package com.pc.utils;

import java.util.regex.Pattern;

/**
 * 
 * @author Switch
 * @function ������
 * @description
 *
 */
public class MyTools {
	// ��֤�����Ƿ���Ϊ����
	public static boolean checkNum(String data) {
		// ��֤
		return Pattern.matches("[0-9]+", data);
	}
	
	
	// ����
	public static void main(String[] args) {
		if(MyTools.checkNum("123")) {
			System.out.println("ok");
		} else {
			System.out.println("error");
		}
	}
}
