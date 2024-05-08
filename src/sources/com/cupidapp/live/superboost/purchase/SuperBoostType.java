package com.cupidapp.live.superboost.purchase;

import com.cupidapp.live.R$mipmap;
import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: SuperBoostPurchaseLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum SuperBoostType {
    DIRECT("DIRECT", R$mipmap.ic_direct_super_boost),
    NON_DIRECT("NON_DIRECT", R$mipmap.ic_purchase_exposure),
    TRAVEL("TRAVEL", R$mipmap.ic_travel_exposure);

    private final int purchaseImg;

    @NotNull
    private final String value;

    SuperBoostType(String str, int i10) {
        this.value = str;
        this.purchaseImg = i10;
    }

    public final int getPurchaseImg() {
        return this.purchaseImg;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
