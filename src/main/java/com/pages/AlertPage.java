package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertPage {
    private WebDriver driver;

    private By AlertFrameWindow = By.xpath("(//div[@class='header-text'])[3]");
    private By Alert = By.xpath("//span[text()='Alerts']");
    private By clickmebutton = By.id("promtButton");

    public AlertPage(WebDriver driver){
        this.driver=driver;
    }

    public void clickAlertFrameWindow(){
        driver.findElement(AlertFrameWindow).click();
    }

    public void clickAlert(){
        driver.findElement(Alert).click();
    }

    public void clickclickmebutton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(clickmebutton));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(clickmebutton));
    }

    public void enterAlertText(String text){
        driver.switchTo().alert().sendKeys(text);
    }

    public void acceptAlert() throws InterruptedException {
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
    }
}
