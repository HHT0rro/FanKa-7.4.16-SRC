package com.cupidapp.live.liveshow.view.giftpicker.model;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DiamondResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class RechargeRewardModel {

    @Nullable
    private final ImageModel iconImage;

    @NotNull
    private final String title;

    public RechargeRewardModel(@NotNull String title, @Nullable ImageModel imageModel) {
        s.i(title, "title");
        this.title = title;
        this.iconImage = imageModel;
    }

    public static /* synthetic */ RechargeRewardModel copy$default(RechargeRewardModel rechargeRewardModel, String str, ImageModel imageModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = rechargeRewardModel.title;
        }
        if ((i10 & 2) != 0) {
            imageModel = rechargeRewardModel.iconImage;
        }
        return rechargeRewardModel.copy(str, imageModel);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final ImageModel component2() {
        return this.iconImage;
    }

    @NotNull
    public final RechargeRewardModel copy(@NotNull String title, @Nullable ImageModel imageModel) {
        s.i(title, "title");
        return new RechargeRewardModel(title, imageModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RechargeRewardModel)) {
            return false;
        }
        RechargeRewardModel rechargeRewardModel = (RechargeRewardModel) obj;
        return s.d(this.title, rechargeRewardModel.title) && s.d(this.iconImage, rechargeRewardModel.iconImage);
    }

    @Nullable
    public final ImageModel getIconImage() {
        return this.iconImage;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int hashCode = this.title.hashCode() * 31;
        ImageModel imageModel = this.iconImage;
        return hashCode + (imageModel == null ? 0 : imageModel.hashCode());
    }

    @NotNull
    public String toString() {
        return "RechargeRewardModel(title=" + this.title + ", iconImage=" + ((Object) this.iconImage) + ")";
    }
}
