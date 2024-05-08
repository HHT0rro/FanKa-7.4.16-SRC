package com.huawei.hms.ads.template.dtimageview;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.AttributeSet;
import android.util.Pair;
import android.widget.ImageView;
import com.huawei.flexiblelayout.css.adapter.value.integrate.align.CSSAlignValue;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.cd;
import com.huawei.hms.ads.cj;
import com.huawei.hms.ads.cl;
import org.json.JSONObject;

@GlobalApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class DTImageView extends ImageView implements com.huawei.hms.ads.template.view.a {
    private static final String V = DTImageView.class.getSimpleName();
    private cd B;
    private Context C;
    public final Rect Code;
    private float D;
    private boolean F;
    private ArrayMap<String, String> L;
    private boolean S;

    /* renamed from: a, reason: collision with root package name */
    private int f29384a;

    /* renamed from: b, reason: collision with root package name */
    private int f29385b;

    /* renamed from: c, reason: collision with root package name */
    private a f29386c;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum a {
        DEFAULT(0),
        CIRCLE(1),
        ROUND_CORNER(2);

        public final int Z;

        a(int i10) {
            this.Z = i10;
        }
    }

    @GlobalApi
    public DTImageView(Context context) {
        super(context);
        this.Code = new Rect();
    }

    @GlobalApi
    public DTImageView(Context context, AttributeSet attributeSet) {
        super(context);
        this.Code = new Rect();
        this.C = context;
        this.L = new ArrayMap<>();
        if (attributeSet != null) {
            cd cdVar = new cd(this);
            this.B = cdVar;
            cdVar.Code((cj) new cl(this));
            this.B.Code(attributeSet);
            Pair<Integer, Integer> Code = com.huawei.hms.ads.template.util.a.Code(attributeSet, this.C);
            this.f29384a = ((Integer) Code.first).intValue();
            this.f29385b = ((Integer) Code.second).intValue();
            int attributeCount = attributeSet.getAttributeCount();
            for (int i10 = 0; i10 < attributeCount; i10++) {
                Code(attributeSet, i10);
            }
            Code();
        }
    }

    private void Code() {
        float f10;
        if (this.L.isEmpty()) {
            return;
        }
        String str = this.L.get("shape");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        char c4 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1360216880) {
            if (hashCode != -1035129469) {
                if (hashCode == 1544803905 && str.equals("default")) {
                    c4 = 2;
                }
            } else if (str.equals("roundCorner")) {
                c4 = 1;
            }
        } else if (str.equals("circle")) {
            c4 = 0;
        }
        if (c4 == 0) {
            int i10 = this.f29384a;
            int i11 = this.f29385b;
            f10 = (i10 > i11 ? i11 : i10) / 2.0f;
        } else {
            if (c4 != 1) {
                return;
            }
            f10 = !TextUtils.isEmpty(this.L.get("cornerRadius")) ? com.huawei.hms.ads.template.util.a.Code(r0, this.C) : 0.0f;
        }
        this.D = f10;
        V();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0032, code lost:
    
        if (r0.equals("cornerRadius") == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void Code(android.util.AttributeSet r7, int r8) {
        /*
            r6 = this;
            java.lang.String r0 = r7.getAttributeName(r8)
            java.lang.String r7 = r7.getAttributeValue(r8)
            java.lang.String r8 = com.huawei.hms.ads.template.dtimageview.DTImageView.V
            r1 = 2
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r3 = 0
            r2[r3] = r0
            r4 = 1
            r2[r4] = r7
            java.lang.String r5 = "processAttribute name: %s value: %s"
            com.huawei.hms.ads.gl.Code(r8, r5, r2)
            boolean r8 = android.text.TextUtils.isEmpty(r0)
            if (r8 == 0) goto L1f
            return
        L1f:
            r0.hashCode()
            r8 = -1
            int r2 = r0.hashCode()
            switch(r2) {
                case -1877911644: goto L40;
                case 109399969: goto L35;
                case 583595847: goto L2c;
                default: goto L2a;
            }
        L2a:
            r1 = -1
            goto L4a
        L2c:
            java.lang.String r2 = "cornerRadius"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L4a
            goto L2a
        L35:
            java.lang.String r1 = "shape"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L3e
            goto L2a
        L3e:
            r1 = 1
            goto L4a
        L40:
            java.lang.String r1 = "scaleType"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L49
            goto L2a
        L49:
            r1 = 0
        L4a:
            switch(r1) {
                case 0: goto L54;
                case 1: goto L4e;
                case 2: goto L4e;
                default: goto L4d;
            }
        L4d:
            goto L57
        L4e:
            android.util.ArrayMap<java.lang.String, java.lang.String> r8 = r6.L
            r8.put(r0, r7)
            goto L57
        L54:
            r6.Code(r7)
        L57:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.template.dtimageview.DTImageView.Code(android.util.AttributeSet, int):void");
    }

    private void Code(String str) {
        ImageView.ScaleType scaleType;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals(CSSAlignValue.AlignKey.CENTER)) {
                    c4 = 0;
                    break;
                }
                break;
            case -1274298614:
                if (str.equals("fitEnd")) {
                    c4 = 1;
                    break;
                }
                break;
            case -522179887:
                if (str.equals("fitStart")) {
                    c4 = 2;
                    break;
                }
                break;
            case -340708175:
                if (str.equals("centerInside")) {
                    c4 = 3;
                    break;
                }
                break;
            case 97441490:
                if (str.equals("fitXY")) {
                    c4 = 4;
                    break;
                }
                break;
            case 520762310:
                if (str.equals("fitCenter")) {
                    c4 = 5;
                    break;
                }
                break;
            case 1161480325:
                if (str.equals("centerCrop")) {
                    c4 = 6;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                scaleType = ImageView.ScaleType.CENTER;
                break;
            case 1:
                scaleType = ImageView.ScaleType.FIT_END;
                break;
            case 2:
                scaleType = ImageView.ScaleType.FIT_START;
                break;
            case 3:
                scaleType = ImageView.ScaleType.CENTER_INSIDE;
                break;
            case 4:
                scaleType = ImageView.ScaleType.FIT_XY;
                break;
            case 5:
                scaleType = ImageView.ScaleType.FIT_CENTER;
                break;
            case 6:
                scaleType = ImageView.ScaleType.CENTER_CROP;
                break;
            default:
                return;
        }
        setScaleType(scaleType);
    }

    private void V() {
    }

    @Override // com.huawei.hms.ads.template.view.a
    public void Code(JSONObject jSONObject) {
        cd cdVar = this.B;
        if (cdVar != null) {
            cdVar.Code(jSONObject);
        }
    }

    public a getDtShape() {
        return this.f29386c;
    }

    public boolean getPreventCornerOverlap() {
        return this.F;
    }

    public boolean getUseCompatPadding() {
        return this.S;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
    }

    public void setDtShape(a aVar) {
        this.f29386c = aVar;
    }

    @Override // android.view.View
    public void setMinimumHeight(int i10) {
        super.setMinimumHeight(i10);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i10) {
        super.setMinimumWidth(i10);
    }

    public void setPreventCornerOverlap(boolean z10) {
        if (z10 != this.F) {
            this.F = z10;
        }
    }

    public void setUseCompatPadding(boolean z10) {
        if (this.S != z10) {
            this.S = z10;
        }
    }
}
