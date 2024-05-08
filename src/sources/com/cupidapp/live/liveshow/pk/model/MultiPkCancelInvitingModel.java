package com.cupidapp.live.liveshow.pk.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MultiPersonPkGrpcModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MultiPkCancelInvitingModel {

    @NotNull
    private final String pkLiveShowId;

    @NotNull
    private final String pkPrepareId;

    public MultiPkCancelInvitingModel(@NotNull String pkLiveShowId, @NotNull String pkPrepareId) {
        s.i(pkLiveShowId, "pkLiveShowId");
        s.i(pkPrepareId, "pkPrepareId");
        this.pkLiveShowId = pkLiveShowId;
        this.pkPrepareId = pkPrepareId;
    }

    public static /* synthetic */ MultiPkCancelInvitingModel copy$default(MultiPkCancelInvitingModel multiPkCancelInvitingModel, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = multiPkCancelInvitingModel.pkLiveShowId;
        }
        if ((i10 & 2) != 0) {
            str2 = multiPkCancelInvitingModel.pkPrepareId;
        }
        return multiPkCancelInvitingModel.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.pkLiveShowId;
    }

    @NotNull
    public final String component2() {
        return this.pkPrepareId;
    }

    @NotNull
    public final MultiPkCancelInvitingModel copy(@NotNull String pkLiveShowId, @NotNull String pkPrepareId) {
        s.i(pkLiveShowId, "pkLiveShowId");
        s.i(pkPrepareId, "pkPrepareId");
        return new MultiPkCancelInvitingModel(pkLiveShowId, pkPrepareId);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MultiPkCancelInvitingModel)) {
            return false;
        }
        MultiPkCancelInvitingModel multiPkCancelInvitingModel = (MultiPkCancelInvitingModel) obj;
        return s.d(this.pkLiveShowId, multiPkCancelInvitingModel.pkLiveShowId) && s.d(this.pkPrepareId, multiPkCancelInvitingModel.pkPrepareId);
    }

    @NotNull
    public final String getPkLiveShowId() {
        return this.pkLiveShowId;
    }

    @NotNull
    public final String getPkPrepareId() {
        return this.pkPrepareId;
    }

    public int hashCode() {
        return (this.pkLiveShowId.hashCode() * 31) + this.pkPrepareId.hashCode();
    }

    @NotNull
    public String toString() {
        return "MultiPkCancelInvitingModel(pkLiveShowId=" + this.pkLiveShowId + ", pkPrepareId=" + this.pkPrepareId + ")";
    }
}
