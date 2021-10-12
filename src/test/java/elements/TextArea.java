package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class TextArea {
    String label;
    String INPUT_LOCATOR_WITH_TOAST_XPATH = "//label[text()='%s']/ancestor::div[contains(@class,'form-group')]//ancestor::div[contains(@class, 'ProseMirror toastui-editor-contents')]";
    public TextArea(String label) {
        this.label = label;
    }

    public void clear() {
        $(By.xpath(String.format(INPUT_LOCATOR_WITH_TOAST_XPATH, label))).clear();
    }

    public void write(String text) {
        log.info("Writing text '{}' into input with label {}", text, label);
        $(By.xpath(String.format(INPUT_LOCATOR_WITH_TOAST_XPATH, label))).sendKeys(text);
    }
}
