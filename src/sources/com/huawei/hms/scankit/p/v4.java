package com.huawei.hms.scankit.p;

/* compiled from: Mode.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public enum v4 {
    TERMINATOR(new int[]{0, 0, 0}, 0),
    NUMERIC(new int[]{10, 12, 14}, 1),
    ALPHANUMERIC(new int[]{9, 11, 13}, 2),
    STRUCTURED_APPEND(new int[]{0, 0, 0}, 3),
    BYTE(new int[]{8, 16, 16}, 4),
    ECI(new int[]{0, 0, 0}, 7),
    KANJI(new int[]{8, 10, 12}, 8),
    FNC1_FIRST_POSITION(new int[]{0, 0, 0}, 5),
    FNC1_SECOND_POSITION(new int[]{0, 0, 0}, 9),
    HEXADECIMAL(new int[]{8, 10, 12}, 10),
    HEXABYTE(new int[]{8, 10, 12}, 11),
    HANZI(new int[]{8, 10, 12}, 13);


    /* renamed from: a, reason: collision with root package name */
    private final int[] f31631a;

    /* renamed from: b, reason: collision with root package name */
    private final int f31632b;

    v4(int[] iArr, int i10) {
        this.f31631a = iArr;
        this.f31632b = i10;
    }

    public static v4 a(int i10) {
        switch (i10) {
            case 0:
                return TERMINATOR;
            case 1:
                return NUMERIC;
            case 2:
                return ALPHANUMERIC;
            case 3:
                return STRUCTURED_APPEND;
            case 4:
                return BYTE;
            case 5:
                return FNC1_FIRST_POSITION;
            case 6:
            case 12:
            default:
                throw new IllegalArgumentException();
            case 7:
                return ECI;
            case 8:
                return KANJI;
            case 9:
                return FNC1_SECOND_POSITION;
            case 10:
                return HEXADECIMAL;
            case 11:
                return HEXABYTE;
            case 13:
                return HANZI;
        }
    }

    public int a(a8 a8Var) {
        int m10 = a8Var.m();
        return this.f31631a[m10 <= 9 ? (char) 0 : m10 <= 26 ? (char) 1 : (char) 2];
    }
}
