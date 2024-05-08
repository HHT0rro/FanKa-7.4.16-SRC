package com.kwad.components.core.c;

import com.kwad.sdk.core.response.model.AdResultData;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class f {
    private Map<Integer, AdResultData> Je = new ConcurrentHashMap();
    private AtomicInteger Jf = new AtomicInteger(0);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a {
        public static f Jg = new f();
    }

    public static f mE() {
        return a.Jg;
    }

    public final AdResultData d(int i10, boolean z10) {
        AdResultData adResultData = this.Je.get(Integer.valueOf(i10));
        this.Je.remove(Integer.valueOf(i10));
        return adResultData;
    }

    public final int i(AdResultData adResultData) {
        if (adResultData == null) {
            return 0;
        }
        int incrementAndGet = this.Jf.incrementAndGet();
        this.Je.put(Integer.valueOf(incrementAndGet), adResultData);
        return incrementAndGet;
    }
}
