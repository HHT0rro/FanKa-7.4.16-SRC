package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.alibaba.security.biometrics.service.build.ah;
import com.android.internal.os.PowerProfile;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox;
import com.google.android.exoplayer2.extractor.mp4.k;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.a;
import com.google.android.exoplayer2.upstream.i;
import com.google.android.exoplayer2.util.j0;
import com.huawei.openalliance.ad.constant.bb;
import com.kuaishou.weapon.p0.t;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class SsManifestParser implements i.a<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> {

    /* renamed from: a, reason: collision with root package name */
    public final XmlPullParserFactory f22069a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class MissingFieldException extends ParserException {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public MissingFieldException(java.lang.String r4) {
            /*
                r3 = this;
                java.lang.String r4 = java.lang.String.valueOf(r4)
                int r0 = r4.length()
                java.lang.String r1 = "Missing required field: "
                if (r0 == 0) goto L11
                java.lang.String r4 = r1.concat(r4)
                goto L16
            L11:
                java.lang.String r4 = new java.lang.String
                r4.<init>(r1)
            L16:
                r0 = 0
                r1 = 1
                r2 = 4
                r3.<init>(r4, r0, r1, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.MissingFieldException.<init>(java.lang.String):void");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f22070a;

        /* renamed from: b, reason: collision with root package name */
        public final String f22071b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        public final a f22072c;

        /* renamed from: d, reason: collision with root package name */
        public final List<Pair<String, Object>> f22073d = new LinkedList();

        public a(@Nullable a aVar, String str, String str2) {
            this.f22072c = aVar;
            this.f22070a = str;
            this.f22071b = str2;
        }

        public void a(Object obj) {
        }

        public abstract Object b();

        @Nullable
        public final Object c(String str) {
            for (int i10 = 0; i10 < this.f22073d.size(); i10++) {
                Pair<String, Object> pair = this.f22073d.get(i10);
                if (((String) pair.first).equals(str)) {
                    return pair.second;
                }
            }
            a aVar = this.f22072c;
            if (aVar == null) {
                return null;
            }
            return aVar.c(str);
        }

        public boolean d(String str) {
            return false;
        }

        public final a e(a aVar, String str, String str2) {
            if ("QualityLevel".equals(str)) {
                return new c(aVar, str2);
            }
            if ("Protection".equals(str)) {
                return new b(aVar, str2);
            }
            if ("StreamIndex".equals(str)) {
                return new e(aVar, str2);
            }
            return null;
        }

        public final Object f(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
            boolean z10 = false;
            int i10 = 0;
            while (true) {
                int eventType = xmlPullParser.getEventType();
                if (eventType == 1) {
                    return null;
                }
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    if (this.f22071b.equals(name)) {
                        n(xmlPullParser);
                        z10 = true;
                    } else if (z10) {
                        if (i10 > 0) {
                            i10++;
                        } else if (d(name)) {
                            n(xmlPullParser);
                        } else {
                            a e2 = e(this, name, this.f22070a);
                            if (e2 == null) {
                                i10 = 1;
                            } else {
                                a(e2.f(xmlPullParser));
                            }
                        }
                    }
                } else if (eventType != 3) {
                    if (eventType == 4 && z10 && i10 == 0) {
                        o(xmlPullParser);
                    }
                } else if (!z10) {
                    continue;
                } else if (i10 > 0) {
                    i10--;
                } else {
                    String name2 = xmlPullParser.getName();
                    h(xmlPullParser);
                    if (!d(name2)) {
                        return b();
                    }
                }
                xmlPullParser.next();
            }
        }

        public final boolean g(XmlPullParser xmlPullParser, String str, boolean z10) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            return attributeValue != null ? Boolean.parseBoolean(attributeValue) : z10;
        }

        public void h(XmlPullParser xmlPullParser) {
        }

        public final int i(XmlPullParser xmlPullParser, String str, int i10) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue == null) {
                return i10;
            }
            try {
                return Integer.parseInt(attributeValue);
            } catch (NumberFormatException e2) {
                throw ParserException.createForMalformedManifest(null, e2);
            }
        }

        public final long j(XmlPullParser xmlPullParser, String str, long j10) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue == null) {
                return j10;
            }
            try {
                return Long.parseLong(attributeValue);
            } catch (NumberFormatException e2) {
                throw ParserException.createForMalformedManifest(null, e2);
            }
        }

        public final int k(XmlPullParser xmlPullParser, String str) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue != null) {
                try {
                    return Integer.parseInt(attributeValue);
                } catch (NumberFormatException e2) {
                    throw ParserException.createForMalformedManifest(null, e2);
                }
            }
            throw new MissingFieldException(str);
        }

        public final long l(XmlPullParser xmlPullParser, String str) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue != null) {
                try {
                    return Long.parseLong(attributeValue);
                } catch (NumberFormatException e2) {
                    throw ParserException.createForMalformedManifest(null, e2);
                }
            }
            throw new MissingFieldException(str);
        }

        public final String m(XmlPullParser xmlPullParser, String str) throws MissingFieldException {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue != null) {
                return attributeValue;
            }
            throw new MissingFieldException(str);
        }

        public abstract void n(XmlPullParser xmlPullParser) throws ParserException;

        public void o(XmlPullParser xmlPullParser) {
        }

        public final void p(String str, @Nullable Object obj) {
            this.f22073d.add(Pair.create(str, obj));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class b extends a {

        /* renamed from: e, reason: collision with root package name */
        public boolean f22074e;

        /* renamed from: f, reason: collision with root package name */
        public UUID f22075f;

        /* renamed from: g, reason: collision with root package name */
        public byte[] f22076g;

        public b(a aVar, String str) {
            super(aVar, str, "Protection");
        }

        public static TrackEncryptionBox[] q(byte[] bArr) {
            return new TrackEncryptionBox[]{new TrackEncryptionBox(true, null, 8, r(bArr), 0, 0, null)};
        }

        public static byte[] r(byte[] bArr) {
            StringBuilder sb2 = new StringBuilder();
            for (int i10 = 0; i10 < bArr.length; i10 += 2) {
                sb2.append((char) bArr[i10]);
            }
            String sb3 = sb2.toString();
            byte[] decode = Base64.decode(sb3.substring(sb3.indexOf("<KID>") + 5, sb3.indexOf("</KID>")), 0);
            t(decode, 0, 3);
            t(decode, 1, 2);
            t(decode, 4, 5);
            t(decode, 6, 7);
            return decode;
        }

        public static String s(String str) {
            return (str.charAt(0) == '{' && str.charAt(str.length() - 1) == '}') ? str.substring(1, str.length() - 1) : str;
        }

        public static void t(byte[] bArr, int i10, int i11) {
            byte b4 = bArr[i10];
            bArr[i10] = bArr[i11];
            bArr[i11] = b4;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object b() {
            UUID uuid = this.f22075f;
            return new a.C0205a(uuid, k.a(uuid, this.f22076g), q(this.f22076g));
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public boolean d(String str) {
            return "ProtectionHeader".equals(str);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void h(XmlPullParser xmlPullParser) {
            if ("ProtectionHeader".equals(xmlPullParser.getName())) {
                this.f22074e = false;
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void n(XmlPullParser xmlPullParser) {
            if ("ProtectionHeader".equals(xmlPullParser.getName())) {
                this.f22074e = true;
                this.f22075f = UUID.fromString(s(xmlPullParser.getAttributeValue(null, "SystemID")));
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void o(XmlPullParser xmlPullParser) {
            if (this.f22074e) {
                this.f22076g = Base64.decode(xmlPullParser.getText(), 0);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class c extends a {

        /* renamed from: e, reason: collision with root package name */
        public Format f22077e;

        public c(a aVar, String str) {
            super(aVar, str, "QualityLevel");
        }

        public static List<byte[]> q(String str) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                byte[] I = j0.I(str);
                byte[][] i10 = com.google.android.exoplayer2.util.c.i(I);
                if (i10 == null) {
                    arrayList.add(I);
                } else {
                    Collections.addAll(arrayList, i10);
                }
            }
            return arrayList;
        }

        @Nullable
        public static String r(String str) {
            if (str.equalsIgnoreCase("H264") || str.equalsIgnoreCase("X264") || str.equalsIgnoreCase("AVC1") || str.equalsIgnoreCase("DAVC")) {
                return ah.f2598d;
            }
            if (str.equalsIgnoreCase("AAC") || str.equalsIgnoreCase("AACL") || str.equalsIgnoreCase("AACH") || str.equalsIgnoreCase("AACP")) {
                return "audio/mp4a-latm";
            }
            if (str.equalsIgnoreCase("TTML") || str.equalsIgnoreCase("DFXP")) {
                return "application/ttml+xml";
            }
            if (str.equalsIgnoreCase("ac-3") || str.equalsIgnoreCase("dac3")) {
                return "audio/ac3";
            }
            if (str.equalsIgnoreCase("ec-3") || str.equalsIgnoreCase("dec3")) {
                return "audio/eac3";
            }
            if (str.equalsIgnoreCase("dtsc")) {
                return "audio/vnd.dts";
            }
            if (str.equalsIgnoreCase("dtsh") || str.equalsIgnoreCase("dtsl")) {
                return "audio/vnd.dts.hd";
            }
            if (str.equalsIgnoreCase("dtse")) {
                return "audio/vnd.dts.hd;profile=lbr";
            }
            if (str.equalsIgnoreCase("opus")) {
                return "audio/opus";
            }
            return null;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object b() {
            return this.f22077e;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void n(XmlPullParser xmlPullParser) throws ParserException {
            Format.b bVar = new Format.b();
            String r10 = r(m(xmlPullParser, "FourCC"));
            int intValue = ((Integer) c("Type")).intValue();
            if (intValue == 2) {
                bVar.K(bb.Code).j0(k(xmlPullParser, "MaxWidth")).Q(k(xmlPullParser, "MaxHeight")).T(q(xmlPullParser.getAttributeValue(null, "CodecPrivateData")));
            } else if (intValue == 1) {
                if (r10 == null) {
                    r10 = "audio/mp4a-latm";
                }
                int k10 = k(xmlPullParser, "Channels");
                int k11 = k(xmlPullParser, "SamplingRate");
                List<byte[]> q10 = q(xmlPullParser.getAttributeValue(null, "CodecPrivateData"));
                if (q10.isEmpty() && "audio/mp4a-latm".equals(r10)) {
                    q10 = Collections.singletonList(x4.a.a(k11, k10));
                }
                bVar.K("audio/mp4").H(k10).f0(k11).T(q10);
            } else if (intValue == 3) {
                int i10 = 0;
                String str = (String) c("Subtype");
                if (str != null) {
                    if (str.equals("CAPT")) {
                        i10 = 64;
                    } else if (str.equals("DESC")) {
                        i10 = 1024;
                    }
                }
                bVar.K("application/mp4").c0(i10);
            } else {
                bVar.K("application/mp4");
            }
            this.f22077e = bVar.S(xmlPullParser.getAttributeValue(null, "Index")).U((String) c("Name")).e0(r10).G(k(xmlPullParser, "Bitrate")).V((String) c("Language")).E();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class d extends a {

        /* renamed from: e, reason: collision with root package name */
        public final List<a.b> f22078e;

        /* renamed from: f, reason: collision with root package name */
        public int f22079f;

        /* renamed from: g, reason: collision with root package name */
        public int f22080g;

        /* renamed from: h, reason: collision with root package name */
        public long f22081h;

        /* renamed from: i, reason: collision with root package name */
        public long f22082i;

        /* renamed from: j, reason: collision with root package name */
        public long f22083j;

        /* renamed from: k, reason: collision with root package name */
        public int f22084k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f22085l;

        /* renamed from: m, reason: collision with root package name */
        @Nullable
        public a.C0205a f22086m;

        public d(a aVar, String str) {
            super(aVar, str, "SmoothStreamingMedia");
            this.f22084k = -1;
            this.f22086m = null;
            this.f22078e = new LinkedList();
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void a(Object obj) {
            if (obj instanceof a.b) {
                this.f22078e.add((a.b) obj);
            } else if (obj instanceof a.C0205a) {
                com.google.android.exoplayer2.util.a.g(this.f22086m == null);
                this.f22086m = (a.C0205a) obj;
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object b() {
            int size = this.f22078e.size();
            a.b[] bVarArr = new a.b[size];
            this.f22078e.toArray(bVarArr);
            if (this.f22086m != null) {
                a.C0205a c0205a = this.f22086m;
                DrmInitData drmInitData = new DrmInitData(new DrmInitData.SchemeData(c0205a.f22109a, bb.Code, c0205a.f22110b));
                for (int i10 = 0; i10 < size; i10++) {
                    a.b bVar = bVarArr[i10];
                    int i11 = bVar.f22112a;
                    if (i11 == 2 || i11 == 1) {
                        Format[] formatArr = bVar.f22121j;
                        for (int i12 = 0; i12 < formatArr.length; i12++) {
                            formatArr[i12] = formatArr[i12].a().L(drmInitData).E();
                        }
                    }
                }
            }
            return new com.google.android.exoplayer2.source.smoothstreaming.manifest.a(this.f22079f, this.f22080g, this.f22081h, this.f22082i, this.f22083j, this.f22084k, this.f22085l, this.f22086m, bVarArr);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void n(XmlPullParser xmlPullParser) throws ParserException {
            this.f22079f = k(xmlPullParser, "MajorVersion");
            this.f22080g = k(xmlPullParser, "MinorVersion");
            this.f22081h = j(xmlPullParser, "TimeScale", 10000000L);
            this.f22082i = l(xmlPullParser, "Duration");
            this.f22083j = j(xmlPullParser, "DVRWindowLength", 0L);
            this.f22084k = i(xmlPullParser, "LookaheadCount", -1);
            this.f22085l = g(xmlPullParser, "IsLive", false);
            p("TimeScale", Long.valueOf(this.f22081h));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class e extends a {

        /* renamed from: e, reason: collision with root package name */
        public final String f22087e;

        /* renamed from: f, reason: collision with root package name */
        public final List<Format> f22088f;

        /* renamed from: g, reason: collision with root package name */
        public int f22089g;

        /* renamed from: h, reason: collision with root package name */
        public String f22090h;

        /* renamed from: i, reason: collision with root package name */
        public long f22091i;

        /* renamed from: j, reason: collision with root package name */
        public String f22092j;

        /* renamed from: k, reason: collision with root package name */
        public String f22093k;

        /* renamed from: l, reason: collision with root package name */
        public int f22094l;

        /* renamed from: m, reason: collision with root package name */
        public int f22095m;

        /* renamed from: n, reason: collision with root package name */
        public int f22096n;

        /* renamed from: o, reason: collision with root package name */
        public int f22097o;

        /* renamed from: p, reason: collision with root package name */
        public String f22098p;

        /* renamed from: q, reason: collision with root package name */
        public ArrayList<Long> f22099q;

        /* renamed from: r, reason: collision with root package name */
        public long f22100r;

        public e(a aVar, String str) {
            super(aVar, str, "StreamIndex");
            this.f22087e = str;
            this.f22088f = new LinkedList();
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void a(Object obj) {
            if (obj instanceof Format) {
                this.f22088f.add((Format) obj);
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object b() {
            Format[] formatArr = new Format[this.f22088f.size()];
            this.f22088f.toArray(formatArr);
            return new a.b(this.f22087e, this.f22093k, this.f22089g, this.f22090h, this.f22091i, this.f22092j, this.f22094l, this.f22095m, this.f22096n, this.f22097o, this.f22098p, formatArr, this.f22099q, this.f22100r);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public boolean d(String str) {
            return "c".equals(str);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void n(XmlPullParser xmlPullParser) throws ParserException {
            if ("c".equals(xmlPullParser.getName())) {
                r(xmlPullParser);
            } else {
                q(xmlPullParser);
            }
        }

        public final void q(XmlPullParser xmlPullParser) throws ParserException {
            int s2 = s(xmlPullParser);
            this.f22089g = s2;
            p("Type", Integer.valueOf(s2));
            if (this.f22089g == 3) {
                this.f22090h = m(xmlPullParser, "Subtype");
            } else {
                this.f22090h = xmlPullParser.getAttributeValue(null, "Subtype");
            }
            p("Subtype", this.f22090h);
            String attributeValue = xmlPullParser.getAttributeValue(null, "Name");
            this.f22092j = attributeValue;
            p("Name", attributeValue);
            this.f22093k = m(xmlPullParser, "Url");
            this.f22094l = i(xmlPullParser, "MaxWidth", -1);
            this.f22095m = i(xmlPullParser, "MaxHeight", -1);
            this.f22096n = i(xmlPullParser, "DisplayWidth", -1);
            this.f22097o = i(xmlPullParser, "DisplayHeight", -1);
            String attributeValue2 = xmlPullParser.getAttributeValue(null, "Language");
            this.f22098p = attributeValue2;
            p("Language", attributeValue2);
            long i10 = i(xmlPullParser, "TimeScale", -1);
            this.f22091i = i10;
            if (i10 == -1) {
                this.f22091i = ((Long) c("TimeScale")).longValue();
            }
            this.f22099q = new ArrayList<>();
        }

        public final void r(XmlPullParser xmlPullParser) throws ParserException {
            int size = this.f22099q.size();
            long j10 = j(xmlPullParser, "t", -9223372036854775807L);
            int i10 = 1;
            if (j10 == -9223372036854775807L) {
                if (size == 0) {
                    j10 = 0;
                } else if (this.f22100r != -1) {
                    j10 = this.f22099q.get(size - 1).longValue() + this.f22100r;
                } else {
                    throw ParserException.createForMalformedManifest("Unable to infer start time", null);
                }
            }
            this.f22099q.add(Long.valueOf(j10));
            this.f22100r = j(xmlPullParser, "d", -9223372036854775807L);
            long j11 = j(xmlPullParser, t.f36226k, 1L);
            if (j11 > 1 && this.f22100r == -9223372036854775807L) {
                throw ParserException.createForMalformedManifest("Repeated chunk with unspecified duration", null);
            }
            while (true) {
                long j12 = i10;
                if (j12 >= j11) {
                    return;
                }
                this.f22099q.add(Long.valueOf((this.f22100r * j12) + j10));
                i10++;
            }
        }

        public final int s(XmlPullParser xmlPullParser) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue(null, "Type");
            if (attributeValue != null) {
                if (PowerProfile.POWER_AUDIO.equalsIgnoreCase(attributeValue)) {
                    return 1;
                }
                if ("video".equalsIgnoreCase(attributeValue)) {
                    return 2;
                }
                if ("text".equalsIgnoreCase(attributeValue)) {
                    return 3;
                }
                StringBuilder sb2 = new StringBuilder(attributeValue.length() + 19);
                sb2.append("Invalid key value[");
                sb2.append(attributeValue);
                sb2.append("]");
                throw ParserException.createForMalformedManifest(sb2.toString(), null);
            }
            throw new MissingFieldException("Type");
        }
    }

    public SsManifestParser() {
        try {
            this.f22069a = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.i.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.google.android.exoplayer2.source.smoothstreaming.manifest.a a(Uri uri, InputStream inputStream) throws IOException {
        try {
            XmlPullParser newPullParser = this.f22069a.newPullParser();
            newPullParser.setInput(inputStream, null);
            return (com.google.android.exoplayer2.source.smoothstreaming.manifest.a) new d(null, uri.toString()).f(newPullParser);
        } catch (XmlPullParserException e2) {
            throw ParserException.createForMalformedManifest(null, e2);
        }
    }
}
