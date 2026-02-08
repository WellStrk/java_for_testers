package tests;
import model.Group;
import model.PhoneNumber;
import org.junit.jupiter.api.Test;

public class PhoneNumberCreationTests extends TestBase {

  @Test
  public void canCreatePhoneNumber() {

    app.number().createPhoneNumber(new PhoneNumber("name", "last name", "address", "email@mail.com", "911"));

  }

  @Test
  public void canCreatePhoneNumberWithEmptyFields() {
    app.number().createPhoneNumber(new PhoneNumber());
  }

  @Test
  public void canCreatePhoneNumberWithFirstNameOnly() {
    app.number().OpenHomePage();
    app.number().createPhoneNumber(new PhoneNumber().withFirstName("someName"));
  }
}
