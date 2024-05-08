package com.huawei.quickcard;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class g extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public boolean f33984a;

    /* renamed from: d, reason: collision with root package name */
    private int f33987d = 255;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f33985b = new Paint(1);

    /* renamed from: c, reason: collision with root package name */
    public final Path f33986c = new Path();

    public g(boolean z10) {
        this.f33984a = z10;
    }

    public abstract void a();

    public abstract void a(@NonNull Canvas canvas);

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (!this.f33984a) {
            a();
        }
        a(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return getAlpha() > 0 ? -3 : -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        if (this.f33987d != i10) {
            this.f33987d = i10;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f33985b.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
