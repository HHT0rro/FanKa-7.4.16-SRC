package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.ku;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.b;
import com.huawei.openalliance.ad.views.PPSNativeView;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class js extends hn<lm> implements kf<lm> {
    private static final String V = "js";
    private PPSNativeView.e B;
    private Context I;
    private com.huawei.openalliance.ad.inter.data.n Z;

    public js(Context context, lm lmVar) {
        this.I = context;
        Code((js) lmVar);
    }

    private void Code(com.huawei.openalliance.ad.uriaction.q qVar, com.huawei.openalliance.ad.inter.data.m mVar, Integer num) {
        kv.Code(this.I, this.Code, 0, 0, qVar.I(), num.intValue(), mVar, b.Code(I()), com.huawei.openalliance.ad.utils.ay.Code(I()));
    }

    @Override // com.huawei.hms.ads.kf
    public void Code() {
        kv.Code(this.I, this.Code);
    }

    @Override // com.huawei.hms.ads.kf
    public void Code(long j10, int i10) {
        kv.Code(this.I, this.Code, j10, i10);
    }

    @Override // com.huawei.hms.ads.kf
    public void Code(com.huawei.openalliance.ad.inter.data.n nVar) {
        this.Z = nVar;
        this.Code = nVar != null ? nVar.l() : null;
    }

    @Override // com.huawei.hms.ads.kf
    public void Code(PPSNativeView.e eVar) {
        this.B = eVar;
    }

    @Override // com.huawei.hms.ads.kf
    public void Code(Long l10, Integer num, Integer num2, boolean z10) {
        ku.a aVar = new ku.a();
        if (z10) {
            aVar.V(Long.valueOf(com.huawei.openalliance.ad.utils.v.Code()));
        }
        aVar.Code(l10).Code(num).V(num2).Code(b.Code(I()));
        kv.Code(this.I, this.Code, aVar.Code());
    }

    @Override // com.huawei.hms.ads.kf
    public void Code(List<String> list) {
        kv.Code(this.I, this.Code, 0, 0, list);
    }

    @Override // com.huawei.hms.ads.kf
    public boolean Code(com.huawei.openalliance.ad.inter.data.m mVar, Integer num) {
        com.huawei.openalliance.ad.inter.data.n nVar = this.Z;
        if (nVar == null) {
            return false;
        }
        nVar.Code(true);
        gl.Code(V, "deal click");
        com.huawei.openalliance.ad.uriaction.q Code = com.huawei.openalliance.ad.uriaction.r.Code(this.I, this.Code, this.Z.ae());
        boolean Code2 = Code.Code();
        if (Code2) {
            Code(Code, mVar, num);
            PPSNativeView.e eVar = this.B;
            if (eVar != null) {
                eVar.V();
                this.B.I();
            }
        }
        return Code2;
    }

    @Override // com.huawei.hms.ads.kf
    public void V() {
        kv.V(this.I, this.Code);
    }

    @Override // com.huawei.hms.ads.kf
    public void V(String str) {
        AdContentData adContentData = this.Code;
        if (adContentData == null) {
            return;
        }
        adContentData.b(str);
    }
}
