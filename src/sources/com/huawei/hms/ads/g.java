package com.huawei.hms.ads;

import android.content.Context;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class g {
    private Context I;
    private com.huawei.openalliance.ad.inter.data.n V;

    public g(Context context, com.huawei.openalliance.ad.inter.data.n nVar) {
        this.V = nVar;
        this.I = context;
    }

    public void Code() {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar != null) {
            kv.Code(this.I, nVar.l());
        }
    }

    public void Code(long j10, int i10) {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar != null) {
            kv.Code(this.I, nVar.l(), j10, i10);
        }
    }

    public void Code(Long l10, Integer num, Integer num2, String str) {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar != null) {
            kv.Code(this.I, nVar.l(), l10, num, num2, str);
        }
    }

    public void Code(String str) {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar == null) {
            gl.V("AdEventProcessor", " native ad is empty");
        } else {
            kv.Code(this.I, nVar.l(), 0, 0, (String) null, str);
        }
    }

    public void Code(String str, String str2) {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar != null) {
            kv.Code(this.I, nVar.l(), 0, 0, str, str2);
        }
    }

    public void Code(List<String> list) {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar != null) {
            kv.Code(this.I, nVar.l(), 0, 0, list);
        }
    }

    public void V(List<String> list) {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar != null) {
            kv.Code(this.I, nVar.l(), 0, 0, list);
        }
    }
}
