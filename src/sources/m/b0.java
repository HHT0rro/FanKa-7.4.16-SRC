package m;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: PointFParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class b0 implements n0<PointF> {

    /* renamed from: a, reason: collision with root package name */
    public static final b0 f51724a = new b0();

    @Override // m.n0
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public PointF a(JsonReader jsonReader, float f10) throws IOException {
        JsonReader.Token w3 = jsonReader.w();
        if (w3 == JsonReader.Token.BEGIN_ARRAY) {
            return s.e(jsonReader, f10);
        }
        if (w3 == JsonReader.Token.BEGIN_OBJECT) {
            return s.e(jsonReader, f10);
        }
        if (w3 == JsonReader.Token.NUMBER) {
            PointF pointF = new PointF(((float) jsonReader.k()) * f10, ((float) jsonReader.k()) * f10);
            while (jsonReader.i()) {
                jsonReader.A();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + ((Object) w3));
    }
}
