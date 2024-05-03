package com.dao;

import com.entity.WupinLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.WupinLiuyanView;

/**
 * 物品留言 Dao 接口
 *
 * @author 
 */
public interface WupinLiuyanDao extends BaseMapper<WupinLiuyanEntity> {

   List<WupinLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
