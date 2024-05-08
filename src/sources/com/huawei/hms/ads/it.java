package com.huawei.hms.ads;

import com.iab.omid.library.huawei.adsession.AdSessionConfiguration;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class it implements ja {
    private static boolean Code = ip.Code(ip.f29311g);
    private static final String V = "AdSessionConfiguration";
    private AdSessionConfiguration I;

    private it(iw iwVar, jb jbVar, jc jcVar, jc jcVar2, boolean z10) {
        this.I = null;
        if (iw.Code() && jb.Code() && jc.Code()) {
            this.I = AdSessionConfiguration.createAdSessionConfiguration(iw.Code(iwVar), jb.Code(jbVar), jc.Code(jcVar), jc.Code(jcVar2), z10);
        }
    }

    public static it Code(iw iwVar, jb jbVar, jc jcVar, jc jcVar2, boolean z10) {
        if (Code) {
            return new it(iwVar, jbVar, jcVar, jcVar2, z10);
        }
        return null;
    }

    public static boolean Code() {
        return Code;
    }

    public AdSessionConfiguration V() {
        return this.I;
    }
}
