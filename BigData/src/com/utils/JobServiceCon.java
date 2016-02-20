package com.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import net.dongliu.requests.Requests;
import net.dongliu.requests.Response;
import net.dongliu.requests.exception.RequestException;

import org.json.JSONException;
import org.json.JSONObject;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

import com.utils.RequestStatement;

/**
 * 
 * @author WangHong
 * 
 */
public class JobServiceCon {
	/**
	 * 有jobId得到返回结果
	 * 
	 * @param jobId
	 * @return
	 */
	public static String getJobResult1(String jobId) {
		String returnstr = null;
		Response<String> resp = null;
		JSONObject object = null;
		resp = Requests.get(RequestStatement.getalljarinfo + "/" + jobId)
				.timeout(100_000).text();
		try {
			object = new JSONObject(resp.getBody());
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		try {
			while (object.getString("status").equals("RUNNING")) {
				resp = Requests
						.get(RequestStatement.getalljarinfo + "/" + jobId)
						.timeout(100_000).text();
				object = new JSONObject(resp.getBody());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			returnstr = object.getString("result");

		} catch (RequestException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		returnstr = returnstr.substring(2, returnstr.length() - 2);
		return returnstr;
	}

	/**
	 * 有jobId得到job运行状态
	 * 
	 * @param jobId
	 * @return
	 */
	public static String getJobStatus(String jobId) {
		String returnstr = null;
		Response<String> resp = null;
		JSONObject object = null;
		resp = Requests.get(RequestStatement.getalljarinfo + "/" + jobId)
				.timeout(100_000).text();
		try {
			object = new JSONObject(resp.getBody());
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		try {
			returnstr = object.getString("status");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnstr;
	}

	/**
	 * 运行一个jar返回ID
	 * 
	 * @param AppName
	 *            应用名
	 * @param classPath
	 *            主类路径
	 * @param scName
	 *            context名
	 * @param arguments
	 *            参数数组
	 * @return
	 * @throws Exception
	 */
	public static String runJobGetID(String AppName, String classPath,
			String scName, String[] arguments) throws Exception {
		String returnstr = null;
		// 拼接请求语句
		String reqSta = RequestStatement.postjar + "appName=" + AppName
				+ "&classPath=" + classPath;
		if (scName == null || scName.equals("")) {
			System.out.println("sc is null or empty");
		} else {
			reqSta += "&context=" + scName;
		}
		// 拼接数据
		String dataSta = "param=";
		for (int i = 0; i < arguments.length; i++) {
			dataSta += arguments[i] + " ";
		}
		dataSta = dataSta.substring(0, dataSta.length() - 1);
		// 发起请求得到结果
		Response<String> resp = Requests.post(reqSta).timeout(100_000)
				.data(dataSta).text();
		JSONObject object = null;
		try {
			object = new JSONObject(resp.getBody());
			if (!object.getString("status").equals("STARTED"))
				throw new Exception("数据生成时运行jar包失败");
			returnstr = object.getJSONObject("result").getString("jobId");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return returnstr;
	}

	/**
	 * 删除指定的context
	 * 
	 * @param sc
	 *            context名
	 */
	public static boolean delSC(String sc) {
		Response<String> resp = Requests
				.delete(RequestStatement.urlAndPort + "/contexts/" + sc)
				.timeout(1000000).text();
		if (resp.getBody().equals("OK")) {
			System.out.println("OK");
			return true;
		} else {
			String ss = resp.getBody();
			try {
				JSONObject object = new JSONObject(ss);
				System.out.println("ERROR" + ":" + object.getString("result"));
			} catch (JSONException e) {
				e.printStackTrace();

			}
			return false;

		}
	}

	/**
	 * 启动一个指定名字的context,这个context与指定的jar关联
	 * @param conTextName
	 * @param jarName
	 * @return
	 */
	public static String startContextConnectionApp(String conTextName,String jarName){
		return Requests.post("http://172.23.27.190:8090/contexts/"+conTextName+"?dependent-jar-uris=file:///172.23.27.190:8090/jars/"+jarName).timeout(100_000).text().getBody();
	}
	/**
	 * 重启jobServer
	 * @throws InterruptedException 
	 */
	public static void restartJobs(String cmd) throws InterruptedException{
		String hostname = "172.23.27.190";
		String username = "root";
		String password = "111111";
		Session ssh = null;
		try {
			Connection conn = new Connection(hostname);
			conn.connect();
			boolean isconn = conn.authenticateWithPassword(username, password);

			if (!isconn) {
				System.out.println("用户名称或者是密码不正确");
			} else {
				System.out.println("已经连接OK");
				ssh = conn.openSession();
				// 使用多个命令用分号隔开
				// ssh.execCommand("pwd;cd /tmp;mkdir hb;ls;ps -ef|grep weblogic");
				// ssh.execCommand("cd /app/weblogic/Oracle/Middleware/user_projects/domains/base_domain;./startWebLogic.sh &");
				// 只允许使用一行命令，即ssh对象只能使用一次execCommand这个方法，多次使用则会出现异常
				ssh.execCommand(cmd);
				// 将屏幕上的文字全部打印出来
				InputStream is = new StreamGobbler(ssh.getStdout());
				BufferedReader brs = new BufferedReader(new InputStreamReader(
						is));
				Thread.sleep(10000);
				/*while (true) {
					System.out.println("ssssss");
					String line = brs.readLine();
					if (line == null) {
						break;
					}
					System.out.println(line);
				}*/
           
			}
			// 连接的Session和Connection对象都需要关闭
			ssh.close();
			conn.close();
			System.out.println("yy");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//cd /root/Documents/job;sh server_stop.sh;cd /root/Documents/job;sh server_start.sh
	/**
	 * 启动系统默认sc
	 */
	public static void startsc(){
		System.out.println("ss");
		System.out.println(JobServiceCon.startContextConnectionApp("stsc1", "testst5"));
		System.out.println(JobServiceCon.startContextConnectionApp("mtssc1", "mts1"));
		System.out.println(JobServiceCon.startContextConnectionApp("sssc1", "ss5"));
	}
	/**
	 * 重启服务
	 * @throws InterruptedException 
	 */
	public static void restart() throws InterruptedException{
		restartJobs("cd /root/Documents/job;sh server_stop.sh");
		restartJobs("cd /root/Documents/job;sh server_start.sh");
		startsc();
	}
	public static void main(String[] args) throws Exception {
		restart();
		
	}
}
