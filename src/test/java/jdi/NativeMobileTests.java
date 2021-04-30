package jdi;

import com.epam.jdi.light.mobile.elements.common.MobileFileManager;
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
import static com.epam.jdi.light.mobile.MobileUtils.executeDriverMethod;

public class NativeMobileTests extends TestInit {
    final String PATH = "/storage/emulated/0/DCIM/Camera/truecat.jpg";
    final String FILE_NAME = "resources/truecat.jpg";

    @Test
    public void newPostTest() {
        startPage.loginUsingGoogleCredos.click();
        postTestLogic(true);
    }

    @Test
    public void newPostUsingDownloadedPhotoTest() throws IOException {
        startPage.loginUsingGoogleCredos.click();
        File file = new File(FILE_NAME);
        MobileFileManager.pushFile(PATH, file);
        NativeMobileTests.postTestLogic(false);
    }

    @AfterClass()
    private void removeFile() {
        Map<String, Object> args = new HashMap<>();
        args.put("command", "rm");
        args.put("args", Lists.newArrayList("-rf", PATH));
        executeScript("mobile: shell", args);
    }

    public static void postTestLogic(boolean useCamera) {
        newPostPageObject.startNewPostCreation();
        if (useCamera) {
            newPostPageObject.useCamera();
        }
        else {
            newPostPageObject.useGallery();
        }
        newPostPageObject.finishPost();
    }

    public static void executeScript(String script, Map<String, Object> args) {
        executeDriverMethod(AppiumDriver.class, (AppiumDriver driver) -> driver.executeScript(script, args));
    }
}
