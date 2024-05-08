package com.huawei.openalliance.ad.uriaction;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.kv;
import com.huawei.openalliance.ad.constant.ae;
import com.huawei.openalliance.ad.constant.t;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.openalliance.ad.download.app.AppDownloadTask;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b extends q {
    private static final String Code = "AppDeepLinkAction";

    public b(Context context, AdContentData adContentData) {
        super(context, adContentData);
    }

    private void Z() {
        kv.Code(this.I, this.Z, ae.D, (Integer) 3, Integer.valueOf(com.huawei.openalliance.ad.utils.e.Code(this.I, this.Z.u().i()) ? 2 : 1));
    }

    @Override // com.huawei.openalliance.ad.uriaction.q
    public boolean Code() {
        String str;
        AdContentData adContentData;
        gl.V(Code, "handle AppDeepLinkAction");
        try {
            adContentData = this.Z;
        } catch (ActivityNotFoundException unused) {
            str = "activity not exist";
            gl.I(Code, str);
            Z();
            return V();
        } catch (Exception unused2) {
            str = "handle intent url fail";
            gl.I(Code, str);
            Z();
            return V();
        }
        if (adContentData != null && adContentData.u() != null) {
            AppInfo u10 = this.Z.u();
            Intent V = com.huawei.openalliance.ad.utils.e.V(this.I, u10.h(), u10.i());
            if (V == null) {
                gl.I(Code, "cannot find target activity");
                Z();
                return V();
            }
            if (!(this.I instanceof Activity)) {
                V.addFlags(268435456);
            }
            V.setClipData(u.cG);
            this.I.startActivity(V);
            if (!TextUtils.isEmpty(u10.Code())) {
                AppDownloadTask Code2 = new AppDownloadTask.a().Code(u10).Code();
                Code2.Code(this.Z);
                Code2.I(System.currentTimeMillis());
                com.huawei.openalliance.ad.download.app.l.Code(this.I).Code(u10.Code(), Code2);
            }
            Code(t.Code);
            kv.Code(this.I, this.Z, "intentSuccess", (Integer) 3, (Integer) null);
            return true;
        }
        gl.V(Code, "getAppInfo is null");
        return V();
    }
}
