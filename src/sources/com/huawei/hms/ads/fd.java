package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.download.app.c;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.m;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class fd extends ez {
    public static final String I = "16";
    public static final String V = "15";
    private static final String Z = "AlertReminder";

    public fd(Context context) {
        super(context);
    }

    private void I(final com.huawei.openalliance.ad.inter.data.AppInfo appInfo, final AdContentData adContentData, long j10) {
        gl.V(Z, "showNonWifiAlert, context:" + ((Object) Code()));
        com.huawei.openalliance.ad.download.app.f.V(Code(), j10, new m.a() { // from class: com.huawei.hms.ads.fd.1
            @Override // com.huawei.openalliance.ad.utils.m.a
            public void Code() {
                c.Code(fd.this.Code, "15", adContentData, new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.fd.1.1
                    @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                    public void onRemoteCallResult(String str, CallResult<String> callResult) {
                        if (callResult.getCode() != -1) {
                            gl.V(fd.Z, " traffic reminder accept");
                        }
                    }
                }, String.class);
                fd.this.Code(appInfo);
            }

            @Override // com.huawei.openalliance.ad.utils.m.a
            public void V() {
                c.Code(fd.this.Code, "16", adContentData, new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.fd.1.2
                    @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                    public void onRemoteCallResult(String str, CallResult<String> callResult) {
                        if (callResult.getCode() != -1) {
                            gl.V(fd.Z, " traffic reminder reject");
                        }
                    }
                }, String.class);
                fd.this.V(appInfo);
            }
        });
    }

    @Override // com.huawei.hms.ads.ez
    public void Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo, AdContentData adContentData, long j10) {
        if (appInfo != null && adContentData != null) {
            I(appInfo, adContentData, j10);
        } else {
            gl.V(Z, "appInfo or contentRecord is empty");
            V(appInfo);
        }
    }
}
