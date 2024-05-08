package com.ishumei.smantifraud.l111l1111l1Il;

import android.os.Build;
import com.baidu.mobads.sdk.internal.bk;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class l1111l111111Il<E> {
    private final Queue<C0355l1111l111111Il<E, Integer>> l1111l111111Il;
    private final int l111l11111lIl;

    /* renamed from: com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il$l1111l111111Il, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class C0355l1111l111111Il<T1, T2> {
        public final T1 l1111l111111Il;
        public T2 l111l11111lIl;

        public C0355l1111l111111Il(T1 t12, T2 t2) {
            this.l1111l111111Il = t12;
            this.l111l11111lIl = t2;
        }
    }

    public l1111l111111Il() {
    }

    public l1111l111111Il(int i10) {
        this.l111l11111lIl = i10;
        this.l1111l111111Il = new LinkedList();
    }

    public static HashMap<String, String> l111l11111lIl() {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put("board", Build.BOARD);
            hashMap.put(bk.f9900i, Build.MODEL);
            hashMap.put("brand", Build.BRAND);
            hashMap.put("manufacturer", Build.MANUFACTURER);
            hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT, Build.FINGERPRINT);
            hashMap.put("cpu_abi", Build.CPU_ABI);
            hashMap.put("cpu_abi2", Build.CPU_ABI2);
            hashMap.put("radioVersion", Build.getRadioVersion());
        } catch (Exception unused) {
        }
        return hashMap;
    }

    public final synchronized int l1111l111111Il(int... iArr) {
        int i10;
        i10 = 0;
        for (C0355l1111l111111Il<E, Integer> c0355l1111l111111Il : this.l1111l111111Il) {
            for (int i11 = 0; i11 < 2; i11++) {
                if (c0355l1111l111111Il.l111l11111lIl.intValue() == iArr[i11]) {
                    i10++;
                }
            }
        }
        return i10;
    }

    public final synchronized List<E> l1111l111111Il() {
        ArrayList arrayList;
        arrayList = new ArrayList(this.l1111l111111Il.size() + 1);
        Iterator<C0355l1111l111111Il<E, Integer>> it = this.l1111l111111Il.iterator2();
        while (it.hasNext()) {
            arrayList.add(it.next().l1111l111111Il);
        }
        return arrayList;
    }

    public final synchronized void l1111l111111Il(Set<E> set) {
        Iterator<C0355l1111l111111Il<E, Integer>> it = this.l1111l111111Il.iterator2();
        while (it.hasNext()) {
            if (set.contains(it.next().l1111l111111Il)) {
                it.remove();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Integer, T2] */
    public final synchronized void l1111l111111Il(Set<E> set, int i10) {
        for (C0355l1111l111111Il<E, Integer> c0355l1111l111111Il : this.l1111l111111Il) {
            if (set.contains(c0355l1111l111111Il.l1111l111111Il)) {
                c0355l1111l111111Il.l111l11111lIl = Integer.valueOf(i10);
            }
        }
    }

    public final synchronized boolean l1111l111111Il(E e2, int i10) {
        boolean add;
        add = this.l1111l111111Il.add(new C0355l1111l111111Il<>(e2, 0));
        while (this.l1111l111111Il.size() > this.l111l11111lIl) {
            this.l1111l111111Il.remove();
        }
        return add;
    }

    public final synchronized List<E> l111l11111lIl(int... iArr) {
        ArrayList arrayList;
        arrayList = new ArrayList(this.l1111l111111Il.size() + 1);
        for (C0355l1111l111111Il<E, Integer> c0355l1111l111111Il : this.l1111l111111Il) {
            for (int i10 = 0; i10 < 2; i10++) {
                if (c0355l1111l111111Il.l111l11111lIl.intValue() == iArr[i10]) {
                    arrayList.add(c0355l1111l111111Il.l1111l111111Il);
                }
            }
        }
        return arrayList;
    }
}
