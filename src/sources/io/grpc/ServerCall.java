package io.grpc;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class ServerCall<ReqT, RespT> {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class Listener<ReqT> {
        public void onCancel() {
        }

        public void onComplete() {
        }

        public void onHalfClose() {
        }

        public void onMessage(ReqT reqt) {
        }

        public void onReady() {
        }
    }

    public abstract void close(Status status, Metadata metadata);

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1779")
    public Attributes getAttributes() {
        return Attributes.EMPTY;
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2924")
    public String getAuthority() {
        return null;
    }

    public abstract MethodDescriptor<ReqT, RespT> getMethodDescriptor();

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/4692")
    public SecurityLevel getSecurityLevel() {
        return SecurityLevel.NONE;
    }

    public abstract boolean isCancelled();

    public boolean isReady() {
        return true;
    }

    public abstract void request(int i10);

    public abstract void sendHeaders(Metadata metadata);

    public abstract void sendMessage(RespT respt);

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
    public void setCompression(String str) {
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
    public void setMessageCompression(boolean z10) {
    }
}
