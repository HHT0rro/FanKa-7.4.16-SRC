package com.cupidapp.live.login.helper;

import org.jetbrains.annotations.NotNull;

/* compiled from: SignInResultHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum LoginMethod {
    UserNameAndPassWordLogin("用户名加密码登录"),
    PhoneNumberAndPasswordLogin("手机号加密码登录"),
    VerificationCodeLogin("验证码登录"),
    OneClickLogin("一键登录"),
    CONVENIENT("CONVENIENT");


    @NotNull
    private final String method;

    LoginMethod(String str) {
        this.method = str;
    }

    @NotNull
    public final String getMethod() {
        return this.method;
    }
}
