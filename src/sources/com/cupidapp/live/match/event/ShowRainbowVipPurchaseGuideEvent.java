package com.cupidapp.live.match.event;

import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: MatchEvent.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ShowRainbowVipPurchaseGuideEvent {

    @NotNull
    private final VipPurchaseEntranceType entranceType;

    public ShowRainbowVipPurchaseGuideEvent(@NotNull VipPurchaseEntranceType entranceType) {
        s.i(entranceType, "entranceType");
        this.entranceType = entranceType;
    }

    @NotNull
    public final VipPurchaseEntranceType getEntranceType() {
        return this.entranceType;
    }
}
