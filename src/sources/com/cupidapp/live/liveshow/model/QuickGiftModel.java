package com.cupidapp.live.liveshow.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class QuickGiftModel implements Serializable {

    @Nullable
    private Integer discountedPrice;

    @NotNull
    private final GiftModel gift;

    public QuickGiftModel(@NotNull GiftModel gift, @Nullable Integer num) {
        s.i(gift, "gift");
        this.gift = gift;
        this.discountedPrice = num;
    }

    @Nullable
    public final Integer getDiscountedPrice() {
        return this.discountedPrice;
    }

    @NotNull
    public final GiftModel getGift() {
        return this.gift;
    }

    public final void setDiscountedPrice(@Nullable Integer num) {
        this.discountedPrice = num;
    }
}
