package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;

/* compiled from: DataMatrixReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class h1 implements o6 {

    /* renamed from: b, reason: collision with root package name */
    private static final u6[] f31047b = new u6[0];

    /* renamed from: a, reason: collision with root package name */
    private final t1 f31048a = new t1();

    @Override // com.huawei.hms.scankit.p.o6
    public s6 a(p pVar, Map<l1, ?> map) throws a {
        j2 a10 = new d2(pVar.b()).a();
        try {
            w1 a11 = this.f31048a.a(a10.a(), map);
            return new s6(a11.d(), a11.c(), a10.d(), BarcodeFormat.DATA_MATRIX);
        } catch (a e2) {
            if (a10.d() != null && !r3.f31448c) {
                double sqrt = Math.sqrt(Math.pow(a10.d()[0].b() - a10.d()[1].b(), 2.0d) + Math.pow(a10.d()[0].c() - a10.d()[1].c(), 2.0d));
                double sqrt2 = Math.sqrt(Math.pow(a10.d()[0].b() - a10.d()[3].b(), 2.0d) + Math.pow(a10.d()[0].c() - a10.d()[3].c(), 2.0d));
                if (this.f31048a.a() != null && Math.abs(sqrt - sqrt2) / sqrt < 0.1d) {
                    return new s6(null, null, a10.d(), BarcodeFormat.DATA_MATRIX);
                }
                throw e2;
            }
            throw e2;
        }
    }
}
