package m;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: RepeaterParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class e0 {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f51731a = JsonReader.a.a("nm", "c", "o", "tr", "hd");

    public static j.f a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String str = null;
        i.b bVar = null;
        i.b bVar2 = null;
        i.l lVar = null;
        boolean z10 = false;
        while (jsonReader.i()) {
            int y10 = jsonReader.y(f51731a);
            if (y10 == 0) {
                str = jsonReader.r();
            } else if (y10 == 1) {
                bVar = d.f(jsonReader, lottieComposition, false);
            } else if (y10 == 2) {
                bVar2 = d.f(jsonReader, lottieComposition, false);
            } else if (y10 == 3) {
                lVar = c.g(jsonReader, lottieComposition);
            } else if (y10 != 4) {
                jsonReader.A();
            } else {
                z10 = jsonReader.j();
            }
        }
        return new j.f(str, bVar, bVar2, lVar, z10);
    }
}
