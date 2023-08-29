package ru.netology.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataGenerator;

import static com.codeborne.selenide.Selenide.$;

public class Login {
    private SelenideElement loginField = $("[data-test-id=login] input");
    private SelenideElement passwordField = $("[data-test-id=password] input");
    private SelenideElement loginButton = $("[data-test-id=action-login]");
    private SelenideElement errorNotification = $("[data-test-id=error-notification]");

    public Verification validLogin(DataGenerator.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
        return new Verification();
    }

    public void verifyErrorNotificationVisibility() {
        errorNotification.shouldBe(Condition.visible);
    }
}
