package com.tencent.cloud.huiyansdkface.facelight.process.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.cloud.huiyansdkface.facelight.c.e.b;
import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.facelight.net.model.FaceWillResult;
import com.tencent.cloud.huiyansdkface.facelight.net.model.request.actlight.FlashReq;
import com.tencent.cloud.huiyansdkface.facelight.net.model.request.actlight.SelectData;
import com.tencent.cloud.huiyansdkface.facelight.process.FaceVerifyStatus;
import com.tencent.cloud.huiyansdkface.facelight.process.d;
import com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback;
import com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceInnerError;
import com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceModeProviders;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cloud.huiyansdkface.record.WeMediaManager;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ReflectColorData;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.YTImageInfo;
import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private d f40774a;

    /* renamed from: b, reason: collision with root package name */
    private FaceVerifyStatus f40775b;

    public a(d dVar, FaceVerifyStatus faceVerifyStatus) {
        this.f40774a = dVar;
        this.f40775b = faceVerifyStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        WLogger.i("CompareService", "deleteWillVideos");
        b.a(str);
        b.a(str2);
    }

    private void b(boolean z10, String str, byte[] bArr, ReflectColorData reflectColorData, YTImageInfo yTImageInfo, YTImageInfo yTImageInfo2, YTImageInfo yTImageInfo3, String str2, String str3, String str4, String str5, String str6, ProcessCallback<FaceWillResult> processCallback) {
        String str7;
        String str8;
        if (TextUtils.isEmpty(str6)) {
            str7 = "null scrnshotImg";
        } else {
            str7 = "" + str6.length();
        }
        WLogger.d("CompareService", "prepareAndStartNetworkUpload:" + str7);
        com.tencent.cloud.huiyansdkface.facelight.a.b.a x10 = this.f40774a.x();
        String R = x10.R();
        String t2 = this.f40774a.e().t();
        SelectData selectData = new SelectData(Float.valueOf(str).floatValue());
        WLogger.d("CompareService", "selectData=" + selectData.toString());
        byte[] videoByte = WeMediaManager.getInstance().getVideoByte();
        byte[] bArr2 = new byte[0];
        if (bArr != null && bArr.length != 0) {
            byte[] b4 = b.b(bArr);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ytProguardByte=");
            sb2.append(b4 == null ? 0 : b4.length);
            WLogger.d("CompareService", sb2.toString());
            bArr2 = b4;
        }
        byte[] bArr3 = new byte[0];
        if (!z10 && videoByte != null) {
            bArr3 = b.b(videoByte);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("wbProguardByte=");
            sb3.append(bArr3 != null ? bArr3.length : 0);
            WLogger.d("CompareService", sb3.toString());
        }
        byte[] bArr4 = bArr3;
        try {
            str8 = b.a(bArr2, bArr4, d.z().x().W());
        } catch (Exception e2) {
            e2.printStackTrace();
            WLogger.w("CompareService", "generateFileMd5 failed:" + e2.toString());
            KycWaSDK.getInstance().trackCustomKVEvent(null, "faceservice_generate_fileMd5_fail", "GetFaceResult generateFileMd5 failed!" + e2.toString(), null);
            str8 = null;
        }
        FlashReq flashReq = new FlashReq();
        flashReq.colorData = x10.M();
        flashReq.liveSelectData = selectData;
        flashReq.reflectData = reflectColorData;
        flashReq.liveImage = yTImageInfo;
        flashReq.eyeImage = yTImageInfo2;
        flashReq.mouthImage = yTImageInfo3;
        WbFaceModeProviders.faceMode().getFaceResult(this.f40774a.e().ak(), bArr2, bArr4, str8, R, t2, flashReq, str2, str3, str4, str5, str6, processCallback);
    }

    public void a(Context context, final boolean z10, final File file, final ProcessCallback processCallback) {
        if (this.f40775b.d() == 9) {
            WLogger.d("CompareService", "On finish Step,No more compared!");
            return;
        }
        byte[] b4 = b.b(b.a(file));
        String str = null;
        try {
            str = b.a(b4, null, d.z().x().W());
        } catch (Exception e2) {
            e2.printStackTrace();
            WLogger.w("CompareService", "uploadWillVideo generateFileMd5 failed:" + e2.toString());
            KycWaSDK.getInstance().trackCustomKVEvent(null, "faceservice_generate_fileMd5_fail", "uploadWillVideo generateFileMd5 failed!" + e2.toString(), null);
        }
        final String a10 = b.a(context, b4);
        WLogger.d("CompareService", "videoProguardPath =" + a10);
        WbFaceModeProviders.faceMode().uploadFaceWillVideo(this.f40774a.e().aj(), str, a10, new ProcessCallback() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.a.a.1
            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
            public void onFailed(WbFaceInnerError wbFaceInnerError) {
                if (!z10) {
                    a.this.a(file.getAbsolutePath(), a10);
                }
                processCallback.onFailed(wbFaceInnerError);
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
            public void onSuccess(Object obj) {
                if (!z10) {
                    a.this.a(file.getAbsolutePath(), a10);
                }
                processCallback.onSuccess(null);
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
            public void onUiNetworkRetryTip() {
            }
        });
    }

    public void a(boolean z10, String str, byte[] bArr, ReflectColorData reflectColorData, YTImageInfo yTImageInfo, YTImageInfo yTImageInfo2, YTImageInfo yTImageInfo3, String str2, String str3, String str4, String str5, String str6, ProcessCallback<FaceWillResult> processCallback) {
        if (this.f40775b.d() == 9) {
            WLogger.d("CompareService", "On finish Step,No more compared!");
        } else {
            b(z10, str, bArr, reflectColorData, yTImageInfo, yTImageInfo2, yTImageInfo3, str2, str3, str4, str5, str6, processCallback);
        }
    }
}
