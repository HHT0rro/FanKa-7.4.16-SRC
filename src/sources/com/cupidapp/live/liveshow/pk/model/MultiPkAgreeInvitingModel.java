package com.cupidapp.live.liveshow.pk.model;

import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MultiPersonPkGrpcModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MultiPkAgreeInvitingModel {

    @NotNull
    private final String pkLiveShowId;

    @NotNull
    private final String pkStreamId;

    @NotNull
    private final User pkUser;

    public MultiPkAgreeInvitingModel(@NotNull String pkLiveShowId, @NotNull User pkUser, @NotNull String pkStreamId) {
        s.i(pkLiveShowId, "pkLiveShowId");
        s.i(pkUser, "pkUser");
        s.i(pkStreamId, "pkStreamId");
        this.pkLiveShowId = pkLiveShowId;
        this.pkUser = pkUser;
        this.pkStreamId = pkStreamId;
    }

    public static /* synthetic */ MultiPkAgreeInvitingModel copy$default(MultiPkAgreeInvitingModel multiPkAgreeInvitingModel, String str, User user, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = multiPkAgreeInvitingModel.pkLiveShowId;
        }
        if ((i10 & 2) != 0) {
            user = multiPkAgreeInvitingModel.pkUser;
        }
        if ((i10 & 4) != 0) {
            str2 = multiPkAgreeInvitingModel.pkStreamId;
        }
        return multiPkAgreeInvitingModel.copy(str, user, str2);
    }

    @NotNull
    public final String component1() {
        return this.pkLiveShowId;
    }

    @NotNull
    public final User component2() {
        return this.pkUser;
    }

    @NotNull
    public final String component3() {
        return this.pkStreamId;
    }

    @NotNull
    public final MultiPkAgreeInvitingModel copy(@NotNull String pkLiveShowId, @NotNull User pkUser, @NotNull String pkStreamId) {
        s.i(pkLiveShowId, "pkLiveShowId");
        s.i(pkUser, "pkUser");
        s.i(pkStreamId, "pkStreamId");
        return new MultiPkAgreeInvitingModel(pkLiveShowId, pkUser, pkStreamId);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MultiPkAgreeInvitingModel)) {
            return false;
        }
        MultiPkAgreeInvitingModel multiPkAgreeInvitingModel = (MultiPkAgreeInvitingModel) obj;
        return s.d(this.pkLiveShowId, multiPkAgreeInvitingModel.pkLiveShowId) && s.d(this.pkUser, multiPkAgreeInvitingModel.pkUser) && s.d(this.pkStreamId, multiPkAgreeInvitingModel.pkStreamId);
    }

    @NotNull
    public final String getPkLiveShowId() {
        return this.pkLiveShowId;
    }

    @NotNull
    public final String getPkStreamId() {
        return this.pkStreamId;
    }

    @NotNull
    public final User getPkUser() {
        return this.pkUser;
    }

    public int hashCode() {
        return (((this.pkLiveShowId.hashCode() * 31) + this.pkUser.hashCode()) * 31) + this.pkStreamId.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.pkLiveShowId;
        User user = this.pkUser;
        return "MultiPkAgreeInvitingModel(pkLiveShowId=" + str + ", pkUser=" + ((Object) user) + ", pkStreamId=" + this.pkStreamId + ")";
    }
}
