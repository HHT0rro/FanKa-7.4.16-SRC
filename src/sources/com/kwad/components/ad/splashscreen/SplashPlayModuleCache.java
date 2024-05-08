package com.kwad.components.ad.splashscreen;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class SplashPlayModuleCache {
    private HashMap<String, WeakReference<com.kwad.components.ad.splashscreen.e.a>> Cl;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum Holder {
        INSTANCE;

        private SplashPlayModuleCache mInstance = new SplashPlayModuleCache(0);

        Holder() {
        }

        public final SplashPlayModuleCache getInstance() {
            return this.mInstance;
        }
    }

    public /* synthetic */ SplashPlayModuleCache(byte b4) {
        this();
    }

    private SplashPlayModuleCache() {
        this.Cl = new HashMap<>(1);
    }
}
