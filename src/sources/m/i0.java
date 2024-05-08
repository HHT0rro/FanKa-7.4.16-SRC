package m;

import android.graphics.Path;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.Collections;

/* compiled from: ShapeFillParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class i0 {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f51741a = JsonReader.a.a("nm", "c", "o", "fillEnabled", com.kuaishou.weapon.p0.t.f36226k, "hd");

    public static j.h a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        i.d dVar = null;
        String str = null;
        i.a aVar = null;
        int i10 = 1;
        boolean z10 = false;
        boolean z11 = false;
        while (jsonReader.i()) {
            int y10 = jsonReader.y(f51741a);
            if (y10 == 0) {
                str = jsonReader.r();
            } else if (y10 == 1) {
                aVar = d.c(jsonReader, lottieComposition);
            } else if (y10 == 2) {
                dVar = d.h(jsonReader, lottieComposition);
            } else if (y10 == 3) {
                z10 = jsonReader.j();
            } else if (y10 == 4) {
                i10 = jsonReader.l();
            } else if (y10 != 5) {
                jsonReader.z();
                jsonReader.A();
            } else {
                z11 = jsonReader.j();
            }
        }
        return new j.h(str, z10, i10 == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, aVar, dVar == null ? new i.d(Collections.singletonList(new o.a(100))) : dVar, z11);
    }
}
