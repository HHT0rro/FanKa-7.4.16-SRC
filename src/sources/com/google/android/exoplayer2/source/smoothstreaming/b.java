package com.google.android.exoplayer2.source.smoothstreaming;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import o6.r;
import o6.v;
import x5.j;

/* compiled from: SsChunkSource.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface b extends j {

    /* compiled from: SsChunkSource.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        b a(r rVar, com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, int i10, ExoTrackSelection exoTrackSelection, @Nullable v vVar);
    }

    void b(ExoTrackSelection exoTrackSelection);

    void e(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar);
}
