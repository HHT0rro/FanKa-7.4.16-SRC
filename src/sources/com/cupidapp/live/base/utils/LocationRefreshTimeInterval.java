package com.cupidapp.live.base.utils;

import com.bytedance.sdk.openadsdk.TTAdConstant;

/* compiled from: LocationUtils.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum LocationRefreshTimeInterval {
    NearbyInterval(com.huawei.openalliance.ad.constant.u.as),
    NearbyLiveInterval(TTAdConstant.AD_MAX_EVENT_TIME),
    ReturnFromBackgroundInterval(com.huawei.openalliance.ad.constant.u.as);

    private final long interval;

    LocationRefreshTimeInterval(long j10) {
        this.interval = j10;
    }

    public final long getInterval() {
        return this.interval;
    }
}
