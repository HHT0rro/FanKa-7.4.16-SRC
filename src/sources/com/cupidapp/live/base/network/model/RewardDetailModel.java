package com.cupidapp.live.base.network.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProfileTaskResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class RewardDetailModel implements Serializable {

    @Nullable
    private final String desc;

    @NotNull
    private final ImageModel icon;

    @Nullable
    private final String jumpUrl;

    @Nullable
    private final String title;

    @Nullable
    private final String validTime;

    public RewardDetailModel(@Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull ImageModel icon, @Nullable String str4) {
        s.i(icon, "icon");
        this.validTime = str;
        this.desc = str2;
        this.title = str3;
        this.icon = icon;
        this.jumpUrl = str4;
    }

    public static /* synthetic */ RewardDetailModel copy$default(RewardDetailModel rewardDetailModel, String str, String str2, String str3, ImageModel imageModel, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = rewardDetailModel.validTime;
        }
        if ((i10 & 2) != 0) {
            str2 = rewardDetailModel.desc;
        }
        String str5 = str2;
        if ((i10 & 4) != 0) {
            str3 = rewardDetailModel.title;
        }
        String str6 = str3;
        if ((i10 & 8) != 0) {
            imageModel = rewardDetailModel.icon;
        }
        ImageModel imageModel2 = imageModel;
        if ((i10 & 16) != 0) {
            str4 = rewardDetailModel.jumpUrl;
        }
        return rewardDetailModel.copy(str, str5, str6, imageModel2, str4);
    }

    @Nullable
    public final String component1() {
        return this.validTime;
    }

    @Nullable
    public final String component2() {
        return this.desc;
    }

    @Nullable
    public final String component3() {
        return this.title;
    }

    @NotNull
    public final ImageModel component4() {
        return this.icon;
    }

    @Nullable
    public final String component5() {
        return this.jumpUrl;
    }

    @NotNull
    public final RewardDetailModel copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull ImageModel icon, @Nullable String str4) {
        s.i(icon, "icon");
        return new RewardDetailModel(str, str2, str3, icon, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RewardDetailModel)) {
            return false;
        }
        RewardDetailModel rewardDetailModel = (RewardDetailModel) obj;
        return s.d(this.validTime, rewardDetailModel.validTime) && s.d(this.desc, rewardDetailModel.desc) && s.d(this.title, rewardDetailModel.title) && s.d(this.icon, rewardDetailModel.icon) && s.d(this.jumpUrl, rewardDetailModel.jumpUrl);
    }

    @Nullable
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    public final ImageModel getIcon() {
        return this.icon;
    }

    @Nullable
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getValidTime() {
        return this.validTime;
    }

    public int hashCode() {
        String str = this.validTime;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.desc;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.title;
        int hashCode3 = (((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.icon.hashCode()) * 31;
        String str4 = this.jumpUrl;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.validTime;
        String str2 = this.desc;
        String str3 = this.title;
        ImageModel imageModel = this.icon;
        return "RewardDetailModel(validTime=" + str + ", desc=" + str2 + ", title=" + str3 + ", icon=" + ((Object) imageModel) + ", jumpUrl=" + this.jumpUrl + ")";
    }
}
