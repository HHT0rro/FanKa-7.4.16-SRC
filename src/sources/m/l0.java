package m;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: ShapeStrokeParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class l0 {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f51757a = JsonReader.a.a("nm", "c", IAdInterListener.AdReqParam.WIDTH, "o", "lc", "lj", "ml", "hd", "d");

    /* renamed from: b, reason: collision with root package name */
    public static final JsonReader.a f51758b = JsonReader.a.a("n", com.kuaishou.weapon.p0.t.f36218c);

    /* JADX WARN: Multi-variable type inference failed */
    public static ShapeStroke a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        char c4;
        ArrayList arrayList = new ArrayList();
        String str = null;
        i.b bVar = null;
        i.a aVar = null;
        i.b bVar2 = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        float f10 = 0.0f;
        boolean z10 = false;
        i.d dVar = null;
        while (jsonReader.i()) {
            switch (jsonReader.y(f51757a)) {
                case 0:
                    str = jsonReader.r();
                    break;
                case 1:
                    aVar = d.c(jsonReader, lottieComposition);
                    break;
                case 2:
                    bVar2 = d.e(jsonReader, lottieComposition);
                    break;
                case 3:
                    dVar = d.h(jsonReader, lottieComposition);
                    break;
                case 4:
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.l() - 1];
                    break;
                case 5:
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.l() - 1];
                    break;
                case 6:
                    f10 = (float) jsonReader.k();
                    break;
                case 7:
                    z10 = jsonReader.j();
                    break;
                case 8:
                    jsonReader.b();
                    while (jsonReader.i()) {
                        jsonReader.d();
                        String str2 = null;
                        i.b bVar3 = null;
                        while (jsonReader.i()) {
                            int y10 = jsonReader.y(f51758b);
                            if (y10 == 0) {
                                str2 = jsonReader.r();
                            } else if (y10 != 1) {
                                jsonReader.z();
                                jsonReader.A();
                            } else {
                                bVar3 = d.e(jsonReader, lottieComposition);
                            }
                        }
                        jsonReader.f();
                        str2.hashCode();
                        switch (str2.hashCode()) {
                            case 100:
                                if (str2.equals("d")) {
                                    c4 = 0;
                                    break;
                                }
                                break;
                            case 103:
                                if (str2.equals("g")) {
                                    c4 = 1;
                                    break;
                                }
                                break;
                            case 111:
                                if (str2.equals("o")) {
                                    c4 = 2;
                                    break;
                                }
                                break;
                        }
                        c4 = 65535;
                        switch (c4) {
                            case 0:
                            case 1:
                                lottieComposition.u(true);
                                arrayList.add(bVar3);
                                break;
                            case 2:
                                bVar = bVar3;
                                break;
                        }
                    }
                    jsonReader.e();
                    if (arrayList.size() != 1) {
                        break;
                    } else {
                        arrayList.add((i.b) arrayList.get(0));
                        break;
                    }
                    break;
                default:
                    jsonReader.A();
                    break;
            }
        }
        if (dVar == null) {
            dVar = new i.d(Collections.singletonList(new o.a(100)));
        }
        return new ShapeStroke(str, bVar, arrayList, aVar, dVar, bVar2, lineCapType, lineJoinType, f10, z10);
    }
}
