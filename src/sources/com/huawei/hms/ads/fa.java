package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.download.app.c;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.m;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class fa extends ez {
    private static final String B = "117";
    private static final String I = "115";
    private static final String V = "ConfirmDownloadAlertStrategy";
    private static final String Z = "116";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements RemoteCallResultCallback<String> {
        private a() {
        }

        @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
        public void onRemoteCallResult(String str, CallResult<String> callResult) {
            if (callResult.getCode() != -1) {
                gl.V(fa.V, "confirm reminder reject");
            }
        }
    }

    public fa(Context context) {
        super(context);
    }

    private void Code(final com.huawei.openalliance.ad.inter.data.AppInfo appInfo, final AdContentData adContentData) {
        gl.V(V, "showConfirmDownloadAlert, context:" + ((Object) Code()));
        Code(I, adContentData);
        com.huawei.openalliance.ad.download.app.f.Code(Code(), new m.a() { // from class: com.huawei.hms.ads.fa.1
            @Override // com.huawei.openalliance.ad.utils.m.a
            public void Code() {
                fa.this.Code(fa.Z, adContentData);
                fa.this.Code(appInfo);
            }

            @Override // com.huawei.openalliance.ad.utils.m.a
            public void V() {
                fa.this.Code(fa.B, adContentData);
                fa.this.V(appInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(String str, AdContentData adContentData) {
        c.Code(this.Code, str, adContentData, new a(), String.class);
    }

    @Override // com.huawei.hms.ads.ez
    public void Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo, AdContentData adContentData, long j10) {
        if (appInfo != null && adContentData != null) {
            Code(appInfo, adContentData);
        } else {
            gl.V(V, "appInfo or contentRecord is empty");
            V(appInfo);
        }
    }
}
