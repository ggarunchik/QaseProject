package elements;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class Input {
    String label;
    String INPUT_LOCATOR_XPATH = "//label[contains(text(), '%s')]/../..//input";

    public Input(String label) {
        this.label = label;
    }

    public void write(String text) {
        log.info("Writing text '{}' into input with label {}", text, label);
        $(By.xpath(String.format(INPUT_LOCATOR_XPATH, label))).sendKeys(text);
    }

    public void clear() {
        log.info("Deleting text from input with label {}", label);
        $(By.xpath(String.format(INPUT_LOCATOR_XPATH, label))).clear();
    }
}
