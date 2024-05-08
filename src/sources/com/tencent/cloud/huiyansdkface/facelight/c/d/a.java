package com.tencent.cloud.huiyansdkface.facelight.c.d;

import android.content.Context;
import android.hardware.Camera;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import com.tencent.cloud.huiyansdkface.a.g.a;
import com.tencent.cloud.huiyansdkface.facelight.c.a.e;
import com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer;
import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.facelight.common.WbCloudNetSecurityManger;
import com.tencent.cloud.huiyansdkface.facelight.common.WbSecureProviders;
import com.tencent.cloud.huiyansdkface.facelight.net.SendTuringCamToken;
import com.tencent.cloud.huiyansdkface.facelight.net.SendTuringPackage;
import com.tencent.cloud.huiyansdkface.facelight.net.model.Param;
import com.tencent.cloud.huiyansdkface.facelight.net.model.result.TuringPackageResult;
import com.tencent.cloud.huiyansdkface.normal.thread.ThreadOperate;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cloud.huiyansdkface.wehttp2.WeReq;
import com.tencent.turingcam.TuringCallback;
import com.tencent.turingcam.TuringFaceDefender;
import com.tencent.turingcam.view.TuringPreviewDisplay;
import java.io.IOException;
import java.util.Properties;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a implements c {

    /* renamed from: a, reason: collision with root package name */
    private TuringPreviewDisplay f40656a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f40657b;

    /* renamed from: c, reason: collision with root package name */
    private long f40658c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f40659d;

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        WLogger.d("TuringFaceHelper", "sendTuringPackage");
        final String generateAESKey = WbCloudNetSecurityManger.generateAESKey();
        final boolean isUseGm = WbSecureProviders.isUseGm();
        final String encryptAESKey = WbCloudNetSecurityManger.encryptAESKey(isUseGm, generateAESKey, "sendTuringPackage:");
        SendTuringPackage.requestExec(com.tencent.cloud.huiyansdkface.facelight.process.d.z().a(), generateAESKey, encryptAESKey, isUseGm, new WeReq.Callback<SendTuringPackage.GetFaceCompareTypeResponse>() { // from class: com.tencent.cloud.huiyansdkface.facelight.c.d.a.3
            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(WeReq weReq, SendTuringPackage.GetFaceCompareTypeResponse getFaceCompareTypeResponse) {
                TuringPackageResult turingPackageResult;
                KycWaSDK kycWaSDK;
                String str;
                WLogger.d("TuringFaceHelper", "sendTuringPackage onSuccess");
                if (getFaceCompareTypeResponse == null) {
                    WLogger.w("TuringFaceHelper", "TuringPackage failed! baseResponse is null！");
                    kycWaSDK = KycWaSDK.getInstance();
                    str = "baseResponse is null！";
                } else {
                    String str2 = isUseGm ? getFaceCompareTypeResponse.encryptBody : getFaceCompareTypeResponse.enMsg;
                    if (!TextUtils.isEmpty(str2)) {
                        WLogger.d("TuringFaceHelper", "start decry response");
                        try {
                            turingPackageResult = (TuringPackageResult) WbCloudNetSecurityManger.decry(isUseGm, str2, TuringPackageResult.class, generateAESKey);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            WLogger.w("TuringFaceHelper", "result decry failed!" + e2.toString());
                            Properties properties = new Properties();
                            properties.setProperty("enKey", encryptAESKey);
                            properties.setProperty("isGm", String.valueOf(isUseGm));
                            KycWaSDK.getInstance().trackCustomKVEvent(null, "faceservice_data_serialize_decry_fail", "decry TuringPackage failed!" + e2.toString(), properties);
                            turingPackageResult = null;
                        }
                        if (turingPackageResult != null) {
                            String str3 = turingPackageResult.isNeedRequest;
                            if (TextUtils.isEmpty(str3) || !str3.equals("1")) {
                                return;
                            }
                            WLogger.d("TuringFaceHelper", "needDoFrameCheck");
                            a.this.f40659d = true;
                            String str4 = turingPackageResult.param;
                            if (TextUtils.isEmpty(str4)) {
                                WLogger.w("TuringFaceHelper", "need frames check,BUT param is null!");
                                KycWaSDK.getInstance().trackCustomKVEvent(null, "facepage_turing_server_error", "need frames check,BUT param is null!", null);
                                return;
                            } else {
                                WLogger.d("TuringFaceHelper", "start FrameCheck");
                                a.this.f40658c = System.currentTimeMillis();
                                TuringFaceDefender.startFrameCheck(str4);
                                return;
                            }
                        }
                        return;
                    }
                    WLogger.w("TuringFaceHelper", "TuringPackage failed,enMsg is null！");
                    kycWaSDK = KycWaSDK.getInstance();
                    str = "enMsg is null！" + getFaceCompareTypeResponse.code + "," + getFaceCompareTypeResponse.msg;
                }
                kycWaSDK.trackCustomKVEvent(null, "facepage_turing_server_error", str, null);
            }

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public void onFailed(WeReq weReq, WeReq.ErrType errType, int i10, String str, IOException iOException) {
                WLogger.d("TuringFaceHelper", "sendTuringPackage onFailed:" + ((Object) errType) + ",code=" + i10 + ",s=" + str);
                KycWaSDK.getInstance().trackCustomKVEvent(null, "facepage_turing_network_error", "sendTuringPackage onFailed:" + ((Object) errType) + ",code=" + i10 + ",s=" + str, null);
            }

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public void onFinish() {
            }

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public void onStart(WeReq weReq) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        WLogger.d("TuringFaceHelper", "sendTuringCamToken");
        String generateAESKey = WbCloudNetSecurityManger.generateAESKey();
        boolean isUseGm = WbSecureProviders.isUseGm();
        SendTuringCamToken.requestExec(com.tencent.cloud.huiyansdkface.facelight.process.d.z().a(), generateAESKey, WbCloudNetSecurityManger.encryptAESKey(isUseGm, generateAESKey, "sendTuringCamToken:"), isUseGm, new WeReq.Callback<SendTuringCamToken.TuringCamTokenResponse>() { // from class: com.tencent.cloud.huiyansdkface.facelight.c.d.a.4
            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(WeReq weReq, SendTuringCamToken.TuringCamTokenResponse turingCamTokenResponse) {
                WLogger.d("TuringFaceHelper", "SendTuringCamToken onSuccess");
                if (turingCamTokenResponse == null) {
                    KycWaSDK.getInstance().trackCustomKVEvent(null, "facepage_turing_cam_server_error", "SendTuringCamToken turingCamTokenResponse is null!", null);
                    return;
                }
                String str = turingCamTokenResponse.code;
                if ("0".equals(str)) {
                    KycWaSDK.getInstance().trackCustomKVEvent(null, "facepage_turing_cam_success", null, null);
                    return;
                }
                KycWaSDK.getInstance().trackCustomKVEvent(null, "facepage_turing_cam_server_error", str + "," + turingCamTokenResponse.msg, null);
            }

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public void onFailed(WeReq weReq, WeReq.ErrType errType, int i10, String str, IOException iOException) {
                WLogger.e("TuringFaceHelper", "SendTuringCamToken onFailed:" + ((Object) errType) + ",code=" + i10 + "s=" + str);
                KycWaSDK.getInstance().trackCustomKVEvent(null, "facepage_turing_cam_network_error", "SendTuringCamToken onFailed:" + ((Object) errType) + ",code=" + i10 + "s=" + str, null);
            }

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public void onFinish() {
            }

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public void onStart(WeReq weReq) {
            }
        });
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.c.d.c
    public View a(Context context) {
        if (this.f40656a == null) {
            TuringPreviewDisplay turingPreviewDisplay = new TuringPreviewDisplay(context);
            this.f40656a = turingPreviewDisplay;
            turingPreviewDisplay.setBackgroundColor(-16777216);
        }
        return this.f40656a;
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.c.d.c
    public e a() {
        return new e();
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.c.d.c
    public void a(Camera camera) {
        TuringFaceDefender.setPreviewDisplay(camera, this.f40656a);
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.c.d.c
    public void a(Camera camera, String str) {
        WLogger.d("TuringFaceHelper", "start TuringFaceDefender");
        this.f40658c = System.currentTimeMillis();
        KycWaSDK.getInstance().trackCustomKVEvent(null, "turing_sdk_start", null, null);
        TuringFaceDefender.start(camera, str);
        ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.c.d.a.2
            @Override // java.lang.Runnable
            public void run() {
                long V = com.tencent.cloud.huiyansdkface.facelight.process.d.z().e().V();
                WLogger.d("TuringFaceHelper", "start count down get turingSdk Result time:" + V);
                new CloudFaceCountDownTimer(V, V / 2) { // from class: com.tencent.cloud.huiyansdkface.facelight.c.d.a.2.1
                    @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
                    public void onFinish() {
                        WLogger.d("TuringFaceHelper", "count down get turingSdk Result onFinish.");
                        if (a.this.f40657b) {
                            return;
                        }
                        WLogger.w("TuringFaceHelper", "get turingSdk Result > 1s, time out!");
                        KycWaSDK.getInstance().trackCustomKVEvent(null, "turing_sdk_out_of_time", null, null);
                        a.this.f40657b = true;
                    }

                    @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
                    public void onTick(long j10) {
                        WLogger.d("TuringFaceHelper", "count down get turingSdk Result onTick.");
                    }
                }.start();
            }
        });
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.c.d.c
    public void a(final a.InterfaceC0616a interfaceC0616a) {
        TuringFaceDefender.setCallback(new TuringCallback() { // from class: com.tencent.cloud.huiyansdkface.facelight.c.d.a.1
            @Override // com.tencent.turingcam.TuringCallback
            public void onException(Throwable th) {
                if (th == null) {
                    WLogger.e("TuringFaceHelper", "onException:throwable is null!");
                    KycWaSDK.getInstance().trackCustomKVEvent(null, "turing_sdk_exception", "throwable is null!", null);
                    return;
                }
                th.printStackTrace();
                String stackTraceString = Log.getStackTraceString(th);
                if (TextUtils.isEmpty(stackTraceString)) {
                    stackTraceString = th.toString();
                }
                WLogger.e("TuringFaceHelper", "onException:" + stackTraceString);
                KycWaSDK.getInstance().trackCustomKVEvent(null, "turing_sdk_exception", stackTraceString, null);
            }

            @Override // com.tencent.turingcam.TuringCallback
            public void onFinish(long j10, byte[] bArr) {
                if (j10 == 0) {
                    long currentTimeMillis = System.currentTimeMillis() - a.this.f40658c;
                    WLogger.d("TuringFaceHelper", "get turingResult:" + currentTimeMillis);
                    KycWaSDK.getInstance().trackCustomKVEvent(null, "turing_sdk_success", String.valueOf(currentTimeMillis), null);
                    Param.setTuringPackage(Base64.encodeToString(bArr, 2));
                    if (a.this.f40657b) {
                        return;
                    }
                    a.this.f40657b = true;
                    a.this.d();
                    return;
                }
                int i10 = (int) (j10 / (-100000));
                int i11 = (int) (j10 % (100000 * i10));
                WLogger.e("TuringFaceHelper", "retCode=" + j10 + ",Stage=" + i10 + ",errCode=" + i11);
                KycWaSDK.getInstance().trackCustomKVEvent(null, "turing_sdk_failed", "retCode=" + j10 + ",Stage=" + i10 + ",errCode=" + i11, null);
            }

            @Override // com.tencent.turingcam.TuringCallback
            public void onFinishFrameCheck(long j10, byte[] bArr) {
                WLogger.d("TuringFaceHelper", "onFinishFrameCheck:" + j10);
                if (j10 != 0) {
                    KycWaSDK.getInstance().trackCustomKVEvent(null, "turing_sdk_camera_failed", "code=" + j10, null);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis() - a.this.f40658c;
                WLogger.d("TuringFaceHelper", "get turingCameraResult:" + currentTimeMillis);
                KycWaSDK.getInstance().trackCustomKVEvent(null, "turing_sdk_camera_success", String.valueOf(currentTimeMillis), null);
                Param.setTuringVideoData(Base64.encodeToString(bArr, 2));
                a.this.e();
            }

            @Override // com.tencent.turingcam.TuringCallback
            public void onPreviewAvailable() {
                interfaceC0616a.a();
            }

            @Override // com.tencent.turingcam.TuringCallback
            public void onPreviewDestroyed() {
                interfaceC0616a.b();
            }
        });
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.c.d.c
    public void a(byte[] bArr) {
        TuringFaceDefender.processFrame(bArr);
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.c.d.c
    public boolean b() {
        return this.f40659d;
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.c.d.c
    public void c() {
        TuringFaceDefender.setCallback(null);
    }
}
