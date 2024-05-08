package com.cupidapp.live.base.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKDynamicLine.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKDynamicLine extends View {

    /* renamed from: b, reason: collision with root package name */
    @ColorInt
    public int f12486b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Lazy f12487c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final Lazy f12488d;

    /* renamed from: e, reason: collision with root package name */
    public float f12489e;

    /* renamed from: f, reason: collision with root package name */
    public float f12490f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12491g = new LinkedHashMap();

    public FKDynamicLine(@Nullable Context context) {
        super(context);
        this.f12486b = -15066598;
        this.f12487c = kotlin.c.b(new Function0<Paint>() { // from class: com.cupidapp.live.base.view.FKDynamicLine$paint$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Paint invoke() {
                LinearGradient b4;
                Paint paint = new Paint();
                FKDynamicLine fKDynamicLine = FKDynamicLine.this;
                paint.setAntiAlias(true);
                paint.setStyle(Paint.Style.FILL);
                b4 = fKDynamicLine.b();
                paint.setShader(b4);
                return paint;
            }
        });
        this.f12488d = kotlin.c.b(FKDynamicLine$rectF$2.INSTANCE);
    }

    private final Paint getPaint() {
        return (Paint) this.f12487c.getValue();
    }

    private final RectF getRectF() {
        return (RectF) this.f12488d.getValue();
    }

    public final LinearGradient b() {
        float measuredWidth = getMeasuredWidth();
        int i10 = this.f12486b;
        return new LinearGradient(0.0f, 0.0f, measuredWidth, 0.0f, i10, i10, Shader.TileMode.CLAMP);
    }

    public final void c(float f10, float f11, @ColorInt int i10) {
        this.f12489e = f10;
        this.f12490f = f11;
        if (this.f12486b != i10) {
            this.f12486b = i10;
            getPaint().setShader(b());
        }
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(@Nullable Canvas canvas) {
        getRectF().set(this.f12489e, 0.0f, this.f12490f, getHeight());
        float c4 = z0.h.c(this, 3.0f);
        if (canvas != null) {
            canvas.drawRoundRect(getRectF(), c4, c4, getPaint());
        }
    }

    public FKDynamicLine(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12486b = -15066598;
        this.f12487c = kotlin.c.b(new Function0<Paint>() { // from class: com.cupidapp.live.base.view.FKDynamicLine$paint$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Paint invoke() {
                LinearGradient b4;
                Paint paint = new Paint();
                FKDynamicLine fKDynamicLine = FKDynamicLine.this;
                paint.setAntiAlias(true);
                paint.setStyle(Paint.Style.FILL);
                b4 = fKDynamicLine.b();
                paint.setShader(b4);
                return paint;
            }
        });
        this.f12488d = kotlin.c.b(FKDynamicLine$rectF$2.INSTANCE);
    }

    public FKDynamicLine(@Nullable Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f12486b = -15066598;
        this.f12487c = kotlin.c.b(new Function0<Paint>() { // from class: com.cupidapp.live.base.view.FKDynamicLine$paint$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Paint invoke() {
                LinearGradient b4;
                Paint paint = new Paint();
                FKDynamicLine fKDynamicLine = FKDynamicLine.this;
                paint.setAntiAlias(true);
                paint.setStyle(Paint.Style.FILL);
                b4 = fKDynamicLine.b();
                paint.setShader(b4);
                return paint;
            }
        });
        this.f12488d = kotlin.c.b(FKDynamicLine$rectF$2.INSTANCE);
    }
}
