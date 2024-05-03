package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JuankuanxiangmLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 捐款项目留言
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("juankuanxiangm_liuyan")
public class JuankuanxiangmLiuyanView extends JuankuanxiangmLiuyanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 捐款项目
		/**
		* 项目名称
		*/

		@ColumnInfo(comment="项目名称",type="varchar(200)")
		private String juankuanxiangmName;
		/**
		* 封面
		*/

		@ColumnInfo(comment="封面",type="varchar(200)")
		private String juankuanxiangmPhoto;
					 
		/**
		* 捐款项目 的 志愿者
		*/
		@ColumnInfo(comment="志愿者",type="int(11)")
		private Integer juankuanxiangmZhiyuanzheId;
		/**
		* 项目类型
		*/
		@ColumnInfo(comment="项目类型",type="int(11)")
		private Integer juankuanxiangmTypes;
			/**
			* 项目类型的值
			*/
			@ColumnInfo(comment="项目类型的字典表值",type="varchar(200)")
			private String juankuanxiangmValue;
		/**
		* 捐款数值
		*/

		@ColumnInfo(comment="捐款数值",type="int(11)")
		private Integer juankuanxiangmXuqiu;
		/**
		* 捐款渠道
		*/

		@ColumnInfo(comment="捐款渠道",type="varchar(200)")
		private String juankuanxiangmQudao;
		/**
		* 项目介绍
		*/

		@ColumnInfo(comment="项目介绍",type="longtext")
		private String juankuanxiangmContent;
		/**
		* 项目审核
		*/
		@ColumnInfo(comment="项目审核",type="int(11)")
		private Integer juankuanxiangmYesnoTypes;
			/**
			* 项目审核的值
			*/
			@ColumnInfo(comment="项目审核的字典表值",type="varchar(200)")
			private String juankuanxiangmYesnoValue;
		/**
		* 审核回复
		*/

		@ColumnInfo(comment="审核回复",type="longtext")
		private String juankuanxiangmYesnoText;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer juankuanxiangmDelete;
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



	public JuankuanxiangmLiuyanView() {

	}

	public JuankuanxiangmLiuyanView(JuankuanxiangmLiuyanEntity juankuanxiangmLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, juankuanxiangmLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 捐款项目

		/**
		* 获取： 项目名称
		*/
		public String getJuankuanxiangmName() {
			return juankuanxiangmName;
		}
		/**
		* 设置： 项目名称
		*/
		public void setJuankuanxiangmName(String juankuanxiangmName) {
			this.juankuanxiangmName = juankuanxiangmName;
		}

		/**
		* 获取： 封面
		*/
		public String getJuankuanxiangmPhoto() {
			return juankuanxiangmPhoto;
		}
		/**
		* 设置： 封面
		*/
		public void setJuankuanxiangmPhoto(String juankuanxiangmPhoto) {
			this.juankuanxiangmPhoto = juankuanxiangmPhoto;
		}
		/**
		* 获取：捐款项目 的 志愿者
		*/
		public Integer getJuankuanxiangmZhiyuanzheId() {
			return juankuanxiangmZhiyuanzheId;
		}
		/**
		* 设置：捐款项目 的 志愿者
		*/
		public void setJuankuanxiangmZhiyuanzheId(Integer juankuanxiangmZhiyuanzheId) {
			this.juankuanxiangmZhiyuanzheId = juankuanxiangmZhiyuanzheId;
		}
		/**
		* 获取： 项目类型
		*/
		public Integer getJuankuanxiangmTypes() {
			return juankuanxiangmTypes;
		}
		/**
		* 设置： 项目类型
		*/
		public void setJuankuanxiangmTypes(Integer juankuanxiangmTypes) {
			this.juankuanxiangmTypes = juankuanxiangmTypes;
		}


			/**
			* 获取： 项目类型的值
			*/
			public String getJuankuanxiangmValue() {
				return juankuanxiangmValue;
			}
			/**
			* 设置： 项目类型的值
			*/
			public void setJuankuanxiangmValue(String juankuanxiangmValue) {
				this.juankuanxiangmValue = juankuanxiangmValue;
			}

		/**
		* 获取： 捐款数值
		*/
		public Integer getJuankuanxiangmXuqiu() {
			return juankuanxiangmXuqiu;
		}
		/**
		* 设置： 捐款数值
		*/
		public void setJuankuanxiangmXuqiu(Integer juankuanxiangmXuqiu) {
			this.juankuanxiangmXuqiu = juankuanxiangmXuqiu;
		}

		/**
		* 获取： 捐款渠道
		*/
		public String getJuankuanxiangmQudao() {
			return juankuanxiangmQudao;
		}
		/**
		* 设置： 捐款渠道
		*/
		public void setJuankuanxiangmQudao(String juankuanxiangmQudao) {
			this.juankuanxiangmQudao = juankuanxiangmQudao;
		}

		/**
		* 获取： 项目介绍
		*/
		public String getJuankuanxiangmContent() {
			return juankuanxiangmContent;
		}
		/**
		* 设置： 项目介绍
		*/
		public void setJuankuanxiangmContent(String juankuanxiangmContent) {
			this.juankuanxiangmContent = juankuanxiangmContent;
		}
		/**
		* 获取： 项目审核
		*/
		public Integer getJuankuanxiangmYesnoTypes() {
			return juankuanxiangmYesnoTypes;
		}
		/**
		* 设置： 项目审核
		*/
		public void setJuankuanxiangmYesnoTypes(Integer juankuanxiangmYesnoTypes) {
			this.juankuanxiangmYesnoTypes = juankuanxiangmYesnoTypes;
		}


			/**
			* 获取： 项目审核的值
			*/
			public String getJuankuanxiangmYesnoValue() {
				return juankuanxiangmYesnoValue;
			}
			/**
			* 设置： 项目审核的值
			*/
			public void setJuankuanxiangmYesnoValue(String juankuanxiangmYesnoValue) {
				this.juankuanxiangmYesnoValue = juankuanxiangmYesnoValue;
			}

		/**
		* 获取： 审核回复
		*/
		public String getJuankuanxiangmYesnoText() {
			return juankuanxiangmYesnoText;
		}
		/**
		* 设置： 审核回复
		*/
		public void setJuankuanxiangmYesnoText(String juankuanxiangmYesnoText) {
			this.juankuanxiangmYesnoText = juankuanxiangmYesnoText;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getJuankuanxiangmDelete() {
			return juankuanxiangmDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setJuankuanxiangmDelete(Integer juankuanxiangmDelete) {
			this.juankuanxiangmDelete = juankuanxiangmDelete;
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
		return "JuankuanxiangmLiuyanView{" +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", jiarenPhone=" + jiarenPhone +
			", yonghuEmail=" + yonghuEmail +
			", juankuanxiangmName=" + juankuanxiangmName +
			", juankuanxiangmPhoto=" + juankuanxiangmPhoto +
			", juankuanxiangmXuqiu=" + juankuanxiangmXuqiu +
			", juankuanxiangmQudao=" + juankuanxiangmQudao +
			", juankuanxiangmContent=" + juankuanxiangmContent +
			", juankuanxiangmYesnoText=" + juankuanxiangmYesnoText +
			", juankuanxiangmDelete=" + juankuanxiangmDelete +
			"} " + super.toString();
	}
}
