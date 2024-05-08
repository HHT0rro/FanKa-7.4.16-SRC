package com.kwad.components.ad;

import androidx.annotation.NonNull;
import com.kwad.components.ad.adbit.c;
import com.kwad.components.core.c.d;
import com.kwad.components.core.c.g;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class KsAdLoadManager {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum Holder {
        INSTANCE;

        private final KsAdLoadManager mInstance = new KsAdLoadManager(0);

        Holder() {
        }
    }

    private KsAdLoadManager() {
    }

    public /* synthetic */ KsAdLoadManager(byte b4) {
        this();
    }

    public static KsAdLoadManager M() {
        return Holder.INSTANCE.mInstance;
    }

    public static void a(@NonNull com.kwad.components.core.request.model.a aVar) {
        if (c.b(aVar)) {
            return;
        }
        d.mx().c(aVar);
    }

    public final synchronized <T> void b(List<T> list) {
        Iterator<T> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            g.mF().add(iterator2.next());
        }
    }

    public final synchronized <T> void a(T t2) {
        g.mF().add(t2);
    }
}
