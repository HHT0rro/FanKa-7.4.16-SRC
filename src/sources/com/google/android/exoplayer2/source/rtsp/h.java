package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import androidx.annotation.Nullable;
import b6.v;
import b6.w;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.rtsp.e;
import com.google.android.exoplayer2.util.j0;
import com.google.common.base.s;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.i1;
import com.huawei.openalliance.ad.constant.u;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: RtspMessageUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f21993a = Pattern.compile("([A-Z_]+) (.*) RTSP/1\\.0");

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f21994b = Pattern.compile("RTSP/1\\.0 (\\d+) (.+)");

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f21995c = Pattern.compile("Content-Length:\\s?(\\d+)", 2);

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f21996d = Pattern.compile("([\\w$\\-_.+]+)(?:;\\s?timeout=(\\d+))?");

    /* renamed from: e, reason: collision with root package name */
    public static final Pattern f21997e = Pattern.compile("Digest realm=\"([^\"\\x00-\\x08\\x0A-\\x1f\\x7f]+)\",\\s?(?:domain=\"(.+)\",\\s?)?nonce=\"([^\"\\x00-\\x08\\x0A-\\x1f\\x7f]+)\"(?:,\\s?opaque=\"([^\"\\x00-\\x08\\x0A-\\x1f\\x7f]+)\")?");

    /* renamed from: f, reason: collision with root package name */
    public static final Pattern f21998f = Pattern.compile("Basic realm=\"([^\"\\x00-\\x08\\x0A-\\x1f\\x7f]+)\"");

    /* renamed from: g, reason: collision with root package name */
    public static final String f21999g = new String(new byte[]{10});

    /* renamed from: h, reason: collision with root package name */
    public static final String f22000h = new String(new byte[]{13, 10});

    /* compiled from: RtspMessageUtil.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f22001a;

        /* renamed from: b, reason: collision with root package name */
        public final String f22002b;

        public a(String str, String str2) {
            this.f22001a = str;
            this.f22002b = str2;
        }
    }

    /* compiled from: RtspMessageUtil.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f22003a;

        /* renamed from: b, reason: collision with root package name */
        public final long f22004b;

        public b(String str, long j10) {
            this.f22003a = str;
            this.f22004b = j10;
        }
    }

    public static byte[] a(List<String> list) {
        return com.google.common.base.i.h(f22000h).d(list).getBytes(g.f21974h);
    }

    public static byte[] b(String str) {
        return str.getBytes(g.f21974h);
    }

    public static boolean c(String str) {
        return f21993a.matcher(str).matches() || f21994b.matcher(str).matches();
    }

    public static long d(String str) throws ParserException {
        try {
            Matcher matcher = f21995c.matcher(str);
            if (matcher.find()) {
                return Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher.group(1)));
            }
            return -1L;
        } catch (NumberFormatException e2) {
            throw ParserException.createForMalformedManifest(str, e2);
        }
    }

    public static int e(String str) throws ParserException {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e2) {
            throw ParserException.createForMalformedManifest(str, e2);
        }
    }

    public static int f(String str) {
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1881579439:
                if (str.equals("RECORD")) {
                    c4 = 0;
                    break;
                }
                break;
            case -880847356:
                if (str.equals("TEARDOWN")) {
                    c4 = 1;
                    break;
                }
                break;
            case -702888512:
                if (str.equals("GET_PARAMETER")) {
                    c4 = 2;
                    break;
                }
                break;
            case -531492226:
                if (str.equals("OPTIONS")) {
                    c4 = 3;
                    break;
                }
                break;
            case -84360524:
                if (str.equals("PLAY_NOTIFY")) {
                    c4 = 4;
                    break;
                }
                break;
            case 2458420:
                if (str.equals("PLAY")) {
                    c4 = 5;
                    break;
                }
                break;
            case 6481884:
                if (str.equals("REDIRECT")) {
                    c4 = 6;
                    break;
                }
                break;
            case 71242700:
                if (str.equals("SET_PARAMETER")) {
                    c4 = 7;
                    break;
                }
                break;
            case 75902422:
                if (str.equals("PAUSE")) {
                    c4 = '\b';
                    break;
                }
                break;
            case 78791261:
                if (str.equals("SETUP")) {
                    c4 = '\t';
                    break;
                }
                break;
            case 133006441:
                if (str.equals("ANNOUNCE")) {
                    c4 = '\n';
                    break;
                }
                break;
            case 1800840907:
                if (str.equals("DESCRIBE")) {
                    c4 = 11;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return 8;
            case 1:
                return 12;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 7;
            case 5:
                return 6;
            case 6:
                return 9;
            case 7:
                return 11;
            case '\b':
                return 5;
            case '\t':
                return 10;
            case '\n':
                return 1;
            case 11:
                return 2;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static ImmutableList<Integer> g(@Nullable String str) {
        if (str == null) {
            return ImmutableList.of();
        }
        ImmutableList.a aVar = new ImmutableList.a();
        for (String str2 : j0.M0(str, ",\\s?")) {
            aVar.a(Integer.valueOf(f(str2)));
        }
        return aVar.k();
    }

    public static w h(List<String> list) {
        Matcher matcher = f21994b.matcher(list.get(0));
        com.google.android.exoplayer2.util.a.a(matcher.matches());
        int parseInt = Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher.group(1)));
        int indexOf = list.indexOf("");
        com.google.android.exoplayer2.util.a.a(indexOf > 0);
        return new w(parseInt, new e.b().c(list.subList(1, indexOf)).e(), com.google.common.base.i.h(f22000h).d(list.subList(indexOf + 1, list.size())));
    }

    public static b i(String str) throws ParserException {
        Matcher matcher = f21996d.matcher(str);
        if (matcher.matches()) {
            String str2 = (String) com.google.android.exoplayer2.util.a.e(matcher.group(1));
            long j10 = 60000;
            if (matcher.group(2) != null) {
                try {
                    j10 = Integer.parseInt(r0) * 1000;
                } catch (NumberFormatException e2) {
                    throw ParserException.createForMalformedManifest(str, e2);
                }
            }
            return new b(str2, j10);
        }
        throw ParserException.createForMalformedManifest(str, null);
    }

    @Nullable
    public static a j(Uri uri) {
        String userInfo = uri.getUserInfo();
        if (userInfo == null || !userInfo.contains(u.bD)) {
            return null;
        }
        String[] N0 = j0.N0(userInfo, u.bD);
        return new a(N0[0], N0[1]);
    }

    public static c k(String str) throws ParserException {
        Matcher matcher = f21997e.matcher(str);
        if (matcher.find()) {
            return new c(2, (String) com.google.android.exoplayer2.util.a.e(matcher.group(1)), (String) com.google.android.exoplayer2.util.a.e(matcher.group(3)), s.e(matcher.group(4)));
        }
        Matcher matcher2 = f21998f.matcher(str);
        if (matcher2.matches()) {
            return new c(1, (String) com.google.android.exoplayer2.util.a.e(matcher2.group(1)), "", "");
        }
        String valueOf = String.valueOf(str);
        throw ParserException.createForMalformedManifest(valueOf.length() != 0 ? "Invalid WWW-Authenticate header ".concat(valueOf) : new String("Invalid WWW-Authenticate header "), null);
    }

    public static Uri l(Uri uri) {
        if (uri.getUserInfo() == null) {
            return uri;
        }
        String str = (String) com.google.android.exoplayer2.util.a.e(uri.getAuthority());
        com.google.android.exoplayer2.util.a.a(str.contains("@"));
        return uri.buildUpon().encodedAuthority(j0.M0(str, "@")[1]).build();
    }

    public static ImmutableList<String> m(v vVar) {
        ImmutableList.a aVar = new ImmutableList.a();
        aVar.a(j0.D("%s %s %s", o(vVar.f1364b), vVar.f1363a, "RTSP/1.0"));
        ImmutableListMultimap<String, String> b4 = vVar.f1365c.b();
        i1<String> iterator2 = b4.keySet().iterator2();
        while (iterator2.hasNext()) {
            String next = iterator2.next();
            ImmutableList<String> immutableList = b4.get((ImmutableListMultimap<String, String>) next);
            for (int i10 = 0; i10 < immutableList.size(); i10++) {
                aVar.a(j0.D("%s: %s", next, immutableList.get(i10)));
            }
        }
        aVar.a("");
        aVar.a(vVar.f1366d);
        return aVar.k();
    }

    public static String[] n(String str) {
        String str2 = f22000h;
        if (!str.contains(str2)) {
            str2 = f21999g;
        }
        return j0.M0(str, str2);
    }

    public static String o(int i10) {
        switch (i10) {
            case 1:
                return "ANNOUNCE";
            case 2:
                return "DESCRIBE";
            case 3:
                return "GET_PARAMETER";
            case 4:
                return "OPTIONS";
            case 5:
                return "PAUSE";
            case 6:
                return "PLAY";
            case 7:
                return "PLAY_NOTIFY";
            case 8:
                return "RECORD";
            case 9:
                return "REDIRECT";
            case 10:
                return "SETUP";
            case 11:
                return "SET_PARAMETER";
            case 12:
                return "TEARDOWN";
            default:
                throw new IllegalStateException();
        }
    }
}
