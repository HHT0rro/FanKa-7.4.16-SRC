package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.mobads.sdk.internal.an;
import com.baidu.mobads.sdk.internal.c;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ao {

    /* renamed from: a, reason: collision with root package name */
    private static final String f9813a = "PluginLoader";

    /* renamed from: b, reason: collision with root package name */
    private static ClassLoader f9814b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface a {
        void a();
    }

    public static void a(double d10, an.b bVar, a aVar) {
        s sVar = (s) c.a().a(c.a.f10007a).a();
        if (sVar != null) {
            sVar.startLoadRemotePhp(d10, bVar);
        } else if (aVar != null) {
            aVar.a();
        }
    }

    public static void b(int i10) {
        t tVar = (t) c.a().a(c.a.f10008b).a();
        if (tVar != null) {
            tVar.b(i10);
        }
    }

    public static Activity c() {
        t tVar = (t) c.a().a(c.a.f10008b).a();
        if (tVar != null) {
            return tVar.c();
        }
        return null;
    }

    public static boolean d() {
        t tVar = (t) c.a().a(c.a.f10008b).a();
        if (tVar != null) {
            return tVar.d();
        }
        return false;
    }

    public static boolean e() {
        t tVar = (t) c.a().a(c.a.f10008b).a();
        if (tVar != null) {
            return tVar.e();
        }
        return false;
    }

    public static boolean f() {
        t tVar = (t) c.a().a(c.a.f10008b).a();
        if (tVar != null) {
            return tVar.f();
        }
        aw.c().e("未能初始化小说sdk，请检查小说包和广告sdk是否匹配");
        return false;
    }

    public static void g() {
        t tVar = (t) c.a().a(c.a.f10008b).a();
        if (tVar != null) {
            tVar.g();
        }
    }

    public static void h() {
        t tVar = (t) c.a().a(c.a.f10008b).a();
        if (tVar != null) {
            tVar.a();
        }
    }

    public static void b() {
        t tVar = (t) c.a().a(c.a.f10008b).a();
        if (tVar != null) {
            tVar.b();
        }
    }

    public static boolean a() {
        return cl.f10052d.booleanValue();
    }

    public static ClassLoader a(String str, String str2, String str3, ClassLoader classLoader) {
        s sVar;
        if (!a()) {
            return classLoader;
        }
        if (f9814b == null && (sVar = (s) c.a().a(c.a.f10007a).a()) != null) {
            f9814b = sVar.getClassLoaderFromJar(str, str2, str3, classLoader);
        }
        return f9814b;
    }

    public static void b(int i10, int i11) {
        t tVar = (t) c.a().a(c.a.f10008b).a();
        if (tVar != null) {
            tVar.a(i10, i11);
        }
    }

    public static void a(Context context, String str, String str2) {
        t tVar = (t) c.a().a(c.a.f10008b).a();
        if (tVar != null) {
            tVar.a(context, str, str2);
        }
    }

    public static void a(u uVar) {
        t tVar = (t) c.a().a(c.a.f10008b).a();
        if (tVar != null) {
            tVar.a(uVar);
        }
    }

    public static void a(int i10) {
        t tVar = (t) c.a().a(c.a.f10008b).a();
        if (tVar != null) {
            tVar.a(i10);
        }
    }

    public static void a(int i10, boolean z10) {
        t tVar = (t) c.a().a(c.a.f10008b).a();
        if (tVar != null) {
            tVar.a(i10, z10);
        }
    }

    public static View a(Context context) {
        t tVar = (t) c.a().a(c.a.f10008b).a();
        if (tVar != null) {
            return tVar.a(context);
        }
        return null;
    }

    public static void a(Context context, String str) {
        t tVar = (t) c.a().a(c.a.f10008b).a();
        if (tVar != null) {
            tVar.a(context, str);
        }
    }

    public static void a(boolean z10) {
        t tVar = (t) c.a().a(c.a.f10008b).a();
        if (tVar != null) {
            tVar.a(z10);
        }
    }

    public static void a(int i10, int i11) {
        t tVar = (t) c.a().a(c.a.f10008b).a();
        if (tVar != null) {
            tVar.b(i10, i11);
        }
    }

    public static void a(boolean z10, int i10, int i11, int i12) {
        t tVar = (t) c.a().a(c.a.f10008b).a();
        if (tVar != null) {
            tVar.a(z10, i10, i11, i12);
        }
    }
}
