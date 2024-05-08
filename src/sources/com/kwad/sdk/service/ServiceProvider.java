package com.kwad.sdk.service;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.n.l;
import com.kwad.sdk.service.a.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ServiceProvider {
    private static List<Throwable> JC;
    private static Context aNZ;
    private static Context aOa;
    private static SdkConfig aOb;
    private static boolean aOc;
    private static Context mContext;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum ServiceProviderDelegate {
        INSTANCE;

        private final Map<Class<?>, Object> mProviders = new HashMap(32);

        ServiceProviderDelegate() {
        }

        public final <T> T get(Class<T> cls) {
            return (T) this.mProviders.get(cls);
        }

        public final <T> void put(Class<T> cls, T t2) {
            this.mProviders.put(cls, t2);
        }
    }

    public static void KN() {
        aOc = true;
    }

    @NonNull
    @Deprecated
    public static Context KO() {
        return mContext;
    }

    @NonNull
    public static SdkConfig KP() {
        return aOb;
    }

    public static void b(SdkConfig sdkConfig) {
        aOb = sdkConfig;
    }

    public static void bC(Context context) {
        aNZ = context;
        mContext = l.dt(context);
    }

    public static void d(com.kwad.sdk.g.a<Throwable> aVar) {
        List<Throwable> list = JC;
        if (list == null) {
            return;
        }
        Iterator<Throwable> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            aVar.accept(iterator2.next());
        }
        JC.clear();
        JC = null;
    }

    public static <T> T get(Class<T> cls) {
        return (T) ServiceProviderDelegate.INSTANCE.get(cls);
    }

    public static String getAppId() {
        return aOb.appId;
    }

    public static String getAppName() {
        return aOb.appName;
    }

    @NonNull
    public static Context getContext() {
        if (aOc) {
            return KO();
        }
        if (aOa == null) {
            aOa = l.wrapContextIfNeed(mContext);
        }
        return aOa;
    }

    public static String getSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public static <T> void put(Class<T> cls, T t2) {
        ServiceProviderDelegate.INSTANCE.put(cls, t2);
    }

    public static void reportSdkCaughtException(Throwable th) {
        e eVar = (e) get(e.class);
        if (eVar != null) {
            eVar.gatherException(th);
        } else {
            b(th);
        }
    }

    private static void b(Throwable th) {
        if (JC == null) {
            JC = new CopyOnWriteArrayList();
        }
        JC.add(th);
    }
}
