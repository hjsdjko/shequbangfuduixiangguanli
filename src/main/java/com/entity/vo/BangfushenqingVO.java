package com.entity.vo;

import com.entity.BangfushenqingEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 帮扶申请
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("bangfushenqing")
public class BangfushenqingVO implements Serializable {
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
     * 申请原因
     */

    @TableField(value = "bangfushenqing_text")
    private String bangfushenqingText;


    /**
     * 凭证文件
     */

    @TableField(value = "bangfushenqing_file")
    private String bangfushenqingFile;


    /**
     * 帮扶类型
     */

    @TableField(value = "bangfuduixiang_types")
    private Integer bangfuduixiangTypes;


    /**
     * 交换状态
     */

    @TableField(value = "bangfushenqing_yesno_types")
    private Integer bangfushenqingYesnoTypes;


    /**
     * 回复
     */

    @TableField(value = "bangfushenqing_yesno_text")
    private String bangfushenqingYesnoText;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
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
	 * 设置：申请原因
	 */
    public String getBangfushenqingText() {
        return bangfushenqingText;
    }


    /**
	 * 获取：申请原因
	 */

    public void setBangfushenqingText(String bangfushenqingText) {
        this.bangfushenqingText = bangfushenqingText;
    }
    /**
	 * 设置：凭证文件
	 */
    public String getBangfushenqingFile() {
        return bangfushenqingFile;
    }


    /**
	 * 获取：凭证文件
	 */

    public void setBangfushenqingFile(String bangfushenqingFile) {
        this.bangfushenqingFile = bangfushenqingFile;
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
	 * 设置：交换状态
	 */
    public Integer getBangfushenqingYesnoTypes() {
        return bangfushenqingYesnoTypes;
    }


    /**
	 * 获取：交换状态
	 */

    public void setBangfushenqingYesnoTypes(Integer bangfushenqingYesnoTypes) {
        this.bangfushenqingYesnoTypes = bangfushenqingYesnoTypes;
    }
    /**
	 * 设置：回复
	 */
    public String getBangfushenqingYesnoText() {
        return bangfushenqingYesnoText;
    }


    /**
	 * 获取：回复
	 */

    public void setBangfushenqingYesnoText(String bangfushenqingYesnoText) {
        this.bangfushenqingYesnoText = bangfushenqingYesnoText;
    }
    /**
	 * 设置：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
