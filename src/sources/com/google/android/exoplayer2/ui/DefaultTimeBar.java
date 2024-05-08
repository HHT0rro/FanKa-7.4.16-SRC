package com.google.android.exoplayer2.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.ui.m0;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class DefaultTimeBar extends View implements m0 {
    public final float A;
    public int B;
    public long C;
    public int D;
    public Rect E;
    public ValueAnimator F;
    public float G;
    public boolean H;
    public boolean I;
    public long J;
    public long K;
    public long L;
    public long M;
    public int N;

    @Nullable
    public long[] O;

    @Nullable
    public boolean[] P;

    /* renamed from: b, reason: collision with root package name */
    public final Rect f22367b;

    /* renamed from: c, reason: collision with root package name */
    public final Rect f22368c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f22369d;

    /* renamed from: e, reason: collision with root package name */
    public final Rect f22370e;

    /* renamed from: f, reason: collision with root package name */
    public final Paint f22371f;

    /* renamed from: g, reason: collision with root package name */
    public final Paint f22372g;

    /* renamed from: h, reason: collision with root package name */
    public final Paint f22373h;

    /* renamed from: i, reason: collision with root package name */
    public final Paint f22374i;

    /* renamed from: j, reason: collision with root package name */
    public final Paint f22375j;

    /* renamed from: k, reason: collision with root package name */
    public final Paint f22376k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public final Drawable f22377l;

    /* renamed from: m, reason: collision with root package name */
    public final int f22378m;

    /* renamed from: n, reason: collision with root package name */
    public final int f22379n;

    /* renamed from: o, reason: collision with root package name */
    public final int f22380o;

    /* renamed from: p, reason: collision with root package name */
    public final int f22381p;

    /* renamed from: q, reason: collision with root package name */
    public final int f22382q;

    /* renamed from: r, reason: collision with root package name */
    public final int f22383r;

    /* renamed from: s, reason: collision with root package name */
    public final int f22384s;

    /* renamed from: t, reason: collision with root package name */
    public final int f22385t;

    /* renamed from: u, reason: collision with root package name */
    public final int f22386u;

    /* renamed from: v, reason: collision with root package name */
    public final StringBuilder f22387v;

    /* renamed from: w, reason: collision with root package name */
    public final Formatter f22388w;

    /* renamed from: x, reason: collision with root package name */
    public final Runnable f22389x;

    /* renamed from: y, reason: collision with root package name */
    public final CopyOnWriteArraySet<m0.a> f22390y;

    /* renamed from: z, reason: collision with root package name */
    public final Point f22391z;

    public DefaultTimeBar(Context context) {
        this(context, null);
    }

    public static int d(float f10, int i10) {
        return (int) ((i10 * f10) + 0.5f);
    }

    private long getPositionIncrement() {
        long j10 = this.C;
        if (j10 != -9223372036854775807L) {
            return j10;
        }
        long j11 = this.K;
        if (j11 == -9223372036854775807L) {
            return 0L;
        }
        return j11 / this.B;
    }

    private String getProgressText() {
        return com.google.android.exoplayer2.util.j0.d0(this.f22387v, this.f22388w, this.L);
    }

    private long getScrubberPosition() {
        if (this.f22368c.width() <= 0 || this.K == -9223372036854775807L) {
            return 0L;
        }
        return (this.f22370e.width() * this.K) / this.f22368c.width();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        v(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(ValueAnimator valueAnimator) {
        this.G = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate(this.f22367b);
    }

    public static int m(float f10, int i10) {
        return (int) (i10 / f10);
    }

    public static boolean q(Drawable drawable, int i10) {
        return com.google.android.exoplayer2.util.j0.f22990a >= 23 && drawable.setLayoutDirection(i10);
    }

    @Override // com.google.android.exoplayer2.ui.m0
    public void a(m0.a aVar) {
        com.google.android.exoplayer2.util.a.e(aVar);
        this.f22390y.add(aVar);
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        x();
    }

    public final void e(Canvas canvas) {
        int i10;
        if (this.K <= 0) {
            return;
        }
        Rect rect = this.f22370e;
        int r10 = com.google.android.exoplayer2.util.j0.r(rect.right, rect.left, this.f22368c.right);
        int centerY = this.f22370e.centerY();
        if (this.f22377l == null) {
            if (!this.I && !isFocused()) {
                i10 = isEnabled() ? this.f22382q : this.f22383r;
            } else {
                i10 = this.f22384s;
            }
            canvas.drawCircle(r10, centerY, (int) ((i10 * this.G) / 2.0f), this.f22376k);
            return;
        }
        int intrinsicWidth = ((int) (r2.getIntrinsicWidth() * this.G)) / 2;
        int intrinsicHeight = ((int) (this.f22377l.getIntrinsicHeight() * this.G)) / 2;
        this.f22377l.setBounds(r10 - intrinsicWidth, centerY - intrinsicHeight, r10 + intrinsicWidth, centerY + intrinsicHeight);
        this.f22377l.draw(canvas);
    }

    public final void f(Canvas canvas) {
        int height = this.f22368c.height();
        int centerY = this.f22368c.centerY() - (height / 2);
        int i10 = height + centerY;
        if (this.K <= 0) {
            Rect rect = this.f22368c;
            canvas.drawRect(rect.left, centerY, rect.right, i10, this.f22373h);
            return;
        }
        Rect rect2 = this.f22369d;
        int i11 = rect2.left;
        int i12 = rect2.right;
        int max = Math.max(Math.max(this.f22368c.left, i12), this.f22370e.right);
        int i13 = this.f22368c.right;
        if (max < i13) {
            canvas.drawRect(max, centerY, i13, i10, this.f22373h);
        }
        int max2 = Math.max(i11, this.f22370e.right);
        if (i12 > max2) {
            canvas.drawRect(max2, centerY, i12, i10, this.f22372g);
        }
        if (this.f22370e.width() > 0) {
            Rect rect3 = this.f22370e;
            canvas.drawRect(rect3.left, centerY, rect3.right, i10, this.f22371f);
        }
        if (this.N == 0) {
            return;
        }
        long[] jArr = (long[]) com.google.android.exoplayer2.util.a.e(this.O);
        boolean[] zArr = (boolean[]) com.google.android.exoplayer2.util.a.e(this.P);
        int i14 = this.f22381p / 2;
        for (int i15 = 0; i15 < this.N; i15++) {
            int width = ((int) ((this.f22368c.width() * com.google.android.exoplayer2.util.j0.s(jArr[i15], 0L, this.K)) / this.K)) - i14;
            Rect rect4 = this.f22368c;
            canvas.drawRect(rect4.left + Math.min(rect4.width() - this.f22381p, Math.max(0, width)), centerY, r10 + this.f22381p, i10, zArr[i15] ? this.f22375j : this.f22374i);
        }
    }

    public void g(long j10) {
        if (this.F.isStarted()) {
            this.F.cancel();
        }
        this.F.setFloatValues(this.G, 0.0f);
        this.F.setDuration(j10);
        this.F.start();
    }

    @Override // com.google.android.exoplayer2.ui.m0
    public long getPreferredUpdateDelay() {
        int m10 = m(this.A, this.f22368c.width());
        if (m10 != 0) {
            long j10 = this.K;
            if (j10 != 0 && j10 != -9223372036854775807L) {
                return j10 / m10;
            }
        }
        return Long.MAX_VALUE;
    }

    public void h(boolean z10) {
        if (this.F.isStarted()) {
            this.F.cancel();
        }
        this.H = z10;
        this.G = 0.0f;
        invalidate(this.f22367b);
    }

    public final boolean i(float f10, float f11) {
        return this.f22367b.contains((int) f10, (int) f11);
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f22377l;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public final void l(float f10) {
        Rect rect = this.f22370e;
        Rect rect2 = this.f22368c;
        rect.right = com.google.android.exoplayer2.util.j0.r((int) f10, rect2.left, rect2.right);
    }

    public final Point n(MotionEvent motionEvent) {
        this.f22391z.set((int) motionEvent.getX(), (int) motionEvent.getY());
        return this.f22391z;
    }

    public final boolean o(long j10) {
        long j11 = this.K;
        if (j11 <= 0) {
            return false;
        }
        long j12 = this.I ? this.J : this.L;
        long s2 = com.google.android.exoplayer2.util.j0.s(j12 + j10, 0L, j11);
        if (s2 == j12) {
            return false;
        }
        if (!this.I) {
            u(s2);
        } else {
            y(s2);
        }
        w();
        return true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.save();
        f(canvas);
        e(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z10, int i10, @Nullable Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        if (!this.I || z10) {
            return;
        }
        v(false);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4) {
            accessibilityEvent.getText().add(getProgressText());
        }
        accessibilityEvent.setClassName("android.widget.SeekBar");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.SeekBar");
        accessibilityNodeInfo.setContentDescription(getProgressText());
        if (this.K <= 0) {
            return;
        }
        if (com.google.android.exoplayer2.util.j0.f22990a >= 21) {
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
        } else {
            accessibilityNodeInfo.addAction(4096);
            accessibilityNodeInfo.addAction(8192);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x000f. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    @Override // android.view.View, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onKeyDown(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            boolean r0 = r4.isEnabled()
            if (r0 == 0) goto L30
            long r0 = r4.getPositionIncrement()
            r2 = 66
            r3 = 1
            if (r5 == r2) goto L27
            switch(r5) {
                case 21: goto L13;
                case 22: goto L14;
                case 23: goto L27;
                default: goto L12;
            }
        L12:
            goto L30
        L13:
            long r0 = -r0
        L14:
            boolean r0 = r4.o(r0)
            if (r0 == 0) goto L30
            java.lang.Runnable r5 = r4.f22389x
            r4.removeCallbacks(r5)
            java.lang.Runnable r5 = r4.f22389x
            r0 = 1000(0x3e8, double:4.94E-321)
            r4.postDelayed(r5, r0)
            return r3
        L27:
            boolean r0 = r4.I
            if (r0 == 0) goto L30
            r5 = 0
            r4.v(r5)
            return r3
        L30:
            boolean r5 = super.onKeyDown(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.DefaultTimeBar.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16 = i12 - i10;
        int i17 = i13 - i11;
        int paddingLeft = getPaddingLeft();
        int paddingRight = i16 - getPaddingRight();
        int i18 = this.H ? 0 : this.f22385t;
        if (this.f22380o == 1) {
            i14 = (i17 - getPaddingBottom()) - this.f22379n;
            int paddingBottom = i17 - getPaddingBottom();
            int i19 = this.f22378m;
            i15 = (paddingBottom - i19) - Math.max(i18 - (i19 / 2), 0);
        } else {
            i14 = (i17 - this.f22379n) / 2;
            i15 = (i17 - this.f22378m) / 2;
        }
        this.f22367b.set(paddingLeft, i14, paddingRight, this.f22379n + i14);
        Rect rect = this.f22368c;
        Rect rect2 = this.f22367b;
        rect.set(rect2.left + i18, i15, rect2.right - i18, this.f22378m + i15);
        if (com.google.android.exoplayer2.util.j0.f22990a >= 29) {
            r(i16, i17);
        }
        w();
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        if (mode == 0) {
            size = this.f22379n;
        } else if (mode != 1073741824) {
            size = Math.min(this.f22379n, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i10), size);
        x();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i10) {
        Drawable drawable = this.f22377l;
        if (drawable == null || !q(drawable, i10)) {
            return;
        }
        invalidate();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0025, code lost:
    
        if (r3 != 3) goto L34;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            boolean r0 = r7.isEnabled()
            r1 = 0
            if (r0 == 0) goto L76
            long r2 = r7.K
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 > 0) goto L10
            goto L76
        L10:
            android.graphics.Point r0 = r7.n(r8)
            int r2 = r0.x
            int r0 = r0.y
            int r3 = r8.getAction()
            r4 = 1
            if (r3 == 0) goto L5d
            r5 = 3
            if (r3 == r4) goto L4e
            r6 = 2
            if (r3 == r6) goto L28
            if (r3 == r5) goto L4e
            goto L76
        L28:
            boolean r8 = r7.I
            if (r8 == 0) goto L76
            int r8 = r7.f22386u
            if (r0 >= r8) goto L3a
            int r8 = r7.D
            int r2 = r2 - r8
            int r2 = r2 / r5
            int r8 = r8 + r2
            float r8 = (float) r8
            r7.l(r8)
            goto L40
        L3a:
            r7.D = r2
            float r8 = (float) r2
            r7.l(r8)
        L40:
            long r0 = r7.getScrubberPosition()
            r7.y(r0)
            r7.w()
            r7.invalidate()
            return r4
        L4e:
            boolean r0 = r7.I
            if (r0 == 0) goto L76
            int r8 = r8.getAction()
            if (r8 != r5) goto L59
            r1 = 1
        L59:
            r7.v(r1)
            return r4
        L5d:
            float r8 = (float) r2
            float r0 = (float) r0
            boolean r0 = r7.i(r8, r0)
            if (r0 == 0) goto L76
            r7.l(r8)
            long r0 = r7.getScrubberPosition()
            r7.u(r0)
            r7.w()
            r7.invalidate()
            return r4
        L76:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.DefaultTimeBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final boolean p(Drawable drawable) {
        return com.google.android.exoplayer2.util.j0.f22990a >= 23 && q(drawable, getLayoutDirection());
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i10, @Nullable Bundle bundle) {
        if (super.performAccessibilityAction(i10, bundle)) {
            return true;
        }
        if (this.K <= 0) {
            return false;
        }
        if (i10 == 8192) {
            if (o(-getPositionIncrement())) {
                v(false);
            }
        } else {
            if (i10 != 4096) {
                return false;
            }
            if (o(getPositionIncrement())) {
                v(false);
            }
        }
        sendAccessibilityEvent(4);
        return true;
    }

    @RequiresApi(29)
    public final void r(int i10, int i11) {
        Rect rect = this.E;
        if (rect != null && rect.width() == i10 && this.E.height() == i11) {
            return;
        }
        Rect rect2 = new Rect(0, 0, i10, i11);
        this.E = rect2;
        setSystemGestureExclusionRects(Collections.singletonList(rect2));
    }

    public void s() {
        if (this.F.isStarted()) {
            this.F.cancel();
        }
        this.H = false;
        this.G = 1.0f;
        invalidate(this.f22367b);
    }

    @Override // com.google.android.exoplayer2.ui.m0
    public void setAdGroupTimesMs(@Nullable long[] jArr, @Nullable boolean[] zArr, int i10) {
        com.google.android.exoplayer2.util.a.a(i10 == 0 || !(jArr == null || zArr == null));
        this.N = i10;
        this.O = jArr;
        this.P = zArr;
        w();
    }

    public void setAdMarkerColor(@ColorInt int i10) {
        this.f22374i.setColor(i10);
        invalidate(this.f22367b);
    }

    public void setBufferedColor(@ColorInt int i10) {
        this.f22372g.setColor(i10);
        invalidate(this.f22367b);
    }

    @Override // com.google.android.exoplayer2.ui.m0
    public void setBufferedPosition(long j10) {
        if (this.M == j10) {
            return;
        }
        this.M = j10;
        w();
    }

    @Override // com.google.android.exoplayer2.ui.m0
    public void setDuration(long j10) {
        if (this.K == j10) {
            return;
        }
        this.K = j10;
        if (this.I && j10 == -9223372036854775807L) {
            v(true);
        }
        w();
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        if (!this.I || z10) {
            return;
        }
        v(true);
    }

    public void setKeyCountIncrement(int i10) {
        com.google.android.exoplayer2.util.a.a(i10 > 0);
        this.B = i10;
        this.C = -9223372036854775807L;
    }

    public void setKeyTimeIncrement(long j10) {
        com.google.android.exoplayer2.util.a.a(j10 > 0);
        this.B = -1;
        this.C = j10;
    }

    public void setPlayedAdMarkerColor(@ColorInt int i10) {
        this.f22375j.setColor(i10);
        invalidate(this.f22367b);
    }

    public void setPlayedColor(@ColorInt int i10) {
        this.f22371f.setColor(i10);
        invalidate(this.f22367b);
    }

    @Override // com.google.android.exoplayer2.ui.m0
    public void setPosition(long j10) {
        if (this.L == j10) {
            return;
        }
        this.L = j10;
        setContentDescription(getProgressText());
        w();
    }

    public void setScrubberColor(@ColorInt int i10) {
        this.f22376k.setColor(i10);
        invalidate(this.f22367b);
    }

    public void setUnplayedColor(@ColorInt int i10) {
        this.f22373h.setColor(i10);
        invalidate(this.f22367b);
    }

    public void t(long j10) {
        if (this.F.isStarted()) {
            this.F.cancel();
        }
        this.H = false;
        this.F.setFloatValues(this.G, 1.0f);
        this.F.setDuration(j10);
        this.F.start();
    }

    public final void u(long j10) {
        this.J = j10;
        this.I = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator<m0.a> iterator2 = this.f22390y.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().c(this, j10);
        }
    }

    public final void v(boolean z10) {
        removeCallbacks(this.f22389x);
        this.I = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator<m0.a> iterator2 = this.f22390y.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().a(this, this.J, z10);
        }
    }

    public final void w() {
        this.f22369d.set(this.f22368c);
        this.f22370e.set(this.f22368c);
        long j10 = this.I ? this.J : this.L;
        if (this.K > 0) {
            int width = (int) ((this.f22368c.width() * this.M) / this.K);
            Rect rect = this.f22369d;
            Rect rect2 = this.f22368c;
            rect.right = Math.min(rect2.left + width, rect2.right);
            int width2 = (int) ((this.f22368c.width() * j10) / this.K);
            Rect rect3 = this.f22370e;
            Rect rect4 = this.f22368c;
            rect3.right = Math.min(rect4.left + width2, rect4.right);
        } else {
            Rect rect5 = this.f22369d;
            int i10 = this.f22368c.left;
            rect5.right = i10;
            this.f22370e.right = i10;
        }
        invalidate(this.f22367b);
    }

    public final void x() {
        Drawable drawable = this.f22377l;
        if (drawable != null && drawable.isStateful() && this.f22377l.setState(getDrawableState())) {
            invalidate();
        }
    }

    public final void y(long j10) {
        if (this.J == j10) {
            return;
        }
        this.J = j10;
        Iterator<m0.a> iterator2 = this.f22390y.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().b(this, j10);
        }
    }

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, attributeSet);
    }

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet, int i10, @Nullable AttributeSet attributeSet2) {
        this(context, attributeSet, i10, attributeSet2, 0);
    }

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet, int i10, @Nullable AttributeSet attributeSet2, int i11) {
        super(context, attributeSet, i10);
        this.f22367b = new Rect();
        this.f22368c = new Rect();
        this.f22369d = new Rect();
        this.f22370e = new Rect();
        Paint paint = new Paint();
        this.f22371f = paint;
        Paint paint2 = new Paint();
        this.f22372g = paint2;
        Paint paint3 = new Paint();
        this.f22373h = paint3;
        Paint paint4 = new Paint();
        this.f22374i = paint4;
        Paint paint5 = new Paint();
        this.f22375j = paint5;
        Paint paint6 = new Paint();
        this.f22376k = paint6;
        paint6.setAntiAlias(true);
        this.f22390y = new CopyOnWriteArraySet<>();
        this.f22391z = new Point();
        float f10 = context.getResources().getDisplayMetrics().density;
        this.A = f10;
        this.f22386u = d(f10, -50);
        int d10 = d(f10, 4);
        int d11 = d(f10, 26);
        int d12 = d(f10, 4);
        int d13 = d(f10, 12);
        int d14 = d(f10, 0);
        int d15 = d(f10, 16);
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R$styleable.DefaultTimeBar, i10, i11);
            try {
                Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.DefaultTimeBar_scrubber_drawable);
                this.f22377l = drawable;
                if (drawable != null) {
                    p(drawable);
                    d11 = Math.max(drawable.getMinimumHeight(), d11);
                }
                this.f22378m = obtainStyledAttributes.getDimensionPixelSize(R$styleable.DefaultTimeBar_bar_height, d10);
                this.f22379n = obtainStyledAttributes.getDimensionPixelSize(R$styleable.DefaultTimeBar_touch_target_height, d11);
                this.f22380o = obtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_bar_gravity, 0);
                this.f22381p = obtainStyledAttributes.getDimensionPixelSize(R$styleable.DefaultTimeBar_ad_marker_width, d12);
                this.f22382q = obtainStyledAttributes.getDimensionPixelSize(R$styleable.DefaultTimeBar_scrubber_enabled_size, d13);
                this.f22383r = obtainStyledAttributes.getDimensionPixelSize(R$styleable.DefaultTimeBar_scrubber_disabled_size, d14);
                this.f22384s = obtainStyledAttributes.getDimensionPixelSize(R$styleable.DefaultTimeBar_scrubber_dragged_size, d15);
                int i12 = obtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_played_color, -1);
                int i13 = obtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_scrubber_color, -1);
                int i14 = obtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_buffered_color, -855638017);
                int i15 = obtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_unplayed_color, 872415231);
                int i16 = obtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_ad_marker_color, -1291845888);
                int i17 = obtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_played_ad_marker_color, 872414976);
                paint.setColor(i12);
                paint6.setColor(i13);
                paint2.setColor(i14);
                paint3.setColor(i15);
                paint4.setColor(i16);
                paint5.setColor(i17);
            } finally {
                obtainStyledAttributes.recycle();
            }
        } else {
            this.f22378m = d10;
            this.f22379n = d11;
            this.f22380o = 0;
            this.f22381p = d12;
            this.f22382q = d13;
            this.f22383r = d14;
            this.f22384s = d15;
            paint.setColor(-1);
            paint6.setColor(-1);
            paint2.setColor(-855638017);
            paint3.setColor(872415231);
            paint4.setColor(-1291845888);
            paint5.setColor(872414976);
            this.f22377l = null;
        }
        StringBuilder sb2 = new StringBuilder();
        this.f22387v = sb2;
        this.f22388w = new Formatter(sb2, Locale.getDefault());
        this.f22389x = new Runnable() { // from class: com.google.android.exoplayer2.ui.e
            @Override // java.lang.Runnable
            public final void run() {
                DefaultTimeBar.this.j();
            }
        };
        Drawable drawable2 = this.f22377l;
        if (drawable2 != null) {
            this.f22385t = (drawable2.getMinimumWidth() + 1) / 2;
        } else {
            this.f22385t = (Math.max(this.f22383r, Math.max(this.f22382q, this.f22384s)) + 1) / 2;
        }
        this.G = 1.0f;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.F = valueAnimator;
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.exoplayer2.ui.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                DefaultTimeBar.this.k(valueAnimator2);
            }
        });
        this.K = -9223372036854775807L;
        this.C = -9223372036854775807L;
        this.B = 20;
        setFocusable(true);
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }
}
