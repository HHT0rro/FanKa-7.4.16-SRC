package com.huawei.hms.scankit.p;

import com.android.internal.accessibility.common.ShortcutConstants;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.CharUtils;

/* compiled from: DecodedBitStreamParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
final class o1 {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f31343a = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f31344b;

    /* renamed from: c, reason: collision with root package name */
    private static final char[] f31345c;

    /* renamed from: d, reason: collision with root package name */
    private static final char[] f31346d;

    /* renamed from: e, reason: collision with root package name */
    private static final char[] f31347e;

    /* compiled from: DecodedBitStreamParser.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f31348a;

        static {
            int[] iArr = new int[b.values().length];
            f31348a = iArr;
            try {
                iArr[b.C40_ENCODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31348a[b.TEXT_ENCODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31348a[b.ANSIX12_ENCODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f31348a[b.EDIFACT_ENCODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f31348a[b.BASE256_ENCODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* compiled from: DecodedBitStreamParser.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum b {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE,
        UPPER_ENCODE
    }

    static {
        char[] cArr = {'!', '\"', '#', '$', '%', SymbolValues.CHAR_AND_SYMBOL, '\'', '(', ')', '*', '+', ',', '-', '.', IOUtils.DIR_SEPARATOR_UNIX, ShortcutConstants.SERVICES_SEPARATOR, ';', '<', '=', '>', '?', '@', '[', IOUtils.DIR_SEPARATOR_WINDOWS, ']', '^', '_'};
        f31344b = cArr;
        f31345c = new char[]{'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', Locale.PRIVATE_USE_EXTENSION, 'y', 'z'};
        f31346d = cArr;
        f31347e = new char[]{'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', 127};
    }

    public static w1 a(byte[] bArr, Map<l1, ?> map) throws com.huawei.hms.scankit.p.a {
        w wVar = new w(bArr);
        StringBuilder sb2 = new StringBuilder(100);
        StringBuilder sb3 = new StringBuilder(0);
        ArrayList arrayList = new ArrayList(1);
        b bVar = b.ASCII_ENCODE;
        do {
            b bVar2 = b.ASCII_ENCODE;
            if (bVar == bVar2) {
                bVar = a(wVar, sb2, sb3);
            } else {
                int i10 = a.f31348a[bVar.ordinal()];
                if (i10 == 1) {
                    b(wVar, sb2);
                } else if (i10 == 2) {
                    d(wVar, sb2);
                } else if (i10 == 3) {
                    a(wVar, sb2);
                } else if (i10 == 4) {
                    c(wVar, sb2);
                } else if (i10 == 5) {
                    a(wVar, sb2, arrayList);
                } else {
                    throw com.huawei.hms.scankit.p.a.a("AIScanException");
                }
                bVar = bVar2;
            }
            if (bVar == b.PAD_ENCODE) {
                break;
            }
        } while (wVar.a() > 0);
        if (sb3.length() > 0) {
            sb2.append((CharSequence) sb3);
        }
        int length = sb2.length();
        byte[] bArr2 = new byte[length];
        for (int i11 = 0; i11 < length; i11++) {
            bArr2[i11] = (byte) sb2.charAt(i11);
        }
        try {
            String str = new String(bArr2, c7.a(bArr2, map));
            if (arrayList.isEmpty()) {
                arrayList = null;
            }
            return new w1(bArr, str, arrayList, null);
        } catch (UnsupportedEncodingException unused) {
            throw com.huawei.hms.scankit.p.a.a();
        }
    }

    private static void b(w wVar, StringBuilder sb2) throws com.huawei.hms.scankit.p.a {
        int a10;
        int[] iArr = new int[3];
        boolean z10 = false;
        int i10 = 0;
        while (wVar.a() != 8 && (a10 = wVar.a(8)) != 254) {
            a(a10, wVar.a(8), iArr);
            for (int i11 = 0; i11 < 3; i11++) {
                int[] b4 = b(sb2, i10, iArr[i11], z10);
                i10 = b4[0];
                z10 = b4[1] == 1;
            }
            if (wVar.a() <= 0) {
                return;
            }
        }
    }

    private static void c(w wVar, StringBuilder sb2) {
        while (wVar.a() > 16) {
            for (int i10 = 0; i10 < 4; i10++) {
                int a10 = wVar.a(6);
                if (a10 == 31) {
                    int b4 = 8 - wVar.b();
                    if (b4 != 8) {
                        wVar.a(b4);
                        return;
                    }
                    return;
                }
                if ((a10 & 32) == 0) {
                    a10 |= 64;
                }
                sb2.append((char) a10);
            }
            if (wVar.a() <= 0) {
                return;
            }
        }
    }

    private static void d(w wVar, StringBuilder sb2) throws com.huawei.hms.scankit.p.a {
        int a10;
        int[] iArr = new int[3];
        boolean z10 = false;
        int i10 = 0;
        while (wVar.a() != 8 && (a10 = wVar.a(8)) != 254) {
            a(a10, wVar.a(8), iArr);
            for (int i11 = 0; i11 < 3; i11++) {
                int[] a11 = a(sb2, i10, iArr[i11], z10);
                i10 = a11[0];
                z10 = a11[1] == 1;
            }
            if (wVar.a() <= 0) {
                return;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [int[]] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    private static int[] b(StringBuilder sb2, int i10, int i11, boolean z10) throws com.huawei.hms.scankit.p.a {
        ?? r92;
        boolean z11;
        if (i10 == 0) {
            if (i11 < 3) {
                i10 = i11 + 1;
                r92 = z10;
                return new int[]{i10, r92};
            }
            char[] cArr = f31343a;
            if (i11 < cArr.length) {
                char c4 = cArr[i11];
                if (z10) {
                    c4 = (char) (c4 + 128);
                }
                sb2.append(c4);
                r92 = 0;
                return new int[]{i10, r92};
            }
            throw com.huawei.hms.scankit.p.a.a("AIScanException");
        }
        if (i10 == 1) {
            if (z10) {
                i11 += 128;
            }
            sb2.append((char) i11);
        } else {
            if (i10 == 2) {
                char[] cArr2 = f31344b;
                if (i11 < cArr2.length) {
                    char c10 = cArr2[i11];
                    if (z10) {
                        c10 = (char) (c10 + 128);
                    }
                    sb2.append(c10);
                    z11 = false;
                } else if (i11 == 27) {
                    sb2.append((char) 29);
                    z11 = z10;
                } else {
                    if (i11 != 30) {
                        throw com.huawei.hms.scankit.p.a.a("AIScanException");
                    }
                    z11 = true;
                }
                i10 = 0;
                r92 = z11;
                return new int[]{i10, r92};
            }
            if (i10 == 3) {
                sb2.append((char) (z10 ? i11 + 224 : i11 + 96));
            } else {
                throw com.huawei.hms.scankit.p.a.a("AIScanException");
            }
        }
        i10 = 0;
        r92 = 0;
        return new int[]{i10, r92};
    }

    private static b a(w wVar, StringBuilder sb2, StringBuilder sb3) throws com.huawei.hms.scankit.p.a {
        boolean z10 = false;
        do {
            int a10 = wVar.a(8);
            if (a10 == 0) {
                throw com.huawei.hms.scankit.p.a.a("AIScanException");
            }
            if (a10 <= 128) {
                if (z10) {
                    a10 += 128;
                }
                sb2.append((char) (a10 - 1));
                return b.ASCII_ENCODE;
            }
            if (a10 == 129) {
                return b.PAD_ENCODE;
            }
            if (a10 <= 229) {
                int i10 = a10 - 130;
                if (i10 < 10) {
                    sb2.append('0');
                }
                sb2.append(i10);
            } else {
                b a11 = a(a10, sb2, sb3, wVar);
                if (a11 != null) {
                    if (a11 != b.UPPER_ENCODE) {
                        return a11;
                    }
                    z10 = true;
                }
            }
        } while (wVar.a() > 0);
        return b.ASCII_ENCODE;
    }

    private static b a(int i10, StringBuilder sb2, StringBuilder sb3, w wVar) throws com.huawei.hms.scankit.p.a {
        switch (i10) {
            case 230:
                return b.C40_ENCODE;
            case 231:
                return b.BASE256_ENCODE;
            case 232:
                sb2.append((char) 29);
                return null;
            case 233:
            case 234:
            case 241:
                return null;
            case 235:
                return b.UPPER_ENCODE;
            case 236:
                sb2.append("[)>\u001e05\u001d");
                sb3.insert(0, "\u001e\u0004");
                return null;
            case 237:
                sb2.append("[)>\u001e06\u001d");
                sb3.insert(0, "\u001e\u0004");
                return null;
            case 238:
                return b.ANSIX12_ENCODE;
            case 239:
                return b.TEXT_ENCODE;
            case 240:
                return b.EDIFACT_ENCODE;
            default:
                if (i10 == 254 && wVar.a() == 0) {
                    return null;
                }
                throw com.huawei.hms.scankit.p.a.a("AIScanException");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [int[]] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    private static int[] a(StringBuilder sb2, int i10, int i11, boolean z10) throws com.huawei.hms.scankit.p.a {
        ?? r92;
        boolean z11;
        if (i10 == 0) {
            if (i11 < 3) {
                i10 = i11 + 1;
                r92 = z10;
                return new int[]{i10, r92};
            }
            char[] cArr = f31345c;
            if (i11 < cArr.length) {
                char c4 = cArr[i11];
                if (z10) {
                    c4 = (char) (c4 + 128);
                }
                sb2.append(c4);
                r92 = 0;
                return new int[]{i10, r92};
            }
            throw com.huawei.hms.scankit.p.a.a("AIScanException");
        }
        if (i10 == 1) {
            if (z10) {
                i11 = (char) (i11 + 128);
            }
            sb2.append(i11);
        } else {
            if (i10 == 2) {
                char[] cArr2 = f31346d;
                if (i11 < cArr2.length) {
                    char c10 = cArr2[i11];
                    if (z10) {
                        c10 = (char) (c10 + 128);
                    }
                    sb2.append(c10);
                    z11 = false;
                } else if (i11 == 27) {
                    sb2.append((char) 29);
                    z11 = z10;
                } else {
                    if (i11 != 30) {
                        throw com.huawei.hms.scankit.p.a.a("AIScanException");
                    }
                    z11 = true;
                }
                i10 = 0;
                r92 = z11;
                return new int[]{i10, r92};
            }
            if (i10 == 3) {
                char[] cArr3 = f31347e;
                if (i11 < cArr3.length) {
                    char c11 = cArr3[i11];
                    if (z10) {
                        c11 = (char) (c11 + 128);
                    }
                    sb2.append(c11);
                } else {
                    throw com.huawei.hms.scankit.p.a.a("AIScanException");
                }
            } else {
                throw com.huawei.hms.scankit.p.a.a("AIScanException");
            }
        }
        i10 = 0;
        r92 = 0;
        return new int[]{i10, r92};
    }

    private static void a(w wVar, StringBuilder sb2) throws com.huawei.hms.scankit.p.a {
        int a10;
        int[] iArr = new int[3];
        while (wVar.a() != 8 && (a10 = wVar.a(8)) != 254) {
            a(a10, wVar.a(8), iArr);
            for (int i10 = 0; i10 < 3; i10++) {
                int i11 = iArr[i10];
                if (i11 == 0) {
                    sb2.append(CharUtils.CR);
                } else if (i11 == 1) {
                    sb2.append('*');
                } else if (i11 == 2) {
                    sb2.append('>');
                } else if (i11 == 3) {
                    sb2.append(' ');
                } else if (i11 < 14) {
                    sb2.append((char) (i11 + 44));
                } else if (i11 < 40) {
                    sb2.append((char) (i11 + 51));
                } else {
                    throw com.huawei.hms.scankit.p.a.a("AIScanException");
                }
            }
            if (wVar.a() <= 0) {
                return;
            }
        }
    }

    private static void a(int i10, int i11, int[] iArr) {
        int i12 = ((i10 << 8) + i11) - 1;
        int i13 = i12 / 1600;
        iArr[0] = i13;
        int i14 = i12 - (i13 * 1600);
        int i15 = i14 / 40;
        iArr[1] = i15;
        iArr[2] = i14 - (i15 * 40);
    }

    private static void a(w wVar, StringBuilder sb2, Collection<byte[]> collection) throws com.huawei.hms.scankit.p.a {
        int c4 = wVar.c() + 1;
        int i10 = c4 + 1;
        int a10 = a(wVar.a(8), c4);
        if (a10 == 0) {
            a10 = wVar.a() / 8;
        } else if (a10 >= 250) {
            a10 = ((a10 - 249) * 250) + a(wVar.a(8), i10);
            i10++;
        }
        if (a10 >= 0) {
            byte[] bArr = new byte[a10];
            int i11 = 0;
            while (i11 < a10) {
                if (wVar.a() >= 8) {
                    bArr[i11] = (byte) a(wVar.a(8), i10);
                    i11++;
                    i10++;
                } else {
                    throw com.huawei.hms.scankit.p.a.a("AIScanException");
                }
            }
            collection.add(bArr);
            try {
                sb2.append(new String(bArr, "ISO8859_1"));
                return;
            } catch (UnsupportedEncodingException e2) {
                throw new IllegalStateException("Platform does not support required encoding: " + ((Object) e2));
            }
        }
        throw com.huawei.hms.scankit.p.a.a("AIScanException");
    }

    private static int a(int i10, int i11) {
        int i12 = i10 - (((i11 * 149) % 255) + 1);
        return i12 >= 0 ? i12 : i12 + 256;
    }
}
