package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactInfoTests extends TestBase{

    @Test
    void testPhones() {
        var contacts = app.hbm().getPhoneNumberList();
          //сделать предусловие по провкерке существования контакта
        var contact = contacts.get(0);
        var phones = app.number().getPhones(contact); //получение инфы о телефонах (по конкретному контакту)
        var expected = Stream.of(contact.home(), contact.mobile(), contact.work())
                .filter(s -> s != null && ! "".equals(s))
                .collect(Collectors.joining("\n"));
        Assertions.assertEquals(expected, phones);
    }
}
