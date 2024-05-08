package com.cupidapp.live.liveshow.view.giftpicker.view;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGiftDetailDescriptionLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class HideGiftDetailDescriptionEvent {
    private final boolean hide;

    public HideGiftDetailDescriptionEvent(boolean z10) {
        this.hide = z10;
    }

    public static /* synthetic */ HideGiftDetailDescriptionEvent copy$default(HideGiftDetailDescriptionEvent hideGiftDetailDescriptionEvent, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = hideGiftDetailDescriptionEvent.hide;
        }
        return hideGiftDetailDescriptionEvent.copy(z10);
    }

    public final boolean component1() {
        return this.hide;
    }

    @NotNull
    public final HideGiftDetailDescriptionEvent copy(boolean z10) {
        return new HideGiftDetailDescriptionEvent(z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof HideGiftDetailDescriptionEvent) && this.hide == ((HideGiftDetailDescriptionEvent) obj).hide;
    }

    public final boolean getHide() {
        return this.hide;
    }

    public int hashCode() {
        boolean z10 = this.hide;
        if (z10) {
            return 1;
        }
        return z10 ? 1 : 0;
    }

    @NotNull
    public String toString() {
        return "HideGiftDetailDescriptionEvent(hide=" + this.hide + ")";
    }
}
