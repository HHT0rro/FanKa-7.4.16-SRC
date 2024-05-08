package m;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.IOException;

/* compiled from: ShapePathParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class k0 {

    /* renamed from: a, reason: collision with root package name */
    public static JsonReader.a f51755a = JsonReader.a.a("nm", "ind", MediationConstant.ADN_KS, "hd");

    public static j.j a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        int i10 = 0;
        String str = null;
        i.h hVar = null;
        boolean z10 = false;
        while (jsonReader.i()) {
            int y10 = jsonReader.y(f51755a);
            if (y10 == 0) {
                str = jsonReader.r();
            } else if (y10 == 1) {
                i10 = jsonReader.l();
            } else if (y10 == 2) {
                hVar = d.k(jsonReader, lottieComposition);
            } else if (y10 != 3) {
                jsonReader.A();
            } else {
                z10 = jsonReader.j();
            }
        }
        return new j.j(str, i10, hVar, z10);
    }
}
