package m;

import android.graphics.Path;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.Collections;

/* compiled from: GradientFillParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f51764a = JsonReader.a.a("nm", "g", "o", "t", com.kuaishou.weapon.p0.t.f36222g, "e", com.kuaishou.weapon.p0.t.f36226k, "hd");

    /* renamed from: b, reason: collision with root package name */
    public static final JsonReader.a f51765b = JsonReader.a.a(com.kuaishou.weapon.p0.t.f36217b, "k");

    public static j.d a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        i.d dVar = null;
        Path.FillType fillType = Path.FillType.WINDING;
        String str = null;
        GradientType gradientType = null;
        i.c cVar = null;
        i.f fVar = null;
        i.f fVar2 = null;
        boolean z10 = false;
        while (jsonReader.i()) {
            switch (jsonReader.y(f51764a)) {
                case 0:
                    str = jsonReader.r();
                    break;
                case 1:
                    int i10 = -1;
                    jsonReader.d();
                    while (jsonReader.i()) {
                        int y10 = jsonReader.y(f51765b);
                        if (y10 == 0) {
                            i10 = jsonReader.l();
                        } else if (y10 != 1) {
                            jsonReader.z();
                            jsonReader.A();
                        } else {
                            cVar = d.g(jsonReader, lottieComposition, i10);
                        }
                    }
                    jsonReader.f();
                    break;
                case 2:
                    dVar = d.h(jsonReader, lottieComposition);
                    break;
                case 3:
                    gradientType = jsonReader.l() == 1 ? GradientType.LINEAR : GradientType.RADIAL;
                    break;
                case 4:
                    fVar = d.i(jsonReader, lottieComposition);
                    break;
                case 5:
                    fVar2 = d.i(jsonReader, lottieComposition);
                    break;
                case 6:
                    fillType = jsonReader.l() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case 7:
                    z10 = jsonReader.j();
                    break;
                default:
                    jsonReader.z();
                    jsonReader.A();
                    break;
            }
        }
        return new j.d(str, gradientType, fillType, cVar, dVar == null ? new i.d(Collections.singletonList(new o.a(100))) : dVar, fVar, fVar2, null, null, z10);
    }
}
