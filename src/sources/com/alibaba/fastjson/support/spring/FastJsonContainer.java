package com.alibaba.fastjson.support.spring;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class FastJsonContainer {
    private PropertyPreFilters filters;
    private Object value;

    public FastJsonContainer(Object obj) {
        this.value = obj;
    }

    public PropertyPreFilters getFilters() {
        return this.filters;
    }

    public Object getValue() {
        return this.value;
    }

    public void setFilters(PropertyPreFilters propertyPreFilters) {
        this.filters = propertyPreFilters;
    }

    public void setValue(Object obj) {
        this.value = obj;
    }
}
