package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.b;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class et extends hn<com.huawei.openalliance.ad.augreality.views.a> implements eu<com.huawei.openalliance.ad.augreality.views.a> {
    private static final String V = "com.huawei.hms.ads.et";
    private Context I;

    public et(Context context, com.huawei.openalliance.ad.augreality.views.a aVar) {
        this.I = context;
        Code((et) aVar);
    }

    private void V(com.huawei.openalliance.ad.inter.data.k kVar, com.huawei.openalliance.ad.utils.aj ajVar) {
        if (kVar == null) {
            gl.I(V, "loadImage imageInfo is null");
            ajVar.Code();
            return;
        }
        SourceParam sourceParam = new SourceParam();
        sourceParam.I(kVar.Z());
        sourceParam.Code(52428800L);
        sourceParam.V(kVar.I());
        sourceParam.V(kVar.S());
        sourceParam.I(true);
        AdContentData adContentData = this.Code;
        com.huawei.openalliance.ad.utils.y.Code(this.I, sourceParam, adContentData != null ? adContentData.S() : null, ajVar);
    }

    private void V(String str) {
        AdContentData adContentData = this.Code;
        if (adContentData == null) {
            return;
        }
        kv.Code(this.I, adContentData, (String) null, 0, 0, str, 1, b.Code(I()), (com.huawei.openalliance.ad.inter.data.m) null);
    }

    @Override // com.huawei.hms.ads.eu
    public void Code(AdContentData adContentData) {
        if (adContentData == null) {
            return;
        }
        this.Code = adContentData;
    }

    @Override // com.huawei.hms.ads.eu
    public void Code(com.huawei.openalliance.ad.inter.data.k kVar, com.huawei.openalliance.ad.utils.aj ajVar) {
        String str = V;
        gl.V(str, "checkArImageHashAndLoad " + ((Object) kVar));
        if (kVar == null) {
            gl.I(str, "checkArImageHashAndLoad imageInfo is null");
        } else {
            V(kVar, ajVar);
        }
    }

    @Override // com.huawei.hms.ads.eu
    public boolean Code() {
        com.huawei.openalliance.ad.uriaction.q Code = com.huawei.openalliance.ad.uriaction.r.Code(this.I, this.Code, new HashMap(0));
        if (!Code.Code()) {
            return true;
        }
        V(Code.I());
        return true;
    }

    @Override // com.huawei.hms.ads.eu
    public boolean V() {
        return false;
    }
}
