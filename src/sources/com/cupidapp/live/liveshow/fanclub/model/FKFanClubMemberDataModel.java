package com.cupidapp.live.liveshow.fanclub.model;

import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.profile.model.User;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKFanClubResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKFanClubMemberDataModel implements Serializable {
    private boolean autoLightUp;

    @Nullable
    private final String badgeBgColor;

    @Nullable
    private final ImageModel badgeIcon;

    @Nullable
    private final String badgeName;
    private final int familiarScore;

    @NotNull
    private final String familiarScoreFormatted;
    private final int level;

    @NotNull
    private final String scoreToNextLevel;
    private final int status;

    @NotNull
    private final User user;

    public FKFanClubMemberDataModel(@NotNull User user, int i10, int i11, int i12, @NotNull String familiarScoreFormatted, @NotNull String scoreToNextLevel, @Nullable String str, @Nullable ImageModel imageModel, @Nullable String str2, boolean z10) {
        s.i(user, "user");
        s.i(familiarScoreFormatted, "familiarScoreFormatted");
        s.i(scoreToNextLevel, "scoreToNextLevel");
        this.user = user;
        this.status = i10;
        this.level = i11;
        this.familiarScore = i12;
        this.familiarScoreFormatted = familiarScoreFormatted;
        this.scoreToNextLevel = scoreToNextLevel;
        this.badgeName = str;
        this.badgeIcon = imageModel;
        this.badgeBgColor = str2;
        this.autoLightUp = z10;
    }

    @NotNull
    public final User component1() {
        return this.user;
    }

    public final boolean component10() {
        return this.autoLightUp;
    }

    public final int component2() {
        return this.status;
    }

    public final int component3() {
        return this.level;
    }

    public final int component4() {
        return this.familiarScore;
    }

    @NotNull
    public final String component5() {
        return this.familiarScoreFormatted;
    }

    @NotNull
    public final String component6() {
        return this.scoreToNextLevel;
    }

    @Nullable
    public final String component7() {
        return this.badgeName;
    }

    @Nullable
    public final ImageModel component8() {
        return this.badgeIcon;
    }

    @Nullable
    public final String component9() {
        return this.badgeBgColor;
    }

    @NotNull
    public final FKFanClubMemberDataModel copy(@NotNull User user, int i10, int i11, int i12, @NotNull String familiarScoreFormatted, @NotNull String scoreToNextLevel, @Nullable String str, @Nullable ImageModel imageModel, @Nullable String str2, boolean z10) {
        s.i(user, "user");
        s.i(familiarScoreFormatted, "familiarScoreFormatted");
        s.i(scoreToNextLevel, "scoreToNextLevel");
        return new FKFanClubMemberDataModel(user, i10, i11, i12, familiarScoreFormatted, scoreToNextLevel, str, imageModel, str2, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKFanClubMemberDataModel)) {
            return false;
        }
        FKFanClubMemberDataModel fKFanClubMemberDataModel = (FKFanClubMemberDataModel) obj;
        return s.d(this.user, fKFanClubMemberDataModel.user) && this.status == fKFanClubMemberDataModel.status && this.level == fKFanClubMemberDataModel.level && this.familiarScore == fKFanClubMemberDataModel.familiarScore && s.d(this.familiarScoreFormatted, fKFanClubMemberDataModel.familiarScoreFormatted) && s.d(this.scoreToNextLevel, fKFanClubMemberDataModel.scoreToNextLevel) && s.d(this.badgeName, fKFanClubMemberDataModel.badgeName) && s.d(this.badgeIcon, fKFanClubMemberDataModel.badgeIcon) && s.d(this.badgeBgColor, fKFanClubMemberDataModel.badgeBgColor) && this.autoLightUp == fKFanClubMemberDataModel.autoLightUp;
    }

    public final boolean getAutoLightUp() {
        return this.autoLightUp;
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

    public final int getFamiliarScore() {
        return this.familiarScore;
    }

    @NotNull
    public final String getFamiliarScoreFormatted() {
        return this.familiarScoreFormatted;
    }

    public final int getLevel() {
        return this.level;
    }

    @NotNull
    public final String getScoreToNextLevel() {
        return this.scoreToNextLevel;
    }

    public final int getStatus() {
        return this.status;
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((this.user.hashCode() * 31) + this.status) * 31) + this.level) * 31) + this.familiarScore) * 31) + this.familiarScoreFormatted.hashCode()) * 31) + this.scoreToNextLevel.hashCode()) * 31;
        String str = this.badgeName;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        ImageModel imageModel = this.badgeIcon;
        int hashCode3 = (hashCode2 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        String str2 = this.badgeBgColor;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z10 = this.autoLightUp;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode4 + i10;
    }

    public final void setAutoLightUp(boolean z10) {
        this.autoLightUp = z10;
    }

    @NotNull
    public String toString() {
        User user = this.user;
        int i10 = this.status;
        int i11 = this.level;
        int i12 = this.familiarScore;
        String str = this.familiarScoreFormatted;
        String str2 = this.scoreToNextLevel;
        String str3 = this.badgeName;
        ImageModel imageModel = this.badgeIcon;
        return "FKFanClubMemberDataModel(user=" + ((Object) user) + ", status=" + i10 + ", level=" + i11 + ", familiarScore=" + i12 + ", familiarScoreFormatted=" + str + ", scoreToNextLevel=" + str2 + ", badgeName=" + str3 + ", badgeIcon=" + ((Object) imageModel) + ", badgeBgColor=" + this.badgeBgColor + ", autoLightUp=" + this.autoLightUp + ")";
    }
}
