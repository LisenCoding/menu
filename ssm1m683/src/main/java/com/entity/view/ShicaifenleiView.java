package com.entity.view;

import com.entity.ShicaifenleiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 食材分类
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-20 12:07:41
 */
@TableName("shicaifenlei")
public class ShicaifenleiView  extends ShicaifenleiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShicaifenleiView(){
	}
 
 	public ShicaifenleiView(ShicaifenleiEntity shicaifenleiEntity){
 	try {
			BeanUtils.copyProperties(this, shicaifenleiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
