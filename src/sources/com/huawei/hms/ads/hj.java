package com.huawei.hms.ads;

import android.view.View;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class hj extends hl {
    private a C;
    private boolean D;
    private int F;
    public boolean I;
    private long L;
    private long S;
    public boolean V;
    public com.huawei.openalliance.ad.inter.data.l Z;

    /* renamed from: a, reason: collision with root package name */
    private int f29293a;

    /* renamed from: b, reason: collision with root package name */
    private int f29294b;

    /* renamed from: c, reason: collision with root package name */
    private int f29295c;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface a {
        void B();

        void Code();

        void Code(long j10, int i10);

        void I();

        void V();

        void V(long j10, int i10);

        void Z();
    }

    public hj(View view, a aVar) {
        super(view);
        this.S = 500L;
        this.F = 50;
        this.D = false;
        this.f29294b = 100;
        this.f29295c = 10;
        this.V = false;
        this.I = false;
        this.C = aVar;
        this.L = com.huawei.openalliance.ad.utils.v.Code();
    }

    private void f() {
        if (this.D) {
            return;
        }
        gl.V("PPSLinkedViewMonitor", "viewShowStartRecord");
        this.D = true;
        this.L = System.currentTimeMillis();
        a aVar = this.C;
        if (aVar != null) {
            aVar.Code();
        }
    }

    private void g() {
        if (this.D) {
            gl.V("PPSLinkedViewMonitor", "viewShowEndRecord");
            this.D = false;
            long currentTimeMillis = System.currentTimeMillis() - this.L;
            if (gl.Code()) {
                gl.Code("PPSLinkedViewMonitor", "max visible area percentage: %d duration: %d", Integer.valueOf(this.f29293a), Long.valueOf(currentTimeMillis));
            }
            a aVar = this.C;
            if (aVar != null) {
                aVar.Code(currentTimeMillis, this.f29293a);
            }
            this.f29293a = 0;
        }
    }

    public int B() {
        return this.f29293a;
    }

    @Override // com.huawei.hms.ads.hl
    public void Code() {
        a aVar = this.C;
        if (aVar != null) {
            aVar.V();
        }
    }

    @Override // com.huawei.hms.ads.hl
    public void Code(int i10) {
        gl.V("PPSLinkedViewMonitor", "onUpdateViewShowArea, percentage: %s", Integer.valueOf(i10));
        if (i10 > this.f29293a) {
            this.f29293a = i10;
        }
        if (i10 >= this.F) {
            f();
        } else {
            g();
        }
        V(i10);
    }

    @Override // com.huawei.hms.ads.hl
    public void Code(long j10, int i10) {
        g();
        a aVar = this.C;
        if (aVar != null) {
            aVar.V(j10, i10);
        }
        V(0);
    }

    public void Code(com.huawei.openalliance.ad.inter.data.l lVar) {
        this.Z = lVar;
        if (lVar == null || lVar.C() == null) {
            return;
        }
        com.huawei.openalliance.ad.inter.data.v C = lVar.C();
        this.f29294b = C.c();
        this.f29295c = Math.max(100 - C.d(), 0);
    }

    public boolean Code(long j10) {
        return j10 >= this.S && this.f29293a >= this.F;
    }

    public boolean F() {
        return e() >= V();
    }

    public int I() {
        return this.f29295c;
    }

    public int V() {
        return this.f29294b;
    }

    public void V(int i10) {
        a aVar;
        if (i10 >= V()) {
            this.I = false;
            if (this.V) {
                return;
            }
            this.V = true;
            a aVar2 = this.C;
            if (aVar2 != null) {
                aVar2.I();
                return;
            }
            return;
        }
        this.V = false;
        if (i10 > 100 - I()) {
            if (this.I && (aVar = this.C) != null) {
                aVar.B();
            }
            this.I = false;
            return;
        }
        if (this.I) {
            return;
        }
        this.I = true;
        a aVar3 = this.C;
        if (aVar3 != null) {
            aVar3.Z();
        }
    }

    public void V(long j10, int i10) {
        this.F = i10;
        this.S = j10;
    }
}
