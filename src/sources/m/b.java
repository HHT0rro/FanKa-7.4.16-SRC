package m;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: AnimatableTextPropertiesParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f51722a = JsonReader.a.a("a");

    /* renamed from: b, reason: collision with root package name */
    public static final JsonReader.a f51723b = JsonReader.a.a("fc", "sc", "sw", "t");

    public static i.k a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        jsonReader.d();
        i.k kVar = null;
        while (jsonReader.i()) {
            if (jsonReader.y(f51722a) != 0) {
                jsonReader.z();
                jsonReader.A();
            } else {
                kVar = b(jsonReader, lottieComposition);
            }
        }
        jsonReader.f();
        return kVar == null ? new i.k(null, null, null, null) : kVar;
    }

    public static i.k b(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        jsonReader.d();
        i.a aVar = null;
        i.a aVar2 = null;
        i.b bVar = null;
        i.b bVar2 = null;
        while (jsonReader.i()) {
            int y10 = jsonReader.y(f51723b);
            if (y10 == 0) {
                aVar = d.c(jsonReader, lottieComposition);
            } else if (y10 == 1) {
                aVar2 = d.c(jsonReader, lottieComposition);
            } else if (y10 == 2) {
                bVar = d.e(jsonReader, lottieComposition);
            } else if (y10 != 3) {
                jsonReader.z();
                jsonReader.A();
            } else {
                bVar2 = d.e(jsonReader, lottieComposition);
            }
        }
        jsonReader.f();
        return new i.k(aVar, aVar2, bVar, bVar2);
    }
}
