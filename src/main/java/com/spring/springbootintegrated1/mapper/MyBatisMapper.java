package com.spring.springbootintegrated1.mapper;

import org.springframework.data.repository.NoRepositoryBean;
import tk.mybatis.mapper.common.*;

/**
 * <p>
 * 描述: 自定义通用Mapper
 * </p>
 * <p>
 * 创建时间: 2019-11-21 16:53
 * </p>
 * 
 * @param <T> 通用对象
 * 
 * @author yanglin
 */
@NoRepositoryBean
public interface MyBatisMapper<T>
extends BaseMapper<T>, MySqlMapper<T>, IdsMapper<T>, ConditionMapper<T>, ExampleMapper<T> {

//    /**
//     * <p>
//     * 描述: 自定义查询
//     * </p>
//     * <p>
//     * 创建时间: 2019-11-21 16:52
//     * </p>
//     * <p>
//     * 更新时间: 2019-11-21 16:52
//     * </p>
//     * <p>
//     * 更新者: yanglin
//     * </p>
//     * 
//     * @param t t
//     * @return List<Map<String, Object>>
//     * 
//     * @author yanglin
//     */
//    @Select("select * from sys_user su where su.sys_user_name = #{sys_user_name}")
//    List<Map<String, Object>> selectCustom(T t);
}