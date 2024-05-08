package com.cupidapp.live.chat.event;

import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BottomTabVsibilityEvent.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class BottomTabVisibilityEvent {
    private final boolean visible;

    public BottomTabVisibilityEvent(boolean z10) {
        this.visible = z10;
    }

    public static /* synthetic */ BottomTabVisibilityEvent copy$default(BottomTabVisibilityEvent bottomTabVisibilityEvent, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = bottomTabVisibilityEvent.visible;
        }
        return bottomTabVisibilityEvent.copy(z10);
    }

    public final boolean component1() {
        return this.visible;
    }

    @NotNull
    public final BottomTabVisibilityEvent copy(boolean z10) {
        return new BottomTabVisibilityEvent(z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BottomTabVisibilityEvent) && this.visible == ((BottomTabVisibilityEvent) obj).visible;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        boolean z10 = this.visible;
        if (z10) {
            return 1;
        }
        return z10 ? 1 : 0;
    }

    @NotNull
    public String toString() {
        return "BottomTabVisibilityEvent(visible=" + this.visible + ")";
    }
}
