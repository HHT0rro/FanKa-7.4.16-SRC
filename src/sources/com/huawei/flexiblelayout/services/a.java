package com.huawei.flexiblelayout.services;

/* compiled from: ServiceToken.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final String f28502a;

    public a(a aVar, String str) {
        if (aVar != null && aVar.b() != null) {
            this.f28502a = aVar.b() + "/" + str;
            return;
        }
        this.f28502a = str;
    }

    public a a() {
        int lastIndexOf = this.f28502a.lastIndexOf("/");
        if (lastIndexOf != -1) {
            return new a(null, this.f28502a.substring(0, lastIndexOf));
        }
        return null;
    }

    public String b() {
        return this.f28502a;
    }
}
