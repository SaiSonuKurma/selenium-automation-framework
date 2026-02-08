package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BookStorePage {

    private WebDriver driver;
    //loctors
    private By books = By.xpath("//div[@class='rt-tr-group']");
    private By search = By.xpath("//input[@id='searchBox']");
    private By author = By.xpath("//div[text()='Eric Elliott']");
    private By bookstore = By.xpath("//span[text()='Book Store']");


    //constructor

    public BookStorePage(WebDriver driver){
        this.driver=driver;
    }
    //page actions
    public String bookstorepagetitle(){
        return driver.getTitle();
    }
    public List<WebElement> getthebookscount(){
        return driver.findElements(books);
    }
    public void enterbookname(String bookname){
        driver.findElement(search).sendKeys(bookname);
    }
    public void findbookauthor(){
        driver.findElement(author);
    }
    public void bookstoreicon(){
        driver.findElement(bookstore).click();
    }

}
