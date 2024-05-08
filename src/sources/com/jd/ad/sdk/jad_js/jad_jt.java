package com.jd.ad.sdk.jad_js;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_jt {
    public Map<String, List<com.jd.ad.sdk.jad_ra.jad_er>> jad_cp;
    public Map<String, jad_na> jad_dq;
    public Map<String, com.jd.ad.sdk.jad_ox.jad_cp> jad_er;
    public List<com.jd.ad.sdk.jad_ox.jad_hu> jad_fs;
    public LongSparseArray<com.jd.ad.sdk.jad_ra.jad_er> jad_hu;
    public List<com.jd.ad.sdk.jad_ra.jad_er> jad_iv;
    public SparseArrayCompat<com.jd.ad.sdk.jad_ox.jad_dq> jad_jt;
    public Rect jad_jw;
    public float jad_kx;
    public float jad_ly;
    public float jad_mz;
    public boolean jad_na;
    public final jad_vi jad_an = new jad_vi();
    public final HashSet<String> jad_bo = new HashSet<>();
    public int jad_ob = 0;

    public float jad_an() {
        return (jad_bo() / this.jad_mz) * 1000.0f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public com.jd.ad.sdk.jad_ra.jad_er jad_an(long j10) {
        return this.jad_hu.get(j10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void jad_an(String str) {
        com.jd.ad.sdk.jad_ve.jad_dq.jad_an(str);
        this.jad_bo.add(str);
    }

    public float jad_bo() {
        return this.jad_ly - this.jad_kx;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0035, code lost:
    
        if (r4.substring(0, r4.length() - 1).equalsIgnoreCase(r8) != false) goto L13;
     */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.jd.ad.sdk.jad_ox.jad_hu jad_bo(java.lang.String r8) {
        /*
            r7 = this;
            java.util.List<com.jd.ad.sdk.jad_ox.jad_hu> r0 = r7.jad_fs
            int r0 = r0.size()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L3f
            java.util.List<com.jd.ad.sdk.jad_ox.jad_hu> r3 = r7.jad_fs
            java.lang.Object r3 = r3.get(r2)
            com.jd.ad.sdk.jad_ox.jad_hu r3 = (com.jd.ad.sdk.jad_ox.jad_hu) r3
            java.lang.String r4 = r3.jad_an
            boolean r4 = r4.equalsIgnoreCase(r8)
            r5 = 1
            if (r4 == 0) goto L1c
            goto L39
        L1c:
            java.lang.String r4 = r3.jad_an
            java.lang.String r6 = "\r"
            boolean r4 = r4.endsWith(r6)
            if (r4 == 0) goto L38
            java.lang.String r4 = r3.jad_an
            int r6 = r4.length()
            int r6 = r6 - r5
            java.lang.String r4 = r4.substring(r1, r6)
            boolean r4 = r4.equalsIgnoreCase(r8)
            if (r4 == 0) goto L38
            goto L39
        L38:
            r5 = 0
        L39:
            if (r5 == 0) goto L3c
            return r3
        L3c:
            int r2 = r2 + 1
            goto L8
        L3f:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_js.jad_jt.jad_bo(java.lang.String):com.jd.ad.sdk.jad_ox.jad_hu");
    }

    public List<com.jd.ad.sdk.jad_ra.jad_er> jad_cp() {
        return this.jad_iv;
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder("LottieComposition:\n");
        Iterator<com.jd.ad.sdk.jad_ra.jad_er> iterator2 = this.jad_iv.iterator2();
        while (iterator2.hasNext()) {
            sb2.append(iterator2.next().jad_an("\t"));
        }
        return sb2.toString();
    }
}
