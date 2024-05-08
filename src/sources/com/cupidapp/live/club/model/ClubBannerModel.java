package com.cupidapp.live.club.model;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubWonderfulActModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubBannerModel {

    @NotNull
    private final String actId;

    @NotNull
    private final ImageModel icon;

    @Nullable
    private final String jumpUrl;

    public ClubBannerModel(@NotNull ImageModel icon, @Nullable String str, @NotNull String actId) {
        s.i(icon, "icon");
        s.i(actId, "actId");
        this.icon = icon;
        this.jumpUrl = str;
        this.actId = actId;
    }

    public static /* synthetic */ ClubBannerModel copy$default(ClubBannerModel clubBannerModel, ImageModel imageModel, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            imageModel = clubBannerModel.icon;
        }
        if ((i10 & 2) != 0) {
            str = clubBannerModel.jumpUrl;
        }
        if ((i10 & 4) != 0) {
            str2 = clubBannerModel.actId;
        }
        return clubBannerModel.copy(imageModel, str, str2);
    }

    @NotNull
    public final ImageModel component1() {
        return this.icon;
    }

    @Nullable
    public final String component2() {
        return this.jumpUrl;
    }

    @NotNull
    public final String component3() {
        return this.actId;
    }

    @NotNull
    public final ClubBannerModel copy(@NotNull ImageModel icon, @Nullable String str, @NotNull String actId) {
        s.i(icon, "icon");
        s.i(actId, "actId");
        return new ClubBannerModel(icon, str, actId);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClubBannerModel)) {
            return false;
        }
        ClubBannerModel clubBannerModel = (ClubBannerModel) obj;
        return s.d(this.icon, clubBannerModel.icon) && s.d(this.jumpUrl, clubBannerModel.jumpUrl) && s.d(this.actId, clubBannerModel.actId);
    }

    @NotNull
    public final String getActId() {
        return this.actId;
    }

    @NotNull
    public final ImageModel getIcon() {
        return this.icon;
    }

    @Nullable
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public int hashCode() {
        int hashCode = this.icon.hashCode() * 31;
        String str = this.jumpUrl;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.actId.hashCode();
    }

    @NotNull
    public String toString() {
        ImageModel imageModel = this.icon;
        return "ClubBannerModel(icon=" + ((Object) imageModel) + ", jumpUrl=" + this.jumpUrl + ", actId=" + this.actId + ")";
    }
}
