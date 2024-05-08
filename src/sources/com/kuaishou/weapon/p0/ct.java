package com.kuaishou.weapon.p0;

import android.os.Build;
import com.kuaishou.weapon.p0.jni.Engine;
import java.lang.reflect.Method;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ct {

    /* renamed from: a, reason: collision with root package name */
    private static int f35990a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f35991b;

    public ct() {
        b();
    }

    private int a(Method method) {
        try {
            int i10 = f35990a;
            if (i10 <= 1 || method == null) {
                return 0;
            }
            return Engine.mmo(method, i10, method.getModifiers());
        } catch (Exception unused) {
            return 0;
        }
    }

    private void b() {
        if (!Engine.loadSuccess || f35991b) {
            return;
        }
        boolean b4 = cr.b();
        int i10 = Build.VERSION.SDK_INT;
        if (b4 && i10 < 29 && i10 > 22) {
            f35990a = Engine.off();
        }
        f35991b = true;
    }

    private boolean c() {
        return f35991b && f35990a > 1;
    }

    public int a(Class cls, String str, Object... objArr) {
        try {
            if (c()) {
                return a(dh.a(cls, str, objArr));
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public int a(int i10, Class cls, String str, Object... objArr) {
        Method a10;
        try {
            if (!c() || (a10 = dh.a(cls, str, objArr)) == null) {
                return 0;
            }
            return Engine.mqc(a10, i10);
        } catch (Exception unused) {
            return 0;
        }
    }

    public int a() {
        if (!c()) {
            return -1;
        }
        long a10 = cq.f35979b.a();
        long a11 = cq.f35978a.a();
        if (f35990a == a10) {
            return (int) a11;
        }
        return -1;
    }
}
