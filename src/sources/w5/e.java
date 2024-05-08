package w5;

import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.k;

/* compiled from: SinglePeriodAdTimeline.java */
@VisibleForTesting(otherwise = 3)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class e extends k {

    /* renamed from: d, reason: collision with root package name */
    public final com.google.android.exoplayer2.source.ads.a f54269d;

    public e(Timeline timeline, com.google.android.exoplayer2.source.ads.a aVar) {
        super(timeline);
        com.google.android.exoplayer2.util.a.g(timeline.i() == 1);
        com.google.android.exoplayer2.util.a.g(timeline.p() == 1);
        this.f54269d = aVar;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.Timeline
    public Timeline.b g(int i10, Timeline.b bVar, boolean z10) {
        this.f21765c.g(i10, bVar, z10);
        long j10 = bVar.f19659d;
        if (j10 == -9223372036854775807L) {
            j10 = this.f54269d.f21211d;
        }
        bVar.r(bVar.f19656a, bVar.f19657b, bVar.f19658c, j10, bVar.m(), this.f54269d, bVar.f19661f);
        return bVar;
    }
}
