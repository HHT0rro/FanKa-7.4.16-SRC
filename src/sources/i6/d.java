package i6;

import com.google.android.exoplayer2.util.j0;
import e6.e;
import java.util.Collections;
import java.util.List;

/* compiled from: SsaSubtitle.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d implements e {

    /* renamed from: b, reason: collision with root package name */
    public final List<List<e6.a>> f49839b;

    /* renamed from: c, reason: collision with root package name */
    public final List<Long> f49840c;

    public d(List<List<e6.a>> list, List<Long> list2) {
        this.f49839b = list;
        this.f49840c = list2;
    }

    @Override // e6.e
    public long a(int i10) {
        com.google.android.exoplayer2.util.a.a(i10 >= 0);
        com.google.android.exoplayer2.util.a.a(i10 < this.f49840c.size());
        return this.f49840c.get(i10).longValue();
    }

    @Override // e6.e
    public int b() {
        return this.f49840c.size();
    }

    @Override // e6.e
    public int c(long j10) {
        int d10 = j0.d(this.f49840c, Long.valueOf(j10), false, false);
        if (d10 < this.f49840c.size()) {
            return d10;
        }
        return -1;
    }

    @Override // e6.e
    public List<e6.a> f(long j10) {
        int g3 = j0.g(this.f49840c, Long.valueOf(j10), true, false);
        if (g3 == -1) {
            return Collections.emptyList();
        }
        return this.f49839b.get(g3);
    }
}
