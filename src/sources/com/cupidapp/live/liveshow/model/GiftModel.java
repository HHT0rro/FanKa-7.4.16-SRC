package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveGiftModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class GiftModel extends GiftItemModel {

    @Nullable
    private final ImageModel actionGiftCard;

    @Nullable
    private final String actionGiftCardUrl;

    @Nullable
    private final Boolean canUseGiftDiscount;

    @Nullable
    private final Integer discountPrice;
    private int freeChance;

    @Nullable
    private Integer level;

    @Nullable
    private ImageModel levelIcon;

    @Nullable
    private final ImageModel namingAvatar;

    @Nullable
    private final ImageModel spokesmanUserIcon;

    @Nullable
    private Boolean unlocked;

    @Nullable
    private List<UpgradeGiftModel> upgradeGiftList;

    public /* synthetic */ GiftModel(int i10, ImageModel imageModel, String str, Integer num, Boolean bool, ImageModel imageModel2, ImageModel imageModel3, List list, Boolean bool2, Integer num2, ImageModel imageModel4, String str2, String str3, int i11, ImageModel imageModel5, String str4, String str5, String str6, ImageModel imageModel6, boolean z10, boolean z11, boolean z12, ImageModel imageModel7, String str7, Integer num3, ImageModel imageModel8, Integer num4, String str8, Long l10, ImageModel imageModel9, String str9, boolean z13, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 0 : i10, imageModel, str, num, bool, imageModel2, imageModel3, list, bool2, num2, imageModel4, str2, str3, i11, imageModel5, str4, str5, str6, imageModel6, z10, z11, z12, imageModel7, str7, num3, imageModel8, num4, str8, l10, imageModel9, str9, z13);
    }

    @Nullable
    public final ImageModel getActionGiftCard() {
        return this.actionGiftCard;
    }

    @Nullable
    public final String getActionGiftCardUrl() {
        return this.actionGiftCardUrl;
    }

    @Nullable
    public final Boolean getCanUseGiftDiscount() {
        return this.canUseGiftDiscount;
    }

    @Nullable
    public final Integer getDiscountPrice() {
        return this.discountPrice;
    }

    public final int getFreeChance() {
        return this.freeChance;
    }

    @Nullable
    public final Integer getLevel() {
        return this.level;
    }

    @Nullable
    public final ImageModel getLevelIcon() {
        return this.levelIcon;
    }

    @Nullable
    public final ImageModel getNamingAvatar() {
        return this.namingAvatar;
    }

    public final boolean getShowDiscountTag() {
        return s.d(this.canUseGiftDiscount, Boolean.TRUE) && getNewArrivalTag() == null;
    }

    @Nullable
    public final ImageModel getSpokesmanUserIcon() {
        return this.spokesmanUserIcon;
    }

    @Nullable
    public final Boolean getUnlocked() {
        return this.unlocked;
    }

    @Nullable
    public final List<UpgradeGiftModel> getUpgradeGiftList() {
        return this.upgradeGiftList;
    }

    public final void setFreeChance(int i10) {
        this.freeChance = i10;
    }

    public final void setLevel(@Nullable Integer num) {
        this.level = num;
    }

    public final void setLevelIcon(@Nullable ImageModel imageModel) {
        this.levelIcon = imageModel;
    }

    public final void setUnlocked(@Nullable Boolean bool) {
        this.unlocked = bool;
    }

    public final void setUpgradeGiftList(@Nullable List<UpgradeGiftModel> list) {
        this.upgradeGiftList = list;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GiftModel(int i10, @Nullable ImageModel imageModel, @Nullable String str, @Nullable Integer num, @Nullable Boolean bool, @Nullable ImageModel imageModel2, @Nullable ImageModel imageModel3, @Nullable List<UpgradeGiftModel> list, @Nullable Boolean bool2, @Nullable Integer num2, @Nullable ImageModel imageModel4, @NotNull String itemId, @NotNull String name, int i11, @NotNull ImageModel image, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable ImageModel imageModel5, boolean z10, boolean z11, boolean z12, @Nullable ImageModel imageModel6, @NotNull String fenceId, @Nullable Integer num3, @Nullable ImageModel imageModel7, @Nullable Integer num4, @Nullable String str5, @Nullable Long l10, @Nullable ImageModel imageModel8, @NotNull String rushType, boolean z13) {
        super(itemId, name, i11, image, str2, str3, str4, imageModel5, z10, z11, z12, imageModel6, fenceId, num3, imageModel7, num4, str5, l10, imageModel8, rushType, z13);
        s.i(itemId, "itemId");
        s.i(name, "name");
        s.i(image, "image");
        s.i(fenceId, "fenceId");
        s.i(rushType, "rushType");
        this.freeChance = i10;
        this.actionGiftCard = imageModel;
        this.actionGiftCardUrl = str;
        this.discountPrice = num;
        this.canUseGiftDiscount = bool;
        this.namingAvatar = imageModel2;
        this.spokesmanUserIcon = imageModel3;
        this.upgradeGiftList = list;
        this.unlocked = bool2;
        this.level = num2;
        this.levelIcon = imageModel4;
    }
}
