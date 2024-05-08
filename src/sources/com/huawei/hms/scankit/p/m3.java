package com.huawei.hms.scankit.p;

import com.android.internal.logging.nano.MetricsProto;
import com.tencent.rtmp.TXLiveConstants;

/* compiled from: FormatInformation.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
final class m3 {

    /* renamed from: c, reason: collision with root package name */
    private static final int[][] f31267c = {new int[]{21522, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{MetricsProto.MetricsEvent.DIALOG_USER_SETUP_PROFILE, 21}, new int[]{3340, 22}, new int[]{TXLiveConstants.PLAY_WARNING_VIDEO_DISCONTINUITY, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};

    /* renamed from: a, reason: collision with root package name */
    private final c3 f31268a;

    /* renamed from: b, reason: collision with root package name */
    private final byte f31269b;

    private m3(int i10) {
        this.f31268a = c3.a((i10 >> 3) & 3);
        this.f31269b = (byte) (i10 & 7);
    }

    public static m3 a(int i10, int i11) {
        m3 b4 = b(i10, i11);
        return b4 != null ? b4 : b(i10 ^ 21522, i11 ^ 21522);
    }

    private static m3 b(int i10, int i11) {
        int c4;
        int i12 = Integer.MAX_VALUE;
        int i13 = 0;
        for (int[] iArr : f31267c) {
            int i14 = iArr[0];
            if (i14 != i10 && i14 != i11) {
                int c10 = c(i10, i14);
                if (c10 < i12) {
                    i13 = iArr[1];
                    i12 = c10;
                }
                if (i11 != i10 && (c4 = c(i11, i14)) < i12) {
                    i13 = iArr[1];
                    i12 = c4;
                }
            } else {
                return new m3(iArr[1]);
            }
        }
        if (i12 <= 3) {
            return new m3(i13);
        }
        return null;
    }

    public static int c(int i10, int i11) {
        return Integer.bitCount(i10 ^ i11);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof m3)) {
            return false;
        }
        m3 m3Var = (m3) obj;
        return this.f31268a == m3Var.f31268a && this.f31269b == m3Var.f31269b;
    }

    public int hashCode() {
        return (this.f31268a.ordinal() << 3) | this.f31269b;
    }

    public c3 a() {
        return this.f31268a;
    }

    public byte b() {
        return this.f31269b;
    }
}
