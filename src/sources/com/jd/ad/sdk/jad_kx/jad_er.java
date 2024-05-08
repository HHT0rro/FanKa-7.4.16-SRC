package com.jd.ad.sdk.jad_kx;

import com.kwad.sdk.core.response.model.SdkConfigData;

/* compiled from: PreloadAdDataCacheHelper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_er {
    public com.jd.ad.sdk.jad_kx.jad_an jad_an;
    public jad_fs jad_bo;
    public com.jd.ad.sdk.jad_na.jad_an jad_er;
    public int jad_cp = SdkConfigData.DEFAULT_REQUEST_INTERVAL;
    public int jad_dq = 2;
    public int jad_fs = 3;
    public boolean jad_jt = true;

    /* compiled from: PreloadAdDataCacheHelper.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class jad_an {
        public static final jad_er jad_an = new jad_er();
    }

    public int jad_bo() {
        if (this.jad_er == null) {
            this.jad_er = com.jd.ad.sdk.jad_pc.jad_an.jad_an();
        }
        com.jd.ad.sdk.jad_na.jad_an jad_anVar = this.jad_er;
        if (jad_anVar != null) {
            this.jad_cp = jad_anVar.jad_jw;
        }
        return this.jad_cp;
    }

    public int jad_cp() {
        if (this.jad_er == null) {
            this.jad_er = com.jd.ad.sdk.jad_pc.jad_an.jad_an();
        }
        com.jd.ad.sdk.jad_na.jad_an jad_anVar = this.jad_er;
        if (jad_anVar != null) {
            this.jad_fs = jad_anVar.jad_ly;
        }
        if (this.jad_fs < 3) {
            this.jad_fs = 3;
        }
        return this.jad_fs;
    }

    public int jad_an() {
        if (this.jad_er == null) {
            this.jad_er = com.jd.ad.sdk.jad_pc.jad_an.jad_an();
        }
        com.jd.ad.sdk.jad_na.jad_an jad_anVar = this.jad_er;
        if (jad_anVar != null) {
            this.jad_dq = jad_anVar.jad_kx;
        }
        return this.jad_dq;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004a A[Catch: all -> 0x005c, DONT_GENERATE, TryCatch #0 {, blocks: (B:7:0x0009, B:9:0x000d, B:11:0x0011, B:12:0x0015, B:14:0x001f, B:15:0x0025, B:17:0x0030, B:19:0x0044, B:21:0x004a, B:24:0x004e, B:27:0x005a, B:30:0x0036, B:32:0x003a, B:34:0x003f), top: B:6:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean jad_bo(java.lang.String r5) {
        /*
            r4 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            r1 = 1
            if (r0 == 0) goto L8
            return r1
        L8:
            monitor-enter(r4)
            boolean r0 = r4.jad_jt     // Catch: java.lang.Throwable -> L5c
            if (r0 == 0) goto L3f
            com.jd.ad.sdk.jad_kx.jad_fs r0 = r4.jad_bo     // Catch: java.lang.Throwable -> L5c
            if (r0 != 0) goto L15
            com.jd.ad.sdk.jad_kx.jad_fs r0 = com.jd.ad.sdk.jad_kx.jad_fs.jad_an.jad_an     // Catch: java.lang.Throwable -> L5c
            r4.jad_bo = r0     // Catch: java.lang.Throwable -> L5c
        L15:
            com.jd.ad.sdk.jad_kx.jad_fs r0 = r4.jad_bo     // Catch: java.lang.Throwable -> L5c
            java.util.ArrayList r0 = r0.jad_an(r5)     // Catch: java.lang.Throwable -> L5c
            com.jd.ad.sdk.jad_kx.jad_an r2 = r4.jad_an     // Catch: java.lang.Throwable -> L5c
            if (r2 != 0) goto L25
            com.jd.ad.sdk.jad_kx.jad_an r2 = com.jd.ad.sdk.jad_kx.jad_an.jad_dq()     // Catch: java.lang.Throwable -> L5c
            r4.jad_an = r2     // Catch: java.lang.Throwable -> L5c
        L25:
            com.jd.ad.sdk.jad_kx.jad_an r2 = r4.jad_an     // Catch: java.lang.Throwable -> L5c
            com.jd.ad.sdk.jad_kx.jad_fs r3 = r4.jad_bo     // Catch: java.lang.Throwable -> L5c
            java.util.List<java.lang.String> r3 = r3.jad_bo     // Catch: java.lang.Throwable -> L5c
            r2.jad_an(r3)     // Catch: java.lang.Throwable -> L5c
            if (r0 == 0) goto L36
            int r2 = r0.size()     // Catch: java.lang.Throwable -> L5c
            if (r2 > 0) goto L44
        L36:
            com.jd.ad.sdk.jad_kx.jad_an r2 = r4.jad_an     // Catch: java.lang.Throwable -> L5c
            if (r2 == 0) goto L44
            java.util.List r5 = r2.jad_an(r5)     // Catch: java.lang.Throwable -> L5c
            goto L43
        L3f:
            java.util.List r5 = com.jd.ad.sdk.jad_re.jad_an.jad_an(r5)     // Catch: java.lang.Throwable -> L5c
        L43:
            r0 = r5
        L44:
            int r5 = r4.jad_an()     // Catch: java.lang.Throwable -> L5c
            if (r5 > 0) goto L4c
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L5c
            return r1
        L4c:
            if (r0 == 0) goto L59
            int r5 = r0.size()     // Catch: java.lang.Throwable -> L5c
            int r0 = r4.jad_an()     // Catch: java.lang.Throwable -> L5c
            if (r5 < r0) goto L59
            goto L5a
        L59:
            r1 = 0
        L5a:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L5c
            return r1
        L5c:
            r5 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L5c
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_kx.jad_er.jad_bo(java.lang.String):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:114:0x027e, code lost:
    
        if (r3.isClosed() == false) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x02a4, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x02a3, code lost:
    
        r10 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0250, code lost:
    
        r4 = new com.jd.ad.sdk.jad_kx.jad_cp(r12, r13, r0, r15, r16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0257, code lost:
    
        ((java.util.ArrayList) com.jd.ad.sdk.jad_re.jad_an.jad_bo).add(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x025e, code lost:
    
        r10 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0260, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0135, code lost:
    
        r14 = new com.jd.ad.sdk.jad_kx.jad_cp(r3, r21, r13, r6, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x013e, code lost:
    
        r11.jad_bo.add(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0143, code lost:
    
        r10 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0145, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0146, code lost:
    
        r10 = r14;
        r12 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0162, code lost:
    
        if (r0 == false) goto L75;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x02af A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0184 A[DONT_GENERATE] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r12v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r12v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String jad_an(java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 706
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_kx.jad_er.jad_an(java.lang.String):java.lang.String");
    }
}
