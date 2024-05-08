package dc;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {

    /* renamed from: dc.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class RunnableC0721a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f48666b;

        public RunnableC0721a(Context context) {
            this.f48666b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if ("HUAWEI".equals(bc.a.a())) {
                new b(this.f48666b).b();
            } else if ("OPPO".equals(bc.a.a())) {
                new c(this.f48666b).c();
            }
        }
    }

    public final void a(Context context) {
        new Thread(new RunnableC0721a(context)).start();
    }

    public void b(Context context) {
        if ("HUAWEI".equals(bc.a.a())) {
            a(context);
            return;
        }
        if ("OPPO".equals(bc.a.a())) {
            a(context);
        } else if ("VIVO".equals(bc.a.a())) {
            new d(context).a();
        } else if ("XIAOMI".equals(bc.a.a())) {
            new e(context).a();
        }
    }
}
