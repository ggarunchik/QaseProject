package pageobjects;

import utils.PropertyReader;

public abstract class BasePage {

    protected PropertyReader propertyReader = new PropertyReader("src/test/resources/configuration.properties");

    public abstract BasePage isPageOpened();
}
