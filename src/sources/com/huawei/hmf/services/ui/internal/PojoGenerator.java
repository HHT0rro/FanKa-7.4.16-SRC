package com.huawei.hmf.services.ui.internal;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.huawei.hmf.orb.IMessageEntity;
import com.huawei.hmf.services.ui.PojoObject;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class PojoGenerator<T> implements IMessageEntity, Cloneable {
    private final transient Class<T> mInterface;
    private Map<String, Object> mValues = new HashMap();
    private transient InvocationHandler handler = new InvocationHandler() { // from class: com.huawei.hmf.services.ui.internal.PojoGenerator.1
        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String substring;
            String name = method.getName();
            if (name.startsWith("set")) {
                PojoGenerator.this.mValues.put(name.substring(3), objArr[0]);
                return null;
            }
            if (name.startsWith(MonitorConstants.CONNECT_TYPE_GET)) {
                substring = name.substring(3);
            } else {
                if (!name.startsWith("is")) {
                    return null;
                }
                substring = name.substring(2);
            }
            Object obj2 = PojoGenerator.this.mValues.get(substring);
            return (obj2 == null && method.getReturnType().isPrimitive()) ? PojoGenerator.getReturnValue(method) : obj2;
        }
    };

    public PojoGenerator(Class<T> cls) {
        if (PojoObject.class.isAssignableFrom(cls)) {
            this.mInterface = cls;
            return;
        }
        throw new IllegalArgumentException(((Object) cls) + " must extends from PojoObject.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object getReturnValue(Method method) {
        Class<?> returnType = method.getReturnType();
        if (returnType == Integer.TYPE) {
            return 0;
        }
        if (returnType == Long.TYPE) {
            return 0L;
        }
        if (returnType == Short.TYPE) {
            return (short) 0;
        }
        if (returnType == Float.TYPE) {
            return Float.valueOf(0.0f);
        }
        if (returnType == Double.TYPE) {
            return Double.valueOf(ShadowDrawableWrapper.COS_45);
        }
        if (returnType == Boolean.TYPE) {
            return Boolean.FALSE;
        }
        if (returnType == Character.TYPE) {
            return (char) 0;
        }
        if (returnType == Byte.TYPE) {
            return (byte) 0;
        }
        if (returnType != Void.TYPE) {
            return null;
        }
        throw new TypeNotPresentException("Getter method '" + method.getName() + "' cannot return a value with void type", null);
    }

    public static String resolveName(String str) {
        if (str.startsWith("set")) {
            return str.substring(3);
        }
        if (str.startsWith(MonitorConstants.CONNECT_TYPE_GET)) {
            return str.substring(3);
        }
        return null;
    }

    public T get() {
        return (T) Proxy.newProxyInstance(this.mInterface.getClassLoader(), new Class[]{this.mInterface}, this.handler);
    }

    public Class<T> getInterface() {
        return this.mInterface;
    }

    public void setValue(String str, Object obj) {
        this.mValues.put(str, obj);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public PojoGenerator<T> m2859clone() {
        PojoGenerator<T> pojoGenerator = new PojoGenerator<>(this.mInterface);
        pojoGenerator.mValues.putAll(this.mValues);
        return pojoGenerator;
    }
}
