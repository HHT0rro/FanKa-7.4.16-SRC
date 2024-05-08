package com.cupidapp.live.base.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.cupidapp.live.base.view.m;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RoundedFrameLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class RoundedFrameLayout extends FrameLayout implements m {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Path f12552b;

    /* renamed from: c, reason: collision with root package name */
    public float f12553c;

    /* renamed from: d, reason: collision with root package name */
    public float f12554d;

    /* renamed from: e, reason: collision with root package name */
    public float f12555e;

    /* renamed from: f, reason: collision with root package name */
    public float f12556f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12557g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundedFrameLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12557g = new LinkedHashMap();
        this.f12552b = new Path();
    }

    public void b(int i10, int i11) {
        m.a.a(this, i10, i11);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(@NotNull Canvas canvas) {
        kotlin.jvm.internal.s.i(canvas, "canvas");
        int save = canvas.save();
        canvas.clipPath(getPath());
        super.dispatchDraw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // com.cupidapp.live.base.view.m
    public float getBottomLeftRadius() {
        return this.f12554d;
    }

    @Override // com.cupidapp.live.base.view.m
    public float getBottomRightRadius() {
        return this.f12556f;
    }

    @Override // com.cupidapp.live.base.view.m
    @NotNull
    public Path getPath() {
        return this.f12552b;
    }

    @Override // com.cupidapp.live.base.view.m
    public float getTopLeftRadius() {
        return this.f12553c;
    }

    @Override // com.cupidapp.live.base.view.m
    public float getTopRightRadius() {
        return this.f12555e;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        b(i10, i11);
    }

    @Override // com.cupidapp.live.base.view.m
    public void setBottomLeftRadius(float f10) {
        this.f12554d = f10;
    }

    @Override // com.cupidapp.live.base.view.m
    public void setBottomRightRadius(float f10) {
        this.f12556f = f10;
    }

    public void setCornerRadius(float f10) {
        m.a.b(this, f10);
    }

    @Override // com.cupidapp.live.base.view.m
    public void setTopLeftRadius(float f10) {
        this.f12553c = f10;
    }

    @Override // com.cupidapp.live.base.view.m
    public void setTopRightRadius(float f10) {
        this.f12555e = f10;
    }

    @Override // com.cupidapp.live.base.view.m
    public void setCornerRadius(float f10, float f11, float f12, float f13) {
        m.a.c(this, f10, f11, f12, f13);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundedFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12557g = new LinkedHashMap();
        this.f12552b = new Path();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundedFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12557g = new LinkedHashMap();
        this.f12552b = new Path();
    }
}
