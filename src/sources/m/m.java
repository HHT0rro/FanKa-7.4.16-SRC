package m;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: FontCharacterParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f51759a = JsonReader.a.a("ch", "size", IAdInterListener.AdReqParam.WIDTH, "style", "fFamily", "data");

    /* renamed from: b, reason: collision with root package name */
    public static final JsonReader.a f51760b = JsonReader.a.a("shapes");

    public static h.b a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.d();
        String str = null;
        String str2 = null;
        double d10 = 0.0d;
        double d11 = 0.0d;
        char c4 = 0;
        while (jsonReader.i()) {
            int y10 = jsonReader.y(f51759a);
            if (y10 == 0) {
                c4 = jsonReader.r().charAt(0);
            } else if (y10 == 1) {
                d10 = jsonReader.k();
            } else if (y10 == 2) {
                d11 = jsonReader.k();
            } else if (y10 == 3) {
                str = jsonReader.r();
            } else if (y10 == 4) {
                str2 = jsonReader.r();
            } else if (y10 != 5) {
                jsonReader.z();
                jsonReader.A();
            } else {
                jsonReader.d();
                while (jsonReader.i()) {
                    if (jsonReader.y(f51760b) != 0) {
                        jsonReader.z();
                        jsonReader.A();
                    } else {
                        jsonReader.b();
                        while (jsonReader.i()) {
                            arrayList.add((j.i) h.a(jsonReader, lottieComposition));
                        }
                        jsonReader.e();
                    }
                }
                jsonReader.f();
            }
        }
        jsonReader.f();
        return new h.b(arrayList, c4, d10, d11, str, str2);
    }
}
