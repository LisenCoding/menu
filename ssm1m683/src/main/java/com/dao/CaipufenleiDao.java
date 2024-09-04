package com.dao;

import com.entity.CaipufenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.CaipufenleiVO;
import com.entity.view.CaipufenleiView;


/**
 * 菜谱分类
 * 
 * @author 
 * @email 
 * @date 2024-03-20 12:07:41
 */
public interface CaipufenleiDao extends BaseMapper<CaipufenleiEntity> {
	
	List<CaipufenleiVO> selectListVO(@Param("ew") Wrapper<CaipufenleiEntity> wrapper);
	
	CaipufenleiVO selectVO(@Param("ew") Wrapper<CaipufenleiEntity> wrapper);
	
	List<CaipufenleiView> selectListView(@Param("ew") Wrapper<CaipufenleiEntity> wrapper);

	List<CaipufenleiView> selectListView(Pagination page,@Param("ew") Wrapper<CaipufenleiEntity> wrapper);
	
	CaipufenleiView selectView(@Param("ew") Wrapper<CaipufenleiEntity> wrapper);
	

}
