package com.ctgu.utils;

import java.util.UUID;

/**
 * 
 * @title UUIDUtils.java
 * @description 生成随机字符串的工具类
 * @author 王桂林
 * @date 2017年12月15日 下午10:25:11
 *
 */

public class UUIDUtils {
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");  //32位的随机字符串
	}
}
