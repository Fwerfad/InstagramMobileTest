package nativeapp.jdi.app;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.common.app.android.TextField;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;
import nativeapp.jdi.elements.User;

public class LoginForm extends Form<User> {
    @MobileFindBy(xpath = "//*[contains(@text, 'username')]")
    public TextField email;

    @MobileFindBy(xpath = "//*[@text='Password']")
    public TextField password;

    @MobileFindBy(xpath = "//*[@text='Log In']")
    public Button login;
}
