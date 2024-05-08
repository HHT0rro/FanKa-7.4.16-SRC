package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class h4 {

    /* renamed from: a, reason: collision with root package name */
    public static a f47379a;

    /* renamed from: b, reason: collision with root package name */
    public static Map<String, ia> f47380b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface a {
        void a(Context context, hu huVar);
    }

    public static int a(int i10) {
        if (i10 > 0) {
            return i10 + 1000;
        }
        return -1;
    }

    public static int b(Enum r12) {
        if (r12 != null) {
            if (r12 instanceof hq) {
                return r12.ordinal() + 1001;
            }
            if (r12 instanceof ia) {
                return r12.ordinal() + 2001;
            }
            if (r12 instanceof fk) {
                return r12.ordinal() + 3001;
            }
        }
        return -1;
    }

    public static hu c(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        hu huVar = new hu();
        huVar.d("category_client_report_data");
        huVar.a("push_sdk_channel");
        huVar.a(1L);
        huVar.b(str);
        huVar.a(true);
        huVar.b(System.currentTimeMillis());
        huVar.g(context.getPackageName());
        huVar.e("com.xiaomi.xmsf");
        huVar.f(kc.z.a());
        huVar.c("quality_support");
        return huVar;
    }

    public static ia d(String str) {
        if (f47380b == null) {
            synchronized (ia.class) {
                if (f47380b == null) {
                    f47380b = new HashMap();
                    for (ia iaVar : ia.values()) {
                        f47380b.put(iaVar.f329a.toLowerCase(), iaVar);
                    }
                }
            }
        }
        ia iaVar2 = f47380b.get(str.toLowerCase());
        return iaVar2 != null ? iaVar2 : ia.Invalid;
    }

    public static gc.a e(Context context) {
        boolean i10 = kc.j.d(context).i(hv.PerfUploadSwitch.a(), false);
        boolean i11 = kc.j.d(context).i(hv.EventUploadNewSwitch.a(), false);
        return gc.a.b().l(i11).k(kc.j.d(context).a(hv.EventUploadFrequency.a(), RemoteMessageConst.DEFAULT_TTL)).o(i10).n(kc.j.d(context).a(hv.PerfUploadFrequency.a(), RemoteMessageConst.DEFAULT_TTL)).h(context);
    }

    public static gc.b f(Context context, String str, String str2, int i10, long j10, String str3) {
        gc.b g3 = g(str);
        g3.f49441h = str2;
        g3.f49442i = i10;
        g3.f49443j = j10;
        g3.f49444k = str3;
        return g3;
    }

    public static gc.b g(String str) {
        gc.b bVar = new gc.b();
        bVar.f49448a = 1000;
        bVar.f49450c = 1001;
        bVar.f49449b = str;
        return bVar;
    }

    public static gc.c h() {
        gc.c cVar = new gc.c();
        cVar.f49448a = 1000;
        cVar.f49450c = 1000;
        cVar.f49449b = "P100000";
        return cVar;
    }

    public static gc.c i(Context context, int i10, long j10, long j11) {
        gc.c h10 = h();
        h10.f49445h = i10;
        h10.f49446i = j10;
        h10.f49447j = j11;
        return h10;
    }

    public static String j(int i10) {
        return i10 == 1000 ? "E100000" : i10 == 3000 ? "E100002" : i10 == 2000 ? "E100001" : i10 == 6000 ? "E100003" : "";
    }

    public static void k(Context context) {
        hc.a.d(context, e(context));
    }

    public static void l(Context context, hu huVar) {
        if (p(context.getApplicationContext())) {
            kc.a0.a(context.getApplicationContext(), huVar);
            return;
        }
        a aVar = f47379a;
        if (aVar != null) {
            aVar.a(context, huVar);
        }
    }

    public static void m(Context context, gc.a aVar) {
        hc.a.a(context, aVar, new f4(context), new g4(context));
    }

    public static void n(Context context, List<String> list) {
        if (list == null) {
            return;
        }
        try {
            Iterator<String> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                hu c4 = c(context, iterator2.next());
                if (!kc.z.d(c4, false)) {
                    l(context, c4);
                }
            }
        } catch (Throwable th) {
            fc.c.n(th.getMessage());
        }
    }

    public static void o(a aVar) {
        f47379a = aVar;
    }

    public static boolean p(Context context) {
        return (context == null || TextUtils.isEmpty(context.getPackageName()) || !"com.xiaomi.xmsf".equals(context.getPackageName())) ? false : true;
    }
}
