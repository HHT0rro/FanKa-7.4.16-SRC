package com.qq.e.ads.nativ;

import android.view.View;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class NativeADEventListenerWithClickInfo implements NativeADEventListener {
    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public final void onADClicked() {
    }

    public abstract void onADClicked(View view);
}
