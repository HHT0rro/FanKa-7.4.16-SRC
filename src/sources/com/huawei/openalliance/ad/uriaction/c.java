package com.huawei.openalliance.ad.uriaction;

import android.content.Context;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.kv;
import com.huawei.openalliance.ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c extends q {
    private static final String Code = "AppEnterAction";

    public c(Context context, AdContentData adContentData) {
        super(context, adContentData);
    }

    @Override // com.huawei.openalliance.ad.uriaction.q
    public boolean Code() {
        ApkInfo c4;
        gl.V(Code, "handle app enter action");
        MetaData Z = this.Z.Z();
        if (!((Z == null || (c4 = Z.c()) == null) ? false : com.huawei.openalliance.ad.utils.e.I(this.I, c4.Code()))) {
            return V();
        }
        Code("app");
        kv.Code(this.I, this.Z, (Integer) 1);
        return true;
    }
}
