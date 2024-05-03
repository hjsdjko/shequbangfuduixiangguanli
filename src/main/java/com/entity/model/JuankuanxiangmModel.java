package com.entity.model;

import com.entity.JuankuanxiangmEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 捐款项目
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JuankuanxiangmModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 项目名称
     */
    private String juankuanxiangmName;


    /**
     * 封面
     */
    private String juankuanxiangmPhoto;


    /**
     * 志愿者
     */
    private Integer zhiyuanzheId;


    /**
     * 项目类型
     */
    private Integer juankuanxiangmTypes;


    /**
     * 捐款数值
     */
    private Integer juankuanxiangmXuqiu;


    /**
     * 捐款渠道
     */
    private String juankuanxiangmQudao;


    /**
     * 项目介绍
     */
    private String juankuanxiangmContent;


    /**
     * 项目审核
     */
    private Integer juankuanxiangmYesnoTypes;


    /**
     * 审核回复
     */
    private String juankuanxiangmYesnoText;


    /**
     * 逻辑删除
     */
    private Integer juankuanxiangmDelete;


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
