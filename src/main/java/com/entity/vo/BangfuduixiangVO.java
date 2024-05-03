package com.entity.vo;

import com.entity.BangfuduixiangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 帮扶对象
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("bangfuduixiang")
public class BangfuduixiangVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 帮扶类型
     */

    @TableField(value = "bangfuduixiang_types")
    private Integer bangfuduixiangTypes;


    /**
     * 帮扶详情
     */

    @TableField(value = "bangfuduixiang_content")
    private String bangfuduixiangContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "bangfuduixiang_delete")
    private Integer bangfuduixiangDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show2 listShow
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
	 * 设置：帮扶类型
	 */
    public Integer getBangfuduixiangTypes() {
        return bangfuduixiangTypes;
    }


    /**
	 * 获取：帮扶类型
	 */

    public void setBangfuduixiangTypes(Integer bangfuduixiangTypes) {
        this.bangfuduixiangTypes = bangfuduixiangTypes;
    }
    /**
	 * 设置：帮扶详情
	 */
    public String getBangfuduixiangContent() {
        return bangfuduixiangContent;
    }


    /**
	 * 获取：帮扶详情
	 */

    public void setBangfuduixiangContent(String bangfuduixiangContent) {
        this.bangfuduixiangContent = bangfuduixiangContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getBangfuduixiangDelete() {
        return bangfuduixiangDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setBangfuduixiangDelete(Integer bangfuduixiangDelete) {
        this.bangfuduixiangDelete = bangfuduixiangDelete;
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
	 * 设置：创建时间 show2 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show2 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
