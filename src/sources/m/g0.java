package m;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: ScaleXYParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class g0 implements n0<o.d> {

    /* renamed from: a, reason: collision with root package name */
    public static final g0 f51735a = new g0();

    @Override // m.n0
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public o.d a(JsonReader jsonReader, float f10) throws IOException {
        boolean z10 = jsonReader.w() == JsonReader.Token.BEGIN_ARRAY;
        if (z10) {
            jsonReader.b();
        }
        float k10 = (float) jsonReader.k();
        float k11 = (float) jsonReader.k();
        while (jsonReader.i()) {
            jsonReader.A();
        }
        if (z10) {
            jsonReader.e();
        }
        return new o.d((k10 / 100.0f) * f10, (k11 / 100.0f) * f10);
    }
}
