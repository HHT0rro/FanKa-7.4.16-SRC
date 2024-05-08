package com.mobile.auth.gatewayauth.manager.compat;

import com.mobile.auth.gatewayauth.annotations.SafeProtector;
import com.mobile.auth.gatewayauth.model.TokenRet;

@SafeProtector
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface ResultCodeProcessor {
    String convertCode(String str);

    TokenRet convertErrorInfo(String str, String str2, String str3);

    String getApiLevel();
}
