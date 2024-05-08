package com.cupidapp.live.chat.event;

import kotlin.d;

/* compiled from: CloseTwoLevelFloorEvent.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class EnableSecondPullCloseEvent {
    private final boolean canPull;

    public EnableSecondPullCloseEvent(boolean z10) {
        this.canPull = z10;
    }

    public final boolean getCanPull() {
        return this.canPull;
    }
}
