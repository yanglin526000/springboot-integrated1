package com.spring.springbootintegrated1.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.springbootintegrated1.utils.ResultMap;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * <p>
 * JWT Authentication Filter
 * </p>
 *
 * @author yanglin
 * @date 2020-06-11 19:53:45
 */
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private ThreadLocal<Integer> rememberMe = new ThreadLocal<>();
    private AuthenticationManager authenticationManager;

    /**
     * <p>
     * JWTAuthenticationFilter Constructor
     * </p>
     *
     * @param authenticationManager AuthenticationManager
     * @author yanglin
     * @date 2020-06-11 19:54:10
     */
    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        super.setFilterProcessesUrl("/auth/login");
    }

    /**
     * <p>
     * TODO
     * </p>
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @return org.springframework.security.core.Authentication
     * @author yanglin
     * @date 2020-06-11 20:09:18
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        // Get login information from InputStream
        try {
            LoginUser loginUser = new ObjectMapper().readValue(request.getInputStream(), LoginUser.class);
            rememberMe.set(loginUser.getRememberMe() == null ? 0 : loginUser.getRememberMe());
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginUser.getUsername(),
                            loginUser.getPassword(),
                            new ArrayList<>()
                    )
            );
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * <p>
     * Method called after successful validation
     * If the verification is successful, a token is generated and returned
     * </p>
     *
     * @param request    HttpServletRequest
     * @param response   HttpServletResponse
     * @param chain      FilterChain
     * @param authResult Authentication
     * @author yanglin
     * @date 2020-06-11 20:27:26
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) {
        JwtUser jwtUser = (JwtUser) authResult.getPrincipal();
        System.out.println("jwtUser:" + jwtUser.toString());
        boolean isRemember = rememberMe.get() == 1;
        String role = "";
        Collection<? extends GrantedAuthority> authorities = jwtUser.getAuthorities();
        for (GrantedAuthority authority : authorities) {
            role = authority.getAuthority();
        }

        String token = JwtTokenUtils.createToken(jwtUser.getUsername(), role, isRemember);
        // 返回创建成功的token
        // 但是这里创建的token只是单纯的token
        // 按照jwt的规定，最后请求的时候应该是 `Bearer token`
        response.setHeader("token", JwtTokenUtils.TOKEN_PREFIX + token);
    }

    /**
     * <p>
     * Method called after unsuccessful validation
     * </p>
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @param failed   AuthenticationException
     * @author yanglin
     * @date 2020-06-11 20:30:38
     */
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request,
                                              HttpServletResponse response,
                                              AuthenticationException failed) throws IOException {
        ResultMap.customJWTResponse(
                response,
                failed.getMessage() + "Authentication failed",
                HttpServletResponse.SC_FORBIDDEN
        );
    }
}
