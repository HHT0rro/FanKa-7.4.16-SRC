package com.huawei.openalliance.ad.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.LruCache;
import com.huawei.hms.ads.fi;
import com.huawei.hms.ads.gl;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class x {
    private static final byte[] B = new byte[0];
    private static final int I = 31457280;
    private static final String V = "x";
    private static x Z;
    public LruCache<String, WeakReference<Drawable>> Code;

    private x() {
        V();
    }

    public static x Code() {
        x xVar;
        synchronized (B) {
            if (Z == null) {
                Z = new x();
            }
            xVar = Z;
        }
        return xVar;
    }

    private void V() {
        int maxMemory = (int) Runtime.getRuntime().maxMemory();
        this.Code = new LruCache<String, WeakReference<Drawable>>(Math.min(I, maxMemory > 0 ? maxMemory / 4 : I)) { // from class: com.huawei.openalliance.ad.utils.x.1
            @Override // android.util.LruCache
            /* renamed from: Code, reason: merged with bridge method [inline-methods] */
            public int sizeOf(String str, WeakReference<Drawable> weakReference) {
                Drawable drawable;
                if (weakReference == null || (drawable = weakReference.get()) == null) {
                    return 1;
                }
                if (!(drawable instanceof BitmapDrawable)) {
                    if (drawable instanceof fi) {
                        return ((fi) drawable).I();
                    }
                    return 1;
                }
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                if (bitmap != null) {
                    return bitmap.getByteCount();
                }
                return 1;
            }
        };
    }

    public Drawable Code(String str) {
        try {
            WeakReference<Drawable> weakReference = this.Code.get(str);
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        } catch (Throwable th) {
            gl.I(V, "get cache encounter: " + th.getClass().getSimpleName());
            return null;
        }
    }

    public void Code(String str, Drawable drawable) {
        try {
            this.Code.put(str, new WeakReference<>(drawable));
        } catch (Throwable th) {
            gl.I(V, "put cache encounter: " + th.getClass().getSimpleName());
        }
    }
}
