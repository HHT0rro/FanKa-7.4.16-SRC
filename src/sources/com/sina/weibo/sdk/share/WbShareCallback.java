package com.sina.weibo.sdk.share;

import com.sina.weibo.sdk.common.UiError;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface WbShareCallback {
    void onCancel();

    void onComplete();

    void onError(UiError uiError);
}
