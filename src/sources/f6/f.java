package f6;

import java.util.Collections;
import java.util.List;

/* compiled from: CeaSubtitle.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class f implements e6.e {

    /* renamed from: b, reason: collision with root package name */
    public final List<e6.a> f49218b;

    public f(List<e6.a> list) {
        this.f49218b = list;
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
        return j10 >= 0 ? this.f49218b : Collections.emptyList();
    }
}
