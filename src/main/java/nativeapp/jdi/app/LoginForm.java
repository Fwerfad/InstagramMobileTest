package nativeapp.jdi.app;

import com.epam.jdi.light.mobile.elements.base.MobileAppUIElement;
import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.common.app.android.TextField;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;
import nativeapp.jdi.elements.User;

public class LoginForm{
    @MobileFindBy(xpath = "//*[contains(@text, 'username')]")
    public TextField email;

    @MobileFindBy(xpath = "//*[@text='Password']")
    public TextField password;

    @MobileFindBy(xpath = "//*[@text='Log In']")
    public Button login;

    @MobileFindBy(id = "com.instagram.android:id/language_selector_button")
    public MobileAppUIElement changeLanguage;

    public void login(User user, boolean closeModal) {
        email.setValue(user.email);
        if (closeModal)
            changeLanguage.click(0, 100);
        password.setValue(user.password);
        login.click();
    }
}
