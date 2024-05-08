package com.cupidapp.live.base.view.zoom;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.android.internal.logging.nano.MetricsProto;
import com.cupidapp.live.base.view.zoom.ZoomImgView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ZoomImgView extends View {
    public boolean A;

    /* renamed from: b, reason: collision with root package name */
    public Context f12971b;

    /* renamed from: c, reason: collision with root package name */
    public Bitmap f12972c;

    /* renamed from: d, reason: collision with root package name */
    public int f12973d;

    /* renamed from: e, reason: collision with root package name */
    public int f12974e;

    /* renamed from: f, reason: collision with root package name */
    public int f12975f;

    /* renamed from: g, reason: collision with root package name */
    public Matrix f12976g;

    /* renamed from: h, reason: collision with root package name */
    public Matrix f12977h;

    /* renamed from: i, reason: collision with root package name */
    public RectF f12978i;

    /* renamed from: j, reason: collision with root package name */
    public RectF f12979j;

    /* renamed from: k, reason: collision with root package name */
    public float f12980k;

    /* renamed from: l, reason: collision with root package name */
    public float f12981l;

    /* renamed from: m, reason: collision with root package name */
    public float f12982m;

    /* renamed from: n, reason: collision with root package name */
    public float f12983n;

    /* renamed from: o, reason: collision with root package name */
    public float f12984o;

    /* renamed from: p, reason: collision with root package name */
    public float f12985p;

    /* renamed from: q, reason: collision with root package name */
    public float f12986q;

    /* renamed from: r, reason: collision with root package name */
    public float f12987r;

    /* renamed from: s, reason: collision with root package name */
    public float f12988s;

    /* renamed from: t, reason: collision with root package name */
    public float f12989t;

    /* renamed from: u, reason: collision with root package name */
    public String f12990u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f12991v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f12992w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f12993x;

    /* renamed from: y, reason: collision with root package name */
    public float f12994y;

    /* renamed from: z, reason: collision with root package name */
    public ValueAnimator f12995z;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f12996b;

        public a(String str) {
            this.f12996b = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(Bitmap bitmap) throws Exception {
            ZoomImgView zoomImgView = ZoomImgView.this;
            zoomImgView.f12972c = bitmap;
            zoomImgView.l();
        }

        @Override // java.lang.Runnable
        public void run() {
            ZoomImgView.this.e(this.f12996b).subscribe(new Consumer() { // from class: com.cupidapp.live.base.view.zoom.i
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    ZoomImgView.a.this.c((Bitmap) obj);
                }
            }, new Consumer() { // from class: com.cupidapp.live.base.view.zoom.j
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    com.cupidapp.live.base.utils.j.a("ZoomImgView", "setImageFromPath getBitmapByPath failure");
                }
            });
        }
    }

    public ZoomImgView(Context context) {
        super(context);
        this.f12978i = new RectF();
        this.f12979j = new RectF();
        this.f12983n = -1.0f;
        this.f12984o = -1.0f;
        this.f12985p = -1.0f;
        this.f12986q = -1.0f;
        this.f12991v = false;
        this.f12992w = true;
        this.f12993x = true;
        this.A = false;
        g(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bitmap j(String str) throws Exception {
        Bitmap j10 = z0.f.j(getContext(), str, MetricsProto.MetricsEvent.ACTION_PERMISSION_REQUESTED);
        if (j10 != null) {
            return z0.f.s(j10, getContext(), str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(float f10, float f11, float f12, float f13, float f14, float f15, ValueAnimator valueAnimator) {
        this.f12973d = 4;
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f12980k = f10 * ((f11 * floatValue) + 1.0f);
        this.f12981l = f12 + (f13 * floatValue);
        this.f12982m = f14 + (f15 * floatValue);
        invalidate();
    }

    public void c(Canvas canvas) {
        this.f12976g.reset();
        Matrix matrix = this.f12976g;
        float f10 = this.f12980k;
        matrix.postScale(f10, f10);
        this.f12976g.postTranslate(this.f12981l, this.f12982m);
        canvas.drawBitmap(this.f12972c, this.f12976g, null);
    }

    public final void d() {
        RectF rectF = new RectF();
        this.f12976g.mapRect(rectF, this.f12979j);
        com.cupidapp.live.base.utils.j.b("ZOOM_IMAGE_VIEW", "src:" + ((Object) this.f12978i));
        com.cupidapp.live.base.utils.j.b("ZOOM_IMAGE_VIEW", "dst:" + ((Object) rectF));
        com.cupidapp.live.base.utils.j.b("ZOOM_IMAGE_VIEW", "src2:" + ((Object) this.f12979j));
        if (rectF.contains(this.f12978i)) {
            com.cupidapp.live.base.utils.j.b("ZOOM_IMAGE_VIEW", "contains");
            return;
        }
        com.cupidapp.live.base.utils.j.b("ZOOM_IMAGE_VIEW", "not contains");
        float width = this.f12978i.width() / rectF.width();
        if (width < 1.0f) {
            width = 1.0f;
        } else {
            Matrix matrix = new Matrix();
            matrix.postScale(width, width);
            matrix.mapRect(rectF, rectF);
        }
        RectF rectF2 = this.f12978i;
        float f10 = rectF2.left - rectF.left;
        float f11 = rectF2.top - rectF.top;
        float f12 = rectF2.right - rectF.right;
        float f13 = rectF2.bottom - rectF.bottom;
        if (f10 > 0.0f && f12 < 0.0f) {
            f10 = 0.0f;
        } else if (Math.abs(f10) > Math.abs(f12)) {
            f10 = f12;
        }
        if (f11 > 0.0f && f13 < 0.0f) {
            f11 = 0.0f;
        } else if (Math.abs(f11) > Math.abs(f13)) {
            f11 = f13;
        }
        p(width, f10, f11);
    }

    public Observable<Bitmap> e(final String str) {
        return Observable.fromCallable(new Callable() { // from class: com.cupidapp.live.base.view.zoom.h
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Bitmap j10;
                j10 = ZoomImgView.this.j(str);
                return j10;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public float f(MotionEvent motionEvent) {
        float abs = Math.abs(motionEvent.getX(0) - motionEvent.getX(1));
        float abs2 = Math.abs(motionEvent.getY(0) - motionEvent.getY(1));
        return (float) Math.sqrt((abs * abs) + (abs2 * abs2));
    }

    public final void g(Context context) {
        this.f12971b = context;
        this.f12973d = 1;
        this.f12977h = new Matrix();
        this.f12976g = new Matrix();
        this.f12980k = 1.0f;
    }

    public void h(Canvas canvas) {
        int i10;
        if (this.f12972c == null) {
            return;
        }
        this.f12979j.set(0.0f, 0.0f, r0.getWidth(), this.f12972c.getHeight());
        this.f12977h.reset();
        int width = this.f12972c.getWidth();
        int height = this.f12972c.getHeight();
        int i11 = this.f12975f;
        if (height <= i11 && width <= (i10 = this.f12974e)) {
            if (i11 - height > i10 - width) {
                float f10 = i10 / width;
                this.f12980k = f10;
                float f11 = height;
                float f12 = (i11 - (f11 * f10)) / 2.0f;
                this.f12982m = f12;
                this.f12978i.set(0.0f, f12, i10, (f11 * f10) + f12);
            } else {
                float f13 = i11 / height;
                this.f12980k = f13;
                float f14 = width;
                float f15 = (i10 - (f14 * f13)) / 2.0f;
                this.f12981l = f15;
                this.f12978i.set(f15, 0.0f, (f14 * f13) + f15, i11);
            }
            Matrix matrix = this.f12977h;
            float f16 = this.f12980k;
            matrix.postScale(f16, f16);
            this.f12977h.postTranslate(this.f12981l, this.f12982m);
        } else {
            int i12 = height - i11;
            int i13 = this.f12974e;
            if (i12 > width - i13) {
                float f17 = i11 / height;
                this.f12980k = f17;
                float f18 = width;
                float f19 = (i13 - (f18 * f17)) / 2.0f;
                this.f12981l = f19;
                this.f12978i.set(f19, 0.0f, (f18 * f17) + f19, i11);
            } else {
                float f20 = i13 / width;
                this.f12980k = f20;
                float f21 = height;
                float f22 = (i11 - (f21 * f20)) / 2.0f;
                this.f12982m = f22;
                this.f12978i.set(0.0f, f22, i13, (f21 * f20) + f22);
            }
            Matrix matrix2 = this.f12977h;
            float f23 = this.f12980k;
            matrix2.postScale(f23, f23);
            this.f12977h.postTranslate(this.f12981l, this.f12982m);
        }
        this.f12994y = this.f12980k;
        canvas.drawBitmap(this.f12972c, this.f12977h, null);
    }

    public void i() {
        this.f12987r = 0.0f;
        this.f12988s = 0.0f;
        this.f12983n = -1.0f;
        this.f12984o = -1.0f;
        if (this.f12991v) {
            d();
        }
    }

    public void l() {
        invalidate();
    }

    public void m(Canvas canvas) {
        if (this.f12972c != null) {
            this.f12976g.reset();
            Matrix matrix = this.f12976g;
            float f10 = this.f12980k;
            matrix.postScale(f10, f10);
            this.f12976g.postTranslate(this.f12981l, this.f12982m);
            canvas.drawBitmap(this.f12972c, this.f12976g, null);
        }
    }

    public void n(float f10, float f11) {
        this.f12973d = 2;
        if (this.f12983n == -1.0f && this.f12984o == -1.0f) {
            this.f12983n = f10;
            this.f12984o = f11;
        }
        float f12 = f10 - this.f12983n;
        this.f12987r = f12;
        float f13 = f11 - this.f12984o;
        this.f12988s = f13;
        this.f12981l += f12;
        this.f12982m += f13;
        this.f12984o = f11;
        this.f12983n = f10;
        invalidate();
    }

    public void o(MotionEvent motionEvent) {
        this.f12973d = 3;
        float f10 = f(motionEvent);
        float f11 = f10 / this.f12989t;
        float f12 = this.f12980k;
        float f13 = f12 * f11;
        float f14 = this.f12994y;
        if (f13 < f14 && !this.f12992w) {
            f11 = 1.0f;
        }
        float f15 = (f12 * f11 <= f14 || this.f12993x) ? f11 : 1.0f;
        this.f12980k = f12 * f15;
        float x10 = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
        float y10 = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
        this.f12981l = (x10 - (x10 * f15)) + (this.f12981l * f15);
        this.f12982m = (y10 - (y10 * f15)) + (this.f12982m * f15);
        this.f12989t = f10;
        invalidate();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        q();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i10 = this.f12973d;
        if (i10 == 1) {
            h(canvas);
            return;
        }
        if (i10 == 2) {
            m(canvas);
        } else if (i10 == 3) {
            r(canvas);
        } else {
            if (i10 != 4) {
                return;
            }
            c(canvas);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10) {
            this.f12974e = getWidth();
            this.f12975f = getHeight();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x001f, code lost:
    
        if (r0 != 6) goto L38;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent r7) {
        /*
            r6 = this;
            android.graphics.Bitmap r0 = r6.f12972c
            if (r0 != 0) goto L9
            boolean r7 = super.onTouchEvent(r7)
            return r7
        L9:
            int r0 = r7.getActionMasked()
            r1 = 0
            java.lang.String r2 = "ZOOM_IMAGE_VIEW_CLICK"
            r3 = 1
            if (r0 == 0) goto L90
            if (r0 == r3) goto L7e
            r4 = 2
            if (r0 == r4) goto L3a
            r5 = 3
            if (r0 == r5) goto L7e
            r5 = 5
            if (r0 == r5) goto L23
            r7 = 6
            if (r0 == r7) goto L7e
            goto La3
        L23:
            r6.A = r1
            java.lang.String r0 = "ACTION_POINTER_DOWN----------"
            com.cupidapp.live.base.utils.j.b(r2, r0)
            r6.q()
            int r0 = r7.getPointerCount()
            if (r0 != r4) goto La3
            float r7 = r6.f(r7)
            r6.f12989t = r7
            goto La3
        L3a:
            int r0 = r7.getPointerCount()
            if (r0 != r3) goto L4c
            float r0 = r7.getX()
            float r1 = r7.getY()
            r6.n(r0, r1)
            goto L55
        L4c:
            int r0 = r7.getPointerCount()
            if (r0 != r4) goto L55
            r6.o(r7)
        L55:
            float r0 = r7.getX()
            float r1 = r6.f12985p
            float r0 = r0 - r1
            float r0 = java.lang.Math.abs(r0)
            r1 = 1092616192(0x41200000, float:10.0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L7b
            float r0 = r7.getY()
            float r2 = r6.f12986q
            float r0 = r0 - r2
            float r0 = java.lang.Math.abs(r0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L7b
            int r7 = r7.getPointerCount()
            if (r7 != r4) goto La3
        L7b:
            r6.A = r3
            goto La3
        L7e:
            r6.i()
            boolean r7 = r6.A
            if (r7 != 0) goto La3
            r6.A = r3
            java.lang.String r7 = "CLICK----------"
            com.cupidapp.live.base.utils.j.b(r2, r7)
            r6.performClick()
            goto La3
        L90:
            r6.A = r1
            float r0 = r7.getX()
            r6.f12985p = r0
            float r7 = r7.getY()
            r6.f12986q = r7
            java.lang.String r7 = "ACTION_DOWN----------"
            com.cupidapp.live.base.utils.j.b(r2, r7)
        La3:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.base.view.zoom.ZoomImgView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p(float f10, final float f11, final float f12) {
        float f13 = f10 - 1.0f;
        final float f14 = f13 < 0.0f ? 0.0f : f13;
        final float f15 = this.f12980k;
        final float f16 = this.f12981l;
        final float f17 = this.f12982m;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f);
        this.f12995z = ofFloat;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.cupidapp.live.base.view.zoom.g
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ZoomImgView.this.k(f15, f14, f16, f11, f17, f12, valueAnimator);
            }
        });
        this.f12995z.setDuration(300L);
        this.f12995z.start();
    }

    public final void q() {
        ValueAnimator valueAnimator = this.f12995z;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public void r(Canvas canvas) {
        this.f12976g.reset();
        Matrix matrix = this.f12976g;
        float f10 = this.f12980k;
        matrix.postScale(f10, f10);
        this.f12976g.postTranslate(this.f12981l, this.f12982m);
        canvas.drawBitmap(this.f12972c, this.f12976g, null);
    }

    public void setEnlargeEnable(boolean z10) {
        this.f12993x = z10;
    }

    public void setGoBack(boolean z10) {
        this.f12991v = z10;
    }

    public void setImageFromPath(String str) {
        this.f12990u = str;
        post(new a(str));
    }

    public void setShrinkEnable(boolean z10) {
        this.f12992w = z10;
    }

    public ZoomImgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12978i = new RectF();
        this.f12979j = new RectF();
        this.f12983n = -1.0f;
        this.f12984o = -1.0f;
        this.f12985p = -1.0f;
        this.f12986q = -1.0f;
        this.f12991v = false;
        this.f12992w = true;
        this.f12993x = true;
        this.A = false;
        if (isInEditMode()) {
            return;
        }
        g(context);
    }

    public ZoomImgView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f12978i = new RectF();
        this.f12979j = new RectF();
        this.f12983n = -1.0f;
        this.f12984o = -1.0f;
        this.f12985p = -1.0f;
        this.f12986q = -1.0f;
        this.f12991v = false;
        this.f12992w = true;
        this.f12993x = true;
        this.A = false;
        g(context);
    }
}
