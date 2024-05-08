package com.huawei.hms.feature.dynamic;

import android.os.IBinder;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import java.lang.reflect.Field;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ObjectWrapper<T> extends IObjectWrapper.Stub {

    /* renamed from: a, reason: collision with root package name */
    public final T f29852a;

    public ObjectWrapper(T t2) {
        this.f29852a = t2;
    }

    public static <T> T unwrap(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper instanceof ObjectWrapper) {
            return ((ObjectWrapper) iObjectWrapper).f29852a;
        }
        IBinder asBinder = iObjectWrapper.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        int i10 = 0;
        for (Field field : declaredFields) {
            if (!field.isSynthetic()) {
                i10++;
            }
        }
        if (i10 == 1) {
            if (declaredFields[0].isAccessible()) {
                throw new IllegalArgumentException("The field is accessible.");
            }
            declaredFields[0].setAccessible(true);
            try {
                return (T) declaredFields[0].get(asBinder);
            } catch (Exception unused) {
                throw new IllegalArgumentException("Get binder failed: null or not permitted.");
            }
        }
        throw new IllegalArgumentException("Got " + declaredFields.length + " fields, The number of field number should be 1.");
    }

    public static <T> IObjectWrapper wrap(T t2) {
        return new ObjectWrapper(t2);
    }
}
