package com.kwad.sdk.utils;

import com.kwad.sdk.service.ServiceProvider;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class o {
    private static boolean aOJ;
    private static boolean aOK;

    public static boolean Li() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).X(2L)) & aOJ;
    }

    public static boolean Lj() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).X(4L)) & aOJ;
    }

    public static boolean Lk() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).X(2048L)) & aOJ;
    }

    public static boolean Ll() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).yB() && aOJ;
    }

    public static boolean Lm() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).X(16L)) & aOJ;
    }

    public static boolean Ln() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).X(4096L)) & aOJ;
    }

    public static boolean Lo() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).X(1L)) & aOJ;
    }

    public static boolean Lp() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).X(128L)) & aOJ;
    }

    public static boolean Lq() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).X(128L)) & aOJ;
    }

    public static synchronized void bR(boolean z10) {
        synchronized (o.class) {
            if (aOK) {
                return;
            }
            aOK = true;
            aOJ = true;
            ((com.kwad.sdk.service.a.b) ServiceProvider.get(com.kwad.sdk.service.a.b.class)).yl();
        }
    }
}
