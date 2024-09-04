package com.entity.vo;

import com.entity.ShicaizhanshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 食材展示
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2024-03-20 12:07:41
 */
public class ShicaizhanshiVO  implements Serializable {
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
