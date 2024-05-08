package com.google.android.exoplayer2.mediacodec;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.util.q;
import sun.util.locale.LanguageTag;

/* compiled from: MediaCodecInfo.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f20832a;

    /* renamed from: b, reason: collision with root package name */
    public final String f20833b;

    /* renamed from: c, reason: collision with root package name */
    public final String f20834c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final MediaCodecInfo.CodecCapabilities f20835d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f20836e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f20837f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f20838g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f20839h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f20840i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f20841j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f20842k;

    @VisibleForTesting
    public c(String str, String str2, String str3, @Nullable MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        this.f20832a = (String) com.google.android.exoplayer2.util.a.e(str);
        this.f20833b = str2;
        this.f20834c = str3;
        this.f20835d = codecCapabilities;
        this.f20839h = z10;
        this.f20840i = z11;
        this.f20841j = z12;
        this.f20836e = z13;
        this.f20837f = z14;
        this.f20838g = z15;
        this.f20842k = q.s(str2);
    }

    public static c A(String str, String str2, String str3, @Nullable MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        return new c(str, str2, str3, codecCapabilities, z10, z11, z12, (z13 || codecCapabilities == null || !h(codecCapabilities) || y(str)) ? false : true, codecCapabilities != null && r(codecCapabilities), z14 || (codecCapabilities != null && p(codecCapabilities)));
    }

    public static int a(String str, String str2, int i10) {
        int i11;
        if (i10 > 1 || ((j0.f22990a >= 26 && i10 > 0) || "audio/mpeg".equals(str2) || "audio/3gpp".equals(str2) || "audio/amr-wb".equals(str2) || "audio/mp4a-latm".equals(str2) || "audio/vorbis".equals(str2) || "audio/opus".equals(str2) || "audio/raw".equals(str2) || "audio/flac".equals(str2) || "audio/g711-alaw".equals(str2) || "audio/g711-mlaw".equals(str2) || "audio/gsm".equals(str2))) {
            return i10;
        }
        if ("audio/ac3".equals(str2)) {
            i11 = 6;
        } else {
            i11 = "audio/eac3".equals(str2) ? 16 : 30;
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 59);
        sb2.append("AssumedMaxChannelAdjustment: ");
        sb2.append(str);
        sb2.append(", [");
        sb2.append(i10);
        sb2.append(" to ");
        sb2.append(i11);
        sb2.append("]");
        m.h("MediaCodecInfo", sb2.toString());
        return i11;
    }

    @RequiresApi(21)
    public static Point c(MediaCodecInfo.VideoCapabilities videoCapabilities, int i10, int i11) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(j0.l(i10, widthAlignment) * widthAlignment, j0.l(i11, heightAlignment) * heightAlignment);
    }

    @RequiresApi(21)
    public static boolean d(MediaCodecInfo.VideoCapabilities videoCapabilities, int i10, int i11, double d10) {
        Point c4 = c(videoCapabilities, i10, i11);
        int i12 = c4.x;
        int i13 = c4.y;
        if (d10 != -1.0d && d10 >= 1.0d) {
            return videoCapabilities.areSizeAndRateSupported(i12, i13, Math.floor(d10));
        }
        return videoCapabilities.isSizeSupported(i12, i13);
    }

    public static MediaCodecInfo.CodecProfileLevel[] f(@Nullable MediaCodecInfo.CodecCapabilities codecCapabilities) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        int intValue = (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) ? 0 : videoCapabilities.getBitrateRange().getUpper().intValue();
        int i10 = intValue >= 180000000 ? 1024 : intValue >= 120000000 ? 512 : intValue >= 60000000 ? 256 : intValue >= 30000000 ? 128 : intValue >= 18000000 ? 64 : intValue >= 12000000 ? 32 : intValue >= 7200000 ? 16 : intValue >= 3600000 ? 8 : intValue >= 1800000 ? 4 : intValue >= 800000 ? 2 : 1;
        MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
        codecProfileLevel.profile = 1;
        codecProfileLevel.level = i10;
        return new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel};
    }

    public static boolean h(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return j0.f22990a >= 19 && i(codecCapabilities);
    }

    @RequiresApi(19)
    public static boolean i(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    public static boolean p(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return j0.f22990a >= 21 && q(codecCapabilities);
    }

    @RequiresApi(21)
    public static boolean q(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    public static boolean r(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return j0.f22990a >= 21 && s(codecCapabilities);
    }

    @RequiresApi(21)
    public static boolean s(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    public static boolean w(String str) {
        return "audio/opus".equals(str);
    }

    public static boolean x(String str) {
        return j0.f22993d.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str);
    }

    public static boolean y(String str) {
        if (j0.f22990a <= 22) {
            String str2 = j0.f22993d;
            if (("ODROID-XU3".equals(str2) || "Nexus 10".equals(str2)) && ("OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str))) {
                return true;
            }
        }
        return false;
    }

    public static final boolean z(String str) {
        return ("OMX.MTK.VIDEO.DECODER.HEVC".equals(str) && "mcv5a".equals(j0.f22991b)) ? false : true;
    }

    @Nullable
    @RequiresApi(21)
    public Point b(int i10, int i11) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f20835d;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return c(videoCapabilities, i10, i11);
    }

    public DecoderReuseEvaluation e(Format format, Format format2) {
        int i10 = !j0.c(format.f19544m, format2.f19544m) ? 8 : 0;
        if (this.f20842k) {
            if (format.f19552u != format2.f19552u) {
                i10 |= 1024;
            }
            if (!this.f20836e && (format.f19549r != format2.f19549r || format.f19550s != format2.f19550s)) {
                i10 |= 512;
            }
            if (!j0.c(format.f19556y, format2.f19556y)) {
                i10 |= 2048;
            }
            if (x(this.f20832a) && !format.d(format2)) {
                i10 |= 2;
            }
            if (i10 == 0) {
                return new DecoderReuseEvaluation(this.f20832a, format, format2, format.d(format2) ? 3 : 2, 0);
            }
        } else {
            if (format.f19557z != format2.f19557z) {
                i10 |= 4096;
            }
            if (format.A != format2.A) {
                i10 |= 8192;
            }
            if (format.B != format2.B) {
                i10 |= 16384;
            }
            if (i10 == 0 && "audio/mp4a-latm".equals(this.f20833b)) {
                Pair<Integer, Integer> p10 = MediaCodecUtil.p(format);
                Pair<Integer, Integer> p11 = MediaCodecUtil.p(format2);
                if (p10 != null && p11 != null) {
                    int intValue = ((Integer) p10.first).intValue();
                    int intValue2 = ((Integer) p11.first).intValue();
                    if (intValue == 42 && intValue2 == 42) {
                        return new DecoderReuseEvaluation(this.f20832a, format, format2, 3, 0);
                    }
                }
            }
            if (!format.d(format2)) {
                i10 |= 32;
            }
            if (w(this.f20833b)) {
                i10 |= 2;
            }
            if (i10 == 0) {
                return new DecoderReuseEvaluation(this.f20832a, format, format2, 1, 0);
            }
        }
        return new DecoderReuseEvaluation(this.f20832a, format, format2, 0, i10);
    }

    public MediaCodecInfo.CodecProfileLevel[] g() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f20835d;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }

    @RequiresApi(21)
    public boolean j(int i10) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f20835d;
        if (codecCapabilities == null) {
            v("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            v("channelCount.aCaps");
            return false;
        }
        if (a(this.f20832a, this.f20833b, audioCapabilities.getMaxInputChannelCount()) >= i10) {
            return true;
        }
        StringBuilder sb2 = new StringBuilder(33);
        sb2.append("channelCount.support, ");
        sb2.append(i10);
        v(sb2.toString());
        return false;
    }

    @RequiresApi(21)
    public boolean k(int i10) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f20835d;
        if (codecCapabilities == null) {
            v("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            v("sampleRate.aCaps");
            return false;
        }
        if (audioCapabilities.isSampleRateSupported(i10)) {
            return true;
        }
        StringBuilder sb2 = new StringBuilder(31);
        sb2.append("sampleRate.support, ");
        sb2.append(i10);
        v(sb2.toString());
        return false;
    }

    public boolean l(Format format) {
        String g3;
        String str = format.f19541j;
        if (str == null || this.f20833b == null || (g3 = q.g(str)) == null) {
            return true;
        }
        if (!this.f20833b.equals(g3)) {
            String str2 = format.f19541j;
            StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 13 + g3.length());
            sb2.append("codec.mime ");
            sb2.append(str2);
            sb2.append(", ");
            sb2.append(g3);
            v(sb2.toString());
            return false;
        }
        Pair<Integer, Integer> p10 = MediaCodecUtil.p(format);
        if (p10 == null) {
            return true;
        }
        int intValue = ((Integer) p10.first).intValue();
        int intValue2 = ((Integer) p10.second).intValue();
        if (!this.f20842k && intValue != 42) {
            return true;
        }
        MediaCodecInfo.CodecProfileLevel[] g10 = g();
        if (j0.f22990a <= 23 && "video/x-vnd.on2.vp9".equals(this.f20833b) && g10.length == 0) {
            g10 = f(this.f20835d);
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : g10) {
            if (codecProfileLevel.profile == intValue && codecProfileLevel.level >= intValue2) {
                return true;
            }
        }
        String str3 = format.f19541j;
        StringBuilder sb3 = new StringBuilder(String.valueOf(str3).length() + 22 + g3.length());
        sb3.append("codec.profileLevel, ");
        sb3.append(str3);
        sb3.append(", ");
        sb3.append(g3);
        v(sb3.toString());
        return false;
    }

    public boolean m(Format format) throws MediaCodecUtil.DecoderQueryException {
        int i10;
        if (!l(format)) {
            return false;
        }
        if (this.f20842k) {
            int i11 = format.f19549r;
            if (i11 <= 0 || (i10 = format.f19550s) <= 0) {
                return true;
            }
            if (j0.f22990a >= 21) {
                return t(i11, i10, format.f19551t);
            }
            boolean z10 = i11 * i10 <= MediaCodecUtil.M();
            if (!z10) {
                int i12 = format.f19549r;
                int i13 = format.f19550s;
                StringBuilder sb2 = new StringBuilder(40);
                sb2.append("legacyFrameSize, ");
                sb2.append(i12);
                sb2.append(LanguageTag.PRIVATEUSE);
                sb2.append(i13);
                v(sb2.toString());
            }
            return z10;
        }
        if (j0.f22990a >= 21) {
            int i14 = format.A;
            if (i14 != -1 && !k(i14)) {
                return false;
            }
            int i15 = format.f19557z;
            if (i15 != -1 && !j(i15)) {
                return false;
            }
        }
        return true;
    }

    public boolean n() {
        if (j0.f22990a >= 29 && "video/x-vnd.on2.vp9".equals(this.f20833b)) {
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : g()) {
                if (codecProfileLevel.profile == 16384) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean o(Format format) {
        if (this.f20842k) {
            return this.f20836e;
        }
        Pair<Integer, Integer> p10 = MediaCodecUtil.p(format);
        return p10 != null && ((Integer) p10.first).intValue() == 42;
    }

    @RequiresApi(21)
    public boolean t(int i10, int i11, double d10) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f20835d;
        if (codecCapabilities == null) {
            v("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            v("sizeAndRate.vCaps");
            return false;
        }
        if (d(videoCapabilities, i10, i11, d10)) {
            return true;
        }
        if (i10 < i11 && z(this.f20832a) && d(videoCapabilities, i11, i10, d10)) {
            StringBuilder sb2 = new StringBuilder(69);
            sb2.append("sizeAndRate.rotated, ");
            sb2.append(i10);
            sb2.append(LanguageTag.PRIVATEUSE);
            sb2.append(i11);
            sb2.append(LanguageTag.PRIVATEUSE);
            sb2.append(d10);
            u(sb2.toString());
            return true;
        }
        StringBuilder sb3 = new StringBuilder(69);
        sb3.append("sizeAndRate.support, ");
        sb3.append(i10);
        sb3.append(LanguageTag.PRIVATEUSE);
        sb3.append(i11);
        sb3.append(LanguageTag.PRIVATEUSE);
        sb3.append(d10);
        v(sb3.toString());
        return false;
    }

    public String toString() {
        return this.f20832a;
    }

    public final void u(String str) {
        String str2 = this.f20832a;
        String str3 = this.f20833b;
        String str4 = j0.f22994e;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 25 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb2.append("AssumedSupport [");
        sb2.append(str);
        sb2.append("] [");
        sb2.append(str2);
        sb2.append(", ");
        sb2.append(str3);
        sb2.append("] [");
        sb2.append(str4);
        sb2.append("]");
        m.b("MediaCodecInfo", sb2.toString());
    }

    public final void v(String str) {
        String str2 = this.f20832a;
        String str3 = this.f20833b;
        String str4 = j0.f22994e;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 20 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb2.append("NoSupport [");
        sb2.append(str);
        sb2.append("] [");
        sb2.append(str2);
        sb2.append(", ");
        sb2.append(str3);
        sb2.append("] [");
        sb2.append(str4);
        sb2.append("]");
        m.b("MediaCodecInfo", sb2.toString());
    }
}
