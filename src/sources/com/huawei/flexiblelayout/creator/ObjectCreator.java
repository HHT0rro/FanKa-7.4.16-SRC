package com.huawei.flexiblelayout.creator;

import com.huawei.flexiblelayout.log.Log;
import java.lang.reflect.InvocationTargetException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ObjectCreator {

    /* renamed from: a, reason: collision with root package name */
    private static final String f27942a = "ObjectCreator";

    public static <T> T create(Class<? extends T> cls) {
        try {
            return cls.newInstance();
        } catch (IllegalAccessException | InstantiationException e2) {
            Log.e(f27942a, "create instance failed with class " + ((Object) cls) + ", error message: " + e2.getMessage());
            return null;
        }
    }

    public static <T> T create(Class<? extends T> cls, Object obj) {
        try {
            return cls.getDeclaredConstructor(obj.getClass()).newInstance(obj);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            throw new IllegalArgumentException("create instance failed with class " + ((Object) cls) + ", error message: " + e2.getMessage());
        }
    }

    public static <T> T create(Class<? extends T> cls, Class<?>[] clsArr, Object... objArr) {
        try {
            return cls.getDeclaredConstructor(clsArr).newInstance(objArr);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            throw new IllegalArgumentException("create instance failed with class " + ((Object) cls) + ", error message: " + e2.getMessage());
        }
    }
}
