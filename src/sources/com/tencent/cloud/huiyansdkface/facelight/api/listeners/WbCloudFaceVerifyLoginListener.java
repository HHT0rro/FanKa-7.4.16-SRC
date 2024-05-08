package com.tencent.cloud.huiyansdkface.facelight.api.listeners;

import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceError;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface WbCloudFaceVerifyLoginListener {
    void onLoginFailed(WbFaceError wbFaceError);

    void onLoginSuccess();
}
