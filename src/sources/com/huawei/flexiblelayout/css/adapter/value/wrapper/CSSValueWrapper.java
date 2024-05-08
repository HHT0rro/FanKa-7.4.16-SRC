package com.huawei.flexiblelayout.css.adapter.value.wrapper;

import com.huawei.flexiblelayout.css.adapter.type.CSSValue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class CSSValueWrapper<T extends CSSValue> {
    private String mMethodName;
    private String mPropertyTag;
    private Class<T> mValueClass;

    public String getMethodName() {
        return this.mMethodName;
    }

    public String getPropertyTag() {
        return this.mPropertyTag;
    }

    public Class<T> getValueClass() {
        return this.mValueClass;
    }

    public abstract T invoke(T t2, Object... objArr);

    public void setMethodName(String str) {
        this.mMethodName = str;
    }

    public void setPropertyTag(String str) {
        this.mPropertyTag = str;
    }

    public void setValueClass(Class<T> cls) {
        this.mValueClass = cls;
    }
}
