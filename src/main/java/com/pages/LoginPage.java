package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By UserName = By.id("userName");
    private By password = By.id("password");
    private By loginInButton = By.id("login");
    private By newuserbutton = By.id("newUser");

    //constructor
    public LoginPage(WebDriver driver){

        this.driver=driver;
    }

    //page actions
    public String getLoginPageTitle(){
        return driver.getTitle();
    }

    public boolean isNewUserButtonExists(){
        return driver.findElement(newuserbutton).isDisplayed();
    }

    public void enterusername(String username){
        driver.findElement(UserName).sendKeys(username);
    }
    public void enterpassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }
    public void clickSignInButton(){
        driver.findElement(loginInButton).click();
    }
}
