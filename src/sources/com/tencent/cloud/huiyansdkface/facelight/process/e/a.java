package com.tencent.cloud.huiyansdkface.facelight.process.e;

import android.text.TextUtils;
import com.tencent.cloud.huiyansdkface.facelight.net.model.WbFaceWillRes;
import com.tencent.cloud.huiyansdkface.facelight.process.FaceVerifyStatus;
import com.tencent.cloud.huiyansdkface.facelight.process.d;
import com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback;
import com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceInnerError;
import com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceModeProviders;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private FaceVerifyStatus f40831a;

    /* renamed from: b, reason: collision with root package name */
    private d f40832b;

    public a(d dVar, FaceVerifyStatus faceVerifyStatus) {
        this.f40831a = faceVerifyStatus;
        this.f40832b = dVar;
    }

    public void a(boolean z10, String str, final ProcessCallback<WbFaceWillRes> processCallback) {
        String str2;
        com.tencent.cloud.huiyansdkface.facelight.a.b.a x10 = this.f40832b.x();
        String N = x10.N();
        boolean z11 = true;
        if (N.contains("2") || N.contains("3")) {
            if (x10.l()) {
                str2 = "simple mode,need flash Resource!";
            } else if (z10) {
                str2 = "try again,need flash Resource!";
            } else if ((N.contains("2") && TextUtils.isEmpty(x10.R())) || (N.contains("3") && TextUtils.isEmpty(x10.M()))) {
                str2 = "Oops! Login didnt get flash Resource!Try again!";
            }
            WLogger.d("ResourceFetcher", str2);
            if (!WbFaceModeProviders.isUseWillSdk() || z11) {
                this.f40831a.a(false);
                WbFaceModeProviders.faceMode().getFaceResource(z11, str, new ProcessCallback<WbFaceWillRes>() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.e.a.1
                    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onSuccess(WbFaceWillRes wbFaceWillRes) {
                        a.this.f40831a.a(true);
                        a.this.f40831a.l();
                        processCallback.onSuccess(wbFaceWillRes);
                    }

                    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
                    public void onFailed(WbFaceInnerError wbFaceInnerError) {
                        processCallback.onFailed(wbFaceInnerError);
                    }

                    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
                    public void onUiNetworkRetryTip() {
                    }
                });
            } else {
                WLogger.i("ResourceFetcher", "no need to get flash resource");
                processCallback.onSuccess(null);
                return;
            }
        }
        z11 = false;
        if (WbFaceModeProviders.isUseWillSdk()) {
        }
        this.f40831a.a(false);
        WbFaceModeProviders.faceMode().getFaceResource(z11, str, new ProcessCallback<WbFaceWillRes>() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.e.a.1
            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(WbFaceWillRes wbFaceWillRes) {
                a.this.f40831a.a(true);
                a.this.f40831a.l();
                processCallback.onSuccess(wbFaceWillRes);
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
            public void onFailed(WbFaceInnerError wbFaceInnerError) {
                processCallback.onFailed(wbFaceInnerError);
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
            public void onUiNetworkRetryTip() {
            }
        });
    }
}
