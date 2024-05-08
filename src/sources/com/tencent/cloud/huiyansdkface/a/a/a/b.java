package com.tencent.cloud.huiyansdkface.a.a.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public int f40286a;

    /* renamed from: b, reason: collision with root package name */
    public int f40287b;

    public b(int i10, int i11) {
        this.f40286a = i10;
        this.f40287b = i11;
    }

    public int a() {
        return this.f40286a;
    }

    public int b() {
        return this.f40287b;
    }

    public boolean c() {
        return this.f40286a >= 0 && this.f40287b >= 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f40286a == bVar.f40286a && this.f40287b == bVar.f40287b;
    }

    public int hashCode() {
        return (this.f40286a * 31) + this.f40287b;
    }

    public String toString() {
        return "{min=" + this.f40286a + ", max=" + this.f40287b + '}';
    }
}
