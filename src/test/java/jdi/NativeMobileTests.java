package jdi;

import com.epam.jdi.light.mobile.elements.common.MobileFileManager;
import com.epam.jdi.tools.Timer;
import io.appium.java_client.AppiumDriver;
import jdi.setup.TestInit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static nativeapp.jdi.InstagramApp.*;
import static nativeapp.jdi.elements.User.defaultUser;
import static com.epam.jdi.light.mobile.MobileUtils.executeDriverMethod;

public class NativeMobileTests extends TestInit {
    final String PATH = "/storage/emulated/0/DCIM/Camera/truecat.jpg";
    final String FILE_NAME = "resources/truecat.jpg";
    final String postText = "What a nice cat meme for an Appium mobile test";

    @Test()
    public void loginTest() {
        loginTestLogic(true);
    }

    @Test
    public void loginTestUsingGoogleCredos() {
        startPage.loginUsingGoogleCredos.click();
        newPostPageObject.newPostButton.isDisplayed();
    }

    @Test
    public void newPostTest() {
        startPage.loginUsingGoogleCredos.click();
        postTestLogic("This post was made by Appium mobile test", true);
    }

    @Test
    public void newPostUsingDownloadedPhotoTest() throws IOException {
        startPage.loginUsingGoogleCredos.click();
        File file = new File(FILE_NAME);
        MobileFileManager.pushFile(PATH, file);
        NativeMobileTests.postTestLogic(postText, false);
    }

    @AfterClass()
    private void removeFile() {
        Map<String, Object> args = new HashMap<>();
        args.put("command", "rm");
        args.put("args", Lists.newArrayList("-rf", PATH));
        executeScript("mobile: shell", args);
    }

    private void loginTestLogic(boolean closeModal) {
        new Timer(2000L).wait(() -> {
            googleModal.out.click();
        });
        startPage.changeLanguage.click();
        startPage.englishLanguage.click();
        startPage.loginButton.click();
        loginForm.login(defaultUser, closeModal);
        newPostPageObject.newPostButton.isDisplayed();
    }

    public static void postTestLogic(String text, boolean useCamera) {
        newPostPageObject.startNewPostCreation();
        if (useCamera) {
            newPostPageObject.useCamera();
        }
        else {
            newPostPageObject.useGallery();
        }
        newPostPageObject.finishPost(text);
        newPostPageObject.newPostButton.isDisplayed();
    }

    public static void executeScript(String script, Map<String, Object> args) {
        executeDriverMethod(AppiumDriver.class, (AppiumDriver driver) -> driver.executeScript(script, args));
    }
}
