package jdi;

import com.epam.jdi.light.mobile.elements.common.AppManager;
import com.epam.jdi.light.mobile.elements.common.MobileFileManager;
import com.epam.jdi.tools.Timer;
import io.appium.java_client.AppiumDriver;
import jdi.setup.BaseTest;
import nativeapp.jdi.InstagramApp;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import static com.epam.jdi.light.mobile.elements.init.PageFactory.initMobile;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static nativeapp.jdi.InstagramApp.*;
import static nativeapp.jdi.elements.User.defaultUser;
import static com.epam.jdi.light.mobile.MobileUtils.executeDriverMethod;

public class nativeMobileTests extends BaseTest {

    @BeforeMethod
    public void init() {
    }

    @Test()
    public void loginTest() {
        Boolean hasCredos = true;
        if (hasCredos)
            startPage.loginUsingGoogleCredos.click();
        else {
            googleModal.out.click();
            startPage.changeLanguage.click();
            startPage.englishLanguage.click();
            startPage.loginButton.click();
            loginForm.login(defaultUser);
        }
        newPostPageObject.newPostButton.isDisplayed();
    }

    @Test
    public void newPostTest() {
        startPage.loginUsingGoogleCredos.click();
        postTestLogic("This post was made by Appium mobile gang", true);
    }

    @Test
    public void newPostUsingDownloadedPhotoTest() throws IOException {
        startPage.loginUsingGoogleCredos.click();
        final String FILE_NAME = "src/test/resources/truecat.jpg";
        final String PATH = "/storage/emulated/0/DCIM/Camera/truecat.jpg";
        final String postText = "What a nice cat meme for an Appium mobile test";
        File file = new File(FILE_NAME);
        MobileFileManager.pushFile(PATH, file);
        postTestLogic(postText, false);
        Map<String, Object> args = new HashMap<>();
        args.put("command", "rm");
        args.put("args", Lists.newArrayList("-rf", PATH));
        executeScript("mobile: shell", args);
    }

    private void postTestLogic(String text, boolean useCamera) {
        newPostPageObject.newPostButton.click();
        if (useCamera) {
            newPostPageObject.goToPhotoButton.click();
            newPostPageObject.takePhotoButton.click();
        }
        else {
            newPostPageObject.openGalleryButton.click();
            newPostPageObject.openCameraGalleryButton.click();
            newPostPageObject.nextButton.click();
        }
        new Timer(1000L).wait(() -> newPostPageObject.nextButton.click());
        newPostPageObject.postTextField.setValue(text);
        newPostPageObject.nextButton.click();
    }

    public static void executeScript(String script, Map<String, Object> args) {
        executeDriverMethod(AppiumDriver.class, (AppiumDriver driver) -> driver.executeScript(script, args));
    }
}
