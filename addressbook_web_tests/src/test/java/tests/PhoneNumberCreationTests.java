package tests;
import model.PhoneNumber;
import org.junit.jupiter.api.Test;

public class PhoneNumberCreationTests extends TestBase {

  @Test
  public void canCreatePhoneNumber() {

    app.number().createPhoneNumber(new PhoneNumber("name", "last name", "address", "email@mail.com", "911"));

  }
}
