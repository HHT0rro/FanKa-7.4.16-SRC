package com.cupidapp.live.liveshow.pk.model;

import com.cupidapp.live.profile.model.User;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MultiPersonPkGrpcModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MultiPkInvitationModel implements Serializable {

    @NotNull
    private final User invitee;

    @NotNull
    private final String inviteeShowId;

    @NotNull
    private final User inviter;

    @NotNull
    private final String pkPrepareId;

    public MultiPkInvitationModel(@NotNull User inviter, @NotNull String inviteeShowId, @NotNull User invitee, @NotNull String pkPrepareId) {
        s.i(inviter, "inviter");
        s.i(inviteeShowId, "inviteeShowId");
        s.i(invitee, "invitee");
        s.i(pkPrepareId, "pkPrepareId");
        this.inviter = inviter;
        this.inviteeShowId = inviteeShowId;
        this.invitee = invitee;
        this.pkPrepareId = pkPrepareId;
    }

    public static /* synthetic */ MultiPkInvitationModel copy$default(MultiPkInvitationModel multiPkInvitationModel, User user, String str, User user2, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            user = multiPkInvitationModel.inviter;
        }
        if ((i10 & 2) != 0) {
            str = multiPkInvitationModel.inviteeShowId;
        }
        if ((i10 & 4) != 0) {
            user2 = multiPkInvitationModel.invitee;
        }
        if ((i10 & 8) != 0) {
            str2 = multiPkInvitationModel.pkPrepareId;
        }
        return multiPkInvitationModel.copy(user, str, user2, str2);
    }

    @NotNull
    public final User component1() {
        return this.inviter;
    }

    @NotNull
    public final String component2() {
        return this.inviteeShowId;
    }

    @NotNull
    public final User component3() {
        return this.invitee;
    }

    @NotNull
    public final String component4() {
        return this.pkPrepareId;
    }

    @NotNull
    public final MultiPkInvitationModel copy(@NotNull User inviter, @NotNull String inviteeShowId, @NotNull User invitee, @NotNull String pkPrepareId) {
        s.i(inviter, "inviter");
        s.i(inviteeShowId, "inviteeShowId");
        s.i(invitee, "invitee");
        s.i(pkPrepareId, "pkPrepareId");
        return new MultiPkInvitationModel(inviter, inviteeShowId, invitee, pkPrepareId);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MultiPkInvitationModel)) {
            return false;
        }
        MultiPkInvitationModel multiPkInvitationModel = (MultiPkInvitationModel) obj;
        return s.d(this.inviter, multiPkInvitationModel.inviter) && s.d(this.inviteeShowId, multiPkInvitationModel.inviteeShowId) && s.d(this.invitee, multiPkInvitationModel.invitee) && s.d(this.pkPrepareId, multiPkInvitationModel.pkPrepareId);
    }

    @NotNull
    public final User getInvitee() {
        return this.invitee;
    }

    @NotNull
    public final String getInviteeShowId() {
        return this.inviteeShowId;
    }

    @NotNull
    public final User getInviter() {
        return this.inviter;
    }

    @NotNull
    public final MultiPkAnchorModel getMultiPkAnchorModel() {
        return new MultiPkAnchorModel(this.inviteeShowId, this.invitee, null, 4, null);
    }

    @NotNull
    public final String getPkPrepareId() {
        return this.pkPrepareId;
    }

    public int hashCode() {
        return (((((this.inviter.hashCode() * 31) + this.inviteeShowId.hashCode()) * 31) + this.invitee.hashCode()) * 31) + this.pkPrepareId.hashCode();
    }

    @NotNull
    public String toString() {
        User user = this.inviter;
        String str = this.inviteeShowId;
        User user2 = this.invitee;
        return "MultiPkInvitationModel(inviter=" + ((Object) user) + ", inviteeShowId=" + str + ", invitee=" + ((Object) user2) + ", pkPrepareId=" + this.pkPrepareId + ")";
    }
}
