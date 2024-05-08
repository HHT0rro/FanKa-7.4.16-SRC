package cd;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import java.lang.reflect.Method;

/* compiled from: ActivityKillerV28.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class d implements e {
    @Override // cd.e
    public void a(Message message) {
    }

    @Override // cd.e
    public void b(Message message) {
        try {
            f(message);
        } catch (Throwable th) {
            th.printStackTrace();
            try {
                g(message);
            } catch (Throwable th2) {
                th2.printStackTrace();
                try {
                    h(message);
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
        }
    }

    @Override // cd.e
    public void c(Message message) {
    }

    @Override // cd.e
    public void d(Message message) {
    }

    public final void e(IBinder iBinder) throws Exception {
        Object invoke = ActivityManager.class.getDeclaredMethod("getService", new Class[0]).invoke(null, new Object[0]);
        Class<?> cls = invoke.getClass();
        Class<Integer> cls2 = Integer.TYPE;
        Method declaredMethod = cls.getDeclaredMethod("finishActivity", IBinder.class, cls2, Intent.class, cls2);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(invoke, iBinder, 0, null, 0);
    }

    public final void f(Message message) throws Throwable {
        e(((oc.a) message.obj).a());
    }

    public final void g(Message message) throws Throwable {
        Object obj = message.obj;
        e((IBinder) obj.getClass().getDeclaredMethod("getActivityToken", new Class[0]).invoke(obj, new Object[0]));
    }

    public final void h(Message message) throws Throwable {
        Object obj = message.obj;
        e((IBinder) obj.getClass().getDeclaredField("mActivityToken").get(obj));
    }
}
