package com.cupidapp.live.base.network.model;

import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProfileResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ProfileResult {
    private final boolean canSendInboxMessage;
    private final boolean hasValidYellowCard;

    @Nullable
    private final Boolean hiddenFootmark;

    @NotNull
    private final LiveShowModel liveShow;

    @NotNull
    private final User user;

    @Nullable
    private final String warningMessage;

    public ProfileResult(@NotNull User user, boolean z10, @Nullable String str, @NotNull LiveShowModel liveShow, boolean z11, @Nullable Boolean bool) {
        s.i(user, "user");
        s.i(liveShow, "liveShow");
        this.user = user;
        this.hasValidYellowCard = z10;
        this.warningMessage = str;
        this.liveShow = liveShow;
        this.canSendInboxMessage = z11;
        this.hiddenFootmark = bool;
    }

    public static /* synthetic */ ProfileResult copy$default(ProfileResult profileResult, User user, boolean z10, String str, LiveShowModel liveShowModel, boolean z11, Boolean bool, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            user = profileResult.user;
        }
        if ((i10 & 2) != 0) {
            z10 = profileResult.hasValidYellowCard;
        }
        boolean z12 = z10;
        if ((i10 & 4) != 0) {
            str = profileResult.warningMessage;
        }
        String str2 = str;
        if ((i10 & 8) != 0) {
            liveShowModel = profileResult.liveShow;
        }
        LiveShowModel liveShowModel2 = liveShowModel;
        if ((i10 & 16) != 0) {
            z11 = profileResult.canSendInboxMessage;
        }
        boolean z13 = z11;
        if ((i10 & 32) != 0) {
            bool = profileResult.hiddenFootmark;
        }
        return profileResult.copy(user, z12, str2, liveShowModel2, z13, bool);
    }

    @NotNull
    public final User component1() {
        return this.user;
    }

    public final boolean component2() {
        return this.hasValidYellowCard;
    }

    @Nullable
    public final String component3() {
        return this.warningMessage;
    }

    @NotNull
    public final LiveShowModel component4() {
        return this.liveShow;
    }

    public final boolean component5() {
        return this.canSendInboxMessage;
    }

    @Nullable
    public final Boolean component6() {
        return this.hiddenFootmark;
    }

    @NotNull
    public final ProfileResult copy(@NotNull User user, boolean z10, @Nullable String str, @NotNull LiveShowModel liveShow, boolean z11, @Nullable Boolean bool) {
        s.i(user, "user");
        s.i(liveShow, "liveShow");
        return new ProfileResult(user, z10, str, liveShow, z11, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileResult)) {
            return false;
        }
        ProfileResult profileResult = (ProfileResult) obj;
        return s.d(this.user, profileResult.user) && this.hasValidYellowCard == profileResult.hasValidYellowCard && s.d(this.warningMessage, profileResult.warningMessage) && s.d(this.liveShow, profileResult.liveShow) && this.canSendInboxMessage == profileResult.canSendInboxMessage && s.d(this.hiddenFootmark, profileResult.hiddenFootmark);
    }

    public final boolean getCanSendInboxMessage() {
        return this.canSendInboxMessage;
    }

    public final boolean getHasValidYellowCard() {
        return this.hasValidYellowCard;
    }

    @Nullable
    public final Boolean getHiddenFootmark() {
        return this.hiddenFootmark;
    }

    @NotNull
    public final LiveShowModel getLiveShow() {
        return this.liveShow;
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }

    @Nullable
    public final String getWarningMessage() {
        return this.warningMessage;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.user.hashCode() * 31;
        boolean z10 = this.hasValidYellowCard;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode + i10) * 31;
        String str = this.warningMessage;
        int hashCode2 = (((i11 + (str == null ? 0 : str.hashCode())) * 31) + this.liveShow.hashCode()) * 31;
        boolean z11 = this.canSendInboxMessage;
        int i12 = (hashCode2 + (z11 ? 1 : z11 ? 1 : 0)) * 31;
        Boolean bool = this.hiddenFootmark;
        return i12 + (bool != null ? bool.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        User user = this.user;
        boolean z10 = this.hasValidYellowCard;
        String str = this.warningMessage;
        LiveShowModel liveShowModel = this.liveShow;
        return "ProfileResult(user=" + ((Object) user) + ", hasValidYellowCard=" + z10 + ", warningMessage=" + str + ", liveShow=" + ((Object) liveShowModel) + ", canSendInboxMessage=" + this.canSendInboxMessage + ", hiddenFootmark=" + ((Object) this.hiddenFootmark) + ")";
    }
}
