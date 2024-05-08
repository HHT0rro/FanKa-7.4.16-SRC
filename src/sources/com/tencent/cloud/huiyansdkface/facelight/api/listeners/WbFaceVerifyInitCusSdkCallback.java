package com.tencent.cloud.huiyansdkface.facelight.api.listeners;

import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceError;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface WbFaceVerifyInitCusSdkCallback {
    void onInitFailed(WbFaceError wbFaceError);

    void onInitSuccess(Map<String, String> map);
}
