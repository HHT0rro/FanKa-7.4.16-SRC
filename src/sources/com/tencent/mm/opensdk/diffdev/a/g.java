package com.tencent.mm.opensdk.diffdev.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public enum g {
    UUID_EXPIRED(402),
    UUID_CANCELED(403),
    UUID_SCANED(404),
    UUID_CONFIRM(405),
    UUID_KEEP_CONNECT(408),
    UUID_ERROR(500);

    private int code;

    g(int i10) {
        this.code = i10;
    }

    public final int getCode() {
        return this.code;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "UUIDStatusCode:" + this.code;
    }
}
