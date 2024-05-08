package com.kwad.components.ad.reward.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public enum EcOrderCardStyle {
    SPIKE_AND_COUPON(1),
    SPIKE(2),
    COUPON(3),
    NO_SPIKE_AND_NO_COUPON(4),
    DEFAULT(5);

    private int value;

    EcOrderCardStyle(int i10) {
        this.value = i10;
    }

    @Nullable
    public static EcOrderCardStyle createFromAdInfo(AdInfo adInfo) {
        if (!(com.kwad.components.ad.reward.a.b.k(adInfo) || com.kwad.components.ad.reward.a.b.j(adInfo))) {
            return null;
        }
        AdProductInfo cP = com.kwad.sdk.core.response.b.a.cP(adInfo);
        boolean hasSpike = cP.hasSpike();
        boolean hasCoupon = cP.hasCoupon();
        boolean hasOriginalPrice = cP.hasOriginalPrice();
        if (hasSpike && hasCoupon) {
            return SPIKE_AND_COUPON;
        }
        if (hasSpike) {
            return SPIKE;
        }
        if (hasCoupon) {
            return COUPON;
        }
        if (hasOriginalPrice) {
            return NO_SPIKE_AND_NO_COUPON;
        }
        return DEFAULT;
    }

    public final int getValue() {
        return this.value;
    }
}
