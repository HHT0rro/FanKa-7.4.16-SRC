package com.huawei.quickcard.base.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Base64;
import android.util.LruCache;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.base.utils.SingleFunctionParser;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceContant;
import com.tencent.liteav.TXLiteAVCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ResourceUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33428a = "ResourceUtils";

    /* renamed from: b, reason: collision with root package name */
    private static final Map<String, Integer> f33429b;

    /* renamed from: c, reason: collision with root package name */
    private static final int f33430c = 3;

    /* renamed from: d, reason: collision with root package name */
    private static final int f33431d = 4;

    /* renamed from: e, reason: collision with root package name */
    private static final int f33432e = 3;

    /* renamed from: f, reason: collision with root package name */
    private static final int f33433f = 4;

    /* renamed from: g, reason: collision with root package name */
    private static final int f33434g = 16;

    /* renamed from: h, reason: collision with root package name */
    private static final int f33435h = 255;

    /* renamed from: i, reason: collision with root package name */
    private static final String f33436i = "rgba";

    /* renamed from: j, reason: collision with root package name */
    private static final String f33437j = "hsl";

    /* renamed from: k, reason: collision with root package name */
    private static final String f33438k = "hsla";

    /* renamed from: l, reason: collision with root package name */
    private static final LruCache<String, Integer> f33439l;

    /* renamed from: m, reason: collision with root package name */
    private static final SingleFunctionParser.NonUniformMapper<Number> f33440m;

    /* renamed from: n, reason: collision with root package name */
    private static final SingleFunctionParser.NonUniformMapper<Number> f33441n;

    /* renamed from: o, reason: collision with root package name */
    private static final SingleFunctionParser.FlatMapper<Integer> f33442o;

    /* renamed from: p, reason: collision with root package name */
    private static final SingleFunctionParser.NonUniformMapper<Number> f33443p;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static abstract class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f33444a;

        /* renamed from: b, reason: collision with root package name */
        public static final b f33445b;

        /* renamed from: c, reason: collision with root package name */
        public static final b f33446c;

        /* renamed from: d, reason: collision with root package name */
        public static final b f33447d;

        /* renamed from: e, reason: collision with root package name */
        public static final b f33448e;

        /* renamed from: f, reason: collision with root package name */
        public static final b f33449f;

        /* renamed from: g, reason: collision with root package name */
        private static final /* synthetic */ b[] f33450g;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public enum a extends b {
            public a(String str, int i10) {
                super(str, i10);
            }

            @Override // com.huawei.quickcard.base.utils.ResourceUtils.b
            @NonNull
            public Pair<Boolean, Integer> a(String str) {
                if (ResourceUtils.f33429b.containsKey(str)) {
                    return new Pair<>(Boolean.TRUE, (Integer) ResourceUtils.f33429b.get(str));
                }
                return new Pair<>(Boolean.FALSE, 0);
            }
        }

        /* renamed from: com.huawei.quickcard.base.utils.ResourceUtils$b$b, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public enum C0343b extends b {
            public C0343b(String str, int i10) {
                super(str, i10);
            }

            @Override // com.huawei.quickcard.base.utils.ResourceUtils.b
            @NonNull
            public Pair<Boolean, Integer> a(String str) {
                if (str.length() == 4 && str.startsWith("#")) {
                    int parseInt = Integer.parseInt(str.substring(1, 2), 16);
                    int parseInt2 = Integer.parseInt(str.substring(2, 3), 16);
                    int parseInt3 = Integer.parseInt(str.substring(3, 4), 16);
                    return new Pair<>(Boolean.TRUE, Integer.valueOf(Color.rgb(parseInt + (parseInt << 4), parseInt2 + (parseInt2 << 4), parseInt3 + (parseInt3 << 4))));
                }
                if ((str.length() == 7 || str.length() == 9) && str.startsWith("#")) {
                    return new Pair<>(Boolean.TRUE, Integer.valueOf(Color.parseColor(str)));
                }
                return new Pair<>(Boolean.FALSE, 0);
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public enum c extends b {
            public c(String str, int i10) {
                super(str, i10);
            }

            @Override // com.huawei.quickcard.base.utils.ResourceUtils.b
            @NonNull
            public Pair<Boolean, Integer> a(String str) {
                List parse = new SingleFunctionParser(str, ResourceUtils.f33442o).parse("rgb");
                if (parse != null && parse.size() == 3) {
                    return new Pair<>(Boolean.TRUE, Integer.valueOf(Color.rgb(((Integer) parse.get(0)).intValue(), ((Integer) parse.get(1)).intValue(), ((Integer) parse.get(2)).intValue())));
                }
                return new Pair<>(Boolean.FALSE, 0);
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public enum d extends b {
            public d(String str, int i10) {
                super(str, i10);
            }

            @Override // com.huawei.quickcard.base.utils.ResourceUtils.b
            @NonNull
            public Pair<Boolean, Integer> a(String str) {
                List parse = new SingleFunctionParser(str, ResourceUtils.f33440m).parse(ResourceUtils.f33436i);
                if (parse != null && parse.size() == 4) {
                    return new Pair<>(Boolean.TRUE, Integer.valueOf(Color.argb(b.b(((Number) parse.get(3)).floatValue()), ((Number) parse.get(0)).intValue(), ((Number) parse.get(1)).intValue(), ((Number) parse.get(2)).intValue())));
                }
                return new Pair<>(Boolean.FALSE, 0);
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public enum e extends b {
            public e(String str, int i10) {
                super(str, i10);
            }

            @Override // com.huawei.quickcard.base.utils.ResourceUtils.b
            @NonNull
            public Pair<Boolean, Integer> a(String str) {
                List parse = new SingleFunctionParser(str, ResourceUtils.f33441n).parse(ResourceUtils.f33437j);
                if (parse != null && parse.size() == 3) {
                    try {
                        return new Pair<>(Boolean.TRUE, Integer.valueOf(ResourceUtils.b(((Number) parse.get(0)).floatValue(), ((Number) parse.get(1)).floatValue(), ((Number) parse.get(2)).floatValue(), 1.0f)));
                    } catch (IllegalArgumentException e2) {
                        CardLogUtils.e("fail to convert hsl value to rgb color", e2);
                    }
                }
                return new Pair<>(Boolean.FALSE, 0);
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public enum f extends b {
            public f(String str, int i10) {
                super(str, i10);
            }

            @Override // com.huawei.quickcard.base.utils.ResourceUtils.b
            @NonNull
            public Pair<Boolean, Integer> a(String str) {
                List parse = new SingleFunctionParser(str, ResourceUtils.f33443p).parse(ResourceUtils.f33438k);
                if (parse != null && parse.size() == 4) {
                    try {
                        return new Pair<>(Boolean.TRUE, Integer.valueOf(ResourceUtils.b(((Number) parse.get(0)).floatValue(), ((Number) parse.get(1)).floatValue(), ((Number) parse.get(2)).floatValue(), ((Number) parse.get(3)).floatValue())));
                    } catch (IllegalArgumentException e2) {
                        CardLogUtils.e("fail to convert hsla value to rgb color", e2);
                    }
                }
                return new Pair<>(Boolean.FALSE, 0);
            }
        }

        static {
            a aVar = new a("NAMED_COLOR_HANDLER", 0);
            f33444a = aVar;
            C0343b c0343b = new C0343b("RGB_HANDLER", 1);
            f33445b = c0343b;
            c cVar = new c("FUNCTIONAL_RGB_HANDLER", 2);
            f33446c = cVar;
            d dVar = new d("FUNCTIONAL_RGBA_HANDLER", 3);
            f33447d = dVar;
            e eVar = new e("FUNCTIONAL_HSL_HANDLER", 4);
            f33448e = eVar;
            f fVar = new f("FUNCTIONAL_HSLA_HANDLER", 5);
            f33449f = fVar;
            f33450g = new b[]{aVar, c0343b, cVar, dVar, eVar, fVar};
        }

        private b(String str, int i10) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int b(float f10) {
            return (int) (f10 * 255.0f);
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f33450g.clone();
        }

        @NonNull
        public abstract Pair<Boolean, Integer> a(String str);
    }

    static {
        HashMap hashMap = new HashMap();
        f33429b = hashMap;
        f33439l = new LruCache<>(1024);
        f33440m = new SingleFunctionParser.NonUniformMapper() { // from class: com.huawei.quickcard.base.utils.d
            @Override // com.huawei.quickcard.base.utils.SingleFunctionParser.NonUniformMapper
            public final List map(List list) {
                List a10;
                a10 = ResourceUtils.a(list);
                return a10;
            }
        };
        f33441n = new SingleFunctionParser.NonUniformMapper() { // from class: com.huawei.quickcard.base.utils.c
            @Override // com.huawei.quickcard.base.utils.SingleFunctionParser.NonUniformMapper
            public final List map(List list) {
                List b4;
                b4 = ResourceUtils.b(list);
                return b4;
            }
        };
        f33442o = new SingleFunctionParser.FlatMapper() { // from class: com.huawei.quickcard.base.utils.a
            @Override // com.huawei.quickcard.base.utils.SingleFunctionParser.FlatMapper
            public final Object map(String str) {
                Integer a10;
                a10 = ResourceUtils.a(str);
                return a10;
            }
        };
        f33443p = new SingleFunctionParser.NonUniformMapper() { // from class: com.huawei.quickcard.base.utils.b
            @Override // com.huawei.quickcard.base.utils.SingleFunctionParser.NonUniformMapper
            public final List map(List list) {
                List c4;
                c4 = ResourceUtils.c(list);
                return c4;
            }
        };
        hashMap.put("aliceblue", -984833);
        hashMap.put("antiquewhite", -332841);
        hashMap.put("aqua", -16711681);
        hashMap.put("aquamarine", -8388652);
        hashMap.put("azure", -983041);
        hashMap.put("beige", -657956);
        hashMap.put("bisque", -6972);
        hashMap.put(WbCloudFaceContant.BLACK, -16777216);
        hashMap.put("blanchedalmond", -5171);
        hashMap.put("blue", -16776961);
        hashMap.put("blueviolet", -7722014);
        hashMap.put("brown", -5952982);
        hashMap.put("burlywood", -2180985);
        hashMap.put("cadetblue", -10510688);
        hashMap.put("chartreuse", -8388864);
        hashMap.put("chocolate", -2987746);
        hashMap.put("coral", -32944);
        hashMap.put("cornflowerblue", -10185235);
        hashMap.put("cornsilk", -1828);
        hashMap.put("crimson", -2354116);
        hashMap.put("cyan", -16711681);
        hashMap.put("darkblue", -16777077);
        hashMap.put("darkcyan", -16741493);
        hashMap.put("darkgoldenrod", -4684277);
        hashMap.put("darkgray", -5658199);
        hashMap.put("darkgreen", -16751616);
        hashMap.put("darkkhaki", -4343957);
        hashMap.put("darkmagenta", -7667573);
        hashMap.put("darkolivegreen", -11179217);
        hashMap.put("darkorange", -29696);
        hashMap.put("darkorchid", -6737204);
        hashMap.put("darkred", -7667712);
        hashMap.put("darksalmon", -1468806);
        hashMap.put("darkseagreen", -7357297);
        hashMap.put("darkslateblue", -12042869);
        hashMap.put("darkslategray", -13676721);
        hashMap.put("darkslategrey", -13676721);
        hashMap.put("darkturquoise", -16724271);
        hashMap.put("darkviolet", -7077677);
        hashMap.put("deeppink", -60269);
        hashMap.put("deepskyblue", -16728065);
        hashMap.put("dimgray", -9868951);
        hashMap.put("dimgrey", -9868951);
        hashMap.put("dodgerblue", -14774017);
        hashMap.put("firebrick", -5103070);
        hashMap.put("floralwhite", -1296);
        hashMap.put("forestgreen", -14513374);
        hashMap.put("fuchsia", -65281);
        hashMap.put("gainsboro", -2302756);
        hashMap.put("ghostwhite", -460545);
        hashMap.put("gold", -10496);
        hashMap.put("goldenrod", -2448096);
        hashMap.put("gray", -8355712);
        hashMap.put("grey", -8355712);
        hashMap.put("green", -16744448);
        hashMap.put("greenyellow", -5374161);
        hashMap.put("honeydew", -983056);
        hashMap.put("hotpink", -38476);
        hashMap.put("indianred", -3318692);
        hashMap.put("indigo", -11861886);
        hashMap.put("ivory", -16);
        hashMap.put("khaki", -989556);
        hashMap.put("lavender", -1644806);
        hashMap.put("lavenderblush", -3851);
        hashMap.put("lawngreen", -8586240);
        hashMap.put("lemonchiffon", Integer.valueOf(TXLiteAVCode.ERR_AUDIO_PLUGIN_INSTALL_NOT_AUTHORIZED));
        hashMap.put("lightblue", -5383962);
        hashMap.put("lightcoral", -1015680);
        hashMap.put("lightcyan", -2031617);
        hashMap.put("lightgoldenrodyellow", -329006);
        hashMap.put("lightgray", -2894893);
        hashMap.put("lightgrey", -2894893);
        hashMap.put("lightgreen", -7278960);
        hashMap.put("lightpink", -18751);
        hashMap.put("lightsalmon", -24454);
        hashMap.put("lightseagreen", -14634326);
        hashMap.put("lightskyblue", -7876870);
        hashMap.put("lightslategray", -8943463);
        hashMap.put("lightslategrey", -8943463);
        hashMap.put("lightsteelblue", -5192482);
        hashMap.put("lightyellow", -32);
        hashMap.put("lime", -16711936);
        hashMap.put("limegreen", -13447886);
        hashMap.put("linen", -331546);
        hashMap.put("magenta", -65281);
        hashMap.put("maroon", -8388608);
        hashMap.put("mediumaquamarine", -10039894);
        hashMap.put("mediumblue", -16777011);
        hashMap.put("mediumorchid", -4565549);
        hashMap.put("mediumpurple", -7114533);
        hashMap.put("mediumseagreen", -12799119);
        hashMap.put("mediumslateblue", -8689426);
        hashMap.put("mediumspringgreen", -16713062);
        hashMap.put("mediumturquoise", -12004916);
        hashMap.put("mediumvioletred", -3730043);
        hashMap.put("midnightblue", -15132304);
        hashMap.put("mintcream", -655366);
        hashMap.put("mistyrose", -6943);
        hashMap.put("moccasin", -6987);
        hashMap.put("navajowhite", -8531);
        hashMap.put("navy", -16777088);
        hashMap.put("oldlace", -133658);
        hashMap.put("olive", -8355840);
        hashMap.put("olivedrab", -9728477);
        hashMap.put("orange", -23296);
        hashMap.put("orangered", -47872);
        hashMap.put("orchid", -2461482);
        hashMap.put("palegoldenrod", -1120086);
        hashMap.put("palegreen", -6751336);
        hashMap.put("paleturquoise", -5247250);
        hashMap.put("palevioletred", -2396013);
        hashMap.put("papayawhip", -4139);
        hashMap.put("peachpuff", -9543);
        hashMap.put("peru", -3308225);
        hashMap.put("pink", -16181);
        hashMap.put("plum", -2252579);
        hashMap.put("powderblue", -5185306);
        hashMap.put("purple", -8388480);
        hashMap.put("rebeccapurple", -10079335);
        hashMap.put("red", -65536);
        hashMap.put("rosybrown", -4419697);
        hashMap.put("royalblue", -12490271);
        hashMap.put("saddlebrown", -7650029);
        hashMap.put("salmon", -360334);
        hashMap.put("sandybrown", -744352);
        hashMap.put("seagreen", -13726889);
        hashMap.put("seashell", -2578);
        hashMap.put("sienna", -6270419);
        hashMap.put("silver", -4144960);
        hashMap.put("skyblue", -7876885);
        hashMap.put("slateblue", -9807155);
        hashMap.put("slategray", -9404272);
        hashMap.put("slategrey", -9404272);
        hashMap.put("snow", -1286);
        hashMap.put("springgreen", -16711809);
        hashMap.put("steelblue", -12156236);
        hashMap.put("tan", -2968436);
        hashMap.put("teal", -16744320);
        hashMap.put("thistle", -2572328);
        hashMap.put("tomato", -40121);
        hashMap.put("turquoise", -12525360);
        hashMap.put("violet", -1146130);
        hashMap.put("wheat", -663885);
        hashMap.put(WbCloudFaceContant.WHITE, -1);
        hashMap.put("whitesmoke", -657931);
        hashMap.put("yellow", -256);
        hashMap.put("yellowgreen", -6632142);
        hashMap.put("transparent", 0);
    }

    private static float a(float f10, float f11, float f12) {
        float f13;
        if (f12 < 0.0f) {
            f12 += 1.0f;
        }
        if (f12 > 1.0f) {
            f12 -= 1.0f;
        }
        if (f12 * 6.0f < 1.0f) {
            f13 = (f11 - f10) * 6.0f * f12;
        } else {
            if (f12 * 2.0f < 1.0f) {
                return f11;
            }
            if (3.0f * f12 >= 2.0f) {
                return f10;
            }
            f13 = (f11 - f10) * 6.0f * (0.6666667f - f12);
        }
        return f10 + f13;
    }

    public static Bitmap base64ToBitmap(String str) {
        try {
            String[] split = str.split(",");
            if (split.length < 2) {
                return null;
            }
            byte[] decode = Base64.decode(split[1], 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Throwable th) {
            CardLogUtils.e("Base642Bitmap", "base64 to bitmap failed:" + th.getMessage());
            return null;
        }
    }

    public static int getColor(String str) {
        return getColor(str, Integer.MIN_VALUE);
    }

    public static Integer getColorInteger(String str) {
        Pair<Boolean, Integer> a10;
        Integer num = null;
        if (!TextUtils.isEmpty(str) && !"#undefined".equals(str)) {
            Integer num2 = f33439l.get(str);
            if (num2 != null) {
                return num2;
            }
            String trim = str.trim();
            b[] values = b.values();
            int length = values.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                try {
                    a10 = values[i10].a(trim);
                } catch (RuntimeException unused) {
                    CardLogUtils.w("Color_Parser error");
                }
                if (a10.first.booleanValue()) {
                    num = a10.second;
                    break;
                }
                continue;
                i10++;
            }
            f33439l.put(trim, num);
        }
        return num;
    }

    public static float parseAlphaPercent(int i10) {
        return Color.alpha(i10) / 255.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List b(List list) {
        if (list.size() != 3) {
            CardLogUtils.e(f33428a, "size is illegal, fail to parse hsl value");
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(Float.valueOf((String) list.get(0)));
            for (int i10 = 1; i10 < 3; i10++) {
                arrayList.add(Float.valueOf(Attributes.getPercent((String) list.get(i10))));
            }
            return arrayList;
        } catch (NumberFormatException e2) {
            CardLogUtils.e(f33428a, "fail to parse hsl value", e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List c(List list) {
        if (list.size() != 4) {
            CardLogUtils.e(f33428a, "size is illegal, fail to parse hsla value");
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(Float.valueOf((String) list.get(0)));
            for (int i10 = 1; i10 < 3; i10++) {
                arrayList.add(Float.valueOf(Attributes.getPercent((String) list.get(i10))));
            }
            arrayList.add(Float.valueOf((String) list.get(3)));
            return arrayList;
        } catch (NumberFormatException e2) {
            CardLogUtils.e("FUNCTIONAL_HSLA_MAPPER: fail to parse hsla value", e2);
            return null;
        }
    }

    public static int getColor(String str, int i10) {
        Pair<Boolean, Integer> a10;
        if (!TextUtils.isEmpty(str) && !"#undefined".equals(str)) {
            Integer num = f33439l.get(str);
            if (num != null) {
                return num.intValue();
            }
            String trim = str.trim();
            for (b bVar : b.values()) {
                try {
                    a10 = bVar.a(trim);
                } catch (RuntimeException e2) {
                    CardLogUtils.w("Color_Parser", "getColor error", e2);
                }
                if (a10.first.booleanValue()) {
                    i10 = a10.second.intValue();
                    break;
                }
                continue;
            }
            f33439l.put(trim, Integer.valueOf(i10));
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List a(List list) {
        ArrayList arrayList = new ArrayList(4);
        int i10 = 0;
        while (i10 < 3) {
            int i11 = 255;
            int parseUnitOrPercent = Attributes.parseUnitOrPercent((String) list.get(i10), 255);
            if (parseUnitOrPercent < 0) {
                parseUnitOrPercent = 0;
            }
            if (parseUnitOrPercent <= 255) {
                i11 = parseUnitOrPercent;
            }
            arrayList.add(Integer.valueOf(i11));
            i10++;
        }
        arrayList.add(Float.valueOf((String) list.get(i10)));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer a(String str) {
        int parseUnitOrPercent = Attributes.parseUnitOrPercent(str, 255);
        if (parseUnitOrPercent < 0) {
            parseUnitOrPercent = 0;
        }
        return Integer.valueOf(parseUnitOrPercent <= 255 ? parseUnitOrPercent : 255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(float f10, float f11, float f12, float f13) throws IllegalArgumentException {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException("color H is illegal");
        }
        if (f11 < 0.0f || f11 > 1.0f) {
            throw new IllegalArgumentException("color S is illegal");
        }
        if (f12 < 0.0f || f12 > 1.0f) {
            throw new IllegalArgumentException("color L is illegal");
        }
        if (f13 >= 0.0f && f13 <= 1.0f) {
            float f14 = (f10 % 360.0f) / 360.0f;
            float f15 = ((double) f12) < 0.5d ? (f11 + 1.0f) * f12 : (f12 + f11) - (f11 * f12);
            float f16 = (f12 * 2.0f) - f15;
            return Color.argb((int) ((f13 * 255.0f) + 0.5f), (int) ((Math.min(Math.max(0.0f, a(f16, f15, f14 + 0.33333334f)), 1.0f) * 255.0f) + 0.5f), (int) ((Math.min(Math.max(0.0f, a(f16, f15, f14)), 1.0f) * 255.0f) + 0.5f), (int) ((Math.min(Math.max(0.0f, a(f16, f15, f14 - 0.33333334f)), 1.0f) * 255.0f) + 0.5f));
        }
        throw new IllegalArgumentException("alpha param is illegal");
    }
}
