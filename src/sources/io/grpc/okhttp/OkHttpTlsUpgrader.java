package io.grpc.okhttp;

import com.google.common.base.o;
import io.grpc.okhttp.internal.ConnectionSpec;
import io.grpc.okhttp.internal.OkHostnameVerifier;
import io.grpc.okhttp.internal.Protocol;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class OkHttpTlsUpgrader {
    public static final List<Protocol> TLS_PROTOCOLS = Collections.unmodifiableList(Arrays.asList(Protocol.HTTP_2));

    public static String canonicalizeHost(String str) {
        return (str.startsWith("[") && str.endsWith("]")) ? str.substring(1, str.length() - 1) : str;
    }

    public static SSLSocket upgrade(SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, Socket socket, String str, int i10, ConnectionSpec connectionSpec) throws IOException {
        o.s(sSLSocketFactory, "sslSocketFactory");
        o.s(socket, "socket");
        o.s(connectionSpec, "spec");
        SSLSocket sSLSocket = (SSLSocket) sSLSocketFactory.createSocket(socket, str, i10, true);
        connectionSpec.apply(sSLSocket, false);
        String negotiate = OkHttpProtocolNegotiator.get().negotiate(sSLSocket, str, connectionSpec.supportsTlsExtensions() ? TLS_PROTOCOLS : null);
        List<Protocol> list = TLS_PROTOCOLS;
        o.B(list.contains(Protocol.get(negotiate)), "Only " + ((Object) list) + " are supported, but negotiated protocol is %s", negotiate);
        if (hostnameVerifier == null) {
            hostnameVerifier = OkHostnameVerifier.INSTANCE;
        }
        if (hostnameVerifier.verify(canonicalizeHost(str), sSLSocket.getSession())) {
            return sSLSocket;
        }
        throw new SSLPeerUnverifiedException("Cannot verify hostname: " + str);
    }
}
