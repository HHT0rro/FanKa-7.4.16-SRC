package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.profile.model.User;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AnchorModel {

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

    @Nullable
    private final List<MiniProfilePopularFeedModel> popularFeedList;

    @Nullable
    private final List<MiniProfileUserTagModel> secondTagList;

    @Nullable
    private final User user;

    public AnchorModel(@Nullable User user, @Nullable ImageModel imageModel, @Nullable ImageModel imageModel2, @Nullable String str, @Nullable String str2, @Nullable List<MiniProfilePopularFeedModel> list, @Nullable List<MiniProfileUserTagModel> list2, @Nullable List<MiniProfileUserTagModel> list3, @Nullable List<CardInfoModel> list4, @Nullable GiftWallModel giftWallModel) {
        this.user = user;
        this.avatarBackgroundImage = imageModel;
        this.backgroundImage = imageModel2;
        this.avatarBackgroundAnimation = str;
        this.backgroundAnimation = str2;
        this.popularFeedList = list;
        this.firstTagList = list2;
        this.secondTagList = list3;
        this.liveCardList = list4;
        this.giftWall = giftWallModel;
    }

    @Nullable
    public final User component1() {
        return this.user;
    }

    @Nullable
    public final GiftWallModel component10() {
        return this.giftWall;
    }

    @Nullable
    public final ImageModel component2() {
        return this.avatarBackgroundImage;
    }

    @Nullable
    public final ImageModel component3() {
        return this.backgroundImage;
    }

    @Nullable
    public final String component4() {
        return this.avatarBackgroundAnimation;
    }

    @Nullable
    public final String component5() {
        return this.backgroundAnimation;
    }

    @Nullable
    public final List<MiniProfilePopularFeedModel> component6() {
        return this.popularFeedList;
    }

    @Nullable
    public final List<MiniProfileUserTagModel> component7() {
        return this.firstTagList;
    }

    @Nullable
    public final List<MiniProfileUserTagModel> component8() {
        return this.secondTagList;
    }

    @Nullable
    public final List<CardInfoModel> component9() {
        return this.liveCardList;
    }

    @NotNull
    public final AnchorModel copy(@Nullable User user, @Nullable ImageModel imageModel, @Nullable ImageModel imageModel2, @Nullable String str, @Nullable String str2, @Nullable List<MiniProfilePopularFeedModel> list, @Nullable List<MiniProfileUserTagModel> list2, @Nullable List<MiniProfileUserTagModel> list3, @Nullable List<CardInfoModel> list4, @Nullable GiftWallModel giftWallModel) {
        return new AnchorModel(user, imageModel, imageModel2, str, str2, list, list2, list3, list4, giftWallModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AnchorModel)) {
            return false;
        }
        AnchorModel anchorModel = (AnchorModel) obj;
        return s.d(this.user, anchorModel.user) && s.d(this.avatarBackgroundImage, anchorModel.avatarBackgroundImage) && s.d(this.backgroundImage, anchorModel.backgroundImage) && s.d(this.avatarBackgroundAnimation, anchorModel.avatarBackgroundAnimation) && s.d(this.backgroundAnimation, anchorModel.backgroundAnimation) && s.d(this.popularFeedList, anchorModel.popularFeedList) && s.d(this.firstTagList, anchorModel.firstTagList) && s.d(this.secondTagList, anchorModel.secondTagList) && s.d(this.liveCardList, anchorModel.liveCardList) && s.d(this.giftWall, anchorModel.giftWall);
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

    @Nullable
    public final List<MiniProfilePopularFeedModel> getPopularFeedList() {
        return this.popularFeedList;
    }

    @Nullable
    public final List<MiniProfileUserTagModel> getSecondTagList() {
        return this.secondTagList;
    }

    @Nullable
    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        User user = this.user;
        int hashCode = (user == null ? 0 : user.hashCode()) * 31;
        ImageModel imageModel = this.avatarBackgroundImage;
        int hashCode2 = (hashCode + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        ImageModel imageModel2 = this.backgroundImage;
        int hashCode3 = (hashCode2 + (imageModel2 == null ? 0 : imageModel2.hashCode())) * 31;
        String str = this.avatarBackgroundAnimation;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.backgroundAnimation;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<MiniProfilePopularFeedModel> list = this.popularFeedList;
        int hashCode6 = (hashCode5 + (list == null ? 0 : list.hashCode())) * 31;
        List<MiniProfileUserTagModel> list2 = this.firstTagList;
        int hashCode7 = (hashCode6 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<MiniProfileUserTagModel> list3 = this.secondTagList;
        int hashCode8 = (hashCode7 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<CardInfoModel> list4 = this.liveCardList;
        int hashCode9 = (hashCode8 + (list4 == null ? 0 : list4.hashCode())) * 31;
        GiftWallModel giftWallModel = this.giftWall;
        return hashCode9 + (giftWallModel != null ? giftWallModel.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        User user = this.user;
        ImageModel imageModel = this.avatarBackgroundImage;
        ImageModel imageModel2 = this.backgroundImage;
        return "AnchorModel(user=" + ((Object) user) + ", avatarBackgroundImage=" + ((Object) imageModel) + ", backgroundImage=" + ((Object) imageModel2) + ", avatarBackgroundAnimation=" + this.avatarBackgroundAnimation + ", backgroundAnimation=" + this.backgroundAnimation + ", popularFeedList=" + ((Object) this.popularFeedList) + ", firstTagList=" + ((Object) this.firstTagList) + ", secondTagList=" + ((Object) this.secondTagList) + ", liveCardList=" + ((Object) this.liveCardList) + ", giftWall=" + ((Object) this.giftWall) + ")";
    }
}
