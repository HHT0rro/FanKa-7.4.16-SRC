package io.grpc;

import com.google.common.base.j;
import com.google.common.base.o;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/2861")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class ClientStreamTracer extends StreamTracer {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class Factory {
        public ClientStreamTracer newClientStreamTracer(StreamInfo streamInfo, Metadata metadata) {
            throw new UnsupportedOperationException("Not implemented");
        }
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2861")
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class StreamInfo {
        private final CallOptions callOptions;
        private final boolean isTransparentRetry;
        private final int previousAttempts;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public static final class Builder {
            private CallOptions callOptions = CallOptions.DEFAULT;
            private boolean isTransparentRetry;
            private int previousAttempts;

            public StreamInfo build() {
                return new StreamInfo(this.callOptions, this.previousAttempts, this.isTransparentRetry);
            }

            public Builder setCallOptions(CallOptions callOptions) {
                this.callOptions = (CallOptions) o.s(callOptions, "callOptions cannot be null");
                return this;
            }

            public Builder setIsTransparentRetry(boolean z10) {
                this.isTransparentRetry = z10;
                return this;
            }

            public Builder setPreviousAttempts(int i10) {
                this.previousAttempts = i10;
                return this;
            }
        }

        public StreamInfo(CallOptions callOptions, int i10, boolean z10) {
            this.callOptions = (CallOptions) o.s(callOptions, "callOptions");
            this.previousAttempts = i10;
            this.isTransparentRetry = z10;
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public CallOptions getCallOptions() {
            return this.callOptions;
        }

        public int getPreviousAttempts() {
            return this.previousAttempts;
        }

        public boolean isTransparentRetry() {
            return this.isTransparentRetry;
        }

        public Builder toBuilder() {
            return new Builder().setCallOptions(this.callOptions).setPreviousAttempts(this.previousAttempts).setIsTransparentRetry(this.isTransparentRetry);
        }

        public String toString() {
            return j.c(this).d("callOptions", this.callOptions).b("previousAttempts", this.previousAttempts).e("isTransparentRetry", this.isTransparentRetry).toString();
        }
    }

    public void inboundHeaders() {
    }

    public void inboundTrailers(Metadata metadata) {
    }

    public void outboundHeaders() {
    }

    public void streamCreated(Attributes attributes, Metadata metadata) {
    }
}
