package com.tencent.cloud.huiyansdkface.okhttp3.internal.connection;

import com.tencent.cloud.huiyansdkface.okhttp3.ConnectionSpec;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ConnectionSpecSelector {

    /* renamed from: a, reason: collision with root package name */
    private final List<ConnectionSpec> f41707a;

    /* renamed from: b, reason: collision with root package name */
    private int f41708b = 0;

    /* renamed from: c, reason: collision with root package name */
    private boolean f41709c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f41710d;

    public ConnectionSpecSelector(List<ConnectionSpec> list) {
        this.f41707a = list;
    }

    private boolean a(SSLSocket sSLSocket) {
        for (int i10 = this.f41708b; i10 < this.f41707a.size(); i10++) {
            if (this.f41707a.get(i10).isCompatible(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public ConnectionSpec configureSecureSocket(SSLSocket sSLSocket) throws IOException {
        ConnectionSpec connectionSpec;
        int i10 = this.f41708b;
        int size = this.f41707a.size();
        while (true) {
            if (i10 >= size) {
                connectionSpec = null;
                break;
            }
            connectionSpec = this.f41707a.get(i10);
            i10++;
            if (connectionSpec.isCompatible(sSLSocket)) {
                this.f41708b = i10;
                break;
            }
        }
        if (connectionSpec != null) {
            this.f41709c = a(sSLSocket);
            Internal.f41598a.apply(connectionSpec, sSLSocket, this.f41710d);
            return connectionSpec;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f41710d + ", modes=" + ((Object) this.f41707a) + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean connectionFailed(IOException iOException) {
        this.f41710d = true;
        if (!this.f41709c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z10 = iOException instanceof SSLHandshakeException;
        if ((z10 && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return z10 || (iOException instanceof SSLProtocolException) || (iOException instanceof SSLException);
    }
}
