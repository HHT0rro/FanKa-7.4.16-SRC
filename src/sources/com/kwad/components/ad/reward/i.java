package com.kwad.components.ad.reward;

import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class i {
    private Map<String, List<AdTemplate>> qe;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a {
        private static final i qf = new i(0);
    }

    public /* synthetic */ i(byte b4) {
        this();
    }

    public static i gj() {
        return a.qf;
    }

    public final void B(String str) {
        this.qe.remove(str);
    }

    private i() {
        this.qe = new ConcurrentHashMap();
    }
}
