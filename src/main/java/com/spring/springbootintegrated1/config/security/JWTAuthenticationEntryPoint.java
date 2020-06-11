package com.spring.springbootintegrated1.config.security;

import com.spring.springbootintegrated1.utils.ResultMap;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * No token carried or invalid token
 * </p>
 *
 * @author yanglin
 * @date 2020-06-11 19:40:03
 */
public class JWTAuthenticationEntryPoint implements AuthenticationEntryPoint {

    /**
     * <p>
     * commence
     * </p>
     *
     * @param request       HttpServletRequest
     * @param response      HttpServletResponse
     * @param authException AuthenticationException
     * @author yanglin
     * @date 2020-06-11 19:42:15
     */
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        ResultMap.customJWTUnauthorizedResponse(
                response,
                authException.getMessage()
        );
    }


}
