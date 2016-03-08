package com.pc.utils;

import java.util.regex.Pattern;

/**
 * 
 * @author Switch
 * @function 工具类
 * @description
 *
 */
public class MyTools {
	// 验证数据是否是为整数
	public static boolean checkNum(String data) {
		// 验证
		return Pattern.matches("[0-9]+", data);
	}
	
	
	// 测试
	public static void main(String[] args) {
		if(MyTools.checkNum("123")) {
			System.out.println("ok");
		} else {
			System.out.println("error");
		}
	}
}
