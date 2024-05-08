package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class z {

    /* renamed from: c, reason: collision with root package name */
    public static volatile z f47097c;

    /* renamed from: a, reason: collision with root package name */
    public Context f47098a;

    /* renamed from: b, reason: collision with root package name */
    public List<j1> f47099b = new ArrayList();

    public z(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f47098a = applicationContext;
        if (applicationContext == null) {
            this.f47098a = context;
        }
    }

    public static z b(Context context) {
        if (f47097c == null) {
            synchronized (z.class) {
                if (f47097c == null) {
                    f47097c = new z(context);
                }
            }
        }
        return f47097c;
    }

    public int a(String str) {
        synchronized (this.f47099b) {
            j1 j1Var = new j1();
            j1Var.f47026b = str;
            if (this.f47099b.contains(j1Var)) {
                for (j1 j1Var2 : this.f47099b) {
                    if (j1Var2.equals(j1Var)) {
                        return j1Var2.f47025a;
                    }
                }
            }
            return 0;
        }
    }

    public synchronized String c(av avVar) {
        return this.f47098a.getSharedPreferences("mipush_extra", 0).getString(avVar.name(), "");
    }

    public synchronized void d(av avVar, String str) {
        SharedPreferences sharedPreferences = this.f47098a.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putString(avVar.name(), str).commit();
    }

    public void e(String str) {
        synchronized (this.f47099b) {
            j1 j1Var = new j1();
            j1Var.f47025a = 0;
            j1Var.f47026b = str;
            if (this.f47099b.contains(j1Var)) {
                this.f47099b.remove(j1Var);
            }
            this.f47099b.add(j1Var);
        }
    }

    public boolean f(String str) {
        synchronized (this.f47099b) {
            j1 j1Var = new j1();
            j1Var.f47026b = str;
            return this.f47099b.contains(j1Var);
        }
    }

    public void g(String str) {
        synchronized (this.f47099b) {
            j1 j1Var = new j1();
            j1Var.f47026b = str;
            if (this.f47099b.contains(j1Var)) {
                Iterator<j1> iterator2 = this.f47099b.iterator2();
                while (true) {
                    if (!iterator2.hasNext()) {
                        break;
                    }
                    j1 next = iterator2.next();
                    if (j1Var.equals(next)) {
                        j1Var = next;
                        break;
                    }
                }
            }
            j1Var.f47025a++;
            this.f47099b.remove(j1Var);
            this.f47099b.add(j1Var);
        }
    }

    public void h(String str) {
        synchronized (this.f47099b) {
            j1 j1Var = new j1();
            j1Var.f47026b = str;
            if (this.f47099b.contains(j1Var)) {
                this.f47099b.remove(j1Var);
            }
        }
    }
}
