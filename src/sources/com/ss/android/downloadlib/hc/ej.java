package com.ss.android.downloadlib.hc;

import java.lang.ref.SoftReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ej<P, R> implements Runnable {
    private R dk;
    private int ej;

    /* renamed from: l, reason: collision with root package name */
    private SoftReference<m<P, R>> f38775l;

    /* renamed from: m, reason: collision with root package name */
    private P f38776m;

    /* renamed from: n, reason: collision with root package name */
    private ej<R, ?> f38777n;
    private ej<?, P> np;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface m<PARAM, RESULT> {
        RESULT m(PARAM param);
    }

    private ej(int i10, m<P, R> mVar, P p10) {
        this.ej = i10;
        this.f38775l = new SoftReference<>(mVar);
        this.f38776m = p10;
    }

    private R dk() {
        return this.dk;
    }

    public static <P, R> ej<P, R> m(m<P, R> mVar, P p10) {
        return new ej<>(2, mVar, p10);
    }

    @Override // java.lang.Runnable
    public void run() {
        ej<?, P> ejVar;
        if (this.ej == 0 && !ve.dk()) {
            com.ss.android.downloadlib.hc.m().dk().post(this);
            return;
        }
        if (this.ej == 1 && ve.dk()) {
            com.ss.android.downloadlib.l.m().m(this);
            return;
        }
        if (this.ej == 2 && ve.dk()) {
            com.ss.android.downloadlib.l.m().dk(this);
            return;
        }
        if (this.f38776m == null && (ejVar = this.np) != null) {
            this.f38776m = ejVar.dk();
        }
        m<P, R> mVar = this.f38775l.get();
        if (mVar == null) {
            return;
        }
        this.dk = mVar.m(this.f38776m);
        ej<R, ?> ejVar2 = this.f38777n;
        if (ejVar2 != null) {
            ejVar2.run();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <NR> ej<R, NR> m(int i10, m<R, NR> mVar) {
        ej ejVar = (ej<R, ?>) new ej(i10, mVar, null);
        this.f38777n = ejVar;
        ejVar.np = this;
        return ejVar;
    }

    public <NR> ej<R, NR> m(m<R, NR> mVar) {
        return m(0, mVar);
    }

    public void m() {
        ej<?, P> ejVar = this.np;
        if (ejVar != null) {
            ejVar.m();
        } else {
            run();
        }
    }
}
