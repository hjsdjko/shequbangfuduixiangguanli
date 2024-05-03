package com.dao;

import com.entity.JuankuanxiangmEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JuankuanxiangmView;

/**
 * 捐款项目 Dao 接口
 *
 * @author 
 */
public interface JuankuanxiangmDao extends BaseMapper<JuankuanxiangmEntity> {

   List<JuankuanxiangmView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
