package ru.stqa.addressbook.tests;
import io.qameta.allure.Allure;
import ru.stqa.addressbook.model.PhoneNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class PhoneNumberModificationTests extends TestBase {

    @Test
    public void canModifyPhoneNumber() {
        Allure.step("Checking precondition", step -> {
        if (app.hbm().getPhoneNumberCount() == 0) {
            app.hbm().createNumber(new PhoneNumber("", "", "", "", "", "", "", "", "", "", "", "", "", "", ""));
        }
        });
        var oldPhoneNumber = app.hbm().getPhoneNumberList();
        var rnd = new Random();
        var index = rnd.nextInt(oldPhoneNumber.size()); //выбирается группа, которую модифиц-ем
        var modifiedContact = new PhoneNumber()
                .withFirstName("modified name")
                .withLastName("modified last name");
        app.number().modifyPhoneNumber(oldPhoneNumber.get(index), modifiedContact);
        var newPhoneNumber = app.hbm().getPhoneNumberList();
        var expectedList = new ArrayList<>(oldPhoneNumber);
        expectedList.set(index, modifiedContact.withId(oldPhoneNumber.get(index).id()));
        //сортировка (по возрастванию id)
        Comparator<PhoneNumber> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newPhoneNumber.sort(compareById);
        expectedList.sort(compareById);
        Allure.step("Validating results", step -> {
        Assertions.assertEquals(newPhoneNumber,  expectedList);
        });
    }
}
