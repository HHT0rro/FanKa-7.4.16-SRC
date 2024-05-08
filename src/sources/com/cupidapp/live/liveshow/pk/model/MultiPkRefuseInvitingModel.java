package com.cupidapp.live.liveshow.pk.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MultiPersonPkGrpcModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MultiPkRefuseInvitingModel {

    @NotNull
    private final String pkLiveShowId;

    public MultiPkRefuseInvitingModel(@NotNull String pkLiveShowId) {
        s.i(pkLiveShowId, "pkLiveShowId");
        this.pkLiveShowId = pkLiveShowId;
    }

    public static /* synthetic */ MultiPkRefuseInvitingModel copy$default(MultiPkRefuseInvitingModel multiPkRefuseInvitingModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = multiPkRefuseInvitingModel.pkLiveShowId;
        }
        return multiPkRefuseInvitingModel.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.pkLiveShowId;
    }

    @NotNull
    public final MultiPkRefuseInvitingModel copy(@NotNull String pkLiveShowId) {
        s.i(pkLiveShowId, "pkLiveShowId");
        return new MultiPkRefuseInvitingModel(pkLiveShowId);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MultiPkRefuseInvitingModel) && s.d(this.pkLiveShowId, ((MultiPkRefuseInvitingModel) obj).pkLiveShowId);
    }

    @NotNull
    public final String getPkLiveShowId() {
        return this.pkLiveShowId;
    }

    public int hashCode() {
        return this.pkLiveShowId.hashCode();
    }

    @NotNull
    public String toString() {
        return "MultiPkRefuseInvitingModel(pkLiveShowId=" + this.pkLiveShowId + ")";
    }
}
