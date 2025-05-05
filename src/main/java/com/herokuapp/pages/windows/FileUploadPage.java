package com.herokuapp.pages.windows;

import com.herokuapp.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileUploadPage extends BasePage {
    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "file-upload")
    WebElement fileUpload;

    @FindBy(id = "file-submit")
    WebElement uploadButton;

    public FileUploadPage chooseFile(String path) {
        fileUpload.sendKeys(path);
        pause(500);
        click(uploadButton);
        return this;
    }

    @FindBy(css = "div#content>div>h3")
    WebElement successTitle;

    public FileUploadPage verifyUpload(String title) {
        Assertions.assertTrue(isContainsText(title,successTitle));
        return this;
    }
}
