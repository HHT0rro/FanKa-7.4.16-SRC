package com.huawei.quickcard;

import com.huawei.quickcard.base.Attributes;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public enum s0 {
    NONE("none"),
    HIDDEN(Attributes.Visibility.HIDDEN),
    DOTTED("dotted"),
    DASHED("dashed"),
    SOLID("solid"),
    DOUBLE("double"),
    GROOVE("groove"),
    RIDGE("ridge"),
    INSET("inset"),
    OUTSET("outset");


    /* renamed from: a, reason: collision with root package name */
    private final String f34231a;

    s0(String str) {
        this.f34231a = str;
    }

    public String a() {
        return this.f34231a;
    }
}
