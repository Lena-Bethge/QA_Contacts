package com.telran.contacts.fw;

import com.telran.contacts.models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class UserHelper extends HelperBase {

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void registration() {
        click(By.xpath("//a[contains(.,'LOGIN')]"));
        //   Assert.assertTrue(isElementPresent(By.cssSelector(".login_login__3EHKB")));
        //fill registration form
        fillLoginRegistrationForm(new User().setEmail("lusylee@gmail.com").setPassword("Lusy_0987654"));
        //click on the button Registration
        click(By.xpath("//button[contains(.,'Registration')]"));

    }

    public void registrationNegative() {
        click(By.xpath("//a[contains(.,'LOGIN')]"));
        Assert.assertTrue(isElementPresent(By.cssSelector(".login_login__3EHKB")));
        //fill registration form
        fillLoginRegistrationForm(new User().setEmail("@mail").setPassword("Lusy_0987654"));
        //click on the button Registration
        click(By.xpath("//button[contains(.,'Registration')]"));
    }

    public void fillLoginRegistrationForm(User user) {
        type(By.cssSelector("[placeholder='Email']"), user.getEmail());
        type(By.cssSelector("[placeholder='Password']"), user.getPassword());
    }

    public void login() {
        click(By.xpath("//a[contains(.,'LOGIN')]"));
        fillLoginRegistrationForm(new User().setEmail("lusylee@gmail.com").setPassword("Lusy_0987654"));
        click(By.xpath("//button[contains(.,'Login')]"));

    }
    public void clickOnLoginTab() {
        click(By.xpath("//a[contains(.,'LOGIN')]"));
    }


    public boolean isErrorPresent() {
        return isElementPresent(By.xpath("//div[.='Login Failed with code 400']"));
    }

    public void clickOnLoginButton() {
        click(By.xpath("//button[contains(.,'Login')]"));
    }

}