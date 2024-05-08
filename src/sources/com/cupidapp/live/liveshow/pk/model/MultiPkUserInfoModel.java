package com.cupidapp.live.liveshow.pk.model;

import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MultiPersonPkModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MultiPkUserInfoModel {

    @NotNull
    private final String liveShowId;

    @Nullable
    private final String streamId;

    @NotNull
    private final User user;

    public MultiPkUserInfoModel(@NotNull String liveShowId, @NotNull User user, @Nullable String str) {
        s.i(liveShowId, "liveShowId");
        s.i(user, "user");
        this.liveShowId = liveShowId;
        this.user = user;
        this.streamId = str;
    }

    public static /* synthetic */ MultiPkUserInfoModel copy$default(MultiPkUserInfoModel multiPkUserInfoModel, String str, User user, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = multiPkUserInfoModel.liveShowId;
        }
        if ((i10 & 2) != 0) {
            user = multiPkUserInfoModel.user;
        }
        if ((i10 & 4) != 0) {
            str2 = multiPkUserInfoModel.streamId;
        }
        return multiPkUserInfoModel.copy(str, user, str2);
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
        return this.streamId;
    }

    @NotNull
    public final MultiPkUserInfoModel copy(@NotNull String liveShowId, @NotNull User user, @Nullable String str) {
        s.i(liveShowId, "liveShowId");
        s.i(user, "user");
        return new MultiPkUserInfoModel(liveShowId, user, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MultiPkUserInfoModel)) {
            return false;
        }
        MultiPkUserInfoModel multiPkUserInfoModel = (MultiPkUserInfoModel) obj;
        return s.d(this.liveShowId, multiPkUserInfoModel.liveShowId) && s.d(this.user, multiPkUserInfoModel.user) && s.d(this.streamId, multiPkUserInfoModel.streamId);
    }

    @NotNull
    public final String getLiveShowId() {
        return this.liveShowId;
    }

    @NotNull
    public final MultiPkAnchorModel getMultiPkAnchorModel() {
        MultiPkAnchorModel multiPkAnchorModel = new MultiPkAnchorModel(this.liveShowId, this.user, null, 4, null);
        multiPkAnchorModel.setPkStreamId(this.streamId);
        return multiPkAnchorModel;
    }

    @Nullable
    public final String getStreamId() {
        return this.streamId;
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        int hashCode = ((this.liveShowId.hashCode() * 31) + this.user.hashCode()) * 31;
        String str = this.streamId;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        String str = this.liveShowId;
        User user = this.user;
        return "MultiPkUserInfoModel(liveShowId=" + str + ", user=" + ((Object) user) + ", streamId=" + this.streamId + ")";
    }
}
