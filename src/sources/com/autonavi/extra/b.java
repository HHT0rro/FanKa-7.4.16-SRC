package com.autonavi.extra;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: AMapExtraInterfaceManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private List<a> f9687a = new ArrayList();

    public final void a() {
        synchronized (b.class) {
            List<a> list = this.f9687a;
            if (list != null) {
                list.add(null);
            }
        }
    }

    public final void b() {
        synchronized (b.class) {
            Iterator<a> iterator2 = this.f9687a.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next();
            }
        }
    }

    public final void c() {
        synchronized (b.class) {
            Iterator<a> iterator2 = this.f9687a.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next();
            }
        }
    }

    public final void d() {
        synchronized (b.class) {
            Iterator<a> iterator2 = this.f9687a.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next();
            }
        }
    }

    public final void e() {
        synchronized (b.class) {
            Iterator<a> iterator2 = this.f9687a.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next();
            }
        }
    }

    public final void f() {
        synchronized (b.class) {
            Iterator<a> iterator2 = this.f9687a.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next();
            }
            this.f9687a.clear();
        }
    }

    public final String g() {
        String stringBuffer;
        synchronized (b.class) {
            StringBuffer stringBuffer2 = new StringBuffer();
            for (a aVar : this.f9687a) {
                if (aVar != null) {
                    String a10 = aVar.a();
                    if (!TextUtils.isEmpty(a10)) {
                        stringBuffer2.append(a10);
                        if (!a10.endsWith(";")) {
                            stringBuffer2.append(";");
                        }
                    }
                }
            }
            stringBuffer = stringBuffer2.toString();
        }
        return stringBuffer;
    }

    public final void h() {
        synchronized (b.class) {
            Iterator<a> iterator2 = this.f9687a.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next();
            }
        }
    }

    public final void i() {
        synchronized (b.class) {
            Iterator<a> iterator2 = this.f9687a.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next();
            }
        }
    }

    public final Object j() {
        Object b4;
        synchronized (b.class) {
            for (a aVar : this.f9687a) {
                if (aVar != null && (b4 = aVar.b()) != null) {
                    return b4;
                }
            }
            return null;
        }
    }
}
