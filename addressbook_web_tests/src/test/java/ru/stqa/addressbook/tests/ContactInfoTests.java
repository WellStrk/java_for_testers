package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactInfoTests extends TestBase{

    @Test
    void testPhones() {
        var contacts = app.hbm().getPhoneNumberList();
        var expected =  contacts.stream().collect(Collectors.toMap(
                contact -> contact.id(),
                contact -> Stream.of(contact.home(), contact.mobile(), contact.work())
                        .filter(s -> s != null && !"".equals(s))
                        .collect(Collectors.joining("\n"))
        ));
        var phones = app.number().getPhones();
        Assertions.assertEquals(expected, phones);
        }

    @Test
    void testAddresses() {
        var contacts = app.hbm().getPhoneNumberList();
        var expected = contacts.stream().collect(Collectors.toMap(
                contact -> contact.id(),
                contact -> contact.address()
        ));
        var addresses = app.number().getAddresses();
        Assertions.assertEquals(expected, addresses);
    }

    @Test
    void testEmails() {
        var contacts = app.hbm().getPhoneNumberList();
        var expected = contacts.stream().collect(Collectors.toMap(
                contact -> contact.id(),
                contact -> Stream.of(contact.email(), contact.email2(), contact.email3())
                        .filter(s -> s != null && !"".equals(s))
                        .collect(Collectors.joining("\n"))
        ));
        var emails = app.number().getEmails();
        Assertions.assertEquals(expected, emails);
    }

    }

