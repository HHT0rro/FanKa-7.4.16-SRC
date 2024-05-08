package m;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: FloatParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class l implements n0<Float> {

    /* renamed from: a, reason: collision with root package name */
    public static final l f51756a = new l();

    @Override // m.n0
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Float a(JsonReader jsonReader, float f10) throws IOException {
        return Float.valueOf(s.g(jsonReader) * f10);
    }
}
