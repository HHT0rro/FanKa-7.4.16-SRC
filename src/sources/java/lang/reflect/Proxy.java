package java.lang.reflect;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import dalvik.annotation.optimization.FastNative;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiFunction;
import libcore.util.EmptyArray;
import sun.reflect.CallerSensitive;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Proxy implements Serializable {
    private static final long serialVersionUID = -2222568056686623797L;

    /* renamed from: h, reason: collision with root package name */
    protected InvocationHandler f50365h;
    private static final Class<?>[] constructorParams = {InvocationHandler.class};
    private static final WeakCache<ClassLoader, Class<?>[], Class<?>> proxyClassCache = new WeakCache<>(new KeyFactory(), new ProxyClassFactory());
    private static final Object key0 = new Object();
    private static final Comparator<Method> ORDER_BY_SIGNATURE_AND_SUBTYPE = new Comparator<Method>() { // from class: java.lang.reflect.Proxy.1
        @Override // java.util.Comparator
        public int compare(Method a10, Method b4) {
            int comparison = Method.ORDER_BY_SIGNATURE.compare(a10, b4);
            if (comparison != 0) {
                return comparison;
            }
            Class<?> aClass = a10.getDeclaringClass();
            Class<?> bClass = b4.getDeclaringClass();
            if (aClass == bClass) {
                return 0;
            }
            if (aClass.isAssignableFrom(bClass)) {
                return 1;
            }
            if (!bClass.isAssignableFrom(aClass)) {
                return 0;
            }
            return -1;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    @FastNative
    public static native Class<?> generateProxy(String str, Class<?>[] clsArr, ClassLoader classLoader, Method[] methodArr, Class<?>[][] clsArr2);

    private Proxy() {
    }

    protected Proxy(InvocationHandler h10) {
        Objects.requireNonNull(h10);
        this.f50365h = h10;
    }

    @CallerSensitive
    public static Class<?> getProxyClass(ClassLoader loader, Class<?>... interfaces) throws IllegalArgumentException {
        return getProxyClass0(loader, interfaces);
    }

    private static Class<?> getProxyClass0(ClassLoader loader, Class<?>... interfaces) {
        if (interfaces.length > 65535) {
            throw new IllegalArgumentException("interface limit exceeded");
        }
        return proxyClassCache.get(loader, interfaces);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class Key1 extends WeakReference<Class<?>> {
        private final int hash;

        Key1(Class<?> intf) {
            super(intf);
            this.hash = intf.hashCode();
        }

        public int hashCode() {
            return this.hash;
        }

        public boolean equals(Object obj) {
            Class<?> intf;
            return this == obj || (obj != null && obj.getClass() == Key1.class && (intf = get()) != null && intf == ((Key1) obj).get());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class Key2 extends WeakReference<Class<?>> {
        private final int hash;
        private final WeakReference<Class<?>> ref2;

        Key2(Class<?> intf1, Class<?> intf2) {
            super(intf1);
            this.hash = (intf1.hashCode() * 31) + intf2.hashCode();
            this.ref2 = new WeakReference<>(intf2);
        }

        public int hashCode() {
            return this.hash;
        }

        public boolean equals(Object obj) {
            Class<?> intf1;
            Class<?> intf2;
            return this == obj || (obj != null && obj.getClass() == Key2.class && (intf1 = get()) != null && intf1 == ((Key2) obj).get() && (intf2 = this.ref2.get()) != null && intf2 == ((Key2) obj).ref2.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class KeyX {
        private final int hash;
        private final WeakReference<Class<?>>[] refs;

        KeyX(Class<?>[] interfaces) {
            this.hash = Arrays.hashCode(interfaces);
            this.refs = new WeakReference[interfaces.length];
            for (int i10 = 0; i10 < interfaces.length; i10++) {
                this.refs[i10] = new WeakReference<>(interfaces[i10]);
            }
        }

        public int hashCode() {
            return this.hash;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj != null && obj.getClass() == KeyX.class && equals(this.refs, ((KeyX) obj).refs));
        }

        private static boolean equals(WeakReference<Class<?>>[] refs1, WeakReference<Class<?>>[] refs2) {
            if (refs1.length != refs2.length) {
                return false;
            }
            for (int i10 = 0; i10 < refs1.length; i10++) {
                Class<?> intf = refs1[i10].get();
                if (intf == null || intf != refs2[i10].get()) {
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static final class KeyFactory implements BiFunction<ClassLoader, Class<?>[], Object> {
        private KeyFactory() {
        }

        @Override // java.util.function.BiFunction
        public Object apply(ClassLoader classLoader, Class<?>[] interfaces) {
            switch (interfaces.length) {
                case 0:
                    return Proxy.key0;
                case 1:
                    return new Key1(interfaces[0]);
                case 2:
                    return new Key2(interfaces[0], interfaces[1]);
                default:
                    return new KeyX(interfaces);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static final class ProxyClassFactory implements BiFunction<ClassLoader, Class<?>[], Class<?>> {
        private static final AtomicLong nextUniqueNumber = new AtomicLong();
        private static final String proxyClassNamePrefix = "$Proxy";

        private ProxyClassFactory() {
        }

        @Override // java.util.function.BiFunction
        public Class<?> apply(ClassLoader loader, Class<?>[] interfaces) {
            Map<Class<?>, Boolean> interfaceSet = new IdentityHashMap<>(interfaces.length);
            for (Class<?> intf : interfaces) {
                Class<?> interfaceClass = null;
                try {
                    interfaceClass = Class.forName(intf.getName(), false, loader);
                } catch (ClassNotFoundException e2) {
                }
                if (interfaceClass != intf) {
                    throw new IllegalArgumentException(((Object) intf) + " is not visible from class loader");
                }
                if (!interfaceClass.isInterface()) {
                    throw new IllegalArgumentException(interfaceClass.getName() + " is not an interface");
                }
                if (interfaceSet.put(interfaceClass, Boolean.TRUE) != null) {
                    throw new IllegalArgumentException("repeated interface: " + interfaceClass.getName());
                }
            }
            String proxyPkg = null;
            for (Class<?> intf2 : interfaces) {
                int flags = intf2.getModifiers();
                if (!Modifier.isPublic(flags)) {
                    String name = intf2.getName();
                    int n10 = name.lastIndexOf(46);
                    String pkg = n10 == -1 ? "" : name.substring(0, n10 + 1);
                    if (proxyPkg == null) {
                        proxyPkg = pkg;
                    } else if (!pkg.equals(proxyPkg)) {
                        throw new IllegalArgumentException("non-public interfaces from different packages");
                    }
                }
            }
            if (proxyPkg == null) {
                proxyPkg = "";
            }
            List<Method> methods = Proxy.getMethods(interfaces);
            Collections.sort(methods, Proxy.ORDER_BY_SIGNATURE_AND_SUBTYPE);
            Proxy.validateReturnTypes(methods);
            List<Class<?>[]> exceptions = Proxy.deduplicateAndGetExceptions(methods);
            Method[] methodsArray = (Method[]) methods.toArray(new Method[methods.size()]);
            Class<?>[][] exceptionsArray = (Class[][]) exceptions.toArray(new Class[exceptions.size()]);
            long num = nextUniqueNumber.getAndIncrement();
            String proxyName = proxyPkg + proxyClassNamePrefix + num;
            return Proxy.generateProxy(proxyName, interfaces, loader, methodsArray, exceptionsArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<Class<?>[]> deduplicateAndGetExceptions(List<Method> methods) {
        List<Class<?>[]> exceptions = new ArrayList<>(methods.size());
        int i10 = 0;
        while (i10 < methods.size()) {
            Method method = methods.get(i10);
            Class<?>[] exceptionTypes = method.getExceptionTypes();
            if (i10 > 0 && Method.ORDER_BY_SIGNATURE.compare(method, methods.get(i10 - 1)) == 0) {
                exceptions.set(i10 - 1, intersectExceptions(exceptions.get(i10 - 1), exceptionTypes));
                methods.remove(i10);
            } else {
                exceptions.add(exceptionTypes);
                i10++;
            }
        }
        return exceptions;
    }

    private static Class<?>[] intersectExceptions(Class<?>[] aExceptions, Class<?>[] bExceptions) {
        if (aExceptions.length == 0 || bExceptions.length == 0) {
            return EmptyArray.CLASS;
        }
        if (Arrays.equals(aExceptions, bExceptions)) {
            return aExceptions;
        }
        Set<Class<?>> intersection = new HashSet<>();
        for (Class<?> a10 : aExceptions) {
            for (Class<?> b4 : bExceptions) {
                if (a10.isAssignableFrom(b4)) {
                    intersection.add(b4);
                } else if (b4.isAssignableFrom(a10)) {
                    intersection.add(a10);
                }
            }
        }
        return (Class[]) intersection.toArray(new Class[intersection.size()]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void validateReturnTypes(List<Method> methods) {
        Method vs = null;
        for (Method method : methods) {
            if (vs == null || !vs.equalNameAndParameters(method)) {
                vs = method;
            } else {
                Class<?> returnType = method.getReturnType();
                Class<?> vsReturnType = vs.getReturnType();
                if (!returnType.isInterface() || !vsReturnType.isInterface()) {
                    if (vsReturnType.isAssignableFrom(returnType)) {
                        vs = method;
                    } else if (!returnType.isAssignableFrom(vsReturnType)) {
                        throw new IllegalArgumentException("proxied interface methods have incompatible return types:\n  " + ((Object) vs) + "\n  " + ((Object) method));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<Method> getMethods(Class<?>[] interfaces) {
        List<Method> result = new ArrayList<>();
        try {
            result.add(Object.class.getMethod("equals", Object.class));
            result.add(Object.class.getMethod(TTDownloadField.TT_HASHCODE, EmptyArray.CLASS));
            result.add(Object.class.getMethod("toString", EmptyArray.CLASS));
            getMethodsRecursive(interfaces, result);
            return result;
        } catch (NoSuchMethodException e2) {
            throw new AssertionError();
        }
    }

    private static void getMethodsRecursive(Class<?>[] interfaces, List<Method> methods) {
        for (Class<?> i10 : interfaces) {
            getMethodsRecursive(i10.getInterfaces(), methods);
            Collections.addAll(methods, i10.getDeclaredMethods());
        }
    }

    @CallerSensitive
    public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h10) throws IllegalArgumentException {
        Objects.requireNonNull(h10);
        Class<?>[] intfs = (Class[]) interfaces.clone();
        Class<?> cl = getProxyClass0(loader, intfs);
        try {
            Constructor<?> cons = cl.getConstructor(constructorParams);
            if (!Modifier.isPublic(cl.getModifiers())) {
                cons.setAccessible(true);
            }
            return cons.newInstance(h10);
        } catch (IllegalAccessException | InstantiationException e2) {
            throw new InternalError(e2.toString(), e2);
        } catch (NoSuchMethodException e10) {
            throw new InternalError(e10.toString(), e10);
        } catch (InvocationTargetException e11) {
            Throwable t2 = e11.getCause();
            if (t2 instanceof RuntimeException) {
                throw ((RuntimeException) t2);
            }
            throw new InternalError(t2.toString(), t2);
        }
    }

    public static boolean isProxyClass(Class<?> cl) {
        return Proxy.class.isAssignableFrom(cl) && proxyClassCache.containsValue(cl);
    }

    @CallerSensitive
    public static InvocationHandler getInvocationHandler(Object proxy) throws IllegalArgumentException {
        if (!isProxyClass(proxy.getClass())) {
            throw new IllegalArgumentException("not a proxy instance");
        }
        Proxy p10 = (Proxy) proxy;
        InvocationHandler ih = p10.f50365h;
        return ih;
    }

    private static Object invoke(Proxy proxy, Method method, Object[] args) throws Throwable {
        InvocationHandler h10 = proxy.f50365h;
        return h10.invoke(proxy, method, args);
    }
}
