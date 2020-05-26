package com.spring.springbootintegrated1.pojo;

import com.spring.springbootintegrated1.pojo.common.CommonPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * <p>
 * 描述: 扫描切片信息
 * </p>
 * <p>
 * 创建时间: 2019-11-19 10:12
 * </p>
 * 
 * @author yanglin
 */
@ApiModel(value = "扫描切片信息")
@Entity
@Table(name = "biopsy")
public class Biopsy extends CommonPo {

    /**
     * @description 序列化号
     * @field serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * @description 切片上传状态（未上传/上传中/已上传）
     * @field uploadStatus
     */
    @ApiModelProperty(value = "切片上传状态（未上传/上传中/已上传）")
    @Column(name = "upload_status", columnDefinition = "TINYINT UNSIGNED COMMENT '切片上传状态（未上传/上传中/已上传）'", nullable = false)
    private Integer uploadStatus;

    /**
     * @description 匹配状态（未匹配/手动匹配/自动匹配）
     * @field matchStatus
     */
    @ApiModelProperty(value = "匹配状态（未匹配/手动匹配/自动匹配）")
    @Column(name = "match_status", columnDefinition = "TINYINT UNSIGNED COMMENT '匹配状态（未匹配/手动匹配/自动匹配）'", nullable = false)
    private Integer matchStatus;

    /**
     * @description 上传进度
     * @field progress
     */
    @ApiModelProperty(value = "上传进度")
    @Column(name = "progress", columnDefinition = "DOUBLE COMMENT '上传进度'")
    private Double progress;

    /**
     * @description 扫描批次id
     * @field biopsyHistoryId
     */
    @ApiModelProperty(value = "扫描批次id")
    @Column(name = "biopsy_history_id", columnDefinition = "INT UNSIGNED COMMENT '扫描批次id'", nullable = false)
    private Long biopsyHistoryId;

    /**
     * @description 机构id
     * @field institutionId
     */
    @ApiModelProperty(value = "机构id")
    @Column(name = "institution_id", columnDefinition = "INT UNSIGNED COMMENT '机构id'", nullable = false)
    private Long institutionId;

    /**
     * @description 新切片名
     * @field newFilename
     */
    @ApiModelProperty(value = "新切片名")
    @Column(name = "new_file_name", columnDefinition = "VARCHAR(255) COMMENT '新切片名'")
    private String newFilename;

    /**
     * @description 原文件名
     * @field originFilename
     */
    @ApiModelProperty(value = "原文件名")
    @Column(name = "origin_file_name", columnDefinition = "VARCHAR(255) COMMENT '新切片名'")
    private String originFilename;

    /**
     * @description 切片描述
     * @field description
     */
    @ApiModelProperty(value = "切片描述")
    @Column(name = "description", columnDefinition = "VARCHAR(255) COMMENT '切片描述'")
    private String description;

    /**
     * @description 上传切片人id
     * @field userId
     */
    @ApiModelProperty(value = "上传切片人id")
    @Column(name = "user_id", columnDefinition = "INT UNSIGNED COMMENT '上传切片人id'", nullable = false)
    private Long userId;

    /**
     * @description 上传完成时间
     * @field uploadedTime
     */
    @ApiModelProperty(value = "上传完成时间")
    @Column(name = "uploaded_time", columnDefinition = "DATETIME COMMENT '上传完成时间'")
    private Date uploadedTime;

    /**
     * @description 匹配完成时间
     * @field matchedTime
     */
    @ApiModelProperty(value = "匹配完成时间")
    @Column(name = "matched_time", columnDefinition = "DATETIME COMMENT '匹配完成时间'")
    private Date matchedTime;

    /**
     * @description 文件是否可疑(0,1)
     * @field isDoubtfulFile
     */
    @ApiModelProperty(value = "文件是否可疑(0,1)")
    @Column(name = "is_doubtful_file", columnDefinition = "TINYINT UNSIGNED COMMENT '文件是否可疑(0,1)'", nullable = false)
    private Integer isDoubtfulFile;

