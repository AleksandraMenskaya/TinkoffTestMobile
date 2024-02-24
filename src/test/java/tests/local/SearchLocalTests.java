package tests.local;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;


@Tag("local")
public class SearchLocalTests extends TestBase {

    private final static String SEARCH_WORD = "Appium";

    @Test
    @DisplayName("Открытие первой ссылки поисковой выдачи")
    void successfulSearchTest() {
        back();
        step("Отправляем  поисковый запрос", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys(SEARCH_WORD);
        });

        step("Проверяем, что поисковая выдача не пустая", () ->
             $$(id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(sizeGreaterThan(0)));
        }
}
