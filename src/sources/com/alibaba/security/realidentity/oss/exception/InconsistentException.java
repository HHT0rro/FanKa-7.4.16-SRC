package com.alibaba.security.realidentity.oss.exception;

import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class InconsistentException extends IOException {
    private Long clientChecksum;
    private String requestId;
    private Long serverChecksum;

    public InconsistentException(Long l10, Long l11, String str) {
        this.clientChecksum = l10;
        this.serverChecksum = l11;
        this.requestId = str;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "InconsistentException: inconsistent object\n[RequestId]: " + this.requestId + "\n[ClientChecksum]: " + ((Object) this.clientChecksum) + "\n[ServerChecksum]: " + ((Object) this.serverChecksum);
    }
}
