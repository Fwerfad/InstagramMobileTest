package nativeapp.jdi.app;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class GoogleModal {
    @MobileFindBy(id = "com.google.android.gms:id/cancel")
    public Button out;
}
