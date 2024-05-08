package com.cupidapp.live.base.network.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConstantsResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MaskPartyAddTimesModel {
    private final int svipDailyAdditionalTimes;
    private final int vipDailyAdditionalTimes;

    public MaskPartyAddTimesModel(int i10, int i11) {
        this.vipDailyAdditionalTimes = i10;
        this.svipDailyAdditionalTimes = i11;
    }

    public static /* synthetic */ MaskPartyAddTimesModel copy$default(MaskPartyAddTimesModel maskPartyAddTimesModel, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = maskPartyAddTimesModel.vipDailyAdditionalTimes;
        }
        if ((i12 & 2) != 0) {
            i11 = maskPartyAddTimesModel.svipDailyAdditionalTimes;
        }
        return maskPartyAddTimesModel.copy(i10, i11);
    }

    public final int component1() {
        return this.vipDailyAdditionalTimes;
    }

    public final int component2() {
        return this.svipDailyAdditionalTimes;
    }

    @NotNull
    public final MaskPartyAddTimesModel copy(int i10, int i11) {
        return new MaskPartyAddTimesModel(i10, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MaskPartyAddTimesModel)) {
            return false;
        }
        MaskPartyAddTimesModel maskPartyAddTimesModel = (MaskPartyAddTimesModel) obj;
        return this.vipDailyAdditionalTimes == maskPartyAddTimesModel.vipDailyAdditionalTimes && this.svipDailyAdditionalTimes == maskPartyAddTimesModel.svipDailyAdditionalTimes;
    }

    public final int getSvipDailyAdditionalTimes() {
        return this.svipDailyAdditionalTimes;
    }

    public final int getVipDailyAdditionalTimes() {
        return this.vipDailyAdditionalTimes;
    }

    public int hashCode() {
        return (this.vipDailyAdditionalTimes * 31) + this.svipDailyAdditionalTimes;
    }

    @NotNull
    public String toString() {
        return "MaskPartyAddTimesModel(vipDailyAdditionalTimes=" + this.vipDailyAdditionalTimes + ", svipDailyAdditionalTimes=" + this.svipDailyAdditionalTimes + ")";
    }
}
