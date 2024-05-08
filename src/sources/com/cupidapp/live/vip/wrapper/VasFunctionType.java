package com.cupidapp.live.vip.wrapper;

/* compiled from: VipPurchaseEntranceType.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum VasFunctionType {
    VIP(1),
    VISITOR(3),
    SVIP(5),
    SUPER_LIKE(6),
    SUPER_BOOST(7),
    PROP_CARD(8),
    SSVIP(9);

    private final int value;

    VasFunctionType(int i10) {
        this.value = i10;
    }

    public final int getValue() {
        return this.value;
    }
}
