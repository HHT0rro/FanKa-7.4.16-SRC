package com.google.android.exoplayer2.source.dash;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.dash.d;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import java.util.List;
import o6.r;
import o6.v;
import x5.j;

/* compiled from: DashChunkSource.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface a extends j {

    /* compiled from: DashChunkSource.java */
    /* renamed from: com.google.android.exoplayer2.source.dash.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface InterfaceC0194a {
        a a(r rVar, z5.c cVar, y5.b bVar, int i10, int[] iArr, ExoTrackSelection exoTrackSelection, int i11, long j10, boolean z10, List<Format> list, @Nullable d.c cVar2, @Nullable v vVar);
    }

    void b(ExoTrackSelection exoTrackSelection);

    void i(z5.c cVar, int i10);
}
