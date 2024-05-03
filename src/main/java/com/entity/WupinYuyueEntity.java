package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 申请交换
 *
 * @author 
 * @email
 */
@TableName("wupin_yuyue")
public class WupinYuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public WupinYuyueEntity() {

	}

	public WupinYuyueEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 物品
     */
    @ColumnInfo(comment="物品",type="int(11)")
    @TableField(value = "wupin_id")

    private Integer wupinId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 交换物品详情
     */
    @ColumnInfo(comment="交换物品详情",type="longtext")
    @TableField(value = "wupin_yuyue_text")

    private String wupinYuyueText;


    /**
     * 交换状态
     */
    @ColumnInfo(comment="交换状态",type="int(11)")
    @TableField(value = "wupin_yuyue_yesno_types")

    private Integer wupinYuyueYesnoTypes;


    /**
     * 回复
     */
    @ColumnInfo(comment="回复",type="longtext")
    @TableField(value = "wupin_yuyue_yesno_text")

    private String wupinYuyueYesnoText;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="申请时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间  listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "WupinYuyue{" +
            ", id=" + id +
            ", wupinId=" + wupinId +
            ", yonghuId=" + yonghuId +
            ", wupinYuyueText=" + wupinYuyueText +
            ", wupinYuyueYesnoTypes=" + wupinYuyueYesnoTypes +
            ", wupinYuyueYesnoText=" + wupinYuyueYesnoText +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
