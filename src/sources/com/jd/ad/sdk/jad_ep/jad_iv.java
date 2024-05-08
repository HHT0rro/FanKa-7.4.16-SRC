package com.jd.ad.sdk.jad_ep;

import android.content.Context;
import android.util.Log;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_kv.jad_mz;
import com.jd.ad.sdk.jad_xi.jad_re;
import com.jd.ad.sdk.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_iv<TranscodeType> extends com.jd.ad.sdk.jad_al.jad_an<jad_iv<TranscodeType>> {
    public final Context jad_cn;
    public final jad_jw jad_do;
    public final Class<TranscodeType> jad_ep;
    public final jad_er jad_fq;

    @NonNull
    public jad_kx<?, ? super TranscodeType> jad_gr;

    @Nullable
    public Object jad_hs;

    @Nullable
    public List<com.jd.ad.sdk.jad_al.jad_jt<TranscodeType>> jad_it;

    @Nullable
    public jad_iv<TranscodeType> jad_ju;

    @Nullable
    public jad_iv<TranscodeType> jad_kv;
    public boolean jad_lw = true;
    public boolean jad_mx;
    public boolean jad_ny;

    static {
        new com.jd.ad.sdk.jad_al.jad_hu().jad_an(com.jd.ad.sdk.jad_kv.jad_ly.jad_bo).jad_an(jad_jt.LOW).jad_an(true);
    }

    public jad_iv(@NonNull jad_cp jad_cpVar, jad_jw jad_jwVar, Class<TranscodeType> cls, Context context) {
        this.jad_do = jad_jwVar;
        this.jad_ep = cls;
        this.jad_cn = context;
        this.jad_gr = jad_jwVar.jad_an(cls);
        this.jad_fq = jad_cpVar.jad_dq();
        jad_an(jad_jwVar.jad_fs());
        jad_bo(jad_jwVar.jad_jt());
    }

    @Override // com.jd.ad.sdk.jad_al.jad_an
    @NonNull
    @CheckResult
    public /* bridge */ /* synthetic */ com.jd.ad.sdk.jad_al.jad_an jad_an(@NonNull com.jd.ad.sdk.jad_al.jad_an jad_anVar) {
        return jad_bo((com.jd.ad.sdk.jad_al.jad_an<?>) jad_anVar);
    }

    @NonNull
    @CheckResult
    public jad_iv<TranscodeType> jad_an(@Nullable com.jd.ad.sdk.jad_al.jad_jt<TranscodeType> jad_jtVar) {
        if (this.jad_vi) {
            return clone().jad_an((com.jd.ad.sdk.jad_al.jad_jt) jad_jtVar);
        }
        if (jad_jtVar != null) {
            if (this.jad_it == null) {
                this.jad_it = new ArrayList();
            }
            this.jad_it.add(jad_jtVar);
        }
        return jad_bo();
    }

    public final void jad_an(List<com.jd.ad.sdk.jad_al.jad_jt<Object>> list) {
        Iterator<com.jd.ad.sdk.jad_al.jad_jt<Object>> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            jad_an((com.jd.ad.sdk.jad_al.jad_jt) iterator2.next());
        }
    }

    @NonNull
    @CheckResult
    public jad_iv<TranscodeType> jad_bo(@NonNull com.jd.ad.sdk.jad_al.jad_an<?> jad_anVar) {
        Objects.requireNonNull(jad_anVar, "Argument must not be null");
        return (jad_iv) super.jad_an(jad_anVar);
    }

    @Override // com.jd.ad.sdk.jad_al.jad_an
    @CheckResult
    /* renamed from: jad_cp, reason: merged with bridge method [inline-methods] */
    public jad_iv<TranscodeType> clone() {
        jad_iv<TranscodeType> jad_ivVar = (jad_iv) super.clone();
        jad_ivVar.jad_gr = (jad_kx<?, ? super TranscodeType>) jad_ivVar.jad_gr.jad_an();
        if (jad_ivVar.jad_it != null) {
            jad_ivVar.jad_it = new ArrayList(jad_ivVar.jad_it);
        }
        jad_iv<TranscodeType> jad_ivVar2 = jad_ivVar.jad_ju;
        if (jad_ivVar2 != null) {
            jad_ivVar.jad_ju = jad_ivVar2.clone();
        }
        jad_iv<TranscodeType> jad_ivVar3 = jad_ivVar.jad_kv;
        if (jad_ivVar3 != null) {
            jad_ivVar.jad_kv = jad_ivVar3.clone();
        }
        return jad_ivVar;
    }

    @NonNull
    public com.jd.ad.sdk.jad_bm.jad_er<TranscodeType> jad_dq() {
        return jad_an((jad_iv<TranscodeType>) new com.jd.ad.sdk.jad_bm.jad_cp(this.jad_do, Integer.MIN_VALUE, Integer.MIN_VALUE));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final com.jd.ad.sdk.jad_al.jad_dq jad_an(Object obj, com.jd.ad.sdk.jad_bm.jad_er<TranscodeType> jad_erVar, @Nullable com.jd.ad.sdk.jad_al.jad_jt<TranscodeType> jad_jtVar, @Nullable com.jd.ad.sdk.jad_al.jad_fs jad_fsVar, jad_kx<?, ? super TranscodeType> jad_kxVar, jad_jt jad_jtVar2, int i10, int i11, com.jd.ad.sdk.jad_al.jad_an<?> jad_anVar, Executor executor) {
        com.jd.ad.sdk.jad_al.jad_bo jad_boVar;
        com.jd.ad.sdk.jad_al.jad_fs jad_fsVar2;
        com.jd.ad.sdk.jad_al.jad_dq jad_an;
        int i12;
        int i13;
        jad_jt jad_bo;
        int i14;
        int i15;
        if (this.jad_kv != null) {
            jad_fsVar2 = new com.jd.ad.sdk.jad_al.jad_bo(obj, jad_fsVar);
            jad_boVar = jad_fsVar2;
        } else {
            jad_boVar = 0;
            jad_fsVar2 = jad_fsVar;
        }
        jad_iv<TranscodeType> jad_ivVar = this.jad_ju;
        if (jad_ivVar == null) {
            jad_an = jad_an(obj, jad_erVar, jad_jtVar, jad_anVar, jad_fsVar2, jad_kxVar, jad_jtVar2, i10, i11, executor);
        } else if (!this.jad_ny) {
            jad_kx<?, ? super TranscodeType> jad_kxVar2 = jad_ivVar.jad_lw ? jad_kxVar : jad_ivVar.jad_gr;
            if (com.jd.ad.sdk.jad_al.jad_an.jad_an(jad_ivVar.jad_an, 8)) {
                jad_bo = this.jad_ju.jad_dq;
            } else {
                jad_bo = jad_bo(jad_jtVar2);
            }
            jad_jt jad_jtVar3 = jad_bo;
            jad_iv<TranscodeType> jad_ivVar2 = this.jad_ju;
            int i16 = jad_ivVar2.jad_kx;
            int i17 = jad_ivVar2.jad_jw;
            if (com.jd.ad.sdk.jad_gp.jad_ly.jad_bo(i10, i11)) {
                jad_iv<TranscodeType> jad_ivVar3 = this.jad_ju;
                if (!com.jd.ad.sdk.jad_gp.jad_ly.jad_bo(jad_ivVar3.jad_kx, jad_ivVar3.jad_jw)) {
                    i15 = jad_anVar.jad_kx;
                    i14 = jad_anVar.jad_jw;
                    com.jd.ad.sdk.jad_al.jad_kx jad_kxVar3 = new com.jd.ad.sdk.jad_al.jad_kx(obj, jad_fsVar2);
                    com.jd.ad.sdk.jad_al.jad_dq jad_an2 = jad_an(obj, jad_erVar, jad_jtVar, jad_anVar, jad_kxVar3, jad_kxVar, jad_jtVar2, i10, i11, executor);
                    this.jad_ny = true;
                    jad_iv<TranscodeType> jad_ivVar4 = this.jad_ju;
                    com.jd.ad.sdk.jad_al.jad_dq jad_an3 = jad_ivVar4.jad_an(obj, jad_erVar, jad_jtVar, jad_kxVar3, jad_kxVar2, jad_jtVar3, i15, i14, jad_ivVar4, executor);
                    this.jad_ny = false;
                    jad_kxVar3.jad_cp = jad_an2;
                    jad_kxVar3.jad_dq = jad_an3;
                    jad_an = jad_kxVar3;
                }
            }
            i14 = i17;
            i15 = i16;
            com.jd.ad.sdk.jad_al.jad_kx jad_kxVar32 = new com.jd.ad.sdk.jad_al.jad_kx(obj, jad_fsVar2);
            com.jd.ad.sdk.jad_al.jad_dq jad_an22 = jad_an(obj, jad_erVar, jad_jtVar, jad_anVar, jad_kxVar32, jad_kxVar, jad_jtVar2, i10, i11, executor);
            this.jad_ny = true;
            jad_iv<TranscodeType> jad_ivVar42 = this.jad_ju;
            com.jd.ad.sdk.jad_al.jad_dq jad_an32 = jad_ivVar42.jad_an(obj, jad_erVar, jad_jtVar, jad_kxVar32, jad_kxVar2, jad_jtVar3, i15, i14, jad_ivVar42, executor);
            this.jad_ny = false;
            jad_kxVar32.jad_cp = jad_an22;
            jad_kxVar32.jad_dq = jad_an32;
            jad_an = jad_kxVar32;
        } else {
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        }
        if (jad_boVar == 0) {
            return jad_an;
        }
        jad_iv<TranscodeType> jad_ivVar5 = this.jad_kv;
        int i18 = jad_ivVar5.jad_kx;
        int i19 = jad_ivVar5.jad_jw;
        if (com.jd.ad.sdk.jad_gp.jad_ly.jad_bo(i10, i11)) {
            jad_iv<TranscodeType> jad_ivVar6 = this.jad_kv;
            if (!com.jd.ad.sdk.jad_gp.jad_ly.jad_bo(jad_ivVar6.jad_kx, jad_ivVar6.jad_jw)) {
                i13 = jad_anVar.jad_kx;
                i12 = jad_anVar.jad_jw;
                jad_iv<TranscodeType> jad_ivVar7 = this.jad_kv;
                com.jd.ad.sdk.jad_al.jad_dq jad_an4 = jad_ivVar7.jad_an(obj, jad_erVar, jad_jtVar, jad_boVar, jad_ivVar7.jad_gr, jad_ivVar7.jad_dq, i13, i12, jad_ivVar7, executor);
                jad_boVar.jad_cp = jad_an;
                jad_boVar.jad_dq = jad_an4;
                return jad_boVar;
            }
        }
        i12 = i19;
        i13 = i18;
        jad_iv<TranscodeType> jad_ivVar72 = this.jad_kv;
        com.jd.ad.sdk.jad_al.jad_dq jad_an42 = jad_ivVar72.jad_an(obj, jad_erVar, jad_jtVar, jad_boVar, jad_ivVar72.jad_gr, jad_ivVar72.jad_dq, i13, i12, jad_ivVar72, executor);
        jad_boVar.jad_cp = jad_an;
        jad_boVar.jad_dq = jad_an42;
        return jad_boVar;
    }

    @NonNull
    public final jad_jt jad_bo(@NonNull jad_jt jad_jtVar) {
        int ordinal = jad_jtVar.ordinal();
        if (ordinal == 0 || ordinal == 1) {
            return jad_jt.IMMEDIATE;
        }
        if (ordinal == 2) {
            return jad_jt.HIGH;
        }
        if (ordinal == 3) {
            return jad_jt.NORMAL;
        }
        StringBuilder jad_an = jad_ly.jad_an("unknown priority: ");
        jad_an.append((Object) this.jad_dq);
        throw new IllegalArgumentException(jad_an.toString());
    }

    @NonNull
    @CheckResult
    public jad_iv<TranscodeType> jad_bo(@Nullable com.jd.ad.sdk.jad_al.jad_jt<TranscodeType> jad_jtVar) {
        if (this.jad_vi) {
            return clone().jad_bo(jad_jtVar);
        }
        this.jad_it = null;
        return jad_an((com.jd.ad.sdk.jad_al.jad_jt) jad_jtVar);
    }

    @NonNull
    public <Y extends com.jd.ad.sdk.jad_bm.jad_er<TranscodeType>> Y jad_an(@NonNull Y y10) {
        Executor executor = com.jd.ad.sdk.jad_gp.jad_er.jad_an;
        Objects.requireNonNull(y10, "Argument must not be null");
        if (this.jad_mx) {
            com.jd.ad.sdk.jad_al.jad_dq jad_an = jad_an(new Object(), y10, (com.jd.ad.sdk.jad_al.jad_jt) null, (com.jd.ad.sdk.jad_al.jad_fs) null, this.jad_gr, this.jad_dq, this.jad_kx, this.jad_jw, this, executor);
            com.jd.ad.sdk.jad_bm.jad_an jad_anVar = (com.jd.ad.sdk.jad_bm.jad_an) y10;
            com.jd.ad.sdk.jad_al.jad_dq jad_dqVar = jad_anVar.jad_cp;
            if (jad_an.jad_dq(jad_dqVar)) {
                if (!(!this.jad_iv && jad_dqVar.jad_cp())) {
                    if (!((com.jd.ad.sdk.jad_al.jad_dq) com.jd.ad.sdk.jad_gp.jad_kx.jad_an(jad_dqVar)).isRunning()) {
                        jad_dqVar.jad_fs();
                    }
                    return y10;
                }
            }
            this.jad_do.jad_an((com.jd.ad.sdk.jad_bm.jad_er<?>) y10);
            jad_anVar.jad_cp = jad_an;
            jad_jw jad_jwVar = this.jad_do;
            synchronized (jad_jwVar) {
                jad_jwVar.jad_fs.jad_an.add(y10);
                jad_re jad_reVar = jad_jwVar.jad_dq;
                jad_reVar.jad_an.add(jad_an);
                if (jad_reVar.jad_cp) {
                    jad_an.clear();
                    if (Log.isLoggable("RequestTracker", 2)) {
                        Logger.v("RequestTracker", "Paused, delaying request");
                    }
                    jad_reVar.jad_bo.add(jad_an);
                } else {
                    jad_an.jad_fs();
                }
            }
            return y10;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    @NonNull
    public final jad_iv<TranscodeType> jad_an(@Nullable Object obj) {
        if (this.jad_vi) {
            return clone().jad_an(obj);
        }
        this.jad_hs = obj;
        this.jad_mx = true;
        return jad_bo();
    }

    public final com.jd.ad.sdk.jad_al.jad_dq jad_an(Object obj, com.jd.ad.sdk.jad_bm.jad_er<TranscodeType> jad_erVar, com.jd.ad.sdk.jad_al.jad_jt<TranscodeType> jad_jtVar, com.jd.ad.sdk.jad_al.jad_an<?> jad_anVar, com.jd.ad.sdk.jad_al.jad_fs jad_fsVar, jad_kx<?, ? super TranscodeType> jad_kxVar, jad_jt jad_jtVar2, int i10, int i11, Executor executor) {
        Context context = this.jad_cn;
        jad_er jad_erVar2 = this.jad_fq;
        Object obj2 = this.jad_hs;
        Class<TranscodeType> cls = this.jad_ep;
        List<com.jd.ad.sdk.jad_al.jad_jt<TranscodeType>> list = this.jad_it;
        jad_mz jad_mzVar = jad_erVar2.jad_fs;
        jad_kxVar.getClass();
        return new com.jd.ad.sdk.jad_al.jad_jw(context, jad_erVar2, obj, obj2, cls, jad_anVar, i10, i11, jad_jtVar2, jad_erVar, jad_jtVar, list, jad_fsVar, jad_mzVar, com.jd.ad.sdk.jad_en.jad_an.jad_bo, executor);
    }
}
