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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * The common controller implementation class - Hibernate
 * </p>
 *
 * @author yanglin
 * @date 2020-06-12 18:44:20
 */
public abstract class BaseHibernateController<T> {

    @Autowired
    private BaseHibernateService<T> baseHibernateService;

    /**
     * <p>
     * Save
     * </p>
     *
     * @param t T
     * @return org.springframework.http.ResponseEntity ResponseEntity
     * @author yanglin
     * @date 2020-06-12 18:47:10
     */
    @ApiOperation(value = "保存接口，body参数中有id，是更新；否则是新增（自动生成）")
    @RequestMapping(value = "", method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<T> save(@RequestBody T t) throws SecurityException, IllegalArgumentException {
        return ResponseEntity.ok(baseHibernateService.save(t));
    }

    /**
     * <p>
     * Delete By Id
     * </p>
     *
     * @param id Primary Key
     * @return org.springframework.http.ResponseEntity ResponseEntity
     * @author yanglin
     * @date 2020-06-12 19:03:32
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    @ApiOperation(value = "根据id删除（自动生成）", httpMethod = "DELETE")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "自增主键", required = true, dataType = "String", paramType = "path")})
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<T> delete(@PathVariable Long id) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        T t = (T) ((Class) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getDeclaredConstructor().newInstance();
        ParamUtil.putField(t, "id", id);
        return ResponseEntity.ok(baseHibernateService.delete(t));
    }

    /**
     * <p>
     * Get Info By Id
     * </p>
     *
     * @param id Primary Key
     * @return org.springframework.http.ResponseEntity ResponseEntity
     * @author yanglin
     * @date 2020-06-12 19:25:16
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    @ApiOperation(value = "根据id对象信息（自动生成）", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "自增主键", required = true, dataType = "String", paramType = "path")})
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<T> info(@PathVariable Long id) throws Exception {
        T t = (T) ((Class) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getDeclaredConstructor().newInstance();
        ParamUtil.putField(t, "id", id);
        return ResponseEntity.ok(baseHibernateService.info(t));
    }

    /**
     * <p>
     * Get List By Conditions
     * </p>
     *
     * @param t    T
     * @param page Integer
     * @param size Integer
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @author yanglin
     * @date 2020-06-12 19:30:16
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
