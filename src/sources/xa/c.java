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
import za.f;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c extends SSLSocketFactory {

    /* renamed from: i, reason: collision with root package name */
    public static volatile c f54595i;

    /* renamed from: a, reason: collision with root package name */
    public SSLContext f54596a;

    /* renamed from: b, reason: collision with root package name */
    public SSLSocket f54597b;

    /* renamed from: c, reason: collision with root package name */
    public Context f54598c;

    /* renamed from: d, reason: collision with root package name */
    public String[] f54599d;

    /* renamed from: e, reason: collision with root package name */
    public X509TrustManager f54600e;

    /* renamed from: f, reason: collision with root package name */
    public String[] f54601f;

    /* renamed from: g, reason: collision with root package name */
    public String[] f54602g;

    /* renamed from: h, reason: collision with root package name */
    public String[] f54603h;

    public c(Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException, KeyManagementException {
        this.f54596a = null;
        this.f54597b = null;
        if (context == null) {
            f.d("SSLFNew", "SecureSSLSocketFactory: context is null");
            return;
        }
        c(context);
        d(a.f());
        e a10 = d.a(context);
        this.f54600e = a10;
        this.f54596a.init(null, new X509TrustManager[]{a10}, secureRandom);
    }

    @Deprecated
    public static c b(Context context) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException, IllegalArgumentException {
        long currentTimeMillis = System.currentTimeMillis();
        za.b.b(context);
        if (f54595i == null) {
            synchronized (c.class) {
                if (f54595i == null) {
                    f54595i = new c(context, null);
                }
            }
        }
        if (f54595i.f54598c == null && context != null) {
            f54595i.c(context);
        }
        f.b("SSLFNew", "getInstance: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return f54595i;
    }

    public final void a(Socket socket) {
        boolean z10;
        boolean z11 = true;
        if (za.c.a(this.f54603h)) {
            z10 = false;
        } else {
            f.e("SSLFNew", "set protocols");
            a.e((SSLSocket) socket, this.f54603h);
            z10 = true;
        }
        if (za.c.a(this.f54602g) && za.c.a(this.f54601f)) {
            z11 = false;
        } else {
            f.e("SSLFNew", "set cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            a.d(sSLSocket);
            if (!za.c.a(this.f54602g)) {
                a.h(sSLSocket, this.f54602g);
            } else {
                a.b(sSLSocket, this.f54601f);
            }
        }
        if (!z10) {
            f.e("SSLFNew", "set default protocols");
            a.d((SSLSocket) socket);
        }
        if (z11) {
            return;
        }
        f.e("SSLFNew", "set default cipher");
        a.c((SSLSocket) socket);
    }

    public void c(Context context) {
        this.f54598c = context.getApplicationContext();
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i10) throws IOException {
        f.e("SSLFNew", "createSocket: host , port");
        Socket createSocket = this.f54596a.getSocketFactory().createSocket(str, i10);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f54597b = sSLSocket;
            this.f54599d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public void d(SSLContext sSLContext) {
        this.f54596a = sSLContext;
    }

    public void e(X509TrustManager x509TrustManager) {
        this.f54600e = x509TrustManager;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f54599d;
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

    @Deprecated
    public c(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f54596a = null;
        this.f54597b = null;
        this.f54596a = a.f();
        e(x509TrustManager);
        this.f54596a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i10, InetAddress inetAddress2, int i11) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i10);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i10, boolean z10) throws IOException {
        f.e("SSLFNew", "createSocket");
        Socket createSocket = this.f54596a.getSocketFactory().createSocket(socket, str, i10, z10);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f54597b = sSLSocket;
            this.f54599d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }
}
