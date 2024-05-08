package hc;

import android.content.Context;
import android.os.Process;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {
    public static void a(Context context, gc.a aVar, ic.a aVar2, ic.b bVar) {
        fc.c.m("init in process " + com.xiaomi.push.g.d(context) + " pid :" + Process.myPid() + " threadId: " + Thread.currentThread().getId());
        b.e(context).i(aVar, aVar2, bVar);
        if (com.xiaomi.push.g.f(context)) {
            fc.c.m("init in process\u3000start scheduleJob");
            b.e(context).g();
        }
    }

    public static void b(Context context, gc.b bVar) {
        if (bVar != null) {
            b.e(context).j(bVar);
        }
    }

    public static void c(Context context, gc.c cVar) {
        if (cVar != null) {
            b.e(context).k(cVar);
        }
    }

    public static void d(Context context, gc.a aVar) {
        if (aVar == null) {
            return;
        }
        b.e(context).p(aVar.g(), aVar.h(), aVar.c(), aVar.e());
    }
}
