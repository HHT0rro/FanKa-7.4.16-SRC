package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveGiftModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class GiftItemModel implements Serializable {

    @Nullable
    private final ImageModel bannerImage;
    private final boolean canSelectRushCount;

    @Nullable
    private final String descBackgroundColor;

    @Nullable
    private final String descText;

    @Nullable
    private final String descUrl;

    @Nullable
    private final Long experience;

    @Nullable
    private final Integer faceAnimationDuration;

    @Nullable
    private final String faceAnimationPath;

    @NotNull
    private final String fenceId;

    @Nullable
    private ImageModel giftTag;

    @NotNull
    private ImageModel image;

    @NotNull
    private String itemId;

    @NotNull
    private String name;

    @Nullable
    private ImageModel newArrivalTag;
    private int price;

    @Nullable
    private final Integer rushAnimationTriggerThreshold;
    private final boolean rushEnable;

    @Nullable
    private final ImageModel rushIcon;

    @NotNull
    private final String rushType;
    private final boolean showInCommentArea;
    private final boolean showInGiftBox;

    public GiftItemModel(@NotNull String itemId, @NotNull String name, int i10, @NotNull ImageModel image, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable ImageModel imageModel, boolean z10, boolean z11, boolean z12, @Nullable ImageModel imageModel2, @NotNull String fenceId, @Nullable Integer num, @Nullable ImageModel imageModel3, @Nullable Integer num2, @Nullable String str4, @Nullable Long l10, @Nullable ImageModel imageModel4, @NotNull String rushType, boolean z13) {
        s.i(itemId, "itemId");
        s.i(name, "name");
        s.i(image, "image");
        s.i(fenceId, "fenceId");
        s.i(rushType, "rushType");
        this.itemId = itemId;
        this.name = name;
        this.price = i10;
        this.image = image;
        this.descText = str;
        this.descUrl = str2;
        this.descBackgroundColor = str3;
        this.bannerImage = imageModel;
        this.rushEnable = z10;
        this.showInCommentArea = z11;
        this.showInGiftBox = z12;
        this.giftTag = imageModel2;
        this.fenceId = fenceId;
        this.rushAnimationTriggerThreshold = num;
        this.rushIcon = imageModel3;
        this.faceAnimationDuration = num2;
        this.faceAnimationPath = str4;
        this.experience = l10;
        this.newArrivalTag = imageModel4;
        this.rushType = rushType;
        this.canSelectRushCount = z13;
    }

    @Nullable
    public final ImageModel getBannerImage() {
        return this.bannerImage;
    }

    public final boolean getCanSelectRushCount() {
        return this.canSelectRushCount;
    }

    @Nullable
    public final String getDescBackgroundColor() {
        return this.descBackgroundColor;
    }

    @Nullable
    public final String getDescText() {
        return this.descText;
    }

    @Nullable
    public final String getDescUrl() {
        return this.descUrl;
    }

    @Nullable
    public final Long getExperience() {
        return this.experience;
    }

    @Nullable
    public final Integer getFaceAnimationDuration() {
        return this.faceAnimationDuration;
    }

    @Nullable
    public final String getFaceAnimationPath() {
        return this.faceAnimationPath;
    }

    @NotNull
    public final String getFenceId() {
        return this.fenceId;
    }

    @Nullable
    public final ImageModel getGiftTag() {
        return this.giftTag;
    }

    @NotNull
    public final ImageModel getImage() {
        return this.image;
    }

    @NotNull
    public final String getItemId() {
        return this.itemId;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final ImageModel getNewArrivalTag() {
        return this.newArrivalTag;
    }

    public final int getPrice() {
        return this.price;
    }

    @Nullable
    public final Integer getRushAnimationTriggerThreshold() {
        return this.rushAnimationTriggerThreshold;
    }

    public final boolean getRushEnable() {
        return this.rushEnable;
    }

    @Nullable
    public final ImageModel getRushIcon() {
        return this.rushIcon;
    }

    @NotNull
    public final String getRushType() {
        return this.rushType;
    }

    public final boolean getShowGiftTag() {
        return this.giftTag != null && this.newArrivalTag == null;
    }

    public final boolean getShowInCommentArea() {
        return this.showInCommentArea;
    }

    public final boolean getShowInGiftBox() {
        return this.showInGiftBox;
    }

    public final void setGiftTag(@Nullable ImageModel imageModel) {
        this.giftTag = imageModel;
    }

    public final void setImage(@NotNull ImageModel imageModel) {
        s.i(imageModel, "<set-?>");
        this.image = imageModel;
    }

    public final void setItemId(@NotNull String str) {
        s.i(str, "<set-?>");
        this.itemId = str;
    }

    public final void setName(@NotNull String str) {
        s.i(str, "<set-?>");
        this.name = str;
    }

    public final void setNewArrivalTag(@Nullable ImageModel imageModel) {
        this.newArrivalTag = imageModel;
    }

    public final void setPrice(int i10) {
        this.price = i10;
    }
}
