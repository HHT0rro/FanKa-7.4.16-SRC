package com.qq.e.comm.pi;

import com.qq.e.ads.nativ.ADSize;
import com.qq.e.comm.adevent.ADListener;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface NEADVI extends LADI {
    void destroy();

    void preloadVideo();

    void render();

    void reportAdNegative();

    void setAdListener(ADListener aDListener);

    void setAdSize(ADSize aDSize);
}
