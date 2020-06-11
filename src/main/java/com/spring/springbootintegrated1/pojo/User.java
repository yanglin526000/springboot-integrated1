package com.spring.springbootintegrated1.pojo;

import com.spring.springbootintegrated1.pojo.common.CommonPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * <p>
 * 描述: 用户信息
 * </p>
 * <p>
 * 创建时间: 2020-6-3 20:16:47
 * </p>
 *
 * @author yanglin
 */
@ApiModel(value = "用户信息")
@Data
@Entity
@Table(name = "user")
@org.hibernate.annotations.Table(appliesTo = "user", comment = "用户信息表")
public class User extends CommonPo {

    /**
     * @description 序列化号
     * @field serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * @description 用户名字
     * @field name
     */
    @ApiModelProperty(value = "用户", example = "杨林")
    @Column(name = "username", columnDefinition = "VARCHAR(50) COMMENT '用户名字'", nullable = false)
    private String username;

    /**
     * @description 密码
     * @field password
     */
    @ApiModelProperty(value = "密码", example = "111111")
    @Column(name = "password", columnDefinition = "VARCHAR(255) COMMENT '密码'", nullable = false)
    private String password;

    /**
     * @description 角色代码
     * @field roleCode
     */
    @ApiModelProperty(value = "角色ID", example = "admin")
    @Column(name = "role_code", columnDefinition = "VARCHAR(50) COMMENT '角色代码'")
    private String roleCode;


}
