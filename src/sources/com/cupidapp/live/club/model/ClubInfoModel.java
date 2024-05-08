package com.cupidapp.live.club.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubTotalModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubInfoModel implements Serializable {
    private final boolean canKickOut;

    @Nullable
    private final String clubId;

    @Nullable
    private final String clubName;

    public ClubInfoModel(boolean z10, @Nullable String str, @Nullable String str2) {
        this.canKickOut = z10;
        this.clubId = str;
        this.clubName = str2;
    }

    public static /* synthetic */ ClubInfoModel copy$default(ClubInfoModel clubInfoModel, boolean z10, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = clubInfoModel.canKickOut;
        }
        if ((i10 & 2) != 0) {
            str = clubInfoModel.clubId;
        }
        if ((i10 & 4) != 0) {
            str2 = clubInfoModel.clubName;
        }
        return clubInfoModel.copy(z10, str, str2);
    }

    public final boolean component1() {
        return this.canKickOut;
    }

    @Nullable
    public final String component2() {
        return this.clubId;
    }

    @Nullable
    public final String component3() {
        return this.clubName;
    }

    @NotNull
    public final ClubInfoModel copy(boolean z10, @Nullable String str, @Nullable String str2) {
        return new ClubInfoModel(z10, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClubInfoModel)) {
            return false;
        }
        ClubInfoModel clubInfoModel = (ClubInfoModel) obj;
        return this.canKickOut == clubInfoModel.canKickOut && s.d(this.clubId, clubInfoModel.clubId) && s.d(this.clubName, clubInfoModel.clubName);
    }

    public final boolean getCanKickOut() {
        return this.canKickOut;
    }

    @Nullable
    public final String getClubId() {
        return this.clubId;
    }

    @Nullable
    public final String getClubName() {
        return this.clubName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z10 = this.canKickOut;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i10 = r02 * 31;
        String str = this.clubId;
        int hashCode = (i10 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.clubName;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ClubInfoModel(canKickOut=" + this.canKickOut + ", clubId=" + this.clubId + ", clubName=" + this.clubName + ")";
    }
}
