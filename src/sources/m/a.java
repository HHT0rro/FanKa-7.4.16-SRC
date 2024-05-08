package m;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import sun.util.locale.LanguageTag;

/* compiled from: AnimatablePathValueParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f51720a = JsonReader.a.a("k", LanguageTag.PRIVATEUSE, "y");

    public static i.e a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.w() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.b();
            while (jsonReader.i()) {
                arrayList.add(z.a(jsonReader, lottieComposition));
            }
            jsonReader.e();
            u.b(arrayList);
        } else {
            arrayList.add(new o.a(s.e(jsonReader, n.h.e())));
        }
        return new i.e(arrayList);
    }

    public static i.m<PointF, PointF> b(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        jsonReader.d();
        i.e eVar = null;
        i.b bVar = null;
        i.b bVar2 = null;
        boolean z10 = false;
        while (jsonReader.w() != JsonReader.Token.END_OBJECT) {
            int y10 = jsonReader.y(f51720a);
            if (y10 == 0) {
                eVar = a(jsonReader, lottieComposition);
            } else if (y10 != 1) {
                if (y10 != 2) {
                    jsonReader.z();
                    jsonReader.A();
                } else if (jsonReader.w() == JsonReader.Token.STRING) {
                    jsonReader.A();
                    z10 = true;
                } else {
                    bVar2 = d.e(jsonReader, lottieComposition);
                }
            } else if (jsonReader.w() == JsonReader.Token.STRING) {
                jsonReader.A();
                z10 = true;
            } else {
                bVar = d.e(jsonReader, lottieComposition);
            }
        }
        jsonReader.f();
        if (z10) {
            lottieComposition.a("Lottie doesn't support expressions.");
        }
        return eVar != null ? eVar : new i.i(bVar, bVar2);
    }
}
