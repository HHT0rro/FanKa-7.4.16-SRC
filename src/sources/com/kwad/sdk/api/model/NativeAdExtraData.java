package com.kwad.sdk.api.model;

import androidx.annotation.Keep;

@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class NativeAdExtraData {
    private boolean enableShake;
    private int showLiveStatus;
    private int showLiveStyle;

    public int getShowLiveStatus() {
        return this.showLiveStatus;
    }

    public int getShowLiveStyle() {
        return this.showLiveStyle;
    }

    public boolean isEnableShake() {
        return this.enableShake;
    }

    public NativeAdExtraData setEnableShake(boolean z10) {
        this.enableShake = z10;
        return this;
    }

    public NativeAdExtraData setShowLiveStatus(int i10) {
        this.showLiveStatus = i10;
        return this;
    }

    public NativeAdExtraData setShowLiveStyle(int i10) {
        this.showLiveStyle = i10;
        return this;
    }
}
