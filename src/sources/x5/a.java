package x5;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;

/* compiled from: BaseMediaChunk.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class a extends n {

    /* renamed from: k, reason: collision with root package name */
    public final long f54478k;

    /* renamed from: l, reason: collision with root package name */
    public final long f54479l;

    /* renamed from: m, reason: collision with root package name */
    public c f54480m;

    /* renamed from: n, reason: collision with root package name */
    public int[] f54481n;

    public a(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, Format format, int i10, @Nullable Object obj, long j10, long j11, long j12, long j13, long j14) {
        super(aVar, bVar, format, i10, obj, j10, j11, j14);
        this.f54478k = j12;
        this.f54479l = j13;
    }

    public final int h(int i10) {
        return ((int[]) com.google.android.exoplayer2.util.a.i(this.f54481n))[i10];
    }

    public final c i() {
        return (c) com.google.android.exoplayer2.util.a.i(this.f54480m);
    }

    public void j(c cVar) {
        this.f54480m = cVar;
        this.f54481n = cVar.a();
    }
}
