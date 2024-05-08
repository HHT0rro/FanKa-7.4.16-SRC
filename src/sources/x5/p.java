package x5;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.j0;
import java.io.IOException;

/* compiled from: SingleSampleMediaChunk.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class p extends a {

    /* renamed from: o, reason: collision with root package name */
    public final int f54559o;

    /* renamed from: p, reason: collision with root package name */
    public final Format f54560p;

    /* renamed from: q, reason: collision with root package name */
    public long f54561q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f54562r;

    public p(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, Format format, int i10, @Nullable Object obj, long j10, long j11, long j12, int i11, Format format2) {
        super(aVar, bVar, format, i10, obj, j10, j11, -9223372036854775807L, -9223372036854775807L, j12);
        this.f54559o = i11;
        this.f54560p = format2;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public void b() {
    }

    @Override // x5.n
    public boolean g() {
        return this.f54562r;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public void load() throws IOException {
        c i10 = i();
        i10.b(0L);
        TrackOutput c4 = i10.c(0, this.f54559o);
        c4.b(this.f54560p);
        try {
            long a10 = this.f54514i.a(this.f54507b.e(this.f54561q));
            if (a10 != -1) {
                a10 += this.f54561q;
            }
            d5.b bVar = new d5.b(this.f54514i, this.f54561q, a10);
            for (int i11 = 0; i11 != -1; i11 = c4.c(bVar, Integer.MAX_VALUE, true)) {
                this.f54561q += i11;
            }
            c4.d(this.f54512g, 1, (int) this.f54561q, 0, null);
            j0.n(this.f54514i);
            this.f54562r = true;
        } catch (Throwable th) {
            j0.n(this.f54514i);
            throw th;
        }
    }
}
