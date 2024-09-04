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


import com.dao.ShicaifenleiDao;
import com.entity.ShicaifenleiEntity;
import com.service.ShicaifenleiService;
import com.entity.vo.ShicaifenleiVO;
import com.entity.view.ShicaifenleiView;

@Service("shicaifenleiService")
public class ShicaifenleiServiceImpl extends ServiceImpl<ShicaifenleiDao, ShicaifenleiEntity> implements ShicaifenleiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShicaifenleiEntity> page = this.selectPage(
                new Query<ShicaifenleiEntity>(params).getPage(),
                new EntityWrapper<ShicaifenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShicaifenleiEntity> wrapper) {
		  Page<ShicaifenleiView> page =new Query<ShicaifenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShicaifenleiVO> selectListVO(Wrapper<ShicaifenleiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShicaifenleiVO selectVO(Wrapper<ShicaifenleiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShicaifenleiView> selectListView(Wrapper<ShicaifenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShicaifenleiView selectView(Wrapper<ShicaifenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
