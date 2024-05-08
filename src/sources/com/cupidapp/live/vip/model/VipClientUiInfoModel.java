package com.cupidapp.live.vip.model;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VipPurchasePriceModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VipClientUiInfoModel {

    @Nullable
    private final String vipFeatureDesc;

    @Nullable
    private final ImageModel vipFeatureDescimage;

    public VipClientUiInfoModel(@Nullable String str, @Nullable ImageModel imageModel) {
        this.vipFeatureDesc = str;
        this.vipFeatureDescimage = imageModel;
    }

    public static /* synthetic */ VipClientUiInfoModel copy$default(VipClientUiInfoModel vipClientUiInfoModel, String str, ImageModel imageModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = vipClientUiInfoModel.vipFeatureDesc;
        }
        if ((i10 & 2) != 0) {
            imageModel = vipClientUiInfoModel.vipFeatureDescimage;
        }
        return vipClientUiInfoModel.copy(str, imageModel);
    }

    @Nullable
    public final String component1() {
        return this.vipFeatureDesc;
    }

    @Nullable
    public final ImageModel component2() {
        return this.vipFeatureDescimage;
    }

    @NotNull
    public final VipClientUiInfoModel copy(@Nullable String str, @Nullable ImageModel imageModel) {
        return new VipClientUiInfoModel(str, imageModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VipClientUiInfoModel)) {
            return false;
        }
        VipClientUiInfoModel vipClientUiInfoModel = (VipClientUiInfoModel) obj;
        return s.d(this.vipFeatureDesc, vipClientUiInfoModel.vipFeatureDesc) && s.d(this.vipFeatureDescimage, vipClientUiInfoModel.vipFeatureDescimage);
    }

    @Nullable
    public final String getVipFeatureDesc() {
        return this.vipFeatureDesc;
    }

    @Nullable
    public final ImageModel getVipFeatureDescimage() {
        return this.vipFeatureDescimage;
    }

    public int hashCode() {
        String str = this.vipFeatureDesc;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        ImageModel imageModel = this.vipFeatureDescimage;
        return hashCode + (imageModel != null ? imageModel.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "VipClientUiInfoModel(vipFeatureDesc=" + this.vipFeatureDesc + ", vipFeatureDescimage=" + ((Object) this.vipFeatureDescimage) + ")";
    }
}
