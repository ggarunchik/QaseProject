package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class DropDown {
    String label;
    String DROPDOWN_XPATH = "//label[contains(text(), '%s')]";
    String SELECT_OPTION_XPATH = "//label[contains(text(),'%s')]/following-sibling::div" +
            "//*[contains(@class, ' css-1gg2qke-menu')]//*[contains(@class, ' css-fspxhu')]//*[text()='%s']";
    String SELECTED_OPTION_XPATH = " //label[contains(text(), '%s')]/following-sibling::div" +
            "//div[@class=' css-io3r9z-singleValue']";

    public DropDown(String label) {
        this.label = label;
    }

    public void selectOption(String option) {
        log.info("Selecting option '{}' in drop-down {}", option, label);
        $(By.xpath(DROPDOWN_XPATH)).click();
        $(By.xpath(String.format(SELECT_OPTION_XPATH, label, option))).click();
        boolean isOptionSelected =
                $(By.xpath(String.format(SELECTED_OPTION_XPATH, label))).getText().equals(option);
        Assert.assertTrue(isOptionSelected, "Option has not been selected.");
    }
}
