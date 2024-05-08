package com.jd.ad.sdk.jad_kv;

import androidx.annotation.NonNull;
import com.jd.ad.sdk.jad_it.jad_dq;
import com.jd.ad.sdk.jad_kv.jad_fs;
import com.jd.ad.sdk.jad_oz.jad_na;
import java.io.File;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_cp implements jad_fs, jad_dq.jad_an<Object> {
    public final List<com.jd.ad.sdk.jad_hs.jad_hu> jad_an;
    public final jad_jt<?> jad_bo;
    public final jad_fs.jad_an jad_cp;
    public int jad_dq = -1;
    public com.jd.ad.sdk.jad_hs.jad_hu jad_er;
    public List<com.jd.ad.sdk.jad_oz.jad_na<File, ?>> jad_fs;
    public volatile jad_na.jad_an<?> jad_hu;
    public File jad_iv;
    public int jad_jt;

    public jad_cp(List<com.jd.ad.sdk.jad_hs.jad_hu> list, jad_jt<?> jad_jtVar, jad_fs.jad_an jad_anVar) {
        this.jad_an = list;
        this.jad_bo = jad_jtVar;
        this.jad_cp = jad_anVar;
    }

    @Override // com.jd.ad.sdk.jad_it.jad_dq.jad_an
    public void jad_an(@NonNull Exception exc) {
        this.jad_cp.jad_an(this.jad_er, exc, this.jad_hu.jad_cp, com.jd.ad.sdk.jad_hs.jad_an.DATA_DISK_CACHE);
    }

    @Override // com.jd.ad.sdk.jad_it.jad_dq.jad_an
    public void jad_an(Object obj) {
        this.jad_cp.jad_an(this.jad_er, obj, this.jad_hu.jad_cp, com.jd.ad.sdk.jad_hs.jad_an.DATA_DISK_CACHE, this.jad_er);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0014, code lost:
    
        r8.jad_hu = null;
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0018, code lost:
    
        if (r0 != false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0022, code lost:
    
        if (r8.jad_jt >= r8.jad_fs.size()) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0024, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
    
        if (r3 == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0029, code lost:
    
        r3 = r8.jad_fs;
        r4 = r8.jad_jt;
        r8.jad_jt = r4 + 1;
        r3 = r3.get(r4);
        r4 = r8.jad_iv;
        r5 = r8.jad_bo;
        r8.jad_hu = r3.jad_an(r4, r5.jad_er, r5.jad_fs, r5.jad_iv);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
    
        if (r8.jad_hu == null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0059, code lost:
    
        if (r8.jad_bo.jad_cp(r8.jad_hu.jad_cp.jad_an()) == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005b, code lost:
    
        r8.jad_hu.jad_cp.jad_an(r8.jad_bo.jad_ob, r8);
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0068, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0026, code lost:
    
        r3 = false;
     */
    @Override // com.jd.ad.sdk.jad_kv.jad_fs
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean jad_an() {
        /*
            r8 = this;
        L0:
            java.util.List<com.jd.ad.sdk.jad_oz.jad_na<java.io.File, ?>> r0 = r8.jad_fs     // Catch: java.lang.Throwable -> La8
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L69
            int r3 = r8.jad_jt     // Catch: java.lang.Throwable -> La8
            int r0 = r0.size()     // Catch: java.lang.Throwable -> La8
            if (r3 >= r0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            if (r0 != 0) goto L14
            goto L69
        L14:
            r0 = 0
            r8.jad_hu = r0     // Catch: java.lang.Throwable -> La8
            r0 = 0
        L18:
            if (r0 != 0) goto L68
            int r3 = r8.jad_jt     // Catch: java.lang.Throwable -> La8
            java.util.List<com.jd.ad.sdk.jad_oz.jad_na<java.io.File, ?>> r4 = r8.jad_fs     // Catch: java.lang.Throwable -> La8
            int r4 = r4.size()     // Catch: java.lang.Throwable -> La8
            if (r3 >= r4) goto L26
            r3 = 1
            goto L27
        L26:
            r3 = 0
        L27:
            if (r3 == 0) goto L68
            java.util.List<com.jd.ad.sdk.jad_oz.jad_na<java.io.File, ?>> r3 = r8.jad_fs     // Catch: java.lang.Throwable -> La8
            int r4 = r8.jad_jt     // Catch: java.lang.Throwable -> La8
            int r5 = r4 + 1
            r8.jad_jt = r5     // Catch: java.lang.Throwable -> La8
            java.lang.Object r3 = r3.get(r4)     // Catch: java.lang.Throwable -> La8
            com.jd.ad.sdk.jad_oz.jad_na r3 = (com.jd.ad.sdk.jad_oz.jad_na) r3     // Catch: java.lang.Throwable -> La8
            java.io.File r4 = r8.jad_iv     // Catch: java.lang.Throwable -> La8
            com.jd.ad.sdk.jad_kv.jad_jt<?> r5 = r8.jad_bo     // Catch: java.lang.Throwable -> La8
            int r6 = r5.jad_er     // Catch: java.lang.Throwable -> La8
            int r7 = r5.jad_fs     // Catch: java.lang.Throwable -> La8
            com.jd.ad.sdk.jad_hs.jad_jw r5 = r5.jad_iv     // Catch: java.lang.Throwable -> La8
            com.jd.ad.sdk.jad_oz.jad_na$jad_an r3 = r3.jad_an(r4, r6, r7, r5)     // Catch: java.lang.Throwable -> La8
            r8.jad_hu = r3     // Catch: java.lang.Throwable -> La8
            com.jd.ad.sdk.jad_oz.jad_na$jad_an<?> r3 = r8.jad_hu     // Catch: java.lang.Throwable -> La8
            if (r3 == 0) goto L18
            com.jd.ad.sdk.jad_kv.jad_jt<?> r3 = r8.jad_bo     // Catch: java.lang.Throwable -> La8
            com.jd.ad.sdk.jad_oz.jad_na$jad_an<?> r4 = r8.jad_hu     // Catch: java.lang.Throwable -> La8
            com.jd.ad.sdk.jad_it.jad_dq<Data> r4 = r4.jad_cp     // Catch: java.lang.Throwable -> La8
            java.lang.Class r4 = r4.jad_an()     // Catch: java.lang.Throwable -> La8
            boolean r3 = r3.jad_cp(r4)     // Catch: java.lang.Throwable -> La8
            if (r3 == 0) goto L18
            com.jd.ad.sdk.jad_oz.jad_na$jad_an<?> r0 = r8.jad_hu     // Catch: java.lang.Throwable -> La8
            com.jd.ad.sdk.jad_it.jad_dq<Data> r0 = r0.jad_cp     // Catch: java.lang.Throwable -> La8
            com.jd.ad.sdk.jad_kv.jad_jt<?> r3 = r8.jad_bo     // Catch: java.lang.Throwable -> La8
            com.jd.ad.sdk.jad_ep.jad_jt r3 = r3.jad_ob     // Catch: java.lang.Throwable -> La8
            r0.jad_an(r3, r8)     // Catch: java.lang.Throwable -> La8
            r0 = 1
            goto L18
        L68:
            return r0
        L69:
            int r0 = r8.jad_dq     // Catch: java.lang.Throwable -> La8
            int r0 = r0 + r2
            r8.jad_dq = r0     // Catch: java.lang.Throwable -> La8
            java.util.List<com.jd.ad.sdk.jad_hs.jad_hu> r2 = r8.jad_an     // Catch: java.lang.Throwable -> La8
            int r2 = r2.size()     // Catch: java.lang.Throwable -> La8
            if (r0 < r2) goto L77
            return r1
        L77:
            java.util.List<com.jd.ad.sdk.jad_hs.jad_hu> r0 = r8.jad_an     // Catch: java.lang.Throwable -> La8
            int r2 = r8.jad_dq     // Catch: java.lang.Throwable -> La8
            java.lang.Object r0 = r0.get(r2)     // Catch: java.lang.Throwable -> La8
            com.jd.ad.sdk.jad_hs.jad_hu r0 = (com.jd.ad.sdk.jad_hs.jad_hu) r0     // Catch: java.lang.Throwable -> La8
            com.jd.ad.sdk.jad_kv.jad_dq r2 = new com.jd.ad.sdk.jad_kv.jad_dq     // Catch: java.lang.Throwable -> La8
            com.jd.ad.sdk.jad_kv.jad_jt<?> r3 = r8.jad_bo     // Catch: java.lang.Throwable -> La8
            com.jd.ad.sdk.jad_hs.jad_hu r4 = r3.jad_na     // Catch: java.lang.Throwable -> La8
            r2.<init>(r0, r4)     // Catch: java.lang.Throwable -> La8
            com.jd.ad.sdk.jad_mx.jad_an r3 = r3.jad_bo()     // Catch: java.lang.Throwable -> La8
            java.io.File r2 = r3.jad_an(r2)     // Catch: java.lang.Throwable -> La8
            r8.jad_iv = r2     // Catch: java.lang.Throwable -> La8
            if (r2 == 0) goto L0
            r8.jad_er = r0     // Catch: java.lang.Throwable -> La8
            com.jd.ad.sdk.jad_kv.jad_jt<?> r0 = r8.jad_bo     // Catch: java.lang.Throwable -> La8
            com.jd.ad.sdk.jad_ep.jad_er r0 = r0.jad_cp     // Catch: java.lang.Throwable -> La8
            com.jd.ad.sdk.jad_ep.jad_hu r0 = r0.jad_bo     // Catch: java.lang.Throwable -> La8
            java.util.List r0 = r0.jad_an(r2)     // Catch: java.lang.Throwable -> La8
            r8.jad_fs = r0     // Catch: java.lang.Throwable -> La8
            r8.jad_jt = r1     // Catch: java.lang.Throwable -> La8
            goto L0
        La8:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_kv.jad_cp.jad_an():boolean");
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_fs
    public void jad_cp() {
        jad_na.jad_an<?> jad_anVar = this.jad_hu;
        if (jad_anVar != null) {
            jad_anVar.jad_cp.jad_cp();
        }
    }
}
