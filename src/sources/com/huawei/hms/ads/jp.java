package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.hp;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class jp<V extends hp> extends hn<V> implements kq<V> {
    public Context V;

    public abstract String B();

    @Override // com.huawei.hms.ads.kq
    public void Code() {
        kv.Code(this.V, this.Code, com.huawei.openalliance.ad.constant.ae.B, (Long) null, (Long) null, (Integer) null, (Integer) null);
    }

    @Override // com.huawei.hms.ads.kq
    public void Code(long j10, long j11, long j12) {
        long j13 = 0;
        if (j10 == 0 || j10 >= j12) {
            return;
        }
        long j14 = j12 - j10;
        if (j11 != 0 && j11 < j12) {
            j13 = j12 - j11;
        }
        eo.Code(this.V, this.Code, j14, j13);
    }

    @Override // com.huawei.hms.ads.kq
    public void Code(long j10, long j11, long j12, long j13) {
        kv.Code(this.V, this.Code, com.huawei.openalliance.ad.constant.ae.Z, Long.valueOf(j10), Long.valueOf(j11), Integer.valueOf((int) j12), Integer.valueOf((int) j13));
    }

    @Override // com.huawei.hms.ads.kq
    public void V() {
        kv.Code(this.V, this.Code, com.huawei.openalliance.ad.constant.ae.S, (Long) null, (Long) null, (Integer) null, (Integer) null);
    }

    @Override // com.huawei.hms.ads.kq
    public void V(long j10, long j11, long j12, long j13) {
        kv.Code(this.V, this.Code, com.huawei.openalliance.ad.constant.ae.C, Long.valueOf(j10), Long.valueOf(j11), Integer.valueOf((int) j12), Integer.valueOf((int) j13));
    }
}
