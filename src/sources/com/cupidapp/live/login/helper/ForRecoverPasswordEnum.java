package com.cupidapp.live.login.helper;

import org.jetbrains.annotations.NotNull;

/* compiled from: LoginHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum ForRecoverPasswordEnum {
    Help("help"),
    ForgetPassword("forget-password"),
    InvalidNumber("invalid-number");


    @NotNull
    private final String type;

    ForRecoverPasswordEnum(String str) {
        this.type = str;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }
}
