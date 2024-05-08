package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.CheckResult;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.alibaba.security.biometrics.service.build.ah;
import com.android.internal.logging.nano.MetricsProto;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.util.q;
import com.google.android.exoplayer2.video.ColorInfo;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.CharUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MediaCodecUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f20807a = Pattern.compile("^\\D?(\\d+)$");

    /* renamed from: b, reason: collision with root package name */
    @GuardedBy("MediaCodecUtil.class")
    public static final HashMap<b, List<com.google.android.exoplayer2.mediacodec.c>> f20808b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public static int f20809c = -1;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class DecoderQueryException extends Exception {
        private DecoderQueryException(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f20810a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f20811b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f20812c;

        public b(String str, boolean z10, boolean z11) {
            this.f20810a = str;
            this.f20811b = z10;
            this.f20812c = z11;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != b.class) {
                return false;
            }
            b bVar = (b) obj;
            return TextUtils.equals(this.f20810a, bVar.f20810a) && this.f20811b == bVar.f20811b && this.f20812c == bVar.f20812c;
        }

        public int hashCode() {
            int hashCode = (this.f20810a.hashCode() + 31) * 31;
            boolean z10 = this.f20811b;
            int i10 = MetricsProto.MetricsEvent.AUTOFILL_SERVICE_DISABLED_APP;
            int i11 = (hashCode + (z10 ? MetricsProto.MetricsEvent.AUTOFILL_SERVICE_DISABLED_APP : MetricsProto.MetricsEvent.ANOMALY_TYPE_UNOPTIMIZED_BT)) * 31;
            if (!this.f20812c) {
                i10 = MetricsProto.MetricsEvent.ANOMALY_TYPE_UNOPTIMIZED_BT;
            }
            return i11 + i10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface c {
        boolean a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        MediaCodecInfo b(int i10);

        boolean c(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        int d();

        boolean e();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d implements c {
        public d() {
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return false;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public MediaCodecInfo b(int i10) {
            return MediaCodecList.getCodecInfoAt(i10);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean c(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "secure-playback".equals(str) && ah.f2598d.equals(str2);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public int d() {
            return MediaCodecList.getCodecCount();
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean e() {
            return false;
        }
    }

    @RequiresApi(21)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class e implements c {

        /* renamed from: a, reason: collision with root package name */
        public final int f20813a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public MediaCodecInfo[] f20814b;

        public e(boolean z10, boolean z11) {
            this.f20813a = (z10 || z11) ? 1 : 0;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureRequired(str);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public MediaCodecInfo b(int i10) {
            f();
            return this.f20814b[i10];
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean c(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported(str);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public int d() {
            f();
            return this.f20814b.length;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean e() {
            return true;
        }

        public final void f() {
            if (this.f20814b == null) {
                this.f20814b = new MediaCodecList(this.f20813a).getCodecInfos();
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface f<T> {
        int a(T t2);
    }

    @RequiresApi(29)
    public static boolean A(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isAlias();
    }

    public static boolean B(MediaCodecInfo mediaCodecInfo, String str, boolean z10, String str2) {
        if (mediaCodecInfo.isEncoder() || (!z10 && str.endsWith(".secure"))) {
            return false;
        }
        int i10 = j0.f22990a;
        if (i10 < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (i10 < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str)) {
            String str3 = j0.f22991b;
            if ("a70".equals(str3) || ("Xiaomi".equals(j0.f22992c) && str3.startsWith("HM"))) {
                return false;
            }
        }
        if (i10 == 16 && "OMX.qcom.audio.decoder.mp3".equals(str)) {
            String str4 = j0.f22991b;
            if ("dlxu".equals(str4) || "protou".equals(str4) || "ville".equals(str4) || "villeplus".equals(str4) || "villec2".equals(str4) || str4.startsWith("gee") || "C6602".equals(str4) || "C6603".equals(str4) || "C6606".equals(str4) || "C6616".equals(str4) || "L36h".equals(str4) || "SO-02E".equals(str4)) {
                return false;
            }
        }
        if (i10 == 16 && "OMX.qcom.audio.decoder.aac".equals(str)) {
            String str5 = j0.f22991b;
            if ("C1504".equals(str5) || "C1505".equals(str5) || "C1604".equals(str5) || "C1605".equals(str5)) {
                return false;
            }
        }
        if (i10 < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && "samsung".equals(j0.f22992c))) {
            String str6 = j0.f22991b;
            if (str6.startsWith("zeroflte") || str6.startsWith("zerolte") || str6.startsWith("zenlte") || "SC-05G".equals(str6) || "marinelteatt".equals(str6) || "404SC".equals(str6) || "SC-04G".equals(str6) || "SCV31".equals(str6)) {
                return false;
            }
        }
        if (i10 <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(j0.f22992c)) {
            String str7 = j0.f22991b;
            if (str7.startsWith("d2") || str7.startsWith("serrano") || str7.startsWith("jflte") || str7.startsWith("santos") || str7.startsWith("t0")) {
                return false;
            }
        }
        if (i10 <= 19 && j0.f22991b.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) {
            return false;
        }
        return ("audio/eac3-joc".equals(str2) && "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str)) ? false : true;
    }

    public static boolean C(MediaCodecInfo mediaCodecInfo) {
        if (j0.f22990a >= 29) {
            return D(mediaCodecInfo);
        }
        return !E(mediaCodecInfo);
    }

    @RequiresApi(29)
    public static boolean D(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isHardwareAccelerated();
    }

    public static boolean E(MediaCodecInfo mediaCodecInfo) {
        if (j0.f22990a >= 29) {
            return F(mediaCodecInfo);
        }
        String e2 = com.google.common.base.a.e(mediaCodecInfo.getName());
        if (e2.startsWith("arc.")) {
            return false;
        }
        return e2.startsWith("omx.google.") || e2.startsWith("omx.ffmpeg.") || (e2.startsWith("omx.sec.") && e2.contains(".sw.")) || e2.equals("omx.qcom.video.decoder.hevcswvdec") || e2.startsWith("c2.android.") || e2.startsWith("c2.google.") || !(e2.startsWith("omx.") || e2.startsWith("c2."));
    }

    @RequiresApi(29)
    public static boolean F(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isSoftwareOnly();
    }

    public static boolean G(MediaCodecInfo mediaCodecInfo) {
        if (j0.f22990a >= 29) {
            return H(mediaCodecInfo);
        }
        String e2 = com.google.common.base.a.e(mediaCodecInfo.getName());
        return (e2.startsWith("omx.google.") || e2.startsWith("c2.android.") || e2.startsWith("c2.google.")) ? false : true;
    }

    @RequiresApi(29)
    public static boolean H(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isVendor();
    }

    public static /* synthetic */ int I(com.google.android.exoplayer2.mediacodec.c cVar) {
        String str = cVar.f20832a;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        return (j0.f22990a >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
    }

    public static /* synthetic */ int J(com.google.android.exoplayer2.mediacodec.c cVar) {
        return cVar.f20832a.startsWith("OMX.google") ? 1 : 0;
    }

    public static /* synthetic */ int K(Format format, com.google.android.exoplayer2.mediacodec.c cVar) {
        try {
            return cVar.m(format) ? 1 : 0;
        } catch (DecoderQueryException unused) {
            return -1;
        }
    }

    public static /* synthetic */ int L(f fVar, Object obj, Object obj2) {
        return fVar.a(obj2) - fVar.a(obj);
    }

    public static int M() throws DecoderQueryException {
        if (f20809c == -1) {
            int i10 = 0;
            com.google.android.exoplayer2.mediacodec.c q10 = q(ah.f2598d, false, false);
            if (q10 != null) {
                MediaCodecInfo.CodecProfileLevel[] g3 = q10.g();
                int length = g3.length;
                int i11 = 0;
                while (i10 < length) {
                    i11 = Math.max(h(g3[i10].level), i11);
                    i10++;
                }
                i10 = Math.max(i11, j0.f22990a >= 21 ? 345600 : 172800);
            }
            f20809c = i10;
        }
        return f20809c;
    }

    public static int N(int i10) {
        int i11 = 17;
        if (i10 != 17) {
            i11 = 20;
            if (i10 != 20) {
                i11 = 23;
                if (i10 != 23) {
                    i11 = 29;
                    if (i10 != 29) {
                        i11 = 39;
                        if (i10 != 39) {
                            i11 = 42;
                            if (i10 != 42) {
                                switch (i10) {
                                    case 1:
                                        return 1;
                                    case 2:
                                        return 2;
                                    case 3:
                                        return 3;
                                    case 4:
                                        return 4;
                                    case 5:
                                        return 5;
                                    case 6:
                                        return 6;
                                    default:
                                        return -1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return i11;
    }

    public static <T> void O(List<T> list, final f<T> fVar) {
        Collections.sort(list, new Comparator() { // from class: m5.n
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int L;
                L = MediaCodecUtil.L(MediaCodecUtil.f.this, obj, obj2);
                return L;
            }
        });
    }

    public static int P(int i10) {
        if (i10 == 10) {
            return 1;
        }
        if (i10 == 11) {
            return 2;
        }
        if (i10 == 20) {
            return 4;
        }
        if (i10 == 21) {
            return 8;
        }
        if (i10 == 30) {
            return 16;
        }
        if (i10 == 31) {
            return 32;
        }
        if (i10 == 40) {
            return 64;
        }
        if (i10 == 41) {
            return 128;
        }
        if (i10 == 50) {
            return 256;
        }
        if (i10 == 51) {
            return 512;
        }
        switch (i10) {
            case 60:
                return 2048;
            case 61:
                return 4096;
            case 62:
                return 8192;
            default:
                return -1;
        }
    }

    public static int Q(int i10) {
        if (i10 == 0) {
            return 1;
        }
        if (i10 == 1) {
            return 2;
        }
        if (i10 != 2) {
            return i10 != 3 ? -1 : 8;
        }
        return 4;
    }

    public static void e(String str, List<com.google.android.exoplayer2.mediacodec.c> list) {
        if ("audio/raw".equals(str)) {
            if (j0.f22990a < 26 && j0.f22991b.equals("R9") && list.size() == 1 && list.get(0).f20832a.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                list.add(com.google.android.exoplayer2.mediacodec.c.A("OMX.google.raw.decoder", "audio/raw", "audio/raw", null, false, true, false, false, false));
            }
            O(list, new f() { // from class: m5.l
                @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.f
                public final int a(Object obj) {
                    int I;
                    I = MediaCodecUtil.I((com.google.android.exoplayer2.mediacodec.c) obj);
                    return I;
                }
            });
        }
        int i10 = j0.f22990a;
        if (i10 < 21 && list.size() > 1) {
            String str2 = list.get(0).f20832a;
            if ("OMX.SEC.mp3.dec".equals(str2) || "OMX.SEC.MP3.Decoder".equals(str2) || "OMX.brcm.audio.mp3.decoder".equals(str2)) {
                O(list, new f() { // from class: m5.m
                    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.f
                    public final int a(Object obj) {
                        int J;
                        J = MediaCodecUtil.J((com.google.android.exoplayer2.mediacodec.c) obj);
                        return J;
                    }
                });
            }
        }
        if (i10 >= 32 || list.size() <= 1 || !"OMX.qti.audio.decoder.flac".equals(list.get(0).f20832a)) {
            return;
        }
        list.add(list.remove(0));
    }

    public static int f(int i10) {
        switch (i10) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case 8:
                return 256;
            case 9:
                return 512;
            case 10:
                return 1024;
            case 11:
                return 2048;
            case 12:
                return 4096;
            case 13:
                return 8192;
            case 14:
                return 16384;
            case 15:
                return 32768;
            case 16:
                return 65536;
            case 17:
                return 131072;
            case 18:
                return 262144;
            case 19:
                return 524288;
            case 20:
                return 1048576;
            case 21:
                return 2097152;
            case 22:
                return 4194304;
            case 23:
                return 8388608;
            default:
                return -1;
        }
    }

    public static int g(int i10) {
        switch (i10) {
            case 10:
                return 1;
            case 11:
                return 4;
            case 12:
                return 8;
            case 13:
                return 16;
            default:
                switch (i10) {
                    case 20:
                        return 32;
                    case 21:
                        return 64;
                    case 22:
                        return 128;
                    default:
                        switch (i10) {
                            case 30:
                                return 256;
                            case 31:
                                return 512;
                            case 32:
                                return 1024;
                            default:
                                switch (i10) {
                                    case 40:
                                        return 2048;
                                    case 41:
                                        return 4096;
                                    case 42:
                                        return 8192;
                                    default:
                                        switch (i10) {
                                            case 50:
                                                return 16384;
                                            case 51:
                                                return 32768;
                                            case 52:
                                                return 65536;
                                            default:
                                                return -1;
                                        }
                                }
                        }
                }
        }
    }

    public static int h(int i10) {
        if (i10 == 1 || i10 == 2) {
            return 25344;
        }
        switch (i10) {
            case 8:
            case 16:
            case 32:
                return 101376;
            case 64:
                return 202752;
            case 128:
            case 256:
                return 414720;
            case 512:
                return 921600;
            case 1024:
                return 1310720;
            case 2048:
            case 4096:
                return 2097152;
            case 8192:
                return 2228224;
            case 16384:
                return 5652480;
            case 32768:
            case 65536:
                return 9437184;
            case 131072:
            case 262144:
            case 524288:
                return 35651584;
            default:
                return -1;
        }
    }

    public static int i(int i10) {
        if (i10 == 66) {
            return 1;
        }
        if (i10 == 77) {
            return 2;
        }
        if (i10 == 88) {
            return 4;
        }
        if (i10 == 100) {
            return 8;
        }
        if (i10 == 110) {
            return 16;
        }
        if (i10 != 122) {
            return i10 != 244 ? -1 : 64;
        }
        return 32;
    }

    @Nullable
    public static Integer j(@Nullable String str) {
        if (str == null) {
            return null;
        }
        char c4 = 65535;
        switch (str.hashCode()) {
            case MetricsProto.MetricsEvent.FIELD_PROCESS_RECORD_MILLIS_SINCE_LAST_INTERACTION_EVENT /* 1537 */:
                if (str.equals(HiAnalyticsConstant.KeyAndValue.NUMBER_01)) {
                    c4 = 0;
                    break;
                }
                break;
            case MetricsProto.MetricsEvent.FIELD_PROCESS_RECORD_MILLIS_SINCE_FG_INTERACTION /* 1538 */:
                if (str.equals(com.huawei.hms.ads.dynamic.a.f29124s)) {
                    c4 = 1;
                    break;
                }
                break;
            case MetricsProto.MetricsEvent.FIELD_PROCESS_RECORD_MILLIS_SINCE_UNIMPORTANT /* 1539 */:
                if (str.equals("03")) {
                    c4 = 2;
                    break;
                }
                break;
            case MetricsProto.MetricsEvent.FIELD_ACTIVITY_RECORD_LAUNCH_MODE /* 1540 */:
                if (str.equals("04")) {
                    c4 = 3;
                    break;
                }
                break;
            case MetricsProto.MetricsEvent.FIELD_ACTIVITY_RECORD_TARGET_ACTIVITY /* 1541 */:
                if (str.equals("05")) {
                    c4 = 4;
                    break;
                }
                break;
            case MetricsProto.MetricsEvent.FIELD_ACTIVITY_RECORD_FLAGS /* 1542 */:
                if (str.equals("06")) {
                    c4 = 5;
                    break;
                }
                break;
            case MetricsProto.MetricsEvent.FIELD_ACTIVITY_RECORD_REAL_ACTIVITY /* 1543 */:
                if (str.equals("07")) {
                    c4 = 6;
                    break;
                }
                break;
            case MetricsProto.MetricsEvent.FIELD_ACTIVITY_RECORD_SHORT_COMPONENT_NAME /* 1544 */:
                if (str.equals("08")) {
                    c4 = 7;
                    break;
                }
                break;
            case MetricsProto.MetricsEvent.FIELD_ACTIVITY_RECORD_PROCESS_NAME /* 1545 */:
                if (str.equals("09")) {
                    c4 = '\b';
                    break;
                }
                break;
            case MetricsProto.MetricsEvent.FIELD_EMERGENCY_DIALER_SHORTCUT_TAPS_INTERVAL /* 1567 */:
                if (str.equals("10")) {
                    c4 = '\t';
                    break;
                }
                break;
            case MetricsProto.MetricsEvent.POWER_MENU /* 1568 */:
                if (str.equals("11")) {
                    c4 = '\n';
                    break;
                }
                break;
            case MetricsProto.MetricsEvent.ACTION_EMERGENCY_DIALER_FROM_POWER_MENU /* 1569 */:
                if (str.equals(Constants.VIA_REPORT_TYPE_SET_AVATAR)) {
                    c4 = 11;
                    break;
                }
                break;
            case MetricsProto.MetricsEvent.SETTINGS_GESTURE_WAKE_SCREEN /* 1570 */:
                if (str.equals(Constants.VIA_REPORT_TYPE_JOININ_GROUP)) {
                    c4 = '\f';
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case '\b':
                return 256;
            case '\t':
                return 512;
            case '\n':
                return 1024;
            case 11:
                return 2048;
            case '\f':
                return 4096;
            default:
                return null;
        }
    }

    @Nullable
    public static Integer k(@Nullable String str) {
        if (str == null) {
            return null;
        }
        char c4 = 65535;
        switch (str.hashCode()) {
            case 1536:
                if (str.equals("00")) {
                    c4 = 0;
                    break;
                }
                break;
            case MetricsProto.MetricsEvent.FIELD_PROCESS_RECORD_MILLIS_SINCE_LAST_INTERACTION_EVENT /* 1537 */:
                if (str.equals(HiAnalyticsConstant.KeyAndValue.NUMBER_01)) {
                    c4 = 1;
                    break;
                }
                break;
            case MetricsProto.MetricsEvent.FIELD_PROCESS_RECORD_MILLIS_SINCE_FG_INTERACTION /* 1538 */:
                if (str.equals(com.huawei.hms.ads.dynamic.a.f29124s)) {
                    c4 = 2;
                    break;
                }
                break;
            case MetricsProto.MetricsEvent.FIELD_PROCESS_RECORD_MILLIS_SINCE_UNIMPORTANT /* 1539 */:
                if (str.equals("03")) {
                    c4 = 3;
                    break;
                }
                break;
            case MetricsProto.MetricsEvent.FIELD_ACTIVITY_RECORD_LAUNCH_MODE /* 1540 */:
                if (str.equals("04")) {
                    c4 = 4;
                    break;
                }
                break;
            case MetricsProto.MetricsEvent.FIELD_ACTIVITY_RECORD_TARGET_ACTIVITY /* 1541 */:
                if (str.equals("05")) {
                    c4 = 5;
                    break;
                }
                break;
            case MetricsProto.MetricsEvent.FIELD_ACTIVITY_RECORD_FLAGS /* 1542 */:
                if (str.equals("06")) {
                    c4 = 6;
                    break;
                }
                break;
            case MetricsProto.MetricsEvent.FIELD_ACTIVITY_RECORD_REAL_ACTIVITY /* 1543 */:
                if (str.equals("07")) {
                    c4 = 7;
                    break;
                }
                break;
            case MetricsProto.MetricsEvent.FIELD_ACTIVITY_RECORD_SHORT_COMPONENT_NAME /* 1544 */:
                if (str.equals("08")) {
                    c4 = '\b';
                    break;
                }
                break;
            case MetricsProto.MetricsEvent.FIELD_ACTIVITY_RECORD_PROCESS_NAME /* 1545 */:
                if (str.equals("09")) {
                    c4 = '\t';
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case '\b':
                return 256;
            case '\t':
                return 512;
            default:
                return null;
        }
    }

    @Nullable
    public static Pair<Integer, Integer> l(String str, String[] strArr) {
        int N;
        if (strArr.length != 3) {
            String valueOf = String.valueOf(str);
            m.h("MediaCodecUtil", valueOf.length() != 0 ? "Ignoring malformed MP4A codec string: ".concat(valueOf) : new String("Ignoring malformed MP4A codec string: "));
            return null;
        }
        try {
            if ("audio/mp4a-latm".equals(q.h(Integer.parseInt(strArr[1], 16))) && (N = N(Integer.parseInt(strArr[2]))) != -1) {
                return new Pair<>(Integer.valueOf(N), 0);
            }
        } catch (NumberFormatException unused) {
            String valueOf2 = String.valueOf(str);
            m.h("MediaCodecUtil", valueOf2.length() != 0 ? "Ignoring malformed MP4A codec string: ".concat(valueOf2) : new String("Ignoring malformed MP4A codec string: "));
        }
        return null;
    }

    @Nullable
    public static Pair<Integer, Integer> m(String str, String[] strArr, @Nullable ColorInfo colorInfo) {
        int i10;
        if (strArr.length < 4) {
            String valueOf = String.valueOf(str);
            m.h("MediaCodecUtil", valueOf.length() != 0 ? "Ignoring malformed AV1 codec string: ".concat(valueOf) : new String("Ignoring malformed AV1 codec string: "));
            return null;
        }
        int i11 = 1;
        try {
            int parseInt = Integer.parseInt(strArr[1]);
            int parseInt2 = Integer.parseInt(strArr[2].substring(0, 2));
            int parseInt3 = Integer.parseInt(strArr[3]);
            if (parseInt != 0) {
                StringBuilder sb2 = new StringBuilder(32);
                sb2.append("Unknown AV1 profile: ");
                sb2.append(parseInt);
                m.h("MediaCodecUtil", sb2.toString());
                return null;
            }
            if (parseInt3 != 8 && parseInt3 != 10) {
                StringBuilder sb3 = new StringBuilder(34);
                sb3.append("Unknown AV1 bit depth: ");
                sb3.append(parseInt3);
                m.h("MediaCodecUtil", sb3.toString());
                return null;
            }
            if (parseInt3 != 8) {
                i11 = (colorInfo == null || !(colorInfo.f23044e != null || (i10 = colorInfo.f23043d) == 7 || i10 == 6)) ? 2 : 4096;
            }
            int f10 = f(parseInt2);
            if (f10 == -1) {
                StringBuilder sb4 = new StringBuilder(30);
                sb4.append("Unknown AV1 level: ");
                sb4.append(parseInt2);
                m.h("MediaCodecUtil", sb4.toString());
                return null;
            }
            return new Pair<>(Integer.valueOf(i11), Integer.valueOf(f10));
        } catch (NumberFormatException unused) {
            String valueOf2 = String.valueOf(str);
            m.h("MediaCodecUtil", valueOf2.length() != 0 ? "Ignoring malformed AV1 codec string: ".concat(valueOf2) : new String("Ignoring malformed AV1 codec string: "));
            return null;
        }
    }

    @Nullable
    public static Pair<Integer, Integer> n(String str, String[] strArr) {
        int parseInt;
        int i10;
        if (strArr.length < 2) {
            String valueOf = String.valueOf(str);
            m.h("MediaCodecUtil", valueOf.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(valueOf) : new String("Ignoring malformed AVC codec string: "));
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                i10 = Integer.parseInt(strArr[1].substring(0, 2), 16);
                parseInt = Integer.parseInt(strArr[1].substring(4), 16);
            } else if (strArr.length >= 3) {
                int parseInt2 = Integer.parseInt(strArr[1]);
                parseInt = Integer.parseInt(strArr[2]);
                i10 = parseInt2;
            } else {
                String valueOf2 = String.valueOf(str);
                m.h("MediaCodecUtil", valueOf2.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(valueOf2) : new String("Ignoring malformed AVC codec string: "));
                return null;
            }
            int i11 = i(i10);
            if (i11 == -1) {
                StringBuilder sb2 = new StringBuilder(32);
                sb2.append("Unknown AVC profile: ");
                sb2.append(i10);
                m.h("MediaCodecUtil", sb2.toString());
                return null;
            }
            int g3 = g(parseInt);
            if (g3 == -1) {
                StringBuilder sb3 = new StringBuilder(30);
                sb3.append("Unknown AVC level: ");
                sb3.append(parseInt);
                m.h("MediaCodecUtil", sb3.toString());
                return null;
            }
            return new Pair<>(Integer.valueOf(i11), Integer.valueOf(g3));
        } catch (NumberFormatException unused) {
            String valueOf3 = String.valueOf(str);
            m.h("MediaCodecUtil", valueOf3.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(valueOf3) : new String("Ignoring malformed AVC codec string: "));
            return null;
        }
    }

    @Nullable
    public static String o(MediaCodecInfo mediaCodecInfo, String str, String str2) {
        for (String str3 : mediaCodecInfo.getSupportedTypes()) {
            if (str3.equalsIgnoreCase(str2)) {
                return str3;
            }
        }
        if (str2.equals("video/dolby-vision")) {
            if ("OMX.MS.HEVCDV.Decoder".equals(str)) {
                return "video/hevcdv";
            }
            if ("OMX.RTK.video.decoder".equals(str) || "OMX.realtek.video.decoder.tunneled".equals(str)) {
                return "video/dv_hevc";
            }
            return null;
        }
        if (str2.equals("audio/alac") && "OMX.lge.alac.decoder".equals(str)) {
            return "audio/x-lg-alac";
        }
        if (str2.equals("audio/flac") && "OMX.lge.flac.decoder".equals(str)) {
            return "audio/x-lg-flac";
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0075, code lost:
    
        if (r3.equals("av01") == false) goto L11;
     */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> p(com.google.android.exoplayer2.Format r6) {
        /*
            java.lang.String r0 = r6.f19541j
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            java.lang.String r2 = "\\."
            java.lang.String[] r0 = r0.split(r2)
            java.lang.String r2 = r6.f19544m
            java.lang.String r3 = "video/dolby-vision"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L1d
            java.lang.String r6 = r6.f19541j
            android.util.Pair r6 = v(r6, r0)
            return r6
        L1d:
            r2 = 0
            r3 = r0[r2]
            r3.hashCode()
            r4 = -1
            int r5 = r3.hashCode()
            switch(r5) {
                case 3004662: goto L6f;
                case 3006243: goto L64;
                case 3006244: goto L59;
                case 3199032: goto L4e;
                case 3214780: goto L43;
                case 3356560: goto L38;
                case 3624515: goto L2d;
                default: goto L2b;
            }
        L2b:
            r2 = -1
            goto L78
        L2d:
            java.lang.String r2 = "vp09"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L36
            goto L2b
        L36:
            r2 = 6
            goto L78
        L38:
            java.lang.String r2 = "mp4a"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L41
            goto L2b
        L41:
            r2 = 5
            goto L78
        L43:
            java.lang.String r2 = "hvc1"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L4c
            goto L2b
        L4c:
            r2 = 4
            goto L78
        L4e:
            java.lang.String r2 = "hev1"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L57
            goto L2b
        L57:
            r2 = 3
            goto L78
        L59:
            java.lang.String r2 = "avc2"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L62
            goto L2b
        L62:
            r2 = 2
            goto L78
        L64:
            java.lang.String r2 = "avc1"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L6d
            goto L2b
        L6d:
            r2 = 1
            goto L78
        L6f:
            java.lang.String r5 = "av01"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L78
            goto L2b
        L78:
            switch(r2) {
                case 0: goto L98;
                case 1: goto L91;
                case 2: goto L91;
                case 3: goto L8a;
                case 4: goto L8a;
                case 5: goto L83;
                case 6: goto L7c;
                default: goto L7b;
            }
        L7b:
            return r1
        L7c:
            java.lang.String r6 = r6.f19541j
            android.util.Pair r6 = x(r6, r0)
            return r6
        L83:
            java.lang.String r6 = r6.f19541j
            android.util.Pair r6 = l(r6, r0)
            return r6
        L8a:
            java.lang.String r6 = r6.f19541j
            android.util.Pair r6 = w(r6, r0)
            return r6
        L91:
            java.lang.String r6 = r6.f19541j
            android.util.Pair r6 = n(r6, r0)
            return r6
        L98:
            java.lang.String r1 = r6.f19541j
            com.google.android.exoplayer2.video.ColorInfo r6 = r6.f19556y
            android.util.Pair r6 = m(r1, r0, r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.p(com.google.android.exoplayer2.Format):android.util.Pair");
    }

    @Nullable
    public static com.google.android.exoplayer2.mediacodec.c q(String str, boolean z10, boolean z11) throws DecoderQueryException {
        List<com.google.android.exoplayer2.mediacodec.c> r10 = r(str, z10, z11);
        if (r10.isEmpty()) {
            return null;
        }
        return r10.get(0);
    }

    public static synchronized List<com.google.android.exoplayer2.mediacodec.c> r(String str, boolean z10, boolean z11) throws DecoderQueryException {
        c dVar;
        synchronized (MediaCodecUtil.class) {
            b bVar = new b(str, z10, z11);
            HashMap<b, List<com.google.android.exoplayer2.mediacodec.c>> hashMap = f20808b;
            List<com.google.android.exoplayer2.mediacodec.c> list = hashMap.get(bVar);
            if (list != null) {
                return list;
            }
            int i10 = j0.f22990a;
            if (i10 >= 21) {
                dVar = new e(z10, z11);
            } else {
                dVar = new d();
            }
            ArrayList<com.google.android.exoplayer2.mediacodec.c> s2 = s(bVar, dVar);
            if (z10 && s2.isEmpty() && 21 <= i10 && i10 <= 23) {
                s2 = s(bVar, new d());
                if (!s2.isEmpty()) {
                    String str2 = s2.get(0).f20832a;
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 63 + String.valueOf(str2).length());
                    sb2.append("MediaCodecList API didn't list secure decoder for: ");
                    sb2.append(str);
                    sb2.append(". Assuming: ");
                    sb2.append(str2);
                    m.h("MediaCodecUtil", sb2.toString());
                }
            }
            e(str, s2);
            List<com.google.android.exoplayer2.mediacodec.c> unmodifiableList = Collections.unmodifiableList(s2);
            hashMap.put(bVar, unmodifiableList);
            return unmodifiableList;
        }
    }

    public static ArrayList<com.google.android.exoplayer2.mediacodec.c> s(b bVar, c cVar) throws DecoderQueryException {
        String o10;
        String str;
        String str2;
        int i10;
        boolean z10;
        int i11;
        MediaCodecInfo.CodecCapabilities capabilitiesForType;
        boolean c4;
        boolean a10;
        boolean z11;
        try {
            ArrayList<com.google.android.exoplayer2.mediacodec.c> arrayList = new ArrayList<>();
            String str3 = bVar.f20810a;
            int d10 = cVar.d();
            boolean e2 = cVar.e();
            int i12 = 0;
            while (i12 < d10) {
                MediaCodecInfo b4 = cVar.b(i12);
                if (!z(b4)) {
                    String name = b4.getName();
                    if (B(b4, name, e2, str3) && (o10 = o(b4, name, str3)) != null) {
                        try {
                            capabilitiesForType = b4.getCapabilitiesForType(o10);
                            c4 = cVar.c("tunneled-playback", o10, capabilitiesForType);
                            a10 = cVar.a("tunneled-playback", o10, capabilitiesForType);
                            z11 = bVar.f20812c;
                        } catch (Exception e10) {
                            e = e10;
                            str = o10;
                            str2 = name;
                            i10 = i12;
                            z10 = e2;
                            i11 = d10;
                        }
                        if ((z11 || !a10) && (!z11 || c4)) {
                            boolean c10 = cVar.c("secure-playback", o10, capabilitiesForType);
                            boolean a11 = cVar.a("secure-playback", o10, capabilitiesForType);
                            boolean z12 = bVar.f20811b;
                            if ((z12 || !a11) && (!z12 || c10)) {
                                boolean C = C(b4);
                                boolean E = E(b4);
                                boolean G = G(b4);
                                if (!(e2 && bVar.f20811b == c10) && (e2 || bVar.f20811b)) {
                                    str = o10;
                                    str2 = name;
                                    i10 = i12;
                                    z10 = e2;
                                    i11 = d10;
                                    if (!z10 && c10) {
                                        arrayList.add(com.google.android.exoplayer2.mediacodec.c.A(String.valueOf(str2).concat(".secure"), str3, str, capabilitiesForType, C, E, G, false, true));
                                        return arrayList;
                                    }
                                    i12 = i10 + 1;
                                    d10 = i11;
                                    e2 = z10;
                                } else {
                                    str = o10;
                                    str2 = name;
                                    i10 = i12;
                                    z10 = e2;
                                    i11 = d10;
                                    try {
                                        arrayList.add(com.google.android.exoplayer2.mediacodec.c.A(name, str3, o10, capabilitiesForType, C, E, G, false, false));
                                    } catch (Exception e11) {
                                        e = e11;
                                        if (j0.f22990a <= 23 && !arrayList.isEmpty()) {
                                            StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 46);
                                            sb2.append("Skipping codec ");
                                            sb2.append(str2);
                                            sb2.append(" (failed to query capabilities)");
                                            m.c("MediaCodecUtil", sb2.toString());
                                            i12 = i10 + 1;
                                            d10 = i11;
                                            e2 = z10;
                                        } else {
                                            String str4 = str2;
                                            StringBuilder sb3 = new StringBuilder(String.valueOf(str4).length() + 25 + str.length());
                                            sb3.append("Failed to query codec ");
                                            sb3.append(str4);
                                            sb3.append(" (");
                                            sb3.append(str);
                                            sb3.append(")");
                                            m.c("MediaCodecUtil", sb3.toString());
                                            throw e;
                                        }
                                    }
                                    i12 = i10 + 1;
                                    d10 = i11;
                                    e2 = z10;
                                }
                            }
                        }
                    }
                }
                i10 = i12;
                z10 = e2;
                i11 = d10;
                i12 = i10 + 1;
                d10 = i11;
                e2 = z10;
            }
            return arrayList;
        } catch (Exception e12) {
            throw new DecoderQueryException(e12);
        }
    }

    @CheckResult
    public static List<com.google.android.exoplayer2.mediacodec.c> t(List<com.google.android.exoplayer2.mediacodec.c> list, final Format format) {
        ArrayList arrayList = new ArrayList(list);
        O(arrayList, new f() { // from class: m5.k
            @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.f
            public final int a(Object obj) {
                int K;
                K = MediaCodecUtil.K(Format.this, (com.google.android.exoplayer2.mediacodec.c) obj);
                return K;
            }
        });
        return arrayList;
    }

    @Nullable
    public static com.google.android.exoplayer2.mediacodec.c u() throws DecoderQueryException {
        return q("audio/raw", false, false);
    }

    @Nullable
    public static Pair<Integer, Integer> v(String str, String[] strArr) {
        if (strArr.length < 3) {
            String valueOf = String.valueOf(str);
            m.h("MediaCodecUtil", valueOf.length() != 0 ? "Ignoring malformed Dolby Vision codec string: ".concat(valueOf) : new String("Ignoring malformed Dolby Vision codec string: "));
            return null;
        }
        Matcher matcher = f20807a.matcher(strArr[1]);
        if (!matcher.matches()) {
            String valueOf2 = String.valueOf(str);
            m.h("MediaCodecUtil", valueOf2.length() != 0 ? "Ignoring malformed Dolby Vision codec string: ".concat(valueOf2) : new String("Ignoring malformed Dolby Vision codec string: "));
            return null;
        }
        String group = matcher.group(1);
        Integer k10 = k(group);
        if (k10 == null) {
            String valueOf3 = String.valueOf(group);
            m.h("MediaCodecUtil", valueOf3.length() != 0 ? "Unknown Dolby Vision profile string: ".concat(valueOf3) : new String("Unknown Dolby Vision profile string: "));
            return null;
        }
        String str2 = strArr[2];
        Integer j10 = j(str2);
        if (j10 == null) {
            String valueOf4 = String.valueOf(str2);
            m.h("MediaCodecUtil", valueOf4.length() != 0 ? "Unknown Dolby Vision level string: ".concat(valueOf4) : new String("Unknown Dolby Vision level string: "));
            return null;
        }
        return new Pair<>(k10, j10);
    }

    @Nullable
    public static Pair<Integer, Integer> w(String str, String[] strArr) {
        if (strArr.length < 4) {
            String valueOf = String.valueOf(str);
            m.h("MediaCodecUtil", valueOf.length() != 0 ? "Ignoring malformed HEVC codec string: ".concat(valueOf) : new String("Ignoring malformed HEVC codec string: "));
            return null;
        }
        int i10 = 1;
        Matcher matcher = f20807a.matcher(strArr[1]);
        if (!matcher.matches()) {
            String valueOf2 = String.valueOf(str);
            m.h("MediaCodecUtil", valueOf2.length() != 0 ? "Ignoring malformed HEVC codec string: ".concat(valueOf2) : new String("Ignoring malformed HEVC codec string: "));
            return null;
        }
        String group = matcher.group(1);
        if (!"1".equals(group)) {
            if (!"2".equals(group)) {
                String valueOf3 = String.valueOf(group);
                m.h("MediaCodecUtil", valueOf3.length() != 0 ? "Unknown HEVC profile string: ".concat(valueOf3) : new String("Unknown HEVC profile string: "));
                return null;
            }
            i10 = 2;
        }
        String str2 = strArr[3];
        Integer y10 = y(str2);
        if (y10 == null) {
            String valueOf4 = String.valueOf(str2);
            m.h("MediaCodecUtil", valueOf4.length() != 0 ? "Unknown HEVC level string: ".concat(valueOf4) : new String("Unknown HEVC level string: "));
            return null;
        }
        return new Pair<>(Integer.valueOf(i10), y10);
    }

    @Nullable
    public static Pair<Integer, Integer> x(String str, String[] strArr) {
        if (strArr.length < 3) {
            String valueOf = String.valueOf(str);
            m.h("MediaCodecUtil", valueOf.length() != 0 ? "Ignoring malformed VP9 codec string: ".concat(valueOf) : new String("Ignoring malformed VP9 codec string: "));
            return null;
        }
        try {
            int parseInt = Integer.parseInt(strArr[1]);
            int parseInt2 = Integer.parseInt(strArr[2]);
            int Q = Q(parseInt);
            if (Q == -1) {
                StringBuilder sb2 = new StringBuilder(32);
                sb2.append("Unknown VP9 profile: ");
                sb2.append(parseInt);
                m.h("MediaCodecUtil", sb2.toString());
                return null;
            }
            int P = P(parseInt2);
            if (P == -1) {
                StringBuilder sb3 = new StringBuilder(30);
                sb3.append("Unknown VP9 level: ");
                sb3.append(parseInt2);
                m.h("MediaCodecUtil", sb3.toString());
                return null;
            }
            return new Pair<>(Integer.valueOf(Q), Integer.valueOf(P));
        } catch (NumberFormatException unused) {
            String valueOf2 = String.valueOf(str);
            m.h("MediaCodecUtil", valueOf2.length() != 0 ? "Ignoring malformed VP9 codec string: ".concat(valueOf2) : new String("Ignoring malformed VP9 codec string: "));
            return null;
        }
    }

    @Nullable
    public static Integer y(@Nullable String str) {
        if (str == null) {
            return null;
        }
        char c4 = 65535;
        switch (str.hashCode()) {
            case 70821:
                if (str.equals("H30")) {
                    c4 = 0;
                    break;
                }
                break;
            case 70914:
                if (str.equals("H60")) {
                    c4 = 1;
                    break;
                }
                break;
            case 70917:
                if (str.equals("H63")) {
                    c4 = 2;
                    break;
                }
                break;
            case 71007:
                if (str.equals("H90")) {
                    c4 = 3;
                    break;
                }
                break;
            case 71010:
                if (str.equals("H93")) {
                    c4 = 4;
                    break;
                }
                break;
            case 74665:
                if (str.equals("L30")) {
                    c4 = 5;
                    break;
                }
                break;
            case 74758:
                if (str.equals("L60")) {
                    c4 = 6;
                    break;
                }
                break;
            case 74761:
                if (str.equals("L63")) {
                    c4 = 7;
                    break;
                }
                break;
            case 74851:
                if (str.equals("L90")) {
                    c4 = '\b';
                    break;
                }
                break;
            case 74854:
                if (str.equals("L93")) {
                    c4 = '\t';
                    break;
                }
                break;
            case 2193639:
                if (str.equals("H120")) {
                    c4 = '\n';
                    break;
                }
                break;
            case 2193642:
                if (str.equals("H123")) {
                    c4 = 11;
                    break;
                }
                break;
            case 2193732:
                if (str.equals("H150")) {
                    c4 = '\f';
                    break;
                }
                break;
            case 2193735:
                if (str.equals("H153")) {
                    c4 = CharUtils.CR;
                    break;
                }
                break;
            case 2193738:
                if (str.equals("H156")) {
                    c4 = 14;
                    break;
                }
                break;
            case 2193825:
                if (str.equals("H180")) {
                    c4 = 15;
                    break;
                }
                break;
            case 2193828:
                if (str.equals("H183")) {
                    c4 = 16;
                    break;
                }
                break;
            case 2193831:
                if (str.equals("H186")) {
                    c4 = 17;
                    break;
                }
                break;
            case 2312803:
                if (str.equals("L120")) {
                    c4 = 18;
                    break;
                }
                break;
            case 2312806:
                if (str.equals("L123")) {
                    c4 = 19;
                    break;
                }
                break;
            case 2312896:
                if (str.equals("L150")) {
                    c4 = 20;
                    break;
                }
                break;
            case 2312899:
                if (str.equals("L153")) {
                    c4 = 21;
                    break;
                }
                break;
            case 2312902:
                if (str.equals("L156")) {
                    c4 = 22;
                    break;
                }
                break;
            case 2312989:
                if (str.equals("L180")) {
                    c4 = 23;
                    break;
                }
                break;
            case 2312992:
                if (str.equals("L183")) {
                    c4 = 24;
                    break;
                }
                break;
            case 2312995:
                if (str.equals("L186")) {
                    c4 = 25;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return 2;
            case 1:
                return 8;
            case 2:
                return 32;
            case 3:
                return 128;
            case 4:
                return 512;
            case 5:
                return 1;
            case 6:
                return 4;
            case 7:
                return 16;
            case '\b':
                return 64;
            case '\t':
                return 256;
            case '\n':
                return 2048;
            case 11:
                return 8192;
            case '\f':
                return 32768;
            case '\r':
                return 131072;
            case 14:
                return 524288;
            case 15:
                return 2097152;
            case 16:
                return 8388608;
            case 17:
                return 33554432;
            case 18:
                return 1024;
            case 19:
                return 4096;
            case 20:
                return 16384;
            case 21:
                return 65536;
            case 22:
                return 262144;
            case 23:
                return 1048576;
            case 24:
                return 4194304;
            case 25:
                return 16777216;
            default:
                return null;
        }
    }

    public static boolean z(MediaCodecInfo mediaCodecInfo) {
        return j0.f22990a >= 29 && A(mediaCodecInfo);
    }
}
