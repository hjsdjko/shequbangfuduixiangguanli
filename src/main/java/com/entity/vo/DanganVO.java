package com.entity.vo;

import com.entity.DanganEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 档案
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("dangan")
public class DanganVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 档案标题
     */

    @TableField(value = "dangan_name")
    private String danganName;


    /**
     * 档案类型
     */

    @TableField(value = "dangan_types")
    private Integer danganTypes;


    /**
     * 基础病史
     */

    @TableField(value = "dangan_file")
    private String danganFile;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 档案详情
     */

    @TableField(value = "dangan_content")
    private String danganContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "dangan_delete")
    private Integer danganDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：档案标题
	 */
    public String getDanganName() {
        return danganName;
    }


    /**
	 * 获取：档案标题
	 */

    public void setDanganName(String danganName) {
        this.danganName = danganName;
    }
    /**
	 * 设置：档案类型
	 */
    public Integer getDanganTypes() {
        return danganTypes;
    }


    /**
	 * 获取：档案类型
	 */

    public void setDanganTypes(Integer danganTypes) {
        this.danganTypes = danganTypes;
    }
    /**
	 * 设置：基础病史
	 */
    public String getDanganFile() {
        return danganFile;
    }


    /**
	 * 获取：基础病史
	 */

    public void setDanganFile(String danganFile) {
        this.danganFile = danganFile;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：档案详情
	 */
    public String getDanganContent() {
        return danganContent;
    }


    /**
	 * 获取：档案详情
	 */

    public void setDanganContent(String danganContent) {
        this.danganContent = danganContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getDanganDelete() {
        return danganDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setDanganDelete(Integer danganDelete) {
        this.danganDelete = danganDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
