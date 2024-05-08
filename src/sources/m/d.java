package m;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.List;

/* compiled from: AnimatableValueParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class d {
    public static <T> List<o.a<T>> a(JsonReader jsonReader, float f10, LottieComposition lottieComposition, n0<T> n0Var) throws IOException {
        return u.a(jsonReader, lottieComposition, f10, n0Var, false);
    }

    public static <T> List<o.a<T>> b(JsonReader jsonReader, LottieComposition lottieComposition, n0<T> n0Var) throws IOException {
        return u.a(jsonReader, lottieComposition, 1.0f, n0Var, false);
    }

    public static i.a c(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new i.a(b(jsonReader, lottieComposition, g.f51734a));
    }

    public static i.j d(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new i.j(a(jsonReader, n.h.e(), lottieComposition, i.f51739a));
    }

    public static i.b e(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return f(jsonReader, lottieComposition, true);
    }

    public static i.b f(JsonReader jsonReader, LottieComposition lottieComposition, boolean z10) throws IOException {
        return new i.b(a(jsonReader, z10 ? n.h.e() : 1.0f, lottieComposition, l.f51756a));
    }

    public static i.c g(JsonReader jsonReader, LottieComposition lottieComposition, int i10) throws IOException {
        return new i.c(b(jsonReader, lottieComposition, new o(i10)));
    }

    public static i.d h(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new i.d(b(jsonReader, lottieComposition, r.f51769a));
    }

    public static i.f i(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new i.f(u.a(jsonReader, lottieComposition, n.h.e(), b0.f51724a, true));
    }

    public static i.g j(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new i.g(b(jsonReader, lottieComposition, g0.f51735a));
    }

    public static i.h k(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new i.h(a(jsonReader, n.h.e(), lottieComposition, h0.f51737a));
    }
}
