package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import java.util.Collections;
import java.util.List;

/* compiled from: BasePlayer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class e implements Player {

    /* renamed from: a, reason: collision with root package name */
    public final Timeline.c f19991a = new Timeline.c();

    @Override // com.google.android.exoplayer2.Player
    public final void B() {
        if (E().q() || f()) {
            return;
        }
        boolean a02 = a0();
        if (c0() && !y()) {
            if (a02) {
                g0();
            }
        } else if (a02 && getCurrentPosition() <= r()) {
            g0();
        } else {
            seekTo(0L);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public final void G() {
        if (E().q() || f()) {
            return;
        }
        if (Z()) {
            e0();
        } else if (c0() && b0()) {
            z();
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public final void R() {
        f0(-T());
    }

    public Player.b U(Player.b bVar) {
        return new Player.b.a().b(bVar).d(3, !f()).d(4, y() && !f()).d(5, a0() && !f()).d(6, !E().q() && (a0() || !c0() || y()) && !f()).d(7, Z() && !f()).d(8, !E().q() && (Z() || (c0() && b0())) && !f()).d(9, !f()).d(10, y() && !f()).d(11, y() && !f()).e();
    }

    public final long V() {
        Timeline E = E();
        if (E.q()) {
            return -9223372036854775807L;
        }
        return E.n(A(), this.f19991a).d();
    }

    public final int W() {
        Timeline E = E();
        if (E.q()) {
            return -1;
        }
        return E.e(A(), Y(), Q());
    }

    public final int X() {
        Timeline E = E();
        if (E.q()) {
            return -1;
        }
        return E.l(A(), Y(), Q());
    }

    public final int Y() {
        int repeatMode = getRepeatMode();
        if (repeatMode == 1) {
            return 0;
        }
        return repeatMode;
    }

    public final boolean Z() {
        return W() != -1;
    }

    public final boolean a0() {
        return X() != -1;
    }

    public final boolean b0() {
        Timeline E = E();
        return !E.q() && E.n(A(), this.f19991a).f19675i;
    }

    public final boolean c0() {
        Timeline E = E();
        return !E.q() && E.n(A(), this.f19991a).f();
    }

    public final void d0(int i10) {
        J(i10, -9223372036854775807L);
    }

    public final void e0() {
        int W = W();
        if (W != -1) {
            d0(W);
        }
    }

    public final void f0(long j10) {
        long currentPosition = getCurrentPosition() + j10;
        long duration = getDuration();
        if (duration != -9223372036854775807L) {
            currentPosition = Math.min(currentPosition, duration);
        }
        seekTo(Math.max(currentPosition, 0L));
    }

    public final void g0() {
        int X = X();
        if (X != -1) {
            d0(X);
        }
    }

    public final void h0(w0 w0Var) {
        i0(Collections.singletonList(w0Var));
    }

    public final void i0(List<w0> list) {
        i(list, true);
    }

    @Override // com.google.android.exoplayer2.Player
    public final boolean isPlaying() {
        return getPlaybackState() == 3 && o() && D() == 0;
    }

    @Override // com.google.android.exoplayer2.Player
    public final boolean m(int i10) {
        return K().b(i10);
    }

    @Override // com.google.android.exoplayer2.Player
    public final void seekTo(long j10) {
        J(A(), j10);
    }

    @Override // com.google.android.exoplayer2.Player
    public final void stop() {
        q(false);
    }

    @Override // com.google.android.exoplayer2.Player
    public final void x() {
        f0(v());
    }

    @Override // com.google.android.exoplayer2.Player
    public final boolean y() {
        Timeline E = E();
        return !E.q() && E.n(A(), this.f19991a).f19674h;
    }

    @Override // com.google.android.exoplayer2.Player
    public final void z() {
        d0(A());
    }
}
