package com.huawei.hms.ads.dynamic;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.huawei.hms.ads.analysis.DynamicLoaderAnalysis;
import com.huawei.hms.ads.dynamic.IDynamicLoader;
import com.huawei.hms.ads.dynamicloader.g;
import com.huawei.hms.ads.uiengineloader.aa;
import com.huawei.hms.ads.uiengineloader.c;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class DynamicModule {
    public static final int MODULE_INTER_ERROR = 3;
    public static final int MODULE_NORMAL = 0;

    /* renamed from: a, reason: collision with root package name */
    private static final String f29086a = "DynamicModule";

    /* renamed from: b, reason: collision with root package name */
    private static final int f29087b = 256;

    /* renamed from: c, reason: collision with root package name */
    private static final int f29088c = -100;

    /* renamed from: d, reason: collision with root package name */
    private static final ThreadLocal<HashMap<String, Boolean>> f29089d = new ThreadLocal<>();

    /* renamed from: e, reason: collision with root package name */
    private static final ThreadLocal<HashMap<String, String>> f29090e = new ThreadLocal<>();

    /* renamed from: f, reason: collision with root package name */
    private static final ThreadLocal<HashMap<String, IDynamicLoader>> f29091f = new ThreadLocal<>();

    /* renamed from: g, reason: collision with root package name */
    private Context f29092g;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class DynamicLoaderClassLoader {

        /* renamed from: a, reason: collision with root package name */
        private static HashMap<String, ClassLoader> f29098a = new HashMap<>();

        public static ClassLoader getsClassLoader(String str) {
            return f29098a.get(str);
        }

        public static void setsClassLoader(String str, ClassLoader classLoader) {
            f29098a.put(str, classLoader);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class LoadingException extends Exception {

        /* renamed from: a, reason: collision with root package name */
        private Bundle f29099a;

        public LoadingException(String str) {
            super(str);
        }

        public LoadingException(String str, Bundle bundle) {
            super(str);
            this.f29099a = bundle;
        }

        public Bundle getBundle() {
            return this.f29099a;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a extends Exception {
        private a(String str) {
            super(str);
        }

        public /* synthetic */ a(String str, byte b4) {
            this(str);
        }
    }

    private DynamicModule(Context context) {
        this.f29092g = context;
    }

    private static Context a(Context context, String str, Bundle bundle, IDynamicLoader iDynamicLoader) throws LoadingException {
        try {
            IObjectWrapper load = iDynamicLoader.load(ObjectWrapper.wrap(context), str, bundle.getInt("module_version"), ObjectWrapper.wrap(bundle));
            Object unwrap = ObjectWrapper.unwrap(load);
            if (unwrap == null) {
                aa.c(f29086a, "Get remote context is null, module:".concat(String.valueOf(str)));
                return null;
            }
            if (unwrap instanceof Context) {
                aa.b(f29086a, "Get context for module:" + str + " success.");
                return (Context) unwrap;
            }
            if (!unwrap.getClass().getName().equals(LoadingException.class.getName())) {
                aa.c(f29086a, "Get remote context is null, module:".concat(String.valueOf(str)));
                return null;
            }
            Bundle bundle2 = (Bundle) ObjectWrapper.unwrap(load).getClass().getDeclaredMethod("getBundle", new Class[0]).invoke(ObjectWrapper.unwrap(load), new Object[0]);
            aa.c(f29086a, "Successfully get the bundle in exception.");
            throw new LoadingException("Failed to load, please check the bundle in exception.", bundle2);
        } catch (LoadingException e2) {
            throw e2;
        } catch (Exception e10) {
            aa.c(f29086a, "Failed to get module context for:" + str + " " + e10.getClass().getSimpleName());
            return null;
        }
    }

    private static Bundle a(Context context, String str) throws LoadingException {
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
                aa.c(f29086a, "failed to load." + e2.getClass().getSimpleName());
            }
            if (classLoader == null) {
                try {
                    aa.b(f29086a, "No available cached loader, query remote.");
                    Bundle b4 = b(context, str);
                    synchronized (DynamicModule.class) {
                        HashMap<String, String> hashMap = f29090e.get();
                        Objects.requireNonNull(hashMap);
                        String str2 = hashMap.get(str);
                        if (TextUtils.isEmpty(str2)) {
                            return b4;
                        }
                        c cVar = new c(str2, ClassLoader.getSystemClassLoader());
                        a(str, cVar);
                        declaredMethod.invoke(null, str, cVar);
                        f29089d.set(new HashMap<String, Boolean>() { // from class: com.huawei.hms.ads.dynamic.DynamicModule.1
                            {
                                put(String.this, Boolean.TRUE);
                            }
                        });
                        return b4;
                    }
                } catch (a unused) {
                }
            } else if (classLoader != ClassLoader.getSystemClassLoader()) {
                aa.b(f29086a, "Cached loader is available, ready to use it.");
                try {
                    a(str, classLoader);
                } catch (LoadingException e10) {
                    aa.c(f29086a, "Get loader interface failed." + e10.getClass().getSimpleName());
                }
                HashMap<String, Boolean> hashMap2 = new HashMap<>();
                hashMap2.put(str, Boolean.valueOf(z10));
                f29089d.set(hashMap2);
                return new Bundle();
            }
            z10 = false;
            HashMap<String, Boolean> hashMap22 = new HashMap<>();
            hashMap22.put(str, Boolean.valueOf(z10));
            f29089d.set(hashMap22);
            return new Bundle();
        } catch (LoadingException e11) {
            throw e11;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002c, code lost:
    
        if ((!android.text.TextUtils.isEmpty(r4) && r4.startsWith(com.huawei.hms.ads.dynamic.a.f29124s)) != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.huawei.hms.ads.dynamic.DynamicModule a(android.content.Context r8, java.lang.Integer r9, java.lang.String r10, android.os.Bundle r11) throws com.huawei.hms.ads.dynamic.DynamicModule.LoadingException {
        /*
            java.lang.String r0 = "DynamicModule"
            r1 = 4
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L67 com.huawei.hms.ads.dynamic.DynamicModule.LoadingException -> La6
            boolean r4 = com.huawei.hms.ads.uiengineloader.v.a(r8)     // Catch: java.lang.Exception -> L67 com.huawei.hms.ads.dynamic.DynamicModule.LoadingException -> La6
            if (r4 == 0) goto L57
            boolean r4 = com.huawei.hms.ads.uiengineloader.b.a()     // Catch: java.lang.Exception -> L67 com.huawei.hms.ads.dynamic.DynamicModule.LoadingException -> La6
            r5 = 0
            r6 = 1
            if (r4 != 0) goto L2e
            java.lang.String r4 = "ro.build.2b2c.partner.ext_channel"
            java.lang.String r4 = com.huawei.hms.ads.uiengineloader.b.a(r4)     // Catch: java.lang.Exception -> L67 com.huawei.hms.ads.dynamic.DynamicModule.LoadingException -> La6
            boolean r7 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Exception -> L67 com.huawei.hms.ads.dynamic.DynamicModule.LoadingException -> La6
            if (r7 != 0) goto L2b
            java.lang.String r7 = "02"
            boolean r4 = r4.startsWith(r7)     // Catch: java.lang.Exception -> L67 com.huawei.hms.ads.dynamic.DynamicModule.LoadingException -> La6
            if (r4 == 0) goto L2b
            r4 = 1
            goto L2c
        L2b:
            r4 = 0
        L2c:
            if (r4 == 0) goto L2f
        L2e:
            r5 = 1
        L2f:
            if (r5 == 0) goto L47
            java.lang.String r4 = "Load start in new-version-policy."
            com.huawei.hms.ads.uiengineloader.aa.b(r0, r4)     // Catch: java.lang.Exception -> L67 com.huawei.hms.ads.dynamic.DynamicModule.LoadingException -> La6
            com.huawei.hms.ads.dynamic.DynamicModule r8 = a(r8, r10, r9, r11)     // Catch: java.lang.Exception -> L67 com.huawei.hms.ads.dynamic.DynamicModule.LoadingException -> La6
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L67 com.huawei.hms.ads.dynamic.DynamicModule.LoadingException -> La6
            long r4 = r4 - r2
            com.huawei.hms.ads.analysis.DynamicLoaderAnalysis r9 = com.huawei.hms.ads.analysis.DynamicLoaderAnalysis.getInstance()     // Catch: java.lang.Exception -> L67 com.huawei.hms.ads.dynamic.DynamicModule.LoadingException -> La6
            r9.onLoaderSuccess(r10, r4)     // Catch: java.lang.Exception -> L67 com.huawei.hms.ads.dynamic.DynamicModule.LoadingException -> La6
            return r8
        L47:
            java.lang.String r8 = "Do not allow loading on other devices."
            com.huawei.hms.ads.analysis.DynamicLoaderAnalysis r9 = com.huawei.hms.ads.analysis.DynamicLoaderAnalysis.getInstance()     // Catch: java.lang.Exception -> L67 com.huawei.hms.ads.dynamic.DynamicModule.LoadingException -> La6
            r11 = 3
            r9.onLoaderException(r10, r11, r8)     // Catch: java.lang.Exception -> L67 com.huawei.hms.ads.dynamic.DynamicModule.LoadingException -> La6
            com.huawei.hms.ads.dynamic.DynamicModule$LoadingException r9 = new com.huawei.hms.ads.dynamic.DynamicModule$LoadingException     // Catch: java.lang.Exception -> L67 com.huawei.hms.ads.dynamic.DynamicModule.LoadingException -> La6
            r9.<init>(r8)     // Catch: java.lang.Exception -> L67 com.huawei.hms.ads.dynamic.DynamicModule.LoadingException -> La6
            throw r9     // Catch: java.lang.Exception -> L67 com.huawei.hms.ads.dynamic.DynamicModule.LoadingException -> La6
        L57:
            java.lang.String r8 = "HMS not installed."
            com.huawei.hms.ads.analysis.DynamicLoaderAnalysis r9 = com.huawei.hms.ads.analysis.DynamicLoaderAnalysis.getInstance()     // Catch: java.lang.Exception -> L67 com.huawei.hms.ads.dynamic.DynamicModule.LoadingException -> La6
            r11 = 2
            r9.onLoaderException(r10, r11, r8)     // Catch: java.lang.Exception -> L67 com.huawei.hms.ads.dynamic.DynamicModule.LoadingException -> La6
            com.huawei.hms.ads.dynamic.DynamicModule$LoadingException r9 = new com.huawei.hms.ads.dynamic.DynamicModule$LoadingException     // Catch: java.lang.Exception -> L67 com.huawei.hms.ads.dynamic.DynamicModule.LoadingException -> La6
            r9.<init>(r8)     // Catch: java.lang.Exception -> L67 com.huawei.hms.ads.dynamic.DynamicModule.LoadingException -> La6
            throw r9     // Catch: java.lang.Exception -> L67 com.huawei.hms.ads.dynamic.DynamicModule.LoadingException -> La6
        L67:
            r8 = move-exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r11 = "Other exception:"
            r9.<init>(r11)
            java.lang.Class r11 = r8.getClass()
            java.lang.String r11 = r11.getSimpleName()
            r9.append(r11)
            java.lang.String r9 = r9.toString()
            com.huawei.hms.ads.uiengineloader.aa.d(r0, r9)
            com.huawei.hms.ads.analysis.DynamicLoaderAnalysis r9 = com.huawei.hms.ads.analysis.DynamicLoaderAnalysis.getInstance()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r0 = "Other exception, "
            r11.<init>(r0)
            java.lang.Class r8 = r8.getClass()
            java.lang.String r8 = r8.getSimpleName()
            r11.append(r8)
            java.lang.String r8 = r11.toString()
            r9.onLoaderException(r10, r1, r8)
            com.huawei.hms.ads.dynamic.DynamicModule$LoadingException r8 = new com.huawei.hms.ads.dynamic.DynamicModule$LoadingException
            java.lang.String r9 = "Load failed."
            r8.<init>(r9)
            throw r8
        La6:
            r8 = move-exception
            com.huawei.hms.ads.analysis.DynamicLoaderAnalysis r9 = com.huawei.hms.ads.analysis.DynamicLoaderAnalysis.getInstance()
            java.lang.String r11 = r8.getMessage()
            r9.onLoaderException(r10, r1, r11)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.dynamic.DynamicModule.a(android.content.Context, java.lang.Integer, java.lang.String, android.os.Bundle):com.huawei.hms.ads.dynamic.DynamicModule");
    }

    private static DynamicModule a(Context context, String str, Bundle bundle) throws LoadingException {
        g gVar = new g();
        aa.b(f29086a, "new DynamicLoader.");
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        Context a10 = a(context, str, bundle, gVar);
        if (a10 != null) {
            return new DynamicModule(a10);
        }
        throw new LoadingException("New version policy: Failed to get module context: null.");
    }

    private static DynamicModule a(Context context, String str, Integer num, Bundle bundle) throws LoadingException {
        int intValue = num.intValue();
        bundle.putString("module_name", str);
        bundle.putInt("version_strategy_type", intValue);
        try {
            g gVar = new g();
            aa.b(f29086a, "new DynamicLoader.");
            Context a10 = a(context.getApplicationContext() == null ? context : context.getApplicationContext(), str, bundle, gVar);
            if (a10 != null) {
                return new DynamicModule(a10);
            }
            throw new LoadingException("New version policy: Failed to get module context: null.");
        } catch (LoadingException e2) {
            throw e2;
        } catch (Exception e10) {
            aa.d(f29086a, "Other exception," + e10.getClass().getSimpleName());
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            return new DynamicModule(context);
        }
    }

    private static Class<?> a(Context context) throws LoadingException {
        Class<?> cls;
        try {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            cls = context.getClassLoader().loadClass(DynamicLoaderClassLoader.class.getName());
        } catch (ClassNotFoundException unused) {
            aa.c(f29086a, "ClassLoader class not found when use client context.");
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

    private static void a(String str, ClassLoader classLoader) throws LoadingException {
        try {
            f29091f.set(new HashMap<String, IDynamicLoader>((IBinder) classLoader.loadClass(com.huawei.hms.ads.dynamic.a.f29107b).getConstructor(new Class[0]).newInstance(new Object[0])) { // from class: com.huawei.hms.ads.dynamic.DynamicModule.3

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ IBinder f29097b;

                {
                    this.f29097b = r2;
                    put(String.this, IDynamicLoader.Stub.asInterface(r2));
                }
            });
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            throw new LoadingException("Failed to get loader interface:" + e2.getMessage());
        }
    }

    private static Bundle b(Context context, String str) throws LoadingException, a {
        try {
            Bundle queryHMSModuleBundle = queryHMSModuleBundle(context, str);
            String string = queryHMSModuleBundle.getString("loader_path");
            if (!TextUtils.isEmpty(string) && new File(string).exists()) {
                f29090e.set(new HashMap<String, String>(string) { // from class: com.huawei.hms.ads.dynamic.DynamicModule.2

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ String f29095b;

                    {
                        this.f29095b = string;
                        put(String.this, string);
                    }
                });
                aa.b(f29086a, "Query remote version by module name:" + str + " success.");
                return queryHMSModuleBundle;
            }
            aa.c(f29086a, "The loaderPath in query bundle is not available,change the module version to:-100");
            queryHMSModuleBundle.putInt("module_version", -100);
            return queryHMSModuleBundle;
        } catch (LoadingException e2) {
            throw e2;
        } catch (Exception unused) {
            throw new a("failed to Query remote version.", (byte) 0);
        }
    }

    public static Bundle getLocalModuleInfo(Context context, String str) {
        int localVersion = getLocalVersion(context, str);
        Bundle bundle = new Bundle();
        bundle.putString("module_name", str);
        bundle.putInt("local_module_version", localVersion);
        return bundle;
    }

    public static int getLocalVersion(Context context, String str) {
        String str2;
        if (context == null || str.length() == 0 || str.length() > 256) {
            aa.d(f29086a, "Invalid context or moduleName.");
            return 0;
        }
        try {
            String str3 = "com.huawei.hms.ads.dynamic.descriptors." + str + ".ModuleDescriptor";
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            return context.getClassLoader().loadClass(str3).getDeclaredField("MODULE_VERSION").getInt(null);
        } catch (ClassNotFoundException unused) {
            str2 = "Cannot find the class of module descriptor for ".concat(str);
            aa.c(f29086a, str2);
            return 0;
        } catch (Exception e2) {
            str2 = "Get local module info failed." + e2.getClass().getSimpleName();
            aa.c(f29086a, str2);
            return 0;
        }
    }

    public static Bundle getRemoteModuleInfo(Context context, String str) throws LoadingException {
        try {
        } catch (LoadingException e2) {
            throw e2;
        } catch (Exception e10) {
            aa.c(f29086a, "Get remote module info for " + str + " failed." + e10.getClass().getSimpleName());
        }
        synchronized (DynamicModule.class) {
            ThreadLocal<HashMap<String, Boolean>> threadLocal = f29089d;
            if (threadLocal.get() == null || threadLocal.get().get(str) == null || !threadLocal.get().get(str).booleanValue()) {
                Bundle a10 = a(context, str);
                if (a10.getInt("module_version") > 0) {
                    return a10;
                }
            }
            if (threadLocal.get().get(str).booleanValue()) {
                try {
                    return b(context, str);
                } catch (a unused) {
                    aa.c(f29086a, "Query remote module info in HMS failed." + a.class.getSimpleName());
                }
            }
            return new Bundle();
        }
    }

    public static int getRemoteVersion(Context context, String str) throws LoadingException {
        try {
            Bundle b4 = b(context, str);
            if (b4 != null && !b4.isEmpty()) {
                return b4.getInt("module_version");
            }
            aa.c(f29086a, "Query remote module:" + str + " info failed.");
            throw new LoadingException("Query remote module info failed: null or empty.");
        } catch (a unused) {
            aa.c(f29086a, "Query remote module:" + str + " exception:" + a.class.getSimpleName());
            return 0;
        }
    }

    public static DynamicModule load(Context context, Integer num, String str) throws LoadingException {
        if (context != null && num != null && str != null && str.length() != 0 && str.length() <= 256) {
            return a(context, num, str, new Bundle());
        }
        DynamicLoaderAnalysis.getInstance().onLoaderException(str, 1, "Null param, please check it.");
        throw new LoadingException("Null param, please check it.");
    }

    public static Bundle queryHMSModuleBundle(Context context, String str) throws LoadingException, a {
        byte b4 = 0;
        try {
            ContentResolver contentResolver = context.getContentResolver();
            if (contentResolver == null) {
                throw new a("Query remote version failed: null contentResolver.", b4);
            }
            Bundle call = contentResolver.call(Uri.parse("content://com.huawei.hms"), str, (String) null, (Bundle) null);
            if (call == null) {
                aa.c(f29086a, "Failed to get bundle info:null.");
                throw new a("Query remote version failed: null bundle info.", b4);
            }
            int i10 = call.getInt("errcode");
            call.getString("loader_path");
            aa.b(f29086a, "bundle info: errorCode:" + i10 + ", moduleVersion:" + call.getInt("module_version") + ", loader_version:" + call.getInt("loader_version") + ", armeabiType:" + call.getInt("armeabiType"));
            if (i10 == 0) {
                return call;
            }
            aa.c(f29086a, "Failed to get " + str + " bundle info, errcode:" + i10);
            throw new LoadingException("Query " + str + " unavailable, errorCode:" + i10, call);
        } catch (LoadingException e2) {
            throw e2;
        } catch (Exception unused) {
            throw new a("failed to get :" + str + " info.", b4);
        }
    }

    public final Context getModuleContext() {
        return this.f29092g;
    }
}
