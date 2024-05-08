package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;

/* compiled from: UPCAReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l7 extends q7 {

    /* renamed from: h, reason: collision with root package name */
    private final q7 f31247h = new o2();

    @Override // com.huawei.hms.scankit.p.q7
    public boolean a(int i10, int i11, r rVar) {
        return rVar.a(i11, (i11 - i10) + i11, false, false);
    }

    @Override // com.huawei.hms.scankit.p.q7
    public s6 a(int i10, r rVar, int[] iArr, Map<l1, ?> map) throws a {
        return a(this.f31247h.a(i10, rVar, iArr, map));
    }

    @Override // com.huawei.hms.scankit.p.q7, com.huawei.hms.scankit.p.g5
    public s6 a(int i10, r rVar, Map<l1, ?> map) throws a {
        return a(this.f31247h.a(i10, rVar, map));
    }

    @Override // com.huawei.hms.scankit.p.g5, com.huawei.hms.scankit.p.o6
    public s6 a(p pVar, Map<l1, ?> map) throws a {
        return a(this.f31247h.a(pVar, map));
    }

    @Override // com.huawei.hms.scankit.p.q7
    public BarcodeFormat a() {
        return BarcodeFormat.UPC_A;
    }

    @Override // com.huawei.hms.scankit.p.q7
    public int a(r rVar, int[] iArr, StringBuilder sb2) throws a {
        return this.f31247h.a(rVar, iArr, sb2);
    }

    private static s6 a(s6 s6Var) throws a {
        String k10 = s6Var.k();
        if (k10.charAt(0) == '0') {
            return new s6(k10.substring(1), null, s6Var.j(), BarcodeFormat.UPC_A);
        }
        throw a.a();
    }

    @Override // com.huawei.hms.scankit.p.q7
    public boolean a(int[] iArr, int[] iArr2) throws a {
        return Math.abs(((int) Math.round(((double) (iArr2[1] - iArr[0])) / (((double) ((iArr2[1] - iArr2[0]) + (iArr[1] - iArr[0]))) / 6.0d))) + (-113)) <= 5;
    }
}
