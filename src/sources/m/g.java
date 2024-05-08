package m;

import android.graphics.Color;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: ColorParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class g implements n0<Integer> {

    /* renamed from: a, reason: collision with root package name */
    public static final g f51734a = new g();

    @Override // m.n0
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer a(JsonReader jsonReader, float f10) throws IOException {
        boolean z10 = jsonReader.w() == JsonReader.Token.BEGIN_ARRAY;
        if (z10) {
            jsonReader.b();
        }
        double k10 = jsonReader.k();
        double k11 = jsonReader.k();
        double k12 = jsonReader.k();
        double k13 = jsonReader.w() == JsonReader.Token.NUMBER ? jsonReader.k() : 1.0d;
        if (z10) {
            jsonReader.e();
        }
        if (k10 <= 1.0d && k11 <= 1.0d && k12 <= 1.0d) {
            k10 *= 255.0d;
            k11 *= 255.0d;
            k12 *= 255.0d;
            if (k13 <= 1.0d) {
                k13 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) k13, (int) k10, (int) k11, (int) k12));
    }
}
