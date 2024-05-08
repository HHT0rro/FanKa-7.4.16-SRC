package com.alibaba.wireless.security.open.litevm;

import com.alibaba.wireless.security.open.litevm.LiteVMParamType;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class LiteVMParameterWrapper {

    /* renamed from: а, reason: contains not printable characters */
    private LiteVMParamType.PARAM_TYPE f197;

    /* renamed from: б, reason: contains not printable characters */
    private Object f198;

    public LiteVMParameterWrapper(LiteVMParamType.PARAM_TYPE param_type, Object obj) {
        this.f197 = param_type;
        this.f198 = obj;
    }

    public int getType() {
        return this.f197.getValue();
    }

    public Object getValue() {
        return this.f198;
    }
}
