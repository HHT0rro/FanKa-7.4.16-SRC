package com.huawei.flexiblelayout.css.adapter.param;

import com.huawei.flexiblelayout.css.adapter.type.CSSValue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface Parameter {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface AsyncGenerator<T extends CSSValue> extends Generator<T> {
        void call(Object obj, GeneratorCallBack generatorCallBack);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface Generator<T extends CSSValue> {
        Object get(Object obj, T t2);
    }
}
