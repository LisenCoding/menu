package com.entity.model;

import com.entity.CaipuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 菜谱信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-03-20 12:07:41
 */
public class CaipuxinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 口味
	 */
	
	private String kouwei;
		
	/**
	 * 菜谱分类
	 */
	
	private String caipufenlei;
		
	/**
	 * 适合人群
	 */
	
	private String shiherenqun;
		
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 食材
	 */
	
	private String shicai;
		
	/**
	 * 热量
	 */
	
	private String yingyang;
		
	/**
	 * 制作步骤
	 */
	
	private String zhizuobuzhou;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
		
	/**
	 * 点击次数
	 */
	
	private Integer clicknum;
				
	
	/**
	 * 设置：口味
	 */
	 
	public void setKouwei(String kouwei) {
		this.kouwei = kouwei;
	}
	
	/**
	 * 获取：口味
	 */
	public String getKouwei() {
		return kouwei;
	}
				
	
	/**
	 * 设置：菜谱分类
	 */
	 
	public void setCaipufenlei(String caipufenlei) {
		this.caipufenlei = caipufenlei;
	}
	
	/**
	 * 获取：菜谱分类
	 */
	public String getCaipufenlei() {
		return caipufenlei;
	}
				
	
	/**
	 * 设置：适合人群
	 */
	 
	public void setShiherenqun(String shiherenqun) {
		this.shiherenqun = shiherenqun;
	}
	
	/**
	 * 获取：适合人群
	 */
	public String getShiherenqun() {
		return shiherenqun;
	}
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
				
	
	/**
	 * 设置：食材
	 */
	 
	public void setShicai(String shicai) {
		this.shicai = shicai;
	}
	
	/**
	 * 获取：食材
	 */
	public String getShicai() {
		return shicai;
	}
				
	
	/**
	 * 设置：热量
	 */
	 
	public void setYingyang(String yingyang) {
		this.yingyang = yingyang;
	}
	
	/**
	 * 获取：热量
	 */
	public String getYingyang() {
		return yingyang;
	}
				
	
	/**
	 * 设置：制作步骤
	 */
	 
	public void setZhizuobuzhou(String zhizuobuzhou) {
		this.zhizuobuzhou = zhizuobuzhou;
	}
	
	/**
	 * 获取：制作步骤
	 */
	public String getZhizuobuzhou() {
		return zhizuobuzhou;
	}
				
	
	/**
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
				
	
	/**
	 * 设置：点击次数
	 */
	 
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}
			
}
