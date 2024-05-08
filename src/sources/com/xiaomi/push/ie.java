package com.xiaomi.push;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public enum ie {
    RegIdExpired(0),
    PackageUnregistered(1),
    Init(2);


    /* renamed from: a, reason: collision with other field name */
    private final int f375a;

    ie(int i10) {
        this.f375a = i10;
    }

    public static ie a(int i10) {
        if (i10 == 0) {
            return RegIdExpired;
        }
        if (i10 == 1) {
            return PackageUnregistered;
        }
        if (i10 != 2) {
            return null;
        }
        return Init;
    }

    public int a() {
        return this.f375a;
    }
}
