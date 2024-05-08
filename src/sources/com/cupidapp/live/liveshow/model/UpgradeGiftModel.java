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
public final class UpgradeGiftModel implements Serializable {

    @NotNull
    private final ImageModel image;

    @NotNull
    private final String itemId;

    @Nullable
    private final Integer level;

    @Nullable
    private final ImageModel levelIcon;

    @NotNull
    private final String name;
    private final int price;

    @Nullable
    private final Boolean unlocked;

    public UpgradeGiftModel(@NotNull String itemId, @NotNull String name, int i10, @NotNull ImageModel image, @Nullable Boolean bool, @Nullable Integer num, @Nullable ImageModel imageModel) {
        s.i(itemId, "itemId");
        s.i(name, "name");
        s.i(image, "image");
        this.itemId = itemId;
        this.name = name;
        this.price = i10;
        this.image = image;
        this.unlocked = bool;
        this.level = num;
        this.levelIcon = imageModel;
    }

    public static /* synthetic */ UpgradeGiftModel copy$default(UpgradeGiftModel upgradeGiftModel, String str, String str2, int i10, ImageModel imageModel, Boolean bool, Integer num, ImageModel imageModel2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = upgradeGiftModel.itemId;
        }
        if ((i11 & 2) != 0) {
            str2 = upgradeGiftModel.name;
        }
        String str3 = str2;
        if ((i11 & 4) != 0) {
            i10 = upgradeGiftModel.price;
        }
        int i12 = i10;
        if ((i11 & 8) != 0) {
            imageModel = upgradeGiftModel.image;
        }
        ImageModel imageModel3 = imageModel;
        if ((i11 & 16) != 0) {
            bool = upgradeGiftModel.unlocked;
        }
        Boolean bool2 = bool;
        if ((i11 & 32) != 0) {
            num = upgradeGiftModel.level;
        }
        Integer num2 = num;
        if ((i11 & 64) != 0) {
            imageModel2 = upgradeGiftModel.levelIcon;
        }
        return upgradeGiftModel.copy(str, str3, i12, imageModel3, bool2, num2, imageModel2);
    }

    @NotNull
    public final String component1() {
        return this.itemId;
    }

    @NotNull
    public final String component2() {
        return this.name;
    }

    public final int component3() {
        return this.price;
    }

    @NotNull
    public final ImageModel component4() {
        return this.image;
    }

    @Nullable
    public final Boolean component5() {
        return this.unlocked;
    }

    @Nullable
    public final Integer component6() {
        return this.level;
    }

    @Nullable
    public final ImageModel component7() {
        return this.levelIcon;
    }

    @NotNull
    public final UpgradeGiftModel copy(@NotNull String itemId, @NotNull String name, int i10, @NotNull ImageModel image, @Nullable Boolean bool, @Nullable Integer num, @Nullable ImageModel imageModel) {
        s.i(itemId, "itemId");
        s.i(name, "name");
        s.i(image, "image");
        return new UpgradeGiftModel(itemId, name, i10, image, bool, num, imageModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpgradeGiftModel)) {
            return false;
        }
        UpgradeGiftModel upgradeGiftModel = (UpgradeGiftModel) obj;
        return s.d(this.itemId, upgradeGiftModel.itemId) && s.d(this.name, upgradeGiftModel.name) && this.price == upgradeGiftModel.price && s.d(this.image, upgradeGiftModel.image) && s.d(this.unlocked, upgradeGiftModel.unlocked) && s.d(this.level, upgradeGiftModel.level) && s.d(this.levelIcon, upgradeGiftModel.levelIcon);
    }

    @NotNull
    public final ImageModel getImage() {
        return this.image;
    }

    @NotNull
    public final String getItemId() {
        return this.itemId;
    }

    @Nullable
    public final Integer getLevel() {
        return this.level;
    }

    @Nullable
    public final ImageModel getLevelIcon() {
        return this.levelIcon;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final int getPrice() {
        return this.price;
    }

    @Nullable
    public final Boolean getUnlocked() {
        return this.unlocked;
    }

    public int hashCode() {
        int hashCode = ((((((this.itemId.hashCode() * 31) + this.name.hashCode()) * 31) + this.price) * 31) + this.image.hashCode()) * 31;
        Boolean bool = this.unlocked;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num = this.level;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        ImageModel imageModel = this.levelIcon;
        return hashCode3 + (imageModel != null ? imageModel.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "UpgradeGiftModel(itemId=" + this.itemId + ", name=" + this.name + ", price=" + this.price + ", image=" + ((Object) this.image) + ", unlocked=" + ((Object) this.unlocked) + ", level=" + ((Object) this.level) + ", levelIcon=" + ((Object) this.levelIcon) + ")";
    }
}
