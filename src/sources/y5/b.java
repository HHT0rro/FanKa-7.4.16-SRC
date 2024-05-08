package y5;

import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.util.j0;
import com.google.common.collect.g0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* compiled from: BaseUrlExclusionList.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, Long> f54663a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<Integer, Long> f54664b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<List<Pair<String, Integer>>, z5.b> f54665c;

    /* renamed from: d, reason: collision with root package name */
    public final Random f54666d;

    public b() {
        this(new Random());
    }

    public static <T> void b(T t2, long j10, Map<T, Long> map) {
        if (map.containsKey(t2)) {
            j10 = Math.max(j10, ((Long) j0.j(map.get(t2))).longValue());
        }
        map.put(t2, Long.valueOf(j10));
    }

    public static int d(z5.b bVar, z5.b bVar2) {
        int compare = Integer.compare(bVar.f54887c, bVar2.f54887c);
        return compare != 0 ? compare : bVar.f54886b.compareTo(bVar2.f54886b);
    }

    public static int f(List<z5.b> list) {
        HashSet hashSet = new HashSet();
        for (int i10 = 0; i10 < list.size(); i10++) {
            hashSet.add(Integer.valueOf(list.get(i10).f54887c));
        }
        return hashSet.size();
    }

    public static <T> void h(long j10, Map<T, Long> map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<T, Long> entry : map.entrySet()) {
            if (entry.getValue().longValue() <= j10) {
                arrayList.add(entry.getKey());
            }
        }
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            map.remove(arrayList.get(i10));
        }
    }

    public final List<z5.b> c(List<z5.b> list) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        h(elapsedRealtime, this.f54663a);
        h(elapsedRealtime, this.f54664b);
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            z5.b bVar = list.get(i10);
            if (!this.f54663a.containsKey(bVar.f54886b) && !this.f54664b.containsKey(Integer.valueOf(bVar.f54887c))) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public void e(z5.b bVar, long j10) {
        long elapsedRealtime = SystemClock.elapsedRealtime() + j10;
        b(bVar.f54886b, elapsedRealtime, this.f54663a);
        b(Integer.valueOf(bVar.f54887c), elapsedRealtime, this.f54664b);
    }

    public int g(List<z5.b> list) {
        HashSet hashSet = new HashSet();
        List<z5.b> c4 = c(list);
        for (int i10 = 0; i10 < c4.size(); i10++) {
            hashSet.add(Integer.valueOf(c4.get(i10).f54887c));
        }
        return hashSet.size();
    }

    public void i() {
        this.f54663a.clear();
        this.f54664b.clear();
        this.f54665c.clear();
    }

    @Nullable
    public z5.b j(List<z5.b> list) {
        List<z5.b> c4 = c(list);
        if (c4.size() < 2) {
            return (z5.b) g0.e(c4, null);
        }
        Collections.sort(c4, new Comparator() { // from class: y5.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int d10;
                d10 = b.d((z5.b) obj, (z5.b) obj2);
                return d10;
            }
        });
        ArrayList arrayList = new ArrayList();
        int i10 = c4.get(0).f54887c;
        int i11 = 0;
        while (true) {
            if (i11 >= c4.size()) {
                break;
            }
            z5.b bVar = c4.get(i11);
            if (i10 != bVar.f54887c) {
                if (arrayList.size() == 1) {
                    return c4.get(0);
                }
            } else {
                arrayList.add(new Pair(bVar.f54886b, Integer.valueOf(bVar.f54888d)));
                i11++;
            }
        }
        z5.b bVar2 = this.f54665c.get(arrayList);
        if (bVar2 != null) {
            return bVar2;
        }
        z5.b k10 = k(c4.subList(0, arrayList.size()));
        this.f54665c.put(arrayList, k10);
        return k10;
    }

    public final z5.b k(List<z5.b> list) {
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            i10 += list.get(i11).f54888d;
        }
        int nextInt = this.f54666d.nextInt(i10);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            z5.b bVar = list.get(i13);
            i12 += bVar.f54888d;
            if (nextInt < i12) {
                return bVar;
            }
        }
        return (z5.b) g0.f(list);
    }

    @VisibleForTesting
    public b(Random random) {
        this.f54665c = new HashMap();
        this.f54666d = random;
        this.f54663a = new HashMap();
        this.f54664b = new HashMap();
    }
}
