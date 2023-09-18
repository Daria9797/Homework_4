import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchSolution {

   @Test
    void searchSolution(){
      //На главной странице GitHub выберите меню Solutions -> Enterprize с помощью команды hover для Solutions.
       open("https://github.com/");
       $(".header-menu-wrapper").$(byText("Solutions")).hover();
       $(byAttribute("aria-labelledby","solutions-for-heading")).$(byText("Enterprise")).click();

      // Убедитесь что загрузилась нужная страница (например что заголовок - "Build like the best."
       $(".application-main").$(byText("Build like the best")).shouldBe(visible);

   }}
