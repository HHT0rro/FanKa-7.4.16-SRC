package com.cupidapp.live.base.recyclerview;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLoopScrollLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class StartOrStopScrollEvent {
    private final boolean stop;

    public StartOrStopScrollEvent(boolean z10) {
        this.stop = z10;
    }

    public static /* synthetic */ StartOrStopScrollEvent copy$default(StartOrStopScrollEvent startOrStopScrollEvent, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = startOrStopScrollEvent.stop;
        }
        return startOrStopScrollEvent.copy(z10);
    }

    public final boolean component1() {
        return this.stop;
    }

    @NotNull
    public final StartOrStopScrollEvent copy(boolean z10) {
        return new StartOrStopScrollEvent(z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StartOrStopScrollEvent) && this.stop == ((StartOrStopScrollEvent) obj).stop;
    }

    public final boolean getStop() {
        return this.stop;
    }

    public int hashCode() {
        boolean z10 = this.stop;
        if (z10) {
            return 1;
        }
        return z10 ? 1 : 0;
    }

    @NotNull
    public String toString() {
        return "StartOrStopScrollEvent(stop=" + this.stop + ")";
    }
}
