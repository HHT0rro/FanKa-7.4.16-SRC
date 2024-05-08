package com.huawei.hms.ads;

import android.content.Context;
import android.view.View;
import com.huawei.hms.ads.ku;
import com.huawei.openalliance.ad.utils.b;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class jw extends hn<ll> implements ki {
    private com.huawei.openalliance.ad.inter.data.l B;
    private com.huawei.openalliance.ad.inter.listeners.a C;
    private Context Z;
    private boolean S = false;
    private boolean F = false;

    public jw(Context context, ll llVar) {
        this.Z = context.getApplicationContext();
        Code((jw) llVar);
    }

    private void Code(com.huawei.openalliance.ad.uriaction.q qVar, int i10, com.huawei.openalliance.ad.inter.data.m mVar) {
        kv.Code(this.Z, this.Code, 0, 0, qVar.I(), i10, mVar, b.Code(I()), com.huawei.openalliance.ad.utils.ay.Code(I()));
    }

    private void Code(Map<String, String> map) {
        com.huawei.openalliance.ad.inter.data.l lVar;
        if (map == null || map.isEmpty() || (lVar = this.B) == null || lVar.C() == null) {
            return;
        }
        int L = this.B.C().L();
        if (Math.abs(this.B.C().I() - L) < 1000) {
            L = 0;
        }
        gl.V("PPSLinkedVideoViewPresenter", "buildLinkedAdConfig, duration: %s, set progress from LinkedSplash view:%s ", Integer.valueOf(this.B.C().I()), Integer.valueOf(L));
        map.put(com.huawei.openalliance.ad.constant.ax.f32274q, this.B.C().h() ? "true" : "false");
        map.put(com.huawei.openalliance.ad.constant.ax.f32273p, this.B.C().a());
        map.put(com.huawei.openalliance.ad.constant.ax.f32272o, String.valueOf(L));
        map.put(com.huawei.openalliance.ad.constant.ax.f32275r, this.B.T());
        map.put(com.huawei.openalliance.ad.constant.ax.f32270m, this.B.o());
        map.put(com.huawei.openalliance.ad.constant.ax.f32271n, String.valueOf(10));
    }

    private boolean D() {
        return this.S;
    }

    private void I(boolean z10) {
        this.S = z10;
    }

    @Override // com.huawei.hms.ads.ki
    public void C() {
        kv.Code(this.Z, this.Code, com.huawei.openalliance.ad.constant.ae.B, (Long) null, (Long) null, (Integer) null, (Integer) null);
    }

    @Override // com.huawei.hms.ads.hn, com.huawei.hms.ads.ho
    /* renamed from: Code, reason: merged with bridge method [inline-methods] */
    public ll I() {
        return (ll) super.I();
    }

    @Override // com.huawei.hms.ads.ki
    public void Code(long j10, int i10) {
        kv.Code(this.Z, this.Code, j10, i10);
    }

    @Override // com.huawei.hms.ads.ki
    public void Code(long j10, long j11, long j12, long j13) {
        kv.Code(this.Z, this.Code, com.huawei.openalliance.ad.constant.ae.Z, Long.valueOf(j10), Long.valueOf(j11), Integer.valueOf((int) j12), Integer.valueOf((int) j13));
    }

    @Override // com.huawei.hms.ads.ki
    public void Code(com.huawei.openalliance.ad.inter.listeners.a aVar) {
        this.C = aVar;
    }

    @Override // com.huawei.hms.ads.ki
    public void Code(Long l10, Integer num, Integer num2, boolean z10) {
        if (D()) {
            gl.I("PPSLinkedVideoViewPresenter", "show event already reported before, ignore this");
            return;
        }
        com.huawei.openalliance.ad.inter.listeners.a aVar = this.C;
        if (aVar != null) {
            aVar.Code();
        }
        I(true);
        ku.a aVar2 = new ku.a();
        if (z10) {
            aVar2.V(Long.valueOf(com.huawei.openalliance.ad.utils.v.Code()));
        }
        aVar2.Code(l10).Code(num).V(num2).Code(b.Code(I()));
        kv.Code(this.Z, this.Code, aVar2.Code());
    }

    @Override // com.huawei.hms.ads.hn, com.huawei.hms.ads.ki
    public void Code(String str) {
        super.Code(str);
        I(false);
    }

    @Override // com.huawei.hms.ads.ki
    public void Code(boolean z10) {
        kv.Code(this.Z, this.Code, z10);
    }

    @Override // com.huawei.hms.ads.ki
    public boolean Code(int i10, com.huawei.openalliance.ad.inter.data.m mVar) {
        com.huawei.openalliance.ad.inter.data.l lVar = this.B;
        if (lVar == null) {
            return false;
        }
        lVar.V(true);
        gl.V("PPSLinkedVideoViewPresenter", "begin to deal click");
        HashMap hashMap = new HashMap();
        hashMap.put("appId", this.B.ag());
        hashMap.put(com.huawei.openalliance.ad.uriaction.i.V, this.B.af());
        Code(hashMap);
        com.huawei.openalliance.ad.inter.listeners.a aVar = this.C;
        if (aVar != null) {
            aVar.V();
        }
        com.huawei.openalliance.ad.uriaction.q Code = com.huawei.openalliance.ad.uriaction.r.Code(I() instanceof View ? ((View) I()).getContext() : this.Z, this.Code, hashMap);
        boolean Code2 = Code.Code();
        if (Code2) {
            Code(Code, i10, mVar);
        }
        com.huawei.openalliance.ad.inter.d.Code(this.Z).Code(false);
        return Code2;
    }

    @Override // com.huawei.hms.ads.ki
    public void S() {
        kv.Code(this.Z, this.Code, com.huawei.openalliance.ad.constant.ae.S, (Long) null, (Long) null, (Integer) null, (Integer) null);
    }

    @Override // com.huawei.hms.ads.ki
    public void V() {
        kv.Code(this.Z, this.Code);
    }

    @Override // com.huawei.hms.ads.ki
    public void V(long j10, long j11, long j12, long j13) {
        kv.Code(this.Z, this.Code, com.huawei.openalliance.ad.constant.ae.C, Long.valueOf(j10), Long.valueOf(j11), Integer.valueOf((int) j12), Integer.valueOf((int) j13));
    }
}
