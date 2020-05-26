package com.spring.springbootintegrated1.controller.common;

import com.spring.springbootintegrated1.service.common.BaseMyBatisService;
import com.spring.springbootintegrated1.utils.ConstantUtil;
import com.spring.springbootintegrated1.utils.ResultMap;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 描述: 公共Controller实现类-MyBatis
 * </p>
 * <p>
 * 创建时间: 2019-11-15 09:45
 * </p>
 * 
 * @param <T>
 * @author yanglin
 */
public abstract class BaseMyBatisController<T> {

    @Autowired
    private BaseMyBatisService<T> baseMyBatisService;

    /**
     * <p>
     * 描述: 保存接口
     * </p>
     * <p>
     * 创建时间: 2019-11-14 17:36
     * </p>
     * 
     * @param t 对象数据
     * @return Map
     * @throws SecurityException        安全异常
     * @throws NoSuchFieldException     无属性异常
     * @throws IllegalAccessException   非法访问异常
     * @throws IllegalArgumentException 非法论证异常
     * 
     * @author yanglin
     */
    @ApiOperation(value = "保存接口，body参数中有id，是更新；否则是新增（自动生成）")
    @RequestMapping(value = "/", method = { RequestMethod.POST, RequestMethod.PUT })
    public Map<String, Object> save(@RequestBody T t)
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Map<String, Object> result = new HashMap<>(ConstantUtil.RESULT_MAP_INIT_COUNT);
        result.put("data", baseMyBatisService.save(t));
        return ResultMap.state(result, HttpStatus.OK);
    }

//    /**
//     * <p>
//     * 描述: 根据id删除
//     * </p>
//     * <p>
//     * 创建时间: 2019-11-15 09:45
//     * </p>
//     * 
//     * @param id 自增主键
//     * @return Map<String, Object>
//     * @throws IllegalAccessException 非法进入异常
//     * @throws InstantiationException 实例化异常
//     * 
//     * @author yanglin
//     */
//    @SuppressWarnings({ "unchecked", "rawtypes" })
//    @ApiOperation(value = "根据id删除（自动生成）", httpMethod = "DELETE")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "自增主键", required = true, dataType = "String", paramType = "path") })
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public Map<String, Object> delete(@PathVariable Long id) throws InstantiationException, IllegalAccessException {
//        T t = (T) ((Class) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0])
//                .newInstance();
//        ParamUtil.putField(t, "id", id);
//        Map<String, Object> result = new HashMap<>(ConstantUtil.RESULT_MAP_INIT_COUNT);
//        result.put("data", baseMyBatisService.delete(t));
//        return ResultMap.state(result, HttpStatus.OK);
//    }
//
//    /**
//     * <p>
//     * 描述: 根据id对象信息
//     * </p>
//     * <p>
//     * 创建时间: 2019-11-15 09:46
//     * </p>
//     * 
//     * @param id 自增主键
//     * @return Map<String, Object>
//     * @throws IllegalAccessException 非法进入异常
//     * @throws InstantiationException 实例化异常
//     * 
//     * @author yanglin
//     */
//    @SuppressWarnings({ "unchecked", "rawtypes" })
//    @ApiOperation(value = "根据id对象信息（自动生成）", httpMethod = "GET")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "自增主键", required = true, dataType = "String", paramType = "path") })
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public Map<String, Object> info(@PathVariable Long id) throws InstantiationException, IllegalAccessException {
//        T t = (T) ((Class) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0])
//                .newInstance();
//        ParamUtil.putField(t, "id", id);
//        Map<String, Object> result = new HashMap<>(ConstantUtil.RESULT_MAP_INIT_COUNT);
//        result.put("data", baseMyBatisService.info(t));
//        return ResultMap.state(result, HttpStatus.OK);
//    }
//
//    /**
//     * <p>
//     * 描述: 根据对象条件查询分页列表
//     * </p>
//     * <p>
//     * 创建时间: 2019-11-15 09:46
//     * </p>
//     * 
//     * @param t    对象数据
//     * @param page 页数
//     * @param size 每页显示数量
//     * @return Map<String, Object>
//     * 
//     * @author yanglin
//     */
//    @ApiOperation(value = "根据对象条件查询分页列表（自动生成）", httpMethod = "GET")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "page", value = "页数，默认第一页为"
//                    + ConstantUtil.DEFAULT_PAGE_INDEX, required = false, dataType = "String", paramType = "query"),
//            @ApiImplicitParam(name = "size", value = "每页显示数量，默认每页数量为"
//                    + ConstantUtil.DEFAULT_PAGE_SIZE, required = false, dataType = "String", paramType = "query") })
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public Map<String, Object> list(T t,
//            @RequestParam(value = "page", required = false, defaultValue = ConstantUtil.DEFAULT_PAGE_INDEX) Integer page,
//            @RequestParam(value = "size", required = false, defaultValue = ConstantUtil.DEFAULT_PAGE_SIZE) Integer size) {
//        Map<String, Object> result = new HashMap<>(ConstantUtil.RESULT_MAP_INIT_COUNT);
//        result.put("data", baseMyBatisService.list(t, PageRequest.of(page, size)));
//        return ResultMap.state(result, HttpStatus.OK);
//    }

}
