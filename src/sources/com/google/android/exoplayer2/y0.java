package com.google.android.exoplayer2;

import androidx.annotation.Nullable;
import com.android.internal.logging.nano.MetricsProto;
import com.google.android.exoplayer2.source.s;

/* compiled from: MediaPeriodInfo.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class y0 {

    /* renamed from: a, reason: collision with root package name */
    public final s.a f23249a;

    /* renamed from: b, reason: collision with root package name */
    public final long f23250b;

    /* renamed from: c, reason: collision with root package name */
    public final long f23251c;

    /* renamed from: d, reason: collision with root package name */
    public final long f23252d;

    /* renamed from: e, reason: collision with root package name */
    public final long f23253e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f23254f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f23255g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f23256h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f23257i;

    public y0(s.a aVar, long j10, long j11, long j12, long j13, boolean z10, boolean z11, boolean z12, boolean z13) {
        boolean z14 = false;
        com.google.android.exoplayer2.util.a.a(!z13 || z11);
        com.google.android.exoplayer2.util.a.a(!z12 || z11);
        if (!z10 || (!z11 && !z12 && !z13)) {
            z14 = true;
        }
        com.google.android.exoplayer2.util.a.a(z14);
        this.f23249a = aVar;
        this.f23250b = j10;
        this.f23251c = j11;
        this.f23252d = j12;
        this.f23253e = j13;
        this.f23254f = z10;
        this.f23255g = z11;
        this.f23256h = z12;
        this.f23257i = z13;
    }

    public y0 a(long j10) {
        return j10 == this.f23251c ? this : new y0(this.f23249a, this.f23250b, j10, this.f23252d, this.f23253e, this.f23254f, this.f23255g, this.f23256h, this.f23257i);
    }

    public y0 b(long j10) {
        return j10 == this.f23250b ? this : new y0(this.f23249a, j10, this.f23251c, this.f23252d, this.f23253e, this.f23254f, this.f23255g, this.f23256h, this.f23257i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || y0.class != obj.getClass()) {
            return false;
        }
        y0 y0Var = (y0) obj;
        return this.f23250b == y0Var.f23250b && this.f23251c == y0Var.f23251c && this.f23252d == y0Var.f23252d && this.f23253e == y0Var.f23253e && this.f23254f == y0Var.f23254f && this.f23255g == y0Var.f23255g && this.f23256h == y0Var.f23256h && this.f23257i == y0Var.f23257i && com.google.android.exoplayer2.util.j0.c(this.f23249a, y0Var.f23249a);
    }

    public int hashCode() {
        return ((((((((((((((((MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE + this.f23249a.hashCode()) * 31) + ((int) this.f23250b)) * 31) + ((int) this.f23251c)) * 31) + ((int) this.f23252d)) * 31) + ((int) this.f23253e)) * 31) + (this.f23254f ? 1 : 0)) * 31) + (this.f23255g ? 1 : 0)) * 31) + (this.f23256h ? 1 : 0)) * 31) + (this.f23257i ? 1 : 0);
    }
}
