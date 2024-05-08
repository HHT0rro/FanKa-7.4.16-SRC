package com.cupidapp.live.vip.model;

import com.cupidapp.live.match.model.MatchSettingResult;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VipPurchasePriceModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VipDiscountAndMatchSettingResult {

    @Nullable
    private final MatchSettingResult matchSetting;

    @Nullable
    private final VipDiscountDescriptionResult vipDiscount;

    public VipDiscountAndMatchSettingResult(@Nullable VipDiscountDescriptionResult vipDiscountDescriptionResult, @Nullable MatchSettingResult matchSettingResult) {
        this.vipDiscount = vipDiscountDescriptionResult;
        this.matchSetting = matchSettingResult;
    }

    public static /* synthetic */ VipDiscountAndMatchSettingResult copy$default(VipDiscountAndMatchSettingResult vipDiscountAndMatchSettingResult, VipDiscountDescriptionResult vipDiscountDescriptionResult, MatchSettingResult matchSettingResult, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            vipDiscountDescriptionResult = vipDiscountAndMatchSettingResult.vipDiscount;
        }
        if ((i10 & 2) != 0) {
            matchSettingResult = vipDiscountAndMatchSettingResult.matchSetting;
        }
        return vipDiscountAndMatchSettingResult.copy(vipDiscountDescriptionResult, matchSettingResult);
    }

    @Nullable
    public final VipDiscountDescriptionResult component1() {
        return this.vipDiscount;
    }

    @Nullable
    public final MatchSettingResult component2() {
        return this.matchSetting;
    }

    @NotNull
    public final VipDiscountAndMatchSettingResult copy(@Nullable VipDiscountDescriptionResult vipDiscountDescriptionResult, @Nullable MatchSettingResult matchSettingResult) {
        return new VipDiscountAndMatchSettingResult(vipDiscountDescriptionResult, matchSettingResult);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VipDiscountAndMatchSettingResult)) {
            return false;
        }
        VipDiscountAndMatchSettingResult vipDiscountAndMatchSettingResult = (VipDiscountAndMatchSettingResult) obj;
        return s.d(this.vipDiscount, vipDiscountAndMatchSettingResult.vipDiscount) && s.d(this.matchSetting, vipDiscountAndMatchSettingResult.matchSetting);
    }

    @Nullable
    public final MatchSettingResult getMatchSetting() {
        return this.matchSetting;
    }

    @Nullable
    public final VipDiscountDescriptionResult getVipDiscount() {
        return this.vipDiscount;
    }

    public int hashCode() {
        VipDiscountDescriptionResult vipDiscountDescriptionResult = this.vipDiscount;
        int hashCode = (vipDiscountDescriptionResult == null ? 0 : vipDiscountDescriptionResult.hashCode()) * 31;
        MatchSettingResult matchSettingResult = this.matchSetting;
        return hashCode + (matchSettingResult != null ? matchSettingResult.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "VipDiscountAndMatchSettingResult(vipDiscount=" + ((Object) this.vipDiscount) + ", matchSetting=" + ((Object) this.matchSetting) + ")";
    }
}
