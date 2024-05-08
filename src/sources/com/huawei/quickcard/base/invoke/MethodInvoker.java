package com.huawei.quickcard.base.invoke;

import androidx.annotation.NonNull;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class MethodInvoker implements IInvoker {

    /* renamed from: a, reason: collision with root package name */
    private final Method f33370a;

    public MethodInvoker(@NonNull Method method) {
        this.f33370a = method;
    }

    @Override // com.huawei.quickcard.base.invoke.IInvoker
    @NonNull
    public Type[] getParameterTypes() {
        return this.f33370a.getGenericParameterTypes();
    }

    @Override // com.huawei.quickcard.base.invoke.IInvoker
    public Object invoke(@NonNull Object obj, Object... objArr) throws Exception {
        return this.f33370a.invoke(obj, objArr);
    }
}
