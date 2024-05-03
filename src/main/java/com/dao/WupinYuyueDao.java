package com.dao;

import com.entity.WupinYuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.WupinYuyueView;

/**
 * 申请交换 Dao 接口
 *
 * @author 
 */
public interface WupinYuyueDao extends BaseMapper<WupinYuyueEntity> {

   List<WupinYuyueView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
