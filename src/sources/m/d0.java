package m;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: RectangleShapeParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class d0 {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f51728a = JsonReader.a.a("nm", com.kuaishou.weapon.p0.t.f36217b, com.kuaishou.weapon.p0.t.f36222g, com.kuaishou.weapon.p0.t.f36226k, "hd");

    public static j.e a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String str = null;
        i.m<PointF, PointF> mVar = null;
        i.f fVar = null;
        i.b bVar = null;
        boolean z10 = false;
        while (jsonReader.i()) {
            int y10 = jsonReader.y(f51728a);
            if (y10 == 0) {
                str = jsonReader.r();
            } else if (y10 == 1) {
                mVar = a.b(jsonReader, lottieComposition);
            } else if (y10 == 2) {
                fVar = d.i(jsonReader, lottieComposition);
            } else if (y10 == 3) {
                bVar = d.e(jsonReader, lottieComposition);
            } else if (y10 != 4) {
                jsonReader.A();
            } else {
                z10 = jsonReader.j();
            }
        }
        return new j.e(str, mVar, fVar, bVar, z10);
    }
}
