package com.huawei.hms.hmsscankit;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.IBinder;
import com.huawei.hms.common.Preconditions;
import com.huawei.hms.feature.dynamic.DynamicModule;
import com.huawei.hms.hmsscankit.api.IRemoteCreator;
import com.huawei.hms.scankit.p.b4;
import com.huawei.hms.scankit.p.o4;
import java.lang.reflect.InvocationTargetException;

/* compiled from: RemoteViewInitializer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f30316a = false;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f30317b = false;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f30318c = false;

    /* renamed from: d, reason: collision with root package name */
    public static int f30319d = Integer.MIN_VALUE;

    /* renamed from: e, reason: collision with root package name */
    public static int f30320e = Integer.MIN_VALUE;

    /* renamed from: f, reason: collision with root package name */
    private static volatile Context f30321f;

    public static int a(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getInt(ScanUtil.MODULE_SCANKIT_LOCAL, Integer.MAX_VALUE);
        } catch (PackageManager.NameNotFoundException unused) {
            o4.b("exception", "NameNotFoundException");
            return Integer.MAX_VALUE;
        }
    }

    public static void b(Context context) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        context.getClassLoader().loadClass(ScanUtil.CONTEXT_PATH).getDeclaredMethod(ScanUtil.CONTEXT_METHOD, Context.class).invoke(null, context);
    }

    public static IRemoteCreator c(Context context) {
        Preconditions.checkNotNull(context);
        try {
            Context e2 = e(context);
            if (e2 == null) {
                return null;
            }
            Object newInstance = e2.getClassLoader().loadClass(ScanUtil.CREATOR_PATH).newInstance();
            if (newInstance instanceof IBinder) {
                return IRemoteCreator.Stub.asInterface((IBinder) newInstance);
            }
            return null;
        } catch (ClassNotFoundException unused) {
            o4.b("exception", "ClassNotFoundException");
            return null;
        } catch (IllegalAccessException unused2) {
            o4.b("exception", "IllegalAccessException");
            return null;
        } catch (InstantiationException unused3) {
            o4.b("exception", "InstantiationException");
            return null;
        } catch (NoSuchMethodException unused4) {
            o4.b("exception", "NoSuchMethodException");
            return null;
        } catch (InvocationTargetException unused5) {
            o4.b("exception", "InvocationTargetException");
            return null;
        }
    }

    public static IRemoteCreator d(Context context) {
        Preconditions.checkNotNull(context);
        try {
            Object newInstance = context.getClassLoader().loadClass(ScanUtil.CREATOR_PATH).newInstance();
            if (newInstance instanceof IBinder) {
                return IRemoteCreator.Stub.asInterface((IBinder) newInstance);
            }
        } catch (ClassNotFoundException unused) {
            o4.b("exception", "ClassNotFoundException");
        } catch (IllegalAccessException unused2) {
            o4.b("exception", "IllegalAccessException");
        } catch (InstantiationException unused3) {
            o4.b("exception", "InvocationTargetException");
        }
        return null;
    }

    public static Context e(Context context) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        b(context);
        if (f30321f != null && !a()) {
            return f30321f;
        }
        try {
            b4.f30737a = false;
            if (f30319d == Integer.MIN_VALUE) {
                f30319d = a(context);
            }
            Context moduleContext = DynamicModule.load(context.getApplicationContext(), DynamicModule.PREFER_REMOTE, ScanUtil.MODULE_SCANKIT).getModuleContext();
            if (f30320e == Integer.MIN_VALUE) {
                f30320e = DynamicModule.getRemoteVersion(context.getApplicationContext(), ScanUtil.MODULE_SCANKIT);
            }
            if (f30319d >= 21200300) {
                f30318c = true;
            } else {
                f30318c = false;
            }
            o4.d("ScankitSDK", "local Version: " + f30319d + " remote Version: " + f30320e);
            if (!a() && f30319d <= f30320e) {
                f30316a = true;
                b4.f30737a = true;
                b4.f30738b = String.valueOf(f30320e);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("use remote scankit ");
                sb2.append(f30320e);
                f30321f = moduleContext;
                return f30321f;
            }
            o4.d("ScankitSDK", "use local Version: " + f30319d);
            b(context);
            f30316a = false;
            f30321f = null;
            return context;
        } catch (DynamicModule.LoadingException e2) {
            o4.b("ScankitSDK", "ClassNotFoundException exception " + e2.getMessage());
            b(context);
            return context;
        } catch (ClassNotFoundException unused) {
            o4.b("ScankitSDK", "ClassNotFoundException exception");
            b(context);
            return context;
        } catch (IllegalAccessException unused2) {
            o4.b("ScankitSDK", "IllegalAccessException exception");
            b(context);
            return context;
        } catch (NoSuchMethodException unused3) {
            o4.b("ScankitSDK", "NoSuchMethodException exception");
            b(context);
            return context;
        } catch (RuntimeException unused4) {
            o4.b("ScankitSDK", "other RuntimeException exception");
            b(context);
            return context;
        } catch (InvocationTargetException unused5) {
            o4.b("ScankitSDK", "InvocationTargetException exception");
            b(context);
            return context;
        } catch (Exception unused6) {
            o4.b("ScankitSDK", "Exception exception");
            b(context);
            return context;
        } catch (Throwable unused7) {
            o4.b("ScankitSDK", "Throwable exception");
            b(context);
            return context;
        }
    }

    public static boolean a() {
        return f30318c && f30316a && f30317b;
    }
}
