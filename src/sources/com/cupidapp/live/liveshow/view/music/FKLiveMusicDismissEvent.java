package com.cupidapp.live.liveshow.view.music;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveMusicFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveMusicDismissEvent {
    private final boolean quitPlay;

    public FKLiveMusicDismissEvent(boolean z10) {
        this.quitPlay = z10;
    }

    public static /* synthetic */ FKLiveMusicDismissEvent copy$default(FKLiveMusicDismissEvent fKLiveMusicDismissEvent, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = fKLiveMusicDismissEvent.quitPlay;
        }
        return fKLiveMusicDismissEvent.copy(z10);
    }

    public final boolean component1() {
        return this.quitPlay;
    }

    @NotNull
    public final FKLiveMusicDismissEvent copy(boolean z10) {
        return new FKLiveMusicDismissEvent(z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FKLiveMusicDismissEvent) && this.quitPlay == ((FKLiveMusicDismissEvent) obj).quitPlay;
    }

    public final boolean getQuitPlay() {
        return this.quitPlay;
    }

    public int hashCode() {
        boolean z10 = this.quitPlay;
        if (z10) {
            return 1;
        }
        return z10 ? 1 : 0;
    }

    @NotNull
    public String toString() {
        return "FKLiveMusicDismissEvent(quitPlay=" + this.quitPlay + ")";
    }
}
