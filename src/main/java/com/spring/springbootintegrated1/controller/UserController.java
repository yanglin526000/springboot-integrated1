package com.spring.springbootintegrated1.controller;

import com.spring.springbootintegrated1.controller.common.BaseHibernateController;
import com.spring.springbootintegrated1.pojo.User;
import com.spring.springbootintegrated1.repository.UserRepository;
import com.spring.springbootintegrated1.utils.ConstantUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * User Controller
 * </p>
 *
 * @author yanglin
 * @date 2020-06-11 20:55:53
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseHibernateController<User> {

    // 为了减少篇幅就不写service接口了
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bcryptPasswordEncoder;

    /**
     * <p>
     * Register User Info
     * </p>
     *
     * @param user User
     * @return org.springframework.http.ResponseEntity
     * @author yanglin
     * @date 2020-06-11 21:07:58
     */
    @ApiOperation(value = "Register User Info", httpMethod = "POST")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<Object> register(@RequestBody User user) {
        // 记得注册的时候把密码加密一下
        user.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));
        user.setRoleCode("ROLE_USER");
        User userR = userRepository.save(user);
        Map<String, Object> result = new HashMap<>(ConstantUtil.RESULT_MAP_INIT_COUNT);
        result.put("userR", userR);
        return ResponseEntity.ok(userR);
    }
}
