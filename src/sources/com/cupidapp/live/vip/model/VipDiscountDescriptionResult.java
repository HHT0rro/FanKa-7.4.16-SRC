package com.cupidapp.live.vip.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VipPurchasePriceModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VipDiscountDescriptionResult {

    @Nullable
    private final String description;

    public VipDiscountDescriptionResult(@Nullable String str) {
        this.description = str;
    }

    public static /* synthetic */ VipDiscountDescriptionResult copy$default(VipDiscountDescriptionResult vipDiscountDescriptionResult, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = vipDiscountDescriptionResult.description;
        }
        return vipDiscountDescriptionResult.copy(str);
    }

    @Nullable
    public final String component1() {
        return this.description;
    }

    @NotNull
    public final VipDiscountDescriptionResult copy(@Nullable String str) {
        return new VipDiscountDescriptionResult(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof VipDiscountDescriptionResult) && s.d(this.description, ((VipDiscountDescriptionResult) obj).description);
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    public int hashCode() {
        String str = this.description;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @NotNull
    public String toString() {
        return "VipDiscountDescriptionResult(description=" + this.description + ")";
    }
}
