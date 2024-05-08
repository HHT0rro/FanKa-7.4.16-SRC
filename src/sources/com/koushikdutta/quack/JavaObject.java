package com.koushikdutta.quack;

import com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.DatabaseSourceInfoStorage;
import com.huawei.jslite.type.JavaObjectProxy;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class JavaObject implements QuackObject, QuackJavaObject {
    private final QuackContext quackContext;
    private final Object target;

    public JavaObject(QuackContext quackContext, Object obj) {
        this.quackContext = quackContext;
        this.target = obj;
    }

    private Field findField(final String str, final Class cls) {
        return QuackContext.javaObjectFields.memoize(new MemoizeFunc() { // from class: com.koushikdutta.quack.c
            @Override // com.koushikdutta.quack.MemoizeFunc
            public final Object process() {
                Field lambda$findField$2;
                lambda$findField$2 = JavaObject.this.lambda$findField$2(cls, str);
                return lambda$findField$2;
            }
        }, str, cls.getDeclaredFields());
    }

    public static Method getGetterMethod(final String str, final Method[] methodArr) {
        return QuackContext.javaObjectGetter.memoize(new MemoizeFunc() { // from class: com.koushikdutta.quack.f
            @Override // com.koushikdutta.quack.MemoizeFunc
            public final Object process() {
                Method lambda$getGetterMethod$0;
                lambda$getGetterMethod$0 = JavaObject.lambda$getGetterMethod$0(methodArr, str);
                return lambda$getGetterMethod$0;
            }
        }, str, methodArr);
    }

    private Object getMap(Object obj) {
        Object obj2 = this.target;
        if (obj2 instanceof Map) {
            return this.quackContext.coerceJavaToJavaScript(((Map) obj2).get(obj));
        }
        return null;
    }

    public static Method getSetterMethod(final String str, final Method[] methodArr) {
        return QuackContext.javaObjectSetter.memoize(new MemoizeFunc() { // from class: com.koushikdutta.quack.g
            @Override // com.koushikdutta.quack.MemoizeFunc
            public final Object process() {
                Method lambda$getSetterMethod$1;
                lambda$getSetterMethod$1 = JavaObject.lambda$getSetterMethod$1(methodArr, str);
                return lambda$getSetterMethod$1;
            }
        }, str, methodArr);
    }

    private static boolean hasMethod(Class cls, String str, boolean z10) {
        for (Method method : cls.getMethods()) {
            if (!z10 || Modifier.isStatic(method.getModifiers())) {
                if (method.getName().equals(str)) {
                    return true;
                }
                QuackMethodName quackMethodName = (QuackMethodName) method.getAnnotation(QuackMethodName.class);
                if (quackMethodName != null && quackMethodName.name().equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Constructor lambda$construct$4(Constructor[] constructorArr, ArrayList arrayList) {
        Constructor constructor = null;
        int i10 = Integer.MAX_VALUE;
        for (Constructor constructor2 : constructorArr) {
            int abs = Math.abs(arrayList.size() - constructor2.getParameterTypes().length) * 1000;
            for (int i11 = 0; i11 < Math.min(constructor2.getParameterTypes().length, arrayList.size()); i11++) {
                Class<?> cls = (Class) arrayList.get(i11);
                Class<?> cls2 = constructor2.getParameterTypes()[i11];
                if (cls2 == cls) {
                    abs -= 4;
                }
                if (QuackContext.isNumberClass(cls2) && QuackContext.isNumberClass(cls)) {
                    abs -= 3;
                } else if ((cls2 == Long.class || cls2 == Long.TYPE) && cls == String.class) {
                    abs -= 2;
                } else if (cls == null || cls2.isAssignableFrom(cls)) {
                    abs--;
                }
            }
            if (abs < i10) {
                constructor = constructor2;
                i10 = abs;
            }
        }
        return constructor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Field lambda$findField$2(Class cls, String str) {
        for (Field field : cls.getDeclaredFields()) {
            if (field.getName().equals(str) && (field.getModifiers() & 8) == 0 && (field.getModifiers() & 1) != 0) {
                return field;
            }
        }
        Object obj = this.target;
        if (!(obj instanceof Class)) {
            return null;
        }
        for (Field field2 : ((Class) obj).getDeclaredFields()) {
            if (field2.getName().equals(str) && (field2.getModifiers() & 8) != 0 && (field2.getModifiers() & 1) != 0) {
                return field2;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$get$3(Class cls, String str) {
        if (hasMethod(cls, str, false)) {
            return Boolean.TRUE;
        }
        Object obj = this.target;
        if (obj instanceof Class) {
            return Boolean.valueOf(hasMethod((Class) obj, str, true));
        }
        return Boolean.FALSE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Method lambda$getGetterMethod$0(Method[] methodArr, String str) {
        QuackProperty quackProperty;
        for (Method method : methodArr) {
            if (method.getParameterTypes().length == 0 && method.getReturnType() != Void.TYPE && method.getReturnType() != Void.class && (quackProperty = (QuackProperty) method.getAnnotation(QuackProperty.class)) != null) {
                String name = quackProperty.name();
                if (QuackContext.isEmpty(name)) {
                    name = method.getName();
                }
                if (name.equals(str)) {
                    return method;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Method lambda$getSetterMethod$1(Method[] methodArr, String str) {
        QuackProperty quackProperty;
        for (Method method : methodArr) {
            if (method.getParameterTypes().length == 1 && ((method.getReturnType() == Void.TYPE || method.getReturnType() == Void.class) && (quackProperty = (QuackProperty) method.getAnnotation(QuackProperty.class)) != null)) {
                String name = quackProperty.name();
                if (QuackContext.isEmpty(name)) {
                    name = method.getName();
                }
                if (name.equals(str)) {
                    return method;
                }
            }
        }
        return null;
    }

    private void noSet() {
        throw new UnsupportedOperationException("can not set value on this JavaObject");
    }

    private boolean putMap(Object obj, Object obj2) {
        Object obj3 = this.target;
        if (obj3 instanceof Map) {
            ((Map) obj3).put(obj, obj2);
            return true;
        }
        noSet();
        return false;
    }

    @Override // com.koushikdutta.quack.QuackObject
    public Object callMethod(Object obj, Object... objArr) {
        throw new UnsupportedOperationException("can not call " + this.target);
    }

    public Object callProperty(Object obj, Object... objArr) {
        Objects.requireNonNull(obj);
        Object obj2 = get(obj);
        if (obj2 instanceof QuackObject) {
            return ((QuackObject) obj2).callMethod(this, objArr);
        }
        throw new UnsupportedOperationException("can not call " + this.target);
    }

    @Override // com.koushikdutta.quack.QuackObject
    public Object construct(Object... objArr) {
        Object obj = this.target;
        if (!(obj instanceof Class)) {
            return m0.b(this, objArr);
        }
        Class cls = (Class) obj;
        final Constructor<?>[] constructors = cls.getConstructors();
        if (constructors.length == 0) {
            try {
                return cls.newInstance();
            } catch (Exception e2) {
                return new IllegalArgumentException(e2);
            }
        }
        final ArrayList arrayList = new ArrayList();
        int i10 = 0;
        for (Object obj2 : objArr) {
            if (obj2 == null) {
                arrayList.add(null);
            } else {
                arrayList.add(obj2.getClass());
            }
        }
        Constructor memoize = QuackContext.javaObjectConstructorCandidates.memoize(new MemoizeFunc() { // from class: com.koushikdutta.quack.e
            @Override // com.koushikdutta.quack.MemoizeFunc
            public final Object process() {
                Constructor lambda$construct$4;
                lambda$construct$4 = JavaObject.lambda$construct$4(constructors, arrayList);
                return lambda$construct$4;
            }
        }, this.target, (Object[]) constructors, arrayList.toArray());
        try {
            int length = memoize.getParameterTypes().length;
            if (memoize.isVarArgs()) {
                length--;
            }
            ArrayList arrayList2 = new ArrayList();
            while (i10 < length) {
                if (i10 < objArr.length) {
                    arrayList2.add(this.quackContext.coerceJavaScriptToJava(memoize.getParameterTypes()[i10], objArr[i10]));
                } else {
                    arrayList2.add(null);
                }
                i10++;
            }
            if (memoize.isVarArgs()) {
                Class<?> componentType = memoize.getParameterTypes()[length].getComponentType();
                ArrayList arrayList3 = new ArrayList();
                while (i10 < objArr.length) {
                    arrayList3.add(this.quackContext.coerceJavaScriptToJava(componentType, objArr[i10]));
                    i10++;
                }
                arrayList2.add(JavaMethodObject.toArray(componentType, arrayList3));
            } else if (i10 < objArr.length) {
                System.err.println("dropping javascript to java arguments on the floor: " + (objArr.length - i10) + " " + memoize.toString());
            }
            return this.quackContext.coerceJavaToJavaScript(memoize.newInstance(arrayList2.toArray()));
        } catch (IllegalAccessException e10) {
            throw new IllegalArgumentException(memoize.toString(), e10);
        } catch (IllegalArgumentException e11) {
            throw new IllegalArgumentException(memoize.toString(), e11);
        } catch (InstantiationException e12) {
            throw new IllegalArgumentException(memoize.toString(), e12);
        } catch (InvocationTargetException e13) {
            if (e13.getTargetException() instanceof RuntimeException) {
                throw ((RuntimeException) e13.getTargetException());
            }
            throw new IllegalArgumentException(memoize.toString(), e13);
        }
    }

    public Object get(final String str) {
        Object map = getMap(str);
        if (map != null) {
            return map;
        }
        final Class<?> cls = this.target.getClass();
        if (!Proxy.isProxyClass(cls)) {
            if (cls.isArray()) {
                if (DatabaseSourceInfoStorage.COLUMN_LENGTH.equals(str)) {
                    return Integer.valueOf(Array.getLength(this.target));
                }
                return get(Integer.parseInt(str));
            }
            if (this.target instanceof List) {
                if (DatabaseSourceInfoStorage.COLUMN_LENGTH.equals(str)) {
                    return Integer.valueOf(((List) this.target).size());
                }
                return get(Integer.parseInt(str));
            }
            Field findField = findField(str, cls);
            if (findField != null) {
                try {
                    return this.quackContext.coerceJavaToJavaScript(findField.get(this.target));
                } catch (IllegalAccessException e2) {
                    throw new IllegalArgumentException(e2);
                }
            }
            if (JavaObjectProxy.class.isAssignableFrom(cls)) {
                try {
                    return this.quackContext.coerceJavaToJavaScript(((JavaObjectProxy) this.target).getFieldValue(str));
                } catch (NoSuchFieldException unused) {
                }
            }
        }
        Method getterMethod = getGetterMethod(str, cls.getMethods());
        if (getterMethod != null) {
            try {
                return this.quackContext.coerceJavaToJavaScript(getterMethod.invoke(this.target, new Object[0]));
            } catch (Exception e10) {
                throw new IllegalArgumentException(e10);
            }
        }
        if (QuackContext.javaObjectMethods.memoize(new MemoizeFunc() { // from class: com.koushikdutta.quack.d
            @Override // com.koushikdutta.quack.MemoizeFunc
            public final Object process() {
                Boolean lambda$get$3;
                lambda$get$3 = JavaObject.this.lambda$get$3(cls, str);
                return lambda$get$3;
            }
        }, str, cls.getMethods()).booleanValue()) {
            return new JavaMethodObject(this.quackContext, this.target, str);
        }
        return null;
    }

    @Override // com.koushikdutta.quack.QuackJavaObject
    public Object getObject() {
        return this.target;
    }

    @Override // com.koushikdutta.quack.QuackObject
    public /* synthetic */ boolean has(Object obj) {
        return m0.d(this, obj);
    }

    public boolean set(int i10, Object obj) {
        if (this.target.getClass().isArray()) {
            Array.set(this.target, i10, obj);
            return true;
        }
        Object obj2 = this.target;
        if (obj2 instanceof List) {
            ((List) obj2).set(i10, obj);
            return true;
        }
        noSet();
        return false;
    }

    public boolean set(String str, Object obj) {
        Class<?> cls = this.target.getClass();
        Field findField = findField(str, cls);
        if (findField != null) {
            try {
                findField.set(this.target, this.quackContext.coerceJavaScriptToJava(findField.getType(), obj));
                return true;
            } catch (IllegalAccessException e2) {
                throw new IllegalArgumentException(e2);
            }
        }
        if (cls.isArray() || (this.target instanceof List)) {
            try {
                return set(Integer.parseInt(str), obj);
            } catch (NumberFormatException unused) {
            }
        }
        if (JavaObjectProxy.class.isAssignableFrom(cls)) {
            try {
                ((JavaObjectProxy) this.target).setFieldValue(str, this.quackContext.coerceJavaToJavaScript(obj));
                return true;
            } catch (NoSuchFieldException unused2) {
            }
        }
        Method setterMethod = getSetterMethod(str, cls.getMethods());
        if (setterMethod != null) {
            try {
                QuackContext quackContext = this.quackContext;
                quackContext.coerceJavaToJavaScript(setterMethod.invoke(this.target, quackContext.coerceJavaScriptToJava(setterMethod.getParameterTypes()[0], obj)));
                return true;
            } catch (Exception e10) {
                throw new IllegalArgumentException(e10);
            }
        }
        return putMap(str, obj);
    }

    @Override // com.koushikdutta.quack.QuackObject
    public boolean set(Object obj, Object obj2) {
        if (obj instanceof Number) {
            Number number = (Number) obj;
            if (number.doubleValue() == number.intValue()) {
                return set(number.intValue(), obj2);
            }
        }
        if (obj instanceof String) {
            return set((String) obj, obj2);
        }
        return putMap(obj, obj2);
    }

    public Object get(int i10) {
        if (this.target.getClass().isArray()) {
            return Array.get(this.target, i10);
        }
        Object obj = this.target;
        if (obj instanceof List) {
            return ((List) obj).get(i10);
        }
        return null;
    }

    @Override // com.koushikdutta.quack.QuackObject
    public Object get(Object obj) {
        if (obj instanceof String) {
            return get((String) obj);
        }
        if (obj instanceof Number) {
            Number number = (Number) obj;
            if (number.doubleValue() == number.intValue()) {
                return get(number.intValue());
            }
        }
        return getMap(obj);
    }
}
