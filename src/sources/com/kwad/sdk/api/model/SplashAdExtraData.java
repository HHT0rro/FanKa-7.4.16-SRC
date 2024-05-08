package com.kwad.sdk.api.model;

import androidx.annotation.Keep;

@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class SplashAdExtraData {
    private boolean isDisableRotate;
    private boolean isDisableShake;
    private boolean isDisableSlide;

    public boolean getDisableRotateStatus() {
        return this.isDisableRotate;
    }

    public boolean getDisableShakeStatus() {
        return this.isDisableShake;
    }

    public boolean getDisableSlideStatus() {
        return this.isDisableSlide;
    }

    public void setDisableRotateStatus(boolean z10) {
        this.isDisableRotate = z10;
    }

    public void setDisableShakeStatus(boolean z10) {
        this.isDisableShake = z10;
    }

    public void setDisableSlideStatus(boolean z10) {
        this.isDisableSlide = z10;
    }
}
