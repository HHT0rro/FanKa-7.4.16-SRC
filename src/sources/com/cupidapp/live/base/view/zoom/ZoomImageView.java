package com.cupidapp.live.base.view.zoom;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ZoomImageView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ZoomImageView extends ImageLoaderView {

    @NotNull
    public static final a B = new a(null);

    @NotNull
    public Map<Integer, View> A;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public Function0<p> f12953l;

    /* renamed from: m, reason: collision with root package name */
    public float f12954m;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    public ScaleEndType f12955n;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    public b f12956o;

    /* renamed from: p, reason: collision with root package name */
    public int f12957p;

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public Rect f12958q;

    /* renamed from: r, reason: collision with root package name */
    public float f12959r;

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public final Matrix f12960s;

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public final PointF f12961t;

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public final PointF f12962u;

    /* renamed from: v, reason: collision with root package name */
    public float f12963v;

    /* renamed from: w, reason: collision with root package name */
    @Nullable
    public f f12964w;

    /* renamed from: x, reason: collision with root package name */
    @Nullable
    public com.cupidapp.live.base.view.zoom.a f12965x;

    /* renamed from: y, reason: collision with root package name */
    public float f12966y;

    /* renamed from: z, reason: collision with root package name */
    @NotNull
    public final GestureDetector f12967z;

    /* compiled from: ZoomImageView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum ScaleEndType {
        RestoreOriginal,
        RecentStyle
    }

    /* compiled from: ZoomImageView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ZoomImageView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface b {
        void a();
    }

    /* compiled from: ZoomImageView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12968a;

        static {
            int[] iArr = new int[ScaleEndType.values().length];
            try {
                iArr[ScaleEndType.RestoreOriginal.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ScaleEndType.RecentStyle.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f12968a = iArr;
        }
    }

    /* compiled from: ZoomImageView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class d extends GestureDetector.SimpleOnGestureListener {
        public d() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(@Nullable MotionEvent motionEvent) {
            if (motionEvent == null) {
                return false;
            }
            if (ZoomImageView.this.f12957p == 1 && ZoomImageView.this.D()) {
                ZoomImageView.this.H(motionEvent.getX(), motionEvent.getY());
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(@Nullable MotionEvent motionEvent, @Nullable MotionEvent motionEvent2, float f10, float f11) {
            if (ZoomImageView.this.f12957p != 0 || !ZoomImageView.this.D()) {
                return true;
            }
            ZoomImageView.this.I(f10, f11);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(@Nullable MotionEvent motionEvent) {
            Function0<p> onSingleClick = ZoomImageView.this.getOnSingleClick();
            if (onSingleClick != null) {
                onSingleClick.invoke();
            }
            if (motionEvent == null) {
                return false;
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* compiled from: ZoomImageView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class e extends AnimatorListenerAdapter {
        public e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            s.i(animation, "animation");
            b bVar = ZoomImageView.this.f12956o;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZoomImageView(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.A = new LinkedHashMap();
        this.f12954m = 0.9f;
        this.f12958q = new Rect();
        this.f12960s = new Matrix();
        this.f12961t = new PointF();
        this.f12962u = new PointF();
        this.f12967z = new GestureDetector(getContext(), new d());
        z();
    }

    public static /* synthetic */ boolean y(ZoomImageView zoomImageView, MotionEvent motionEvent, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleTouchEvent");
        }
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return zoomImageView.x(motionEvent, i10);
    }

    public final boolean A() {
        return getDrawable() != null && getDrawable().getIntrinsicWidth() > 0 && getDrawable().getIntrinsicHeight() > 0 && this.f12958q.width() > 0 && this.f12958q.height() > 0;
    }

    public final void B() {
        this.f12960s.reset();
        this.f12957p = 0;
        this.f12961t.set(0.0f, 0.0f);
        this.f12962u.set(0.0f, 0.0f);
        this.f12963v = 0.0f;
        this.f12959r = 0.0f;
        this.f12958q.set(0, 0, 0, 0);
        q();
        invalidate();
    }

    public final void C(float f10, float f11, float f12, float f13) {
        com.cupidapp.live.base.view.zoom.b bVar = com.cupidapp.live.base.view.zoom.b.f13001a;
        this.f12963v = bVar.c(this.f12960s).x / bVar.b(f10, f11, f12, f13);
        PointF d10 = bVar.d(bVar.a(f10, f11, f12, f13), this.f12960s);
        this.f12962u.set(d10.x, d10.y);
    }

    public final boolean D() {
        f fVar = this.f12964w;
        if (fVar != null) {
            return fVar != null && !fVar.isRunning();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean E(float r10, float r11) {
        /*
            r9 = this;
            boolean r0 = r9.A()
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            com.cupidapp.live.base.view.zoom.b r0 = com.cupidapp.live.base.view.zoom.b.f13001a
            android.graphics.RectF r2 = r0.i()
            r9.v(r2)
            float r3 = r2.right
            float r4 = r2.left
            float r3 = r3 - r4
            android.graphics.Rect r4 = r9.f12958q
            int r4 = r4.width()
            float r4 = (float) r4
            r5 = 0
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L24
        L22:
            r10 = 0
            goto L4b
        L24:
            float r3 = r2.left
            float r4 = r3 + r10
            android.graphics.Rect r6 = r9.f12958q
            int r7 = r6.left
            float r8 = (float) r7
            int r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r4 <= 0) goto L39
            float r10 = (float) r7
            int r10 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r10 >= 0) goto L22
            float r10 = (float) r7
        L37:
            float r10 = r10 - r3
            goto L4b
        L39:
            float r3 = r2.right
            float r4 = r3 + r10
            int r6 = r6.right
            float r7 = (float) r6
            int r4 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r4 >= 0) goto L4b
            float r10 = (float) r6
            int r10 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r10 <= 0) goto L22
            float r10 = (float) r6
            goto L37
        L4b:
            float r3 = r2.bottom
            float r4 = r2.top
            float r3 = r3 - r4
            android.graphics.Rect r4 = r9.f12958q
            int r4 = r4.height()
            float r4 = (float) r4
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L5d
        L5b:
            r11 = 0
            goto L84
        L5d:
            float r3 = r2.top
            float r4 = r3 + r11
            android.graphics.Rect r6 = r9.f12958q
            int r7 = r6.top
            float r8 = (float) r7
            int r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r4 <= 0) goto L72
            float r11 = (float) r7
            int r11 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r11 >= 0) goto L5b
            float r11 = (float) r7
        L70:
            float r11 = r11 - r3
            goto L84
        L72:
            float r3 = r2.bottom
            float r4 = r3 + r11
            int r6 = r6.bottom
            float r7 = (float) r6
            int r4 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r4 >= 0) goto L84
            float r11 = (float) r6
            int r11 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r11 <= 0) goto L5b
            float r11 = (float) r6
            goto L70
        L84:
            r0.h(r2)
            android.graphics.Matrix r0 = r9.f12960s
            r0.postTranslate(r10, r11)
            r9.invalidate()
            r0 = 1
            int r10 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r10 != 0) goto L96
            r10 = 1
            goto L97
        L96:
            r10 = 0
        L97:
            if (r10 == 0) goto La2
            int r10 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r10 != 0) goto L9f
            r10 = 1
            goto La0
        L9f:
            r10 = 0
        La0:
            if (r10 != 0) goto La3
        La2:
            r1 = 1
        La3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.base.view.zoom.ZoomImageView.E(float, float):boolean");
    }

    public final void F(float f10) {
        this.f12959r = f10;
    }

    public final void G(@Nullable RectF rectF) {
        float centerY;
        float f10;
        float height;
        float height2;
        if (A()) {
            com.cupidapp.live.base.view.zoom.b bVar = com.cupidapp.live.base.view.zoom.b.f13001a;
            RectF i10 = bVar.i();
            v(i10);
            float f11 = 0.0f;
            if (rectF == null) {
                if (getDrawable().getIntrinsicWidth() < getDrawable().getIntrinsicHeight()) {
                    height = this.f12958q.width();
                    height2 = i10.width();
                } else {
                    height = this.f12958q.height();
                    height2 = i10.height();
                }
                f10 = height / height2;
                centerY = 0.0f;
            } else {
                float width = rectF.width() / i10.width();
                float centerX = rectF.centerX() - i10.centerX();
                centerY = rectF.centerY() - i10.centerY();
                f10 = width;
                f11 = centerX;
            }
            float f12 = bVar.c(this.f12960s).x;
            Matrix g3 = bVar.g(this.f12960s);
            Rect rect = this.f12958q;
            float f13 = f10 / f12;
            g3.postScale(f13, f13, (this.f12958q.width() / 2.0f) + rect.left, (rect.height() / 2.0f) + this.f12958q.top);
            g3.postTranslate(f11, centerY);
            q();
            this.f12960s.set(g3);
            invalidate();
            bVar.h(i10);
            bVar.e(g3);
        }
    }

    public final void H(float f10, float f11) {
        if (A()) {
            com.cupidapp.live.base.view.zoom.b bVar = com.cupidapp.live.base.view.zoom.b.f13001a;
            Matrix f12 = bVar.f();
            w(f12);
            float f13 = bVar.c(this.f12960s).x;
            float o10 = o(f13);
            Matrix g3 = bVar.g(this.f12960s);
            float f14 = o10 / f13;
            g3.postScale(f14, f14, f10, f11);
            g3.postTranslate((getWidth() / 2.0f) - f10, (getHeight() / 2.0f) - f11);
            Matrix g10 = bVar.g(f12);
            g10.postConcat(g3);
            RectF j10 = bVar.j(0.0f, 0.0f, getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
            g10.mapRect(j10);
            PointF t2 = t(j10);
            g3.postTranslate(t2.x, t2.y);
            q();
            f fVar = new f(this.f12960s, g3, new Function1<float[], p>() { // from class: com.cupidapp.live.base.view.zoom.ZoomImageView$startDoubleTapAnimation$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(float[] fArr) {
                    invoke2(fArr);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull float[] it) {
                    Matrix matrix;
                    s.i(it, "it");
                    matrix = ZoomImageView.this.f12960s;
                    matrix.setValues(it);
                    ZoomImageView.this.invalidate();
                }
            });
            this.f12964w = fVar;
            fVar.start();
            bVar.h(j10);
            bVar.e(g10);
            bVar.e(g3);
            bVar.e(f12);
        }
    }

    public final void I(float f10, float f11) {
        if (A()) {
            q();
            com.cupidapp.live.base.view.zoom.a aVar = new com.cupidapp.live.base.view.zoom.a(f10 / 60.0f, f11 / 60.0f, new Function1<float[], Boolean>() { // from class: com.cupidapp.live.base.view.zoom.ZoomImageView$startFlingAnimation$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull float[] it) {
                    boolean E;
                    s.i(it, "it");
                    E = ZoomImageView.this.E(it[0], it[1]);
                    return Boolean.valueOf(E);
                }
            });
            this.f12965x = aVar;
            aVar.start();
        }
    }

    public final void J(PointF pointF, float f10, float f11, PointF pointF2) {
        if (A()) {
            com.cupidapp.live.base.view.zoom.b bVar = com.cupidapp.live.base.view.zoom.b.f13001a;
            Matrix f12 = bVar.f();
            u(f12);
            if (bVar.c(f12).x > this.f12954m || f11 > this.f12966y) {
                this.f12966y = f11;
                float f13 = f10 * f11;
                Matrix f14 = bVar.f();
                f14.postScale(f13, f13, pointF.x, pointF.y);
                f14.postTranslate(pointF2.x - pointF.x, pointF2.y - pointF.y);
                this.f12960s.set(f14);
                bVar.e(f14);
                invalidate();
            }
            bVar.e(f12);
        }
    }

    public final void K() {
        if (!A()) {
            b bVar = this.f12956o;
            if (bVar != null) {
                bVar.a();
                return;
            }
            return;
        }
        com.cupidapp.live.base.view.zoom.b bVar2 = com.cupidapp.live.base.view.zoom.b.f13001a;
        Matrix f10 = bVar2.f();
        u(f10);
        float p10 = p(bVar2.c(f10).x, bVar2.c(this.f12960s).x);
        boolean z10 = true;
        boolean z11 = !(p10 == 1.0f);
        Matrix g3 = bVar2.g(f10);
        PointF pointF = this.f12961t;
        g3.postScale(p10, p10, pointF.x, pointF.y);
        RectF j10 = bVar2.j(0.0f, 0.0f, getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
        g3.mapRect(j10);
        PointF t2 = t(j10);
        if (t2.x == 0.0f) {
            if (t2.y == 0.0f) {
                z10 = z11;
            }
        }
        if (z10) {
            Matrix g10 = bVar2.g(this.f12960s);
            PointF pointF2 = this.f12961t;
            g10.postScale(p10, p10, pointF2.x, pointF2.y);
            g10.postTranslate(t2.x, t2.y + this.f12959r);
            q();
            f fVar = new f(this.f12960s, g10, new Function1<float[], p>() { // from class: com.cupidapp.live.base.view.zoom.ZoomImageView$startZoomEndAnimation$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(float[] fArr) {
                    invoke2(fArr);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull float[] it) {
                    Matrix matrix;
                    s.i(it, "it");
                    matrix = ZoomImageView.this.f12960s;
                    matrix.setValues(it);
                    ZoomImageView.this.invalidate();
                }
            });
            this.f12964w = fVar;
            fVar.addListener(new e());
            f fVar2 = this.f12964w;
            if (fVar2 != null) {
                fVar2.start();
            }
            bVar2.e(g10);
        } else {
            b bVar3 = this.f12956o;
            if (bVar3 != null) {
                bVar3.a();
            }
        }
        bVar2.h(j10);
        bVar2.e(g3);
        bVar2.e(f10);
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i10) {
        if (this.f12957p == 2) {
            return true;
        }
        RectF v2 = v(null);
        if (v2.isEmpty()) {
            return false;
        }
        if (i10 > 0) {
            if (v2.right > getWidth()) {
                return true;
            }
        } else if (v2.left < 0.0f) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i10) {
        if (this.f12957p == 2) {
            return true;
        }
        RectF v2 = v(null);
        if (v2.isEmpty()) {
            return false;
        }
        if (i10 > 0) {
            if (v2.bottom > getHeight()) {
                return true;
            }
        } else if (v2.top < 0.0f) {
            return true;
        }
        return false;
    }

    @Nullable
    public final Function0<p> getOnSingleClick() {
        return this.f12953l;
    }

    public final float o(float f10) {
        float f11 = f10 < 4.0f ? 4.0f : 1.0f;
        float f12 = f11 <= 4.0f ? f11 : 4.0f;
        if (f12 < 1.0f) {
            return 1.0f;
        }
        return f12;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(@Nullable Canvas canvas) {
        if (this.f12958q.isEmpty()) {
            this.f12958q.set(0, 0, getWidth(), getHeight());
        }
        if (A()) {
            com.cupidapp.live.base.view.zoom.b bVar = com.cupidapp.live.base.view.zoom.b.f13001a;
            Matrix f10 = bVar.f();
            setImageMatrix(u(f10));
            bVar.e(f10);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent motionEvent) {
        if (motionEvent == null) {
            return super.onTouchEvent(motionEvent);
        }
        super.onTouchEvent(motionEvent);
        return y(this, motionEvent, 0, 2, null);
    }

    public final float p(float f10, float f11) {
        ScaleEndType scaleEndType = this.f12955n;
        int i10 = scaleEndType == null ? -1 : c.f12968a[scaleEndType.ordinal()];
        if (i10 == 1) {
            float f12 = 1.0f / f10;
            if (f11 * f12 >= 1.0f) {
                return f12;
            }
        } else {
            if (i10 != 2) {
                return 1.0f;
            }
            if (f11 > 4.0f) {
                return 4.0f / f11;
            }
            if (f11 >= 1.0f) {
                return 1.0f;
            }
        }
        return 1.0f / f11;
    }

    public final void q() {
        f fVar = this.f12964w;
        if (fVar != null) {
            fVar.cancel();
        }
        this.f12964w = null;
        com.cupidapp.live.base.view.zoom.a aVar = this.f12965x;
        if (aVar != null) {
            aVar.cancel();
        }
        this.f12965x = null;
    }

    public final void r(int i10, int i11, int i12, int i13) {
        this.f12958q.set(i10, i11, i12, i13);
    }

    public final void s(@NotNull MotionEvent event, int i10) {
        s.i(event, "event");
        x(event, i10);
    }

    public final void setOnSingleClick(@Nullable Function0<p> function0) {
        this.f12953l = function0;
    }

    public final void setOnTouchUpListener(@NotNull b l10) {
        s.i(l10, "l");
        this.f12956o = l10;
    }

    public final void setScaleEndType(@NotNull ScaleEndType scaleEndType) {
        s.i(scaleEndType, "scaleEndType");
        this.f12955n = scaleEndType;
    }

    @Override // android.widget.ImageView
    public void setScaleType(@Nullable ImageView.ScaleType scaleType) {
    }

    public final void setZoomImageMinScale(float f10) {
        this.f12954m = f10;
    }

    public final PointF t(RectF rectF) {
        PointF pointF = new PointF(0.0f, 0.0f);
        if (rectF.right - rectF.left < this.f12958q.width()) {
            pointF.x = (((this.f12958q.width() - rectF.width()) / 2.0f) + this.f12958q.left) - rectF.left;
        } else {
            float f10 = rectF.left;
            Rect rect = this.f12958q;
            int i10 = rect.left;
            if (f10 > i10) {
                pointF.x = i10 - f10;
            } else {
                float f11 = rectF.right;
                int i11 = rect.right;
                if (f11 < i11) {
                    pointF.x = i11 - f11;
                }
            }
        }
        if (rectF.bottom - rectF.top < this.f12958q.height()) {
            pointF.y = (((this.f12958q.height() - rectF.height()) / 2.0f) + this.f12958q.top) - rectF.top;
        } else {
            float f12 = rectF.top;
            Rect rect2 = this.f12958q;
            int i12 = rect2.top;
            if (f12 > i12) {
                pointF.y = i12 - f12;
            } else {
                float f13 = rectF.bottom;
                int i13 = rect2.bottom;
                if (f13 < i13) {
                    pointF.y = i13 - f13;
                }
            }
        }
        return pointF;
    }

    public final Matrix u(Matrix matrix) {
        Matrix w3 = w(matrix);
        w3.postConcat(this.f12960s);
        return w3;
    }

    @NotNull
    public final RectF v(@Nullable RectF rectF) {
        if (rectF == null) {
            rectF = new RectF();
        } else {
            rectF.setEmpty();
        }
        if (A()) {
            com.cupidapp.live.base.view.zoom.b bVar = com.cupidapp.live.base.view.zoom.b.f13001a;
            Matrix f10 = bVar.f();
            u(f10);
            rectF.set(0.0f, 0.0f, getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
            f10.mapRect(rectF);
            bVar.e(f10);
        }
        return rectF;
    }

    public final Matrix w(Matrix matrix) {
        matrix.reset();
        if (A()) {
            com.cupidapp.live.base.view.zoom.b bVar = com.cupidapp.live.base.view.zoom.b.f13001a;
            RectF j10 = bVar.j(0.0f, 0.0f, getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
            Rect rect = this.f12958q;
            RectF j11 = bVar.j(rect.left, rect.top, rect.right, rect.bottom);
            matrix.setRectToRect(j10, j11, Matrix.ScaleToFit.CENTER);
            float f10 = this.f12959r;
            if (!(f10 == 0.0f)) {
                matrix.postTranslate(0.0f, f10);
            }
            bVar.h(j11);
            bVar.h(j10);
        }
        return matrix;
    }

    public final boolean x(MotionEvent motionEvent, int i10) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action == 5) {
                            com.cupidapp.live.base.utils.j.f12332a.a("ZoomImageView", "MotionEvent.ACTION_POINTER_DOWN");
                            if (motionEvent.getPointerCount() == 2) {
                                q();
                                this.f12957p = 2;
                                float f10 = i10;
                                C(motionEvent.getX(0), motionEvent.getY(0) + f10, motionEvent.getX(1), motionEvent.getY(1) + f10);
                            }
                        } else if (action == 6) {
                            com.cupidapp.live.base.utils.j.f12332a.a("ZoomImageView", "MotionEvent.ACTION_POINTER_UP");
                            if (this.f12957p == 2 && motionEvent.getPointerCount() > 2) {
                                if ((motionEvent.getAction() >> 8) == 0) {
                                    float f11 = i10;
                                    C(motionEvent.getX(1), motionEvent.getY(1) + f11, motionEvent.getX(2), motionEvent.getY(2) + f11);
                                } else if ((motionEvent.getAction() >> 8) == 1) {
                                    float f12 = i10;
                                    C(motionEvent.getX(0), motionEvent.getY(0) + f12, motionEvent.getX(2), motionEvent.getY(2) + f12);
                                }
                            }
                        }
                    }
                } else if (D()) {
                    int i11 = this.f12957p;
                    if (i11 == 1) {
                        E(motionEvent.getX() - this.f12961t.x, motionEvent.getY() - this.f12961t.y);
                        this.f12961t.set(motionEvent.getX(), motionEvent.getY());
                    } else if (i11 == 2 && motionEvent.getPointerCount() > 1) {
                        com.cupidapp.live.base.view.zoom.b bVar = com.cupidapp.live.base.view.zoom.b.f13001a;
                        float f13 = i10;
                        float b4 = bVar.b(motionEvent.getX(0), motionEvent.getY(0) + f13, motionEvent.getX(1), motionEvent.getY(1) + f13);
                        PointF a10 = bVar.a(motionEvent.getX(0), motionEvent.getY(0) + f13, motionEvent.getX(1), motionEvent.getY(1) + f13);
                        this.f12961t.set(a10.x, a10.y);
                        J(this.f12962u, this.f12963v, b4, this.f12961t);
                    }
                }
            }
            com.cupidapp.live.base.utils.j.f12332a.a("ZoomImageView", "MotionEvent.ACTION_UP || MotionEvent.ACTION_CANCEL");
            if (this.f12957p == 2) {
                K();
            }
            this.f12957p = 0;
        } else {
            com.cupidapp.live.base.utils.j.f12332a.a("ZoomImageView", "MotionEvent.ACTION_DOWN");
            if (D() && this.f12957p == 0) {
                q();
                this.f12957p = 1;
                this.f12961t.set(motionEvent.getX(), motionEvent.getY());
            }
        }
        this.f12967z.onTouchEvent(motionEvent);
        return true;
    }

    public final void z() {
        super.setScaleType(ImageView.ScaleType.MATRIX);
        this.f12955n = ScaleEndType.RestoreOriginal;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZoomImageView(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        s.i(context, "context");
        s.i(attrs, "attrs");
        this.A = new LinkedHashMap();
        this.f12954m = 0.9f;
        this.f12958q = new Rect();
        this.f12960s = new Matrix();
        this.f12961t = new PointF();
        this.f12962u = new PointF();
        this.f12967z = new GestureDetector(getContext(), new d());
        z();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZoomImageView(@NotNull Context context, @NotNull AttributeSet attrs, int i10) {
        super(context, attrs, i10);
        s.i(context, "context");
        s.i(attrs, "attrs");
        this.A = new LinkedHashMap();
        this.f12954m = 0.9f;
        this.f12958q = new Rect();
        this.f12960s = new Matrix();
        this.f12961t = new PointF();
        this.f12962u = new PointF();
        this.f12967z = new GestureDetector(getContext(), new d());
        z();
    }
}
