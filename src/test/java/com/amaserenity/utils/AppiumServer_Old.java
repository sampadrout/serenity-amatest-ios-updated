/*********************************************************************************************************
* File Name: AppiumServer.java
* Author: Sampad Rout
* Creation Date: 24-Feb-2016
*Description: This class starts and stops the Appium server at the run time.
* Copyright: Thinkrite Inc.
*********************************************************************************************************/

package com.amaserenity.utils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executor;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.ExecuteWatchdog;

public class AppiumServer_Old {

	static Executor appiumProcess;

	public static void startAppiumServer() throws ExecuteException, IOException, Exception {
		try {
			CommandLine command = new CommandLine("/Applications/Appium.app/Contents/Resources/node/bin/node");
			command.addArgument("/Applications/Appium.app/Contents/Resources/node_modules/appium/build/lib/appium.js");
			command.addArgument("--address", true);
			command.addArgument("127.0.0.1");
			command.addArgument("--port", true);
			command.addArgument("4723");
			command.addArgument("--session-override", true);
			command.addArgument("--full-reset", true); // uninstall tra app from the emulator			
			command.addArgument("--device-ready-timeout");
			command.addArgument("180");
			command.addArgument("--log-level");
			command.addArgument("debug"); // make this debug, error:info
			command.addArgument("--log");

			File appiumLogDir = new File(System.getProperty("user.dir") + "/appiumlogs");
			if (!appiumLogDir.exists()) {
				appiumLogDir.mkdir();
			}
			File logFile = new File(appiumLogDir, "appiumLogs.txt");
			if (!logFile.exists()) {
				logFile.createNewFile();
			}
			command.addArgument(System.getProperty("user.dir") + "/appiumlogs/appiumLogs.txt");
			DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
			ExecuteWatchdog watchdog = new ExecuteWatchdog(ExecuteWatchdog.INFINITE_TIMEOUT);
			DefaultExecutor appiumProcess = new DefaultExecutor();
			appiumProcess.setExitValue(1);
			appiumProcess.setWatchdog(watchdog);
			System.out.println("Server start command executing now " + command);
			appiumProcess.execute(command, resultHandler);
		} catch (Exception e) {
			System.out.println("Excption is " + e);
		}
	}

	public static void stopAppiumServer() throws IOException {

		CommandLine command = new CommandLine("killall");
		command.addArgument("node");

		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		System.out.println("Server stop command is executing now " + command);
		executor.execute(command, resultHandler);

		System.out.println("Appium process destroyed successfully");

	}
}
