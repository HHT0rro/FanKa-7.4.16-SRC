package com.huawei.openalliance.ad.uriaction;

import android.content.Context;
import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.constant.t;
import com.huawei.openalliance.ad.download.app.AppDownloadTask;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class m extends q {
    private static final String Code = "OpenMiniPageAction";
    private int V;

    public m(Context context, AdContentData adContentData) {
        super(context, adContentData);
        this.V = 2;
    }

    private AppDownloadTask Code(AppInfo appInfo) {
        AppDownloadTask V = com.huawei.openalliance.ad.download.app.g.I().V(appInfo);
        if (V != null) {
            AdContentData adContentData = this.Z;
            if (adContentData != null) {
                V.Z(adContentData.C());
                V.B(this.Z.s());
                V.C(this.Z.S());
                V.I(this.Z.B());
                V.a(this.Z.az());
                V.C(this.Z.aA());
            }
        } else {
            V = new AppDownloadTask.a().Code(appInfo).Code();
            if (V != null) {
                V.Code(Integer.valueOf(this.V));
                V.Code(this.Z);
                AdContentData adContentData2 = this.Z;
                if (adContentData2 != null) {
                    V.B(adContentData2.s());
                    V.Z(this.Z.C());
                    V.C(this.Z.S());
                    V.I(this.Z.B());
                    V.a(this.Z.az());
                    V.C(this.Z.aA());
                }
            }
        }
        return V;
    }

    public void Code(int i10) {
        this.V = i10;
    }

    @Override // com.huawei.openalliance.ad.uriaction.q
    public boolean Code() {
        gl.V(Code, "handle OpenMiniPageAction");
        AdContentData adContentData = this.Z;
        if (adContentData == null || adContentData.u() == null) {
            gl.V(Code, "getAppInfo is null");
            return V();
        }
        AppInfo u10 = this.Z.u();
        if (u10 != null && com.huawei.openalliance.ad.utils.e.Code(this.I, u10.Code())) {
            gl.V(Code, "app installed");
            return V();
        }
        AppDownloadTask Code2 = Code(u10);
        if (Code2 == null) {
            gl.V(Code, "downloadTask is null");
            return V();
        }
        Code2.S(this.Z.ao());
        Code2.F(this.Z.ap());
        Code2.Code(Integer.valueOf(this.V));
        Code2.D(this.Z.E());
        Code2.I((Integer) 1);
        Code(t.F);
        com.huawei.openalliance.ad.download.app.g.I().Code(Code2);
        return true;
    }
}
