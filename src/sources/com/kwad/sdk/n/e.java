package com.kwad.sdk.n;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.s;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class e {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private final AtomicBoolean JB;
    private Resources aTd;
    private Resources aTe;
    private h aTf;
    private boolean aTg;
    private ClassLoader aTh;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {
        private static final e aTi = new e(0);
    }

    public /* synthetic */ e(byte b4) {
        this();
    }

    public static e NV() {
        return a.aTi;
    }

    private boolean NW() {
        Context KO;
        Object a10;
        try {
            KO = ServiceProvider.KO();
        } catch (Throwable th) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
        }
        if (!l.ds(KO)) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new IllegalArgumentException("KSPlugin unwrapContextIfNeed fail"));
            return false;
        }
        Class<?> cls = Class.forName("com.kwad.sdk.api.loader.Loader", false, getClass().getClassLoader());
        Object invoke = cls.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[0]).invoke(null, new Object[0]);
        for (Field field : cls.getDeclaredFields()) {
            if (field.getType() != IKsAdSDK.class && field.getType() != Context.class && field.getType() != AtomicBoolean.class && (a10 = s.a(field, invoke)) != null) {
                for (Field field2 : a10.getClass().getDeclaredFields()) {
                    if (field2.getType() == Resources.class) {
                        field2.setAccessible(true);
                        Resources resources = (Resources) field2.get(a10);
                        Resources resources2 = KO.getResources();
                        h hVar = new h(resources, resources2);
                        s.a(field2, a10, hVar);
                        this.aTd = resources2;
                        this.aTe = resources;
                        this.aTf = hVar;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean yQ() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).yQ();
    }

    private static boolean yR() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).yR();
    }

    public final boolean MA() {
        return this.JB.get();
    }

    public final ClassLoader getClassLoader() {
        return this.aTh;
    }

    public final Resources getResources() {
        return this.aTf;
    }

    public final void init() {
        if (this.JB.get()) {
            return;
        }
        try {
            if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).yp()) {
                if (yQ() && NW()) {
                    this.aTh = getClass().getClassLoader();
                    i.cj(yR());
                    com.kwad.sdk.core.e.c.d("KSDY/KSPlugin", toString());
                    this.aTg = true;
                } else {
                    this.aTg = false;
                }
            }
        } catch (Throwable th) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
        }
        this.JB.set(true);
    }

    @NonNull
    public String toString() {
        return "KSPlugin{mHostResources=" + ((Object) this.aTd) + ", mResResources=" + ((Object) this.aTe) + ", mPluginResources=" + ((Object) this.aTf) + ", mEnable=" + this.aTg + '}';
    }

    private e() {
        this.JB = new AtomicBoolean(false);
    }
}
