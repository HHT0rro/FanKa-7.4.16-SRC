package com.huawei.hms.ads;

import com.huawei.openalliance.ad.inter.data.AdContentData;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ij {
    public static ik Code(AdContentData adContentData) {
        if (adContentData == null) {
            return new ii();
        }
        if (adContentData.p() != null || (adContentData.q() != null && com.huawei.openalliance.ad.constant.bb.Code.equals(adContentData.q().Code()))) {
            if (in.C()) {
                return new in();
            }
        } else if (Cif.Code()) {
            return new Cif();
        }
        return new ii();
    }
}
