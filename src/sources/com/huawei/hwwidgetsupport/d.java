package com.huawei.hwwidgetsupport;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hwwidgetsupport.api.HwWidgetCreator;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* compiled from: ReflectWidgetCreator.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class d<T> implements HwWidgetCreator<T> {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final Class<T> f32005a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final Constructor<T> f32006b = a(Context.class);

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private final Constructor<T> f32007c = a(Context.class, AttributeSet.class);

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private final Constructor<T> f32008d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private final Constructor<T> f32009e;

    public d(@NonNull Class<T> cls) {
        this.f32005a = cls;
        Class<Integer> cls2 = Integer.TYPE;
        this.f32008d = a(Context.class, AttributeSet.class, cls2);
        this.f32009e = a(Context.class, AttributeSet.class, cls2, cls2);
    }

    @Nullable
    private Constructor<T> a(Class<?>... clsArr) {
        try {
            return this.f32005a.getDeclaredConstructor(clsArr);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // com.huawei.hwwidgetsupport.api.HwWidgetCreator
    @NonNull
    public T createWidget(@NonNull Context context) {
        return a(this.f32006b, context);
    }

    @NonNull
    private T a(Constructor<T> constructor, Object... objArr) {
        if (constructor != null) {
            try {
                return constructor.newInstance(objArr);
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
                throw new IllegalArgumentException("create widget failed with class " + ((Object) this.f32005a) + ", error message: " + e2.getMessage());
            }
        }
        throw new IllegalArgumentException("create widget failed with class " + ((Object) this.f32005a) + ", constructor with " + objArr.length + " params not found");
    }

    @Override // com.huawei.hwwidgetsupport.api.HwWidgetCreator
    @NonNull
    public T createWidget(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        return a(this.f32007c, context, attributeSet);
    }

    @Override // com.huawei.hwwidgetsupport.api.HwWidgetCreator
    @NonNull
    public T createWidget(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        return a(this.f32008d, context, attributeSet, Integer.valueOf(i10));
    }

    @Override // com.huawei.hwwidgetsupport.api.HwWidgetCreator
    @NonNull
    public T createWidget(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        return a(this.f32009e, context, attributeSet, Integer.valueOf(i10), Integer.valueOf(i11));
    }
}
