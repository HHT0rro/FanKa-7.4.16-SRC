package com.huawei.openalliance.ad.uriaction;

import android.content.Context;
import com.huawei.hms.ads.le;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class q {
    public le B;
    private String Code = null;
    public Context I;
    private q V;
    public AdContentData Z;

    public q() {
    }

    public q(Context context, AdContentData adContentData) {
        this.I = context;
        this.Z = adContentData;
    }

    public void Code(le leVar) {
        this.B = leVar;
    }

    public void Code(q qVar) {
        this.V = qVar;
    }

    public void Code(String str) {
        this.Code = str;
    }

    public abstract boolean Code();

    public String I() {
        q qVar;
        String str = this.Code;
        return (str != null || (qVar = this.V) == null) ? str : qVar.I();
    }

    public boolean V() {
        q qVar = this.V;
        if (qVar != null) {
            return qVar.Code();
        }
        return false;
    }
}
