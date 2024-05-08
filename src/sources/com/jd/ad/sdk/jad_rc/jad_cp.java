package com.jd.ad.sdk.jad_rc;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_cp implements com.jd.ad.sdk.jad_hs.jad_mz<Bitmap> {
    public static final com.jd.ad.sdk.jad_hs.jad_iv<Integer> jad_bo = com.jd.ad.sdk.jad_hs.jad_iv.jad_an("com.jd.ad.sdk.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
    public static final com.jd.ad.sdk.jad_hs.jad_iv<Bitmap.CompressFormat> jad_cp = new com.jd.ad.sdk.jad_hs.jad_iv<>("com.jd.ad.sdk.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat", null, com.jd.ad.sdk.jad_hs.jad_iv.jad_er);

    @Nullable
    public final com.jd.ad.sdk.jad_lw.jad_bo jad_an;

    public jad_cp(@NonNull com.jd.ad.sdk.jad_lw.jad_bo jad_boVar) {
        this.jad_an = jad_boVar;
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_mz
    @NonNull
    public com.jd.ad.sdk.jad_hs.jad_cp jad_an(@NonNull com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar) {
        return com.jd.ad.sdk.jad_hs.jad_cp.TRANSFORMED;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007e A[Catch: all -> 0x00d0, TRY_LEAVE, TryCatch #0 {, blocks: (B:9:0x0024, B:20:0x0053, B:22:0x0078, B:24:0x007e, B:49:0x00cc, B:47:0x00cf, B:42:0x0074), top: B:8:0x0024 }] */
    @Override // com.jd.ad.sdk.jad_hs.jad_dq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_kv.jad_xk<android.graphics.Bitmap> r12, @androidx.annotation.NonNull java.io.File r13, @androidx.annotation.NonNull com.jd.ad.sdk.jad_hs.jad_jw r14) {
        /*
            r11 = this;
            java.lang.String r0 = "BitmapEncoder"
            java.lang.Object r12 = r12.get()
            android.graphics.Bitmap r12 = (android.graphics.Bitmap) r12
            com.jd.ad.sdk.jad_hs.jad_iv<android.graphics.Bitmap$CompressFormat> r1 = com.jd.ad.sdk.jad_rc.jad_cp.jad_cp
            java.lang.Object r1 = r14.jad_an(r1)
            android.graphics.Bitmap$CompressFormat r1 = (android.graphics.Bitmap.CompressFormat) r1
            if (r1 == 0) goto L13
            goto L1e
        L13:
            boolean r1 = r12.hasAlpha()
            if (r1 == 0) goto L1c
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.PNG
            goto L1e
        L1c:
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG
        L1e:
            r12.getWidth()
            r12.getHeight()
            long r2 = com.jd.ad.sdk.jad_gp.jad_jt.jad_an()     // Catch: java.lang.Throwable -> Ld0
            com.jd.ad.sdk.jad_hs.jad_iv<java.lang.Integer> r4 = com.jd.ad.sdk.jad_rc.jad_cp.jad_bo     // Catch: java.lang.Throwable -> Ld0
            java.lang.Object r4 = r14.jad_an(r4)     // Catch: java.lang.Throwable -> Ld0
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch: java.lang.Throwable -> Ld0
            int r4 = r4.intValue()     // Catch: java.lang.Throwable -> Ld0
            r5 = 0
            r6 = 2
            r7 = 1
            r8 = 0
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L5f
            r9.<init>(r13)     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L5f
            com.jd.ad.sdk.jad_lw.jad_bo r13 = r11.jad_an     // Catch: java.lang.Throwable -> L58 java.io.IOException -> L5a
            if (r13 == 0) goto L4c
            com.jd.ad.sdk.jad_it.jad_cp r13 = new com.jd.ad.sdk.jad_it.jad_cp     // Catch: java.lang.Throwable -> L58 java.io.IOException -> L5a
            com.jd.ad.sdk.jad_lw.jad_bo r5 = r11.jad_an     // Catch: java.lang.Throwable -> L58 java.io.IOException -> L5a
            r10 = 65536(0x10000, float:9.18355E-41)
            r13.<init>(r9, r5, r10)     // Catch: java.lang.Throwable -> L58 java.io.IOException -> L5a
            r5 = r13
            goto L4d
        L4c:
            r5 = r9
        L4d:
            r12.compress(r1, r4, r5)     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L5f
            r5.close()     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L5f
            r5.close()     // Catch: java.io.IOException -> L56 java.lang.Throwable -> Ld0
        L56:
            r13 = 1
            goto L78
        L58:
            r12 = move-exception
            goto Lca
        L5a:
            r13 = move-exception
            r5 = r9
            goto L60
        L5d:
            r12 = move-exception
            goto Lc9
        L5f:
            r13 = move-exception
        L60:
            r4 = 3
            boolean r4 = android.util.Log.isLoggable(r0, r4)     // Catch: java.lang.Throwable -> L5d
            if (r4 == 0) goto L72
            java.lang.Object[] r4 = new java.lang.Object[r6]     // Catch: java.lang.Throwable -> L5d
            java.lang.String r9 = "Failed to encode Bitmap"
            r4[r8] = r9     // Catch: java.lang.Throwable -> L5d
            r4[r7] = r13     // Catch: java.lang.Throwable -> L5d
            com.jd.ad.sdk.logger.Logger.d(r0, r4)     // Catch: java.lang.Throwable -> L5d
        L72:
            if (r5 == 0) goto L77
            r5.close()     // Catch: java.io.IOException -> L77 java.lang.Throwable -> Ld0
        L77:
            r13 = 0
        L78:
            boolean r4 = android.util.Log.isLoggable(r0, r6)     // Catch: java.lang.Throwable -> Ld0
            if (r4 == 0) goto Lc8
            java.lang.Object[] r4 = new java.lang.Object[r7]     // Catch: java.lang.Throwable -> Ld0
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld0
            r5.<init>()     // Catch: java.lang.Throwable -> Ld0
            java.lang.String r6 = "Compressed with type: "
            r5.append(r6)     // Catch: java.lang.Throwable -> Ld0
            r5.append(r1)     // Catch: java.lang.Throwable -> Ld0
            java.lang.String r1 = " of size "
            r5.append(r1)     // Catch: java.lang.Throwable -> Ld0
            int r1 = com.jd.ad.sdk.jad_gp.jad_ly.jad_an(r12)     // Catch: java.lang.Throwable -> Ld0
            r5.append(r1)     // Catch: java.lang.Throwable -> Ld0
            java.lang.String r1 = " in "
            r5.append(r1)     // Catch: java.lang.Throwable -> Ld0
            double r1 = com.jd.ad.sdk.jad_gp.jad_jt.jad_an(r2)     // Catch: java.lang.Throwable -> Ld0
            r5.append(r1)     // Catch: java.lang.Throwable -> Ld0
            java.lang.String r1 = ", options format: "
            r5.append(r1)     // Catch: java.lang.Throwable -> Ld0
            com.jd.ad.sdk.jad_hs.jad_iv<android.graphics.Bitmap$CompressFormat> r1 = com.jd.ad.sdk.jad_rc.jad_cp.jad_cp     // Catch: java.lang.Throwable -> Ld0
            java.lang.Object r14 = r14.jad_an(r1)     // Catch: java.lang.Throwable -> Ld0
            r5.append(r14)     // Catch: java.lang.Throwable -> Ld0
            java.lang.String r14 = ", hasAlpha: "
            r5.append(r14)     // Catch: java.lang.Throwable -> Ld0
            boolean r12 = r12.hasAlpha()     // Catch: java.lang.Throwable -> Ld0
            r5.append(r12)     // Catch: java.lang.Throwable -> Ld0
            java.lang.String r12 = r5.toString()     // Catch: java.lang.Throwable -> Ld0
            r4[r8] = r12     // Catch: java.lang.Throwable -> Ld0
            com.jd.ad.sdk.logger.Logger.v(r0, r4)     // Catch: java.lang.Throwable -> Ld0
        Lc8:
            return r13
        Lc9:
            r9 = r5
        Lca:
            if (r9 == 0) goto Lcf
            r9.close()     // Catch: java.io.IOException -> Lcf java.lang.Throwable -> Ld0
        Lcf:
            throw r12     // Catch: java.lang.Throwable -> Ld0
        Ld0:
            r12 = move-exception
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_rc.jad_cp.jad_an(com.jd.ad.sdk.jad_kv.jad_xk, java.io.File, com.jd.ad.sdk.jad_hs.jad_jw):boolean");
    }
}
