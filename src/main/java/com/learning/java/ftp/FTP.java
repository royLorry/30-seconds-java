package com.learning.java.ftp;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class FTP {
    public static void main(String[] args) throws Exception {
        //创建FTP客户端，所有的操作都基于FTPClinet
		FTPClient ftp = new FTPClient();
		
		//连接FTP服务器
		ftp.connect("10.103.93.000");
		
		//如果是需要认证的服务器，就需要账号和密码来登录
		ftp.login("aaa", "1234");
		
		//获取服务器返回的状态码
		int reply = ftp.getReplyCode();
		System.out.println(reply);
		
		/*
		 * 判断是否连接成功
		 * 所有以2开头的代码是正完成响应。
		 * FTP服务器将在最终发送一个肯定的完成响应成功完成命令。
		 */
		if (!FTPReply.isPositiveCompletion(reply)) {
			ftp.disconnect();
			System.out.println("连接失败");
			return;
		}
		System.out.println("连接成功");
		ftp.changeWorkingDirectory("/wpc");
		FTPFile[] list = ftp.listFiles();
		for (FTPFile ftpFile : list) {
			System.out.println("name: " + ftpFile.getName());
			// System.out.println("group: " + ftpFile.getGroup());
			// System.out.println("RwaListing: " + ftpFile.getRawListing());
			// System.out.println("size: " + ftpFile.getSize());
			// System.out.println("type: " + ftpFile.getType());
			// System.out.println("user: " + ftpFile.getUser());
			// System.out.println("timestamp: " + ftpFile.getTimestamp());
			// System.out.println("class: " + ftpFile.getClass());
		}
    }
}