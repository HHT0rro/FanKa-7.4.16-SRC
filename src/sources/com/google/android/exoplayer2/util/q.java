package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.alibaba.security.biometrics.service.build.ah;
import com.android.internal.os.PowerProfile;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: MimeTypes.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public static final ArrayList<a> f23012a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f23013b = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");

    /* compiled from: MimeTypes.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f23014a;

        /* renamed from: b, reason: collision with root package name */
        public final String f23015b;

        /* renamed from: c, reason: collision with root package name */
        public final int f23016c;
    }

    /* compiled from: MimeTypes.java */
    @VisibleForTesting
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f23017a;

        /* renamed from: b, reason: collision with root package name */
        public final int f23018b;

        public b(int i10, int i11) {
            this.f23017a = i10;
            this.f23018b = i11;
        }
    }

    public static boolean a(@Nullable String str, @Nullable String str2) {
        b i10;
        int d10;
        if (str == null) {
            return false;
        }
        char c4 = 65535;
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals("audio/eac3-joc")) {
                    c4 = 0;
                    break;
                }
                break;
            case -432837260:
                if (str.equals("audio/mpeg-L1")) {
                    c4 = 1;
                    break;
                }
                break;
            case -432837259:
                if (str.equals("audio/mpeg-L2")) {
                    c4 = 2;
                    break;
                }
                break;
            case -53558318:
                if (str.equals("audio/mp4a-latm")) {
                    c4 = 3;
                    break;
                }
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                    c4 = 4;
                    break;
                }
                break;
            case 187094639:
                if (str.equals("audio/raw")) {
                    c4 = 5;
                    break;
                }
                break;
            case 1504578661:
                if (str.equals("audio/eac3")) {
                    c4 = 6;
                    break;
                }
                break;
            case 1504619009:
                if (str.equals("audio/flac")) {
                    c4 = 7;
                    break;
                }
                break;
            case 1504831518:
                if (str.equals("audio/mpeg")) {
                    c4 = '\b';
                    break;
                }
                break;
            case 1903231877:
                if (str.equals("audio/g711-alaw")) {
                    c4 = '\t';
                    break;
                }
                break;
            case 1903589369:
                if (str.equals("audio/g711-mlaw")) {
                    c4 = '\n';
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
            case 1:
            case 2:
            case 4:
            case 5:
            case 6:
            case 7:
            case '\b':
            case '\t':
            case '\n':
                return true;
            case 3:
                return (str2 == null || (i10 = i(str2)) == null || (d10 = x4.a.d(i10.f23018b)) == 0 || d10 == 16) ? false : true;
            default:
                return false;
        }
    }

    public static boolean b(@Nullable String str, String str2) {
        return d(str, str2) != null;
    }

    @Nullable
    public static String c(@Nullable String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : j0.O0(str)) {
            String g3 = g(str2);
            if (g3 != null && p(g3)) {
                return g3;
            }
        }
        return null;
    }

    @Nullable
    public static String d(@Nullable String str, @Nullable String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        String[] O0 = j0.O0(str);
        StringBuilder sb2 = new StringBuilder();
        for (String str3 : O0) {
            if (str2.equals(g(str3))) {
                if (sb2.length() > 0) {
                    sb2.append(",");
                }
                sb2.append(str3);
            }
        }
        if (sb2.length() > 0) {
            return sb2.toString();
        }
        return null;
    }

    @Nullable
    public static String e(String str) {
        int size = f23012a.size();
        for (int i10 = 0; i10 < size; i10++) {
            a aVar = f23012a.get(i10);
            if (str.startsWith(aVar.f23015b)) {
                return aVar.f23014a;
            }
        }
        return null;
    }

    public static int f(String str, @Nullable String str2) {
        b i10;
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals("audio/eac3-joc")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1095064472:
                if (str.equals("audio/vnd.dts")) {
                    c4 = 1;
                    break;
                }
                break;
            case -53558318:
                if (str.equals("audio/mp4a-latm")) {
                    c4 = 2;
                    break;
                }
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                    c4 = 3;
                    break;
                }
                break;
            case 187078297:
                if (str.equals("audio/ac4")) {
                    c4 = 4;
                    break;
                }
                break;
            case 1504578661:
                if (str.equals("audio/eac3")) {
                    c4 = 5;
                    break;
                }
                break;
            case 1504831518:
                if (str.equals("audio/mpeg")) {
                    c4 = 6;
                    break;
                }
                break;
            case 1505942594:
                if (str.equals("audio/vnd.dts.hd")) {
                    c4 = 7;
                    break;
                }
                break;
            case 1556697186:
                if (str.equals("audio/true-hd")) {
                    c4 = '\b';
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return 18;
            case 1:
                return 7;
            case 2:
                if (str2 == null || (i10 = i(str2)) == null) {
                    return 0;
                }
                return x4.a.d(i10.f23018b);
            case 3:
                return 5;
            case 4:
                return 17;
            case 5:
                return 6;
            case 6:
                return 9;
            case 7:
                return 8;
            case '\b':
                return 14;
            default:
                return 0;
        }
    }

    @Nullable
    public static String g(@Nullable String str) {
        b i10;
        String str2 = null;
        if (str == null) {
            return null;
        }
        String e2 = com.google.common.base.a.e(str.trim());
        if (e2.startsWith("avc1") || e2.startsWith("avc3")) {
            return ah.f2598d;
        }
        if (e2.startsWith("hev1") || e2.startsWith("hvc1")) {
            return "video/hevc";
        }
        if (e2.startsWith("dvav") || e2.startsWith("dva1") || e2.startsWith("dvhe") || e2.startsWith("dvh1")) {
            return "video/dolby-vision";
        }
        if (e2.startsWith("av01")) {
            return "video/av01";
        }
        if (e2.startsWith("vp9") || e2.startsWith("vp09")) {
            return "video/x-vnd.on2.vp9";
        }
        if (e2.startsWith("vp8") || e2.startsWith("vp08")) {
            return "video/x-vnd.on2.vp8";
        }
        if (!e2.startsWith("mp4a")) {
            return e2.startsWith("mha1") ? "audio/mha1" : e2.startsWith("mhm1") ? "audio/mhm1" : (e2.startsWith("ac-3") || e2.startsWith("dac3")) ? "audio/ac3" : (e2.startsWith("ec-3") || e2.startsWith("dec3")) ? "audio/eac3" : e2.startsWith("ec+3") ? "audio/eac3-joc" : (e2.startsWith("ac-4") || e2.startsWith("dac4")) ? "audio/ac4" : e2.startsWith("dtsc") ? "audio/vnd.dts" : e2.startsWith("dtse") ? "audio/vnd.dts.hd;profile=lbr" : (e2.startsWith("dtsh") || e2.startsWith("dtsl")) ? "audio/vnd.dts.hd" : e2.startsWith("dtsx") ? "audio/vnd.dts.uhd" : e2.startsWith("opus") ? "audio/opus" : e2.startsWith("vorbis") ? "audio/vorbis" : e2.startsWith("flac") ? "audio/flac" : e2.startsWith("stpp") ? "application/ttml+xml" : e2.startsWith("wvtt") ? "text/vtt" : e2.contains("cea708") ? "application/cea-708" : (e2.contains("eia608") || e2.contains("cea608")) ? "application/cea-608" : e(e2);
        }
        if (e2.startsWith("mp4a.") && (i10 = i(e2)) != null) {
            str2 = h(i10.f23017a);
        }
        return str2 == null ? "audio/mp4a-latm" : str2;
    }

    @Nullable
    public static String h(int i10) {
        if (i10 == 32) {
            return "video/mp4v-es";
        }
        if (i10 == 33) {
            return ah.f2598d;
        }
        if (i10 == 35) {
            return "video/hevc";
        }
        if (i10 == 64) {
            return "audio/mp4a-latm";
        }
        if (i10 == 163) {
            return "video/wvc1";
        }
        if (i10 == 177) {
            return "video/x-vnd.on2.vp9";
        }
        if (i10 == 165) {
            return "audio/ac3";
        }
        if (i10 == 166) {
            return "audio/eac3";
        }
        switch (i10) {
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
                return "video/mpeg2";
            case 102:
            case 103:
            case 104:
                return "audio/mp4a-latm";
            case 105:
            case 107:
                return "audio/mpeg";
            case 106:
                return "video/mpeg";
            default:
                switch (i10) {
                    case 169:
                    case 172:
                        return "audio/vnd.dts";
                    case 170:
                    case 171:
                        return "audio/vnd.dts.hd";
                    case 173:
                        return "audio/opus";
                    case 174:
                        return "audio/ac4";
                    default:
                        return null;
                }
        }
    }

    @Nullable
    @VisibleForTesting
    public static b i(String str) {
        Matcher matcher = f23013b.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String str2 = (String) com.google.android.exoplayer2.util.a.e(matcher.group(1));
        String group = matcher.group(2);
        try {
            return new b(Integer.parseInt(str2, 16), group != null ? Integer.parseInt(group) : 0);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @Nullable
    public static String j(@Nullable String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : j0.O0(str)) {
            String g3 = g(str2);
            if (g3 != null && r(g3)) {
                return g3;
            }
        }
        return null;
    }

    @Nullable
    public static String k(@Nullable String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, indexOf);
    }

    public static int l(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (p(str)) {
            return 1;
        }
        if (s(str)) {
            return 2;
        }
        if (r(str)) {
            return 3;
        }
        if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str)) {
            return 5;
        }
        if ("application/x-camera-motion".equals(str)) {
            return 6;
        }
        return m(str);
    }

    public static int m(String str) {
        int size = f23012a.size();
        for (int i10 = 0; i10 < size; i10++) {
            a aVar = f23012a.get(i10);
            if (str.equals(aVar.f23014a)) {
                return aVar.f23016c;
            }
        }
        return -1;
    }

    public static int n(String str) {
        return l(g(str));
    }

    @Nullable
    public static String o(@Nullable String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : j0.O0(str)) {
            String g3 = g(str2);
            if (g3 != null && s(g3)) {
                return g3;
            }
        }
        return null;
    }

    public static boolean p(@Nullable String str) {
        return PowerProfile.POWER_AUDIO.equals(k(str));
    }

    public static boolean q(@Nullable String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith("video/webm") || str.startsWith("audio/webm") || str.startsWith("application/webm") || str.startsWith("video/x-matroska") || str.startsWith("audio/x-matroska") || str.startsWith("application/x-matroska");
    }

    public static boolean r(@Nullable String str) {
        return "text".equals(k(str)) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str);
    }

    public static boolean s(@Nullable String str) {
        return "video".equals(k(str));
    }

    public static String t(String str) {
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1007807498:
                if (str.equals("audio/x-flac")) {
                    c4 = 0;
                    break;
                }
                break;
            case -586683234:
                if (str.equals("audio/x-wav")) {
                    c4 = 1;
                    break;
                }
                break;
            case 187090231:
                if (str.equals("audio/mp3")) {
                    c4 = 2;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return "audio/flac";
            case 1:
                return "audio/wav";
            case 2:
                return "audio/mpeg";
            default:
                return str;
        }
    }
}
