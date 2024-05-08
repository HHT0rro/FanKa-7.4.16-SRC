package m;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: KeyframesParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    public static JsonReader.a f51776a = JsonReader.a.a("k");

    public static <T> List<o.a<T>> a(JsonReader jsonReader, LottieComposition lottieComposition, float f10, n0<T> n0Var, boolean z10) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.w() == JsonReader.Token.STRING) {
            lottieComposition.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.d();
        while (jsonReader.i()) {
            if (jsonReader.y(f51776a) != 0) {
                jsonReader.A();
            } else if (jsonReader.w() == JsonReader.Token.BEGIN_ARRAY) {
                jsonReader.b();
                if (jsonReader.w() == JsonReader.Token.NUMBER) {
                    arrayList.add(t.c(jsonReader, lottieComposition, f10, n0Var, false, z10));
                } else {
                    while (jsonReader.i()) {
                        arrayList.add(t.c(jsonReader, lottieComposition, f10, n0Var, true, z10));
                    }
                }
                jsonReader.e();
            } else {
                arrayList.add(t.c(jsonReader, lottieComposition, f10, n0Var, false, z10));
            }
        }
        jsonReader.f();
        b(arrayList);
        return arrayList;
    }

    public static <T> void b(List<? extends o.a<T>> list) {
        int i10;
        T t2;
        int size = list.size();
        int i11 = 0;
        while (true) {
            i10 = size - 1;
            if (i11 >= i10) {
                break;
            }
            o.a<T> aVar = list.get(i11);
            i11++;
            o.a<T> aVar2 = list.get(i11);
            aVar.f52217h = Float.valueOf(aVar2.f52216g);
            if (aVar.f52212c == null && (t2 = aVar2.f52211b) != null) {
                aVar.f52212c = t2;
                if (aVar instanceof f.i) {
                    ((f.i) aVar).j();
                }
            }
        }
        o.a<T> aVar3 = list.get(i10);
        if ((aVar3.f52211b == null || aVar3.f52212c == null) && list.size() > 1) {
            list.remove(aVar3);
        }
    }
}
