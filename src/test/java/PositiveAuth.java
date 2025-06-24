import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PositiveAuth {

    @Test
    void positiveTest() {

        //Открытие ресурса
        open("https://dev2.getinfo.radugi.net/login");

        //Заполнение полей данными
        $("#sdo-login").setValue("dumbledore@sct.team");
        $("#sdo-password").setValue("12345678qQ1");
        $(".login-btn button").click();

        //Проверка успешности входа
        $(".avatar-icon-bg").click();
        $(".my-3").shouldHave(text("dumbledore@sct.team"));




        sleep(5000);
    }
}
