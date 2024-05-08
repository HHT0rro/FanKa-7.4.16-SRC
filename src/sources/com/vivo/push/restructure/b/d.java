package com.vivo.push.restructure.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.vivo.push.PushConfig;
import com.vivo.push.util.aa;
import com.vivo.push.util.g;
import com.vivo.push.util.u;
import com.vivo.push.util.z;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: PushRelyImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d implements a {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, c> f46324a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private String f46325b;

    /* renamed from: c, reason: collision with root package name */
    private z f46326c;

    /* renamed from: d, reason: collision with root package name */
    private volatile PushConfig f46327d;

    public d(z zVar) {
        this.f46326c = zVar;
    }

    @Override // com.vivo.push.restructure.b.a
    public final String a(Context context, String str) {
        if (!TextUtils.isEmpty(this.f46325b)) {
            return this.f46325b;
        }
        if (context != null && !TextUtils.isEmpty(str)) {
            String packageName = context.getPackageName();
            String a10 = a(context, packageName, str);
            this.f46325b = a10;
            if (TextUtils.isEmpty(a10)) {
                u.d("PushRelyImpl", " reflectReceiver error: receiver for: " + str + " not found, package: " + packageName);
            }
            return this.f46325b;
        }
        u.a("PushRelyImpl", "getReceiverClassName() params error, context = " + ((Object) context) + ", action = " + str);
        return "";
    }

    @Override // com.vivo.push.restructure.b.a
    public final void b() {
        a("");
    }

    @Override // com.vivo.push.restructure.b.a
    public final String c() {
        c cVar = f46324a.get(com.vivo.push.restructure.a.a().b().getPackageName());
        if (cVar != null) {
            String b4 = cVar.b();
            if (!TextUtils.isEmpty(b4)) {
                return b4;
            }
        }
        String c4 = this.f46326c.c();
        if (!TextUtils.isEmpty(c4)) {
            if (cVar == null) {
                cVar = new c();
            }
            cVar.b(c4);
            f46324a.put(com.vivo.push.restructure.a.a().b().getPackageName(), cVar);
        }
        return c4;
    }

    @Override // com.vivo.push.restructure.b.a
    public final void d() {
        b("");
    }

    @Override // com.vivo.push.restructure.b.a
    public final void e() {
        this.f46326c.a();
        f46324a.clear();
    }

    @Override // com.vivo.push.restructure.b.a
    public final String f() {
        return this.f46326c.b("APP_TOKEN", (String) null);
    }

    @Override // com.vivo.push.restructure.b.a
    public final String g() {
        return this.f46326c.b("APP_TAGS", (String) null);
    }

    @Override // com.vivo.push.restructure.b.a
    public final void h() {
        this.f46326c.a("APP_TAGS");
    }

    @Override // com.vivo.push.restructure.b.a
    public final String i() {
        return this.f46326c.b("APP_ALIAS", (String) null);
    }

    @Override // com.vivo.push.restructure.b.a
    public final void j() {
        this.f46326c.a("APP_ALIAS");
    }

    @Override // com.vivo.push.restructure.b.a
    public final String k() {
        com.vivo.push.model.b a10 = aa.a(com.vivo.push.restructure.a.a().b(), com.vivo.push.restructure.a.a().f());
        if (a10 == null || a10.c()) {
            return null;
        }
        return a10.a();
    }

    @Override // com.vivo.push.restructure.b.a
    public final PushConfig l() {
        if (this.f46327d != null) {
            return this.f46327d;
        }
        int b4 = this.f46326c.b("PUSH_CLIENT_CONFIG", 1) & 1;
        return new PushConfig.Builder().agreePrivacyStatement(b4 != 0).openMultiUserMode(b4 != 0).build();
    }

    @Override // com.vivo.push.restructure.b.a
    public final void b(String str) {
        this.f46326c.a("APP_APIKEY", str);
        c cVar = f46324a.get(com.vivo.push.restructure.a.a().b().getPackageName());
        if (cVar == null) {
            cVar = new c();
        }
        cVar.b(str);
        f46324a.put(com.vivo.push.restructure.a.a().b().getPackageName(), cVar);
    }

    @Override // com.vivo.push.restructure.b.a
    public final void d(String str) {
        this.f46326c.a("APP_TAGS", str);
    }

    @Override // com.vivo.push.restructure.b.a
    public final void e(String str) {
        this.f46326c.a("APP_ALIAS", str);
    }

    @Override // com.vivo.push.restructure.b.a
    public final void c(String str) {
        this.f46326c.a("APP_TOKEN", str);
    }

    private static String a(Context context, String str, String str2) {
        List<ResolveInfo> queryBroadcastReceivers;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Intent intent = new Intent(str2);
        intent.setPackage(str);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 64)) == null || queryBroadcastReceivers.size() <= 0) {
                return null;
            }
            return queryBroadcastReceivers.get(0).activityInfo.name;
        } catch (Exception e2) {
            u.a("PushRelyImpl", "error  " + e2.getMessage());
            return null;
        }
    }

    @Override // com.vivo.push.restructure.b.a
    public final String a() {
        c cVar = f46324a.get(com.vivo.push.restructure.a.a().b().getPackageName());
        if (cVar != null) {
            String a10 = cVar.a();
            if (!TextUtils.isEmpty(a10)) {
                return a10;
            }
        }
        String b4 = this.f46326c.b();
        if (!TextUtils.isEmpty(b4)) {
            if (cVar == null) {
                cVar = new c();
            }
            cVar.a(b4);
            f46324a.put(com.vivo.push.restructure.a.a().b().getPackageName(), cVar);
        }
        return b4;
    }

    @Override // com.vivo.push.restructure.b.a
    public final void a(String str) {
        this.f46326c.a("APP_APPID", str);
        c cVar = f46324a.get(com.vivo.push.restructure.a.a().b().getPackageName());
        if (cVar == null) {
            cVar = new c();
        }
        cVar.a(str);
        f46324a.put(com.vivo.push.restructure.a.a().b().getPackageName(), cVar);
    }

    @Override // com.vivo.push.restructure.b.a
    public final void a(PushConfig pushConfig) {
        if (pushConfig == null) {
            return;
        }
        this.f46327d = null;
        Context b4 = com.vivo.push.restructure.a.a().b();
        this.f46326c.a("PUSH_CLIENT_CONFIG", (pushConfig.isAgreePrivacyStatement() ? 1 : 0) | (pushConfig.isOpenMultiUser() ? 1 : 0));
        g.a().execute(new e(this, b4, pushConfig));
        this.f46327d = pushConfig;
    }
}
