package tests;

import model.PhoneNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PhoneNumberRemovalTests extends TestBase {




  @Test
  public void canRemovePhoneNumber() {
    if (app.number().getNumberCount() == 0) {
      app.number().createPhoneNumber(new PhoneNumber("", "", "", "", "", ""));
    }
    app.number().removePhoneNumber();

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
