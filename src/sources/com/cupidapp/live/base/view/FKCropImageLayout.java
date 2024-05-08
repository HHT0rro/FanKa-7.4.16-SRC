package com.cupidapp.live.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.exifinterface.media.ExifInterface;
import com.cupidapp.live.R$styleable;
import com.cupidapp.live.base.view.zoom.ZoomImgView;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class FKCropImageLayout extends ZoomImgView {
    public Paint B;
    public Paint C;
    public Paint D;
    public Paint E;
    public float F;
    public float G;
    public float H;
    public float I;
    public float J;
    public float K;
    public boolean L;
    public float M;
    public float N;
    public float O;
    public float P;
    public float Q;
    public float R;
    public float S;
    public float T;
    public a U;
    public a V;
    public boolean W;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f12463a0;

    /* renamed from: b0, reason: collision with root package name */
    public float f12464b0;

    /* renamed from: c0, reason: collision with root package name */
    public float f12465c0;

    /* renamed from: d0, reason: collision with root package name */
    public float f12466d0;

    /* renamed from: e0, reason: collision with root package name */
    public float f12467e0;

    /* renamed from: f0, reason: collision with root package name */
    public float f12468f0;

    /* renamed from: g0, reason: collision with root package name */
    public float f12469g0;

    /* renamed from: h0, reason: collision with root package name */
    public float f12470h0;

    /* renamed from: i0, reason: collision with root package name */
    public float f12471i0;

    /* renamed from: j0, reason: collision with root package name */
    public float f12472j0;

    /* renamed from: k0, reason: collision with root package name */
    public float f12473k0;

    /* renamed from: l0, reason: collision with root package name */
    public float f12474l0;

    /* renamed from: m0, reason: collision with root package name */
    public float f12475m0;

    /* renamed from: n0, reason: collision with root package name */
    public int f12476n0;

    /* renamed from: o0, reason: collision with root package name */
    public final int f12477o0;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public float f12478a;

        /* renamed from: b, reason: collision with root package name */
        public float f12479b;

        /* renamed from: c, reason: collision with root package name */
        public float f12480c;

        /* renamed from: d, reason: collision with root package name */
        public float f12481d;

        /* renamed from: e, reason: collision with root package name */
        public Paint f12482e;

        /* renamed from: f, reason: collision with root package name */
        public Paint f12483f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f12484g;

        public a() {
            Paint paint = new Paint();
            this.f12482e = paint;
            paint.setColor(-1);
            Paint paint2 = new Paint();
            this.f12483f = paint2;
            paint2.setColor(-65536);
        }

        public void a(Canvas canvas, float f10, float f11, float f12, float f13) {
            this.f12478a = f10;
            this.f12481d = f13;
            this.f12479b = f12;
            this.f12480c = f11;
            canvas.drawCircle(((f12 - f10) / 2.0f) + f10, ((f13 - f11) / 2.0f) + f11, z0.h.c(this, 4.0f), this.f12482e);
        }

        public float b() {
            return this.f12481d;
        }

        public float c() {
            return this.f12478a;
        }

        public float d() {
            return this.f12479b;
        }

        public float e() {
            return this.f12480c;
        }

        public boolean f() {
            return this.f12484g;
        }

        public void g(int i10) {
            this.f12482e.setColor(i10);
        }

        public void h(boolean z10) {
            this.f12484g = z10;
        }
    }

    public FKCropImageLayout(Context context) {
        super(context);
        this.f12464b0 = 1.7777778f;
        this.f12465c0 = 0.75f;
        this.f12477o0 = z0.h.c(this, 315.0f);
    }

    public Bitmap getCropBitmap() {
        float height = this.f12972c.getHeight() * this.f12980k;
        float width = this.f12972c.getWidth() * this.f12980k;
        return Bitmap.createBitmap(this.f12972c, (int) (((this.G - this.f12981l) / width) * this.f12972c.getWidth()), (int) (((this.F - this.f12982m) / height) * this.f12972c.getHeight()), (int) ((this.K / width) * this.f12972c.getWidth()), (int) ((this.J / height) * this.f12972c.getHeight()));
    }

    @Override // com.cupidapp.live.base.view.zoom.ZoomImgView
    public void h(Canvas canvas) {
        if (this.f12972c == null) {
            return;
        }
        this.f12976g.reset();
        float v2 = v(this.K, this.J, this.f12972c.getWidth(), this.f12972c.getHeight());
        this.T = v2;
        this.f12980k = v2;
        this.f12982m = (this.f12975f - (this.f12972c.getHeight() * this.f12980k)) / 2.0f;
        float f10 = this.f12974e;
        float width = this.f12972c.getWidth();
        float f11 = this.f12980k;
        this.f12981l = (f10 - (width * f11)) / 2.0f;
        this.f12976g.postScale(f11, f11);
        this.f12976g.postTranslate(this.f12981l, this.f12982m);
        canvas.drawBitmap(this.f12972c, this.f12976g, null);
    }

    @Override // com.cupidapp.live.base.view.zoom.ZoomImgView
    public void i() {
        super.i();
        this.f12463a0 = false;
    }

    @Override // com.cupidapp.live.base.view.zoom.ZoomImgView
    public void l() {
        this.f12973d = 1;
        Bitmap bitmap = this.f12972c;
        if (bitmap != null) {
            int width = bitmap.getWidth() - this.f12972c.getHeight();
            if (width > -5 && width < 5) {
                this.f12476n0 = 0;
            } else if (width >= 5) {
                float width2 = this.f12972c.getWidth() / this.f12972c.getHeight();
                if (width2 < this.f12464b0) {
                    this.f12464b0 = width2;
                }
                this.f12476n0 = 2;
            } else {
                this.f12476n0 = 1;
            }
        }
        s();
        super.l();
    }

    @Override // com.cupidapp.live.base.view.zoom.ZoomImgView
    public void n(float f10, float f11) {
        this.f12973d = 2;
        if (this.f12983n == -1.0f && this.f12984o == -1.0f) {
            this.f12983n = f10;
            this.f12984o = f11;
        }
        float f12 = this.f12981l;
        float f13 = this.f12982m;
        float f14 = f10 - this.f12983n;
        float f15 = f11 - this.f12984o;
        float f16 = f12 + f14;
        float f17 = f13 + f15;
        float height = this.H - (this.f12972c.getHeight() * this.f12980k);
        float f18 = this.F;
        float width = this.I - (this.f12972c.getWidth() * this.f12980k);
        float f19 = this.G;
        if (f17 >= height && f17 <= f18) {
            this.f12988s = f15;
            this.f12984o = f11;
            this.f12982m = f17;
        } else if (f17 < height) {
            this.f12982m = height;
        } else {
            this.f12982m = f18;
        }
        if (f16 >= width && f16 <= f19) {
            this.f12987r = f14;
            this.f12983n = f10;
            this.f12981l = f16;
        } else if (f16 < width) {
            this.f12981l = width;
        } else {
            this.f12981l = f19;
        }
        invalidate();
    }

    @Override // com.cupidapp.live.base.view.zoom.ZoomImgView
    public void o(MotionEvent motionEvent) {
        this.f12973d = 3;
        float f10 = f(motionEvent);
        float f11 = f10 / this.f12989t;
        float f12 = this.f12980k * f11;
        float x10 = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
        float y10 = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
        float f13 = (x10 - (x10 * f11)) + (this.f12981l * f11);
        float f14 = (y10 - (y10 * f11)) + (this.f12982m * f11);
        float f15 = this.f12980k;
        if (f12 < f15) {
            if (f15 == this.T) {
                return;
            }
            if (this.f12972c.getWidth() * f12 <= this.K || this.f12972c.getHeight() * f12 <= this.J) {
                f12 = this.T;
            }
            float height = this.H - (this.f12972c.getHeight() * f12);
            float f16 = this.F;
            float width = this.I - (this.f12972c.getWidth() * f12);
            float f17 = this.G;
            if (f14 < height || f14 > f16 || f13 < width || f13 > f17) {
                if (f14 <= height) {
                    f14 = height;
                } else if (f14 >= f16) {
                    f14 = f16;
                }
                if (f13 <= width) {
                    f13 = width;
                } else if (f13 >= f17) {
                    f13 = f17;
                }
            }
        }
        if (f12 > 2.0f) {
            return;
        }
        this.f12981l = f13;
        this.f12982m = f14;
        this.f12980k = f12;
        this.f12989t = f10;
        invalidate();
    }

    @Override // com.cupidapp.live.base.view.zoom.ZoomImgView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        y(canvas);
    }

    @Override // com.cupidapp.live.base.view.zoom.ZoomImgView, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0051, code lost:
    
        if (r2 != 3) goto L34;
     */
    @Override // com.cupidapp.live.base.view.zoom.ZoomImgView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.graphics.Bitmap r0 = r5.f12972c
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r5.f12476n0
            if (r0 == 0) goto Laa
            boolean r0 = r5.L
            if (r0 == 0) goto L10
            goto Laa
        L10:
            boolean r0 = r5.f12463a0
            if (r0 == 0) goto L18
            boolean r0 = r5.W
            if (r0 == 0) goto La5
        L18:
            r0 = 1
            r5.f12463a0 = r0
            boolean r2 = r5.W
            if (r2 != 0) goto L41
            com.cupidapp.live.base.view.FKCropImageLayout$a r2 = r5.U
            float r3 = r6.getX()
            float r4 = r6.getY()
            boolean r2 = r5.t(r2, r3, r4)
            if (r2 != 0) goto L3f
            com.cupidapp.live.base.view.FKCropImageLayout$a r2 = r5.V
            float r3 = r6.getX()
            float r4 = r6.getY()
            boolean r2 = r5.t(r2, r3, r4)
            if (r2 == 0) goto L41
        L3f:
            r5.W = r0
        L41:
            boolean r2 = r5.W
            if (r2 == 0) goto La5
            int r2 = r6.getAction()
            if (r2 == 0) goto L88
            if (r2 == r0) goto L66
            r3 = 2
            if (r2 == r3) goto L54
            r6 = 3
            if (r2 == r6) goto L66
            goto La4
        L54:
            float r1 = r6.getX()
            float r6 = r6.getY()
            com.cupidapp.live.base.view.FKCropImageLayout$a r2 = r5.U
            boolean r2 = r2.f()
            r5.z(r1, r6, r2)
            goto La4
        L66:
            r5.W = r1
            r5.i()
            float r6 = r5.I
            float r1 = r5.G
            float r6 = r6 - r1
            float r1 = r5.H
            float r2 = r5.F
            float r1 = r1 - r2
            android.graphics.Bitmap r2 = r5.f12972c
            int r2 = r2.getWidth()
            android.graphics.Bitmap r3 = r5.f12972c
            int r3 = r3.getHeight()
            float r6 = r5.v(r6, r1, r2, r3)
            r5.T = r6
            goto La4
        L88:
            float r1 = r6.getX()
            r5.N = r1
            float r6 = r6.getY()
            r5.O = r6
            float r6 = r5.F
            r5.P = r6
            float r6 = r5.H
            r5.R = r6
            float r6 = r5.G
            r5.Q = r6
            float r6 = r5.I
            r5.S = r6
        La4:
            return r0
        La5:
            boolean r6 = super.onTouchEvent(r6)
            return r6
        Laa:
            boolean r6 = super.onTouchEvent(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.base.view.FKCropImageLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void s() {
        float f10;
        float f11 = 0.0f;
        if (this.L) {
            this.G = 0.0f;
            int i10 = this.f12975f;
            this.H = i10;
            this.F = 0.0f;
            int i11 = this.f12974e;
            this.I = i11;
            this.J = i10;
            this.K = i11;
            return;
        }
        float f12 = this.J;
        if (f12 > 0.0f) {
            float f13 = this.K;
            if (f13 > 0.0f) {
                this.f12476n0 = 0;
                float f14 = (this.f12974e - f13) / 2.0f;
                this.G = f14;
                this.I = f14 + f13;
                float f15 = (this.f12975f - f12) / 2.0f;
                this.F = f15;
                this.H = f15 + f12;
                return;
            }
        }
        int i12 = this.f12476n0;
        if (i12 != 0) {
            if (i12 == 1) {
                int i13 = this.f12974e;
                int i14 = this.f12975f;
                float f16 = i13 / i14;
                float f17 = this.f12465c0;
                if (f16 > f17) {
                    float f18 = i14 * 0.9f;
                    this.f12470h0 = f18;
                    float f19 = f18 * f17;
                    this.f12471i0 = f19;
                    f11 = f19;
                    f10 = f18;
                } else {
                    f11 = i13 * 0.9f;
                    this.f12471i0 = f11;
                    f10 = f11 / f17;
                    this.f12470h0 = f10;
                }
            } else if (i12 != 2) {
                f10 = 0.0f;
            } else {
                f11 = this.f12974e * 0.9f;
                this.f12471i0 = f11;
                f10 = f11 / this.f12464b0;
                this.f12470h0 = f10;
            }
            int i15 = this.f12974e;
            float f20 = (i15 - f11) / 2.0f;
            this.G = f20;
            this.I = f20 + f11;
            float f21 = (this.f12975f - f10) / 2.0f;
            this.F = f21;
            this.H = f21 + f10;
            this.f12473k0 = (i15 - Math.min(f10, f11)) / 2.0f;
            this.f12472j0 = (this.f12975f - Math.min(f10, f11)) / 2.0f;
            this.f12475m0 = this.f12473k0 + Math.min(f10, f11);
            this.f12474l0 = this.f12472j0 + Math.min(f10, f11);
            float f22 = this.f12974e;
            float f23 = this.f12471i0;
            float f24 = (f22 - f23) / 2.0f;
            this.f12467e0 = f24;
            this.f12469g0 = f24 + f23;
            float f25 = this.f12975f;
            float f26 = this.f12470h0;
            float f27 = (f25 - f26) / 2.0f;
            this.f12466d0 = f27;
            this.f12468f0 = f27 + f26;
            this.J = f10;
            this.K = f11;
            return;
        }
        int i16 = this.f12477o0;
        this.J = i16;
        this.K = i16;
        s();
    }

    public final boolean t(a aVar, float f10, float f11) {
        aVar.h(f10 > aVar.c() && f10 < aVar.d() && f11 < aVar.b() && f11 > aVar.e());
        return aVar.f();
    }

    public final float u(Float f10) {
        if (f10.floatValue() < 0.0f) {
            f10 = Float.valueOf(0.0f);
        } else if (f10.floatValue() > 1.0f) {
            f10 = Float.valueOf(1.0f);
        }
        return f10.floatValue();
    }

    public float v(float f10, float f11, int i10, int i11) {
        float f12 = i10;
        float f13 = i11;
        return f10 / f11 > (1.0f * f12) / f13 ? f10 / f12 : f11 / f13;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00b0 A[Catch: all -> 0x011f, TryCatch #0 {all -> 0x011f, blocks: (B:16:0x0098, B:18:0x00b0, B:19:0x00bb, B:21:0x00ec, B:23:0x00ff, B:24:0x0103, B:28:0x010e, B:31:0x00b9), top: B:15:0x0098 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ec A[Catch: all -> 0x011f, TryCatch #0 {all -> 0x011f, blocks: (B:16:0x0098, B:18:0x00b0, B:19:0x00bb, B:21:0x00ec, B:23:0x00ff, B:24:0x0103, B:28:0x010e, B:31:0x00b9), top: B:15:0x0098 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ff A[Catch: all -> 0x011f, TryCatch #0 {all -> 0x011f, blocks: (B:16:0x0098, B:18:0x00b0, B:19:0x00bb, B:21:0x00ec, B:23:0x00ff, B:24:0x0103, B:28:0x010e, B:31:0x00b9), top: B:15:0x0098 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b9 A[Catch: all -> 0x011f, TryCatch #0 {all -> 0x011f, blocks: (B:16:0x0098, B:18:0x00b0, B:19:0x00bb, B:21:0x00ec, B:23:0x00ff, B:24:0x0103, B:28:0x010e, B:31:0x00b9), top: B:15:0x0098 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.graphics.Bitmap w(float r19) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.base.view.FKCropImageLayout.w(float):android.graphics.Bitmap");
    }

    public int x(String str) {
        try {
            return new ExifInterface(str).getAttributeInt(ExifInterface.TAG_ORIENTATION, 0);
        } catch (IOException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public void y(Canvas canvas) {
        if (this.f12972c == null) {
            return;
        }
        this.J = this.H - this.F;
        this.K = this.I - this.G;
        canvas.save();
        Path path = new Path();
        float f10 = this.G;
        float f11 = this.F;
        float f12 = this.I;
        float f13 = this.H;
        float f14 = this.M;
        path.addRoundRect(f10, f11, f12, f13, f14, f14, Path.Direction.CW);
        canvas.clipPath(path, Region.Op.DIFFERENCE);
        canvas.drawRect(0.0f, 0.0f, this.f12974e, this.f12975f, this.D);
        canvas.restore();
        float f15 = this.G;
        float f16 = this.F;
        float f17 = this.I;
        float f18 = this.H;
        float f19 = this.M;
        canvas.drawRoundRect(f15, f16, f17, f18, f19, f19, this.B);
        float f20 = this.G;
        float f21 = this.F;
        float f22 = this.J;
        float f23 = this.I;
        float f24 = this.K;
        float f25 = this.H;
        canvas.drawLines(new float[]{f20, (f22 / 3.0f) + f21, f23, (f22 / 3.0f) + f21, f20, ((f22 / 3.0f) * 2.0f) + f21, f23, ((f22 / 3.0f) * 2.0f) + f21, (f24 / 3.0f) + f20, f21, (f24 / 3.0f) + f20, f25, ((f24 / 3.0f) * 2.0f) + f20, f21, f20 + ((f24 / 3.0f) * 2.0f), f25}, this.E);
        if (this.L) {
            return;
        }
        int i10 = this.f12476n0;
        if (i10 == 1) {
            float f26 = this.I;
            float f27 = this.G;
            float f28 = ((f26 - f27) / 2.0f) + f27;
            a aVar = this.U;
            float f29 = f28 - 100.0f;
            float f30 = this.F;
            float f31 = f28 + 100.0f;
            aVar.a(canvas, f29, f30 - 100.0f, f31, f30 + 100.0f);
            a aVar2 = this.V;
            float f32 = this.H;
            aVar2.a(canvas, f29, f32 - 100.0f, f31, f32 + 100.0f);
            return;
        }
        if (i10 != 2) {
            return;
        }
        float f33 = this.H;
        float f34 = this.F;
        float f35 = ((f33 - f34) / 2.0f) + f34;
        a aVar3 = this.U;
        float f36 = this.G;
        float f37 = f35 - 100.0f;
        float f38 = f35 + 100.0f;
        aVar3.a(canvas, f36 - 100.0f, f37, f36 + 100.0f, f38);
        a aVar4 = this.V;
        float f39 = this.I;
        aVar4.a(canvas, f39 - 100.0f, f37, f39 + 100.0f, f38);
    }

    public final void z(float f10, float f11, boolean z10) {
        int i10 = this.f12476n0;
        if (i10 == 1) {
            float f12 = f11 - this.O;
            if (z10) {
                f12 = -f12;
            }
            float f13 = this.F;
            float f14 = this.H;
            float f15 = this.P - f12;
            this.F = f15;
            float f16 = this.R + f12;
            this.H = f16;
            float f17 = this.f12466d0;
            if (f15 >= f17 && f16 <= this.f12468f0) {
                float f18 = this.f12472j0;
                if (f15 <= f18 && f16 >= this.f12474l0) {
                    float height = this.f12980k * this.f12972c.getHeight();
                    float f19 = this.f12982m;
                    if (f16 >= height + f19 || this.F <= f19) {
                        if (this.F <= f19) {
                            float f20 = this.H;
                            float height2 = this.f12980k * this.f12972c.getHeight();
                            float f21 = this.f12982m;
                            if (f20 >= height2 + f21) {
                                this.F = f21;
                                this.H = (this.f12980k * this.f12972c.getHeight()) + this.f12982m;
                                invalidate();
                                return;
                            }
                        }
                        n(f10, f11);
                        return;
                    }
                } else {
                    if (f15 > f18) {
                        this.F = f18;
                    }
                    float f22 = this.f12474l0;
                    if (f16 < f22) {
                        this.H = f22;
                    }
                    invalidate();
                    return;
                }
            } else {
                float f23 = this.f12982m;
                if (f23 == f13) {
                    this.f12982m = f17;
                } else if (f23 == f14 - (this.f12972c.getHeight() * this.f12980k)) {
                    this.f12982m = this.f12468f0 - (this.f12972c.getHeight() * this.f12980k);
                }
                float f24 = this.F;
                float f25 = this.f12466d0;
                if (f24 < f25) {
                    this.F = f25;
                }
                float f26 = this.H;
                float f27 = this.f12468f0;
                if (f26 > f27) {
                    this.H = f27;
                }
                invalidate();
                return;
            }
        } else if (i10 == 2) {
            float f28 = f10 - this.N;
            if (z10) {
                f28 = -f28;
            }
            float f29 = this.G;
            float f30 = this.I;
            float f31 = this.Q - f28;
            this.G = f31;
            float f32 = this.S + f28;
            this.I = f32;
            float f33 = this.f12467e0;
            if (f31 >= f33 && f32 <= this.f12469g0) {
                float f34 = this.f12473k0;
                if (f31 <= f34 && f32 >= this.f12475m0) {
                    float width = this.f12980k * this.f12972c.getWidth();
                    float f35 = this.f12981l;
                    if (f32 >= width + f35 || this.G <= f35) {
                        if (this.G <= f35) {
                            float f36 = this.I;
                            float width2 = this.f12980k * this.f12972c.getWidth();
                            float f37 = this.f12981l;
                            if (f36 >= width2 + f37) {
                                this.G = f37;
                                this.I = (this.f12980k * this.f12972c.getWidth()) + this.f12981l;
                                invalidate();
                                return;
                            }
                        }
                        n(f10, f11);
                        return;
                    }
                } else {
                    if (f31 > f34) {
                        this.G = f34;
                    }
                    float f38 = this.f12475m0;
                    if (f32 < f38) {
                        this.I = f38;
                    }
                    invalidate();
                    return;
                }
            } else {
                float f39 = this.f12981l;
                if (f39 == f29) {
                    this.f12981l = f33;
                } else if (f39 == f30 - (this.f12972c.getWidth() * this.f12980k)) {
                    this.f12981l = this.f12469g0 - (this.f12972c.getWidth() * this.f12980k);
                }
                float f40 = this.G;
                float f41 = this.f12467e0;
                if (f40 < f41) {
                    this.G = f41;
                }
                float f42 = this.I;
                float f43 = this.f12469g0;
                if (f42 > f43) {
                    this.I = f43;
                }
                invalidate();
                return;
            }
        }
        invalidate();
    }

    public FKCropImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12464b0 = 1.7777778f;
        this.f12465c0 = 0.75f;
        int c4 = z0.h.c(this, 315.0f);
        this.f12477o0 = c4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FKCropImageLayout);
        boolean z10 = obtainStyledAttributes.getBoolean(4, false);
        int color = obtainStyledAttributes.getColor(6, -1);
        int color2 = obtainStyledAttributes.getColor(2, com.cupidapp.live.base.utils.h.a(-16777216, 0.8f));
        this.M = obtainStyledAttributes.getDimensionPixelSize(3, 0);
        this.J = obtainStyledAttributes.getDimensionPixelSize(7, 0);
        this.K = obtainStyledAttributes.getDimensionPixelSize(10, 0);
        float f10 = this.J;
        if (f10 == 0.0f && z10) {
            this.J = c4;
            this.K = c4;
        } else if (f10 == 0.0f) {
            this.J = obtainStyledAttributes.getDimensionPixelSize(7, 0);
            this.K = obtainStyledAttributes.getDimensionPixelSize(10, 0);
        }
        this.L = obtainStyledAttributes.getInteger(8, 1) == 0;
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.B = paint;
        paint.setColor(color);
        this.B.setStrokeWidth(z0.h.c(this, 3.0f));
        this.B.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.C = paint2;
        paint2.setColor(-65536);
        this.C.setStyle(Paint.Style.FILL);
        this.C.setXfermode(new Xfermode());
        Paint paint3 = new Paint();
        this.D = paint3;
        paint3.setColor(color2);
        this.D.setStyle(Paint.Style.FILL);
        a aVar = new a();
        this.U = aVar;
        aVar.g(color);
        a aVar2 = new a();
        this.V = aVar2;
        aVar2.g(color);
        Paint paint4 = new Paint();
        this.E = paint4;
        paint4.setColor(com.cupidapp.live.base.utils.h.a(-1, 0.25f));
        this.E.setStrokeWidth(z0.h.c(this, 1.0f));
    }

    public FKCropImageLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f12464b0 = 1.7777778f;
        this.f12465c0 = 0.75f;
        this.f12477o0 = z0.h.c(this, 315.0f);
    }
}
