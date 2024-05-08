package com.tencent.bugly.idasc.proguard;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class bn extends m implements Cloneable {

    /* renamed from: d, reason: collision with root package name */
    public static byte[] f39767d;

    /* renamed from: a, reason: collision with root package name */
    public byte f39768a;

    /* renamed from: b, reason: collision with root package name */
    public String f39769b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f39770c;

    public bn() {
        this.f39768a = (byte) 0;
        this.f39769b = "";
        this.f39770c = null;
    }

    public bn(byte b4, String str, byte[] bArr) {
        this.f39768a = b4;
        this.f39769b = str;
        this.f39770c = bArr;
    }

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(k kVar) {
        this.f39768a = kVar.a(this.f39768a, 0, true);
        this.f39769b = kVar.b(1, true);
        if (f39767d == null) {
            f39767d = r0;
            byte[] bArr = {0};
        }
        this.f39770c = kVar.c(2, false);
    }

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f39768a, 0);
        lVar.a(this.f39769b, 1);
        byte[] bArr = this.f39770c;
        if (bArr != null) {
            lVar.a(bArr, 2);
        }
    }

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(StringBuilder sb2, int i10) {
    }
}
