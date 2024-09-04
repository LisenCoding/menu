package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CaipuxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.CaipuxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CaipuxinxiView;


/**
 * 菜谱信息
 *
 * @author 
 * @email 
 * @date 2024-03-20 12:07:41
 */
public interface CaipuxinxiService extends IService<CaipuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CaipuxinxiVO> selectListVO(Wrapper<CaipuxinxiEntity> wrapper);
   	
   	CaipuxinxiVO selectVO(@Param("ew") Wrapper<CaipuxinxiEntity> wrapper);
   	
   	List<CaipuxinxiView> selectListView(Wrapper<CaipuxinxiEntity> wrapper);
   	
   	CaipuxinxiView selectView(@Param("ew") Wrapper<CaipuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CaipuxinxiEntity> wrapper);
   	

}

