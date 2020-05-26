package com.spring.springbootintegrated1.utils;

import java.lang.reflect.Field;
import java.util.*;

/**
 * <p>
 * 描述: 参数处理工具类
 * </p>
 * <p>
 * 创建时间: 2019-11-15 09:20
 * </p>
 *
 * @author yanglin
 */
public class ParamUtil {

    /**
     * <p>
     * 描述:
     * </p>
     * <p>
     * 创建时间: 2019-11-15 09:20
     * </p>
     *
     * @param o          任意对象
     * @param fieldName  属性名
     * @param fieldValue 属性值
     * @author yanglin
     */
    public static void putField(Object o, String fieldName, Object fieldValue) {
        // 属性值为空，不设置值
        if (fieldValue == null) {
            return;
        }
        try {
            Field f = null;
            try {
                f = o.getClass().getDeclaredField(fieldName);
            } catch (Exception e) {
                f = o.getClass().getSuperclass().getDeclaredField(fieldName);
            }
            f.setAccessible(true);
            // 属性值为空字符串时候，将对应字段值为空，否则正常设置属性值
            if ("".equals(fieldValue.toString().trim())) {
                f.set(o, null);
            } else {
                Object fv = null;
                // 传过来的值是对应实例
                if (f.getType().isInstance(fieldValue)) {
                    fv = fieldValue;
                } else if (Date.class.getName().equals(f.getType().getName())) {
                    // 日期类型和其他常用类型的处理
                    fv = f.getType().getDeclaredConstructor(long.class)
                            .newInstance(Long.parseLong(fieldValue.toString().trim()));
                } else {
                    fv = f.getType().getDeclaredConstructor(String.class).newInstance(fieldValue.toString().trim());
                }
                if (ArrayList.class.equals(fieldValue.getClass())) {
                    o.getClass()
                            .getDeclaredMethod(
                                    "set" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1),
                                    f.getType())
                            .invoke(o, fv);
                } else {
                    f.set(o, fv);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * <p>
     * 描述: 生成随机属性对象
     * </p>
     * <p>
     * 创建时间: 2019-11-21 13:44
     * </p>
     * <p>
     * 更新时间: 2019-11-21 13:44
     * </p>
     * <p>
     * 更新者: yanglin
     * </p>
     *
     * @param o 对象值
     * @author yanglin
     */
    public static void randomObject(Object o) {
        // 值为空，不做任何操作
        if (o == null) {
            return;
        }
        String r = String.valueOf(System.currentTimeMillis());
        for (Field f : o.getClass().getDeclaredFields()) {
            if (!"serialVersionUID".equals(f.getName())) {
                for (int i = 0, len = r.length(); i < len - 1; i++) {
                    try {
                        f.setAccessible(true);
                        Object fv = null;
                        try {
                            fv = f.getType().getDeclaredConstructor(String.class).newInstance(r.substring(len - i - 1));
                        } catch (Exception e) {
                            fv = f.getType().getDeclaredConstructor(long.class)
                                    .newInstance(Long.parseLong(r.substring(len - i - 1)));
                        }
                        f.set(o, fv);
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


}
