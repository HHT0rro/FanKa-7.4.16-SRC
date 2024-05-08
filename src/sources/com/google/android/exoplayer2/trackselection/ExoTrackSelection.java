package com.google.android.exoplayer2.trackselection;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.s;
import java.util.List;
import n6.g;
import o6.e;
import x5.f;
import x5.n;
import x5.o;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface ExoTrackSelection extends g {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final TrackGroup f22269a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f22270b;

        /* renamed from: c, reason: collision with root package name */
        public final int f22271c;

        public a(TrackGroup trackGroup, int... iArr) {
            this(trackGroup, iArr, 0);
        }

        public a(TrackGroup trackGroup, int[] iArr, int i10) {
            this.f22269a = trackGroup;
            this.f22270b = iArr;
            this.f22271c = i10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface b {
        ExoTrackSelection[] a(a[] aVarArr, e eVar, s.a aVar, Timeline timeline);
    }

    int a();

    boolean b(int i10, long j10);

    void d();

    void e();

    boolean h(long j10, f fVar, List<? extends n> list);

    void i(long j10, long j11, long j12, List<? extends n> list, o[] oVarArr);

    void j();

    int k(long j10, List<? extends n> list);

    int l();

    Format m();

    void n();

    boolean o(int i10, long j10);

    void q(float f10);

    @Nullable
    Object r();

    void s(boolean z10);

    int u();
}
