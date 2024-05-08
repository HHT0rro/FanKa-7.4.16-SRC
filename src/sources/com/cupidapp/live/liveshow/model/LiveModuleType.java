package com.cupidapp.live.liveshow.model;

import kotlin.d;

/* compiled from: FKLiveListResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum LiveModuleType {
    HorizontalSlipType(0),
    SquareCardType(1),
    AdBannerType(2),
    BigImageOrStreamType(3),
    BigHorizontalSlipType(4),
    NearbyHorizontalSlipType(5);

    private final int type;

    LiveModuleType(int i10) {
        this.type = i10;
    }

    public final int getType() {
        return this.type;
    }
}
