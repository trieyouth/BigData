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
	 * 生成数据
	 * @param sc
	 * @param nums
	 * @param dir
	 * @param unameAndTime
	 * @param mode1savePath
	 * @param scopeData
	 * @param partitionNum
	 * @return
	 */
	 public static String[][] runMakedataJobAndGetDoubleArr1(String sc, int nums,
				String dir, String unameAndTime, String mode1savePath,
				String scopeData, int partitionNum){
		 try {
			return getJobResultDoubleArrByJobid1(runMakedataJob1(sc, nums, dir, unameAndTime, mode1savePath, scopeData, partitionNum));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return null;
	 }
	/**
	 * 运行jar1并返回结果数组
	 * 
	 * @param nums
	 *            生成数量
	 * @param dir
	 *            生成记录保持目录
	 * @param unameAndTime
	 *            用户时间戳
	 * @param partitionNum
	 *            计算分区数
	 * @return
	 */
	public static String[] runMakedataJobAndGetResultArr1(String sc, int nums,
			String dir, String unameAndTime, String mode1savePath,
			String scopeData, int partitionNum) {
		try {
			return getJobResultArrByJobid1(runMakedataJob1(sc, nums, dir,
					unameAndTime, mode1savePath, scopeData, partitionNum));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 运行jar1并返回结果
	 * 
	 * @param nums
	 *            生成数量
	 * @param dir
	 *            生成记录保持目录
	 * @param unameAndTime
	 *            用户时间戳
	 * @param partitionNum
	 *            计算分区数
	 * @return
	 */
	public static String runMakedataJobAndGetResult1(String sc, int nums,
			String dir, String unameAndTime, String mode1savePath,
			String scopeData, int partitionNum) {
		try {
			return getJobResult1(runMakedataJob1(sc, nums, dir, unameAndTime,
					mode1savePath, scopeData, partitionNum));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 运行jar1返回jobId
	 * @param sc
	 * @param nums
	 * @param dir
	 * @param unameAndTime
	 * @param mode1savePath
	 * @param scopeData
	 * @param partitionNum
	 * @return
	 * @throws Exception
	 */
	public static String runMakedataJob1(String sc, int nums, String dir,
			String unameAndTime, String mode1savePath, String scopeData,
			int partitionNum) throws Exception {
		String returnstr = null;
		String reqStatement = null;
		if (sc.equals("")) {
			reqStatement = RequestStatement.postmakedata1;
		} else {
			reqStatement = RequestStatement.postmakedata1 + "&context=" + sc;
		}
		Response<String> resp = Requests
				.post(reqStatement)
				.timeout(100_000)
				.data("param=" + String.valueOf(nums) + " " + dir + " "
						+ unameAndTime + " " + mode1savePath + " " + scopeData
						+ " " + String.valueOf(partitionNum)).text();
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
					Thread.sleep(500);
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
	 * 返回结果数组
	 * 
	 * @param jobId
	 * @return
	 */
	public static String[] getJobResultArrByJobid1(String jobId) {
		return getJobResult1(jobId).split("\",\"");
	}

	/**
	 * 返回二维结果数组
	 * 
	 * @param jobId
	 * @return
	 */
	public static String[][] getJobResultDoubleArrByJobid1(String jobId) {
		String[] arr = getJobResultArrByJobid1(jobId);
		String[][] doubleArr = new String[arr.length][];
		for (int i = 0; i < arr.length; i++) {
			doubleArr[i] = arr[i].split(",");
		}
		return doubleArr;
	}

	/**
	 * 运行jar2返回jobId
	 * @param sc
	 * @param nums
	 * @param dir
	 * @param unameAndTime
	 * @param partitionNum
	 * @return
	 * @throws Exception
	 */
	public static String runMakedataJob2(String sc, int nums, String dir,
			String unameAndTime,int partitionNum) throws Exception{
		String returnstr = null;
		String reqStatement = null;
		if (sc.equals("")) {
			reqStatement = RequestStatement.postmakedata2;
		} else {
			reqStatement = RequestStatement.postmakedata2 + "&context=" + sc;
		}
		Response<String> resp = Requests.post(reqStatement).timeout(100_000).data("param=" + String.valueOf(nums) + " " + dir + " "+ unameAndTime + " " + String.valueOf(partitionNum)).text();
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
	 * 有jobId得到返回结果
	 * @param jobId
	 * @return
	 */
	public static String getJobResult2(String jobId){
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
					Thread.sleep(500);
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
	 * 返回结果数组
	 * 
	 * @param jobId
	 * @return
	 */
	public static String[] getJobResultArrByJobid2(String jobId) {
		return getJobResult2(jobId).split("\",\"");
	}

	/**
	 * 返回二维结果数组
	 * 
	 * @param jobId
	 * @return
	 */
	public static String[][] getJobResultDoubleArrByJobid2(String jobId) {
		String[] arr = getJobResultArrByJobid2(jobId);
		String[][] doubleArr = new String[arr.length][];
		for (int i = 0; i < arr.length; i++) {
			doubleArr[i] = arr[i].split("#");
		}
		return doubleArr;
	}
	
	public static String[][] runMakedataJobAndGetDoubleArr2(String sc, int nums,
			String dir, String unameAndTime,int partitionNum){
	 try {
		return getJobResultDoubleArrByJobid2(runMakedataJob2(sc, nums, dir, unameAndTime, partitionNum));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return null;
 }
	

}
