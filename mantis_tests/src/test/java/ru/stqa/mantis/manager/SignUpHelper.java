package ru.stqa.mantis.manager;
import org.openqa.selenium.By;

public class SignUpHelper extends HelperBase {

    public SignUpHelper(ApplicationManager manager) {
        super(manager);
    }

    public void startRegistration(String username, String email) {
        manager.driver().get(manager.property("web.baseUrl"));
        click(By.linkText("Signup for a new account"));
        type(By.name("username"), username);
        type(By.name("email"), email);
        click(By.cssSelector("input[type='submit']"));
    }

    public void completeRegistration(String confirmationUrl, String username, String password) {
        manager.driver().get(confirmationUrl);
        type(By.name("realname"), username);
        type(By.name("password"), password);
        type(By.name("password_confirm"), password);
        By submitButton = By.xpath("//button[contains(., 'Update User')]");
        click(submitButton);
    }


}
