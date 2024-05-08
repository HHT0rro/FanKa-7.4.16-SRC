package he;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.greenrobot.eventbus.EventBusException;

/* compiled from: SubscriberMethodFinder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class l {

    /* renamed from: d, reason: collision with root package name */
    public static final Map<Class<?>, List<k>> f49640d = new ConcurrentHashMap();

    /* renamed from: e, reason: collision with root package name */
    public static final a[] f49641e = new a[4];

    /* renamed from: a, reason: collision with root package name */
    public List<ie.b> f49642a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f49643b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f49644c;

    /* compiled from: SubscriberMethodFinder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final List<k> f49645a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public final Map<Class, Object> f49646b = new HashMap();

        /* renamed from: c, reason: collision with root package name */
        public final Map<String, Class> f49647c = new HashMap();

        /* renamed from: d, reason: collision with root package name */
        public final StringBuilder f49648d = new StringBuilder(128);

        /* renamed from: e, reason: collision with root package name */
        public Class<?> f49649e;

        /* renamed from: f, reason: collision with root package name */
        public Class<?> f49650f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f49651g;

        /* renamed from: h, reason: collision with root package name */
        public ie.a f49652h;

        public boolean a(Method method, Class<?> cls) {
            Object put = this.f49646b.put(cls, method);
            if (put == null) {
                return true;
            }
            if (put instanceof Method) {
                if (b((Method) put, cls)) {
                    this.f49646b.put(cls, this);
                } else {
                    throw new IllegalStateException();
                }
            }
            return b(method, cls);
        }

        public final boolean b(Method method, Class<?> cls) {
            this.f49648d.setLength(0);
            this.f49648d.append(method.getName());
            StringBuilder sb2 = this.f49648d;
            sb2.append('>');
            sb2.append(cls.getName());
            String sb3 = this.f49648d.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class put = this.f49647c.put(sb3, declaringClass);
            if (put == null || put.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.f49647c.put(sb3, put);
            return false;
        }

        public void c(Class<?> cls) {
            this.f49650f = cls;
            this.f49649e = cls;
            this.f49651g = false;
            this.f49652h = null;
        }

        public void d() {
            if (this.f49651g) {
                this.f49650f = null;
                return;
            }
            Class<? super Object> superclass = this.f49650f.getSuperclass();
            this.f49650f = superclass;
            String name = superclass.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.")) {
                this.f49650f = null;
            }
        }

        public void e() {
            this.f49645a.clear();
            this.f49646b.clear();
            this.f49647c.clear();
            this.f49648d.setLength(0);
            this.f49649e = null;
            this.f49650f = null;
            this.f49651g = false;
            this.f49652h = null;
        }
    }

    public l(List<ie.b> list, boolean z10, boolean z11) {
        this.f49642a = list;
        this.f49643b = z10;
        this.f49644c = z11;
    }

    public List<k> a(Class<?> cls) {
        List<k> b4;
        Map<Class<?>, List<k>> map = f49640d;
        List<k> list = map.get(cls);
        if (list != null) {
            return list;
        }
        if (this.f49644c) {
            b4 = c(cls);
        } else {
            b4 = b(cls);
        }
        if (!b4.isEmpty()) {
            map.put(cls, b4);
            return b4;
        }
        throw new EventBusException("Subscriber " + ((Object) cls) + " and its super classes have no public methods with the @Subscribe annotation");
    }

    public final List<k> b(Class<?> cls) {
        a g3 = g();
        g3.c(cls);
        while (g3.f49650f != null) {
            ie.a f10 = f(g3);
            g3.f49652h = f10;
            if (f10 != null) {
                for (k kVar : f10.a()) {
                    if (g3.a(kVar.f49634a, kVar.f49636c)) {
                        g3.f49645a.add(kVar);
                    }
                }
            } else {
                d(g3);
            }
            g3.d();
        }
        return e(g3);
    }

    public final List<k> c(Class<?> cls) {
        a g3 = g();
        g3.c(cls);
        while (g3.f49650f != null) {
            d(g3);
            g3.d();
        }
        return e(g3);
    }

    public final void d(a aVar) {
        Method[] methods;
        try {
            methods = aVar.f49650f.getDeclaredMethods();
        } catch (Throwable unused) {
            methods = aVar.f49650f.getMethods();
            aVar.f49651g = true;
        }
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if ((modifiers & 1) != 0 && (modifiers & 5192) == 0) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1) {
                    j jVar = (j) method.getAnnotation(j.class);
                    if (jVar != null) {
                        Class<?> cls = parameterTypes[0];
                        if (aVar.a(method, cls)) {
                            aVar.f49645a.add(new k(method, cls, jVar.threadMode(), jVar.priority(), jVar.sticky()));
                        }
                    }
                } else if (this.f49643b && method.isAnnotationPresent(j.class)) {
                    throw new EventBusException("@Subscribe method " + (method.getDeclaringClass().getName() + "." + method.getName()) + "must have exactly 1 parameter but has " + parameterTypes.length);
                }
            } else if (this.f49643b && method.isAnnotationPresent(j.class)) {
                throw new EventBusException((method.getDeclaringClass().getName() + "." + method.getName()) + " is a illegal @Subscribe method: must be public, non-static, and non-abstract");
            }
        }
    }

    public final List<k> e(a aVar) {
        ArrayList arrayList = new ArrayList(aVar.f49645a);
        aVar.e();
        synchronized (f49641e) {
            int i10 = 0;
            while (true) {
                if (i10 >= 4) {
                    break;
                }
                a[] aVarArr = f49641e;
                if (aVarArr[i10] == null) {
                    aVarArr[i10] = aVar;
                    break;
                }
                i10++;
            }
        }
        return arrayList;
    }

    public final ie.a f(a aVar) {
        ie.a aVar2 = aVar.f49652h;
        if (aVar2 != null && aVar2.c() != null) {
            ie.a c4 = aVar.f49652h.c();
            if (aVar.f49650f == c4.b()) {
                return c4;
            }
        }
        List<ie.b> list = this.f49642a;
        if (list == null) {
            return null;
        }
        Iterator<ie.b> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            ie.a a10 = iterator2.next().a(aVar.f49650f);
            if (a10 != null) {
                return a10;
            }
        }
        return null;
    }

    public final a g() {
        synchronized (f49641e) {
            for (int i10 = 0; i10 < 4; i10++) {
                a[] aVarArr = f49641e;
                a aVar = aVarArr[i10];
                if (aVar != null) {
                    aVarArr[i10] = null;
                    return aVar;
                }
            }
            return new a();
        }
    }
}
