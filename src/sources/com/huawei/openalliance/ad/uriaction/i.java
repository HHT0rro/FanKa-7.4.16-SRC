package com.huawei.openalliance.ad.uriaction;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.kv;
import com.huawei.openalliance.ad.constant.ae;
import com.huawei.openalliance.ad.constant.t;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class i extends q {
    private static final String C = "HwMarketAction";
    public static final String Code = "appId";
    private static final String F = "com.huawei.appmarket";
    private static final String S = "com.huawei.appmarket.appmarket.intent.action.AppDetail.withid";
    public static final String V = "thirdId";
    private String D;
    private String L;

    public i(Context context, AdContentData adContentData, Map<String, String> map) {
        super(context, adContentData);
        this.D = map.get("appId");
        this.L = map.get(V);
    }

    private void Z() {
        kv.Code(this.I, this.Z, ae.D, (Integer) 3, Integer.valueOf(com.huawei.openalliance.ad.utils.e.Code(this.I, "com.huawei.appmarket") ? 2 : 1));
    }

    @Override // com.huawei.openalliance.ad.uriaction.q
    public boolean Code() {
        gl.V(C, "handle hw app market action");
        Intent intent = new Intent(S);
        intent.setPackage("com.huawei.appmarket");
        intent.putExtra("appId", this.D);
        intent.putExtra(V, this.L);
        if (!(this.I instanceof Activity)) {
            intent.addFlags(268435456);
        }
        try {
            PackageManager packageManager = this.I.getPackageManager();
            if (packageManager != null && !packageManager.queryIntentActivities(intent, 65536).isEmpty()) {
                intent.setClipData(u.cG);
                this.I.startActivity(intent);
                Code(t.Code);
                kv.Code(this.I, this.Z, "intentSuccess", (Integer) 3, (Integer) null);
                return true;
            }
        } catch (ActivityNotFoundException unused) {
            gl.Z(C, "fail to open market detail page");
        }
        Z();
        return V();
    }
}
