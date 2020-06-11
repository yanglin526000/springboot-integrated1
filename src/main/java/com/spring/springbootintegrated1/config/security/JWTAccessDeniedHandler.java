package com.spring.springbootintegrated1.config.security;

import com.spring.springbootintegrated1.utils.ResultMap;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * Unified handling: when no permissions
 * </p>
 *
 * @author yanglin
 * @date 2020-06-11 09:29:46
 */
public class JWTAccessDeniedHandler implements AccessDeniedHandler {

    /**
     * <p>
     * A concrete implementation of the Handle method
     * </p>
     *
     * @param httpServletRequest  HttpServletRequest
     * @param httpServletResponse HttpServletResponse
     * @param e                   AccessDeniedException
     * @author yanglin
     * @date 2020-06-11 09:30:54
     */
    @Override
    public void handle(HttpServletRequest httpServletRequest,
                       HttpServletResponse httpServletResponse,
                       AccessDeniedException e) throws IOException {
        ResultMap.customJWTResponse(
                httpServletResponse,
                e.getMessage(),
                HttpServletResponse.SC_UNAUTHORIZED
        );
    }

}
