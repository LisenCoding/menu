package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.CaipufenleiDao;
import com.entity.CaipufenleiEntity;
import com.service.CaipufenleiService;
import com.entity.vo.CaipufenleiVO;
import com.entity.view.CaipufenleiView;

@Service("caipufenleiService")
public class CaipufenleiServiceImpl extends ServiceImpl<CaipufenleiDao, CaipufenleiEntity> implements CaipufenleiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CaipufenleiEntity> page = this.selectPage(
                new Query<CaipufenleiEntity>(params).getPage(),
                new EntityWrapper<CaipufenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CaipufenleiEntity> wrapper) {
		  Page<CaipufenleiView> page =new Query<CaipufenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<CaipufenleiVO> selectListVO(Wrapper<CaipufenleiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CaipufenleiVO selectVO(Wrapper<CaipufenleiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CaipufenleiView> selectListView(Wrapper<CaipufenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CaipufenleiView selectView(Wrapper<CaipufenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
