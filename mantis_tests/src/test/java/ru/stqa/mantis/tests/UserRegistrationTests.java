package ru.stqa.mantis.tests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.mantis.common.CommonFunctions;
import ru.stqa.mantis.model.MailMessage;
import ru.stqa.mantis.model.UserData;

import java.time.Duration;
import java.util.List;


public class UserRegistrationTests extends TestBase {

    @Test
    void canRegisterUser() {
        var username = CommonFunctions.randomString(8);
        var email = String.format("%s@localhost", username);
        var password = "password";
        app.jamesCli().addUser(email, password);
        app.signup().startRegistration(username, email);
        List<MailMessage> messages = app.mail().receive(email, password, Duration.ofSeconds(60));
        var confirmationUrl = app.mail().extractConfirmationUrl(messages.get(0));
        app.signup().completeRegistration(confirmationUrl, username, password);
        app.http().login(username, password);
        Assertions.assertTrue(app.http().isLoggedIn());
    }


    @Test
    void RandomUser() {
        var username = CommonFunctions.randomString(8);
        var email = String.format("%s@localhost", username);
        var password = "password";
        app.jamesApi().addUser(email, password);
        app.rest().registerUser(new UserData()
                .withUsername(username)
                .withEmail(email)
                .withPassword(password));
        List<MailMessage> messages = app.mail().receive(email, password, Duration.ofSeconds(60));
        var confirmationUrl = app.mail().extractConfirmationUrl(messages.get(0));
        app.signup().completeRegistration(confirmationUrl, username, password);
        app.http().login(username, password);
        Assertions.assertTrue(app.http().isLoggedIn());
    }
}
