package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ShicaizhanshiEntity;
import com.entity.view.ShicaizhanshiView;

import com.service.ShicaizhanshiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 食材展示
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-20 12:07:41
 */
@RestController
@RequestMapping("/shicaizhanshi")
public class ShicaizhanshiController {
    @Autowired
    private ShicaizhanshiService shicaizhanshiService;


    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShicaizhanshiEntity shicaizhanshi, 
		HttpServletRequest request){

        EntityWrapper<ShicaizhanshiEntity> ew = new EntityWrapper<ShicaizhanshiEntity>();
		PageUtils page = shicaizhanshiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shicaizhanshi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShicaizhanshiEntity shicaizhanshi, 
		HttpServletRequest request){
        EntityWrapper<ShicaizhanshiEntity> ew = new EntityWrapper<ShicaizhanshiEntity>();
		PageUtils page = shicaizhanshiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shicaizhanshi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShicaizhanshiEntity shicaizhanshi){
       	EntityWrapper<ShicaizhanshiEntity> ew = new EntityWrapper<ShicaizhanshiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shicaizhanshi, "shicaizhanshi")); 
        return R.ok().put("data", shicaizhanshiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShicaizhanshiEntity shicaizhanshi){
        EntityWrapper< ShicaizhanshiEntity> ew = new EntityWrapper< ShicaizhanshiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shicaizhanshi, "shicaizhanshi")); 
		ShicaizhanshiView shicaizhanshiView =  shicaizhanshiService.selectView(ew);
		return R.ok("查询食材展示成功").put("data", shicaizhanshiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShicaizhanshiEntity shicaizhanshi = shicaizhanshiService.selectById(id);
        return R.ok().put("data", shicaizhanshi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShicaizhanshiEntity shicaizhanshi = shicaizhanshiService.selectById(id);
        return R.ok().put("data", shicaizhanshi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShicaizhanshiEntity shicaizhanshi, HttpServletRequest request){
    	shicaizhanshi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shicaizhanshi);

        shicaizhanshiService.insert(shicaizhanshi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShicaizhanshiEntity shicaizhanshi, HttpServletRequest request){
    	shicaizhanshi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shicaizhanshi);

        shicaizhanshiService.insert(shicaizhanshi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ShicaizhanshiEntity shicaizhanshi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shicaizhanshi);
        shicaizhanshiService.updateById(shicaizhanshi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shicaizhanshiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<ShicaizhanshiEntity> wrapper = new EntityWrapper<ShicaizhanshiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = shicaizhanshiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
