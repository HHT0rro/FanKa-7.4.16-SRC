package com.huawei.hms.scankit.p;

/* compiled from: QRCode.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class h6 {

    /* renamed from: a, reason: collision with root package name */
    private u4 f31060a;

    /* renamed from: b, reason: collision with root package name */
    private b3 f31061b;

    /* renamed from: c, reason: collision with root package name */
    private b8 f31062c;

    /* renamed from: d, reason: collision with root package name */
    private int f31063d = -1;

    /* renamed from: e, reason: collision with root package name */
    private c0 f31064e;

    public static boolean a(int i10) {
        return i10 >= 0 && i10 < 8;
    }

    public c0 a() {
        return this.f31064e;
    }

    public void b(int i10) {
        this.f31063d = i10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(200);
        sb2.append("<<\n");
        sb2.append(" mode: ");
        sb2.append((Object) this.f31060a);
        sb2.append("\n ecLevel: ");
        sb2.append((Object) this.f31061b);
        sb2.append("\n version: ");
        sb2.append((Object) this.f31062c);
        sb2.append("\n maskPattern: ");
        sb2.append(this.f31063d);
        sb2.append(">>\n");
        return sb2.toString();
    }

    public void a(u4 u4Var) {
        this.f31060a = u4Var;
    }

    public void a(b3 b3Var) {
        this.f31061b = b3Var;
    }

    public void a(b8 b8Var) {
        this.f31062c = b8Var;
    }

    public void a(c0 c0Var) {
        this.f31064e = c0Var;
    }
}
