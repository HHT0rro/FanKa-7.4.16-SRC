package com.jd.ad.sdk.jad_js;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_tg implements Runnable {
    public final /* synthetic */ jad_uh jad_an;

    public jad_tg(jad_uh jad_uhVar) {
        this.jad_an = jad_uhVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public void run() {
        if (this.jad_an.jad_dq == null) {
            return;
        }
        jad_sf<T> jad_sfVar = this.jad_an.jad_dq;
        V v2 = jad_sfVar.jad_an;
        if (v2 != 0) {
            jad_uh jad_uhVar = this.jad_an;
            synchronized (jad_uhVar) {
                Iterator iterator2 = new ArrayList(jad_uhVar.jad_an).iterator2();
                while (iterator2.hasNext()) {
                    ((jad_ob) iterator2.next()).jad_an(v2);
                }
            }
            return;
        }
        jad_uh jad_uhVar2 = this.jad_an;
        Throwable th = jad_sfVar.jad_bo;
        synchronized (jad_uhVar2) {
            ArrayList arrayList = new ArrayList(jad_uhVar2.jad_bo);
            if (arrayList.isEmpty()) {
                com.jd.ad.sdk.jad_ve.jad_dq.jad_an("Lottie encountered an error but no failure listener was added:", th);
            } else {
                Iterator iterator22 = arrayList.iterator2();
                while (iterator22.hasNext()) {
                    ((jad_ob) iterator22.next()).jad_an(th);
                }
            }
        }
    }
}
