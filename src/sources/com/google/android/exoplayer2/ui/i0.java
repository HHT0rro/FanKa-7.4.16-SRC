package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.Nullable;

/* compiled from: SubtitlePainter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class i0 {
    public int A;
    public int B;
    public int C;
    public int D;
    public StaticLayout E;
    public StaticLayout F;
    public int G;
    public int H;
    public int I;
    public Rect J;

    /* renamed from: a, reason: collision with root package name */
    public final float f22655a;

    /* renamed from: b, reason: collision with root package name */
    public final float f22656b;

    /* renamed from: c, reason: collision with root package name */
    public final float f22657c;

    /* renamed from: d, reason: collision with root package name */
    public final float f22658d;

    /* renamed from: e, reason: collision with root package name */
    public final float f22659e;

    /* renamed from: f, reason: collision with root package name */
    public final TextPaint f22660f;

    /* renamed from: g, reason: collision with root package name */
    public final Paint f22661g;

    /* renamed from: h, reason: collision with root package name */
    public final Paint f22662h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public CharSequence f22663i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public Layout.Alignment f22664j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public Bitmap f22665k;

    /* renamed from: l, reason: collision with root package name */
    public float f22666l;

    /* renamed from: m, reason: collision with root package name */
    public int f22667m;

    /* renamed from: n, reason: collision with root package name */
    public int f22668n;

    /* renamed from: o, reason: collision with root package name */
    public float f22669o;

    /* renamed from: p, reason: collision with root package name */
    public int f22670p;

    /* renamed from: q, reason: collision with root package name */
    public float f22671q;

    /* renamed from: r, reason: collision with root package name */
    public float f22672r;

    /* renamed from: s, reason: collision with root package name */
    public int f22673s;

    /* renamed from: t, reason: collision with root package name */
    public int f22674t;

    /* renamed from: u, reason: collision with root package name */
    public int f22675u;

    /* renamed from: v, reason: collision with root package name */
    public int f22676v;

    /* renamed from: w, reason: collision with root package name */
    public int f22677w;

    /* renamed from: x, reason: collision with root package name */
    public float f22678x;

    /* renamed from: y, reason: collision with root package name */
    public float f22679y;

    /* renamed from: z, reason: collision with root package name */
    public float f22680z;

    public i0(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{16843287, 16843288}, 0, 0);
        this.f22659e = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f22658d = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
        float round = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.f22655a = round;
        this.f22656b = round;
        this.f22657c = round;
        TextPaint textPaint = new TextPaint();
        this.f22660f = textPaint;
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        Paint paint = new Paint();
        this.f22661g = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f22662h = paint2;
        paint2.setAntiAlias(true);
        paint2.setFilterBitmap(true);
    }

    public static boolean a(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        return charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2));
    }

    public void b(e6.a aVar, c cVar, float f10, float f11, float f12, Canvas canvas, int i10, int i11, int i12, int i13) {
        boolean z10 = aVar.f48887d == null;
        int i14 = -16777216;
        if (z10) {
            if (TextUtils.isEmpty(aVar.f48884a)) {
                return;
            } else {
                i14 = aVar.f48895l ? aVar.f48896m : cVar.f22603c;
            }
        }
        if (a(this.f22663i, aVar.f48884a) && com.google.android.exoplayer2.util.j0.c(this.f22664j, aVar.f48885b) && this.f22665k == aVar.f48887d && this.f22666l == aVar.f48888e && this.f22667m == aVar.f48889f && com.google.android.exoplayer2.util.j0.c(Integer.valueOf(this.f22668n), Integer.valueOf(aVar.f48890g)) && this.f22669o == aVar.f48891h && com.google.android.exoplayer2.util.j0.c(Integer.valueOf(this.f22670p), Integer.valueOf(aVar.f48892i)) && this.f22671q == aVar.f48893j && this.f22672r == aVar.f48894k && this.f22673s == cVar.f22601a && this.f22674t == cVar.f22602b && this.f22675u == i14 && this.f22677w == cVar.f22604d && this.f22676v == cVar.f22605e && com.google.android.exoplayer2.util.j0.c(this.f22660f.getTypeface(), cVar.f22606f) && this.f22678x == f10 && this.f22679y == f11 && this.f22680z == f12 && this.A == i10 && this.B == i11 && this.C == i12 && this.D == i13) {
            d(canvas, z10);
            return;
        }
        this.f22663i = aVar.f48884a;
        this.f22664j = aVar.f48885b;
        this.f22665k = aVar.f48887d;
        this.f22666l = aVar.f48888e;
        this.f22667m = aVar.f48889f;
        this.f22668n = aVar.f48890g;
        this.f22669o = aVar.f48891h;
        this.f22670p = aVar.f48892i;
        this.f22671q = aVar.f48893j;
        this.f22672r = aVar.f48894k;
        this.f22673s = cVar.f22601a;
        this.f22674t = cVar.f22602b;
        this.f22675u = i14;
        this.f22677w = cVar.f22604d;
        this.f22676v = cVar.f22605e;
        this.f22660f.setTypeface(cVar.f22606f);
        this.f22678x = f10;
        this.f22679y = f11;
        this.f22680z = f12;
        this.A = i10;
        this.B = i11;
        this.C = i12;
        this.D = i13;
        if (z10) {
            com.google.android.exoplayer2.util.a.e(this.f22663i);
            g();
        } else {
            com.google.android.exoplayer2.util.a.e(this.f22665k);
            f();
        }
        d(canvas, z10);
    }

    public final void c(Canvas canvas) {
        canvas.drawBitmap(this.f22665k, (Rect) null, this.J, this.f22662h);
    }

    public final void d(Canvas canvas, boolean z10) {
        if (z10) {
            e(canvas);
            return;
        }
        com.google.android.exoplayer2.util.a.e(this.J);
        com.google.android.exoplayer2.util.a.e(this.f22665k);
        c(canvas);
    }

    public final void e(Canvas canvas) {
        StaticLayout staticLayout = this.E;
        StaticLayout staticLayout2 = this.F;
        if (staticLayout == null || staticLayout2 == null) {
            return;
        }
        int save = canvas.save();
        canvas.translate(this.G, this.H);
        if (Color.alpha(this.f22675u) > 0) {
            this.f22661g.setColor(this.f22675u);
            canvas.drawRect(-this.I, 0.0f, staticLayout.getWidth() + this.I, staticLayout.getHeight(), this.f22661g);
        }
        int i10 = this.f22677w;
        if (i10 == 1) {
            this.f22660f.setStrokeJoin(Paint.Join.ROUND);
            this.f22660f.setStrokeWidth(this.f22655a);
            this.f22660f.setColor(this.f22676v);
            this.f22660f.setStyle(Paint.Style.FILL_AND_STROKE);
            staticLayout2.draw(canvas);
        } else if (i10 == 2) {
            TextPaint textPaint = this.f22660f;
            float f10 = this.f22656b;
            float f11 = this.f22657c;
            textPaint.setShadowLayer(f10, f11, f11, this.f22676v);
        } else if (i10 == 3 || i10 == 4) {
            boolean z10 = i10 == 3;
            int i11 = z10 ? -1 : this.f22676v;
            int i12 = z10 ? this.f22676v : -1;
            float f12 = this.f22656b / 2.0f;
            this.f22660f.setColor(this.f22673s);
            this.f22660f.setStyle(Paint.Style.FILL);
            float f13 = -f12;
            this.f22660f.setShadowLayer(this.f22656b, f13, f13, i11);
            staticLayout2.draw(canvas);
            this.f22660f.setShadowLayer(this.f22656b, f12, f12, i12);
        }
        this.f22660f.setColor(this.f22673s);
        this.f22660f.setStyle(Paint.Style.FILL);
        staticLayout.draw(canvas);
        this.f22660f.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        canvas.restoreToCount(save);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void f() {
        /*
            r7 = this;
            android.graphics.Bitmap r0 = r7.f22665k
            int r1 = r7.C
            int r2 = r7.A
            int r1 = r1 - r2
            int r3 = r7.D
            int r4 = r7.B
            int r3 = r3 - r4
            float r2 = (float) r2
            float r1 = (float) r1
            float r5 = r7.f22669o
            float r5 = r5 * r1
            float r2 = r2 + r5
            float r4 = (float) r4
            float r3 = (float) r3
            float r5 = r7.f22666l
            float r5 = r5 * r3
            float r4 = r4 + r5
            float r5 = r7.f22671q
            float r1 = r1 * r5
            int r1 = java.lang.Math.round(r1)
            float r5 = r7.f22672r
            r6 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r6 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r6 == 0) goto L32
            float r3 = r3 * r5
            int r0 = java.lang.Math.round(r3)
            goto L44
        L32:
            float r3 = (float) r1
            int r5 = r0.getHeight()
            float r5 = (float) r5
            int r0 = r0.getWidth()
            float r0 = (float) r0
            float r5 = r5 / r0
            float r3 = r3 * r5
            int r0 = java.lang.Math.round(r3)
        L44:
            int r3 = r7.f22670p
            r5 = 1
            r6 = 2
            if (r3 != r6) goto L4d
            float r3 = (float) r1
        L4b:
            float r2 = r2 - r3
            goto L53
        L4d:
            if (r3 != r5) goto L53
            int r3 = r1 / 2
            float r3 = (float) r3
            goto L4b
        L53:
            int r2 = java.lang.Math.round(r2)
            int r3 = r7.f22668n
            if (r3 != r6) goto L5e
            float r3 = (float) r0
        L5c:
            float r4 = r4 - r3
            goto L64
        L5e:
            if (r3 != r5) goto L64
            int r3 = r0 / 2
            float r3 = (float) r3
            goto L5c
        L64:
            int r3 = java.lang.Math.round(r4)
            android.graphics.Rect r4 = new android.graphics.Rect
            int r1 = r1 + r2
            int r0 = r0 + r3
            r4.<init>(r2, r3, r1, r0)
            r7.J = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.i0.f():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void g() {
        /*
            Method dump skipped, instructions count: 495
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.i0.g():void");
    }
}
