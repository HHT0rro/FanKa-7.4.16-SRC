package com.cupidapp.live.base.network;

import org.jetbrains.annotations.NotNull;

/* compiled from: ResultErrorHandler.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum ResultShowErrorStyle {
    ALERT("alert"),
    JUMP("jump"),
    TOAST("toast");


    @NotNull
    private final String value;

    ResultShowErrorStyle(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
