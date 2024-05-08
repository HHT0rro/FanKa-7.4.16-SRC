package com.amap.api.col.p0003l;

import java.io.File;

/* compiled from: FileNumUpdateStrategy.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class iw extends ja {

    /* renamed from: a, reason: collision with root package name */
    private int f6504a;

    /* renamed from: b, reason: collision with root package name */
    private String f6505b;

    public iw(String str, ja jaVar) {
        super(jaVar);
        this.f6504a = 30;
        this.f6505b = str;
    }

    private static int a(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.list().length;
            }
            return 0;
        } catch (Throwable th) {
            gy.b(th, "fus", "gfn");
            return 0;
        }
    }

    @Override // com.amap.api.col.p0003l.ja
    public final boolean c() {
        return a(this.f6505b) >= this.f6504a;
    }
}
