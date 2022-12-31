package com.e2e.steps;

import com.e2e.utils.DriverUtil;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @AfterStep
    public static void AfterStep(Scenario scenario){
        if(scenario.isFailed()){
            TakesScreenshot ss = (TakesScreenshot)DriverUtil.getDriver();
            scenario.attach(ss.getScreenshotAs(OutputType.BYTES),"image/png","");
        }
    }

    @After
    public static void tearDown() {
        new DriverUtil().tearDown();
    }
}
