package com.amap.api.col.p0003l;

import android.text.TextUtils;
import java.util.Vector;

/* compiled from: LogMemCacher.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class gh {

    /* renamed from: b, reason: collision with root package name */
    private static int f6079b = 100;

    /* renamed from: d, reason: collision with root package name */
    private static int f6080d = 10000;

    /* renamed from: a, reason: collision with root package name */
    private Vector<ge> f6081a;

    /* renamed from: c, reason: collision with root package name */
    private int f6082c;

    /* renamed from: e, reason: collision with root package name */
    private int f6083e;

    public gh() {
        this.f6083e = 0;
        this.f6082c = 10;
        this.f6081a = new Vector<>();
    }

    public final synchronized boolean a(String str) {
        if (str == null) {
            return false;
        }
        if (this.f6081a.size() >= this.f6082c) {
            return true;
        }
        return this.f6083e + str.getBytes().length > f6080d;
    }

    public final synchronized void b() {
        this.f6081a.clear();
        this.f6083e = 0;
    }

    public gh(byte b4) {
        this.f6082c = f6079b;
        this.f6083e = 0;
        this.f6081a = new Vector<>();
    }

    public final Vector<ge> a() {
        return this.f6081a;
    }

    public final synchronized void a(ge geVar) {
        if (geVar != null) {
            if (!TextUtils.isEmpty(geVar.b())) {
                this.f6081a.add(geVar);
                this.f6083e += geVar.b().getBytes().length;
            }
        }
    }
}
