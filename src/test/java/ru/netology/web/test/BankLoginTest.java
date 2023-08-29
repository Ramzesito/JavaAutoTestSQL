package ru.netology.web.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataGenerator;
import ru.netology.web.data.SqlHelp;
import ru.netology.web.pages.Login;

import static com.codeborne.selenide.Selenide.open;

import static ru.netology.web.data.SqlHelp.clearDB;

public class BankLoginTest {

    @AfterAll
    static void teardown() {
        clearDB();
    }

    @Test
    @DisplayName("Should successfully login to dashboard with exist login and password from SUT test data")
    public void shouldSuccessfullyLogin() {
        var loginPage = open("http://localhost:9999", Login.class);
        var authInfo = DataGenerator.getAuthInfoForTest();
        var verificationPage = loginPage.validLogin(authInfo);
        verificationPage.verifyVerificationPageVisibility();
        var verificationCode = SqlHelp.getVerificationCode();
        verificationPage.validVerify(verificationCode.getCode());
    }

    @Test
    @DisplayName("Should get error notification if user is not exist in base")
    public void shouldGetErrorNotificationIfLoginWithRandomUserWithoutAddingToBase() {
        var loginPage = open("http://localhost:9999", Login.class);
        var authInfo = new DataGenerator.AuthInfo(DataGenerator.generateRandomLogin(),
                                                    DataGenerator.generateRandomPassword());
        loginPage.validLogin(authInfo);
        loginPage.verifyErrorNotificationVisibility();
    }

    @Test
    @DisplayName("Should get error notification if login exists in base and active user and random verification code")
    public void shouldGetErrorNotificationIfLoginExistsAndRandomNotificationCode() {
        var loginPage = open("http://localhost:9999", Login.class);
        var authInfo = DataGenerator.getAuthInfoForTest();
        var verificationPage = loginPage.validLogin(authInfo);
        verificationPage.verifyVerificationPageVisibility();
        var verificationCode = DataGenerator.generateRandomVerificationCode();
        verificationPage.verify(verificationCode);
        verificationPage.verifyErrorNotificationVisibility();
    }
}
