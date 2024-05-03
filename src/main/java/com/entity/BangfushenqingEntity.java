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
 * 帮扶申请
 *
 * @author 
 * @email
 */
@TableName("bangfushenqing")
public class BangfushenqingEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public BangfushenqingEntity() {

	}

	public BangfushenqingEntity(T t) {
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
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 申请原因
     */
    @ColumnInfo(comment="申请原因",type="longtext")
    @TableField(value = "bangfushenqing_text")

    private String bangfushenqingText;


    /**
     * 凭证文件
     */
    @ColumnInfo(comment="凭证文件",type="varchar(200)")
    @TableField(value = "bangfushenqing_file")

    private String bangfushenqingFile;


    /**
     * 帮扶类型
     */
    @ColumnInfo(comment="帮扶类型",type="int(11)")
    @TableField(value = "bangfuduixiang_types")

    private Integer bangfuduixiangTypes;


    /**
     * 交换状态
     */
    @ColumnInfo(comment="交换状态",type="int(11)")
    @TableField(value = "bangfushenqing_yesno_types")

    private Integer bangfushenqingYesnoTypes;


    /**
     * 回复
     */
    @ColumnInfo(comment="回复",type="longtext")
    @TableField(value = "bangfushenqing_yesno_text")

    private String bangfushenqingYesnoText;


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
        return "Bangfushenqing{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", bangfushenqingText=" + bangfushenqingText +
            ", bangfushenqingFile=" + bangfushenqingFile +
            ", bangfuduixiangTypes=" + bangfuduixiangTypes +
            ", bangfushenqingYesnoTypes=" + bangfushenqingYesnoTypes +
            ", bangfushenqingYesnoText=" + bangfushenqingYesnoText +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
