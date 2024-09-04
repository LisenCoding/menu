package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShicaifenleiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShicaifenleiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShicaifenleiView;


/**
 * 食材分类
 *
 * @author 
 * @email 
 * @date 2024-03-20 12:07:41
 */
public interface ShicaifenleiService extends IService<ShicaifenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShicaifenleiVO> selectListVO(Wrapper<ShicaifenleiEntity> wrapper);
   	
   	ShicaifenleiVO selectVO(@Param("ew") Wrapper<ShicaifenleiEntity> wrapper);
   	
   	List<ShicaifenleiView> selectListView(Wrapper<ShicaifenleiEntity> wrapper);
   	
   	ShicaifenleiView selectView(@Param("ew") Wrapper<ShicaifenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShicaifenleiEntity> wrapper);
   	

}

