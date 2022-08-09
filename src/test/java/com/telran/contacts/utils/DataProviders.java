package com.telran.contacts.utils;

import com.telran.contacts.models.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

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
    @DataProvider
    public Iterator<Object[]> addNewContactNegative() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"lusy@gmail.com", "1a!"});
        list.add(new Object[]{"lusy+1@gmail.com", "2a!"});
        list.add(new Object[]{"lusy+2@gmail.com", "3a!"});
        return list.iterator();

    }

}
