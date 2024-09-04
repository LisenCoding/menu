package com.entity.view;

import com.entity.CaipufenleiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 菜谱分类
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-20 12:07:41
 */
@TableName("caipufenlei")
public class CaipufenleiView  extends CaipufenleiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public CaipufenleiView(){
	}
 
 	public CaipufenleiView(CaipufenleiEntity caipufenleiEntity){
 	try {
			BeanUtils.copyProperties(this, caipufenleiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
