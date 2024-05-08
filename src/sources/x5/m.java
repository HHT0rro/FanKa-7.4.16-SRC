package x5;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.j0;
import java.io.IOException;
import o6.t;
import x5.g;

/* compiled from: InitializationChunk.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class m extends f {

    /* renamed from: j, reason: collision with root package name */
    public final g f54553j;

    /* renamed from: k, reason: collision with root package name */
    public g.b f54554k;

    /* renamed from: l, reason: collision with root package name */
    public long f54555l;

    /* renamed from: m, reason: collision with root package name */
    public volatile boolean f54556m;

    public m(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, Format format, int i10, @Nullable Object obj, g gVar) {
        super(aVar, bVar, 2, format, i10, obj, -9223372036854775807L, -9223372036854775807L);
        this.f54553j = gVar;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public void b() {
        this.f54556m = true;
    }

    public void f(g.b bVar) {
        this.f54554k = bVar;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public void load() throws IOException {
        if (this.f54555l == 0) {
            this.f54553j.b(this.f54554k, -9223372036854775807L, -9223372036854775807L);
        }
        try {
            com.google.android.exoplayer2.upstream.b e2 = this.f54507b.e(this.f54555l);
            t tVar = this.f54514i;
            d5.b bVar = new d5.b(tVar, e2.f22773g, tVar.a(e2));
            while (!this.f54556m && this.f54553j.a(bVar)) {
                try {
                } finally {
                    this.f54555l = bVar.getPosition() - this.f54507b.f22773g;
                }
            }
        } finally {
            j0.n(this.f54514i);
        }
    }
}
