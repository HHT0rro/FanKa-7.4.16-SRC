package com.cupidapp.live.profile.holder;

import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.profile.model.UserVipDetailModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedLikedUserViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FeedLikedUserUiModel {

    @Nullable
    private ImageModel avatarImage;

    @Nullable
    private final String name;

    @NotNull
    private final User user;

    @NotNull
    private UserVipDetailModel vipModel;

    public FeedLikedUserUiModel(@NotNull User user, @Nullable ImageModel imageModel, @Nullable String str, @NotNull UserVipDetailModel vipModel) {
        s.i(user, "user");
        s.i(vipModel, "vipModel");
        this.user = user;
        this.avatarImage = imageModel;
        this.name = str;
        this.vipModel = vipModel;
    }

    @Nullable
    public final ImageModel getAvatarImage() {
        return this.avatarImage;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }

    @NotNull
    public final UserVipDetailModel getVipModel() {
        return this.vipModel;
    }

    public final void setAvatarImage(@Nullable ImageModel imageModel) {
        this.avatarImage = imageModel;
    }

    public final void setVipModel(@NotNull UserVipDetailModel userVipDetailModel) {
        s.i(userVipDetailModel, "<set-?>");
        this.vipModel = userVipDetailModel;
    }
}
