package com.cupidapp.live.liveshow.pk.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MultiPersonPkModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class StartMultiPkResult {

    @NotNull
    private final String pkPairId;

    public StartMultiPkResult(@NotNull String pkPairId) {
        s.i(pkPairId, "pkPairId");
        this.pkPairId = pkPairId;
    }

    public static /* synthetic */ StartMultiPkResult copy$default(StartMultiPkResult startMultiPkResult, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = startMultiPkResult.pkPairId;
        }
        return startMultiPkResult.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.pkPairId;
    }

    @NotNull
    public final StartMultiPkResult copy(@NotNull String pkPairId) {
        s.i(pkPairId, "pkPairId");
        return new StartMultiPkResult(pkPairId);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StartMultiPkResult) && s.d(this.pkPairId, ((StartMultiPkResult) obj).pkPairId);
    }

    @NotNull
    public final String getPkPairId() {
        return this.pkPairId;
    }

    public int hashCode() {
        return this.pkPairId.hashCode();
    }

    @NotNull
    public String toString() {
        return "StartMultiPkResult(pkPairId=" + this.pkPairId + ")";
    }
}
