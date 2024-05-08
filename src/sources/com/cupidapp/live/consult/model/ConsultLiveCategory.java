package com.cupidapp.live.consult.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: ConsultTotalModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum ConsultLiveCategory {
    ASTROLABE("astrolabe"),
    TAROT("tarot"),
    PSYCHOLOGY("psychology");


    @NotNull
    private final String value;

    ConsultLiveCategory(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
