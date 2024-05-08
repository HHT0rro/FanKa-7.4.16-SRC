package com.tencent.cloud.huiyansdkface.a.a.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public int f40295a;

    /* renamed from: b, reason: collision with root package name */
    public int f40296b;

    public d(int i10, int i11) {
        this.f40295a = i10;
        this.f40296b = i11;
    }

    public int a() {
        return this.f40295a;
    }

    public int b() {
        return this.f40296b;
    }

    public int c() {
        return this.f40295a * this.f40296b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return this.f40295a == dVar.f40295a && this.f40296b == dVar.f40296b;
    }

    public int hashCode() {
        return (this.f40295a * 31) + this.f40296b;
    }

    public String toString() {
        return "{width=" + this.f40295a + ", height=" + this.f40296b + '}';
    }
}
