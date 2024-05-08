package com.cupidapp.live.liveshow.adapter;

import com.cupidapp.live.base.network.gson.BaseLiveShowTagModel;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.liveshow.model.GiftItemModel;
import com.cupidapp.live.profile.model.User;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveCommentAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveGiftMessageViewModel implements FKLiveMessageViewModel {

    @Nullable
    private final String backgroundColor;

    @Nullable
    private final String borderColor;
    private final int count;

    @Nullable
    private final String desc;

    @NotNull
    private final GiftItemModel giftModel;

    @Nullable
    private final String gradientDirection;

    @Nullable
    private final List<BaseLiveShowTagModel> labelList;

    @Nullable
    private final ImageModel leftBottomImage;

    @Nullable
    private final ImageModel leftTopImage;

    @Nullable
    private final GiftItemModel originalGift;

    @Nullable
    private final ImageModel rightBottomImage;

    @Nullable
    private final ImageModel rightTopImage;

    @Nullable
    private User sender;

    /* JADX WARN: Multi-variable type inference failed */
    public FKLiveGiftMessageViewModel(@Nullable User user, @Nullable List<? extends BaseLiveShowTagModel> list, @Nullable GiftItemModel giftItemModel, @NotNull GiftItemModel giftModel, @Nullable String str, int i10, @Nullable String str2, @Nullable String str3, @Nullable ImageModel imageModel, @Nullable ImageModel imageModel2, @Nullable ImageModel imageModel3, @Nullable ImageModel imageModel4, @Nullable String str4) {
        s.i(giftModel, "giftModel");
        this.sender = user;
        this.labelList = list;
        this.originalGift = giftItemModel;
        this.giftModel = giftModel;
        this.desc = str;
        this.count = i10;
        this.backgroundColor = str2;
        this.borderColor = str3;
        this.leftTopImage = imageModel;
        this.rightTopImage = imageModel2;
        this.leftBottomImage = imageModel3;
        this.rightBottomImage = imageModel4;
        this.gradientDirection = str4;
    }

    @Nullable
    public final User component1() {
        return this.sender;
    }

    @Nullable
    public final ImageModel component10() {
        return this.rightTopImage;
    }

    @Nullable
    public final ImageModel component11() {
        return this.leftBottomImage;
    }

    @Nullable
    public final ImageModel component12() {
        return this.rightBottomImage;
    }

    @Nullable
    public final String component13() {
        return this.gradientDirection;
    }

    @Nullable
    public final List<BaseLiveShowTagModel> component2() {
        return this.labelList;
    }

    @Nullable
    public final GiftItemModel component3() {
        return this.originalGift;
    }

    @NotNull
    public final GiftItemModel component4() {
        return this.giftModel;
    }

    @Nullable
    public final String component5() {
        return this.desc;
    }

    public final int component6() {
        return this.count;
    }

    @Nullable
    public final String component7() {
        return this.backgroundColor;
    }

    @Nullable
    public final String component8() {
        return this.borderColor;
    }

    @Nullable
    public final ImageModel component9() {
        return this.leftTopImage;
    }

    @NotNull
    public final FKLiveGiftMessageViewModel copy(@Nullable User user, @Nullable List<? extends BaseLiveShowTagModel> list, @Nullable GiftItemModel giftItemModel, @NotNull GiftItemModel giftModel, @Nullable String str, int i10, @Nullable String str2, @Nullable String str3, @Nullable ImageModel imageModel, @Nullable ImageModel imageModel2, @Nullable ImageModel imageModel3, @Nullable ImageModel imageModel4, @Nullable String str4) {
        s.i(giftModel, "giftModel");
        return new FKLiveGiftMessageViewModel(user, list, giftItemModel, giftModel, str, i10, str2, str3, imageModel, imageModel2, imageModel3, imageModel4, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKLiveGiftMessageViewModel)) {
            return false;
        }
        FKLiveGiftMessageViewModel fKLiveGiftMessageViewModel = (FKLiveGiftMessageViewModel) obj;
        return s.d(this.sender, fKLiveGiftMessageViewModel.sender) && s.d(this.labelList, fKLiveGiftMessageViewModel.labelList) && s.d(this.originalGift, fKLiveGiftMessageViewModel.originalGift) && s.d(this.giftModel, fKLiveGiftMessageViewModel.giftModel) && s.d(this.desc, fKLiveGiftMessageViewModel.desc) && this.count == fKLiveGiftMessageViewModel.count && s.d(this.backgroundColor, fKLiveGiftMessageViewModel.backgroundColor) && s.d(this.borderColor, fKLiveGiftMessageViewModel.borderColor) && s.d(this.leftTopImage, fKLiveGiftMessageViewModel.leftTopImage) && s.d(this.rightTopImage, fKLiveGiftMessageViewModel.rightTopImage) && s.d(this.leftBottomImage, fKLiveGiftMessageViewModel.leftBottomImage) && s.d(this.rightBottomImage, fKLiveGiftMessageViewModel.rightBottomImage) && s.d(this.gradientDirection, fKLiveGiftMessageViewModel.gradientDirection);
    }

    @Nullable
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    @Nullable
    public final String getBorderColor() {
        return this.borderColor;
    }

    public final int getCount() {
        return this.count;
    }

    @Nullable
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    public final GiftItemModel getGiftModel() {
        return this.giftModel;
    }

    @Nullable
    public final String getGradientDirection() {
        return this.gradientDirection;
    }

    @Nullable
    public final List<BaseLiveShowTagModel> getLabelList() {
        return this.labelList;
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

    @Nullable
    public final User getSender() {
        return this.sender;
    }

    public int hashCode() {
        User user = this.sender;
        int hashCode = (user == null ? 0 : user.hashCode()) * 31;
        List<BaseLiveShowTagModel> list = this.labelList;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        GiftItemModel giftItemModel = this.originalGift;
        int hashCode3 = (((hashCode2 + (giftItemModel == null ? 0 : giftItemModel.hashCode())) * 31) + this.giftModel.hashCode()) * 31;
        String str = this.desc;
        int hashCode4 = (((hashCode3 + (str == null ? 0 : str.hashCode())) * 31) + this.count) * 31;
        String str2 = this.backgroundColor;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.borderColor;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        ImageModel imageModel = this.leftTopImage;
        int hashCode7 = (hashCode6 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        ImageModel imageModel2 = this.rightTopImage;
        int hashCode8 = (hashCode7 + (imageModel2 == null ? 0 : imageModel2.hashCode())) * 31;
        ImageModel imageModel3 = this.leftBottomImage;
        int hashCode9 = (hashCode8 + (imageModel3 == null ? 0 : imageModel3.hashCode())) * 31;
        ImageModel imageModel4 = this.rightBottomImage;
        int hashCode10 = (hashCode9 + (imageModel4 == null ? 0 : imageModel4.hashCode())) * 31;
        String str4 = this.gradientDirection;
        return hashCode10 + (str4 != null ? str4.hashCode() : 0);
    }

    public final void setSender(@Nullable User user) {
        this.sender = user;
    }

    @NotNull
    public String toString() {
        User user = this.sender;
        List<BaseLiveShowTagModel> list = this.labelList;
        GiftItemModel giftItemModel = this.originalGift;
        GiftItemModel giftItemModel2 = this.giftModel;
        String str = this.desc;
        int i10 = this.count;
        String str2 = this.backgroundColor;
        String str3 = this.borderColor;
        ImageModel imageModel = this.leftTopImage;
        ImageModel imageModel2 = this.rightTopImage;
        ImageModel imageModel3 = this.leftBottomImage;
        ImageModel imageModel4 = this.rightBottomImage;
        return "FKLiveGiftMessageViewModel(sender=" + ((Object) user) + ", labelList=" + ((Object) list) + ", originalGift=" + ((Object) giftItemModel) + ", giftModel=" + ((Object) giftItemModel2) + ", desc=" + str + ", count=" + i10 + ", backgroundColor=" + str2 + ", borderColor=" + str3 + ", leftTopImage=" + ((Object) imageModel) + ", rightTopImage=" + ((Object) imageModel2) + ", leftBottomImage=" + ((Object) imageModel3) + ", rightBottomImage=" + ((Object) imageModel4) + ", gradientDirection=" + this.gradientDirection + ")";
    }

    public /* synthetic */ FKLiveGiftMessageViewModel(User user, List list, GiftItemModel giftItemModel, GiftItemModel giftItemModel2, String str, int i10, String str2, String str3, ImageModel imageModel, ImageModel imageModel2, ImageModel imageModel3, ImageModel imageModel4, String str4, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(user, list, giftItemModel, giftItemModel2, (i11 & 16) != 0 ? "" : str, (i11 & 32) != 0 ? 1 : i10, str2, str3, imageModel, imageModel2, imageModel3, imageModel4, (i11 & 4096) != 0 ? null : str4);
    }
}
