package com.cupidapp.live.club.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubTotalModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubMedalModel implements Serializable {

    @NotNull
    private final String jumpUrl;

    @NotNull
    private final ImageModel medalIcon;

    @NotNull
    private final String medalId;

    @NotNull
    private final String medalName;

    public ClubMedalModel(@NotNull String medalId, @NotNull String medalName, @NotNull ImageModel medalIcon, @NotNull String jumpUrl) {
        s.i(medalId, "medalId");
        s.i(medalName, "medalName");
        s.i(medalIcon, "medalIcon");
        s.i(jumpUrl, "jumpUrl");
        this.medalId = medalId;
        this.medalName = medalName;
        this.medalIcon = medalIcon;
        this.jumpUrl = jumpUrl;
    }

    public static /* synthetic */ ClubMedalModel copy$default(ClubMedalModel clubMedalModel, String str, String str2, ImageModel imageModel, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = clubMedalModel.medalId;
        }
        if ((i10 & 2) != 0) {
            str2 = clubMedalModel.medalName;
        }
        if ((i10 & 4) != 0) {
            imageModel = clubMedalModel.medalIcon;
        }
        if ((i10 & 8) != 0) {
            str3 = clubMedalModel.jumpUrl;
        }
        return clubMedalModel.copy(str, str2, imageModel, str3);
    }

    @NotNull
    public final String component1() {
        return this.medalId;
    }

    @NotNull
    public final String component2() {
        return this.medalName;
    }

    @NotNull
    public final ImageModel component3() {
        return this.medalIcon;
    }

    @NotNull
    public final String component4() {
        return this.jumpUrl;
    }

    @NotNull
    public final ClubMedalModel copy(@NotNull String medalId, @NotNull String medalName, @NotNull ImageModel medalIcon, @NotNull String jumpUrl) {
        s.i(medalId, "medalId");
        s.i(medalName, "medalName");
        s.i(medalIcon, "medalIcon");
        s.i(jumpUrl, "jumpUrl");
        return new ClubMedalModel(medalId, medalName, medalIcon, jumpUrl);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClubMedalModel)) {
            return false;
        }
        ClubMedalModel clubMedalModel = (ClubMedalModel) obj;
        return s.d(this.medalId, clubMedalModel.medalId) && s.d(this.medalName, clubMedalModel.medalName) && s.d(this.medalIcon, clubMedalModel.medalIcon) && s.d(this.jumpUrl, clubMedalModel.jumpUrl);
    }

    @NotNull
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @NotNull
    public final ImageModel getMedalIcon() {
        return this.medalIcon;
    }

    @NotNull
    public final String getMedalId() {
        return this.medalId;
    }

    @NotNull
    public final String getMedalName() {
        return this.medalName;
    }

    public int hashCode() {
        return (((((this.medalId.hashCode() * 31) + this.medalName.hashCode()) * 31) + this.medalIcon.hashCode()) * 31) + this.jumpUrl.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.medalId;
        String str2 = this.medalName;
        ImageModel imageModel = this.medalIcon;
        return "ClubMedalModel(medalId=" + str + ", medalName=" + str2 + ", medalIcon=" + ((Object) imageModel) + ", jumpUrl=" + this.jumpUrl + ")";
    }
}
