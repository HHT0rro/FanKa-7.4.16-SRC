package y5;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.util.j0;
import java.io.IOException;

/* compiled from: EventSampleStream.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class h implements SampleStream {

    /* renamed from: b, reason: collision with root package name */
    public final Format f54671b;

    /* renamed from: d, reason: collision with root package name */
    public long[] f54673d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f54674e;

    /* renamed from: f, reason: collision with root package name */
    public z5.f f54675f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f54676g;

    /* renamed from: h, reason: collision with root package name */
    public int f54677h;

    /* renamed from: c, reason: collision with root package name */
    public final p5.b f54672c = new p5.b();

    /* renamed from: i, reason: collision with root package name */
    public long f54678i = -9223372036854775807L;

    public h(z5.f fVar, Format format, boolean z10) {
        this.f54671b = format;
        this.f54675f = fVar;
        this.f54673d = fVar.f54918b;
        e(fVar, z10);
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public void a() throws IOException {
    }

    public String b() {
        return this.f54675f.a();
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int c(s0 s0Var, DecoderInputBuffer decoderInputBuffer, int i10) {
        int i11 = this.f54677h;
        boolean z10 = i11 == this.f54673d.length;
        if (z10 && !this.f54674e) {
            decoderInputBuffer.o(4);
            return -4;
        }
        if ((i10 & 2) != 0 || !this.f54676g) {
            s0Var.f21132b = this.f54671b;
            this.f54676g = true;
            return -5;
        }
        if (z10) {
            return -3;
        }
        this.f54677h = i11 + 1;
        byte[] a10 = this.f54672c.a(this.f54675f.f54917a[i11]);
        decoderInputBuffer.q(a10.length);
        decoderInputBuffer.f19882d.put(a10);
        decoderInputBuffer.f19884f = this.f54673d[i11];
        decoderInputBuffer.o(1);
        return -4;
    }

    public void d(long j10) {
        int e2 = j0.e(this.f54673d, j10, true, false);
        this.f54677h = e2;
        if (!(this.f54674e && e2 == this.f54673d.length)) {
            j10 = -9223372036854775807L;
        }
        this.f54678i = j10;
    }

    public void e(z5.f fVar, boolean z10) {
        int i10 = this.f54677h;
        long j10 = i10 == 0 ? -9223372036854775807L : this.f54673d[i10 - 1];
        this.f54674e = z10;
        this.f54675f = fVar;
        long[] jArr = fVar.f54918b;
        this.f54673d = jArr;
        long j11 = this.f54678i;
        if (j11 != -9223372036854775807L) {
            d(j11);
        } else if (j10 != -9223372036854775807L) {
            this.f54677h = j0.e(jArr, j10, false, false);
        }
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public boolean isReady() {
        return true;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int l(long j10) {
        int max = Math.max(this.f54677h, j0.e(this.f54673d, j10, true, false));
        int i10 = max - this.f54677h;
        this.f54677h = max;
        return i10;
    }
}
