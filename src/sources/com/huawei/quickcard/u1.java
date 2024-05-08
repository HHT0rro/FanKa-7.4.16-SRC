package com.huawei.quickcard;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import androidx.annotation.NonNull;
import com.huawei.quickcard.framework.border.Border;
import com.huawei.quickcard.utils.BrushUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class u1 extends l {

    /* renamed from: g, reason: collision with root package name */
    private static final float f34259g = 2.0f;

    public u1(boolean z10) {
        super(z10);
        b();
    }

    private void b() {
        BrushUtils.initEraserBrush(this.f33985b);
    }

    @Override // com.huawei.quickcard.l
    public void a(Border border) {
        if (border == null) {
            return;
        }
        p borderWidth = border.getBorderWidth();
        float a10 = a(borderWidth, n.LEFT) / 2.0f;
        float a11 = a(borderWidth, n.RIGHT) / 2.0f;
        float a12 = a(borderWidth, n.TOP) / 2.0f;
        float a13 = a(borderWidth, n.BOTTOM) / 2.0f;
        boolean b4 = m.b(border);
        this.f33986c.rewind();
        RectF rectF = new RectF(getBounds());
        RectF a14 = a(rectF, a10, a12, a11, a13);
        if (b4) {
            this.f33986c.addRect(a14, Path.Direction.CW);
        } else {
            float[] a15 = m.a(this.f34090e, border.getBorderRadius(), rectF);
            a(a15, a10, a12, a11, a13);
            this.f33986c.addRoundRect(a14, a15, Path.Direction.CW);
        }
        this.f33986c.addRect(rectF, Path.Direction.CCW);
    }

    public u1(boolean z10, View view) {
        super(z10, view);
        b();
    }

    public u1(boolean z10, Border border) {
        super(z10, border);
        b();
    }

    public u1(boolean z10, Border border, View view) {
        super(z10, border, view);
        b();
    }

    private float a(p pVar, @NonNull n nVar) {
        if (pVar == null) {
            return 0.0f;
        }
        return m.a(pVar, nVar);
    }

    @NonNull
    private RectF a(@NonNull RectF rectF, float f10, float f11, float f12, float f13) {
        RectF rectF2 = new RectF(rectF);
        rectF2.left = rectF.left + f10;
        rectF2.top = rectF.top + f11;
        rectF2.right = rectF.right - f12;
        rectF2.bottom = rectF.bottom - f13;
        return rectF2;
    }

    private void a(@NonNull float[] fArr, float f10, float f11, float f12, float f13) {
        if (fArr.length != 8) {
            return;
        }
        fArr[0] = Math.max(fArr[0] - f10, 0.0f);
        fArr[1] = Math.max(fArr[1] - f11, 0.0f);
        fArr[2] = Math.max(fArr[2] - f12, 0.0f);
        fArr[3] = Math.max(fArr[3] - f11, 0.0f);
        fArr[4] = Math.max(fArr[4] - f12, 0.0f);
        fArr[5] = Math.max(fArr[5] - f13, 0.0f);
        fArr[6] = Math.max(fArr[6] - f10, 0.0f);
        fArr[7] = Math.max(fArr[7] - f13, 0.0f);
    }

    @Override // com.huawei.quickcard.l
    public void a(@NonNull Canvas canvas, Border border) {
        if (border != null) {
            canvas.drawPath(this.f33986c, this.f33985b);
        }
    }
}
