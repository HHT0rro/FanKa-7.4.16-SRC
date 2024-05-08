package com.huawei.hmf.services.interception;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class Signature {
    public static final String ConstructorMethod = "__constructor__";
    private String mAlias;
    private Class mDeclaringType;
    private String mDeclaringTypeName;
    private String mName;

    public Signature(Class cls) {
        this.mDeclaringType = cls;
    }

    public String getAlias() {
        return this.mAlias;
    }

    public Class getDeclaringType() {
        return this.mDeclaringType;
    }

    public String getDeclaringTypeName() {
        Class cls;
        String str = this.mDeclaringTypeName;
        return (str != null || (cls = this.mDeclaringType) == null) ? str : cls.getName();
    }

    public String getName() {
        return this.mName;
    }

    public void setAlias(String str) {
        this.mAlias = str;
    }

    public void setDeclaringTypeName(String str) {
        this.mDeclaringTypeName = str;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String toString() {
        return "Signature{DeclaringTypeName='" + getDeclaringTypeName() + "', Alias='" + this.mAlias + "', Name='" + this.mName + "'}";
    }
}
