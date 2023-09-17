

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SearchCodeJUnit5 {
    @Test
    void searchCodeJUnit5(){

        //Откройте страницу Selenide в Github
        open("https://github.com");
        $(".search-input").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        $("[data-testid=results-list] h3 a").shouldHave(text("selenide/selenide")).click();

        // Перейдите в раздел Wiki проекта
        $$("ul.UnderlineNav-body.list-style-none li").get(5).$("a").click();
        // Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $$(".markdown-body ul li a").shouldHave(itemWithText("Soft assertions"));

        //Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $$(".markdown-body ul li").get(7).$("a").click();
        $$(".markdown-body h4").findBy(text("3. Using JUnit5 extend test class:")).shouldBe(visible);
        $$("pre").findBy(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}")).shouldBe(visible);
    }

}
