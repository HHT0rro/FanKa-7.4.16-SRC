package com.huawei.hms.ads.uiengineloader;

import android.os.IBinder;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import java.lang.reflect.Field;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class ac<T> extends IObjectWrapper.Stub {

    /* renamed from: a, reason: collision with root package name */
    private final T f29425a;

    private ac(T t2) {
        this.f29425a = t2;
    }

    public static <T> IObjectWrapper a(T t2) {
        return new ac(t2);
    }

    public static <T> T a(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper instanceof ac) {
            return ((ac) iObjectWrapper).f29425a;
        }
        IBinder asBinder = iObjectWrapper.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        int i10 = 0;
        for (Field field : declaredFields) {
            if (!field.isSynthetic()) {
                i10++;
            }
        }
        if (i10 != 1) {
            throw new IllegalArgumentException("Unexpected number of IObjectWrapper declared fields: " + declaredFields.length);
        }
        if (declaredFields[0].isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
        declaredFields[0].setAccessible(true);
        try {
            return (T) declaredFields[0].get(asBinder);
        } catch (IllegalAccessException unused) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.");
        } catch (NullPointerException unused2) {
            throw new IllegalArgumentException("Binder object is null.");
        }
    }
}
