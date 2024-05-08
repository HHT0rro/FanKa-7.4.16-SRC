package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.huawei.hms.ads.dynamic.IDynamicLoader;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import java.io.File;
import java.lang.reflect.InvocationTargetException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    private static final String f29474a = "dl_LoadHelper";

    /* renamed from: b, reason: collision with root package name */
    private static final String f29475b = "DynamicLoader";

    public static Context a(Context context, String str, Bundle bundle, IDynamicLoader iDynamicLoader) {
        try {
            IObjectWrapper load = iDynamicLoader.load(ac.a(context), str, bundle.getInt("module_version"), ac.a(bundle));
            if (ac.a(load) == null) {
                aa.c(f29474a, "Get remote context is null.");
                return null;
            }
            if (!(ac.a(load) instanceof Context)) {
                aa.c(f29474a, "Incorrect context type.");
                return null;
            }
            aa.b(f29474a, "Get context for the module:" + str + " success.");
            return (Context) ac.a(load);
        } catch (Exception e2) {
            aa.c(f29474a, "Failed to get remote module context." + e2.getClass().getSimpleName());
            return null;
        }
    }

    public static IBinder a(Context context, String str) throws com.huawei.hms.ads.dynamicloader.j {
        if (str != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return (IBinder) new com.huawei.hms.ads.dynamicloader.d(str, ClassLoader.getSystemClassLoader()).loadClass("DynamicLoader").getConstructor(new Class[0]).newInstance(new Object[0]);
                }
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
                throw new com.huawei.hms.ads.dynamicloader.j("Failed to instantiate dynamic loader:" + e2.getMessage());
            }
        }
        throw new com.huawei.hms.ads.dynamicloader.j("Failed to get dynamicLoader path.");
    }

    public static void a(final int i10, final String str, final String[] strArr, String str2) {
        com.huawei.hms.ads.dynamic.b.a(str2).execute(new com.huawei.hms.ads.dynamicloader.k(new Runnable() { // from class: com.huawei.hms.ads.uiengineloader.r.1
            @Override // java.lang.Runnable
            public final void run() {
                for (String str3 : strArr) {
                    if (Integer.parseInt(str3) < i10) {
                        aa.b(r.f29474a, "Delete low version:" + i10 + " in modulePath.");
                        y.b(str + File.separator + str3);
                    }
                }
            }
        }));
    }
}
