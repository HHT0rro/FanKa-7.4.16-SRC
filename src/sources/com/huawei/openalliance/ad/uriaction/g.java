package com.huawei.openalliance.ad.uriaction;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.constant.t;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.utils.bb;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class g extends q {
    private static final String Code = "HarmonyAppAction";

    public g(Context context, AdContentData adContentData) {
        super(context, adContentData);
    }

    @Override // com.huawei.openalliance.ad.uriaction.q
    public boolean Code() {
        try {
            gl.V(Code, "handle harmony app action");
            AppInfo u10 = this.Z.u();
            if (u10 == null || TextUtils.isEmpty(u10.Code())) {
                gl.V(Code, "parameters occur error");
            } else if (Boolean.parseBoolean((String) bb.Code(this.I, this.Z, 11, String.class))) {
                Code(t.Z);
                return true;
            }
        } catch (Throwable th) {
            gl.I(Code, "handle uri exception: %s", th.getClass().getSimpleName());
        }
        return V();
    }
}
