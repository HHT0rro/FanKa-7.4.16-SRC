package com.cupidapp.live.liveshow.fanclub.view;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKFanClubMedalLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKFanClubMedalModel {

    @Nullable
    private final String medalBgColor;

    @Nullable
    private final ImageModel medalImage;
    private final int medalLevel;

    @Nullable
    private final String medalName;

    public FKFanClubMedalModel(int i10, @Nullable String str, @Nullable ImageModel imageModel, @Nullable String str2) {
        this.medalLevel = i10;
        this.medalName = str;
        this.medalImage = imageModel;
        this.medalBgColor = str2;
    }

    public static /* synthetic */ FKFanClubMedalModel copy$default(FKFanClubMedalModel fKFanClubMedalModel, int i10, String str, ImageModel imageModel, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = fKFanClubMedalModel.medalLevel;
        }
        if ((i11 & 2) != 0) {
            str = fKFanClubMedalModel.medalName;
        }
        if ((i11 & 4) != 0) {
            imageModel = fKFanClubMedalModel.medalImage;
        }
        if ((i11 & 8) != 0) {
            str2 = fKFanClubMedalModel.medalBgColor;
        }
        return fKFanClubMedalModel.copy(i10, str, imageModel, str2);
    }

    public final int component1() {
        return this.medalLevel;
    }

    @Nullable
    public final String component2() {
        return this.medalName;
    }

    @Nullable
    public final ImageModel component3() {
        return this.medalImage;
    }

    @Nullable
    public final String component4() {
        return this.medalBgColor;
    }

    @NotNull
    public final FKFanClubMedalModel copy(int i10, @Nullable String str, @Nullable ImageModel imageModel, @Nullable String str2) {
        return new FKFanClubMedalModel(i10, str, imageModel, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKFanClubMedalModel)) {
            return false;
        }
        FKFanClubMedalModel fKFanClubMedalModel = (FKFanClubMedalModel) obj;
        return this.medalLevel == fKFanClubMedalModel.medalLevel && s.d(this.medalName, fKFanClubMedalModel.medalName) && s.d(this.medalImage, fKFanClubMedalModel.medalImage) && s.d(this.medalBgColor, fKFanClubMedalModel.medalBgColor);
    }

    @Nullable
    public final String getMedalBgColor() {
        return this.medalBgColor;
    }

    @Nullable
    public final ImageModel getMedalImage() {
        return this.medalImage;
    }

    public final int getMedalLevel() {
        return this.medalLevel;
    }

    @Nullable
    public final String getMedalName() {
        return this.medalName;
    }

    public int hashCode() {
        int i10 = this.medalLevel * 31;
        String str = this.medalName;
        int hashCode = (i10 + (str == null ? 0 : str.hashCode())) * 31;
        ImageModel imageModel = this.medalImage;
        int hashCode2 = (hashCode + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        String str2 = this.medalBgColor;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        int i10 = this.medalLevel;
        String str = this.medalName;
        ImageModel imageModel = this.medalImage;
        return "FKFanClubMedalModel(medalLevel=" + i10 + ", medalName=" + str + ", medalImage=" + ((Object) imageModel) + ", medalBgColor=" + this.medalBgColor + ")";
    }
}
