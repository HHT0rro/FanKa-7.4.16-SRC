package com.huawei.hms.ads;

import android.view.View;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class hi extends hl {
    private static final String Code = "NativeViewMonitor";
    private boolean B;
    private long C;
    private long I;
    private int S;
    private hh V;
    private int Z;

    public hi(View view, hh hhVar) {
        super(view);
        this.I = 500L;
        this.Z = 50;
        this.B = false;
        this.V = hhVar;
        this.C = com.huawei.openalliance.ad.utils.v.Code();
    }

    private void B() {
        if (this.B) {
            return;
        }
        gl.V(Code, "viewShowStartRecord");
        this.B = true;
        this.C = System.currentTimeMillis();
        hh hhVar = this.V;
        if (hhVar != null) {
            hhVar.a_();
        }
    }

    private void C() {
        if (this.B) {
            gl.V(Code, "viewShowEndRecord");
            this.B = false;
            long currentTimeMillis = System.currentTimeMillis() - this.C;
            if (gl.Code()) {
                gl.Code(Code, "max visible area percentage: %d duration: %d", Integer.valueOf(this.S), Long.valueOf(currentTimeMillis));
            }
            hh hhVar = this.V;
            if (hhVar != null) {
                hhVar.Code(currentTimeMillis, this.S);
            }
            this.S = 0;
        }
    }

    @Override // com.huawei.hms.ads.hl
    public void Code() {
        hh hhVar = this.V;
        if (hhVar != null) {
            hhVar.I();
        }
    }

    @Override // com.huawei.hms.ads.hl
    public void Code(int i10) {
        if (i10 > this.S) {
            this.S = i10;
        }
        if (i10 >= this.Z) {
            B();
        } else {
            C();
        }
    }

    @Override // com.huawei.hms.ads.hl
    public void Code(long j10, int i10) {
        C();
        hh hhVar = this.V;
        if (hhVar != null) {
            hhVar.V(j10, i10);
        }
    }

    public boolean Code(long j10) {
        return j10 >= this.I && this.S >= this.Z;
    }

    public int I() {
        return this.S;
    }

    public void V() {
        this.Z = 50;
        this.I = 500L;
    }

    public void V(long j10, int i10) {
        this.Z = i10;
        this.I = j10;
    }

    public long Z() {
        return this.C;
    }
}
