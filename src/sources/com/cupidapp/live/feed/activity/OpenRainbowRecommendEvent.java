package com.cupidapp.live.feed.activity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RainbowRecommendActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class OpenRainbowRecommendEvent {
    private final boolean open;

    public OpenRainbowRecommendEvent(boolean z10) {
        this.open = z10;
    }

    public static /* synthetic */ OpenRainbowRecommendEvent copy$default(OpenRainbowRecommendEvent openRainbowRecommendEvent, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = openRainbowRecommendEvent.open;
        }
        return openRainbowRecommendEvent.copy(z10);
    }

    public final boolean component1() {
        return this.open;
    }

    @NotNull
    public final OpenRainbowRecommendEvent copy(boolean z10) {
        return new OpenRainbowRecommendEvent(z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OpenRainbowRecommendEvent) && this.open == ((OpenRainbowRecommendEvent) obj).open;
    }

    public final boolean getOpen() {
        return this.open;
    }

    public int hashCode() {
        boolean z10 = this.open;
        if (z10) {
            return 1;
        }
        return z10 ? 1 : 0;
    }

    @NotNull
    public String toString() {
        return "OpenRainbowRecommendEvent(open=" + this.open + ")";
    }
}
