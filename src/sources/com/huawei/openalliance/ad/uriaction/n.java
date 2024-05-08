package com.huawei.openalliance.ad.uriaction;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.ads.fr;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.kt;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.ai;
import com.huawei.openalliance.ad.utils.au;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class n extends q {
    private static final String Code = "OuterWebAction";

    public n(Context context, AdContentData adContentData) {
        super(context, adContentData);
    }

    private String Z() {
        for (String str : fr.Code(this.I).l()) {
            if (com.huawei.openalliance.ad.utils.e.Code(this.I, str)) {
                return str;
            }
        }
        return "";
    }

    @Override // com.huawei.openalliance.ad.uriaction.q
    public boolean Code() {
        AdContentData adContentData = this.Z;
        if (adContentData == null || !(kt.Code(adContentData.r()) || ai.Z(this.I))) {
            return V();
        }
        gl.V(Code, "handle outer browser action");
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        String e2 = this.Z.e();
        if (!au.Code(e2)) {
            intent.setData(Uri.parse(e2));
            if (!(this.I instanceof Activity)) {
                intent.addFlags(268435456);
            }
            try {
                if (kt.V(this.Z.r())) {
                    gl.Code(Code, "handleUri, use default browser");
                    String Z = Z();
                    if (TextUtils.isEmpty(Z)) {
                        gl.I(Code, "can not find default browser");
                    } else {
                        intent.setPackage(Z);
                    }
                }
                PackageManager packageManager = this.I.getPackageManager();
                if (packageManager != null && !packageManager.queryIntentActivities(intent, 65536).isEmpty()) {
                    intent.setClipData(u.cG);
                    this.I.startActivity(intent);
                    Code("web");
                    return true;
                }
            } catch (ActivityNotFoundException unused) {
                gl.Z(Code, "fail to open uri");
            } catch (Throwable th) {
                gl.Z(Code, "handle uri exception: %s", th.getClass().getSimpleName());
            }
        }
        return V();
    }
}
