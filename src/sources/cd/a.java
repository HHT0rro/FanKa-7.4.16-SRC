package cd;

import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import java.lang.reflect.Field;

/* compiled from: ActivityKillerV21_V23.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class a implements e {
    @Override // cd.e
    public void a(Message message) {
        try {
            e((IBinder) message.obj);
        } catch (Throwable th) {
            th.printStackTrace();
        }
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
        try {
            e((IBinder) message.obj);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // cd.e
    public void d(Message message) {
        try {
            e((IBinder) message.obj);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void e(IBinder iBinder) throws Exception {
        Object invoke = Class.forName("android.app.ActivityManagerNative").getDeclaredMethod("getDefault", new Class[0]).invoke(null, new Object[0]);
        invoke.getClass().getDeclaredMethod("finishActivity", IBinder.class, Integer.TYPE, Intent.class, Boolean.TYPE).invoke(invoke, iBinder, 0, null, Boolean.FALSE);
    }
}
