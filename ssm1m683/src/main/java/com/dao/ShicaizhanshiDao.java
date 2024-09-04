package com.dao;

import com.entity.ShicaizhanshiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShicaizhanshiVO;
import com.entity.view.ShicaizhanshiView;


/**
 * 食材展示
 * 
 * @author 
 * @email 
 * @date 2024-03-20 12:07:41
 */
public interface ShicaizhanshiDao extends BaseMapper<ShicaizhanshiEntity> {
	
	List<ShicaizhanshiVO> selectListVO(@Param("ew") Wrapper<ShicaizhanshiEntity> wrapper);
	
	ShicaizhanshiVO selectVO(@Param("ew") Wrapper<ShicaizhanshiEntity> wrapper);
	
	List<ShicaizhanshiView> selectListView(@Param("ew") Wrapper<ShicaizhanshiEntity> wrapper);

	List<ShicaizhanshiView> selectListView(Pagination page,@Param("ew") Wrapper<ShicaizhanshiEntity> wrapper);
	
	ShicaizhanshiView selectView(@Param("ew") Wrapper<ShicaizhanshiEntity> wrapper);
	

}
