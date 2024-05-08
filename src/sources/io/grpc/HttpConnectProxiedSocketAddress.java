package io.grpc;

import android.view.View;
import com.google.common.base.j;
import com.google.common.base.l;
import com.google.common.base.o;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/5279")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class HttpConnectProxiedSocketAddress extends ProxiedSocketAddress {
    private static final long serialVersionUID = 0;
    private final String password;
    private final SocketAddress proxyAddress;
    private final InetSocketAddress targetAddress;
    private final String username;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Builder {
        private String password;
        private SocketAddress proxyAddress;
        private InetSocketAddress targetAddress;
        private String username;

        public HttpConnectProxiedSocketAddress build() {
            return new HttpConnectProxiedSocketAddress(this.proxyAddress, this.targetAddress, this.username, this.password);
        }

        public Builder setPassword(String str) {
            this.password = str;
            return this;
        }

        public Builder setProxyAddress(SocketAddress socketAddress) {
            this.proxyAddress = (SocketAddress) o.s(socketAddress, "proxyAddress");
            return this;
        }

        public Builder setTargetAddress(InetSocketAddress inetSocketAddress) {
            this.targetAddress = (InetSocketAddress) o.s(inetSocketAddress, "targetAddress");
            return this;
        }

        public Builder setUsername(String str) {
            this.username = str;
            return this;
        }

        private Builder() {
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof HttpConnectProxiedSocketAddress)) {
            return false;
        }
        HttpConnectProxiedSocketAddress httpConnectProxiedSocketAddress = (HttpConnectProxiedSocketAddress) obj;
        return l.a(this.proxyAddress, httpConnectProxiedSocketAddress.proxyAddress) && l.a(this.targetAddress, httpConnectProxiedSocketAddress.targetAddress) && l.a(this.username, httpConnectProxiedSocketAddress.username) && l.a(this.password, httpConnectProxiedSocketAddress.password);
    }

    public String getPassword() {
        return this.password;
    }

    public SocketAddress getProxyAddress() {
        return this.proxyAddress;
    }

    public InetSocketAddress getTargetAddress() {
        return this.targetAddress;
    }

    public String getUsername() {
        return this.username;
    }

    public int hashCode() {
        return l.b(this.proxyAddress, this.targetAddress, this.username, this.password);
    }

    public String toString() {
        return j.c(this).d("proxyAddr", this.proxyAddress).d("targetAddr", this.targetAddress).d(View.AUTOFILL_HINT_USERNAME, this.username).e("hasPassword", this.password != null).toString();
    }

    private HttpConnectProxiedSocketAddress(SocketAddress socketAddress, InetSocketAddress inetSocketAddress, String str, String str2) {
        o.s(socketAddress, "proxyAddress");
        o.s(inetSocketAddress, "targetAddress");
        if (socketAddress instanceof InetSocketAddress) {
            o.B(!((InetSocketAddress) socketAddress).isUnresolved(), "The proxy address %s is not resolved", socketAddress);
        }
        this.proxyAddress = socketAddress;
        this.targetAddress = inetSocketAddress;
        this.username = str;
        this.password = str2;
    }
}
