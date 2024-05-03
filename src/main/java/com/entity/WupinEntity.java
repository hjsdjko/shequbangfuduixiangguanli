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
 * 物品交换
 *
 * @author 
 * @email
 */
@TableName("wupin")
public class WupinEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public WupinEntity() {

	}

	public WupinEntity(T t) {
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
     * 物品名称
     */
    @ColumnInfo(comment="物品名称",type="varchar(200)")
    @TableField(value = "wupin_name")

    private String wupinName;


    /**
     * 封面
     */
    @ColumnInfo(comment="封面",type="varchar(200)")
    @TableField(value = "wupin_photo")

    private String wupinPhoto;


    /**
     * 物品类型
     */
    @ColumnInfo(comment="物品类型",type="int(11)")
    @TableField(value = "wupin_types")

    private Integer wupinTypes;


    /**
     * 交换需求
     */
    @ColumnInfo(comment="交换需求",type="varchar(200)")
    @TableField(value = "wupin_xuqiu")

    private String wupinXuqiu;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 物品介绍
     */
    @ColumnInfo(comment="物品介绍",type="longtext")
    @TableField(value = "wupin_content")

    private String wupinContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "wupin_delete")

    private Integer wupinDelete;


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
	 * 获取：物品名称
	 */
    public String getWupinName() {
        return wupinName;
    }
    /**
	 * 设置：物品名称
	 */

    public void setWupinName(String wupinName) {
        this.wupinName = wupinName;
    }
    /**
	 * 获取：封面
	 */
    public String getWupinPhoto() {
        return wupinPhoto;
    }
    /**
	 * 设置：封面
	 */

    public void setWupinPhoto(String wupinPhoto) {
        this.wupinPhoto = wupinPhoto;
    }
    /**
	 * 获取：物品类型
	 */
    public Integer getWupinTypes() {
        return wupinTypes;
    }
    /**
	 * 设置：物品类型
	 */

    public void setWupinTypes(Integer wupinTypes) {
        this.wupinTypes = wupinTypes;
    }
    /**
	 * 获取：交换需求
	 */
    public String getWupinXuqiu() {
        return wupinXuqiu;
    }
    /**
	 * 设置：交换需求
	 */

    public void setWupinXuqiu(String wupinXuqiu) {
        this.wupinXuqiu = wupinXuqiu;
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
	 * 获取：物品介绍
	 */
    public String getWupinContent() {
        return wupinContent;
    }
    /**
	 * 设置：物品介绍
	 */

    public void setWupinContent(String wupinContent) {
        this.wupinContent = wupinContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getWupinDelete() {
        return wupinDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setWupinDelete(Integer wupinDelete) {
        this.wupinDelete = wupinDelete;
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
        return "Wupin{" +
            ", id=" + id +
            ", wupinName=" + wupinName +
            ", wupinPhoto=" + wupinPhoto +
            ", wupinTypes=" + wupinTypes +
            ", wupinXuqiu=" + wupinXuqiu +
            ", yonghuId=" + yonghuId +
            ", wupinContent=" + wupinContent +
            ", wupinDelete=" + wupinDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
