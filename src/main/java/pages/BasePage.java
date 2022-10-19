package pages;

import org.openqa.selenium.WebDriver;

//This class contains methods that can be used for other pages of the app
public class BasePage<T extends BasePage>{

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver=driver;
    }

    public T refreshPage() {
        driver.navigate().to(driver.getCurrentUrl());
        return (T) this;
    }
}