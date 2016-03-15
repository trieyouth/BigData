package com.zero.utils;

import java.io.File;
import java.io.IOException;
import org.springframework.stereotype.Service;
import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;


@Service
public class FileUpLoadUtil {
	
	private final String hostname = "";
    private final String username = "";
    private final String password = ""; 
    
	
	public FileUpLoadUtil(){
	
	}
	
	public void syncMoveFileToHDFS(final File file){
		new Thread(new Runnable() {
			@Override
			public void run() {
				moveFileToHDFS(file);
			}
		}).start();
	}
	
	
	private synchronized void moveFileToHDFS(final File file){
	       Session ssh = null;
	       try {
	 			Connection conn = new Connection(hostname);
	 			conn.connect();
	 			boolean isconn = conn.authenticateWithPassword(username, password);
	 			if (!isconn) {
	 				System.out.println("连不起");
	 			} else {
	 				System.out.println("ok");
	 				ssh = conn.openSession();
	 				ssh.execCommand("hdfs dfs -put Documents/tomcat/webapps/BigData/WEB-INF/tmp/upData/" +file.getName()+" /tmp/");
	 			}
	 			ssh.close();
	 			conn.close();
	 			System.out.println("close");
	 			file.delete();
	 		} catch (IOException e) {
	 			e.printStackTrace();
	 		}
	}
}
