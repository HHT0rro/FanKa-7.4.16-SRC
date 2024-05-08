package a6;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.upstream.i;
import java.util.List;

/* compiled from: FilteringHlsPlaylistParserFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d implements f {

    /* renamed from: a, reason: collision with root package name */
    public final f f709a;

    /* renamed from: b, reason: collision with root package name */
    public final List<StreamKey> f710b;

    public d(f fVar, List<StreamKey> list) {
        this.f709a = fVar;
        this.f710b = list;
    }

    @Override // a6.f
    public i.a<e> a(com.google.android.exoplayer2.source.hls.playlist.b bVar, @Nullable com.google.android.exoplayer2.source.hls.playlist.c cVar) {
        return new u5.e(this.f709a.a(bVar, cVar), this.f710b);
    }

    @Override // a6.f
    public i.a<e> b() {
        return new u5.e(this.f709a.b(), this.f710b);
    }
}
