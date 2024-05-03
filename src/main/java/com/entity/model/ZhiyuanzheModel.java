package com.entity.model;

import com.entity.ZhiyuanzheEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 志愿者
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZhiyuanzheModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 志愿者姓名
     */
    private String zhiyuanzheName;


    /**
     * 志愿者手机号
     */
    private String zhiyuanzhePhone;


    /**
     * 志愿者身份证号
     */
    private String zhiyuanzheIdNumber;


    /**
     * 志愿者头像
     */
    private String zhiyuanzhePhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 志愿者邮箱
     */
    private String zhiyuanzheEmail;


    /**
     * 创建时间
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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：志愿者姓名
	 */
    public String getZhiyuanzheName() {
        return zhiyuanzheName;
    }


    /**
	 * 设置：志愿者姓名
	 */
    public void setZhiyuanzheName(String zhiyuanzheName) {
        this.zhiyuanzheName = zhiyuanzheName;
    }
    /**
	 * 获取：志愿者手机号
	 */
    public String getZhiyuanzhePhone() {
        return zhiyuanzhePhone;
    }


    /**
	 * 设置：志愿者手机号
	 */
    public void setZhiyuanzhePhone(String zhiyuanzhePhone) {
        this.zhiyuanzhePhone = zhiyuanzhePhone;
    }
    /**
	 * 获取：志愿者身份证号
	 */
    public String getZhiyuanzheIdNumber() {
        return zhiyuanzheIdNumber;
    }


    /**
	 * 设置：志愿者身份证号
	 */
    public void setZhiyuanzheIdNumber(String zhiyuanzheIdNumber) {
        this.zhiyuanzheIdNumber = zhiyuanzheIdNumber;
    }
    /**
	 * 获取：志愿者头像
	 */
    public String getZhiyuanzhePhoto() {
        return zhiyuanzhePhoto;
    }


    /**
	 * 设置：志愿者头像
	 */
    public void setZhiyuanzhePhoto(String zhiyuanzhePhoto) {
        this.zhiyuanzhePhoto = zhiyuanzhePhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：志愿者邮箱
	 */
    public String getZhiyuanzheEmail() {
        return zhiyuanzheEmail;
    }


    /**
	 * 设置：志愿者邮箱
	 */
    public void setZhiyuanzheEmail(String zhiyuanzheEmail) {
        this.zhiyuanzheEmail = zhiyuanzheEmail;
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

    }
