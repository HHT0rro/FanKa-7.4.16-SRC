package com.huawei.hms.ads;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class kc {
    private final String B = "min_show_time_task" + hashCode();
    private final String C = "max_show_time_task" + hashCode();
    public fr Code;
    private mb Z;

    public kc(fr frVar, mb mbVar) {
        this.Code = frVar;
        this.Z = mbVar;
    }

    public void B() {
        com.huawei.openalliance.ad.utils.ba.Code(this.B);
    }

    public void Code() {
    }

    public void Code(long j10) {
        gl.V(getClass().getSimpleName(), "start max show time task duration: %d", Long.valueOf(j10));
        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.kc.1
            @Override // java.lang.Runnable
            public void run() {
                kc.this.B();
                kc.this.Z();
            }
        }, this.C, j10);
    }

    public void I() {
        mb mbVar = this.Z;
        if (mbVar != null) {
            mbVar.Code();
        }
    }

    public void V() {
    }

    public void V(long j10) {
        gl.V(getClass().getSimpleName(), "start min show time task duration: %d", Long.valueOf(j10));
        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.kc.2
            @Override // java.lang.Runnable
            public void run() {
                kc.this.I();
            }
        }, this.B, j10);
    }

    public void Z() {
        mb mbVar = this.Z;
        if (mbVar != null) {
            mbVar.V();
        }
    }
}
