package com.baiduAI.app.util;

/**
 * 存储redis的所有的key, 以key的名称 + _key的类型结尾
 * 如 :string 类型的  key叫 name 则变量名称 为 NAME_STRING
 * 
 */
public class RedisKey {
	
	
	
	/**
	 *  浏览客户数  key+sales_id
	 */
	public static  final String RANDREADSTRING="randRead:";
	

	/**
	 *  名片保存数  key+sales_id
	 */
	public static  final String RANDSAVECARDSTRING="randSaveCard:";
	

	/**
	 *  名片转发数  key+sales_id
	 */
	public static  final String RANDTRANSPONDSTRING="randTranspond:";
	
	/**
	 *  名片跟进数  key+sales_id
	 */
	public static  final String RANDFOLLOWSTRING="randFollowCard:";
	
	/**
	 *  名片点赞数  key+sales_id
	 */
	public static  final String RANDPRAISESTRING="randPraiseCard:";
	
	
}
 