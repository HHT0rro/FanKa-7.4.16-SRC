package n6;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.util.j0;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import x5.n;

/* compiled from: BaseTrackSelection.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class b implements ExoTrackSelection {

    /* renamed from: a, reason: collision with root package name */
    public final TrackGroup f52130a;

    /* renamed from: b, reason: collision with root package name */
    public final int f52131b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f52132c;

    /* renamed from: d, reason: collision with root package name */
    public final int f52133d;

    /* renamed from: e, reason: collision with root package name */
    public final Format[] f52134e;

    /* renamed from: f, reason: collision with root package name */
    public final long[] f52135f;

    /* renamed from: g, reason: collision with root package name */
    public int f52136g;

    public b(TrackGroup trackGroup, int... iArr) {
        this(trackGroup, iArr, 0);
    }

    public static /* synthetic */ int w(Format format, Format format2) {
        return format2.f19540i - format.f19540i;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public boolean b(int i10, long j10) {
        return this.f52135f[i10] > j10;
    }

    @Override // n6.g
    public final int c(int i10) {
        return this.f52132c[i10];
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public /* synthetic */ void d() {
        e.a(this);
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public void e() {
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f52130a == bVar.f52130a && Arrays.equals(this.f52132c, bVar.f52132c);
    }

    @Override // n6.g
    public final int f(int i10) {
        for (int i11 = 0; i11 < this.f52131b; i11++) {
            if (this.f52132c[i11] == i10) {
                return i11;
            }
        }
        return -1;
    }

    @Override // n6.g
    public final TrackGroup g() {
        return this.f52130a;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public /* synthetic */ boolean h(long j10, x5.f fVar, List list) {
        return e.d(this, j10, fVar, list);
    }

    public int hashCode() {
        if (this.f52136g == 0) {
            this.f52136g = (System.identityHashCode(this.f52130a) * 31) + Arrays.hashCode(this.f52132c);
        }
        return this.f52136g;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public void j() {
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public int k(long j10, List<? extends n> list) {
        return list.size();
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public final int l() {
        return this.f52132c[a()];
    }

    @Override // n6.g
    public final int length() {
        return this.f52132c.length;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public final Format m() {
        return this.f52134e[a()];
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public /* synthetic */ void n() {
        e.c(this);
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public boolean o(int i10, long j10) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean b4 = b(i10, elapsedRealtime);
        int i11 = 0;
        while (i11 < this.f52131b && !b4) {
            b4 = (i11 == i10 || b(i11, elapsedRealtime)) ? false : true;
            i11++;
        }
        if (!b4) {
            return false;
        }
        long[] jArr = this.f52135f;
        jArr[i10] = Math.max(jArr[i10], j0.b(elapsedRealtime, j10, Long.MAX_VALUE));
        return true;
    }

    @Override // n6.g
    public final Format p(int i10) {
        return this.f52134e[i10];
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public void q(float f10) {
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public /* synthetic */ void s(boolean z10) {
        e.b(this, z10);
    }

    @Override // n6.g
    public final int t(Format format) {
        for (int i10 = 0; i10 < this.f52131b; i10++) {
            if (this.f52134e[i10] == format) {
                return i10;
            }
        }
        return -1;
    }

    public b(TrackGroup trackGroup, int[] iArr, int i10) {
        int i11 = 0;
        com.google.android.exoplayer2.util.a.g(iArr.length > 0);
        this.f52133d = i10;
        this.f52130a = (TrackGroup) com.google.android.exoplayer2.util.a.e(trackGroup);
        int length = iArr.length;
        this.f52131b = length;
        this.f52134e = new Format[length];
        for (int i12 = 0; i12 < iArr.length; i12++) {
            this.f52134e[i12] = trackGroup.a(iArr[i12]);
        }
        Arrays.sort(this.f52134e, new Comparator() { // from class: n6.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int w3;
                w3 = b.w((Format) obj, (Format) obj2);
                return w3;
            }
        });
        this.f52132c = new int[this.f52131b];
        while (true) {
            int i13 = this.f52131b;
            if (i11 < i13) {
                this.f52132c[i11] = trackGroup.b(this.f52134e[i11]);
                i11++;
            } else {
                this.f52135f = new long[i13];
                return;
            }
        }
    }
}
