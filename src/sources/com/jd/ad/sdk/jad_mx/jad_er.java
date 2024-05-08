package com.jd.ad.sdk.jad_mx;

import android.util.Log;
import com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheWrapper;
import com.jd.ad.sdk.jad_fq.jad_an;
import com.jd.ad.sdk.jad_mx.jad_an;
import com.jd.ad.sdk.jad_mx.jad_cp;
import com.jd.ad.sdk.logger.Logger;
import java.io.File;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_er implements jad_an {
    public final File jad_bo;
    public final long jad_cp;
    public com.jd.ad.sdk.jad_fq.jad_an jad_er;
    public final jad_cp jad_dq = new jad_cp();
    public final jad_jw jad_an = new jad_jw();

    @Deprecated
    public jad_er(File file, long j10) {
        this.jad_bo = file;
        this.jad_cp = j10;
    }

    public final synchronized com.jd.ad.sdk.jad_fq.jad_an jad_an() {
        if (this.jad_er == null) {
            File file = this.jad_bo;
            long j10 = this.jad_cp;
            if (j10 > 0) {
                File file2 = new File(file, "journal.bkp");
                if (file2.exists()) {
                    File file3 = new File(file, "journal");
                    if (file3.exists()) {
                        file2.delete();
                    } else {
                        com.jd.ad.sdk.jad_fq.jad_an.jad_an(file2, file3, false);
                    }
                }
                com.jd.ad.sdk.jad_fq.jad_an jad_anVar = new com.jd.ad.sdk.jad_fq.jad_an(file, 1, 1, j10);
                if (jad_anVar.jad_bo.exists()) {
                    try {
                        jad_anVar.jad_er();
                        jad_anVar.jad_dq();
                    } catch (IOException e2) {
                        System.out.println("DiskLruCache " + ((Object) file) + " is corrupt: " + e2.getMessage() + ", removing");
                        jad_anVar.close();
                        com.jd.ad.sdk.jad_fq.jad_cp.jad_an(jad_anVar.jad_an);
                    }
                    this.jad_er = jad_anVar;
                }
                file.mkdirs();
                jad_anVar = new com.jd.ad.sdk.jad_fq.jad_an(file, 1, 1, j10);
                jad_anVar.jad_fs();
                this.jad_er = jad_anVar;
            } else {
                throw new IllegalArgumentException("maxSize <= 0");
            }
        }
        return this.jad_er;
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_an
    public File jad_an(com.jd.ad.sdk.jad_hs.jad_hu jad_huVar) {
        String jad_an = this.jad_an.jad_an(jad_huVar);
        if (Log.isLoggable(DiskLruCacheWrapper.TAG, 2)) {
            Logger.v(DiskLruCacheWrapper.TAG, "Get: Obtained: " + jad_an + " for for Key: " + ((Object) jad_huVar));
        }
        try {
            jad_an.jad_er jad_bo = jad_an().jad_bo(jad_an);
            if (jad_bo != null) {
                return jad_bo.jad_an(0);
            }
            return null;
        } catch (IOException e2) {
            if (!Log.isLoggable(DiskLruCacheWrapper.TAG, 5)) {
                return null;
            }
            Logger.w(DiskLruCacheWrapper.TAG, "Unable to get from disk cache", e2);
            return null;
        }
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_an
    public void jad_an(com.jd.ad.sdk.jad_hs.jad_hu jad_huVar, jad_an.jad_bo jad_boVar) {
        jad_cp.jad_an jad_anVar;
        com.jd.ad.sdk.jad_fq.jad_an jad_an;
        boolean z10;
        String jad_an2 = this.jad_an.jad_an(jad_huVar);
        jad_cp jad_cpVar = this.jad_dq;
        synchronized (jad_cpVar) {
            jad_anVar = jad_cpVar.jad_an.get(jad_an2);
            if (jad_anVar == null) {
                jad_cp.jad_bo jad_boVar2 = jad_cpVar.jad_bo;
                synchronized (jad_boVar2.jad_an) {
                    jad_anVar = jad_boVar2.jad_an.poll();
                }
                if (jad_anVar == null) {
                    jad_anVar = new jad_cp.jad_an();
                }
                jad_cpVar.jad_an.put(jad_an2, jad_anVar);
            }
            jad_anVar.jad_bo++;
        }
        jad_anVar.jad_an.lock();
        try {
            if (Log.isLoggable(DiskLruCacheWrapper.TAG, 2)) {
                Logger.v(DiskLruCacheWrapper.TAG, "Put: Obtained: " + jad_an2 + " for for Key: " + ((Object) jad_huVar));
            }
            try {
                jad_an = jad_an();
            } catch (IOException e2) {
                if (Log.isLoggable(DiskLruCacheWrapper.TAG, 5)) {
                    Logger.w(DiskLruCacheWrapper.TAG, "Unable to put to disk cache", e2);
                }
            }
            if (jad_an.jad_bo(jad_an2) != null) {
                return;
            }
            jad_an.jad_cp jad_an3 = jad_an.jad_an(jad_an2);
            if (jad_an3 == null) {
                throw new IllegalStateException("Had two simultaneous puts for: " + jad_an2);
            }
            try {
                com.jd.ad.sdk.jad_kv.jad_er jad_erVar = (com.jd.ad.sdk.jad_kv.jad_er) jad_boVar;
                if (jad_erVar.jad_an.jad_an(jad_erVar.jad_bo, jad_an3.jad_an(0), jad_erVar.jad_cp)) {
                    com.jd.ad.sdk.jad_fq.jad_an.jad_an(com.jd.ad.sdk.jad_fq.jad_an.this, jad_an3, true);
                    jad_an3.jad_cp = true;
                }
                if (!z10) {
                    try {
                        jad_an3.jad_an();
                    } catch (IOException unused) {
                    }
                }
            } finally {
                if (!jad_an3.jad_cp) {
                    try {
                        jad_an3.jad_an();
                    } catch (IOException unused2) {
                    }
                }
            }
        } finally {
            this.jad_dq.jad_an(jad_an2);
        }
    }
}
