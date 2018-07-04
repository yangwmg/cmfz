package com.baizhi.cmfz.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.DigestUtils;

public class EncryptionUtil {

	public static String encryption(String str) throws NoSuchAlgorithmException{

		MessageDigest md = MessageDigest.getInstance("MD5");
		
		byte[] code = md.digest(str.getBytes());
		
		StringBuilder builder = new StringBuilder();
		
		for(byte b : code){
			//1.��ÿ���ֽ�ת��Ϊ�޷�������������
			int c = b & 0xFF;
			
			if(c < 16){
				//2.���16���µ����֣�ת��ʮ�����ƺ󣬲���2λ������׷��0��Ϊǰ׺
				builder.append("0");
			}
			//3.�����ֽ�ת��Ϊʮ�������ַ���������ƴ��
			builder.append(Integer.toHexString(c));
		}
		return builder.toString();
	}

	public static String encryptionCode(String str){
		return DigestUtils.md5Hex(str);
	}
}
