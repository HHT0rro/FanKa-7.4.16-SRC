package com.jd.ad.sdk.jad_ep;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alipay.sdk.util.i;
import com.jd.ad.sdk.jad_xi.jad_cp;
import com.jd.ad.sdk.jad_xi.jad_mz;
import com.jd.ad.sdk.jad_xi.jad_qd;
import com.jd.ad.sdk.jad_xi.jad_re;
import com.jd.ad.sdk.jad_xi.jad_vi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_jw implements ComponentCallbacks2, jad_mz {
    public static final com.jd.ad.sdk.jad_al.jad_hu jad_kx;
    public final jad_cp jad_an;
    public final Context jad_bo;
    public final com.jd.ad.sdk.jad_xi.jad_ly jad_cp;

    @GuardedBy("this")
    public final jad_re jad_dq;

    @GuardedBy("this")
    public final jad_qd jad_er;

    @GuardedBy("this")
    public final jad_vi jad_fs = new jad_vi();
    public final com.jd.ad.sdk.jad_xi.jad_cp jad_hu;
    public final CopyOnWriteArrayList<com.jd.ad.sdk.jad_al.jad_jt<Object>> jad_iv;
    public final Runnable jad_jt;

    @GuardedBy("this")
    public com.jd.ad.sdk.jad_al.jad_hu jad_jw;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class jad_an implements Runnable {
        public jad_an() {
        }

        @Override // java.lang.Runnable
        public void run() {
            jad_jw jad_jwVar = jad_jw.this;
            jad_jwVar.jad_cp.jad_an(jad_jwVar);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class jad_bo implements jad_cp.jad_an {

        @GuardedBy("RequestManager.this")
        public final jad_re jad_an;

        public jad_bo(jad_re jad_reVar) {
            this.jad_an = jad_reVar;
        }

        @Override // com.jd.ad.sdk.jad_xi.jad_cp.jad_an
        public void jad_an(boolean z10) {
            if (z10) {
                synchronized (jad_jw.this) {
                    jad_re jad_reVar = this.jad_an;
                    Iterator iterator2 = ((ArrayList) com.jd.ad.sdk.jad_gp.jad_ly.jad_an(jad_reVar.jad_an)).iterator2();
                    while (iterator2.hasNext()) {
                        com.jd.ad.sdk.jad_al.jad_dq jad_dqVar = (com.jd.ad.sdk.jad_al.jad_dq) iterator2.next();
                        if (!jad_dqVar.jad_cp() && !jad_dqVar.jad_er()) {
                            jad_dqVar.clear();
                            if (jad_reVar.jad_cp) {
                                jad_reVar.jad_bo.add(jad_dqVar);
                            } else {
                                jad_dqVar.jad_fs();
                            }
                        }
                    }
                }
            }
        }
    }

    static {
        com.jd.ad.sdk.jad_al.jad_hu jad_an2 = new com.jd.ad.sdk.jad_al.jad_hu().jad_an(Bitmap.class);
        jad_an2.jad_tg = true;
        jad_kx = jad_an2;
        new com.jd.ad.sdk.jad_al.jad_hu().jad_an(com.jd.ad.sdk.jad_vg.jad_cp.class).jad_tg = true;
        new com.jd.ad.sdk.jad_al.jad_hu().jad_an(com.jd.ad.sdk.jad_kv.jad_ly.jad_bo).jad_an(jad_jt.LOW).jad_an(true);
    }

    public jad_jw(jad_cp jad_cpVar, com.jd.ad.sdk.jad_xi.jad_ly jad_lyVar, jad_qd jad_qdVar, jad_re jad_reVar, com.jd.ad.sdk.jad_xi.jad_dq jad_dqVar, Context context) {
        jad_an jad_anVar = new jad_an();
        this.jad_jt = jad_anVar;
        this.jad_an = jad_cpVar;
        this.jad_cp = jad_lyVar;
        this.jad_er = jad_qdVar;
        this.jad_dq = jad_reVar;
        this.jad_bo = context;
        com.jd.ad.sdk.jad_xi.jad_cp jad_an2 = ((com.jd.ad.sdk.jad_xi.jad_fs) jad_dqVar).jad_an(context.getApplicationContext(), new jad_bo(jad_reVar));
        this.jad_hu = jad_an2;
        if (com.jd.ad.sdk.jad_gp.jad_ly.jad_cp()) {
            com.jd.ad.sdk.jad_gp.jad_ly.jad_an(jad_anVar);
        } else {
            jad_lyVar.jad_an(this);
        }
        jad_lyVar.jad_an(jad_an2);
        this.jad_iv = new CopyOnWriteArrayList<>(jad_cpVar.jad_dq().jad_an());
        jad_an(jad_cpVar.jad_dq().jad_bo());
        jad_cpVar.jad_an(this);
    }

    public void jad_an(@Nullable com.jd.ad.sdk.jad_bm.jad_er<?> jad_erVar) {
        boolean z10;
        if (jad_erVar == null) {
            return;
        }
        boolean jad_bo2 = jad_bo(jad_erVar);
        com.jd.ad.sdk.jad_al.jad_dq jad_bo3 = jad_erVar.jad_bo();
        if (jad_bo2) {
            return;
        }
        jad_cp jad_cpVar = this.jad_an;
        synchronized (jad_cpVar.jad_hu) {
            Iterator<jad_jw> iterator2 = jad_cpVar.jad_hu.iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    z10 = false;
                    break;
                } else if (iterator2.next().jad_bo(jad_erVar)) {
                    z10 = true;
                    break;
                }
            }
        }
        if (z10 || jad_bo3 == null) {
            return;
        }
        jad_erVar.jad_an((com.jd.ad.sdk.jad_al.jad_dq) null);
        jad_bo3.clear();
    }

    public synchronized boolean jad_bo(@NonNull com.jd.ad.sdk.jad_bm.jad_er<?> jad_erVar) {
        com.jd.ad.sdk.jad_al.jad_dq jad_bo2 = jad_erVar.jad_bo();
        if (jad_bo2 == null) {
            return true;
        }
        if (!this.jad_dq.jad_an(jad_bo2)) {
            return false;
        }
        this.jad_fs.jad_an.remove(jad_erVar);
        jad_erVar.jad_an((com.jd.ad.sdk.jad_al.jad_dq) null);
        return true;
    }

    @Override // com.jd.ad.sdk.jad_xi.jad_mz
    public synchronized void jad_cp() {
        synchronized (this) {
            jad_re jad_reVar = this.jad_dq;
            jad_reVar.jad_cp = false;
            Iterator iterator2 = ((ArrayList) com.jd.ad.sdk.jad_gp.jad_ly.jad_an(jad_reVar.jad_an)).iterator2();
            while (iterator2.hasNext()) {
                com.jd.ad.sdk.jad_al.jad_dq jad_dqVar = (com.jd.ad.sdk.jad_al.jad_dq) iterator2.next();
                if (!jad_dqVar.jad_cp() && !jad_dqVar.isRunning()) {
                    jad_dqVar.jad_fs();
                }
            }
            jad_reVar.jad_bo.clear();
        }
        this.jad_fs.jad_cp();
    }

    @Override // com.jd.ad.sdk.jad_xi.jad_mz
    public synchronized void jad_dq() {
        this.jad_fs.jad_dq();
        Iterator iterator2 = ((ArrayList) com.jd.ad.sdk.jad_gp.jad_ly.jad_an(this.jad_fs.jad_an)).iterator2();
        while (iterator2.hasNext()) {
            jad_an((com.jd.ad.sdk.jad_bm.jad_er<?>) iterator2.next());
        }
        this.jad_fs.jad_an.clear();
        jad_re jad_reVar = this.jad_dq;
        Iterator iterator22 = ((ArrayList) com.jd.ad.sdk.jad_gp.jad_ly.jad_an(jad_reVar.jad_an)).iterator2();
        while (iterator22.hasNext()) {
            jad_reVar.jad_an((com.jd.ad.sdk.jad_al.jad_dq) iterator22.next());
        }
        jad_reVar.jad_bo.clear();
        this.jad_cp.jad_bo(this);
        this.jad_cp.jad_bo(this.jad_hu);
        com.jd.ad.sdk.jad_gp.jad_ly.jad_bo().removeCallbacks(this.jad_jt);
        jad_cp jad_cpVar = this.jad_an;
        synchronized (jad_cpVar.jad_hu) {
            if (!jad_cpVar.jad_hu.contains(this)) {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
            jad_cpVar.jad_hu.remove(this);
        }
    }

    @NonNull
    @CheckResult
    public jad_iv<Bitmap> jad_er() {
        return new jad_iv(this.jad_an, this, Bitmap.class, this.jad_bo).jad_bo(jad_kx);
    }

    public List<com.jd.ad.sdk.jad_al.jad_jt<Object>> jad_fs() {
        return this.jad_iv;
    }

    public synchronized com.jd.ad.sdk.jad_al.jad_hu jad_jt() {
        return this.jad_jw;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + ((Object) this.jad_dq) + ", treeNode=" + ((Object) this.jad_er) + i.f4738d;
    }

    @NonNull
    public <T> jad_kx<?, T> jad_an(Class<T> cls) {
        jad_er jad_erVar = this.jad_an.jad_cp;
        jad_kx<?, T> jad_kxVar = (jad_kx) jad_erVar.jad_er.get(cls);
        if (jad_kxVar == null) {
            for (Map.Entry<Class<?>, jad_kx<?, ?>> entry : jad_erVar.jad_er.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    jad_kxVar = (jad_kx) entry.getValue();
                }
            }
        }
        return jad_kxVar == null ? (jad_kx<?, T>) jad_er.jad_jw : jad_kxVar;
    }

    @NonNull
    @CheckResult
    public jad_iv<Drawable> jad_an(@Nullable String str) {
        return new jad_iv(this.jad_an, this, Drawable.class, this.jad_bo).jad_an(str);
    }

    @Override // com.jd.ad.sdk.jad_xi.jad_mz
    public synchronized void jad_an() {
        synchronized (this) {
            jad_re jad_reVar = this.jad_dq;
            jad_reVar.jad_cp = true;
            Iterator iterator2 = ((ArrayList) com.jd.ad.sdk.jad_gp.jad_ly.jad_an(jad_reVar.jad_an)).iterator2();
            while (iterator2.hasNext()) {
                com.jd.ad.sdk.jad_al.jad_dq jad_dqVar = (com.jd.ad.sdk.jad_al.jad_dq) iterator2.next();
                if (jad_dqVar.isRunning()) {
                    jad_dqVar.jad_dq();
                    jad_reVar.jad_bo.add(jad_dqVar);
                }
            }
        }
        this.jad_fs.jad_an();
    }

    public synchronized void jad_an(@NonNull com.jd.ad.sdk.jad_al.jad_hu jad_huVar) {
        com.jd.ad.sdk.jad_al.jad_hu clone = jad_huVar.clone();
        if (clone.jad_tg && !clone.jad_vi) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        clone.jad_vi = true;
        clone.jad_tg = true;
        this.jad_jw = clone;
    }
}
