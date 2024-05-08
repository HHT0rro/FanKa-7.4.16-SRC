package com.mobile.auth.gatewayauth;

import com.mobile.auth.gatewayauth.annotations.AuthNumber;
import com.mobile.auth.gatewayauth.annotations.SafeProtector;

@AuthNumber
@SafeProtector
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface PreLoginResultListener {
    void onTokenFailed(String str, String str2);

    void onTokenSuccess(String str);
}
