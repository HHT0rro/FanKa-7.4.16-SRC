package com.kwad.sdk.api.model;

import androidx.annotation.Keep;

@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class AdExposureFailedReason {
    public String adnName;
    public int adnType;
    public int winEcpm;

    public AdExposureFailedReason setAdnName(String str) {
        this.adnName = str;
        return this;
    }

    public AdExposureFailedReason setAdnType(int i10) {
        this.adnType = i10;
        return this;
    }

    public AdExposureFailedReason setWinEcpm(int i10) {
        this.winEcpm = i10;
        return this;
    }
}
