package com.huawei.hms.ads.dynamicloader;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.ads.uiengineloader.aa;
import com.huawei.hms.ads.uiengineloader.l;
import com.huawei.hms.ads.uiengineloader.v;
import com.huawei.hms.hmsscankit.ScanUtil;
import java.io.File;
import java.util.Arrays;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static final String f29165a = "h";

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f29166b = {"b4ec5c5bc95f125d5d586b54a5a40abd38b44201fe8fe3cd295cb3c64f422c3c"};

    /* renamed from: c, reason: collision with root package name */
    private static volatile h f29167c;

    /* renamed from: d, reason: collision with root package name */
    private final Context f29168d;

    private h(Context context) {
        this.f29168d = context.getApplicationContext() != null ? context.getApplicationContext() : context;
    }

    public static Context a(Context context, Bundle bundle) {
        if (bundle == null) {
            aa.d(f29165a, "Failed to read query result");
            return null;
        }
        String str = f29165a;
        aa.b(str, "createModuleContext");
        String string = bundle.getString("module_path");
        if (TextUtils.isEmpty(string) || !new File(string).exists()) {
            aa.c(str, "The module path is invalid.");
            return null;
        }
        if (!v.a((List<String>) Arrays.asList(f29166b), v.a(context, string))) {
            aa.c(str, "uiengine apk is invalid.");
            return null;
        }
        new l();
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        String string2 = bundle.getString("loader_version_type", b.f29144f);
        aa.b(str, "loaderType :  ".concat(String.valueOf(string2)));
        int i10 = bundle.getInt("armeabiType");
        Context iVar = "v2".equals(string2) ? new i(context, string, i10) : new e(context, string, i10);
        try {
            iVar.getClassLoader().loadClass("com.huawei.hms.ads.DynamicModuleInitializer").getDeclaredMethod(ScanUtil.CONTEXT_METHOD, Context.class).invoke(null, iVar);
        } catch (Exception e2) {
            aa.b(l.f29452a, "failed to init Module " + e2.getClass().getSimpleName());
        }
        return iVar;
    }

    public static h a(Context context) {
        h hVar;
        if (f29167c != null) {
            return f29167c;
        }
        synchronized (h.class) {
            if (f29167c == null) {
                f29167c = new h(context);
            }
            hVar = f29167c;
        }
        return hVar;
    }

    private static boolean a(Context context, String str) {
        return v.a((List<String>) Arrays.asList(f29166b), v.a(context, str));
    }
}
