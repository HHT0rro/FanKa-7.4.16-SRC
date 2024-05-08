package com.huawei.hms.ads;

import android.content.Context;
import android.view.View;
import com.huawei.hms.ads.ku;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.b;
import com.huawei.openalliance.ad.views.PPSNativeView;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class bw implements bv<View> {
    private static final String Code = "bw";
    private com.huawei.openalliance.ad.inter.data.n B;
    private PPSNativeView.e C;
    private View I;
    private Context V;
    private AdContentData Z;

    public bw(Context context, View view) {
        this.V = context;
        Code(view);
    }

    private void Code(com.huawei.openalliance.ad.uriaction.q qVar) {
        kv.Code(this.V, this.Z, 0, 0, qVar.I(), b.Code(I()), com.huawei.openalliance.ad.utils.ay.Code(I()));
    }

    @Override // com.huawei.hms.ads.bv
    public void Code() {
        kv.Code(this.V, this.Z);
    }

    @Override // com.huawei.hms.ads.bv
    public void Code(long j10, int i10) {
        kv.Code(this.V, this.Z, j10, i10);
    }

    public void Code(View view) {
        this.I = view;
    }

    @Override // com.huawei.hms.ads.bv
    public void Code(com.huawei.openalliance.ad.inter.data.n nVar) {
        this.B = nVar;
        this.Z = nVar != null ? nVar.l() : null;
    }

    @Override // com.huawei.hms.ads.bv
    public void Code(PPSNativeView.e eVar) {
        this.C = eVar;
    }

    @Override // com.huawei.hms.ads.bv
    public void Code(Long l10, Integer num, Integer num2, boolean z10) {
        ku.a aVar = new ku.a();
        if (z10) {
            aVar.V(Long.valueOf(com.huawei.openalliance.ad.utils.v.Code()));
        }
        aVar.Code(l10).Code(num).V(num2).Code(b.Code(I()));
        kv.Code(this.V, this.Z, aVar.Code());
    }

    @Override // com.huawei.hms.ads.bv
    public void Code(String str) {
        AdContentData adContentData = this.Z;
        if (adContentData == null) {
            return;
        }
        adContentData.V(str);
    }

    @Override // com.huawei.hms.ads.bv
    public void Code(List<String> list) {
        kv.Code(this.V, this.Z, 0, 0, list);
    }

    public View I() {
        return this.I;
    }

    @Override // com.huawei.hms.ads.bv
    public boolean V() {
        com.huawei.openalliance.ad.inter.data.n nVar = this.B;
        if (nVar == null) {
            return false;
        }
        nVar.Code(true);
        gl.Code(Code, "deal click");
        com.huawei.openalliance.ad.uriaction.q Code2 = com.huawei.openalliance.ad.uriaction.r.Code(this.V, this.Z, this.B.ae());
        boolean Code3 = Code2.Code();
        if (Code3) {
            Code(Code2);
            PPSNativeView.e eVar = this.C;
            if (eVar != null) {
                eVar.V();
                this.C.I();
            }
        }
        return Code3;
    }
}
