package com.cupidapp.live.flutter.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: PageName.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum PageName {
    Roaming("roamingCityPage"),
    Empty("emptyEnginPage"),
    MediaPicker("mediaPickerPage");


    @NotNull
    private final String value;

    PageName(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
