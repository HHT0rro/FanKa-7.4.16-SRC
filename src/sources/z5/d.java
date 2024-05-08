package z5;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Xml;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.android.internal.org.bouncycastle.cms.CMSAttributeTableGenerator;
import com.android.internal.os.PowerProfile;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.upstream.i;
import com.google.android.exoplayer2.util.h0;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.k0;
import com.google.android.exoplayer2.util.q;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.huawei.hianalytics.core.storage.Event;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.cardmanager.util.CardUriUtils;
import com.kuaishou.weapon.p0.t;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;
import z5.k;

/* compiled from: DashManifestParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class d extends DefaultHandler implements i.a<c> {

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f54902b = Pattern.compile("(\\d+)(?:/(\\d+))?");

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f54903c = Pattern.compile("CC([1-4])=.*");

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f54904d = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f54905e = {-1, 1, 2, 3, 4, 5, 6, 8, 2, 3, 4, 7, 8, 24, 8, 12, 10, 12, 14, 12, 14};

    /* renamed from: a, reason: collision with root package name */
    public final XmlPullParserFactory f54906a;

    /* compiled from: DashManifestParser.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Format f54907a;

        /* renamed from: b, reason: collision with root package name */
        public final ImmutableList<b> f54908b;

        /* renamed from: c, reason: collision with root package name */
        public final k f54909c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        public final String f54910d;

        /* renamed from: e, reason: collision with root package name */
        public final ArrayList<DrmInitData.SchemeData> f54911e;

        /* renamed from: f, reason: collision with root package name */
        public final ArrayList<e> f54912f;

        /* renamed from: g, reason: collision with root package name */
        public final long f54913g;

        public a(Format format, List<b> list, k kVar, @Nullable String str, ArrayList<DrmInitData.SchemeData> arrayList, ArrayList<e> arrayList2, long j10) {
            this.f54907a = format;
            this.f54908b = ImmutableList.copyOf((Collection) list);
            this.f54909c = kVar;
            this.f54910d = str;
            this.f54911e = arrayList;
            this.f54912f = arrayList2;
            this.f54913g = j10;
        }
    }

    public d() {
        try {
            this.f54906a = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }

    public static int B(List<e> list) {
        String str;
        for (int i10 = 0; i10 < list.size(); i10++) {
            e eVar = list.get(i10);
            if ("urn:scte:dash:cc:cea-608:2015".equals(eVar.f54914a) && (str = eVar.f54915b) != null) {
                Matcher matcher = f54903c.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                String valueOf = String.valueOf(eVar.f54915b);
                com.google.android.exoplayer2.util.m.h("MpdParser", valueOf.length() != 0 ? "Unable to parse CEA-608 channel number from: ".concat(valueOf) : new String("Unable to parse CEA-608 channel number from: "));
            }
        }
        return -1;
    }

    public static int C(List<e> list) {
        String str;
        for (int i10 = 0; i10 < list.size(); i10++) {
            e eVar = list.get(i10);
            if ("urn:scte:dash:cc:cea-708:2015".equals(eVar.f54914a) && (str = eVar.f54915b) != null) {
                Matcher matcher = f54904d.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                String valueOf = String.valueOf(eVar.f54915b);
                com.google.android.exoplayer2.util.m.h("MpdParser", valueOf.length() != 0 ? "Unable to parse CEA-708 service block number from: ".concat(valueOf) : new String("Unable to parse CEA-708 service block number from: "));
            }
        }
        return -1;
    }

    public static long F(XmlPullParser xmlPullParser, String str, long j10) throws ParserException {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j10 : j0.C0(attributeValue);
    }

    public static e G(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String m02 = m0(xmlPullParser, "schemeIdUri", "");
        String m03 = m0(xmlPullParser, "value", null);
        String m04 = m0(xmlPullParser, "id", null);
        do {
            xmlPullParser.next();
        } while (!k0.d(xmlPullParser, str));
        return new e(m02, m03, m04);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int H(XmlPullParser xmlPullParser) {
        char c4;
        String attributeValue = xmlPullParser.getAttributeValue(null, "value");
        if (attributeValue == null) {
            return -1;
        }
        String e2 = com.google.common.base.a.e(attributeValue);
        e2.hashCode();
        switch (e2.hashCode()) {
            case 1596796:
                if (e2.equals("4000")) {
                    c4 = 0;
                    break;
                }
                c4 = 65535;
                break;
            case 2937391:
                if (e2.equals("a000")) {
                    c4 = 1;
                    break;
                }
                c4 = 65535;
                break;
            case 3094035:
                if (e2.equals("f801")) {
                    c4 = 2;
                    break;
                }
                c4 = 65535;
                break;
            case 3133436:
                if (e2.equals("fa01")) {
                    c4 = 3;
                    break;
                }
                c4 = 65535;
                break;
            default:
                c4 = 65535;
                break;
        }
        switch (c4) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 6;
            case 3:
                return 8;
            default:
                return -1;
        }
    }

    public static long I(XmlPullParser xmlPullParser, String str, long j10) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j10 : j0.D0(attributeValue);
    }

    public static String J(List<e> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            e eVar = list.get(i10);
            String str = eVar.f54914a;
            if ("tag:dolby.com,2018:dash:EC3_ExtensionType:2018".equals(str) && "JOC".equals(eVar.f54915b)) {
                return "audio/eac3-joc";
            }
            if ("tag:dolby.com,2014:dash:DolbyDigitalPlusExtensionType:2014".equals(str) && "ec+3".equals(eVar.f54915b)) {
                return "audio/eac3-joc";
            }
        }
        return "audio/eac3";
    }

    public static float N(XmlPullParser xmlPullParser, String str, float f10) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? f10 : Float.parseFloat(attributeValue);
    }

    public static float O(XmlPullParser xmlPullParser, float f10) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "frameRate");
        if (attributeValue == null) {
            return f10;
        }
        Matcher matcher = f54902b.matcher(attributeValue);
        if (!matcher.matches()) {
            return f10;
        }
        int parseInt = Integer.parseInt(matcher.group(1));
        return !TextUtils.isEmpty(matcher.group(2)) ? parseInt / Integer.parseInt(r2) : parseInt;
    }

    public static int Q(XmlPullParser xmlPullParser, String str, int i10) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? i10 : Integer.parseInt(attributeValue);
    }

    public static long S(List<e> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            e eVar = list.get(i10);
            if (com.google.common.base.a.a("http://dashif.org/guidelines/last-segment-number", eVar.f54914a)) {
                return Long.parseLong(eVar.f54915b);
            }
        }
        return -1L;
    }

    public static long T(XmlPullParser xmlPullParser, String str, long j10) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j10 : Long.parseLong(attributeValue);
    }

    public static int V(XmlPullParser xmlPullParser) {
        int Q = Q(xmlPullParser, "value", -1);
        if (Q < 0) {
            return -1;
        }
        int[] iArr = f54905e;
        if (Q < iArr.length) {
            return iArr[Q];
        }
        return -1;
    }

    public static String m0(XmlPullParser xmlPullParser, String str, String str2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? str2 : attributeValue;
    }

    public static String n0(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String str2 = "";
        do {
            xmlPullParser.next();
            if (xmlPullParser.getEventType() == 4) {
                str2 = xmlPullParser.getText();
            } else {
                u(xmlPullParser);
            }
        } while (!k0.d(xmlPullParser, str));
        return str2;
    }

    public static int p(int i10, int i11) {
        if (i10 == -1) {
            return i11;
        }
        if (i11 == -1) {
            return i10;
        }
        com.google.android.exoplayer2.util.a.g(i10 == i11);
        return i10;
    }

    @Nullable
    public static String q(@Nullable String str, @Nullable String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        com.google.android.exoplayer2.util.a.g(str.equals(str2));
        return str;
    }

    public static void r(ArrayList<DrmInitData.SchemeData> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            DrmInitData.SchemeData schemeData = arrayList.get(size);
            if (!schemeData.hasData()) {
                int i10 = 0;
                while (true) {
                    if (i10 >= arrayList.size()) {
                        break;
                    }
                    if (arrayList.get(i10).canReplace(schemeData)) {
                        arrayList.remove(size);
                        break;
                    }
                    i10++;
                }
            }
        }
    }

    public static long s(long j10, long j11) {
        if (j11 != -9223372036854775807L) {
            j10 = j11;
        }
        if (j10 == Long.MAX_VALUE) {
            return -9223372036854775807L;
        }
        return j10;
    }

    @Nullable
    public static String t(@Nullable String str, @Nullable String str2) {
        if (q.p(str)) {
            return q.c(str2);
        }
        if (q.s(str)) {
            return q.o(str2);
        }
        if (q.r(str)) {
            return "application/x-rawcc".equals(str) ? q.j(str2) : str;
        }
        if (!"application/mp4".equals(str)) {
            return null;
        }
        String g3 = q.g(str2);
        return "text/vtt".equals(g3) ? "application/x-mp4-vtt" : g3;
    }

    public static void u(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        if (k0.e(xmlPullParser)) {
            int i10 = 1;
            while (i10 != 0) {
                xmlPullParser.next();
                if (k0.e(xmlPullParser)) {
                    i10++;
                } else if (k0.c(xmlPullParser)) {
                    i10--;
                }
            }
        }
    }

    public List<b> A(XmlPullParser xmlPullParser, List<b> list) throws XmlPullParserException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue(null, "dvb:priority");
        int parseInt = attributeValue != null ? Integer.parseInt(attributeValue) : 1;
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "dvb:weight");
        int parseInt2 = attributeValue2 != null ? Integer.parseInt(attributeValue2) : 1;
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "serviceLocation");
        String n02 = n0(xmlPullParser, "BaseURL");
        if (attributeValue3 == null) {
            attributeValue3 = n02;
        }
        if (h0.b(n02)) {
            return Lists.m(new b(n02, attributeValue3, parseInt, parseInt2));
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            b bVar = list.get(i10);
            arrayList.add(new b(h0.d(bVar.f54885a, n02), bVar.f54886b, bVar.f54887c, bVar.f54888d));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0098  */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.util.UUID] */
    /* JADX WARN: Type inference failed for: r3v13, types: [java.util.UUID] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15, types: [java.util.UUID] */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v20, types: [java.util.UUID] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v10, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.util.UUID] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.util.Pair<java.lang.String, com.google.android.exoplayer2.drm.DrmInitData.SchemeData> D(org.xmlpull.v1.XmlPullParser r11) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: z5.d.D(org.xmlpull.v1.XmlPullParser):android.util.Pair");
    }

    public int E(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, CMSAttributeTableGenerator.CONTENT_TYPE);
        if (TextUtils.isEmpty(attributeValue)) {
            return -1;
        }
        if (PowerProfile.POWER_AUDIO.equals(attributeValue)) {
            return 1;
        }
        if ("video".equals(attributeValue)) {
            return 2;
        }
        return "text".equals(attributeValue) ? 3 : -1;
    }

    public Pair<Long, EventMessage> K(XmlPullParser xmlPullParser, String str, String str2, long j10, ByteArrayOutputStream byteArrayOutputStream) throws IOException, XmlPullParserException {
        long T = T(xmlPullParser, "id", 0L);
        long T2 = T(xmlPullParser, "duration", -9223372036854775807L);
        long T3 = T(xmlPullParser, "presentationTime", 0L);
        long H0 = j0.H0(T2, 1000L, j10);
        long H02 = j0.H0(T3, 1000000L, j10);
        String m02 = m0(xmlPullParser, "messageData", null);
        byte[] L = L(xmlPullParser, byteArrayOutputStream);
        Long valueOf = Long.valueOf(H02);
        if (m02 != null) {
            L = j0.i0(m02);
        }
        return Pair.create(valueOf, d(str, str2, T, H0, L));
    }

    public byte[] L(XmlPullParser xmlPullParser, ByteArrayOutputStream byteArrayOutputStream) throws XmlPullParserException, IOException {
        byteArrayOutputStream.reset();
        XmlSerializer newSerializer = Xml.newSerializer();
        newSerializer.setOutput(byteArrayOutputStream, com.google.common.base.c.f25961c.name());
        xmlPullParser.nextToken();
        while (!k0.d(xmlPullParser, Event.TAG)) {
            switch (xmlPullParser.getEventType()) {
                case 0:
                    newSerializer.startDocument(null, Boolean.FALSE);
                    break;
                case 1:
                    newSerializer.endDocument();
                    break;
                case 2:
                    newSerializer.startTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    for (int i10 = 0; i10 < xmlPullParser.getAttributeCount(); i10++) {
                        newSerializer.attribute(xmlPullParser.getAttributeNamespace(i10), xmlPullParser.getAttributeName(i10), xmlPullParser.getAttributeValue(i10));
                    }
                    break;
                case 3:
                    newSerializer.endTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    break;
                case 4:
                    newSerializer.text(xmlPullParser.getText());
                    break;
                case 5:
                    newSerializer.cdsect(xmlPullParser.getText());
                    break;
                case 6:
                    newSerializer.entityRef(xmlPullParser.getText());
                    break;
                case 7:
                    newSerializer.ignorableWhitespace(xmlPullParser.getText());
                    break;
                case 8:
                    newSerializer.processingInstruction(xmlPullParser.getText());
                    break;
                case 9:
                    newSerializer.comment(xmlPullParser.getText());
                    break;
                case 10:
                    newSerializer.docdecl(xmlPullParser.getText());
                    break;
            }
            xmlPullParser.nextToken();
        }
        newSerializer.flush();
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f M(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String m02 = m0(xmlPullParser, "schemeIdUri", "");
        String m03 = m0(xmlPullParser, "value", "");
        long T = T(xmlPullParser, "timescale", 1L);
        ArrayList arrayList = new ArrayList();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        do {
            xmlPullParser.next();
            if (k0.f(xmlPullParser, Event.TAG)) {
                arrayList.add(K(xmlPullParser, m02, m03, T, byteArrayOutputStream));
            } else {
                u(xmlPullParser);
            }
        } while (!k0.d(xmlPullParser, "EventStream"));
        long[] jArr = new long[arrayList.size()];
        EventMessage[] eventMessageArr = new EventMessage[arrayList.size()];
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            Pair pair = (Pair) arrayList.get(i10);
            jArr[i10] = ((Long) pair.first).longValue();
            eventMessageArr[i10] = (EventMessage) pair.second;
        }
        return e(m02, m03, T, jArr, eventMessageArr);
    }

    public i P(XmlPullParser xmlPullParser) {
        return Y(xmlPullParser, "sourceURL", Attributes.Style.RANGE);
    }

    public String R(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return n0(xmlPullParser, "Label");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x01b9 A[LOOP:0: B:15:0x0082->B:23:0x01b9, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0175 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public z5.c U(org.xmlpull.v1.XmlPullParser r44, z5.b r45) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 452
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: z5.d.U(org.xmlpull.v1.XmlPullParser, z5.b):z5.c");
    }

    public Pair<g, Long> W(XmlPullParser xmlPullParser, List<b> list, long j10, long j11, long j12, long j13) throws XmlPullParserException, IOException {
        long j14;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        Object obj;
        long j15;
        k g02;
        d dVar = this;
        Object obj2 = null;
        String attributeValue = xmlPullParser.getAttributeValue(null, "id");
        long I = I(xmlPullParser, "start", j10);
        long j16 = -9223372036854775807L;
        long j17 = j12 != -9223372036854775807L ? j12 + I : -9223372036854775807L;
        long I2 = I(xmlPullParser, "duration", -9223372036854775807L);
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        long j18 = j11;
        long j19 = -9223372036854775807L;
        k kVar = null;
        e eVar = null;
        boolean z10 = false;
        while (true) {
            xmlPullParser.next();
            if (k0.f(xmlPullParser, "BaseURL")) {
                if (!z10) {
                    j18 = dVar.z(xmlPullParser, j18);
                    z10 = true;
                }
                arrayList6.addAll(A(xmlPullParser, list));
                arrayList3 = arrayList5;
                arrayList = arrayList6;
                j15 = j16;
                obj = obj2;
                arrayList2 = arrayList4;
            } else {
                if (k0.f(xmlPullParser, "AdaptationSet")) {
                    j14 = j18;
                    arrayList = arrayList6;
                    arrayList2 = arrayList4;
                    arrayList2.add(w(xmlPullParser, !arrayList6.isEmpty() ? arrayList6 : list, kVar, I2, j18, j19, j17, j13));
                    arrayList3 = arrayList5;
                } else {
                    j14 = j18;
                    ArrayList arrayList7 = arrayList5;
                    arrayList = arrayList6;
                    arrayList2 = arrayList4;
                    if (k0.f(xmlPullParser, "EventStream")) {
                        arrayList7.add(M(xmlPullParser));
                        arrayList3 = arrayList7;
                    } else if (k0.f(xmlPullParser, "SegmentBase")) {
                        arrayList3 = arrayList7;
                        kVar = e0(xmlPullParser, null);
                        obj = null;
                        j18 = j14;
                        j15 = -9223372036854775807L;
                    } else {
                        arrayList3 = arrayList7;
                        if (k0.f(xmlPullParser, "SegmentList")) {
                            long z11 = z(xmlPullParser, -9223372036854775807L);
                            obj = null;
                            g02 = f0(xmlPullParser, null, j17, I2, j14, z11, j13);
                            j19 = z11;
                            j18 = j14;
                            j15 = -9223372036854775807L;
                        } else {
                            obj = null;
                            if (k0.f(xmlPullParser, "SegmentTemplate")) {
                                long z12 = z(xmlPullParser, -9223372036854775807L);
                                j15 = -9223372036854775807L;
                                g02 = g0(xmlPullParser, null, ImmutableList.of(), j17, I2, j14, z12, j13);
                                j19 = z12;
                                j18 = j14;
                            } else {
                                j15 = -9223372036854775807L;
                                if (k0.f(xmlPullParser, "AssetIdentifier")) {
                                    eVar = G(xmlPullParser, "AssetIdentifier");
                                } else {
                                    u(xmlPullParser);
                                }
                                j18 = j14;
                            }
                        }
                        kVar = g02;
                    }
                }
                obj = null;
                j15 = -9223372036854775807L;
                j18 = j14;
            }
            if (k0.d(xmlPullParser, "Period")) {
                return Pair.create(h(attributeValue, I, arrayList2, arrayList3, eVar), Long.valueOf(I2));
            }
            arrayList4 = arrayList2;
            arrayList6 = arrayList;
            obj2 = obj;
            arrayList5 = arrayList3;
            j16 = j15;
            dVar = this;
        }
    }

    public h X(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        String str = null;
        String m02 = m0(xmlPullParser, "moreInformationURL", null);
        String m03 = m0(xmlPullParser, "lang", null);
        String str2 = null;
        String str3 = null;
        while (true) {
            xmlPullParser.next();
            if (k0.f(xmlPullParser, "Title")) {
                str = xmlPullParser.nextText();
            } else if (k0.f(xmlPullParser, "Source")) {
                str2 = xmlPullParser.nextText();
            } else if (k0.f(xmlPullParser, ExifInterface.TAG_COPYRIGHT)) {
                str3 = xmlPullParser.nextText();
            } else {
                u(xmlPullParser);
            }
            String str4 = str3;
            if (k0.d(xmlPullParser, "ProgramInformation")) {
                return new h(str, str2, str4, m02, m03);
            }
            str3 = str4;
        }
    }

    public i Y(XmlPullParser xmlPullParser, String str, String str2) {
        long j10;
        long j11;
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, str2);
        if (attributeValue2 != null) {
            String[] split = attributeValue2.split("-");
            j10 = Long.parseLong(split[0]);
            if (split.length == 2) {
                j11 = (Long.parseLong(split[1]) - j10) + 1;
                return i(attributeValue, j10, j11);
            }
        } else {
            j10 = 0;
        }
        j11 = -1;
        return i(attributeValue, j10, j11);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x01e2 A[LOOP:0: B:2:0x006a->B:11:0x01e2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0190 A[EDGE_INSN: B:12:0x0190->B:13:0x0190 BREAK  A[LOOP:0: B:2:0x006a->B:11:0x01e2], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public z5.d.a Z(org.xmlpull.v1.XmlPullParser r36, java.util.List<z5.b> r37, @androidx.annotation.Nullable java.lang.String r38, @androidx.annotation.Nullable java.lang.String r39, int r40, int r41, float r42, int r43, int r44, @androidx.annotation.Nullable java.lang.String r45, java.util.List<z5.e> r46, java.util.List<z5.e> r47, java.util.List<z5.e> r48, java.util.List<z5.e> r49, @androidx.annotation.Nullable z5.k r50, long r51, long r53, long r55, long r57, long r59) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 497
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: z5.d.Z(org.xmlpull.v1.XmlPullParser, java.util.List, java.lang.String, java.lang.String, int, int, float, int, int, java.lang.String, java.util.List, java.util.List, java.util.List, java.util.List, z5.k, long, long, long, long, long):z5.d$a");
    }

    public int a0(List<e> list) {
        int o02;
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            e eVar = list.get(i11);
            if (com.google.common.base.a.a("urn:mpeg:dash:role:2011", eVar.f54914a)) {
                o02 = b0(eVar.f54915b);
            } else if (com.google.common.base.a.a("urn:tva:metadata:cs:AudioPurposeCS:2007", eVar.f54914a)) {
                o02 = o0(eVar.f54915b);
            }
            i10 |= o02;
        }
        return i10;
    }

    public final long b(List<k.d> list, long j10, long j11, int i10, long j12) {
        int m10 = i10 >= 0 ? i10 + 1 : (int) j0.m(j12 - j10, j11);
        for (int i11 = 0; i11 < m10; i11++) {
            list.add(m(j10, j11));
            j10 += j11;
        }
        return j10;
    }

    public int b0(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        char c4 = 65535;
        switch (str.hashCode()) {
            case -2060497896:
                if (str.equals("subtitle")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1724546052:
                if (str.equals("description")) {
                    c4 = 1;
                    break;
                }
                break;
            case -1580883024:
                if (str.equals("enhanced-audio-intelligibility")) {
                    c4 = 2;
                    break;
                }
                break;
            case -1574842690:
                if (str.equals("forced_subtitle")) {
                    c4 = 3;
                    break;
                }
                break;
            case -1408024454:
                if (str.equals("alternate")) {
                    c4 = 4;
                    break;
                }
                break;
            case 99825:
                if (str.equals("dub")) {
                    c4 = 5;
                    break;
                }
                break;
            case 3343801:
                if (str.equals("main")) {
                    c4 = 6;
                    break;
                }
                break;
            case 3530173:
                if (str.equals(CardUriUtils.PARAM_SIGN)) {
                    c4 = 7;
                    break;
                }
                break;
            case 552573414:
                if (str.equals("caption")) {
                    c4 = '\b';
                    break;
                }
                break;
            case 899152809:
                if (str.equals("commentary")) {
                    c4 = '\t';
                    break;
                }
                break;
            case 1629013393:
                if (str.equals("emergency")) {
                    c4 = '\n';
                    break;
                }
                break;
            case 1855372047:
                if (str.equals("supplementary")) {
                    c4 = 11;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
            case 3:
                return 128;
            case 1:
                return 512;
            case 2:
                return 2048;
            case 4:
                return 2;
            case 5:
                return 16;
            case 6:
                return 1;
            case 7:
                return 256;
            case '\b':
                return 64;
            case '\t':
                return 8;
            case '\n':
                return 32;
            case 11:
                return 4;
            default:
                return 0;
        }
    }

    public z5.a c(int i10, int i11, List<j> list, List<e> list2, List<e> list3, List<e> list4) {
        return new z5.a(i10, i11, list, list2, list3, list4);
    }

    public int c0(List<e> list) {
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (com.google.common.base.a.a("http://dashif.org/guidelines/trickmode", list.get(i11).f54914a)) {
                i10 |= 16384;
            }
        }
        return i10;
    }

    public EventMessage d(String str, String str2, long j10, long j11, byte[] bArr) {
        return new EventMessage(str, str2, j11, j10, bArr);
    }

    public int d0(List<e> list) {
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            e eVar = list.get(i11);
            if (com.google.common.base.a.a("urn:mpeg:dash:role:2011", eVar.f54914a)) {
                i10 |= b0(eVar.f54915b);
            }
        }
        return i10;
    }

    public f e(String str, String str2, long j10, long[] jArr, EventMessage[] eventMessageArr) {
        return new f(str, str2, j10, jArr, eventMessageArr);
    }

    public k.e e0(XmlPullParser xmlPullParser, @Nullable k.e eVar) throws XmlPullParserException, IOException {
        long j10;
        long j11;
        long T = T(xmlPullParser, "timescale", eVar != null ? eVar.f54949b : 1L);
        long T2 = T(xmlPullParser, "presentationTimeOffset", eVar != null ? eVar.f54950c : 0L);
        long j12 = eVar != null ? eVar.f54963d : 0L;
        long j13 = eVar != null ? eVar.f54964e : 0L;
        String attributeValue = xmlPullParser.getAttributeValue(null, "indexRange");
        if (attributeValue != null) {
            String[] split = attributeValue.split("-");
            long parseLong = Long.parseLong(split[0]);
            j10 = (Long.parseLong(split[1]) - parseLong) + 1;
            j11 = parseLong;
        } else {
            j10 = j13;
            j11 = j12;
        }
        i iVar = eVar != null ? eVar.f54948a : null;
        do {
            xmlPullParser.next();
            if (k0.f(xmlPullParser, "Initialization")) {
                iVar = P(xmlPullParser);
            } else {
                u(xmlPullParser);
            }
        } while (!k0.d(xmlPullParser, "SegmentBase"));
        return n(iVar, T, T2, j11, j10);
    }

    public Format f(@Nullable String str, @Nullable String str2, int i10, int i11, float f10, int i12, int i13, int i14, @Nullable String str3, List<e> list, List<e> list2, @Nullable String str4, List<e> list3, List<e> list4) {
        String str5 = str4;
        String t2 = t(str2, str5);
        if ("audio/eac3".equals(t2)) {
            t2 = J(list4);
            if ("audio/eac3-joc".equals(t2)) {
                str5 = "ec+3";
            }
        }
        int k02 = k0(list);
        Format.b V = new Format.b().S(str).K(str2).e0(t2).I(str5).Z(i14).g0(k02).c0(d0(list) | a0(list2) | c0(list3) | c0(list4)).V(str3);
        if (q.s(t2)) {
            V.j0(i10).Q(i11).P(f10);
        } else if (q.p(t2)) {
            V.H(i12).f0(i13);
        } else if (q.r(t2)) {
            int i15 = -1;
            if ("application/cea-608".equals(t2)) {
                i15 = B(list2);
            } else if ("application/cea-708".equals(t2)) {
                i15 = C(list2);
            }
            V.F(i15);
        }
        return V.E();
    }

    public k.b f0(XmlPullParser xmlPullParser, @Nullable k.b bVar, long j10, long j11, long j12, long j13, long j14) throws XmlPullParserException, IOException {
        long T = T(xmlPullParser, "timescale", bVar != null ? bVar.f54949b : 1L);
        long T2 = T(xmlPullParser, "presentationTimeOffset", bVar != null ? bVar.f54950c : 0L);
        long T3 = T(xmlPullParser, "duration", bVar != null ? bVar.f54952e : -9223372036854775807L);
        long T4 = T(xmlPullParser, "startNumber", bVar != null ? bVar.f54951d : 1L);
        long s2 = s(j12, j13);
        List<k.d> list = null;
        List<i> list2 = null;
        i iVar = null;
        do {
            xmlPullParser.next();
            if (k0.f(xmlPullParser, "Initialization")) {
                iVar = P(xmlPullParser);
            } else if (k0.f(xmlPullParser, "SegmentTimeline")) {
                list = h0(xmlPullParser, T, j11);
            } else if (k0.f(xmlPullParser, "SegmentURL")) {
                if (list2 == null) {
                    list2 = new ArrayList<>();
                }
                list2.add(i0(xmlPullParser));
            } else {
                u(xmlPullParser);
            }
        } while (!k0.d(xmlPullParser, "SegmentList"));
        if (bVar != null) {
            if (iVar == null) {
                iVar = bVar.f54948a;
            }
            if (list == null) {
                list = bVar.f54953f;
            }
            if (list2 == null) {
                list2 = bVar.f54957j;
            }
        }
        return k(iVar, T, T2, T4, T3, list, s2, list2, j14, j10);
    }

    public c g(long j10, long j11, long j12, boolean z10, long j13, long j14, long j15, long j16, @Nullable h hVar, @Nullable o oVar, @Nullable l lVar, @Nullable Uri uri, List<g> list) {
        return new c(j10, j11, j12, z10, j13, j14, j15, j16, hVar, oVar, lVar, uri, list);
    }

    public k.c g0(XmlPullParser xmlPullParser, @Nullable k.c cVar, List<e> list, long j10, long j11, long j12, long j13, long j14) throws XmlPullParserException, IOException {
        long T = T(xmlPullParser, "timescale", cVar != null ? cVar.f54949b : 1L);
        long T2 = T(xmlPullParser, "presentationTimeOffset", cVar != null ? cVar.f54950c : 0L);
        long T3 = T(xmlPullParser, "duration", cVar != null ? cVar.f54952e : -9223372036854775807L);
        long T4 = T(xmlPullParser, "startNumber", cVar != null ? cVar.f54951d : 1L);
        long S = S(list);
        long s2 = s(j12, j13);
        List<k.d> list2 = null;
        n p02 = p0(xmlPullParser, "media", cVar != null ? cVar.f54959k : null);
        n p03 = p0(xmlPullParser, "initialization", cVar != null ? cVar.f54958j : null);
        i iVar = null;
        do {
            xmlPullParser.next();
            if (k0.f(xmlPullParser, "Initialization")) {
                iVar = P(xmlPullParser);
            } else if (k0.f(xmlPullParser, "SegmentTimeline")) {
                list2 = h0(xmlPullParser, T, j11);
            } else {
                u(xmlPullParser);
            }
        } while (!k0.d(xmlPullParser, "SegmentTemplate"));
        if (cVar != null) {
            if (iVar == null) {
                iVar = cVar.f54948a;
            }
            if (list2 == null) {
                list2 = cVar.f54953f;
            }
        }
        return l(iVar, T, T2, T4, S, T3, list2, s2, p03, p02, j14, j10);
    }

    public g h(@Nullable String str, long j10, List<z5.a> list, List<f> list2, @Nullable e eVar) {
        return new g(str, j10, list, list2, eVar);
    }

    public List<k.d> h0(XmlPullParser xmlPullParser, long j10, long j11) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        long j12 = 0;
        long j13 = -9223372036854775807L;
        boolean z10 = false;
        int i10 = 0;
        do {
            xmlPullParser.next();
            if (k0.f(xmlPullParser, ExifInterface.LATITUDE_SOUTH)) {
                long T = T(xmlPullParser, "t", -9223372036854775807L);
                if (z10) {
                    j12 = b(arrayList, j12, j13, i10, T);
                }
                if (T == -9223372036854775807L) {
                    T = j12;
                }
                j13 = T(xmlPullParser, "d", -9223372036854775807L);
                i10 = Q(xmlPullParser, t.f36226k, 0);
                j12 = T;
                z10 = true;
            } else {
                u(xmlPullParser);
            }
        } while (!k0.d(xmlPullParser, "SegmentTimeline"));
        if (z10) {
            b(arrayList, j12, j13, i10, j0.H0(j11, j10, 1000L));
        }
        return arrayList;
    }

    public i i(String str, long j10, long j11) {
        return new i(str, j10, j11);
    }

    public i i0(XmlPullParser xmlPullParser) {
        return Y(xmlPullParser, "media", "mediaRange");
    }

    public j j(a aVar, @Nullable String str, @Nullable String str2, ArrayList<DrmInitData.SchemeData> arrayList, ArrayList<e> arrayList2) {
        Format.b a10 = aVar.f54907a.a();
        if (str != null) {
            a10.U(str);
        }
        String str3 = aVar.f54910d;
        if (str3 != null) {
            str2 = str3;
        }
        ArrayList<DrmInitData.SchemeData> arrayList3 = aVar.f54911e;
        arrayList3.addAll(arrayList);
        if (!arrayList3.isEmpty()) {
            r(arrayList3);
            a10.L(new DrmInitData(str2, arrayList3));
        }
        ArrayList<e> arrayList4 = aVar.f54912f;
        arrayList4.addAll(arrayList2);
        return j.o(aVar.f54913g, a10.E(), aVar.f54908b, aVar.f54909c, arrayList4);
    }

    public int j0(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        if (str.equals("forced_subtitle")) {
            return 2;
        }
        return !str.equals("main") ? 0 : 1;
    }

    public k.b k(i iVar, long j10, long j11, long j12, long j13, @Nullable List<k.d> list, long j14, @Nullable List<i> list2, long j15, long j16) {
        return new k.b(iVar, j10, j11, j12, j13, list, j14, list2, com.google.android.exoplayer2.h.d(j15), com.google.android.exoplayer2.h.d(j16));
    }

    public int k0(List<e> list) {
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            e eVar = list.get(i11);
            if (com.google.common.base.a.a("urn:mpeg:dash:role:2011", eVar.f54914a)) {
                i10 |= j0(eVar.f54915b);
            }
        }
        return i10;
    }

    public k.c l(i iVar, long j10, long j11, long j12, long j13, long j14, List<k.d> list, long j15, @Nullable n nVar, @Nullable n nVar2, long j16, long j17) {
        return new k.c(iVar, j10, j11, j12, j13, j14, list, j15, nVar, nVar2, com.google.android.exoplayer2.h.d(j16), com.google.android.exoplayer2.h.d(j17));
    }

    public l l0(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        long j10 = -9223372036854775807L;
        long j11 = -9223372036854775807L;
        long j12 = -9223372036854775807L;
        float f10 = -3.4028235E38f;
        float f11 = -3.4028235E38f;
        while (true) {
            xmlPullParser.next();
            if (k0.f(xmlPullParser, "Latency")) {
                j10 = T(xmlPullParser, Attributes.Style.TARGET, -9223372036854775807L);
                j11 = T(xmlPullParser, Attributes.Style.MIN, -9223372036854775807L);
                j12 = T(xmlPullParser, "max", -9223372036854775807L);
            } else if (k0.f(xmlPullParser, "PlaybackRate")) {
                f10 = N(xmlPullParser, Attributes.Style.MIN, -3.4028235E38f);
                f11 = N(xmlPullParser, "max", -3.4028235E38f);
            }
            long j13 = j10;
            long j14 = j11;
            long j15 = j12;
            float f12 = f10;
            float f13 = f11;
            if (k0.d(xmlPullParser, "ServiceDescription")) {
                return new l(j13, j14, j15, f12, f13);
            }
            j10 = j13;
            j11 = j14;
            j12 = j15;
            f10 = f12;
            f11 = f13;
        }
    }

    public k.d m(long j10, long j11) {
        return new k.d(j10, j11);
    }

    public k.e n(i iVar, long j10, long j11, long j12, long j13) {
        return new k.e(iVar, j10, j11, j12, j13);
    }

    public o o(String str, String str2) {
        return new o(str, str2);
    }

    public int o0(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        char c4 = 65535;
        switch (str.hashCode()) {
            case 49:
                if (str.equals("1")) {
                    c4 = 0;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    c4 = 1;
                    break;
                }
                break;
            case 51:
                if (str.equals("3")) {
                    c4 = 2;
                    break;
                }
                break;
            case 52:
                if (str.equals("4")) {
                    c4 = 3;
                    break;
                }
                break;
            case 54:
                if (str.equals("6")) {
                    c4 = 4;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return 512;
            case 1:
                return 2048;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 1;
            default:
                return 0;
        }
    }

    @Nullable
    public n p0(XmlPullParser xmlPullParser, String str, @Nullable n nVar) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue != null ? n.b(attributeValue) : nVar;
    }

    public o q0(XmlPullParser xmlPullParser) {
        return o(xmlPullParser.getAttributeValue(null, "schemeIdUri"), xmlPullParser.getAttributeValue(null, "value"));
    }

    @Override // com.google.android.exoplayer2.upstream.i.a
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public c a(Uri uri, InputStream inputStream) throws IOException {
        try {
            XmlPullParser newPullParser = this.f54906a.newPullParser();
            newPullParser.setInput(inputStream, null);
            if (newPullParser.next() == 2 && "MPD".equals(newPullParser.getName())) {
                return U(newPullParser, new b(uri.toString()));
            }
            throw ParserException.createForMalformedManifest("inputStream does not contain a valid media presentation description", null);
        } catch (XmlPullParserException e2) {
            throw ParserException.createForMalformedManifest(null, e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0319 A[LOOP:0: B:2:0x007c->B:10:0x0319, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x02da A[EDGE_INSN: B:11:0x02da->B:12:0x02da BREAK  A[LOOP:0: B:2:0x007c->B:10:0x0319], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public z5.a w(org.xmlpull.v1.XmlPullParser r54, java.util.List<z5.b> r55, @androidx.annotation.Nullable z5.k r56, long r57, long r59, long r61, long r63, long r65) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 819
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: z5.d.w(org.xmlpull.v1.XmlPullParser, java.util.List, z5.k, long, long, long, long, long):z5.a");
    }

    public void x(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        u(xmlPullParser);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public int y(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        char c4;
        String m02 = m0(xmlPullParser, "schemeIdUri", null);
        m02.hashCode();
        int i10 = -1;
        switch (m02.hashCode()) {
            case -1352850286:
                if (m02.equals("urn:mpeg:dash:23003:3:audio_channel_configuration:2011")) {
                    c4 = 0;
                    break;
                }
                c4 = 65535;
                break;
            case -1138141449:
                if (m02.equals("tag:dolby.com,2014:dash:audio_channel_configuration:2011")) {
                    c4 = 1;
                    break;
                }
                c4 = 65535;
                break;
            case -986633423:
                if (m02.equals("urn:mpeg:mpegB:cicp:ChannelConfiguration")) {
                    c4 = 2;
                    break;
                }
                c4 = 65535;
                break;
            case 2036691300:
                if (m02.equals("urn:dolby:dash:audio_channel_configuration:2011")) {
                    c4 = 3;
                    break;
                }
                c4 = 65535;
                break;
            default:
                c4 = 65535;
                break;
        }
        switch (c4) {
            case 0:
                i10 = Q(xmlPullParser, "value", -1);
                break;
            case 1:
            case 3:
                i10 = H(xmlPullParser);
                break;
            case 2:
                i10 = V(xmlPullParser);
                break;
        }
        do {
            xmlPullParser.next();
        } while (!k0.d(xmlPullParser, "AudioChannelConfiguration"));
        return i10;
    }

    public long z(XmlPullParser xmlPullParser, long j10) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "availabilityTimeOffset");
        if (attributeValue == null) {
            return j10;
        }
        if ("INF".equals(attributeValue)) {
            return Long.MAX_VALUE;
        }
        return Float.parseFloat(attributeValue) * 1000000.0f;
    }
}
