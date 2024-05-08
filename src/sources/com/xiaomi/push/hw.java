package com.xiaomi.push;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public enum hw {
    MISC_CONFIG(1),
    PLUGIN_CONFIG(2);


    /* renamed from: a, reason: collision with other field name */
    private final int f315a;

    hw(int i10) {
        this.f315a = i10;
    }

    public static hw a(int i10) {
        if (i10 == 1) {
            return MISC_CONFIG;
        }
        if (i10 != 2) {
            return null;
        }
        return PLUGIN_CONFIG;
    }

    public int a() {
        return this.f315a;
    }
}
