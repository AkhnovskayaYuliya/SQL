package ru.netology.SQL.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DashBoard {
    private final SelenideElement header = $("[data-test-id=dashboard]");

    public DashBoard() {
        header.shouldBe(visible);
    }
}
