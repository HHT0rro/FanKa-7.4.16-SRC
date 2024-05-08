package com.cupidapp.live.vip.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VipPurchasePriceModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VipOptionsCombineModel {

    @Nullable
    private final VipOptionsModel normalVip;

    @Nullable
    private final VipOptionsModel rainbowVip;

    @Nullable
    private final VipOptionsModel sVip;

    @Nullable
    private final VipStrategyModel strategy;

    @Nullable
    private final VipOptionsModel visitor;

    public VipOptionsCombineModel(@Nullable VipStrategyModel vipStrategyModel, @Nullable VipOptionsModel vipOptionsModel, @Nullable VipOptionsModel vipOptionsModel2, @Nullable VipOptionsModel vipOptionsModel3, @Nullable VipOptionsModel vipOptionsModel4) {
        this.strategy = vipStrategyModel;
        this.normalVip = vipOptionsModel;
        this.sVip = vipOptionsModel2;
        this.rainbowVip = vipOptionsModel3;
        this.visitor = vipOptionsModel4;
    }

    public static /* synthetic */ VipOptionsCombineModel copy$default(VipOptionsCombineModel vipOptionsCombineModel, VipStrategyModel vipStrategyModel, VipOptionsModel vipOptionsModel, VipOptionsModel vipOptionsModel2, VipOptionsModel vipOptionsModel3, VipOptionsModel vipOptionsModel4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            vipStrategyModel = vipOptionsCombineModel.strategy;
        }
        if ((i10 & 2) != 0) {
            vipOptionsModel = vipOptionsCombineModel.normalVip;
        }
        VipOptionsModel vipOptionsModel5 = vipOptionsModel;
        if ((i10 & 4) != 0) {
            vipOptionsModel2 = vipOptionsCombineModel.sVip;
        }
        VipOptionsModel vipOptionsModel6 = vipOptionsModel2;
        if ((i10 & 8) != 0) {
            vipOptionsModel3 = vipOptionsCombineModel.rainbowVip;
        }
        VipOptionsModel vipOptionsModel7 = vipOptionsModel3;
        if ((i10 & 16) != 0) {
            vipOptionsModel4 = vipOptionsCombineModel.visitor;
        }
        return vipOptionsCombineModel.copy(vipStrategyModel, vipOptionsModel5, vipOptionsModel6, vipOptionsModel7, vipOptionsModel4);
    }

    @Nullable
    public final VipStrategyModel component1() {
        return this.strategy;
    }

    @Nullable
    public final VipOptionsModel component2() {
        return this.normalVip;
    }

    @Nullable
    public final VipOptionsModel component3() {
        return this.sVip;
    }

    @Nullable
    public final VipOptionsModel component4() {
        return this.rainbowVip;
    }

    @Nullable
    public final VipOptionsModel component5() {
        return this.visitor;
    }

    @NotNull
    public final VipOptionsCombineModel copy(@Nullable VipStrategyModel vipStrategyModel, @Nullable VipOptionsModel vipOptionsModel, @Nullable VipOptionsModel vipOptionsModel2, @Nullable VipOptionsModel vipOptionsModel3, @Nullable VipOptionsModel vipOptionsModel4) {
        return new VipOptionsCombineModel(vipStrategyModel, vipOptionsModel, vipOptionsModel2, vipOptionsModel3, vipOptionsModel4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VipOptionsCombineModel)) {
            return false;
        }
        VipOptionsCombineModel vipOptionsCombineModel = (VipOptionsCombineModel) obj;
        return s.d(this.strategy, vipOptionsCombineModel.strategy) && s.d(this.normalVip, vipOptionsCombineModel.normalVip) && s.d(this.sVip, vipOptionsCombineModel.sVip) && s.d(this.rainbowVip, vipOptionsCombineModel.rainbowVip) && s.d(this.visitor, vipOptionsCombineModel.visitor);
    }

    @Nullable
    public final VipOptionsModel getNormalVip() {
        return this.normalVip;
    }

    @Nullable
    public final VipOptionsModel getRainbowVip() {
        return this.rainbowVip;
    }

    @Nullable
    public final VipOptionsModel getSVip() {
        return this.sVip;
    }

    @Nullable
    public final VipStrategyModel getStrategy() {
        return this.strategy;
    }

    @Nullable
    public final VipOptionsModel getVisitor() {
        return this.visitor;
    }

    public int hashCode() {
        VipStrategyModel vipStrategyModel = this.strategy;
        int hashCode = (vipStrategyModel == null ? 0 : vipStrategyModel.hashCode()) * 31;
        VipOptionsModel vipOptionsModel = this.normalVip;
        int hashCode2 = (hashCode + (vipOptionsModel == null ? 0 : vipOptionsModel.hashCode())) * 31;
        VipOptionsModel vipOptionsModel2 = this.sVip;
        int hashCode3 = (hashCode2 + (vipOptionsModel2 == null ? 0 : vipOptionsModel2.hashCode())) * 31;
        VipOptionsModel vipOptionsModel3 = this.rainbowVip;
        int hashCode4 = (hashCode3 + (vipOptionsModel3 == null ? 0 : vipOptionsModel3.hashCode())) * 31;
        VipOptionsModel vipOptionsModel4 = this.visitor;
        return hashCode4 + (vipOptionsModel4 != null ? vipOptionsModel4.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "VipOptionsCombineModel(strategy=" + ((Object) this.strategy) + ", normalVip=" + ((Object) this.normalVip) + ", sVip=" + ((Object) this.sVip) + ", rainbowVip=" + ((Object) this.rainbowVip) + ", visitor=" + ((Object) this.visitor) + ")";
    }

    public /* synthetic */ VipOptionsCombineModel(VipStrategyModel vipStrategyModel, VipOptionsModel vipOptionsModel, VipOptionsModel vipOptionsModel2, VipOptionsModel vipOptionsModel3, VipOptionsModel vipOptionsModel4, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(vipStrategyModel, vipOptionsModel, vipOptionsModel2, vipOptionsModel3, (i10 & 16) != 0 ? null : vipOptionsModel4);
    }
}
