package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.hls.f;
import com.google.android.exoplayer2.source.z;
import com.google.android.exoplayer2.upstream.h;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface HlsPlaylistTracker {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class PlaylistResetException extends IOException {
        public final Uri url;

        public PlaylistResetException(Uri uri) {
            this.url = uri;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class PlaylistStuckException extends IOException {
        public final Uri url;

        public PlaylistStuckException(Uri uri) {
            this.url = uri;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        HlsPlaylistTracker a(f fVar, h hVar, a6.f fVar2);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface b {
        void a();

        boolean c(Uri uri, h.c cVar, boolean z10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface c {
        void h(com.google.android.exoplayer2.source.hls.playlist.c cVar);
    }

    void a(b bVar);

    long b();

    @Nullable
    com.google.android.exoplayer2.source.hls.playlist.b c();

    void d(Uri uri, z.a aVar, c cVar);

    void e(Uri uri) throws IOException;

    void f(Uri uri);

    void g(b bVar);

    boolean h(Uri uri);

    boolean i();

    boolean j(Uri uri, long j10);

    void k() throws IOException;

    @Nullable
    com.google.android.exoplayer2.source.hls.playlist.c l(Uri uri, boolean z10);

    void stop();
}
