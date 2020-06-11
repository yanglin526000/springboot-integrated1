package com.spring.springbootintegrated1.repository;

import com.spring.springbootintegrated1.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
