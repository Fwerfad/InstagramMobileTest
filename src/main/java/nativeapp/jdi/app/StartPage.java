package nativeapp.jdi.app;

import com.epam.jdi.light.mobile.elements.base.MobileAppUIElement;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;
import com.epam.jdi.light.ui.html.elements.common.Button;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class StartPage {
    @MobileFindBy(id = "com.instagram.android:id/log_in_button")
    public MobileAppUIElement loginButton;

    @MobileFindBy(id = "com.instagram.android:id/sign_up_with_email_or_phone")
    public MobileAppUIElement signUpButton;

    @MobileFindBy(id = "com.instagram.android:id/language_selector_button")
    public MobileAppUIElement changeLanguage;

    @MobileFindBy(xpath = "//*[@resource-id='com.instagram.android:id/language_locale_list']/*[1]")
    public MobileAppUIElement englishLanguage;

    @MobileFindBy(xpath = "//*[@resource-id='com.google.android.gms:id/credential_picker_options']/*[3]")
    public MobileAppUIElement loginUsingGoogleCredos;
}
