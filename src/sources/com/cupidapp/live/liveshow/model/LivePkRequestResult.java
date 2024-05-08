package com.cupidapp.live.liveshow.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLivePkResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LivePkRequestResult {
    private final int waitSec;

    public LivePkRequestResult(int i10) {
        this.waitSec = i10;
    }

    public static /* synthetic */ LivePkRequestResult copy$default(LivePkRequestResult livePkRequestResult, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = livePkRequestResult.waitSec;
        }
        return livePkRequestResult.copy(i10);
    }

    public final int component1() {
        return this.waitSec;
    }

    @NotNull
    public final LivePkRequestResult copy(int i10) {
        return new LivePkRequestResult(i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LivePkRequestResult) && this.waitSec == ((LivePkRequestResult) obj).waitSec;
    }

    public final int getWaitSec() {
        return this.waitSec;
    }

    public int hashCode() {
        return this.waitSec;
    }

    @NotNull
    public String toString() {
        return "LivePkRequestResult(waitSec=" + this.waitSec + ")";
    }
}
