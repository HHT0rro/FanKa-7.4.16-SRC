package com.jd.ad.sdk.jad_rc;

import android.graphics.Bitmap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class jad_kx {
    public static final com.jd.ad.sdk.jad_lw.jad_er jad_an = new jad_an();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class jad_an extends com.jd.ad.sdk.jad_lw.jad_fs {
        @Override // com.jd.ad.sdk.jad_lw.jad_fs, com.jd.ad.sdk.jad_lw.jad_er
        public void jad_an(Bitmap bitmap) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x00ad  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.jd.ad.sdk.jad_kv.jad_xk<android.graphics.Bitmap> jad_an(com.jd.ad.sdk.jad_lw.jad_er r8, android.graphics.drawable.Drawable r9, int r10, int r11) {
        /*
            android.graphics.drawable.Drawable r9 = r9.getCurrent()
            boolean r0 = r9 instanceof android.graphics.drawable.BitmapDrawable
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L13
            android.graphics.drawable.BitmapDrawable r9 = (android.graphics.drawable.BitmapDrawable) r9
            android.graphics.Bitmap r2 = r9.getBitmap()
            goto La9
        L13:
            boolean r0 = r9 instanceof android.graphics.drawable.Animatable
            if (r0 != 0) goto La9
            java.lang.String r0 = "Unable to draw "
            r4 = 5
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            java.lang.String r6 = "DrawableToBitmap"
            if (r10 != r5) goto L48
            int r7 = r9.getIntrinsicWidth()
            if (r7 > 0) goto L48
            boolean r10 = android.util.Log.isLoggable(r6, r4)
            if (r10 == 0) goto Laa
            java.lang.Object[] r10 = new java.lang.Object[r1]
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r0)
            r11.append(r9)
            java.lang.String r9 = " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width"
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            r10[r3] = r9
            com.jd.ad.sdk.logger.Logger.w(r6, r10)
            goto Laa
        L48:
            if (r11 != r5) goto L72
            int r5 = r9.getIntrinsicHeight()
            if (r5 > 0) goto L72
            boolean r10 = android.util.Log.isLoggable(r6, r4)
            if (r10 == 0) goto Laa
            java.lang.Object[] r10 = new java.lang.Object[r1]
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r0)
            r11.append(r9)
            java.lang.String r9 = " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height"
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            r10[r3] = r9
            com.jd.ad.sdk.logger.Logger.w(r6, r10)
            goto Laa
        L72:
            int r0 = r9.getIntrinsicWidth()
            if (r0 <= 0) goto L7c
            int r10 = r9.getIntrinsicWidth()
        L7c:
            int r0 = r9.getIntrinsicHeight()
            if (r0 <= 0) goto L86
            int r11 = r9.getIntrinsicHeight()
        L86:
            java.util.concurrent.locks.Lock r0 = com.jd.ad.sdk.jad_rc.jad_vi.jad_bo
            r0.lock()
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r4 = r8.jad_an(r10, r11, r4)
            android.graphics.Canvas r5 = new android.graphics.Canvas     // Catch: java.lang.Throwable -> La4
            r5.<init>(r4)     // Catch: java.lang.Throwable -> La4
            r9.setBounds(r3, r3, r10, r11)     // Catch: java.lang.Throwable -> La4
            r9.draw(r5)     // Catch: java.lang.Throwable -> La4
            r5.setBitmap(r2)     // Catch: java.lang.Throwable -> La4
            r0.unlock()
            r2 = r4
            goto Laa
        La4:
            r8 = move-exception
            r0.unlock()
            throw r8
        La9:
            r1 = 0
        Laa:
            if (r1 == 0) goto Lad
            goto Laf
        Lad:
            com.jd.ad.sdk.jad_lw.jad_er r8 = com.jd.ad.sdk.jad_rc.jad_kx.jad_an
        Laf:
            com.jd.ad.sdk.jad_rc.jad_er r8 = com.jd.ad.sdk.jad_rc.jad_er.jad_an(r2, r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_rc.jad_kx.jad_an(com.jd.ad.sdk.jad_lw.jad_er, android.graphics.drawable.Drawable, int, int):com.jd.ad.sdk.jad_kv.jad_xk");
    }
}
