package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.core.KSLifecycleObserver;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
import com.kwad.sdk.api.proxy.IComponentProxy;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class Loader {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static Context mContext;
    private final AtomicBoolean JB;
    private IKsAdSDK amG;
    private k amH;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {
        private static final Loader amI = new Loader(0);
    }

    public /* synthetic */ Loader(byte b4) {
        this();
    }

    private static void Ah() {
        try {
            int zX = com.kwad.sdk.api.c.zX();
            if (zX > 0) {
                try {
                    d.ay(mContext).setDefaultUncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler());
                    Thread.setDefaultUncaughtExceptionHandler(d.ay(mContext));
                    d.ay(mContext).bW(zX);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @NonNull
    @MainThread
    public static synchronized IKsAdSDK a(ClassLoader classLoader) {
        IKsAdSDK iKsAdSDK;
        synchronized (Loader.class) {
            try {
                Object invoke = Class.forName(((KsAdSdkDynamicApi) IKsAdSDK.class.getAnnotation(KsAdSdkDynamicApi.class)).value(), true, classLoader).getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[0]).invoke(null, new Object[0]);
                if (invoke != null) {
                    iKsAdSDK = (IKsAdSDK) invoke;
                } else {
                    throw new RuntimeException("Can not get sdk form " + ((Object) classLoader));
                }
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return iKsAdSDK;
    }

    private boolean aD(Context context) {
        try {
            String az = g.az(context);
            String aA = g.aA(context);
            if (TextUtils.isEmpty(az) && TextUtils.isEmpty(aA)) {
                return false;
            }
            if (!TextUtils.isEmpty(aA) && g.K(aA, az)) {
                g.m(context, aA);
                w(context, az);
                g.n(context, "");
                az = aA;
            }
            return !TextUtils.isEmpty(az);
        } catch (Throwable th) {
            com.kwad.sdk.api.c.m(th);
            return false;
        }
    }

    private static void aE(Context context) {
        try {
            String aB = g.aB(context);
            boolean b4 = t.b(context, g.amm, false);
            if (TextUtils.isEmpty(aB) || !aB.equals(BuildConfig.VERSION_NAME) || b4) {
                String az = g.az(context);
                g.m(context, "");
                g.n(context, "");
                t.a(context, g.amm, false);
                h.j(h.r(context, az));
                g.o(context, BuildConfig.VERSION_NAME);
            }
        } catch (Throwable th) {
            com.kwad.sdk.api.c.m(th);
        }
    }

    public static void checkInitSDK(Context context) {
        if (KsAdSDK.sHasInit.get()) {
            return;
        }
        if (context == null) {
            context = KSLifecycleObserver.getInstance().getApplication();
        }
        KsAdSDK.init(context, SdkConfig.create(t.getString(context, "sdkconfig")));
    }

    public static Loader get() {
        return a.amI;
    }

    private static void w(Context context, String str) {
        h.v(context, str);
    }

    public Context getContext() {
        return mContext;
    }

    @MainThread
    public ClassLoader getExternalClassLoader() {
        k kVar = this.amH;
        if (kVar != null) {
            return kVar.getClassLoader();
        }
        return null;
    }

    @MainThread
    public Resources getExternalResource() {
        k kVar = this.amH;
        if (kVar != null) {
            return kVar.Ae();
        }
        return null;
    }

    public ClassLoader getRealClassLoader() {
        k kVar = this.amH;
        if (kVar != null) {
            return kVar.getClassLoader();
        }
        return getClass().getClassLoader();
    }

    public IKsAdSDK init(@NonNull Context context, ClassLoader classLoader) {
        if (this.JB.get()) {
            return this.amG;
        }
        mContext = context.getApplicationContext();
        aE(context);
        if (aD(context)) {
            this.amH = k.a(context, classLoader, g.az(context));
        }
        k kVar = this.amH;
        if (kVar == null) {
            IKsAdSDK a10 = a(getClass().getClassLoader());
            this.amG = a10;
            a10.setIsExternal(false);
        } else {
            IKsAdSDK Af = kVar.Af();
            this.amG = Af;
            Af.setIsExternal(true);
        }
        com.kwad.sdk.api.c.a(this.amG);
        if (this.amH != null) {
            Ah();
        }
        this.JB.set(true);
        return this.amG;
    }

    public boolean isExternalLoaded() {
        return this.amH != null;
    }

    @MainThread
    public <T extends IComponentProxy> T newComponentProxy(Context context, Class<?> cls, Object obj) {
        checkInitSDK(context);
        return (T) this.amG.newComponentProxy(cls, obj);
    }

    @MainThread
    public <T> T newInstance(Class<T> cls) {
        checkInitSDK(mContext);
        return (T) this.amG.newInstance(cls);
    }

    public void rest() {
        this.JB.set(false);
        mContext = null;
        this.amG = null;
        this.amH = null;
    }

    private Loader() {
        this.amH = null;
        this.JB = new AtomicBoolean(false);
    }
}
