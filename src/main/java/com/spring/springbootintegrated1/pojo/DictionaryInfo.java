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
 * 描述: 字典信息
 * </p>
 * <p>
 * 创建时间: 2019-11-15 09:42
 * </p>
 *
 * @author yanglin
 */
@ApiModel(value = "字典信息")
@Data
@Entity
@Table(name = "dictionary_info")
@org.hibernate.annotations.Table(appliesTo = "dictionary_info", comment = "字典信息表")
public class DictionaryInfo extends CommonPo {

    /**
     * @description 序列化号
     * @field serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * @description 字典名字
     * @field name
     */
    @ApiModelProperty(value = "字典名字", example = "三甲医院")
    @Column(name = "name", columnDefinition = "VARCHAR(50) COMMENT '字典名字'", nullable = false)
    private String name;

    /**
     * @description 类别代码
     * @field code
     */
    @ApiModelProperty(value = "类别代码", example = "institutionType")
    @Column(name = "code", columnDefinition = "VARCHAR(50) COMMENT '类别代码'", nullable = false)
    private String code;

    /**
     * @description 外部代码
     * @field outCode
     */
    @ApiModelProperty(value = "外部代码", example = "XYZ")
    @Column(name = "out_code", columnDefinition = "VARCHAR(50) COMMENT '外部代码'")
    private String outCode;

    /**
     * @description 输入码一
     * @field firstCode
     */
    @ApiModelProperty(value = "输入码一", example = "ABC")
    @Column(name = "first_code", columnDefinition = "VARCHAR(50) COMMENT '输入码一'")
    private String firstCode;

    /**
     * @description 输入码二
     * @field secondCode
     */
    @ApiModelProperty(value = "输入码二", example = "EFG")
    @Column(name = "second_code", columnDefinition = "VARCHAR(50) COMMENT '输入码二'")
    private String secondCode;

    // 外键关联字典示例
//    /**
//     * @description 关联字典信息表-诊断流程状态：待初诊/待核发/待审核/待终审（多对一）
//     * @field diagnoseStatusDictionaryInfo
//     */
//    @ApiModelProperty(hidden = true)
//    @NotFound(action = NotFoundAction.IGNORE)
//    @ManyToOne
//    @JoinColumn(name = "dispatch_type", insertable = false, updatable = false)
//    private DictionaryInfo diagnoseStatusDictionaryInfo;

}
