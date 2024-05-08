package com.huawei.hms.ads.uiengineloader;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.huawei.hms.ads.dynamic.IDynamicLoader;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class p implements q {

    /* renamed from: a, reason: collision with root package name */
    private static final String f29462a = "ads_HMSLoadStrategy";

    /* renamed from: b, reason: collision with root package name */
    private static final String f29463b = "content://com.huawei.hms";

    /* renamed from: c, reason: collision with root package name */
    private static final String f29464c = "huawei_module_dynamicloader";

    /* renamed from: d, reason: collision with root package name */
    private static final String f29465d = "errcode";

    /* renamed from: e, reason: collision with root package name */
    private static final String f29466e = "loader_version";

    /* renamed from: f, reason: collision with root package name */
    private static final int f29467f = 0;

    /* renamed from: g, reason: collision with root package name */
    private static final int f29468g = 1;

    /* renamed from: h, reason: collision with root package name */
    private static final int f29469h = 6;

    /* renamed from: i, reason: collision with root package name */
    private static HashMap<String, Bundle> f29470i = new HashMap<>();

    private static void a(Context context, t tVar, Bundle bundle) {
        if (Build.VERSION.SDK_INT < 31) {
            a(context, tVar.f29482a, 0);
            return;
        }
        boolean a10 = s.a(context, bundle);
        aa.b(f29462a, "android s,  result:".concat(String.valueOf(a10)));
        if (a10) {
            tVar.f29483b = bundle.getString("module_path");
        }
    }

    public static void a(final Context context, final String str, final int i10) {
        new Thread() { // from class: com.huawei.hms.ads.uiengineloader.p.1
            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                try {
                    int b4 = p.b(context, str);
                    aa.b(p.f29462a, "remoteVersion:" + b4 + " localModuleVersion:" + i10);
                    if (b4 > i10) {
                        p.c(context, str);
                    }
                } catch (Throwable th) {
                    aa.c(p.f29462a, "cp error: " + th.getLocalizedMessage());
                }
            }
        }.start();
    }

    public static int b(Context context, String str) throws com.huawei.hms.ads.dynamicloader.j {
        Bundle bundle;
        if (f29470i.containsKey(str) && (bundle = f29470i.get(str)) != null) {
            aa.b(f29462a, "cachedModuleInfo containsKey, version: " + bundle.getInt("module_version"));
            return bundle.getInt("module_version");
        }
        Bundle e2 = e(context, str);
        if (e2 == null) {
            aa.c(f29462a, "Query module bundle info failed: null.");
            return 0;
        }
        if (e2.getInt("errcode") != 0) {
            return 0;
        }
        return e2.getInt("module_version");
    }

    private static Context b(Context context, t tVar) throws com.huawei.hms.ads.dynamicloader.j {
        IDynamicLoader asInterface = IDynamicLoader.Stub.asInterface(r.a(context, tVar.f29486e));
        if (asInterface == null) {
            aa.c(f29462a, "Get iDynamicLoader failed: null.");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("module_name", tVar.f29482a);
        bundle.putString("loader_path", tVar.f29486e);
        bundle.putInt("module_version", tVar.f29485d);
        bundle.putString("loader_version_type", tVar.f29487f);
        return r.a(context, tVar.f29482a, bundle, asInterface);
    }

    public static /* synthetic */ void c(Context context, String str) {
        try {
            Bundle e2 = e(context, str);
            if (e2 == null) {
                aa.c(f29462a, "query failed to get bundle info: null.");
                return;
            }
            int i10 = e2.getInt("errcode");
            if (i10 == 1) {
                aa.c(f29462a, "the query module:" + str + " is not existed in HMS.");
                return;
            }
            if (i10 != 0) {
                aa.c(f29462a, "failed to get bundle info for " + str + ", errcode:" + i10);
                return;
            }
            aa.b(f29462a, "Ready to cp module.");
            boolean a10 = s.a(context, e2);
            aa.a(f29462a, "bundle info: errorCode:" + i10 + ", moduleName:" + str + ", moduleVersion:" + e2.getInt("module_version"));
            StringBuilder sb2 = new StringBuilder("cp remote version by module name:");
            sb2.append(str);
            sb2.append(" ,result:");
            sb2.append(a10);
            aa.b(f29462a, sb2.toString());
        } catch (Throwable th) {
            aa.c(f29462a, "Failed to cp remote hms module version." + th.getClass().getSimpleName());
        }
    }

    private static t d(Context context, String str) throws com.huawei.hms.ads.dynamicloader.j {
        Bundle e2;
        t tVar = new t();
        try {
            e2 = e(context, str);
        } catch (com.huawei.hms.ads.dynamicloader.j e10) {
            throw e10;
        } catch (Exception e11) {
            aa.c(f29462a, "Failed to Query remote module version." + e11.getClass().getSimpleName());
        }
        if (e2 == null) {
            aa.c(f29462a, "Failed to get bundle info: null.");
            return tVar;
        }
        int i10 = e2.getInt("errcode");
        if (i10 == 1) {
            aa.c(f29462a, "The query module:" + str + " is not existed in HMS.");
            return tVar;
        }
        if (i10 != 0) {
            aa.c(f29462a, "Failed to get bundle info for " + str + ", errcode:" + i10);
            throw new com.huawei.hms.ads.dynamicloader.j("Query module unavailable, maybe you need to download it.", e2);
        }
        tVar.f29482a = str;
        tVar.f29483b = e2.getString("module_path");
        tVar.f29484c = e2.getString("module_uri_path");
        tVar.f29485d = e2.getInt("module_version");
        tVar.f29486e = e2.getString("loader_path");
        tVar.f29488g = e2.getInt("loader_version");
        tVar.f29489h = e2.getInt("armeabiType");
        aa.b(f29462a, "bundle info: errorCode:" + i10 + ", moduleName:" + str + ", moduleVersion:" + tVar.f29485d);
        if (Build.VERSION.SDK_INT >= 31) {
            boolean a10 = s.a(context, e2);
            aa.b(f29462a, "android s,  result:".concat(String.valueOf(a10)));
            if (a10) {
                tVar.f29483b = e2.getString("module_path");
            }
        } else {
            a(context, tVar.f29482a, 0);
        }
        aa.b(f29462a, "Query remote version by module name:" + str + " success.");
        return tVar;
    }

    private static Bundle e(Context context, String str) {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            if (contentResolver == null) {
                aa.c(f29462a, "Query remote version failed: null contentResolver.");
                return null;
            }
            Bundle call = contentResolver.call(Uri.parse("content://com.huawei.hms"), str, (String) null, (Bundle) null);
            if (call == null) {
                aa.c(f29462a, "query module:" + str + " failed: null.");
                return null;
            }
            int i10 = call.getInt("errcode");
            if (i10 == 0) {
                f29470i.put(str, call);
            }
            aa.b(f29462a, "Query module info result code:".concat(String.valueOf(i10)));
            return call;
        } catch (Exception e2) {
            aa.c(f29462a, "Query module:" + str + " info failed:" + e2.getMessage());
            return null;
        }
    }

    private static void f(Context context, String str) {
        try {
            Bundle e2 = e(context, str);
            if (e2 == null) {
                aa.c(f29462a, "query failed to get bundle info: null.");
                return;
            }
            int i10 = e2.getInt("errcode");
            if (i10 == 1) {
                aa.c(f29462a, "the query module:" + str + " is not existed in HMS.");
                return;
            }
            if (i10 != 0) {
                aa.c(f29462a, "failed to get bundle info for " + str + ", errcode:" + i10);
                return;
            }
            aa.b(f29462a, "Ready to cp module.");
            boolean a10 = s.a(context, e2);
            aa.a(f29462a, "bundle info: errorCode:" + i10 + ", moduleName:" + str + ", moduleVersion:" + e2.getInt("module_version"));
            StringBuilder sb2 = new StringBuilder("cp remote version by module name:");
            sb2.append(str);
            sb2.append(" ,result:");
            sb2.append(a10);
            aa.b(f29462a, sb2.toString());
        } catch (Throwable th) {
            aa.c(f29462a, "Failed to cp remote hms module version." + th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.hms.ads.uiengineloader.q
    public final Context a(Context context, t tVar) throws com.huawei.hms.ads.dynamicloader.j {
        try {
            if (tVar.f29486e.contains("huawei_module_dynamicloader")) {
                Bundle bundle = new Bundle();
                bundle.putString("module_path", tVar.f29483b);
                bundle.putString("module_name", tVar.f29482a);
                bundle.putInt("armeabiType", tVar.f29489h);
                bundle.putString("loader_version_type", tVar.f29487f);
                com.huawei.hms.ads.dynamicloader.h.a(context);
                return com.huawei.hms.ads.dynamicloader.h.a(context, bundle);
            }
            aa.b(f29462a, "The loader is not dynamicLoader，use it to load.");
            IDynamicLoader asInterface = IDynamicLoader.Stub.asInterface(r.a(context, tVar.f29486e));
            if (asInterface == null) {
                aa.c(f29462a, "Get iDynamicLoader failed: null.");
                return null;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("module_name", tVar.f29482a);
            bundle2.putString("loader_path", tVar.f29486e);
            bundle2.putInt("module_version", tVar.f29485d);
            bundle2.putString("loader_version_type", tVar.f29487f);
            return r.a(context, tVar.f29482a, bundle2, asInterface);
        } catch (com.huawei.hms.ads.dynamicloader.j e2) {
            throw e2;
        } catch (Exception unused) {
            aa.d(f29462a, "Load DynamicModule failed.");
            Bundle bundle3 = new Bundle();
            bundle3.putInt("errcode", 6);
            throw new com.huawei.hms.ads.dynamicloader.j("load HMS dynamic module failed.", bundle3);
        }
    }

    @Override // com.huawei.hms.ads.uiengineloader.q
    public final t a(Context context, String str) throws com.huawei.hms.ads.dynamicloader.j {
        return d(context, str);
    }
}
