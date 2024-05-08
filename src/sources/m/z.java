package m;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: PathKeyframeParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class z {
    public static f.i a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new f.i(lottieComposition, t.c(jsonReader, lottieComposition, n.h.e(), a0.f51721a, jsonReader.w() == JsonReader.Token.BEGIN_OBJECT, false));
    }
}
