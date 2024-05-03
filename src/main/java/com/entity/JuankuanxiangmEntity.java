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
 * 捐款项目
 *
 * @author 
 * @email
 */
@TableName("juankuanxiangm")
public class JuankuanxiangmEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JuankuanxiangmEntity() {

	}

	public JuankuanxiangmEntity(T t) {
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
     * 项目名称
     */
    @ColumnInfo(comment="项目名称",type="varchar(200)")
    @TableField(value = "juankuanxiangm_name")

    private String juankuanxiangmName;


    /**
     * 封面
     */
    @ColumnInfo(comment="封面",type="varchar(200)")
    @TableField(value = "juankuanxiangm_photo")

    private String juankuanxiangmPhoto;


    /**
     * 志愿者
     */
    @ColumnInfo(comment="志愿者",type="int(11)")
    @TableField(value = "zhiyuanzhe_id")

    private Integer zhiyuanzheId;


    /**
     * 项目类型
     */
    @ColumnInfo(comment="项目类型",type="int(11)")
    @TableField(value = "juankuanxiangm_types")

    private Integer juankuanxiangmTypes;


    /**
     * 捐款数值
     */
    @ColumnInfo(comment="捐款数值",type="int(11)")
    @TableField(value = "juankuanxiangm_xuqiu")

    private Integer juankuanxiangmXuqiu;


    /**
     * 捐款渠道
     */
    @ColumnInfo(comment="捐款渠道",type="varchar(200)")
    @TableField(value = "juankuanxiangm_qudao")

    private String juankuanxiangmQudao;


    /**
     * 项目介绍
     */
    @ColumnInfo(comment="项目介绍",type="longtext")
    @TableField(value = "juankuanxiangm_content")

    private String juankuanxiangmContent;


    /**
     * 项目审核
     */
    @ColumnInfo(comment="项目审核",type="int(11)")
    @TableField(value = "juankuanxiangm_yesno_types")

    private Integer juankuanxiangmYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="longtext")
    @TableField(value = "juankuanxiangm_yesno_text")

    private String juankuanxiangmYesnoText;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "juankuanxiangm_delete")

    private Integer juankuanxiangmDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
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
	 * 获取：项目名称
	 */
    public String getJuankuanxiangmName() {
        return juankuanxiangmName;
    }
    /**
	 * 设置：项目名称
	 */

    public void setJuankuanxiangmName(String juankuanxiangmName) {
        this.juankuanxiangmName = juankuanxiangmName;
    }
    /**
	 * 获取：封面
	 */
    public String getJuankuanxiangmPhoto() {
        return juankuanxiangmPhoto;
    }
    /**
	 * 设置：封面
	 */

    public void setJuankuanxiangmPhoto(String juankuanxiangmPhoto) {
        this.juankuanxiangmPhoto = juankuanxiangmPhoto;
    }
    /**
	 * 获取：志愿者
	 */
    public Integer getZhiyuanzheId() {
        return zhiyuanzheId;
    }
    /**
	 * 设置：志愿者
	 */

    public void setZhiyuanzheId(Integer zhiyuanzheId) {
        this.zhiyuanzheId = zhiyuanzheId;
    }
    /**
	 * 获取：项目类型
	 */
    public Integer getJuankuanxiangmTypes() {
        return juankuanxiangmTypes;
    }
    /**
	 * 设置：项目类型
	 */

    public void setJuankuanxiangmTypes(Integer juankuanxiangmTypes) {
        this.juankuanxiangmTypes = juankuanxiangmTypes;
    }
    /**
	 * 获取：捐款数值
	 */
    public Integer getJuankuanxiangmXuqiu() {
        return juankuanxiangmXuqiu;
    }
    /**
	 * 设置：捐款数值
	 */

    public void setJuankuanxiangmXuqiu(Integer juankuanxiangmXuqiu) {
        this.juankuanxiangmXuqiu = juankuanxiangmXuqiu;
    }
    /**
	 * 获取：捐款渠道
	 */
    public String getJuankuanxiangmQudao() {
        return juankuanxiangmQudao;
    }
    /**
	 * 设置：捐款渠道
	 */

    public void setJuankuanxiangmQudao(String juankuanxiangmQudao) {
        this.juankuanxiangmQudao = juankuanxiangmQudao;
    }
    /**
	 * 获取：项目介绍
	 */
    public String getJuankuanxiangmContent() {
        return juankuanxiangmContent;
    }
    /**
	 * 设置：项目介绍
	 */

    public void setJuankuanxiangmContent(String juankuanxiangmContent) {
        this.juankuanxiangmContent = juankuanxiangmContent;
    }
    /**
	 * 获取：项目审核
	 */
    public Integer getJuankuanxiangmYesnoTypes() {
        return juankuanxiangmYesnoTypes;
    }
    /**
	 * 设置：项目审核
	 */

    public void setJuankuanxiangmYesnoTypes(Integer juankuanxiangmYesnoTypes) {
        this.juankuanxiangmYesnoTypes = juankuanxiangmYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getJuankuanxiangmYesnoText() {
        return juankuanxiangmYesnoText;
    }
    /**
	 * 设置：审核回复
	 */

    public void setJuankuanxiangmYesnoText(String juankuanxiangmYesnoText) {
        this.juankuanxiangmYesnoText = juankuanxiangmYesnoText;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getJuankuanxiangmDelete() {
        return juankuanxiangmDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setJuankuanxiangmDelete(Integer juankuanxiangmDelete) {
        this.juankuanxiangmDelete = juankuanxiangmDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Juankuanxiangm{" +
            ", id=" + id +
            ", juankuanxiangmName=" + juankuanxiangmName +
            ", juankuanxiangmPhoto=" + juankuanxiangmPhoto +
            ", zhiyuanzheId=" + zhiyuanzheId +
            ", juankuanxiangmTypes=" + juankuanxiangmTypes +
            ", juankuanxiangmXuqiu=" + juankuanxiangmXuqiu +
            ", juankuanxiangmQudao=" + juankuanxiangmQudao +
            ", juankuanxiangmContent=" + juankuanxiangmContent +
            ", juankuanxiangmYesnoTypes=" + juankuanxiangmYesnoTypes +
            ", juankuanxiangmYesnoText=" + juankuanxiangmYesnoText +
            ", juankuanxiangmDelete=" + juankuanxiangmDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
