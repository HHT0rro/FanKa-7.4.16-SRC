package com.jd.ad.sdk.jad_gp;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import sun.util.locale.LanguageTag;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class jad_ly {
    public static final char[] jad_an = "0123456789abcdef".toCharArray();
    public static final char[] jad_bo = new char[64];

    @Nullable
    public static volatile Handler jad_cp;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static /* synthetic */ class jad_an {
        public static final /* synthetic */ int[] jad_an;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            jad_an = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                jad_an[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                jad_an[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                jad_an[Bitmap.Config.RGBA_F16.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                jad_an[Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static int jad_an(int i10, int i11) {
        return (i11 * 31) + i10;
    }

    public static int jad_an(@Nullable Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i10 = jad_an.jad_an[config.ordinal()];
        if (i10 == 1) {
            return 1;
        }
        if (i10 == 2 || i10 == 3) {
            return 2;
        }
        return i10 != 4 ? 4 : 8;
    }

    public static int jad_an(@NonNull Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
        }
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + ((Object) bitmap) + "[" + bitmap.getWidth() + LanguageTag.PRIVATEUSE + bitmap.getHeight() + "] " + ((Object) bitmap.getConfig()));
    }

    public static int jad_an(@Nullable Object obj, int i10) {
        return jad_an(obj == null ? 0 : obj.hashCode(), i10);
    }

    @NonNull
    public static <T> List<T> jad_an(@NonNull Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t2 : collection) {
            if (t2 != null) {
                arrayList.add(t2);
            }
        }
        return arrayList;
    }

    @NonNull
    public static <T> Queue<T> jad_an(int i10) {
        return new ArrayDeque(i10);
    }

    public static void jad_an() {
        if (!jad_dq()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static void jad_an(Runnable runnable) {
        jad_bo().post(runnable);
    }

    public static boolean jad_an(@Nullable Object obj, @Nullable Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static Handler jad_bo() {
        if (jad_cp == null) {
            synchronized (jad_ly.class) {
                if (jad_cp == null) {
                    jad_cp = new Handler(Looper.getMainLooper());
                }
            }
        }
        return jad_cp;
    }

    public static boolean jad_bo(int i10, int i11) {
        if (i10 > 0 || i10 == Integer.MIN_VALUE) {
            return i11 > 0 || i11 == Integer.MIN_VALUE;
        }
        return false;
    }

    public static boolean jad_cp() {
        return !jad_dq();
    }

    public static boolean jad_dq() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
