package com.spring.springbootintegrated1.utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 描述: 自定义返回结果结构体
 * </p>
 * <p>
 * 创建时间: 2019-11-15 09:21
 * </p>
 *
 * @author yanglin
 */
public final class ResultMap {

    private ResultMap() {
        super();
    }

    /**
     * <p>
     * 描述: 根据状态值封装Map结果信息
     * </p>
     * <p>
     * 创建时间: 2019-11-15 09:21
     * </p>
     *
     * @param result     需要封装状态码的信息
     * @param httpStatus 指定状态
     * @return Map<String, Object>
     * @author yanglin
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> state(Object result, HttpStatus httpStatus) {
        Map<String, Object> resultHandle = null;
        if (result == null) {
            resultHandle = new HashMap<String, Object>();
            resultHandle.put("data", null);
        } else {
            if (result instanceof Map) {
                resultHandle = (Map<String, Object>) result;
            } else {
                resultHandle = new HashMap<String, Object>();
                resultHandle.put("data", result);
            }
        }

        resultHandle.put("code", httpStatus.value());
        resultHandle.put("message", httpStatus.getReasonPhrase());
        return resultHandle;
    }

    /**
     * <p>
     * 描述: 覆盖返回信息
     * </p>
     * <p>
     * 创建时间: 2019-11-15 09:22
     * </p>
     *
     * @param result     需要封装状态码的信息
     * @param httpStatus 指定状态码
     * @param message    自定义状态码提示信息
     * @return Map
     * @author yanglin
     */
    public static Map<String, Object> state(Object result, HttpStatus httpStatus, String message) {
        Map<String, Object> r = state(result, httpStatus);
        r.put("message", message);
        return r;
    }

    /**
     * <p>
     * 描述: 自定义分页信息
     * </p>
     * <p>
     * 创建时间: 2019-11-15 09:23
     * </p>
     *
     * @param result 设置 result
     * @param total  数据总数
     * @param page   当前页
     * @param size   每页显示条数
     * @return Map<String, Object>
     * @author yanglin
     */
    public static Map<String, Object> pageInfo(Map<String, Object> result, Long total, Integer page, Integer size) {
        Map<String, Object> pageInfo = new HashMap<>();
        pageInfo.put("total", total);
        pageInfo.put("page", page);
        pageInfo.put("size", size);
        result.put("pageInfo", pageInfo);
        return result;
    }

    /**
     * <p>
     * 描述: 自定义响应设置
     * </p>
     * <p>
     * 创建时间: 2020-6-9 10:46:35
     * </p>
     *
     * @param httpServletResponse 设置的Response对象
     * @return javax.servlet.http.HttpServletResponse
     * @author yanglin
     */
    public static HttpServletResponse customResponse(HttpServletResponse httpServletResponse, int status) {
        return customResponse(httpServletResponse, StandardCharsets.UTF_8.name(), MediaType.APPLICATION_JSON_UTF8_VALUE, status);
    }

    /**
     * <p>
     * 描述: 自定义响应设置
     * </p>
     * <p>
     * 创建时间: 2020-6-9 10:46:35
     * </p>
     *
     * @param httpServletResponse 设置的Response对象
     * @param characterEncoding   设置编码
     * @param contentType         设置contentType
     * @param status              设置响应状态码
     * @return javax.servlet.http.HttpServletResponse
     * @author yanglin
     */
    public static HttpServletResponse customResponse(HttpServletResponse httpServletResponse, String characterEncoding, String contentType, int status) {
        httpServletResponse.setCharacterEncoding(characterEncoding);
        httpServletResponse.setContentType(contentType);
        httpServletResponse.setStatus(status);
        return httpServletResponse;
    }

    /**
     * <p>
     * 描述: 自定义响应设置
     * </p>
     * <p>
     * 创建时间: 2020-6-9 10:46:35
     * </p>
     *
     * @param httpServletResponse 设置的Response对象
     * @return javax.servlet.http.HttpServletResponse
     * @author yanglin
     */
    public static HttpServletResponse customJWTUnauthorizedResponse(HttpServletResponse httpServletResponse, String errorMessage) throws IOException {
        return customJWTResponse( httpServletResponse, errorMessage, HttpServletResponse.SC_FORBIDDEN);
    }

    public static HttpServletResponse customJWTResponse(HttpServletResponse httpServletResponse, String errorMessage, int status) throws IOException {
        customResponse(httpServletResponse, StandardCharsets.UTF_8.name(), MediaType.APPLICATION_JSON_UTF8_VALUE, status);
        Map<String, Object> result = new HashMap<>(ConstantUtil.RESULT_MAP_INIT_COUNT);
        result.put("errorMessage", errorMessage);
        httpServletResponse.getWriter().write(JSONObject.toJSONString(result));
        httpServletResponse.getWriter().flush();
        return httpServletResponse;
    }

}
