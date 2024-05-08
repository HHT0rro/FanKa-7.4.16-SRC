package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.s0;

/* compiled from: EmptySampleStream.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class j implements SampleStream {
    @Override // com.google.android.exoplayer2.source.SampleStream
    public void a() {
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int c(s0 s0Var, DecoderInputBuffer decoderInputBuffer, int i10) {
        decoderInputBuffer.o(4);
        return -4;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public boolean isReady() {
        return true;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int l(long j10) {
        return 0;
    }
}
