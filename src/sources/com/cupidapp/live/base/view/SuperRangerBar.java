package com.cupidapp.live.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.ColorInt;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$styleable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class SuperRangerBar extends View {
    public Bitmap A;
    public Matrix B;
    public Matrix C;
    public b D;
    public int E;
    public int F;
    public int G;
    public View.OnTouchListener H;

    /* renamed from: b, reason: collision with root package name */
    public int f12562b;

    /* renamed from: c, reason: collision with root package name */
    public int f12563c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f12564d;

    /* renamed from: e, reason: collision with root package name */
    public Paint f12565e;

    /* renamed from: f, reason: collision with root package name */
    public Paint f12566f;

    /* renamed from: g, reason: collision with root package name */
    public Paint f12567g;

    /* renamed from: h, reason: collision with root package name */
    public RectF f12568h;

    /* renamed from: i, reason: collision with root package name */
    public RectF f12569i;

    /* renamed from: j, reason: collision with root package name */
    public int f12570j;

    /* renamed from: k, reason: collision with root package name */
    public float f12571k;

    /* renamed from: l, reason: collision with root package name */
    public float f12572l;

    /* renamed from: m, reason: collision with root package name */
    public float f12573m;

    /* renamed from: n, reason: collision with root package name */
    public float f12574n;

    /* renamed from: o, reason: collision with root package name */
    public float f12575o;

    /* renamed from: p, reason: collision with root package name */
    public float f12576p;

    /* renamed from: q, reason: collision with root package name */
    public float f12577q;

    /* renamed from: r, reason: collision with root package name */
    public float f12578r;

    /* renamed from: s, reason: collision with root package name */
    public float f12579s;

    /* renamed from: t, reason: collision with root package name */
    public float f12580t;

    /* renamed from: u, reason: collision with root package name */
    public int f12581u;

    /* renamed from: v, reason: collision with root package name */
    public float f12582v;

    /* renamed from: w, reason: collision with root package name */
    public float f12583w;

    /* renamed from: x, reason: collision with root package name */
    public int f12584x;

    /* renamed from: y, reason: collision with root package name */
    public int f12585y;

    /* renamed from: z, reason: collision with root package name */
    public Bitmap f12586z;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class b {
        public void a(Boolean bool, MotionEvent motionEvent) {
        }

        public void b(int i10, int i11) {
        }

        public void c() {
        }

        public void d() {
        }

        public void e(int i10, int i11, boolean z10, boolean z11) {
            throw null;
        }
    }

    public SuperRangerBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f12564d = true;
        this.E = 3;
        this.H = new a();
        g(context, attributeSet);
    }

    public final float a(MotionEvent motionEvent) {
        float x10 = motionEvent.getX() - this.f12571k;
        this.f12571k = motionEvent.getX();
        return x10;
    }

    public final void b(MotionEvent motionEvent) {
        float a10 = a(motionEvent);
        int i10 = this.E;
        if (i10 == 1) {
            float f10 = this.f12574n + a10;
            int i11 = this.f12563c;
            float f11 = this.f12572l;
            if (f10 > i11 - f11) {
                this.f12574n = i11 - f11;
            } else if ((f10 - this.A.getWidth()) - this.f12582v > this.f12573m + this.f12586z.getWidth()) {
                this.f12574n = f10;
            }
        } else if (i10 == 2) {
            float f12 = this.f12573m + a10;
            float f13 = this.f12572l;
            if (f12 < f13) {
                this.f12573m = f13;
            } else if (this.f12586z.getWidth() + f12 + this.f12582v < this.f12574n - this.A.getWidth()) {
                this.f12573m = f12;
            }
        }
        c();
    }

    public final void c() {
        float width = ((this.f12573m + this.f12586z.getWidth()) - (this.f12575o + this.f12586z.getWidth())) / this.f12582v;
        float width2 = ((this.f12574n - this.A.getWidth()) - (this.f12575o + this.f12586z.getWidth())) / this.f12582v;
        this.f12584x = Math.round(width);
        int round = Math.round(width2);
        this.f12585y = round;
        b bVar = this.D;
        if (bVar != null) {
            bVar.b(this.f12584x, round);
            b bVar2 = this.D;
            int i10 = this.G;
            int i11 = this.f12584x;
            int i12 = i10 + i11;
            int i13 = this.f12585y;
            bVar2.e(i12, i10 + i13, i11 == 0, i10 + i13 == this.F);
        }
    }

    public void d(int i10, int i11, int i12) {
        setScale(i10, i11, i12);
        requestLayout();
        invalidate();
    }

    public final int e(MotionEvent motionEvent) {
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        if (y10 >= this.f12569i.bottom + (this.f12586z.getHeight() / 2) || y10 <= this.f12569i.top - (this.f12586z.getHeight() / 2)) {
            return 3;
        }
        if (x10 < this.f12569i.left + this.f12586z.getWidth() && x10 > this.f12569i.left) {
            return 2;
        }
        float f10 = this.f12569i.right;
        return (x10 >= f10 || x10 <= f10 - ((float) this.A.getWidth())) ? 3 : 1;
    }

    public void f(boolean z10) {
        this.f12564d = z10;
    }

    public final void g(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SuperRangerBar);
        this.f12570j = obtainStyledAttributes.getInt(4, z0.h.c(this, 1.0f));
        this.f12579s = obtainStyledAttributes.getInt(3, r0 / 2);
        int color = obtainStyledAttributes.getColor(1, -12566464);
        int color2 = obtainStyledAttributes.getColor(0, -2302756);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.f12566f = paint;
        paint.setColor(color);
        this.f12566f.setStrokeWidth(this.f12570j);
        Paint paint2 = new Paint();
        this.f12565e = paint2;
        paint2.setColor(color2);
        this.f12565e.setStrokeWidth(this.f12570j);
        this.f12568h = new RectF();
        this.f12569i = new RectF();
        this.f12567g = new Paint();
        this.f12586z = BitmapFactory.decodeResource(context.getResources(), R$mipmap.icon_range_bar);
        this.A = BitmapFactory.decodeResource(context.getResources(), R$mipmap.icon_range_bar);
        this.B = new Matrix();
        this.C = new Matrix();
        this.f12572l = 30.0f;
        this.f12581u = 42;
        this.f12584x = 0;
        this.f12585y = 42;
    }

    public int getLeftScale() {
        return this.f12584x;
    }

    public int getMaxValue() {
        return this.f12585y + this.G;
    }

    public int getMinValue() {
        return this.f12584x + this.G;
    }

    public int getRightScale() {
        return this.f12585y;
    }

    public void h(int i10, int i11) {
        this.F = i11;
        this.G = i10;
        int i12 = i11 - i10;
        d(i12, 0, i12);
    }

    public final void i(int i10, int i11) {
        com.cupidapp.live.base.utils.j.b("SUPER_RANGER_VIEW_TAG", "width:" + i10 + " ------- height:" + i11);
        this.f12562b = i11;
        this.f12563c = i10;
        float f10 = this.f12572l;
        this.f12575o = f10;
        float f11 = ((float) i10) - f10;
        this.f12576p = f11;
        float width = (f11 - this.A.getWidth()) - (this.f12575o + this.f12586z.getWidth());
        this.f12583w = width;
        float f12 = width / this.f12581u;
        this.f12582v = f12;
        float f13 = this.f12575o;
        this.f12573m = (this.f12584x * f12) + f13;
        this.f12574n = f13 + (this.f12585y * f12) + this.f12586z.getWidth() + this.A.getWidth();
        int i12 = this.f12562b;
        int i13 = this.f12570j;
        this.f12577q = (i12 - i13) / 2;
        this.f12578r = (i13 + i12) / 2;
        this.f12580t = (i12 - this.f12586z.getHeight()) / 2;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f12569i.set(this.f12573m, this.f12577q, this.f12574n, this.f12578r);
        RectF rectF = this.f12568h;
        float f10 = this.f12572l;
        rectF.set(f10, this.f12577q, this.f12563c - f10, this.f12578r);
        this.B.setTranslate(this.f12573m - (this.f12586z.getWidth() * 0.2f), this.f12580t);
        this.C.setTranslate((this.f12574n - this.A.getHeight()) + (this.f12586z.getWidth() * 0.2f), this.f12580t);
        RectF rectF2 = this.f12568h;
        float f11 = this.f12579s;
        canvas.drawRoundRect(rectF2, f11, f11, this.f12565e);
        RectF rectF3 = this.f12569i;
        float f12 = this.f12579s;
        canvas.drawRoundRect(rectF3, f12, f12, this.f12566f);
        canvas.drawBitmap(this.f12586z, this.B, this.f12567g);
        canvas.drawBitmap(this.A, this.C, this.f12567g);
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        i(getWidth(), getHeight());
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
    
        if (r0 != 3) goto L19;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            com.cupidapp.live.base.view.SuperRangerBar$b r0 = r4.D
            boolean r1 = r4.f12564d
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r0.a(r1, r5)
            boolean r0 = r4.f12564d
            r1 = 1
            if (r0 != 0) goto L11
            return r1
        L11:
            int r0 = r5.getAction()
            if (r0 == 0) goto L46
            r2 = 3
            if (r0 == r1) goto L31
            r3 = 2
            if (r0 == r3) goto L20
            if (r0 == r2) goto L31
            goto L51
        L20:
            int r0 = r4.E
            if (r0 != r2) goto L2a
            int r0 = r4.e(r5)
            r4.E = r0
        L2a:
            r4.b(r5)
            r4.invalidate()
            goto L51
        L31:
            r5 = 0
            r4.f12571k = r5
            android.graphics.RectF r5 = r4.f12569i
            float r0 = r5.left
            r4.f12573m = r0
            float r5 = r5.right
            r4.f12574n = r5
            r4.E = r2
            com.cupidapp.live.base.view.SuperRangerBar$b r5 = r4.D
            r5.d()
            goto L51
        L46:
            float r5 = r5.getX()
            r4.f12571k = r5
            com.cupidapp.live.base.view.SuperRangerBar$b r5 = r4.D
            r5.c()
        L51:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.base.view.SuperRangerBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setCoverLineColor(@ColorInt int i10) {
        this.f12566f.setColor(i10);
        invalidate();
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        this.f12564d = z10;
    }

    public void setOnMoveListener(b bVar) {
        this.D = bVar;
    }

    public void setRange(int i10, int i11) {
        int i12 = this.F;
        int i13 = this.G;
        d(i12 - i13, i10 - i13, i11 - i13);
        b bVar = this.D;
        if (bVar != null) {
            bVar.b(this.f12584x, this.f12585y);
            b bVar2 = this.D;
            int i14 = this.G;
            int i15 = this.f12584x;
            int i16 = i14 + i15;
            int i17 = this.f12585y;
            bVar2.e(i16, i14 + i17, i15 == 0, i14 + i17 == this.F);
        }
    }

    public void setScale(int i10, int i11, int i12) {
        if (i11 < 0 || i12 > i10 || i11 >= i12) {
            return;
        }
        this.f12581u = i10;
        this.f12584x = i11;
        this.f12585y = i12;
    }

    public SuperRangerBar(Context context) {
        super(context);
        this.f12564d = true;
        this.E = 3;
        this.H = new a();
    }

    public SuperRangerBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12564d = true;
        this.E = 3;
        this.H = new a();
        g(context, attributeSet);
    }
}
