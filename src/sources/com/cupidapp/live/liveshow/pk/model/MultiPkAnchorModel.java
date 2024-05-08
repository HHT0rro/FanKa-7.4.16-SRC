package com.cupidapp.live.liveshow.pk.model;

import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MultiPersonPkModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MultiPkAnchorModel {

    @Nullable
    private String inviteStatus;

    @NotNull
    private final String liveShowId;

    @Nullable
    private String pkPrepareId;

    @Nullable
    private String pkStreamId;

    @NotNull
    private final User user;

    public MultiPkAnchorModel(@NotNull String liveShowId, @NotNull User user, @Nullable String str) {
        s.i(liveShowId, "liveShowId");
        s.i(user, "user");
        this.liveShowId = liveShowId;
        this.user = user;
        this.inviteStatus = str;
    }

    public static /* synthetic */ MultiPkAnchorModel copy$default(MultiPkAnchorModel multiPkAnchorModel, String str, User user, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = multiPkAnchorModel.liveShowId;
        }
        if ((i10 & 2) != 0) {
            user = multiPkAnchorModel.user;
        }
        if ((i10 & 4) != 0) {
            str2 = multiPkAnchorModel.inviteStatus;
        }
        return multiPkAnchorModel.copy(str, user, str2);
    }

    @NotNull
    public final String component1() {
        return this.liveShowId;
    }

    @NotNull
    public final User component2() {
        return this.user;
    }

    @Nullable
    public final String component3() {
        return this.inviteStatus;
    }

    @NotNull
    public final MultiPkAnchorModel copy(@NotNull String liveShowId, @NotNull User user, @Nullable String str) {
        s.i(liveShowId, "liveShowId");
        s.i(user, "user");
        return new MultiPkAnchorModel(liveShowId, user, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MultiPkAnchorModel)) {
            return false;
        }
        MultiPkAnchorModel multiPkAnchorModel = (MultiPkAnchorModel) obj;
        return s.d(this.liveShowId, multiPkAnchorModel.liveShowId) && s.d(this.user, multiPkAnchorModel.user) && s.d(this.inviteStatus, multiPkAnchorModel.inviteStatus);
    }

    @Nullable
    public final String getInviteStatus() {
        return this.inviteStatus;
    }

    @NotNull
    public final String getLiveShowId() {
        return this.liveShowId;
    }

    @Nullable
    public final String getPkPrepareId() {
        return this.pkPrepareId;
    }

    @Nullable
    public final String getPkStreamId() {
        return this.pkStreamId;
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }

    public final boolean hasStream() {
        String str = this.pkStreamId;
        return !(str == null || str.length() == 0);
    }

    public int hashCode() {
        int hashCode = ((this.liveShowId.hashCode() * 31) + this.user.hashCode()) * 31;
        String str = this.inviteStatus;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final void setInviteStatus(@Nullable String str) {
        this.inviteStatus = str;
    }

    public final void setPkPrepareId(@Nullable String str) {
        this.pkPrepareId = str;
    }

    public final void setPkStreamId(@Nullable String str) {
        this.pkStreamId = str;
    }

    @NotNull
    public String toString() {
        String str = this.liveShowId;
        User user = this.user;
        return "MultiPkAnchorModel(liveShowId=" + str + ", user=" + ((Object) user) + ", inviteStatus=" + this.inviteStatus + ")";
    }

    public /* synthetic */ MultiPkAnchorModel(String str, User user, String str2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, user, (i10 & 4) != 0 ? null : str2);
    }
}
