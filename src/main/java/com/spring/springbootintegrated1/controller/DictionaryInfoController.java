package com.spring.springbootintegrated1.controller;

import com.spring.springbootintegrated1.controller.common.BaseHIbernateController;
import com.spring.springbootintegrated1.pojo.DictionaryInfo;
import com.spring.springbootintegrated1.service.common.BaseHibernateService;
import com.spring.springbootintegrated1.utils.ConstantUtil;
import com.spring.springbootintegrated1.utils.ResultMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 描述: 字典信息
 * </p>
 * <p>
 * 创建时间: 2019-11-15 09:48
 * </p>
 * 
 * @author yanglin
 */
@Api(tags = "dictionary-info[字典信息API]")
@RestController
@RequestMapping("dictionary-info")
public class DictionaryInfoController extends BaseHIbernateController<DictionaryInfo> {

    @Autowired
    private BaseHibernateService<DictionaryInfo> baseHibernateService;

    /**
     * <p>
     * 描述: 根据字典类型代码获取字典信息
     * </p>
     * <p>
     * 创建时间: 2019-11-15 09:49
     * </p>
     * 
     * @param code 字典类型代码
     * @return Map<String, Object>
     * 
     * @author yanglin
     */
    @ApiOperation(value = "根据字典类型代码获取字典信息", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "字典类型代码", required = true, dataType = "String", paramType = "query") })
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map<String, Object> list(@RequestParam(value = "code", required = true) String code) {
        Map<String, Object> result = new HashMap<>(ConstantUtil.RESULT_MAP_INIT_COUNT);
        DictionaryInfo dictionaryInfo = new DictionaryInfo();
        dictionaryInfo.setCode(code);
        result.put("data", baseHibernateService.listAccurate(dictionaryInfo).get("list"));
        return ResultMap.state(result, HttpStatus.OK);
    }
}
