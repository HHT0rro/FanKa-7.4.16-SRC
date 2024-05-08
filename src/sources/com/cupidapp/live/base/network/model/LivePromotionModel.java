package com.cupidapp.live.base.network.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConstantsResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LivePromotionModel {

    @NotNull
    private final String configId;

    @NotNull
    private final ImageModel iconImage;

    @Nullable
    private final String jumpUrl;

    public LivePromotionModel(@NotNull ImageModel iconImage, @Nullable String str, @NotNull String configId) {
        s.i(iconImage, "iconImage");
        s.i(configId, "configId");
        this.iconImage = iconImage;
        this.jumpUrl = str;
        this.configId = configId;
    }

    public static /* synthetic */ LivePromotionModel copy$default(LivePromotionModel livePromotionModel, ImageModel imageModel, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            imageModel = livePromotionModel.iconImage;
        }
        if ((i10 & 2) != 0) {
            str = livePromotionModel.jumpUrl;
        }
        if ((i10 & 4) != 0) {
            str2 = livePromotionModel.configId;
        }
        return livePromotionModel.copy(imageModel, str, str2);
    }

    @NotNull
    public final ImageModel component1() {
        return this.iconImage;
    }

    @Nullable
    public final String component2() {
        return this.jumpUrl;
    }

    @NotNull
    public final String component3() {
        return this.configId;
    }

    @NotNull
    public final LivePromotionModel copy(@NotNull ImageModel iconImage, @Nullable String str, @NotNull String configId) {
        s.i(iconImage, "iconImage");
        s.i(configId, "configId");
        return new LivePromotionModel(iconImage, str, configId);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LivePromotionModel)) {
            return false;
        }
        LivePromotionModel livePromotionModel = (LivePromotionModel) obj;
        return s.d(this.iconImage, livePromotionModel.iconImage) && s.d(this.jumpUrl, livePromotionModel.jumpUrl) && s.d(this.configId, livePromotionModel.configId);
    }

    @NotNull
    public final String getConfigId() {
        return this.configId;
    }

    @NotNull
    public final ImageModel getIconImage() {
        return this.iconImage;
    }

    @Nullable
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public int hashCode() {
        int hashCode = this.iconImage.hashCode() * 31;
        String str = this.jumpUrl;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.configId.hashCode();
    }

    @NotNull
    public String toString() {
        ImageModel imageModel = this.iconImage;
        return "LivePromotionModel(iconImage=" + ((Object) imageModel) + ", jumpUrl=" + this.jumpUrl + ", configId=" + this.configId + ")";
    }
}
