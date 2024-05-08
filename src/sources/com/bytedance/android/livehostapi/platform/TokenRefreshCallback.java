package com.bytedance.android.livehostapi.platform;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface TokenRefreshCallback {
    void onFailed(Throwable th);

    void onSuccess(TokenInfo tokenInfo);
}
