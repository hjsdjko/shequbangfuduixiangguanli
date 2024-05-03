package com.entity.model;

import com.entity.DanganEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 档案
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class DanganModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 档案标题
     */
    private String danganName;


    /**
     * 档案类型
     */
    private Integer danganTypes;


    /**
     * 基础病史
     */
    private String danganFile;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 档案详情
     */
    private String danganContent;


    /**
     * 逻辑删除
     */
    private Integer danganDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show3 listShow
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
	 * 获取：档案标题
	 */
    public String getDanganName() {
        return danganName;
    }


    /**
	 * 设置：档案标题
	 */
    public void setDanganName(String danganName) {
        this.danganName = danganName;
    }
    /**
	 * 获取：档案类型
	 */
    public Integer getDanganTypes() {
        return danganTypes;
    }


    /**
	 * 设置：档案类型
	 */
    public void setDanganTypes(Integer danganTypes) {
        this.danganTypes = danganTypes;
    }
    /**
	 * 获取：基础病史
	 */
    public String getDanganFile() {
        return danganFile;
    }


    /**
	 * 设置：基础病史
	 */
    public void setDanganFile(String danganFile) {
        this.danganFile = danganFile;
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
	 * 获取：档案详情
	 */
    public String getDanganContent() {
        return danganContent;
    }


    /**
	 * 设置：档案详情
	 */
    public void setDanganContent(String danganContent) {
        this.danganContent = danganContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getDanganDelete() {
        return danganDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setDanganDelete(Integer danganDelete) {
        this.danganDelete = danganDelete;
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
	 * 获取：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
