package com.entity.model;

import com.entity.ShicaizhanshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 食材展示
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-03-20 12:07:41
 */
public class ShicaizhanshiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 食材分类
	 */
	
	private String shicaifenlei;
		
	/**
	 * 食材图片
	 */
	
	private String shicaitupian;
		
	/**
	 * 食材功效
	 */
	
	private String shicaigongxiao;
		
	/**
	 * 食材介绍
	 */
	
	private String shicaijieshao;
				
	
	/**
	 * 设置：食材分类
	 */
	 
	public void setShicaifenlei(String shicaifenlei) {
		this.shicaifenlei = shicaifenlei;
	}
	
	/**
	 * 获取：食材分类
	 */
	public String getShicaifenlei() {
		return shicaifenlei;
	}
				
	
	/**
	 * 设置：食材图片
	 */
	 
	public void setShicaitupian(String shicaitupian) {
		this.shicaitupian = shicaitupian;
	}
	
	/**
	 * 获取：食材图片
	 */
	public String getShicaitupian() {
		return shicaitupian;
	}
				
	
	/**
	 * 设置：食材功效
	 */
	 
	public void setShicaigongxiao(String shicaigongxiao) {
		this.shicaigongxiao = shicaigongxiao;
	}
	
	/**
	 * 获取：食材功效
	 */
	public String getShicaigongxiao() {
		return shicaigongxiao;
	}
				
	
	/**
	 * 设置：食材介绍
	 */
	 
	public void setShicaijieshao(String shicaijieshao) {
		this.shicaijieshao = shicaijieshao;
	}
	
	/**
	 * 获取：食材介绍
	 */
	public String getShicaijieshao() {
		return shicaijieshao;
	}
			
}
