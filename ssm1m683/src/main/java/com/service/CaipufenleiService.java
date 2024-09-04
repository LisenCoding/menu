package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CaipufenleiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.CaipufenleiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CaipufenleiView;


/**
 * 菜谱分类
 *
 * @author 
 * @email 
 * @date 2024-03-20 12:07:41
 */
public interface CaipufenleiService extends IService<CaipufenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CaipufenleiVO> selectListVO(Wrapper<CaipufenleiEntity> wrapper);
   	
   	CaipufenleiVO selectVO(@Param("ew") Wrapper<CaipufenleiEntity> wrapper);
   	
   	List<CaipufenleiView> selectListView(Wrapper<CaipufenleiEntity> wrapper);
   	
   	CaipufenleiView selectView(@Param("ew") Wrapper<CaipufenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CaipufenleiEntity> wrapper);
   	

}

