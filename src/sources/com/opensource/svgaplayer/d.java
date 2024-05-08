package com.opensource.svgaplayer;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.media.SoundPool;
import android.widget.ImageView;
import java.util.Iterator;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SVGADrawable.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public boolean f37967a;

    /* renamed from: b, reason: collision with root package name */
    public int f37968b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public ImageView.ScaleType f37969c;

    /* renamed from: d, reason: collision with root package name */
    public final rb.b f37970d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final SVGAVideoEntity f37971e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final e f37972f;

    public d(@NotNull SVGAVideoEntity videoItem, @NotNull e dynamicItem) {
        s.j(videoItem, "videoItem");
        s.j(dynamicItem, "dynamicItem");
        this.f37971e = videoItem;
        this.f37972f = dynamicItem;
        this.f37967a = true;
        this.f37969c = ImageView.ScaleType.MATRIX;
        this.f37970d = new rb.b(videoItem, dynamicItem);
    }

    public final void a() {
        for (sb.a aVar : this.f37971e.l()) {
            Integer b4 = aVar.b();
            if (b4 != null) {
                int intValue = b4.intValue();
                h hVar = h.f38009e;
                if (hVar.b()) {
                    hVar.e(intValue);
                } else {
                    SoundPool p10 = this.f37971e.p();
                    if (p10 != null) {
                        p10.stop(intValue);
                    }
                }
            }
            aVar.e(null);
        }
        this.f37971e.b();
    }

    public final int b() {
        return this.f37968b;
    }

    @NotNull
    public final e c() {
        return this.f37972f;
    }

    @NotNull
    public final SVGAVideoEntity d() {
        return this.f37971e;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@Nullable Canvas canvas) {
        if (this.f37967a || canvas == null) {
            return;
        }
        this.f37970d.a(canvas, this.f37968b, this.f37969c);
    }

    public final void e(boolean z10) {
        if (this.f37967a == z10) {
            return;
        }
        this.f37967a = z10;
        invalidateSelf();
    }

    public final void f(int i10) {
        if (this.f37968b == i10) {
            return;
        }
        this.f37968b = i10;
        invalidateSelf();
    }

    public final void g(@NotNull ImageView.ScaleType scaleType) {
        s.j(scaleType, "<set-?>");
        this.f37969c = scaleType;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public final void h() {
        Iterator<sb.a> iterator2 = this.f37971e.l().iterator2();
        while (iterator2.hasNext()) {
            Integer b4 = iterator2.next().b();
            if (b4 != null) {
                int intValue = b4.intValue();
                h hVar = h.f38009e;
                if (hVar.b()) {
                    hVar.e(intValue);
                } else {
                    SoundPool p10 = this.f37971e.p();
                    if (p10 != null) {
                        p10.stop(intValue);
                    }
                }
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }
}
