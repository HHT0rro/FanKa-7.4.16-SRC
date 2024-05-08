package com.huawei.hmf.services;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ApiSpec {
    private boolean isSingleton;
    private Class<?> type;
    private String typeName;

    public ApiSpec(Class<?> cls) {
        this.type = cls;
    }

    public Class<?> getType() {
        return this.type;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public boolean isSingleton() {
        return this.isSingleton;
    }

    public void setSingleton(boolean z10) {
        this.isSingleton = z10;
    }

    public void setTypeName(String str) {
        this.typeName = str;
    }
}
