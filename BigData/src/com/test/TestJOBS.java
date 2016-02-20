package com.test;

import net.dongliu.requests.Requests;
import net.dongliu.requests.Response;

public class TestJOBS {

	public static void main(String[] args) {
		
		//String postonejar = "http://172.23.27.190:8090/jobs?appName=testst5&classPath=spark.jobserver.ProduceData&context=stsc1";
		//String postonejar = "http://172.23.27.190:8090/jobs?appName=testst5&classPath=spark.jobserver.ProduceData";
		
		String postonejar = "http://172.23.27.190:8090/jobs?appName=mts1&classPath=spark.jobserver.ModelTrainJob&context=mtssc1";
		//String postonejar = "http://172.23.27.190:8090/jobs?appName=mts1&classPath=spark.jobserver.ModelTrainJob";
		
		
		
		//String postonejar = "http://172.23.27.190:8090/jobs?appName=ss5&classPath=spark.jobserver.SparkStreamingJob&context=sssc1";
		
		String getonejarinfo = "http://172.23.27.190:8090/jobs/44935a58-1939-42f0-b3da-15f17bd4c896";
		//Response<String> resp = Requests.post(postonejar).timeout(1000_000).data("param=10000 1 20151205 mytopic 100").text();
		//Response<String> resp = Requests.post(postonejar).timeout(1000_000).data("param=/user/zhaorui/streamimg/traindata/t /user/zhaorui/streamimg/traindata/f GBDT /user/zhaorui/streamimg/modelsavedir/test6").text();
		//Response<String> resp = Requests.post(postonejar).timeout(1000_000).data("param=mytopic 1 LR /user/zhaorui/streamimg/trainModel/LogisticRegression /root/Documents/zr/streamingdataout/zong.txt /root/Documents/zr/streamingdataout/1.txt /root/Documents/zr/streamingdataout/2.txt /root/Documents/zr/streamingdataout/3.txt /root/Documents/zr/streamingdataout/feature.txt /root/Documents/zr/streamingdataout/model.txt 3 1 1").text();
		Response<String> resp=Requests.get(getonejarinfo).timeout(100_000).text();
		System.out.println(resp.getBody());
	}

}
