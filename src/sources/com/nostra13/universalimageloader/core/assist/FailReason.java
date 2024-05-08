package com.nostra13.universalimageloader.core.assist;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class FailReason {

    /* renamed from: a, reason: collision with root package name */
    public final FailType f37740a;

    /* renamed from: b, reason: collision with root package name */
    public final Throwable f37741b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum FailType {
        IO_ERROR,
        DECODING_ERROR,
        NETWORK_DENIED,
        OUT_OF_MEMORY,
        UNKNOWN
    }

    public FailReason(FailType failType, Throwable th) {
        this.f37740a = failType;
        this.f37741b = th;
    }
}
