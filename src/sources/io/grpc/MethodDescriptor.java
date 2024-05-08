package io.grpc;

import com.google.common.base.j;
import com.google.common.base.o;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class MethodDescriptor<ReqT, RespT> {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private final String fullMethodName;
    private final boolean idempotent;
    private final AtomicReferenceArray<Object> rawMethodNames;
    private final Marshaller<ReqT> requestMarshaller;
    private final Marshaller<RespT> responseMarshaller;
    private final boolean safe;
    private final boolean sampledToLocalTracing;
    private final Object schemaDescriptor;
    private final String serviceName;
    private final MethodType type;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Builder<ReqT, RespT> {
        private String fullMethodName;
        private boolean idempotent;
        private Marshaller<ReqT> requestMarshaller;
        private Marshaller<RespT> responseMarshaller;
        private boolean safe;
        private boolean sampledToLocalTracing;
        private Object schemaDescriptor;
        private MethodType type;

        public MethodDescriptor<ReqT, RespT> build() {
            return new MethodDescriptor<>(this.type, this.fullMethodName, this.requestMarshaller, this.responseMarshaller, this.schemaDescriptor, this.idempotent, this.safe, this.sampledToLocalTracing);
        }

        public Builder<ReqT, RespT> setFullMethodName(String str) {
            this.fullMethodName = str;
            return this;
        }

        public Builder<ReqT, RespT> setIdempotent(boolean z10) {
            this.idempotent = z10;
            if (!z10) {
                this.safe = false;
            }
            return this;
        }

        public Builder<ReqT, RespT> setRequestMarshaller(Marshaller<ReqT> marshaller) {
            this.requestMarshaller = marshaller;
            return this;
        }

        public Builder<ReqT, RespT> setResponseMarshaller(Marshaller<RespT> marshaller) {
            this.responseMarshaller = marshaller;
            return this;
        }

        public Builder<ReqT, RespT> setSafe(boolean z10) {
            this.safe = z10;
            if (z10) {
                this.idempotent = true;
            }
            return this;
        }

        public Builder<ReqT, RespT> setSampledToLocalTracing(boolean z10) {
            this.sampledToLocalTracing = z10;
            return this;
        }

        public Builder<ReqT, RespT> setSchemaDescriptor(Object obj) {
            this.schemaDescriptor = obj;
            return this;
        }

        public Builder<ReqT, RespT> setType(MethodType methodType) {
            this.type = methodType;
            return this;
        }

        private Builder() {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface Marshaller<T> {
        T parse(InputStream inputStream);

        InputStream stream(T t2);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum MethodType {
        UNARY,
        CLIENT_STREAMING,
        SERVER_STREAMING,
        BIDI_STREAMING,
        UNKNOWN;

        public final boolean clientSendsOneMessage() {
            return this == UNARY || this == SERVER_STREAMING;
        }

        public final boolean serverSendsOneMessage() {
            return this == UNARY || this == CLIENT_STREAMING;
        }
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2222")
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface PrototypeMarshaller<T> extends ReflectableMarshaller<T> {
        T getMessagePrototype();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2222")
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface ReflectableMarshaller<T> extends Marshaller<T> {
        Class<T> getMessageClass();
    }

    @Deprecated
    public static <RequestT, ResponseT> MethodDescriptor<RequestT, ResponseT> create(MethodType methodType, String str, Marshaller<RequestT> marshaller, Marshaller<ResponseT> marshaller2) {
        return new MethodDescriptor<>(methodType, str, marshaller, marshaller2, null, false, false, false);
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/5635")
    public static String extractBareMethodName(String str) {
        int lastIndexOf = ((String) o.s(str, "fullMethodName")).lastIndexOf(47);
        if (lastIndexOf == -1) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }

    public static String extractFullServiceName(String str) {
        int lastIndexOf = ((String) o.s(str, "fullMethodName")).lastIndexOf(47);
        if (lastIndexOf == -1) {
            return null;
        }
        return str.substring(0, lastIndexOf);
    }

    public static String generateFullMethodName(String str, String str2) {
        return ((String) o.s(str, "fullServiceName")) + "/" + ((String) o.s(str2, "methodName"));
    }

    public static <ReqT, RespT> Builder<ReqT, RespT> newBuilder() {
        return newBuilder(null, null);
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/5635")
    public String getBareMethodName() {
        return extractBareMethodName(this.fullMethodName);
    }

    public String getFullMethodName() {
        return this.fullMethodName;
    }

    public final Object getRawMethodName(int i10) {
        return this.rawMethodNames.get(i10);
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2592")
    public Marshaller<ReqT> getRequestMarshaller() {
        return this.requestMarshaller;
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2592")
    public Marshaller<RespT> getResponseMarshaller() {
        return this.responseMarshaller;
    }

    public Object getSchemaDescriptor() {
        return this.schemaDescriptor;
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/5635")
    public String getServiceName() {
        return this.serviceName;
    }

    public MethodType getType() {
        return this.type;
    }

    public boolean isIdempotent() {
        return this.idempotent;
    }

    public boolean isSafe() {
        return this.safe;
    }

    public boolean isSampledToLocalTracing() {
        return this.sampledToLocalTracing;
    }

    public ReqT parseRequest(InputStream inputStream) {
        return this.requestMarshaller.parse(inputStream);
    }

    public RespT parseResponse(InputStream inputStream) {
        return this.responseMarshaller.parse(inputStream);
    }

    public final void setRawMethodName(int i10, Object obj) {
        this.rawMethodNames.lazySet(i10, obj);
    }

    public InputStream streamRequest(ReqT reqt) {
        return this.requestMarshaller.stream(reqt);
    }

    public InputStream streamResponse(RespT respt) {
        return this.responseMarshaller.stream(respt);
    }

    public Builder<ReqT, RespT> toBuilder() {
        return (Builder<ReqT, RespT>) toBuilder(this.requestMarshaller, this.responseMarshaller);
    }

    public String toString() {
        return j.c(this).d("fullMethodName", this.fullMethodName).d("type", this.type).e("idempotent", this.idempotent).e("safe", this.safe).e("sampledToLocalTracing", this.sampledToLocalTracing).d("requestMarshaller", this.requestMarshaller).d("responseMarshaller", this.responseMarshaller).d("schemaDescriptor", this.schemaDescriptor).m().toString();
    }

    private MethodDescriptor(MethodType methodType, String str, Marshaller<ReqT> marshaller, Marshaller<RespT> marshaller2, Object obj, boolean z10, boolean z11, boolean z12) {
        this.rawMethodNames = new AtomicReferenceArray<>(2);
        this.type = (MethodType) o.s(methodType, "type");
        this.fullMethodName = (String) o.s(str, "fullMethodName");
        this.serviceName = extractFullServiceName(str);
        this.requestMarshaller = (Marshaller) o.s(marshaller, "requestMarshaller");
        this.responseMarshaller = (Marshaller) o.s(marshaller2, "responseMarshaller");
        this.schemaDescriptor = obj;
        this.idempotent = z10;
        this.safe = z11;
        this.sampledToLocalTracing = z12;
    }

    public static <ReqT, RespT> Builder<ReqT, RespT> newBuilder(Marshaller<ReqT> marshaller, Marshaller<RespT> marshaller2) {
        return new Builder().setRequestMarshaller(marshaller).setResponseMarshaller(marshaller2);
    }

    public <NewReqT, NewRespT> Builder<NewReqT, NewRespT> toBuilder(Marshaller<NewReqT> marshaller, Marshaller<NewRespT> marshaller2) {
        return newBuilder().setRequestMarshaller(marshaller).setResponseMarshaller(marshaller2).setType(this.type).setFullMethodName(this.fullMethodName).setIdempotent(this.idempotent).setSafe(this.safe).setSampledToLocalTracing(this.sampledToLocalTracing).setSchemaDescriptor(this.schemaDescriptor);
    }
}
