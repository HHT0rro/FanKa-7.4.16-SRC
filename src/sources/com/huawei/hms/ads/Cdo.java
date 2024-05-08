package com.huawei.hms.ads;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import com.huawei.quickcard.base.Attributes;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.ads.do, reason: invalid class name */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class Cdo extends ShapeDrawable {

    /* renamed from: com.huawei.hms.ads.do$a */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a extends RoundRectShape {
        private int Code;
        private int I;
        private int V;

        public a(float[] fArr, int i10, int i11, int i12) {
            super(fArr, null, null);
            this.Code = i10;
            this.I = i11;
            this.V = i12;
        }

        @Override // android.graphics.drawable.shapes.RoundRectShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas canvas, Paint paint) {
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(this.V);
            super.draw(canvas, paint);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeCap(Paint.Cap.ROUND);
            paint.setStrokeWidth(this.I);
            paint.setColor(this.Code);
            paint.setAntiAlias(true);
            super.draw(canvas, paint);
        }
    }

    public Cdo(Context context, JSONObject jSONObject) {
        int i10;
        int i11;
        int Code;
        int i12 = 0;
        float[] fArr = null;
        if (jSONObject != null) {
            String optString = jSONObject.optString("cornerRadius");
            if (!TextUtils.isEmpty(optString) && (Code = com.huawei.hms.ads.template.util.a.Code(optString, context)) > 0) {
                float[] fArr2 = new float[8];
                for (int i13 = 0; i13 < 8; i13++) {
                    fArr2[i13] = Code;
                }
                fArr = fArr2;
            }
            String optString2 = jSONObject.optString("strokeColor");
            int Code2 = !TextUtils.isEmpty(optString2) ? com.huawei.hms.ads.template.util.a.Code(optString2, 0) : 0;
            String optString3 = jSONObject.optString("fillColor");
            i11 = !TextUtils.isEmpty(optString3) ? com.huawei.hms.ads.template.util.a.Code(optString3, 0) : 0;
            String optString4 = jSONObject.optString(Attributes.Style.STROKE_WIDTH);
            if (TextUtils.isEmpty(optString4)) {
                i12 = Code2;
                i10 = 0;
            } else {
                i10 = com.huawei.hms.ads.template.util.a.Code(optString4, context);
                i12 = Code2;
            }
        } else {
            i10 = 0;
            i11 = 0;
        }
        setShape(new a(fArr, i12, i10, i11));
    }
}
