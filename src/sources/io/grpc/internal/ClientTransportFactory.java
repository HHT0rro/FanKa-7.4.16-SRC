package io.grpc.internal;

import com.google.common.base.l;
import com.google.common.base.o;
import io.grpc.Attributes;
import io.grpc.CallCredentials;
import io.grpc.ChannelCredentials;
import io.grpc.ChannelLogger;
import io.grpc.HttpConnectProxiedSocketAddress;
import java.io.Closeable;
import java.net.SocketAddress;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface ClientTransportFactory extends Closeable {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ClientTransportOptions {
        private ChannelLogger channelLogger;
        private HttpConnectProxiedSocketAddress connectProxiedSocketAddr;
        private String userAgent;
        private String authority = "unknown-authority";
        private Attributes eagAttributes = Attributes.EMPTY;

        public boolean equals(Object obj) {
            if (!(obj instanceof ClientTransportOptions)) {
                return false;
            }
            ClientTransportOptions clientTransportOptions = (ClientTransportOptions) obj;
            return this.authority.equals(clientTransportOptions.authority) && this.eagAttributes.equals(clientTransportOptions.eagAttributes) && l.a(this.userAgent, clientTransportOptions.userAgent) && l.a(this.connectProxiedSocketAddr, clientTransportOptions.connectProxiedSocketAddr);
        }

        public String getAuthority() {
            return this.authority;
        }

        public ChannelLogger getChannelLogger() {
            return this.channelLogger;
        }

        public Attributes getEagAttributes() {
            return this.eagAttributes;
        }

        public HttpConnectProxiedSocketAddress getHttpConnectProxiedSocketAddress() {
            return this.connectProxiedSocketAddr;
        }

        public String getUserAgent() {
            return this.userAgent;
        }

        public int hashCode() {
            return l.b(this.authority, this.eagAttributes, this.userAgent, this.connectProxiedSocketAddr);
        }

        public ClientTransportOptions setAuthority(String str) {
            this.authority = (String) o.s(str, "authority");
            return this;
        }

        public ClientTransportOptions setChannelLogger(ChannelLogger channelLogger) {
            this.channelLogger = channelLogger;
            return this;
        }

        public ClientTransportOptions setEagAttributes(Attributes attributes) {
            o.s(attributes, "eagAttributes");
            this.eagAttributes = attributes;
            return this;
        }

        public ClientTransportOptions setHttpConnectProxiedSocketAddress(HttpConnectProxiedSocketAddress httpConnectProxiedSocketAddress) {
            this.connectProxiedSocketAddr = httpConnectProxiedSocketAddress;
            return this;
        }

        public ClientTransportOptions setUserAgent(String str) {
            this.userAgent = str;
            return this;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class SwapChannelCredentialsResult {
        public final CallCredentials callCredentials;
        public final ClientTransportFactory transportFactory;

        public SwapChannelCredentialsResult(ClientTransportFactory clientTransportFactory, CallCredentials callCredentials) {
            this.transportFactory = (ClientTransportFactory) o.s(clientTransportFactory, "transportFactory");
            this.callCredentials = callCredentials;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    ScheduledExecutorService getScheduledExecutorService();

    ConnectionClientTransport newClientTransport(SocketAddress socketAddress, ClientTransportOptions clientTransportOptions, ChannelLogger channelLogger);

    SwapChannelCredentialsResult swapChannelCredentials(ChannelCredentials channelCredentials);
}
