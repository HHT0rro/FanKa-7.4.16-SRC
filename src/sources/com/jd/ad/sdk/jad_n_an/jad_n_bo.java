package com.jd.ad.sdk.jad_n_an;

import android.view.View;

/* compiled from: JADNativeCountDownController.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_n_bo implements View.OnAttachStateChangeListener {
    public final /* synthetic */ jad_n_an jad_n_an;

    public jad_n_bo(jad_n_an jad_n_anVar) {
        this.jad_n_an = jad_n_anVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.jad_n_an.jad_n_an();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.jad_n_an.jad_n_bo();
    }
}
