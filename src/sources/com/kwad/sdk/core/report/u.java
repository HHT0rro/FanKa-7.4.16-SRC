package com.kwad.sdk.core.report;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.z;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class u<T extends e, R extends com.kwad.sdk.core.network.f> implements Runnable {
    private static AtomicLong ayZ = new AtomicLong(-1);
    public final l<T> axm;
    public final b<T, R> aza;
    public final AtomicInteger azb;
    public final Context mContext;

    public u(Context context, l<T> lVar, b<T, R> bVar, AtomicInteger atomicInteger) {
        this.mContext = context;
        this.axm = lVar;
        this.aza = bVar;
        this.azb = atomicInteger;
    }

    private void A(@NonNull List<T> list) {
        List d10 = z.d(list, 200);
        int size = d10.size();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        for (int i10 = 0; i10 < size; i10++) {
            this.aza.a((List) d10.get(i10), atomicBoolean);
        }
    }

    private void EX() {
        long MU = bi.MU();
        if (MU >= ayZ.get() * 2) {
            try {
                List<T> EI = this.axm.EI();
                if (EI.isEmpty()) {
                    return;
                }
                A(EI);
            } catch (OutOfMemoryError e2) {
                ayZ.set(MU);
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(e2);
            } catch (Throwable th) {
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.azb.get() > 0 || !ag.isNetworkConnected(this.mContext)) {
            return;
        }
        EX();
    }
}
