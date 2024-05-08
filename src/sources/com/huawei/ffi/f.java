package com.huawei.ffi;

import com.huawei.ffi.api.JavaCall;
import com.huawei.hmf.annotation.ApiDefine;
import com.huawei.hmf.md.spec.ffi;
import java.lang.reflect.Constructor;

/* compiled from: JavaCallImpl.java */
@ApiDefine(alias = ffi.api.javacall, uri = JavaCall.class)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class f implements JavaCall {
    private Constructor a(Class cls, Object... objArr) {
        Constructor<?> constructor = null;
        int i10 = Integer.MAX_VALUE;
        for (Constructor<?> constructor2 : cls.getConstructors()) {
            if (objArr.length == constructor2.getParameterTypes().length) {
                int i11 = 0;
                for (int i12 = 0; i12 < objArr.length; i12++) {
                    Class<?> cls2 = objArr[i12].getClass();
                    Class<?> cls3 = constructor2.getParameterTypes()[i12];
                    if (cls3 == cls2) {
                        i11 -= 4;
                    }
                    if (a(cls3) && a(cls2)) {
                        i11 -= 3;
                    } else if (cls3.isAssignableFrom(cls2)) {
                        i11--;
                    }
                }
                if (i11 < i10) {
                    constructor = constructor2;
                    i10 = i11;
                }
            }
        }
        return constructor;
    }

    @Override // com.huawei.ffi.api.JavaCall
    public Object create(String str, Object... objArr) {
        Constructor a10;
        Class load = load(str);
        if (load == null || (a10 = a(load, objArr)) == null) {
            return null;
        }
        try {
            return a10.newInstance(objArr);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.huawei.ffi.api.JavaCall
    public Class load(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private static boolean a(Class<?> cls) {
        return cls == Byte.TYPE || cls == Byte.class || cls == Short.TYPE || cls == Short.class || cls == Integer.TYPE || cls == Integer.class || cls == Long.TYPE || cls == Long.class || cls == Float.TYPE || cls == Float.class || cls == Double.TYPE || cls == Double.class;
    }
}
