package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.source.SampleStream;
import java.io.IOException;

/* compiled from: HlsSampleStream.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class l implements SampleStream {

    /* renamed from: b, reason: collision with root package name */
    public final int f21571b;

    /* renamed from: c, reason: collision with root package name */
    public final p f21572c;

    /* renamed from: d, reason: collision with root package name */
    public int f21573d = -1;

    public l(p pVar, int i10) {
        this.f21572c = pVar;
        this.f21571b = i10;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public void a() throws IOException {
        int i10 = this.f21573d;
        if (i10 == -2) {
            throw new SampleQueueMappingException(this.f21572c.m().a(this.f21571b).a(0).f19544m);
        }
        if (i10 == -1) {
            this.f21572c.S();
        } else if (i10 != -3) {
            this.f21572c.T(i10);
        }
    }

    public void b() {
        com.google.android.exoplayer2.util.a.a(this.f21573d == -1);
        this.f21573d = this.f21572c.x(this.f21571b);
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int c(s0 s0Var, DecoderInputBuffer decoderInputBuffer, int i10) {
        if (this.f21573d == -3) {
            decoderInputBuffer.g(4);
            return -4;
        }
        if (d()) {
            return this.f21572c.c0(this.f21573d, s0Var, decoderInputBuffer, i10);
        }
        return -3;
    }

    public final boolean d() {
        int i10 = this.f21573d;
        return (i10 == -1 || i10 == -3 || i10 == -2) ? false : true;
    }

    public void e() {
        if (this.f21573d != -1) {
            this.f21572c.n0(this.f21571b);
            this.f21573d = -1;
        }
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public boolean isReady() {
        return this.f21573d == -3 || (d() && this.f21572c.P(this.f21573d));
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int l(long j10) {
        if (d()) {
            return this.f21572c.m0(this.f21573d, j10);
        }
        return 0;
    }
}
