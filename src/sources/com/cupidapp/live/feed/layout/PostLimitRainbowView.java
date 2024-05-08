package com.cupidapp.live.feed.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PostLimitRainbowView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PostLimitRainbowView extends View {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Paint f14558b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public LinearGradient f14559c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public RectF f14560d;

    /* renamed from: e, reason: collision with root package name */
    public final float f14561e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14562f = new LinkedHashMap();

    public PostLimitRainbowView(@Nullable Context context) {
        super(context);
        this.f14558b = new Paint();
        this.f14561e = z0.h.c(this, 8.0f);
        a();
    }

    public final void a() {
        this.f14558b.setAntiAlias(true);
        this.f14558b.setDither(true);
        this.f14558b.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    public void onDraw(@Nullable Canvas canvas) {
        super.onDraw(canvas);
        this.f14558b.setShader(this.f14559c);
        RectF rectF = this.f14560d;
        if (rectF == null || canvas == null) {
            return;
        }
        float f10 = this.f14561e;
        canvas.drawRoundRect(rectF, f10, f10, this.f14558b);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        float f10 = i10;
        float f11 = i11;
        this.f14559c = new LinearGradient(0.0f, 0.0f, f10, f11, new int[]{Color.parseColor("#FF0E0E"), Color.parseColor("#FF7338"), Color.parseColor("#FFD200"), Color.parseColor("#2CFF42"), Color.parseColor("#4796FF"), Color.parseColor("#CA47FF")}, new float[]{0.0f, 0.19f, 0.38f, 0.58f, 0.82f, 1.0f}, Shader.TileMode.CLAMP);
        this.f14560d = new RectF(0.0f, 0.0f, f10, f11);
    }

    public PostLimitRainbowView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14558b = new Paint();
        this.f14561e = z0.h.c(this, 8.0f);
        a();
    }

    public PostLimitRainbowView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f14558b = new Paint();
        this.f14561e = z0.h.c(this, 8.0f);
        a();
    }
}
