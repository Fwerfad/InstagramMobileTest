package nativeapp.jdi.app;

import com.epam.jdi.light.mobile.elements.base.MobileAppUIElement;
import com.epam.jdi.light.mobile.elements.common.app.android.TextField;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;
import com.epam.jdi.tools.Timer;

import static nativeapp.jdi.InstagramApp.newPostPageObject;

public class NewPostPageObject {
    @MobileFindBy(id = "com.instagram.android:id/creation_tab")
    public MobileAppUIElement newPostButton;

    @MobileFindBy(xpath = "//*[contains(@text, 'НЕСКОЛЬКО')]/parent::*/following-sibling::*")
    public MobileAppUIElement goToPhotoButton;

    @MobileFindBy(id = "com.instagram.android:id/camera_shutter_button")
    public MobileAppUIElement takePhotoButton;

    @MobileFindBy(id = "com.instagram.android:id/next_button_imageview")
    public MobileAppUIElement nextButton;

    @MobileFindBy(id = "com.instagram.android:id/caption_text_view")
    public TextField postTextField;

    @MobileFindBy(id = "com.instagram.android:id/gallery_folder_menu_alt")
    public MobileAppUIElement openGalleryButton;

    @MobileFindBy(id = "com.instagram.android:id/gallery_preview_button")
    public MobileAppUIElement openCameraGalleryButton;

    public void startNewPostCreation() {
        newPostButton.click();
    }

    public void useCamera() {
        newPostPageObject.goToPhotoButton.click();
        newPostPageObject.takePhotoButton.click();
    }

    public void useGallery() {
        new Timer(2000L).wait(() ->
                newPostPageObject.openGalleryButton.click());
        newPostPageObject.openCameraGalleryButton.click();
        newPostPageObject.nextButton.click();
    }

    public void finishPost(String text) {
        new Timer(1000L).wait(() ->
                newPostPageObject.nextButton.click());
        newPostPageObject.postTextField.setValue(text);
        newPostPageObject.nextButton.click();
    }
}
