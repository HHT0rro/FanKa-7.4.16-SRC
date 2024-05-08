package com.huawei.flexiblelayout.css.adapter.param;

import com.huawei.flexiblelayout.css.adapter.param.Parameter;
import com.huawei.flexiblelayout.css.adapter.type.CSSValue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class AsyncParameterGenerator<T extends CSSValue> implements Parameter.AsyncGenerator<T> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huawei.flexiblelayout.css.adapter.param.Parameter.AsyncGenerator
    public final void call(Object obj, GeneratorCallBack generatorCallBack) {
        Object[] objArr = (Object[]) obj;
        get(objArr[0], (CSSValue) objArr[1], generatorCallBack);
    }

    @Override // com.huawei.flexiblelayout.css.adapter.param.Parameter.Generator
    public final Object get(Object obj, T t2) {
        return new Object[]{obj, t2};
    }

    public abstract void get(Object obj, T t2, GeneratorCallBack generatorCallBack);
}
