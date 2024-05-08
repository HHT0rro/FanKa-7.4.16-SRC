package x5;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.j0;
import java.io.IOException;
import o6.t;
import x5.g;

/* compiled from: ContainerMediaChunk.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class k extends a {

    /* renamed from: o, reason: collision with root package name */
    public final int f54545o;

    /* renamed from: p, reason: collision with root package name */
    public final long f54546p;

    /* renamed from: q, reason: collision with root package name */
    public final g f54547q;

    /* renamed from: r, reason: collision with root package name */
    public long f54548r;

    /* renamed from: s, reason: collision with root package name */
    public volatile boolean f54549s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f54550t;

    public k(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, Format format, int i10, @Nullable Object obj, long j10, long j11, long j12, long j13, long j14, int i11, long j15, g gVar) {
        super(aVar, bVar, format, i10, obj, j10, j11, j12, j13, j14);
        this.f54545o = i11;
        this.f54546p = j15;
        this.f54547q = gVar;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public final void b() {
        this.f54549s = true;
    }

    @Override // x5.n
    public long f() {
        return this.f54557j + this.f54545o;
    }

    @Override // x5.n
    public boolean g() {
        return this.f54550t;
    }

    public g.b k(c cVar) {
        return cVar;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public final void load() throws IOException {
        if (this.f54548r == 0) {
            c i10 = i();
            i10.b(this.f54546p);
            g gVar = this.f54547q;
            g.b k10 = k(i10);
            long j10 = this.f54478k;
            long j11 = j10 == -9223372036854775807L ? -9223372036854775807L : j10 - this.f54546p;
            long j12 = this.f54479l;
            gVar.b(k10, j11, j12 == -9223372036854775807L ? -9223372036854775807L : j12 - this.f54546p);
        }
        try {
            com.google.android.exoplayer2.upstream.b e2 = this.f54507b.e(this.f54548r);
            t tVar = this.f54514i;
            d5.b bVar = new d5.b(tVar, e2.f22773g, tVar.a(e2));
            do {
                try {
                    if (this.f54549s) {
                        break;
                    }
                } finally {
                    this.f54548r = bVar.getPosition() - this.f54507b.f22773g;
                }
            } while (this.f54547q.a(bVar));
            j0.n(this.f54514i);
            this.f54550t = !this.f54549s;
        } catch (Throwable th) {
            j0.n(this.f54514i);
            throw th;
        }
    }
}
