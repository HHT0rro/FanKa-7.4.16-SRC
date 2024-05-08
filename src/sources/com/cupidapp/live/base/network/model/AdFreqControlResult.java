package com.cupidapp.live.base.network.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConstantsResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AdFreqControlResult {
    private final boolean hitControl;

    public AdFreqControlResult(boolean z10) {
        this.hitControl = z10;
    }

    public static /* synthetic */ AdFreqControlResult copy$default(AdFreqControlResult adFreqControlResult, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = adFreqControlResult.hitControl;
        }
        return adFreqControlResult.copy(z10);
    }

    public final boolean component1() {
        return this.hitControl;
    }

    @NotNull
    public final AdFreqControlResult copy(boolean z10) {
        return new AdFreqControlResult(z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AdFreqControlResult) && this.hitControl == ((AdFreqControlResult) obj).hitControl;
    }

    public final boolean getHitControl() {
        return this.hitControl;
    }

    public int hashCode() {
        boolean z10 = this.hitControl;
        if (z10) {
            return 1;
        }
        return z10 ? 1 : 0;
    }

    @NotNull
    public String toString() {
        return "AdFreqControlResult(hitControl=" + this.hitControl + ")";
    }
}
