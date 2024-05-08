package com.sina.weibo.sdk.auth;

import com.sina.weibo.sdk.common.UiError;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface WbAuthListener {
    void onCancel();

    void onComplete(Oauth2AccessToken oauth2AccessToken);

    void onError(UiError uiError);
}
