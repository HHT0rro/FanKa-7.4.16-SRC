package x4;

import com.google.android.exoplayer2.ParserException;

/* compiled from: AacUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f54361a = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f54362b = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    /* compiled from: AacUtil.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f54363a;

        /* renamed from: b, reason: collision with root package name */
        public final int f54364b;

        /* renamed from: c, reason: collision with root package name */
        public final String f54365c;

        public b(int i10, int i11, String str) {
            this.f54363a = i10;
            this.f54364b = i11;
            this.f54365c = str;
        }
    }

    public static byte[] a(int i10, int i11) {
        int i12 = 0;
        int i13 = 0;
        int i14 = -1;
        while (true) {
            int[] iArr = f54361a;
            if (i13 >= iArr.length) {
                break;
            }
            if (i10 == iArr[i13]) {
                i14 = i13;
            }
            i13++;
        }
        int i15 = -1;
        while (true) {
            int[] iArr2 = f54362b;
            if (i12 >= iArr2.length) {
                break;
            }
            if (i11 == iArr2[i12]) {
                i15 = i12;
            }
            i12++;
        }
        if (i10 != -1 && i15 != -1) {
            return b(2, i14, i15);
        }
        StringBuilder sb2 = new StringBuilder(67);
        sb2.append("Invalid sample rate or number of channels: ");
        sb2.append(i10);
        sb2.append(", ");
        sb2.append(i11);
        throw new IllegalArgumentException(sb2.toString());
    }

    public static byte[] b(int i10, int i11, int i12) {
        return new byte[]{(byte) (((i10 << 3) & 248) | ((i11 >> 1) & 7)), (byte) (((i11 << 7) & 128) | ((i12 << 3) & 120))};
    }

    public static int c(com.google.android.exoplayer2.util.u uVar) {
        int h10 = uVar.h(5);
        return h10 == 31 ? uVar.h(6) + 32 : h10;
    }

    public static int d(int i10) {
        if (i10 == 2) {
            return 10;
        }
        if (i10 == 5) {
            return 11;
        }
        if (i10 == 29) {
            return 12;
        }
        if (i10 == 42) {
            return 16;
        }
        if (i10 != 22) {
            return i10 != 23 ? 0 : 15;
        }
        return 1073741824;
    }

    public static int e(com.google.android.exoplayer2.util.u uVar) throws ParserException {
        int h10 = uVar.h(4);
        if (h10 == 15) {
            return uVar.h(24);
        }
        if (h10 < 13) {
            return f54361a[h10];
        }
        throw ParserException.createForMalformedContainer(null, null);
    }

    public static b f(com.google.android.exoplayer2.util.u uVar, boolean z10) throws ParserException {
        int c4 = c(uVar);
        int e2 = e(uVar);
        int h10 = uVar.h(4);
        StringBuilder sb2 = new StringBuilder(19);
        sb2.append("mp4a.40.");
        sb2.append(c4);
        String sb3 = sb2.toString();
        if (c4 == 5 || c4 == 29) {
            e2 = e(uVar);
            c4 = c(uVar);
            if (c4 == 22) {
                h10 = uVar.h(4);
            }
        }
        if (z10) {
            if (c4 != 1 && c4 != 2 && c4 != 3 && c4 != 4 && c4 != 6 && c4 != 7 && c4 != 17) {
                switch (c4) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        StringBuilder sb4 = new StringBuilder(42);
                        sb4.append("Unsupported audio object type: ");
                        sb4.append(c4);
                        throw ParserException.createForUnsupportedContainerFeature(sb4.toString());
                }
            }
            h(uVar, c4, h10);
            switch (c4) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int h11 = uVar.h(2);
                    if (h11 == 2 || h11 == 3) {
                        StringBuilder sb5 = new StringBuilder(33);
                        sb5.append("Unsupported epConfig: ");
                        sb5.append(h11);
                        throw ParserException.createForUnsupportedContainerFeature(sb5.toString());
                    }
            }
        }
        int i10 = f54362b[h10];
        if (i10 != -1) {
            return new b(e2, i10, sb3);
        }
        throw ParserException.createForMalformedContainer(null, null);
    }

    public static b g(byte[] bArr) throws ParserException {
        return f(new com.google.android.exoplayer2.util.u(bArr), false);
    }

    public static void h(com.google.android.exoplayer2.util.u uVar, int i10, int i11) {
        if (uVar.g()) {
            com.google.android.exoplayer2.util.m.h("AacUtil", "Unexpected frameLengthFlag = 1");
        }
        if (uVar.g()) {
            uVar.r(14);
        }
        boolean g3 = uVar.g();
        if (i11 == 0) {
            throw new UnsupportedOperationException();
        }
        if (i10 == 6 || i10 == 20) {
            uVar.r(3);
        }
        if (g3) {
            if (i10 == 22) {
                uVar.r(16);
            }
            if (i10 == 17 || i10 == 19 || i10 == 20 || i10 == 23) {
                uVar.r(3);
            }
            uVar.r(1);
        }
    }
}
