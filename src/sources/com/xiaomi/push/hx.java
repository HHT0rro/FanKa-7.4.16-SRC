package com.xiaomi.push;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public enum hx {
    INT(1),
    LONG(2),
    STRING(3),
    BOOLEAN(4);


    /* renamed from: a, reason: collision with other field name */
    private final int f317a;

    hx(int i10) {
        this.f317a = i10;
    }

    public static hx a(int i10) {
        if (i10 == 1) {
            return INT;
        }
        if (i10 == 2) {
            return LONG;
        }
        if (i10 == 3) {
            return STRING;
        }
        if (i10 != 4) {
            return null;
        }
        return BOOLEAN;
    }
}
