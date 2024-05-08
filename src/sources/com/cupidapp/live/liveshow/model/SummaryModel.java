package com.cupidapp.live.liveshow.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveSummaryDataResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SummaryModel implements Serializable {

    @Nullable
    private String auditWarning;

    @NotNull
    private final String commission;

    @NotNull
    private final ExperienceInfoModel endExperienceInfo;

    @Nullable
    private Long liveDurationMillis;

    @NotNull
    private final String newCommission;
    private final int newFans;
    private final int newGift;
    private final int pkCount;
    private final int pkWinCount;
    private final int viewers;

    public SummaryModel(@NotNull String newCommission, int i10, @NotNull String commission, int i11, int i12, @Nullable String str, @Nullable Long l10, int i13, int i14, @NotNull ExperienceInfoModel endExperienceInfo) {
        s.i(newCommission, "newCommission");
        s.i(commission, "commission");
        s.i(endExperienceInfo, "endExperienceInfo");
        this.newCommission = newCommission;
        this.viewers = i10;
        this.commission = commission;
        this.newGift = i11;
        this.newFans = i12;
        this.auditWarning = str;
        this.liveDurationMillis = l10;
        this.pkCount = i13;
        this.pkWinCount = i14;
        this.endExperienceInfo = endExperienceInfo;
    }

    @NotNull
    public final String component1() {
        return this.newCommission;
    }

    @NotNull
    public final ExperienceInfoModel component10() {
        return this.endExperienceInfo;
    }

    public final int component2() {
        return this.viewers;
    }

    @NotNull
    public final String component3() {
        return this.commission;
    }

    public final int component4() {
        return this.newGift;
    }

    public final int component5() {
        return this.newFans;
    }

    @Nullable
    public final String component6() {
        return this.auditWarning;
    }

    @Nullable
    public final Long component7() {
        return this.liveDurationMillis;
    }

    public final int component8() {
        return this.pkCount;
    }

    public final int component9() {
        return this.pkWinCount;
    }

    @NotNull
    public final SummaryModel copy(@NotNull String newCommission, int i10, @NotNull String commission, int i11, int i12, @Nullable String str, @Nullable Long l10, int i13, int i14, @NotNull ExperienceInfoModel endExperienceInfo) {
        s.i(newCommission, "newCommission");
        s.i(commission, "commission");
        s.i(endExperienceInfo, "endExperienceInfo");
        return new SummaryModel(newCommission, i10, commission, i11, i12, str, l10, i13, i14, endExperienceInfo);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SummaryModel)) {
            return false;
        }
        SummaryModel summaryModel = (SummaryModel) obj;
        return s.d(this.newCommission, summaryModel.newCommission) && this.viewers == summaryModel.viewers && s.d(this.commission, summaryModel.commission) && this.newGift == summaryModel.newGift && this.newFans == summaryModel.newFans && s.d(this.auditWarning, summaryModel.auditWarning) && s.d(this.liveDurationMillis, summaryModel.liveDurationMillis) && this.pkCount == summaryModel.pkCount && this.pkWinCount == summaryModel.pkWinCount && s.d(this.endExperienceInfo, summaryModel.endExperienceInfo);
    }

    @Nullable
    public final String getAuditWarning() {
        return this.auditWarning;
    }

    @NotNull
    public final String getCommission() {
        return this.commission;
    }

    @NotNull
    public final ExperienceInfoModel getEndExperienceInfo() {
        return this.endExperienceInfo;
    }

    @Nullable
    public final Long getLiveDurationMillis() {
        return this.liveDurationMillis;
    }

    @NotNull
    public final String getNewCommission() {
        return this.newCommission;
    }

    public final int getNewFans() {
        return this.newFans;
    }

    public final int getNewGift() {
        return this.newGift;
    }

    public final int getPkCount() {
        return this.pkCount;
    }

    public final int getPkWinCount() {
        return this.pkWinCount;
    }

    public final int getViewers() {
        return this.viewers;
    }

    public int hashCode() {
        int hashCode = ((((((((this.newCommission.hashCode() * 31) + this.viewers) * 31) + this.commission.hashCode()) * 31) + this.newGift) * 31) + this.newFans) * 31;
        String str = this.auditWarning;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l10 = this.liveDurationMillis;
        return ((((((hashCode2 + (l10 != null ? l10.hashCode() : 0)) * 31) + this.pkCount) * 31) + this.pkWinCount) * 31) + this.endExperienceInfo.hashCode();
    }

    public final void setAuditWarning(@Nullable String str) {
        this.auditWarning = str;
    }

    public final void setLiveDurationMillis(@Nullable Long l10) {
        this.liveDurationMillis = l10;
    }

    @NotNull
    public String toString() {
        String str = this.newCommission;
        int i10 = this.viewers;
        String str2 = this.commission;
        int i11 = this.newGift;
        int i12 = this.newFans;
        String str3 = this.auditWarning;
        Long l10 = this.liveDurationMillis;
        return "SummaryModel(newCommission=" + str + ", viewers=" + i10 + ", commission=" + str2 + ", newGift=" + i11 + ", newFans=" + i12 + ", auditWarning=" + str3 + ", liveDurationMillis=" + ((Object) l10) + ", pkCount=" + this.pkCount + ", pkWinCount=" + this.pkWinCount + ", endExperienceInfo=" + ((Object) this.endExperienceInfo) + ")";
    }
}
