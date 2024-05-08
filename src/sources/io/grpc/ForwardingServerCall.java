package io.grpc;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class ForwardingServerCall<ReqT, RespT> extends PartialForwardingServerCall<ReqT, RespT> {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class SimpleForwardingServerCall<ReqT, RespT> extends ForwardingServerCall<ReqT, RespT> {
        private final ServerCall<ReqT, RespT> delegate;

        public SimpleForwardingServerCall(ServerCall<ReqT, RespT> serverCall) {
            this.delegate = serverCall;
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public /* bridge */ /* synthetic */ void close(Status status, Metadata metadata) {
            super.close(status, metadata);
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall
        public ServerCall<ReqT, RespT> delegate() {
            return this.delegate;
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1779")
        public /* bridge */ /* synthetic */ Attributes getAttributes() {
            return super.getAttributes();
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public /* bridge */ /* synthetic */ String getAuthority() {
            return super.getAuthority();
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        @ExperimentalApi("https://github.com/grpc/grpc-java/issues/4692")
        public /* bridge */ /* synthetic */ SecurityLevel getSecurityLevel() {
            return super.getSecurityLevel();
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public /* bridge */ /* synthetic */ boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public /* bridge */ /* synthetic */ boolean isReady() {
            return super.isReady();
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public /* bridge */ /* synthetic */ void request(int i10) {
            super.request(i10);
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public /* bridge */ /* synthetic */ void sendHeaders(Metadata metadata) {
            super.sendHeaders(metadata);
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
        public /* bridge */ /* synthetic */ void setCompression(String str) {
            super.setCompression(str);
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1703")
        public /* bridge */ /* synthetic */ void setMessageCompression(boolean z10) {
            super.setMessageCompression(z10);
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }
    }

    @Override // io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
    public /* bridge */ /* synthetic */ void close(Status status, Metadata metadata) {
        super.close(status, metadata);
    }

    @Override // io.grpc.PartialForwardingServerCall
    public abstract ServerCall<ReqT, RespT> delegate();

    @Override // io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1779")
    public /* bridge */ /* synthetic */ Attributes getAttributes() {
        return super.getAttributes();
    }

    @Override // io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
    public /* bridge */ /* synthetic */ String getAuthority() {
        return super.getAuthority();
    }

    @Override // io.grpc.ServerCall
    public MethodDescriptor<ReqT, RespT> getMethodDescriptor() {
        return delegate().getMethodDescriptor();
    }

    @Override // io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/4692")
    public /* bridge */ /* synthetic */ SecurityLevel getSecurityLevel() {
        return super.getSecurityLevel();
    }

    @Override // io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
    public /* bridge */ /* synthetic */ boolean isCancelled() {
        return super.isCancelled();
    }

    @Override // io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
    public /* bridge */ /* synthetic */ boolean isReady() {
        return super.isReady();
    }

    @Override // io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
    public /* bridge */ /* synthetic */ void request(int i10) {
        super.request(i10);
    }

    @Override // io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
    public /* bridge */ /* synthetic */ void sendHeaders(Metadata metadata) {
        super.sendHeaders(metadata);
    }

    @Override // io.grpc.ServerCall
    public void sendMessage(RespT respt) {
        delegate().sendMessage(respt);
    }

    @Override // io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
    public /* bridge */ /* synthetic */ void setCompression(String str) {
        super.setCompression(str);
    }

    @Override // io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1703")
    public /* bridge */ /* synthetic */ void setMessageCompression(boolean z10) {
        super.setMessageCompression(z10);
    }

    @Override // io.grpc.PartialForwardingServerCall
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
