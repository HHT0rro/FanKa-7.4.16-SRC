package com.cupidapp.live.superboost.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RemainAssetsResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SuperBoostRemainAssetsResult {

    @Nullable
    private final Long exposureEnd;

    @Nullable
    private final String extraCountInfo;

    @Nullable
    private final Integer superboostRemains;

    @Nullable
    private final Integer targetedSuperboostRemains;

    @Nullable
    private final Integer travelboostRemains;

    @Nullable
    private final Long travelboostStatus;

    public SuperBoostRemainAssetsResult() {
        this(null, null, null, null, null, null, 63, null);
    }

    public SuperBoostRemainAssetsResult(@Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Long l10, @Nullable Long l11, @Nullable String str) {
        this.superboostRemains = num;
        this.targetedSuperboostRemains = num2;
        this.travelboostRemains = num3;
        this.travelboostStatus = l10;
        this.exposureEnd = l11;
        this.extraCountInfo = str;
    }

    public static /* synthetic */ SuperBoostRemainAssetsResult copy$default(SuperBoostRemainAssetsResult superBoostRemainAssetsResult, Integer num, Integer num2, Integer num3, Long l10, Long l11, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = superBoostRemainAssetsResult.superboostRemains;
        }
        if ((i10 & 2) != 0) {
            num2 = superBoostRemainAssetsResult.targetedSuperboostRemains;
        }
        Integer num4 = num2;
        if ((i10 & 4) != 0) {
            num3 = superBoostRemainAssetsResult.travelboostRemains;
        }
        Integer num5 = num3;
        if ((i10 & 8) != 0) {
            l10 = superBoostRemainAssetsResult.travelboostStatus;
        }
        Long l12 = l10;
        if ((i10 & 16) != 0) {
            l11 = superBoostRemainAssetsResult.exposureEnd;
        }
        Long l13 = l11;
        if ((i10 & 32) != 0) {
            str = superBoostRemainAssetsResult.extraCountInfo;
        }
        return superBoostRemainAssetsResult.copy(num, num4, num5, l12, l13, str);
    }

    @Nullable
    public final Integer component1() {
        return this.superboostRemains;
    }

    @Nullable
    public final Integer component2() {
        return this.targetedSuperboostRemains;
    }

    @Nullable
    public final Integer component3() {
        return this.travelboostRemains;
    }

    @Nullable
    public final Long component4() {
        return this.travelboostStatus;
    }

    @Nullable
    public final Long component5() {
        return this.exposureEnd;
    }

    @Nullable
    public final String component6() {
        return this.extraCountInfo;
    }

    @NotNull
    public final SuperBoostRemainAssetsResult copy(@Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Long l10, @Nullable Long l11, @Nullable String str) {
        return new SuperBoostRemainAssetsResult(num, num2, num3, l10, l11, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuperBoostRemainAssetsResult)) {
            return false;
        }
        SuperBoostRemainAssetsResult superBoostRemainAssetsResult = (SuperBoostRemainAssetsResult) obj;
        return s.d(this.superboostRemains, superBoostRemainAssetsResult.superboostRemains) && s.d(this.targetedSuperboostRemains, superBoostRemainAssetsResult.targetedSuperboostRemains) && s.d(this.travelboostRemains, superBoostRemainAssetsResult.travelboostRemains) && s.d(this.travelboostStatus, superBoostRemainAssetsResult.travelboostStatus) && s.d(this.exposureEnd, superBoostRemainAssetsResult.exposureEnd) && s.d(this.extraCountInfo, superBoostRemainAssetsResult.extraCountInfo);
    }

    @Nullable
    public final Long getExposureEnd() {
        return this.exposureEnd;
    }

    @Nullable
    public final String getExtraCountInfo() {
        return this.extraCountInfo;
    }

    @Nullable
    public final Integer getSuperboostRemains() {
        return this.superboostRemains;
    }

    @Nullable
    public final Integer getTargetedSuperboostRemains() {
        return this.targetedSuperboostRemains;
    }

    @Nullable
    public final Integer getTravelboostRemains() {
        return this.travelboostRemains;
    }

    @Nullable
    public final Long getTravelboostStatus() {
        return this.travelboostStatus;
    }

    public int hashCode() {
        Integer num = this.superboostRemains;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.targetedSuperboostRemains;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.travelboostRemains;
        int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Long l10 = this.travelboostStatus;
        int hashCode4 = (hashCode3 + (l10 == null ? 0 : l10.hashCode())) * 31;
        Long l11 = this.exposureEnd;
        int hashCode5 = (hashCode4 + (l11 == null ? 0 : l11.hashCode())) * 31;
        String str = this.extraCountInfo;
        return hashCode5 + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        Integer num = this.superboostRemains;
        Integer num2 = this.targetedSuperboostRemains;
        Integer num3 = this.travelboostRemains;
        Long l10 = this.travelboostStatus;
        Long l11 = this.exposureEnd;
        return "SuperBoostRemainAssetsResult(superboostRemains=" + ((Object) num) + ", targetedSuperboostRemains=" + ((Object) num2) + ", travelboostRemains=" + ((Object) num3) + ", travelboostStatus=" + ((Object) l10) + ", exposureEnd=" + ((Object) l11) + ", extraCountInfo=" + this.extraCountInfo + ")";
    }

    public /* synthetic */ SuperBoostRemainAssetsResult(Integer num, Integer num2, Integer num3, Long l10, Long l11, String str, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : num, (i10 & 2) != 0 ? null : num2, (i10 & 4) != 0 ? null : num3, (i10 & 8) != 0 ? null : l10, (i10 & 16) != 0 ? null : l11, (i10 & 32) != 0 ? null : str);
    }
}
