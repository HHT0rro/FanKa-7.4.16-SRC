package com.jd.ad.sdk.jad_js;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_kx implements Callable<jad_sf<jad_jt>> {
    public final /* synthetic */ WeakReference jad_an;
    public final /* synthetic */ Context jad_bo;
    public final /* synthetic */ int jad_cp;
    public final /* synthetic */ String jad_dq;

    public jad_kx(WeakReference weakReference, Context context, int i10, String str) {
        this.jad_an = weakReference;
        this.jad_bo = context;
        this.jad_cp = i10;
        this.jad_dq = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.Callable
    public jad_sf<jad_jt> call() {
        Context context = (Context) this.jad_an.get();
        if (context == null) {
            context = this.jad_bo;
        }
        return jad_hu.jad_an(context, this.jad_cp, this.jad_dq);
    }
}
