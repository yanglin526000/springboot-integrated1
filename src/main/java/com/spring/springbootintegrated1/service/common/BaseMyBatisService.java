package com.spring.springbootintegrated1.service.common;

/**
 * <p>
 * 描述: 公共业务层接口
 * </p>
 * <p>
 * 创建时间: 2019-11-15 09:23
 * </p>
 * 
 * @param <T> 标签
 * @author yanglin
 */
public interface BaseMyBatisService<T> {

    /**
     * <p>
     * 描述: 新增和更新
     * </p>
     * <p>
     * 创建时间: 2019-11-15 09:32
     * </p>
     * 
     * @param t 参数实体
     * @return T
     * 
     * @author yanglin
     */
    T save(T t);

//    /**
//     * <p>
//     * 描述: 删除（假删除）
//     * </p>
//     * <p>
//     * 创建时间: 2019-11-15 09:32
//     * </p>
//     * 
//     * @param t 参数实体
//     * @return T
//     * 
//     * @author yanglin
//     */
//    T delete(T t);
//
//    /**
//     * <p>
//     * 描述: 根据id获取实体信息
//     * </p>
//     * <p>
//     * 创建时间: 2019-11-15 09:33
//     * </p>
//     * 
//     * @param t 实体
//     * @return T
//     * 
//     * @author yanglin
//     */
//    T info(T t);
//
//    /**
//     * <p>
//     * 描述: 根据对象条件查询分页列表
//     * </p>
//     * <p>
//     * 创建时间: 2019-11-15 09:34
//     * </p>
//     * 
//     * @param t        实体
//     * @param pageable 分页信息
//     * @return T
//     * 
//     * @author yanglin
//     */
//    Map<String, Object> list(T t, Pageable pageable);
//
//    /**
//     * <p>
//     * 描述: 根据对象条件精确查询分页列表
//     * </p>
//     * <p>
//     * 创建时间: 2019-11-15 09:34
//     * </p>
//     * 
//     * @param t        实体
//     * @param pageable 分页信息
//     * @return T
//     * 
//     * @author yanglin
//     */
//    Map<String, Object> listAccurate(T t, Pageable pageable);
//
//    /**
//     * <p>
//     * 描述: 根据对象条件精确查询分页列表（重载，没有分页）
//     * </p>
//     * <p>
//     * 创建时间: 2019-11-15 09:34
//     * </p>
//     * 
//     * @param t 实体
//     * @return T
//     * 
//     * @author yanglin
//     */
//    Map<String, Object> listAccurate(T t);
}
