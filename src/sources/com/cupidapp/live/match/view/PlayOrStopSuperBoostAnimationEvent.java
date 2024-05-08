package com.cupidapp.live.match.view;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NearByBoostEntranceLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PlayOrStopSuperBoostAnimationEvent {
    private final boolean play;

    public PlayOrStopSuperBoostAnimationEvent(boolean z10) {
        this.play = z10;
    }

    public static /* synthetic */ PlayOrStopSuperBoostAnimationEvent copy$default(PlayOrStopSuperBoostAnimationEvent playOrStopSuperBoostAnimationEvent, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = playOrStopSuperBoostAnimationEvent.play;
        }
        return playOrStopSuperBoostAnimationEvent.copy(z10);
    }

    public final boolean component1() {
        return this.play;
    }

    @NotNull
    public final PlayOrStopSuperBoostAnimationEvent copy(boolean z10) {
        return new PlayOrStopSuperBoostAnimationEvent(z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PlayOrStopSuperBoostAnimationEvent) && this.play == ((PlayOrStopSuperBoostAnimationEvent) obj).play;
    }

    public final boolean getPlay() {
        return this.play;
    }

    public int hashCode() {
        boolean z10 = this.play;
        if (z10) {
            return 1;
        }
        return z10 ? 1 : 0;
    }

    @NotNull
    public String toString() {
        return "PlayOrStopSuperBoostAnimationEvent(play=" + this.play + ")";
    }
}
