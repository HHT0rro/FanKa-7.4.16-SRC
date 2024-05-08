package com.cupidapp.live.base.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import org.jetbrains.annotations.NotNull;

/* compiled from: ImageUtils.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b0 f12284a = new b0();

    /* renamed from: b, reason: collision with root package name */
    public static final String f12285b = b0.class.getSimpleName();

    public final int a(BitmapFactory.Options options, int i10, int i11) {
        int i12 = options.outWidth;
        int i13 = options.outHeight;
        if (i12 <= i10 && i13 <= i11) {
            return 0;
        }
        int round = Math.round(i13 / i11);
        int round2 = Math.round(i12 / i10);
        return round > round2 ? round2 : round;
    }

    @NotNull
    public final Bitmap b(@NotNull byte[] buffer, int i10, int i11) {
        kotlin.jvm.internal.s.i(buffer, "buffer");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(buffer, 0, buffer.length, options);
        options.inSampleSize = a(options, i10, i11);
        options.inJustDecodeBounds = false;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(buffer, 0, buffer.length, options);
        kotlin.jvm.internal.s.h(decodeByteArray, "decodeByteArray(buffer, 0, buffer.size, options)");
        return decodeByteArray;
    }
}
