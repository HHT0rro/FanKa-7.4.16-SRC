package com.cupidapp.live.vip.model;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VipPurchasePriceModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VipPurchaseActivityModel {

    @Nullable
    private final ImageModel cornerImg;

    @Nullable
    private final String cornerImgUrlDesc;

    public VipPurchaseActivityModel(@Nullable String str, @Nullable ImageModel imageModel) {
        this.cornerImgUrlDesc = str;
        this.cornerImg = imageModel;
    }

    public static /* synthetic */ VipPurchaseActivityModel copy$default(VipPurchaseActivityModel vipPurchaseActivityModel, String str, ImageModel imageModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = vipPurchaseActivityModel.cornerImgUrlDesc;
        }
        if ((i10 & 2) != 0) {
            imageModel = vipPurchaseActivityModel.cornerImg;
        }
        return vipPurchaseActivityModel.copy(str, imageModel);
    }

    @Nullable
    public final String component1() {
        return this.cornerImgUrlDesc;
    }

    @Nullable
    public final ImageModel component2() {
        return this.cornerImg;
    }

    @NotNull
    public final VipPurchaseActivityModel copy(@Nullable String str, @Nullable ImageModel imageModel) {
        return new VipPurchaseActivityModel(str, imageModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VipPurchaseActivityModel)) {
            return false;
        }
        VipPurchaseActivityModel vipPurchaseActivityModel = (VipPurchaseActivityModel) obj;
        return s.d(this.cornerImgUrlDesc, vipPurchaseActivityModel.cornerImgUrlDesc) && s.d(this.cornerImg, vipPurchaseActivityModel.cornerImg);
    }

    @Nullable
    public final ImageModel getCornerImg() {
        return this.cornerImg;
    }

    @Nullable
    public final String getCornerImgUrlDesc() {
        return this.cornerImgUrlDesc;
    }

    public int hashCode() {
        String str = this.cornerImgUrlDesc;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        ImageModel imageModel = this.cornerImg;
        return hashCode + (imageModel != null ? imageModel.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "VipPurchaseActivityModel(cornerImgUrlDesc=" + this.cornerImgUrlDesc + ", cornerImg=" + ((Object) this.cornerImg) + ")";
    }
}
