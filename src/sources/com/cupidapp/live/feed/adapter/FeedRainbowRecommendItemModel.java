package com.cupidapp.live.feed.adapter;

import com.cupidapp.live.feed.model.UserWithPostLimitStatusModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedRainbowRecommendAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedRainbowRecommendItemModel {
    private boolean openRecommend;

    @NotNull
    private final UserWithPostLimitStatusModel user;

    public FeedRainbowRecommendItemModel(@NotNull UserWithPostLimitStatusModel user, boolean z10) {
        s.i(user, "user");
        this.user = user;
        this.openRecommend = z10;
    }

    public static /* synthetic */ FeedRainbowRecommendItemModel copy$default(FeedRainbowRecommendItemModel feedRainbowRecommendItemModel, UserWithPostLimitStatusModel userWithPostLimitStatusModel, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            userWithPostLimitStatusModel = feedRainbowRecommendItemModel.user;
        }
        if ((i10 & 2) != 0) {
            z10 = feedRainbowRecommendItemModel.openRecommend;
        }
        return feedRainbowRecommendItemModel.copy(userWithPostLimitStatusModel, z10);
    }

    @NotNull
    public final UserWithPostLimitStatusModel component1() {
        return this.user;
    }

    public final boolean component2() {
        return this.openRecommend;
    }

    @NotNull
    public final FeedRainbowRecommendItemModel copy(@NotNull UserWithPostLimitStatusModel user, boolean z10) {
        s.i(user, "user");
        return new FeedRainbowRecommendItemModel(user, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedRainbowRecommendItemModel)) {
            return false;
        }
        FeedRainbowRecommendItemModel feedRainbowRecommendItemModel = (FeedRainbowRecommendItemModel) obj;
        return s.d(this.user, feedRainbowRecommendItemModel.user) && this.openRecommend == feedRainbowRecommendItemModel.openRecommend;
    }

    public final boolean getOpenRecommend() {
        return this.openRecommend;
    }

    @NotNull
    public final UserWithPostLimitStatusModel getUser() {
        return this.user;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.user.hashCode() * 31;
        boolean z10 = this.openRecommend;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    public final void setOpenRecommend(boolean z10) {
        this.openRecommend = z10;
    }

    @NotNull
    public String toString() {
        UserWithPostLimitStatusModel userWithPostLimitStatusModel = this.user;
        return "FeedRainbowRecommendItemModel(user=" + ((Object) userWithPostLimitStatusModel) + ", openRecommend=" + this.openRecommend + ")";
    }
}
