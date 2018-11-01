package com.amaserenity.utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

//import static com.serenity.appium.poc.Property.*;
import static io.appium.java_client.service.local.AppiumDriverLocalService.buildService;

import java.io.File;
import java.io.IOException;

public final class AppiumServer {
	private final static AppiumDriverLocalService service;

	static {
		service = buildService(new AppiumServiceBuilder()
				.withIPAddress("127.0.0.1")
				.usingPort(Integer.parseInt("4723"))
				.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
				.withArgument(GeneralServerFlag.SESSION_OVERRIDE)
				.withArgument(GeneralServerFlag.LOG_LEVEL, "info"));
	}
	
	public static void startAppiumServer() {
		try{
			service.start();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void stopAppiumServer() throws IOException {
		try{
			if (service.isRunning()) {
				service.stop();
			}
		}catch(Exception e){
			e.printStackTrace();
			Runtime.getRuntime().exec("killall node");
		}
	}
}

