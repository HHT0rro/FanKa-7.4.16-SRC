package com.cupidapp.live.feed.layout;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PostSendMsgLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SoftKeyboardEvent {
    private final boolean show;

    public SoftKeyboardEvent(boolean z10) {
        this.show = z10;
    }

    public static /* synthetic */ SoftKeyboardEvent copy$default(SoftKeyboardEvent softKeyboardEvent, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = softKeyboardEvent.show;
        }
        return softKeyboardEvent.copy(z10);
    }

    public final boolean component1() {
        return this.show;
    }

    @NotNull
    public final SoftKeyboardEvent copy(boolean z10) {
        return new SoftKeyboardEvent(z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SoftKeyboardEvent) && this.show == ((SoftKeyboardEvent) obj).show;
    }

    public final boolean getShow() {
        return this.show;
    }

    public int hashCode() {
        boolean z10 = this.show;
        if (z10) {
            return 1;
        }
        return z10 ? 1 : 0;
    }

    @NotNull
    public String toString() {
        return "SoftKeyboardEvent(show=" + this.show + ")";
    }
}
