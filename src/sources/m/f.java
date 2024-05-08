package m;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: CircleShapeParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f51732a = JsonReader.a.a("nm", com.kuaishou.weapon.p0.t.f36217b, com.kuaishou.weapon.p0.t.f36222g, "hd", "d");

    public static j.b a(JsonReader jsonReader, LottieComposition lottieComposition, int i10) throws IOException {
        boolean z10 = i10 == 3;
        String str = null;
        i.m<PointF, PointF> mVar = null;
        i.f fVar = null;
        boolean z11 = false;
        while (jsonReader.i()) {
            int y10 = jsonReader.y(f51732a);
            if (y10 == 0) {
                str = jsonReader.r();
            } else if (y10 == 1) {
                mVar = a.b(jsonReader, lottieComposition);
            } else if (y10 == 2) {
                fVar = d.i(jsonReader, lottieComposition);
            } else if (y10 == 3) {
                z11 = jsonReader.j();
            } else if (y10 != 4) {
                jsonReader.z();
                jsonReader.A();
            } else {
                z10 = jsonReader.l() == 3;
            }
        }
        return new j.b(str, mVar, fVar, z10, z11);
    }
}
