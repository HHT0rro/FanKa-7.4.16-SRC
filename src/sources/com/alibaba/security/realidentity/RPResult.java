package com.alibaba.security.realidentity;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public enum RPResult {
    AUDIT_EXCEPTION(-2, "客户端异常"),
    AUDIT_NOT(-1, "未完成认证"),
    AUDIT_IN_AUDIT(0, "认证审核中"),
    AUDIT_PASS(1, "认证通过"),
    AUDIT_FAIL(2, "认证不通过");

    public int code;
    public String message;

    RPResult(int i10, String str) {
        this.code = i10;
        this.message = str;
    }
}
