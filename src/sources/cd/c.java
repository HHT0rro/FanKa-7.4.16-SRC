package cd;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: ActivityKillerV26.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class c implements e {
    @Override // cd.e
    public void a(Message message) {
        f(message);
    }

    @Override // cd.e
    public void b(Message message) {
        try {
            Object obj = message.obj;
            Field declaredField = obj.getClass().getDeclaredField("token");
            declaredField.setAccessible(true);
            e((IBinder) declaredField.get(obj));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // cd.e
    public void c(Message message) {
        f(message);
    }

    @Override // cd.e
    public void d(Message message) {
        f(message);
    }

    public final void e(IBinder iBinder) throws Exception {
        Object invoke = ActivityManager.class.getDeclaredMethod("getService", new Class[0]).invoke(null, new Object[0]);
        Class<?> cls = invoke.getClass();
        Class<Integer> cls2 = Integer.TYPE;
        Method declaredMethod = cls.getDeclaredMethod("finishActivity", IBinder.class, cls2, Intent.class, cls2);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(invoke, iBinder, 0, null, 0);
    }

    public final void f(Message message) {
        try {
            Object obj = message.obj;
            Field declaredField = obj.getClass().getDeclaredField("arg1");
            declaredField.setAccessible(true);
            e((IBinder) declaredField.get(obj));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
