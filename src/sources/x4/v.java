package x4;

import android.window.TaskConstants;
import androidx.annotation.Nullable;
import com.android.internal.logging.nano.MetricsProto;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* compiled from: MpegAudioUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f54442a = {"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f54443b = {44100, 48000, 32000};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f54444c = {32000, 64000, 96000, 128000, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f54445d = {32000, 48000, 56000, 64000, MediationConstant.ErrorCode.ADN_INIT_FAIL, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f54446e = {32000, 48000, 56000, 64000, MediationConstant.ErrorCode.ADN_INIT_FAIL, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 384000};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f54447f = {32000, TaskConstants.TASK_CHILD_LAYER_TASK_OVERLAY, 48000, 56000, 64000, MediationConstant.ErrorCode.ADN_INIT_FAIL, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000};

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f54448g = {8000, 16000, 24000, 32000, TaskConstants.TASK_CHILD_LAYER_TASK_OVERLAY, 48000, 56000, 64000, MediationConstant.ErrorCode.ADN_INIT_FAIL, 96000, 112000, 128000, 144000, 160000};

    /* compiled from: MpegAudioUtil.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int f54449a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public String f54450b;

        /* renamed from: c, reason: collision with root package name */
        public int f54451c;

        /* renamed from: d, reason: collision with root package name */
        public int f54452d;

        /* renamed from: e, reason: collision with root package name */
        public int f54453e;

        /* renamed from: f, reason: collision with root package name */
        public int f54454f;

        /* renamed from: g, reason: collision with root package name */
        public int f54455g;

        public boolean a(int i10) {
            int i11;
            int i12;
            int i13;
            int i14;
            if (!v.l(i10) || (i11 = (i10 >>> 19) & 3) == 1 || (i12 = (i10 >>> 17) & 3) == 0 || (i13 = (i10 >>> 12) & 15) == 0 || i13 == 15 || (i14 = (i10 >>> 10) & 3) == 3) {
                return false;
            }
            this.f54449a = i11;
            this.f54450b = v.f54442a[3 - i12];
            int i15 = v.f54443b[i14];
            this.f54452d = i15;
            if (i11 == 2) {
                this.f54452d = i15 / 2;
            } else if (i11 == 0) {
                this.f54452d = i15 / 4;
            }
            int i16 = (i10 >>> 9) & 1;
            this.f54455g = v.k(i11, i12);
            if (i12 == 3) {
                int i17 = i11 == 3 ? v.f54444c[i13 - 1] : v.f54445d[i13 - 1];
                this.f54454f = i17;
                this.f54451c = (((i17 * 12) / this.f54452d) + i16) * 4;
            } else {
                if (i11 == 3) {
                    int i18 = i12 == 2 ? v.f54446e[i13 - 1] : v.f54447f[i13 - 1];
                    this.f54454f = i18;
                    this.f54451c = ((i18 * 144) / this.f54452d) + i16;
                } else {
                    int i19 = v.f54448g[i13 - 1];
                    this.f54454f = i19;
                    this.f54451c = (((i12 == 1 ? 72 : 144) * i19) / this.f54452d) + i16;
                }
            }
            this.f54453e = ((i10 >> 6) & 3) == 3 ? 1 : 2;
            return true;
        }
    }

    public static int j(int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        if (!l(i10) || (i11 = (i10 >>> 19) & 3) == 1 || (i12 = (i10 >>> 17) & 3) == 0 || (i13 = (i10 >>> 12) & 15) == 0 || i13 == 15 || (i14 = (i10 >>> 10) & 3) == 3) {
            return -1;
        }
        int i16 = f54443b[i14];
        if (i11 == 2) {
            i16 /= 2;
        } else if (i11 == 0) {
            i16 /= 4;
        }
        int i17 = (i10 >>> 9) & 1;
        if (i12 == 3) {
            return ((((i11 == 3 ? f54444c[i13 - 1] : f54445d[i13 - 1]) * 12) / i16) + i17) * 4;
        }
        if (i11 == 3) {
            i15 = i12 == 2 ? f54446e[i13 - 1] : f54447f[i13 - 1];
        } else {
            i15 = f54448g[i13 - 1];
        }
        if (i11 == 3) {
            return ((i15 * 144) / i16) + i17;
        }
        return (((i12 == 1 ? 72 : 144) * i15) / i16) + i17;
    }

    public static int k(int i10, int i11) {
        if (i11 == 1) {
            if (i10 == 3) {
                return 1152;
            }
            return MetricsProto.MetricsEvent.DIALOG_WIFI_P2P_CANCEL_CONNECT;
        }
        if (i11 == 2) {
            return 1152;
        }
        if (i11 == 3) {
            return 384;
        }
        throw new IllegalArgumentException();
    }

    public static boolean l(int i10) {
        return (i10 & (-2097152)) == -2097152;
    }

    public static int m(int i10) {
        int i11;
        int i12;
        if (!l(i10) || (i11 = (i10 >>> 19) & 3) == 1 || (i12 = (i10 >>> 17) & 3) == 0) {
            return -1;
        }
        int i13 = (i10 >>> 12) & 15;
        int i14 = (i10 >>> 10) & 3;
        if (i13 == 0 || i13 == 15 || i14 == 3) {
            return -1;
        }
        return k(i11, i12);
    }
}
