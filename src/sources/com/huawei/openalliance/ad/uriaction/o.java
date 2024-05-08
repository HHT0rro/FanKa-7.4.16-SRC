package com.huawei.openalliance.ad.uriaction;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.kt;
import com.huawei.hms.ads.lc;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.ai;
import com.huawei.openalliance.ad.utils.au;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class o extends q {
    private static final String Code = "OuterWebCCTAction";

    public o(Context context, AdContentData adContentData) {
        super(context, adContentData);
    }

    @Override // com.huawei.openalliance.ad.uriaction.q
    public boolean Code() {
        AdContentData adContentData = this.Z;
        if (adContentData == null || !(kt.Code(adContentData.r()) || ai.Z(this.I))) {
            return V();
        }
        gl.Code(Code, "handleUri by cct, pkgName is : %s", this.I.getPackageName());
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        String e2 = this.Z.e();
        if (!au.Code(e2)) {
            Uri parse = Uri.parse(e2);
            intent.setData(parse);
            if (!(this.I instanceof Activity)) {
                intent.addFlags(268435456);
            }
            try {
                lc.Code().Code(this.I, parse, true);
                Code("web");
                return true;
            } catch (ActivityNotFoundException unused) {
                gl.Z(Code, "fail to open uri by cct");
            } catch (Throwable th) {
                gl.Z(Code, "handle uri exception: %s", th.getClass().getSimpleName());
            }
        }
        return V();
    }
}
