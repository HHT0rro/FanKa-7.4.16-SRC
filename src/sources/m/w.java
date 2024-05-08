package m;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.huawei.quickcard.framework.QuickCardField;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: LottieCompositionMoshiParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f51781a = JsonReader.a.a(IAdInterListener.AdReqParam.WIDTH, "h", "ip", "op", "fr", com.kuaishou.weapon.p0.t.f36218c, "layers", QuickCardField.ASSETS, "fonts", "chars", "markers");

    /* renamed from: b, reason: collision with root package name */
    public static JsonReader.a f51782b = JsonReader.a.a("id", "layers", IAdInterListener.AdReqParam.WIDTH, "h", com.kuaishou.weapon.p0.t.f36217b, com.kuaishou.weapon.p0.t.f36224i);

    /* renamed from: c, reason: collision with root package name */
    public static final JsonReader.a f51783c = JsonReader.a.a("list");

    /* renamed from: d, reason: collision with root package name */
    public static final JsonReader.a f51784d = JsonReader.a.a("cm", "tm", "dr");

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0043. Please report as an issue. */
    public static LottieComposition a(JsonReader jsonReader) throws IOException {
        HashMap hashMap;
        ArrayList arrayList;
        JsonReader jsonReader2 = jsonReader;
        float e2 = n.h.e();
        LongSparseArray<Layer> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        SparseArrayCompat<h.b> sparseArrayCompat = new SparseArrayCompat<>();
        LottieComposition lottieComposition = new LottieComposition();
        jsonReader.d();
        int i10 = 0;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        int i11 = 0;
        while (jsonReader.i()) {
            switch (jsonReader2.y(f51781a)) {
                case 0:
                    i10 = jsonReader.l();
                    break;
                case 1:
                    i11 = jsonReader.l();
                    break;
                case 2:
                    f10 = (float) jsonReader.k();
                    break;
                case 3:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f11 = ((float) jsonReader.k()) - 0.01f;
                    hashMap4 = hashMap;
                    arrayList3 = arrayList;
                    break;
                case 4:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f12 = (float) jsonReader.k();
                    hashMap4 = hashMap;
                    arrayList3 = arrayList;
                    break;
                case 5:
                    String[] split = jsonReader.r().split("\\.");
                    if (!n.h.j(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 4, 4, 0)) {
                        lottieComposition.a("Lottie only supports bodymovin >= 4.4.0");
                    }
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    hashMap4 = hashMap;
                    arrayList3 = arrayList;
                    break;
                case 6:
                    e(jsonReader2, lottieComposition, arrayList2, longSparseArray);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    hashMap4 = hashMap;
                    arrayList3 = arrayList;
                    break;
                case 7:
                    b(jsonReader2, lottieComposition, hashMap2, hashMap3);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    hashMap4 = hashMap;
                    arrayList3 = arrayList;
                    break;
                case 8:
                    d(jsonReader2, hashMap4);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    hashMap4 = hashMap;
                    arrayList3 = arrayList;
                    break;
                case 9:
                    c(jsonReader2, lottieComposition, sparseArrayCompat);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    hashMap4 = hashMap;
                    arrayList3 = arrayList;
                    break;
                case 10:
                    f(jsonReader2, arrayList3);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    hashMap4 = hashMap;
                    arrayList3 = arrayList;
                    break;
                default:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    jsonReader.z();
                    jsonReader.A();
                    hashMap4 = hashMap;
                    arrayList3 = arrayList;
                    break;
            }
            jsonReader2 = jsonReader;
        }
        lottieComposition.s(new Rect(0, 0, (int) (i10 * e2), (int) (i11 * e2)), f10, f11, f12, arrayList2, longSparseArray, hashMap2, hashMap3, sparseArrayCompat, hashMap4, arrayList3);
        return lottieComposition;
    }

    public static void b(JsonReader jsonReader, LottieComposition lottieComposition, Map<String, List<Layer>> map, Map<String, com.airbnb.lottie.e0> map2) throws IOException {
        jsonReader.b();
        while (jsonReader.i()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            jsonReader.d();
            String str = null;
            String str2 = null;
            String str3 = null;
            int i10 = 0;
            int i11 = 0;
            while (jsonReader.i()) {
                int y10 = jsonReader.y(f51782b);
                if (y10 == 0) {
                    str = jsonReader.r();
                } else if (y10 == 1) {
                    jsonReader.b();
                    while (jsonReader.i()) {
                        Layer b4 = v.b(jsonReader, lottieComposition);
                        longSparseArray.put(b4.d(), b4);
                        arrayList.add(b4);
                    }
                    jsonReader.e();
                } else if (y10 == 2) {
                    i10 = jsonReader.l();
                } else if (y10 == 3) {
                    i11 = jsonReader.l();
                } else if (y10 == 4) {
                    str2 = jsonReader.r();
                } else if (y10 != 5) {
                    jsonReader.z();
                    jsonReader.A();
                } else {
                    str3 = jsonReader.r();
                }
            }
            jsonReader.f();
            if (str2 != null) {
                com.airbnb.lottie.e0 e0Var = new com.airbnb.lottie.e0(i10, i11, str, str2, str3);
                map2.put(e0Var.d(), e0Var);
            } else {
                map.put(str, arrayList);
            }
        }
        jsonReader.e();
    }

    public static void c(JsonReader jsonReader, LottieComposition lottieComposition, SparseArrayCompat<h.b> sparseArrayCompat) throws IOException {
        jsonReader.b();
        while (jsonReader.i()) {
            h.b a10 = m.a(jsonReader, lottieComposition);
            sparseArrayCompat.put(a10.hashCode(), a10);
        }
        jsonReader.e();
    }

    public static void d(JsonReader jsonReader, Map<String, h.a> map) throws IOException {
        jsonReader.d();
        while (jsonReader.i()) {
            if (jsonReader.y(f51783c) != 0) {
                jsonReader.z();
                jsonReader.A();
            } else {
                jsonReader.b();
                while (jsonReader.i()) {
                    h.a a10 = n.a(jsonReader);
                    map.put(a10.b(), a10);
                }
                jsonReader.e();
            }
        }
        jsonReader.f();
    }

    public static void e(JsonReader jsonReader, LottieComposition lottieComposition, List<Layer> list, LongSparseArray<Layer> longSparseArray) throws IOException {
        jsonReader.b();
        int i10 = 0;
        while (jsonReader.i()) {
            Layer b4 = v.b(jsonReader, lottieComposition);
            if (b4.f() == Layer.LayerType.IMAGE) {
                i10++;
            }
            list.add(b4);
            longSparseArray.put(b4.d(), b4);
            if (i10 > 4) {
                n.d.c("You have " + i10 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.e();
    }

    public static void f(JsonReader jsonReader, List<h.f> list) throws IOException {
        jsonReader.b();
        while (jsonReader.i()) {
            String str = null;
            jsonReader.d();
            float f10 = 0.0f;
            float f11 = 0.0f;
            while (jsonReader.i()) {
                int y10 = jsonReader.y(f51784d);
                if (y10 == 0) {
                    str = jsonReader.r();
                } else if (y10 == 1) {
                    f10 = (float) jsonReader.k();
                } else if (y10 != 2) {
                    jsonReader.z();
                    jsonReader.A();
                } else {
                    f11 = (float) jsonReader.k();
                }
            }
            jsonReader.f();
            list.add(new h.f(str, f10, f11));
        }
        jsonReader.e();
    }
}
