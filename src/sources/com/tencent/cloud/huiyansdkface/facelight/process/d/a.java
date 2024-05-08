package com.tencent.cloud.huiyansdkface.facelight.process.d;

import android.content.Context;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceVerifySdk;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceError;
import com.tencent.cloud.huiyansdkface.facelight.c.c;
import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.facelight.net.model.result.LoginResult;
import com.tencent.cloud.huiyansdkface.facelight.process.d;
import com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback;
import com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceInnerError;
import com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceModeProviders;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private d f40825a;

    /* renamed from: b, reason: collision with root package name */
    private c f40826b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f40827c;

    public a(d dVar, c cVar) {
        this.f40825a = dVar;
        this.f40826b = cVar;
    }

    public void a(final Context context, long j10, final ProcessCallback<LoginResult> processCallback) {
        WbCloudFaceVerifySdk.InputData i10 = this.f40825a.x().i();
        WbFaceModeProviders.faceMode().login(i10.nonce, i10.sign, j10, new ProcessCallback<LoginResult>() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.d.a.1
            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(LoginResult loginResult) {
                processCallback.onSuccess(loginResult);
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
            public void onFailed(WbFaceInnerError wbFaceInnerError) {
                if (!WbFaceError.WBFaceErrorDomainLoginNetwork.equals(wbFaceInnerError.domain) || a.this.f40827c) {
                    processCallback.onFailed(wbFaceInnerError);
                    return;
                }
                WLogger.d("LoginService", "first login network error,change url retry!");
                a.this.f40827c = true;
                KycWaSDK.getInstance().trackIMSWarnVEvent(context, "faceservice_login_retry_start", wbFaceInnerError.reason, null);
                a.this.f40826b.b(a.this.f40825a.x().X(), a.this.f40825a.x().P(), true);
                a.this.a(context, 14000L, processCallback);
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
            public void onUiNetworkRetryTip() {
            }
        });
    }
}
