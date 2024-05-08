package com.amap.api.col.p0003l;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* compiled from: MethodCallHelper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ej {

    /* renamed from: b, reason: collision with root package name */
    private boolean f5518b = false;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<a> f5517a = new ArrayList<>();

    /* compiled from: MethodCallHelper.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f5519a;

        /* renamed from: b, reason: collision with root package name */
        private Object f5520b;

        /* renamed from: c, reason: collision with root package name */
        private Class<?>[] f5521c;

        /* renamed from: d, reason: collision with root package name */
        private Object[] f5522d;

        public a(Object obj, String str, Object... objArr) {
            this.f5520b = obj;
            this.f5519a = str;
            if (objArr == null || objArr.length <= 0) {
                return;
            }
            this.f5521c = new Class[objArr.length];
            for (int i10 = 0; i10 < objArr.length; i10++) {
                this.f5521c[i10] = objArr[i10].getClass();
            }
            this.f5522d = new Object[objArr.length];
            for (int i11 = 0; i11 < objArr.length; i11++) {
                this.f5522d[i11] = objArr[i11];
            }
        }
    }

    public final synchronized void a() {
        if (this.f5518b) {
            return;
        }
        this.f5518b = true;
        for (int i10 = 0; i10 < this.f5517a.size(); i10++) {
            a aVar = this.f5517a.get(i10);
            try {
                try {
                    try {
                        if (aVar.f5520b != null) {
                            Class<?> cls = aVar.f5520b.getClass();
                            Method method = null;
                            try {
                                method = cls.getDeclaredMethod(aVar.f5519a, aVar.f5521c);
                            } catch (NoSuchMethodException unused) {
                                if (aVar.f5521c.length > 0) {
                                    Class<?>[] clsArr = new Class[aVar.f5521c.length];
                                    for (int i11 = 0; i11 < aVar.f5521c.length; i11++) {
                                        if (aVar.f5521c[i11].getInterfaces().length > 0) {
                                            clsArr[i11] = aVar.f5521c[i11].getInterfaces()[0];
                                        }
                                    }
                                    method = cls.getDeclaredMethod(aVar.f5519a, clsArr);
                                }
                            }
                            if (method != null) {
                                method.setAccessible(true);
                                method.invoke(aVar.f5520b, aVar.f5522d);
                            }
                        }
                    } catch (IllegalArgumentException e2) {
                        e2.printStackTrace();
                    } catch (InvocationTargetException e10) {
                        e10.printStackTrace();
                    }
                } catch (IllegalAccessException e11) {
                    e11.printStackTrace();
                } catch (SecurityException e12) {
                    e12.printStackTrace();
                }
            } catch (NoSuchMethodException e13) {
                e13.printStackTrace();
            }
        }
        this.f5517a.clear();
    }

    public final synchronized void a(Object obj, Object... objArr) {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace != null && stackTrace.length >= 3) {
                this.f5517a.add(new a(obj, stackTrace[3].getMethodName(), objArr));
            }
        } catch (Throwable unused) {
        }
        this.f5518b = false;
    }
}
