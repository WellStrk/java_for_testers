package tests;
import model.PhoneNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PhoneNumberCreationTests extends TestBase {

  public static List<PhoneNumber> PhoneNumberProvider() {
    var result = new ArrayList<PhoneNumber>();
    for (var firstname : List.of("", "name")) {
      for (var lastname : List.of("", "last name")) {
        for (var address : List.of("", "address")) {
          for (var email : List.of("", "email@mail.com")) {
            for (var mobile : List.of("", "911")) {
              for (var photo : List.of("", randomFile("src/test/resources/images"))) {
                result.add(new PhoneNumber().withFirstName(firstname).withLastName(lastname).withAddress(address).withEmail(email).withMobile(mobile).withPhoto(photo));
              }
            }
          }
        }
      }
    }
        for (int i = 0; i < 5; i++) {
          result.add(new PhoneNumber()
                  .withFirstName(randomString(i * 10))
                  .withLastName(randomString(i * 10))
                  .withAddress(randomString(i * 10))
                  .withEmail(randomString(i * 10))
                  .withMobile(randomString(i * 10))
                  .withPhoto(randomFile("src/test/resources/images")));
        }
        return result;
      }

  @ParameterizedTest
  @MethodSource("PhoneNumberProvider")
  public void canCreateMultiplePhoneNumber(PhoneNumber phone) {
    var oldPhoneNumber = app.number().getNumbersList(); //загрузка списка групп из веб приложения
    app.number().createPhoneNumber(phone);
    var newPhoneNumber = app.number().getNumbersList();
    Comparator<PhoneNumber> compareById = (o1, o2) -> {
      return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
    };
    newPhoneNumber.sort(compareById);
    var expectedList = new ArrayList<>(oldPhoneNumber);
    expectedList.add(phone
            .withId(newPhoneNumber.get(newPhoneNumber.size() - 1).id())
            .withAddress("")
            .withEmail("")
            .withMobile(""));
    expectedList.sort(compareById);
    Assertions.assertEquals(expectedList.size(), newPhoneNumber.size());
    for (int i = 0; i < expectedList.size(); i++) {
      PhoneNumber expected = expectedList.get(i);
      PhoneNumber actual = newPhoneNumber.get(i);

      Assertions.assertEquals(expected.id(), actual.id());
      Assertions.assertEquals(expected.firstname(), actual.firstname());
      Assertions.assertEquals(expected.lastname(), actual.lastname());
      Assertions.assertEquals(expected.address(), actual.address());
      Assertions.assertEquals(expected.email(), actual.email());
      Assertions.assertEquals(expected.mobile(), actual.mobile());
    }
  }


  public static List<PhoneNumber> negativePhoneNumberProvider() {
    var result = new ArrayList<PhoneNumber>(List.of(
            new PhoneNumber("", "name'", "", "", "", "","")));
    return result;
  }

  @ParameterizedTest
  @MethodSource ("negativePhoneNumberProvider")
  public void cannotCreatePhoneNumber(PhoneNumber phone) {
    var oldPhoneNumber = app.number().getNumbersList();
    app.number().createPhoneNumberWithIncorrectParameters(phone);
    var newPhoneNumber = app.number().getNumbersList();
    Assertions.assertEquals(oldPhoneNumber, newPhoneNumber);
  }
}
