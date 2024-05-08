package n6;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.TrackGroup;
import java.util.List;
import x5.n;
import x5.o;

/* compiled from: FixedTrackSelection.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class f extends b {

    /* renamed from: h, reason: collision with root package name */
    public final int f52139h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public final Object f52140i;

    public f(TrackGroup trackGroup, int i10, int i11) {
        this(trackGroup, i10, i11, 0, null);
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public int a() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public void i(long j10, long j11, long j12, List<? extends n> list, o[] oVarArr) {
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    @Nullable
    public Object r() {
        return this.f52140i;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public int u() {
        return this.f52139h;
    }

    public f(TrackGroup trackGroup, int i10, int i11, int i12, @Nullable Object obj) {
        super(trackGroup, new int[]{i10}, i11);
        this.f52139h = i12;
        this.f52140i = obj;
    }
}
