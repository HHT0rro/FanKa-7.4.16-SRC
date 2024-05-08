package com.amap.api.col.p0003l;

import com.alipay.sdk.data.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: WifiCollector.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class jn {

    /* renamed from: b, reason: collision with root package name */
    private kr f6595b;

    /* renamed from: a, reason: collision with root package name */
    private List<ks> f6594a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<ks> f6596c = new ArrayList<>();

    private boolean b(kr krVar, List<ks> list, boolean z10, long j10, long j11) {
        if (!z10 || !a(krVar, j10, j11) || list == null || list.size() <= 0) {
            return false;
        }
        if (this.f6595b == null) {
            return true;
        }
        boolean a10 = a(krVar);
        return !a10 ? !a(list, this.f6594a) : a10;
    }

    public final List<ks> a(kr krVar, List<ks> list, boolean z10, long j10, long j11) {
        if (!b(krVar, list, z10, j10, j11)) {
            return null;
        }
        b(this.f6596c, list);
        this.f6594a.clear();
        this.f6594a.addAll(list);
        this.f6595b = krVar;
        return this.f6596c;
    }

    private void b(List<ks> list, List<ks> list2) {
        list.clear();
        if (list2 != null) {
            List<ks> b4 = b(a(list2));
            int size = b4.size();
            if (size > 40) {
                size = 40;
            }
            for (int i10 = 0; i10 < size; i10++) {
                list.add(b4.get(i10));
            }
        }
    }

    private static boolean a(kr krVar, long j10, long j11) {
        return j10 > 0 && j11 - j10 < ((long) ((krVar.f6679g > 10.0f ? 1 : (krVar.f6679g == 10.0f ? 0 : -1)) >= 0 ? 2000 : a.f4564a));
    }

    private boolean a(kr krVar) {
        float f10 = krVar.f6679g;
        float f11 = 10.0f;
        if (f10 > 10.0f) {
            f11 = 200.0f;
        } else if (f10 > 2.0f) {
            f11 = 50.0f;
        }
        return krVar.a(this.f6595b) > ((double) f11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean a(List<ks> list, List<ks> list2) {
        if (list != null && list2 != null) {
            int size = list.size();
            int size2 = list2.size();
            int i10 = size + size2;
            if (size <= size2) {
                list2 = list;
                list = list2;
            }
            HashMap hashMap = new HashMap(list.size());
            Iterator<ks> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                hashMap.put(Long.valueOf(iterator2.next().f6685a), 1);
            }
            Iterator<ks> iterator22 = list2.iterator2();
            int i11 = 0;
            while (iterator22.hasNext()) {
                if (((Integer) hashMap.get(Long.valueOf(iterator22.next().f6685a))) != null) {
                    i11++;
                }
            }
            if (i11 * 2.0d >= i10 * 0.5d) {
                return true;
            }
        }
        return false;
    }

    private List<ks> b(List<ks> list) {
        Collections.sort(list, new Comparator<ks>() { // from class: com.amap.api.col.3l.jn.1
            private static int a(ks ksVar, ks ksVar2) {
                return ksVar2.f6687c - ksVar.f6687c;
            }

            @Override // java.util.Comparator
            public final /* synthetic */ int compare(ks ksVar, ks ksVar2) {
                return a(ksVar, ksVar2);
            }
        });
        return list;
    }

    private static List<ks> a(List<ks> list) {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        for (int i10 = 0; i10 < list.size(); i10++) {
            ks ksVar = list.get(i10);
            hashMap.put(Integer.valueOf(ksVar.f6687c), ksVar);
        }
        arrayList.addAll(hashMap.values());
        return arrayList;
    }
}
