package com.cupidapp.live.profile.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: User.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FansClubMedalModel implements Serializable {

    @Nullable
    private final String badgeBgColor;

    @Nullable
    private final ImageModel badgeIcon;

    @Nullable
    private final String badgeName;
    private final int level;

    public FansClubMedalModel(int i10, @Nullable ImageModel imageModel, @Nullable String str, @Nullable String str2) {
        this.level = i10;
        this.badgeIcon = imageModel;
        this.badgeName = str;
        this.badgeBgColor = str2;
    }

    public static /* synthetic */ FansClubMedalModel copy$default(FansClubMedalModel fansClubMedalModel, int i10, ImageModel imageModel, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = fansClubMedalModel.level;
        }
        if ((i11 & 2) != 0) {
            imageModel = fansClubMedalModel.badgeIcon;
        }
        if ((i11 & 4) != 0) {
            str = fansClubMedalModel.badgeName;
        }
        if ((i11 & 8) != 0) {
            str2 = fansClubMedalModel.badgeBgColor;
        }
        return fansClubMedalModel.copy(i10, imageModel, str, str2);
    }

    public final int component1() {
        return this.level;
    }

    @Nullable
    public final ImageModel component2() {
        return this.badgeIcon;
    }

    @Nullable
    public final String component3() {
        return this.badgeName;
    }

    @Nullable
    public final String component4() {
        return this.badgeBgColor;
    }

    @NotNull
    public final FansClubMedalModel copy(int i10, @Nullable ImageModel imageModel, @Nullable String str, @Nullable String str2) {
        return new FansClubMedalModel(i10, imageModel, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FansClubMedalModel)) {
            return false;
        }
        FansClubMedalModel fansClubMedalModel = (FansClubMedalModel) obj;
        return this.level == fansClubMedalModel.level && s.d(this.badgeIcon, fansClubMedalModel.badgeIcon) && s.d(this.badgeName, fansClubMedalModel.badgeName) && s.d(this.badgeBgColor, fansClubMedalModel.badgeBgColor);
    }

    @Nullable
    public final String getBadgeBgColor() {
        return this.badgeBgColor;
    }

    @Nullable
    public final ImageModel getBadgeIcon() {
        return this.badgeIcon;
    }

    @Nullable
    public final String getBadgeName() {
        return this.badgeName;
    }

    public final int getLevel() {
        return this.level;
    }

    public int hashCode() {
        int i10 = this.level * 31;
        ImageModel imageModel = this.badgeIcon;
        int hashCode = (i10 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        String str = this.badgeName;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.badgeBgColor;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        int i10 = this.level;
        ImageModel imageModel = this.badgeIcon;
        return "FansClubMedalModel(level=" + i10 + ", badgeIcon=" + ((Object) imageModel) + ", badgeName=" + this.badgeName + ", badgeBgColor=" + this.badgeBgColor + ")";
    }
}
