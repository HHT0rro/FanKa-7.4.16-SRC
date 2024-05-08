package k6;

import android.text.Layout;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.k0;
import com.google.android.exoplayer2.util.m;
import com.huawei.flexiblelayout.css.adapter.value.integrate.align.CSSAlignValue;
import com.huawei.hms.mlsdk.common.AgConnectInfo;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.views.list.QRecyclerView;
import com.kuaishou.weapon.p0.t;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: TtmlDecoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c extends e6.c {

    /* renamed from: p, reason: collision with root package name */
    public static final Pattern f50671p = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");

    /* renamed from: q, reason: collision with root package name */
    public static final Pattern f50672q = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");

    /* renamed from: r, reason: collision with root package name */
    public static final Pattern f50673r = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");

    /* renamed from: s, reason: collision with root package name */
    public static final Pattern f50674s = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");

    /* renamed from: t, reason: collision with root package name */
    public static final Pattern f50675t = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");

    /* renamed from: u, reason: collision with root package name */
    public static final Pattern f50676u = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");

    /* renamed from: v, reason: collision with root package name */
    public static final Pattern f50677v = Pattern.compile("^(\\d+) (\\d+)$");

    /* renamed from: w, reason: collision with root package name */
    public static final b f50678w = new b(30.0f, 1, 1);

    /* renamed from: x, reason: collision with root package name */
    public static final a f50679x = new a(32, 15);

    /* renamed from: o, reason: collision with root package name */
    public final XmlPullParserFactory f50680o;

    /* compiled from: TtmlDecoder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f50681a;

        /* renamed from: b, reason: collision with root package name */
        public final int f50682b;

        public a(int i10, int i11) {
            this.f50681a = i10;
            this.f50682b = i11;
        }
    }

    /* compiled from: TtmlDecoder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final float f50683a;

        /* renamed from: b, reason: collision with root package name */
        public final int f50684b;

        /* renamed from: c, reason: collision with root package name */
        public final int f50685c;

        public b(float f10, int i10, int i11) {
            this.f50683a = f10;
            this.f50684b = i10;
            this.f50685c = i11;
        }
    }

    /* compiled from: TtmlDecoder.java */
    /* renamed from: k6.c$c, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class C0770c {

        /* renamed from: a, reason: collision with root package name */
        public final int f50686a;

        /* renamed from: b, reason: collision with root package name */
        public final int f50687b;

        public C0770c(int i10, int i11) {
            this.f50686a = i10;
            this.f50687b = i11;
        }
    }

    public c() {
        super("TtmlDecoder");
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            this.f50680o = newInstance;
            newInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }

    public static g B(@Nullable g gVar) {
        return gVar == null ? new g() : gVar;
    }

    public static boolean C(String str) {
        return str.equals("tt") || str.equals("head") || str.equals("body") || str.equals(Attributes.Component.DIV) || str.equals(t.f36217b) || str.equals("span") || str.equals("br") || str.equals("style") || str.equals("styling") || str.equals("layout") || str.equals(AgConnectInfo.AgConnectKey.REGION) || str.equals("metadata") || str.equals(Attributes.Component.IMAGE) || str.equals("data") || str.equals("information");
    }

    @Nullable
    public static Layout.Alignment D(String str) {
        String e2 = com.google.common.base.a.e(str);
        e2.hashCode();
        char c4 = 65535;
        switch (e2.hashCode()) {
            case -1364013995:
                if (e2.equals(CSSAlignValue.AlignKey.CENTER)) {
                    c4 = 0;
                    break;
                }
                break;
            case 100571:
                if (e2.equals("end")) {
                    c4 = 1;
                    break;
                }
                break;
            case 3317767:
                if (e2.equals("left")) {
                    c4 = 2;
                    break;
                }
                break;
            case 108511772:
                if (e2.equals("right")) {
                    c4 = 3;
                    break;
                }
                break;
            case 109757538:
                if (e2.equals("start")) {
                    c4 = 4;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return Layout.Alignment.ALIGN_CENTER;
            case 1:
            case 3:
                return Layout.Alignment.ALIGN_OPPOSITE;
            case 2:
            case 4:
                return Layout.Alignment.ALIGN_NORMAL;
            default:
                return null;
        }
    }

    public static a E(XmlPullParser xmlPullParser, a aVar) throws SubtitleDecoderException {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (attributeValue == null) {
            return aVar;
        }
        Matcher matcher = f50677v.matcher(attributeValue);
        if (!matcher.matches()) {
            m.h("TtmlDecoder", attributeValue.length() != 0 ? "Ignoring malformed cell resolution: ".concat(attributeValue) : new String("Ignoring malformed cell resolution: "));
            return aVar;
        }
        try {
            int parseInt = Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher.group(1)));
            int parseInt2 = Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher.group(2)));
            if (parseInt != 0 && parseInt2 != 0) {
                return new a(parseInt, parseInt2);
            }
            StringBuilder sb2 = new StringBuilder(47);
            sb2.append("Invalid cell resolution ");
            sb2.append(parseInt);
            sb2.append(" ");
            sb2.append(parseInt2);
            throw new SubtitleDecoderException(sb2.toString());
        } catch (NumberFormatException unused) {
            m.h("TtmlDecoder", attributeValue.length() != 0 ? "Ignoring malformed cell resolution: ".concat(attributeValue) : new String("Ignoring malformed cell resolution: "));
            return aVar;
        }
    }

    public static void F(String str, g gVar) throws SubtitleDecoderException {
        Matcher matcher;
        String[] M0 = j0.M0(str, "\\s+");
        if (M0.length == 1) {
            matcher = f50673r.matcher(str);
        } else if (M0.length == 2) {
            matcher = f50673r.matcher(M0[1]);
            m.h("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        } else {
            int length = M0.length;
            StringBuilder sb2 = new StringBuilder(52);
            sb2.append("Invalid number of entries for fontSize: ");
            sb2.append(length);
            sb2.append(".");
            throw new SubtitleDecoderException(sb2.toString());
        }
        if (matcher.matches()) {
            String str2 = (String) com.google.android.exoplayer2.util.a.e(matcher.group(3));
            str2.hashCode();
            char c4 = 65535;
            switch (str2.hashCode()) {
                case 37:
                    if (str2.equals("%")) {
                        c4 = 0;
                        break;
                    }
                    break;
                case 3240:
                    if (str2.equals("em")) {
                        c4 = 1;
                        break;
                    }
                    break;
                case 3592:
                    if (str2.equals("px")) {
                        c4 = 2;
                        break;
                    }
                    break;
            }
            switch (c4) {
                case 0:
                    gVar.z(3);
                    break;
                case 1:
                    gVar.z(2);
                    break;
                case 2:
                    gVar.z(1);
                    break;
                default:
                    StringBuilder sb3 = new StringBuilder(str2.length() + 30);
                    sb3.append("Invalid unit for fontSize: '");
                    sb3.append(str2);
                    sb3.append("'.");
                    throw new SubtitleDecoderException(sb3.toString());
            }
            gVar.y(Float.parseFloat((String) com.google.android.exoplayer2.util.a.e(matcher.group(1))));
            return;
        }
        StringBuilder sb4 = new StringBuilder(String.valueOf(str).length() + 36);
        sb4.append("Invalid expression for fontSize: '");
        sb4.append(str);
        sb4.append("'.");
        throw new SubtitleDecoderException(sb4.toString());
    }

    public static b G(XmlPullParser xmlPullParser) throws SubtitleDecoderException {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int parseInt = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        float f10 = 1.0f;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            if (j0.M0(attributeValue2, " ").length == 2) {
                f10 = Integer.parseInt(r2[0]) / Integer.parseInt(r2[1]);
            } else {
                throw new SubtitleDecoderException("frameRateMultiplier doesn't have 2 parts");
            }
        }
        b bVar = f50678w;
        int i10 = bVar.f50684b;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i10 = Integer.parseInt(attributeValue3);
        }
        int i11 = bVar.f50685c;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i11 = Integer.parseInt(attributeValue4);
        }
        return new b(parseInt * f10, i10, i11);
    }

    public static Map<String, g> H(XmlPullParser xmlPullParser, Map<String, g> map, a aVar, @Nullable C0770c c0770c, Map<String, e> map2, Map<String, String> map3) throws IOException, XmlPullParserException {
        do {
            xmlPullParser.next();
            if (k0.f(xmlPullParser, "style")) {
                String a10 = k0.a(xmlPullParser, "style");
                g M = M(xmlPullParser, new g());
                if (a10 != null) {
                    for (String str : N(a10)) {
                        M.a(map.get(str));
                    }
                }
                String g3 = M.g();
                if (g3 != null) {
                    map.put(g3, M);
                }
            } else if (k0.f(xmlPullParser, AgConnectInfo.AgConnectKey.REGION)) {
                e K = K(xmlPullParser, aVar, c0770c);
                if (K != null) {
                    map2.put(K.f50701a, K);
                }
            } else if (k0.f(xmlPullParser, "metadata")) {
                I(xmlPullParser, map3);
            }
        } while (!k0.d(xmlPullParser, "head"));
        return map;
    }

    public static void I(XmlPullParser xmlPullParser, Map<String, String> map) throws IOException, XmlPullParserException {
        String a10;
        do {
            xmlPullParser.next();
            if (k0.f(xmlPullParser, Attributes.Component.IMAGE) && (a10 = k0.a(xmlPullParser, "id")) != null) {
                map.put(a10, xmlPullParser.nextText());
            }
        } while (!k0.d(xmlPullParser, "metadata"));
    }

    public static d J(XmlPullParser xmlPullParser, @Nullable d dVar, Map<String, e> map, b bVar) throws SubtitleDecoderException {
        long j10;
        long j11;
        char c4;
        int attributeCount = xmlPullParser.getAttributeCount();
        g M = M(xmlPullParser, null);
        String str = null;
        String str2 = "";
        long j12 = -9223372036854775807L;
        long j13 = -9223372036854775807L;
        long j14 = -9223372036854775807L;
        String[] strArr = null;
        for (int i10 = 0; i10 < attributeCount; i10++) {
            String attributeName = xmlPullParser.getAttributeName(i10);
            String attributeValue = xmlPullParser.getAttributeValue(i10);
            attributeName.hashCode();
            switch (attributeName.hashCode()) {
                case -934795532:
                    if (attributeName.equals(AgConnectInfo.AgConnectKey.REGION)) {
                        c4 = 0;
                        break;
                    }
                    break;
                case 99841:
                    if (attributeName.equals("dur")) {
                        c4 = 1;
                        break;
                    }
                    break;
                case 100571:
                    if (attributeName.equals("end")) {
                        c4 = 2;
                        break;
                    }
                    break;
                case 93616297:
                    if (attributeName.equals(QRecyclerView.SHOW_BEGIN_KEY)) {
                        c4 = 3;
                        break;
                    }
                    break;
                case 109780401:
                    if (attributeName.equals("style")) {
                        c4 = 4;
                        break;
                    }
                    break;
                case 1292595405:
                    if (attributeName.equals("backgroundImage")) {
                        c4 = 5;
                        break;
                    }
                    break;
            }
            c4 = 65535;
            switch (c4) {
                case 0:
                    if (!map.containsKey(attributeValue)) {
                        break;
                    } else {
                        str2 = attributeValue;
                        continue;
                    }
                case 1:
                    j14 = O(attributeValue, bVar);
                    break;
                case 2:
                    j13 = O(attributeValue, bVar);
                    break;
                case 3:
                    j12 = O(attributeValue, bVar);
                    break;
                case 4:
                    String[] N = N(attributeValue);
                    if (N.length > 0) {
                        strArr = N;
                        break;
                    }
                    break;
                case 5:
                    if (attributeValue.startsWith("#")) {
                        str = attributeValue.substring(1);
                        break;
                    }
                    break;
            }
        }
        if (dVar != null) {
            long j15 = dVar.f50691d;
            j10 = -9223372036854775807L;
            if (j15 != -9223372036854775807L) {
                if (j12 != -9223372036854775807L) {
                    j12 += j15;
                }
                if (j13 != -9223372036854775807L) {
                    j13 += j15;
                }
            }
        } else {
            j10 = -9223372036854775807L;
        }
        long j16 = j12;
        if (j13 == j10) {
            if (j14 != j10) {
                j11 = j16 + j14;
            } else if (dVar != null) {
                long j17 = dVar.f50692e;
                if (j17 != j10) {
                    j11 = j17;
                }
            }
            return d.c(xmlPullParser.getName(), j16, j11, M, strArr, str2, str, dVar);
        }
        j11 = j13;
        return d.c(xmlPullParser.getName(), j16, j11, M, strArr, str2, str, dVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01ad, code lost:
    
        if (r0.equals("tb") == false) goto L65;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0180  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static k6.e K(org.xmlpull.v1.XmlPullParser r17, k6.c.a r18, @androidx.annotation.Nullable k6.c.C0770c r19) {
        /*
            Method dump skipped, instructions count: 578
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: k6.c.K(org.xmlpull.v1.XmlPullParser, k6.c$a, k6.c$c):k6.e");
    }

    public static float L(String str) {
        Matcher matcher = f50674s.matcher(str);
        if (!matcher.matches()) {
            String valueOf = String.valueOf(str);
            m.h("TtmlDecoder", valueOf.length() != 0 ? "Invalid value for shear: ".concat(valueOf) : new String("Invalid value for shear: "));
            return Float.MAX_VALUE;
        }
        try {
            return Math.min(100.0f, Math.max(-100.0f, Float.parseFloat((String) com.google.android.exoplayer2.util.a.e(matcher.group(1)))));
        } catch (NumberFormatException e2) {
            String valueOf2 = String.valueOf(str);
            m.i("TtmlDecoder", valueOf2.length() != 0 ? "Failed to parse shear: ".concat(valueOf2) : new String("Failed to parse shear: "), e2);
            return Float.MAX_VALUE;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x01f2, code lost:
    
        if (r3.equals("text") == false) goto L112;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:93:0x0289. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static k6.g M(org.xmlpull.v1.XmlPullParser r12, k6.g r13) {
        /*
            Method dump skipped, instructions count: 946
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: k6.c.M(org.xmlpull.v1.XmlPullParser, k6.g):k6.g");
    }

    public static String[] N(String str) {
        String trim = str.trim();
        return trim.isEmpty() ? new String[0] : j0.M0(trim, "\\s+");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bf, code lost:
    
        if (r13.equals("ms") == false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long O(java.lang.String r13, k6.c.b r14) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        /*
            Method dump skipped, instructions count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: k6.c.O(java.lang.String, k6.c$b):long");
    }

    @Nullable
    public static C0770c P(XmlPullParser xmlPullParser) {
        String a10 = k0.a(xmlPullParser, "extent");
        if (a10 == null) {
            return null;
        }
        Matcher matcher = f50676u.matcher(a10);
        if (!matcher.matches()) {
            m.h("TtmlDecoder", a10.length() != 0 ? "Ignoring non-pixel tts extent: ".concat(a10) : new String("Ignoring non-pixel tts extent: "));
            return null;
        }
        try {
            return new C0770c(Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher.group(1))), Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher.group(2))));
        } catch (NumberFormatException unused) {
            m.h("TtmlDecoder", a10.length() != 0 ? "Ignoring malformed tts extent: ".concat(a10) : new String("Ignoring malformed tts extent: "));
            return null;
        }
    }

    @Override // e6.c
    public e6.e A(byte[] bArr, int i10, boolean z10) throws SubtitleDecoderException {
        b bVar;
        try {
            XmlPullParser newPullParser = this.f50680o.newPullParser();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            hashMap2.put("", new e(""));
            C0770c c0770c = null;
            newPullParser.setInput(new ByteArrayInputStream(bArr, 0, i10), null);
            ArrayDeque arrayDeque = new ArrayDeque();
            b bVar2 = f50678w;
            a aVar = f50679x;
            h hVar = null;
            int i11 = 0;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.getEventType()) {
                d dVar = (d) arrayDeque.peek();
                if (i11 == 0) {
                    String name = newPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            bVar2 = G(newPullParser);
                            aVar = E(newPullParser, f50679x);
                            c0770c = P(newPullParser);
                        }
                        C0770c c0770c2 = c0770c;
                        b bVar3 = bVar2;
                        a aVar2 = aVar;
                        if (!C(name)) {
                            String valueOf = String.valueOf(newPullParser.getName());
                            m.f("TtmlDecoder", valueOf.length() != 0 ? "Ignoring unsupported tag: ".concat(valueOf) : new String("Ignoring unsupported tag: "));
                            i11++;
                            bVar2 = bVar3;
                        } else {
                            if ("head".equals(name)) {
                                bVar = bVar3;
                                H(newPullParser, hashMap, aVar2, c0770c2, hashMap2, hashMap3);
                            } else {
                                bVar = bVar3;
                                try {
                                    d J = J(newPullParser, dVar, hashMap2, bVar);
                                    arrayDeque.push(J);
                                    if (dVar != null) {
                                        dVar.a(J);
                                    }
                                } catch (SubtitleDecoderException e2) {
                                    m.i("TtmlDecoder", "Suppressing parser error", e2);
                                    i11++;
                                }
                            }
                            bVar2 = bVar;
                        }
                        c0770c = c0770c2;
                        aVar = aVar2;
                    } else if (eventType == 4) {
                        ((d) com.google.android.exoplayer2.util.a.e(dVar)).a(d.d(newPullParser.getText()));
                    } else if (eventType == 3) {
                        if (newPullParser.getName().equals("tt")) {
                            hVar = new h((d) com.google.android.exoplayer2.util.a.e((d) arrayDeque.peek()), hashMap, hashMap2, hashMap3);
                        }
                        arrayDeque.pop();
                    }
                } else if (eventType == 2) {
                    i11++;
                } else if (eventType == 3) {
                    i11--;
                }
                newPullParser.next();
            }
            if (hVar != null) {
                return hVar;
            }
            throw new SubtitleDecoderException("No TTML subtitles found");
        } catch (IOException e10) {
            throw new IllegalStateException("Unexpected error when reading input.", e10);
        } catch (XmlPullParserException e11) {
            throw new SubtitleDecoderException("Unable to decode source", e11);
        }
    }
}
