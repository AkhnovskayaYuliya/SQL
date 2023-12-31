package ru.netology.SQL.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private final SelenideElement code = $("[data-test-id=code] input");
    private final SelenideElement verificationButton = $("[data-test-id=action-verify]");
    private final SelenideElement errorMessage = $("[data-test-id=error-notification] .notification__content");

    public DashBoard validVerify(String verificationCode) {
        setCode(verificationCode);
        return new DashBoard();
    }

    public void setCode(String verificationCode) {
        code.setValue(verificationCode);
        verificationButton.click();
    }

    public void errorNotification(String expectedText) {
        errorMessage.shouldHave(text(expectedText)).shouldBe(visible);
    }
}
