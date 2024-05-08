package com.google.android.exoplayer2;

/* compiled from: DefaultControlDispatcher.java */
@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class j implements i {

    /* renamed from: b, reason: collision with root package name */
    public final long f20719b = -9223372036854775807L;

    /* renamed from: a, reason: collision with root package name */
    public final long f20718a = -9223372036854775807L;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f20720c = false;

    public static void o(Player player, long j10) {
        long currentPosition = player.getCurrentPosition() + j10;
        long duration = player.getDuration();
        if (duration != -9223372036854775807L) {
            currentPosition = Math.min(currentPosition, duration);
        }
        player.seekTo(Math.max(currentPosition, 0L));
    }

    @Override // com.google.android.exoplayer2.i
    public boolean a(Player player, f1 f1Var) {
        player.c(f1Var);
        return true;
    }

    @Override // com.google.android.exoplayer2.i
    public boolean b(Player player, int i10, long j10) {
        player.J(i10, j10);
        return true;
    }

    @Override // com.google.android.exoplayer2.i
    public boolean c(Player player, boolean z10) {
        player.p(z10);
        return true;
    }

    @Override // com.google.android.exoplayer2.i
    public boolean d(Player player, int i10) {
        player.setRepeatMode(i10);
        return true;
    }

    @Override // com.google.android.exoplayer2.i
    public boolean e(Player player) {
        if (!this.f20720c) {
            player.x();
            return true;
        }
        if (!l() || !player.y()) {
            return true;
        }
        o(player, this.f20719b);
        return true;
    }

    @Override // com.google.android.exoplayer2.i
    public boolean f() {
        return !this.f20720c || this.f20718a > 0;
    }

    @Override // com.google.android.exoplayer2.i
    public boolean g(Player player) {
        player.prepare();
        return true;
    }

    @Override // com.google.android.exoplayer2.i
    public boolean h(Player player) {
        player.B();
        return true;
    }

    @Override // com.google.android.exoplayer2.i
    public boolean i(Player player) {
        player.G();
        return true;
    }

    @Override // com.google.android.exoplayer2.i
    public boolean j(Player player, boolean z10) {
        player.setPlayWhenReady(z10);
        return true;
    }

    @Override // com.google.android.exoplayer2.i
    public boolean k(Player player) {
        if (!this.f20720c) {
            player.R();
            return true;
        }
        if (!f() || !player.y()) {
            return true;
        }
        o(player, -this.f20718a);
        return true;
    }

    @Override // com.google.android.exoplayer2.i
    public boolean l() {
        return !this.f20720c || this.f20719b > 0;
    }

    public long m(Player player) {
        if (this.f20720c) {
            return this.f20719b;
        }
        return player.v();
    }

    public long n(Player player) {
        return this.f20720c ? this.f20718a : player.T();
    }
}
