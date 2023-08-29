package ru.netology.web.data;

import com.github.javafaker.Faker;
import lombok.Value;
import java.util.Locale;

public class DataGenerator {

    private static final Faker faker = new Faker(new Locale("en"));
    private DataGenerator() {}

    // -------------  по пользователям  ----------------------
    @Value
    public static class AuthInfo {
        String login;
        String password;
    }

    public static AuthInfo getAuthInfoForTest() {
        return new AuthInfo("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static String generateRandomVerificationCode() {
        return faker.numerify("######");
    }

    public static String generateRandomLogin() {
        return faker.name().username();
    }
    public static String generateRandomPassword() {
        return faker.internet().password();
    }

}