import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RecoveryForm {

    @Test
    void recoveryFromTest() {

        //Открытие ресурса
        open("https://dev2.getinfo.radugi.net/login");

        //Заполнение формы для восстановления
        $(byText("Забыли пароль?")).click();
        $(".user-box>input").setValue("dumbledore@sct.team");
        $(".login-btn button").click();

        //Проверка нотификации
        $(".el-notification__group").shouldHave(text("Ссылка на изменение пароля отправлена на почту"));

        sleep(5000);

    }
}
