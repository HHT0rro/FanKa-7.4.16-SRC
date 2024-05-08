package m6;

import java.util.Collections;
import java.util.List;

/* compiled from: Mp4WebvttSubtitle.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b implements e6.e {

    /* renamed from: b, reason: collision with root package name */
    public final List<e6.a> f51878b;

    public b(List<e6.a> list) {
        this.f51878b = Collections.unmodifiableList(list);
    }

    @Override // e6.e
    public long a(int i10) {
        com.google.android.exoplayer2.util.a.a(i10 == 0);
        return 0L;
    }

    @Override // e6.e
    public int b() {
        return 1;
    }

    @Override // e6.e
    public int c(long j10) {
        return j10 < 0 ? 0 : -1;
    }

    @Override // e6.e
    public List<e6.a> f(long j10) {
        return j10 >= 0 ? this.f51878b : Collections.emptyList();
    }
}
