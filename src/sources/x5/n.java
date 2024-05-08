package x5;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;

/* compiled from: MediaChunk.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class n extends f {

    /* renamed from: j, reason: collision with root package name */
    public final long f54557j;

    public n(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, Format format, int i10, @Nullable Object obj, long j10, long j11, long j12) {
        super(aVar, bVar, 1, format, i10, obj, j10, j11);
        com.google.android.exoplayer2.util.a.e(format);
        this.f54557j = j12;
    }

    public long f() {
        long j10 = this.f54557j;
        if (j10 != -1) {
            return 1 + j10;
        }
        return -1L;
    }

    public abstract boolean g();
}
