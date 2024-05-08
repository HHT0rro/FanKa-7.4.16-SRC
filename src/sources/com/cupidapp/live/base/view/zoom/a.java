package com.cupidapp.live.base.view.zoom;

import android.animation.ValueAnimator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FlingAnimator.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a extends ValueAnimator implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final C0146a f12998d = new C0146a(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Function1<float[], Boolean> f12999b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final float[] f13000c;

    /* compiled from: FlingAnimator.kt */
    @kotlin.d
    /* renamed from: com.cupidapp.live.base.view.zoom.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class C0146a {
        public C0146a() {
        }

        public /* synthetic */ C0146a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(float f10, float f11, @NotNull Function1<? super float[], Boolean> scrollBy) {
        s.i(scrollBy, "scrollBy");
        this.f12999b = scrollBy;
        setFloatValues(0.0f, 1.0f);
        setDuration(1000000L);
        addUpdateListener(this);
        this.f13000c = new float[]{f10, f11};
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@NotNull ValueAnimator animation) {
        s.i(animation, "animation");
        boolean booleanValue = this.f12999b.invoke(this.f13000c).booleanValue();
        float[] fArr = this.f13000c;
        fArr[0] = fArr[0] * 0.9f;
        fArr[1] = fArr[1] * 0.9f;
        if (!booleanValue || b.f13001a.b(0.0f, 0.0f, fArr[0], fArr[1]) < 1.0f) {
            animation.cancel();
        }
    }
}
