package com.jd.ad.sdk.bl.exposuremonitor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface JADExposureListener {
    void onDelayExposure(long j10, String str, int i10);

    void onExposure(String str);

    void onFinishExposure();

    void onPreExposure(String str);
}
