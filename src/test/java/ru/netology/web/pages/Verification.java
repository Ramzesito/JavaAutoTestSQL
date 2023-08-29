package ru.netology.web.pages;

import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataGenerator;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Verification {
    private SelenideElement codeField = $("[data-test-id=code] input");
    private SelenideElement verifyButton = $("[data-test-id=action-verify]");
    private SelenideElement errorNotification = $("[data-test-id=error-notification]");

//    public Verification() {
//        codeField.shouldBe(visible);
//    }

    public void verifyVerificationPageVisibility() {
        codeField.shouldBe(visible);
    }

    public void verifyErrorNotificationVisibility() {
        errorNotification.shouldBe(visible);
    }

    public void verify(String verificationCode) {
        codeField.setValue(verificationCode);
        verifyButton.click();
    }
    public Dashboard validVerify(String verificationCode) {
        verify(verificationCode);
        return new Dashboard();
    }
}