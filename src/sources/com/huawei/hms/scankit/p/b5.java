package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: MultiFormatUPCEANReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class b5 extends g5 {

    /* renamed from: a, reason: collision with root package name */
    private final q7[] f30739a;

    public b5(Map<l1, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(l1.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.EAN_13)) {
                arrayList.add(new o2());
            } else if (collection.contains(BarcodeFormat.UPC_A)) {
                arrayList.add(new l7());
            }
            if (collection.contains(BarcodeFormat.EAN_8)) {
                arrayList.add(new q2());
            }
            if (collection.contains(BarcodeFormat.UPC_E)) {
                arrayList.add(new s7());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new o2());
            arrayList.add(new q2());
            arrayList.add(new s7());
        }
        this.f30739a = (q7[]) arrayList.toArray(new q7[arrayList.size()]);
    }

    @Override // com.huawei.hms.scankit.p.g5
    public s6 a(int i10, r rVar, Map<l1, ?> map) throws a {
        boolean z10;
        Iterator<int[]> iterator2 = q7.b(rVar).iterator2();
        while (iterator2.hasNext()) {
            int[] next = iterator2.next();
            for (q7 q7Var : this.f30739a) {
                try {
                    s6 a10 = q7Var.a(i10, rVar, next, map);
                    boolean z11 = a10.c() == BarcodeFormat.EAN_13 && a10.k().charAt(0) == '0';
                    Collection collection = map == null ? null : (Collection) map.get(l1.POSSIBLE_FORMATS);
                    if (collection != null && !collection.contains(BarcodeFormat.UPC_A)) {
                        z10 = false;
                        return (z11 || !z10) ? a10 : new s6(a10.k().substring(1), a10.i(), a10.j(), BarcodeFormat.UPC_A);
                    }
                    z10 = true;
                    if (z11) {
                    }
                } catch (a unused) {
                }
            }
        }
        throw a.a();
    }
}
