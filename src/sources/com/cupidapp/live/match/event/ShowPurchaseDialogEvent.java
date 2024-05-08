package com.cupidapp.live.match.event;

import com.cupidapp.live.match.model.PurchaseProductType;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchEvent.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ShowPurchaseDialogEvent {

    @NotNull
    private final VipPurchaseEntranceType entranceType;

    @NotNull
    private final PurchaseProductType productType;

    @Nullable
    private final String sensorFrom;

    public ShowPurchaseDialogEvent(@NotNull VipPurchaseEntranceType entranceType, @Nullable String str, @NotNull PurchaseProductType productType) {
        s.i(entranceType, "entranceType");
        s.i(productType, "productType");
        this.entranceType = entranceType;
        this.sensorFrom = str;
        this.productType = productType;
    }

    public static /* synthetic */ ShowPurchaseDialogEvent copy$default(ShowPurchaseDialogEvent showPurchaseDialogEvent, VipPurchaseEntranceType vipPurchaseEntranceType, String str, PurchaseProductType purchaseProductType, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            vipPurchaseEntranceType = showPurchaseDialogEvent.entranceType;
        }
        if ((i10 & 2) != 0) {
            str = showPurchaseDialogEvent.sensorFrom;
        }
        if ((i10 & 4) != 0) {
            purchaseProductType = showPurchaseDialogEvent.productType;
        }
        return showPurchaseDialogEvent.copy(vipPurchaseEntranceType, str, purchaseProductType);
    }

    @NotNull
    public final VipPurchaseEntranceType component1() {
        return this.entranceType;
    }

    @Nullable
    public final String component2() {
        return this.sensorFrom;
    }

    @NotNull
    public final PurchaseProductType component3() {
        return this.productType;
    }

    @NotNull
    public final ShowPurchaseDialogEvent copy(@NotNull VipPurchaseEntranceType entranceType, @Nullable String str, @NotNull PurchaseProductType productType) {
        s.i(entranceType, "entranceType");
        s.i(productType, "productType");
        return new ShowPurchaseDialogEvent(entranceType, str, productType);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShowPurchaseDialogEvent)) {
            return false;
        }
        ShowPurchaseDialogEvent showPurchaseDialogEvent = (ShowPurchaseDialogEvent) obj;
        return this.entranceType == showPurchaseDialogEvent.entranceType && s.d(this.sensorFrom, showPurchaseDialogEvent.sensorFrom) && this.productType == showPurchaseDialogEvent.productType;
    }

    @NotNull
    public final VipPurchaseEntranceType getEntranceType() {
        return this.entranceType;
    }

    @NotNull
    public final PurchaseProductType getProductType() {
        return this.productType;
    }

    @Nullable
    public final String getSensorFrom() {
        return this.sensorFrom;
    }

    public int hashCode() {
        int hashCode = this.entranceType.hashCode() * 31;
        String str = this.sensorFrom;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.productType.hashCode();
    }

    @NotNull
    public String toString() {
        VipPurchaseEntranceType vipPurchaseEntranceType = this.entranceType;
        return "ShowPurchaseDialogEvent(entranceType=" + ((Object) vipPurchaseEntranceType) + ", sensorFrom=" + this.sensorFrom + ", productType=" + ((Object) this.productType) + ")";
    }
}
