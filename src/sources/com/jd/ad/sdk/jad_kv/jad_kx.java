package com.jd.ad.sdk.jad_kv;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.alipay.sdk.util.i;
import com.jd.ad.sdk.jad_ep.jad_hu;
import com.jd.ad.sdk.jad_kv.jad_hu;
import com.jd.ad.sdk.jad_oz.jad_na;
import com.jd.ad.sdk.logger.Logger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_kx<DataType, ResourceType, Transcode> {
    public final Class<DataType> jad_an;
    public final List<? extends com.jd.ad.sdk.jad_hs.jad_ly<DataType, ResourceType>> jad_bo;
    public final com.jd.ad.sdk.jad_wh.jad_er<ResourceType, Transcode> jad_cp;
    public final Pools.Pool<List<Throwable>> jad_dq;
    public final String jad_er;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface jad_an<ResourceType> {
    }

    public jad_kx(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends com.jd.ad.sdk.jad_hs.jad_ly<DataType, ResourceType>> list, com.jd.ad.sdk.jad_wh.jad_er<ResourceType, Transcode> jad_erVar, Pools.Pool<List<Throwable>> pool) {
        this.jad_an = cls;
        this.jad_bo = list;
        this.jad_cp = jad_erVar;
        this.jad_dq = pool;
        StringBuilder jad_an2 = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("Failed DecodePath{");
        jad_an2.append(cls.getSimpleName());
        jad_an2.append("->");
        jad_an2.append(cls2.getSimpleName());
        jad_an2.append("->");
        jad_an2.append(cls3.getSimpleName());
        jad_an2.append(i.f4738d);
        this.jad_er = jad_an2.toString();
    }

    public jad_xk<Transcode> jad_an(com.jd.ad.sdk.jad_it.jad_er<DataType> jad_erVar, int i10, int i11, @NonNull com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar, jad_an<ResourceType> jad_anVar) {
        jad_xk<ResourceType> jad_xkVar;
        com.jd.ad.sdk.jad_hs.jad_na jad_naVar;
        com.jd.ad.sdk.jad_hs.jad_cp jad_cpVar;
        com.jd.ad.sdk.jad_hs.jad_hu jad_dqVar;
        List<Throwable> list = (List) com.jd.ad.sdk.jad_gp.jad_kx.jad_an(this.jad_dq.acquire());
        try {
            jad_xk<ResourceType> jad_an2 = jad_an(jad_erVar, i10, i11, jad_jwVar, list);
            this.jad_dq.release(list);
            jad_hu.jad_cp jad_cpVar2 = (jad_hu.jad_cp) jad_anVar;
            jad_hu jad_huVar = jad_hu.this;
            com.jd.ad.sdk.jad_hs.jad_an jad_anVar2 = jad_cpVar2.jad_an;
            jad_huVar.getClass();
            Class<?> cls = jad_an2.get().getClass();
            com.jd.ad.sdk.jad_hs.jad_mz jad_mzVar = null;
            if (jad_anVar2 != com.jd.ad.sdk.jad_hs.jad_an.RESOURCE_DISK_CACHE) {
                com.jd.ad.sdk.jad_hs.jad_na jad_bo = jad_huVar.jad_an.jad_bo(cls);
                jad_naVar = jad_bo;
                jad_xkVar = jad_bo.jad_an(jad_huVar.jad_hu, jad_an2, jad_huVar.jad_ly, jad_huVar.jad_mz);
            } else {
                jad_xkVar = jad_an2;
                jad_naVar = null;
            }
            if (!jad_an2.equals(jad_xkVar)) {
                jad_an2.jad_dq();
            }
            if (jad_huVar.jad_an.jad_an((jad_xk<?>) jad_xkVar)) {
                jad_mzVar = jad_huVar.jad_an.jad_cp.jad_bo.jad_dq.jad_an(jad_xkVar.jad_cp());
                if (jad_mzVar != null) {
                    jad_cpVar = jad_mzVar.jad_an(jad_huVar.jad_ob);
                } else {
                    throw new jad_hu.jad_dq(jad_xkVar.jad_cp());
                }
            } else {
                jad_cpVar = com.jd.ad.sdk.jad_hs.jad_cp.NONE;
            }
            com.jd.ad.sdk.jad_hs.jad_mz jad_mzVar2 = jad_mzVar;
            jad_jt<R> jad_jtVar = jad_huVar.jad_an;
            com.jd.ad.sdk.jad_hs.jad_hu jad_huVar2 = jad_huVar.jad_xk;
            List<jad_na.jad_an<?>> jad_cp = jad_jtVar.jad_cp();
            int size = jad_cp.size();
            boolean z10 = false;
            int i12 = 0;
            while (true) {
                if (i12 >= size) {
                    break;
                }
                if (jad_cp.get(i12).jad_an.equals(jad_huVar2)) {
                    z10 = true;
                    break;
                }
                i12++;
            }
            jad_xk<ResourceType> jad_xkVar2 = jad_xkVar;
            if (jad_huVar.jad_na.jad_an(!z10, jad_anVar2, jad_cpVar)) {
                if (jad_mzVar2 != null) {
                    int i13 = jad_hu.jad_an.jad_cp[jad_cpVar.ordinal()];
                    if (i13 == 1) {
                        jad_dqVar = new jad_dq(jad_huVar.jad_xk, jad_huVar.jad_iv);
                    } else {
                        if (i13 != 2) {
                            throw new IllegalArgumentException("Unknown strategy: " + ((Object) jad_cpVar));
                        }
                        jad_dqVar = new jad_zm(jad_huVar.jad_an.jad_cp.jad_an, jad_huVar.jad_xk, jad_huVar.jad_iv, jad_huVar.jad_ly, jad_huVar.jad_mz, jad_naVar, cls, jad_huVar.jad_ob);
                    }
                    jad_wj<Z> jad_an3 = jad_wj.jad_an(jad_xkVar);
                    jad_hu.jad_dq<?> jad_dqVar2 = jad_huVar.jad_fs;
                    jad_dqVar2.jad_an = jad_dqVar;
                    jad_dqVar2.jad_bo = jad_mzVar2;
                    jad_dqVar2.jad_cp = jad_an3;
                    jad_xkVar2 = jad_an3;
                } else {
                    throw new jad_hu.jad_dq(jad_xkVar.get().getClass());
                }
            }
            return this.jad_cp.jad_an(jad_xkVar2, jad_jwVar);
        } catch (Throwable th) {
            this.jad_dq.release(list);
            throw th;
        }
    }

    @NonNull
    public final jad_xk<ResourceType> jad_an(com.jd.ad.sdk.jad_it.jad_er<DataType> jad_erVar, int i10, int i11, @NonNull com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar, List<Throwable> list) {
        int size = this.jad_bo.size();
        jad_xk<ResourceType> jad_xkVar = null;
        for (int i12 = 0; i12 < size; i12++) {
            com.jd.ad.sdk.jad_hs.jad_ly<DataType, ResourceType> jad_lyVar = this.jad_bo.get(i12);
            try {
                if (jad_lyVar.jad_an(jad_erVar.jad_an(), jad_jwVar)) {
                    jad_xkVar = jad_lyVar.jad_an(jad_erVar.jad_an(), i10, i11, jad_jwVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e2) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Logger.v("DecodePath", "Failed to decode data for " + ((Object) jad_lyVar), e2);
                }
                list.add(e2);
            }
            if (jad_xkVar != null) {
                break;
            }
        }
        if (jad_xkVar != null) {
            return jad_xkVar;
        }
        throw new jad_sf(this.jad_er, new ArrayList(list));
    }

    public String toString() {
        StringBuilder jad_an2 = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("DecodePath{ dataClass=");
        jad_an2.append((Object) this.jad_an);
        jad_an2.append(", decoders=");
        jad_an2.append((Object) this.jad_bo);
        jad_an2.append(", transcoder=");
        jad_an2.append((Object) this.jad_cp);
        jad_an2.append('}');
        return jad_an2.toString();
    }
}
