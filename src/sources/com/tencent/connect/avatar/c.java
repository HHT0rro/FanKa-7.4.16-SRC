package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

/* compiled from: ProGuard */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    public final String f42537a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f42538b;

    /* renamed from: c, reason: collision with root package name */
    private Matrix f42539c;

    /* renamed from: d, reason: collision with root package name */
    private Matrix f42540d;

    /* renamed from: e, reason: collision with root package name */
    private int f42541e;

    /* renamed from: f, reason: collision with root package name */
    private float f42542f;

    /* renamed from: g, reason: collision with root package name */
    private float f42543g;

    /* renamed from: h, reason: collision with root package name */
    private Bitmap f42544h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f42545i;

    /* renamed from: j, reason: collision with root package name */
    private float f42546j;

    /* renamed from: k, reason: collision with root package name */
    private float f42547k;

    /* renamed from: l, reason: collision with root package name */
    private PointF f42548l;

    /* renamed from: m, reason: collision with root package name */
    private PointF f42549m;

    /* renamed from: n, reason: collision with root package name */
    private float f42550n;

    /* renamed from: o, reason: collision with root package name */
    private float f42551o;

    /* renamed from: p, reason: collision with root package name */
    private Rect f42552p;

    public c(Context context) {
        super(context);
        this.f42539c = new Matrix();
        this.f42540d = new Matrix();
        this.f42541e = 0;
        this.f42542f = 1.0f;
        this.f42543g = 1.0f;
        this.f42545i = false;
        this.f42537a = "TouchView";
        this.f42548l = new PointF();
        this.f42549m = new PointF();
        this.f42550n = 1.0f;
        this.f42551o = 0.0f;
        this.f42538b = false;
        Rect rect = new Rect();
        this.f42552p = rect;
        getDrawingRect(rect);
        a();
    }

    private void a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        boolean z10;
        Animation animation;
        if (this.f42544h == null) {
            return;
        }
        float width = this.f42552p.width();
        float height = this.f42552p.height();
        float[] fArr = new float[9];
        this.f42539c.getValues(fArr);
        float f10 = fArr[2];
        float f11 = fArr[5];
        float f12 = fArr[0];
        float f13 = this.f42542f;
        if (f12 > f13) {
            float f14 = f13 / f12;
            this.f42551o = f14;
            Matrix matrix = this.f42539c;
            PointF pointF = this.f42549m;
            matrix.postScale(f14, f14, pointF.x, pointF.y);
            setImageMatrix(this.f42539c);
            float f15 = this.f42551o;
            float f16 = 1.0f / f15;
            float f17 = 1.0f / f15;
            PointF pointF2 = this.f42549m;
            animation = new ScaleAnimation(f16, 1.0f, f17, 1.0f, pointF2.x, pointF2.y);
        } else {
            float f18 = this.f42543g;
            if (f12 < f18) {
                float f19 = f18 / f12;
                this.f42551o = f19;
                Matrix matrix2 = this.f42539c;
                PointF pointF3 = this.f42549m;
                matrix2.postScale(f19, f19, pointF3.x, pointF3.y);
                float f20 = this.f42551o;
                PointF pointF4 = this.f42549m;
                animation = new ScaleAnimation(1.0f, f20, 1.0f, f20, pointF4.x, pointF4.y);
            } else {
                float width2 = this.f42544h.getWidth() * f12;
                float height2 = this.f42544h.getHeight() * f12;
                Rect rect = this.f42552p;
                int i10 = rect.left;
                float f21 = i10 - f10;
                int i11 = rect.top;
                float f22 = i11 - f11;
                if (f21 < 0.0f) {
                    f10 = i10;
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (f22 < 0.0f) {
                    f11 = i11;
                    z10 = true;
                }
                float f23 = height2 - f22;
                if (width2 - f21 < width) {
                    f10 = i10 - (width2 - width);
                    z10 = true;
                }
                if (f23 < height) {
                    f11 = i11 - (height2 - height);
                    z10 = true;
                }
                if (z10) {
                    float f24 = fArr[2] - f10;
                    float f25 = fArr[5] - f11;
                    fArr[2] = f10;
                    fArr[5] = f11;
                    this.f42539c.setValues(fArr);
                    setImageMatrix(this.f42539c);
                    animation = new TranslateAnimation(f24, 0.0f, f25, 0.0f);
                } else {
                    setImageMatrix(this.f42539c);
                    animation = null;
                }
            }
        }
        if (animation != null) {
            this.f42545i = true;
            animation.setDuration(300L);
            startAnimation(animation);
            new Thread(new Runnable() { // from class: com.tencent.connect.avatar.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Thread.sleep(300L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                    c.this.post(new Runnable() { // from class: com.tencent.connect.avatar.c.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.clearAnimation();
                            c.this.b();
                        }
                    });
                    c.this.f42545i = false;
                }
            }).start();
        }
    }

    private void c() {
        if (this.f42544h == null) {
            return;
        }
        this.f42539c.getValues(r0);
        float max = Math.max(this.f42552p.width() / this.f42544h.getWidth(), this.f42552p.height() / this.f42544h.getHeight());
        this.f42546j = this.f42552p.left - (((this.f42544h.getWidth() * max) - this.f42552p.width()) / 2.0f);
        float height = this.f42552p.top - (((this.f42544h.getHeight() * max) - this.f42552p.height()) / 2.0f);
        this.f42547k = height;
        float[] fArr = {max, 0.0f, this.f42546j, 0.0f, max, height};
        this.f42539c.setValues(fArr);
        float min = Math.min(2048.0f / this.f42544h.getWidth(), 2048.0f / this.f42544h.getHeight());
        this.f42542f = min;
        this.f42543g = max;
        if (min < max) {
            this.f42542f = max;
        }
        setImageMatrix(this.f42539c);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0019, code lost:
    
        if (r0 != 6) goto L28;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            boolean r0 = r5.f42545i
            r1 = 1
            if (r0 == 0) goto L6
            return r1
        L6:
            int r0 = r6.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            if (r0 == 0) goto L90
            if (r0 == r1) goto L89
            r2 = 1092616192(0x41200000, float:10.0)
            r3 = 2
            if (r0 == r3) goto L37
            r4 = 5
            if (r0 == r4) goto L1d
            r6 = 6
            if (r0 == r6) goto L89
            goto Laf
        L1d:
            float r6 = r5.a(r6)
            r5.f42550n = r6
            int r6 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r6 <= 0) goto Laf
            android.graphics.Matrix r6 = r5.f42540d
            android.graphics.Matrix r0 = r5.f42539c
            r6.set(r0)
            android.graphics.PointF r6 = r5.f42549m
            r5.a(r6)
            r5.f42541e = r3
            goto Laf
        L37:
            int r0 = r5.f42541e
            if (r0 != r1) goto L5f
            android.graphics.Matrix r0 = r5.f42539c
            android.graphics.Matrix r2 = r5.f42540d
            r0.set(r2)
            float r0 = r6.getX()
            android.graphics.PointF r2 = r5.f42548l
            float r2 = r2.x
            float r0 = r0 - r2
            float r6 = r6.getY()
            android.graphics.PointF r2 = r5.f42548l
            float r2 = r2.y
            float r6 = r6 - r2
            android.graphics.Matrix r2 = r5.f42539c
            r2.postTranslate(r0, r6)
            android.graphics.Matrix r6 = r5.f42539c
            r5.setImageMatrix(r6)
            goto Laf
        L5f:
            if (r0 != r3) goto Laf
            android.graphics.Matrix r0 = r5.f42539c
            r0.set(r0)
            float r6 = r5.a(r6)
            int r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r0 <= 0) goto L83
            android.graphics.Matrix r0 = r5.f42539c
            android.graphics.Matrix r2 = r5.f42540d
            r0.set(r2)
            float r0 = r5.f42550n
            float r6 = r6 / r0
            android.graphics.Matrix r0 = r5.f42539c
            android.graphics.PointF r2 = r5.f42549m
            float r3 = r2.x
            float r2 = r2.y
            r0.postScale(r6, r6, r3, r2)
        L83:
            android.graphics.Matrix r6 = r5.f42539c
            r5.setImageMatrix(r6)
            goto Laf
        L89:
            r5.b()
            r6 = 0
            r5.f42541e = r6
            goto Laf
        L90:
            android.graphics.Matrix r0 = r5.f42539c
            android.graphics.Matrix r2 = r5.getImageMatrix()
            r0.set(r2)
            android.graphics.Matrix r0 = r5.f42540d
            android.graphics.Matrix r2 = r5.f42539c
            r0.set(r2)
            android.graphics.PointF r0 = r5.f42548l
            float r2 = r6.getX()
            float r6 = r6.getY()
            r0.set(r2, r6)
            r5.f42541e = r1
        Laf:
            r5.f42538b = r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.avatar.c.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.f42544h = bitmap;
        if (bitmap != null) {
            this.f42544h = bitmap;
        }
    }

    private float a(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() < 2) {
            return 0.0f;
        }
        float x10 = motionEvent.getX(0) - motionEvent.getX(1);
        float y10 = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x10 * x10) + (y10 * y10));
    }

    public void a(Rect rect) {
        this.f42552p = rect;
        if (this.f42544h != null) {
            c();
        }
    }

    private void a(PointF pointF) {
        if (this.f42544h == null) {
            return;
        }
        float[] fArr = new float[9];
        this.f42539c.getValues(fArr);
        float f10 = fArr[2];
        float f11 = fArr[5];
        float f12 = fArr[0];
        float width = this.f42544h.getWidth() * f12;
        float height = this.f42544h.getHeight() * f12;
        Rect rect = this.f42552p;
        float f13 = rect.left - f10;
        if (f13 <= 1.0f) {
            f13 = 1.0f;
        }
        float f14 = (f10 + width) - rect.right;
        if (f14 <= 1.0f) {
            f14 = 1.0f;
        }
        float width2 = (rect.width() * f13) / (f14 + f13);
        Rect rect2 = this.f42552p;
        float f15 = width2 + rect2.left;
        float f16 = rect2.top - f11;
        float f17 = (f11 + height) - rect2.bottom;
        if (f16 <= 1.0f) {
            f16 = 1.0f;
        }
        pointF.set(f15, ((rect2.height() * f16) / ((f17 > 1.0f ? f17 : 1.0f) + f16)) + this.f42552p.top);
    }
}
