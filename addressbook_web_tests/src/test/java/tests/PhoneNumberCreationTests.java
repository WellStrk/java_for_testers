package tests;
import model.PhoneNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.List;

public class PhoneNumberCreationTests extends TestBase {

  public static List<PhoneNumber> PhoneNumberProvider() {
    var result = new ArrayList<PhoneNumber>();
    for (var firstname : List.of("", "name")) {
      for (var lastname : List.of("", "last name")) {
        for (var address : List.of("", "address")) {
          for (var email : List.of("", "email@mail.com")) {
            for (var mobile : List.of("", "911")) {
              result.add(new PhoneNumber(firstname, lastname, address, email, mobile));
            }
          }
        }
      }
    }
        for (int i = 0; i < 5; i++) {
          result.add(new PhoneNumber(randomString(i * 10), randomString(i * 10), randomString(i * 10), randomString(i * 10), randomString(i * 10)));
        }
        return result;
      }

      @ParameterizedTest
      @MethodSource("PhoneNumberProvider")
      public void canCreateMultiplePhoneNumber(PhoneNumber phone) {
        int PhoneNumberCount = app.number().getNumberCount();
        app.number().createPhoneNumber(phone);
        int newPhoneNumberCount = app.number().getNumberCount();
        Assertions.assertEquals(PhoneNumberCount + 1, newPhoneNumberCount);
      }


  public static List<PhoneNumber> negativePhoneNumberProvider() {
    var result = new ArrayList<PhoneNumber>(List.of(
            new PhoneNumber("name'", "", "", "", "")));
    return result;
  }

  @ParameterizedTest
  @MethodSource ("negativePhoneNumberProvider")
  public void cannotCreatePhoneNumber(PhoneNumber phone) {
    int PhoneNumberCount = app.number().getNumberCount();
    app.number().createPhoneNumberWithIncorrectParameters(phone);
    int newPhoneNumberCount = app.number().getNumberCount();
    Assertions.assertEquals(PhoneNumberCount, newPhoneNumberCount);
  }
}
