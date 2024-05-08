package com.huawei.hmf.orb.aidl;

import com.huawei.hmf.annotation.NamedMethod;
import com.huawei.hmf.orb.RemoteInvoker;
import com.huawei.hmf.orb.RemoteProxy;
import com.huawei.hmf.orb.exception.InvocationException;
import com.huawei.hmf.services.codec.TypeToken;
import com.huawei.hmf.services.interception.Signature;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class NamingRemoteProxy extends RemoteProxy implements InvocationHandler {
    private static final String TAG = "NamingRemoteProxy";
    private Object mObject;
    private String mUri;

    private NamingRemoteProxy(RemoteInvoker remoteInvoker, String str, Object... objArr) {
        super(remoteInvoker);
        this.mUri = str;
        setSequence(((Long) send(str, Signature.ConstructorMethod, new TypeToken<Long>() { // from class: com.huawei.hmf.orb.aidl.NamingRemoteProxy.1
        }, objArr)).longValue());
    }

    public static <T> T create(RemoteInvoker remoteInvoker, T t2, Long l10) {
        return (T) Proxy.newProxyInstance(t2.getClass().getClassLoader(), t2.getClass().getInterfaces(), new NamingRemoteProxy(remoteInvoker, l10, t2));
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        Object obj2 = this.mObject;
        Object invoke = obj2 != null ? method.invoke(obj2, objArr) : null;
        NamedMethod namedMethod = (NamedMethod) method.getAnnotation(NamedMethod.class);
        if (namedMethod != null) {
            return send(this.mUri, namedMethod.value(), new TypeToken(method.getGenericReturnType()), objArr);
        }
        if (this.mObject != null) {
            return invoke;
        }
        StringBuilder sb2 = new StringBuilder();
        for (Class<?> cls : obj.getClass().getInterfaces()) {
            sb2.append(cls.getName());
            sb2.append(",");
        }
        if (!method.getReturnType().isPrimitive()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2.toString());
            sb3.append(" can not found NamedMethod `");
            sb3.append(method.getName());
            sb3.append("`");
            return invoke;
        }
        throw new InvocationException(sb2.toString() + " can not found NamedMethod `" + method.getName() + "`");
    }

    private NamingRemoteProxy(RemoteInvoker remoteInvoker, Long l10, Object obj) {
        super(remoteInvoker);
        this.mUri = null;
        setSequence(l10.longValue());
        this.mObject = obj;
    }

    public static <T> T create(RemoteInvoker remoteInvoker, Class<?>[] clsArr, Long l10) {
        return (T) Proxy.newProxyInstance(NamingRemoteProxy.class.getClassLoader(), clsArr, new NamingRemoteProxy(remoteInvoker, l10, (Object) null));
    }

    public static <T> T create(RemoteInvoker remoteInvoker, Class<?>[] clsArr, String str, Object... objArr) {
        return (T) Proxy.newProxyInstance(NamingRemoteProxy.class.getClassLoader(), clsArr, new NamingRemoteProxy(remoteInvoker, str, objArr));
    }
}
