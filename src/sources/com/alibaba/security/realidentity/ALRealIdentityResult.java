package com.alibaba.security.realidentity;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public enum ALRealIdentityResult {
    AUDIT_EXCEPTION(-2),
    AUDIT_NOT(-1),
    AUDIT_IN_AUDIT(0),
    AUDIT_PASS(1),
    AUDIT_FAIL(2);

    public int audit;

    ALRealIdentityResult(int i10) {
        this.audit = i10;
    }
}
