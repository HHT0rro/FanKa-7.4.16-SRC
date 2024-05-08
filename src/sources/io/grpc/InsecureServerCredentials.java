package io.grpc;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class InsecureServerCredentials extends ServerCredentials {
    private InsecureServerCredentials() {
    }

    public static ServerCredentials create() {
        return new InsecureServerCredentials();
    }
}
