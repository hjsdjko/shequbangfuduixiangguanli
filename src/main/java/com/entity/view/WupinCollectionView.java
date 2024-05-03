package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.WupinCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 物品收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("wupin_collection")
public class WupinCollectionView extends WupinCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String wupinCollectionValue;

	//级联表 物品交换
		/**
		* 物品名称
		*/

		@ColumnInfo(comment="物品名称",type="varchar(200)")
		private String wupinName;
		/**
		* 封面
		*/

		@ColumnInfo(comment="封面",type="varchar(200)")
		private String wupinPhoto;
		/**
		* 物品类型
		*/
		@ColumnInfo(comment="物品类型",type="int(11)")
		private Integer wupinTypes;
			/**
			* 物品类型的值
			*/
			@ColumnInfo(comment="物品类型的字典表值",type="varchar(200)")
			private String wupinValue;
		/**
		* 交换需求
		*/

		@ColumnInfo(comment="交换需求",type="varchar(200)")
		private String wupinXuqiu;
					 
		/**
		* 物品交换 的 用户
		*/
		@ColumnInfo(comment="用户",type="int(11)")
		private Integer wupinYonghuId;
		/**
		* 物品介绍
		*/

		@ColumnInfo(comment="物品介绍",type="longtext")
		private String wupinContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer wupinDelete;
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



	public WupinCollectionView() {

	}

	public WupinCollectionView(WupinCollectionEntity wupinCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, wupinCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getWupinCollectionValue() {
		return wupinCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setWupinCollectionValue(String wupinCollectionValue) {
		this.wupinCollectionValue = wupinCollectionValue;
	}


	//级联表的get和set 物品交换

		/**
		* 获取： 物品名称
		*/
		public String getWupinName() {
			return wupinName;
		}
		/**
		* 设置： 物品名称
		*/
		public void setWupinName(String wupinName) {
			this.wupinName = wupinName;
		}

		/**
		* 获取： 封面
		*/
		public String getWupinPhoto() {
			return wupinPhoto;
		}
		/**
		* 设置： 封面
		*/
		public void setWupinPhoto(String wupinPhoto) {
			this.wupinPhoto = wupinPhoto;
		}
		/**
		* 获取： 物品类型
		*/
		public Integer getWupinTypes() {
			return wupinTypes;
		}
		/**
		* 设置： 物品类型
		*/
		public void setWupinTypes(Integer wupinTypes) {
			this.wupinTypes = wupinTypes;
		}


			/**
			* 获取： 物品类型的值
			*/
			public String getWupinValue() {
				return wupinValue;
			}
			/**
			* 设置： 物品类型的值
			*/
			public void setWupinValue(String wupinValue) {
				this.wupinValue = wupinValue;
			}

		/**
		* 获取： 交换需求
		*/
		public String getWupinXuqiu() {
			return wupinXuqiu;
		}
		/**
		* 设置： 交换需求
		*/
		public void setWupinXuqiu(String wupinXuqiu) {
			this.wupinXuqiu = wupinXuqiu;
		}
		/**
		* 获取：物品交换 的 用户
		*/
		public Integer getWupinYonghuId() {
			return wupinYonghuId;
		}
		/**
		* 设置：物品交换 的 用户
		*/
		public void setWupinYonghuId(Integer wupinYonghuId) {
			this.wupinYonghuId = wupinYonghuId;
		}

		/**
		* 获取： 物品介绍
		*/
		public String getWupinContent() {
			return wupinContent;
		}
		/**
		* 设置： 物品介绍
		*/
		public void setWupinContent(String wupinContent) {
			this.wupinContent = wupinContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getWupinDelete() {
			return wupinDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setWupinDelete(Integer wupinDelete) {
			this.wupinDelete = wupinDelete;
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
		return "WupinCollectionView{" +
			", wupinCollectionValue=" + wupinCollectionValue +
			", wupinName=" + wupinName +
			", wupinPhoto=" + wupinPhoto +
			", wupinXuqiu=" + wupinXuqiu +
			", wupinContent=" + wupinContent +
			", wupinDelete=" + wupinDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", jiarenPhone=" + jiarenPhone +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
