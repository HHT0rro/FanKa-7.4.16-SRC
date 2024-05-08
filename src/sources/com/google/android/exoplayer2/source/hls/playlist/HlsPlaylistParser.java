package com.google.android.exoplayer2.source.hls.playlist;

import a6.e;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.mp4.k;
import com.google.android.exoplayer2.h;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry;
import com.google.android.exoplayer2.source.hls.playlist.b;
import com.google.android.exoplayer2.source.hls.playlist.c;
import com.google.android.exoplayer2.upstream.i;
import com.google.android.exoplayer2.util.h0;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.util.q;
import com.google.common.collect.g0;
import com.huawei.hianalytics.core.greendao.EventDao;
import com.huawei.openalliance.ad.constant.bb;
import com.huawei.openalliance.ad.constant.u;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.TreeMap;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import sun.util.locale.LanguageTag;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class HlsPlaylistParser implements i.a<e> {

    /* renamed from: a, reason: collision with root package name */
    public final b f21636a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final c f21637b;

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f21612c = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f21613d = Pattern.compile("VIDEO=\"(.+?)\"");

    /* renamed from: e, reason: collision with root package name */
    public static final Pattern f21614e = Pattern.compile("AUDIO=\"(.+?)\"");

    /* renamed from: f, reason: collision with root package name */
    public static final Pattern f21615f = Pattern.compile("SUBTITLES=\"(.+?)\"");

    /* renamed from: g, reason: collision with root package name */
    public static final Pattern f21616g = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");

    /* renamed from: h, reason: collision with root package name */
    public static final Pattern f21617h = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");

    /* renamed from: i, reason: collision with root package name */
    public static final Pattern f21618i = Pattern.compile("CHANNELS=\"(.+?)\"");

    /* renamed from: j, reason: collision with root package name */
    public static final Pattern f21619j = Pattern.compile("CODECS=\"(.+?)\"");

    /* renamed from: k, reason: collision with root package name */
    public static final Pattern f21620k = Pattern.compile("RESOLUTION=(\\d+x\\d+)");

    /* renamed from: l, reason: collision with root package name */
    public static final Pattern f21621l = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");

    /* renamed from: m, reason: collision with root package name */
    public static final Pattern f21622m = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");

    /* renamed from: n, reason: collision with root package name */
    public static final Pattern f21623n = Pattern.compile("DURATION=([\\d\\.]+)\\b");

    /* renamed from: o, reason: collision with root package name */
    public static final Pattern f21624o = Pattern.compile("PART-TARGET=([\\d\\.]+)\\b");

    /* renamed from: p, reason: collision with root package name */
    public static final Pattern f21625p = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");

    /* renamed from: q, reason: collision with root package name */
    public static final Pattern f21626q = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");

    /* renamed from: r, reason: collision with root package name */
    public static final Pattern f21627r = Pattern.compile("CAN-SKIP-UNTIL=([\\d\\.]+)\\b");

    /* renamed from: s, reason: collision with root package name */
    public static final Pattern f21628s = c("CAN-SKIP-DATERANGES");

    /* renamed from: t, reason: collision with root package name */
    public static final Pattern f21629t = Pattern.compile("SKIPPED-SEGMENTS=(\\d+)\\b");

    /* renamed from: u, reason: collision with root package name */
    public static final Pattern f21630u = Pattern.compile("[:|,]HOLD-BACK=([\\d\\.]+)\\b");

    /* renamed from: v, reason: collision with root package name */
    public static final Pattern f21631v = Pattern.compile("PART-HOLD-BACK=([\\d\\.]+)\\b");

    /* renamed from: w, reason: collision with root package name */
    public static final Pattern f21632w = c("CAN-BLOCK-RELOAD");

    /* renamed from: x, reason: collision with root package name */
    public static final Pattern f21633x = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");

    /* renamed from: y, reason: collision with root package name */
    public static final Pattern f21634y = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");

    /* renamed from: z, reason: collision with root package name */
    public static final Pattern f21635z = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");
    public static final Pattern A = Pattern.compile("LAST-MSN=(\\d+)\\b");
    public static final Pattern B = Pattern.compile("LAST-PART=(\\d+)\\b");
    public static final Pattern C = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    public static final Pattern D = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    public static final Pattern E = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    public static final Pattern F = Pattern.compile("BYTERANGE-START=(\\d+)\\b");
    public static final Pattern G = Pattern.compile("BYTERANGE-LENGTH=(\\d+)\\b");
    public static final Pattern H = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");
    public static final Pattern I = Pattern.compile("KEYFORMAT=\"(.+?)\"");
    public static final Pattern J = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");
    public static final Pattern K = Pattern.compile("URI=\"(.+?)\"");
    public static final Pattern L = Pattern.compile("IV=([^,.*]+)");
    public static final Pattern M = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    public static final Pattern N = Pattern.compile("TYPE=(PART|MAP)");
    public static final Pattern O = Pattern.compile("LANGUAGE=\"(.+?)\"");
    public static final Pattern P = Pattern.compile("NAME=\"(.+?)\"");
    public static final Pattern Q = Pattern.compile("GROUP-ID=\"(.+?)\"");
    public static final Pattern R = Pattern.compile("CHARACTERISTICS=\"(.+?)\"");
    public static final Pattern S = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    public static final Pattern T = c("AUTOSELECT");
    public static final Pattern U = c("DEFAULT");
    public static final Pattern V = c("FORCED");
    public static final Pattern W = c("INDEPENDENT");
    public static final Pattern X = c("GAP");
    public static final Pattern Y = c("PRECISE");
    public static final Pattern Z = Pattern.compile("VALUE=\"(.+?)\"");

    /* renamed from: a0, reason: collision with root package name */
    public static final Pattern f21610a0 = Pattern.compile("IMPORT=\"(.+?)\"");

    /* renamed from: b0, reason: collision with root package name */
    public static final Pattern f21611b0 = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class DeltaUpdateException extends IOException {
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final BufferedReader f21638a;

        /* renamed from: b, reason: collision with root package name */
        public final Queue<String> f21639b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        public String f21640c;

        public a(Queue<String> queue, BufferedReader bufferedReader) {
            this.f21639b = queue;
            this.f21638a = bufferedReader;
        }

        public boolean a() throws IOException {
            String trim;
            if (this.f21640c != null) {
                return true;
            }
            if (!this.f21639b.isEmpty()) {
                this.f21640c = (String) com.google.android.exoplayer2.util.a.e(this.f21639b.poll());
                return true;
            }
            do {
                String readLine = this.f21638a.readLine();
                this.f21640c = readLine;
                if (readLine == null) {
                    return false;
                }
                trim = readLine.trim();
                this.f21640c = trim;
            } while (trim.isEmpty());
            return true;
        }

        public String b() throws IOException {
            if (a()) {
                String str = this.f21640c;
                this.f21640c = null;
                return str;
            }
            throw new NoSuchElementException();
        }
    }

    public HlsPlaylistParser() {
        this(b.f21669n, null);
    }

    public static String A(String str, Map<String, String> map) {
        Matcher matcher = f21611b0.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String group = matcher.group(1);
            if (map.containsKey(group)) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(map.get(group)));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public static int B(BufferedReader bufferedReader, boolean z10, int i10) throws IOException {
        while (i10 != -1 && Character.isWhitespace(i10) && (z10 || !j0.p0(i10))) {
            i10 = bufferedReader.read();
        }
        return i10;
    }

    public static boolean b(BufferedReader bufferedReader) throws IOException {
        int read = bufferedReader.read();
        if (read == 239) {
            if (bufferedReader.read() != 187 || bufferedReader.read() != 191) {
                return false;
            }
            read = bufferedReader.read();
        }
        int B2 = B(bufferedReader, true, read);
        for (int i10 = 0; i10 < 7; i10++) {
            if (B2 != "#EXTM3U".charAt(i10)) {
                return false;
            }
            B2 = bufferedReader.read();
        }
        return j0.p0(B(bufferedReader, false, B2));
    }

    public static Pattern c(String str) {
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 9);
        sb2.append(str);
        sb2.append("=(");
        sb2.append("NO");
        sb2.append("|");
        sb2.append("YES");
        sb2.append(")");
        return Pattern.compile(sb2.toString());
    }

    public static DrmInitData d(@Nullable String str, DrmInitData.SchemeData[] schemeDataArr) {
        DrmInitData.SchemeData[] schemeDataArr2 = new DrmInitData.SchemeData[schemeDataArr.length];
        for (int i10 = 0; i10 < schemeDataArr.length; i10++) {
            schemeDataArr2[i10] = schemeDataArr[i10].copyWithData(null);
        }
        return new DrmInitData(str, schemeDataArr2);
    }

    @Nullable
    public static String e(long j10, @Nullable String str, @Nullable String str2) {
        if (str == null) {
            return null;
        }
        return str2 != null ? str2 : Long.toHexString(j10);
    }

    @Nullable
    public static b.C0198b f(ArrayList<b.C0198b> arrayList, String str) {
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            b.C0198b c0198b = arrayList.get(i10);
            if (str.equals(c0198b.f21687d)) {
                return c0198b;
            }
        }
        return null;
    }

    @Nullable
    public static b.C0198b g(ArrayList<b.C0198b> arrayList, String str) {
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            b.C0198b c0198b = arrayList.get(i10);
            if (str.equals(c0198b.f21688e)) {
                return c0198b;
            }
        }
        return null;
    }

    @Nullable
    public static b.C0198b h(ArrayList<b.C0198b> arrayList, String str) {
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            b.C0198b c0198b = arrayList.get(i10);
            if (str.equals(c0198b.f21686c)) {
                return c0198b;
            }
        }
        return null;
    }

    public static double j(String str, Pattern pattern) throws ParserException {
        return Double.parseDouble(z(str, pattern, Collections.emptyMap()));
    }

    @Nullable
    public static DrmInitData.SchemeData k(String str, String str2, Map<String, String> map) throws ParserException {
        String u10 = u(str, J, "1", map);
        if ("urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed".equals(str2)) {
            String z10 = z(str, K, map);
            return new DrmInitData.SchemeData(h.f20707d, bb.Code, Base64.decode(z10.substring(z10.indexOf(44)), 0));
        }
        if ("com.widevine".equals(str2)) {
            return new DrmInitData.SchemeData(h.f20707d, "hls", j0.i0(str));
        }
        if (!"com.microsoft.playready".equals(str2) || !"1".equals(u10)) {
            return null;
        }
        String z11 = z(str, K, map);
        byte[] decode = Base64.decode(z11.substring(z11.indexOf(44)), 0);
        UUID uuid = h.f20708e;
        return new DrmInitData.SchemeData(uuid, bb.Code, k.a(uuid, decode));
    }

    public static String l(String str) {
        return ("SAMPLE-AES-CENC".equals(str) || "SAMPLE-AES-CTR".equals(str)) ? "cenc" : "cbcs";
    }

    public static int m(String str, Pattern pattern) throws ParserException {
        return Integer.parseInt(z(str, pattern, Collections.emptyMap()));
    }

    public static long n(String str, Pattern pattern) throws ParserException {
        return Long.parseLong(z(str, pattern, Collections.emptyMap()));
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:85:0x036a. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.List] */
    public static b o(a aVar, String str) throws IOException {
        char c4;
        Format format;
        ArrayList arrayList;
        ArrayList arrayList2;
        String str2;
        ArrayList arrayList3;
        int parseInt;
        String str3;
        String str4;
        boolean z10;
        int i10;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        ArrayList arrayList7;
        int i11;
        int i12;
        ArrayList arrayList8;
        ArrayList arrayList9;
        float f10;
        ArrayList arrayList10;
        Uri e2;
        HashMap hashMap;
        int i13;
        String str5 = str;
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        ArrayList arrayList11 = new ArrayList();
        ArrayList arrayList12 = new ArrayList();
        ArrayList arrayList13 = new ArrayList();
        ArrayList arrayList14 = new ArrayList();
        ArrayList arrayList15 = new ArrayList();
        ArrayList arrayList16 = new ArrayList();
        ArrayList arrayList17 = new ArrayList();
        ArrayList arrayList18 = new ArrayList();
        boolean z11 = false;
        boolean z12 = false;
        while (true) {
            String str6 = "application/x-mpegURL";
            if (aVar.a()) {
                String b4 = aVar.b();
                if (b4.startsWith("#EXT")) {
                    arrayList18.add(b4);
                }
                boolean startsWith = b4.startsWith("#EXT-X-I-FRAME-STREAM-INF");
                boolean z13 = z11;
                if (b4.startsWith("#EXT-X-DEFINE")) {
                    hashMap3.put(z(b4, P, hashMap3), z(b4, Z, hashMap3));
                } else {
                    if (b4.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                        hashMap = hashMap2;
                        arrayList10 = arrayList16;
                        arrayList9 = arrayList12;
                        arrayList8 = arrayList13;
                        arrayList7 = arrayList14;
                        arrayList5 = arrayList15;
                        arrayList6 = arrayList18;
                        arrayList4 = arrayList17;
                        z11 = true;
                    } else if (b4.startsWith("#EXT-X-MEDIA")) {
                        arrayList16.add(b4);
                    } else if (b4.startsWith("#EXT-X-SESSION-KEY")) {
                        DrmInitData.SchemeData k10 = k(b4, u(b4, I, "identity", hashMap3), hashMap3);
                        if (k10 != null) {
                            arrayList17.add(new DrmInitData(l(z(b4, H, hashMap3)), k10));
                        }
                    } else if (b4.startsWith("#EXT-X-STREAM-INF") || startsWith) {
                        boolean contains = z12 | b4.contains("CLOSED-CAPTIONS=NONE");
                        if (startsWith) {
                            i10 = 16384;
                            z10 = contains;
                        } else {
                            z10 = contains;
                            i10 = 0;
                        }
                        int m10 = m(b4, f21617h);
                        arrayList4 = arrayList17;
                        arrayList5 = arrayList15;
                        int s2 = s(b4, f21612c, -1);
                        String v2 = v(b4, f21619j, hashMap3);
                        arrayList6 = arrayList18;
                        String v10 = v(b4, f21620k, hashMap3);
                        if (v10 != null) {
                            arrayList7 = arrayList14;
                            String[] M0 = j0.M0(v10, LanguageTag.PRIVATEUSE);
                            int parseInt2 = Integer.parseInt(M0[0]);
                            int parseInt3 = Integer.parseInt(M0[1]);
                            if (parseInt2 <= 0 || parseInt3 <= 0) {
                                parseInt3 = -1;
                                i13 = -1;
                            } else {
                                i13 = parseInt2;
                            }
                            i12 = parseInt3;
                            i11 = i13;
                        } else {
                            arrayList7 = arrayList14;
                            i11 = -1;
                            i12 = -1;
                        }
                        arrayList8 = arrayList13;
                        String v11 = v(b4, f21621l, hashMap3);
                        if (v11 != null) {
                            arrayList9 = arrayList12;
                            f10 = Float.parseFloat(v11);
                        } else {
                            arrayList9 = arrayList12;
                            f10 = -1.0f;
                        }
                        String v12 = v(b4, f21613d, hashMap3);
                        arrayList10 = arrayList16;
                        String v13 = v(b4, f21614e, hashMap3);
                        HashMap hashMap4 = hashMap2;
                        String v14 = v(b4, f21615f, hashMap3);
                        String v15 = v(b4, f21616g, hashMap3);
                        if (startsWith) {
                            e2 = h0.e(str5, z(b4, K, hashMap3));
                        } else if (aVar.a()) {
                            e2 = h0.e(str5, A(aVar.b(), hashMap3));
                        } else {
                            throw ParserException.createForMalformedManifest("#EXT-X-STREAM-INF must be followed by another line", null);
                        }
                        arrayList11.add(new b.C0198b(e2, new Format.b().R(arrayList11.size()).K("application/x-mpegURL").I(v2).G(s2).Z(m10).j0(i11).Q(i12).P(f10).c0(i10).E(), v12, v13, v14, v15));
                        hashMap = hashMap4;
                        ArrayList arrayList19 = (ArrayList) hashMap.get(e2);
                        if (arrayList19 == null) {
                            arrayList19 = new ArrayList();
                            hashMap.put(e2, arrayList19);
                        }
                        arrayList19.add(new HlsTrackMetadataEntry.VariantInfo(s2, m10, v12, v13, v14, v15));
                        z11 = z13;
                        z12 = z10;
                    }
                    hashMap2 = hashMap;
                    arrayList17 = arrayList4;
                    arrayList15 = arrayList5;
                    arrayList18 = arrayList6;
                    arrayList14 = arrayList7;
                    arrayList13 = arrayList8;
                    arrayList12 = arrayList9;
                    arrayList16 = arrayList10;
                    str5 = str;
                }
                hashMap = hashMap2;
                arrayList10 = arrayList16;
                arrayList9 = arrayList12;
                arrayList8 = arrayList13;
                arrayList7 = arrayList14;
                arrayList5 = arrayList15;
                arrayList6 = arrayList18;
                arrayList4 = arrayList17;
                z11 = z13;
                hashMap2 = hashMap;
                arrayList17 = arrayList4;
                arrayList15 = arrayList5;
                arrayList18 = arrayList6;
                arrayList14 = arrayList7;
                arrayList13 = arrayList8;
                arrayList12 = arrayList9;
                arrayList16 = arrayList10;
                str5 = str;
            } else {
                HashMap hashMap5 = hashMap2;
                ArrayList arrayList20 = arrayList16;
                ArrayList arrayList21 = arrayList12;
                ArrayList arrayList22 = arrayList13;
                ArrayList arrayList23 = arrayList14;
                ArrayList arrayList24 = arrayList15;
                ArrayList arrayList25 = arrayList18;
                boolean z14 = z11;
                ArrayList arrayList26 = arrayList17;
                ArrayList arrayList27 = new ArrayList();
                HashSet hashSet = new HashSet();
                for (int i14 = 0; i14 < arrayList11.size(); i14++) {
                    b.C0198b c0198b = (b.C0198b) arrayList11.get(i14);
                    if (hashSet.add(c0198b.f21684a)) {
                        com.google.android.exoplayer2.util.a.g(c0198b.f21685b.f19542k == null);
                        arrayList27.add(c0198b.a(c0198b.f21685b.a().X(new Metadata(new HlsTrackMetadataEntry(null, null, (List) com.google.android.exoplayer2.util.a.e((ArrayList) hashMap5.get(c0198b.f21684a))))).E()));
                    }
                }
                Uri uri = null;
                ArrayList arrayList28 = null;
                Format format2 = null;
                int i15 = 0;
                while (i15 < arrayList20.size()) {
                    ArrayList arrayList29 = arrayList20;
                    String str7 = (String) arrayList29.get(i15);
                    String z15 = z(str7, Q, hashMap3);
                    String z16 = z(str7, P, hashMap3);
                    Format.b bVar = new Format.b();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(z15).length() + 1 + String.valueOf(z16).length());
                    sb2.append(z15);
                    sb2.append(u.bD);
                    sb2.append(z16);
                    Format.b V2 = bVar.S(sb2.toString()).U(z16).K(str6).g0(x(str7)).c0(w(str7, hashMap3)).V(v(str7, O, hashMap3));
                    String v16 = v(str7, K, hashMap3);
                    Uri e10 = v16 == null ? uri : h0.e(str, v16);
                    arrayList20 = arrayList29;
                    String str8 = str6;
                    Metadata metadata = new Metadata(new HlsTrackMetadataEntry(z15, z16, Collections.emptyList()));
                    String z17 = z(str7, M, hashMap3);
                    z17.hashCode();
                    switch (z17.hashCode()) {
                        case -959297733:
                            if (z17.equals("SUBTITLES")) {
                                c4 = 0;
                                break;
                            }
                            break;
                        case -333210994:
                            if (z17.equals("CLOSED-CAPTIONS")) {
                                c4 = 1;
                                break;
                            }
                            break;
                        case 62628790:
                            if (z17.equals("AUDIO")) {
                                c4 = 2;
                                break;
                            }
                            break;
                        case 81665115:
                            if (z17.equals("VIDEO")) {
                                c4 = 3;
                                break;
                            }
                            break;
                    }
                    c4 = 65535;
                    switch (c4) {
                        case 0:
                            format = format2;
                            arrayList = arrayList22;
                            arrayList2 = arrayList21;
                            b.C0198b g3 = g(arrayList11, z15);
                            if (g3 != null) {
                                String K2 = j0.K(g3.f21685b.f19541j, 3);
                                V2.I(K2);
                                str2 = q.g(K2);
                            } else {
                                str2 = null;
                            }
                            if (str2 == null) {
                                str2 = "text/vtt";
                            }
                            V2.e0(str2).X(metadata);
                            if (e10 != null) {
                                b.a aVar2 = new b.a(e10, V2.E(), z15, z16);
                                arrayList3 = arrayList23;
                                arrayList3.add(aVar2);
                                break;
                            } else {
                                arrayList3 = arrayList23;
                                m.h("HlsPlaylistParser", "EXT-X-MEDIA tag with missing mandatory URI attribute: skipping");
                                break;
                            }
                        case 1:
                            format = format2;
                            arrayList = arrayList22;
                            arrayList2 = arrayList21;
                            String z18 = z(str7, S, hashMap3);
                            if (z18.startsWith("CC")) {
                                parseInt = Integer.parseInt(z18.substring(2));
                                str3 = "application/cea-608";
                            } else {
                                parseInt = Integer.parseInt(z18.substring(7));
                                str3 = "application/cea-708";
                            }
                            if (arrayList28 == null) {
                                arrayList28 = new ArrayList();
                            }
                            V2.e0(str3).F(parseInt);
                            arrayList28.add(V2.E());
                            arrayList3 = arrayList23;
                            break;
                        case 2:
                            arrayList2 = arrayList21;
                            b.C0198b f11 = f(arrayList11, z15);
                            if (f11 != null) {
                                format = format2;
                                String K3 = j0.K(f11.f21685b.f19541j, 1);
                                V2.I(K3);
                                str4 = q.g(K3);
                            } else {
                                format = format2;
                                str4 = null;
                            }
                            String v17 = v(str7, f21618i, hashMap3);
                            if (v17 != null) {
                                V2.H(Integer.parseInt(j0.N0(v17, "/")[0]));
                                if ("audio/eac3".equals(str4) && v17.endsWith("/JOC")) {
                                    V2.I("ec+3");
                                    str4 = "audio/eac3-joc";
                                }
                            }
                            V2.e0(str4);
                            if (e10 != null) {
                                V2.X(metadata);
                                arrayList = arrayList22;
                                arrayList.add(new b.a(e10, V2.E(), z15, z16));
                            } else {
                                arrayList = arrayList22;
                                if (f11 != null) {
                                    format = V2.E();
                                }
                            }
                            arrayList3 = arrayList23;
                            break;
                        case 3:
                            b.C0198b h10 = h(arrayList11, z15);
                            if (h10 != null) {
                                Format format3 = h10.f21685b;
                                String K4 = j0.K(format3.f19541j, 2);
                                V2.I(K4).e0(q.g(K4)).j0(format3.f19549r).Q(format3.f19550s).P(format3.f19551t);
                            }
                            if (e10 != null) {
                                V2.X(metadata);
                                arrayList2 = arrayList21;
                                arrayList2.add(new b.a(e10, V2.E(), z15, z16));
                                format = format2;
                                arrayList3 = arrayList23;
                                arrayList = arrayList22;
                                break;
                            }
                        default:
                            format = format2;
                            arrayList3 = arrayList23;
                            arrayList = arrayList22;
                            arrayList2 = arrayList21;
                            break;
                    }
                    i15++;
                    arrayList23 = arrayList3;
                    arrayList22 = arrayList;
                    arrayList21 = arrayList2;
                    str6 = str8;
                    format2 = format;
                    uri = null;
                }
                return new b(str, arrayList25, arrayList27, arrayList21, arrayList22, arrayList23, arrayList24, format2, z12 ? Collections.emptyList() : arrayList28, z14, hashMap3, arrayList26);
            }
        }
    }

    public static c p(b bVar, @Nullable c cVar, a aVar, String str) throws IOException {
        ArrayList arrayList;
        boolean z10;
        ArrayList arrayList2;
        String str2;
        String str3;
        c.b bVar2;
        long j10;
        HashMap hashMap;
        String str4;
        String str5;
        String str6;
        long j11;
        String str7;
        long j12;
        long j13;
        c.d dVar;
        DrmInitData drmInitData;
        b bVar3 = bVar;
        c cVar2 = cVar;
        boolean z11 = bVar3.f713c;
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        HashMap hashMap4 = new HashMap();
        ArrayList arrayList5 = new ArrayList();
        c.f fVar = new c.f(-9223372036854775807L, false, -9223372036854775807L, -9223372036854775807L, false);
        TreeMap treeMap = new TreeMap();
        String str8 = "";
        boolean z12 = z11;
        c.f fVar2 = fVar;
        String str9 = "";
        long j14 = 0;
        long j15 = 0;
        long j16 = 0;
        long j17 = 0;
        long j18 = 0;
        long j19 = 0;
        long j20 = 0;
        long j21 = 0;
        boolean z13 = false;
        int i10 = 0;
        long j22 = -9223372036854775807L;
        boolean z14 = false;
        int i11 = 0;
        int i12 = 1;
        long j23 = -9223372036854775807L;
        long j24 = -9223372036854775807L;
        boolean z15 = false;
        DrmInitData drmInitData2 = null;
        DrmInitData drmInitData3 = null;
        boolean z16 = false;
        c.b bVar4 = null;
        String str10 = null;
        long j25 = -1;
        String str11 = null;
        String str12 = null;
        int i13 = 0;
        boolean z17 = false;
        c.d dVar2 = null;
        while (aVar.a()) {
            String b4 = aVar.b();
            if (b4.startsWith("#EXT")) {
                arrayList5.add(b4);
            }
            if (b4.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                String z18 = z(b4, f21626q, hashMap2);
                if ("VOD".equals(z18)) {
                    i10 = 1;
                } else if (EventDao.TABLENAME.equals(z18)) {
                    i10 = 2;
                }
            } else if (b4.equals("#EXT-X-I-FRAMES-ONLY")) {
                z17 = true;
            } else if (b4.startsWith("#EXT-X-START")) {
                long j26 = (long) (j(b4, C) * 1000000.0d);
                z13 = q(b4, Y, false);
                j22 = j26;
            } else if (b4.startsWith("#EXT-X-SERVER-CONTROL")) {
                fVar2 = y(b4);
            } else if (b4.startsWith("#EXT-X-PART-INF")) {
                j24 = (long) (j(b4, f21624o) * 1000000.0d);
            } else if (b4.startsWith("#EXT-X-MAP")) {
                String z19 = z(b4, K, hashMap2);
                String v2 = v(b4, E, hashMap2);
                if (v2 != null) {
                    String[] M0 = j0.M0(v2, "@");
                    j25 = Long.parseLong(M0[0]);
                    if (M0.length > 1) {
                        j16 = Long.parseLong(M0[1]);
                    }
                }
                if (j25 == -1) {
                    j16 = 0;
                }
                String str13 = str10;
                String str14 = str11;
                if (str13 != null && str14 == null) {
                    throw ParserException.createForMalformedManifest("The encryption IV attribute must be present when an initialization segment is encrypted with METHOD=AES-128.", null);
                }
                dVar2 = new c.d(z19, j16, j25, str13, str14);
                if (j25 != -1) {
                    j16 += j25;
                }
                str10 = str13;
                str11 = str14;
                j25 = -1;
            } else {
                String str15 = str10;
                String str16 = str11;
                boolean z20 = z13;
                if (b4.startsWith("#EXT-X-TARGETDURATION")) {
                    j23 = 1000000 * m(b4, f21622m);
                } else if (b4.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                    j19 = n(b4, f21633x);
                    str11 = str16;
                    z13 = z20;
                    j15 = j19;
                    str10 = str15;
                } else if (b4.startsWith("#EXT-X-VERSION")) {
                    i12 = m(b4, f21625p);
                } else {
                    if (b4.startsWith("#EXT-X-DEFINE")) {
                        String v10 = v(b4, f21610a0, hashMap2);
                        if (v10 != null) {
                            String str17 = bVar3.f21678l.get(v10);
                            if (str17 != null) {
                                hashMap2.put(v10, str17);
                            }
                        } else {
                            hashMap2.put(z(b4, P, hashMap2), z(b4, Z, hashMap2));
                        }
                        arrayList2 = arrayList5;
                        str2 = str8;
                        str3 = str15;
                        bVar2 = bVar4;
                        j10 = j19;
                        hashMap = hashMap4;
                        str4 = str12;
                    } else {
                        if (b4.startsWith("#EXTINF")) {
                            double j27 = j(b4, f21634y);
                            str5 = str15;
                            str9 = u(b4, f21635z, str8, hashMap2);
                            bVar3 = bVar;
                            j20 = (long) (j27 * 1000000.0d);
                            str11 = str16;
                        } else {
                            str5 = str15;
                            if (b4.startsWith("#EXT-X-SKIP")) {
                                int m10 = m(b4, f21629t);
                                com.google.android.exoplayer2.util.a.g(cVar2 != null && arrayList3.isEmpty());
                                int i14 = (int) (j15 - ((c) j0.j(cVar)).f21697k);
                                int i15 = m10 + i14;
                                if (i14 < 0 || i15 > cVar2.f21704r.size()) {
                                    throw new DeltaUpdateException();
                                }
                                str11 = str16;
                                long j28 = j18;
                                while (i14 < i15) {
                                    c.d dVar3 = cVar2.f21704r.get(i14);
                                    String str18 = str8;
                                    if (j15 != cVar2.f21697k) {
                                        dVar3 = dVar3.b(j28, (cVar2.f21696j - i11) + dVar3.f21719e);
                                    }
                                    arrayList3.add(dVar3);
                                    j28 += dVar3.f21718d;
                                    long j29 = dVar3.f21725k;
                                    int i16 = i15;
                                    if (j29 != -1) {
                                        j16 = dVar3.f21724j + j29;
                                    }
                                    int i17 = dVar3.f21719e;
                                    c.d dVar4 = dVar3.f21717c;
                                    DrmInitData drmInitData4 = dVar3.f21721g;
                                    String str19 = dVar3.f21722h;
                                    String str20 = dVar3.f21723i;
                                    if (str20 == null || !str20.equals(Long.toHexString(j19))) {
                                        str11 = dVar3.f21723i;
                                    }
                                    j19++;
                                    i14++;
                                    cVar2 = cVar;
                                    str5 = str19;
                                    j17 = j28;
                                    i13 = i17;
                                    i15 = i16;
                                    dVar2 = dVar4;
                                    drmInitData3 = drmInitData4;
                                    str8 = str18;
                                }
                                bVar3 = bVar;
                                cVar2 = cVar;
                                j18 = j28;
                            } else {
                                str2 = str8;
                                if (b4.startsWith("#EXT-X-KEY")) {
                                    String z21 = z(b4, H, hashMap2);
                                    String u10 = u(b4, I, "identity", hashMap2);
                                    if ("NONE".equals(z21)) {
                                        treeMap.clear();
                                        str6 = null;
                                        drmInitData3 = null;
                                        str11 = null;
                                    } else {
                                        String v11 = v(b4, L, hashMap2);
                                        if ("identity".equals(u10)) {
                                            if ("AES-128".equals(z21)) {
                                                str6 = z(b4, K, hashMap2);
                                                str11 = v11;
                                            }
                                            str11 = v11;
                                            str6 = null;
                                        } else {
                                            String str21 = str12;
                                            str12 = str21 == null ? l(z21) : str21;
                                            DrmInitData.SchemeData k10 = k(b4, u10, hashMap2);
                                            if (k10 != null) {
                                                treeMap.put(u10, k10);
                                                str11 = v11;
                                                str6 = null;
                                                drmInitData3 = null;
                                            }
                                            str11 = v11;
                                            str6 = null;
                                        }
                                    }
                                    cVar2 = cVar;
                                    z13 = z20;
                                    str8 = str2;
                                    str10 = str6;
                                } else {
                                    String str22 = str12;
                                    if (b4.startsWith("#EXT-X-BYTERANGE")) {
                                        String[] M02 = j0.M0(z(b4, D, hashMap2), "@");
                                        j25 = Long.parseLong(M02[0]);
                                        if (M02.length > 1) {
                                            j16 = Long.parseLong(M02[1]);
                                        }
                                    } else if (b4.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                                        i11 = Integer.parseInt(b4.substring(b4.indexOf(58) + 1));
                                        bVar3 = bVar;
                                        cVar2 = cVar;
                                        str12 = str22;
                                        str11 = str16;
                                        str8 = str2;
                                        z14 = true;
                                    } else if (b4.equals("#EXT-X-DISCONTINUITY")) {
                                        i13++;
                                    } else if (b4.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                                        if (j14 == 0) {
                                            j14 = h.d(j0.C0(b4.substring(b4.indexOf(58) + 1))) - j18;
                                        } else {
                                            str3 = str5;
                                            arrayList2 = arrayList5;
                                            j10 = j19;
                                            HashMap hashMap5 = hashMap4;
                                            str4 = str22;
                                            bVar2 = bVar4;
                                            hashMap = hashMap5;
                                        }
                                    } else if (b4.equals("#EXT-X-GAP")) {
                                        bVar3 = bVar;
                                        cVar2 = cVar;
                                        str12 = str22;
                                        str11 = str16;
                                        str8 = str2;
                                        z16 = true;
                                    } else if (b4.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                                        bVar3 = bVar;
                                        cVar2 = cVar;
                                        str12 = str22;
                                        str11 = str16;
                                        str8 = str2;
                                        z12 = true;
                                    } else if (b4.equals("#EXT-X-ENDLIST")) {
                                        bVar3 = bVar;
                                        cVar2 = cVar;
                                        str12 = str22;
                                        str11 = str16;
                                        str8 = str2;
                                        z15 = true;
                                    } else {
                                        if (b4.startsWith("#EXT-X-RENDITION-REPORT")) {
                                            str3 = str5;
                                            long t2 = t(b4, A, (j15 + arrayList3.size()) - (arrayList4.isEmpty() ? 1L : 0L));
                                            int s2 = s(b4, B, j24 != -9223372036854775807L ? (arrayList4.isEmpty() ? ((c.d) g0.f(arrayList3)).f21715n : arrayList4).size() - 1 : -1);
                                            Uri parse = Uri.parse(h0.d(str, z(b4, K, hashMap2)));
                                            hashMap4.put(parse, new c.C0199c(parse, t2, s2));
                                            bVar2 = bVar4;
                                            j10 = j19;
                                            hashMap = hashMap4;
                                            str4 = str22;
                                        } else {
                                            str3 = str5;
                                            if (b4.startsWith("#EXT-X-PRELOAD-HINT")) {
                                                c.b bVar5 = bVar4;
                                                if (bVar5 == null && "PART".equals(z(b4, N, hashMap2))) {
                                                    String z22 = z(b4, K, hashMap2);
                                                    long t10 = t(b4, F, -1L);
                                                    HashMap hashMap6 = hashMap4;
                                                    long t11 = t(b4, G, -1L);
                                                    long j30 = j19;
                                                    String e2 = e(j30, str3, str16);
                                                    if (drmInitData3 != null || treeMap.isEmpty()) {
                                                        j11 = j30;
                                                        str7 = str22;
                                                    } else {
                                                        j11 = j30;
                                                        DrmInitData.SchemeData[] schemeDataArr = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                        str7 = str22;
                                                        DrmInitData drmInitData5 = new DrmInitData(str7, schemeDataArr);
                                                        if (drmInitData2 == null) {
                                                            drmInitData2 = d(str7, schemeDataArr);
                                                        }
                                                        drmInitData3 = drmInitData5;
                                                    }
                                                    if (t10 == -1 || t11 != -1) {
                                                        bVar5 = new c.b(z22, dVar2, 0L, i13, j17, drmInitData3, str3, e2, t10 != -1 ? t10 : 0L, t11, false, false, true);
                                                    }
                                                    cVar2 = cVar;
                                                    str11 = str16;
                                                    str12 = str7;
                                                    j19 = j11;
                                                    hashMap4 = hashMap6;
                                                    z13 = z20;
                                                    bVar4 = bVar5;
                                                    str10 = str3;
                                                    str8 = str2;
                                                } else {
                                                    bVar2 = bVar5;
                                                    hashMap = hashMap4;
                                                    str4 = str22;
                                                    j10 = j19;
                                                }
                                            } else {
                                                c.b bVar6 = bVar4;
                                                long j31 = j19;
                                                hashMap = hashMap4;
                                                str4 = str22;
                                                if (b4.startsWith("#EXT-X-PART")) {
                                                    String e10 = e(j31, str3, str16);
                                                    String z23 = z(b4, K, hashMap2);
                                                    bVar2 = bVar6;
                                                    long j32 = (long) (j(b4, f21623n) * 1000000.0d);
                                                    ArrayList arrayList6 = arrayList5;
                                                    boolean q10 = q(b4, W, false) | (z12 && arrayList4.isEmpty());
                                                    boolean q11 = q(b4, X, false);
                                                    String v12 = v(b4, E, hashMap2);
                                                    if (v12 != null) {
                                                        String[] M03 = j0.M0(v12, "@");
                                                        j12 = Long.parseLong(M03[0]);
                                                        if (M03.length > 1) {
                                                            j21 = Long.parseLong(M03[1]);
                                                        }
                                                    } else {
                                                        j12 = -1;
                                                    }
                                                    if (j12 == -1) {
                                                        j21 = 0;
                                                    }
                                                    if (drmInitData3 == null && !treeMap.isEmpty()) {
                                                        DrmInitData.SchemeData[] schemeDataArr2 = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                        DrmInitData drmInitData6 = new DrmInitData(str4, schemeDataArr2);
                                                        if (drmInitData2 == null) {
                                                            drmInitData2 = d(str4, schemeDataArr2);
                                                        }
                                                        drmInitData3 = drmInitData6;
                                                    }
                                                    arrayList4.add(new c.b(z23, dVar2, j32, i13, j17, drmInitData3, str3, e10, j21, j12, q11, q10, false));
                                                    j17 += j32;
                                                    if (j12 != -1) {
                                                        j21 += j12;
                                                    }
                                                    bVar3 = bVar;
                                                    cVar2 = cVar;
                                                    str12 = str4;
                                                    j19 = j31;
                                                    hashMap4 = hashMap;
                                                    z13 = z20;
                                                    arrayList5 = arrayList6;
                                                    str10 = str3;
                                                    bVar4 = bVar2;
                                                    str11 = str16;
                                                    str8 = str2;
                                                } else {
                                                    bVar2 = bVar6;
                                                    arrayList2 = arrayList5;
                                                    if (b4.startsWith("#")) {
                                                        j10 = j31;
                                                    } else {
                                                        String e11 = e(j31, str3, str16);
                                                        j19 = j31 + 1;
                                                        String A2 = A(b4, hashMap2);
                                                        c.d dVar5 = (c.d) hashMap3.get(A2);
                                                        if (j25 == -1) {
                                                            j13 = 0;
                                                        } else {
                                                            if (z17 && dVar2 == null && dVar5 == null) {
                                                                dVar5 = new c.d(A2, 0L, j16, null, null);
                                                                hashMap3.put(A2, dVar5);
                                                            }
                                                            j13 = j16;
                                                        }
                                                        if (drmInitData3 != null || treeMap.isEmpty()) {
                                                            dVar = dVar5;
                                                            drmInitData = drmInitData3;
                                                        } else {
                                                            dVar = dVar5;
                                                            DrmInitData.SchemeData[] schemeDataArr3 = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                            drmInitData = new DrmInitData(str4, schemeDataArr3);
                                                            if (drmInitData2 == null) {
                                                                drmInitData2 = d(str4, schemeDataArr3);
                                                            }
                                                        }
                                                        arrayList3.add(new c.d(A2, dVar2 != null ? dVar2 : dVar, str9, j20, i13, j18, drmInitData, str3, e11, j13, j25, z16, arrayList4));
                                                        j17 = j18 + j20;
                                                        arrayList4 = new ArrayList();
                                                        if (j25 != -1) {
                                                            j13 += j25;
                                                        }
                                                        j16 = j13;
                                                        bVar3 = bVar;
                                                        cVar2 = cVar;
                                                        drmInitData3 = drmInitData;
                                                        str12 = str4;
                                                        j20 = 0;
                                                        j18 = j17;
                                                        hashMap4 = hashMap;
                                                        z13 = z20;
                                                        arrayList5 = arrayList2;
                                                        str9 = str2;
                                                        z16 = false;
                                                        j25 = -1;
                                                        str10 = str3;
                                                        bVar4 = bVar2;
                                                        str11 = str16;
                                                        str8 = str9;
                                                    }
                                                }
                                            }
                                        }
                                        arrayList2 = arrayList5;
                                    }
                                    bVar3 = bVar;
                                    cVar2 = cVar;
                                    str12 = str22;
                                    str11 = str16;
                                    str8 = str2;
                                }
                                bVar3 = bVar;
                            }
                        }
                        str10 = str5;
                        z13 = z20;
                    }
                    j19 = j10;
                    str12 = str4;
                    hashMap4 = hashMap;
                    z13 = z20;
                    arrayList5 = arrayList2;
                    bVar3 = bVar;
                    cVar2 = cVar;
                    str10 = str3;
                    bVar4 = bVar2;
                    str11 = str16;
                    str8 = str2;
                }
                str11 = str16;
                z13 = z20;
                str10 = str15;
            }
        }
        boolean z24 = z13;
        ArrayList arrayList7 = arrayList5;
        c.b bVar7 = bVar4;
        HashMap hashMap7 = hashMap4;
        if (bVar7 != null) {
            arrayList4.add(bVar7);
        }
        if (j14 != 0) {
            arrayList = arrayList4;
            z10 = true;
        } else {
            arrayList = arrayList4;
            z10 = false;
        }
        return new c(i10, str, arrayList7, j22, z24, j14, z14, i11, j15, i12, j23, j24, z12, z15, z10, drmInitData2, arrayList3, arrayList, fVar2, hashMap7);
    }

    public static boolean q(String str, Pattern pattern, boolean z10) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? "YES".equals(matcher.group(1)) : z10;
    }

    public static double r(String str, Pattern pattern, double d10) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Double.parseDouble((String) com.google.android.exoplayer2.util.a.e(matcher.group(1))) : d10;
    }

    public static int s(String str, Pattern pattern, int i10) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher.group(1))) : i10;
    }

    public static long t(String str, Pattern pattern, long j10) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher.group(1))) : j10;
    }

    public static String u(String str, Pattern pattern, String str2, Map<String, String> map) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            str2 = (String) com.google.android.exoplayer2.util.a.e(matcher.group(1));
        }
        return (map.isEmpty() || str2 == null) ? str2 : A(str2, map);
    }

    @Nullable
    public static String v(String str, Pattern pattern, Map<String, String> map) {
        return u(str, pattern, null, map);
    }

    public static int w(String str, Map<String, String> map) {
        String v2 = v(str, R, map);
        if (TextUtils.isEmpty(v2)) {
            return 0;
        }
        String[] M0 = j0.M0(v2, ",");
        int i10 = j0.t(M0, "public.accessibility.describes-video") ? 512 : 0;
        if (j0.t(M0, "public.accessibility.transcribes-spoken-dialog")) {
            i10 |= 4096;
        }
        if (j0.t(M0, "public.accessibility.describes-music-and-sound")) {
            i10 |= 1024;
        }
        return j0.t(M0, "public.easy-to-read") ? i10 | 8192 : i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public static int x(String str) {
        boolean q10 = q(str, U, false);
        ?? r02 = q10;
        if (q(str, V, false)) {
            r02 = (q10 ? 1 : 0) | 2;
        }
        return q(str, T, false) ? r02 | 4 : r02;
    }

    public static c.f y(String str) {
        double r10 = r(str, f21627r, -9.223372036854776E18d);
        long j10 = r10 == -9.223372036854776E18d ? -9223372036854775807L : (long) (r10 * 1000000.0d);
        boolean q10 = q(str, f21628s, false);
        double r11 = r(str, f21630u, -9.223372036854776E18d);
        long j11 = r11 == -9.223372036854776E18d ? -9223372036854775807L : (long) (r11 * 1000000.0d);
        double r12 = r(str, f21631v, -9.223372036854776E18d);
        return new c.f(j10, q10, j11, r12 != -9.223372036854776E18d ? (long) (r12 * 1000000.0d) : -9223372036854775807L, q(str, f21632w, false));
    }

    public static String z(String str, Pattern pattern, Map<String, String> map) throws ParserException {
        String v2 = v(str, pattern, map);
        if (v2 != null) {
            return v2;
        }
        String pattern2 = pattern.pattern();
        StringBuilder sb2 = new StringBuilder(String.valueOf(pattern2).length() + 19 + String.valueOf(str).length());
        sb2.append("Couldn't match ");
        sb2.append(pattern2);
        sb2.append(" in ");
        sb2.append(str);
        throw ParserException.createForMalformedManifest(sb2.toString(), null);
    }

    @Override // com.google.android.exoplayer2.upstream.i.a
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public e a(Uri uri, InputStream inputStream) throws IOException {
        String trim;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayDeque arrayDeque = new ArrayDeque();
        try {
            if (b(bufferedReader)) {
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        trim = readLine.trim();
                        if (!trim.isEmpty()) {
                            if (trim.startsWith("#EXT-X-STREAM-INF")) {
                                arrayDeque.add(trim);
                                return o(new a(arrayDeque, bufferedReader), uri.toString());
                            }
                            if (trim.startsWith("#EXT-X-TARGETDURATION") || trim.startsWith("#EXT-X-MEDIA-SEQUENCE") || trim.startsWith("#EXTINF") || trim.startsWith("#EXT-X-KEY") || trim.startsWith("#EXT-X-BYTERANGE") || trim.equals("#EXT-X-DISCONTINUITY") || trim.equals("#EXT-X-DISCONTINUITY-SEQUENCE") || trim.equals("#EXT-X-ENDLIST")) {
                                break;
                            }
                            arrayDeque.add(trim);
                        }
                    } else {
                        j0.o(bufferedReader);
                        throw ParserException.createForMalformedManifest("Failed to parse the playlist, could not identify any tags.", null);
                    }
                }
                arrayDeque.add(trim);
                return p(this.f21636a, this.f21637b, new a(arrayDeque, bufferedReader), uri.toString());
            }
            throw ParserException.createForMalformedManifest("Input does not start with the #EXTM3U header.", null);
        } finally {
            j0.o(bufferedReader);
        }
    }

    public HlsPlaylistParser(b bVar, @Nullable c cVar) {
        this.f21636a = bVar;
        this.f21637b = cVar;
    }
}
