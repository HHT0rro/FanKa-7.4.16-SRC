package com.huawei.hms.scankit.p;

import com.android.internal.logging.nano.MetricsProto;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;

/* compiled from: DecodedBitStreamParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
final class q1 {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f31409a = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f31410b = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();

    /* renamed from: c, reason: collision with root package name */
    private static final BigInteger[] f31411c;

    /* compiled from: DecodedBitStreamParser.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f31412a;

        static {
            int[] iArr = new int[b.values().length];
            f31412a = iArr;
            try {
                iArr[b.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31412a[b.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31412a[b.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f31412a[b.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f31412a[b.ALPHA_SHIFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f31412a[b.PUNCT_SHIFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* compiled from: DecodedBitStreamParser.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum b {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        f31411c = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900L);
        bigIntegerArr[1] = valueOf;
        int i10 = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = f31411c;
            if (i10 >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i10] = bigIntegerArr2[i10 - 1].multiply(valueOf);
            i10++;
        }
    }

    public static w1 a(int[] iArr, String str, Map<l1, ?> map) throws com.huawei.hms.scankit.p.a {
        int i10;
        int a10;
        StringBuilder sb2 = new StringBuilder(iArr.length * 2);
        Charset charset = StandardCharsets.ISO_8859_1;
        int i11 = iArr[1];
        s5 s5Var = new s5();
        Charset charset2 = charset;
        int i12 = i11;
        int i13 = 2;
        while (true) {
            if (i13 > iArr[0] || (i13 == iArr[0] && sb2.length() > 0)) {
                break;
            }
            if (i12 == 927) {
                a10 = i13 + 1;
                charset2 = Charset.forName(o0.a(iArr[i13]).name());
            } else {
                a10 = a(sb2, i12, iArr, i13, charset2, s5Var);
            }
            if (a10 < iArr.length) {
                i13 = a10 + 1;
                i12 = iArr[a10];
            } else {
                throw com.huawei.hms.scankit.p.a.a();
            }
        }
        if (sb2.length() != 0) {
            if (charset2 == StandardCharsets.ISO_8859_1) {
                int length = sb2.length();
                byte[] bArr = new byte[length];
                for (i10 = 0; i10 < length; i10++) {
                    bArr[i10] = (byte) sb2.charAt(i10);
                }
                try {
                    w1 w1Var = new w1(null, new String(bArr, c7.a(bArr, map)), null, str);
                    w1Var.a(s5Var);
                    return w1Var;
                } catch (UnsupportedEncodingException unused) {
                    throw com.huawei.hms.scankit.p.a.a();
                }
            }
            w1 w1Var2 = new w1(null, sb2.toString(), null, str);
            w1Var2.a(s5Var);
            return w1Var2;
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    private static boolean a(int i10) {
        return i10 == 901 || i10 == 924 || i10 == 902 || i10 == 928 || i10 == 923 || i10 == 922;
    }

    private static int b(int[] iArr, int i10, StringBuilder sb2) throws com.huawei.hms.scankit.p.a {
        int[] iArr2 = new int[(iArr[0] - i10) * 2];
        int[] iArr3 = new int[(iArr[0] - i10) * 2];
        boolean z10 = false;
        int i11 = 0;
        while (i10 < iArr[0] && !z10) {
            int i12 = i10 + 1;
            int i13 = iArr[i10];
            if (i13 < 900) {
                iArr2[i11] = i13 / 30;
                iArr2[i11 + 1] = i13 % 30;
                i11 += 2;
            } else if (i13 == 900) {
                iArr2[i11] = 900;
                i11++;
            } else if (i13 == 913) {
                iArr2[i11] = 913;
                i10 = i12 + 1;
                iArr3[i11] = iArr[i12];
                i11++;
            } else {
                if (!a(i13)) {
                    throw com.huawei.hms.scankit.p.a.a();
                }
                i10 = i12 - 1;
                z10 = true;
            }
            i10 = i12;
        }
        a(iArr2, iArr3, i11, sb2);
        return i10;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x001b. Please report as an issue. */
    private static b[] c(StringBuilder sb2, int[] iArr, b bVar, b bVar2, int[] iArr2) throws com.huawei.hms.scankit.p.a {
        b bVar3;
        if (iArr2[1] < 26) {
            iArr2[2] = (char) (iArr2[1] + 97);
        } else {
            int i10 = iArr2[1];
            if (i10 == 900) {
                bVar = b.ALPHA;
            } else if (i10 != 913) {
                switch (i10) {
                    case 26:
                        iArr2[2] = 32;
                        break;
                    case 27:
                        bVar3 = b.ALPHA_SHIFT;
                        bVar2 = bVar;
                        bVar = bVar3;
                        break;
                    case 28:
                        bVar = b.MIXED;
                        break;
                    case 29:
                        bVar3 = b.PUNCT_SHIFT;
                        bVar2 = bVar;
                        bVar = bVar3;
                        break;
                    default:
                        throw com.huawei.hms.scankit.p.a.a();
                }
            } else {
                sb2.append((char) iArr[iArr2[0]]);
            }
        }
        return new b[]{bVar, bVar2};
    }

    private static b[] d(StringBuilder sb2, int[] iArr, b bVar, b bVar2, int[] iArr2) throws com.huawei.hms.scankit.p.a {
        if (iArr2[1] < 25) {
            iArr2[2] = f31410b[iArr2[1]];
        } else {
            int i10 = iArr2[1];
            if (i10 != 900) {
                if (i10 != 913) {
                    switch (i10) {
                        case 25:
                            bVar = b.PUNCT;
                            break;
                        case 26:
                            iArr2[2] = 32;
                            break;
                        case 27:
                            bVar = b.LOWER;
                            break;
                        case 28:
                            break;
                        case 29:
                            bVar2 = bVar;
                            bVar = b.PUNCT_SHIFT;
                            break;
                        default:
                            throw com.huawei.hms.scankit.p.a.a();
                    }
                } else {
                    sb2.append((char) iArr[iArr2[0]]);
                }
            }
            bVar = b.ALPHA;
        }
        return new b[]{bVar, bVar2};
    }

    private static b[] e(StringBuilder sb2, int[] iArr, b bVar, b bVar2, int[] iArr2) throws com.huawei.hms.scankit.p.a {
        if (iArr2[1] < 29) {
            iArr2[2] = f31409a[iArr2[1]];
        } else {
            int i10 = iArr2[1];
            if (i10 == 29 || i10 == 900) {
                bVar = b.ALPHA;
            } else if (i10 == 913) {
                sb2.append((char) iArr[iArr2[0]]);
            } else {
                throw com.huawei.hms.scankit.p.a.a();
            }
        }
        return new b[]{bVar, bVar2};
    }

    private static b[] f(StringBuilder sb2, int[] iArr, b bVar, b bVar2, int[] iArr2) throws com.huawei.hms.scankit.p.a {
        b bVar3;
        if (iArr2[1] < 29) {
            iArr2[2] = f31409a[iArr2[1]];
        } else {
            int i10 = iArr2[1];
            if (i10 == 29 || i10 == 900) {
                bVar3 = b.ALPHA;
                return new b[]{bVar3, bVar2};
            }
            if (i10 == 913) {
                sb2.append((char) iArr[iArr2[0]]);
            } else {
                throw com.huawei.hms.scankit.p.a.a();
            }
        }
        bVar3 = bVar2;
        return new b[]{bVar3, bVar2};
    }

    private static b[] b(StringBuilder sb2, int[] iArr, b bVar, b bVar2, int[] iArr2) throws com.huawei.hms.scankit.p.a {
        b bVar3;
        if (iArr2[1] < 26) {
            iArr2[2] = (char) (iArr2[1] + 65);
        } else {
            int i10 = iArr2[1];
            if (i10 != 26) {
                if (i10 == 900) {
                    bVar3 = b.ALPHA;
                    return new b[]{bVar3, bVar2};
                }
                throw com.huawei.hms.scankit.p.a.a();
            }
            iArr2[2] = 32;
        }
        bVar3 = bVar2;
        return new b[]{bVar3, bVar2};
    }

    private static int a(StringBuilder sb2, int i10, int[] iArr, int i11, Charset charset, s5 s5Var) throws com.huawei.hms.scankit.p.a {
        if (i10 == 913) {
            int i12 = i11 + 1;
            sb2.append((char) iArr[i11]);
            return i12;
        }
        if (i10 != 928) {
            switch (i10) {
                case 900:
                    return b(iArr, i11, sb2);
                case 901:
                    break;
                case 902:
                    return a(iArr, i11, sb2);
                default:
                    switch (i10) {
                        case MetricsProto.MetricsEvent.ACCESSIBILITY_SCREEN_MAGNIFICATION_SETTINGS /* 922 */:
                        case MetricsProto.MetricsEvent.ACTION_SETTINGS_CLEAR_INSTANT_APP /* 923 */:
                            throw com.huawei.hms.scankit.p.a.a();
                        case MetricsProto.MetricsEvent.RESET_DASHBOARD /* 924 */:
                            break;
                        case MetricsProto.MetricsEvent.ACTION_QS_CLICK /* 925 */:
                            return i11 + 1;
                        case MetricsProto.MetricsEvent.ACTION_QS_SECONDARY_CLICK /* 926 */:
                            return i11 + 2;
                        default:
                            return b(iArr, i11 - 1, sb2);
                    }
            }
            return a(i10, iArr, charset, i11, sb2);
        }
        return a(iArr, i11, s5Var);
    }

    public static int a(int[] iArr, int i10, s5 s5Var) throws com.huawei.hms.scankit.p.a {
        int i11 = 0;
        if (i10 + 2 <= iArr[0]) {
            int[] iArr2 = new int[2];
            while (i11 < 2) {
                iArr2[i11] = iArr[i10];
                i11++;
                i10++;
            }
            try {
                s5Var.c(Integer.parseInt(a(iArr2, 2)));
                StringBuilder sb2 = new StringBuilder();
                int b4 = b(iArr, i10, sb2);
                s5Var.b(sb2.toString());
                int i12 = iArr[b4] == 923 ? b4 + 1 : -1;
                a(b4, iArr, s5Var);
                if (i12 != -1) {
                    int i13 = b4 - i12;
                    if (s5Var.a()) {
                        i13--;
                    }
                    s5Var.a(Arrays.copyOfRange(iArr, i12, i13 + i12));
                }
                return b4;
            } catch (Exception unused) {
                throw com.huawei.hms.scankit.p.a.a();
            }
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    private static void a(int i10, int[] iArr, s5 s5Var) throws com.huawei.hms.scankit.p.a {
        while (i10 < iArr[0]) {
            if (iArr[i10] == 923) {
                int i11 = i10 + 1;
                if (iArr[i11] == 0) {
                    StringBuilder sb2 = new StringBuilder();
                    i10 = b(iArr, i11 + 1, sb2);
                    s5Var.c(sb2.toString());
                } else if (iArr[i11] == 3) {
                    StringBuilder sb3 = new StringBuilder();
                    i10 = b(iArr, i11 + 1, sb3);
                    s5Var.d(sb3.toString());
                } else if (iArr[i11] == 4) {
                    StringBuilder sb4 = new StringBuilder();
                    i10 = b(iArr, i11 + 1, sb4);
                    s5Var.a(sb4.toString());
                } else if (iArr[i11] == 1) {
                    StringBuilder sb5 = new StringBuilder();
                    i10 = a(iArr, i11 + 1, sb5);
                    s5Var.b(Integer.parseInt(sb5.toString()));
                } else if (iArr[i11] == 2) {
                    StringBuilder sb6 = new StringBuilder();
                    i10 = a(iArr, i11 + 1, sb6);
                    s5Var.b(Long.parseLong(sb6.toString()));
                } else if (iArr[i11] == 6) {
                    StringBuilder sb7 = new StringBuilder();
                    i10 = a(iArr, i11 + 1, sb7);
                    s5Var.a(Integer.parseInt(sb7.toString()));
                } else if (iArr[i11] == 5) {
                    StringBuilder sb8 = new StringBuilder();
                    i10 = a(iArr, i11 + 1, sb8);
                    s5Var.a(Long.parseLong(sb8.toString()));
                } else {
                    throw com.huawei.hms.scankit.p.a.a();
                }
            } else if (iArr[i10] == 922) {
                i10++;
                s5Var.a(true);
            } else {
                throw com.huawei.hms.scankit.p.a.a();
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0022. Please report as an issue. */
    private static void a(int[] iArr, int[] iArr2, int i10, StringBuilder sb2) throws com.huawei.hms.scankit.p.a {
        b bVar = b.ALPHA;
        b bVar2 = bVar;
        int i11 = 0;
        while (i11 < i10) {
            int[] iArr3 = {i11, iArr[i11], 0};
            b[] bVarArr = {bVar, bVar2};
            switch (a.f31412a[bVar.ordinal()]) {
                case 1:
                    bVarArr = a(sb2, iArr2, bVar, bVar2, iArr3);
                    break;
                case 2:
                    bVarArr = c(sb2, iArr2, bVar, bVar2, iArr3);
                    break;
                case 3:
                    bVarArr = d(sb2, iArr2, bVar, bVar2, iArr3);
                    break;
                case 4:
                    bVarArr = e(sb2, iArr2, bVar, bVar2, iArr3);
                    break;
                case 5:
                    bVarArr = b(sb2, iArr2, bVar, bVar2, iArr3);
                    break;
                case 6:
                    bVarArr = f(sb2, iArr2, bVar, bVar2, iArr3);
                    break;
            }
            bVar = bVarArr[0];
            bVar2 = bVarArr[1];
            int i12 = iArr3[0];
            char c4 = (char) iArr3[2];
            if (c4 != 0) {
                sb2.append(c4);
            }
            i11 = 1 + i12;
        }
    }

    private static b[] a(StringBuilder sb2, int[] iArr, b bVar, b bVar2, int[] iArr2) throws com.huawei.hms.scankit.p.a {
        if (iArr2[1] < 26) {
            iArr2[2] = (char) (iArr2[1] + 65);
        } else {
            int i10 = iArr2[1];
            if (i10 == 900) {
                bVar = b.ALPHA;
            } else if (i10 != 913) {
                switch (i10) {
                    case 26:
                        iArr2[2] = 32;
                        break;
                    case 27:
                        bVar = b.LOWER;
                        break;
                    case 28:
                        bVar = b.MIXED;
                        break;
                    case 29:
                        bVar2 = bVar;
                        bVar = b.PUNCT_SHIFT;
                        break;
                    default:
                        throw com.huawei.hms.scankit.p.a.a();
                }
            } else {
                sb2.append((char) iArr[iArr2[0]]);
            }
        }
        return new b[]{bVar, bVar2};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0031. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x002e. Please report as an issue. */
    private static int a(int i10, int[] iArr, Charset charset, int i11, StringBuilder sb2) throws com.huawei.hms.scankit.p.a {
        int a10;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i12 = 0;
        long j10 = 0;
        boolean z10 = false;
        if (i10 == 901) {
            int[] iArr2 = new int[6];
            int i13 = i11 + 1;
            int i14 = iArr[i11];
            while (i13 < iArr[0] && !z10) {
                int i15 = i12 + 1;
                iArr2[i12] = i14;
                j10 = (j10 * 900) + i14;
                int i16 = i13 + 1;
                i14 = iArr[i13];
                if (i14 != 928) {
                    switch (i14) {
                        case 900:
                        case 901:
                        case 902:
                            break;
                        default:
                            switch (i14) {
                                case MetricsProto.MetricsEvent.ACCESSIBILITY_SCREEN_MAGNIFICATION_SETTINGS /* 922 */:
                                case MetricsProto.MetricsEvent.ACTION_SETTINGS_CLEAR_INSTANT_APP /* 923 */:
                                case MetricsProto.MetricsEvent.RESET_DASHBOARD /* 924 */:
                                    break;
                                default:
                                    if (i15 % 5 != 0 || i15 <= 0) {
                                        i13 = i16;
                                        i12 = i15;
                                        break;
                                    } else {
                                        for (int i17 = 0; i17 < 6; i17++) {
                                            byteArrayOutputStream.write((byte) (j10 >> ((5 - i17) * 8)));
                                        }
                                        j10 = 0;
                                        i13 = i16;
                                        i12 = 0;
                                        break;
                                    }
                                    break;
                            }
                    }
                }
                i13 = i16 - 1;
                z10 = true;
                i12 = i15;
            }
            if (i13 == iArr[0] && i14 < 900) {
                iArr2[i12] = i14;
                i12++;
            }
            for (int i18 = 0; i18 < i12; i18++) {
                byteArrayOutputStream.write((byte) iArr2[i18]);
            }
            a10 = i13;
        } else {
            a10 = i10 == 924 ? a(i11, iArr, false, 0, 0L, byteArrayOutputStream) : i11;
        }
        sb2.append(new String(byteArrayOutputStream.toByteArray(), charset));
        return a10;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x001d. Please report as an issue. */
    private static int a(int i10, int[] iArr, boolean z10, int i11, long j10, ByteArrayOutputStream byteArrayOutputStream) throws com.huawei.hms.scankit.p.a {
        while (i10 < iArr[0] && !z10) {
            int i12 = i10 + 1;
            int i13 = iArr[i10];
            if (i13 < 900) {
                i11++;
                j10 = (j10 * 900) + i13;
                i10 = i12;
            } else {
                if (i13 != 928) {
                    switch (i13) {
                        default:
                            switch (i13) {
                                case MetricsProto.MetricsEvent.ACCESSIBILITY_SCREEN_MAGNIFICATION_SETTINGS /* 922 */:
                                case MetricsProto.MetricsEvent.ACTION_SETTINGS_CLEAR_INSTANT_APP /* 923 */:
                                case MetricsProto.MetricsEvent.RESET_DASHBOARD /* 924 */:
                                    break;
                                default:
                                    throw com.huawei.hms.scankit.p.a.a();
                            }
                        case 900:
                        case 901:
                        case 902:
                            i10 = i12 - 1;
                            z10 = true;
                            break;
                    }
                }
                i10 = i12 - 1;
                z10 = true;
            }
            if (i11 % 5 == 0 && i11 > 0) {
                for (int i14 = 0; i14 < 6; i14++) {
                    byteArrayOutputStream.write((byte) (j10 >> ((5 - i14) * 8)));
                }
                j10 = 0;
                i11 = 0;
            }
        }
        return i10;
    }

    private static int a(int[] iArr, int i10, StringBuilder sb2) throws com.huawei.hms.scankit.p.a {
        int[] iArr2 = new int[15];
        boolean z10 = false;
        int i11 = 0;
        while (i10 < iArr[0] && !z10) {
            int i12 = i10 + 1;
            int i13 = iArr[i10];
            if (i12 == iArr[0]) {
                z10 = true;
            }
            if (i13 < 900) {
                iArr2[i11] = i13;
                i11++;
            } else {
                if (i13 != 900 && i13 != 901 && i13 != 928) {
                    switch (i13) {
                        case MetricsProto.MetricsEvent.ACCESSIBILITY_SCREEN_MAGNIFICATION_SETTINGS /* 922 */:
                        case MetricsProto.MetricsEvent.ACTION_SETTINGS_CLEAR_INSTANT_APP /* 923 */:
                        case MetricsProto.MetricsEvent.RESET_DASHBOARD /* 924 */:
                            break;
                        default:
                            throw com.huawei.hms.scankit.p.a.a();
                    }
                }
                i12--;
                z10 = true;
            }
            if ((i11 % 15 == 0 || i13 == 902 || z10) && i11 > 0) {
                sb2.append(a(iArr2, i11));
                i11 = 0;
            }
            i10 = i12;
        }
        return i10;
    }

    private static String a(int[] iArr, int i10) throws com.huawei.hms.scankit.p.a {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i11 = 0; i11 < i10; i11++) {
            bigInteger = bigInteger.add(f31411c[(i10 - i11) - 1].multiply(BigInteger.valueOf(iArr[i11])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw com.huawei.hms.scankit.p.a.a();
    }
}
