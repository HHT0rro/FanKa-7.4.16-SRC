package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.profile.model.User;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveMiniProfileResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class UserProfileInfoResult implements Serializable {

    @Nullable
    private final List<ActionModel> actionList;

    @Nullable
    private final String avatarBackgroundAnimation;

    @Nullable
    private final ImageModel avatarBackgroundImage;

    @Nullable
    private final String backgroundAnimation;

    @Nullable
    private final ImageModel backgroundImage;

    @Nullable
    private final List<MiniProfileUserTagModel> firstTagList;

    @Nullable
    private final GiftWallModel giftWall;

    @Nullable
    private final List<CardInfoModel> liveCardList;

    @NotNull
    private final List<MiniProfilePopularFeedModel> popularFeedList;

    @NotNull
    private final List<Map<String, String>> reportType;

    @Nullable
    private final List<MiniProfileUserTagModel> secondTagList;
    private final boolean showKickOut;
    private final boolean showLiveBan;
    private final boolean showSetAdmin;

    @Nullable
    private final User user;

    /* JADX WARN: Multi-variable type inference failed */
    public UserProfileInfoResult(@Nullable List<ActionModel> list, @NotNull List<? extends Map<String, String>> reportType, @Nullable List<MiniProfileUserTagModel> list2, @Nullable List<MiniProfileUserTagModel> list3, @NotNull List<MiniProfilePopularFeedModel> popularFeedList, @Nullable List<CardInfoModel> list4, @Nullable GiftWallModel giftWallModel, @Nullable ImageModel imageModel, @Nullable ImageModel imageModel2, @Nullable String str, @Nullable String str2, @Nullable User user, boolean z10, boolean z11, boolean z12) {
        s.i(reportType, "reportType");
        s.i(popularFeedList, "popularFeedList");
        this.actionList = list;
        this.reportType = reportType;
        this.firstTagList = list2;
        this.secondTagList = list3;
        this.popularFeedList = popularFeedList;
        this.liveCardList = list4;
        this.giftWall = giftWallModel;
        this.avatarBackgroundImage = imageModel;
        this.backgroundImage = imageModel2;
        this.avatarBackgroundAnimation = str;
        this.backgroundAnimation = str2;
        this.user = user;
        this.showLiveBan = z10;
        this.showSetAdmin = z11;
        this.showKickOut = z12;
    }

    @Nullable
    public final List<ActionModel> component1() {
        return this.actionList;
    }

    @Nullable
    public final String component10() {
        return this.avatarBackgroundAnimation;
    }

    @Nullable
    public final String component11() {
        return this.backgroundAnimation;
    }

    @Nullable
    public final User component12() {
        return this.user;
    }

    public final boolean component13() {
        return this.showLiveBan;
    }

    public final boolean component14() {
        return this.showSetAdmin;
    }

    public final boolean component15() {
        return this.showKickOut;
    }

    @NotNull
    public final List<Map<String, String>> component2() {
        return this.reportType;
    }

    @Nullable
    public final List<MiniProfileUserTagModel> component3() {
        return this.firstTagList;
    }

    @Nullable
    public final List<MiniProfileUserTagModel> component4() {
        return this.secondTagList;
    }

    @NotNull
    public final List<MiniProfilePopularFeedModel> component5() {
        return this.popularFeedList;
    }

    @Nullable
    public final List<CardInfoModel> component6() {
        return this.liveCardList;
    }

    @Nullable
    public final GiftWallModel component7() {
        return this.giftWall;
    }

    @Nullable
    public final ImageModel component8() {
        return this.avatarBackgroundImage;
    }

    @Nullable
    public final ImageModel component9() {
        return this.backgroundImage;
    }

    @NotNull
    public final UserProfileInfoResult copy(@Nullable List<ActionModel> list, @NotNull List<? extends Map<String, String>> reportType, @Nullable List<MiniProfileUserTagModel> list2, @Nullable List<MiniProfileUserTagModel> list3, @NotNull List<MiniProfilePopularFeedModel> popularFeedList, @Nullable List<CardInfoModel> list4, @Nullable GiftWallModel giftWallModel, @Nullable ImageModel imageModel, @Nullable ImageModel imageModel2, @Nullable String str, @Nullable String str2, @Nullable User user, boolean z10, boolean z11, boolean z12) {
        s.i(reportType, "reportType");
        s.i(popularFeedList, "popularFeedList");
        return new UserProfileInfoResult(list, reportType, list2, list3, popularFeedList, list4, giftWallModel, imageModel, imageModel2, str, str2, user, z10, z11, z12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserProfileInfoResult)) {
            return false;
        }
        UserProfileInfoResult userProfileInfoResult = (UserProfileInfoResult) obj;
        return s.d(this.actionList, userProfileInfoResult.actionList) && s.d(this.reportType, userProfileInfoResult.reportType) && s.d(this.firstTagList, userProfileInfoResult.firstTagList) && s.d(this.secondTagList, userProfileInfoResult.secondTagList) && s.d(this.popularFeedList, userProfileInfoResult.popularFeedList) && s.d(this.liveCardList, userProfileInfoResult.liveCardList) && s.d(this.giftWall, userProfileInfoResult.giftWall) && s.d(this.avatarBackgroundImage, userProfileInfoResult.avatarBackgroundImage) && s.d(this.backgroundImage, userProfileInfoResult.backgroundImage) && s.d(this.avatarBackgroundAnimation, userProfileInfoResult.avatarBackgroundAnimation) && s.d(this.backgroundAnimation, userProfileInfoResult.backgroundAnimation) && s.d(this.user, userProfileInfoResult.user) && this.showLiveBan == userProfileInfoResult.showLiveBan && this.showSetAdmin == userProfileInfoResult.showSetAdmin && this.showKickOut == userProfileInfoResult.showKickOut;
    }

    @Nullable
    public final List<ActionModel> getActionList() {
        return this.actionList;
    }

    @Nullable
    public final String getAvatarBackgroundAnimation() {
        return this.avatarBackgroundAnimation;
    }

    @Nullable
    public final ImageModel getAvatarBackgroundImage() {
        return this.avatarBackgroundImage;
    }

    @Nullable
    public final String getBackgroundAnimation() {
        return this.backgroundAnimation;
    }

    @Nullable
    public final ImageModel getBackgroundImage() {
        return this.backgroundImage;
    }

    @Nullable
    public final List<MiniProfileUserTagModel> getFirstTagList() {
        return this.firstTagList;
    }

    @Nullable
    public final GiftWallModel getGiftWall() {
        return this.giftWall;
    }

    @Nullable
    public final List<CardInfoModel> getLiveCardList() {
        return this.liveCardList;
    }

    @NotNull
    public final List<MiniProfilePopularFeedModel> getPopularFeedList() {
        return this.popularFeedList;
    }

    @NotNull
    public final List<Map<String, String>> getReportType() {
        return this.reportType;
    }

    @Nullable
    public final List<MiniProfileUserTagModel> getSecondTagList() {
        return this.secondTagList;
    }

    public final boolean getShowKickOut() {
        return this.showKickOut;
    }

    public final boolean getShowLiveBan() {
        return this.showLiveBan;
    }

    public final boolean getShowSetAdmin() {
        return this.showSetAdmin;
    }

    @Nullable
    public final User getUser() {
        return this.user;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        List<ActionModel> list = this.actionList;
        int hashCode = (((list == null ? 0 : list.hashCode()) * 31) + this.reportType.hashCode()) * 31;
        List<MiniProfileUserTagModel> list2 = this.firstTagList;
        int hashCode2 = (hashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<MiniProfileUserTagModel> list3 = this.secondTagList;
        int hashCode3 = (((hashCode2 + (list3 == null ? 0 : list3.hashCode())) * 31) + this.popularFeedList.hashCode()) * 31;
        List<CardInfoModel> list4 = this.liveCardList;
        int hashCode4 = (hashCode3 + (list4 == null ? 0 : list4.hashCode())) * 31;
        GiftWallModel giftWallModel = this.giftWall;
        int hashCode5 = (hashCode4 + (giftWallModel == null ? 0 : giftWallModel.hashCode())) * 31;
        ImageModel imageModel = this.avatarBackgroundImage;
        int hashCode6 = (hashCode5 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        ImageModel imageModel2 = this.backgroundImage;
        int hashCode7 = (hashCode6 + (imageModel2 == null ? 0 : imageModel2.hashCode())) * 31;
        String str = this.avatarBackgroundAnimation;
        int hashCode8 = (hashCode7 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.backgroundAnimation;
        int hashCode9 = (hashCode8 + (str2 == null ? 0 : str2.hashCode())) * 31;
        User user = this.user;
        int hashCode10 = (hashCode9 + (user != null ? user.hashCode() : 0)) * 31;
        boolean z10 = this.showLiveBan;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode10 + i10) * 31;
        boolean z11 = this.showSetAdmin;
        int i12 = z11;
        if (z11 != 0) {
            i12 = 1;
        }
        int i13 = (i11 + i12) * 31;
        boolean z12 = this.showKickOut;
        return i13 + (z12 ? 1 : z12 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        List<ActionModel> list = this.actionList;
        List<Map<String, String>> list2 = this.reportType;
        List<MiniProfileUserTagModel> list3 = this.firstTagList;
        List<MiniProfileUserTagModel> list4 = this.secondTagList;
        List<MiniProfilePopularFeedModel> list5 = this.popularFeedList;
        List<CardInfoModel> list6 = this.liveCardList;
        GiftWallModel giftWallModel = this.giftWall;
        ImageModel imageModel = this.avatarBackgroundImage;
        ImageModel imageModel2 = this.backgroundImage;
        String str = this.avatarBackgroundAnimation;
        String str2 = this.backgroundAnimation;
        User user = this.user;
        return "UserProfileInfoResult(actionList=" + ((Object) list) + ", reportType=" + ((Object) list2) + ", firstTagList=" + ((Object) list3) + ", secondTagList=" + ((Object) list4) + ", popularFeedList=" + ((Object) list5) + ", liveCardList=" + ((Object) list6) + ", giftWall=" + ((Object) giftWallModel) + ", avatarBackgroundImage=" + ((Object) imageModel) + ", backgroundImage=" + ((Object) imageModel2) + ", avatarBackgroundAnimation=" + str + ", backgroundAnimation=" + str2 + ", user=" + ((Object) user) + ", showLiveBan=" + this.showLiveBan + ", showSetAdmin=" + this.showSetAdmin + ", showKickOut=" + this.showKickOut + ")";
    }
}
