package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShicaizhanshiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShicaizhanshiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShicaizhanshiView;


/**
 * 食材展示
 *
 * @author 
 * @email 
 * @date 2024-03-20 12:07:41
 */
public interface ShicaizhanshiService extends IService<ShicaizhanshiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShicaizhanshiVO> selectListVO(Wrapper<ShicaizhanshiEntity> wrapper);
   	
   	ShicaizhanshiVO selectVO(@Param("ew") Wrapper<ShicaizhanshiEntity> wrapper);
   	
   	List<ShicaizhanshiView> selectListView(Wrapper<ShicaizhanshiEntity> wrapper);
   	
   	ShicaizhanshiView selectView(@Param("ew") Wrapper<ShicaizhanshiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShicaizhanshiEntity> wrapper);
   	

}

