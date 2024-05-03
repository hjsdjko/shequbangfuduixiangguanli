package com.dao;

import com.entity.WupinCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.WupinCollectionView;

/**
 * 物品收藏 Dao 接口
 *
 * @author 
 */
public interface WupinCollectionDao extends BaseMapper<WupinCollectionEntity> {

   List<WupinCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
