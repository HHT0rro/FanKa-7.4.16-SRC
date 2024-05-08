package com.tencent.cloud.huiyansdkface.facelight.provider;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface WbWillFinishCallback {
    void onAnswerErrorRestart();

    void onFinish(String str, String str2, String str3, String str4);

    void onNativeException(WbFaceInnerError wbFaceInnerError);

    void onNoVoiceRestart(WbFaceInnerError wbFaceInnerError);

    void onStartAsr();
}
