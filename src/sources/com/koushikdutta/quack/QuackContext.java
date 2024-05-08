package com.koushikdutta.quack;

import com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.DatabaseSourceInfoStorage;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import com.huawei.jslite.type.CoerceJavaScriptToJava;
import java.io.Closeable;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class QuackContext implements Closeable {
    public static Memoize<Method> interfaceMethods;
    public static Memoize<Constructor> javaObjectConstructorCandidates;
    public static Memoize<Field> javaObjectFields;
    public static Memoize<Method> javaObjectGetter;
    public static Memoize<Method> javaObjectMethodCandidates;
    public static Memoize<Boolean> javaObjectMethods;
    public static Memoize<Method> javaObjectSetter;
    private final Map<Class, QuackCoercion> JavaScriptToJavaCoercions;
    public final Map<Method, QuackMethodCoercion> JavaScriptToJavaMethodCoercions;
    private final Map<Class, QuackCoercion> JavaToJavascriptCoercions;
    public final Map<Method, QuackMethodCoercion> JavaToJavascriptMethodCoercions;
    private long context;
    private Object[] empty;
    public final ArrayList<Long> finalizationQueue;
    private QuackInvocationHandlerWrapper invocationHandlerWrapper;
    private Executor jobExecutor;
    private CoerceJavaScriptToJava mCoerceJavaScriptToJava;
    private Object mReferrer;
    private final WeakExactHashMap<Object, Object> nativeMappings = new WeakExactHashMap<>();
    private long totalElapsedScriptExecutionMs;
    private boolean useQuickJS;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface Catcher {
        JavaScriptObject doCatch(Thrower thrower);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface JavaMethodReference<T> {
        void invoke(T t2) throws Exception;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface JavaMethodReference0<T, A> {
        void invoke(T t2, A a10) throws Exception;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface JavaMethodReference1<T, A, B> {
        void invoke(T t2, A a10, B b4) throws Exception;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface JavaMethodReference2<T, A, B, C> {
        void invoke(T t2, A a10, B b4, C c4) throws Exception;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface JavaMethodReference3<T, A, B, C, D> {
        void invoke(T t2, A a10, B b4, C c4, D d10) throws Exception;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface JavaMethodReference4<T, A, B, C, D, E> {
        void invoke(T t2, A a10, B b4, C c4, D d10, E e2) throws Exception;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class MethodException extends Exception {
        private static final long serialVersionUID = -1432377890337490927L;
        public Method method;

        public MethodException(Method method) {
            this.method = method;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface Thrower {
        void doThrow() throws Throwable;
    }

    static {
        try {
            System.loadLibrary("jslite");
        } catch (UnsatisfiedLinkError unused) {
        }
        javaObjectFields = new Memoize<>();
        javaObjectMethods = new Memoize<>();
        javaObjectGetter = new Memoize<>();
        javaObjectSetter = new Memoize<>();
        javaObjectMethodCandidates = new Memoize<>();
        javaObjectConstructorCandidates = new Memoize<>();
        interfaceMethods = new Memoize<>();
    }

    private QuackContext(final boolean z10) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.JavaScriptToJavaCoercions = linkedHashMap;
        this.JavaToJavascriptCoercions = new LinkedHashMap();
        this.JavaScriptToJavaMethodCoercions = new LinkedHashMap();
        this.JavaToJavascriptMethodCoercions = new LinkedHashMap();
        this.finalizationQueue = new ArrayList<>();
        this.empty = new Object[0];
        linkedHashMap.put(Enum.class, new QuackCoercion() { // from class: com.koushikdutta.quack.s
            @Override // com.koushikdutta.quack.QuackCoercion
            public final Object coerce(Class cls, Object obj) {
                Enum lambda$new$3;
                lambda$new$3 = QuackContext.lambda$new$3(cls, obj);
                return lambda$new$3;
            }
        });
        putJavaScriptToJavaCoercion(Byte.class, new QuackCoercion() { // from class: com.koushikdutta.quack.x
            @Override // com.koushikdutta.quack.QuackCoercion
            public final Object coerce(Class cls, Object obj) {
                Byte lambda$new$4;
                lambda$new$4 = QuackContext.lambda$new$4(cls, obj);
                return lambda$new$4;
            }
        });
        linkedHashMap.put(Byte.TYPE, new QuackCoercion() { // from class: com.koushikdutta.quack.n
            @Override // com.koushikdutta.quack.QuackCoercion
            public final Object coerce(Class cls, Object obj) {
                Object lambda$new$5;
                lambda$new$5 = QuackContext.lambda$new$5(cls, obj);
                return lambda$new$5;
            }
        });
        putJavaToJavaScriptCoercion(Byte.TYPE, new QuackCoercion() { // from class: com.koushikdutta.quack.e0
            @Override // com.koushikdutta.quack.QuackCoercion
            public final Object coerce(Class cls, Object obj) {
                Object lambda$new$6;
                lambda$new$6 = QuackContext.lambda$new$6(cls, (Byte) obj);
                return lambda$new$6;
            }
        });
        putJavaToJavaScriptCoercion(Byte.class, new QuackCoercion() { // from class: com.koushikdutta.quack.f0
            @Override // com.koushikdutta.quack.QuackCoercion
            public final Object coerce(Class cls, Object obj) {
                Object lambda$new$7;
                lambda$new$7 = QuackContext.lambda$new$7(cls, (Byte) obj);
                return lambda$new$7;
            }
        });
        linkedHashMap.put(Short.class, new QuackCoercion() { // from class: com.koushikdutta.quack.q
            @Override // com.koushikdutta.quack.QuackCoercion
            public final Object coerce(Class cls, Object obj) {
                Object lambda$new$8;
                lambda$new$8 = QuackContext.lambda$new$8(cls, obj);
                return lambda$new$8;
            }
        });
        linkedHashMap.put(Short.TYPE, new QuackCoercion() { // from class: com.koushikdutta.quack.l
            @Override // com.koushikdutta.quack.QuackCoercion
            public final Object coerce(Class cls, Object obj) {
                Object lambda$new$9;
                lambda$new$9 = QuackContext.lambda$new$9(cls, obj);
                return lambda$new$9;
            }
        });
        putJavaToJavaScriptCoercion(Short.TYPE, new QuackCoercion() { // from class: com.koushikdutta.quack.k
            @Override // com.koushikdutta.quack.QuackCoercion
            public final Object coerce(Class cls, Object obj) {
                Object lambda$new$10;
                lambda$new$10 = QuackContext.lambda$new$10(cls, (Short) obj);
                return lambda$new$10;
            }
        });
        putJavaToJavaScriptCoercion(Short.class, new QuackCoercion() { // from class: com.koushikdutta.quack.l0
            @Override // com.koushikdutta.quack.QuackCoercion
            public final Object coerce(Class cls, Object obj) {
                Object lambda$new$11;
                lambda$new$11 = QuackContext.lambda$new$11(cls, (Short) obj);
                return lambda$new$11;
            }
        });
        linkedHashMap.put(Integer.class, new QuackCoercion() { // from class: com.koushikdutta.quack.m
            @Override // com.koushikdutta.quack.QuackCoercion
            public final Object coerce(Class cls, Object obj) {
                Object lambda$new$12;
                lambda$new$12 = QuackContext.lambda$new$12(cls, obj);
                return lambda$new$12;
            }
        });
        linkedHashMap.put(Integer.TYPE, new QuackCoercion() { // from class: com.koushikdutta.quack.t
            @Override // com.koushikdutta.quack.QuackCoercion
            public final Object coerce(Class cls, Object obj) {
                Object lambda$new$13;
                lambda$new$13 = QuackContext.lambda$new$13(cls, obj);
                return lambda$new$13;
            }
        });
        linkedHashMap.put(Long.class, new QuackCoercion() { // from class: com.koushikdutta.quack.v
            @Override // com.koushikdutta.quack.QuackCoercion
            public final Object coerce(Class cls, Object obj) {
                Object lambda$new$14;
                lambda$new$14 = QuackContext.lambda$new$14(cls, obj);
                return lambda$new$14;
            }
        });
        Class<Long> cls = Long.TYPE;
        linkedHashMap.put(cls, new QuackCoercion() { // from class: com.koushikdutta.quack.o
            @Override // com.koushikdutta.quack.QuackCoercion
            public final Object coerce(Class cls2, Object obj) {
                Object lambda$new$15;
                lambda$new$15 = QuackContext.lambda$new$15(cls2, obj);
                return lambda$new$15;
            }
        });
        if (!z10) {
            putJavaToJavaScriptCoercion(cls, new QuackCoercion() { // from class: com.koushikdutta.quack.j0
                @Override // com.koushikdutta.quack.QuackCoercion
                public final Object coerce(Class cls2, Object obj) {
                    Object lambda$new$16;
                    lambda$new$16 = QuackContext.lambda$new$16(cls2, (Long) obj);
                    return lambda$new$16;
                }
            });
            putJavaToJavaScriptCoercion(Long.class, new QuackCoercion() { // from class: com.koushikdutta.quack.k0
                @Override // com.koushikdutta.quack.QuackCoercion
                public final Object coerce(Class cls2, Object obj) {
                    Object lambda$new$17;
                    lambda$new$17 = QuackContext.lambda$new$17(cls2, (Long) obj);
                    return lambda$new$17;
                }
            });
        }
        linkedHashMap.put(Float.class, new QuackCoercion() { // from class: com.koushikdutta.quack.p
            @Override // com.koushikdutta.quack.QuackCoercion
            public final Object coerce(Class cls2, Object obj) {
                Object lambda$new$18;
                lambda$new$18 = QuackContext.lambda$new$18(cls2, obj);
                return lambda$new$18;
            }
        });
        Class<Float> cls2 = Float.TYPE;
        linkedHashMap.put(cls2, new QuackCoercion() { // from class: com.koushikdutta.quack.w
            @Override // com.koushikdutta.quack.QuackCoercion
            public final Object coerce(Class cls3, Object obj) {
                Object lambda$new$19;
                lambda$new$19 = QuackContext.lambda$new$19(cls3, obj);
                return lambda$new$19;
            }
        });
        putJavaToJavaScriptCoercion(cls2, new QuackCoercion() { // from class: com.koushikdutta.quack.h0
            @Override // com.koushikdutta.quack.QuackCoercion
            public final Object coerce(Class cls3, Object obj) {
                Object lambda$new$20;
                lambda$new$20 = QuackContext.lambda$new$20(cls3, (Float) obj);
                return lambda$new$20;
            }
        });
        putJavaToJavaScriptCoercion(Float.class, new QuackCoercion() { // from class: com.koushikdutta.quack.i0
            @Override // com.koushikdutta.quack.QuackCoercion
            public final Object coerce(Class cls3, Object obj) {
                Object lambda$new$21;
                lambda$new$21 = QuackContext.lambda$new$21(cls3, (Float) obj);
                return lambda$new$21;
            }
        });
        linkedHashMap.put(Double.class, new QuackCoercion() { // from class: com.koushikdutta.quack.y
            @Override // com.koushikdutta.quack.QuackCoercion
            public final Object coerce(Class cls3, Object obj) {
                Object lambda$new$22;
                lambda$new$22 = QuackContext.lambda$new$22(cls3, obj);
                return lambda$new$22;
            }
        });
        linkedHashMap.put(Double.TYPE, new QuackCoercion() { // from class: com.koushikdutta.quack.r
            @Override // com.koushikdutta.quack.QuackCoercion
            public final Object coerce(Class cls3, Object obj) {
                Object lambda$new$23;
                lambda$new$23 = QuackContext.lambda$new$23(cls3, obj);
                return lambda$new$23;
            }
        });
        putJavaToJavaScriptCoercion(Enum.class, new QuackCoercion() { // from class: com.koushikdutta.quack.g0
            @Override // com.koushikdutta.quack.QuackCoercion
            public final Object coerce(Class cls3, Object obj) {
                Object lambda$new$24;
                lambda$new$24 = QuackContext.lambda$new$24(cls3, (Enum) obj);
                return lambda$new$24;
            }
        });
        putJavaToJavaScriptCoercion(ByteBuffer.class, new QuackCoercion() { // from class: com.koushikdutta.quack.u
            @Override // com.koushikdutta.quack.QuackCoercion
            public final Object coerce(Class cls3, Object obj) {
                Object lambda$new$25;
                lambda$new$25 = QuackContext.lambda$new$25(z10, cls3, (ByteBuffer) obj);
                return lambda$new$25;
            }
        });
    }

    private static native Object call(long j10, long j11, Object... objArr);

    private static native Object callConstructor(long j10, long j11, Object... objArr);

    private static native Object callMethod(long j10, long j11, Object obj, Object... objArr);

    private static native Object callProperty(long j10, long j11, Object obj, Object... objArr);

    private static native JavaScriptObject compileFunction(long j10, String str, String str2);

    private static native void cooperateDebugger(long j10);

    public static QuackContext create(boolean z10) {
        QuackContext quackContext = new QuackContext(z10);
        long createContext = createContext(quackContext, z10);
        if (createContext != 0) {
            quackContext.context = createContext;
            quackContext.useQuickJS = z10;
            return quackContext;
        }
        throw new OutOfMemoryError("Cannot create Duktape instance");
    }

    private static native long createContext(QuackContext quackContext, boolean z10);

    private static native long createContextByRuntime(QuackContext quackContext, long j10, boolean z10);

    private static <T> T createMethodInterceptProxy(Class<T> cls) {
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: com.koushikdutta.quack.d0
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                Object throwInvokedMethod;
                throwInvokedMethod = QuackContext.throwInvokedMethod(obj, method, objArr);
                return throwInvokedMethod;
            }
        });
    }

    private static native void debuggerAppNotify(long j10, Object... objArr);

    private static native void destroyContext(long j10);

    private static native Object evaluate(long j10, String str, String str2);

    private static native Object evaluateModule(long j10, String str, String str2);

    private static native Object evaluateThis(long j10, long j11, String str, String str2);

    private synchronized void finalizeJavaScriptObjects() {
        synchronized (this.finalizationQueue) {
            if (this.finalizationQueue.isEmpty()) {
                return;
            }
            long[] jArr = new long[this.finalizationQueue.size()];
            for (int i10 = 0; i10 < this.finalizationQueue.size(); i10++) {
                jArr[i10] = this.finalizationQueue.get(i10).longValue();
            }
            this.finalizationQueue.clear();
            long j10 = this.context;
            if (j10 == 0) {
                return;
            }
            finalizeJavaScriptObjects(j10, jArr);
        }
    }

    private static native void finalizeJavaScriptObjects(long j10, long[] jArr);

    private static native Object getFunctionThis(long j10, long j11);

    private static native JavaScriptObject getGlobalObject(long j10);

    private static native long getHeapSize(long j10);

    public static <T> Method getInterfaceMethod(Class<T> cls, JavaMethodReference<T> javaMethodReference) {
        return invokeMethodReferenceProxy(cls, javaMethodReference);
    }

    private static native Object getKeyInteger(long j10, long j11, int i10);

    private static native Object getKeyObject(long j10, long j11, Object obj);

    private static native Object getKeyString(long j10, long j11, String str);

    public static Method getLambdaMethod(Class cls) {
        if (!cls.isInterface()) {
            return null;
        }
        Method method = null;
        for (Method method2 : cls.getMethods()) {
            if (!Modifier.isStatic(method2.getModifiers())) {
                if (method != null) {
                    return null;
                }
                method = method2;
            }
        }
        return method;
    }

    private long getNativePointer(QuackJavaScriptObject quackJavaScriptObject) {
        if (quackJavaScriptObject.getNativeContext() != this.context) {
            return 0L;
        }
        return quackJavaScriptObject.getNativePointer();
    }

    private synchronized void handlePostInvocation() {
        if (hasPostInvocationTasks()) {
            Executor executor = this.jobExecutor;
            if (executor == null) {
                runPostInvocation();
            } else {
                executor.execute(new Runnable() { // from class: com.koushikdutta.quack.a0
                    @Override // java.lang.Runnable
                    public final void run() {
                        QuackContext.this.runPostInvocation();
                    }
                });
            }
        }
    }

    private static native boolean hasPendingJobs(long j10);

    private synchronized boolean hasPostInvocationTasks() {
        synchronized (this.finalizationQueue) {
            if (!this.finalizationQueue.isEmpty()) {
                return true;
            }
            return hasPendingJobs(this.context);
        }
    }

    private static <T> Method invokeMethodReferenceProxy(Class<T> cls, Object obj) {
        try {
            if (obj.getClass().getDeclaredMethods().length != 1) {
                throw new Exception("expecting lambda with 1 method: getInterfaceMethod(Foo.class, Foo::bar)");
            }
            Method method = obj.getClass().getDeclaredMethods()[0];
            Object[] objArr = new Object[method.getParameterTypes().length];
            objArr[0] = createMethodInterceptProxy(cls);
            method.invoke(obj, objArr);
            throw new IllegalArgumentException("interface method was not called by lambda.");
        } catch (Exception e2) {
            if (e2 instanceof InvocationTargetException) {
                InvocationTargetException invocationTargetException = (InvocationTargetException) e2;
                if (invocationTargetException.getTargetException() instanceof UndeclaredThrowableException) {
                    UndeclaredThrowableException undeclaredThrowableException = (UndeclaredThrowableException) invocationTargetException.getTargetException();
                    if (undeclaredThrowableException.getUndeclaredThrowable() instanceof MethodException) {
                        return ((MethodException) undeclaredThrowableException.getUndeclaredThrowable()).method;
                    }
                } else if (invocationTargetException.getTargetException() instanceof NullPointerException) {
                    throw new IllegalArgumentException("lambdas with primitive arguments must be invoked with default values: getInterfaceMethod(Foo.class, thiz -> thiz.setInt(0))");
                }
            }
            throw new IllegalArgumentException(e2);
        }
    }

    public static boolean isBoolClass(Class<?> cls) {
        return cls == Boolean.TYPE || cls == Boolean.class;
    }

    private static native boolean isDebugging(long j10);

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isNumberClass(Class<?> cls) {
        return cls == Byte.TYPE || cls == Byte.class || cls == Short.TYPE || cls == Short.class || cls == Integer.TYPE || cls == Integer.class || cls == Long.TYPE || cls == Long.class || cls == Float.TYPE || cls == Float.class || cls == Double.TYPE || cls == Double.class;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$coerceJavaScriptToJava$1(JavaScriptObject javaScriptObject, Object obj, Method method, Object[] objArr) throws Throwable {
        return coerceJavaScriptToJava(method.getReturnType(), javaScriptObject.call(JavaScriptObject.coerceArgs(this, method, objArr)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Method lambda$getInterfaceMethod$2(Method method) {
        boolean z10;
        if (method.getDeclaringClass().isInterface()) {
            return method;
        }
        for (Class<?> cls : method.getDeclaringClass().getInterfaces()) {
            for (Method method2 : cls.getDeclaredMethods()) {
                if (method2.getParameterTypes().length == method.getParameterTypes().length && method2.getName().equals(method.getName()) && method2.getReturnType().isAssignableFrom(method.getReturnType())) {
                    int i10 = 0;
                    while (true) {
                        if (i10 >= method.getParameterTypes().length) {
                            z10 = true;
                            break;
                        }
                        if (!method2.getParameterTypes()[i10].isAssignableFrom(method.getParameterTypes()[i10])) {
                            z10 = false;
                            break;
                        }
                        i10++;
                    }
                    if (z10) {
                        return method2;
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$new$10(Class cls, Short sh) {
        return Integer.valueOf(sh.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$new$11(Class cls, Short sh) {
        return Integer.valueOf(sh.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$new$12(Class cls, Object obj) {
        int parseInt;
        if (obj instanceof Number) {
            parseInt = ((Number) obj).intValue();
        } else {
            if (!(obj instanceof String)) {
                return obj;
            }
            parseInt = Integer.parseInt(obj.toString());
        }
        return Integer.valueOf(parseInt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$new$13(Class cls, Object obj) {
        int parseInt;
        if (obj instanceof Number) {
            parseInt = ((Number) obj).intValue();
        } else {
            if (!(obj instanceof String)) {
                return obj;
            }
            parseInt = Integer.parseInt(obj.toString());
        }
        return Integer.valueOf(parseInt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$new$14(Class cls, Object obj) {
        long parseLong;
        if (obj instanceof Number) {
            parseLong = ((Number) obj).longValue();
        } else {
            if (!(obj instanceof String)) {
                return obj;
            }
            parseLong = Long.parseLong(obj.toString());
        }
        return Long.valueOf(parseLong);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$new$15(Class cls, Object obj) {
        long parseLong;
        if (obj instanceof Number) {
            parseLong = ((Number) obj).longValue();
        } else {
            if (!(obj instanceof String)) {
                return obj;
            }
            parseLong = Long.parseLong(obj.toString());
        }
        return Long.valueOf(parseLong);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$new$16(Class cls, Long l10) {
        return l10.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$new$17(Class cls, Long l10) {
        return l10.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$new$18(Class cls, Object obj) {
        float parseFloat;
        if (obj instanceof Number) {
            parseFloat = ((Number) obj).floatValue();
        } else {
            if (!(obj instanceof String)) {
                return obj;
            }
            parseFloat = Float.parseFloat(obj.toString());
        }
        return Float.valueOf(parseFloat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$new$19(Class cls, Object obj) {
        float parseFloat;
        if (obj instanceof Number) {
            parseFloat = ((Number) obj).floatValue();
        } else {
            if (!(obj instanceof String)) {
                return obj;
            }
            parseFloat = Float.parseFloat(obj.toString());
        }
        return Float.valueOf(parseFloat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$new$20(Class cls, Float f10) {
        return Double.valueOf(f10.doubleValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$new$21(Class cls, Float f10) {
        return Double.valueOf(f10.doubleValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$new$22(Class cls, Object obj) {
        double parseDouble;
        if (obj instanceof Number) {
            parseDouble = ((Number) obj).doubleValue();
        } else {
            if (!(obj instanceof String)) {
                return obj;
            }
            parseDouble = Double.parseDouble(obj.toString());
        }
        return Double.valueOf(parseDouble);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$new$23(Class cls, Object obj) {
        double parseDouble;
        if (obj instanceof Number) {
            parseDouble = ((Number) obj).doubleValue();
        } else {
            if (!(obj instanceof String)) {
                return obj;
            }
            parseDouble = Double.parseDouble(obj.toString());
        }
        return Double.valueOf(parseDouble);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$new$24(Class cls, Enum r12) {
        return r12.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$new$25(boolean z10, Class cls, ByteBuffer byteBuffer) {
        if (byteBuffer.isDirect() && z10) {
            return byteBuffer;
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(byteBuffer.remaining());
        allocateDirect.put(byteBuffer.duplicate());
        allocateDirect.flip();
        return allocateDirect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Enum lambda$new$3(Class cls, Object obj) {
        if (obj == null) {
            return null;
        }
        return Enum.valueOf(cls, obj.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Byte lambda$new$4(Class cls, Object obj) {
        return Byte.valueOf(obj instanceof Number ? ((Number) obj).byteValue() : obj instanceof String ? Byte.parseByte(obj.toString()) : ((Byte) obj).byteValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$new$5(Class cls, Object obj) {
        byte parseByte;
        if (obj instanceof Number) {
            parseByte = ((Number) obj).byteValue();
        } else {
            if (!(obj instanceof String)) {
                return obj;
            }
            parseByte = Byte.parseByte(obj.toString());
        }
        return Byte.valueOf(parseByte);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$new$6(Class cls, Byte b4) {
        return Integer.valueOf(b4.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$new$7(Class cls, Byte b4) {
        return Integer.valueOf(b4.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$new$8(Class cls, Object obj) {
        short parseShort;
        if (obj instanceof Number) {
            parseShort = ((Number) obj).shortValue();
        } else {
            if (!(obj instanceof String)) {
                return obj;
            }
            parseShort = Short.parseShort(obj.toString());
        }
        return Short.valueOf(parseShort);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$new$9(Class cls, Object obj) {
        short parseShort;
        if (obj instanceof Number) {
            parseShort = ((Number) obj).shortValue();
        } else {
            if (!(obj instanceof String)) {
                return obj;
            }
            parseShort = Short.parseShort(obj.toString());
        }
        return Short.valueOf(parseShort);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$newError$26(Throwable th) throws Throwable {
        throw th;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$wrapObjectInvocationHandler$0(JavaScriptObject javaScriptObject, InvocationHandler invocationHandler, Object obj, Method method, Object[] objArr) throws Throwable {
        if (method.getDeclaringClass() == Object.class) {
            return method.invoke(javaScriptObject, objArr);
        }
        return invocationHandler.invoke(obj, method, objArr);
    }

    private Object quackApply(QuackObject quackObject, Object obj, Object... objArr) {
        if (objArr == null) {
            objArr = this.empty;
        }
        return quackObject.callMethod(obj, objArr);
    }

    private Object quackConstruct(QuackObject quackObject, Object... objArr) {
        if (objArr == null) {
            objArr = this.empty;
        }
        return quackObject.construct(objArr);
    }

    private Object quackGet(QuackObject quackObject, Object obj) {
        return quackObject.get(obj);
    }

    private boolean quackHas(QuackObject quackObject, Object obj) {
        return quackObject.has(obj);
    }

    private boolean quackSet(QuackObject quackObject, Object obj, Object obj2) {
        return quackObject.set(obj, obj2);
    }

    private static native void runJobs(long j10);

    private static native boolean setKeyInteger(long j10, long j11, int i10, Object obj);

    private static native boolean setKeyObject(long j10, long j11, Object obj, Object obj2);

    private static native boolean setKeyString(long j10, long j11, String str, Object obj);

    private static native String stringify(long j10, long j11);

    /* JADX INFO: Access modifiers changed from: private */
    public static Object throwInvokedMethod(Object obj, Method method, Object[] objArr) throws MethodException {
        throw new MethodException(method);
    }

    private static native void waitForDebugger(long j10, String str);

    private static InvocationHandler wrapObjectInvocationHandler(final JavaScriptObject javaScriptObject, final InvocationHandler invocationHandler) {
        return new InvocationHandler() { // from class: com.koushikdutta.quack.b0
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                Object lambda$wrapObjectInvocationHandler$0;
                lambda$wrapObjectInvocationHandler$0 = QuackContext.lambda$wrapObjectInvocationHandler$0(JavaScriptObject.this, invocationHandler, obj, method, objArr);
                return lambda$wrapObjectInvocationHandler$0;
            }
        };
    }

    public synchronized Object call(long j10, Object... objArr) {
        if (this.context == 0) {
            return null;
        }
        long nanoTime = System.nanoTime() / 1000000;
        try {
            return call(this.context, j10, objArr);
        } finally {
            this.totalElapsedScriptExecutionMs += (System.nanoTime() / 1000000) - nanoTime;
            handlePostInvocation();
        }
    }

    public synchronized Object callConstructor(long j10, Object... objArr) {
        if (this.context == 0) {
            return null;
        }
        long nanoTime = System.nanoTime() / 1000000;
        try {
            return callConstructor(this.context, j10, objArr);
        } finally {
            this.totalElapsedScriptExecutionMs += (System.nanoTime() / 1000000) - nanoTime;
            handlePostInvocation();
        }
    }

    public synchronized Object callMethod(long j10, Object obj, Object... objArr) {
        if (this.context == 0) {
            return null;
        }
        long nanoTime = System.nanoTime() / 1000000;
        try {
            return callMethod(this.context, j10, obj, objArr);
        } finally {
            this.totalElapsedScriptExecutionMs += (System.nanoTime() / 1000000) - nanoTime;
            handlePostInvocation();
        }
    }

    public synchronized Object callProperty(long j10, Object obj, Object... objArr) {
        if (this.context == 0) {
            return null;
        }
        long nanoTime = System.nanoTime() / 1000000;
        try {
            return callProperty(this.context, j10, obj, objArr);
        } finally {
            this.totalElapsedScriptExecutionMs += (System.nanoTime() / 1000000) - nanoTime;
            handlePostInvocation();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        long j10 = this.context;
        if (j10 != 0) {
            this.context = 0L;
            destroyContext(j10);
        }
        this.nativeMappings.clear();
    }

    public Object[] coerceJavaArgsToJavaScript(Object... objArr) {
        if (objArr != null) {
            for (int i10 = 0; i10 < objArr.length; i10++) {
                objArr[i10] = coerceJavaToJavaScript(objArr[i10]);
            }
        }
        return objArr;
    }

    public Object coerceJavaScriptToJava(Class<?> cls, Object obj) {
        Object coerce;
        Object object;
        if (obj == null) {
            return null;
        }
        while ((obj instanceof QuackJavaObject) && obj != (object = ((QuackJavaObject) obj).getObject())) {
            obj = object;
        }
        if (cls == null || cls.isInstance(obj)) {
            return obj;
        }
        if (cls == Boolean.TYPE && (obj instanceof Boolean)) {
            return obj;
        }
        Class<Byte> cls2 = Byte.TYPE;
        if (cls == cls2 && (obj instanceof Byte)) {
            return obj;
        }
        Class<Short> cls3 = Short.TYPE;
        if (cls == cls3 && (obj instanceof Short)) {
            return obj;
        }
        Class<Integer> cls4 = Integer.TYPE;
        if (cls == cls4 && (obj instanceof Integer)) {
            return obj;
        }
        Class<Long> cls5 = Long.TYPE;
        if (cls == cls5 && (obj instanceof Long)) {
            return obj;
        }
        Class<Float> cls6 = Float.TYPE;
        if (cls == cls6 && (obj instanceof Float)) {
            return obj;
        }
        if (cls == Double.TYPE && (obj instanceof Double)) {
            return obj;
        }
        if ((cls == cls2 || cls == Byte.class) && (obj instanceof Double)) {
            return Byte.valueOf(((Double) obj).byteValue());
        }
        if ((cls == cls3 || cls == Short.class) && (obj instanceof Double)) {
            return Short.valueOf(((Double) obj).shortValue());
        }
        if ((cls == cls4 || cls == Integer.class) && (obj instanceof Double)) {
            return Integer.valueOf(((Double) obj).intValue());
        }
        if ((cls == cls6 || cls == Float.class) && (obj instanceof Double)) {
            return Float.valueOf(((Double) obj).floatValue());
        }
        if ((cls == cls5 || cls == Long.class) && (obj instanceof Double)) {
            return Long.valueOf(((Double) obj).longValue());
        }
        if (cls.isArray() && (obj instanceof JavaScriptObject)) {
            JavaScriptObject javaScriptObject = (JavaScriptObject) obj;
            int intValue = ((Number) javaScriptObject.get(DatabaseSourceInfoStorage.COLUMN_LENGTH)).intValue();
            Class<?> componentType = cls.getComponentType();
            Object newInstance = Array.newInstance(componentType, intValue);
            for (int i10 = 0; i10 < intValue; i10++) {
                Array.set(newInstance, i10, coerceJavaScriptToJava(componentType, javaScriptObject.get(i10)));
            }
            return newInstance;
        }
        Object coerceJavaScriptToJava = coerceJavaScriptToJava(this.JavaScriptToJavaCoercions, obj, cls);
        if (coerceJavaScriptToJava != null) {
            return coerceJavaScriptToJava;
        }
        CoerceJavaScriptToJava coerceJavaScriptToJava2 = this.mCoerceJavaScriptToJava;
        if (coerceJavaScriptToJava2 != null && (coerce = coerceJavaScriptToJava2.coerce(cls, obj)) != null) {
            return coerce;
        }
        if (!cls.isInterface() || !(obj instanceof JavaScriptObject)) {
            return obj;
        }
        final JavaScriptObject javaScriptObject2 = (JavaScriptObject) obj;
        return getLambdaMethod(cls) != null ? Proxy.newProxyInstance(QuackJavaScriptObject.class.getClassLoader(), new Class[]{QuackJavaScriptObject.class, cls}, javaScriptObject2.getWrappedInvocationHandler(new InvocationHandler() { // from class: com.koushikdutta.quack.c0
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj2, Method method, Object[] objArr) {
                Object lambda$coerceJavaScriptToJava$1;
                lambda$coerceJavaScriptToJava$1 = QuackContext.this.lambda$coerceJavaScriptToJava$1(javaScriptObject2, obj2, method, objArr);
                return lambda$coerceJavaScriptToJava$1;
            }
        })) : Proxy.newProxyInstance(QuackJavaScriptObject.class.getClassLoader(), new Class[]{QuackJavaScriptObject.class, cls}, javaScriptObject2.createInvocationHandler());
    }

    public Object coerceJavaToJavaScript(Object obj) {
        if (obj == null) {
            return null;
        }
        return coerceJavaToJavaScript(obj.getClass(), obj);
    }

    public synchronized JavaScriptObject compileFunction(String str, String str2) {
        return compileFunction(this.context, str, str2);
    }

    public synchronized void cooperateDebugger() {
        long j10 = this.context;
        if (j10 == 0) {
            return;
        }
        cooperateDebugger(j10);
    }

    public synchronized void debuggerAppNotify(Object... objArr) {
        long j10 = this.context;
        if (j10 == 0) {
            return;
        }
        debuggerAppNotify(j10, objArr);
    }

    public synchronized <T> T evaluate(Class<T> cls, String str, String str2) {
        return (T) evaluate(cls, null, str, str2);
    }

    public synchronized JavaScriptObject evaluateForJavaScriptObject(String str) {
        return (JavaScriptObject) evaluate(str, JavaScriptObject.class);
    }

    public synchronized JavaScriptObject evaluateModule(String str, String str2) {
        if (this.context == 0) {
            return null;
        }
        long nanoTime = System.nanoTime() / 1000000;
        try {
            return (JavaScriptObject) coerceJavaScriptToJava(JavaScriptObject.class, evaluateModule(this.context, str, str2));
        } finally {
            this.totalElapsedScriptExecutionMs += (System.nanoTime() / 1000000) - nanoTime;
            handlePostInvocation();
        }
    }

    public synchronized void finalize() throws Throwable {
        if (this.context != 0) {
            Logger.getLogger(QuackContext.class.getName()).warning("Duktape instance leaked!");
        }
        close();
    }

    public void finalizeJavaScriptObject(long j10) {
        if (this.context == 0) {
            return;
        }
        synchronized (this.finalizationQueue) {
            this.finalizationQueue.add(Long.valueOf(j10));
        }
    }

    public void gc() {
        for (int i10 = 0; i10 < 2; i10++) {
            System.gc();
            System.gc();
            finalizeJavaScriptObjects();
            System.gc();
            System.gc();
            purgeNativeMappings();
        }
    }

    public synchronized Object getFunctionThis(long j10) {
        long j11 = this.context;
        if (j11 == 0) {
            return null;
        }
        return getFunctionThis(j11, j10);
    }

    public synchronized JavaScriptObject getGlobalObject() {
        return getGlobalObject(this.context);
    }

    public synchronized long getHeapSize() {
        long j10 = this.context;
        if (j10 == 0) {
            return 0L;
        }
        return getHeapSize(j10);
    }

    public Executor getJobExecutor() {
        return this.jobExecutor;
    }

    public synchronized Object getKeyInteger(long j10, int i10) {
        long j11 = this.context;
        if (j11 == 0) {
            return null;
        }
        return getKeyInteger(j11, j10, i10);
    }

    public synchronized Object getKeyObject(long j10, Object obj) {
        long j11 = this.context;
        if (j11 == 0) {
            return null;
        }
        return getKeyObject(j11, j10, obj);
    }

    public synchronized Object getKeyString(long j10, String str) {
        long j11 = this.context;
        if (j11 == 0) {
            return null;
        }
        return getKeyString(j11, j10, str);
    }

    public synchronized int getMappedNativeCount() {
        return this.nativeMappings.size();
    }

    public Object getReferrer() {
        return this.mReferrer;
    }

    public long getTotalScriptExecutionTime() {
        return this.totalElapsedScriptExecutionMs;
    }

    public InvocationHandler getWrappedInvocationHandler(JavaScriptObject javaScriptObject, InvocationHandler invocationHandler) {
        InvocationHandler wrapInvocationHandler;
        InvocationHandler wrapObjectInvocationHandler = wrapObjectInvocationHandler(javaScriptObject, invocationHandler);
        QuackInvocationHandlerWrapper quackInvocationHandlerWrapper = this.invocationHandlerWrapper;
        return (quackInvocationHandlerWrapper == null || (wrapInvocationHandler = quackInvocationHandlerWrapper.wrapInvocationHandler(javaScriptObject, wrapObjectInvocationHandler)) == null) ? wrapObjectInvocationHandler : wrapInvocationHandler;
    }

    public synchronized boolean isClose() {
        return this.context == 0;
    }

    public boolean isDebugging() {
        long j10 = this.context;
        if (j10 == 0) {
            return false;
        }
        return isDebugging(j10);
    }

    public synchronized JavaScriptObject newError(final Throwable th) {
        if (this.context == 0) {
            return null;
        }
        try {
            return ((Catcher) evaluate("(function(t) { try { t(); } catch (e) { return e } })", Catcher.class)).doCatch(new Thrower() { // from class: com.koushikdutta.quack.z
                @Override // com.koushikdutta.quack.QuackContext.Thrower
                public final void doThrow() {
                    QuackContext.lambda$newError$26(Throwable.this);
                }
            });
        } catch (Throwable unused) {
            return null;
        }
    }

    public synchronized int purgeNativeMappings() {
        return this.nativeMappings.purge();
    }

    public synchronized <T> void putJavaScriptToJavaCoercion(Class<T> cls, QuackCoercion<T, Object> quackCoercion) {
        this.JavaScriptToJavaCoercions.put(cls, quackCoercion);
    }

    public synchronized void putJavaScriptToJavaMethodCoercion(Method method, QuackMethodCoercion quackMethodCoercion) {
        this.JavaScriptToJavaMethodCoercions.put(method, quackMethodCoercion);
        interfaceMethods.clear();
    }

    public synchronized <F> void putJavaToJavaScriptCoercion(Class<F> cls, QuackCoercion<Object, F> quackCoercion) {
        this.JavaToJavascriptCoercions.put(cls, quackCoercion);
    }

    public synchronized void putJavaToJavaScriptMethodCoercion(Method method, QuackMethodCoercion quackMethodCoercion) {
        this.JavaToJavascriptMethodCoercions.put(method, quackMethodCoercion);
        interfaceMethods.clear();
    }

    public synchronized void quackMapNative(Object obj, Object obj2) {
        this.nativeMappings.put(obj, obj2);
    }

    public Object quackUnmapNative(Object obj) {
        return this.nativeMappings.get(obj);
    }

    public void resetTotalScriptExecutionTime() {
        this.totalElapsedScriptExecutionMs = 0L;
    }

    public synchronized void runPostInvocation() {
        if (this.context == 0) {
            return;
        }
        finalizeJavaScriptObjects();
        runJobs(this.context);
    }

    public void setCoerceJavaScriptToJava(CoerceJavaScriptToJava coerceJavaScriptToJava) {
        this.mCoerceJavaScriptToJava = coerceJavaScriptToJava;
    }

    public void setInvocationHandlerWrapper(QuackInvocationHandlerWrapper quackInvocationHandlerWrapper) {
        this.invocationHandlerWrapper = quackInvocationHandlerWrapper;
    }

    public void setJobExecutor(Executor executor) {
        this.jobExecutor = executor;
    }

    public synchronized boolean setKeyInteger(long j10, int i10, Object obj) {
        long j11 = this.context;
        if (j11 == 0) {
            return false;
        }
        return setKeyInteger(j11, j10, i10, obj);
    }

    public synchronized boolean setKeyObject(long j10, Object obj, Object obj2) {
        long j11 = this.context;
        if (j11 == 0) {
            return false;
        }
        return setKeyObject(j11, j10, obj, obj2);
    }

    public synchronized boolean setKeyString(long j10, String str, Object obj) {
        long j11 = this.context;
        if (j11 == 0) {
            return false;
        }
        return setKeyString(j11, j10, str, obj);
    }

    public void setReferrer(Object obj) {
        this.mReferrer = obj;
    }

    public synchronized String stringify(long j10) {
        long j11 = this.context;
        if (j11 == 0) {
            return null;
        }
        return stringify(j11, j10);
    }

    public synchronized void throwObject(Object obj) {
        if (this.context == 0) {
            return;
        }
        evaluateForJavaScriptObject("(function(t) { throw t; })").call(obj);
    }

    public void waitForDebugger(String str) {
        long j10 = this.context;
        if (j10 == 0) {
            return;
        }
        waitForDebugger(j10, str);
    }

    public static <T, A> Method getInterfaceMethod(Class<T> cls, JavaMethodReference0<T, A> javaMethodReference0) {
        return invokeMethodReferenceProxy(cls, javaMethodReference0);
    }

    public Object coerceJavaToJavaScript(final Class cls, Object obj) {
        Object obj2;
        if (obj == null) {
            return null;
        }
        do {
            obj2 = obj;
            if (!(obj2 instanceof QuackJavaObject)) {
                break;
            }
            obj = ((QuackJavaObject) obj2).getObject();
        } while (obj2 != obj);
        Object coerceJavaToJavaScript = coerceJavaToJavaScript(this.JavaToJavascriptCoercions, obj2, cls);
        if (coerceJavaToJavaScript != null) {
            return coerceJavaToJavaScript;
        }
        Method lambdaMethod = getLambdaMethod(cls);
        return lambdaMethod != null ? new JavaMethodObject(this, obj2, lambdaMethod.getName()) { // from class: com.koushikdutta.quack.QuackContext.1
            @Override // com.koushikdutta.quack.JavaMethodObject, com.koushikdutta.quack.QuackObject
            public Object callMethod(Object obj3, Object... objArr) {
                return super.callMethod(obj3, objArr);
            }

            @Override // com.koushikdutta.quack.JavaMethodObject
            public Method[] getMethods(Object obj3) {
                return cls.getMethods();
            }
        } : obj2;
    }

    public synchronized <T> T evaluate(Class<T> cls, JavaScriptObject javaScriptObject, String str, String str2) {
        Object evaluate;
        if (this.context == 0) {
            return null;
        }
        long nanoTime = System.nanoTime() / 1000000;
        try {
            if (javaScriptObject != null) {
                evaluate = evaluateThis(this.context, javaScriptObject.pointer, str, str2);
            } else {
                evaluate = evaluate(this.context, str, str2);
            }
            return (T) coerceJavaScriptToJava(cls, evaluate);
        } finally {
            this.totalElapsedScriptExecutionMs += (System.nanoTime() / 1000000) - nanoTime;
            handlePostInvocation();
        }
    }

    public static <T, A, B> Method getInterfaceMethod(Class<T> cls, JavaMethodReference1<T, A, B> javaMethodReference1) {
        return invokeMethodReferenceProxy(cls, javaMethodReference1);
    }

    public static <T, A, B, C> Method getInterfaceMethod(Class<T> cls, JavaMethodReference2<T, A, B, C> javaMethodReference2) {
        return invokeMethodReferenceProxy(cls, javaMethodReference2);
    }

    public static <T, A, B, C, D> Method getInterfaceMethod(Class<T> cls, JavaMethodReference3<T, A, B, C, D> javaMethodReference3) {
        return invokeMethodReferenceProxy(cls, javaMethodReference3);
    }

    public static QuackContext create() {
        return create(true);
    }

    public static <T, A, B, C, D, E> Method getInterfaceMethod(Class<T> cls, JavaMethodReference4<T, A, B, C, D, E> javaMethodReference4) {
        return invokeMethodReferenceProxy(cls, javaMethodReference4);
    }

    private static Object coerceJavaToJavaScript(Map<Class, QuackCoercion> map, Object obj, Class<?> cls) {
        QuackCoercion quackCoercion = map.get(cls);
        if (quackCoercion != null) {
            return quackCoercion.coerce(cls, obj);
        }
        for (Map.Entry<Class, QuackCoercion> entry : map.entrySet()) {
            if (entry.getKey().isAssignableFrom(cls)) {
                return entry.getValue().coerce(cls, obj);
            }
        }
        return null;
    }

    public static QuackContext create(long j10) {
        QuackContext quackContext = new QuackContext(true);
        long createContextByRuntime = createContextByRuntime(quackContext, j10, true);
        if (createContextByRuntime != 0) {
            quackContext.context = createContextByRuntime;
            quackContext.useQuickJS = true;
            return quackContext;
        }
        throw new OutOfMemoryError("Cannot create Duktape instance");
    }

    public static Method getInterfaceMethod(final Method method) {
        return interfaceMethods.memoize(new MemoizeFunc() { // from class: com.koushikdutta.quack.j
            @Override // com.koushikdutta.quack.MemoizeFunc
            public final Object process() {
                Method lambda$getInterfaceMethod$2;
                lambda$getInterfaceMethod$2 = QuackContext.lambda$getInterfaceMethod$2(Method.this);
                return lambda$getInterfaceMethod$2;
            }
        }, method);
    }

    public synchronized JavaScriptObject evaluateModule(String str) {
        return evaluateModule(str, SymbolValues.QUESTION_EN_SYMBOL);
    }

    public synchronized Object evaluate(String str, String str2) {
        return evaluate((Class) null, str, str2);
    }

    public synchronized Object evaluate(String str) {
        return evaluate(str, SymbolValues.QUESTION_EN_SYMBOL);
    }

    public synchronized <T> T evaluate(String str, Class<T> cls) {
        return (T) coerceJavaScriptToJava(cls, evaluate(str));
    }

    private static Object coerceJavaScriptToJava(Map<Class, QuackCoercion> map, Object obj, Class<?> cls) {
        QuackCoercion quackCoercion = map.get(cls);
        if (quackCoercion != null) {
            return quackCoercion.coerce(cls, obj);
        }
        Iterator<Map.Entry<Class, QuackCoercion>> iterator2 = map.entrySet().iterator2();
        while (iterator2.hasNext()) {
            if (cls.isAssignableFrom(iterator2.next().getKey())) {
                throw new AssertionError((Object) "Superclass converter not implemented.");
            }
        }
        for (Map.Entry<Class, QuackCoercion> entry : map.entrySet()) {
            if (entry.getKey().isAssignableFrom(cls)) {
                return entry.getValue().coerce(cls, obj);
            }
        }
        return null;
    }
}
