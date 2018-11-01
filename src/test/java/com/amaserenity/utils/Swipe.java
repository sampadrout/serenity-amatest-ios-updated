package com.amaserenity.utils;

import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.core.pages.PageObject;

import net.thucydides.core.webdriver.WebDriverFacade;

import org.openqa.selenium.Dimension;

import java.io.IOException;

public class Swipe extends PageObject {

    public void swipeFromLeftToRight(AndroidDriver driver) throws InterruptedException, IOException {
//        Dimension size = ((AndroidDriver)((WebDriverFacade) getDriver()).getProxiedDriver()).manage().window().getSize();
        Dimension size = getDriver().manage().window().getSize();
        int startx = (int) (size.width * 0.70);
        int endx = (int) (size.width * 0.30);
        int starty = size.height / 2;
        String adbCommandForSwipe = "cmd /c adb shell input touchscreen swipe" + endx + "" + starty + "" + startx + "" + starty + " 100";
        Runtime.getRuntime().exec(adbCommandForSwipe);
        Thread.sleep(2000);
    }

    public void swipeFromRightToLeft(AndroidDriver driver) throws InterruptedException, IOException {
//        Dimension size = ((AndroidDriver)((WebDriverFacade) getDriver()).getProxiedDriver()).manage().window().getSize();
        Dimension size = getDriver().manage().window().getSize();
        int startx = (int) (size.width * 0.70);
        int endx = (int) (size.width * 0.30);
        int starty = size.height / 2;
        String adbCommandForSwipe = "cmd /c adb shell input touchscreen swipe" + startx + "" + starty + "" + endx + "" + starty + " 100";
        Runtime.getRuntime().exec(adbCommandForSwipe);
        Thread.sleep(2000);
    }

    public void swipeFromBottomToTop(AndroidDriver driver) throws InterruptedException, IOException {
//        Dimension size = ((AndroidDriver)((WebDriverFacade) getDriver()).getProxiedDriver()).manage().window().getSize();
        Dimension size = getDriver().manage().window().getSize();
        int starty = (int) (size.height * 0.80);
        int endy = (int) (size.height * 0.20);
        int startx = size.width / 2;
        String adbCommandForSwipe = "cmd /c adb shell input touchscreen swipe" + startx + "" + starty + "" + startx + "" + endy + " 100";
        Runtime.getRuntime().exec(adbCommandForSwipe);
        Thread.sleep(2000);
    }

    public void swipeFromTopToBottom(AndroidDriver driver) throws InterruptedException, IOException {
//        Dimension size = ((AndroidDriver)((WebDriverFacade) getDriver()).getProxiedDriver()).manage().window().getSize();
        Dimension size = getDriver().manage().window().getSize();
        int starty = (int) (size.height * 0.80);
        int endy = (int) (size.height * 0.20);
        int startx = size.width / 2;
        String adbCommandForSwipe = "cmd /c adb shell input touchscreen swipe" + startx + "" + endy + "" + startx + "" + starty + " 100";
        Runtime.getRuntime().exec(adbCommandForSwipe);
        Thread.sleep(2000);
    }


}
