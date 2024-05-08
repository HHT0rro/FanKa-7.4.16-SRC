package retrofit2;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import retrofit2.c;
import retrofit2.f;

/* compiled from: Platform.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f53495a = e();

    /* compiled from: Platform.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class a extends m {

        /* compiled from: Platform.java */
        /* renamed from: retrofit2.m$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public static class ExecutorC0822a implements Executor {

            /* renamed from: b, reason: collision with root package name */
            public final Handler f53496b = new Handler(Looper.getMainLooper());

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                this.f53496b.post(runnable);
            }
        }

        @Override // retrofit2.m
        public List<? extends c.a> a(Executor executor) {
            if (executor != null) {
                g gVar = new g(executor);
                return Build.VERSION.SDK_INT >= 24 ? Arrays.asList(e.f53400a, gVar) : Collections.singletonList(gVar);
            }
            throw new AssertionError();
        }

        @Override // retrofit2.m
        public Executor b() {
            return new ExecutorC0822a();
        }

        @Override // retrofit2.m
        public List<? extends f.a> c() {
            if (Build.VERSION.SDK_INT >= 24) {
                return Collections.singletonList(k.f53448a);
            }
            return Collections.emptyList();
        }

        @Override // retrofit2.m
        public int d() {
            return Build.VERSION.SDK_INT >= 24 ? 1 : 0;
        }

        @Override // retrofit2.m
        public boolean h(Method method) {
            if (Build.VERSION.SDK_INT < 24) {
                return false;
            }
            return method.isDefault();
        }
    }

    /* compiled from: Platform.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class b extends m {
        @Override // retrofit2.m
        public List<? extends c.a> a(Executor executor) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(e.f53400a);
            arrayList.add(new g(executor));
            return Collections.unmodifiableList(arrayList);
        }

        @Override // retrofit2.m
        public List<? extends f.a> c() {
            return Collections.singletonList(k.f53448a);
        }

        @Override // retrofit2.m
        public int d() {
            return 1;
        }

        @Override // retrofit2.m
        public Object g(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
            Constructor declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
            declaredConstructor.setAccessible(true);
            return ((MethodHandles.Lookup) declaredConstructor.newInstance(cls, -1)).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
        }

        @Override // retrofit2.m
        public boolean h(Method method) {
            return method.isDefault();
        }
    }

    public static m e() {
        try {
            try {
                Class.forName("android.os.Build");
                return new a();
            } catch (ClassNotFoundException unused) {
                Class.forName("java.util.Optional");
                return new b();
            }
        } catch (ClassNotFoundException unused2) {
            return new m();
        }
    }

    public static m f() {
        return f53495a;
    }

    public List<? extends c.a> a(Executor executor) {
        return Collections.singletonList(new g(executor));
    }

    public Executor b() {
        return null;
    }

    public List<? extends f.a> c() {
        return Collections.emptyList();
    }

    public int d() {
        return 0;
    }

    public Object g(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
        throw new UnsupportedOperationException();
    }

    public boolean h(Method method) {
        return false;
    }
}
