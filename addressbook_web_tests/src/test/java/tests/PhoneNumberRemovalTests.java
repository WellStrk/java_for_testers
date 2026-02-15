package tests;

import model.PhoneNumber;
import org.junit.jupiter.api.Test;

public class PhoneNumberRemovalTests extends TestBase {




  @Test
  public void canRemovePhoneNumber() {
    if (app.number().isPhoneNumberPresent()) {
      app.number().createPhoneNumber(new PhoneNumber("", "", "", "", ""));
    }
    app.number().removePhoneNumber();

  }

}
