package com.huawei.hms.ads;

import android.content.Context;
import com.iab.omid.library.huawei.adsession.AdSessionContext;
import com.iab.omid.library.huawei.adsession.Partner;
import com.iab.omid.library.huawei.adsession.VerificationScriptResource;
import java.io.IOException;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class iu implements ja {
    private static final String Code = "AdSessionContextWrapper";
    private static boolean I = ip.Code(ip.f29313i);
    private static final String V = "Huawei";
    private Context Z;

    public iu(Context context) {
        this.Z = context;
    }

    public static boolean Code() {
        return I;
    }

    public AdSessionContext Code(jd jdVar, String str) {
        String str2;
        if (!ip.Code(ip.f29320p) || !ip.Code(ip.f29321q) || !ip.Code(ip.f29313i)) {
            gl.I(Code, "createNativeAdSessionContext, not available ");
            return null;
        }
        List<VerificationScriptResource> V2 = jdVar.V();
        if (V2.isEmpty()) {
            return null;
        }
        try {
            str2 = com.huawei.openalliance.ad.utils.au.Code("openmeasure/omsdk-v1.js", this.Z);
        } catch (IOException e2) {
            gl.I(Code, "getNativeAdSession: " + com.huawei.openalliance.ad.utils.bc.Code(e2.getMessage()));
            str2 = null;
        }
        if (str2 == null) {
            return null;
        }
        return AdSessionContext.createNativeAdSessionContext(Partner.createPartner(V, "13.4.62.302"), str2, V2, str, (String) null);
    }
}
