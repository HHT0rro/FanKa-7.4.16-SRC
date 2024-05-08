package com.huawei.hmf.services.internal;

import com.huawei.hmf.services.ApiSpec;
import java.lang.reflect.Constructor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ApiFactory {
    private static final String TAG = "ApiFactory";
    private static ObjectCache objectCache = new ObjectCache();

    public static <T> T create(ApiSpec apiSpec) {
        return (T) create(objectCache, apiSpec);
    }

    private static Constructor matchConstructor(Class cls, Object... objArr) {
        boolean z10 = false;
        for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == objArr.length) {
                for (int i10 = 0; i10 < objArr.length; i10++) {
                    z10 = parameterTypes[i10].isAssignableFrom(objArr[i10].getClass());
                }
                if (z10) {
                    return constructor;
                }
            }
        }
        throw new IllegalStateException("Do not match constructor with argument number: " + objArr.length);
    }

    public static <T> T create(ApiSpec apiSpec, Object... objArr) {
        return (T) create(objectCache, apiSpec, objArr);
    }

    public static <T> T create(ObjectCache objectCache2, ApiSpec apiSpec) {
        T t2;
        if (apiSpec == null) {
            return null;
        }
        try {
            if (apiSpec.isSingleton()) {
                synchronized (ApiFactory.class) {
                    t2 = (T) objectCache2.get(apiSpec.getType());
                    if (t2 == null) {
                        t2 = (T) apiSpec.getType().newInstance();
                        objectCache2.put(apiSpec.getType(), t2);
                    }
                }
                return t2;
            }
            return (T) apiSpec.getType().newInstance();
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("create failed:");
            sb2.append(e2.getMessage());
            return null;
        }
    }

    public static <T> T create(ObjectCache objectCache2, ApiSpec apiSpec, Object... objArr) {
        T t2;
        if (objArr.length == 0) {
            return (T) create(objectCache2, apiSpec);
        }
        if (apiSpec == null) {
            return null;
        }
        try {
            if (apiSpec.isSingleton()) {
                synchronized (ApiFactory.class) {
                    t2 = (T) objectCache2.get(apiSpec.getType());
                    if (t2 == null) {
                        t2 = (T) matchConstructor(apiSpec.getType(), objArr).newInstance(objArr);
                        objectCache2.put(apiSpec.getType(), t2);
                    }
                }
                return t2;
            }
            return (T) matchConstructor(apiSpec.getType(), objArr).newInstance(objArr);
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("create failed with arguments:");
            sb2.append(e2.getMessage());
            return null;
        }
    }
}
