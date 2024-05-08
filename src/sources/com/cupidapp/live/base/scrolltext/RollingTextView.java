package com.cupidapp.live.base.scrolltext;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.cupidapp.live.R$styleable;
import com.cupidapp.live.base.scrolltext.RollingTextView;
import i1.b;
import i1.i;
import i1.k;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.s;
import kotlin.text.r;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RollingTextView.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class RollingTextView extends View {

    /* renamed from: b, reason: collision with root package name */
    public int f12187b;

    /* renamed from: c, reason: collision with root package name */
    public int f12188c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final Paint f12189d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final i1.a f12190e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final k f12191f;

    /* renamed from: g, reason: collision with root package name */
    public ValueAnimator f12192g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final Rect f12193h;

    /* renamed from: i, reason: collision with root package name */
    public int f12194i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public CharSequence f12195j;

    /* renamed from: k, reason: collision with root package name */
    public long f12196k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f12197l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f12198m;

    /* renamed from: n, reason: collision with root package name */
    public int f12199n;

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    public Interpolator f12200o;

    /* renamed from: p, reason: collision with root package name */
    public int f12201p;

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12202q;

    /* compiled from: RollingTextView.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            s.i(animation, "animation");
            RollingTextView.this.f12191f.h();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RollingTextView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        s.i(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RollingTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        s.i(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RollingTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0, 8, null);
        s.i(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RollingTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10);
        TypedArray typedArray;
        Ref$FloatRef ref$FloatRef;
        Ref$ObjectRef ref$ObjectRef;
        s.i(context, "context");
        this.f12202q = new LinkedHashMap();
        Paint paint = new Paint();
        this.f12189d = paint;
        i1.a aVar = new i1.a();
        this.f12190e = aVar;
        this.f12191f = new k(paint, aVar);
        this.f12192g = ValueAnimator.ofFloat(1.0f);
        this.f12193h = new Rect();
        this.f12195j = "";
        this.f12196k = 750L;
        this.f12199n = 8388613;
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        Ref$FloatRef ref$FloatRef2 = new Ref$FloatRef();
        Ref$FloatRef ref$FloatRef3 = new Ref$FloatRef();
        Ref$FloatRef ref$FloatRef4 = new Ref$FloatRef();
        Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        ref$ObjectRef2.element = "";
        Ref$FloatRef ref$FloatRef5 = new Ref$FloatRef();
        ref$FloatRef5.element = TypedValue.applyDimension(2, 12.0f, context.getResources().getDisplayMetrics());
        int[] iArr = R$styleable.RollingTextView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i10, i11);
        s.h(obtainStyledAttributes, "context.obtainStyledAttr…tr, defStyleRes\n        )");
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        if (resourceId != -1) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, iArr);
            s.h(obtainStyledAttributes2, "context.obtainStyledAttr…ingTextView\n            )");
            typedArray = obtainStyledAttributes;
            ref$FloatRef = ref$FloatRef5;
            ref$ObjectRef = ref$ObjectRef2;
            c(this, ref$IntRef, ref$FloatRef2, ref$FloatRef3, ref$FloatRef4, ref$ObjectRef2, ref$FloatRef5, obtainStyledAttributes2);
            obtainStyledAttributes2.recycle();
        } else {
            typedArray = obtainStyledAttributes;
            ref$FloatRef = ref$FloatRef5;
            ref$ObjectRef = ref$ObjectRef2;
        }
        c(this, ref$IntRef, ref$FloatRef2, ref$FloatRef3, ref$FloatRef4, ref$ObjectRef, ref$FloatRef, typedArray);
        TypedArray typedArray2 = typedArray;
        this.f12196k = typedArray2.getInt(10, (int) this.f12196k);
        paint.setAntiAlias(true);
        int i12 = ref$IntRef.element;
        if (i12 != 0) {
            paint.setShadowLayer(ref$FloatRef4.element, ref$FloatRef2.element, ref$FloatRef3.element, i12);
        }
        if (this.f12194i != 0) {
            setTypeface(paint.getTypeface());
        }
        setTextSize(0, ref$FloatRef.element);
        setText((CharSequence) ref$ObjectRef.element, false);
        typedArray2.recycle();
        this.f12192g.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: i1.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                RollingTextView.d(RollingTextView.this, valueAnimator);
            }
        });
        this.f12192g.addListener(new a());
        this.f12200o = new LinearInterpolator();
        this.f12201p = -16777216;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void c(RollingTextView rollingTextView, Ref$IntRef ref$IntRef, Ref$FloatRef ref$FloatRef, Ref$FloatRef ref$FloatRef2, Ref$FloatRef ref$FloatRef3, Ref$ObjectRef<String> ref$ObjectRef, Ref$FloatRef ref$FloatRef4, TypedArray typedArray) {
        rollingTextView.f12199n = typedArray.getInt(4, rollingTextView.f12199n);
        ref$IntRef.element = typedArray.getColor(6, ref$IntRef.element);
        ref$FloatRef.element = typedArray.getFloat(7, ref$FloatRef.element);
        ref$FloatRef2.element = typedArray.getFloat(8, ref$FloatRef2.element);
        ref$FloatRef3.element = typedArray.getFloat(9, ref$FloatRef3.element);
        String string = typedArray.getString(5);
        T t2 = string;
        if (string == null) {
            t2 = "";
        }
        ref$ObjectRef.element = t2;
        rollingTextView.setTextColor(typedArray.getColor(3, rollingTextView.f12201p));
        ref$FloatRef4.element = typedArray.getDimension(1, ref$FloatRef4.element);
        rollingTextView.f12194i = typedArray.getInt(2, rollingTextView.f12194i);
    }

    public static final void d(RollingTextView this$0, ValueAnimator it) {
        s.i(this$0, "this$0");
        s.i(it, "it");
        this$0.f12191f.k(it.getAnimatedFraction());
        this$0.h();
        this$0.invalidate();
    }

    public final void f(@NotNull Animator.AnimatorListener listener) {
        s.i(listener, "listener");
        this.f12192g.addListener(listener);
    }

    public final void g(@NotNull CharSequence orderList) {
        s.i(orderList, "orderList");
        this.f12190e.a(r.S0(orderList));
    }

    public final long getAnimationDuration() {
        return this.f12196k;
    }

    @NotNull
    public final Interpolator getAnimationInterpolator() {
        return this.f12200o;
    }

    @Override // android.view.View
    public int getBaseline() {
        Paint.FontMetrics fontMetrics = this.f12189d.getFontMetrics();
        float f10 = 2;
        float g3 = this.f12191f.g() / f10;
        float f11 = fontMetrics.descent;
        return (int) (g3 + (((f11 - fontMetrics.ascent) / f10) - f11));
    }

    @NotNull
    public final b getCharStrategy() {
        return this.f12190e.e();
    }

    @NotNull
    public final char[] getCurrentText() {
        return this.f12191f.c();
    }

    public final int getGravity() {
        return this.f12199n;
    }

    public final int getLetterSpacingExtra() {
        return this.f12191f.e();
    }

    @NotNull
    public final CharSequence getText() {
        return this.f12195j;
    }

    public final int getTextColor() {
        return this.f12201p;
    }

    public final float getTextSize() {
        return this.f12189d.getTextSize();
    }

    @Nullable
    public final Typeface getTypeface() {
        return this.f12189d.getTypeface();
    }

    public final boolean h() {
        boolean z10 = this.f12187b != j();
        boolean z11 = this.f12188c != i();
        if (!z10 && !z11) {
            return false;
        }
        requestLayout();
        return true;
    }

    public final int i() {
        return ((int) this.f12191f.g()) + getPaddingTop() + getPaddingBottom();
    }

    public final int j() {
        return ((int) this.f12191f.d()) + getPaddingLeft() + getPaddingRight();
    }

    public final void k() {
        this.f12189d.setFakeBoldText(true);
    }

    public final void l() {
        this.f12191f.l();
        h();
        invalidate();
    }

    public final void m(Canvas canvas) {
        float d10 = this.f12191f.d();
        float g3 = this.f12191f.g();
        int width = this.f12193h.width();
        int height = this.f12193h.height();
        Rect rect = this.f12193h;
        int i10 = rect.left;
        float f10 = i10;
        int i11 = rect.top;
        float f11 = i11;
        if (this.f12197l) {
            int i12 = this.f12199n;
            if ((i12 & 1) == 1) {
                f10 = i10 + ((width - d10) / 2.0f);
            }
            if ((i12 & 8388613) == 8388613) {
                f10 = i10 + (width - d10);
            }
        }
        if (this.f12198m) {
            int i13 = this.f12199n;
            if ((i13 & 16) == 16) {
                f11 = ((height - g3) / 2.0f) + i11;
            }
            if ((i13 & 80) == 80) {
                f11 = i11 + (height - g3);
            }
        }
        canvas.translate(f10, f11);
        canvas.clipRect(0.0f, 0.0f, d10, g3);
    }

    public final void n(@NotNull Animator.AnimatorListener listener) {
        s.i(listener, "listener");
        this.f12192g.removeListener(listener);
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        s.i(canvas, "canvas");
        super.onDraw(canvas);
        canvas.save();
        m(canvas);
        canvas.translate(0.0f, this.f12191f.f());
        this.f12191f.b(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        this.f12187b = j();
        this.f12188c = i();
        setMeasuredDimension(View.resolveSize(this.f12187b, i10), View.resolveSize(this.f12188c, i11));
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f12193h.set(getPaddingLeft(), getPaddingTop(), i10 - getPaddingRight(), i11 - getPaddingBottom());
        this.f12197l = this.f12193h.width() > j();
        this.f12198m = this.f12193h.height() > i();
    }

    public final void setAnimationDuration(long j10) {
        this.f12196k = j10;
    }

    public final void setAnimationInterpolator(@NotNull Interpolator interpolator) {
        s.i(interpolator, "<set-?>");
        this.f12200o = interpolator;
    }

    public final void setCharOrder(@NotNull CharSequence orderList) {
        s.i(orderList, "orderList");
        this.f12190e.g(r.S0(orderList));
    }

    public final void setCharStrategy(@NotNull b value) {
        s.i(value, "value");
        this.f12190e.h(value);
    }

    public final void setGravity(int i10) {
        this.f12199n = i10;
    }

    public final void setLetterSpacingExtra(int i10) {
        this.f12191f.i(i10);
    }

    public final void setText(@NotNull CharSequence text) {
        s.i(text, "text");
        setText(text, !TextUtils.isEmpty(this.f12195j));
    }

    public final void setTextColor(int i10) {
        if (this.f12201p != i10) {
            this.f12201p = i10;
            this.f12189d.setColor(i10);
            invalidate();
        }
    }

    public final void setTextSize(float f10) {
        setTextSize(2, f10);
    }

    public final void setTypeface(@Nullable Typeface typeface) {
        Paint paint = this.f12189d;
        int i10 = this.f12194i;
        if (i10 == 1) {
            typeface = Typeface.create(typeface, 1);
        } else if (i10 == 2) {
            typeface = Typeface.create(typeface, 2);
        } else if (i10 == 3) {
            typeface = Typeface.create(typeface, 3);
        }
        paint.setTypeface(typeface);
        l();
    }

    public final void setText(@NotNull CharSequence text, boolean z10) {
        s.i(text, "text");
        this.f12195j = text;
        if (z10) {
            this.f12191f.j(text);
            final ValueAnimator valueAnimator = this.f12192g;
            if (valueAnimator.isRunning()) {
                valueAnimator.cancel();
            }
            valueAnimator.setDuration(this.f12196k);
            valueAnimator.setInterpolator(this.f12200o);
            post(new Runnable() { // from class: i1.g
                @Override // java.lang.Runnable
                public final void run() {
                    valueAnimator.start();
                }
            });
            return;
        }
        b charStrategy = getCharStrategy();
        setCharStrategy(i.a());
        this.f12191f.j(text);
        setCharStrategy(charStrategy);
        this.f12191f.h();
        h();
        invalidate();
    }

    public final void setTextSize(int i10, float f10) {
        Context context = getContext();
        Resources resources = context != null ? context.getResources() : null;
        if (resources == null) {
            resources = Resources.getSystem();
            s.h(resources, "getSystem()");
        }
        this.f12189d.setTextSize(TypedValue.applyDimension(i10, f10, resources.getDisplayMetrics()));
        l();
    }

    public /* synthetic */ RollingTextView(Context context, AttributeSet attributeSet, int i10, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i10, (i12 & 8) != 0 ? 0 : i11);
    }
}
