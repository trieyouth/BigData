package com.zero.test;

import com.zero.utils.JobServiceCon;
import com.zero.utils.JobServiceCon;

public class TestJobConn {
	public static void main(String[] args) throws Exception {
		// System.out.println(JobServiceCon.startContextConnectionApp("sc11","sys11"));
		// System.out.println(JobServiceCon.startContextConnectionApp("sc12","sys12"));
		// String
		// [][]arr=JobServiceCon.runMakedataJobAndGetDoubleArr2("sc12",1000,"/tmp/makedata2/admin2016332",
		// "admin2016332", 20);

		// String
		// arr=JobServiceCon.runMakedataJob1("sc11",1000,"/tmp/makedata/admin123456","admin123456","/tmp/modelsave/model","1s100s1s10000s1s10000",40);
		String[][] arr = JobServiceCon.runMakedataJobAndGetDoubleArr1("sc11",
				10000000, "/tmp/makedata/admin123", "admin123",
				"/tmp/modelsave/model", "1s100s1s10000s1s10000", 40);
		// System.out.println(arr);

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " , ");
			}
			System.out.println();
		}

	}
}