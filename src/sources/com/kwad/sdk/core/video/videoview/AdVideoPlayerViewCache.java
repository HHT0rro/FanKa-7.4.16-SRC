package com.kwad.sdk.core.video.videoview;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class AdVideoPlayerViewCache {
    private HashMap<String, WeakReference<a>> Cl;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum Holder {
        INSTANCE;

        private AdVideoPlayerViewCache mInstance = new AdVideoPlayerViewCache(0);

        Holder() {
        }

        public final AdVideoPlayerViewCache getInstance() {
            return this.mInstance;
        }
    }

    public /* synthetic */ AdVideoPlayerViewCache(byte b4) {
        this();
    }

    public static AdVideoPlayerViewCache getInstance() {
        return Holder.INSTANCE.getInstance();
    }

    public final void a(String str, a aVar) {
        this.Cl.put(str, new WeakReference<>(aVar));
    }

    public final a ew(String str) {
        WeakReference<a> weakReference = this.Cl.get(str);
        if (weakReference != null) {
            a aVar = weakReference.get();
            if (aVar != null) {
                return aVar;
            }
            this.Cl.remove(str);
        }
        return null;
    }

    public final void remove(String str) {
        this.Cl.remove(str);
    }

    private AdVideoPlayerViewCache() {
        this.Cl = new HashMap<>(1);
    }
}
