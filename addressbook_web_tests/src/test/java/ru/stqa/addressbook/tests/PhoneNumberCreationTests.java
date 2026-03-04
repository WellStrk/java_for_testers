package ru.stqa.addressbook.tests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.stqa.addressbook.common.CommonFunctions;
import ru.stqa.addressbook.model.Group;
import ru.stqa.addressbook.model.PhoneNumber;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static ru.stqa.addressbook.tests.TestBase.app;

public class PhoneNumberCreationTests extends TestBase {

  public static List<PhoneNumber> PhoneNumberProvider() throws IOException {
    var result = new ArrayList<PhoneNumber>();

    var json = Files.readString(Paths.get("phoneNumbers.json"));  // более короткий способ того что выше
    ObjectMapper mapper = new ObjectMapper();
    var value = mapper.readValue(json, new TypeReference<List<PhoneNumber>>() {
    });
    result.addAll(value);
        return result;
      }


  public static List<PhoneNumber> singleRandomNumber() {
    return List.of(new PhoneNumber()
            .withFirstName(CommonFunctions.randomString(10))
            .withLastName(CommonFunctions.randomString(20))
            .withAddress(CommonFunctions.randomString(30)));
  }

  @ParameterizedTest
  @MethodSource("singleRandomNumber")
  public void canCreateMultiplePhoneNumber(PhoneNumber phone) {
    var oldPhoneNumber = app.hbm().getPhoneNumberList(); //загрузка списка групп из веб приложения
    app.number().createPhoneNumber(phone);
    var newPhoneNumber = app.hbm().getPhoneNumberList();
    Comparator<PhoneNumber> compareById = (o1, o2) -> {
      return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
    };
    newPhoneNumber.sort(compareById);
    var maxId = newPhoneNumber.get(newPhoneNumber.size() - 1).id();
    var expectedList = new ArrayList<>(oldPhoneNumber);
    expectedList.add(phone.withId(maxId));
    expectedList.sort(compareById);
    Assertions.assertEquals(newPhoneNumber,  expectedList);

  }


  public static List<PhoneNumber> negativePhoneNumberProvider() {
    var result = new ArrayList<PhoneNumber>(List.of(
            new PhoneNumber("", "name'", "", "", "", "","", "", "", "", "")));
    return result;
  }

  @ParameterizedTest
  @MethodSource ("negativePhoneNumberProvider")
  public void cannotCreatePhoneNumber(PhoneNumber phone) {
    var oldPhoneNumber = app.hbm().getPhoneNumberList();
    app.number().createPhoneNumberWithIncorrectParameters(phone);
    var newPhoneNumber = app.hbm().getPhoneNumberList();
    Comparator<PhoneNumber> compareById = (o1, o2) -> {
      return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
    };
    newPhoneNumber.sort(compareById);
    var expectedList = new ArrayList<>(oldPhoneNumber);
    expectedList.sort(compareById);
    Assertions.assertEquals(oldPhoneNumber, newPhoneNumber);
  }

  @Test
  void canCreatePhoneNumberInGroup () {
      var phoneNumber = new PhoneNumber()
              .withFirstName(CommonFunctions.randomString(10))
              .withLastName(CommonFunctions.randomString(10))
              .withAddress(CommonFunctions.randomString(10));
      if (app.hbm().getGroupCount() == 0) {
        app.hbm().createGroup(new Group("", "", "", ""));
      }
      var group = app.hbm().getGroupList().get(0);
      var oldRelated = app.hbm().getPhoneNumbersInGroup(group);
      app.number().createPhoneNumberInGroup(phoneNumber, group);
      var newRelated = app.hbm().getPhoneNumbersInGroup(group);
      Comparator<PhoneNumber> compareById = (o1, o2) -> {
        return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
      };
      newRelated.sort(compareById);
      var maxId = newRelated.get(newRelated.size() - 1).id();
      var expectedList = new ArrayList<>(oldRelated);
      expectedList.add(phoneNumber.withId(maxId));
      expectedList.sort(compareById);
      Assertions.assertEquals(expectedList, newRelated);
  }

    @Test
    void canAddExistingPhoneNumberToGroup() {
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
        var existingPhoneNumber = app.hbm().getPhoneNumberList().get(0);
        var phoneNumbersInGroup = app.hbm().getPhoneNumbersInGroup(group);
        if (phoneNumbersInGroup.stream().anyMatch(p -> p.id().equals(existingPhoneNumber.id()))) {
            app.number().removePhoneNumberFromGroupWithGroupSelection(existingPhoneNumber, group);
        }
        var oldRelated = app.hbm().getPhoneNumbersInGroup(group);
        app.number().addPhoneNumberToGroup(existingPhoneNumber, group);
        var newRelated = app.hbm().getPhoneNumbersInGroup(group);
        var expectedList = new ArrayList<>(oldRelated);
        expectedList.add(existingPhoneNumber);
        Comparator<PhoneNumber> compareById = (o1, o2) ->
                Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        expectedList.sort(compareById);
        newRelated.sort(compareById);
        Assertions.assertEquals(expectedList, newRelated);
    }
}


