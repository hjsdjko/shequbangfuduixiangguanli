package com.entity.model;

import com.entity.BangfuduixiangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 帮扶对象
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class BangfuduixiangModel implements Serializable {
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
     * 帮扶类型
     */
    private Integer bangfuduixiangTypes;


    /**
     * 帮扶详情
     */
    private String bangfuduixiangContent;


    /**
     * 逻辑删除
     */
    private Integer bangfuduixiangDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show2 listShow
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
	 * 获取：帮扶详情
	 */
    public String getBangfuduixiangContent() {
        return bangfuduixiangContent;
    }


    /**
	 * 设置：帮扶详情
	 */
    public void setBangfuduixiangContent(String bangfuduixiangContent) {
        this.bangfuduixiangContent = bangfuduixiangContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getBangfuduixiangDelete() {
        return bangfuduixiangDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setBangfuduixiangDelete(Integer bangfuduixiangDelete) {
        this.bangfuduixiangDelete = bangfuduixiangDelete;
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
	 * 获取：创建时间 show2 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show2 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
