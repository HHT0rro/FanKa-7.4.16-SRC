package m;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: ShapeGroupParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class j0 {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f51747a = JsonReader.a.a("nm", "hd", "it");

    public static j.i a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList = new ArrayList();
        String str = null;
        boolean z10 = false;
        while (jsonReader.i()) {
            int y10 = jsonReader.y(f51747a);
            if (y10 == 0) {
                str = jsonReader.r();
            } else if (y10 == 1) {
                z10 = jsonReader.j();
            } else if (y10 != 2) {
                jsonReader.A();
            } else {
                jsonReader.b();
                while (jsonReader.i()) {
                    ContentModel a10 = h.a(jsonReader, lottieComposition);
                    if (a10 != null) {
                        arrayList.add(a10);
                    }
                }
                jsonReader.e();
            }
        }
        return new j.i(str, arrayList, z10);
    }
}
