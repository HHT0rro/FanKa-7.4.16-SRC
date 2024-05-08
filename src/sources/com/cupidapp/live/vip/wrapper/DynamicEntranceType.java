package com.cupidapp.live.vip.wrapper;

import org.jetbrains.annotations.NotNull;

/* compiled from: VipPurchaseEntranceType.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum DynamicEntranceType {
    Nearby("nearby"),
    CustomHide("customHide"),
    MapLookingSomeone("mapLookingSomeone"),
    FastCancelFollow("fastCancelFollow"),
    SpecialExposure("specialExposure");


    @NotNull
    private final String from;

    DynamicEntranceType(String str) {
        this.from = str;
    }

    @NotNull
    public final String getFrom() {
        return this.from;
    }
}
