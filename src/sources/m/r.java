package m;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: IntegerParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class r implements n0<Integer> {

    /* renamed from: a, reason: collision with root package name */
    public static final r f51769a = new r();

    @Override // m.n0
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer a(JsonReader jsonReader, float f10) throws IOException {
        return Integer.valueOf(Math.round(s.g(jsonReader) * f10));
    }
}
