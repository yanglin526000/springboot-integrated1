package com.spring.springbootintegrated1.pojo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 描述: 公共继承类
 * </p>
 * <p>
 * 创建时间: 2019-11-15 09:38
 * </p>
 *
 * @author yanglin
 */
@ApiModel
@Data
@MappedSuperclass
public class CommonPo implements Serializable {

    /**
     * @description 序列化号
     * @field serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * @description 自增主键
     * @field id
     */
    @ApiModelProperty(value = "自增主键", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INT UNSIGNED COMMENT '自增主键'")
    private Long id;

    /**
     * @description 创建者id
     * @field createUserId
     */
    @ApiModelProperty(value = "创建者id", hidden = true)
    @Column(name = "create_user_id", columnDefinition = "INT UNSIGNED COMMENT '创建者id'")
    private Long createUserId;

    /**
     * @description 更新者id
     * @field updateUserId
     */
    @ApiModelProperty(value = "更新者id", hidden = true)
    @Column(name = "update_user_id", columnDefinition = "INT UNSIGNED COMMENT '更新者id'")
    private Long updateUserId;

    /**
     * @description 创建时间
     * @field createTime
     */
    @ApiModelProperty(value = "创建时间", hidden = true)
    @Column(name = "create_time", columnDefinition = "DATETIME COMMENT '创建时间'")
    private Date createTime;

    /**
     * @description 更新时间
     * @field updateTime
     */
    @ApiModelProperty(value = "更新时间", hidden = true)
    @Column(name = "update_time", columnDefinition = "DATETIME COMMENT '更新时间'")
    private Date updateTime;

    /**
     * @description 备注
     * @field remark
     */
    @ApiModelProperty(value = "备注", example = "备注信息")
    @Column(name = "remark", columnDefinition = "VARCHAR(255) COMMENT '备注'")
    private String remark;

    /**
     * @description 是否删除
     * @field isDelete
     */
    @ApiModelProperty(value = "是否删除", hidden = true)
    @Column(name = "is_delete", columnDefinition = "TINYINT(2) DEFAULT 0 COMMENT '是否删除'", nullable = false)
    private Byte isDelete;

}
