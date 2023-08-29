package ru.netology.web.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Dashboard {
    private final SelenideElement heading = $("[data-test-id=dashboard]");

    public Dashboard() {
        heading.shouldBe(visible);
    }

}