package com.huawei.hms.ads;

import com.huawei.openalliance.ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class kw {
    public static com.huawei.openalliance.ad.inter.data.l Code(AdContentData adContentData) {
        com.huawei.openalliance.ad.inter.data.l lVar = new com.huawei.openalliance.ad.inter.data.l(adContentData);
        lVar.Code(adContentData);
        lVar.S(1);
        lVar.Code(adContentData.u());
        lVar.Z(adContentData.m());
        lVar.V(adContentData.k());
        lVar.F(adContentData.h());
        lVar.n(adContentData.S());
        lVar.I(adContentData.P());
        lVar.a(adContentData.e());
        lVar.i(adContentData.C());
        lVar.m(adContentData.B());
        lVar.j(adContentData.s());
        lVar.Z(adContentData.f());
        lVar.Code(adContentData.Z());
        lVar.C(adContentData.Q());
        lVar.e(adContentData.R());
        lVar.f(adContentData.r());
        lVar.Code(new com.huawei.openalliance.ad.inter.data.v(adContentData.p()));
        MetaData Z = adContentData.Z();
        if (Z != null) {
            lVar.D(com.huawei.openalliance.ad.utils.au.V(Z.I()));
            lVar.L(com.huawei.openalliance.ad.utils.au.V(Z.Z()));
            lVar.V(Z.C());
            lVar.B(Z.S());
            lVar.p(com.huawei.openalliance.ad.utils.au.V(adContentData.Z().F()));
            lVar.b(Z.D());
            lVar.c(Z.L());
            lVar.o(com.huawei.openalliance.ad.utils.au.V(Z.Code()));
            ApkInfo c4 = Z.c();
            if (c4 != null) {
                com.huawei.openalliance.ad.inter.data.AppInfo appInfo = new com.huawei.openalliance.ad.inter.data.AppInfo(c4);
                appInfo.Code(lVar.b_());
                appInfo.V(lVar.u());
                lVar.Code(appInfo);
            }
        }
        lVar.Code(adContentData.D());
        lVar.Z(adContentData.o());
        lVar.I(adContentData.n());
        lVar.C(adContentData.V());
        lVar.S(adContentData.l());
        lVar.V(adContentData.ab());
        lVar.I(adContentData.ac());
        lVar.B(adContentData.d());
        lVar.q(adContentData.aq());
        return lVar;
    }
}
