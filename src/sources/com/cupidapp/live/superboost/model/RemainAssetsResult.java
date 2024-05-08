package com.cupidapp.live.superboost.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RemainAssetsResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class RemainAssetsResult {

    @Nullable
    private final Long exposureEnd;

    @Nullable
    private final Integer remains;

    public RemainAssetsResult() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public RemainAssetsResult(@Nullable Integer num, @Nullable Long l10) {
        this.remains = num;
        this.exposureEnd = l10;
    }

    public static /* synthetic */ RemainAssetsResult copy$default(RemainAssetsResult remainAssetsResult, Integer num, Long l10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = remainAssetsResult.remains;
        }
        if ((i10 & 2) != 0) {
            l10 = remainAssetsResult.exposureEnd;
        }
        return remainAssetsResult.copy(num, l10);
    }

    @Nullable
    public final Integer component1() {
        return this.remains;
    }

    @Nullable
    public final Long component2() {
        return this.exposureEnd;
    }

    @NotNull
    public final RemainAssetsResult copy(@Nullable Integer num, @Nullable Long l10) {
        return new RemainAssetsResult(num, l10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RemainAssetsResult)) {
            return false;
        }
        RemainAssetsResult remainAssetsResult = (RemainAssetsResult) obj;
        return s.d(this.remains, remainAssetsResult.remains) && s.d(this.exposureEnd, remainAssetsResult.exposureEnd);
    }

    @Nullable
    public final Long getExposureEnd() {
        return this.exposureEnd;
    }

    @Nullable
    public final Integer getRemains() {
        return this.remains;
    }

    public int hashCode() {
        Integer num = this.remains;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Long l10 = this.exposureEnd;
        return hashCode + (l10 != null ? l10.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "RemainAssetsResult(remains=" + ((Object) this.remains) + ", exposureEnd=" + ((Object) this.exposureEnd) + ")";
    }

    public /* synthetic */ RemainAssetsResult(Integer num, Long l10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : num, (i10 & 2) != 0 ? null : l10);
    }
}
