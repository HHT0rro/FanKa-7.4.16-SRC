package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.huawei.openalliance.ad.constant.u;
import dalvik.system.DelegateLastClassLoader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class DynamiteModule {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public static Boolean f23764b = null;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public static zzk f23765c = null;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public static zzm f23766d = null;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public static String f23767e = null;

    /* renamed from: f, reason: collision with root package name */
    public static int f23768f = -1;

    /* renamed from: g, reason: collision with root package name */
    public static final ThreadLocal<b> f23769g = new ThreadLocal<>();

    /* renamed from: h, reason: collision with root package name */
    public static final a.b f23770h = new com.google.android.gms.dynamite.b();

    /* renamed from: i, reason: collision with root package name */
    @RecentlyNonNull
    public static final a f23771i = new com.google.android.gms.dynamite.a();

    /* renamed from: j, reason: collision with root package name */
    @RecentlyNonNull
    public static final a f23772j = new d();

    /* renamed from: k, reason: collision with root package name */
    @RecentlyNonNull
    public static final a f23773k = new com.google.android.gms.dynamite.c();

    /* renamed from: l, reason: collision with root package name */
    @RecentlyNonNull
    public static final a f23774l = new f();

    /* renamed from: m, reason: collision with root package name */
    @RecentlyNonNull
    public static final a f23775m = new e();

    /* renamed from: n, reason: collision with root package name */
    @RecentlyNonNull
    public static final a f23776n = new h();

    /* renamed from: o, reason: collision with root package name */
    public static final a f23777o = new g();

    /* renamed from: a, reason: collision with root package name */
    public final Context f23778a;

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    @DynamiteApi
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class DynamiteLoaderClassLoader {

        @RecentlyNullable
        public static ClassLoader sClassLoader;
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class LoadingException extends Exception {
        private LoadingException(String str) {
            super(str);
        }

        private LoadingException(String str, Throwable th) {
            super(str, th);
        }

        public /* synthetic */ LoadingException(String str, com.google.android.gms.dynamite.b bVar) {
            this(str);
        }

        public /* synthetic */ LoadingException(String str, Throwable th, com.google.android.gms.dynamite.b bVar) {
            this(str, th);
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {

        /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
        /* renamed from: com.google.android.gms.dynamite.DynamiteModule$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public static class C0217a {

            /* renamed from: a, reason: collision with root package name */
            public int f23779a = 0;

            /* renamed from: b, reason: collision with root package name */
            public int f23780b = 0;

            /* renamed from: c, reason: collision with root package name */
            public int f23781c = 0;
        }

        /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public interface b {
            int a(Context context, String str, boolean z10) throws LoadingException;

            int b(Context context, String str);
        }

        C0217a a(Context context, String str, b bVar) throws LoadingException;
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public Cursor f23782a;

        public b() {
        }

        public /* synthetic */ b(com.google.android.gms.dynamite.b bVar) {
            this();
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class c implements a.b {

        /* renamed from: a, reason: collision with root package name */
        public final int f23783a;

        /* renamed from: b, reason: collision with root package name */
        public final int f23784b = 0;

        public c(int i10, int i11) {
            this.f23783a = i10;
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.a.b
        public final int a(Context context, String str, boolean z10) {
            return 0;
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.a.b
        public final int b(Context context, String str) {
            return this.f23783a;
        }
    }

    public DynamiteModule(Context context) {
        this.f23778a = (Context) com.google.android.gms.common.internal.h.h(context);
    }

    @RecentlyNonNull
    public static int a(@RecentlyNonNull Context context, @RecentlyNonNull String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 61);
            sb2.append("com.google.android.gms.dynamite.descriptors.");
            sb2.append(str);
            sb2.append(".ModuleDescriptor");
            Class<?> loadClass = classLoader.loadClass(sb2.toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (!com.google.android.gms.common.internal.g.a(declaredField.get(null), str)) {
                String valueOf = String.valueOf(declaredField.get(null));
                StringBuilder sb3 = new StringBuilder(valueOf.length() + 51 + String.valueOf(str).length());
                sb3.append("Module descriptor id '");
                sb3.append(valueOf);
                sb3.append("' didn't match expected id '");
                sb3.append(str);
                sb3.append("'");
                return 0;
            }
            return declaredField2.getInt(null);
        } catch (ClassNotFoundException unused) {
            StringBuilder sb4 = new StringBuilder(String.valueOf(str).length() + 45);
            sb4.append("Local module descriptor class for ");
            sb4.append(str);
            sb4.append(" not found.");
            return 0;
        } catch (Exception e2) {
            String valueOf2 = String.valueOf(e2.getMessage());
            if (valueOf2.length() != 0) {
                "Failed to load module descriptor class: ".concat(valueOf2);
            }
            return 0;
        }
    }

    @RecentlyNonNull
    public static DynamiteModule c(@RecentlyNonNull Context context, @RecentlyNonNull a aVar, @RecentlyNonNull String str) throws LoadingException {
        ThreadLocal<b> threadLocal = f23769g;
        b bVar = threadLocal.get();
        com.google.android.gms.dynamite.b bVar2 = null;
        b bVar3 = new b(bVar2);
        threadLocal.set(bVar3);
        try {
            a.C0217a a10 = aVar.a(context, str, f23770h);
            int i10 = a10.f23779a;
            int i11 = a10.f23780b;
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str).length());
            sb2.append("Considering local module ");
            sb2.append(str);
            sb2.append(u.bD);
            sb2.append(i10);
            sb2.append(" and remote module ");
            sb2.append(str);
            sb2.append(u.bD);
            sb2.append(i11);
            int i12 = a10.f23781c;
            if (i12 == 0 || ((i12 == -1 && a10.f23779a == 0) || (i12 == 1 && a10.f23780b == 0))) {
                int i13 = a10.f23779a;
                int i14 = a10.f23780b;
                StringBuilder sb3 = new StringBuilder(91);
                sb3.append("No acceptable module found. Local version is ");
                sb3.append(i13);
                sb3.append(" and remote version is ");
                sb3.append(i14);
                sb3.append(".");
                throw new LoadingException(sb3.toString(), bVar2);
            }
            if (i12 == -1) {
                DynamiteModule e2 = e(context, str);
                Cursor cursor = bVar3.f23782a;
                if (cursor != null) {
                    cursor.close();
                }
                threadLocal.set(bVar);
                return e2;
            }
            if (i12 == 1) {
                try {
                    DynamiteModule f10 = f(context, str, a10.f23780b);
                    Cursor cursor2 = bVar3.f23782a;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    threadLocal.set(bVar);
                    return f10;
                } catch (LoadingException e10) {
                    String valueOf = String.valueOf(e10.getMessage());
                    if (valueOf.length() != 0) {
                        "Failed to load remote module: ".concat(valueOf);
                    }
                    int i15 = a10.f23779a;
                    if (i15 != 0 && aVar.a(context, str, new c(i15, 0)).f23781c == -1) {
                        DynamiteModule e11 = e(context, str);
                        Cursor cursor3 = bVar3.f23782a;
                        if (cursor3 != null) {
                            cursor3.close();
                        }
                        f23769g.set(bVar);
                        return e11;
                    }
                    throw new LoadingException("Remote load failed. No local fallback found.", e10, bVar2);
                }
            }
            int i16 = a10.f23781c;
            StringBuilder sb4 = new StringBuilder(47);
            sb4.append("VersionPolicy returned invalid code:");
            sb4.append(i16);
            throw new LoadingException(sb4.toString(), bVar2);
        } catch (Throwable th) {
            Cursor cursor4 = bVar3.f23782a;
            if (cursor4 != null) {
                cursor4.close();
            }
            f23769g.set(bVar);
            throw th;
        }
    }

    @RecentlyNonNull
    public static int d(@RecentlyNonNull Context context, @RecentlyNonNull String str, @RecentlyNonNull boolean z10) {
        Field declaredField;
        ClassLoader aVar;
        try {
            synchronized (DynamiteModule.class) {
                Boolean bool = f23764b;
                if (bool == null) {
                    try {
                        declaredField = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName()).getDeclaredField("sClassLoader");
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e2) {
                        String valueOf = String.valueOf(e2);
                        StringBuilder sb2 = new StringBuilder(valueOf.length() + 30);
                        sb2.append("Failed to load module via V2: ");
                        sb2.append(valueOf);
                        bool = Boolean.FALSE;
                    }
                    synchronized (declaredField.getDeclaringClass()) {
                        ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                        if (classLoader != null) {
                            if (classLoader == ClassLoader.getSystemClassLoader()) {
                                bool = Boolean.FALSE;
                            } else {
                                try {
                                    i(classLoader);
                                } catch (LoadingException unused) {
                                }
                                bool = Boolean.TRUE;
                            }
                        } else if ("com.google.android.gms".equals(context.getApplicationContext().getPackageName())) {
                            declaredField.set(null, ClassLoader.getSystemClassLoader());
                            bool = Boolean.FALSE;
                        } else {
                            try {
                                int m10 = m(context, str, z10);
                                String str2 = f23767e;
                                if (str2 != null && !str2.isEmpty()) {
                                    if (Build.VERSION.SDK_INT >= 29) {
                                        aVar = new DelegateLastClassLoader((String) com.google.android.gms.common.internal.h.h(f23767e), ClassLoader.getSystemClassLoader());
                                    } else {
                                        aVar = new e7.a((String) com.google.android.gms.common.internal.h.h(f23767e), ClassLoader.getSystemClassLoader());
                                    }
                                    i(aVar);
                                    declaredField.set(null, aVar);
                                    f23764b = Boolean.TRUE;
                                    return m10;
                                }
                                return m10;
                            } catch (LoadingException unused2) {
                                declaredField.set(null, ClassLoader.getSystemClassLoader());
                                bool = Boolean.FALSE;
                            }
                        }
                        f23764b = bool;
                    }
                }
                if (bool.booleanValue()) {
                    try {
                        return m(context, str, z10);
                    } catch (LoadingException e10) {
                        String valueOf2 = String.valueOf(e10.getMessage());
                        if (valueOf2.length() == 0) {
                            return 0;
                        }
                        "Failed to retrieve remote module version: ".concat(valueOf2);
                        return 0;
                    }
                }
                return k(context, str, z10);
            }
        } catch (Throwable th) {
            b7.e.a(context, th);
            throw th;
        }
    }

    public static DynamiteModule e(Context context, String str) {
        String valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            "Selected local version of ".concat(valueOf);
        }
        return new DynamiteModule(context.getApplicationContext());
    }

    public static DynamiteModule f(Context context, String str, int i10) throws LoadingException {
        Boolean bool;
        IObjectWrapper zza;
        com.google.android.gms.dynamite.b bVar = null;
        try {
            synchronized (DynamiteModule.class) {
                bool = f23764b;
            }
            if (bool != null) {
                if (bool.booleanValue()) {
                    return l(context, str, i10);
                }
                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 51);
                sb2.append("Selected remote version of ");
                sb2.append(str);
                sb2.append(", version >= ");
                sb2.append(i10);
                zzk g3 = g(context);
                if (g3 != null) {
                    int zzb = g3.zzb();
                    if (zzb >= 3) {
                        b bVar2 = f23769g.get();
                        if (bVar2 != null) {
                            zza = g3.zza(ObjectWrapper.wrap(context), str, i10, ObjectWrapper.wrap(bVar2.f23782a));
                        } else {
                            throw new LoadingException("No cached result cursor holder", bVar);
                        }
                    } else if (zzb == 2) {
                        zza = g3.zzb(ObjectWrapper.wrap(context), str, i10);
                    } else {
                        zza = g3.zza(ObjectWrapper.wrap(context), str, i10);
                    }
                    if (ObjectWrapper.unwrap(zza) != null) {
                        return new DynamiteModule((Context) ObjectWrapper.unwrap(zza));
                    }
                    throw new LoadingException("Failed to load remote module.", bVar);
                }
                throw new LoadingException("Failed to create IDynamiteLoader.", bVar);
            }
            throw new LoadingException("Failed to determine which loading route to use.", bVar);
        } catch (RemoteException e2) {
            throw new LoadingException("Failed to load remote module.", e2, bVar);
        } catch (LoadingException e10) {
            throw e10;
        } catch (Throwable th) {
            b7.e.a(context, th);
            throw new LoadingException("Failed to load remote module.", th, bVar);
        }
    }

    @Nullable
    public static zzk g(Context context) {
        zzk zzjVar;
        synchronized (DynamiteModule.class) {
            zzk zzkVar = f23765c;
            if (zzkVar != null) {
                return zzkVar;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzjVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    if (queryLocalInterface instanceof zzk) {
                        zzjVar = (zzk) queryLocalInterface;
                    } else {
                        zzjVar = new zzj(iBinder);
                    }
                }
                if (zzjVar != null) {
                    f23765c = zzjVar;
                    return zzjVar;
                }
            } catch (Exception e2) {
                String valueOf = String.valueOf(e2.getMessage());
                if (valueOf.length() != 0) {
                    "Failed to load IDynamiteLoader from GmsCore: ".concat(valueOf);
                }
            }
            return null;
        }
    }

    public static Boolean h() {
        Boolean valueOf;
        synchronized (DynamiteModule.class) {
            valueOf = Boolean.valueOf(f23768f >= 2);
        }
        return valueOf;
    }

    public static void i(ClassLoader classLoader) throws LoadingException {
        zzm zzlVar;
        com.google.android.gms.dynamite.b bVar = null;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                zzlVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof zzm) {
                    zzlVar = (zzm) queryLocalInterface;
                } else {
                    zzlVar = new zzl(iBinder);
                }
            }
            f23766d = zzlVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            throw new LoadingException("Failed to instantiate dynamite loader", e2, bVar);
        }
    }

    public static boolean j(Cursor cursor) {
        b bVar = f23769g.get();
        if (bVar == null || bVar.f23782a != null) {
            return false;
        }
        bVar.f23782a = cursor;
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0031, code lost:
    
        if (j(r5) != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int k(android.content.Context r5, java.lang.String r6, boolean r7) {
        /*
            com.google.android.gms.dynamite.zzk r0 = g(r5)
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            r2 = 0
            int r3 = r0.zzb()     // Catch: java.lang.Throwable -> L5c android.os.RemoteException -> L5e
            r4 = 3
            if (r3 < r4) goto L47
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r5)     // Catch: java.lang.Throwable -> L5c android.os.RemoteException -> L5e
            com.google.android.gms.dynamic.IObjectWrapper r5 = r0.zzc(r5, r6, r7)     // Catch: java.lang.Throwable -> L5c android.os.RemoteException -> L5e
            java.lang.Object r5 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r5)     // Catch: java.lang.Throwable -> L5c android.os.RemoteException -> L5e
            android.database.Cursor r5 = (android.database.Cursor) r5     // Catch: java.lang.Throwable -> L5c android.os.RemoteException -> L5e
            if (r5 == 0) goto L41
            boolean r6 = r5.moveToFirst()     // Catch: java.lang.Throwable -> L3b android.os.RemoteException -> L3e
            if (r6 != 0) goto L27
            goto L41
        L27:
            int r6 = r5.getInt(r1)     // Catch: java.lang.Throwable -> L3b android.os.RemoteException -> L3e
            if (r6 <= 0) goto L34
            boolean r7 = j(r5)     // Catch: java.lang.Throwable -> L3b android.os.RemoteException -> L3e
            if (r7 == 0) goto L34
            goto L35
        L34:
            r2 = r5
        L35:
            if (r2 == 0) goto L3a
            r2.close()
        L3a:
            return r6
        L3b:
            r6 = move-exception
            r2 = r5
            goto L78
        L3e:
            r6 = move-exception
            r2 = r5
            goto L5f
        L41:
            if (r5 == 0) goto L46
            r5.close()
        L46:
            return r1
        L47:
            r4 = 2
            if (r3 != r4) goto L53
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r5)     // Catch: java.lang.Throwable -> L5c android.os.RemoteException -> L5e
            int r5 = r0.zzb(r5, r6, r7)     // Catch: java.lang.Throwable -> L5c android.os.RemoteException -> L5e
            return r5
        L53:
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r5)     // Catch: java.lang.Throwable -> L5c android.os.RemoteException -> L5e
            int r5 = r0.zza(r5, r6, r7)     // Catch: java.lang.Throwable -> L5c android.os.RemoteException -> L5e
            return r5
        L5c:
            r6 = move-exception
            goto L78
        L5e:
            r6 = move-exception
        L5f:
            java.lang.String r5 = "Failed to retrieve remote module version: "
            java.lang.String r6 = r6.getMessage()     // Catch: java.lang.Throwable -> L5c
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch: java.lang.Throwable -> L5c
            int r7 = r6.length()     // Catch: java.lang.Throwable -> L5c
            if (r7 == 0) goto L72
            r5.concat(r6)     // Catch: java.lang.Throwable -> L5c
        L72:
            if (r2 == 0) goto L77
            r2.close()
        L77:
            return r1
        L78:
            if (r2 == 0) goto L7d
            r2.close()
        L7d:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.k(android.content.Context, java.lang.String, boolean):int");
    }

    public static DynamiteModule l(Context context, String str, int i10) throws LoadingException, RemoteException {
        zzm zzmVar;
        IObjectWrapper zza;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 51);
        sb2.append("Selected remote version of ");
        sb2.append(str);
        sb2.append(", version >= ");
        sb2.append(i10);
        synchronized (DynamiteModule.class) {
            zzmVar = f23766d;
        }
        com.google.android.gms.dynamite.b bVar = null;
        if (zzmVar != null) {
            b bVar2 = f23769g.get();
            if (bVar2 != null && bVar2.f23782a != null) {
                Context applicationContext = context.getApplicationContext();
                Cursor cursor = bVar2.f23782a;
                ObjectWrapper.wrap(null);
                if (h().booleanValue()) {
                    zza = zzmVar.zzb(ObjectWrapper.wrap(applicationContext), str, i10, ObjectWrapper.wrap(cursor));
                } else {
                    zza = zzmVar.zza(ObjectWrapper.wrap(applicationContext), str, i10, ObjectWrapper.wrap(cursor));
                }
                Context context2 = (Context) ObjectWrapper.unwrap(zza);
                if (context2 != null) {
                    return new DynamiteModule(context2);
                }
                throw new LoadingException("Failed to get module context", bVar);
            }
            throw new LoadingException("No result cursor", bVar);
        }
        throw new LoadingException("DynamiteLoaderV2 was not cached.", bVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x006c, code lost:
    
        if (j(r8) != false) goto L27;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x009f  */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.dynamite.b] */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m(android.content.Context r8, java.lang.String r9, boolean r10) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            r0 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c
            if (r10 == 0) goto La
            java.lang.String r8 = "api_force_staging"
            goto Lc
        La:
            java.lang.String r8 = "api"
        Lc:
            int r10 = r8.length()     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c
            int r10 = r10 + 42
            java.lang.String r2 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c
            int r2 = r2.length()     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c
            int r10 = r10 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c
            r2.<init>(r10)     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c
            java.lang.String r10 = "content://com.google.android.gms.chimera/"
            r2.append(r10)     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c
            r2.append(r8)     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c
            java.lang.String r8 = "/"
            r2.append(r8)     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c
            r2.append(r9)     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c
            java.lang.String r8 = r2.toString()     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c
            android.net.Uri r2 = android.net.Uri.parse(r8)     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c
            if (r8 == 0) goto L82
            boolean r9 = r8.moveToFirst()     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            if (r9 == 0) goto L82
            r9 = 0
            int r9 = r8.getInt(r9)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            if (r9 <= 0) goto L72
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r10 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r10)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            r1 = 2
            java.lang.String r1 = r8.getString(r1)     // Catch: java.lang.Throwable -> L6f
            com.google.android.gms.dynamite.DynamiteModule.f23767e = r1     // Catch: java.lang.Throwable -> L6f
            java.lang.String r1 = "loaderVersion"
            int r1 = r8.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L6f
            if (r1 < 0) goto L67
            int r1 = r8.getInt(r1)     // Catch: java.lang.Throwable -> L6f
            com.google.android.gms.dynamite.DynamiteModule.f23768f = r1     // Catch: java.lang.Throwable -> L6f
        L67:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L6f
            boolean r10 = j(r8)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            if (r10 == 0) goto L72
            goto L73
        L6f:
            r9 = move-exception
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L6f
            throw r9     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
        L72:
            r0 = r8
        L73:
            if (r0 == 0) goto L78
            r0.close()
        L78:
            return r9
        L79:
            r9 = move-exception
            r0 = r8
            r8 = r9
            goto L9d
        L7d:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            goto L8e
        L82:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r9 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            java.lang.String r10 = "Failed to connect to dynamite module ContentResolver."
            r9.<init>(r10, r0)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            throw r9     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
        L8a:
            r8 = move-exception
            goto L9d
        L8c:
            r8 = move-exception
            r9 = r0
        L8e:
            boolean r10 = r8 instanceof com.google.android.gms.dynamite.DynamiteModule.LoadingException     // Catch: java.lang.Throwable -> L9b
            if (r10 == 0) goto L93
            throw r8     // Catch: java.lang.Throwable -> L9b
        L93:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r10 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch: java.lang.Throwable -> L9b
            java.lang.String r1 = "V2 version check failed"
            r10.<init>(r1, r8, r0)     // Catch: java.lang.Throwable -> L9b
            throw r10     // Catch: java.lang.Throwable -> L9b
        L9b:
            r8 = move-exception
            r0 = r9
        L9d:
            if (r0 == 0) goto La2
            r0.close()
        La2:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.m(android.content.Context, java.lang.String, boolean):int");
    }

    @RecentlyNonNull
    public final IBinder b(@RecentlyNonNull String str) throws LoadingException {
        try {
            return (IBinder) this.f23778a.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e2) {
            String valueOf = String.valueOf(str);
            throw new LoadingException(valueOf.length() != 0 ? "Failed to instantiate module class: ".concat(valueOf) : new String("Failed to instantiate module class: "), e2, null);
        }
    }
}
