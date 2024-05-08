package m;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: GradientStrokeParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f51766a = JsonReader.a.a("nm", "g", "o", "t", com.kuaishou.weapon.p0.t.f36222g, "e", IAdInterListener.AdReqParam.WIDTH, "lc", "lj", "ml", "hd", "d");

    /* renamed from: b, reason: collision with root package name */
    public static final JsonReader.a f51767b = JsonReader.a.a(com.kuaishou.weapon.p0.t.f36217b, "k");

    /* renamed from: c, reason: collision with root package name */
    public static final JsonReader.a f51768c = JsonReader.a.a("n", com.kuaishou.weapon.p0.t.f36218c);

    /* JADX WARN: Multi-variable type inference failed */
    public static com.airbnb.lottie.model.content.a a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        i.c cVar;
        ArrayList arrayList = new ArrayList();
        String str = null;
        GradientType gradientType = null;
        i.c cVar2 = null;
        i.f fVar = null;
        i.f fVar2 = null;
        i.b bVar = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        float f10 = 0.0f;
        i.b bVar2 = null;
        boolean z10 = false;
        i.d dVar = null;
        while (jsonReader.i()) {
            switch (jsonReader.y(f51766a)) {
                case 0:
                    str = jsonReader.r();
                    break;
                case 1:
                    int i10 = -1;
                    jsonReader.d();
                    while (jsonReader.i()) {
                        int y10 = jsonReader.y(f51767b);
                        if (y10 != 0) {
                            cVar = cVar2;
                            if (y10 != 1) {
                                jsonReader.z();
                                jsonReader.A();
                            } else {
                                cVar2 = d.g(jsonReader, lottieComposition, i10);
                            }
                        } else {
                            cVar = cVar2;
                            i10 = jsonReader.l();
                        }
                        cVar2 = cVar;
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
                    bVar = d.e(jsonReader, lottieComposition);
                    break;
                case 7:
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.l() - 1];
                    break;
                case 8:
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.l() - 1];
                    break;
                case 9:
                    f10 = (float) jsonReader.k();
                    break;
                case 10:
                    z10 = jsonReader.j();
                    break;
                case 11:
                    jsonReader.b();
                    while (jsonReader.i()) {
                        jsonReader.d();
                        String str2 = null;
                        i.b bVar3 = null;
                        while (jsonReader.i()) {
                            int y11 = jsonReader.y(f51768c);
                            if (y11 != 0) {
                                i.b bVar4 = bVar2;
                                if (y11 != 1) {
                                    jsonReader.z();
                                    jsonReader.A();
                                } else {
                                    bVar3 = d.e(jsonReader, lottieComposition);
                                }
                                bVar2 = bVar4;
                            } else {
                                str2 = jsonReader.r();
                            }
                        }
                        i.b bVar5 = bVar2;
                        jsonReader.f();
                        if (str2.equals("o")) {
                            bVar2 = bVar3;
                        } else {
                            if (str2.equals("d") || str2.equals("g")) {
                                lottieComposition.u(true);
                                arrayList.add(bVar3);
                            }
                            bVar2 = bVar5;
                        }
                    }
                    i.b bVar6 = bVar2;
                    jsonReader.e();
                    if (arrayList.size() == 1) {
                        arrayList.add((i.b) arrayList.get(0));
                    }
                    bVar2 = bVar6;
                    break;
                default:
                    jsonReader.z();
                    jsonReader.A();
                    break;
            }
        }
        if (dVar == null) {
            dVar = new i.d(Collections.singletonList(new o.a(100)));
        }
        return new com.airbnb.lottie.model.content.a(str, gradientType, cVar2, dVar, fVar, fVar2, bVar, lineCapType, lineJoinType, f10, arrayList, bVar2, z10);
    }
}
