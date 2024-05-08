package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.base.network.gson.BaseLiveShowTagModel;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.profile.model.User;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveGiftModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveShowGiftModel {

    @Nullable
    private final String backgroundColor;

    @Nullable
    private final String bgImageAndroid;

    @Nullable
    private final String borderColor;

    @Nullable
    private final ImageModel bottomIcon;
    private final int count;

    @Nullable
    private String desc;

    @NotNull
    private GiftItemModel gift;

    @Nullable
    private final GiftAnimationModel giftAnimation;

    @Nullable
    private List<? extends BaseLiveShowTagModel> giftTrackLabels;

    @Nullable
    private final String gradientDirection;

    @Nullable
    private final ImageModel leftBottomImage;

    @Nullable
    private final ImageModel leftTopImage;

    @Nullable
    private List<? extends BaseLiveShowTagModel> liveGiftCommentLabels;

    @Nullable
    private final GiftItemModel originalGift;

    @Nullable
    private final ImageModel rightBottomImage;

    @Nullable
    private final ImageModel rightTopImage;
    private int rushCounter;

    @Nullable
    private String rushId;

    @Nullable
    private User sender;

    @Nullable
    private final ImageModel spokesman;

    @Nullable
    private final ImageModel topIcon;

    public LiveShowGiftModel(@Nullable User user, @NotNull GiftItemModel gift, @Nullable GiftAnimationModel giftAnimationModel, @Nullable List<? extends BaseLiveShowTagModel> list, @Nullable List<? extends BaseLiveShowTagModel> list2, @Nullable GiftItemModel giftItemModel, @Nullable String str, int i10, @Nullable String str2, int i11, @Nullable ImageModel imageModel, @Nullable ImageModel imageModel2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable ImageModel imageModel3, @Nullable ImageModel imageModel4, @Nullable ImageModel imageModel5, @Nullable ImageModel imageModel6, @Nullable ImageModel imageModel7, @Nullable String str6) {
        s.i(gift, "gift");
        this.sender = user;
        this.gift = gift;
        this.giftAnimation = giftAnimationModel;
        this.liveGiftCommentLabels = list;
        this.giftTrackLabels = list2;
        this.originalGift = giftItemModel;
        this.rushId = str;
        this.rushCounter = i10;
        this.desc = str2;
        this.count = i11;
        this.topIcon = imageModel;
        this.bottomIcon = imageModel2;
        this.bgImageAndroid = str3;
        this.backgroundColor = str4;
        this.borderColor = str5;
        this.leftTopImage = imageModel3;
        this.rightTopImage = imageModel4;
        this.leftBottomImage = imageModel5;
        this.rightBottomImage = imageModel6;
        this.spokesman = imageModel7;
        this.gradientDirection = str6;
    }

    @Nullable
    public final User component1() {
        return this.sender;
    }

    public final int component10() {
        return this.count;
    }

    @Nullable
    public final ImageModel component11() {
        return this.topIcon;
    }

    @Nullable
    public final ImageModel component12() {
        return this.bottomIcon;
    }

    @Nullable
    public final String component13() {
        return this.bgImageAndroid;
    }

    @Nullable
    public final String component14() {
        return this.backgroundColor;
    }

    @Nullable
    public final String component15() {
        return this.borderColor;
    }

    @Nullable
    public final ImageModel component16() {
        return this.leftTopImage;
    }

    @Nullable
    public final ImageModel component17() {
        return this.rightTopImage;
    }

    @Nullable
    public final ImageModel component18() {
        return this.leftBottomImage;
    }

    @Nullable
    public final ImageModel component19() {
        return this.rightBottomImage;
    }

    @NotNull
    public final GiftItemModel component2() {
        return this.gift;
    }

    @Nullable
    public final ImageModel component20() {
        return this.spokesman;
    }

    @Nullable
    public final String component21() {
        return this.gradientDirection;
    }

    @Nullable
    public final GiftAnimationModel component3() {
        return this.giftAnimation;
    }

    @Nullable
    public final List<BaseLiveShowTagModel> component4() {
        return this.liveGiftCommentLabels;
    }

    @Nullable
    public final List<BaseLiveShowTagModel> component5() {
        return this.giftTrackLabels;
    }

    @Nullable
    public final GiftItemModel component6() {
        return this.originalGift;
    }

    @Nullable
    public final String component7() {
        return this.rushId;
    }

    public final int component8() {
        return this.rushCounter;
    }

    @Nullable
    public final String component9() {
        return this.desc;
    }

    @NotNull
    public final LiveShowGiftModel copy(@Nullable User user, @NotNull GiftItemModel gift, @Nullable GiftAnimationModel giftAnimationModel, @Nullable List<? extends BaseLiveShowTagModel> list, @Nullable List<? extends BaseLiveShowTagModel> list2, @Nullable GiftItemModel giftItemModel, @Nullable String str, int i10, @Nullable String str2, int i11, @Nullable ImageModel imageModel, @Nullable ImageModel imageModel2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable ImageModel imageModel3, @Nullable ImageModel imageModel4, @Nullable ImageModel imageModel5, @Nullable ImageModel imageModel6, @Nullable ImageModel imageModel7, @Nullable String str6) {
        s.i(gift, "gift");
        return new LiveShowGiftModel(user, gift, giftAnimationModel, list, list2, giftItemModel, str, i10, str2, i11, imageModel, imageModel2, str3, str4, str5, imageModel3, imageModel4, imageModel5, imageModel6, imageModel7, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveShowGiftModel)) {
            return false;
        }
        LiveShowGiftModel liveShowGiftModel = (LiveShowGiftModel) obj;
        return s.d(this.sender, liveShowGiftModel.sender) && s.d(this.gift, liveShowGiftModel.gift) && s.d(this.giftAnimation, liveShowGiftModel.giftAnimation) && s.d(this.liveGiftCommentLabels, liveShowGiftModel.liveGiftCommentLabels) && s.d(this.giftTrackLabels, liveShowGiftModel.giftTrackLabels) && s.d(this.originalGift, liveShowGiftModel.originalGift) && s.d(this.rushId, liveShowGiftModel.rushId) && this.rushCounter == liveShowGiftModel.rushCounter && s.d(this.desc, liveShowGiftModel.desc) && this.count == liveShowGiftModel.count && s.d(this.topIcon, liveShowGiftModel.topIcon) && s.d(this.bottomIcon, liveShowGiftModel.bottomIcon) && s.d(this.bgImageAndroid, liveShowGiftModel.bgImageAndroid) && s.d(this.backgroundColor, liveShowGiftModel.backgroundColor) && s.d(this.borderColor, liveShowGiftModel.borderColor) && s.d(this.leftTopImage, liveShowGiftModel.leftTopImage) && s.d(this.rightTopImage, liveShowGiftModel.rightTopImage) && s.d(this.leftBottomImage, liveShowGiftModel.leftBottomImage) && s.d(this.rightBottomImage, liveShowGiftModel.rightBottomImage) && s.d(this.spokesman, liveShowGiftModel.spokesman) && s.d(this.gradientDirection, liveShowGiftModel.gradientDirection);
    }

    @Nullable
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    @Nullable
    public final String getBgImageAndroid() {
        return this.bgImageAndroid;
    }

    @Nullable
    public final String getBorderColor() {
        return this.borderColor;
    }

    @Nullable
    public final ImageModel getBottomIcon() {
        return this.bottomIcon;
    }

    public final int getCount() {
        return this.count;
    }

    @Nullable
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    public final GiftItemModel getGift() {
        return this.gift;
    }

    @Nullable
    public final GiftAnimationModel getGiftAnimation() {
        return this.giftAnimation;
    }

    @Nullable
    public final List<BaseLiveShowTagModel> getGiftTrackLabels() {
        return this.giftTrackLabels;
    }

    @Nullable
    public final String getGradientDirection() {
        return this.gradientDirection;
    }

    @Nullable
    public final ImageModel getLeftBottomImage() {
        return this.leftBottomImage;
    }

    @Nullable
    public final ImageModel getLeftTopImage() {
        return this.leftTopImage;
    }

    @Nullable
    public final List<BaseLiveShowTagModel> getLiveGiftCommentLabels() {
        return this.liveGiftCommentLabels;
    }

    @Nullable
    public final GiftItemModel getOriginalGift() {
        return this.originalGift;
    }

    @Nullable
    public final ImageModel getRightBottomImage() {
        return this.rightBottomImage;
    }

    @Nullable
    public final ImageModel getRightTopImage() {
        return this.rightTopImage;
    }

    public final int getRushCounter() {
        return this.rushCounter;
    }

    @Nullable
    public final String getRushId() {
        return this.rushId;
    }

    @Nullable
    public final User getSender() {
        return this.sender;
    }

    @Nullable
    public final ImageModel getSpokesman() {
        return this.spokesman;
    }

    @Nullable
    public final ImageModel getTopIcon() {
        return this.topIcon;
    }

    public int hashCode() {
        User user = this.sender;
        int hashCode = (((user == null ? 0 : user.hashCode()) * 31) + this.gift.hashCode()) * 31;
        GiftAnimationModel giftAnimationModel = this.giftAnimation;
        int hashCode2 = (hashCode + (giftAnimationModel == null ? 0 : giftAnimationModel.hashCode())) * 31;
        List<? extends BaseLiveShowTagModel> list = this.liveGiftCommentLabels;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        List<? extends BaseLiveShowTagModel> list2 = this.giftTrackLabels;
        int hashCode4 = (hashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31;
        GiftItemModel giftItemModel = this.originalGift;
        int hashCode5 = (hashCode4 + (giftItemModel == null ? 0 : giftItemModel.hashCode())) * 31;
        String str = this.rushId;
        int hashCode6 = (((hashCode5 + (str == null ? 0 : str.hashCode())) * 31) + this.rushCounter) * 31;
        String str2 = this.desc;
        int hashCode7 = (((hashCode6 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.count) * 31;
        ImageModel imageModel = this.topIcon;
        int hashCode8 = (hashCode7 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        ImageModel imageModel2 = this.bottomIcon;
        int hashCode9 = (hashCode8 + (imageModel2 == null ? 0 : imageModel2.hashCode())) * 31;
        String str3 = this.bgImageAndroid;
        int hashCode10 = (hashCode9 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.backgroundColor;
        int hashCode11 = (hashCode10 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.borderColor;
        int hashCode12 = (hashCode11 + (str5 == null ? 0 : str5.hashCode())) * 31;
        ImageModel imageModel3 = this.leftTopImage;
        int hashCode13 = (hashCode12 + (imageModel3 == null ? 0 : imageModel3.hashCode())) * 31;
        ImageModel imageModel4 = this.rightTopImage;
        int hashCode14 = (hashCode13 + (imageModel4 == null ? 0 : imageModel4.hashCode())) * 31;
        ImageModel imageModel5 = this.leftBottomImage;
        int hashCode15 = (hashCode14 + (imageModel5 == null ? 0 : imageModel5.hashCode())) * 31;
        ImageModel imageModel6 = this.rightBottomImage;
        int hashCode16 = (hashCode15 + (imageModel6 == null ? 0 : imageModel6.hashCode())) * 31;
        ImageModel imageModel7 = this.spokesman;
        int hashCode17 = (hashCode16 + (imageModel7 == null ? 0 : imageModel7.hashCode())) * 31;
        String str6 = this.gradientDirection;
        return hashCode17 + (str6 != null ? str6.hashCode() : 0);
    }

    public final void setDesc(@Nullable String str) {
        this.desc = str;
    }

    public final void setGift(@NotNull GiftItemModel giftItemModel) {
        s.i(giftItemModel, "<set-?>");
        this.gift = giftItemModel;
    }

    public final void setGiftTrackLabels(@Nullable List<? extends BaseLiveShowTagModel> list) {
        this.giftTrackLabels = list;
    }

    public final void setLiveGiftCommentLabels(@Nullable List<? extends BaseLiveShowTagModel> list) {
        this.liveGiftCommentLabels = list;
    }

    public final void setRushCounter(int i10) {
        this.rushCounter = i10;
    }

    public final void setRushId(@Nullable String str) {
        this.rushId = str;
    }

    public final void setSender(@Nullable User user) {
        this.sender = user;
    }

    @NotNull
    public String toString() {
        User user = this.sender;
        GiftItemModel giftItemModel = this.gift;
        GiftAnimationModel giftAnimationModel = this.giftAnimation;
        List<? extends BaseLiveShowTagModel> list = this.liveGiftCommentLabels;
        List<? extends BaseLiveShowTagModel> list2 = this.giftTrackLabels;
        GiftItemModel giftItemModel2 = this.originalGift;
        String str = this.rushId;
        int i10 = this.rushCounter;
        String str2 = this.desc;
        int i11 = this.count;
        ImageModel imageModel = this.topIcon;
        ImageModel imageModel2 = this.bottomIcon;
        String str3 = this.bgImageAndroid;
        String str4 = this.backgroundColor;
        String str5 = this.borderColor;
        ImageModel imageModel3 = this.leftTopImage;
        ImageModel imageModel4 = this.rightTopImage;
        ImageModel imageModel5 = this.leftBottomImage;
        ImageModel imageModel6 = this.rightBottomImage;
        ImageModel imageModel7 = this.spokesman;
        return "LiveShowGiftModel(sender=" + ((Object) user) + ", gift=" + ((Object) giftItemModel) + ", giftAnimation=" + ((Object) giftAnimationModel) + ", liveGiftCommentLabels=" + ((Object) list) + ", giftTrackLabels=" + ((Object) list2) + ", originalGift=" + ((Object) giftItemModel2) + ", rushId=" + str + ", rushCounter=" + i10 + ", desc=" + str2 + ", count=" + i11 + ", topIcon=" + ((Object) imageModel) + ", bottomIcon=" + ((Object) imageModel2) + ", bgImageAndroid=" + str3 + ", backgroundColor=" + str4 + ", borderColor=" + str5 + ", leftTopImage=" + ((Object) imageModel3) + ", rightTopImage=" + ((Object) imageModel4) + ", leftBottomImage=" + ((Object) imageModel5) + ", rightBottomImage=" + ((Object) imageModel6) + ", spokesman=" + ((Object) imageModel7) + ", gradientDirection=" + this.gradientDirection + ")";
    }

    public /* synthetic */ LiveShowGiftModel(User user, GiftItemModel giftItemModel, GiftAnimationModel giftAnimationModel, List list, List list2, GiftItemModel giftItemModel2, String str, int i10, String str2, int i11, ImageModel imageModel, ImageModel imageModel2, String str3, String str4, String str5, ImageModel imageModel3, ImageModel imageModel4, ImageModel imageModel5, ImageModel imageModel6, ImageModel imageModel7, String str6, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(user, giftItemModel, giftAnimationModel, list, list2, giftItemModel2, str, i10, (i12 & 256) != 0 ? "" : str2, i11, imageModel, imageModel2, str3, (i12 & 8192) != 0 ? null : str4, (i12 & 16384) != 0 ? null : str5, (32768 & i12) != 0 ? null : imageModel3, (65536 & i12) != 0 ? null : imageModel4, (131072 & i12) != 0 ? null : imageModel5, (262144 & i12) != 0 ? null : imageModel6, (524288 & i12) != 0 ? null : imageModel7, (i12 & 1048576) != 0 ? null : str6);
    }
}
