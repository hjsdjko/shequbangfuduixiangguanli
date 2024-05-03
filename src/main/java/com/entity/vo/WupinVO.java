package com.entity.vo;

import com.entity.WupinEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 物品交换
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("wupin")
public class WupinVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 物品名称
     */

    @TableField(value = "wupin_name")
    private String wupinName;


    /**
     * 封面
     */

    @TableField(value = "wupin_photo")
    private String wupinPhoto;


    /**
     * 物品类型
     */

    @TableField(value = "wupin_types")
    private Integer wupinTypes;


    /**
     * 交换需求
     */

    @TableField(value = "wupin_xuqiu")
    private String wupinXuqiu;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 物品介绍
     */

    @TableField(value = "wupin_content")
    private String wupinContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "wupin_delete")
    private Integer wupinDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：物品名称
	 */
    public String getWupinName() {
        return wupinName;
    }


    /**
	 * 获取：物品名称
	 */

    public void setWupinName(String wupinName) {
        this.wupinName = wupinName;
    }
    /**
	 * 设置：封面
	 */
    public String getWupinPhoto() {
        return wupinPhoto;
    }


    /**
	 * 获取：封面
	 */

    public void setWupinPhoto(String wupinPhoto) {
        this.wupinPhoto = wupinPhoto;
    }
    /**
	 * 设置：物品类型
	 */
    public Integer getWupinTypes() {
        return wupinTypes;
    }


    /**
	 * 获取：物品类型
	 */

    public void setWupinTypes(Integer wupinTypes) {
        this.wupinTypes = wupinTypes;
    }
    /**
	 * 设置：交换需求
	 */
    public String getWupinXuqiu() {
        return wupinXuqiu;
    }


    /**
	 * 获取：交换需求
	 */

    public void setWupinXuqiu(String wupinXuqiu) {
        this.wupinXuqiu = wupinXuqiu;
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
	 * 设置：物品介绍
	 */
    public String getWupinContent() {
        return wupinContent;
    }


    /**
	 * 获取：物品介绍
	 */

    public void setWupinContent(String wupinContent) {
        this.wupinContent = wupinContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getWupinDelete() {
        return wupinDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setWupinDelete(Integer wupinDelete) {
        this.wupinDelete = wupinDelete;
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
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
