package com.amaserenity.pages;

import java.io.IOException;
import java.time.Duration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.webdriver.WebDriverFacade;


public class TutorialScreen extends PageObject {

//    public TutorialScreen (WebDriver driver) {
//        super(driver);
//    }
//    
   

/*
    @FindBy(id="com.thinkrite.assistant:id/imageView")
    private WebElementFacade coachMark;

    @FindBy(xpath="//android.widget.ImageView[@content-desc=\"Coach mark\"]")
    private WebElementFacade coachMark;
*/

    @FindBy(accessibilityId="CLOSE")
    private WebElementFacade btnClose;
    
    @FindBy(accessibilityId="Coach1")
    private WebElementFacade tutorialScreen;

    public void closeTutorialScreen() throws InterruptedException, IOException {

//        TouchAction swipe = new TouchAction(((AppiumDriver)((WebDriverFacade) getDriver()).getProxiedDriver()));

/*        TouchAction swipe = new TouchAction(getDriver);
        swipe.press(1030, 995);
        swipe.moveTo(19, 991)
        swipe.release();
        swipe.perform();*/


//(new TouchAction(driver))
//  .press({x: 358, y: 349})
//  .moveTo({x: 13: y: 360})
//  .release()
//  .perform()
    	element(tutorialScreen).click();
        TouchAction swipe_coach_mark1 = new TouchAction(((AppiumDriver)((WebDriverFacade) getDriver()).getProxiedDriver()))
                .press(PointOption.point(358,349))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(13, 349))
                .release()
                .perform();

        TouchAction swipe_coach_mark2 = new TouchAction(((AppiumDriver)((WebDriverFacade) getDriver()).getProxiedDriver()))
                .press(PointOption.point(358,349))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(13, 349))
                .release()
                .perform();

/*        (new TouchAction(getDriver()))
                .press({x: 1030, y: 995})
                .moveTo({x: 19: y: 991})
                .release()
                .perform();*/


//        swipeFromRightToLeft();

//        Swipe swipe = new Swipe();
//        swipe.swipeFromRightToLeft(driver);
//        swipe.swipeFromRightToLeft(driver);

        //XCUIElementTypeApplication[@name="AgileMeeting Assistant"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeButton/XCUIElementTypeImage
//    	swipeFromRightToLeft();
//    	getDriver().close();
//    	((AppiumDriver)((WebDriverFacade) getDriver()).getProxiedDriver()).launchApp();
        element(btnClose).click();
//    	Thread.sleep(10000);
    }


    
}