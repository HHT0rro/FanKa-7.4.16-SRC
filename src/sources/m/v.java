package m;

import android.graphics.Color;
import android.graphics.Rect;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.ss.android.socialbase.downloader.segment.Segment;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: LayerParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f51777a = JsonReader.a.a("nm", "ind", "refId", com.alipay.sdk.sys.a.f4666g, "parent", "sw", "sh", "sc", MediationConstant.ADN_KS, "tt", "masksProperties", "shapes", "t", "ef", "sr", Segment.JsonKey.START, IAdInterListener.AdReqParam.WIDTH, "h", "ip", "op", "tm", "cl", "hd");

    /* renamed from: b, reason: collision with root package name */
    public static final JsonReader.a f51778b = JsonReader.a.a("d", "a");

    /* renamed from: c, reason: collision with root package name */
    public static final JsonReader.a f51779c = JsonReader.a.a(com.alipay.sdk.sys.a.f4666g, "nm");

    /* compiled from: LayerParser.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f51780a;

        static {
            int[] iArr = new int[Layer.MatteType.values().length];
            f51780a = iArr;
            try {
                iArr[Layer.MatteType.LUMA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f51780a[Layer.MatteType.LUMA_INVERTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static Layer a(LottieComposition lottieComposition) {
        Rect b4 = lottieComposition.b();
        return new Layer(Collections.emptyList(), lottieComposition, "__container", -1L, Layer.LayerType.PRE_COMP, -1L, null, Collections.emptyList(), new i.l(), 0, 0, 0, 0.0f, 0.0f, b4.width(), b4.height(), null, null, Collections.emptyList(), Layer.MatteType.NONE, null, false, null, null);
    }

    public static Layer b(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList;
        ArrayList arrayList2;
        Layer.MatteType matteType = Layer.MatteType.NONE;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        jsonReader.d();
        Float valueOf = Float.valueOf(1.0f);
        Float valueOf2 = Float.valueOf(0.0f);
        Layer.MatteType matteType2 = matteType;
        Layer.LayerType layerType = null;
        String str = null;
        i.l lVar = null;
        i.j jVar = null;
        i.k kVar = null;
        i.b bVar = null;
        j.a aVar = null;
        j jVar2 = null;
        long j10 = -1;
        float f10 = 0.0f;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        float f11 = 1.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        boolean z10 = false;
        float f15 = 0.0f;
        long j11 = 0;
        String str2 = null;
        String str3 = "UNSET";
        while (jsonReader.i()) {
            switch (jsonReader.y(f51777a)) {
                case 0:
                    str3 = jsonReader.r();
                    break;
                case 1:
                    j11 = jsonReader.l();
                    break;
                case 2:
                    str = jsonReader.r();
                    break;
                case 3:
                    int l10 = jsonReader.l();
                    layerType = Layer.LayerType.UNKNOWN;
                    if (l10 >= layerType.ordinal()) {
                        break;
                    } else {
                        layerType = Layer.LayerType.values()[l10];
                        break;
                    }
                case 4:
                    j10 = jsonReader.l();
                    break;
                case 5:
                    i10 = (int) (jsonReader.l() * n.h.e());
                    break;
                case 6:
                    i11 = (int) (jsonReader.l() * n.h.e());
                    break;
                case 7:
                    i12 = Color.parseColor(jsonReader.r());
                    break;
                case 8:
                    lVar = c.g(jsonReader, lottieComposition);
                    break;
                case 9:
                    int l11 = jsonReader.l();
                    if (l11 >= Layer.MatteType.values().length) {
                        lottieComposition.a("Unsupported matte type: " + l11);
                        break;
                    } else {
                        matteType2 = Layer.MatteType.values()[l11];
                        int i13 = a.f51780a[matteType2.ordinal()];
                        if (i13 == 1) {
                            lottieComposition.a("Unsupported matte type: Luma");
                        } else if (i13 == 2) {
                            lottieComposition.a("Unsupported matte type: Luma Inverted");
                        }
                        lottieComposition.r(1);
                        break;
                    }
                case 10:
                    jsonReader.b();
                    while (jsonReader.i()) {
                        arrayList3.add(x.a(jsonReader, lottieComposition));
                    }
                    lottieComposition.r(arrayList3.size());
                    jsonReader.e();
                    break;
                case 11:
                    jsonReader.b();
                    while (jsonReader.i()) {
                        ContentModel a10 = h.a(jsonReader, lottieComposition);
                        if (a10 != null) {
                            arrayList4.add(a10);
                        }
                    }
                    jsonReader.e();
                    break;
                case 12:
                    jsonReader.d();
                    while (jsonReader.i()) {
                        int y10 = jsonReader.y(f51778b);
                        if (y10 == 0) {
                            jVar = d.d(jsonReader, lottieComposition);
                        } else if (y10 != 1) {
                            jsonReader.z();
                            jsonReader.A();
                        } else {
                            jsonReader.b();
                            if (jsonReader.i()) {
                                kVar = b.a(jsonReader, lottieComposition);
                            }
                            while (jsonReader.i()) {
                                jsonReader.A();
                            }
                            jsonReader.e();
                        }
                    }
                    jsonReader.f();
                    break;
                case 13:
                    jsonReader.b();
                    ArrayList arrayList5 = new ArrayList();
                    while (jsonReader.i()) {
                        jsonReader.d();
                        while (jsonReader.i()) {
                            int y11 = jsonReader.y(f51779c);
                            if (y11 == 0) {
                                int l12 = jsonReader.l();
                                if (l12 == 29) {
                                    aVar = e.b(jsonReader, lottieComposition);
                                } else if (l12 == 25) {
                                    jVar2 = new k().b(jsonReader, lottieComposition);
                                }
                            } else if (y11 != 1) {
                                jsonReader.z();
                                jsonReader.A();
                            } else {
                                arrayList5.add(jsonReader.r());
                            }
                        }
                        jsonReader.f();
                    }
                    jsonReader.e();
                    lottieComposition.a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + ((Object) arrayList5));
                    break;
                case 14:
                    f11 = (float) jsonReader.k();
                    break;
                case 15:
                    f12 = (float) jsonReader.k();
                    break;
                case 16:
                    f13 = (float) (jsonReader.k() * n.h.e());
                    break;
                case 17:
                    f14 = (float) (jsonReader.k() * n.h.e());
                    break;
                case 18:
                    f10 = (float) jsonReader.k();
                    break;
                case 19:
                    f15 = (float) jsonReader.k();
                    break;
                case 20:
                    bVar = d.f(jsonReader, lottieComposition, false);
                    break;
                case 21:
                    str2 = jsonReader.r();
                    break;
                case 22:
                    z10 = jsonReader.j();
                    break;
                default:
                    jsonReader.z();
                    jsonReader.A();
                    break;
            }
        }
        jsonReader.f();
        ArrayList arrayList6 = new ArrayList();
        if (f10 > 0.0f) {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
            arrayList2.add(new o.a(lottieComposition, valueOf2, valueOf2, null, 0.0f, Float.valueOf(f10)));
        } else {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
        }
        if (f15 <= 0.0f) {
            f15 = lottieComposition.f();
        }
        arrayList2.add(new o.a(lottieComposition, valueOf, valueOf, null, f10, Float.valueOf(f15)));
        arrayList2.add(new o.a(lottieComposition, valueOf2, valueOf2, null, f15, Float.valueOf(Float.MAX_VALUE)));
        if (str3.endsWith(".ai") || "ai".equals(str2)) {
            lottieComposition.a("Convert your Illustrator layers to shape layers.");
        }
        return new Layer(arrayList4, lottieComposition, str3, j11, layerType, j10, str, arrayList, lVar, i10, i11, i12, f11, f12, f13, f14, jVar, kVar, arrayList2, matteType2, bVar, z10, aVar, jVar2);
    }
}
