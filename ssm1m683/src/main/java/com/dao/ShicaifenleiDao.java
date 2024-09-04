package com.dao;

import com.entity.ShicaifenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShicaifenleiVO;
import com.entity.view.ShicaifenleiView;


/**
 * 食材分类
 * 
 * @author 
 * @email 
 * @date 2024-03-20 12:07:41
 */
public interface ShicaifenleiDao extends BaseMapper<ShicaifenleiEntity> {
	
	List<ShicaifenleiVO> selectListVO(@Param("ew") Wrapper<ShicaifenleiEntity> wrapper);
	
	ShicaifenleiVO selectVO(@Param("ew") Wrapper<ShicaifenleiEntity> wrapper);
	
	List<ShicaifenleiView> selectListView(@Param("ew") Wrapper<ShicaifenleiEntity> wrapper);

	List<ShicaifenleiView> selectListView(Pagination page,@Param("ew") Wrapper<ShicaifenleiEntity> wrapper);
	
	ShicaifenleiView selectView(@Param("ew") Wrapper<ShicaifenleiEntity> wrapper);
	

}
