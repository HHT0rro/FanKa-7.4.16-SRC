package m;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: ShapeTrimPathParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class m0 {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f51761a = JsonReader.a.a(com.kuaishou.weapon.p0.t.f36222g, "e", "o", "nm", "m", "hd");

    public static ShapeTrimPath a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String str = null;
        ShapeTrimPath.Type type = null;
        i.b bVar = null;
        i.b bVar2 = null;
        i.b bVar3 = null;
        boolean z10 = false;
        while (jsonReader.i()) {
            int y10 = jsonReader.y(f51761a);
            if (y10 == 0) {
                bVar = d.f(jsonReader, lottieComposition, false);
            } else if (y10 == 1) {
                bVar2 = d.f(jsonReader, lottieComposition, false);
            } else if (y10 == 2) {
                bVar3 = d.f(jsonReader, lottieComposition, false);
            } else if (y10 == 3) {
                str = jsonReader.r();
            } else if (y10 == 4) {
                type = ShapeTrimPath.Type.forId(jsonReader.l());
            } else if (y10 != 5) {
                jsonReader.A();
            } else {
                z10 = jsonReader.j();
            }
        }
        return new ShapeTrimPath(str, type, bVar, bVar2, bVar3, z10);
    }
}
