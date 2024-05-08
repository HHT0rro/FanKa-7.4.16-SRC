package io.grpc;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class StatusRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 1950934672280720624L;
    private final boolean fillInStackTrace;
    private final Status status;
    private final Metadata trailers;

    public StatusRuntimeException(Status status) {
        this(status, null);
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        return this.fillInStackTrace ? super.fillInStackTrace() : this;
    }

    public final Status getStatus() {
        return this.status;
    }

    public final Metadata getTrailers() {
        return this.trailers;
    }

    public StatusRuntimeException(Status status, Metadata metadata) {
        this(status, metadata, true);
    }

    public StatusRuntimeException(Status status, Metadata metadata, boolean z10) {
        super(Status.formatThrowableMessage(status), status.getCause());
        this.status = status;
        this.trailers = metadata;
        this.fillInStackTrace = z10;
        fillInStackTrace();
    }
}
