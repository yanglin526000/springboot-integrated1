package com.spring.springbootintegrated1.repository.common;

import org.springframework.data.domain.Pageable;

import java.util.Map;

/**
 * <p>
 * 描述: 公共持久层接口
 * </p>
 * <p>
 * 创建时间: 2019-11-15 09:35
 * </p>
 * 
 * @param <T> 标签
 * @author yanglin
 */
public interface BaseRepository<T> {

    /**
     * <p>
     * 描述: 新增和更新
     * </p>
     * <p>
     * 创建时间: 2019-11-15 09:35
     * </p>
     * 
     * @param t 参数实体
     * @return T
     * 
     * @author yanglin
     */
    T save(T t);

    /**
     * <p>
     * 描述: 删除（假删除）
     * </p>
     * <p>
     * 创建时间: 2019-11-15 09:36
     * </p>
     * 
     * @param t 参数实体
     * @return T
     * 
     * @author yanglin
     */
    T delete(T t);

    /**
     * <p>
     * 描述: 根据id获取实体信息
     * </p>
     * <p>
     * 创建时间: 2019-11-15 09:36
     * </p>
     * 
     * @param t 实体
     * @return T
     * 
     * @author yanglin
     */
    T info(T t);

    /**
     * <p>
     * 描述: 根据对象条件查询分页列表
     * </p>
     * <p>
     * 创建时间: 2019-11-15 09:37
     * </p>
     * 
     * @param t        实体
     * @param pageable 分页信息
     * @return T
     * 
     * @author yanglin
     */
    Map<String, Object> list(T t, Pageable pageable);

    /**
     * <p>
     * 描述: 根据对象条件精确查询分页列表
     * </p>
     * <p>
     * 创建时间: 2019-11-15 09:37
     * </p>
     * 
     * @param t        实体
     * @param pageable 分页信息
     * @return T
     * 
     * @author yanglin
     */
    Map<String, Object> listAccurate(T t, Pageable pageable);

    /**
     * <p>
     * 描述: 根据对象条件精确查询分页列表（重载，可不传分页信息）
     * </p>
     * <p>
     * 创建时间: 2019-11-15 09:37
     * </p>
     * 
     * @param t 实体
     * @return T
     * 
     * @author yanglin
     */
    Map<String, Object> listAccurate(T t);
}
