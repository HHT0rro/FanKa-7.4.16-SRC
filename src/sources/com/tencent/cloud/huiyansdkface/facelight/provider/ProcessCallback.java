package com.tencent.cloud.huiyansdkface.facelight.provider;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface ProcessCallback<T> {
    void onFailed(WbFaceInnerError wbFaceInnerError);

    void onSuccess(T t2);

    void onUiNetworkRetryTip();
}
