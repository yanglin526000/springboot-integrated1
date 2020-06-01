package com.spring.springbootintegrated1.controller.common;

import com.spring.springbootintegrated1.service.common.BaseHibernateService;
import com.spring.springbootintegrated1.utils.ConstantUtil;
import com.spring.springbootintegrated1.utils.ParamUtil;
import com.spring.springbootintegrated1.utils.ResultMap;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 描述: 公共Controller实现类-Hibernate
 * </p>
 * <p>
 * 创建时间: 2019-11-15 09:45
 * </p>
 *
 * @param <T>
 * @author yanglin
 */
public abstract class BaseHIbernateController<T> {

    @Autowired
    private BaseHibernateService<T> baseHibernateService;

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
     * @author yanglin
     */
    @ApiOperation(value = "保存接口，body参数中有id，是更新；否则是新增（自动生成）")
    @RequestMapping(value = "", method = {RequestMethod.POST, RequestMethod.PUT})
    public Map<String, Object> save(@RequestBody T t)
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Map<String, Object> result = new HashMap<>(ConstantUtil.RESULT_MAP_INIT_COUNT);
//        // 新增和保存的用户记录
//        Field fId = t.getClass().getSuperclass().getDeclaredField("id");
//        fId.setAccessible(true);
//        Object idO = fId.get(t);
//        // 更新数据用户信息
//        Long userId = ((User) SecurityUtils.getSubject().getPrincipal()).getId();
//        if (idO == null) {
//            ParamUtil.putField(t, "createUserId", userId);
//            ParamUtil.putField(t, "updateUserId", userId);
//        } else {
//            ParamUtil.putField(t, "updateUserId", userId);
//        }
        result.put("data", baseHibernateService.save(t));
        return ResultMap.state(result, HttpStatus.OK);
    }

    /**
     * <p>
     * 描述: 根据id删除
     * </p>
     * <p>
     * 创建时间: 2019-11-15 09:45
     * </p>
     *
     * @param id 自增主键
     * @return Map<String, Object>
     * @throws IllegalAccessException 非法进入异常
     * @throws InstantiationException 实例化异常
     * @author yanglin
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    @ApiOperation(value = "根据id删除（自动生成）", httpMethod = "DELETE")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "自增主键", required = true, dataType = "String", paramType = "path")})
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public Map<String, Object> delete(@PathVariable Long id) throws Exception {
        T t = (T) ((Class) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0])
                .getDeclaredConstructor().newInstance();
//        // 更新数据用户信息
//        Long userId = ((User) SecurityUtils.getSubject().getPrincipal()).getId();
//        ParamUtil.putField(t, "updateUserId", userId);
        ParamUtil.putField(t, "id", id);
        Map<String, Object> result = new HashMap<>(ConstantUtil.RESULT_MAP_INIT_COUNT);
        result.put("data", baseHibernateService.delete(t));
        return ResultMap.state(result, HttpStatus.OK);
    }

    /**
     * <p>
     * 描述: 根据id对象信息
     * </p>
     * <p>
     * 创建时间: 2019-11-15 09:46
     * </p>
     *
     * @param id 自增主键
     * @return Map<String, Object>
     * @throws IllegalAccessException 非法进入异常
     * @throws InstantiationException 实例化异常
     * @author yanglin
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    @ApiOperation(value = "根据id对象信息（自动生成）", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "自增主键", required = true, dataType = "String", paramType = "path")})
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Map<String, Object> info(@PathVariable Long id) throws Exception {
        T t = (T) ((Class) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0])
                .getDeclaredConstructor().newInstance();
        ParamUtil.putField(t, "id", id);
        Map<String, Object> result = new HashMap<>(ConstantUtil.RESULT_MAP_INIT_COUNT);
        result.put("data", baseHibernateService.info(t));
        return ResultMap.state(result, HttpStatus.OK);
    }

    /**
     * <p>
     * 描述: 根据对象条件查询分页列表
     * </p>
     * <p>
     * 创建时间: 2019-11-15 09:46
     * </p>
     *
     * @param t    对象数据
     * @param page 页数
     * @param size 每页显示数量
     * @return Map<String, Object>
     * @author yanglin
     */
    @ApiOperation(value = "根据对象条件查询分页列表（自动生成）", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页数，默认第一页为"
                    + ConstantUtil.DEFAULT_PAGE_INDEX, required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页显示数量，默认每页数量为"
                    + ConstantUtil.DEFAULT_PAGE_SIZE, required = false, dataType = "String", paramType = "query")})
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Map<String, Object> list(T t,
                                    @RequestParam(value = "page", required = false, defaultValue = ConstantUtil.DEFAULT_PAGE_INDEX) Integer page,
                                    @RequestParam(value = "size", required = false, defaultValue = ConstantUtil.DEFAULT_PAGE_SIZE) Integer size) {
        Map<String, Object> result = new HashMap<>(ConstantUtil.RESULT_MAP_INIT_COUNT);
        Map<String, Object> r = baseHibernateService.list(t, PageRequest.of(page, size));
        result.put("data", (List<?>) r.get("list"));
        result.put("pageInfo", r.get("pageInfo"));
        return ResultMap.state(result, HttpStatus.OK);
    }

}
