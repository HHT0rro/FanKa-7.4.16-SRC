package com.qq.e.comm.managers.plugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.qq.e.comm.constants.Sig;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class PM {

    /* renamed from: q, reason: collision with root package name */
    private static final Map<Class<?>, String> f38276q = new b();

    /* renamed from: b, reason: collision with root package name */
    private final Context f38278b;

    /* renamed from: c, reason: collision with root package name */
    private String f38279c;

    /* renamed from: d, reason: collision with root package name */
    private File f38280d;

    /* renamed from: e, reason: collision with root package name */
    private volatile int f38281e;

    /* renamed from: f, reason: collision with root package name */
    private DexClassLoader f38282f;

    /* renamed from: g, reason: collision with root package name */
    private RandomAccessFile f38283g;

    /* renamed from: h, reason: collision with root package name */
    private FileLock f38284h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f38285i;

    /* renamed from: j, reason: collision with root package name */
    private final f f38286j;

    /* renamed from: k, reason: collision with root package name */
    private volatile POFactory f38287k;

    /* renamed from: l, reason: collision with root package name */
    private int f38288l;

    /* renamed from: m, reason: collision with root package name */
    private Future<Boolean> f38289m;

    /* renamed from: o, reason: collision with root package name */
    private boolean f38291o;

    /* renamed from: p, reason: collision with root package name */
    private String f38292p;

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f38277a = Executors.newSingleThreadExecutor();

    /* renamed from: n, reason: collision with root package name */
    private boolean f38290n = false;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a implements Callable<Boolean> {
        public a() {
        }

        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            if (!PM.this.f38285i) {
                PM pm = PM.this;
                pm.f38285i = pm.tryLockUpdate();
            }
            if (PM.b(PM.this)) {
                PM.c(PM.this);
            }
            PM.this.f38288l = (int) (System.currentTimeMillis() - currentTimeMillis);
            return Boolean.TRUE;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b extends HashMap<Class<?>, String> {
        public b() {
            put(POFactory.class, "com.qq.e.comm.plugin.POFactoryImpl");
        }
    }

    public PM(Context context, f fVar) {
        this.f38278b = context.getApplicationContext();
        this.f38286j = fVar;
        com.qq.e.comm.managers.plugin.b.a(context);
        d();
    }

    private JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            int pluginVersion = getPluginVersion();
            if (pluginVersion > 10000) {
                jSONObject.put("vas", this.f38292p);
            }
            jSONObject.put("pv", pluginVersion);
            jSONObject.put(INoCaptchaComponent.sig, this.f38279c);
            jSONObject.put("appId", com.qq.e.comm.managers.b.b().a());
            jSONObject.put("pn", com.qq.e.comm.managers.plugin.b.a(this.f38278b));
            jSONObject.put("ict", this.f38288l);
            jSONObject.put("mup", this.f38285i);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private boolean b() {
        if (!this.f38285i) {
            return false;
        }
        try {
            Context context = this.f38278b;
            com.qq.e.comm.managers.plugin.b.a(context, h.e(context), h.f(this.f38278b));
            this.f38279c = Sig.ASSET_PLUGIN_SIG;
            this.f38280d = h.e(this.f38278b);
            this.f38281e = SDKStatus.getBuildInPluginVersion();
            return true;
        } catch (Throwable th) {
            GDTLogger.e("插件初始化失败 ");
            com.qq.e.comm.managers.plugin.a.a(th, th.getMessage());
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0028, code lost:
    
        if (r5.b() != false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean b(com.qq.e.comm.managers.plugin.PM r5) {
        /*
            java.lang.String r0 = "TimeStap_AFTER_PLUGIN_INIT:"
            java.util.Objects.requireNonNull(r5)
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L32
            r2.<init>()     // Catch: java.lang.Throwable -> L32
            java.lang.String r3 = "TimeStap_BEFORE_PLUGIN_INIT:"
            r2.append(r3)     // Catch: java.lang.Throwable -> L32
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L32
            r2.append(r3)     // Catch: java.lang.Throwable -> L32
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L32
            com.qq.e.comm.util.GDTLogger.d(r2)     // Catch: java.lang.Throwable -> L32
            boolean r2 = r5.c()     // Catch: java.lang.Throwable -> L32
            if (r2 != 0) goto L2a
            boolean r5 = r5.b()     // Catch: java.lang.Throwable -> L32
            if (r5 == 0) goto L2c
        L2a:
            r5 = 1
            r1 = 1
        L2c:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            goto L44
        L32:
            r5 = move-exception
            java.lang.String r2 = "插件加载出现异常"
            com.qq.e.comm.util.GDTLogger.e(r2, r5)     // Catch: java.lang.Throwable -> L56
            java.lang.String r2 = r5.getMessage()     // Catch: java.lang.Throwable -> L56
            com.qq.e.comm.managers.plugin.a.a(r5, r2)     // Catch: java.lang.Throwable -> L56
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
        L44:
            r5.append(r0)
            long r2 = java.lang.System.currentTimeMillis()
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            com.qq.e.comm.util.GDTLogger.d(r5)
            return r1
        L56:
            r5 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            long r2 = java.lang.System.currentTimeMillis()
            r1.append(r2)
            java.lang.String r0 = r1.toString()
            com.qq.e.comm.util.GDTLogger.d(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.managers.plugin.PM.b(com.qq.e.comm.managers.plugin.PM):boolean");
    }

    public static void c(PM pm) {
        Objects.requireNonNull(pm);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("PluginFile:\t");
        File file = pm.f38280d;
        sb2.append(file == null ? "null" : file.getAbsolutePath());
        GDTLogger.d(sb2.toString());
        if (pm.f38279c == null || pm.f38280d == null) {
            pm.f38282f = null;
            return;
        }
        try {
            pm.f38282f = new DexClassLoader(pm.f38280d.getAbsolutePath(), h.a(pm.f38278b).getAbsolutePath(), null, pm.getClass().getClassLoader());
            f fVar = pm.f38286j;
            if (fVar != null) {
                fVar.a();
            }
        } catch (Throwable th) {
            GDTLogger.e("插件ClassLoader构造发生异常", th);
            f fVar2 = pm.f38286j;
            if (fVar2 != null) {
                fVar2.b();
            }
            com.qq.e.comm.managers.plugin.a.a(th, th.getMessage());
        }
    }

    private boolean c() {
        if (this.f38291o) {
            return false;
        }
        if (this.f38285i) {
            g gVar = new g(h.c(this.f38278b), h.d(this.f38278b));
            if (gVar.a()) {
                GDTLogger.d("NextExist,Updated=" + gVar.a(h.e(this.f38278b), h.f(this.f38278b)));
            }
        }
        g gVar2 = new g(h.e(this.f38278b), h.f(this.f38278b));
        if (!gVar2.a()) {
            return false;
        }
        if (gVar2.c() >= SDKStatus.getBuildInPluginVersion()) {
            this.f38279c = gVar2.b();
            this.f38281e = gVar2.c();
            this.f38280d = h.e(this.f38278b);
            this.f38292p = gVar2.d();
            this.f38290n = true;
            return true;
        }
        GDTLogger.d("last updated plugin version =" + this.f38281e + ";asset plugin version=" + SDKStatus.getBuildInPluginVersion());
        return false;
    }

    private void d() {
        this.f38290n = false;
        SharedPreferences sharedPreferences = this.f38278b.getSharedPreferences("start_crash", 0);
        if (sharedPreferences.getInt("crash_count", 0) >= 2) {
            this.f38291o = true;
            sharedPreferences.edit().remove("crash_count").commit();
            GDTLogger.e("加载本地插件");
        }
        this.f38289m = this.f38277a.submit(new a());
    }

    public <T> T getFactory(Class<T> cls) throws e {
        Future<Boolean> future = this.f38289m;
        if (future != null) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        GDTLogger.d("GetFactoryInstaceforInterface:" + ((Object) cls));
        ClassLoader classLoader = Sig.ASSET_PLUGIN_SIG == null ? PM.class.getClassLoader() : this.f38282f;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("PluginClassLoader is parent");
        sb2.append(PM.class.getClassLoader() == classLoader);
        GDTLogger.d(sb2.toString());
        if (classLoader == null) {
            throw new e("Fail to init GDTADPLugin,PluginClassLoader == null;while loading factory impl for:" + ((Object) cls));
        }
        try {
            String str = f38276q.get(cls);
            if (TextUtils.isEmpty(str)) {
                throw new e("factory  implemention name is not specified for interface:" + cls.getName());
            }
            Class<?> loadClass = classLoader.loadClass(str);
            T cast = cls.cast(loadClass.getDeclaredMethod("getInstance", Context.class, JSONObject.class).invoke(loadClass, this.f38278b, a()));
            GDTLogger.d("ServiceDelegateFactory =" + ((Object) cast));
            return cast;
        } catch (Throwable th) {
            throw new e("Fail to getfactory implement instance for interface:" + cls.getName(), th);
        }
    }

    public POFactory getPOFactory() throws e {
        if (this.f38287k == null) {
            synchronized (this) {
                if (this.f38287k == null) {
                    try {
                        this.f38287k = (POFactory) getFactory(POFactory.class);
                    } catch (e e2) {
                        if (!this.f38290n) {
                            throw e2;
                        }
                        GDTLogger.e("插件加载错误，回退到内置版本");
                        this.f38291o = true;
                        d();
                        this.f38287k = (POFactory) getFactory(POFactory.class);
                    }
                }
            }
        }
        return this.f38287k;
    }

    public int getPluginVersion() {
        Future<Boolean> future = this.f38289m;
        if (future != null) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        return this.f38281e;
    }

    public boolean tryLockUpdate() {
        try {
            File b4 = h.b(this.f38278b);
            if (!b4.exists()) {
                b4.createNewFile();
                h.a("lock", b4);
            }
            if (!b4.exists()) {
                return false;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(b4, "rw");
            this.f38283g = randomAccessFile;
            FileLock tryLock = randomAccessFile.getChannel().tryLock();
            this.f38284h = tryLock;
            if (tryLock == null) {
                return false;
            }
            this.f38283g.writeByte(37);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
