package com.iweigame.logcat.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.util.Log;
/**
 * 
* @ClassName: LogCatUtil
* @Description: 记录Logcat日志到sd卡中文件 
* @author:大辉
* @date 2011-12-1 下午01:45:56
*
 */
public class LogCatUtil {

	/**
	 * 文件名称，前缀即可.文件默认格式是txt
	 */
	String logFileName;
	/**
	 * 日志的名字
	 */
	String tagName;
	/**
	 * 日志记录级别
	 */
	String logLevel;

	/**
	 * 
	 * @Title:
	 * @Description: (初始化LogUtil)
	 * @param @param logFileName 文件名称，前缀即可.文件默认格式是txt
	 * @param @param tagName 日志的名字
	 * @param @param logLevel 日志记录级别,例如DEBUG级别直接写“D”
	 */
	public LogCatUtil(String logFileName, String tagName, String logLevel) {
		super();
		if (logFileName == null || logFileName.equals("")) {
			this.logFileName = "logfile";
		} else {
			this.logFileName = logFileName;
		}

		this.tagName = tagName;
		this.logLevel = logLevel;
	}

	/**
	 * 
	 * @Title: writeLogToFile
	 * @Description: 向SD卡中写入日志信息
	 * @author 大辉 jiessiedyh@gmail.com
	 * @date 2011-11-30
	 * @return void
	 * @throws
	 */
	public void writeLogToFile() {

		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				Process process;
				InputStream inputstream;
				BufferedReader bufferedreader;
				try {
					// -s "+ tagName +":"+logLevel+"
					if (tagName != null && !tagName.equals("")
							&& logLevel != null && !logLevel.equals("")) {

						process = Runtime.getRuntime().exec(
								" logcat  -v time  -f /mnt/sdcard/"
										+ logFileName + ".txt" + " -s  "
										+ tagName + ":" + logLevel
										+ " System.err  AndroidRuntime");

					} else {
						if (logLevel == null || logLevel.equals("")) {
							if (tagName != null && !tagName.equals("")) {
								process = Runtime
										.getRuntime()
										.exec("logcat  -v time  -f /mnt/sdcard/"
												+ logFileName
												+ ".txt"
												+ " -s  "
												+ tagName
												+ "  System.err AndroidRuntime");
							} else {
								process = Runtime
										.getRuntime()
										.exec("logcat  -v time  -f /mnt/sdcard/"
												+ logFileName
												+ ".txt"
												+ " -s System.err AndroidRuntime");
							}
						}

					}
				} catch (Exception e) {
					Log.e("logutil", "logutil error and error message is :" + e);
				}
			}
		}).start();

	}
}
