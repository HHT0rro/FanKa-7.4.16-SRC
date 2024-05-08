package com.cupidapp.live.consult.model;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultListModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultBannerModel {

    @Nullable
    private final ImageModel bgImage;

    @NotNull
    private final String itemId;

    @Nullable
    private final String jumpUrl;

    public ConsultBannerModel(@NotNull String itemId, @Nullable String str, @Nullable ImageModel imageModel) {
        s.i(itemId, "itemId");
        this.itemId = itemId;
        this.jumpUrl = str;
        this.bgImage = imageModel;
    }

    public static /* synthetic */ ConsultBannerModel copy$default(ConsultBannerModel consultBannerModel, String str, String str2, ImageModel imageModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = consultBannerModel.itemId;
        }
        if ((i10 & 2) != 0) {
            str2 = consultBannerModel.jumpUrl;
        }
        if ((i10 & 4) != 0) {
            imageModel = consultBannerModel.bgImage;
        }
        return consultBannerModel.copy(str, str2, imageModel);
    }

    @NotNull
    public final String component1() {
        return this.itemId;
    }

    @Nullable
    public final String component2() {
        return this.jumpUrl;
    }

    @Nullable
    public final ImageModel component3() {
        return this.bgImage;
    }

    @NotNull
    public final ConsultBannerModel copy(@NotNull String itemId, @Nullable String str, @Nullable ImageModel imageModel) {
        s.i(itemId, "itemId");
        return new ConsultBannerModel(itemId, str, imageModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConsultBannerModel)) {
            return false;
        }
        ConsultBannerModel consultBannerModel = (ConsultBannerModel) obj;
        return s.d(this.itemId, consultBannerModel.itemId) && s.d(this.jumpUrl, consultBannerModel.jumpUrl) && s.d(this.bgImage, consultBannerModel.bgImage);
    }

    @Nullable
    public final ImageModel getBgImage() {
        return this.bgImage;
    }

    @NotNull
    public final String getItemId() {
        return this.itemId;
    }

    @Nullable
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public int hashCode() {
        int hashCode = this.itemId.hashCode() * 31;
        String str = this.jumpUrl;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        ImageModel imageModel = this.bgImage;
        return hashCode2 + (imageModel != null ? imageModel.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ConsultBannerModel(itemId=" + this.itemId + ", jumpUrl=" + this.jumpUrl + ", bgImage=" + ((Object) this.bgImage) + ")";
    }
}
