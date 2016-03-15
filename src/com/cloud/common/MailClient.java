package com.cloud.common;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class MailClient {

	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("smtp.163.com",25);//telnet smtp.163.com 25
		InputStream in = socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));// ���շ������ķ�����Ϣ
		OutputStream out = socket.getOutputStream();//�������������Ϣ
		
		out.write("ehlo wzt\r\n".getBytes());
		System.out.println(br.readLine());
		System.out.println(br.readLine());
		System.out.println(br.readLine());
		System.out.println(br.readLine());
		System.out.println(br.readLine());
		System.out.println(br.readLine());
		System.out.println(br.readLine());
		
		out.write("auth login\r\n".getBytes());
		System.out.println(br.readLine());
		out.write("aXRoZWltYWNsb3Vk\r\n".getBytes());
		System.out.println(br.readLine());
		out.write("aWFtc29ycnk=\r\n".getBytes());
		System.out.println(br.readLine());
		out.write("mail from:<cloud_webtest@163.com>\r\n".getBytes());
		System.out.println(br.readLine());
		out.write("rcpt to:<wltserius@163.com>\r\n".getBytes());
		System.out.println(br.readLine());
		out.write("data\r\n".getBytes());
		System.out.println(br.readLine());
		out.write("from:cloud_webtest@163.com\r\n".getBytes());
		out.write("to:wltserius@163.com\r\n".getBytes());
		out.write("subject:haha\r\n".getBytes());
		out.write("\r\n".getBytes());
		out.write("�ף�����12��Ľ�Ұ�ؼ����ĸ�Ұ�أ������ϴ��ĸ����ƣ��ҵ���Ŷ���ֻ�û�е磬��Ҳ���ûظ��ʼ���ֱ��ȥ���ɣ�������ɢŶ���ס�\r\n".getBytes());
		out.write(".\r\n".getBytes());
		socket.close();// quit
	}

}

