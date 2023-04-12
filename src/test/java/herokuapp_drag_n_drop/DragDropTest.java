package herokuapp_drag_n_drop;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.*;

public class DragDropTest {
    @Test
    void dragByActionsError() {
        //Configuration.holdBrowserOpen = true;

//Открыть https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");

//Перенести прямоугольник А на место В
        actions().clickAndHold($("#column-a")).moveToElement($("#column-b"))
               .release().perform();

//Прямоугольники поменялись (а на самом деле нет - и все зависло)
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }

    @Test
    void dragByDragAndDrop() {
        //Configuration.holdBrowserOpen = true;

//Открыть https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");

//Перенести прямоугольник А на место В
        $("#column-a").dragAndDropTo("#column-b");

//Прямоугольники действительно поменялись
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
/* К вопросу о неработающих командах. А почему на странице https://github.com/selenide/selenide
поиск родителя .closest(".BorderGrid-cell") работает, а поиск .closest("div.BorderGrid-cell") не работает?
Хотя элемент именно div. Более конкретно:

        //работает
        $("div.Layout-sidebar").$(byText("Contributors"))
                .closest(".BorderGrid-cell").$$("ul li").first().hover();

        //не работает
        $("div.Layout-sidebar").$(byText("Contributors"))
                .closest("div.BorderGrid-cell").$$("ul li").first().hover();

Разница - только в наличии div в .closest()
 */
}
