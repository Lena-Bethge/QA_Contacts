package com.telran.contacts.tests;

import com.telran.contacts.models.Contact;
import com.telran.contacts.tests.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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


        @DataProvider
    public Iterator<Object[]> addNewContact() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Lusy","Lee","1234567890","kan@gm.com","Berlin","goalkiper"});
        list.add(new Object[]{"Lusy","Lee","123454321","kan+1@gm.com","Berlin","goalkiper"});
        list.add(new Object[]{"Lusy","Lee","0987654321","kan+2@gm.com","Berlin","goalkiper"});
        return list.iterator();

    }
    @DataProvider
    public Iterator<Object[]> addNewContactFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/Contacts.csv")));

        String line = reader.readLine();

        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new Contact().setName(split[0])
                    .setSureName(split[1])
                    .setPhone(split[2])
                    .setEmail(split[3])
                    .setAddress(split[4])
                    .setDiscription(split[5])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @Test(dataProvider = "addNewContactFromCSV")
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
