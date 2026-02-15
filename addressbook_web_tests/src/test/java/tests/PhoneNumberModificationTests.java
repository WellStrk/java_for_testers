package tests;
import model.PhoneNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class PhoneNumberModificationTests extends TestBase{

    @Test
    public void canModifyPhoneNumber() {
        if (app.number().getNumberCount() == 0) {
            app.number().createPhoneNumber(new PhoneNumber("", "", "", "", "", ""));
        }
        var oldPhoneNumber = app.number().getNumbersList(); //загрузка списка групп из веб приложения
        var rnd = new Random();
        var index = rnd.nextInt(oldPhoneNumber.size()); //выбираетс ягруппа, которую модифиц-ем
        var modifiedContact = new PhoneNumber()
                .withFirstName("modified name")
                .withLastName("modified last name");
        app.number().modifyPhoneNumber(oldPhoneNumber.get(index), modifiedContact);
        var newPhoneNumber = app.number().getNumbersList();
        var expectedList = new ArrayList<>(oldPhoneNumber);
        expectedList.set(index, modifiedContact.withId(oldPhoneNumber.get(index).id()));
        //сортировка (по возрастванию id)
        Comparator<PhoneNumber> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newPhoneNumber.sort(compareById);
        expectedList.sort(compareById);
        Assertions.assertEquals(newPhoneNumber,  expectedList);
    }
}
