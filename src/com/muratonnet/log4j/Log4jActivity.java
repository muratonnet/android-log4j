package com.muratonnet.log4j;

import org.apache.log4j.Logger;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Log4jActivity extends Activity {

	private Logger mLog;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// create logger
		mLog = Logger.getLogger("Log4jActivity");

		// get button
		Button logMeButton = (Button) findViewById(R.id.logMeButton);
		// set on click event of button
		logMeButton.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				logMe();
			}
		});
	}
	
	private void logMe() {
		// write some logs
		mLog.error("This is an error");
		mLog.info("This is an info");
		mLog.warn("This is a warn");

		// write some exception
		try {
			String dummyString = null;
			if (dummyString.equals("something")) {
				int dummyInt = 1;
			}
		} catch (Exception ex) {
			// NullPointerException :)
			mLog.error(ex.toString(), ex);
		}

	}

}
