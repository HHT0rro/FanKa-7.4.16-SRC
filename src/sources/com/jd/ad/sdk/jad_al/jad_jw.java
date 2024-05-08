package com.jd.ad.sdk.jad_al;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alimm.tanx.ui.image.glide.Glide;
import com.jd.ad.sdk.jad_ep.jad_dq;
import com.jd.ad.sdk.jad_gp.jad_ly;
import com.jd.ad.sdk.jad_kv.jad_mz;
import com.jd.ad.sdk.jad_kv.jad_sf;
import com.jd.ad.sdk.jad_kv.jad_xk;
import com.jd.ad.sdk.logger.Logger;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import sun.util.locale.LanguageTag;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class jad_jw<R> implements jad_dq, com.jd.ad.sdk.jad_bm.jad_dq, jad_iv {
    public static final boolean jad_fq = Log.isLoggable("GlideRequest", 2);

    @Nullable
    public final String jad_an;
    public final com.jd.ad.sdk.jad_hq.jad_dq jad_bo;

    @GuardedBy("requestLock")
    public int jad_cn;
    public final Object jad_cp;

    @GuardedBy("requestLock")
    public boolean jad_do;

    @Nullable
    public final jad_jt<R> jad_dq;

    @Nullable
    public RuntimeException jad_ep;
    public final jad_fs jad_er;
    public final Context jad_fs;

    @Nullable
    public final Object jad_hu;
    public final Class<R> jad_iv;
    public final com.jd.ad.sdk.jad_ep.jad_er jad_jt;
    public final jad_an<?> jad_jw;
    public final int jad_kx;
    public final int jad_ly;
    public final com.jd.ad.sdk.jad_ep.jad_jt jad_mz;
    public final com.jd.ad.sdk.jad_bm.jad_er<R> jad_na;

    @Nullable
    public final List<jad_jt<R>> jad_ob;
    public final com.jd.ad.sdk.jad_en.jad_cp<? super R> jad_pc;
    public final Executor jad_qd;

    @GuardedBy("requestLock")
    public jad_xk<R> jad_re;

    @GuardedBy("requestLock")
    public jad_mz.jad_dq jad_sf;

    @GuardedBy("requestLock")
    public long jad_tg;
    public volatile jad_mz jad_uh;

    @GuardedBy("requestLock")
    public int jad_vi;

    @Nullable
    @GuardedBy("requestLock")
    public Drawable jad_wj;

    @Nullable
    @GuardedBy("requestLock")
    public Drawable jad_xk;

    @Nullable
    @GuardedBy("requestLock")
    public Drawable jad_yl;

    @GuardedBy("requestLock")
    public int jad_zm;

    public jad_jw(Context context, com.jd.ad.sdk.jad_ep.jad_er jad_erVar, @NonNull Object obj, @Nullable Object obj2, Class<R> cls, jad_an<?> jad_anVar, int i10, int i11, com.jd.ad.sdk.jad_ep.jad_jt jad_jtVar, com.jd.ad.sdk.jad_bm.jad_er<R> jad_erVar2, @Nullable jad_jt<R> jad_jtVar2, @Nullable List<jad_jt<R>> list, jad_fs jad_fsVar, jad_mz jad_mzVar, com.jd.ad.sdk.jad_en.jad_cp<? super R> jad_cpVar, Executor executor) {
        this.jad_an = jad_fq ? String.valueOf(hashCode()) : null;
        this.jad_bo = com.jd.ad.sdk.jad_hq.jad_dq.jad_an();
        this.jad_cp = obj;
        this.jad_fs = context;
        this.jad_jt = jad_erVar;
        this.jad_hu = obj2;
        this.jad_iv = cls;
        this.jad_jw = jad_anVar;
        this.jad_kx = i10;
        this.jad_ly = i11;
        this.jad_mz = jad_jtVar;
        this.jad_na = jad_erVar2;
        this.jad_dq = jad_jtVar2;
        this.jad_ob = list;
        this.jad_er = jad_fsVar;
        this.jad_uh = jad_mzVar;
        this.jad_pc = jad_cpVar;
        this.jad_qd = executor;
        this.jad_vi = 1;
        if (this.jad_ep == null && jad_erVar.jad_cp().jad_an(jad_dq.C0359jad_dq.class)) {
            this.jad_ep = new RuntimeException("Glide request origin trace");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002e A[Catch: all -> 0x0042, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0010, B:9:0x0012, B:11:0x001a, B:12:0x001e, B:14:0x0022, B:19:0x002e, B:20:0x0037, B:21:0x0039), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    @Override // com.jd.ad.sdk.jad_al.jad_dq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void clear() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.jad_cp
            monitor-enter(r0)
            r5.jad_bo()     // Catch: java.lang.Throwable -> L42
            com.jd.ad.sdk.jad_hq.jad_dq r1 = r5.jad_bo     // Catch: java.lang.Throwable -> L42
            r1.jad_bo()     // Catch: java.lang.Throwable -> L42
            int r1 = r5.jad_vi     // Catch: java.lang.Throwable -> L42
            r2 = 6
            if (r1 != r2) goto L12
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L42
            return
        L12:
            r5.jad_jt()     // Catch: java.lang.Throwable -> L42
            com.jd.ad.sdk.jad_kv.jad_xk<R> r1 = r5.jad_re     // Catch: java.lang.Throwable -> L42
            r3 = 0
            if (r1 == 0) goto L1d
            r5.jad_re = r3     // Catch: java.lang.Throwable -> L42
            goto L1e
        L1d:
            r1 = r3
        L1e:
            com.jd.ad.sdk.jad_al.jad_fs r3 = r5.jad_er     // Catch: java.lang.Throwable -> L42
            if (r3 == 0) goto L2b
            boolean r3 = r3.jad_fs(r5)     // Catch: java.lang.Throwable -> L42
            if (r3 == 0) goto L29
            goto L2b
        L29:
            r3 = 0
            goto L2c
        L2b:
            r3 = 1
        L2c:
            if (r3 == 0) goto L37
            com.jd.ad.sdk.jad_bm.jad_er<R> r3 = r5.jad_na     // Catch: java.lang.Throwable -> L42
            android.graphics.drawable.Drawable r4 = r5.jad_iv()     // Catch: java.lang.Throwable -> L42
            r3.jad_an(r4)     // Catch: java.lang.Throwable -> L42
        L37:
            r5.jad_vi = r2     // Catch: java.lang.Throwable -> L42
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L42
            if (r1 == 0) goto L41
            com.jd.ad.sdk.jad_kv.jad_mz r0 = r5.jad_uh
            r0.jad_an(r1)
        L41:
            return
        L42:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L42
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_al.jad_jw.clear():void");
    }

    @Override // com.jd.ad.sdk.jad_al.jad_dq
    public boolean isRunning() {
        boolean z10;
        synchronized (this.jad_cp) {
            int i10 = this.jad_vi;
            z10 = i10 == 2 || i10 == 3;
        }
        return z10;
    }

    @GuardedBy("requestLock")
    public final Drawable jad_an(@DrawableRes int i10) {
        Resources.Theme theme = this.jad_jw.jad_uh;
        if (theme == null) {
            theme = this.jad_fs.getTheme();
        }
        com.jd.ad.sdk.jad_ep.jad_er jad_erVar = this.jad_jt;
        return com.jd.ad.sdk.jad_te.jad_bo.jad_an(jad_erVar, jad_erVar, i10, theme);
    }

    public final void jad_an(String str) {
        Logger.v("GlideRequest", str + " this: " + this.jad_an);
    }

    @Override // com.jd.ad.sdk.jad_al.jad_dq
    public boolean jad_an() {
        boolean z10;
        synchronized (this.jad_cp) {
            z10 = this.jad_vi == 4;
        }
        return z10;
    }

    @GuardedBy("requestLock")
    public final void jad_bo() {
        if (this.jad_do) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    @Override // com.jd.ad.sdk.jad_al.jad_dq
    public boolean jad_cp() {
        boolean z10;
        synchronized (this.jad_cp) {
            z10 = this.jad_vi == 4;
        }
        return z10;
    }

    @Override // com.jd.ad.sdk.jad_al.jad_dq
    public void jad_dq() {
        synchronized (this.jad_cp) {
            if (isRunning()) {
                clear();
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_al.jad_dq
    public boolean jad_dq(jad_dq jad_dqVar) {
        int i10;
        int i11;
        Object obj;
        Class<R> cls;
        jad_an<?> jad_anVar;
        com.jd.ad.sdk.jad_ep.jad_jt jad_jtVar;
        int size;
        int i12;
        int i13;
        Object obj2;
        Class<R> cls2;
        jad_an<?> jad_anVar2;
        com.jd.ad.sdk.jad_ep.jad_jt jad_jtVar2;
        int size2;
        boolean jad_an;
        if (!(jad_dqVar instanceof jad_jw)) {
            return false;
        }
        synchronized (this.jad_cp) {
            i10 = this.jad_kx;
            i11 = this.jad_ly;
            obj = this.jad_hu;
            cls = this.jad_iv;
            jad_anVar = this.jad_jw;
            jad_jtVar = this.jad_mz;
            List<jad_jt<R>> list = this.jad_ob;
            size = list != null ? list.size() : 0;
        }
        jad_jw jad_jwVar = (jad_jw) jad_dqVar;
        synchronized (jad_jwVar.jad_cp) {
            i12 = jad_jwVar.jad_kx;
            i13 = jad_jwVar.jad_ly;
            obj2 = jad_jwVar.jad_hu;
            cls2 = jad_jwVar.jad_iv;
            jad_anVar2 = jad_jwVar.jad_jw;
            jad_jtVar2 = jad_jwVar.jad_mz;
            List<jad_jt<R>> list2 = jad_jwVar.jad_ob;
            size2 = list2 != null ? list2.size() : 0;
        }
        if (i10 == i12 && i11 == i13) {
            char[] cArr = jad_ly.jad_an;
            if (obj == null) {
                jad_an = obj2 == null;
            } else {
                jad_an = obj instanceof com.jd.ad.sdk.jad_oz.jad_ly ? ((com.jd.ad.sdk.jad_oz.jad_ly) obj).jad_an(obj2) : obj.equals(obj2);
            }
            if (jad_an && cls.equals(cls2) && jad_anVar.equals(jad_anVar2) && jad_jtVar == jad_jtVar2 && size == size2) {
                return true;
            }
        }
        return false;
    }

    @Override // com.jd.ad.sdk.jad_al.jad_dq
    public boolean jad_er() {
        boolean z10;
        synchronized (this.jad_cp) {
            z10 = this.jad_vi == 6;
        }
        return z10;
    }

    @Override // com.jd.ad.sdk.jad_al.jad_dq
    public void jad_fs() {
        synchronized (this.jad_cp) {
            jad_bo();
            this.jad_bo.jad_bo();
            this.jad_tg = com.jd.ad.sdk.jad_gp.jad_jt.jad_an();
            if (this.jad_hu == null) {
                if (jad_ly.jad_bo(this.jad_kx, this.jad_ly)) {
                    this.jad_zm = this.jad_kx;
                    this.jad_cn = this.jad_ly;
                }
                jad_an(new jad_sf("Received null model", Collections.emptyList()), jad_hu() == null ? 5 : 3);
                return;
            }
            int i10 = this.jad_vi;
            if (i10 == 2) {
                throw new IllegalArgumentException("Cannot restart a running request");
            }
            if (i10 == 4) {
                jad_an(this.jad_re, com.jd.ad.sdk.jad_hs.jad_an.MEMORY_CACHE, false);
                return;
            }
            List<jad_jt<R>> list = this.jad_ob;
            if (list != null) {
                for (jad_jt<R> jad_jtVar : list) {
                    if (jad_jtVar instanceof jad_cp) {
                        ((jad_cp) jad_jtVar).getClass();
                    }
                }
            }
            this.jad_vi = 3;
            if (jad_ly.jad_bo(this.jad_kx, this.jad_ly)) {
                jad_an(this.jad_kx, this.jad_ly);
            } else {
                this.jad_na.jad_bo(this);
            }
            int i11 = this.jad_vi;
            if (i11 == 2 || i11 == 3) {
                jad_fs jad_fsVar = this.jad_er;
                if (jad_fsVar == null || jad_fsVar.jad_cp(this)) {
                    this.jad_na.jad_bo(jad_iv());
                }
            }
            if (jad_fq) {
                jad_an("finished run method in " + com.jd.ad.sdk.jad_gp.jad_jt.jad_an(this.jad_tg));
            }
        }
    }

    @GuardedBy("requestLock")
    public final Drawable jad_hu() {
        int i10;
        if (this.jad_yl == null) {
            jad_an<?> jad_anVar = this.jad_jw;
            Drawable drawable = jad_anVar.jad_ob;
            this.jad_yl = drawable;
            if (drawable == null && (i10 = jad_anVar.jad_pc) > 0) {
                this.jad_yl = jad_an(i10);
            }
        }
        return this.jad_yl;
    }

    @GuardedBy("requestLock")
    public final Drawable jad_iv() {
        int i10;
        if (this.jad_xk == null) {
            jad_an<?> jad_anVar = this.jad_jw;
            Drawable drawable = jad_anVar.jad_jt;
            this.jad_xk = drawable;
            if (drawable == null && (i10 = jad_anVar.jad_hu) > 0) {
                this.jad_xk = jad_an(i10);
            }
        }
        return this.jad_xk;
    }

    @GuardedBy("requestLock")
    public final void jad_jt() {
        jad_bo();
        this.jad_bo.jad_bo();
        this.jad_na.jad_an((com.jd.ad.sdk.jad_bm.jad_dq) this);
        jad_mz.jad_dq jad_dqVar = this.jad_sf;
        if (jad_dqVar != null) {
            synchronized (jad_mz.this) {
                jad_dqVar.jad_an.jad_an(jad_dqVar.jad_bo);
            }
            this.jad_sf = null;
        }
    }

    @GuardedBy("requestLock")
    public final boolean jad_jw() {
        jad_fs jad_fsVar = this.jad_er;
        return jad_fsVar == null || !jad_fsVar.jad_bo().jad_an();
    }

    @GuardedBy("requestLock")
    public final void jad_kx() {
        int i10;
        jad_fs jad_fsVar = this.jad_er;
        if (jad_fsVar == null || jad_fsVar.jad_cp(this)) {
            Drawable jad_hu = this.jad_hu == null ? jad_hu() : null;
            if (jad_hu == null) {
                if (this.jad_wj == null) {
                    jad_an<?> jad_anVar = this.jad_jw;
                    Drawable drawable = jad_anVar.jad_er;
                    this.jad_wj = drawable;
                    if (drawable == null && (i10 = jad_anVar.jad_fs) > 0) {
                        this.jad_wj = jad_an(i10);
                    }
                }
                jad_hu = this.jad_wj;
            }
            if (jad_hu == null) {
                jad_hu = jad_iv();
            }
            this.jad_na.jad_cp(jad_hu);
        }
    }

    public String toString() {
        Object obj;
        Class<R> cls;
        synchronized (this.jad_cp) {
            obj = this.jad_hu;
            cls = this.jad_iv;
        }
        return super.toString() + "[model=" + obj + ", transcodeClass=" + ((Object) cls) + "]";
    }

    public final void jad_an(jad_sf jad_sfVar, int i10) {
        boolean z10;
        this.jad_bo.jad_bo();
        synchronized (this.jad_cp) {
            jad_sfVar.getClass();
            int i11 = this.jad_jt.jad_hu;
            boolean z11 = true;
            if (i11 <= i10) {
                Logger.w(Glide.TAG, "Load failed for " + this.jad_hu + " with size [" + this.jad_zm + LanguageTag.PRIVATEUSE + this.jad_cn + "]", jad_sfVar);
                if (i11 <= 4) {
                    jad_sfVar.jad_an(Glide.TAG);
                }
            }
            this.jad_sf = null;
            this.jad_vi = 5;
            this.jad_do = true;
            try {
                List<jad_jt<R>> list = this.jad_ob;
                if (list != null) {
                    Iterator<jad_jt<R>> iterator2 = list.iterator2();
                    z10 = false;
                    while (iterator2.hasNext()) {
                        z10 |= iterator2.next().jad_an(jad_sfVar, this.jad_hu, this.jad_na, jad_jw());
                    }
                } else {
                    z10 = false;
                }
                jad_jt<R> jad_jtVar = this.jad_dq;
                if (jad_jtVar == null || !jad_jtVar.jad_an(jad_sfVar, this.jad_hu, this.jad_na, jad_jw())) {
                    z11 = false;
                }
                if (!(z10 | z11)) {
                    jad_kx();
                }
                this.jad_do = false;
                jad_fs jad_fsVar = this.jad_er;
                if (jad_fsVar != null) {
                    jad_fsVar.jad_an(this);
                }
            } catch (Throwable th) {
                this.jad_do = false;
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void jad_an(jad_xk<?> jad_xkVar, com.jd.ad.sdk.jad_hs.jad_an jad_anVar, boolean z10) {
        jad_jw jad_jwVar;
        Throwable th;
        this.jad_bo.jad_bo();
        jad_xk<?> jad_xkVar2 = null;
        try {
            synchronized (this.jad_cp) {
                try {
                    this.jad_sf = null;
                    if (jad_xkVar == null) {
                        jad_an(new jad_sf("Expected to receive a Resource<R> with an object of " + ((Object) this.jad_iv) + " inside, but instead got null.", Collections.emptyList()), 5);
                        return;
                    }
                    Object obj = jad_xkVar.get();
                    try {
                        if (obj != null && this.jad_iv.isAssignableFrom(obj.getClass())) {
                            jad_fs jad_fsVar = this.jad_er;
                            if (jad_fsVar == null || jad_fsVar.jad_bo(this)) {
                                jad_an(jad_xkVar, obj, jad_anVar, z10);
                                return;
                            }
                            this.jad_re = null;
                            this.jad_vi = 4;
                            this.jad_uh.jad_an(jad_xkVar);
                            return;
                        }
                        this.jad_re = null;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Expected to receive an object of ");
                        sb2.append((Object) this.jad_iv);
                        sb2.append(" but instead got ");
                        sb2.append(obj != null ? obj.getClass() : "");
                        sb2.append("{");
                        sb2.append(obj);
                        sb2.append("} inside Resource{");
                        sb2.append((Object) jad_xkVar);
                        sb2.append("}.");
                        sb2.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                        jad_an(new jad_sf(sb2.toString(), Collections.emptyList()), 5);
                        this.jad_uh.jad_an(jad_xkVar);
                    } catch (Throwable th2) {
                        th = th2;
                        jad_xkVar2 = jad_xkVar;
                        jad_jwVar = this;
                        while (true) {
                            try {
                                try {
                                    break;
                                } catch (Throwable th3) {
                                    th = th3;
                                    if (jad_xkVar2 != null) {
                                        jad_jwVar.jad_uh.jad_an(jad_xkVar2);
                                    }
                                    throw th;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                jad_jwVar = jad_jwVar;
                            }
                            th = th4;
                            jad_jwVar = jad_jwVar;
                        }
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    jad_jwVar = this;
                }
            }
        } catch (Throwable th6) {
            th = th6;
            jad_jwVar = this;
        }
    }

    @GuardedBy("requestLock")
    public final void jad_an(jad_xk<R> jad_xkVar, R r10, com.jd.ad.sdk.jad_hs.jad_an jad_anVar, boolean z10) {
        boolean z11;
        boolean jad_jw = jad_jw();
        this.jad_vi = 4;
        this.jad_re = jad_xkVar;
        boolean z12 = true;
        if (this.jad_jt.jad_hu <= 3) {
            StringBuilder jad_an = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("Finished loading ");
            jad_an.append(r10.getClass().getSimpleName());
            jad_an.append(" from ");
            jad_an.append((Object) jad_anVar);
            jad_an.append(" for ");
            jad_an.append(this.jad_hu);
            jad_an.append(" with size [");
            jad_an.append(this.jad_zm);
            jad_an.append(LanguageTag.PRIVATEUSE);
            jad_an.append(this.jad_cn);
            jad_an.append("] in ");
            jad_an.append(com.jd.ad.sdk.jad_gp.jad_jt.jad_an(this.jad_tg));
            jad_an.append(" ms");
            Logger.d(Glide.TAG, jad_an.toString());
        }
        this.jad_do = true;
        try {
            List<jad_jt<R>> list = this.jad_ob;
            if (list != null) {
                Iterator<jad_jt<R>> iterator2 = list.iterator2();
                z11 = false;
                while (iterator2.hasNext()) {
                    z11 |= iterator2.next().jad_an(r10, this.jad_hu, this.jad_na, jad_anVar, jad_jw);
                }
            } else {
                z11 = false;
            }
            jad_jt<R> jad_jtVar = this.jad_dq;
            if (jad_jtVar == null || !jad_jtVar.jad_an(r10, this.jad_hu, this.jad_na, jad_anVar, jad_jw)) {
                z12 = false;
            }
            if (!(z11 | z12)) {
                this.jad_pc.getClass();
                this.jad_na.jad_an(r10, com.jd.ad.sdk.jad_en.jad_an.jad_an);
            }
            this.jad_do = false;
            jad_fs jad_fsVar = this.jad_er;
            if (jad_fsVar != null) {
                jad_fsVar.jad_er(this);
            }
        } catch (Throwable th) {
            this.jad_do = false;
            throw th;
        }
    }

    public void jad_an(int i10, int i11) {
        Object obj;
        int i12 = i10;
        this.jad_bo.jad_bo();
        Object obj2 = this.jad_cp;
        synchronized (obj2) {
            try {
                try {
                    boolean z10 = jad_fq;
                    if (z10) {
                        jad_an("Got onSizeReady in " + com.jd.ad.sdk.jad_gp.jad_jt.jad_an(this.jad_tg));
                    }
                    if (this.jad_vi == 3) {
                        this.jad_vi = 2;
                        float f10 = this.jad_jw.jad_bo;
                        if (i12 != Integer.MIN_VALUE) {
                            i12 = Math.round(i12 * f10);
                        }
                        this.jad_zm = i12;
                        this.jad_cn = i11 == Integer.MIN_VALUE ? i11 : Math.round(f10 * i11);
                        if (z10) {
                            jad_an("finished setup for calling load in " + com.jd.ad.sdk.jad_gp.jad_jt.jad_an(this.jad_tg));
                        }
                        jad_mz jad_mzVar = this.jad_uh;
                        com.jd.ad.sdk.jad_ep.jad_er jad_erVar = this.jad_jt;
                        Object obj3 = this.jad_hu;
                        jad_an<?> jad_anVar = this.jad_jw;
                        try {
                            obj = obj2;
                        } catch (Throwable th) {
                            th = th;
                            obj = obj2;
                        }
                        try {
                            this.jad_sf = jad_mzVar.jad_an(jad_erVar, obj3, jad_anVar.jad_ly, this.jad_zm, this.jad_cn, jad_anVar.jad_sf, this.jad_iv, this.jad_mz, jad_anVar.jad_cp, jad_anVar.jad_re, jad_anVar.jad_mz, jad_anVar.jad_yl, jad_anVar.jad_qd, jad_anVar.jad_iv, jad_anVar.jad_wj, jad_anVar.jad_zm, jad_anVar.jad_xk, this, this.jad_qd);
                            if (this.jad_vi != 2) {
                                this.jad_sf = null;
                            }
                            if (z10) {
                                jad_an("finished onSizeReady in " + com.jd.ad.sdk.jad_gp.jad_jt.jad_an(this.jad_tg));
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    obj = obj2;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }
}
