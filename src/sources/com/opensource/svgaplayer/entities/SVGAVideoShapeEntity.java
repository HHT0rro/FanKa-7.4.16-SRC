package com.opensource.svgaplayer.entities;

import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.huawei.quickcard.base.Attributes;
import com.opensource.svgaplayer.proto.ShapeEntity;
import com.opensource.svgaplayer.proto.Transform;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d;
import kotlin.jvm.internal.s;
import kotlin.text.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import sb.b;
import sb.e;
import sun.util.locale.LanguageTag;

/* compiled from: SVGAVideoShapeEntity.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class SVGAVideoShapeEntity {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public Type f37990a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Map<String, ? extends Object> f37991b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public a f37992c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public Matrix f37993d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public Path f37994e;

    /* compiled from: SVGAVideoShapeEntity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum Type {
        shape,
        rect,
        ellipse,
        keep
    }

    /* compiled from: SVGAVideoShapeEntity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int f37995a;

        /* renamed from: b, reason: collision with root package name */
        public int f37996b;

        /* renamed from: c, reason: collision with root package name */
        public float f37997c;

        /* renamed from: f, reason: collision with root package name */
        public int f38000f;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public String f37998d = "butt";

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        public String f37999e = "miter";

        /* renamed from: g, reason: collision with root package name */
        @NotNull
        public float[] f38001g = new float[0];

        public final int a() {
            return this.f37995a;
        }

        @NotNull
        public final String b() {
            return this.f37998d;
        }

        @NotNull
        public final float[] c() {
            return this.f38001g;
        }

        @NotNull
        public final String d() {
            return this.f37999e;
        }

        public final int e() {
            return this.f38000f;
        }

        public final int f() {
            return this.f37996b;
        }

        public final float g() {
            return this.f37997c;
        }

        public final void h(int i10) {
            this.f37995a = i10;
        }

        public final void i(@NotNull String str) {
            s.j(str, "<set-?>");
            this.f37998d = str;
        }

        public final void j(@NotNull float[] fArr) {
            s.j(fArr, "<set-?>");
            this.f38001g = fArr;
        }

        public final void k(@NotNull String str) {
            s.j(str, "<set-?>");
            this.f37999e = str;
        }

        public final void l(int i10) {
            this.f38000f = i10;
        }

        public final void m(int i10) {
            this.f37996b = i10;
        }

        public final void n(float f10) {
            this.f37997c = f10;
        }
    }

    public SVGAVideoShapeEntity(@NotNull JSONObject obj) {
        s.j(obj, "obj");
        this.f37990a = Type.shape;
        q(obj);
        k(obj);
        m(obj);
        o(obj);
    }

    public final void a() {
        if (this.f37994e != null) {
            return;
        }
        e.a().reset();
        Type type = this.f37990a;
        if (type == Type.shape) {
            Map<String, ? extends Object> map = this.f37991b;
            Object obj = map != null ? map.get("d") : null;
            String str = (String) (obj instanceof String ? obj : null);
            if (str != null) {
                new b(str).a(e.a());
            }
        } else if (type == Type.ellipse) {
            Map<String, ? extends Object> map2 = this.f37991b;
            Object obj2 = map2 != null ? map2.get(LanguageTag.PRIVATEUSE) : null;
            if (!(obj2 instanceof Number)) {
                obj2 = null;
            }
            Number number = (Number) obj2;
            if (number == null) {
                return;
            }
            Map<String, ? extends Object> map3 = this.f37991b;
            Object obj3 = map3 != null ? map3.get("y") : null;
            if (!(obj3 instanceof Number)) {
                obj3 = null;
            }
            Number number2 = (Number) obj3;
            if (number2 == null) {
                return;
            }
            Map<String, ? extends Object> map4 = this.f37991b;
            Object obj4 = map4 != null ? map4.get("radiusX") : null;
            if (!(obj4 instanceof Number)) {
                obj4 = null;
            }
            Number number3 = (Number) obj4;
            if (number3 == null) {
                return;
            }
            Map<String, ? extends Object> map5 = this.f37991b;
            Object obj5 = map5 != null ? map5.get("radiusY") : null;
            Number number4 = (Number) (obj5 instanceof Number ? obj5 : null);
            if (number4 == null) {
                return;
            }
            float floatValue = number.floatValue();
            float floatValue2 = number2.floatValue();
            float floatValue3 = number3.floatValue();
            float floatValue4 = number4.floatValue();
            e.a().addOval(new RectF(floatValue - floatValue3, floatValue2 - floatValue4, floatValue + floatValue3, floatValue2 + floatValue4), Path.Direction.CW);
        } else if (type == Type.rect) {
            Map<String, ? extends Object> map6 = this.f37991b;
            Object obj6 = map6 != null ? map6.get(LanguageTag.PRIVATEUSE) : null;
            if (!(obj6 instanceof Number)) {
                obj6 = null;
            }
            Number number5 = (Number) obj6;
            if (number5 == null) {
                return;
            }
            Map<String, ? extends Object> map7 = this.f37991b;
            Object obj7 = map7 != null ? map7.get("y") : null;
            if (!(obj7 instanceof Number)) {
                obj7 = null;
            }
            Number number6 = (Number) obj7;
            if (number6 == null) {
                return;
            }
            Map<String, ? extends Object> map8 = this.f37991b;
            Object obj8 = map8 != null ? map8.get("width") : null;
            if (!(obj8 instanceof Number)) {
                obj8 = null;
            }
            Number number7 = (Number) obj8;
            if (number7 == null) {
                return;
            }
            Map<String, ? extends Object> map9 = this.f37991b;
            Object obj9 = map9 != null ? map9.get("height") : null;
            if (!(obj9 instanceof Number)) {
                obj9 = null;
            }
            Number number8 = (Number) obj9;
            if (number8 == null) {
                return;
            }
            Map<String, ? extends Object> map10 = this.f37991b;
            Object obj10 = map10 != null ? map10.get("cornerRadius") : null;
            Number number9 = (Number) (obj10 instanceof Number ? obj10 : null);
            if (number9 == null) {
                return;
            }
            float floatValue5 = number5.floatValue();
            float floatValue6 = number6.floatValue();
            float floatValue7 = number7.floatValue();
            float floatValue8 = number8.floatValue();
            float floatValue9 = number9.floatValue();
            e.a().addRoundRect(new RectF(floatValue5, floatValue6, floatValue7 + floatValue5, floatValue8 + floatValue6), floatValue9, floatValue9, Path.Direction.CW);
        }
        Path path = new Path();
        this.f37994e = path;
        path.set(e.a());
    }

    public final float b(ShapeEntity.ShapeStyle.RGBAColor rGBAColor) {
        return rGBAColor.f38024a.floatValue() <= 1.0f ? 255.0f : 1.0f;
    }

    public final float c(JSONArray jSONArray) {
        return jSONArray.optDouble(3) <= ((double) 1) ? 255.0f : 1.0f;
    }

    public final float d(ShapeEntity.ShapeStyle.RGBAColor rGBAColor) {
        Float f10 = rGBAColor.f38027r;
        float f11 = 1;
        if ((f10 != null ? f10.floatValue() : 0.0f) <= f11) {
            Float f12 = rGBAColor.f38026g;
            if ((f12 != null ? f12.floatValue() : 0.0f) <= f11) {
                Float f13 = rGBAColor.f38025b;
                if ((f13 != null ? f13.floatValue() : 0.0f) <= f11) {
                    return 255.0f;
                }
            }
        }
        return 1.0f;
    }

    public final float e(JSONArray jSONArray) {
        double d10 = 1;
        return (jSONArray.optDouble(0) > d10 || jSONArray.optDouble(1) > d10 || jSONArray.optDouble(2) > d10) ? 1.0f : 255.0f;
    }

    @Nullable
    public final Path f() {
        return this.f37994e;
    }

    @Nullable
    public final a g() {
        return this.f37992c;
    }

    @Nullable
    public final Matrix h() {
        return this.f37993d;
    }

    public final boolean i() {
        return this.f37990a == Type.keep;
    }

    public final void j(ShapeEntity shapeEntity) {
        String str;
        HashMap hashMap = new HashMap();
        ShapeEntity.ShapeArgs shapeArgs = shapeEntity.shape;
        if (shapeArgs != null && (str = shapeArgs.f38022d) != null) {
            hashMap.put("d", str);
        }
        ShapeEntity.EllipseArgs ellipseArgs = shapeEntity.ellipse;
        if (ellipseArgs != null) {
            Float f10 = ellipseArgs.f38014x;
            if (f10 == null) {
                f10 = Float.valueOf(0.0f);
            }
            hashMap.put(LanguageTag.PRIVATEUSE, f10);
            Float f11 = ellipseArgs.f38015y;
            if (f11 == null) {
                f11 = Float.valueOf(0.0f);
            }
            hashMap.put("y", f11);
            Float f12 = ellipseArgs.radiusX;
            if (f12 == null) {
                f12 = Float.valueOf(0.0f);
            }
            hashMap.put("radiusX", f12);
            Float f13 = ellipseArgs.radiusY;
            if (f13 == null) {
                f13 = Float.valueOf(0.0f);
            }
            hashMap.put("radiusY", f13);
        }
        ShapeEntity.RectArgs rectArgs = shapeEntity.rect;
        if (rectArgs != null) {
            Float f14 = rectArgs.f38018x;
            if (f14 == null) {
                f14 = Float.valueOf(0.0f);
            }
            hashMap.put(LanguageTag.PRIVATEUSE, f14);
            Float f15 = rectArgs.f38019y;
            if (f15 == null) {
                f15 = Float.valueOf(0.0f);
            }
            hashMap.put("y", f15);
            Float f16 = rectArgs.width;
            if (f16 == null) {
                f16 = Float.valueOf(0.0f);
            }
            hashMap.put("width", f16);
            Float f17 = rectArgs.height;
            if (f17 == null) {
                f17 = Float.valueOf(0.0f);
            }
            hashMap.put("height", f17);
            Float f18 = rectArgs.cornerRadius;
            if (f18 == null) {
                f18 = Float.valueOf(0.0f);
            }
            hashMap.put("cornerRadius", f18);
        }
        this.f37991b = hashMap;
    }

    public final void k(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        JSONObject optJSONObject = jSONObject.optJSONObject("args");
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            s.e(keys, "values.keys()");
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = optJSONObject.get(next);
                if (obj != null) {
                    hashMap.put(next, obj);
                }
            }
            this.f37991b = hashMap;
        }
    }

    public final void l(ShapeEntity shapeEntity) {
        ShapeEntity.ShapeStyle shapeStyle = shapeEntity.styles;
        if (shapeStyle != null) {
            a aVar = new a();
            ShapeEntity.ShapeStyle.RGBAColor rGBAColor = shapeStyle.fill;
            if (rGBAColor != null) {
                float d10 = d(rGBAColor);
                float b4 = b(rGBAColor);
                Float f10 = rGBAColor.f38024a;
                int floatValue = (int) ((f10 != null ? f10.floatValue() : 0.0f) * b4);
                Float f11 = rGBAColor.f38027r;
                int floatValue2 = (int) ((f11 != null ? f11.floatValue() : 0.0f) * d10);
                Float f12 = rGBAColor.f38026g;
                int floatValue3 = (int) ((f12 != null ? f12.floatValue() : 0.0f) * d10);
                Float f13 = rGBAColor.f38025b;
                aVar.h(Color.argb(floatValue, floatValue2, floatValue3, (int) ((f13 != null ? f13.floatValue() : 0.0f) * d10)));
            }
            ShapeEntity.ShapeStyle.RGBAColor rGBAColor2 = shapeStyle.stroke;
            if (rGBAColor2 != null) {
                float d11 = d(rGBAColor2);
                float b10 = b(rGBAColor2);
                Float f14 = rGBAColor2.f38024a;
                int floatValue4 = (int) ((f14 != null ? f14.floatValue() : 0.0f) * b10);
                Float f15 = rGBAColor2.f38027r;
                int floatValue5 = (int) ((f15 != null ? f15.floatValue() : 0.0f) * d11);
                Float f16 = rGBAColor2.f38026g;
                int floatValue6 = (int) ((f16 != null ? f16.floatValue() : 0.0f) * d11);
                Float f17 = rGBAColor2.f38025b;
                aVar.m(Color.argb(floatValue4, floatValue5, floatValue6, (int) ((f17 != null ? f17.floatValue() : 0.0f) * d11)));
            }
            Float f18 = shapeStyle.strokeWidth;
            aVar.n(f18 != null ? f18.floatValue() : 0.0f);
            ShapeEntity.ShapeStyle.LineCap lineCap = shapeStyle.lineCap;
            if (lineCap != null) {
                int i10 = sb.d.f53699b[lineCap.ordinal()];
                if (i10 == 1) {
                    aVar.i("butt");
                } else if (i10 == 2) {
                    aVar.i("round");
                } else if (i10 == 3) {
                    aVar.i("square");
                }
            }
            ShapeEntity.ShapeStyle.LineJoin lineJoin = shapeStyle.lineJoin;
            if (lineJoin != null) {
                int i11 = sb.d.f53700c[lineJoin.ordinal()];
                if (i11 == 1) {
                    aVar.k("bevel");
                } else if (i11 == 2) {
                    aVar.k("miter");
                } else if (i11 == 3) {
                    aVar.k("round");
                }
            }
            Float f19 = shapeStyle.miterLimit;
            aVar.l((int) (f19 != null ? f19.floatValue() : 0.0f));
            aVar.j(new float[3]);
            Float f20 = shapeStyle.lineDashI;
            if (f20 != null) {
                aVar.c()[0] = f20.floatValue();
            }
            Float f21 = shapeStyle.lineDashII;
            if (f21 != null) {
                aVar.c()[1] = f21.floatValue();
            }
            Float f22 = shapeStyle.lineDashIII;
            if (f22 != null) {
                aVar.c()[2] = f22.floatValue();
            }
            this.f37992c = aVar;
        }
    }

    public final void m(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("styles");
        if (optJSONObject != null) {
            a aVar = new a();
            JSONArray optJSONArray = optJSONObject.optJSONArray(Attributes.ImageMode.FILL);
            if (optJSONArray != null && optJSONArray.length() == 4) {
                double e2 = e(optJSONArray);
                aVar.h(Color.argb((int) (optJSONArray.optDouble(3) * c(optJSONArray)), (int) (optJSONArray.optDouble(0) * e2), (int) (optJSONArray.optDouble(1) * e2), (int) (optJSONArray.optDouble(2) * e2)));
            }
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("stroke");
            if (optJSONArray2 != null && optJSONArray2.length() == 4) {
                double e10 = e(optJSONArray2);
                aVar.m(Color.argb((int) (optJSONArray2.optDouble(3) * c(optJSONArray2)), (int) (optJSONArray2.optDouble(0) * e10), (int) (optJSONArray2.optDouble(1) * e10), (int) (optJSONArray2.optDouble(2) * e10)));
            }
            aVar.n((float) optJSONObject.optDouble(Attributes.Style.STROKE_WIDTH, ShadowDrawableWrapper.COS_45));
            String optString = optJSONObject.optString("lineCap", "butt");
            s.e(optString, "it.optString(\"lineCap\", \"butt\")");
            aVar.i(optString);
            String optString2 = optJSONObject.optString("lineJoin", "miter");
            s.e(optString2, "it.optString(\"lineJoin\", \"miter\")");
            aVar.k(optString2);
            aVar.l(optJSONObject.optInt("miterLimit", 0));
            JSONArray optJSONArray3 = optJSONObject.optJSONArray("lineDash");
            if (optJSONArray3 != null) {
                aVar.j(new float[optJSONArray3.length()]);
                int length = optJSONArray3.length();
                for (int i10 = 0; i10 < length; i10++) {
                    aVar.c()[i10] = (float) optJSONArray3.optDouble(i10, ShadowDrawableWrapper.COS_45);
                }
            }
            this.f37992c = aVar;
        }
    }

    public final void n(ShapeEntity shapeEntity) {
        Transform transform = shapeEntity.transform;
        if (transform != null) {
            Matrix matrix = new Matrix();
            float[] fArr = new float[9];
            Float f10 = transform.f38032a;
            float floatValue = f10 != null ? f10.floatValue() : 1.0f;
            Float f11 = transform.f38033b;
            float floatValue2 = f11 != null ? f11.floatValue() : 0.0f;
            Float f12 = transform.f38034c;
            float floatValue3 = f12 != null ? f12.floatValue() : 0.0f;
            Float f13 = transform.f38035d;
            float floatValue4 = f13 != null ? f13.floatValue() : 1.0f;
            Float f14 = transform.tx;
            float floatValue5 = f14 != null ? f14.floatValue() : 0.0f;
            Float f15 = transform.ty;
            float floatValue6 = f15 != null ? f15.floatValue() : 0.0f;
            fArr[0] = floatValue;
            fArr[1] = floatValue3;
            fArr[2] = floatValue5;
            fArr[3] = floatValue2;
            fArr[4] = floatValue4;
            fArr[5] = floatValue6;
            fArr[6] = 0.0f;
            fArr[7] = 0.0f;
            fArr[8] = 1.0f;
            matrix.setValues(fArr);
            this.f37993d = matrix;
        }
    }

    public final void o(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("transform");
        if (optJSONObject != null) {
            Matrix matrix = new Matrix();
            double optDouble = optJSONObject.optDouble("a", 1.0d);
            double optDouble2 = optJSONObject.optDouble("b", ShadowDrawableWrapper.COS_45);
            double optDouble3 = optJSONObject.optDouble("c", ShadowDrawableWrapper.COS_45);
            double optDouble4 = optJSONObject.optDouble("d", 1.0d);
            double optDouble5 = optJSONObject.optDouble("tx", ShadowDrawableWrapper.COS_45);
            double optDouble6 = optJSONObject.optDouble(com.alipay.sdk.sys.a.f4666g, ShadowDrawableWrapper.COS_45);
            float f10 = (float) ShadowDrawableWrapper.COS_45;
            matrix.setValues(new float[]{(float) optDouble, (float) optDouble3, (float) optDouble5, (float) optDouble2, (float) optDouble4, (float) optDouble6, f10, f10, (float) 1.0d});
            this.f37993d = matrix;
        }
    }

    public final void p(ShapeEntity shapeEntity) {
        Type type;
        ShapeEntity.ShapeType shapeType = shapeEntity.type;
        if (shapeType != null) {
            int i10 = sb.d.f53698a[shapeType.ordinal()];
            if (i10 == 1) {
                type = Type.shape;
            } else if (i10 == 2) {
                type = Type.rect;
            } else if (i10 == 3) {
                type = Type.ellipse;
            } else {
                if (i10 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                type = Type.keep;
            }
            this.f37990a = type;
        }
    }

    public final void q(JSONObject jSONObject) {
        String optString = jSONObject.optString("type");
        if (optString != null) {
            if (p.r(optString, "shape", true)) {
                this.f37990a = Type.shape;
                return;
            }
            if (p.r(optString, "rect", true)) {
                this.f37990a = Type.rect;
            } else if (p.r(optString, "ellipse", true)) {
                this.f37990a = Type.ellipse;
            } else if (p.r(optString, "keep", true)) {
                this.f37990a = Type.keep;
            }
        }
    }

    public SVGAVideoShapeEntity(@NotNull ShapeEntity obj) {
        s.j(obj, "obj");
        this.f37990a = Type.shape;
        p(obj);
        j(obj);
        l(obj);
        n(obj);
    }
}
