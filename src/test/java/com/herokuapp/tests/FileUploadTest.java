package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.windows.FileUploadPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class FileUploadTest extends TestBase {
    HomePage homePage;
    FileUploadPage fileUpload;


    @BeforeEach
    public void precondition(){
        homePage = new HomePage(app.driver);
        fileUpload = new FileUploadPage(app.driver);
    }

    @Test
    @Tag("tag_test")
    public void fileUploadTest(){
        homePage.selectFileUpload();

        fileUpload.chooseFile("E:/!Learning/!QA AIT/QA_auto/lesson_26_Selenium._Data_picker,_file_upload/fileToUpload.txt")
                  .verifyUpload("File Uploaded!")
        ;
    }
}
