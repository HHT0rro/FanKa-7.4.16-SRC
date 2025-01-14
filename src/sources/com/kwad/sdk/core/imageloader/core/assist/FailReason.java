package com.kwad.sdk.core.imageloader.core.assist;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class FailReason {
    private final Throwable cause;
    private final FailType type;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum FailType {
        IO_ERROR,
        DECODING_ERROR,
        NETWORK_DENIED,
        OUT_OF_MEMORY,
        UNKNOWN
    }

    public FailReason(FailType failType, Throwable th) {
        this.type = failType;
        this.cause = th;
    }

    public Throwable getCause() {
        return this.cause;
    }

    public FailType getType() {
        return this.type;
    }

    public String toString() {
        return "FailReason{type=" + ((Object) this.type) + ", cause=" + ((Object) this.cause) + '}';
    }
}
