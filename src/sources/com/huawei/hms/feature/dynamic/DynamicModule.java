package com.huawei.hms.feature.dynamic;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.feature.dynamic.IDynamicInstall;
import com.huawei.hms.feature.dynamic.IDynamicLoader;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class DynamicModule {
    public static final int MODULE_INTER_ERROR = 3;
    public static final int MODULE_NEED_UPDATE = 2;
    public static final int MODULE_NORMAL = 0;
    public static final int MODULE_NOT_EXIST = 1;
    public static final int MODULE_NOT_PRESET_HSF = 5;
    public static final int MODULE_NOT_READY = 4;

    /* renamed from: c, reason: collision with root package name */
    public static final int f29809c = 256;

    /* renamed from: d, reason: collision with root package name */
    public static final int f29810d = -100;

    /* renamed from: i, reason: collision with root package name */
    public static int f29815i = 0;

    /* renamed from: j, reason: collision with root package name */
    public static final int f29816j = 1;

    /* renamed from: k, reason: collision with root package name */
    public static final int f29817k = 2;

    /* renamed from: l, reason: collision with root package name */
    public static int f29818l;

    /* renamed from: a, reason: collision with root package name */
    public Context f29821a;
    public static final VersionPolicy PREFER_REMOTE = new com.huawei.hms.feature.dynamic.e.e();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new com.huawei.hms.feature.dynamic.e.c();
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new com.huawei.hms.feature.dynamic.e.d();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new com.huawei.hms.feature.dynamic.e.e();

    /* renamed from: b, reason: collision with root package name */
    public static final String f29808b = DynamicModule.class.getSimpleName();

    /* renamed from: e, reason: collision with root package name */
    public static final ThreadLocal<HashMap<String, Boolean>> f29811e = new ThreadLocal<>();

    /* renamed from: f, reason: collision with root package name */
    public static final ThreadLocal<HashMap<String, String>> f29812f = new ThreadLocal<>();

    /* renamed from: g, reason: collision with root package name */
    public static final ThreadLocal<HashMap<String, IDynamicLoader>> f29813g = new ThreadLocal<>();

    /* renamed from: h, reason: collision with root package name */
    public static final ThreadLocal<HashMap<String, ClassLoader>> f29814h = new ThreadLocal<>();

    /* renamed from: m, reason: collision with root package name */
    public static HashMap<String, Boolean> f29819m = new HashMap<>();

    /* renamed from: n, reason: collision with root package name */
    public static HashMap<String, Boolean> f29820n = new HashMap<>();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class DynamicLoaderClassLoader {

        /* renamed from: a, reason: collision with root package name */
        public static HashMap<String, ClassLoader> f29822a = new HashMap<>();

        public static ClassLoader getsClassLoader(String str) {
            return f29822a.get(str);
        }

        public static void setsClassLoader(String str, ClassLoader classLoader) {
            f29822a.put(str, classLoader);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class LoadingException extends Exception {

        /* renamed from: a, reason: collision with root package name */
        public Bundle f29823a;

        public LoadingException(String str) {
            super(str);
        }

        public LoadingException(String str, Bundle bundle) {
            super(str);
            this.f29823a = bundle;
        }

        public Bundle getBundle() {
            return this.f29823a;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface VersionPolicy {
        Bundle getModuleInfo(Context context, String str) throws LoadingException;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a extends HashMap<String, ClassLoader> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f29824a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ClassLoader f29825b;

        public a(String str, ClassLoader classLoader) {
            this.f29824a = str;
            this.f29825b = classLoader;
            put(str, classLoader);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b extends HashMap<String, ClassLoader> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f29826a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ClassLoader f29827b;

        public b(String str, ClassLoader classLoader) {
            this.f29826a = str;
            this.f29827b = classLoader;
            put(str, classLoader);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class c implements Callable<Bundle> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f29828a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Bundle f29829b;

        public c(Context context, Bundle bundle) {
            this.f29828a = context;
            this.f29829b = bundle;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Bundle call() {
            try {
                return DynamicModule.queryHMSModuleBundle(this.f29828a, com.huawei.hms.feature.dynamic.b.f29864e, this.f29829b);
            } catch (Exception e2) {
                Logger.w(DynamicModule.f29808b, "Query provider error.", e2);
                return new Bundle();
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class d extends HashMap<String, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f29830a;

        public d(String str) {
            this.f29830a = str;
            put(str, Boolean.TRUE);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class e extends HashMap<String, String> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f29831a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f29832b;

        public e(String str, String str2) {
            this.f29831a = str;
            this.f29832b = str2;
            put(str, str2);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class f extends HashMap<String, IDynamicLoader> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f29833a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IBinder f29834b;

        public f(String str, IBinder iBinder) {
            this.f29833a = str;
            this.f29834b = iBinder;
            put(str, IDynamicLoader.Stub.asInterface(iBinder));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class g extends Exception {
        public g(String str) {
            super(str);
        }

        public /* synthetic */ g(String str, a aVar) {
            this(str);
        }
    }

    public DynamicModule(Context context) {
        this.f29821a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x008c A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(android.content.Context r9, java.lang.String r10, android.os.Bundle r11) throws com.huawei.hms.feature.dynamic.DynamicModule.LoadingException {
        /*
            Method dump skipped, instructions count: 271
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.feature.dynamic.DynamicModule.a(android.content.Context, java.lang.String, android.os.Bundle):int");
    }

    public static int a(VersionPolicy versionPolicy) {
        if (versionPolicy instanceof com.huawei.hms.feature.dynamic.e.e) {
            return 1;
        }
        if (versionPolicy instanceof com.huawei.hms.feature.dynamic.e.d) {
            return 2;
        }
        return versionPolicy instanceof com.huawei.hms.feature.dynamic.e.c ? 3 : 0;
    }

    public static Context a(Context context, String str, Bundle bundle, IDynamicLoader iDynamicLoader) throws LoadingException {
        try {
            IObjectWrapper load = iDynamicLoader.load(ObjectWrapper.wrap(context), str, bundle.getInt("module_version"), ObjectWrapper.wrap(bundle));
            Object unwrap = ObjectWrapper.unwrap(load);
            if (unwrap == null) {
                Logger.w(f29808b, "Get remote context is null, module:" + str);
                return null;
            }
            if (unwrap instanceof Context) {
                Logger.i(f29808b, "Get context for module:" + str + " success.");
                return (Context) unwrap;
            }
            if (unwrap instanceof Bundle) {
                Logger.i(f29808b, "Get module info bundle for " + str);
                return a(context, str, bundle, iDynamicLoader, (Bundle) unwrap);
            }
            if (unwrap.getClass().getName().equals(LoadingException.class.getName())) {
                Bundle bundle2 = (Bundle) ObjectWrapper.unwrap(load).getClass().getDeclaredMethod("getBundle", new Class[0]).invoke(ObjectWrapper.unwrap(load), new Object[0]);
                Logger.w(f29808b, "Successfully get the bundle in exception.");
                throw new LoadingException("Failed to load, please check the bundle in exception.", bundle2);
            }
            Logger.w(f29808b, "Get remote context is null, module:" + str);
            return null;
        } catch (LoadingException e2) {
            throw e2;
        } catch (Exception e10) {
            Logger.w(f29808b, "Failed to get module context for:" + str, e10);
            return null;
        }
    }

    public static Context a(Context context, String str, Bundle bundle, IDynamicLoader iDynamicLoader, Bundle bundle2) throws LoadingException {
        bundle.putInt("version_strategy_type", 4);
        if (AssetLoadManager.getAssetModuleInfo(context, str).getInt(com.huawei.hms.feature.dynamic.b.f29872m, 0) <= 0) {
            Logger.i(f29808b, "No fallback module in assets.");
            throw new LoadingException("Load exception, please check the bundle in exception.", bundle2);
        }
        Object obj = null;
        try {
            obj = ObjectWrapper.unwrap(iDynamicLoader.load(ObjectWrapper.wrap(context), str, bundle.getInt("module_version"), ObjectWrapper.wrap(bundle)));
        } catch (RemoteException e2) {
            Logger.w(f29808b, "tryWithAssetsModule RemoteException.", e2);
        }
        if (!(obj instanceof Context)) {
            Logger.w(f29808b, "tryWithAssetsModule get dynamicContext failed: null or wrong type.");
            throw new LoadingException("Load exception, please check the bundle in exception.", bundle2);
        }
        Logger.i(f29808b, "get dynamic module context for:" + str + " from assets fallback success.");
        return (Context) obj;
    }

    public static Bundle a(Context context, Bundle bundle) throws g {
        a aVar = null;
        try {
            ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
            FutureTask futureTask = new FutureTask(new c(context, bundle));
            newSingleThreadExecutor.execute(futureTask);
            Bundle bundle2 = (Bundle) futureTask.get(f29818l, TimeUnit.MILLISECONDS);
            String string = bundle2.getString("loader_path");
            if (!TextUtils.isEmpty(string) && new File(string).exists()) {
                Logger.i(f29808b, "Query HMS module:huawei_module_dynamicloader info success.");
                return bundle2;
            }
            Logger.w(f29808b, "The loader_path:" + string + " is not available.");
            throw new g("The loader_path in queryBundle is empty or not exist.", aVar);
        } catch (TimeoutException unused) {
            Logger.w(f29808b, "Query hms provider timeout: over " + f29818l + " ms, choose the local loader fallback.");
            return new Bundle();
        } catch (Exception e2) {
            Logger.w(f29808b, "FutureTask: query provider exception.", e2);
            throw new g("failed to get :huawei_module_dynamicloader info.", aVar);
        }
    }

    public static DynamicModule a(Context context, String str, VersionPolicy versionPolicy) throws LoadingException {
        Bundle moduleInfo = versionPolicy.getModuleInfo(context, str);
        if (moduleInfo.getInt("module_version") <= 0) {
            if (moduleInfo.getInt("local_module_version") <= 0) {
                throw new LoadingException("Query remote version and local version failed.");
            }
            Logger.i(f29808b, "Remote version is invalid, use local context.");
            return new DynamicModule(context.getApplicationContext());
        }
        try {
            return c(context, str, moduleInfo);
        } catch (LoadingException e2) {
            Logger.w(f29808b, "Failed to load remote module.", e2);
            if (getLocalVersion(context, str) <= 0) {
                throw e2;
            }
            Logger.d(f29808b, "Local module version is valid, use local fallback.");
            return new DynamicModule(context.getApplicationContext());
        }
    }

    public static DynamicModule a(Context context, String str, VersionPolicy versionPolicy, Bundle bundle) throws LoadingException {
        int a10 = a(versionPolicy);
        String string = bundle.getString("loader_path");
        Logger.i(f29808b, "The loader path for module:" + str + " is:" + string + ", and versionType is:" + a10);
        if (TextUtils.isEmpty(string)) {
            throw new LoadingException("Cannot find a valid dynamic loader in HMS or local.");
        }
        Boolean bool = f29820n.get(str);
        Boolean bool2 = f29819m.get(str);
        bundle.putString("module_name", str);
        bundle.putInt("version_strategy_type", a10);
        bundle.putBoolean(com.huawei.hms.feature.dynamic.b.f29883x, bool != null ? bool.booleanValue() : false);
        bundle.putBoolean(com.huawei.hms.feature.dynamic.b.f29884y, bool2 != null ? bool2.booleanValue() : false);
        try {
            return b(context, str, bundle);
        } catch (LoadingException e2) {
            throw e2;
        } catch (Exception e10) {
            Logger.e(f29808b, "Other exception,", e10);
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            return new DynamicModule(context);
        }
    }

    public static IDynamicInstall a(Context context, String str) throws LoadingException {
        if (str != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (com.huawei.hms.feature.dynamic.f.c.a(context, str)) {
                        return IDynamicInstall.Stub.asInterface((IBinder) new com.huawei.hms.feature.dynamic.e.a(str, ClassLoader.getSystemClassLoader()).loadClass(com.huawei.hms.feature.dynamic.b.f29866g).getConstructor(new Class[0]).newInstance(new Object[0]));
                    }
                    Logger.w(f29808b, "check path failed: invalid.");
                    throw new LoadingException("getHMSDynamicInstaller: checkPathValidity failed.");
                }
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
                throw new LoadingException("getHMSDynamicInstaller: failed to instantiate dynamic loader:" + e2.getMessage());
            }
        }
        throw new LoadingException("Failed to get dynamicLoader path.");
    }

    public static IDynamicLoader a(Context context, String str, String str2, ClassLoader classLoader) {
        if (classLoader == null) {
            try {
                classLoader = new com.huawei.hms.feature.dynamic.e.a(str2, ClassLoader.getSystemClassLoader());
                f29814h.set(new b(str, classLoader));
            } catch (Exception e2) {
                Logger.w(f29808b, "Get iDynamicLoader failed.", e2);
                return null;
            }
        }
        return IDynamicLoader.Stub.asInterface((IBinder) classLoader.loadClass(com.huawei.hms.feature.dynamic.b.f29865f).getConstructor(new Class[0]).newInstance(new Object[0]));
    }

    public static Class<?> a(Context context) throws LoadingException {
        Class<?> cls;
        try {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            cls = context.getClassLoader().loadClass(DynamicLoaderClassLoader.class.getName());
        } catch (ClassNotFoundException unused) {
            Logger.w(f29808b, "ClassLoader class not found when use client context.");
            cls = null;
        }
        if (cls == null) {
            try {
                ClassLoader classLoader = DynamicModule.class.getClassLoader();
                Objects.requireNonNull(classLoader);
                ClassLoader classLoader2 = classLoader;
                cls = classLoader.loadClass(DynamicLoaderClassLoader.class.getName());
                if (cls == null) {
                    throw new LoadingException("ClassLoader class is null.");
                }
            } catch (ClassNotFoundException unused2) {
                throw new LoadingException("ClassLoader class not found when use DynamicModule's classLoader.");
            }
        }
        return cls;
    }

    public static void a(Context context, VersionPolicy versionPolicy, String str, Bundle bundle) throws LoadingException {
        if (((context == null || versionPolicy == null || str == null) || str.length() == 0 || str.length() > 256) || bundle == null) {
            throw new LoadingException("Null param, please check it.");
        }
    }

    public static void a(String str, ClassLoader classLoader) throws LoadingException {
        try {
            f29813g.set(new f(str, (IBinder) classLoader.loadClass(com.huawei.hms.feature.dynamic.b.f29865f).getConstructor(new Class[0]).newInstance(new Object[0])));
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            throw new LoadingException("Failed to get loader interface:" + e2.getMessage());
        }
    }

    public static boolean a(String str, int i10) {
        if (i10 == 1) {
            Boolean bool = f29820n.get(str);
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        }
        if (i10 != 2) {
            return i10 == 3 || i10 == 4;
        }
        Boolean bool2 = f29819m.get(str);
        if (bool2 != null) {
            return bool2.booleanValue();
        }
        return false;
    }

    public static Bundle b(Context context, String str) throws LoadingException {
        Method declaredMethod;
        ClassLoader classLoader;
        boolean z10 = true;
        try {
            try {
                Class<?> a10 = a(context);
                Method declaredMethod2 = a10.getDeclaredMethod("getsClassLoader", String.class);
                declaredMethod = a10.getDeclaredMethod("setsClassLoader", String.class, ClassLoader.class);
                classLoader = (ClassLoader) declaredMethod2.invoke(null, str);
            } catch (Exception e2) {
                Logger.w(f29808b, "failed to load.", e2);
            }
            if (classLoader == null) {
                try {
                    String str2 = f29808b;
                    Logger.i(str2, "No available cached loader, query remote.");
                    Bundle c4 = c(context, str);
                    synchronized (DynamicModule.class) {
                        HashMap<String, String> hashMap = f29812f.get();
                        Objects.requireNonNull(hashMap);
                        String str3 = hashMap.get(str);
                        if (TextUtils.isEmpty(str3)) {
                            return c4;
                        }
                        if (!com.huawei.hms.feature.dynamic.f.c.a(context, str3)) {
                            Logger.w(str2, "The loaderPath is invalid.");
                            throw new LoadingException("getHMSModuleInfo: checkPathValidity failed.");
                        }
                        com.huawei.hms.feature.dynamic.e.a aVar = new com.huawei.hms.feature.dynamic.e.a(str3, ClassLoader.getSystemClassLoader());
                        a(str, aVar);
                        declaredMethod.invoke(null, str, aVar);
                        f29811e.set(new d(str));
                        return c4;
                    }
                } catch (g unused) {
                }
            } else if (classLoader != ClassLoader.getSystemClassLoader()) {
                Logger.i(f29808b, "Cached loader is available, ready to use it.");
                try {
                    a(str, classLoader);
                } catch (LoadingException e10) {
                    Logger.w(f29808b, "Get loader interface failed.", e10);
                }
                HashMap<String, Boolean> hashMap2 = new HashMap<>();
                hashMap2.put(str, Boolean.valueOf(z10));
                f29811e.set(hashMap2);
                return new Bundle();
            }
            z10 = false;
            HashMap<String, Boolean> hashMap22 = new HashMap<>();
            hashMap22.put(str, Boolean.valueOf(z10));
            f29811e.set(hashMap22);
            return new Bundle();
        } catch (LoadingException e11) {
            throw e11;
        }
    }

    public static DynamicModule b(Context context, VersionPolicy versionPolicy, String str, Bundle bundle) throws LoadingException {
        String str2 = f29808b;
        Logger.i(str2, "dynamic-api version: 10024300");
        a(context, versionPolicy, str, bundle);
        try {
            int a10 = a(context, str, bundle);
            if (a10 >= 10015300) {
                Logger.i(str2, "Load start in new-version-policy.");
                return a(context, str, versionPolicy, bundle);
            }
            if (a10 <= 0) {
                throw new LoadingException("Cannot find a valid dynamicLoader in HMS and local.");
            }
            Logger.i(str2, "Load start in old-version-policy.");
            return a(context, str, versionPolicy);
        } catch (LoadingException e2) {
            throw e2;
        } catch (Exception e10) {
            Logger.e(f29808b, "Other exception:" + ((Object) e10));
            throw new LoadingException("Load failed.");
        }
    }

    public static DynamicModule b(Context context, String str, Bundle bundle) throws LoadingException {
        ClassLoader classLoader;
        synchronized (DynamicModule.class) {
            ThreadLocal<HashMap<String, ClassLoader>> threadLocal = f29814h;
            if (threadLocal.get() != null && threadLocal.get().get(str) != null) {
                Logger.i(f29808b, "Cached loader for module is available, ready to use it.");
                classLoader = threadLocal.get().get(str);
            }
            Logger.i(f29808b, "No available cached loader for module:" + str);
            classLoader = null;
        }
        IDynamicLoader a10 = a(context, str, bundle.getString("loader_path"), classLoader);
        if (a10 == null) {
            throw new LoadingException("Failed to get iDynamicLoader: null.");
        }
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        Context a11 = a(context, str, bundle, a10);
        if (a11 != null) {
            return new DynamicModule(a11);
        }
        throw new LoadingException("New version policy: Failed to get module context: null.");
    }

    public static IDynamicInstall b(Context context) throws LoadingException {
        int i10;
        int i11 = 0;
        String str = null;
        try {
            Bundle a10 = a(context, (Bundle) null);
            str = a10.getString("loader_path");
            i10 = a10.getInt("loader_version");
        } catch (Exception e2) {
            Logger.w(f29808b, "Cannot get remote HMS dynamicLoader.", e2);
            i10 = 0;
        }
        try {
            i11 = getLocalVersion(context, com.huawei.hms.feature.dynamic.b.f29864e);
        } catch (Exception e10) {
            Logger.w(f29808b, "Cannot find local dynamicLoader fallback.", e10);
        }
        String str2 = f29808b;
        Logger.i(str2, "DynamicLoader remoteHMSVersion:" + i10 + ", hmsLoaderPath:" + str + ", localLoaderVersion:" + i11);
        int max = Math.max(i10, i11);
        if (max > 10009300) {
            if (i10 <= i11) {
                Logger.i(str2, "Choose local dynamicLoader fallback: ");
                f29815i = 2;
                return c(context);
            }
            Logger.i(str2, "Choose hms dynamicLoader: " + str);
            f29815i = 1;
            return a(context, str);
        }
        Logger.w(str2, "The current version:" + max + " is too low.");
        throw new LoadingException("The loader version:" + max + " is too low to support HFF.");
    }

    public static Bundle c(Context context, String str) throws LoadingException, g {
        try {
            Bundle queryHMSModuleBundle = queryHMSModuleBundle(context, str);
            String string = queryHMSModuleBundle.getString("loader_path");
            if (!TextUtils.isEmpty(string) && new File(string).exists()) {
                f29812f.set(new e(str, string));
                Logger.i(f29808b, "Query remote version by module name:" + str + " success.");
                return queryHMSModuleBundle;
            }
            Logger.w(f29808b, "The loader_path:" + string + " in query bundle is not available,change the module version to:-100");
            queryHMSModuleBundle.putInt("module_version", -100);
            return queryHMSModuleBundle;
        } catch (LoadingException e2) {
            throw e2;
        } catch (Exception unused) {
            throw new g("failed to Query remote version.", null);
        }
    }

    public static DynamicModule c(Context context, String str, Bundle bundle) throws LoadingException {
        Boolean bool;
        IDynamicLoader iDynamicLoader;
        try {
            synchronized (DynamicModule.class) {
                HashMap<String, Boolean> hashMap = f29811e.get();
                Objects.requireNonNull(hashMap);
                bool = hashMap.get(str);
                HashMap<String, IDynamicLoader> hashMap2 = f29813g.get();
                Objects.requireNonNull(hashMap2);
                iDynamicLoader = hashMap2.get(str);
            }
            if (bool == null || iDynamicLoader == null) {
                throw new LoadingException("The loader for " + str + " was not prepared.");
            }
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            Context a10 = a(context, str, bundle, iDynamicLoader);
            if (a10 != null) {
                return new DynamicModule(a10);
            }
            throw new LoadingException("Failed to get remote module context: null");
        } catch (LoadingException e2) {
            throw e2;
        } catch (Exception unused) {
            throw new LoadingException("Load Module Error.");
        }
    }

    public static IDynamicInstall c(Context context) throws LoadingException {
        try {
            return (IDynamicInstall) context.getClassLoader().loadClass(com.huawei.hms.feature.dynamic.b.f29866g).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e2) {
            throw new LoadingException("getLocalLoaderFallback: failed to instantiate dynamic loader: " + e2.getMessage());
        }
    }

    public static void enable3rdPhone(String str, boolean z10) {
        f29819m.put(str, Boolean.valueOf(z10));
    }

    public static void enableLowEMUI(String str, boolean z10) {
        f29820n.put(str, Boolean.valueOf(z10));
    }

    public static Set<String> getInstalledModuleInfo() {
        return com.huawei.hms.feature.dynamic.d.a().f29893a;
    }

    public static Bundle getLocalModuleInfo(Context context, String str) {
        int localVersion = getLocalVersion(context, str);
        Bundle bundle = new Bundle();
        bundle.putString("module_name", str);
        bundle.putInt("local_module_version", localVersion);
        return bundle;
    }

    public static int getLocalVersion(Context context, String str) {
        if (context == null || str.length() == 0 || str.length() > 256) {
            Logger.e(f29808b, "Invalid context or moduleName.");
            return 0;
        }
        try {
            String str2 = AssetLoadManager.f29787d + str + ".ModuleDescriptor";
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            return context.getClassLoader().loadClass(str2).getDeclaredField("MODULE_VERSION").getInt(null);
        } catch (ClassNotFoundException unused) {
            Logger.w(f29808b, "Cannot find the class of module descriptor for " + str);
            return 0;
        } catch (Exception e2) {
            Logger.w(f29808b, "Get local module info failed.", e2);
            return 0;
        }
    }

    public static Bundle getRemoteModuleInfo(Context context, String str) throws LoadingException {
        try {
        } catch (LoadingException e2) {
            throw e2;
        } catch (Exception e10) {
            Logger.w(f29808b, "Get remote module info for " + str + " failed.", e10);
        }
        synchronized (DynamicModule.class) {
            ThreadLocal<HashMap<String, Boolean>> threadLocal = f29811e;
            if (threadLocal.get() == null || threadLocal.get().get(str) == null || !threadLocal.get().get(str).booleanValue()) {
                Bundle b4 = b(context, str);
                if (b4.getInt("module_version") > 0) {
                    return b4;
                }
            }
            if (threadLocal.get().get(str).booleanValue()) {
                try {
                    return c(context, str);
                } catch (g e11) {
                    Logger.w(f29808b, "Query remote module info in HMS failed.", e11);
                }
            }
            return new Bundle();
        }
    }

    public static int getRemoteVersion(Context context, String str) throws LoadingException {
        try {
            Bundle c4 = c(context, str);
            if (c4 != null && !c4.isEmpty()) {
                return c4.getInt("module_version");
            }
            Logger.w(f29808b, "Query remote module:" + str + " info failed.");
            throw new LoadingException("Query remote module info failed: null or empty.");
        } catch (g e2) {
            Logger.w(f29808b, "Query remote module:" + str + " exception:" + ((Object) e2));
            return 0;
        }
    }

    public static void install(Context context, int i10) {
        String str = f29808b;
        Logger.i(str, "dynamic-api version: 10024300");
        if (context == null) {
            Logger.e(str, "The input context is null.");
            return;
        }
        try {
            f29818l = i10;
            Logger.i(str, "Query HMS provider timeOut is set to:" + f29818l + " ms.");
            IDynamicInstall b4 = b(context);
            if (b4 == null) {
                throw new LoadingException("Get dynamicInstaller failed.");
            }
            Bundle install = b4.install(ObjectWrapper.wrap(context), new Bundle());
            if (install == null) {
                throw new LoadingException("Get install info failed: moduleBundle is null.");
            }
            com.huawei.hms.feature.dynamic.d.a().a(install);
            Logger.i(str, "Install module success.");
        } catch (RemoteException | LoadingException | NullPointerException e2) {
            if (f29815i == 2 || getLocalVersion(context, com.huawei.hms.feature.dynamic.b.f29864e) <= 0) {
                Logger.w(f29808b, "Install module failed.", e2);
                return;
            }
            String str2 = f29808b;
            Logger.i(str2, "Ready to use local loader-fallback to retry:");
            try {
                Bundle install2 = c(context).install(ObjectWrapper.wrap(context), new Bundle());
                if (install2 == null) {
                    throw new LoadingException("Retry: get install info failed: moduleBundle is null.");
                }
                com.huawei.hms.feature.dynamic.d.a().a(install2);
                Logger.i(str2, "Retry install module with local loader-fallback success.");
            } catch (RemoteException | LoadingException | NullPointerException e10) {
                Logger.w(f29808b, "Retry failed with local loader-fallback.", e10);
            }
        }
    }

    public static DynamicModule load(Context context, VersionPolicy versionPolicy, String str) throws LoadingException {
        return b(context, versionPolicy, str, new Bundle());
    }

    public static DynamicModule loadV2(Context context, VersionPolicy versionPolicy, String str) throws LoadingException {
        Bundle bundle = new Bundle();
        bundle.putString("loader_version_type", "v2");
        return b(context, versionPolicy, str, bundle);
    }

    public static DynamicModule loadV3(Context context, VersionPolicy versionPolicy, String str) throws LoadingException {
        return loadV3(context, versionPolicy, str, new Bundle());
    }

    public static DynamicModule loadV3(Context context, VersionPolicy versionPolicy, String str, Bundle bundle) throws LoadingException {
        bundle.putString("loader_version_type", com.huawei.hms.feature.dynamic.b.f29880u);
        return b(context, versionPolicy, str, bundle);
    }

    public static Bundle queryHMSModuleBundle(Context context, String str) throws LoadingException, g {
        return queryHMSModuleBundle(context, str, null);
    }

    public static Bundle queryHMSModuleBundle(Context context, String str, Bundle bundle) throws LoadingException, g {
        a aVar = null;
        try {
            if (!com.huawei.hms.feature.dynamic.f.c.a(context)) {
                Logger.w(f29808b, "No valid HMS Core in this device.");
                throw new g("HMS Core is not installed.", aVar);
            }
            ContentResolver contentResolver = context.getContentResolver();
            if (contentResolver == null) {
                throw new g("Query remote version failed: null contentResolver.", aVar);
            }
            Bundle call = contentResolver.call(Uri.parse("content://com.huawei.hms"), str, (String) null, bundle);
            if (call == null) {
                Logger.w(f29808b, "Failed to get bundle info:null.");
                throw new g("Query remote version failed: null bundle info.", aVar);
            }
            int i10 = call.getInt("errcode");
            String string = call.getString("loader_path");
            String str2 = f29808b;
            Logger.i(str2, "bundle info: errorCode:" + i10 + ", moduleVersion:" + call.getInt("module_version") + ", modulePath:" + call.getString("module_path") + ", loader_version:" + call.getInt("loader_version") + ", loaderPath:" + string + ", armeabiType:" + call.getInt("armeabiType"));
            if (i10 == 0) {
                return call;
            }
            Logger.w(str2, "Failed to get " + str + " bundle info, errcode:" + i10);
            throw new LoadingException("Query " + str + " unavailable, errorCode:" + i10, call);
        } catch (LoadingException e2) {
            throw e2;
        } catch (Exception unused) {
            throw new g("failed to get :" + str + " info from HMS Core.", aVar);
        }
    }

    public final Context getModuleContext() {
        return this.f29821a;
    }
}
