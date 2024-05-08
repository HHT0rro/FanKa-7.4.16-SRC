package com.huawei.hms.scankit.p;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.CharEncoding;

/* compiled from: CharacterSetECI.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public enum o0 {
    Cp437(new int[]{0, 2}, new String[0]),
    ISO8859_1(new int[]{1, 3}, CharEncoding.ISO_8859_1),
    ISO8859_2(4, "ISO-8859-2"),
    ISO8859_3(5, "ISO-8859-3"),
    ISO8859_4(6, "ISO-8859-4"),
    ISO8859_5(7, "ISO-8859-5"),
    ISO8859_6(8, "ISO-8859-6"),
    ISO8859_7(9, "ISO-8859-7"),
    ISO8859_8(10, "ISO-8859-8"),
    ISO8859_9(11, "ISO-8859-9"),
    ISO8859_10(12, "ISO-8859-10"),
    ISO8859_11(13, "ISO-8859-11"),
    ISO8859_13(15, "ISO-8859-13"),
    ISO8859_14(16, "ISO-8859-14"),
    ISO8859_15(17, "ISO-8859-15"),
    ISO8859_16(18, "ISO-8859-16"),
    SJIS(20, "Shift_JIS"),
    Cp1250(21, "windows-1250"),
    Cp1251(22, "windows-1251"),
    Cp1252(23, "windows-1252"),
    Cp1256(24, "windows-1256"),
    UnicodeBigUnmarked(25, CharEncoding.UTF_16BE, "UnicodeBig"),
    UTF8(26, "UTF-8"),
    ASCII(new int[]{27, 170}, CharEncoding.US_ASCII),
    Big5(28),
    GB18030(29, "GB2312", "EUC_CN", "GBK"),
    EUC_KR(30, "EUC-KR");

    private static final Map<Integer, o0> D = new HashMap();
    private static final Map<String, o0> E = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    private final int[] f31341a;

    /* renamed from: b, reason: collision with root package name */
    private final String[] f31342b;

    static {
        for (o0 o0Var : values()) {
            for (int i10 : o0Var.f31341a) {
                D.put(Integer.valueOf(i10), o0Var);
            }
            E.put(o0Var.name(), o0Var);
            for (String str : o0Var.f31342b) {
                E.put(str, o0Var);
            }
        }
    }

    o0(int i10) {
        this(new int[]{i10}, new String[0]);
    }

    public int a() {
        return this.f31341a[0];
    }

    o0(int i10, String... strArr) {
        this.f31341a = new int[]{i10};
        this.f31342b = strArr;
    }

    public static o0 a(int i10) throws a {
        if (i10 >= 0 && i10 < 900) {
            return D.get(Integer.valueOf(i10));
        }
        throw a.a();
    }

    public static o0 a(String str) {
        return E.get(str);
    }

    o0(int[] iArr, String... strArr) {
        this.f31341a = iArr;
        this.f31342b = strArr;
    }
}
