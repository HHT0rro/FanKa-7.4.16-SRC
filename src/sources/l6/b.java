package l6;

import e6.e;
import java.util.Collections;
import java.util.List;

/* compiled from: Tx3gSubtitle.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b implements e {

    /* renamed from: c, reason: collision with root package name */
    public static final b f51676c = new b();

    /* renamed from: b, reason: collision with root package name */
    public final List<e6.a> f51677b;

    public b(e6.a aVar) {
        this.f51677b = Collections.singletonList(aVar);
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
        return j10 >= 0 ? this.f51677b : Collections.emptyList();
    }

    public b() {
        this.f51677b = Collections.emptyList();
    }
}
