package com.qq.e.ads.nativ;

import com.qq.e.comm.util.AdError;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface NativeADEventListener {
    void onADClicked();

    void onADError(AdError adError);

    void onADExposed();

    void onADStatusChanged();
}
