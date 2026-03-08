package ru.stqa.addressbook.tests;

import ru.stqa.addressbook.common.CommonFunctions;
import ru.stqa.addressbook.model.Group;
import ru.stqa.addressbook.model.PhoneNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class PhoneNumberRemovalTests extends TestBase {




  @Test
  public void canRemovePhoneNumber() {
    if (app.number().getNumberCount() == 0) {
      app.number().createPhoneNumber(new PhoneNumber("", "", "", "", "", "", "", "", "", "", "", "", ""));
    }
    var oldPhoneNumber = app.hbm().getPhoneNumberList();
    var rnd = new Random();
    var index = rnd.nextInt(oldPhoneNumber.size()); //случайным образом выбираем индекс какого-то элемента из списка oldGroups
    app.number().removePhoneNumber(oldPhoneNumber.get(index));
    var newPhoneNumber = app.hbm().getPhoneNumberList();
    var expectedList = new ArrayList<>(oldPhoneNumber);
    expectedList.remove(index);
    Assertions.assertEquals(newPhoneNumber,  expectedList);
  }

  @Test
  public void canRemoveAllPhoneNumberAtOnce() {
    if (app.hbm().getPhoneNumberCount() == 0) {
      app.hbm().createNumber(new PhoneNumber("", "", "", "", "", "", "", "", "", "", "", "", ""));
    }
    app.number().RemoveAllPhoneNumber();
    Assertions.assertEquals(0, app.hbm().getPhoneNumberCount());
  }

  @Test
  void canRemovePhoneNumberFromGroup () {
    if (app.hbm().getGroupCount() == 0) {
      app.hbm().createGroup(new Group()
              .withName(CommonFunctions.randomString(10))
              .withHeader("")
              .withFooter(""));
    }
    if (app.hbm().getPhoneNumberCount() == 0) {
      var phoneNumber = new PhoneNumber()
              .withFirstName(CommonFunctions.randomString(10))
              .withLastName(CommonFunctions.randomString(10))
              .withAddress(CommonFunctions.randomString(10));
      app.number().createPhoneNumber(phoneNumber);
    }
    var group = app.hbm().getGroupList().get(0);
    var phoneNumbersInGroup = app.hbm().getPhoneNumbersInGroup(group);
    if (phoneNumbersInGroup.isEmpty()) {
      var somePhoneNumber = app.hbm().getPhoneNumberList().get(0);
      app.number().addPhoneNumberToGroup(somePhoneNumber, group);
      phoneNumbersInGroup = app.hbm().getPhoneNumbersInGroup(group);
    }
    var phoneNumberToRemove = phoneNumbersInGroup.get(0);
    var oldRelated = app.hbm().getPhoneNumbersInGroup(group);
    app.number().removePhoneNumberFromGroup(phoneNumberToRemove, group);
    var newRelated = app.hbm().getPhoneNumbersInGroup(group);
    var expectedList = new ArrayList<>(oldRelated);
    expectedList.removeIf(p -> p.id().equals(phoneNumberToRemove.id()));
    Comparator<PhoneNumber> compareById = (o1, o2) -> {
      return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
    };
    expectedList.sort(compareById);
    newRelated.sort(compareById);
    Assertions.assertEquals(expectedList, newRelated);
    Assertions.assertFalse(newRelated.stream()
            .anyMatch(p -> p.id().equals(phoneNumberToRemove.id())));
  }

}
