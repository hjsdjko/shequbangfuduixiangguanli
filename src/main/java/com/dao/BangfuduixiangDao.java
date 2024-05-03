package com.dao;

import com.entity.BangfuduixiangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.BangfuduixiangView;

/**
 * 帮扶对象 Dao 接口
 *
 * @author 
 */
public interface BangfuduixiangDao extends BaseMapper<BangfuduixiangEntity> {

   List<BangfuduixiangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
