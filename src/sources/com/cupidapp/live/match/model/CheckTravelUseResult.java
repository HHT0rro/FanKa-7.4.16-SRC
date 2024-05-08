package com.cupidapp.live.match.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TravelMapModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class CheckTravelUseResult {
    private final int travelDefaultTimes;

    @Nullable
    private final Integer travelboostLimit;
    private final int travelboostRemains;

    @Nullable
    private final String travelboostUseInfo;

    public CheckTravelUseResult(int i10, int i11, @Nullable Integer num, @Nullable String str) {
        this.travelboostRemains = i10;
        this.travelDefaultTimes = i11;
        this.travelboostLimit = num;
        this.travelboostUseInfo = str;
    }

    public static /* synthetic */ CheckTravelUseResult copy$default(CheckTravelUseResult checkTravelUseResult, int i10, int i11, Integer num, String str, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = checkTravelUseResult.travelboostRemains;
        }
        if ((i12 & 2) != 0) {
            i11 = checkTravelUseResult.travelDefaultTimes;
        }
        if ((i12 & 4) != 0) {
            num = checkTravelUseResult.travelboostLimit;
        }
        if ((i12 & 8) != 0) {
            str = checkTravelUseResult.travelboostUseInfo;
        }
        return checkTravelUseResult.copy(i10, i11, num, str);
    }

    public final int component1() {
        return this.travelboostRemains;
    }

    public final int component2() {
        return this.travelDefaultTimes;
    }

    @Nullable
    public final Integer component3() {
        return this.travelboostLimit;
    }

    @Nullable
    public final String component4() {
        return this.travelboostUseInfo;
    }

    @NotNull
    public final CheckTravelUseResult copy(int i10, int i11, @Nullable Integer num, @Nullable String str) {
        return new CheckTravelUseResult(i10, i11, num, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CheckTravelUseResult)) {
            return false;
        }
        CheckTravelUseResult checkTravelUseResult = (CheckTravelUseResult) obj;
        return this.travelboostRemains == checkTravelUseResult.travelboostRemains && this.travelDefaultTimes == checkTravelUseResult.travelDefaultTimes && s.d(this.travelboostLimit, checkTravelUseResult.travelboostLimit) && s.d(this.travelboostUseInfo, checkTravelUseResult.travelboostUseInfo);
    }

    public final int getTravelDefaultTimes() {
        return this.travelDefaultTimes;
    }

    @Nullable
    public final Integer getTravelboostLimit() {
        return this.travelboostLimit;
    }

    public final int getTravelboostRemains() {
        return this.travelboostRemains;
    }

    @Nullable
    public final String getTravelboostUseInfo() {
        return this.travelboostUseInfo;
    }

    public int hashCode() {
        int i10 = ((this.travelboostRemains * 31) + this.travelDefaultTimes) * 31;
        Integer num = this.travelboostLimit;
        int hashCode = (i10 + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.travelboostUseInfo;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        int i10 = this.travelboostRemains;
        int i11 = this.travelDefaultTimes;
        Integer num = this.travelboostLimit;
        return "CheckTravelUseResult(travelboostRemains=" + i10 + ", travelDefaultTimes=" + i11 + ", travelboostLimit=" + ((Object) num) + ", travelboostUseInfo=" + this.travelboostUseInfo + ")";
    }
}
