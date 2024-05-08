package com.cupidapp.live.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.cupidapp.live.R$styleable;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: StrokeTextView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class StrokeTextView extends AppCompatTextView {

    /* renamed from: b, reason: collision with root package name */
    public Paint f12559b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12560c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StrokeTextView(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12560c = new LinkedHashMap();
        b(this, null, 0, 2, null);
    }

    public static /* synthetic */ void b(StrokeTextView strokeTextView, AttributeSet attributeSet, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        strokeTextView.a(attributeSet, i10);
    }

    public final void a(@Nullable AttributeSet attributeSet, int i10) {
        setStrokePain(new Paint());
        Context context = getContext();
        TypedArray obtainStyledAttributes = context != null ? context.obtainStyledAttributes(attributeSet, R$styleable.StrokeTextView, i10, 0) : null;
        if (obtainStyledAttributes != null) {
            getStrokePain().setShadowLayer(4.0f, 4.0f, 4.0f, -16777216);
        }
        if (obtainStyledAttributes != null) {
            obtainStyledAttributes.recycle();
        }
    }

    @NotNull
    public final Paint getStrokePain() {
        Paint paint = this.f12559b;
        if (paint != null) {
            return paint;
        }
        kotlin.jvm.internal.s.A("strokePain");
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        kotlin.jvm.internal.s.i(canvas, "canvas");
        getStrokePain().setTextSize(getPaint().getTextSize());
        getStrokePain().setTypeface(getPaint().getTypeface());
        getStrokePain().setFlags(getPaint().getFlags());
        getStrokePain().setAlpha(getPaint().getAlpha());
        getStrokePain().setStyle(Paint.Style.STROKE);
        canvas.drawText(getText().toString(), (getWidth() - getStrokePain().measureText(getText().toString())) / 2, getBaseline(), getStrokePain());
        super.onDraw(canvas);
    }

    public final void setStrokePain(@NotNull Paint paint) {
        kotlin.jvm.internal.s.i(paint, "<set-?>");
        this.f12559b = paint;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StrokeTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12560c = new LinkedHashMap();
        b(this, attributeSet, 0, 2, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StrokeTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12560c = new LinkedHashMap();
        a(attributeSet, i10);
    }
}
