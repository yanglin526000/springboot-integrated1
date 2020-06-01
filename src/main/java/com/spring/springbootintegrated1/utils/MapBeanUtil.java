package com.spring.springbootintegrated1.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Object和Map相互转换
 * 
 * @Description:MapBeanUtil
 * @author:yanglin
 * @time:2018年8月8日 下午5:07:02
 */
@SuppressWarnings("rawtypes")
public class MapBeanUtil {

    /**
     * <p>
     * 描述: POJO对象转Map
     * </p>
     * <p>
     * 创建时间: 2019-11-20 10:10
     * </p>
     * <p>
     * 更新时间: 2019-11-20 10:10
     * </p>
     * <p>
     * 更新者: yanglin
     * </p>
     * 
     * @param object 转换对象
     * @return Map<String, Object>
     * @throws IllegalAccessException   非法访问异常
     * @throws IllegalArgumentException 非法参数异常
     * 
     * @author yanglin
     */
    public static Map<String, Object> beanToMap(Object object) throws IllegalArgumentException, IllegalAccessException {
        Map<String, Object> map = new HashMap<String, Object>();
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(object));
        }
        return map;
    }

    /**
     * <p>
     * 描述: Map转换为POJO对象
     * </p>
     * <p>
     * 创建时间: 2019-11-20 10:07
     * </p>
     * <p>
     * 更新时间: 2019-11-20 10:07
     * </p>
     * <p>
     * 更新者: yanglin
     * </p>
     * 
     * @param map   map参数
     * @param clazz 类对象
     * @return 通用对象
     * @throws InstantiationException 实例化异常
     * @throws IllegalAccessException 非法访问异常
     * @throws NoSuchFieldException   无属性异常
     * @throws SecurityException      安全异常
     * 
     * @author yanglin
     */
    public static Object mapToBean(Map<String, Object> map, Class clazz)
            throws Exception {
        Object object = clazz.getDeclaredConstructor().newInstance();
        for (String key : map.keySet()) {
            Field temFiels = clazz.getDeclaredField(key);
            temFiels.setAccessible(true);
            temFiels.set(object, map.get(key));
        }
        return object;
    }

//    public static void main(String[] args) throws Exception {
//        SysUser sUser = new SysUser();
//        sUser.setSysUserId(SnowflakeIdWorker.nextIdString());
//        sUser.setSysUserName("yang");
//        sUser.setSysUserAge(23);
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("sysUserId", "666");
//        map.put("sysUserName", "yanglin666");
//        map.put("sysUserAge", 666);
//        // map to object
//        SysUser sUserC = (SysUser) mapToBean(map, SysUser.class);
//        // object to map
//        Map<String, Object> mapC = beanToMap(sUser);
//    }

}
