package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.renderscript.BaseObj;
import com.huawei.hms.ads.gl;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class w {
    private static final String Code = "BlurUtil";

    /* JADX WARN: Removed duplicated region for block: B:32:0x009e A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Bitmap Code(android.content.Context r6, android.graphics.Bitmap r7, float r8, float r9) {
        /*
            r0 = 0
            int r0 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r0 <= 0) goto Lb2
            r0 = 1103626240(0x41c80000, float:25.0)
            int r0 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r0 > 0) goto Lb2
            r0 = 1065353216(0x3f800000, float:1.0)
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 < 0) goto Lb2
            r0 = 0
            int r1 = r7.getWidth()     // Catch: java.lang.Throwable -> L70
            float r1 = (float) r1     // Catch: java.lang.Throwable -> L70
            float r1 = r1 / r9
            int r1 = java.lang.Math.round(r1)     // Catch: java.lang.Throwable -> L70
            int r2 = r7.getHeight()     // Catch: java.lang.Throwable -> L70
            float r2 = (float) r2     // Catch: java.lang.Throwable -> L70
            float r2 = r2 / r9
            int r9 = java.lang.Math.round(r2)     // Catch: java.lang.Throwable -> L70
            r2 = 0
            android.graphics.Bitmap r7 = android.graphics.Bitmap.createScaledBitmap(r7, r1, r9, r2)     // Catch: java.lang.Throwable -> L70
            android.renderscript.RenderScript r6 = android.renderscript.RenderScript.create(r6)     // Catch: java.lang.Throwable -> L6c
            android.renderscript.Element r9 = android.renderscript.Element.U8_4(r6)     // Catch: java.lang.Throwable -> L66
            android.renderscript.ScriptIntrinsicBlur r9 = android.renderscript.ScriptIntrinsicBlur.create(r6, r9)     // Catch: java.lang.Throwable -> L66
            android.renderscript.Allocation r1 = android.renderscript.Allocation.createFromBitmap(r6, r7)     // Catch: java.lang.Throwable -> L63
            android.renderscript.Type r2 = r1.getType()     // Catch: java.lang.Throwable -> L5e
            android.renderscript.Allocation r0 = android.renderscript.Allocation.createTyped(r6, r2)     // Catch: java.lang.Throwable -> L5e
            r9.setRadius(r8)     // Catch: java.lang.Throwable -> L5e
            r9.setInput(r1)     // Catch: java.lang.Throwable -> L5e
            r9.forEach(r0)     // Catch: java.lang.Throwable -> L5e
            r0.copyTo(r7)     // Catch: java.lang.Throwable -> L5e
            Code(r1)
            Code(r0)
            Code(r9)
            if (r6 == 0) goto L5d
            r6.destroy()
        L5d:
            return r7
        L5e:
            r8 = move-exception
            r5 = r0
            r0 = r6
            r6 = r5
            goto L75
        L63:
            r8 = move-exception
            r1 = r0
            goto L69
        L66:
            r8 = move-exception
            r9 = r0
            r1 = r9
        L69:
            r0 = r6
            r6 = r1
            goto L75
        L6c:
            r8 = move-exception
            r6 = r0
            r9 = r6
            goto L74
        L70:
            r8 = move-exception
            r6 = r0
            r7 = r6
            r9 = r7
        L74:
            r1 = r9
        L75:
            java.lang.String r2 = "BlurUtil"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La2
            r3.<init>()     // Catch: java.lang.Throwable -> La2
            java.lang.String r4 = "blur drawable exception"
            r3.append(r4)     // Catch: java.lang.Throwable -> La2
            java.lang.Class r8 = r8.getClass()     // Catch: java.lang.Throwable -> La2
            java.lang.String r8 = r8.getSimpleName()     // Catch: java.lang.Throwable -> La2
            r3.append(r8)     // Catch: java.lang.Throwable -> La2
            java.lang.String r8 = r3.toString()     // Catch: java.lang.Throwable -> La2
            com.huawei.hms.ads.gl.I(r2, r8)     // Catch: java.lang.Throwable -> La2
            Code(r1)
            Code(r6)
            Code(r9)
            if (r0 == 0) goto La1
            r0.destroy()
        La1:
            return r7
        La2:
            r7 = move-exception
            Code(r1)
            Code(r6)
            Code(r9)
            if (r0 == 0) goto Lb1
            r0.destroy()
        Lb1:
            throw r7
        Lb2:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r7 = "ensure blurRadius in (0, 25] and scaleRatio >= 1"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.utils.w.Code(android.content.Context, android.graphics.Bitmap, float, float):android.graphics.Bitmap");
    }

    private static Drawable Code(Context context, Bitmap bitmap) {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public static Drawable Code(Context context, Drawable drawable, float f10, float f11) {
        String str;
        Drawable drawable2 = null;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            drawable2 = Code(context, Code(context, y.Code(drawable), f10, f11));
            gl.Code(Code, "blurDrawable: duration %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            return drawable2;
        } catch (OutOfMemoryError unused) {
            str = "OOM blur image";
            gl.I(Code, str);
            return drawable2;
        } catch (Throwable th) {
            str = "blur drawable exception " + th.getClass().getSimpleName();
            gl.I(Code, str);
            return drawable2;
        }
    }

    private static void Code(BaseObj baseObj) {
        if (baseObj != null) {
            baseObj.destroy();
        }
    }
}
