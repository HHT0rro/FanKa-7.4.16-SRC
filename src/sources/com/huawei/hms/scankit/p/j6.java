package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;

/* compiled from: QRCodeReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class j6 implements o6 {

    /* renamed from: a, reason: collision with root package name */
    private final v1 f31175a = new v1();

    public static void a(p4 p4Var) {
        int a10 = p4Var.a();
        if (a10 == p4Var.c() && a10 == 805) {
            r3.f31467v[0] = true;
        }
    }

    public static void a(p4 p4Var, s6 s6Var) {
        boolean z10;
        int a10 = p4Var.a();
        int c4 = p4Var.c();
        while (true) {
            if (r3.f31468w.size() == 0) {
                z10 = false;
                break;
            }
            int intValue = r3.f31468w.pop().intValue();
            if (intValue != 0 && a10 % intValue == 0) {
                z10 = true;
                break;
            }
        }
        if (!(a10 == c4 && z10) || s6Var == null || s6Var.j() == null) {
            return;
        }
        if ((Math.max(Math.max(s6Var.j()[0].b(), s6Var.j()[1].b()), s6Var.j()[2].b()) - Math.min(Math.min(s6Var.j()[0].b(), s6Var.j()[1].b()), s6Var.j()[2].b())) * (Math.max(Math.max(s6Var.j()[0].c(), s6Var.j()[1].c()), s6Var.j()[2].c()) - Math.min(Math.min(s6Var.j()[0].c(), s6Var.j()[1].c()), s6Var.j()[2].c())) > a10 * c4 * 0.8d) {
            r3.f31467v[1] = true;
        }
    }

    @Override // com.huawei.hms.scankit.p.o6
    public final s6 a(p pVar, Map<l1, ?> map) throws a {
        w1 w1Var;
        boolean z10 = true;
        r3.f31455j++;
        try {
            j2 a10 = new g2(pVar.b()).a(map);
            boolean z11 = a(a10) > 0;
            try {
                w1Var = this.f31175a.a(a10.a(), map);
                z10 = false;
            } catch (Exception unused) {
                w1Var = null;
            }
            if (z10 && z11) {
                return new s6(null, null, a10.b(), BarcodeFormat.QR_CODE);
            }
            if (z10) {
                throw a.a();
            }
            if (w1Var == null) {
                return null;
            }
            u6[] d10 = a10.d();
            if (w1Var.b() instanceof i6) {
                ((i6) w1Var.b()).a(d10);
            }
            s6 s6Var = new s6(w1Var.d(), w1Var.c(), d10, BarcodeFormat.QR_CODE);
            s6Var.b(a10.b());
            return s6Var;
        } catch (a unused2) {
            throw a.a();
        }
    }

    private int a(j2 j2Var) {
        r3.f31454i = j2Var.c();
        s a10 = j2Var.a();
        int[] iArr = {3, a10.e() - 4, 3};
        int[] iArr2 = {3, 3, a10.c() - 4};
        int i10 = 0;
        for (int i11 = 0; i11 < 3; i11++) {
            if (a(a10, iArr[i11], iArr2[i11])) {
                i10++;
            }
        }
        return i10;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [boolean, int] */
    private boolean a(s sVar, int i10, int i11) {
        if (sVar == null || sVar.c() < 21 || sVar.e() < 21) {
            return false;
        }
        ?? b4 = sVar.b(i10, i11);
        int i12 = b4;
        if (sVar.b(i10 + 1, i11)) {
            i12 = b4 + 1;
        }
        int i13 = i12;
        if (!sVar.b(i10 + 2, i11)) {
            i13 = i12 + 1;
        }
        int i14 = i13;
        if (sVar.b(i10 + 3, i11)) {
            i14 = i13 + 1;
        }
        int i15 = i14;
        if (sVar.b(i10 - 1, i11)) {
            i15 = i14 + 1;
        }
        int i16 = i15;
        if (!sVar.b(i10 - 2, i11)) {
            i16 = i15 + 1;
        }
        int i17 = i16;
        if (sVar.b(i10 - 3, i11)) {
            i17 = i16 + 1;
        }
        int i18 = i17;
        if (sVar.b(i10, i11 + 1)) {
            i18 = i17 + 1;
        }
        int i19 = i18;
        if (!sVar.b(i10, i11 + 2)) {
            i19 = i18 + 1;
        }
        int i20 = i19;
        if (sVar.b(i10, i11 + 3)) {
            i20 = i19 + 1;
        }
        int i21 = i20;
        if (sVar.b(i10, i11 - 1)) {
            i21 = i20 + 1;
        }
        int i22 = i21;
        if (!sVar.b(i10, i11 - 2)) {
            i22 = i21 + 1;
        }
        int i23 = i22;
        if (sVar.b(i10, i11 - 3)) {
            i23 = i22 + 1;
        }
        return i23 > 10;
    }
}
