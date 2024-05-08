package com.xiaomi.push;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class f0 implements i0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f47228a;

    /* renamed from: b, reason: collision with root package name */
    public final String f47229b;

    public f0(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.f47228a = str;
        this.f47229b = str2;
    }

    @Override // com.xiaomi.push.i0
    public String a() {
        return this.f47228a;
    }

    @Override // com.xiaomi.push.i0
    public String b() {
        return this.f47229b;
    }
}
