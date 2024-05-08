package m6;

import com.google.android.exoplayer2.util.j0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: WebvttSubtitle.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class k implements e6.e {

    /* renamed from: b, reason: collision with root package name */
    public final List<e> f51932b;

    /* renamed from: c, reason: collision with root package name */
    public final long[] f51933c;

    /* renamed from: d, reason: collision with root package name */
    public final long[] f51934d;

    public k(List<e> list) {
        this.f51932b = Collections.unmodifiableList(new ArrayList(list));
        this.f51933c = new long[list.size() * 2];
        for (int i10 = 0; i10 < list.size(); i10++) {
            e eVar = list.get(i10);
            int i11 = i10 * 2;
            long[] jArr = this.f51933c;
            jArr[i11] = eVar.f51901b;
            jArr[i11 + 1] = eVar.f51902c;
        }
        long[] jArr2 = this.f51933c;
        long[] copyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.f51934d = copyOf;
        Arrays.sort(copyOf);
    }

    public static /* synthetic */ int e(e eVar, e eVar2) {
        return Long.compare(eVar.f51901b, eVar2.f51901b);
    }

    @Override // e6.e
    public long a(int i10) {
        com.google.android.exoplayer2.util.a.a(i10 >= 0);
        com.google.android.exoplayer2.util.a.a(i10 < this.f51934d.length);
        return this.f51934d[i10];
    }

    @Override // e6.e
    public int b() {
        return this.f51934d.length;
    }

    @Override // e6.e
    public int c(long j10) {
        int e2 = j0.e(this.f51934d, j10, false, false);
        if (e2 < this.f51934d.length) {
            return e2;
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e6.e
    public List<e6.a> f(long j10) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i10 = 0; i10 < this.f51932b.size(); i10++) {
            long[] jArr = this.f51933c;
            int i11 = i10 * 2;
            if (jArr[i11] <= j10 && j10 < jArr[i11 + 1]) {
                e eVar = this.f51932b.get(i10);
                e6.a aVar = eVar.f51900a;
                if (aVar.f48888e == -3.4028235E38f) {
                    arrayList2.add(eVar);
                } else {
                    arrayList.add(aVar);
                }
            }
        }
        Collections.sort(arrayList2, new Comparator() { // from class: m6.j
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int e2;
                e2 = k.e((e) obj, (e) obj2);
                return e2;
            }
        });
        for (int i12 = 0; i12 < arrayList2.size(); i12++) {
            arrayList.add(((e) arrayList2.get(i12)).f51900a.a().h((-1) - i12, 1).a());
        }
        return arrayList;
    }
}
