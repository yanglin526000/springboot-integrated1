package com.spring.springbootintegrated1.exception;

import com.spring.springbootintegrated1.utils.ResultMap;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @description 处理异常全局配置：拦截异常并统一处理
 * @classname GlobalThrowableHandler
 *
 * @author yanglin
 * @time 2019-03-19 17:47:24.110 +0800
 * @version v1.0
 */
@RestControllerAdvice
public class GlobalThrowableHandler {

//    /**
//     * @description 异常具体处理过程
//     * @param t       异常对象
//     * @param request 请求域对象
//     * @return java.util.Map<String, Object>
//     * 
//     * @author yanglin
//     * @time 2019-03-19 17:50:51.879 +0800
//     */
//    @ExceptionHandler(value = Throwable.class)
//    private Map<String, Object> handleThrowable(Throwable t, HttpServletRequest request) {
//        Map<String, Object> result = new HashMap<>(ConstantUtil.RESULT_MAP_INIT_COUNT);
//        t.printStackTrace();
//        result.put("errorMessage", t.getMessage());
//        result.put("errorURL", request.getRequestURL());
//        ResultMap.state(result, HttpStatus.INTERNAL_SERVER_ERROR);
//        return result;
//    }

    /**
     * <p>
     * 描述: 约束校验异常-字段为空以及字段值重复异常
     * </p>
     * <p>
     * 创建时间: 2019-11-21 16:35
     * </p>
     * <p>
     * 更新时间: 2019-11-21 16:35
     * </p>
     * <p>
     * 更新者: yanglin
     * </p>
     * 
     * @param e       异常对象
     * @param request 请求域
     * @return Map
     * 
     * @author yanglin
     */
    @ResponseBody
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.LOCKED)
    private Map<String, Object> constraintViolationException(ConstraintViolationException e,
            HttpServletRequest request) {
        e.printStackTrace();
        String message = "";
        String[] ms = e.getSQLException().getMessage().split("'");
        if (ms[0].indexOf("Column") != -1) {
            // 字段为空的异常
            message = "字段'" + ms[1] + "'的值不能为空";
        } else if (ms[0].indexOf("Duplicate entry") != -1) {
            // 字段值重复的异常
            message = "字段值'" + ms[1] + "'重复";
        }
        return ResultMap.state(null, HttpStatus.LOCKED, message);
    }
}
