package tests;

import model.PhoneNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class PhoneNumberRemovalTests extends TestBase {




  @Test
  public void canRemovePhoneNumber() {
    if (app.number().getNumberCount() == 0) {
      app.number().createPhoneNumber(new PhoneNumber("", "", "", "", "", ""));
    }
    var oldPhoneNumber = app.number().getNumbersList();
    var rnd = new Random();
    var index = rnd.nextInt(oldPhoneNumber.size()); //случайным образом выбираем индекс какого-то элемента из списка oldGroups
    app.number().removePhoneNumber(oldPhoneNumber.get(index));
    var newPhoneNumber = app.number().getNumbersList();
    var expectedList = new ArrayList<>(oldPhoneNumber);
    expectedList.remove(index);
    Assertions.assertEquals(newPhoneNumber,  expectedList);
  }

  @Test
  public void canRemoveAllPhoneNumberAtOnce() {
    if (app.number().getNumberCount() == 0) {
      app.number().createPhoneNumber(new PhoneNumber("", "", "", "", "", ""));
    }
    app.number().RemoveAllPhoneNumber();
    Assertions.assertEquals(0, app.number().getNumberCount());
  }

}
