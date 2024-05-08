package m;

import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: RoundedCornersParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class f0 {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f51733a = JsonReader.a.a("nm", com.kuaishou.weapon.p0.t.f36226k, "hd");

    @Nullable
    public static j.g a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        boolean z10 = false;
        String str = null;
        i.b bVar = null;
        while (jsonReader.i()) {
            int y10 = jsonReader.y(f51733a);
            if (y10 == 0) {
                str = jsonReader.r();
            } else if (y10 == 1) {
                bVar = d.f(jsonReader, lottieComposition, true);
            } else if (y10 != 2) {
                jsonReader.A();
            } else {
                z10 = jsonReader.j();
            }
        }
        if (z10) {
            return null;
        }
        return new j.g(str, bVar);
    }
}