    /**
     * @description 扫描倍率
     * @field level
     */
    @ApiModelProperty(value = "扫描倍率")
    @Column(name = "level", columnDefinition = "TINYINT UNSIGNED COMMENT '扫描倍率'", nullable = false)
    private Integer level;

    /**
     * @description 宽
     * @field width
     */
    @ApiModelProperty(value = "宽")
    @Column(name = "width", columnDefinition = "DOUBLE COMMENT '宽'", nullable = false)
    private Double width;

    /**
     * @description 高
     * @field height
     */
    @ApiModelProperty(value = "高")
    @Column(name = "height", columnDefinition = "DOUBLE COMMENT '高'", nullable = false)
    private Double height;

    /**
     * @description 诊断id
     * @field diagnosisId
     */
    @ApiModelProperty(value = "诊断id")
    @Column(name = "diagnosis_id", columnDefinition = "INT UNSIGNED COMMENT '诊断id'")
    private Long diagnosisId;

    /**
     * @description 标签url
     * @field labelUrl
     */
    @ApiModelProperty(value = "标签url")
    @Column(name = "label_url", columnDefinition = "VARCHAR(255) COMMENT '标签url'", nullable = false)
    private String labelUrl;

    /**
     * @description 缩略图url
     * @field previewUrl
     */
    @ApiModelProperty(value = "缩略图url")
    @Column(name = "preview_url", columnDefinition = "VARCHAR(255) COMMENT '缩略图url'", nullable = false)
    private String previewUrl;

    /**
     * @description 是否补传
     * @field isAddedBiopsy
     */
    @ApiModelProperty(value = "是否补传")
    @Column(name = "is_added_biopsy", columnDefinition = "TINYINT UNSIGNED COMMENT '是否补传'", nullable = false)
    private Integer isAddedBiopsy;

    /**
     * @description 切片大小
     * @field fileSize
     */
    @ApiModelProperty(value = "切片大小")
    @Column(name = "file_size", columnDefinition = "INT UNSIGNED COMMENT '切片大小'", nullable = false)
    private Long fileSize;

    public Integer getUploadStatus() {
        return uploadStatus;
    }

    public void setUploadStatus(Integer uploadStatus) {
        this.uploadStatus = uploadStatus;
    }

    public Integer getMatchStatus() {
        return matchStatus;
    }

    public void setMatchStatus(Integer matchStatus) {
        this.matchStatus = matchStatus;
    }

    public Double getProgress() {
        return progress;
    }

    public void setProgress(Double progress) {
        this.progress = progress;
    }

    public Long getBiopsyHistoryId() {
        return biopsyHistoryId;
    }

    public void setBiopsyHistoryId(Long biopsyHistoryId) {
        this.biopsyHistoryId = biopsyHistoryId;
    }

    public Long getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(Long institutionId) {
        this.institutionId = institutionId;
    }

    public String getNewFilename() {
        return newFilename;
    }

    public void setNewFilename(String newFilename) {
        this.newFilename = newFilename;
    }

    public String getOriginFilename() {
        return originFilename;
    }

    public void setOriginFilename(String originFilename) {
        this.originFilename = originFilename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getUploadedTime() {
        return uploadedTime;
    }

    public void setUploadedTime(Date uploadedTime) {
        this.uploadedTime = uploadedTime;
    }

    public Date getMatchedTime() {
        return matchedTime;
    }

    public void setMatchedTime(Date matchedTime) {
        this.matchedTime = matchedTime;
    }

    public Integer getIsDoubtfulFile() {
        return isDoubtfulFile;
    }

    public void setIsDoubtfulFile(Integer isDoubtfulFile) {
        this.isDoubtfulFile = isDoubtfulFile;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Long getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(Long diagnosisId) {
        this.diagnosisId = diagnosisId;
    }

    public String getLabelUrl() {
        return labelUrl;
    }

    public void setLabelUrl(String labelUrl) {
        this.labelUrl = labelUrl;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public Integer getIsAddedBiopsy() {
        return isAddedBiopsy;
    }

    public void setIsAddedBiopsy(Integer isAddedBiopsy) {
        this.isAddedBiopsy = isAddedBiopsy;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

}
