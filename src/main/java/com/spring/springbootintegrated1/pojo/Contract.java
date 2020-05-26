package com.spring.springbootintegrated1.pojo;

import com.spring.springbootintegrated1.pojo.common.CommonPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * <p>
 * 描述: 通讯录
 * </p>
 * <p>
 * 创建时间: 2019-12-04 17:50
 * </p>
 * 
 * @author yanglin
 */
@ApiModel(value = "通讯录表")
@Entity
@Table(name = "contract")
@org.hibernate.annotations.Table(appliesTo = "contract", comment = "通讯录表")
public class Contract extends CommonPo {

    /**
     * @description 序列化号
     * @field serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * @description 名字
     * @field name
     */
    @ApiModelProperty(value = "名字")
    @Column(name = "name", columnDefinition = "VARCHAR(255) COMMENT '名字'")
    private String name;

    /**
     * @description 电话号码
     * @field telNum
     */
    @ApiModelProperty(value = "电话号码")
    @Column(name = "tel_num", columnDefinition = "VARCHAR(255) COMMENT '电话号码'")
    private String telNum;

    /**
     * @description 地址
     * @field address
     */
    @ApiModelProperty(value = "地址", example = "XYZ")
    @Column(name = "address", columnDefinition = "VARCHAR(255) COMMENT '地址'")
    private String address;

    /**
     * @description 邮箱
     * @field email
     */
    @ApiModelProperty(value = "邮箱")
    @Column(name = "email", columnDefinition = "VARCHAR(255) COMMENT '输入码一'")
    private String email;

    /**
     * @description 出生日期
     * @field birthday
     */
    @ApiModelProperty(value = "出生日期")
    @Column(name = "birthday", columnDefinition = "VARCHAR(100) COMMENT '出生日期'")
    private String birthday;

    /**
     * @description 是否收藏
     * @field collection
     */
    @ApiModelProperty(value = "是否收藏")
    @Column(name = "collection", columnDefinition = "INT COMMENT '是否收藏'")
    private Integer collection;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getCollection() {
        return collection;
    }

    public void setCollection(Integer collection) {
        this.collection = collection;
    }

}
