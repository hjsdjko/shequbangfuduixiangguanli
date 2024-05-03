package com.entity.model;

import com.entity.WupinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 物品交换
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WupinModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 物品名称
     */
    private String wupinName;


    /**
     * 封面
     */
    private String wupinPhoto;


    /**
     * 物品类型
     */
    private Integer wupinTypes;


    /**
     * 交换需求
     */
    private String wupinXuqiu;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 物品介绍
     */
    private String wupinContent;


    /**
     * 逻辑删除
     */
    private Integer wupinDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
