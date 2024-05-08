package io.grpc;

import com.google.common.base.o;
import io.grpc.ManagedChannelProvider;

@Internal
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class ServerProvider {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class NewServerBuilderResult {
        private final String error;
        private final ServerBuilder<?> serverBuilder;

        private NewServerBuilderResult(ServerBuilder<?> serverBuilder, String str) {
            this.serverBuilder = serverBuilder;
            this.error = str;
        }

        public static NewServerBuilderResult error(String str) {
            return new NewServerBuilderResult(null, (String) o.r(str));
        }

        public static NewServerBuilderResult serverBuilder(ServerBuilder<?> serverBuilder) {
            return new NewServerBuilderResult((ServerBuilder) o.r(serverBuilder), null);
        }

        public String getError() {
            return this.error;
        }

        public ServerBuilder<?> getServerBuilder() {
            return this.serverBuilder;
        }
    }

    public static ServerProvider provider() {
        ServerProvider provider = ServerRegistry.getDefaultRegistry().provider();
        if (provider != null) {
            return provider;
        }
        throw new ManagedChannelProvider.ProviderNotFoundException("No functional server found. Try adding a dependency on the grpc-netty or grpc-netty-shaded artifact");
    }

    public abstract ServerBuilder<?> builderForPort(int i10);

    public abstract boolean isAvailable();

    public NewServerBuilderResult newServerBuilderForPort(int i10, ServerCredentials serverCredentials) {
        return NewServerBuilderResult.error("ServerCredentials are unsupported");
    }

    public abstract int priority();
}
