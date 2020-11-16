package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.mantis.appmanager.HttpSession;

import java.io.IOException;

import static ru.stqa.pft.mantis.tests.TestBase.app;

public class PasswordChangeTests {

    @Test

    public void testPasswordChange() throws IOException {

        HttpSession session = app.newSession();
        session.login("administrator", "root");

        //перейти по этой ссылке
        //http://localhost/mantisbt-2.24.2/manage_user_page.php

        //кликнуть по пользователю + запомнить его почтовый ящик
        //нажать сбросить пароль
        //перейти на почтовый ящик этого пользователя, извлечь ссылку для смены пароля, пройти по ссылке и изменить пароль
        // затем тест должен проверить что пользователь может войти с новым паролем

    }
}
