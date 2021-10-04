package elements.casepreview;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


@Log4j2
public class InfoField {
    String label;
    String PREVIEW_INFO_LOCATOR = "//*[contains(@class, 'preview-param-title') and contains(text(), " +
            "'%s')]/..//*[contains(@class,'preview-param-value')]";

    public InfoField(String label) {
        this.label = label;
    }

    public String getFieldValueByName() {
        log.info("Getting info from filed with name '{}'", label);
        return $(By.xpath(String.format(PREVIEW_INFO_LOCATOR, label))).getText();
    }
}
