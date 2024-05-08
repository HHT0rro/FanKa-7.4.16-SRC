package com.tencent.cloud.huiyansdkface.facelight.provider;

import android.app.FragmentManager;
import android.content.Context;
import com.tencent.cloud.huiyansdkface.facelight.net.model.FaceWillResult;
import com.tencent.cloud.huiyansdkface.facelight.net.model.WbFaceWillRes;
import com.tencent.cloud.huiyansdkface.facelight.net.model.request.actlight.FlashReq;
import com.tencent.cloud.huiyansdkface.facelight.net.model.result.LoginResult;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface WbFaceModeInterface {
    void getFaceResource(boolean z10, String str, ProcessCallback<WbFaceWillRes> processCallback);

    void getFaceResult(int i10, byte[] bArr, byte[] bArr2, String str, String str2, String str3, FlashReq flashReq, String str4, String str5, String str6, String str7, String str8, ProcessCallback<FaceWillResult> processCallback);

    PermissionInfo getPermissionList();

    int getProtocolImgSrc();

    void login(String str, String str2, long j10, ProcessCallback<LoginResult> processCallback);

    void onEnterFaceLivePage(WbUiTips wbUiTips);

    void onFaceStatusChanged(int i10);

    void onPreviewFrame(byte[] bArr);

    void onQuitFaceLivePage();

    void onStartFaceVerify(Context context);

    void startWill(FragmentManager fragmentManager, int i10, WillParam willParam, WbWillVideoEncodeFinishCallback wbWillVideoEncodeFinishCallback, WbWillFinishCallback wbWillFinishCallback, WbWillProcessCallback wbWillProcessCallback);

    void stopWill(FragmentManager fragmentManager);

    void uploadFaceWillVideo(int i10, String str, String str2, ProcessCallback processCallback);
}
