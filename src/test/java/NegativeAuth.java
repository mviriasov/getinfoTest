import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class NegativeAuth {

    @Test
    void negativeTest() {
        //Открытие ресурса
        open("https://dev2.getinfo.radugi.net/login");

        //Заполнение полей данными
        $("#sdo-login").setValue("hubldorf@gmail.com");
        $("#sdo-password").setValue("123ppll2341");
        $(".login-btn button").click();

        //Проверка наличия нотификации
        $(".custom-error-notification").shouldHave(text("Bad credentials."));


    }
}
