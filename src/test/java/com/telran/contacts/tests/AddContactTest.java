package com.telran.contacts.tests;

import com.telran.contacts.models.Contact;
import com.telran.contacts.tests.TestBase;
import com.telran.contacts.utils.DataProviders;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.xml.crypto.Data;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class AddContactTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions()
    {
        if(!app.getHeader().isLoginLinkPresent()){
            app.getUser().click(By.xpath("//button[contains(.,'Sign Out')]"));
        }else {
            app.getUser().login();
        }
    }

    @Test
    public void addContactPositiveTest(){
        app.getContact().addContact();
        Assert.assertTrue(app.getContact().isContactCreated("Lusy"));
    }




    @Test(dataProvider = "addNewContactFromCSV", dataProviderClass = DataProviders.class)
    public void addContactPositiveTestFromDataProvider(Contact contact) {
        app.getContact().click(By.xpath("//a[contains(text(),'ADD')]"));
        app.getContact().fillContactForm(contact);
        app.getContact().clickWithAction(By.cssSelector(".add_form__2rsm2 button"));

    }

    @AfterMethod
    public void postCondition(){
        app.getContact().removeContact();
    }


}
