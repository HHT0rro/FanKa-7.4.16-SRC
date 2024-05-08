package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.ku;
import com.huawei.openalliance.ad.beans.inner.AnalysisEventReport;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.b;
import java.util.HashMap;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class jy extends hn<ln> implements kl<ln> {
    private Context I;
    private com.huawei.openalliance.ad.inter.data.p Z;

    public jy(Context context, ln lnVar) {
        this.I = context;
        Code((jy) lnVar);
    }

    private void Code(com.huawei.openalliance.ad.uriaction.q qVar, com.huawei.openalliance.ad.inter.data.m mVar) {
        kv.Code(this.I, this.Code, 0, 0, qVar.I(), mVar, b.Code(I()), com.huawei.openalliance.ad.utils.ay.Code(I()));
    }

    @Override // com.huawei.hms.ads.kl
    public void Code() {
        kv.Code(this.I, this.Code, 0, 0, (List<String>) null);
    }

    @Override // com.huawei.hms.ads.kl
    public void Code(long j10, int i10) {
        kv.Code(this.I, this.Code, j10, i10);
    }

    @Override // com.huawei.hms.ads.kl
    public void Code(long j10, int i10, Integer num) {
        ku.a aVar = new ku.a();
        if (num != null) {
            aVar.V(Long.valueOf(com.huawei.openalliance.ad.utils.v.Code()));
        }
        aVar.Code(Long.valueOf(j10)).Code(Integer.valueOf(i10)).V(num).Code(b.Code(I()));
        kv.Code(this.I, this.Code, aVar.Code());
    }

    @Override // com.huawei.hms.ads.kl
    public void Code(com.huawei.openalliance.ad.inter.data.m mVar) {
        com.huawei.openalliance.ad.inter.data.p pVar = this.Z;
        if (pVar == null) {
            return;
        }
        pVar.Code(true);
        gl.Code("PlacementAdPresenter", "begin to deal click");
        HashMap hashMap = new HashMap();
        hashMap.put("appId", this.Z.t());
        hashMap.put(com.huawei.openalliance.ad.uriaction.i.V, this.Z.Code());
        com.huawei.openalliance.ad.uriaction.q Code = com.huawei.openalliance.ad.uriaction.r.Code(this.I, this.Code, hashMap);
        if (Code.Code()) {
            Code(Code, mVar);
        }
    }

    @Override // com.huawei.hms.ads.kl
    public void Code(com.huawei.openalliance.ad.inter.data.p pVar) {
        this.Z = pVar;
        this.Code = pVar != null ? pVar.l() : null;
    }

    @Override // com.huawei.hms.ads.kl
    public void Code(String str, int i10, int i11, com.huawei.openalliance.ad.inter.data.p pVar) {
        AdContentData l10 = pVar.l();
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        analysisEventReport.Code(str);
        analysisEventReport.Code(i10);
        analysisEventReport.V(i11);
        analysisEventReport.Code(l10);
        if (l10 != null) {
            analysisEventReport.S(l10.az());
            analysisEventReport.F(l10.C());
            analysisEventReport.C(l10.S());
            analysisEventReport.I(l10.aA());
        }
        com.huawei.openalliance.ad.ipc.g.V(this.I).Code("rptPlacePlayErr", com.huawei.openalliance.ad.utils.z.V(analysisEventReport), null, null);
    }

    @Override // com.huawei.hms.ads.kl
    public void Code(boolean z10) {
        kv.Code(this.I, this.Code, z10);
    }

    @Override // com.huawei.hms.ads.kl
    public void V() {
        kv.Code(this.I, this.Code);
    }
}
