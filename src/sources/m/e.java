package m;

import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: BlurEffectParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f51729a = JsonReader.a.a("ef");

    /* renamed from: b, reason: collision with root package name */
    public static final JsonReader.a f51730b = JsonReader.a.a(com.alipay.sdk.sys.a.f4666g, com.kuaishou.weapon.p0.t.f36218c);

    @Nullable
    public static j.a a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        jsonReader.d();
        j.a aVar = null;
        while (true) {
            boolean z10 = false;
            while (jsonReader.i()) {
                int y10 = jsonReader.y(f51730b);
                if (y10 != 0) {
                    if (y10 != 1) {
                        jsonReader.z();
                        jsonReader.A();
                    } else if (z10) {
                        aVar = new j.a(d.e(jsonReader, lottieComposition));
                    } else {
                        jsonReader.A();
                    }
                } else if (jsonReader.l() == 0) {
                    z10 = true;
                }
            }
            jsonReader.f();
            return aVar;
        }
    }

    @Nullable
    public static j.a b(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        j.a aVar = null;
        while (jsonReader.i()) {
            if (jsonReader.y(f51729a) != 0) {
                jsonReader.z();
                jsonReader.A();
            } else {
                jsonReader.b();
                while (jsonReader.i()) {
                    j.a a10 = a(jsonReader, lottieComposition);
                    if (a10 != null) {
                        aVar = a10;
                    }
                }
                jsonReader.e();
            }
        }
        return aVar;
    }
}
