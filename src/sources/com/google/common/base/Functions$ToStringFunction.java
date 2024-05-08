package com.google.common.base;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
enum Functions$ToStringFunction implements g<Object, String> {
    INSTANCE;

    @Override // java.lang.Enum
    public String toString() {
        return "Functions.toStringFunction()";
    }

    @Override // com.google.common.base.g
    public String apply(Object obj) {
        o.r(obj);
        return obj.toString();
    }
}
