package com.cupidapp.live.feed.event;

import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedEventModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SwipeRefreshIsEnabledEvent {
    private final boolean isEnabled;

    public SwipeRefreshIsEnabledEvent(boolean z10) {
        this.isEnabled = z10;
    }

    public static /* synthetic */ SwipeRefreshIsEnabledEvent copy$default(SwipeRefreshIsEnabledEvent swipeRefreshIsEnabledEvent, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = swipeRefreshIsEnabledEvent.isEnabled;
        }
        return swipeRefreshIsEnabledEvent.copy(z10);
    }

    public final boolean component1() {
        return this.isEnabled;
    }

    @NotNull
    public final SwipeRefreshIsEnabledEvent copy(boolean z10) {
        return new SwipeRefreshIsEnabledEvent(z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SwipeRefreshIsEnabledEvent) && this.isEnabled == ((SwipeRefreshIsEnabledEvent) obj).isEnabled;
    }

    public int hashCode() {
        boolean z10 = this.isEnabled;
        if (z10) {
            return 1;
        }
        return z10 ? 1 : 0;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    @NotNull
    public String toString() {
        return "SwipeRefreshIsEnabledEvent(isEnabled=" + this.isEnabled + ")";
    }
}
