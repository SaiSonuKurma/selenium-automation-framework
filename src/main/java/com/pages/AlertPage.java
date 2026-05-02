package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        driver.findElement(clickmebutton).click();
    }

    public void enterAlertText(String text){
        driver.switchTo().alert().sendKeys(text);
    }

    public void acceptAlert() throws InterruptedException {
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
    }
}
