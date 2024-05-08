package com.amap.api.col.s;

import java.io.File;

/* compiled from: FileNumUpdateStrategy.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class eq extends eu {

    /* renamed from: a, reason: collision with root package name */
    private int f7923a;

    /* renamed from: b, reason: collision with root package name */
    private String f7924b;

    public eq(String str, eu euVar) {
        super(euVar);
        this.f7923a = 30;
        this.f7924b = str;
    }

    @Override // com.amap.api.col.s.eu
    public final boolean a() {
        return a(this.f7924b) >= this.f7923a;
    }

    private static int a(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.list().length;
            }
            return 0;
        } catch (Throwable th) {
            df.c(th, "fus", "gfn");
            return 0;
        }
    }
}
