package com.huawei.quickcard;

import android.content.Context;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.quickcard.base.utils.ResourceUtils;
import com.huawei.quickcard.framework.border.Border;
import com.huawei.quickcard.framework.border.BorderRadius;
import com.huawei.quickcard.o;
import com.huawei.quickcard.utils.ViewUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class m {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34107a;

        static {
            int[] iArr = new int[n.values().length];
            f34107a = iArr;
            try {
                iArr[n.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34107a[n.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f34107a[n.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f34107a[n.RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f34107a[n.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static Path a(Context context, Border border, Rect rect) {
        if (border == null) {
            return null;
        }
        RectF rectF = new RectF(rect);
        float a10 = a(border);
        rectF.inset(a10, a10);
        float[] fArr = new float[8];
        BorderRadius borderRadius = border.getBorderRadius();
        if (borderRadius != null) {
            fArr = a(context, borderRadius, rect, a10);
        }
        Path path = new Path();
        path.addRoundRect(rectF, fArr, Path.Direction.CW);
        return path;
    }

    public static boolean b(@NonNull Border border) {
        BorderRadius borderRadius = border.getBorderRadius();
        return borderRadius == null || borderRadius.isRectangle();
    }

    public static float[] a(Context context, BorderRadius borderRadius, Rect rect, float f10) {
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        float[] fArr = new float[8];
        if (borderRadius == null) {
            return fArr;
        }
        o1 topLeft = borderRadius.getTopLeft();
        o1 topRight = borderRadius.getTopRight();
        o1 bottomLeft = borderRadius.getBottomLeft();
        o1 bottomRight = borderRadius.getBottomRight();
        o1 allRadius = borderRadius.getAllRadius();
        int height = rect.height();
        int width = rect.width();
        if (allRadius != null) {
            n1 n1Var = allRadius.f34142b;
            if (n1Var == n1.PERCENT) {
                float f19 = allRadius.f34141a;
                f12 = width * f19;
                f11 = f19 * height;
            } else if (n1Var == n1.PX) {
                f12 = allRadius.f34141a;
                f11 = f12;
            } else {
                f12 = ViewUtils.dip2FloatPx(context, allRadius.f34141a);
                f11 = ViewUtils.dip2FloatPx(context, allRadius.f34141a);
            }
        } else {
            f11 = 0.0f;
            f12 = 0.0f;
        }
        if (topLeft != null) {
            n1 n1Var2 = topLeft.f34142b;
            if (n1Var2 == n1.PERCENT) {
                float f20 = topLeft.f34141a;
                f14 = width * f20;
                f13 = f20 * height;
            } else if (n1Var2 == n1.PX) {
                f14 = topLeft.f34141a;
                f13 = f14;
            } else {
                f14 = ViewUtils.dip2FloatPx(context, topLeft.f34141a);
                f13 = ViewUtils.dip2FloatPx(context, topLeft.f34141a);
            }
        } else {
            f13 = f11;
            f14 = f12;
        }
        if (topRight != null) {
            n1 n1Var3 = topRight.f34142b;
            if (n1Var3 == n1.PERCENT) {
                float f21 = topRight.f34141a;
                f16 = width * f21;
                f15 = f21 * height;
            } else if (n1Var3 == n1.PX) {
                f16 = topRight.f34141a;
                f15 = f16;
            } else {
                f16 = ViewUtils.dip2FloatPx(context, topRight.f34141a);
                f15 = ViewUtils.dip2FloatPx(context, topRight.f34141a);
            }
        } else {
            f15 = f11;
            f16 = f12;
        }
        if (bottomLeft != null) {
            n1 n1Var4 = bottomLeft.f34142b;
            if (n1Var4 == n1.PERCENT) {
                float f22 = bottomLeft.f34141a;
                f18 = width * f22;
                f17 = f22 * height;
            } else if (n1Var4 == n1.PX) {
                f18 = bottomLeft.f34141a;
                f17 = f18;
            } else {
                f18 = ViewUtils.dip2FloatPx(context, bottomLeft.f34141a);
                f17 = ViewUtils.dip2FloatPx(context, bottomLeft.f34141a);
            }
        } else {
            f17 = f11;
            f18 = f12;
        }
        if (bottomRight != null) {
            n1 n1Var5 = bottomRight.f34142b;
            if (n1Var5 == n1.PERCENT) {
                float f23 = bottomRight.f34141a;
                f12 = f23 * width;
                f11 = height * f23;
            } else if (n1Var5 == n1.PX) {
                f11 = bottomRight.f34141a;
                f12 = f11;
            } else {
                f12 = ViewUtils.dip2FloatPx(context, bottomRight.f34141a);
                f11 = ViewUtils.dip2FloatPx(context, bottomRight.f34141a);
            }
        }
        float f24 = f10 / 2.0f;
        float f25 = f14 - f24;
        if (f25 > 0.0f) {
            f14 = f25;
        }
        fArr[0] = f14;
        float f26 = f13 - f24;
        if (f26 > 0.0f) {
            f13 = f26;
        }
        fArr[1] = f13;
        float f27 = f16 - f24;
        if (f27 > 0.0f) {
            f16 = f27;
        }
        fArr[2] = f16;
        float f28 = f15 - f24;
        if (f28 > 0.0f) {
            f15 = f28;
        }
        fArr[3] = f15;
        float f29 = f12 - f24;
        if (f29 > 0.0f) {
            f12 = f29;
        }
        fArr[4] = f12;
        float f30 = f11 - f24;
        if (f30 > 0.0f) {
            f11 = f30;
        }
        fArr[5] = f11;
        float f31 = f18 - f24;
        if (f31 > 0.0f) {
            f18 = f31;
        }
        fArr[6] = f18;
        float f32 = f17 - f24;
        if (f32 > 0.0f) {
            f17 = f32;
        }
        fArr[7] = f17;
        return fArr;
    }

    @NonNull
    public static float[] a(@Nullable View view, @Nullable BorderRadius borderRadius, @NonNull RectF rectF) {
        float[] fArr = new float[8];
        if (borderRadius != null && !borderRadius.isRectangle()) {
            if (borderRadius.allSame()) {
                a(a(borderRadius, n.LEFT), view, rectF, fArr);
            } else {
                o1 a10 = a(borderRadius, n.LEFT);
                o1 a11 = a(borderRadius, n.TOP);
                o1 a12 = a(borderRadius, n.RIGHT);
                o1 a13 = a(borderRadius, n.BOTTOM);
                float width = rectF.width();
                float height = rectF.height();
                fArr[0] = a(view, a10, width);
                fArr[1] = a(view, a10, height);
                fArr[2] = a(view, a11, width);
                fArr[3] = a(view, a11, height);
                fArr[4] = a(view, a12, width);
                fArr[5] = a(view, a12, height);
                fArr[6] = a(view, a13, width);
                fArr[7] = a(view, a13, height);
            }
        }
        return fArr;
    }

    @Nullable
    private static o1 a(@NonNull BorderRadius borderRadius, @NonNull n nVar) {
        int i10 = a.f34107a[nVar.ordinal()];
        if (i10 == 1) {
            return borderRadius.getAllRadius();
        }
        if (i10 == 2) {
            o1 topLeft = borderRadius.getTopLeft();
            return topLeft != null ? topLeft : a(borderRadius, n.ALL);
        }
        if (i10 == 3) {
            o1 topRight = borderRadius.getTopRight();
            return topRight != null ? topRight : a(borderRadius, n.ALL);
        }
        if (i10 == 4) {
            o1 bottomRight = borderRadius.getBottomRight();
            return bottomRight != null ? bottomRight : a(borderRadius, n.ALL);
        }
        if (i10 != 5) {
            return null;
        }
        o1 bottomLeft = borderRadius.getBottomLeft();
        return bottomLeft != null ? bottomLeft : a(borderRadius, n.ALL);
    }

    private static float a(View view, o1 o1Var, float f10) {
        if (o1Var == null) {
            return 0.0f;
        }
        if (o1Var.f34142b == n1.PERCENT) {
            return o1Var.f34141a * f10;
        }
        return ViewUtils.dip2FloatPx(view, o1Var.f34141a);
    }

    private static void a(o1 o1Var, View view, @NonNull RectF rectF, @NonNull float[] fArr) {
        float a10 = a(view, o1Var, rectF.width());
        float a11 = a(view, o1Var, rectF.height());
        for (int i10 = 0; i10 < fArr.length; i10++) {
            if (i10 % 2 == 0) {
                fArr[i10] = a10;
            } else {
                fArr[i10] = a11;
            }
        }
    }

    public static float a(@NonNull Border border) {
        p borderWidth = border.getBorderWidth();
        if (borderWidth == null) {
            return 0.0f;
        }
        if (borderWidth.a()) {
            return borderWidth.d();
        }
        return borderWidth.b();
    }

    public static int a(@NonNull Border border, int i10) {
        j borderColor = border.getBorderColor();
        if (borderColor == null) {
            return i10;
        }
        if (borderColor.a()) {
            return ResourceUtils.getColor(borderColor.d(), -16777216);
        }
        return ResourceUtils.getColor(borderColor.b(), -16777216);
    }

    public static o.a a(@NonNull Border border, o.a aVar) {
        o borderStyle = border.getBorderStyle();
        if (borderStyle == null) {
            return aVar;
        }
        if (borderStyle.b() != null) {
            return borderStyle.b();
        }
        return borderStyle.a() ? borderStyle.d() : aVar;
    }

    public static float a(@NonNull p pVar, @NonNull n nVar) {
        int i10 = a.f34107a[nVar.ordinal()];
        if (i10 == 1) {
            return Math.max(pVar.b(), 0.0f);
        }
        if (i10 == 2) {
            float d10 = pVar.d();
            return Float.compare(d10, 0.0f) == 1 ? d10 : a(pVar, n.ALL);
        }
        if (i10 == 3) {
            float f10 = pVar.f();
            return Float.compare(f10, 0.0f) == 1 ? f10 : a(pVar, n.ALL);
        }
        if (i10 == 4) {
            float e2 = pVar.e();
            return Float.compare(e2, 0.0f) == 1 ? e2 : a(pVar, n.ALL);
        }
        if (i10 != 5) {
            return 0.0f;
        }
        float c4 = pVar.c();
        return Float.compare(c4, 0.0f) == 1 ? c4 : a(pVar, n.ALL);
    }

    public static int a(j jVar, @NonNull n nVar, int i10) {
        return jVar == null ? i10 : ResourceUtils.getColor(a(jVar, nVar), i10);
    }

    @Nullable
    private static String a(@NonNull j jVar, @NonNull n nVar) {
        int i10 = a.f34107a[nVar.ordinal()];
        if (i10 == 1) {
            return jVar.b();
        }
        if (i10 == 2) {
            String d10 = jVar.d();
            return d10 != null ? d10 : a(jVar, n.ALL);
        }
        if (i10 == 3) {
            String f10 = jVar.f();
            return f10 != null ? f10 : a(jVar, n.ALL);
        }
        if (i10 == 4) {
            String e2 = jVar.e();
            return e2 != null ? e2 : a(jVar, n.ALL);
        }
        if (i10 != 5) {
            return null;
        }
        String c4 = jVar.c();
        return c4 != null ? c4 : a(jVar, n.ALL);
    }

    @NonNull
    public static o.a a(o oVar, @NonNull n nVar, @NonNull o.a aVar) {
        if (oVar == null) {
            return aVar;
        }
        int i10 = a.f34107a[nVar.ordinal()];
        if (i10 == 1) {
            o.a b4 = oVar.b();
            return b4 == null ? aVar : b4;
        }
        if (i10 == 2) {
            o.a d10 = oVar.d();
            return d10 != null ? d10 : a(oVar, n.ALL, aVar);
        }
        if (i10 == 3) {
            o.a f10 = oVar.f();
            return f10 != null ? f10 : a(oVar, n.ALL, aVar);
        }
        if (i10 == 4) {
            o.a e2 = oVar.e();
            return e2 != null ? e2 : a(oVar, n.ALL, aVar);
        }
        if (i10 != 5) {
            return a(oVar, n.ALL, aVar);
        }
        o.a c4 = oVar.c();
        return c4 != null ? c4 : a(oVar, n.ALL, aVar);
    }

    public static void a(@NonNull float[] fArr, float f10) {
        for (int i10 = 0; i10 < fArr.length; i10++) {
            if (f10 < fArr[i10]) {
                fArr[i10] = fArr[i10] - f10;
            }
        }
    }

    public static boolean a(p pVar) {
        return pVar == null || (pVar.a() && pVar.d() <= 0.0f);
    }
}
