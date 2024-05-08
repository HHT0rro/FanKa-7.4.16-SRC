package com.google.android.exoplayer2.extractor;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import d5.p;
import java.io.EOFException;
import java.io.IOException;

/* compiled from: DummyTrackOutput.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d implements TrackOutput {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f20044a = new byte[4096];

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public /* synthetic */ void a(ParsableByteArray parsableByteArray, int i10) {
        p.b(this, parsableByteArray, i10);
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void b(Format format) {
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public /* synthetic */ int c(o6.g gVar, int i10, boolean z10) {
        return p.a(this, gVar, i10, z10);
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void d(long j10, int i10, int i11, int i12, @Nullable TrackOutput.CryptoData cryptoData) {
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public int e(o6.g gVar, int i10, boolean z10, int i11) throws IOException {
        int read = gVar.read(this.f20044a, 0, Math.min(this.f20044a.length, i10));
        if (read != -1) {
            return read;
        }
        if (z10) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void f(ParsableByteArray parsableByteArray, int i10, int i11) {
        parsableByteArray.Q(i10);
    }
}
