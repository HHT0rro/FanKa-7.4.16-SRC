package xa;

import android.content.Context;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import za.f;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b extends SSLSocketFactory {

    /* renamed from: i, reason: collision with root package name */
    @Deprecated
    public static final X509HostnameVerifier f54583i = new BrowserCompatHostnameVerifier();

    /* renamed from: j, reason: collision with root package name */
    @Deprecated
    public static final X509HostnameVerifier f54584j = new StrictHostnameVerifier();

    /* renamed from: k, reason: collision with root package name */
    public static final String f54585k = b.class.getSimpleName();

    /* renamed from: l, reason: collision with root package name */
    public static volatile b f54586l = null;

    /* renamed from: a, reason: collision with root package name */
    public SSLContext f54587a = null;

    /* renamed from: b, reason: collision with root package name */
    public SSLSocket f54588b = null;

    /* renamed from: c, reason: collision with root package name */
    public Context f54589c;

    /* renamed from: d, reason: collision with root package name */
    public String[] f54590d;

    /* renamed from: e, reason: collision with root package name */
    public X509TrustManager f54591e;

    /* renamed from: f, reason: collision with root package name */
    public String[] f54592f;

    /* renamed from: g, reason: collision with root package name */
    public String[] f54593g;

    /* renamed from: h, reason: collision with root package name */
    public String[] f54594h;

    public b(Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException, KeyManagementException {
        if (context == null) {
            f.d(f54585k, "SecureSSLSocketFactory: context is null");
            return;
        }
        c(context);
        d(a.f());
        e a10 = d.a(context);
        this.f54591e = a10;
        this.f54587a.init(null, new X509TrustManager[]{a10}, secureRandom);
    }

    @Deprecated
    public static b b(Context context) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException, IllegalArgumentException {
        long currentTimeMillis = System.currentTimeMillis();
        za.b.b(context);
        if (f54586l == null) {
            synchronized (b.class) {
                if (f54586l == null) {
                    f54586l = new b(context, null);
                }
            }
        }
        if (f54586l.f54589c == null && context != null) {
            f54586l.c(context);
        }
        f.b(f54585k, "getInstance: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return f54586l;
    }

    public final void a(Socket socket) {
        boolean z10;
        boolean z11 = true;
        if (za.c.a(this.f54594h)) {
            z10 = false;
        } else {
            f.e(f54585k, "set protocols");
            a.e((SSLSocket) socket, this.f54594h);
            z10 = true;
        }
        if (za.c.a(this.f54593g) && za.c.a(this.f54592f)) {
            z11 = false;
        } else {
            f.e(f54585k, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            a.d(sSLSocket);
            if (!za.c.a(this.f54593g)) {
                a.h(sSLSocket, this.f54593g);
            } else {
                a.b(sSLSocket, this.f54592f);
            }
        }
        if (!z10) {
            f.e(f54585k, "set default protocols");
            a.d((SSLSocket) socket);
        }
        if (z11) {
            return;
        }
        f.e(f54585k, "set default cipher suites");
        a.c((SSLSocket) socket);
    }

    public void c(Context context) {
        this.f54589c = context.getApplicationContext();
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i10) throws IOException {
        f.e(f54585k, "createSocket: host , port");
        Socket createSocket = this.f54587a.getSocketFactory().createSocket(str, i10);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f54588b = sSLSocket;
            this.f54590d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public void d(SSLContext sSLContext) {
        this.f54587a = sSLContext;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f54590d;
        return strArr != null ? strArr : new String[0];
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i10) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i10);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i10, InetAddress inetAddress, int i11) throws IOException, UnknownHostException {
        return createSocket(str, i10);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i10, InetAddress inetAddress2, int i11) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i10);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i10, boolean z10) throws IOException {
        f.e(f54585k, "createSocket s host port autoClose");
        Socket createSocket = this.f54587a.getSocketFactory().createSocket(socket, str, i10, z10);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f54588b = sSLSocket;
            this.f54590d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }
}
