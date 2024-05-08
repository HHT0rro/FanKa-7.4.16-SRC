package com.kwad.components.ad.interstitial.report.realtime.model;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.commercial.c.a;
import java.io.Serializable;

@KsJson
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class InterstitialRealTimeInfo extends a implements Serializable {
    public String materialUrl;
    public long monitorIndex;
    public long renderType;

    public void setMaterialUrl(String str) {
        this.materialUrl = str;
    }

    public void setRenderType(long j10) {
        this.renderType = j10;
    }
}
