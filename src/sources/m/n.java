package m;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: FontParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f51762a = JsonReader.a.a("fFamily", "fName", "fStyle", "ascent");

    public static h.a a(JsonReader jsonReader) throws IOException {
        jsonReader.d();
        String str = null;
        String str2 = null;
        String str3 = null;
        float f10 = 0.0f;
        while (jsonReader.i()) {
            int y10 = jsonReader.y(f51762a);
            if (y10 == 0) {
                str = jsonReader.r();
            } else if (y10 == 1) {
                str2 = jsonReader.r();
            } else if (y10 == 2) {
                str3 = jsonReader.r();
            } else if (y10 != 3) {
                jsonReader.z();
                jsonReader.A();
            } else {
                f10 = (float) jsonReader.k();
            }
        }
        jsonReader.f();
        return new h.a(str, str2, str3, f10);
    }
}
