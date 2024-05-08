package com.cupidapp.live.mediapicker.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;

/* compiled from: VideoTrimHandleLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VideoTrimHandleLayout extends View {

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public static final a f17436s = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public i f17437b;

    /* renamed from: c, reason: collision with root package name */
    public Paint f17438c;

    /* renamed from: d, reason: collision with root package name */
    public Paint f17439d;

    /* renamed from: e, reason: collision with root package name */
    public Paint f17440e;

    /* renamed from: f, reason: collision with root package name */
    public final float f17441f;

    /* renamed from: g, reason: collision with root package name */
    public final float f17442g;

    /* renamed from: h, reason: collision with root package name */
    public final float f17443h;

    /* renamed from: i, reason: collision with root package name */
    public float f17444i;

    /* renamed from: j, reason: collision with root package name */
    public float f17445j;

    /* renamed from: k, reason: collision with root package name */
    public int f17446k;

    /* renamed from: l, reason: collision with root package name */
    public int f17447l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public RectF f17448m;

    /* renamed from: n, reason: collision with root package name */
    public float f17449n;

    /* renamed from: o, reason: collision with root package name */
    public float f17450o;

    /* renamed from: p, reason: collision with root package name */
    public int f17451p;

    /* renamed from: q, reason: collision with root package name */
    public float f17452q;

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17453r = new LinkedHashMap();

    /* compiled from: VideoTrimHandleLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public VideoTrimHandleLayout(@Nullable Context context) {
        super(context);
        this.f17441f = z0.h.c(this, 5.0f);
        this.f17442g = z0.h.c(this, 5.0f);
        this.f17443h = z0.h.c(this, 10.0f);
        this.f17448m = new RectF();
        c();
    }

    public final void a(float f10) {
        int i10 = this.f17451p;
        if (i10 == 1) {
            float f11 = this.f17444i + f10;
            if (f11 >= this.f17443h && f11 <= this.f17445j - this.f17450o) {
                this.f17444i = f11;
                this.f17452q = f11;
                i iVar = this.f17437b;
                if (iVar != null) {
                    iVar.a(getLeftPosition(), getRightPosition(), getLeftPosition());
                }
            }
        } else if (i10 == 2) {
            float f12 = this.f17445j + f10;
            if (f12 <= this.f17446k - this.f17443h && f12 >= this.f17444i + this.f17450o) {
                this.f17445j = f12;
                this.f17452q = f12;
                i iVar2 = this.f17437b;
                if (iVar2 != null) {
                    iVar2.a(getLeftPosition(), getRightPosition(), getRightPosition());
                }
            }
        }
        invalidate();
    }

    public final int b(MotionEvent motionEvent) {
        if (motionEvent.getY() >= this.f17448m.bottom || motionEvent.getY() <= this.f17448m.top) {
            return 0;
        }
        float f10 = 2;
        if (motionEvent.getX() >= this.f17448m.left + (this.f17443h * f10) || motionEvent.getX() <= this.f17448m.left - this.f17443h) {
            return (motionEvent.getX() >= this.f17448m.right + this.f17443h || motionEvent.getX() <= this.f17448m.right - (f10 * this.f17443h)) ? 0 : 2;
        }
        return 1;
    }

    public final void c() {
        Paint paint = new Paint(1);
        paint.setStrokeWidth(this.f17441f);
        paint.setColor(-14522);
        this.f17438c = paint;
        Paint paint2 = new Paint(1);
        paint2.setColor(com.cupidapp.live.base.utils.h.a(-1, 0.4f));
        paint2.setStyle(Paint.Style.FILL);
        this.f17439d = paint2;
        Paint paint3 = new Paint(1);
        paint3.setStrokeWidth(z0.h.c(paint3, 5.0f));
        paint3.setStrokeCap(Paint.Cap.ROUND);
        paint3.setColor(-1);
        this.f17440e = paint3;
    }

    public final int getHandleWidth() {
        return (int) this.f17443h;
    }

    public final int getLeftPosition() {
        return (int) (this.f17444i - this.f17443h);
    }

    public final int getRightPosition() {
        return (int) (this.f17445j - this.f17443h);
    }

    @Override // android.view.View
    public void onDraw(@Nullable Canvas canvas) {
        Paint paint;
        Paint paint2;
        Paint paint3;
        super.onDraw(canvas);
        if (canvas == null) {
            return;
        }
        float f10 = this.f17444i;
        float height = getHeight();
        Paint paint4 = this.f17439d;
        if (paint4 == null) {
            s.A("unSelectedLayerPaint");
            paint = null;
        } else {
            paint = paint4;
        }
        canvas.drawRect(0.0f, 0.0f, f10, height, paint);
        float f11 = this.f17445j;
        float width = getWidth();
        float height2 = getHeight();
        Paint paint5 = this.f17439d;
        if (paint5 == null) {
            s.A("unSelectedLayerPaint");
            paint2 = null;
        } else {
            paint2 = paint5;
        }
        canvas.drawRect(f11, 0.0f, width, height2, paint2);
        canvas.save();
        canvas.clipRect(this.f17444i, this.f17441f, this.f17445j, getHeight() - this.f17441f, Region.Op.DIFFERENCE);
        RectF rectF = this.f17448m;
        float f12 = this.f17444i;
        float f13 = this.f17443h;
        rectF.set(f12 - f13, 0.0f, this.f17445j + f13, getHeight());
        RectF rectF2 = this.f17448m;
        float f14 = this.f17442g;
        Paint paint6 = this.f17438c;
        if (paint6 == null) {
            s.A("handlePaint");
            paint6 = null;
        }
        canvas.drawRoundRect(rectF2, f14, f14, paint6);
        canvas.restore();
        float f15 = this.f17452q;
        float height3 = getHeight();
        Paint paint7 = this.f17440e;
        if (paint7 == null) {
            s.A("positionLinePaint");
            paint3 = null;
        } else {
            paint3 = paint7;
        }
        canvas.drawLine(f15, 0.0f, f15, height3, paint3);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.f17446k = getMeasuredWidth();
        this.f17447l = getMeasuredHeight();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0011, code lost:
    
        if (r1 != 3) goto L17;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(@org.jetbrains.annotations.Nullable android.view.MotionEvent r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 != 0) goto L4
            return r0
        L4:
            int r1 = r6.getAction()
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L2f
            if (r1 == r3) goto L25
            if (r1 == r2) goto L14
            r6 = 3
            if (r1 == r6) goto L25
            goto L3f
        L14:
            float r1 = r6.getX()
            float r4 = r5.f17449n
            float r1 = r1 - r4
            float r6 = r6.getX()
            r5.f17449n = r6
            r5.a(r1)
            goto L3f
        L25:
            r5.f17451p = r0
            com.cupidapp.live.mediapicker.view.i r6 = r5.f17437b
            if (r6 == 0) goto L3f
            r6.b()
            goto L3f
        L2f:
            int r1 = r5.b(r6)
            r5.f17451p = r1
            float r6 = r6.getX()
            r5.f17449n = r6
            r6 = 0
            r5.a(r6)
        L3f:
            int r6 = r5.f17451p
            if (r6 == r3) goto L45
            if (r6 != r2) goto L46
        L45:
            r0 = 1
        L46:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.mediapicker.view.VideoTrimHandleLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void setMinDistanceBetweenHandle(double d10, long j10) {
        this.f17450o = (float) (d10 * j10);
    }

    public final void setPositionLineX(int i10) {
        this.f17452q = i10 + this.f17443h;
        invalidate();
    }

    public final void setPositionLineXInLeft() {
        this.f17452q = this.f17444i;
        invalidate();
    }

    public final void setSelectedLayerPosition(int i10, int i11) {
        float f10 = this.f17443h;
        float f11 = i10 + f10;
        this.f17444i = f11;
        this.f17445j = i11 + f10;
        this.f17452q = f11;
        invalidate();
    }

    public final void setStartAndEndMargin(int i10) {
        int i11 = i10 - ((int) this.f17443h);
        y.l(this, Integer.valueOf(i11), 0, Integer.valueOf(i11), 0);
    }

    public final void setVideoTrimHandleLayoutListener(@NotNull i listener) {
        s.i(listener, "listener");
        this.f17437b = listener;
    }

    public VideoTrimHandleLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17441f = z0.h.c(this, 5.0f);
        this.f17442g = z0.h.c(this, 5.0f);
        this.f17443h = z0.h.c(this, 10.0f);
        this.f17448m = new RectF();
        c();
    }

    public VideoTrimHandleLayout(@Nullable Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f17441f = z0.h.c(this, 5.0f);
        this.f17442g = z0.h.c(this, 5.0f);
        this.f17443h = z0.h.c(this, 10.0f);
        this.f17448m = new RectF();
        c();
    }
}
