package com.cupidapp.live.vip.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VipPurchasePriceModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VipStrategyModel {

    @Nullable
    private final Boolean showPopup;

    @Nullable
    private final List<String> skuCodes;

    @Nullable
    private final Integer type;

    public VipStrategyModel(@Nullable Boolean bool, @Nullable List<String> list, @Nullable Integer num) {
        this.showPopup = bool;
        this.skuCodes = list;
        this.type = num;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VipStrategyModel copy$default(VipStrategyModel vipStrategyModel, Boolean bool, List list, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            bool = vipStrategyModel.showPopup;
        }
        if ((i10 & 2) != 0) {
            list = vipStrategyModel.skuCodes;
        }
        if ((i10 & 4) != 0) {
            num = vipStrategyModel.type;
        }
        return vipStrategyModel.copy(bool, list, num);
    }

    @Nullable
    public final Boolean component1() {
        return this.showPopup;
    }

    @Nullable
    public final List<String> component2() {
        return this.skuCodes;
    }

    @Nullable
    public final Integer component3() {
        return this.type;
    }

    @NotNull
    public final VipStrategyModel copy(@Nullable Boolean bool, @Nullable List<String> list, @Nullable Integer num) {
        return new VipStrategyModel(bool, list, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VipStrategyModel)) {
            return false;
        }
        VipStrategyModel vipStrategyModel = (VipStrategyModel) obj;
        return s.d(this.showPopup, vipStrategyModel.showPopup) && s.d(this.skuCodes, vipStrategyModel.skuCodes) && s.d(this.type, vipStrategyModel.type);
    }

    @Nullable
    public final Boolean getShowPopup() {
        return this.showPopup;
    }

    @Nullable
    public final List<String> getSkuCodes() {
        return this.skuCodes;
    }

    @Nullable
    public final Integer getType() {
        return this.type;
    }

    public int hashCode() {
        Boolean bool = this.showPopup;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        List<String> list = this.skuCodes;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        Integer num = this.type;
        return hashCode2 + (num != null ? num.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "VipStrategyModel(showPopup=" + ((Object) this.showPopup) + ", skuCodes=" + ((Object) this.skuCodes) + ", type=" + ((Object) this.type) + ")";
    }
}
