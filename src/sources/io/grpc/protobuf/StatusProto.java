package io.grpc.protobuf;

import com.google.common.base.o;
import com.google.rpc.Status;
import io.grpc.ExperimentalApi;
import io.grpc.Metadata;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import io.grpc.protobuf.lite.ProtoLiteUtils;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/4695")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class StatusProto {
    private static final Metadata.Key<Status> STATUS_DETAILS_KEY = Metadata.Key.of("grpc-status-details-bin", ProtoLiteUtils.metadataMarshaller(Status.getDefaultInstance()));

    private StatusProto() {
    }

    public static Status fromStatusAndTrailers(io.grpc.Status status, Metadata metadata) {
        Status status2;
        o.s(status, "status");
        if (metadata != null && (status2 = (Status) metadata.get(STATUS_DETAILS_KEY)) != null) {
            o.e(status.getCode().value() == status2.getCode(), "com.google.rpc.Status code must match gRPC status code");
            return status2;
        }
        Status.Builder code = Status.newBuilder().setCode(status.getCode().value());
        if (status.getDescription() != null) {
            code.setMessage(status.getDescription());
        }
        return code.build();
    }

    public static Status fromThrowable(Throwable th) {
        for (Throwable th2 = (Throwable) o.s(th, "t"); th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof StatusException) {
                StatusException statusException = (StatusException) th2;
                return fromStatusAndTrailers(statusException.getStatus(), statusException.getTrailers());
            }
            if (th2 instanceof StatusRuntimeException) {
                StatusRuntimeException statusRuntimeException = (StatusRuntimeException) th2;
                return fromStatusAndTrailers(statusRuntimeException.getStatus(), statusRuntimeException.getTrailers());
            }
        }
        return null;
    }

    private static Metadata toMetadata(Status status) {
        Metadata metadata = new Metadata();
        metadata.put(STATUS_DETAILS_KEY, status);
        return metadata;
    }

    private static io.grpc.Status toStatus(Status status) {
        io.grpc.Status fromCodeValue = io.grpc.Status.fromCodeValue(status.getCode());
        o.e(fromCodeValue.getCode().value() == status.getCode(), "invalid status code");
        return fromCodeValue.withDescription(status.getMessage());
    }

    public static StatusException toStatusException(Status status) {
        return toStatus(status).asException(toMetadata(status));
    }

    public static StatusRuntimeException toStatusRuntimeException(Status status) {
        return toStatus(status).asRuntimeException(toMetadata(status));
    }

    public static StatusException toStatusException(Status status, Metadata metadata) {
        return toStatus(status).asException(toMetadata(status, metadata));
    }

    public static StatusRuntimeException toStatusRuntimeException(Status status, Metadata metadata) {
        return toStatus(status).asRuntimeException(toMetadata(status, metadata));
    }

    private static Metadata toMetadata(Status status, Metadata metadata) {
        o.s(metadata, "metadata must not be null");
        Metadata.Key<Status> key = STATUS_DETAILS_KEY;
        metadata.discardAll(key);
        metadata.put(key, status);
        return metadata;
    }
}
