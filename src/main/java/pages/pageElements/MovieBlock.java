package pages.pageElements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Image;


@FindBy(xpath = ".//div[@itemtype = 'http://schema.org/Movie']")
public class MovieBlock extends CommonActionWithElements {

    @FindBy(xpath = ".//a[@class = 'poster-wrapper']")
    private Image poster;

    @FindBy(xpath = ".//div[@title = 'Перегляну пізніше']")
    private Button watchButton;

    @FindBy(xpath = ".//div[@title = 'Улюблений']")
    private Button favoriteButton;

    @FindBy(xpath = ".//div[@title = 'Бачив']")
    private Button seenButton;

    @FindBy(xpath = ".//div[@title = 'Не цікавить']")
    private Button blacklistButton;

    @FindBy(xpath = ".//div[@title = 'Додати до списку']")
    private Button addToListButton;

    @FindBy(xpath = ".//i[@data-value = '10']")
    private Button rating10;

    @FindBy(xpath = ".//button[@title = 'Видалити оцінку']")
    private Button deleteRatingButton;

}
