package ru.netology.SQL.pages;

import com.codeborne.selenide.SelenideElement;
import ru.netology.SQL.data.DataHelper;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private static final SelenideElement login = $("[data-test-id=login] input");
    private static final SelenideElement password = $("[data-test-id=password] input");
    private static final SelenideElement loginButton = $("[data-test-id=action-login]");

    public static VerificationPage validLogin(DataHelper.AuthInfo info) {
        login.setValue(info.getLogin());
        password.setValue(info.getPassword());
        loginButton.click();
        return new VerificationPage();
    }

}
