package com.tencent.cloud.huiyansdkface.facelight.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.os.CountDownTimer;
import android.view.View;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.tencent.cloud.huiyansdkface.facelight.c.f;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b extends View {

    /* renamed from: a, reason: collision with root package name */
    private static final String f41164a = b.class.getSimpleName();

    /* renamed from: b, reason: collision with root package name */
    private float f41165b;

    /* renamed from: c, reason: collision with root package name */
    private int f41166c;

    /* renamed from: d, reason: collision with root package name */
    private int f41167d;

    /* renamed from: e, reason: collision with root package name */
    private float[] f41168e;

    /* renamed from: f, reason: collision with root package name */
    private float[] f41169f;

    /* renamed from: g, reason: collision with root package name */
    private float[] f41170g;

    /* renamed from: h, reason: collision with root package name */
    private int f41171h;

    /* renamed from: i, reason: collision with root package name */
    private int f41172i;

    /* renamed from: j, reason: collision with root package name */
    private int f41173j;

    /* renamed from: k, reason: collision with root package name */
    private int f41174k;

    /* renamed from: l, reason: collision with root package name */
    private Paint f41175l;

    /* renamed from: m, reason: collision with root package name */
    private DrawFilter f41176m;

    /* renamed from: n, reason: collision with root package name */
    private float f41177n;

    /* renamed from: o, reason: collision with root package name */
    private float f41178o;

    /* renamed from: p, reason: collision with root package name */
    private float f41179p;

    /* renamed from: q, reason: collision with root package name */
    private CountDownTimer f41180q;

    /* renamed from: r, reason: collision with root package name */
    private CountDownTimer f41181r;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void a();
    }

    public b(Context context) {
        super(context);
        this.f41177n = 0.0f;
        this.f41179p = 0.0f;
        this.f41171h = f.a(context, 6.0f);
        this.f41172i = f.a(context, 8.0f);
        Paint paint = new Paint();
        this.f41175l = paint;
        paint.setAntiAlias(true);
        this.f41175l.setStyle(Paint.Style.FILL);
        this.f41175l.setColor(452984831);
        this.f41176m = new PaintFlagsDrawFilter(0, 3);
    }

    private void a() {
        float[] fArr;
        float[] fArr2 = this.f41168e;
        if (fArr2 == null || (fArr = this.f41169f) == null || this.f41170g == null) {
            WLogger.e(f41164a, "mYPositions is null！");
            return;
        }
        int length = fArr2.length;
        int i10 = this.f41173j;
        int i11 = length - i10;
        if (i11 > 0) {
            System.arraycopy((Object) fArr2, i10, (Object) fArr, 0, i11);
            System.arraycopy((Object) this.f41168e, 0, (Object) this.f41169f, i11, this.f41173j);
        }
        float[] fArr3 = this.f41168e;
        int length2 = fArr3.length;
        int i12 = this.f41174k;
        int i13 = length2 - i12;
        if (i13 > 0) {
            System.arraycopy((Object) fArr3, i12, (Object) this.f41170g, 0, i13);
            System.arraycopy((Object) this.f41168e, 0, (Object) this.f41170g, i13, this.f41174k);
        }
    }

    public void a(final int i10, final float f10) {
        this.f41179p = 0.0f;
        CountDownTimer countDownTimer = new CountDownTimer(i10, 10L) { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.widget.b.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                b.this.setProgress(f10);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j10) {
                b bVar = b.this;
                float f11 = f10;
                int i11 = i10;
                bVar.setProgress((f11 * ((float) (i11 - j10))) / i11);
            }
        };
        this.f41180q = countDownTimer;
        countDownTimer.start();
    }

    public void a(final int i10, final a aVar) {
        CountDownTimer countDownTimer = this.f41180q;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        final float f10 = this.f41179p;
        final float f11 = 1.0f - f10;
        CountDownTimer countDownTimer2 = new CountDownTimer(i10, 10L) { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.widget.b.2
            @Override // android.os.CountDownTimer
            public void onFinish() {
                b.this.setProgress(1.0f);
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a();
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j10) {
                b bVar = b.this;
                float f12 = f10;
                float f13 = f11;
                int i11 = i10;
                bVar.setProgress(f12 + ((f13 * ((float) (i11 - j10))) / i11));
            }
        };
        this.f41181r = countDownTimer2;
        countDownTimer2.start();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i10;
        super.onDraw(canvas);
        canvas.setDrawFilter(this.f41176m);
        a();
        int i11 = 0;
        while (true) {
            i10 = this.f41166c;
            if (i11 >= i10) {
                break;
            }
            float f10 = i11;
            int i12 = this.f41167d;
            canvas.drawLine(f10, ((i12 - this.f41169f[i11]) - this.f41177n) - (this.f41179p * this.f41178o), f10, i12, this.f41175l);
            int i13 = this.f41167d;
            canvas.drawLine(f10, ((i13 - this.f41170g[i11]) - this.f41177n) - (this.f41179p * this.f41178o), f10, i13, this.f41175l);
            i11++;
        }
        int i14 = this.f41173j + this.f41171h;
        this.f41173j = i14;
        int i15 = this.f41174k + this.f41172i;
        this.f41174k = i15;
        if (i14 >= i10) {
            this.f41173j = 0;
        }
        if (i15 > i10) {
            this.f41174k = 0;
        }
        postInvalidate();
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f41166c = i10;
        this.f41167d = i11;
        this.f41168e = new float[i10];
        this.f41169f = new float[i10];
        this.f41170g = new float[i10];
        this.f41165b = (float) (6.283185307179586d / i10);
        for (int i14 = 0; i14 < this.f41166c; i14++) {
            this.f41168e[i14] = (float) ((Math.sin(this.f41165b * i14) * 24.0d) + ShadowDrawableWrapper.COS_45);
        }
    }

    public void setEndHeight(float f10) {
        this.f41178o = f10;
        invalidate();
    }

    public void setInitHeight(float f10) {
        this.f41177n = f10;
        invalidate();
    }

    public void setProgress(float f10) {
        this.f41179p = f10;
        invalidate();
    }
}
