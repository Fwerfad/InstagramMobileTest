package nativeapp.jdi;

import com.epam.jdi.light.mobile.elements.pageobjects.annotations.JApp;
import nativeapp.jdi.app.GoogleModal;
import nativeapp.jdi.app.LoginForm;
import nativeapp.jdi.app.NewPostPageObject;
import nativeapp.jdi.app.StartPage;

@JApp(appPackage = "com.instagram.android", appActivity = "com.instagram.mainactivity.LauncherActivity")
public class InstagramApp {
    public static LoginForm loginForm;

    public static StartPage startPage;

    public static GoogleModal googleModal;

    public static NewPostPageObject newPostPageObject;
}
