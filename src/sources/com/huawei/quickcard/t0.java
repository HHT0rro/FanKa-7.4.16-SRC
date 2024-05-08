package com.huawei.quickcard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.text.TextUtils;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.base.utils.ResourceUtils;
import com.huawei.quickcard.framework.background.IBorderRadiusDrawable;
import com.huawei.quickcard.framework.border.Border;
import com.huawei.quickcard.utils.ViewUtils;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class t0 extends ShapeDrawable implements IBorderRadiusDrawable {

    /* renamed from: i, reason: collision with root package name */
    private static final String f34234i = "LinearGradientDrawable";

    /* renamed from: j, reason: collision with root package name */
    private static final int f34235j = 0;

    /* renamed from: k, reason: collision with root package name */
    private static final int f34236k = 1;

    /* renamed from: l, reason: collision with root package name */
    private static final int f34237l = 2;

    /* renamed from: m, reason: collision with root package name */
    private static final int f34238m = 3;

    /* renamed from: n, reason: collision with root package name */
    private static final int f34239n = 180;

    /* renamed from: a, reason: collision with root package name */
    private final Context f34240a;

    /* renamed from: b, reason: collision with root package name */
    private final List<t> f34241b;

    /* renamed from: c, reason: collision with root package name */
    private final String f34242c;

    /* renamed from: d, reason: collision with root package name */
    private final float[] f34243d = new float[4];

    /* renamed from: e, reason: collision with root package name */
    private Shader.TileMode f34244e;

    /* renamed from: f, reason: collision with root package name */
    private float[] f34245f;

    /* renamed from: g, reason: collision with root package name */
    private int[] f34246g;

    /* renamed from: h, reason: collision with root package name */
    private Border f34247h;

    public t0(Context context, String str, List<t> list, Shader.TileMode tileMode) {
        this.f34240a = context;
        this.f34242c = str;
        this.f34241b = list;
        this.f34244e = tileMode;
    }

    private Shader a(int i10, int i11) {
        List<t> list;
        if (i10 == 0 || i11 == 0 || (list = this.f34241b) == null || list.size() < 2) {
            return null;
        }
        b(i10, i11);
        float[] fArr = this.f34243d;
        return new LinearGradient(fArr[0], fArr[1], fArr[2], fArr[3], this.f34246g, this.f34245f, this.f34244e);
    }

    private void b(int i10, int i11) {
        double d10;
        float f10;
        String str;
        String b4 = this.f34241b.get(0).b();
        List<t> list = this.f34241b;
        String b10 = list.get(list.size() - 1).b();
        double a10 = a();
        double d11 = i10;
        double d12 = i11;
        float abs = (float) Math.abs((Math.sin(a10) * d11) + (Math.cos(a10) * d12));
        double d13 = d11 * 0.5d;
        double d14 = abs * 0.5d;
        double sin = d13 - (Math.sin(a10) * d14);
        double d15 = d12 * 0.5d;
        double cos = (Math.cos(a10) * d14) + d15;
        double sin2 = d13 + (Math.sin(a10) * d14);
        double cos2 = d15 - (Math.cos(a10) * d14);
        boolean equals = Shader.TileMode.REPEAT.equals(this.f34244e);
        float[] fArr = this.f34243d;
        if (b4 == null || !equals) {
            d10 = cos2;
            f10 = (float) sin;
        } else {
            d10 = cos2;
            f10 = (float) ((Math.sin(a10) * a(b4, abs)) + sin);
        }
        fArr[0] = f10;
        float[] fArr2 = this.f34243d;
        if (b4 != null && equals) {
            cos -= Math.cos(a10) * a(b4, abs);
        }
        fArr2[1] = (float) cos;
        float[] fArr3 = this.f34243d;
        if (b10 == null || !equals) {
            str = b10;
        } else {
            str = b10;
            sin2 -= Math.sin(a10) * (abs - a(str, abs));
        }
        fArr3[2] = (float) sin2;
        this.f34243d[3] = (str == null || !equals) ? (float) d10 : (float) ((Math.cos(a10) * (abs - a(str, abs))) + d10);
        a(abs, (b4 == null || !equals) ? 0.0f : a(b4, abs), (str == null || !equals) ? abs : a(str, abs));
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.save();
        Path a10 = m.a(this.f34240a, this.f34247h, getBounds());
        if (a10 != null) {
            canvas.clipPath(a10);
        }
        super.draw(canvas);
        canvas.restore();
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        Rect bounds = getBounds();
        Shader a10 = a(bounds.width(), bounds.height());
        if (a10 != null) {
            getPaint().setShader(a10);
        }
    }

    @Override // com.huawei.quickcard.framework.background.IBorderRadiusDrawable
    public void setBorder(Border border) {
        if (border != this.f34247h) {
            this.f34247h = border;
            invalidateSelf();
        }
    }

    private void a(float f10, float f11, float f12) {
        int size = this.f34241b.size();
        this.f34246g = new int[size];
        this.f34245f = new float[size];
        float f13 = f12 - f11;
        for (int i10 = 0; i10 < size; i10++) {
            t tVar = this.f34241b.get(i10);
            String b4 = tVar.b();
            if (TextUtils.isEmpty(b4)) {
                int i11 = size - 1;
                if (i10 == i11) {
                    this.f34245f[i10] = 1.0f;
                } else if (i10 == 0) {
                    this.f34245f[i10] = 0.0f;
                } else {
                    float[] fArr = this.f34245f;
                    fArr[i10] = fArr[i10 - 1] + (1.0f / i11);
                }
            } else if (f13 > 0.0f) {
                this.f34245f[i10] = (a(b4, f10) - f11) / Math.abs(f13);
            }
            this.f34246g[i10] = ResourceUtils.getColor(tVar.a(), -1);
        }
    }

    private float a(String str, float f10) {
        if (str.endsWith("%")) {
            try {
                return (Float.parseFloat(str.substring(0, str.indexOf("%"))) / 100.0f) * f10;
            } catch (NumberFormatException unused) {
                CardLogUtils.e(f34234i, "parse float fail");
                return Float.NaN;
            }
        }
        return ViewUtils.dip2FloatPx(this.f34240a, Attributes.getFloat(str, Float.NaN));
    }

    private double a() {
        String str = this.f34242c;
        if (TextUtils.isEmpty(str)) {
            str = "toBottom";
        }
        if (str.endsWith("deg")) {
            try {
                return Math.toRadians(Float.parseFloat(str.substring(0, str.lastIndexOf("deg"))));
            } catch (NullPointerException | NumberFormatException unused) {
                CardLogUtils.e(f34234i, "format deg error");
                return Math.toRadians(180.0d);
            }
        }
        return a(str);
    }

    private double a(String str) {
        double d10;
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1486250643:
                if (str.equals("tobottomleft")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1137407871:
                if (str.equals("toright")) {
                    c4 = 1;
                    break;
                }
                break;
            case -1033506462:
                if (str.equals("totopright")) {
                    c4 = 2;
                    break;
                }
                break;
            case -868157182:
                if (str.equals("toleft")) {
                    c4 = 3;
                    break;
                }
                break;
            case -172068863:
                if (str.equals("totopleft")) {
                    c4 = 4;
                    break;
                }
                break;
            case 110550266:
                if (str.equals("totop")) {
                    c4 = 5;
                    break;
                }
                break;
            case 1176531318:
                if (str.equals("tobottomright")) {
                    c4 = 6;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                d10 = 225.0d;
                break;
            case 1:
                d10 = 90.0d;
                break;
            case 2:
                d10 = 45.0d;
                break;
            case 3:
                d10 = 270.0d;
                break;
            case 4:
                d10 = 315.0d;
                break;
            case 5:
                d10 = ShadowDrawableWrapper.COS_45;
                break;
            case 6:
                d10 = 135.0d;
                break;
            default:
                d10 = 180.0d;
                break;
        }
        return Math.toRadians(d10);
    }

    public void a(Shader.TileMode tileMode) {
        this.f34244e = tileMode;
        invalidateSelf();
    }
}
