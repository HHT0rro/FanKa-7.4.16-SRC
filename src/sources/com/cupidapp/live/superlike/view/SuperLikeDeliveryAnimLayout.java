package com.cupidapp.live.superlike.view;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.i0;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: SuperLikeDeliveryAnimLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SuperLikeDeliveryAnimLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    public int f18630b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18631c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuperLikeDeliveryAnimLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f18631c = new LinkedHashMap();
        b();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f18631c;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void b() {
        z.a(this, R$layout.layout_super_like_delivery_anim, true);
    }

    public final void c(int i10) {
        int min;
        int i11;
        setVisibility(0);
        if (i10 == 1) {
            i11 = 0;
        } else if (i10 <= 6) {
            i11 = ((i10 - 2) * 12) + 30;
        } else {
            if (i10 < 100) {
                min = Math.min(i10 - 6, 12);
            } else {
                min = Math.min(i10 - 6, 16);
            }
            i11 = (min * 9) + 78;
        }
        FKSVGAImageView fKSVGAImageView = (FKSVGAImageView) a(R$id.super_like_delivery_svga);
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(200.0f);
        h hVar = h.f18669a;
        Context context = getContext();
        s.h(context, "context");
        textPaint.setColor(hVar.c(context, i10));
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setFakeBoldText(true);
        textPaint.setAntiAlias(true);
        p pVar = p.f51048a;
        TextPaint textPaint2 = new TextPaint();
        textPaint2.setTextSize(200.0f);
        textPaint2.setColor(-1);
        textPaint2.setStrokeWidth(26.0f);
        textPaint2.setStyle(Paint.Style.FILL_AND_STROKE);
        textPaint2.setAntiAlias(true);
        fKSVGAImageView.C(i0.g(new Pair("number_2", new Pair(textPaint, String.valueOf(i10))), new Pair("number_outline", new Pair(textPaint2, String.valueOf(i10)))), i11);
        this.f18630b = i10;
    }

    public final void d() {
        setVisibility(8);
        ((FKSVGAImageView) a(R$id.super_like_delivery_svga)).K();
    }

    public final int getAndResetSendCount() {
        int i10 = this.f18630b;
        this.f18630b = 0;
        return i10;
    }

    public final int getSendCount() {
        return this.f18630b;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuperLikeDeliveryAnimLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18631c = new LinkedHashMap();
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuperLikeDeliveryAnimLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f18631c = new LinkedHashMap();
        b();
    }
}
