package m;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.IOException;
import java.lang.ref.WeakReference;
import sun.util.locale.LanguageTag;

/* compiled from: KeyframeParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class t {

    /* renamed from: b, reason: collision with root package name */
    public static SparseArrayCompat<WeakReference<Interpolator>> f51773b;

    /* renamed from: a, reason: collision with root package name */
    public static final Interpolator f51772a = new LinearInterpolator();

    /* renamed from: c, reason: collision with root package name */
    public static JsonReader.a f51774c = JsonReader.a.a("t", com.kuaishou.weapon.p0.t.f36222g, "e", "o", com.kuaishou.weapon.p0.t.f36220e, "h", RemoteMessageConst.TO, "ti");

    /* renamed from: d, reason: collision with root package name */
    public static JsonReader.a f51775d = JsonReader.a.a(LanguageTag.PRIVATEUSE, "y");

    @Nullable
    public static WeakReference<Interpolator> a(int i10) {
        WeakReference<Interpolator> weakReference;
        synchronized (t.class) {
            weakReference = g().get(i10);
        }
        return weakReference;
    }

    public static Interpolator b(PointF pointF, PointF pointF2) {
        Interpolator linearInterpolator;
        pointF.x = n.g.b(pointF.x, -1.0f, 1.0f);
        pointF.y = n.g.b(pointF.y, -100.0f, 100.0f);
        pointF2.x = n.g.b(pointF2.x, -1.0f, 1.0f);
        float b4 = n.g.b(pointF2.y, -100.0f, 100.0f);
        pointF2.y = b4;
        int i10 = n.h.i(pointF.x, pointF.y, pointF2.x, b4);
        WeakReference<Interpolator> a10 = com.airbnb.lottie.c.c() ? null : a(i10);
        Interpolator interpolator = a10 != null ? a10.get() : null;
        if (a10 == null || interpolator == null) {
            try {
                linearInterpolator = PathInterpolatorCompat.create(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (IllegalArgumentException e2) {
                if ("The Path cannot loop back on itself.".equals(e2.getMessage())) {
                    linearInterpolator = PathInterpolatorCompat.create(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y);
                } else {
                    linearInterpolator = new LinearInterpolator();
                }
            }
            interpolator = linearInterpolator;
            if (!com.airbnb.lottie.c.c()) {
                try {
                    h(i10, new WeakReference(interpolator));
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
            }
        }
        return interpolator;
    }

    public static <T> o.a<T> c(JsonReader jsonReader, LottieComposition lottieComposition, float f10, n0<T> n0Var, boolean z10, boolean z11) throws IOException {
        if (z10 && z11) {
            return e(lottieComposition, jsonReader, f10, n0Var);
        }
        if (z10) {
            return d(lottieComposition, jsonReader, f10, n0Var);
        }
        return f(jsonReader, f10, n0Var);
    }

    public static <T> o.a<T> d(LottieComposition lottieComposition, JsonReader jsonReader, float f10, n0<T> n0Var) throws IOException {
        Interpolator interpolator;
        Interpolator interpolator2;
        T t2;
        jsonReader.d();
        PointF pointF = null;
        PointF pointF2 = null;
        T t10 = null;
        T t11 = null;
        PointF pointF3 = null;
        PointF pointF4 = null;
        boolean z10 = false;
        float f11 = 0.0f;
        while (jsonReader.i()) {
            switch (jsonReader.y(f51774c)) {
                case 0:
                    f11 = (float) jsonReader.k();
                    break;
                case 1:
                    t11 = n0Var.a(jsonReader, f10);
                    break;
                case 2:
                    t10 = n0Var.a(jsonReader, f10);
                    break;
                case 3:
                    pointF = s.e(jsonReader, 1.0f);
                    break;
                case 4:
                    pointF2 = s.e(jsonReader, 1.0f);
                    break;
                case 5:
                    if (jsonReader.l() != 1) {
                        z10 = false;
                        break;
                    } else {
                        z10 = true;
                        break;
                    }
                case 6:
                    pointF3 = s.e(jsonReader, f10);
                    break;
                case 7:
                    pointF4 = s.e(jsonReader, f10);
                    break;
                default:
                    jsonReader.A();
                    break;
            }
        }
        jsonReader.f();
        if (z10) {
            interpolator2 = f51772a;
            t2 = t11;
        } else {
            if (pointF != null && pointF2 != null) {
                interpolator = b(pointF, pointF2);
            } else {
                interpolator = f51772a;
            }
            interpolator2 = interpolator;
            t2 = t10;
        }
        o.a<T> aVar = new o.a<>(lottieComposition, t11, t2, interpolator2, f11, null);
        aVar.f52224o = pointF3;
        aVar.f52225p = pointF4;
        return aVar;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0023. Please report as an issue. */
    public static <T> o.a<T> e(LottieComposition lottieComposition, JsonReader jsonReader, float f10, n0<T> n0Var) throws IOException {
        Interpolator interpolator;
        Interpolator b4;
        Interpolator b10;
        T t2;
        PointF pointF;
        o.a<T> aVar;
        PointF pointF2;
        float f11;
        PointF pointF3;
        jsonReader.d();
        PointF pointF4 = null;
        boolean z10 = false;
        PointF pointF5 = null;
        PointF pointF6 = null;
        PointF pointF7 = null;
        T t10 = null;
        PointF pointF8 = null;
        PointF pointF9 = null;
        PointF pointF10 = null;
        float f12 = 0.0f;
        PointF pointF11 = null;
        T t11 = null;
        while (jsonReader.i()) {
            switch (jsonReader.y(f51774c)) {
                case 0:
                    pointF2 = pointF4;
                    f12 = (float) jsonReader.k();
                    pointF4 = pointF2;
                    break;
                case 1:
                    pointF2 = pointF4;
                    t10 = n0Var.a(jsonReader, f10);
                    pointF4 = pointF2;
                    break;
                case 2:
                    pointF2 = pointF4;
                    t11 = n0Var.a(jsonReader, f10);
                    pointF4 = pointF2;
                    break;
                case 3:
                    pointF2 = pointF4;
                    f11 = f12;
                    PointF pointF12 = pointF11;
                    if (jsonReader.w() == JsonReader.Token.BEGIN_OBJECT) {
                        jsonReader.d();
                        float f13 = 0.0f;
                        float f14 = 0.0f;
                        float f15 = 0.0f;
                        float f16 = 0.0f;
                        while (jsonReader.i()) {
                            int y10 = jsonReader.y(f51775d);
                            if (y10 == 0) {
                                JsonReader.Token w3 = jsonReader.w();
                                JsonReader.Token token = JsonReader.Token.NUMBER;
                                if (w3 == token) {
                                    f15 = (float) jsonReader.k();
                                    f13 = f15;
                                } else {
                                    jsonReader.b();
                                    f13 = (float) jsonReader.k();
                                    f15 = jsonReader.w() == token ? (float) jsonReader.k() : f13;
                                    jsonReader.e();
                                }
                            } else if (y10 != 1) {
                                jsonReader.A();
                            } else {
                                JsonReader.Token w10 = jsonReader.w();
                                JsonReader.Token token2 = JsonReader.Token.NUMBER;
                                if (w10 == token2) {
                                    f16 = (float) jsonReader.k();
                                    f14 = f16;
                                } else {
                                    jsonReader.b();
                                    f14 = (float) jsonReader.k();
                                    f16 = jsonReader.w() == token2 ? (float) jsonReader.k() : f14;
                                    jsonReader.e();
                                }
                            }
                        }
                        PointF pointF13 = new PointF(f13, f14);
                        PointF pointF14 = new PointF(f15, f16);
                        jsonReader.f();
                        pointF8 = pointF14;
                        pointF7 = pointF13;
                        pointF11 = pointF12;
                        f12 = f11;
                        pointF4 = pointF2;
                        break;
                    } else {
                        pointF5 = s.e(jsonReader, f10);
                        f12 = f11;
                        pointF11 = pointF12;
                        pointF4 = pointF2;
                    }
                case 4:
                    if (jsonReader.w() == JsonReader.Token.BEGIN_OBJECT) {
                        jsonReader.d();
                        float f17 = 0.0f;
                        float f18 = 0.0f;
                        float f19 = 0.0f;
                        float f20 = 0.0f;
                        while (jsonReader.i()) {
                            PointF pointF15 = pointF11;
                            int y11 = jsonReader.y(f51775d);
                            if (y11 != 0) {
                                pointF3 = pointF4;
                                if (y11 != 1) {
                                    jsonReader.A();
                                } else {
                                    JsonReader.Token w11 = jsonReader.w();
                                    JsonReader.Token token3 = JsonReader.Token.NUMBER;
                                    if (w11 == token3) {
                                        f20 = (float) jsonReader.k();
                                        f12 = f12;
                                        f18 = f20;
                                    } else {
                                        float f21 = f12;
                                        jsonReader.b();
                                        float k10 = (float) jsonReader.k();
                                        float k11 = jsonReader.w() == token3 ? (float) jsonReader.k() : k10;
                                        jsonReader.e();
                                        f12 = f21;
                                        pointF11 = pointF15;
                                        pointF4 = pointF3;
                                        f20 = k11;
                                        f18 = k10;
                                    }
                                }
                            } else {
                                pointF3 = pointF4;
                                float f22 = f12;
                                JsonReader.Token w12 = jsonReader.w();
                                JsonReader.Token token4 = JsonReader.Token.NUMBER;
                                if (w12 == token4) {
                                    f19 = (float) jsonReader.k();
                                    f12 = f22;
                                    f17 = f19;
                                } else {
                                    jsonReader.b();
                                    f17 = (float) jsonReader.k();
                                    f19 = jsonReader.w() == token4 ? (float) jsonReader.k() : f17;
                                    jsonReader.e();
                                    f12 = f22;
                                }
                            }
                            pointF11 = pointF15;
                            pointF4 = pointF3;
                        }
                        pointF2 = pointF4;
                        f11 = f12;
                        PointF pointF16 = new PointF(f17, f18);
                        PointF pointF17 = new PointF(f19, f20);
                        jsonReader.f();
                        pointF10 = pointF17;
                        pointF9 = pointF16;
                        f12 = f11;
                        pointF4 = pointF2;
                        break;
                    } else {
                        pointF2 = pointF4;
                        pointF6 = s.e(jsonReader, f10);
                        pointF4 = pointF2;
                    }
                case 5:
                    if (jsonReader.l() != 1) {
                        z10 = false;
                        break;
                    } else {
                        z10 = true;
                        break;
                    }
                case 6:
                    pointF11 = s.e(jsonReader, f10);
                    break;
                case 7:
                    pointF4 = s.e(jsonReader, f10);
                    break;
                default:
                    pointF2 = pointF4;
                    jsonReader.A();
                    pointF4 = pointF2;
                    break;
            }
        }
        PointF pointF18 = pointF4;
        float f23 = f12;
        PointF pointF19 = pointF11;
        jsonReader.f();
        if (z10) {
            interpolator = f51772a;
            t2 = t10;
        } else {
            if (pointF5 != null && pointF6 != null) {
                interpolator = b(pointF5, pointF6);
            } else {
                if (pointF7 != null && pointF8 != null && pointF9 != null && pointF10 != null) {
                    b4 = b(pointF7, pointF9);
                    b10 = b(pointF8, pointF10);
                    t2 = t11;
                    interpolator = null;
                    if (b4 == null && b10 != null) {
                        pointF = pointF19;
                        aVar = new o.a<>(lottieComposition, t10, t2, b4, b10, f23, null);
                    } else {
                        pointF = pointF19;
                        aVar = new o.a<>(lottieComposition, t10, t2, interpolator, f23, null);
                    }
                    aVar.f52224o = pointF;
                    aVar.f52225p = pointF18;
                    return aVar;
                }
                interpolator = f51772a;
            }
            t2 = t11;
        }
        b4 = null;
        b10 = null;
        if (b4 == null) {
        }
        pointF = pointF19;
        aVar = new o.a<>(lottieComposition, t10, t2, interpolator, f23, null);
        aVar.f52224o = pointF;
        aVar.f52225p = pointF18;
        return aVar;
    }

    public static <T> o.a<T> f(JsonReader jsonReader, float f10, n0<T> n0Var) throws IOException {
        return new o.a<>(n0Var.a(jsonReader, f10));
    }

    public static SparseArrayCompat<WeakReference<Interpolator>> g() {
        if (f51773b == null) {
            f51773b = new SparseArrayCompat<>();
        }
        return f51773b;
    }

    public static void h(int i10, WeakReference<Interpolator> weakReference) {
        synchronized (t.class) {
            f51773b.put(i10, weakReference);
        }
    }
}
