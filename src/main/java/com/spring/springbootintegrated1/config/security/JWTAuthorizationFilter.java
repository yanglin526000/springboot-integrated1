package com.spring.springbootintegrated1.config.security;

import com.spring.springbootintegrated1.utils.ResultMap;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

/**
 * <p>
 * JWT Authorization Filter
 * </p>
 *
 * @author yanglin
 * @date 2020-06-11 20:31:37
 */
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    /**
     * <p>
     * Constructor Method
     * </p>
     *
     * @param authenticationManager AuthenticationManager
     * @author yanglin
     * @date 2020-06-11 20:54:21
     */
    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {

        String tokenHeader = request.getHeader(JwtTokenUtils.TOKEN_HEADER);
        // 如果请求头中没有Authorization信息则直接放行了
        if (tokenHeader == null || !tokenHeader.startsWith(JwtTokenUtils.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }
        // 如果请求头中有token，则进行解析，并且设置认证信息
        try {
            SecurityContextHolder.getContext().setAuthentication(getAuthentication(tokenHeader));
        } catch (TokenIsExpiredException e) {
            //返回json形式的错误信息
            ResultMap.customJWTUnauthorizedResponse(response, e.getMessage());
            return;
        }
        super.doFilterInternal(request, response, chain);
    }

    /**
     * 这里从token中获取用户信息并新建一个token
     *
     * @param tokenHeader Header中的Token
     * @return org.springframework.security.authentication.UsernamePasswordAuthenticationToken
     * @throws TokenIsExpiredException TokenIsExpired
     */
    private UsernamePasswordAuthenticationToken getAuthentication(String tokenHeader) throws TokenIsExpiredException {
        String token = tokenHeader.replace(JwtTokenUtils.TOKEN_PREFIX, "");
        try {
            boolean expiration = JwtTokenUtils.isExpiration(token);
            if (expiration) {
                throw new TokenIsExpiredException("token超时了");
            } else {
                String username = JwtTokenUtils.getUsername(token);
                String role = JwtTokenUtils.getUserRole(token);
                if (username != null) {
                    return new UsernamePasswordAuthenticationToken(username, null,
                            Collections.singleton(new SimpleGrantedAuthority(role))
                    );
                }
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }
}
