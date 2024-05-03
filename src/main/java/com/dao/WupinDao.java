package com.dao;

import com.entity.WupinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.WupinView;

/**
 * 物品交换 Dao 接口
 *
 * @author 
 */
public interface WupinDao extends BaseMapper<WupinEntity> {

   List<WupinView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
