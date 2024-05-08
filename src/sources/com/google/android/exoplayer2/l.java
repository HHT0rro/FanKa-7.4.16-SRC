package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;

/* compiled from: DefaultLoadControl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class l implements v0 {

    /* renamed from: a, reason: collision with root package name */
    public final o6.l f20750a;

    /* renamed from: b, reason: collision with root package name */
    public final long f20751b;

    /* renamed from: c, reason: collision with root package name */
    public final long f20752c;

    /* renamed from: d, reason: collision with root package name */
    public final long f20753d;

    /* renamed from: e, reason: collision with root package name */
    public final long f20754e;

    /* renamed from: f, reason: collision with root package name */
    public final int f20755f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f20756g;

    /* renamed from: h, reason: collision with root package name */
    public final long f20757h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f20758i;

    /* renamed from: j, reason: collision with root package name */
    public int f20759j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f20760k;

    public l() {
        this(new o6.l(true, 65536), 50000, 50000, 2500, 5000, -1, false, 0, false);
    }

    public static void i(int i10, int i11, String str, String str2) {
        boolean z10 = i10 >= i11;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(str2).length());
        sb2.append(str);
        sb2.append(" cannot be less than ");
        sb2.append(str2);
        com.google.android.exoplayer2.util.a.b(z10, sb2.toString());
    }

    public static int k(int i10) {
        if (i10 == 0) {
            return 144310272;
        }
        if (i10 == 1) {
            return 13107200;
        }
        if (i10 == 2) {
            return 131072000;
        }
        if (i10 == 3 || i10 == 5 || i10 == 6) {
            return 131072;
        }
        if (i10 == 7) {
            return 0;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.exoplayer2.v0
    public boolean a() {
        return this.f20758i;
    }

    @Override // com.google.android.exoplayer2.v0
    public void b(l1[] l1VarArr, TrackGroupArray trackGroupArray, ExoTrackSelection[] exoTrackSelectionArr) {
        int i10 = this.f20755f;
        if (i10 == -1) {
            i10 = j(l1VarArr, exoTrackSelectionArr);
        }
        this.f20759j = i10;
        this.f20750a.h(i10);
    }

    @Override // com.google.android.exoplayer2.v0
    public void c() {
        l(true);
    }

    @Override // com.google.android.exoplayer2.v0
    public boolean d(long j10, long j11, float f10) {
        boolean z10 = true;
        boolean z11 = this.f20750a.f() >= this.f20759j;
        long j12 = this.f20751b;
        if (f10 > 1.0f) {
            j12 = Math.min(com.google.android.exoplayer2.util.j0.W(j12, f10), this.f20752c);
        }
        if (j11 < Math.max(j12, 500000L)) {
            if (!this.f20756g && z11) {
                z10 = false;
            }
            this.f20760k = z10;
            if (!z10 && j11 < 500000) {
                com.google.android.exoplayer2.util.m.h("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j11 >= this.f20752c || z11) {
            this.f20760k = false;
        }
        return this.f20760k;
    }

    @Override // com.google.android.exoplayer2.v0
    public long e() {
        return this.f20757h;
    }

    @Override // com.google.android.exoplayer2.v0
    public boolean f(long j10, float f10, boolean z10, long j11) {
        long b02 = com.google.android.exoplayer2.util.j0.b0(j10, f10);
        long j12 = z10 ? this.f20754e : this.f20753d;
        if (j11 != -9223372036854775807L) {
            j12 = Math.min(j11 / 2, j12);
        }
        return j12 <= 0 || b02 >= j12 || (!this.f20756g && this.f20750a.f() >= this.f20759j);
    }

    @Override // com.google.android.exoplayer2.v0
    public o6.b g() {
        return this.f20750a;
    }

    @Override // com.google.android.exoplayer2.v0
    public void h() {
        l(true);
    }

    public int j(l1[] l1VarArr, ExoTrackSelection[] exoTrackSelectionArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < l1VarArr.length; i11++) {
            if (exoTrackSelectionArr[i11] != null) {
                i10 += k(l1VarArr[i11].g());
            }
        }
        return Math.max(13107200, i10);
    }

    public final void l(boolean z10) {
        int i10 = this.f20755f;
        if (i10 == -1) {
            i10 = 13107200;
        }
        this.f20759j = i10;
        this.f20760k = false;
        if (z10) {
            this.f20750a.g();
        }
    }

    @Override // com.google.android.exoplayer2.v0
    public void onPrepared() {
        l(false);
    }

    public l(o6.l lVar, int i10, int i11, int i12, int i13, int i14, boolean z10, int i15, boolean z11) {
        i(i12, 0, "bufferForPlaybackMs", "0");
        i(i13, 0, "bufferForPlaybackAfterRebufferMs", "0");
        i(i10, i12, "minBufferMs", "bufferForPlaybackMs");
        i(i10, i13, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        i(i11, i10, "maxBufferMs", "minBufferMs");
        i(i15, 0, "backBufferDurationMs", "0");
        this.f20750a = lVar;
        this.f20751b = h.d(i10);
        this.f20752c = h.d(i11);
        this.f20753d = h.d(i12);
        this.f20754e = h.d(i13);
        this.f20755f = i14;
        this.f20759j = i14 == -1 ? 13107200 : i14;
        this.f20756g = z10;
        this.f20757h = h.d(i15);
        this.f20758i = z11;
    }
}
