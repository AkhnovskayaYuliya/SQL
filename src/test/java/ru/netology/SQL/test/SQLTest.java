package ru.netology.SQL.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.SQL.data.DataHelper;
import ru.netology.SQL.data.SQLHelper;
import ru.netology.SQL.pages.LoginPage;


import static com.codeborne.selenide.Selenide.open;
import static ru.netology.SQL.data.SQLHelper.cleanDatabase;

public class SQLTest {

    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }


    @AfterAll
    static void tearDownAll() {
        cleanDatabase();
    }

    @Test
    void shouldLoginWithTestData() {
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfoWithTestData();
        var verificationPage = LoginPage.validLogin(authInfo);
        var verificationCode = SQLHelper.getVerificationCode();
        verificationPage.validVerify(verificationCode.getCode());
    }

    @Test
    void wrongVerificationCode() {
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfoWithTestData();
        var verificationPage = LoginPage.validLogin(authInfo);
        var verificationCode = DataHelper.generateCode();
        verificationPage.validVerify(verificationCode.getCode());
        verificationPage.errorNotification("Ошибка!");
    }
}
