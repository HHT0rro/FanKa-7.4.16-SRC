package com.huawei.hms.scankit.p;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UPCEANExtensionSupport.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class p7 {

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f31400c = {1, 1, 2};

    /* renamed from: a, reason: collision with root package name */
    private final n7 f31401a = new n7();

    /* renamed from: b, reason: collision with root package name */
    private final o7 f31402b = new o7();

    public s6 a(int i10, r rVar, int i11) throws a {
        int[] a10 = q7.a(rVar, i11, false, f31400c);
        try {
            return this.f31402b.a(i10, rVar, a10);
        } catch (a unused) {
            return this.f31401a.a(i10, rVar, a10);
        }
    }
}
