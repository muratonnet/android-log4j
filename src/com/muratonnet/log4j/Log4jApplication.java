package com.muratonnet.log4j;

import android.app.Application;
import android.os.Environment;

public class Log4jApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		// configure log4j
		configureLog4j();
	}

	private void configureLog4j() {

		// set file name
		String fileName = Environment.getExternalStorageDirectory() + "/"
				+ "log4j.log";
		// set log line pattern
		String filePattern = "%d - [%c] - %p : %m%n";
		// set max. number of backed up log files
		int maxBackupSize = 10;
		// set max. size of log file
		long maxFileSize = 1024 * 1024;

		// configure
		Log4jHelper
				.Configure(fileName, filePattern, maxBackupSize, maxFileSize);
	}

}
