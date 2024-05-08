package m;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: PolystarShapeParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class c0 {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f51727a = JsonReader.a.a("nm", "sy", "pt", com.kuaishou.weapon.p0.t.f36217b, com.kuaishou.weapon.p0.t.f36226k, "or", "os", "ir", "is", "hd", "d");

    public static PolystarShape a(JsonReader jsonReader, LottieComposition lottieComposition, int i10) throws IOException {
        boolean z10 = i10 == 3;
        String str = null;
        PolystarShape.Type type = null;
        i.b bVar = null;
        i.m<PointF, PointF> mVar = null;
        i.b bVar2 = null;
        i.b bVar3 = null;
        i.b bVar4 = null;
        i.b bVar5 = null;
        i.b bVar6 = null;
        boolean z11 = false;
        while (jsonReader.i()) {
            switch (jsonReader.y(f51727a)) {
                case 0:
                    str = jsonReader.r();
                    break;
                case 1:
                    type = PolystarShape.Type.forValue(jsonReader.l());
                    break;
                case 2:
                    bVar = d.f(jsonReader, lottieComposition, false);
                    break;
                case 3:
                    mVar = a.b(jsonReader, lottieComposition);
                    break;
                case 4:
                    bVar2 = d.f(jsonReader, lottieComposition, false);
                    break;
                case 5:
                    bVar4 = d.e(jsonReader, lottieComposition);
                    break;
                case 6:
                    bVar6 = d.f(jsonReader, lottieComposition, false);
                    break;
                case 7:
                    bVar3 = d.e(jsonReader, lottieComposition);
                    break;
                case 8:
                    bVar5 = d.f(jsonReader, lottieComposition, false);
                    break;
                case 9:
                    z11 = jsonReader.j();
                    break;
                case 10:
                    if (jsonReader.l() != 3) {
                        z10 = false;
                        break;
                    } else {
                        z10 = true;
                        break;
                    }
                default:
                    jsonReader.z();
                    jsonReader.A();
                    break;
            }
        }
        return new PolystarShape(str, type, bVar, mVar, bVar2, bVar3, bVar4, bVar5, bVar6, z11, z10);
    }
}
