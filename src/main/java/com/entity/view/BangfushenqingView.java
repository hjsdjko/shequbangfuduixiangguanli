package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.BangfushenqingEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 帮扶申请
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("bangfushenqing")
public class BangfushenqingView extends BangfushenqingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 帮扶类型的值
	*/
	@ColumnInfo(comment="帮扶类型的字典表值",type="varchar(200)")
	private String bangfuduixiangValue;
	/**
	* 交换状态的值
	*/
	@ColumnInfo(comment="交换状态的字典表值",type="varchar(200)")
	private String bangfushenqingYesnoValue;

	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 家人联系方式
		*/

		@ColumnInfo(comment="家人联系方式",type="varchar(200)")
		private String jiarenPhone;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;



	public BangfushenqingView() {

	}

	public BangfushenqingView(BangfushenqingEntity bangfushenqingEntity) {
		try {
			BeanUtils.copyProperties(this, bangfushenqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 帮扶类型的值
	*/
	public String getBangfuduixiangValue() {
		return bangfuduixiangValue;
	}
	/**
	* 设置： 帮扶类型的值
	*/
	public void setBangfuduixiangValue(String bangfuduixiangValue) {
		this.bangfuduixiangValue = bangfuduixiangValue;
	}
	//当前表的
	/**
	* 获取： 交换状态的值
	*/
	public String getBangfushenqingYesnoValue() {
		return bangfushenqingYesnoValue;
	}
	/**
	* 设置： 交换状态的值
	*/
	public void setBangfushenqingYesnoValue(String bangfushenqingYesnoValue) {
		this.bangfushenqingYesnoValue = bangfushenqingYesnoValue;
	}


	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 家人联系方式
		*/
		public String getjiarenPhone() {
			return jiarenPhone;
		}
		/**
		* 设置： 家人联系方式
		*/
		public void setjiarenPhone(String jiarenPhone) {
			this.jiarenPhone = jiarenPhone;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}


	@Override
	public String toString() {
		return "BangfushenqingView{" +
			", bangfuduixiangValue=" + bangfuduixiangValue +
			", bangfushenqingYesnoValue=" + bangfushenqingYesnoValue +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", jiarenPhone=" + jiarenPhone +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
