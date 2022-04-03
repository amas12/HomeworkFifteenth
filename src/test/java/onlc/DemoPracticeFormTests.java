package onlc;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class DemoPracticeFormTests extends TestBase {
    @Test
    public void fillPracticeFormTests() {
        step("Открываем страницу с формами", () -> {
            open("https://demoqa.com/automation-practice-form");
        });
        //fill form
        step("Вводим имя", () -> {
            $("#firstName").setValue("Maks");
        });
        step("Вводим фамилию", () -> {
            $("#lastName").setValue("Maks");
        });
        step("Вводим email", () -> {
            $("#userEmail").setValue("test@test.test");
        });
        step("Выбираем пол", () -> {
            $("[for='gender-radio-3']").click();
        });
        step("Вводим телефон", () -> {
            $("#userNumber").setValue("4444444444");
        });
        step("выбираем дату рождения", () -> {
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOption("August");
            $(".react-datepicker__year-select").selectOption("1990");
            $(".react-datepicker__day--019").click();
        });
        step("Выбираеи предметы", () -> {
            $("#subjectsInput").setValue("English").pressEnter();
            $("#subjectsInput").setValue("Computer Science").pressEnter();
        });
        step("Выбираем хобби", () -> {
            $("[for=hobbies-checkbox-1]").click();
            $("[for=hobbies-checkbox-3]").click();
        });

        step("Вводим адрес", () -> {
            $("#currentAddress").setValue("Any Address");
        });
        step("Выбираем штат и город", () -> {
            $("#react-select-3-input").setValue("Haryana").pressEnter();
            $("#react-select-4-input").setValue("Karnal").pressEnter();
        });
        step("Нажимаем submit", () -> {
            $("#submit").click();
        });


        step("Проверка результата", () -> {
            $("#example-modal-sizes-title-lg").shouldBe(visible);
            $(".table-responsive").shouldHave(text("Maks"), text("Maks"), text("test@test.test"),
                    text("Other"), text("4444444444"), text("19 August,1990"), text("English, Computer Science"),
                    text("Sports, Music"), /*text("Glazov.txt"),*/ text("Any Address"), text("Haryana Karnal"));
        });
    }
}
