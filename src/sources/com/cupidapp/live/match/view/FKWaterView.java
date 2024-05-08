package com.cupidapp.live.match.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import com.cupidapp.live.R$styleable;
import com.cupidapp.live.match.view.FKWaterView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKWaterView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKWaterView extends View {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public CountDownTimer f16906b;

    /* renamed from: c, reason: collision with root package name */
    public long f16907c;

    /* renamed from: d, reason: collision with root package name */
    public final long f16908d;

    /* renamed from: e, reason: collision with root package name */
    public long f16909e;

    /* renamed from: f, reason: collision with root package name */
    public final long f16910f;

    /* renamed from: g, reason: collision with root package name */
    public long f16911g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final List<CircleView> f16912h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final List<CircleView> f16913i;

    /* renamed from: j, reason: collision with root package name */
    public final int f16914j;

    /* renamed from: k, reason: collision with root package name */
    public final int f16915k;

    /* renamed from: l, reason: collision with root package name */
    public int f16916l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16917m = new LinkedHashMap();

    /* compiled from: FKWaterView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class CircleView {

        /* renamed from: a, reason: collision with root package name */
        public final int f16918a;

        /* renamed from: b, reason: collision with root package name */
        public final int f16919b;

        /* renamed from: c, reason: collision with root package name */
        public final int f16920c;

        /* renamed from: d, reason: collision with root package name */
        public final int f16921d;

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        public final Lazy f16922e = kotlin.c.b(new Function0<Float>() { // from class: com.cupidapp.live.match.view.FKWaterView$CircleView$cx$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Float invoke() {
                return Float.valueOf(FKWaterView.CircleView.this.i() / 2.0f);
            }
        });

        /* renamed from: f, reason: collision with root package name */
        @NotNull
        public final Lazy f16923f = kotlin.c.b(new Function0<Float>() { // from class: com.cupidapp.live.match.view.FKWaterView$CircleView$cy$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Float invoke() {
                return Float.valueOf(FKWaterView.CircleView.this.e() / 2.0f);
            }
        });

        /* renamed from: g, reason: collision with root package name */
        public final int f16924g = Color.argb(255, 255, 167, 68);

        /* renamed from: h, reason: collision with root package name */
        public final int f16925h = Color.argb(255, 254, 80, 124);

        /* renamed from: i, reason: collision with root package name */
        @NotNull
        public final Lazy f16926i = kotlin.c.b(new Function0<Paint>() { // from class: com.cupidapp.live.match.view.FKWaterView$CircleView$colorPaint$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Paint invoke() {
                Paint paint = new Paint(1);
                paint.setStrokeWidth(24.0f);
                paint.setStyle(Paint.Style.STROKE);
                paint.setShader(new LinearGradient(0.4f * FKWaterView.CircleView.this.i(), FKWaterView.CircleView.this.e() / 2.0f, 0.6f * FKWaterView.CircleView.this.i(), FKWaterView.CircleView.this.e() / 2.0f, FKWaterView.CircleView.this.g(), FKWaterView.CircleView.this.d(), Shader.TileMode.CLAMP));
                return paint;
            }
        });

        /* renamed from: j, reason: collision with root package name */
        @NotNull
        public final Lazy f16927j = kotlin.c.b(new Function0<Integer>() { // from class: com.cupidapp.live.match.view.FKWaterView$CircleView$radio$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                int min = Math.min(FKWaterView.CircleView.this.i(), FKWaterView.CircleView.this.e());
                if (FKWaterView.CircleView.this.h() == 0) {
                    min /= 2;
                }
                return Integer.valueOf(min);
            }
        });

        /* renamed from: k, reason: collision with root package name */
        @NotNull
        public RectF f16928k = new RectF();

        /* renamed from: l, reason: collision with root package name */
        public float f16929l;

        public CircleView(int i10, int i11, int i12, int i13) {
            this.f16918a = i10;
            this.f16919b = i11;
            this.f16920c = i12;
            this.f16921d = i13;
        }

        @NotNull
        public final Paint a() {
            return (Paint) this.f16926i.getValue();
        }

        public final float b() {
            return ((Number) this.f16922e.getValue()).floatValue();
        }

        public final float c() {
            return ((Number) this.f16923f.getValue()).floatValue();
        }

        public final int d() {
            return this.f16925h;
        }

        public final int e() {
            return this.f16919b;
        }

        public final int f() {
            return ((Number) this.f16927j.getValue()).intValue();
        }

        public final int g() {
            return this.f16924g;
        }

        public final int h() {
            return this.f16921d;
        }

        public final int i() {
            return this.f16918a;
        }

        public final boolean j(@Nullable Canvas canvas) {
            float f10 = this.f16929l + 1.0f;
            this.f16929l = f10;
            float f11 = f10 / this.f16920c;
            float f12 = 1 - f11;
            a().setStrokeWidth(24.0f * f12);
            a().setAlpha((int) (255 * f12));
            if (this.f16921d != 0) {
                float f13 = f() * f11;
                float f14 = 0.5f * f13;
                this.f16928k.set(b() - f13, c() - f14, b() + f13, c() + f14);
                if (canvas != null) {
                    canvas.drawOval(this.f16928k, a());
                }
            } else if (canvas != null) {
                canvas.drawCircle(b(), c(), f() * f11, a());
            }
            return f11 == 1.0f;
        }

        public final void k() {
            this.f16929l = 0.0f;
        }
    }

    /* compiled from: FKWaterView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a extends CountDownTimer {
        public a(long j10) {
            super(86400000L, j10);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
            CircleView circleView;
            if (FKWaterView.this.getTime() % FKWaterView.this.getCreateNewFrameTime() == 0) {
                List<CircleView> oldCircleViews = FKWaterView.this.getOldCircleViews();
                FKWaterView fKWaterView = FKWaterView.this;
                Iterator<CircleView> iterator2 = oldCircleViews.iterator2();
                while (true) {
                    if (!iterator2.hasNext()) {
                        circleView = null;
                        break;
                    }
                    circleView = iterator2.next();
                    if (fKWaterView.getOldCircleViews().remove(circleView)) {
                        break;
                    }
                }
                CircleView circleView2 = circleView;
                if (circleView2 == null) {
                    circleView2 = new CircleView(FKWaterView.this.getWidth(), FKWaterView.this.getHeight(), (int) FKWaterView.this.getCircleLifeCount(), FKWaterView.this.getCircleStyle());
                }
                circleView2.k();
                FKWaterView.this.getCircleViews().add(circleView2);
            }
            FKWaterView fKWaterView2 = FKWaterView.this;
            fKWaterView2.setTime(fKWaterView2.getTime() + FKWaterView.this.getRefreshFrameTime());
            FKWaterView.this.invalidate();
        }
    }

    public FKWaterView(@Nullable Context context) {
        super(context);
        this.f16908d = 20L;
        this.f16909e = com.huawei.openalliance.ad.ipc.c.Code;
        this.f16910f = com.huawei.openalliance.ad.ipc.c.Code / 20;
        this.f16911g = 500L;
        this.f16912h = new ArrayList();
        this.f16913i = new ArrayList();
        this.f16915k = 1;
        this.f16916l = this.f16914j;
    }

    public static /* synthetic */ void d(FKWaterView fKWaterView, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 0;
        }
        fKWaterView.c(j10);
    }

    public static final void e(FKWaterView this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        CountDownTimer countDownTimer = this$0.f16906b;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        a aVar = new a(this$0.f16908d);
        this$0.f16906b = aVar;
        aVar.start();
    }

    public final void b(@Nullable AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.FKWaterView);
            kotlin.jvm.internal.s.h(obtainStyledAttributes, "context.obtainStyledAttr… R.styleable.FKWaterView)");
            this.f16909e = obtainStyledAttributes.getInteger(0, 3000);
            this.f16911g = obtainStyledAttributes.getInteger(2, 500);
            this.f16916l = obtainStyledAttributes.getInt(1, this.f16914j);
            obtainStyledAttributes.recycle();
        }
    }

    public final void c(long j10) {
        postDelayed(new Runnable() { // from class: com.cupidapp.live.match.view.p
            @Override // java.lang.Runnable
            public final void run() {
                FKWaterView.e(FKWaterView.this);
            }
        }, j10);
    }

    public final void f() {
        this.f16912h.clear();
        this.f16913i.clear();
        CountDownTimer countDownTimer = this.f16906b;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.f16906b = null;
    }

    public final int getCircle() {
        return this.f16914j;
    }

    public final long getCircleLife() {
        return this.f16909e;
    }

    public final long getCircleLifeCount() {
        return this.f16910f;
    }

    public final int getCircleStyle() {
        return this.f16916l;
    }

    @NotNull
    public final List<CircleView> getCircleViews() {
        return this.f16912h;
    }

    public final long getCreateNewFrameTime() {
        return this.f16911g;
    }

    @Nullable
    public final CountDownTimer getEngine() {
        return this.f16906b;
    }

    @NotNull
    public final List<CircleView> getOldCircleViews() {
        return this.f16913i;
    }

    public final int getOval() {
        return this.f16915k;
    }

    public final long getRefreshFrameTime() {
        return this.f16908d;
    }

    public final long getTime() {
        return this.f16907c;
    }

    @Override // android.view.View
    public void onDraw(@Nullable Canvas canvas) {
        for (CircleView circleView : this.f16912h) {
            if (circleView.j(canvas)) {
                this.f16913i.add(circleView);
            }
        }
        this.f16912h.removeAll(this.f16913i);
    }

    public final void setCircleLife(long j10) {
        this.f16909e = j10;
    }

    public final void setCircleStyle(int i10) {
        this.f16916l = i10;
    }

    public final void setCreateNewFrameTime(long j10) {
        this.f16911g = j10;
    }

    public final void setEngine(@Nullable CountDownTimer countDownTimer) {
        this.f16906b = countDownTimer;
    }

    public final void setTime(long j10) {
        this.f16907c = j10;
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        if (i10 != 4 && i10 != 8) {
            d(this, 0L, 1, null);
        } else {
            f();
        }
    }

    public FKWaterView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16908d = 20L;
        this.f16909e = com.huawei.openalliance.ad.ipc.c.Code;
        this.f16910f = com.huawei.openalliance.ad.ipc.c.Code / 20;
        this.f16911g = 500L;
        this.f16912h = new ArrayList();
        this.f16913i = new ArrayList();
        this.f16915k = 1;
        this.f16916l = this.f16914j;
        b(attributeSet);
    }

    public FKWaterView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f16908d = 20L;
        this.f16909e = com.huawei.openalliance.ad.ipc.c.Code;
        this.f16910f = com.huawei.openalliance.ad.ipc.c.Code / 20;
        this.f16911g = 500L;
        this.f16912h = new ArrayList();
        this.f16913i = new ArrayList();
        this.f16915k = 1;
        this.f16916l = this.f16914j;
        b(attributeSet);
    }
}
