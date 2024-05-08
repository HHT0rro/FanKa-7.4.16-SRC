package com.tencent.liteav.base;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Process;
import android.preference.PreferenceManager;
import androidx.annotation.Nullable;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.annotations.MainDex;
import java.lang.reflect.Method;

@JNINamespace("base::android")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ContextUtils {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "ContextUtils";
    private static Context sApplicationContext;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static SharedPreferences f42739a = ContextUtils.access$000();
    }

    public static /* synthetic */ SharedPreferences access$000() {
        return fetchAppSharedPreferences();
    }

    @Nullable
    public static Activity activityFromContext(@Nullable Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    private static SharedPreferences fetchAppSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(sApplicationContext);
    }

    public static SharedPreferences getAppSharedPreferences() {
        return a.f42739a;
    }

    public static AssetManager getApplicationAssets() {
        Context applicationContext = getApplicationContext();
        while (applicationContext instanceof ContextWrapper) {
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        return applicationContext.getAssets();
    }

    public static Context getApplicationContext() {
        return sApplicationContext;
    }

    @MainDex
    public static void initApplicationContext(Context context) {
        initJavaSideApplicationContext(context);
    }

    @VisibleForTesting
    public static void initApplicationContextForTests(Context context) {
        initJavaSideApplicationContext(context);
        SharedPreferences unused = a.f42739a = fetchAppSharedPreferences();
    }

    @CalledByNative
    public static void initContextFromNative(String str) {
        try {
            Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
            method.setAccessible(true);
            Object invoke = method.invoke(null, new Object[0]);
            Object invoke2 = invoke.getClass().getMethod("getApplication", new Class[0]).invoke(invoke, new Object[0]);
            if (invoke2 instanceof Context) {
                initApplicationContext((Context) invoke2);
                setDataDirectorySuffix(str);
            }
        } catch (Exception unused) {
        }
    }

    private static void initJavaSideApplicationContext(Context context) {
        sApplicationContext = context;
    }

    public static boolean isIsolatedProcess() {
        return Process.isIsolated();
    }

    public static void setDataDirectorySuffix(String str) {
        PathUtils.setPrivateDataDirectorySuffix(str, null);
    }
}
