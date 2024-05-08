package com.cupidapp.live.base.view.zoom;

import android.animation.ValueAnimator;
import android.graphics.Matrix;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: ScaleAnimator.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class f extends ValueAnimator implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f13006f = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Function1<float[], p> f13007b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final float[] f13008c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final float[] f13009d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final float[] f13010e;

    /* compiled from: ScaleAnimator.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(@NotNull Matrix start, @NotNull Matrix end, @NotNull Function1<? super float[], p> onAnimationUpdate) {
        s.i(start, "start");
        s.i(end, "end");
        s.i(onAnimationUpdate, "onAnimationUpdate");
        this.f13007b = onAnimationUpdate;
        float[] fArr = new float[9];
        this.f13008c = fArr;
        float[] fArr2 = new float[9];
        this.f13009d = fArr2;
        this.f13010e = new float[9];
        setFloatValues(0.0f, 1.0f);
        setDuration(200L);
        addUpdateListener(this);
        start.getValues(fArr);
        end.getValues(fArr2);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@NotNull ValueAnimator animation) {
        s.i(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Float f10 = animatedValue instanceof Float ? (Float) animatedValue : null;
        if (f10 != null) {
            float floatValue = f10.floatValue();
            for (int i10 = 0; i10 < 9; i10++) {
                float[] fArr = this.f13010e;
                float[] fArr2 = this.f13008c;
                fArr[i10] = fArr2[i10] + ((this.f13009d[i10] - fArr2[i10]) * floatValue);
            }
            this.f13007b.invoke(this.f13010e);
        }
    }
}
