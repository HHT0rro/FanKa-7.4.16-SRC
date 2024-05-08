package k6;

import com.google.android.exoplayer2.util.j0;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: TtmlSubtitle.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class h implements e6.e {

    /* renamed from: b, reason: collision with root package name */
    public final d f50730b;

    /* renamed from: c, reason: collision with root package name */
    public final long[] f50731c;

    /* renamed from: d, reason: collision with root package name */
    public final Map<String, g> f50732d;

    /* renamed from: e, reason: collision with root package name */
    public final Map<String, e> f50733e;

    /* renamed from: f, reason: collision with root package name */
    public final Map<String, String> f50734f;

    public h(d dVar, Map<String, g> map, Map<String, e> map2, Map<String, String> map3) {
        this.f50730b = dVar;
        this.f50733e = map2;
        this.f50734f = map3;
        this.f50732d = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.f50731c = dVar.j();
    }

    @Override // e6.e
    public long a(int i10) {
        return this.f50731c[i10];
    }

    @Override // e6.e
    public int b() {
        return this.f50731c.length;
    }

    @Override // e6.e
    public int c(long j10) {
        int e2 = j0.e(this.f50731c, j10, false, false);
        if (e2 < this.f50731c.length) {
            return e2;
        }
        return -1;
    }

    @Override // e6.e
    public List<e6.a> f(long j10) {
        return this.f50730b.h(j10, this.f50732d, this.f50733e, this.f50734f);
    }
}
