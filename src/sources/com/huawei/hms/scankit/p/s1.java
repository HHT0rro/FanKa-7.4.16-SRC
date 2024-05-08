package com.huawei.hms.scankit.p;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.google.android.material.badge.BadgeDrawable;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import com.huawei.hms.ads.ContentClassification;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Map;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import sun.util.locale.LanguageTag;

/* compiled from: Decoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class s1 {

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f31483b = {"CTRL_PS", " ", "A", "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", ContentClassification.AD_CONTENT_CLASSIFICATION_J, "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f31484c = {"CTRL_PS", " ", "a", "b", "c", "d", "e", "f", "g", "h", com.kuaishou.weapon.p0.t.f36220e, "j", "k", "l", "m", "n", "o", com.kuaishou.weapon.p0.t.f36217b, "q", com.kuaishou.weapon.p0.t.f36226k, com.kuaishou.weapon.p0.t.f36222g, "t", com.kuaishou.weapon.p0.t.f36224i, com.kuaishou.weapon.p0.t.f36218c, IAdInterListener.AdReqParam.WIDTH, LanguageTag.PRIVATEUSE, "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f31485d = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", StringUtils.CR, "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};

    /* renamed from: e, reason: collision with root package name */
    private static final String[] f31486e = {"", StringUtils.CR, IOUtils.LINE_SEPARATOR_WINDOWS, ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", com.huawei.appgallery.agd.common.utils.StringUtils.NO_PRINT_CODE, BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX, ",", "-", ".", "/", com.huawei.openalliance.ad.constant.u.bD, ";", "<", "=", ">", SymbolValues.QUESTION_EN_SYMBOL, "[", "]", "{", com.alipay.sdk.util.i.f4738d, "CTRL_UL"};

    /* renamed from: f, reason: collision with root package name */
    private static final String[] f31487f = {"CTRL_PS", " ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ",", ".", "CTRL_UL", "CTRL_US"};

    /* renamed from: a, reason: collision with root package name */
    private g f31488a;

    /* compiled from: Decoder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f31489a;

        static {
            int[] iArr = new int[b.values().length];
            f31489a = iArr;
            try {
                iArr[b.UPPER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31489a[b.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31489a[b.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f31489a[b.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f31489a[b.DIGIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* compiled from: Decoder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum b {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    private static int a(int i10, boolean z10) {
        return ((z10 ? 88 : 112) + (i10 * 16)) * i10;
    }

    private boolean[] b(boolean[] zArr) throws com.huawei.hms.scankit.p.a {
        o3 o3Var;
        g gVar = this.f31488a;
        if (gVar != null) {
            int i10 = 8;
            if (gVar.f() <= 2) {
                i10 = 6;
                o3Var = o3.f31363j;
            } else if (this.f31488a.f() <= 8) {
                o3Var = o3.f31367n;
            } else if (this.f31488a.f() <= 22) {
                i10 = 10;
                o3Var = o3.f31362i;
            } else {
                i10 = 12;
                o3Var = o3.f31361h;
            }
            int e2 = this.f31488a.e();
            int length = zArr.length / i10;
            if (length >= e2) {
                int length2 = zArr.length % i10;
                int[] iArr = new int[length];
                int i11 = 0;
                while (i11 < length) {
                    iArr[i11] = a(zArr, length2, i10);
                    i11++;
                    length2 += i10;
                }
                try {
                    new p6(o3Var).a(iArr, length - e2);
                    return a(e2, i10, iArr);
                } catch (com.huawei.hms.scankit.p.a e10) {
                    throw com.huawei.hms.scankit.p.a.a(e10.getMessage());
                }
            }
            throw com.huawei.hms.scankit.p.a.a();
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    public w1 a(g gVar, Map<l1, ?> map) throws com.huawei.hms.scankit.p.a {
        this.f31488a = gVar;
        boolean[] b4 = b(a(gVar.a()));
        w1 w1Var = new w1(a(b4), a(b4, map), null, null);
        w1Var.a(b4.length);
        return w1Var;
    }

    private static String a(boolean[] zArr, Map<l1, ?> map) throws com.huawei.hms.scankit.p.a {
        b bVar = b.UPPER;
        StringBuilder a10 = a(zArr, bVar, bVar);
        int length = a10.length();
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            bArr[i10] = (byte) a10.charAt(i10);
        }
        try {
            return new String(bArr, c7.a(bArr, map));
        } catch (UnsupportedEncodingException unused) {
            throw com.huawei.hms.scankit.p.a.a();
        }
    }

    private static StringBuilder a(boolean[] zArr, b bVar, b bVar2) {
        int length = zArr.length;
        StringBuilder sb2 = new StringBuilder(20);
        int i10 = 0;
        while (i10 < length) {
            if (bVar2 != b.BINARY) {
                int i11 = bVar2 == b.DIGIT ? 4 : 5;
                if (length - i10 < i11) {
                    break;
                }
                int a10 = a(zArr, i10, i11);
                i10 += i11;
                String a11 = a(bVar2, a10);
                if (a11.startsWith("CTRL_")) {
                    bVar = a(a11.charAt(5));
                    if (a11.charAt(6) != 'L') {
                        b bVar3 = bVar2;
                        bVar2 = bVar;
                        bVar = bVar3;
                    }
                } else {
                    sb2.append(a11);
                }
                bVar2 = bVar;
            } else {
                if (length - i10 < 5) {
                    break;
                }
                int a12 = a(zArr, i10, 5);
                i10 += 5;
                if (a12 == 0) {
                    if (length - i10 < 11) {
                        break;
                    }
                    a12 = a(zArr, i10, 11) + 31;
                    i10 += 11;
                }
                int i12 = 0;
                while (true) {
                    if (i12 >= a12) {
                        break;
                    }
                    if (length - i10 < 8) {
                        i10 = length;
                        break;
                    }
                    sb2.append((char) a(zArr, i10, 8));
                    i10 += 8;
                    i12++;
                }
                bVar2 = bVar;
            }
        }
        return sb2;
    }

    private static b a(char c4) {
        if (c4 == 'B') {
            return b.BINARY;
        }
        if (c4 == 'D') {
            return b.DIGIT;
        }
        if (c4 == 'P') {
            return b.PUNCT;
        }
        if (c4 == 'L') {
            return b.LOWER;
        }
        if (c4 != 'M') {
            return b.UPPER;
        }
        return b.MIXED;
    }

    private static String a(b bVar, int i10) {
        int i11 = a.f31489a[bVar.ordinal()];
        if (i11 == 1) {
            return f31483b[i10];
        }
        if (i11 == 2) {
            return f31484c[i10];
        }
        if (i11 == 3) {
            return f31485d[i10];
        }
        if (i11 == 4) {
            return f31486e[i10];
        }
        if (i11 == 5) {
            return f31487f[i10];
        }
        throw new IllegalStateException("Bad table");
    }

    private boolean[] a(int i10, int i11, int[] iArr) throws com.huawei.hms.scankit.p.a {
        int i12 = (1 << i11) - 1;
        int i13 = 0;
        for (int i14 = 0; i14 < i10; i14++) {
            int i15 = iArr[i14];
            if (i15 == 0 || i15 == i12) {
                throw com.huawei.hms.scankit.p.a.a();
            }
            if (i15 == 1 || i15 == i12 - 1) {
                i13++;
            }
        }
        boolean[] zArr = new boolean[(i10 * i11) - i13];
        int i16 = 0;
        for (int i17 = 0; i17 < i10; i17++) {
            int i18 = iArr[i17];
            if (i18 == 1 || i18 == i12 - 1) {
                Arrays.fill(zArr, i16, (i16 + i11) - 1, i18 > 1);
                i16 += i11 - 1;
            } else {
                int i19 = i11 - 1;
                while (i19 >= 0) {
                    int i20 = i16 + 1;
                    zArr[i16] = ((1 << i19) & i18) != 0;
                    i19--;
                    i16 = i20;
                }
            }
        }
        return zArr;
    }

    private boolean[] a(s sVar) {
        g gVar = this.f31488a;
        boolean z10 = gVar != null && gVar.g();
        g gVar2 = this.f31488a;
        int f10 = gVar2 != null ? gVar2.f() : 0;
        int i10 = (z10 ? 11 : 14) + (f10 * 4);
        int[] iArr = new int[i10];
        boolean[] zArr = new boolean[a(f10, z10)];
        int i11 = 2;
        if (z10) {
            for (int i12 = 0; i12 < i10; i12++) {
                iArr[i12] = i12;
            }
        } else {
            int i13 = i10 / 2;
            int i14 = ((i10 + 1) + (((i13 - 1) / 15) * 2)) / 2;
            for (int i15 = 0; i15 < i13; i15++) {
                int i16 = (i15 / 15) + i15;
                iArr[(i13 - i15) - 1] = (i14 - i16) - 1;
                iArr[i13 + i15] = i16 + i14 + 1;
            }
        }
        int i17 = 0;
        int i18 = 0;
        while (i17 < f10) {
            int i19 = ((f10 - i17) * 4) + (z10 ? 9 : 12);
            int i20 = i17 * 2;
            int i21 = (i10 - 1) - i20;
            int i22 = 0;
            while (i22 < i19) {
                int i23 = i22 * 2;
                int i24 = 0;
                while (i24 < i11) {
                    int i25 = i20 + i24;
                    int i26 = i20 + i22;
                    zArr[i18 + i23 + i24] = sVar.b(iArr[i25], iArr[i26]);
                    int i27 = i21 - i24;
                    zArr[(i19 * 2) + i18 + i23 + i24] = sVar.b(iArr[i26], iArr[i27]);
                    int i28 = i21 - i22;
                    zArr[(i19 * 4) + i18 + i23 + i24] = sVar.b(iArr[i27], iArr[i28]);
                    zArr[(i19 * 6) + i18 + i23 + i24] = sVar.b(iArr[i28], iArr[i25]);
                    i24++;
                    z10 = z10;
                    i11 = 2;
                }
                i22++;
                i11 = 2;
            }
            i18 += i19 * 8;
            i17++;
            i11 = 2;
        }
        return zArr;
    }

    private static int a(boolean[] zArr, int i10, int i11) {
        int i12 = 0;
        for (int i13 = i10; i13 < i10 + i11; i13++) {
            i12 <<= 1;
            if (zArr[i13]) {
                i12 |= 1;
            }
        }
        return i12;
    }

    private static byte a(boolean[] zArr, int i10) {
        int a10;
        int length = zArr.length - i10;
        if (length >= 8) {
            a10 = a(zArr, i10, 8);
        } else {
            a10 = a(zArr, i10, length) << (8 - length);
        }
        return (byte) a10;
    }

    public static byte[] a(boolean[] zArr) {
        int length = (zArr.length + 7) / 8;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            bArr[i10] = a(zArr, i10 * 8);
        }
        return bArr;
    }
}
