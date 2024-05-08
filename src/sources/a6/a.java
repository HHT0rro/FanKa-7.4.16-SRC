package a6;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.android.exoplayer2.upstream.i;

/* compiled from: DefaultHlsPlaylistParserFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a implements f {
    @Override // a6.f
    public i.a<e> a(com.google.android.exoplayer2.source.hls.playlist.b bVar, @Nullable com.google.android.exoplayer2.source.hls.playlist.c cVar) {
        return new HlsPlaylistParser(bVar, cVar);
    }

    @Override // a6.f
    public i.a<e> b() {
        return new HlsPlaylistParser();
    }
}
