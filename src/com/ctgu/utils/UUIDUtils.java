package com.ctgu.utils;

import java.util.UUID;

/**
 * 
 * @title UUIDUtils.java
 * @description ��������ַ����Ĺ�����
 * @author ������
 * @date 2017��12��15�� ����10:25:11
 *
 */

public class UUIDUtils {
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");  //32λ������ַ���
	}
}
