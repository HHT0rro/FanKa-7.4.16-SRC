package com.cupidapp.live.liveshow.fanclub.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKFanClubResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKFanClubTaskDataModel implements Serializable {
    private int amount;

    @NotNull
    private final ImageModel iconImage;

    /* renamed from: id, reason: collision with root package name */
    @Nullable
    private final String f14984id;

    @NotNull
    private final String jumpDesc;

    @Nullable
    private final String jumpUrl;

    @NotNull
    private final String missionId;

    @NotNull
    private final String name;

    @NotNull
    private final String rewardName;

    @NotNull
    private final String rewardTitle;

    @Nullable
    private final String specificGiftId;
    private int status;

    public FKFanClubTaskDataModel(@Nullable String str, @NotNull String missionId, @NotNull ImageModel iconImage, @NotNull String name, int i10, @NotNull String rewardTitle, @NotNull String rewardName, int i11, @Nullable String str2, @NotNull String jumpDesc, @Nullable String str3) {
        s.i(missionId, "missionId");
        s.i(iconImage, "iconImage");
        s.i(name, "name");
        s.i(rewardTitle, "rewardTitle");
        s.i(rewardName, "rewardName");
        s.i(jumpDesc, "jumpDesc");
        this.f14984id = str;
        this.missionId = missionId;
        this.iconImage = iconImage;
        this.name = name;
        this.amount = i10;
        this.rewardTitle = rewardTitle;
        this.rewardName = rewardName;
        this.status = i11;
        this.specificGiftId = str2;
        this.jumpDesc = jumpDesc;
        this.jumpUrl = str3;
    }

    @Nullable
    public final String component1() {
        return this.f14984id;
    }

    @NotNull
    public final String component10() {
        return this.jumpDesc;
    }

    @Nullable
    public final String component11() {
        return this.jumpUrl;
    }

    @NotNull
    public final String component2() {
        return this.missionId;
    }

    @NotNull
    public final ImageModel component3() {
        return this.iconImage;
    }

    @NotNull
    public final String component4() {
        return this.name;
    }

    public final int component5() {
        return this.amount;
    }

    @NotNull
    public final String component6() {
        return this.rewardTitle;
    }

    @NotNull
    public final String component7() {
        return this.rewardName;
    }

    public final int component8() {
        return this.status;
    }

    @Nullable
    public final String component9() {
        return this.specificGiftId;
    }

    @NotNull
    public final FKFanClubTaskDataModel copy(@Nullable String str, @NotNull String missionId, @NotNull ImageModel iconImage, @NotNull String name, int i10, @NotNull String rewardTitle, @NotNull String rewardName, int i11, @Nullable String str2, @NotNull String jumpDesc, @Nullable String str3) {
        s.i(missionId, "missionId");
        s.i(iconImage, "iconImage");
        s.i(name, "name");
        s.i(rewardTitle, "rewardTitle");
        s.i(rewardName, "rewardName");
        s.i(jumpDesc, "jumpDesc");
        return new FKFanClubTaskDataModel(str, missionId, iconImage, name, i10, rewardTitle, rewardName, i11, str2, jumpDesc, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKFanClubTaskDataModel)) {
            return false;
        }
        FKFanClubTaskDataModel fKFanClubTaskDataModel = (FKFanClubTaskDataModel) obj;
        return s.d(this.f14984id, fKFanClubTaskDataModel.f14984id) && s.d(this.missionId, fKFanClubTaskDataModel.missionId) && s.d(this.iconImage, fKFanClubTaskDataModel.iconImage) && s.d(this.name, fKFanClubTaskDataModel.name) && this.amount == fKFanClubTaskDataModel.amount && s.d(this.rewardTitle, fKFanClubTaskDataModel.rewardTitle) && s.d(this.rewardName, fKFanClubTaskDataModel.rewardName) && this.status == fKFanClubTaskDataModel.status && s.d(this.specificGiftId, fKFanClubTaskDataModel.specificGiftId) && s.d(this.jumpDesc, fKFanClubTaskDataModel.jumpDesc) && s.d(this.jumpUrl, fKFanClubTaskDataModel.jumpUrl);
    }

    public final int getAmount() {
        return this.amount;
    }

    @NotNull
    public final ImageModel getIconImage() {
        return this.iconImage;
    }

    @Nullable
    public final String getId() {
        return this.f14984id;
    }

    @NotNull
    public final String getJumpDesc() {
        return this.jumpDesc;
    }

    @Nullable
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @NotNull
    public final String getMissionId() {
        return this.missionId;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getRewardName() {
        return this.rewardName;
    }

    @NotNull
    public final String getRewardTitle() {
        return this.rewardTitle;
    }

    @Nullable
    public final String getSpecificGiftId() {
        return this.specificGiftId;
    }

    public final int getStatus() {
        return this.status;
    }

    public int hashCode() {
        String str = this.f14984id;
        int hashCode = (((((((((((((((str == null ? 0 : str.hashCode()) * 31) + this.missionId.hashCode()) * 31) + this.iconImage.hashCode()) * 31) + this.name.hashCode()) * 31) + this.amount) * 31) + this.rewardTitle.hashCode()) * 31) + this.rewardName.hashCode()) * 31) + this.status) * 31;
        String str2 = this.specificGiftId;
        int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.jumpDesc.hashCode()) * 31;
        String str3 = this.jumpUrl;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setAmount(int i10) {
        this.amount = i10;
    }

    public final void setStatus(int i10) {
        this.status = i10;
    }

    @NotNull
    public String toString() {
        String str = this.f14984id;
        String str2 = this.missionId;
        ImageModel imageModel = this.iconImage;
        return "FKFanClubTaskDataModel(id=" + str + ", missionId=" + str2 + ", iconImage=" + ((Object) imageModel) + ", name=" + this.name + ", amount=" + this.amount + ", rewardTitle=" + this.rewardTitle + ", rewardName=" + this.rewardName + ", status=" + this.status + ", specificGiftId=" + this.specificGiftId + ", jumpDesc=" + this.jumpDesc + ", jumpUrl=" + this.jumpUrl + ")";
    }
}
