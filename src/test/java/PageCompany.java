import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PageCompany {

    @BeforeEach
    void clearSession() {

        open("https://dev2.getinfo.radugi.net/login");
        clearBrowserCookies();
        clearBrowserLocalStorage();

    }


    @Test
    void companypageTest() {

        //Открытие ресурса
        open("https://dev2.getinfo.radugi.net/login");

        //Заполнение полей данными
        $("#sdo-login").setValue("dumbledore@sct.team");
        $("#sdo-password").setValue("12345678qQ1");
        $(".login-btn button").click();


        //Проверка успешности входа
        $(".avatar-icon-bg").click();
        $(".my-3").shouldHave(text("dumbledore@sct.team"));

        //Доступность страницы компании после авторизации
        $(byText("Учебный центр")).click();
        $(byText("Компания")).click();
        $(".el-main").shouldHave(text(" Компания Учебный центр Хогвардса"));

        //Проверка на совпадение между пользователем и руководителем компании
        $(byText("Дамблдор Альбус")).click();
        switchTo().window(1);
        $(".description-value").shouldHave(text("dumbledore@sct.team"));


    }


    @Test
    void NegativeAuthTest() {

        //Открытие ресурса
        open("https://dev2.getinfo.radugi.net/login");

        //Заполнение полей данными
        $("#sdo-login").setValue("hubldorf@gmail.com");
        $("#sdo-password").setValue("123ppll2341");
        $(".login-btn button").click();

        //Проверка наличия нотификации
        $(".custom-error-notification").shouldHave(text("Bad credentials."));


    }

    @Test
    void RecoveryFormTest() {

        //Открытие ресурса
        open("https://dev2.getinfo.radugi.net/login");

        //Заполнение формы для восстановления
        $(byText("Забыли пароль?")).click();
        $(".user-box>input").setValue("dumbledore@sct.team");
        $(".login-btn button").click();

        //Проверка нотификации
        $(".el-notification__group").shouldHave(text("Ссылка на изменение пароля отправлена на почту"));


    }
}
