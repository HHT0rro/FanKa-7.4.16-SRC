package com.cupidapp.live.liveshow.pk.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MultiPersonPkModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AcceptInvitingResult {

    @NotNull
    private final String mixStreamId;

    @NotNull
    private final List<MultiPkUserInfoModel> pkUsers;

    @Nullable
    private final String rtmpUrlPrefix;

    public AcceptInvitingResult(@NotNull List<MultiPkUserInfoModel> pkUsers, @NotNull String mixStreamId, @Nullable String str) {
        s.i(pkUsers, "pkUsers");
        s.i(mixStreamId, "mixStreamId");
        this.pkUsers = pkUsers;
        this.mixStreamId = mixStreamId;
        this.rtmpUrlPrefix = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AcceptInvitingResult copy$default(AcceptInvitingResult acceptInvitingResult, List list, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = acceptInvitingResult.pkUsers;
        }
        if ((i10 & 2) != 0) {
            str = acceptInvitingResult.mixStreamId;
        }
        if ((i10 & 4) != 0) {
            str2 = acceptInvitingResult.rtmpUrlPrefix;
        }
        return acceptInvitingResult.copy(list, str, str2);
    }

    @NotNull
    public final List<MultiPkUserInfoModel> component1() {
        return this.pkUsers;
    }

    @NotNull
    public final String component2() {
        return this.mixStreamId;
    }

    @Nullable
    public final String component3() {
        return this.rtmpUrlPrefix;
    }

    @NotNull
    public final AcceptInvitingResult copy(@NotNull List<MultiPkUserInfoModel> pkUsers, @NotNull String mixStreamId, @Nullable String str) {
        s.i(pkUsers, "pkUsers");
        s.i(mixStreamId, "mixStreamId");
        return new AcceptInvitingResult(pkUsers, mixStreamId, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AcceptInvitingResult)) {
            return false;
        }
        AcceptInvitingResult acceptInvitingResult = (AcceptInvitingResult) obj;
        return s.d(this.pkUsers, acceptInvitingResult.pkUsers) && s.d(this.mixStreamId, acceptInvitingResult.mixStreamId) && s.d(this.rtmpUrlPrefix, acceptInvitingResult.rtmpUrlPrefix);
    }

    @NotNull
    public final String getMixStreamId() {
        return this.mixStreamId;
    }

    @NotNull
    public final List<MultiPkUserInfoModel> getPkUsers() {
        return this.pkUsers;
    }

    @Nullable
    public final String getRtmpUrlPrefix() {
        return this.rtmpUrlPrefix;
    }

    public int hashCode() {
        int hashCode = ((this.pkUsers.hashCode() * 31) + this.mixStreamId.hashCode()) * 31;
        String str = this.rtmpUrlPrefix;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        List<MultiPkUserInfoModel> list = this.pkUsers;
        return "AcceptInvitingResult(pkUsers=" + ((Object) list) + ", mixStreamId=" + this.mixStreamId + ", rtmpUrlPrefix=" + this.rtmpUrlPrefix + ")";
    }
}
