package com.jd.ad.sdk.jad_kv;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.jd.ad.sdk.jad_hq.jad_an;
import com.jd.ad.sdk.jad_kv.jad_hu;
import com.jd.ad.sdk.jad_kv.jad_re;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_na<R> implements jad_hu.jad_bo<R>, jad_an.jad_dq {
    public static final jad_cp jad_zm = new jad_cp();
    public final jad_re.jad_an jad_cp;
    public final Pools.Pool<jad_na<?>> jad_dq;
    public final jad_cp jad_er;
    public final jad_ob jad_fs;
    public final com.jd.ad.sdk.jad_ny.jad_an jad_hu;
    public final com.jd.ad.sdk.jad_ny.jad_an jad_iv;
    public final com.jd.ad.sdk.jad_ny.jad_an jad_jt;
    public final com.jd.ad.sdk.jad_ny.jad_an jad_jw;
    public com.jd.ad.sdk.jad_hs.jad_hu jad_ly;
    public boolean jad_mz;
    public boolean jad_na;
    public boolean jad_ob;
    public boolean jad_pc;
    public jad_xk<?> jad_qd;
    public com.jd.ad.sdk.jad_hs.jad_an jad_re;
    public boolean jad_sf;
    public jad_sf jad_tg;
    public boolean jad_uh;
    public jad_re<?> jad_vi;
    public jad_hu<R> jad_wj;
    public volatile boolean jad_xk;
    public boolean jad_yl;
    public final jad_er jad_an = new jad_er();
    public final com.jd.ad.sdk.jad_hq.jad_dq jad_bo = com.jd.ad.sdk.jad_hq.jad_dq.jad_an();
    public final AtomicInteger jad_kx = new AtomicInteger();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class jad_an implements Runnable {
        public final com.jd.ad.sdk.jad_al.jad_iv jad_an;

        public jad_an(com.jd.ad.sdk.jad_al.jad_iv jad_ivVar) {
            this.jad_an = jad_ivVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.jd.ad.sdk.jad_al.jad_jw jad_jwVar = (com.jd.ad.sdk.jad_al.jad_jw) this.jad_an;
            jad_jwVar.jad_bo.jad_bo();
            synchronized (jad_jwVar.jad_cp) {
                synchronized (jad_na.this) {
                    if (jad_na.this.jad_an.jad_an.contains(new jad_dq(this.jad_an, com.jd.ad.sdk.jad_gp.jad_er.jad_bo))) {
                        jad_na jad_naVar = jad_na.this;
                        com.jd.ad.sdk.jad_al.jad_iv jad_ivVar = this.jad_an;
                        jad_naVar.getClass();
                        try {
                            ((com.jd.ad.sdk.jad_al.jad_jw) jad_ivVar).jad_an(jad_naVar.jad_tg, 5);
                        } catch (Throwable th) {
                            throw new com.jd.ad.sdk.jad_kv.jad_bo(th);
                        }
                    }
                    jad_na.this.jad_bo();
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class jad_bo implements Runnable {
        public final com.jd.ad.sdk.jad_al.jad_iv jad_an;

        public jad_bo(com.jd.ad.sdk.jad_al.jad_iv jad_ivVar) {
            this.jad_an = jad_ivVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.jd.ad.sdk.jad_al.jad_jw jad_jwVar = (com.jd.ad.sdk.jad_al.jad_jw) this.jad_an;
            jad_jwVar.jad_bo.jad_bo();
            synchronized (jad_jwVar.jad_cp) {
                synchronized (jad_na.this) {
                    if (jad_na.this.jad_an.jad_an.contains(new jad_dq(this.jad_an, com.jd.ad.sdk.jad_gp.jad_er.jad_bo))) {
                        jad_na.this.jad_vi.jad_an();
                        jad_na jad_naVar = jad_na.this;
                        com.jd.ad.sdk.jad_al.jad_iv jad_ivVar = this.jad_an;
                        jad_naVar.getClass();
                        try {
                            ((com.jd.ad.sdk.jad_al.jad_jw) jad_ivVar).jad_an(jad_naVar.jad_vi, jad_naVar.jad_re, jad_naVar.jad_yl);
                            jad_na.this.jad_an(this.jad_an);
                        } catch (Throwable th) {
                            throw new com.jd.ad.sdk.jad_kv.jad_bo(th);
                        }
                    }
                    jad_na.this.jad_bo();
                }
            }
        }
    }

    @VisibleForTesting
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class jad_cp {
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class jad_dq {
        public final com.jd.ad.sdk.jad_al.jad_iv jad_an;
        public final Executor jad_bo;

        public jad_dq(com.jd.ad.sdk.jad_al.jad_iv jad_ivVar, Executor executor) {
            this.jad_an = jad_ivVar;
            this.jad_bo = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof jad_dq) {
                return this.jad_an.equals(((jad_dq) obj).jad_an);
            }
            return false;
        }

        public int hashCode() {
            return this.jad_an.hashCode();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class jad_er implements Iterable<jad_dq> {
        public final List<jad_dq> jad_an;

        public jad_er() {
            this(new ArrayList(2));
        }

        public jad_er(List<jad_dq> list) {
            this.jad_an = list;
        }

        @Override // java.lang.Iterable
        @NonNull
        /* renamed from: iterator */
        public Iterator<jad_dq> iterator2() {
            return this.jad_an.iterator2();
        }
    }

    @VisibleForTesting
    public jad_na(com.jd.ad.sdk.jad_ny.jad_an jad_anVar, com.jd.ad.sdk.jad_ny.jad_an jad_anVar2, com.jd.ad.sdk.jad_ny.jad_an jad_anVar3, com.jd.ad.sdk.jad_ny.jad_an jad_anVar4, jad_ob jad_obVar, jad_re.jad_an jad_anVar5, Pools.Pool<jad_na<?>> pool, jad_cp jad_cpVar) {
        this.jad_jt = jad_anVar;
        this.jad_hu = jad_anVar2;
        this.jad_iv = jad_anVar3;
        this.jad_jw = jad_anVar4;
        this.jad_fs = jad_obVar;
        this.jad_cp = jad_anVar5;
        this.jad_dq = pool;
        this.jad_er = jad_cpVar;
    }

    @Override // com.jd.ad.sdk.jad_hq.jad_an.jad_dq
    @NonNull
    public com.jd.ad.sdk.jad_hq.jad_dq jad_an() {
        return this.jad_bo;
    }

    public synchronized void jad_an(int i10) {
        jad_re<?> jad_reVar;
        com.jd.ad.sdk.jad_gp.jad_kx.jad_an(jad_cp(), "Not yet complete!");
        if (this.jad_kx.getAndAdd(i10) == 0 && (jad_reVar = this.jad_vi) != null) {
            jad_reVar.jad_an();
        }
    }

    public synchronized void jad_an(com.jd.ad.sdk.jad_al.jad_iv jad_ivVar, Executor executor) {
        Runnable jad_anVar;
        this.jad_bo.jad_bo();
        this.jad_an.jad_an.add(new jad_dq(jad_ivVar, executor));
        if (this.jad_sf) {
            jad_an(1);
            jad_anVar = new jad_bo(jad_ivVar);
        } else if (this.jad_uh) {
            jad_an(1);
            jad_anVar = new jad_an(jad_ivVar);
        } else {
            com.jd.ad.sdk.jad_gp.jad_kx.jad_an(!this.jad_xk, "Cannot add callbacks to a cancelled EngineJob");
        }
        executor.execute(jad_anVar);
    }

    public void jad_bo() {
        jad_re<?> jad_reVar;
        synchronized (this) {
            this.jad_bo.jad_bo();
            com.jd.ad.sdk.jad_gp.jad_kx.jad_an(jad_cp(), "Not yet complete!");
            int decrementAndGet = this.jad_kx.decrementAndGet();
            com.jd.ad.sdk.jad_gp.jad_kx.jad_an(decrementAndGet >= 0, "Can't decrement below 0");
            if (decrementAndGet == 0) {
                jad_reVar = this.jad_vi;
                jad_dq();
            } else {
                jad_reVar = null;
            }
        }
        if (jad_reVar != null) {
            jad_reVar.jad_jt();
        }
    }

    public final boolean jad_cp() {
        return this.jad_uh || this.jad_sf || this.jad_xk;
    }

    public final synchronized void jad_dq() {
        boolean jad_an2;
        if (this.jad_ly != null) {
            this.jad_an.jad_an.clear();
            this.jad_ly = null;
            this.jad_vi = null;
            this.jad_qd = null;
            this.jad_uh = false;
            this.jad_xk = false;
            this.jad_sf = false;
            this.jad_yl = false;
            jad_hu<R> jad_huVar = this.jad_wj;
            jad_hu.jad_fs jad_fsVar = jad_huVar.jad_jt;
            synchronized (jad_fsVar) {
                jad_fsVar.jad_an = true;
                jad_an2 = jad_fsVar.jad_an(false);
            }
            if (jad_an2) {
                jad_huVar.jad_fs();
            }
            this.jad_wj = null;
            this.jad_tg = null;
            this.jad_re = null;
            this.jad_dq.release(this);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0065, code lost:
    
        if (r4.jad_kx.get() != 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0067, code lost:
    
        jad_dq();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void jad_an(com.jd.ad.sdk.jad_al.jad_iv r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            com.jd.ad.sdk.jad_hq.jad_dq r0 = r4.jad_bo     // Catch: java.lang.Throwable -> L70
            r0.jad_bo()     // Catch: java.lang.Throwable -> L70
            com.jd.ad.sdk.jad_kv.jad_na$jad_er r0 = r4.jad_an     // Catch: java.lang.Throwable -> L70
            java.util.List<com.jd.ad.sdk.jad_kv.jad_na$jad_dq> r0 = r0.jad_an     // Catch: java.lang.Throwable -> L70
            com.jd.ad.sdk.jad_kv.jad_na$jad_dq r1 = new com.jd.ad.sdk.jad_kv.jad_na$jad_dq     // Catch: java.lang.Throwable -> L70
            java.util.concurrent.Executor r2 = com.jd.ad.sdk.jad_gp.jad_er.jad_bo     // Catch: java.lang.Throwable -> L70
            r1.<init>(r5, r2)     // Catch: java.lang.Throwable -> L70
            r0.remove(r1)     // Catch: java.lang.Throwable -> L70
            com.jd.ad.sdk.jad_kv.jad_na$jad_er r5 = r4.jad_an     // Catch: java.lang.Throwable -> L70
            java.util.List<com.jd.ad.sdk.jad_kv.jad_na$jad_dq> r5 = r5.jad_an     // Catch: java.lang.Throwable -> L70
            boolean r5 = r5.isEmpty()     // Catch: java.lang.Throwable -> L70
            if (r5 == 0) goto L6e
            boolean r5 = r4.jad_cp()     // Catch: java.lang.Throwable -> L70
            r0 = 1
            if (r5 == 0) goto L26
            goto L53
        L26:
            r4.jad_xk = r0     // Catch: java.lang.Throwable -> L70
            com.jd.ad.sdk.jad_kv.jad_hu<R> r5 = r4.jad_wj     // Catch: java.lang.Throwable -> L70
            r5.jad_gr = r0     // Catch: java.lang.Throwable -> L70
            com.jd.ad.sdk.jad_kv.jad_fs r5 = r5.jad_ep     // Catch: java.lang.Throwable -> L70
            if (r5 == 0) goto L33
            r5.jad_cp()     // Catch: java.lang.Throwable -> L70
        L33:
            com.jd.ad.sdk.jad_kv.jad_ob r5 = r4.jad_fs     // Catch: java.lang.Throwable -> L70
            com.jd.ad.sdk.jad_hs.jad_hu r1 = r4.jad_ly     // Catch: java.lang.Throwable -> L70
            com.jd.ad.sdk.jad_kv.jad_mz r5 = (com.jd.ad.sdk.jad_kv.jad_mz) r5     // Catch: java.lang.Throwable -> L70
            monitor-enter(r5)     // Catch: java.lang.Throwable -> L70
            com.jd.ad.sdk.jad_kv.jad_uh r2 = r5.jad_an     // Catch: java.lang.Throwable -> L6b
            r2.getClass()     // Catch: java.lang.Throwable -> L6b
            boolean r3 = r4.jad_pc     // Catch: java.lang.Throwable -> L6b
            java.util.Map r2 = r2.jad_an(r3)     // Catch: java.lang.Throwable -> L6b
            java.lang.Object r3 = r2.get(r1)     // Catch: java.lang.Throwable -> L6b
            boolean r3 = r4.equals(r3)     // Catch: java.lang.Throwable -> L6b
            if (r3 == 0) goto L52
            r2.remove(r1)     // Catch: java.lang.Throwable -> L6b
        L52:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L70
        L53:
            boolean r5 = r4.jad_sf     // Catch: java.lang.Throwable -> L70
            if (r5 != 0) goto L5d
            boolean r5 = r4.jad_uh     // Catch: java.lang.Throwable -> L70
            if (r5 == 0) goto L5c
            goto L5d
        L5c:
            r0 = 0
        L5d:
            if (r0 == 0) goto L6e
            java.util.concurrent.atomic.AtomicInteger r5 = r4.jad_kx     // Catch: java.lang.Throwable -> L70
            int r5 = r5.get()     // Catch: java.lang.Throwable -> L70
            if (r5 != 0) goto L6e
            r4.jad_dq()     // Catch: java.lang.Throwable -> L70
            goto L6e
        L6b:
            r0 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L70
            throw r0     // Catch: java.lang.Throwable -> L70
        L6e:
            monitor-exit(r4)
            return
        L70:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_kv.jad_na.jad_an(com.jd.ad.sdk.jad_al.jad_iv):void");
    }

    public void jad_an(jad_hu<?> jad_huVar) {
        (this.jad_na ? this.jad_iv : this.jad_ob ? this.jad_jw : this.jad_hu).jad_an.execute(jad_huVar);
    }
}