package tests.browserstack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

@Tag("remote")
public class SearchTests extends TestBase {

    private final static String SEARCH_WORD = "Appium",
                                DESCRIPTION = "Automation for Apps";
    @Test
    @DisplayName("Проверка наличия поисковой выдачи")
    void checkResultTest() {
        step("Отправляем  поисковый запрос", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys(SEARCH_WORD);
        });
        step("Проверяем, что поисковая выдача непустая", () ->
            $$(id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @DisplayName("Переход по первой ссылке поисковой выдачи")
    void successfulSearchTest() {
        step("Отправляем  поисковый запрос", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys(SEARCH_WORD);
        });
        step("Нажимаем на первую найденную ссылку", () ->
             $$(id("org.wikipedia.alpha:id/page_list_item_title")).first().click());
        step("Проверяем получение ошибки", () ->
             $(id("org.wikipedia.alpha:id/view_wiki_error_text")).shouldBe(visible));
    }

    @Test
    @DisplayName("Проверка описания заголовка")
    void checkDescriptionTest() {
        step("Отправляем запрос в википедии", () -> {
             $(accessibilityId("Search Wikipedia")).click();
             $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys(SEARCH_WORD);
        });
        step("Проверяем, что описания найденного заголовка", () ->
              $(id("org.wikipedia.alpha:id/page_list_item_description")).shouldHave(text(DESCRIPTION)));
    }
}
