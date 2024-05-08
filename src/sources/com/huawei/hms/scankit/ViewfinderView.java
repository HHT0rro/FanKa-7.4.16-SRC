package com.huawei.hms.scankit;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.android.internal.logging.nano.MetricsProto;
import com.huawei.hms.scankit.p.u6;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class ViewfinderView extends View {
    private int[] A;
    private float[] B;
    private Rect C;
    private boolean D;
    public Point E;
    private boolean F;

    /* renamed from: a, reason: collision with root package name */
    private Paint f30475a;

    /* renamed from: b, reason: collision with root package name */
    private TextPaint f30476b;

    /* renamed from: c, reason: collision with root package name */
    private int f30477c;

    /* renamed from: d, reason: collision with root package name */
    private int f30478d;

    /* renamed from: e, reason: collision with root package name */
    private int f30479e;

    /* renamed from: f, reason: collision with root package name */
    private int f30480f;

    /* renamed from: g, reason: collision with root package name */
    private int f30481g;

    /* renamed from: h, reason: collision with root package name */
    private float f30482h;

    /* renamed from: i, reason: collision with root package name */
    private c f30483i;

    /* renamed from: j, reason: collision with root package name */
    private String f30484j;

    /* renamed from: k, reason: collision with root package name */
    private int f30485k;

    /* renamed from: l, reason: collision with root package name */
    private float f30486l;

    /* renamed from: m, reason: collision with root package name */
    public int f30487m;

    /* renamed from: n, reason: collision with root package name */
    public int f30488n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f30489o;

    /* renamed from: p, reason: collision with root package name */
    private int f30490p;

    /* renamed from: q, reason: collision with root package name */
    private int f30491q;

    /* renamed from: r, reason: collision with root package name */
    private int f30492r;

    /* renamed from: s, reason: collision with root package name */
    private int f30493s;

    /* renamed from: t, reason: collision with root package name */
    private b f30494t;

    /* renamed from: u, reason: collision with root package name */
    private int f30495u;

    /* renamed from: v, reason: collision with root package name */
    private int f30496v;

    /* renamed from: w, reason: collision with root package name */
    private Rect f30497w;

    /* renamed from: x, reason: collision with root package name */
    private int f30498x;

    /* renamed from: y, reason: collision with root package name */
    private ValueAnimator f30499y;

    /* renamed from: z, reason: collision with root package name */
    public Paint f30500z;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ViewfinderView.this.f30487m = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            ViewfinderView.this.invalidate();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum b {
        NONE(0),
        LINE(1),
        GRID(2);


        /* renamed from: a, reason: collision with root package name */
        private int f30506a;

        b(int i10) {
            this.f30506a = i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b b(int i10) {
            for (b bVar : values()) {
                if (bVar.f30506a == i10) {
                    return bVar;
                }
            }
            return LINE;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum c {
        TOP(0),
        BOTTOM(1);


        /* renamed from: a, reason: collision with root package name */
        private int f30510a;

        c(int i10) {
            this.f30510a = i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static c b(int i10) {
            for (c cVar : values()) {
                if (cVar.f30510a == i10) {
                    return cVar;
                }
            }
            return TOP;
        }
    }

    public ViewfinderView(Context context) {
        this(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ViewfinderView);
        this.f30477c = obtainStyledAttributes.getColor(R.styleable.ViewfinderView_scankit_maskColor, b(context, R.color.scankit_viewfinder_mask));
        this.f30478d = obtainStyledAttributes.getColor(R.styleable.ViewfinderView_scankit_frameColor, b(context, R.color.scankit_viewfinder_frame));
        this.f30480f = obtainStyledAttributes.getColor(R.styleable.ViewfinderView_scankit_cornerColor, b(context, R.color.scankit_viewfinder_corner));
        this.f30479e = obtainStyledAttributes.getColor(R.styleable.ViewfinderView_scankit_laserColor, b(context, R.color.scankit_viewfinder_lasers));
        this.f30481g = obtainStyledAttributes.getColor(R.styleable.ViewfinderView_scankit_resultPointColor, b(context, R.color.scankit_viewfinder_result_point_color));
        this.f30484j = obtainStyledAttributes.getString(R.styleable.ViewfinderView_scankit_labelText);
        this.f30485k = obtainStyledAttributes.getColor(R.styleable.ViewfinderView_scankit_labelTextColor, b(context, R.color.scankit_viewfinder_text_color));
        this.f30486l = obtainStyledAttributes.getDimension(R.styleable.ViewfinderView_scankit_labelTextSize, TypedValue.applyDimension(2, 14.0f, getResources().getDisplayMetrics()));
        this.f30482h = obtainStyledAttributes.getDimension(R.styleable.ViewfinderView_scankit_labelTextPadding, TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics()));
        this.f30483i = c.b(obtainStyledAttributes.getInt(R.styleable.ViewfinderView_scankit_labelTextLocation, 0));
        this.f30489o = obtainStyledAttributes.getBoolean(R.styleable.ViewfinderView_scankit_showResultPoint, false);
        this.f30492r = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ViewfinderView_scankit_frameWidth, 0);
        this.f30493s = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ViewfinderView_scankit_frameHeight, 0);
        this.f30494t = b.b(obtainStyledAttributes.getInt(R.styleable.ViewfinderView_scankit_laserStyle, b.LINE.f30506a));
        this.f30495u = obtainStyledAttributes.getInt(R.styleable.ViewfinderView_scankit_gridColumn, 20);
        this.f30496v = (int) obtainStyledAttributes.getDimension(R.styleable.ViewfinderView_scankit_gridHeight, TypedValue.applyDimension(1, 40.0f, getResources().getDisplayMetrics()));
        this.F = obtainStyledAttributes.getBoolean(R.styleable.ViewfinderView_scankit_line_anim, true);
        obtainStyledAttributes.recycle();
        this.f30475a = new Paint(1);
        this.f30476b = new TextPaint(1);
        this.f30498x = a(context, 136);
        this.f30491q = getDisplayMetrics().heightPixels;
        this.f30490p = getDisplayMetrics().widthPixels;
    }

    public static int b(Context context, int i10) {
        try {
            return Build.VERSION.SDK_INT >= 23 ? context.getColor(i10) : context.getResources().getColor(i10);
        } catch (Resources.NotFoundException | Exception unused) {
            return 16777215;
        }
    }

    private DisplayMetrics getDisplayMetrics() {
        return getResources().getDisplayMetrics();
    }

    public void a(u6 u6Var) {
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f30499y;
        if (valueAnimator != null) {
            valueAnimator.pause();
            this.f30499y.removeAllListeners();
            this.f30499y.cancel();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.F) {
            canvas.save();
            String str = Build.DEVICE;
            a(canvas, "HWTAH".equals(str) || str.equals("HWTAH-C"));
            canvas.restore();
        }
        a(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f30490p = i10;
        this.f30491q = i11;
        a();
    }

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewfinderView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f30487m = 0;
        this.f30488n = 0;
        this.f30497w = new Rect();
        this.f30500z = new Paint();
        this.A = new int[]{Color.parseColor("#FFFFFFFF"), Color.parseColor("#72FFFFFF"), Color.parseColor("#58FFFFFF"), Color.parseColor("#40FFFFFF"), Color.parseColor("#28FFFFFF"), Color.parseColor("#13FFFFFF"), Color.parseColor("#00FFFFFF")};
        this.B = new float[]{0.0f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f, 1.0f};
        this.D = true;
        this.F = true;
        a(context, attributeSet);
    }

    private void a(Canvas canvas, boolean z10) {
        this.f30475a.setStyle(Paint.Style.FILL);
        this.f30475a.setColor(this.f30479e);
        if (!e.f30632z && !z10) {
            Rect rect = this.f30497w;
            rect.left = 0;
            int i10 = this.f30487m;
            rect.top = i10;
            rect.bottom = i10 + this.f30498x;
            rect.right = this.f30490p;
        } else {
            Rect rect2 = this.f30497w;
            int i11 = this.f30490p / 2;
            rect2.left = i11 - 540;
            int i12 = this.f30487m;
            rect2.top = i12;
            rect2.bottom = i12 + this.f30498x;
            rect2.right = i11 + 540;
        }
        float f10 = this.f30490p / 2;
        float f11 = this.f30497w.bottom + 500;
        this.f30475a.setShader(new RadialGradient(f10, f11, MetricsProto.MetricsEvent.ACTION_PERMISSION_REQUEST_USE_SIP, this.A, this.B, Shader.TileMode.CLAMP));
        this.f30475a.setStrokeWidth(10.0f);
        Rect rect3 = this.f30497w;
        float f12 = rect3.left;
        float f13 = rect3.bottom;
        canvas.drawLine(f12, f13, rect3.right, f13, this.f30475a);
        canvas.clipRect(this.f30497w);
        canvas.drawCircle(f10, f11, r12 + 200, this.f30475a);
    }

    public void a() {
        if (e.f30632z) {
            this.f30488n = this.f30491q;
        } else {
            this.f30488n = this.f30491q - a(getContext(), 139);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, this.f30488n - this.f30498x);
        this.f30499y = ofInt;
        ofInt.setDuration(com.huawei.openalliance.ad.ipc.c.Code);
        this.f30499y.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f30499y.setRepeatMode(1);
        this.f30499y.setRepeatCount(-1);
        this.f30499y.addUpdateListener(new a());
        this.f30499y.start();
    }

    public void a(Rect rect, boolean z10, Point point) {
        this.D = z10;
        this.E = point;
        if (this.C == null) {
            this.C = rect;
            invalidate();
        }
    }

    public static int a(Context context, int i10) {
        return (int) ((i10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void a(Canvas canvas) {
        Point point;
        int i10;
        int i11;
        int i12;
        if (this.C == null) {
            return;
        }
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.D) {
            Point point2 = this.E;
            point = new Point(point2.y, point2.x);
        } else {
            Point point3 = this.E;
            point = new Point(point3.x, point3.y);
        }
        int i13 = point.x;
        float f10 = width / i13;
        int i14 = point.y;
        float f11 = height / i14;
        int i15 = (int) (i14 * 0.1d);
        int i16 = (int) ((i13 * 0.15d) / 2.0d);
        RectF rectF = new RectF();
        if (this.D) {
            if (f10 > f11) {
                i11 = (int) (point.y * f10);
                canvas.translate(0.0f, (height / 2) - (i11 / 2));
                i12 = width;
            } else {
                i10 = (int) (point.x * f11);
                canvas.translate((width / 2) - (i10 / 2), 0.0f);
                i12 = i10;
                i11 = height;
            }
        } else if (f10 > f11) {
            i11 = (int) (point.y * f10);
            canvas.translate(0.0f, (height / 2) - (i11 / 2));
            i12 = width;
        } else {
            i10 = (int) (point.x * f11);
            canvas.translate((width / 2) - (i10 / 2), 0.0f);
            i12 = i10;
            i11 = height;
        }
        Rect rect = this.C;
        float f12 = rect.left + i16;
        float f13 = point.x;
        float f14 = rect.top + i15;
        float f15 = point.y;
        float f16 = f14 / f15;
        float f17 = (rect.bottom + i15) / f15;
        float f18 = i12;
        float f19 = (f12 / f13) * f18;
        rectF.left = f19;
        float f20 = ((rect.right + i16) / f13) * f18;
        rectF.right = f20;
        float f21 = i11;
        float f22 = f16 * f21;
        rectF.top = f22;
        float f23 = f17 * f21;
        rectF.bottom = f23;
        float f24 = (f19 + f20) / 2.0f;
        float f25 = (f22 + f23) / 2.0f;
        this.f30500z.setStyle(Paint.Style.FILL);
        this.f30500z.setColor(-1);
        canvas.drawCircle(f24, f25, ((int) ((getDisplayMetrics().density * 24.0f) + 0.5d)) / 2, this.f30500z);
        this.f30500z.setColor(Color.parseColor("#007DFF"));
        canvas.drawCircle(f24, f25, ((int) ((getDisplayMetrics().density * 22.0f) + 0.5d)) / 2, this.f30500z);
        if (this.D) {
            if (f10 > f11) {
                canvas.translate(0.0f, (i11 / 2) - (height / 2));
                return;
            } else {
                canvas.translate((i12 / 2) - (width / 2), 0.0f);
                return;
            }
        }
        if (f10 > f11) {
            canvas.translate(0.0f, (i11 / 2) - (height / 2));
        } else {
            canvas.translate((i12 / 2) - (width / 2), 0.0f);
        }
    }
}
