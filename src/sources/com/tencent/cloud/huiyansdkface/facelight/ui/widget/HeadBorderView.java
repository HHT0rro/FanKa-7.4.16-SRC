package com.tencent.cloud.huiyansdkface.facelight.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.tencent.cloud.huiyansdkface.R;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class HeadBorderView extends View {

    /* renamed from: a, reason: collision with root package name */
    public static final RectF f41124a = new RectF(0.0f, 0.0f, 720.0f, 1280.0f);

    /* renamed from: b, reason: collision with root package name */
    public static float f41125b = 1.0f;

    /* renamed from: c, reason: collision with root package name */
    private static RectF f41126c;

    /* renamed from: d, reason: collision with root package name */
    private Path f41127d;

    /* renamed from: e, reason: collision with root package name */
    private Path f41128e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f41129f;

    /* renamed from: g, reason: collision with root package name */
    private Paint f41130g;

    /* renamed from: h, reason: collision with root package name */
    private Paint f41131h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f41132i;

    /* renamed from: j, reason: collision with root package name */
    private Matrix f41133j;

    /* renamed from: k, reason: collision with root package name */
    private int[] f41134k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f41135l;

    /* renamed from: m, reason: collision with root package name */
    private RectF f41136m;

    /* renamed from: n, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.b f41137n;

    /* renamed from: o, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.a f41138o;

    public HeadBorderView(Context context) {
        super(context);
        this.f41127d = new Path();
        this.f41128e = new Path();
        this.f41129f = new Paint();
        this.f41130g = new Paint();
        this.f41133j = new Matrix();
        this.f41135l = false;
        this.f41138o = new com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.a();
        a(context);
    }

    public HeadBorderView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f41127d = new Path();
        this.f41128e = new Path();
        this.f41129f = new Paint();
        this.f41130g = new Paint();
        this.f41133j = new Matrix();
        this.f41135l = false;
        this.f41138o = new com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.a();
        a(context);
    }

    public HeadBorderView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f41127d = new Path();
        this.f41128e = new Path();
        this.f41129f = new Paint();
        this.f41130g = new Paint();
        this.f41133j = new Matrix();
        this.f41135l = false;
        this.f41138o = new com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.a();
        a(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Matrix a(int r11, int r12, int r13, int r14, android.graphics.Paint r15) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "width="
            r0.append(r1)
            r0.append(r11)
            java.lang.String r1 = ",height="
            r0.append(r1)
            r0.append(r12)
            java.lang.String r1 = ",screenW="
            r0.append(r1)
            r0.append(r13)
            java.lang.String r1 = ",screenH="
            r0.append(r1)
            r0.append(r14)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "HeadBorderView"
            com.tencent.cloud.huiyansdkface.normal.tools.WLogger.d(r1, r0)
            if (r11 <= r13) goto L32
            r0 = r13
            goto L33
        L32:
            r0 = r11
        L33:
            if (r12 <= r14) goto L37
            r2 = r14
            goto L38
        L37:
            r2 = r12
        L38:
            android.graphics.Matrix r3 = new android.graphics.Matrix
            r3.<init>()
            float r11 = (float) r11
            r4 = 1144258560(0x44340000, float:720.0)
            float r5 = r11 - r4
            r6 = 1073741824(0x40000000, float:2.0)
            float r5 = r5 / r6
            float r12 = (float) r12
            r7 = 1151336448(0x44a00000, float:1280.0)
            float r8 = r12 - r7
            float r8 = r8 / r6
            r3.preTranslate(r5, r8)
            r5 = 1065353216(0x3f800000, float:1.0)
            com.tencent.cloud.huiyansdkface.facelight.ui.widget.HeadBorderView.f41125b = r5
            java.lang.String r8 = "x"
            if (r0 > r2) goto L8e
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "HeadBorderView 竖屏:"
            r9.append(r10)
            r9.append(r0)
            r9.append(r8)
            r9.append(r2)
            java.lang.String r0 = r9.toString()
            com.tencent.cloud.huiyansdkface.normal.tools.WLogger.d(r1, r0)
            float r13 = (float) r13
            float r13 = r13 / r4
            float r13 = r13 * r5
            float r7 = r7 * r13
            float r11 = r11 / r6
            float r12 = r12 / r6
            r3.postScale(r13, r13, r11, r12)
            float r0 = com.tencent.cloud.huiyansdkface.facelight.ui.widget.HeadBorderView.f41125b
            float r0 = r0 * r13
            com.tencent.cloud.huiyansdkface.facelight.ui.widget.HeadBorderView.f41125b = r0
            float r13 = (float) r14
            int r14 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r14 <= 0) goto Lb5
            float r13 = r13 / r7
            float r13 = r13 * r5
            float r0 = r0 * r13
            com.tencent.cloud.huiyansdkface.facelight.ui.widget.HeadBorderView.f41125b = r0
            goto Lb2
        L8e:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "HeadBorderView 横屏:"
            r13.append(r14)
            r13.append(r0)
            r13.append(r8)
            r13.append(r2)
            java.lang.String r13 = r13.toString()
            com.tencent.cloud.huiyansdkface.normal.tools.WLogger.d(r1, r13)
            float r13 = (float) r2
            float r13 = r13 / r7
            float r14 = com.tencent.cloud.huiyansdkface.facelight.ui.widget.HeadBorderView.f41125b
            float r14 = r14 * r13
            com.tencent.cloud.huiyansdkface.facelight.ui.widget.HeadBorderView.f41125b = r14
            float r11 = r11 / r6
            float r12 = r12 / r6
        Lb2:
            r3.postScale(r13, r13, r11, r12)
        Lb5:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "totalScale="
            r11.append(r12)
            float r12 = com.tencent.cloud.huiyansdkface.facelight.ui.widget.HeadBorderView.f41125b
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            com.tencent.cloud.huiyansdkface.normal.tools.WLogger.d(r1, r11)
            if (r15 == 0) goto Ld6
            r11 = 1092616192(0x41200000, float:10.0)
            float r12 = com.tencent.cloud.huiyansdkface.facelight.ui.widget.HeadBorderView.f41125b
            float r12 = r12 * r11
            r15.setStrokeWidth(r12)
        Ld6:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.facelight.ui.widget.HeadBorderView.a(int, int, int, int, android.graphics.Paint):android.graphics.Matrix");
    }

    private void a() {
        this.f41129f.setColor(getResources().getColor(R.color.wbcf_white));
        this.f41129f.setStyle(Paint.Style.FILL);
        this.f41129f.setAntiAlias(true);
        this.f41130g.setColor(-65536);
        this.f41130g.setStyle(Paint.Style.FILL);
        this.f41130g.setAntiAlias(true);
    }

    private void a(Context context) {
        a();
    }

    private void a(Canvas canvas) {
        if (this.f41135l) {
            if (this.f41132i == null) {
                Paint paint = new Paint(1);
                this.f41132i = paint;
                paint.setColor(-16776961);
                this.f41132i.setStyle(Paint.Style.STROKE);
                this.f41132i.setStrokeWidth(5.0f);
                this.f41132i.setAlpha(180);
            }
            RectF rectF = f41126c;
            canvas.drawRect(new RectF(rectF.left, rectF.top, rectF.right, rectF.bottom + 80.0f), this.f41132i);
            if (this.f41131h == null) {
                Paint paint2 = new Paint();
                this.f41131h = paint2;
                paint2.setColor(-65536);
                this.f41131h.setStyle(Paint.Style.STROKE);
                this.f41131h.setStrokeWidth(5.0f);
                this.f41131h.setAlpha(180);
            }
            RectF rectF2 = this.f41136m;
            if (rectF2 != null) {
                canvas.drawRect(rectF2, this.f41131h);
            }
        }
    }

    private void b() {
        Path path = this.f41128e;
        Path path2 = this.f41127d;
        path.rewind();
        path2.rewind();
        path2.setFillType(Path.FillType.EVEN_ODD);
        path.setFillType(Path.FillType.EVEN_ODD);
        com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.a aVar = this.f41138o;
        Path path3 = new Path();
        Path path4 = new Path();
        aVar.a(path3);
        path3.addCircle(360.0f, 554.0f, 248.0f, Path.Direction.CW);
        path4.addCircle(360.0f, 554.0f, 256.0f, Path.Direction.CCW);
        path.addPath(path3);
        path.addPath(path4);
        path.transform(this.f41133j);
        path4.transform(this.f41133j);
        RectF rectF = new RectF();
        f41126c = rectF;
        path.computeBounds(rectF, true);
        path2.set(path4);
        path2.moveTo(0.0f, 0.0f);
        path2.lineTo(getWidth(), 0.0f);
        path2.lineTo(getWidth(), getHeight());
        path2.lineTo(0.0f, getHeight());
        path2.close();
        if (this.f41137n != null) {
            WLogger.d("HeadBorderView", "totalScale=" + f41125b);
            this.f41137n.a(f41125b);
            WLogger.d("HeadBorderView", "绘制外围矩形 结束");
        }
    }

    public HeadBorderView a(boolean z10) {
        this.f41135l = z10;
        return this;
    }

    public void a(int i10) {
        c(i10).postInvalidate();
    }

    public void a(RectF rectF) {
        if (this.f41135l) {
            if (this.f41136m == null) {
                this.f41136m = new RectF();
            }
            this.f41136m.set(rectF);
            postInvalidate();
        }
    }

    public void b(int i10) {
        e(i10).postInvalidate();
    }

    public HeadBorderView c(int i10) {
        this.f41130g.setColor(i10);
        return this;
    }

    public HeadBorderView d(int i10) {
        this.f41134k = null;
        this.f41129f.setShader(null);
        this.f41129f.setColor(i10);
        return this;
    }

    public HeadBorderView e(int i10) {
        this.f41129f.setColor(i10);
        return this;
    }

    public RectF getBorderRect() {
        return f41126c;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        System.currentTimeMillis();
        canvas.drawPath(this.f41127d, this.f41129f);
        canvas.drawPath(this.f41128e, this.f41130g);
        a(canvas);
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        int width = getWidth();
        int height = getHeight();
        WLogger.d("HeadBorderView", String.format("Screen Background view rect size:%d,%d-%d,%d", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(width), Integer.valueOf(height)));
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        this.f41133j = a(width, height, displayMetrics.widthPixels, displayMetrics.heightPixels, this.f41130g);
        long currentTimeMillis = System.currentTimeMillis();
        b();
        WLogger.d("HeadBorderView", "加载 Path 耗时:" + (System.currentTimeMillis() - currentTimeMillis));
        if (this.f41134k != null) {
            this.f41129f.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, height, this.f41134k, (float[]) null, Shader.TileMode.CLAMP));
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        if (mode == Integer.MIN_VALUE && mode2 == Integer.MIN_VALUE) {
            setMeasuredDimension(100, 100);
        } else if (mode == Integer.MIN_VALUE) {
            setMeasuredDimension(100, size2);
        } else if (mode2 == Integer.MIN_VALUE) {
            setMeasuredDimension(size, 100);
        }
    }

    public void setWbCloudFacePathListener(com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.b bVar) {
        this.f41137n = bVar;
    }
}
