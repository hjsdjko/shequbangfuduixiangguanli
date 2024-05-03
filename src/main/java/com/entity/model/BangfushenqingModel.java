package com.entity.model;

import com.entity.BangfushenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 帮扶申请
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class BangfushenqingModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 申请原因
     */
    private String bangfushenqingText;


    /**
     * 凭证文件
     */
    private String bangfushenqingFile;


    /**
     * 帮扶类型
     */
    private Integer bangfuduixiangTypes;


    /**
     * 交换状态
     */
    private Integer bangfushenqingYesnoTypes;


    /**
     * 回复
     */
    private String bangfushenqingYesnoText;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：申请原因
	 */
    public String getBangfushenqingText() {
        return bangfushenqingText;
    }


    /**
	 * 设置：申请原因
	 */
    public void setBangfushenqingText(String bangfushenqingText) {
        this.bangfushenqingText = bangfushenqingText;
    }
    /**
	 * 获取：凭证文件
	 */
    public String getBangfushenqingFile() {
        return bangfushenqingFile;
    }


    /**
	 * 设置：凭证文件
	 */
    public void setBangfushenqingFile(String bangfushenqingFile) {
        this.bangfushenqingFile = bangfushenqingFile;
    }
    /**
	 * 获取：帮扶类型
	 */
    public Integer getBangfuduixiangTypes() {
        return bangfuduixiangTypes;
    }


    /**
	 * 设置：帮扶类型
	 */
    public void setBangfuduixiangTypes(Integer bangfuduixiangTypes) {
        this.bangfuduixiangTypes = bangfuduixiangTypes;
    }
    /**
	 * 获取：交换状态
	 */
    public Integer getBangfushenqingYesnoTypes() {
        return bangfushenqingYesnoTypes;
    }


    /**
	 * 设置：交换状态
	 */
    public void setBangfushenqingYesnoTypes(Integer bangfushenqingYesnoTypes) {
        this.bangfushenqingYesnoTypes = bangfushenqingYesnoTypes;
    }
    /**
	 * 获取：回复
	 */
    public String getBangfushenqingYesnoText() {
        return bangfushenqingYesnoText;
    }


    /**
	 * 设置：回复
	 */
    public void setBangfushenqingYesnoText(String bangfushenqingYesnoText) {
        this.bangfushenqingYesnoText = bangfushenqingYesnoText;
    }
    /**
	 * 获取：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：申请时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
