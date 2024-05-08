package com.hailiang.advlib.common;

import androidx.annotation.Nullable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/* compiled from: CpcBridge.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static volatile b f27115a;

    /* renamed from: b, reason: collision with root package name */
    public static Map<String, Class> f27116b = new HashMap();

    /* compiled from: CpcBridge.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f27117a;

        public a(String str) {
            this.f27117a = str;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                Method declaredMethod = ((Class) b.f27116b.get(this.f27117a)).getDeclaredMethod(method.getName(), method.getParameterTypes());
                if (Modifier.isPrivate(declaredMethod.getModifiers())) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod.invoke(null, objArr);
            } catch (Error e2) {
                e2.printStackTrace();
                return null;
            } catch (RuntimeException e10) {
                e10.printStackTrace();
                return null;
            }
        }
    }

    /* compiled from: CpcBridge.java */
    /* renamed from: com.hailiang.advlib.common.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class C0245b implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f27119a;

        public C0245b(Object obj) {
            this.f27119a = obj;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                Method method2 = this.f27119a.getClass().getMethod(method.getName(), method.getParameterTypes());
                return method2.invoke(Modifier.isStatic(method2.getModifiers()) ? null : this.f27119a, objArr);
            } catch (Error e2) {
                e2.printStackTrace();
                return null;
            } catch (RuntimeException e10) {
                e10.printStackTrace();
                return null;
            }
        }
    }

    public static b c() {
        if (f27115a == null) {
            synchronized (b.class) {
                if (f27115a == null) {
                    f27115a = new b();
                }
            }
        }
        return f27115a;
    }

    public <T> Class<T> b(Class cls) {
        return f27116b.get(cls.getName());
    }

    public void a(Class cls, Class cls2) {
        f27116b.put(cls.getName(), cls2);
    }

    public void b() {
        f27116b.clear();
    }

    @Nullable
    public <T> T a(Class<T> cls) {
        return (T) a(cls, cls.getName());
    }

    public <T> T b(Class<T> cls, Object... objArr) {
        return (T) a(true, cls, objArr);
    }

    @Nullable
    private <T> T a(Class<T> cls, String str) {
        if (f27116b.get(str) == null) {
            return null;
        }
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(str));
    }

    @Nullable
    public <T> T a(Class<T> cls, Object... objArr) {
        return (T) a(false, cls, objArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    private <T> T a(boolean z10, Class<T> cls, Object... objArr) {
        boolean z11;
        T t2;
        Class cls2 = f27116b.get(cls.getName());
        T t10 = null;
        if (cls2 == null) {
            return null;
        }
        if (objArr != null) {
            try {
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (objArr.length > 0) {
                for (Constructor<?> constructor : cls2.getConstructors()) {
                    if (objArr.length == constructor.getParameterTypes().length) {
                        Class<?>[] parameterTypes = constructor.getParameterTypes();
                        int i10 = 0;
                        while (true) {
                            if (i10 >= parameterTypes.length) {
                                z11 = true;
                                break;
                            }
                            if (!parameterTypes[i10].isInstance(objArr[i10])) {
                                z11 = false;
                                break;
                            }
                            i10++;
                        }
                        if (z11) {
                            t2 = constructor.newInstance(objArr);
                            t10 = t2;
                            break;
                        }
                    }
                }
                return (t10 != null || z10) ? t10 : (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new C0245b(t10));
            }
        }
        t2 = cls2.newInstance();
        t10 = t2;
        if (t10 != null) {
        }
    }
}
