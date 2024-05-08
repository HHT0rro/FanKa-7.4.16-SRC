package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.base.zaj;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public int f23564a;

    public final void a(Context context, Bitmap bitmap, boolean z10) {
        com.google.android.gms.common.internal.a.c(bitmap);
        c(new BitmapDrawable(context.getResources(), bitmap), z10, false, true);
    }

    public final void b(Context context, zaj zajVar, boolean z10) {
        int i10 = this.f23564a;
        c(i10 != 0 ? context.getResources().getDrawable(i10) : null, z10, false, false);
    }

    public abstract void c(@Nullable Drawable drawable, boolean z10, boolean z11, boolean z12);
}
