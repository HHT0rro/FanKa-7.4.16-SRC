package com.huawei.hms.scankit.p;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BarcodeValue.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
final class m {

    /* renamed from: a, reason: collision with root package name */
    private final Map<Integer, Integer> f31248a = new HashMap();

    public void a(int i10) {
        Integer num = this.f31248a.get(Integer.valueOf(i10));
        if (num == null) {
            num = 0;
        }
        this.f31248a.put(Integer.valueOf(i10), Integer.valueOf(num.intValue() + 1));
    }

    public int[] a() {
        ArrayList arrayList = new ArrayList();
        int i10 = -1;
        for (Map.Entry<Integer, Integer> entry : this.f31248a.entrySet()) {
            if (entry.getValue().intValue() > i10) {
                i10 = entry.getValue().intValue();
                arrayList.clear();
                arrayList.add(entry.getKey());
            } else if (entry.getValue().intValue() == i10) {
                arrayList.add(entry.getKey());
            }
        }
        return n5.a(arrayList);
    }
}
