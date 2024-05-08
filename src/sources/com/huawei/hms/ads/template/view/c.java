package com.huawei.hms.ads.template.view;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c {
    private Path I;
    private View Z;
    private final RectF Code = new RectF();
    private float V = 0.0f;

    public c(View view) {
        this.Z = view;
        view.setWillNotDraw(false);
        this.I = new Path();
    }

    private void Code() {
        Path path = this.I;
        RectF rectF = this.Code;
        float f10 = this.V;
        path.addRoundRect(rectF, f10, f10, Path.Direction.CW);
    }

    public void Code(float f10) {
        this.V = f10;
        Code();
        this.Z.postInvalidate();
    }

    public void Code(Canvas canvas) {
        if (this.V > 0.01f) {
            canvas.clipPath(this.I);
        }
    }

    public void Code(boolean z10, int i10, int i11, int i12, int i13) {
        this.Code.set(0.0f, 0.0f, this.Z.getMeasuredWidth(), this.Z.getMeasuredHeight());
        Code();
    }
}
