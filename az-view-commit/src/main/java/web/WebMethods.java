package web;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import param.PathParam;
import param.WebParam;

import java.util.concurrent.TimeUnit;

public class WebMethods {
    public void Upload(){
        System.getProperties().setProperty("webdriver.chrome.driver", "D:\\Azkaban\\hanrb\\ChromeDriver\\chromedriver.exe");
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("http://localhost:8081/manager?project=azkaban");
        chromeDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        WebElement userNameBox = chromeDriver.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement passWordBox = chromeDriver.findElement(By.xpath("//*[@id=\"password\"]"));
        WebElement loginButton = chromeDriver.findElement(By.xpath("//*[@id=\"login-submit\"]"));

        userNameBox.clear();
        passWordBox.clear();

        userNameBox.sendKeys(WebParam.azkabanUser);
        passWordBox.sendKeys(WebParam.azkabanPasswd);
        loginButton.click();

        WebElement uploadButton = chromeDriver.findElement(By.xpath("//*[@id=\"project-upload-btn\"]"));
        uploadButton.click();

        chromeDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);


        WebElement pathBox=chromeDriver.findElement(By.xpath("//*[@id=\"file\"]"));
        WebElement uploadButton2=chromeDriver.findElement(By.xpath("//*[@id=\"upload-project-btn\"]"));
        pathBox.sendKeys(PathParam.zipPath+PathParam.zipName+".zip");
        uploadButton2.click();

    }
}
