package com.cupidapp.live.match.fragment;

import com.cupidapp.live.base.sensorslog.SensorPosition;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchFilterFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MatchFilterTransModel implements Serializable {
    private final boolean backToMainActivity;

    @Nullable
    private final String defaultTab;
    private final boolean fromNearBy;
    private final boolean needPurchaseFirst;

    @NotNull
    private final SensorPosition sensorPosition;

    public MatchFilterTransModel(boolean z10, boolean z11, @Nullable String str, @NotNull SensorPosition sensorPosition, boolean z12) {
        kotlin.jvm.internal.s.i(sensorPosition, "sensorPosition");
        this.fromNearBy = z10;
        this.backToMainActivity = z11;
        this.defaultTab = str;
        this.sensorPosition = sensorPosition;
        this.needPurchaseFirst = z12;
    }

    public static /* synthetic */ MatchFilterTransModel copy$default(MatchFilterTransModel matchFilterTransModel, boolean z10, boolean z11, String str, SensorPosition sensorPosition, boolean z12, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = matchFilterTransModel.fromNearBy;
        }
        if ((i10 & 2) != 0) {
            z11 = matchFilterTransModel.backToMainActivity;
        }
        boolean z13 = z11;
        if ((i10 & 4) != 0) {
            str = matchFilterTransModel.defaultTab;
        }
        String str2 = str;
        if ((i10 & 8) != 0) {
            sensorPosition = matchFilterTransModel.sensorPosition;
        }
        SensorPosition sensorPosition2 = sensorPosition;
        if ((i10 & 16) != 0) {
            z12 = matchFilterTransModel.needPurchaseFirst;
        }
        return matchFilterTransModel.copy(z10, z13, str2, sensorPosition2, z12);
    }

    public final boolean component1() {
        return this.fromNearBy;
    }

    public final boolean component2() {
        return this.backToMainActivity;
    }

    @Nullable
    public final String component3() {
        return this.defaultTab;
    }

    @NotNull
    public final SensorPosition component4() {
        return this.sensorPosition;
    }

    public final boolean component5() {
        return this.needPurchaseFirst;
    }

    @NotNull
    public final MatchFilterTransModel copy(boolean z10, boolean z11, @Nullable String str, @NotNull SensorPosition sensorPosition, boolean z12) {
        kotlin.jvm.internal.s.i(sensorPosition, "sensorPosition");
        return new MatchFilterTransModel(z10, z11, str, sensorPosition, z12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MatchFilterTransModel)) {
            return false;
        }
        MatchFilterTransModel matchFilterTransModel = (MatchFilterTransModel) obj;
        return this.fromNearBy == matchFilterTransModel.fromNearBy && this.backToMainActivity == matchFilterTransModel.backToMainActivity && kotlin.jvm.internal.s.d(this.defaultTab, matchFilterTransModel.defaultTab) && this.sensorPosition == matchFilterTransModel.sensorPosition && this.needPurchaseFirst == matchFilterTransModel.needPurchaseFirst;
    }

    public final boolean getBackToMainActivity() {
        return this.backToMainActivity;
    }

    @Nullable
    public final String getDefaultTab() {
        return this.defaultTab;
    }

    public final boolean getFromNearBy() {
        return this.fromNearBy;
    }

    public final boolean getNeedPurchaseFirst() {
        return this.needPurchaseFirst;
    }

    @NotNull
    public final SensorPosition getSensorPosition() {
        return this.sensorPosition;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    public int hashCode() {
        boolean z10 = this.fromNearBy;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i10 = r02 * 31;
        ?? r22 = this.backToMainActivity;
        int i11 = r22;
        if (r22 != 0) {
            i11 = 1;
        }
        int i12 = (i10 + i11) * 31;
        String str = this.defaultTab;
        int hashCode = (((i12 + (str == null ? 0 : str.hashCode())) * 31) + this.sensorPosition.hashCode()) * 31;
        boolean z11 = this.needPurchaseFirst;
        return hashCode + (z11 ? 1 : z11 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        boolean z10 = this.fromNearBy;
        boolean z11 = this.backToMainActivity;
        String str = this.defaultTab;
        SensorPosition sensorPosition = this.sensorPosition;
        return "MatchFilterTransModel(fromNearBy=" + z10 + ", backToMainActivity=" + z11 + ", defaultTab=" + str + ", sensorPosition=" + ((Object) sensorPosition) + ", needPurchaseFirst=" + this.needPurchaseFirst + ")";
    }

    public /* synthetic */ MatchFilterTransModel(boolean z10, boolean z11, String str, SensorPosition sensorPosition, boolean z12, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(z10, z11, (i10 & 4) != 0 ? null : str, sensorPosition, z12);
    }
}
