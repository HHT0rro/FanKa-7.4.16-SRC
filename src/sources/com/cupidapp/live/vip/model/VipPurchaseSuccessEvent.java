package com.cupidapp.live.vip.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VipPurchaseSuccessEvent.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VipPurchaseSuccessEvent {

    @NotNull
    private final VipType vipType;

    public VipPurchaseSuccessEvent(@NotNull VipType vipType) {
        s.i(vipType, "vipType");
        this.vipType = vipType;
    }

    public static /* synthetic */ VipPurchaseSuccessEvent copy$default(VipPurchaseSuccessEvent vipPurchaseSuccessEvent, VipType vipType, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            vipType = vipPurchaseSuccessEvent.vipType;
        }
        return vipPurchaseSuccessEvent.copy(vipType);
    }

    @NotNull
    public final VipType component1() {
        return this.vipType;
    }

    @NotNull
    public final VipPurchaseSuccessEvent copy(@NotNull VipType vipType) {
        s.i(vipType, "vipType");
        return new VipPurchaseSuccessEvent(vipType);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof VipPurchaseSuccessEvent) && this.vipType == ((VipPurchaseSuccessEvent) obj).vipType;
    }

    @NotNull
    public final VipType getVipType() {
        return this.vipType;
    }

    public int hashCode() {
        return this.vipType.hashCode();
    }

    @NotNull
    public String toString() {
        return "VipPurchaseSuccessEvent(vipType=" + ((Object) this.vipType) + ")";
    }
}
