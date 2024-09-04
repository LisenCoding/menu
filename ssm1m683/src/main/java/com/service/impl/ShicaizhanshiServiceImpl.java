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


import com.dao.ShicaizhanshiDao;
import com.entity.ShicaizhanshiEntity;
import com.service.ShicaizhanshiService;
import com.entity.vo.ShicaizhanshiVO;
import com.entity.view.ShicaizhanshiView;

@Service("shicaizhanshiService")
public class ShicaizhanshiServiceImpl extends ServiceImpl<ShicaizhanshiDao, ShicaizhanshiEntity> implements ShicaizhanshiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShicaizhanshiEntity> page = this.selectPage(
                new Query<ShicaizhanshiEntity>(params).getPage(),
                new EntityWrapper<ShicaizhanshiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShicaizhanshiEntity> wrapper) {
		  Page<ShicaizhanshiView> page =new Query<ShicaizhanshiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShicaizhanshiVO> selectListVO(Wrapper<ShicaizhanshiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShicaizhanshiVO selectVO(Wrapper<ShicaizhanshiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShicaizhanshiView> selectListView(Wrapper<ShicaizhanshiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShicaizhanshiView selectView(Wrapper<ShicaizhanshiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
