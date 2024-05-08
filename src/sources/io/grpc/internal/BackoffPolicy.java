package io.grpc.internal;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface BackoffPolicy {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface Provider {
        BackoffPolicy get();
    }

    long nextBackoffNanos();
}
