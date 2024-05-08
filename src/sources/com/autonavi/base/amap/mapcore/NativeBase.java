package com.autonavi.base.amap.mapcore;

import com.autonavi.base.amap.mapcore.annotations.ParameterIsClass;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class NativeBase {
    private static final String CREATE_OVERLAY = "createOverlay";
    private static final int STACK_NUMBER = 3;
    private static final String UPDATE_OPTIONS = "updateOptions";
    private boolean mCalledFuntion = false;
    public boolean useRunnable = true;
    public volatile boolean destroy = false;
    public ArrayList<Method> methodMap = new ArrayList<>();
    public ArrayList<Runnable> runnableArrayList = new ArrayList<>();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class Method {
        private boolean baseClass;
        private Class<?>[] clazz;
        private String methodName;
        private Object object;
        private Object[] param;

        public Method(Object obj, String str, boolean z10, Object... objArr) {
            this.object = obj;
            this.methodName = str;
            this.baseClass = z10;
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        this.clazz = new Class[objArr.length];
                        if ((NativeBase.CREATE_OVERLAY.equals(str) || NativeBase.UPDATE_OPTIONS.equals(str)) ? true : z10) {
                            for (int i10 = 0; i10 < objArr.length; i10++) {
                                if (i10 == 1) {
                                    this.clazz[i10] = objArr[i10].getClass().getSuperclass();
                                } else {
                                    this.clazz[i10] = objArr[i10].getClass();
                                }
                            }
                        } else {
                            for (int i11 = 0; i11 < objArr.length; i11++) {
                                this.clazz[i11] = objArr[i11].getClass();
                            }
                        }
                        this.param = new Object[objArr.length];
                        for (int i12 = 0; i12 < objArr.length; i12++) {
                            this.param[i12] = objArr[i12];
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public synchronized void callAllFunction() {
        java.lang.reflect.Method declaredMethod;
        if (isReady() && !this.destroy) {
            if (this.mCalledFuntion) {
                return;
            }
            try {
                this.mCalledFuntion = true;
                if (this.useRunnable) {
                    while (this.runnableArrayList.size() > 0 && !this.destroy) {
                        Runnable runnable = this.runnableArrayList.get(0);
                        if (runnable != null) {
                            runnable.run();
                        }
                        this.runnableArrayList.remove(0);
                    }
                    return;
                }
                Iterator<Method> iterator2 = this.methodMap.iterator2();
                while (iterator2.hasNext()) {
                    Method next = iterator2.next();
                    if (this.destroy) {
                        break;
                    }
                    if (next.object != null && (declaredMethod = next.object.getClass().getDeclaredMethod(next.methodName, next.clazz)) != null) {
                        declaredMethod.setAccessible(true);
                        declaredMethod.invoke(next.object, next.param);
                    }
                }
                this.methodMap.clear();
            } catch (Throwable unused) {
            }
        }
    }

    public abstract void createNative();

    public void destroy() {
        this.destroy = true;
        synchronized (this) {
            this.runnableArrayList.clear();
            this.methodMap.clear();
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
        try {
            finalizeNative();
        } catch (Throwable th) {
            th.toString();
        }
    }

    public abstract void finalizeNative();

    public abstract long getNative();

    public boolean isReady() {
        return getNative() != 0;
    }

    public synchronized void storeUncallFunction(Object obj, Object obj2, Object... objArr) {
        try {
            if (this.useRunnable && obj2 != null) {
                synchronized (this.runnableArrayList) {
                    this.runnableArrayList.add((Runnable) obj2);
                }
            } else {
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                if (stackTrace != null && stackTrace.length >= 3) {
                    this.methodMap.add(new Method(obj, stackTrace[3].getMethodName(), false, objArr));
                }
            }
            this.mCalledFuntion = false;
        } catch (Throwable unused) {
        }
    }

    public synchronized void storeUncallFunctionArray(Object obj, Object obj2, Object[] objArr) {
        try {
            if (this.useRunnable && obj2 != null) {
                synchronized (this.runnableArrayList) {
                    this.runnableArrayList.add((Runnable) obj2);
                }
            } else {
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                if (stackTrace != null && stackTrace.length >= 3) {
                    this.methodMap.add(new Method(obj, stackTrace[3].getMethodName(), false, objArr));
                }
            }
            this.mCalledFuntion = false;
        } catch (Throwable unused) {
        }
    }

    public void validate() {
        ParameterIsClass parameterIsClass;
        Class<?>[] parameterTypes;
        java.lang.reflect.Method[] methods = getClass().getMethods();
        if (methods == null) {
            return;
        }
        for (java.lang.reflect.Method method : methods) {
            if (method.isAnnotationPresent(ParameterIsClass.class) && (parameterIsClass = (ParameterIsClass) method.getAnnotation(ParameterIsClass.class)) != null && parameterIsClass.required() && (parameterTypes = method.getParameterTypes()) != null) {
                for (Class<?> cls : parameterTypes) {
                    if (!(cls instanceof Object)) {
                        throw new RuntimeException("函数：" + ((Object) method) + " 参数不是对象类型");
                    }
                }
            }
        }
    }
}
