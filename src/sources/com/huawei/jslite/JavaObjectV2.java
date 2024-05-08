package com.huawei.jslite;

import android.text.TextUtils;
import com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.DatabaseSourceInfoStorage;
import com.huawei.jslite.JavaObjectV2;
import com.huawei.jslite.SyntheticProperty;
import com.huawei.jslite.type.JavaObjectProxy;
import com.koushikdutta.quack.JavaObject;
import com.koushikdutta.quack.Memoize;
import com.koushikdutta.quack.MemoizeFunc;
import com.koushikdutta.quack.QuackContext;
import com.koushikdutta.quack.QuackMethodName;
import com.koushikdutta.quack.QuackProperty;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class JavaObjectV2 extends JavaObject {
    private static final Memoize<SyntheticProperty> javaObjectSyntheticProperties = new Memoize<>();
    private static final Object nullValue = new Object();
    private final QuackContext quackContext;
    private final Object target;
    private final Class targetClazz;

    public JavaObjectV2(QuackContext quackContext, Object obj) {
        super(quackContext, obj);
        this.quackContext = quackContext;
        this.target = obj;
        this.targetClazz = obj instanceof Class ? (Class) obj : obj.getClass();
    }

    private Field findField(String str, Class cls) {
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

    private static Method getGetterMethod(String str, Class cls) {
        QuackProperty quackProperty;
        for (Method method : cls.getMethods()) {
            if (method.getParameterTypes().length == 0 && method.getReturnType() != Void.TYPE && method.getReturnType() != Void.class && (quackProperty = (QuackProperty) method.getAnnotation(QuackProperty.class)) != null) {
                String name = quackProperty.name();
                if (TextUtils.isEmpty(name)) {
                    name = method.getName();
                }
                if (name.equals(str)) {
                    return method;
                }
            }
        }
        return null;
    }

    private Object getInternal(final String str) {
        Object map = getMap(str);
        if (map != null) {
            return map;
        }
        final Class<?> cls = this.target.getClass();
        if (!Proxy.isProxyClass(cls)) {
            try {
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
            } catch (NumberFormatException unused) {
            }
        }
        if (JavaObjectProxy.class.isAssignableFrom(cls)) {
            try {
                return this.quackContext.coerceJavaToJavaScript(((JavaObjectProxy) this.target).getFieldValue(str));
            } catch (NoSuchFieldException unused2) {
            }
        }
        SyntheticProperty memoize = javaObjectSyntheticProperties.memoize(new MemoizeFunc() { // from class: qa.f
            @Override // com.koushikdutta.quack.MemoizeFunc
            public final Object process() {
                SyntheticProperty lambda$getInternal$0;
                lambda$getInternal$0 = JavaObjectV2.this.lambda$getInternal$0(cls, str);
                return lambda$getInternal$0;
            }
        }, str, this.targetClazz);
        if (memoize == null) {
            return null;
        }
        Object obj = memoize.get(this.quackContext, this.target);
        return obj == null ? nullValue : obj;
    }

    private Object getMap(Object obj) {
        Object obj2 = this.target;
        if (obj2 instanceof Map) {
            return this.quackContext.coerceJavaToJavaScript(((Map) obj2).get(obj));
        }
        return null;
    }

    public static List<Method> getMethods(Object obj, String str) {
        boolean z10 = obj instanceof Class;
        Class<?> cls = z10 ? (Class) obj : obj.getClass();
        ArrayList arrayList = new ArrayList();
        Method[] methods = cls.getMethods();
        if (z10 && cls != Class.class) {
            ArrayList arrayList2 = new ArrayList();
            Collections.addAll(arrayList2, methods);
            Collections.addAll(arrayList2, Class.class.getMethods());
            methods = (Method[]) arrayList2.toArray(new Method[0]);
        }
        for (Method method : methods) {
            if (!z10 || Modifier.isStatic(method.getModifiers())) {
                if (method.getName().equals(str)) {
                    arrayList.add(method);
                } else {
                    QuackMethodName quackMethodName = (QuackMethodName) method.getAnnotation(QuackMethodName.class);
                    if (quackMethodName != null && quackMethodName.name().equals(str)) {
                        arrayList.add(method);
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ SyntheticProperty lambda$getInternal$0(Class cls, String str) {
        Field findField;
        if (!Proxy.isProxyClass(cls) && (findField = findField(str, cls)) != null) {
            return new SyntheticProperty.FieldProperty(findField);
        }
        List<Method> methods = getMethods(this.target, str);
        if (!methods.isEmpty()) {
            return new SyntheticProperty.MethodProperty(str, (Method[]) methods.toArray(new Method[0]));
        }
        Method getterMethod = getGetterMethod(str, cls);
        if (getterMethod != null) {
            return new SyntheticProperty.GetterProperty(getterMethod);
        }
        return null;
    }

    @Override // com.koushikdutta.quack.JavaObject
    public Object get(String str) {
        Object internal = getInternal(str);
        if (internal == nullValue) {
            return null;
        }
        return internal;
    }

    @Override // com.koushikdutta.quack.JavaObject, com.koushikdutta.quack.QuackObject
    public boolean has(Object obj) {
        if (obj instanceof String) {
            return getInternal((String) obj) != null;
        }
        return super.has(obj);
    }
}
