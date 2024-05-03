package com.entity.model;

import com.entity.WupinYuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 申请交换
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WupinYuyueModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 物品
     */
    private Integer wupinId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 交换物品详情
     */
    private String wupinYuyueText;


    /**
     * 交换状态
     */
    private Integer wupinYuyueYesnoTypes;


    /**
     * 回复
     */
    private String wupinYuyueYesnoText;


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
	 * 获取：物品
	 */
    public Integer getWupinId() {
        return wupinId;
    }


    /**
	 * 设置：物品
	 */
    public void setWupinId(Integer wupinId) {
        this.wupinId = wupinId;
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
	 * 获取：交换物品详情
	 */
    public String getWupinYuyueText() {
        return wupinYuyueText;
    }


    /**
	 * 设置：交换物品详情
	 */
    public void setWupinYuyueText(String wupinYuyueText) {
        this.wupinYuyueText = wupinYuyueText;
    }
    /**
	 * 获取：交换状态
	 */
    public Integer getWupinYuyueYesnoTypes() {
        return wupinYuyueYesnoTypes;
    }


    /**
	 * 设置：交换状态
	 */
    public void setWupinYuyueYesnoTypes(Integer wupinYuyueYesnoTypes) {
        this.wupinYuyueYesnoTypes = wupinYuyueYesnoTypes;
    }
    /**
	 * 获取：回复
	 */
    public String getWupinYuyueYesnoText() {
        return wupinYuyueYesnoText;
    }


    /**
	 * 设置：回复
	 */
    public void setWupinYuyueYesnoText(String wupinYuyueYesnoText) {
        this.wupinYuyueYesnoText = wupinYuyueYesnoText;
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
