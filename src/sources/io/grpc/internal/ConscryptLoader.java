package io.grpc.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.Provider;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ConscryptLoader {
    private static final Method IS_CONSCRYPT_METHOD;
    private static final Method NEW_PROVIDER_METHOD;

    static {
        Method method;
        Method method2 = null;
        try {
            Class<?> cls = Class.forName("org.conscrypt.Conscrypt");
            Method method3 = cls.getMethod("newProvider", new Class[0]);
            method = cls.getMethod("isConscrypt", Provider.class);
            method2 = method3;
        } catch (ClassNotFoundException unused) {
            method = null;
        } catch (NoSuchMethodException e2) {
            throw new AssertionError(e2);
        }
        NEW_PROVIDER_METHOD = method2;
        IS_CONSCRYPT_METHOD = method;
    }

    public static boolean isConscrypt(Provider provider) {
        if (!isPresent()) {
            return false;
        }
        try {
            return ((Boolean) IS_CONSCRYPT_METHOD.invoke(null, provider)).booleanValue();
        } catch (IllegalAccessException e2) {
            throw new AssertionError(e2);
        } catch (InvocationTargetException e10) {
            throw new AssertionError(e10);
        }
    }

    public static boolean isPresent() {
        return NEW_PROVIDER_METHOD != null;
    }

    public static Provider newProvider() throws Throwable {
        if (isPresent()) {
            return (Provider) NEW_PROVIDER_METHOD.invoke(null, new Object[0]);
        }
        Class.forName("org.conscrypt.Conscrypt");
        throw new AssertionError((Object) "Unexpected failure referencing Conscrypt class");
    }
}
