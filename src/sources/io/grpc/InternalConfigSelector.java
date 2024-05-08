package io.grpc;

import com.google.common.base.o;
import com.huawei.flexiblelayout.card.FLPNode;
import io.grpc.Attributes;
import io.grpc.LoadBalancer;

@Internal
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class InternalConfigSelector {
    public static final Attributes.Key<InternalConfigSelector> KEY = Attributes.Key.create("internal:io.grpc.config-selector");

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Result {
        private final Object config;
        public ClientInterceptor interceptor;
        private final Status status;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public static final class Builder {
            private Object config;
            private ClientInterceptor interceptor;

            public Result build() {
                o.y(this.config != null, "config is not set");
                return new Result(Status.OK, this.config, this.interceptor);
            }

            public Builder setConfig(Object obj) {
                this.config = o.s(obj, FLPNode.KEY_CONFIG);
                return this;
            }

            public Builder setInterceptor(ClientInterceptor clientInterceptor) {
                this.interceptor = (ClientInterceptor) o.s(clientInterceptor, "interceptor");
                return this;
            }

            private Builder() {
            }
        }

        public static Result forError(Status status) {
            o.e(!status.isOk(), "status is OK");
            return new Result(status, null, null);
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Object getConfig() {
            return this.config;
        }

        public ClientInterceptor getInterceptor() {
            return this.interceptor;
        }

        public Status getStatus() {
            return this.status;
        }

        private Result(Status status, Object obj, ClientInterceptor clientInterceptor) {
            this.status = (Status) o.s(status, "status");
            this.config = obj;
            this.interceptor = clientInterceptor;
        }
    }

    public abstract Result selectConfig(LoadBalancer.PickSubchannelArgs pickSubchannelArgs);
}
