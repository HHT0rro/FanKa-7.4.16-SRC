package x5;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput;
import java.io.IOException;
import java.util.List;

/* compiled from: ChunkExtractor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface g {

    /* compiled from: ChunkExtractor.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        @Nullable
        g a(int i10, Format format, boolean z10, List<Format> list, @Nullable TrackOutput trackOutput);
    }

    /* compiled from: ChunkExtractor.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface b {
        TrackOutput c(int i10, int i11);
    }

    boolean a(d5.d dVar) throws IOException;

    void b(@Nullable b bVar, long j10, long j11);

    @Nullable
    com.google.android.exoplayer2.extractor.b d();

    @Nullable
    Format[] e();

    void release();
}
