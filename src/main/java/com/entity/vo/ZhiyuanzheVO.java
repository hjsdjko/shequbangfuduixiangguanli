package com.entity.vo;

import com.entity.ZhiyuanzheEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 志愿者
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zhiyuanzhe")
public class ZhiyuanzheVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 志愿者姓名
     */

    @TableField(value = "zhiyuanzhe_name")
    private String zhiyuanzheName;


    /**
     * 志愿者手机号
     */

    @TableField(value = "zhiyuanzhe_phone")
    private String zhiyuanzhePhone;


    /**
     * 志愿者身份证号
     */

    @TableField(value = "zhiyuanzhe_id_number")
    private String zhiyuanzheIdNumber;


    /**
     * 志愿者头像
     */

    @TableField(value = "zhiyuanzhe_photo")
    private String zhiyuanzhePhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 志愿者邮箱
     */

    @TableField(value = "zhiyuanzhe_email")
    private String zhiyuanzheEmail;


    /**
     * 创建时间
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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：志愿者姓名
	 */
    public String getZhiyuanzheName() {
        return zhiyuanzheName;
    }


    /**
	 * 获取：志愿者姓名
	 */

    public void setZhiyuanzheName(String zhiyuanzheName) {
        this.zhiyuanzheName = zhiyuanzheName;
    }
    /**
	 * 设置：志愿者手机号
	 */
    public String getZhiyuanzhePhone() {
        return zhiyuanzhePhone;
    }


    /**
	 * 获取：志愿者手机号
	 */

    public void setZhiyuanzhePhone(String zhiyuanzhePhone) {
        this.zhiyuanzhePhone = zhiyuanzhePhone;
    }
    /**
	 * 设置：志愿者身份证号
	 */
    public String getZhiyuanzheIdNumber() {
        return zhiyuanzheIdNumber;
    }


    /**
	 * 获取：志愿者身份证号
	 */

    public void setZhiyuanzheIdNumber(String zhiyuanzheIdNumber) {
        this.zhiyuanzheIdNumber = zhiyuanzheIdNumber;
    }
    /**
	 * 设置：志愿者头像
	 */
    public String getZhiyuanzhePhoto() {
        return zhiyuanzhePhoto;
    }


    /**
	 * 获取：志愿者头像
	 */

    public void setZhiyuanzhePhoto(String zhiyuanzhePhoto) {
        this.zhiyuanzhePhoto = zhiyuanzhePhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：志愿者邮箱
	 */
    public String getZhiyuanzheEmail() {
        return zhiyuanzheEmail;
    }


    /**
	 * 获取：志愿者邮箱
	 */

    public void setZhiyuanzheEmail(String zhiyuanzheEmail) {
        this.zhiyuanzheEmail = zhiyuanzheEmail;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
