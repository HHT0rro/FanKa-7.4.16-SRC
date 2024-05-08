package com.contrarywind.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.contrarywind.interfaces.IPickerViewData;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import s0.b;
import t0.c;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class WheelView extends View {
    public static final String[] V = {"00", HiAnalyticsConstant.KeyAndValue.NUMBER_01, com.huawei.hms.ads.dynamic.a.f29124s, "03", "04", "05", "06", "07", "08", "09"};
    public boolean A;
    public float B;
    public float C;
    public float D;
    public float E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public float N;
    public long O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public float T;
    public boolean U;

    /* renamed from: b, reason: collision with root package name */
    public DividerType f11586b;

    /* renamed from: c, reason: collision with root package name */
    public Context f11587c;

    /* renamed from: d, reason: collision with root package name */
    public Handler f11588d;

    /* renamed from: e, reason: collision with root package name */
    public GestureDetector f11589e;

    /* renamed from: f, reason: collision with root package name */
    public b f11590f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f11591g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f11592h;

    /* renamed from: i, reason: collision with root package name */
    public ScheduledExecutorService f11593i;

    /* renamed from: j, reason: collision with root package name */
    public ScheduledFuture<?> f11594j;

    /* renamed from: k, reason: collision with root package name */
    public Paint f11595k;

    /* renamed from: l, reason: collision with root package name */
    public Paint f11596l;

    /* renamed from: m, reason: collision with root package name */
    public Paint f11597m;

    /* renamed from: n, reason: collision with root package name */
    public r0.a f11598n;

    /* renamed from: o, reason: collision with root package name */
    public String f11599o;

    /* renamed from: p, reason: collision with root package name */
    public int f11600p;

    /* renamed from: q, reason: collision with root package name */
    public int f11601q;

    /* renamed from: r, reason: collision with root package name */
    public int f11602r;

    /* renamed from: s, reason: collision with root package name */
    public int f11603s;

    /* renamed from: t, reason: collision with root package name */
    public float f11604t;

    /* renamed from: u, reason: collision with root package name */
    public Typeface f11605u;

    /* renamed from: v, reason: collision with root package name */
    public int f11606v;

    /* renamed from: w, reason: collision with root package name */
    public int f11607w;

    /* renamed from: x, reason: collision with root package name */
    public int f11608x;

    /* renamed from: y, reason: collision with root package name */
    public int f11609y;

    /* renamed from: z, reason: collision with root package name */
    public float f11610z;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum ACTION {
        CLICK,
        FLING,
        DAGGLE
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum DividerType {
        FILL,
        WRAP,
        CIRCLE
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            WheelView.this.f11590f.a(WheelView.this.getCurrentItem());
        }
    }

    public WheelView(Context context) {
        this(context, null);
    }

    public void b() {
        ScheduledFuture<?> scheduledFuture = this.f11594j;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            return;
        }
        this.f11594j.cancel(true);
        this.f11594j = null;
    }

    public final String c(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof IPickerViewData) {
            return ((IPickerViewData) obj).getPickerViewText();
        }
        if (obj instanceof Integer) {
            return d(((Integer) obj).intValue());
        }
        return obj.toString();
    }

    public final String d(int i10) {
        return (i10 < 0 || i10 >= 10) ? String.valueOf(i10) : V[i10];
    }

    public final int e(int i10) {
        if (i10 < 0) {
            return e(i10 + this.f11598n.a());
        }
        return i10 > this.f11598n.a() + (-1) ? e(i10 - this.f11598n.a()) : i10;
    }

    public int f(Paint paint, String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        int length = str.length();
        paint.getTextWidths(str, new float[length]);
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            i10 += (int) Math.ceil(r2[i11]);
        }
        return i10;
    }

    public final void g(Context context) {
        this.f11587c = context;
        this.f11588d = new t0.b(this);
        GestureDetector gestureDetector = new GestureDetector(context, new s0.a(this));
        this.f11589e = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.A = true;
        this.E = 0.0f;
        this.F = -1;
        h();
    }

    public final r0.a getAdapter() {
        return this.f11598n;
    }

    public final int getCurrentItem() {
        int i10;
        r0.a aVar = this.f11598n;
        if (aVar == null) {
            return 0;
        }
        if (this.A && ((i10 = this.G) < 0 || i10 >= aVar.a())) {
            return Math.max(0, Math.min(Math.abs(Math.abs(this.G) - this.f11598n.a()), this.f11598n.a() - 1));
        }
        return Math.max(0, Math.min(this.G, this.f11598n.a() - 1));
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.f11588d;
    }

    public int getInitPosition() {
        return this.F;
    }

    public float getItemHeight() {
        return this.f11604t;
    }

    public int getItemsCount() {
        r0.a aVar = this.f11598n;
        if (aVar != null) {
            return aVar.a();
        }
        return 0;
    }

    public float getTotalScrollY() {
        return this.E;
    }

    public final void h() {
        Paint paint = new Paint();
        this.f11595k = paint;
        paint.setColor(this.f11606v);
        this.f11595k.setAntiAlias(true);
        this.f11595k.setTypeface(this.f11605u);
        this.f11595k.setTextSize(this.f11600p);
        Paint paint2 = new Paint();
        this.f11596l = paint2;
        paint2.setColor(this.f11607w);
        this.f11596l.setAntiAlias(true);
        this.f11596l.setTextScaleX(1.1f);
        this.f11596l.setTypeface(this.f11605u);
        this.f11596l.setTextSize(this.f11600p);
        Paint paint3 = new Paint();
        this.f11597m = paint3;
        paint3.setColor(this.f11608x);
        this.f11597m.setAntiAlias(true);
        setLayerType(1, null);
    }

    public void i(boolean z10) {
        this.f11592h = z10;
    }

    public boolean j() {
        return this.A;
    }

    public final void k() {
        float f10 = this.f11610z;
        if (f10 < 1.0f) {
            this.f11610z = 1.0f;
        } else if (f10 > 4.0f) {
            this.f11610z = 4.0f;
        }
    }

    public final void l() {
        Rect rect = new Rect();
        for (int i10 = 0; i10 < this.f11598n.a(); i10++) {
            String c4 = c(this.f11598n.getItem(i10));
            this.f11596l.getTextBounds(c4, 0, c4.length(), rect);
            int width = rect.width();
            if (width > this.f11601q) {
                this.f11601q = width;
            }
        }
        this.f11596l.getTextBounds("星期", 0, 2, rect);
        int height = rect.height() + 2;
        this.f11602r = height;
        this.f11604t = this.f11610z * height;
    }

    public final void m(String str) {
        String str2;
        Rect rect = new Rect();
        this.f11596l.getTextBounds(str, 0, str.length(), rect);
        int i10 = this.Q;
        if (i10 == 3) {
            this.R = 0;
            return;
        }
        if (i10 == 5) {
            this.R = (this.K - rect.width()) - ((int) this.T);
            return;
        }
        if (i10 != 17) {
            return;
        }
        if (!this.f11591g && (str2 = this.f11599o) != null && !str2.equals("") && this.f11592h) {
            this.R = (int) ((this.K - rect.width()) * 0.25d);
        } else {
            this.R = (int) ((this.K - rect.width()) * 0.5d);
        }
    }

    public final void n(String str) {
        String str2;
        Rect rect = new Rect();
        this.f11595k.getTextBounds(str, 0, str.length(), rect);
        int i10 = this.Q;
        if (i10 == 3) {
            this.S = 0;
            return;
        }
        if (i10 == 5) {
            this.S = (this.K - rect.width()) - ((int) this.T);
            return;
        }
        if (i10 != 17) {
            return;
        }
        if (!this.f11591g && (str2 = this.f11599o) != null && !str2.equals("") && this.f11592h) {
            this.S = (int) ((this.K - rect.width()) * 0.25d);
        } else {
            this.S = (int) ((this.K - rect.width()) * 0.5d);
        }
    }

    public final void o() {
        if (this.f11590f != null) {
            postDelayed(new a(), 200L);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f10;
        float f11;
        String c4;
        int i10;
        if (this.f11598n == null) {
            return;
        }
        int min = Math.min(Math.max(0, this.F), this.f11598n.a() - 1);
        this.F = min;
        try {
            this.H = min + (((int) (this.E / this.f11604t)) % this.f11598n.a());
        } catch (ArithmeticException unused) {
        }
        if (!this.A) {
            if (this.H < 0) {
                this.H = 0;
            }
            if (this.H > this.f11598n.a() - 1) {
                this.H = this.f11598n.a() - 1;
            }
        } else {
            if (this.H < 0) {
                this.H = this.f11598n.a() + this.H;
            }
            if (this.H > this.f11598n.a() - 1) {
                this.H -= this.f11598n.a();
            }
        }
        float f12 = this.E % this.f11604t;
        DividerType dividerType = this.f11586b;
        if (dividerType == DividerType.WRAP) {
            if (TextUtils.isEmpty(this.f11599o)) {
                i10 = (this.K - this.f11601q) / 2;
            } else {
                i10 = (this.K - this.f11601q) / 4;
            }
            float f13 = i10 - 12;
            float f14 = f13 <= 0.0f ? 10.0f : f13;
            float f15 = this.K - f14;
            float f16 = this.B;
            float f17 = f14;
            canvas.drawLine(f17, f16, f15, f16, this.f11597m);
            float f18 = this.C;
            canvas.drawLine(f17, f18, f15, f18, this.f11597m);
        } else if (dividerType == DividerType.CIRCLE) {
            this.f11597m.setStyle(Paint.Style.STROKE);
            this.f11597m.setStrokeWidth(this.f11609y);
            if (TextUtils.isEmpty(this.f11599o)) {
                f10 = (this.K - this.f11601q) / 2.0f;
            } else {
                f10 = (this.K - this.f11601q) / 4.0f;
            }
            float f19 = f10 - 12.0f;
            float f20 = f19 > 0.0f ? f19 : 10.0f;
            canvas.drawCircle(this.K / 2.0f, this.J / 2.0f, Math.max((this.K - f20) - f20, this.f11604t) / 1.8f, this.f11597m);
        } else {
            float f21 = this.B;
            canvas.drawLine(0.0f, f21, this.K, f21, this.f11597m);
            float f22 = this.C;
            canvas.drawLine(0.0f, f22, this.K, f22, this.f11597m);
        }
        if (!TextUtils.isEmpty(this.f11599o) && this.f11592h) {
            canvas.drawText(this.f11599o, (this.K - f(this.f11596l, this.f11599o)) - this.T, this.D, this.f11596l);
        }
        int i11 = 0;
        while (true) {
            int i12 = this.I;
            if (i11 >= i12) {
                return;
            }
            int i13 = this.H - ((i12 / 2) - i11);
            Object obj = "";
            if (this.A) {
                obj = this.f11598n.getItem(e(i13));
            } else if (i13 >= 0 && i13 <= this.f11598n.a() - 1) {
                obj = this.f11598n.getItem(i13);
            }
            canvas.save();
            double d10 = ((this.f11604t * i11) - f12) / this.L;
            float f23 = (float) (90.0d - ((d10 / 3.141592653589793d) * 180.0d));
            if (f23 <= 90.0f && f23 >= -90.0f) {
                if (!this.f11592h && !TextUtils.isEmpty(this.f11599o) && !TextUtils.isEmpty(c(obj))) {
                    c4 = c(obj) + this.f11599o;
                } else {
                    c4 = c(obj);
                }
                float pow = (float) Math.pow(Math.abs(f23) / 90.0f, 2.2d);
                q(c4);
                m(c4);
                n(c4);
                f11 = f12;
                float cos = (float) ((this.L - (Math.cos(d10) * this.L)) - ((Math.sin(d10) * this.f11602r) / 2.0d));
                canvas.translate(0.0f, cos);
                float f24 = this.B;
                if (cos <= f24 && this.f11602r + cos >= f24) {
                    canvas.save();
                    canvas.clipRect(0.0f, 0.0f, this.K, this.B - cos);
                    canvas.scale(1.0f, ((float) Math.sin(d10)) * 0.8f);
                    s(pow, f23);
                    canvas.drawText(c4, this.S, this.f11602r, this.f11595k);
                    canvas.restore();
                    canvas.save();
                    canvas.clipRect(0.0f, this.B - cos, this.K, (int) this.f11604t);
                    canvas.scale(1.0f, ((float) Math.sin(d10)) * 1.0f);
                    canvas.drawText(c4, this.R, this.f11602r - this.T, this.f11596l);
                    canvas.restore();
                } else {
                    float f25 = this.C;
                    if (cos <= f25 && this.f11602r + cos >= f25) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.K, this.C - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d10)) * 1.0f);
                        canvas.drawText(c4, this.R, this.f11602r - this.T, this.f11596l);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.C - cos, this.K, (int) this.f11604t);
                        canvas.scale(1.0f, ((float) Math.sin(d10)) * 0.8f);
                        s(pow, f23);
                        canvas.drawText(c4, this.S, this.f11602r, this.f11595k);
                        canvas.restore();
                    } else {
                        if (cos >= f24) {
                            int i14 = this.f11602r;
                            if (i14 + cos <= f25) {
                                canvas.drawText(c4, this.R, i14 - this.T, this.f11596l);
                                this.G = this.H - ((this.I / 2) - i11);
                            }
                        }
                        canvas.save();
                        canvas.clipRect(0, 0, this.K, (int) this.f11604t);
                        canvas.scale(1.0f, ((float) Math.sin(d10)) * 0.8f);
                        s(pow, f23);
                        canvas.drawText(c4, this.S + (this.f11603s * pow), this.f11602r, this.f11595k);
                        canvas.restore();
                        canvas.restore();
                        this.f11596l.setTextSize(this.f11600p);
                    }
                }
                canvas.restore();
                this.f11596l.setTextSize(this.f11600p);
            } else {
                f11 = f12;
                canvas.restore();
            }
            i11++;
            f12 = f11;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        this.P = i10;
        p();
        setMeasuredDimension(this.K, this.J);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.f11589e.onTouchEvent(motionEvent);
        float f10 = (-this.F) * this.f11604t;
        float a10 = ((this.f11598n.a() - 1) - this.F) * this.f11604t;
        int action = motionEvent.getAction();
        boolean z10 = false;
        if (action == 0) {
            this.O = System.currentTimeMillis();
            b();
            this.N = motionEvent.getRawY();
        } else if (action == 2) {
            float rawY = this.N - motionEvent.getRawY();
            this.N = motionEvent.getRawY();
            float f11 = this.E + rawY;
            this.E = f11;
            if (!this.A) {
                float f12 = this.f11604t;
                if ((f11 - (f12 * 0.25f) < f10 && rawY < 0.0f) || ((f12 * 0.25f) + f11 > a10 && rawY > 0.0f)) {
                    this.E = f11 - rawY;
                    z10 = true;
                }
            }
        } else if (!onTouchEvent) {
            float y10 = motionEvent.getY();
            int i10 = this.L;
            double acos = Math.acos((i10 - y10) / i10) * this.L;
            float f13 = this.f11604t;
            this.M = (int) (((((int) ((acos + (f13 / 2.0f)) / f13)) - (this.I / 2)) * f13) - (((this.E % f13) + f13) % f13));
            if (System.currentTimeMillis() - this.O > 120) {
                t(ACTION.DAGGLE);
            } else {
                t(ACTION.CLICK);
            }
        }
        if (!z10 && motionEvent.getAction() != 0) {
            invalidate();
        }
        return true;
    }

    public final void p() {
        if (this.f11598n == null) {
            return;
        }
        l();
        int i10 = (int) (this.f11604t * (this.I - 1));
        this.J = (int) ((i10 * 2) / 3.141592653589793d);
        this.L = (int) (i10 / 3.141592653589793d);
        this.K = View.MeasureSpec.getSize(this.P);
        int i11 = this.J;
        float f10 = this.f11604t;
        this.B = (i11 - f10) / 2.0f;
        float f11 = (i11 + f10) / 2.0f;
        this.C = f11;
        this.D = (f11 - ((f10 - this.f11602r) / 2.0f)) - this.T;
        if (this.F == -1) {
            if (this.A) {
                this.F = (this.f11598n.a() + 1) / 2;
            } else {
                this.F = 0;
            }
        }
        this.H = this.F;
    }

    public final void q(String str) {
        Rect rect = new Rect();
        this.f11596l.getTextBounds(str, 0, str.length(), rect);
        int i10 = this.f11600p;
        for (int width = rect.width(); width > this.K; width = rect.width()) {
            i10--;
            this.f11596l.setTextSize(i10);
            this.f11596l.getTextBounds(str, 0, str.length(), rect);
        }
        this.f11595k.setTextSize(i10);
    }

    public final void r(float f10) {
        b();
        this.f11594j = this.f11593i.scheduleWithFixedDelay(new t0.a(this, f10), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    public final void s(float f10, float f11) {
        int i10 = this.f11603s;
        this.f11595k.setTextSkewX((i10 > 0 ? 1 : i10 < 0 ? -1 : 0) * (f11 <= 0.0f ? 1 : -1) * 0.5f * f10);
        this.f11595k.setAlpha(this.U ? (int) (((90.0f - Math.abs(f11)) / 90.0f) * 255.0f) : 255);
    }

    public final void setAdapter(r0.a aVar) {
        this.f11598n = aVar;
        p();
        invalidate();
    }

    public void setAlphaGradient(boolean z10) {
        this.U = z10;
    }

    public final void setCurrentItem(int i10) {
        this.G = i10;
        this.F = i10;
        this.E = 0.0f;
        invalidate();
    }

    public final void setCyclic(boolean z10) {
        this.A = z10;
    }

    public void setDividerColor(int i10) {
        this.f11608x = i10;
        this.f11597m.setColor(i10);
    }

    public void setDividerType(DividerType dividerType) {
        this.f11586b = dividerType;
    }

    public void setDividerWidth(int i10) {
        this.f11609y = i10;
        this.f11597m.setStrokeWidth(i10);
    }

    public void setGravity(int i10) {
        this.Q = i10;
    }

    public void setIsOptions(boolean z10) {
        this.f11591g = z10;
    }

    public void setItemsVisibleCount(int i10) {
        if (i10 % 2 == 0) {
            i10++;
        }
        this.I = i10 + 2;
    }

    public void setLabel(String str) {
        this.f11599o = str;
    }

    public void setLineSpacingMultiplier(float f10) {
        if (f10 != 0.0f) {
            this.f11610z = f10;
            k();
        }
    }

    public final void setOnItemSelectedListener(b bVar) {
        this.f11590f = bVar;
    }

    public void setTextColorCenter(int i10) {
        this.f11607w = i10;
        this.f11596l.setColor(i10);
    }

    public void setTextColorOut(int i10) {
        this.f11606v = i10;
        this.f11595k.setColor(i10);
    }

    public final void setTextSize(float f10) {
        if (f10 > 0.0f) {
            int i10 = (int) (this.f11587c.getResources().getDisplayMetrics().density * f10);
            this.f11600p = i10;
            this.f11595k.setTextSize(i10);
            this.f11596l.setTextSize(this.f11600p);
        }
    }

    public void setTextXOffset(int i10) {
        this.f11603s = i10;
        if (i10 != 0) {
            this.f11596l.setTextScaleX(1.0f);
        }
    }

    public void setTotalScrollY(float f10) {
        this.E = f10;
    }

    public final void setTypeface(Typeface typeface) {
        this.f11605u = typeface;
        this.f11595k.setTypeface(typeface);
        this.f11596l.setTypeface(this.f11605u);
    }

    public void t(ACTION action) {
        b();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            float f10 = this.E;
            float f11 = this.f11604t;
            int i10 = (int) (((f10 % f11) + f11) % f11);
            this.M = i10;
            if (i10 > f11 / 2.0f) {
                this.M = (int) (f11 - i10);
            } else {
                this.M = -i10;
            }
        }
        this.f11594j = this.f11593i.scheduleWithFixedDelay(new c(this, this.M), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11591g = false;
        this.f11592h = true;
        this.f11593i = Executors.newSingleThreadScheduledExecutor();
        this.f11605u = Typeface.DEFAULT;
        this.f11610z = 1.6f;
        this.I = 11;
        this.M = 0;
        this.N = 0.0f;
        this.O = 0L;
        this.Q = 17;
        this.R = 0;
        this.S = 0;
        this.U = false;
        this.f11600p = getResources().getDimensionPixelSize(R$dimen.pickerview_textsize);
        float f10 = getResources().getDisplayMetrics().density;
        if (f10 < 1.0f) {
            this.T = 2.4f;
        } else if (1.0f <= f10 && f10 < 2.0f) {
            this.T = 4.0f;
        } else if (2.0f <= f10 && f10 < 3.0f) {
            this.T = 6.0f;
        } else if (f10 >= 3.0f) {
            this.T = f10 * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.pickerview, 0, 0);
            this.Q = obtainStyledAttributes.getInt(R$styleable.pickerview_wheelview_gravity, 17);
            this.f11606v = obtainStyledAttributes.getColor(R$styleable.pickerview_wheelview_textColorOut, -5723992);
            this.f11607w = obtainStyledAttributes.getColor(R$styleable.pickerview_wheelview_textColorCenter, -14013910);
            this.f11608x = obtainStyledAttributes.getColor(R$styleable.pickerview_wheelview_dividerColor, -2763307);
            this.f11609y = obtainStyledAttributes.getDimensionPixelSize(R$styleable.pickerview_wheelview_dividerWidth, 2);
            this.f11600p = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.pickerview_wheelview_textSize, this.f11600p);
            this.f11610z = obtainStyledAttributes.getFloat(R$styleable.pickerview_wheelview_lineSpacingMultiplier, this.f11610z);
            obtainStyledAttributes.recycle();
        }
        k();
        g(context);
    }
}
