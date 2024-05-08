package io.grpc.okhttp;

import com.google.common.base.o;
import com.squareup.okhttp.TlsVersion;
import io.grpc.InternalChannelz;
import io.grpc.InternalMetadata;
import io.grpc.Metadata;
import io.grpc.internal.TransportFrameUtil;
import io.grpc.okhttp.internal.CipherSuite;
import io.grpc.okhttp.internal.ConnectionSpec;
import io.grpc.okhttp.internal.framed.Header;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class Utils {
    public static final int CONNECTION_STREAM_ID = 0;
    public static final int DEFAULT_WINDOW_SIZE = 65535;
    public static final float DEFAULT_WINDOW_UPDATE_RATIO = 0.5f;
    private static final Logger log = Logger.getLogger(Utils.class.getName());

    private Utils() {
    }

    public static Metadata convertHeaders(List<Header> list) {
        return InternalMetadata.newMetadata(convertHeadersToArray(list));
    }

    private static byte[][] convertHeadersToArray(List<Header> list) {
        byte[][] bArr = new byte[list.size() * 2];
        int i10 = 0;
        for (Header header : list) {
            int i11 = i10 + 1;
            bArr[i10] = header.name.toByteArray();
            i10 = i11 + 1;
            bArr[i11] = header.value.toByteArray();
        }
        return TransportFrameUtil.toRawSerializedHeaders(bArr);
    }

    public static ConnectionSpec convertSpec(com.squareup.okhttp.ConnectionSpec connectionSpec) {
        o.e(connectionSpec.isTls(), "plaintext ConnectionSpec is not accepted");
        List tlsVersions = connectionSpec.tlsVersions();
        int size = tlsVersions.size();
        String[] strArr = new String[size];
        for (int i10 = 0; i10 < size; i10++) {
            strArr[i10] = ((TlsVersion) tlsVersions.get(i10)).javaName();
        }
        List cipherSuites = connectionSpec.cipherSuites();
        int size2 = cipherSuites.size();
        CipherSuite[] cipherSuiteArr = new CipherSuite[size2];
        for (int i11 = 0; i11 < size2; i11++) {
            cipherSuiteArr[i11] = CipherSuite.valueOf(((com.squareup.okhttp.CipherSuite) cipherSuites.get(i11)).name());
        }
        return new ConnectionSpec.Builder(connectionSpec.isTls()).supportsTlsExtensions(connectionSpec.supportsTlsExtensions()).tlsVersions(strArr).cipherSuites(cipherSuiteArr).build();
    }

    public static Metadata convertTrailers(List<Header> list) {
        return InternalMetadata.newMetadata(convertHeadersToArray(list));
    }

    public static InternalChannelz.SocketOptions getSocketOptions(Socket socket) {
        InternalChannelz.SocketOptions.Builder builder = new InternalChannelz.SocketOptions.Builder();
        try {
            builder.setSocketOptionLingerSeconds(Integer.valueOf(socket.getSoLinger()));
        } catch (SocketException e2) {
            log.log(Level.SEVERE, "Exception caught while reading socket option", (Throwable) e2);
            builder.addOption("SO_LINGER", "channelz_internal_error");
        }
        try {
            builder.setSocketOptionTimeoutMillis(Integer.valueOf(socket.getSoTimeout()));
        } catch (Exception e10) {
            log.log(Level.SEVERE, "Exception caught while reading socket option", (Throwable) e10);
            builder.addOption("SO_TIMEOUT", "channelz_internal_error");
        }
        try {
            builder.addOption("TCP_NODELAY", socket.getTcpNoDelay());
        } catch (SocketException e11) {
            log.log(Level.SEVERE, "Exception caught while reading socket option", (Throwable) e11);
            builder.addOption("TCP_NODELAY", "channelz_internal_error");
        }
        try {
            builder.addOption("SO_REUSEADDR", socket.getReuseAddress());
        } catch (SocketException e12) {
            log.log(Level.SEVERE, "Exception caught while reading socket option", (Throwable) e12);
            builder.addOption("SO_REUSEADDR", "channelz_internal_error");
        }
        try {
            builder.addOption("SO_SNDBUF", socket.getSendBufferSize());
        } catch (SocketException e13) {
            log.log(Level.SEVERE, "Exception caught while reading socket option", (Throwable) e13);
            builder.addOption("SO_SNDBUF", "channelz_internal_error");
        }
        try {
            builder.addOption("SO_RECVBUF", socket.getReceiveBufferSize());
        } catch (SocketException e14) {
            log.log(Level.SEVERE, "Exception caught while reading socket option", (Throwable) e14);
            builder.addOption("SO_RECVBUF", "channelz_internal_error");
        }
        try {
            builder.addOption("SO_KEEPALIVE", socket.getKeepAlive());
        } catch (SocketException e15) {
            log.log(Level.SEVERE, "Exception caught while reading socket option", (Throwable) e15);
            builder.addOption("SO_KEEPALIVE", "channelz_internal_error");
        }
        try {
            builder.addOption("SO_OOBINLINE", socket.getOOBInline());
        } catch (SocketException e16) {
            log.log(Level.SEVERE, "Exception caught while reading socket option", (Throwable) e16);
            builder.addOption("SO_OOBINLINE", "channelz_internal_error");
        }
        try {
            builder.addOption("IP_TOS", socket.getTrafficClass());
        } catch (SocketException e17) {
            log.log(Level.SEVERE, "Exception caught while reading socket option", (Throwable) e17);
            builder.addOption("IP_TOS", "channelz_internal_error");
        }
        return builder.build();
    }
}
