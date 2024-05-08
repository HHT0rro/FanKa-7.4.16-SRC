package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.source.m0;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import java.io.IOException;

/* compiled from: MediaPeriod.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface p extends m0 {

    /* compiled from: MediaPeriod.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a extends m0.a<p> {
        void n(p pVar);
    }

    @Override // com.google.android.exoplayer2.source.m0
    boolean b(long j10);

    @Override // com.google.android.exoplayer2.source.m0
    long d();

    @Override // com.google.android.exoplayer2.source.m0
    void e(long j10);

    @Override // com.google.android.exoplayer2.source.m0
    long f();

    long g(long j10, p1 p1Var);

    long h(long j10);

    long i();

    @Override // com.google.android.exoplayer2.source.m0
    boolean isLoading();

    long j(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j10);

    TrackGroupArray m();

    void p(a aVar, long j10);

    void s() throws IOException;

    void t(long j10, boolean z10);
}
