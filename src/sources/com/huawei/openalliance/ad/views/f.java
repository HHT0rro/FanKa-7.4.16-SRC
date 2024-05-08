package com.huawei.openalliance.ad.views;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.utils.ay;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class f extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private Paint f33021a;

    /* renamed from: b, reason: collision with root package name */
    private float f33022b;

    /* renamed from: c, reason: collision with root package name */
    private float f33023c;

    /* renamed from: d, reason: collision with root package name */
    private float f33024d;

    /* renamed from: e, reason: collision with root package name */
    private float f33025e;

    /* renamed from: i, reason: collision with root package name */
    private int f33029i;

    /* renamed from: k, reason: collision with root package name */
    private long f33031k;

    /* renamed from: l, reason: collision with root package name */
    private LinearGradient f33032l;

    /* renamed from: m, reason: collision with root package name */
    private float f33033m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f33034n;

    /* renamed from: f, reason: collision with root package name */
    private int f33026f = 1728053247;

    /* renamed from: g, reason: collision with root package name */
    private boolean f33027g = true;

    /* renamed from: h, reason: collision with root package name */
    private float f33028h = 0.0f;

    /* renamed from: j, reason: collision with root package name */
    private boolean f33030j = false;

    public f() {
        B();
    }

    public f(float f10) {
        this.f33033m = f10;
        B();
    }

    private void B() {
        Paint paint = new Paint();
        this.f33021a = paint;
        paint.setAntiAlias(true);
        this.f33021a.setStyle(Paint.Style.FILL);
        this.f33022b = 0.0f;
        this.f33024d = 0.0f;
        V(2);
        this.f33034n = ay.C();
    }

    private boolean C() {
        return this.f33029i == 2;
    }

    private void Code(float f10, float f11) {
        float f12 = f11 - f10;
        this.f33022b = f12;
        float level = (f12 * getLevel()) / 10000.0f;
        this.f33023c = level;
        float f13 = this.f33022b * 0.3f;
        this.f33024d = f13;
        this.f33028h = (f13 + level) / 2000.0f;
        a();
        L();
    }

    private void Code(long j10) {
        this.f33031k = j10;
    }

    private long D() {
        long currentTimeMillis = System.currentTimeMillis();
        long j10 = currentTimeMillis - this.f33031k;
        Code(currentTimeMillis);
        if (j10 < 0) {
            return 0L;
        }
        return j10;
    }

    private void F() {
        this.f33028h = (this.f33024d + this.f33023c) / 2000.0f;
        if (this.f33027g) {
            this.f33027g = false;
        }
    }

    private void L() {
        int i10 = this.f33026f;
        int i11 = 16777215 & i10;
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, this.f33024d, 0.0f, new int[]{i11, i10, i11}, new float[]{0.0f, 0.93f, 1.0f}, Shader.TileMode.CLAMP);
        this.f33032l = linearGradient;
        this.f33021a.setShader(linearGradient);
    }

    private boolean S() {
        return this.f33030j && this.f33027g;
    }

    private void V(int i10) {
        this.f33029i = i10;
    }

    private void a() {
        this.f33025e = -this.f33024d;
    }

    public void Code() {
        if (gl.Code()) {
            gl.Code("HwFlickerDrawable", "start()");
        }
        if (this.f33029i == 0) {
            return;
        }
        this.f33030j = false;
        Code(System.currentTimeMillis());
        invalidateSelf();
        V(0);
    }

    public void I() {
        if (gl.Code()) {
            gl.Code("HwFlickerDrawable", "stop()");
        }
        a();
        V(2);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (C()) {
            this.f33030j = false;
            return;
        }
        F();
        float D = this.f33025e + (this.f33028h * ((float) D()));
        if (Float.compare(D, this.f33023c) > 0) {
            if (((int) this.f33023c) != 0) {
                D = (D % ((int) r0)) - this.f33024d;
            }
            this.f33027g = true;
        }
        this.f33025e = D;
        Rect bounds = getBounds();
        if (Float.compare(this.f33033m, 0.0f) > 0) {
            RectF rectF = new RectF();
            rectF.set(bounds);
            Path path = new Path();
            float f10 = this.f33033m;
            path.addRoundRect(rectF, f10, f10, Path.Direction.CW);
            canvas.clipPath(path);
        }
        if (this.f33034n) {
            canvas.scale(-1.0f, 1.0f, bounds.width() / 2.0f, bounds.height() / 2.0f);
        }
        canvas.save();
        canvas.translate(D, 0.0f);
        float f11 = Float.compare(this.f33024d + D, this.f33023c) > 0 ? this.f33023c - D : this.f33024d;
        if (Float.compare(D, 0.0f) < 0) {
            int i10 = bounds.left;
            canvas.clipRect(i10 - D, bounds.top, (i10 - D) + f11, bounds.bottom);
        }
        int i11 = bounds.left;
        canvas.drawRect(i11, bounds.top, i11 + f11, bounds.bottom, this.f33021a);
        canvas.restore();
        invalidateSelf();
        if (S()) {
            this.f33030j = false;
            I();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i10) {
        this.f33023c = (this.f33022b * i10) / 10000.0f;
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i10, int i11, int i12, int i13) {
        super.setBounds(i10, i11, i12, i13);
        Code(i10, i12);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        super.setBounds(rect);
        Code(rect.left, rect.right);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
