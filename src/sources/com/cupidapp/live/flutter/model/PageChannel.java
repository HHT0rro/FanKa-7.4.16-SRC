package com.cupidapp.live.flutter.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: PageChannel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum PageChannel {
    Roaming("roamingCountry"),
    ALL_NEED_CHANNEL_NAME("basicChannel"),
    MediaChannel("mediaChannel");


    @NotNull
    private final String value;

    PageChannel(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
