package bd;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cd.e;
import com.wangmai.restrictionbypass.hiddenapibypass.HiddenApiBypass;
import java.lang.Thread;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* compiled from: WMCrashIntercept.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static e f1477a;

    /* renamed from: b, reason: collision with root package name */
    public static bd.a f1478b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f1479c;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f1480d;

    /* renamed from: e, reason: collision with root package name */
    public static String f1481e;

    /* renamed from: f, reason: collision with root package name */
    public static bd.a f1482f = new a();

    /* compiled from: WMCrashIntercept.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class a extends bd.a {
        @Override // bd.a
        public void b(Thread thread, Throwable th) {
            th.printStackTrace();
        }

        @Override // bd.a
        public void d() {
        }

        @Override // bd.a
        public void g(Throwable th) {
            th.printStackTrace();
        }
    }

    /* compiled from: WMCrashIntercept.java */
    /* renamed from: bd.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class C0024b implements Thread.UncaughtExceptionHandler {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f1483a;

        public C0024b(String str) {
            this.f1483a = str;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            if (b.i(th, this.f1483a)) {
                if (b.f1478b != null) {
                    b.f1478b.e(thread, th);
                }
                if (thread == Looper.getMainLooper().getThread()) {
                    b.m(th);
                    b.q();
                    return;
                }
                return;
            }
            b.g((RuntimeException) th);
        }
    }

    /* compiled from: WMCrashIntercept.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class c implements Handler.Callback {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Handler f1484b;

        public c(Handler handler) {
            this.f1484b = handler;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (Build.VERSION.SDK_INT >= 28) {
                if (message.what != 159) {
                    return false;
                }
                try {
                    this.f1484b.handleMessage(message);
                } catch (Throwable th) {
                    b.f1477a.b(message);
                    b.o(th);
                }
                return true;
            }
            int i10 = message.what;
            if (i10 == 104) {
                try {
                    this.f1484b.handleMessage(message);
                } catch (Throwable th2) {
                    b.f1477a.a(message);
                    b.o(th2);
                }
                return true;
            }
            if (i10 == 107) {
                try {
                    this.f1484b.handleMessage(message);
                } catch (Throwable th3) {
                    b.f1477a.d(message);
                    b.o(th3);
                }
                return true;
            }
            if (i10 != 109) {
                switch (i10) {
                    case 100:
                        try {
                            this.f1484b.handleMessage(message);
                        } catch (Throwable th4) {
                            b.f1477a.b(message);
                            b.o(th4);
                        }
                        return true;
                    case 101:
                        try {
                            this.f1484b.handleMessage(message);
                        } catch (Throwable th5) {
                            b.f1477a.c(message);
                            b.o(th5);
                        }
                        return true;
                    case 102:
                        try {
                            this.f1484b.handleMessage(message);
                        } catch (Throwable th6) {
                            b.f1477a.c(message);
                            b.o(th6);
                        }
                        return true;
                    default:
                        return false;
                }
            }
            try {
                this.f1484b.handleMessage(message);
            } catch (Throwable th7) {
                b.o(th7);
            }
            return true;
        }
    }

    /* compiled from: WMCrashIntercept.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class d implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RuntimeException f1485b;

        public d(RuntimeException runtimeException) {
            this.f1485b = runtimeException;
        }

        @Override // java.lang.Runnable
        public void run() {
            throw this.f1485b;
        }
    }

    public static void b(Context context, String str, bd.a aVar) {
        if (f1479c) {
            return;
        }
        f1481e = str;
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                HiddenApiBypass.setHiddenApiExemptions("");
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        f1479c = true;
        f1478b = aVar;
        n();
        Thread.setDefaultUncaughtExceptionHandler(new C0024b(str));
    }

    public static void g(RuntimeException runtimeException) {
        new Thread(new d(runtimeException)).start();
    }

    public static boolean i(Throwable th, String str) {
        if (th == null || f1478b == null) {
            return false;
        }
        k(th);
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace == null) {
            return false;
        }
        boolean z10 = false;
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (stackTraceElement.getClassName().contains(str) && !stackTraceElement.getClassName().contains(b.class.getSimpleName())) {
                z10 = true;
            }
        }
        return (z10 || th.getCause() == null) ? z10 : i(th.getCause(), str);
    }

    public static void k(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        ArrayList arrayList = new ArrayList();
        if (stackTrace == null) {
            return;
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (!stackTraceElement.getClassName().contains(b.class.getPackage().getName())) {
                arrayList.add(stackTraceElement);
            }
        }
        if (th.getCause() != null) {
            k(th.getCause());
        }
        th.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
    }

    public static void l() throws Exception {
        Class<?> cls = Class.forName("android.app.ActivityThread");
        Object invoke = cls.getDeclaredMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
        Field declaredField = cls.getDeclaredField("mH");
        declaredField.setAccessible(true);
        Handler handler = (Handler) declaredField.get(invoke);
        Field declaredField2 = Handler.class.getDeclaredField("mCallback");
        declaredField2.setAccessible(true);
        declaredField2.set(handler, new c(handler));
    }

    public static void m(Throwable th) {
        StackTraceElement[] stackTrace;
        if (th == null || f1478b == null || (stackTrace = th.getStackTrace()) == null) {
            return;
        }
        int length = stackTrace.length;
        while (true) {
            length--;
            if (length <= -1 || stackTrace.length - length > 20) {
                return;
            }
            StackTraceElement stackTraceElement = stackTrace[length];
            if ("android.view.Choreographer".equals(stackTraceElement.getClassName()) && "Choreographer.java".equals(stackTraceElement.getFileName()) && "doFrame".equals(stackTraceElement.getMethodName())) {
                f1478b.f(th);
                return;
            }
        }
    }

    public static void n() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            f1477a = new cd.d();
        } else if (i10 >= 26) {
            f1477a = new cd.c();
        } else if (i10 == 25 || i10 == 24) {
            f1477a = new cd.b();
        } else if (i10 <= 23) {
            f1477a = new cd.a();
        }
        try {
            l();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void o(Throwable th) {
        if (f1478b == null) {
            return;
        }
        if (i(th, f1481e)) {
            if (p()) {
                f1478b.c(th);
                return;
            } else {
                f1478b.e(Looper.getMainLooper().getThread(), th);
                q();
                return;
            }
        }
        g((RuntimeException) th);
    }

    public static boolean p() {
        return f1480d;
    }

    public static void q() {
        f1480d = true;
        bd.a aVar = f1478b;
        if (aVar != null) {
            aVar.a();
        }
        while (true) {
            try {
                Looper.loop();
            } catch (Throwable th) {
                if (i(th, f1481e)) {
                    m(th);
                    bd.a aVar2 = f1478b;
                    if (aVar2 != null) {
                        aVar2.c(th);
                    }
                } else {
                    g(th);
                }
            }
        }
    }
}
