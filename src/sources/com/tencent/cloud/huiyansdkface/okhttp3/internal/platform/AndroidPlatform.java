package com.tencent.cloud.huiyansdkface.okhttp3.internal.platform;

import android.os.Build;
import android.util.Log;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.tencent.cloud.huiyansdkface.okhttp3.Protocol;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.tls.CertificateChainCleaner;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.tls.TrustRootIndex;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
class AndroidPlatform extends Platform {

    /* renamed from: a, reason: collision with root package name */
    private final Class<?> f41987a;

    /* renamed from: b, reason: collision with root package name */
    private final OptionalMethod<Socket> f41988b;

    /* renamed from: c, reason: collision with root package name */
    private final OptionalMethod<Socket> f41989c;

    /* renamed from: d, reason: collision with root package name */
    private final OptionalMethod<Socket> f41990d;

    /* renamed from: e, reason: collision with root package name */
    private final OptionalMethod<Socket> f41991e;

    /* renamed from: f, reason: collision with root package name */
    private final CloseGuard f41992f = CloseGuard.a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class AndroidCertificateChainCleaner extends CertificateChainCleaner {

        /* renamed from: a, reason: collision with root package name */
        private final Object f41993a;

        /* renamed from: b, reason: collision with root package name */
        private final Method f41994b;

        public AndroidCertificateChainCleaner(Object obj, Method method) {
            this.f41993a = obj;
            this.f41994b = method;
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.tls.CertificateChainCleaner
        public List<Certificate> clean(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.f41994b.invoke(this.f41993a, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (InvocationTargetException e10) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e10.getMessage());
                sSLPeerUnverifiedException.initCause(e10);
                throw sSLPeerUnverifiedException;
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof AndroidCertificateChainCleaner;
        }

        public int hashCode() {
            return 0;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class AndroidTrustRootIndex implements TrustRootIndex {

        /* renamed from: a, reason: collision with root package name */
        private final X509TrustManager f41995a;

        /* renamed from: b, reason: collision with root package name */
        private final Method f41996b;

        public AndroidTrustRootIndex(X509TrustManager x509TrustManager, Method method) {
            this.f41996b = method;
            this.f41995a = x509TrustManager;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AndroidTrustRootIndex)) {
                return false;
            }
            AndroidTrustRootIndex androidTrustRootIndex = (AndroidTrustRootIndex) obj;
            return this.f41995a.equals(androidTrustRootIndex.f41995a) && this.f41996b.equals(androidTrustRootIndex.f41996b);
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.tls.TrustRootIndex
        public X509Certificate findByIssuerAndSignature(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f41996b.invoke(this.f41995a, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (IllegalAccessException e2) {
                throw Util.assertionError("unable to get issues and signature", e2);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public int hashCode() {
            return this.f41995a.hashCode() + (this.f41996b.hashCode() * 31);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class CloseGuard {

        /* renamed from: a, reason: collision with root package name */
        private final Method f41997a;

        /* renamed from: b, reason: collision with root package name */
        private final Method f41998b;

        /* renamed from: c, reason: collision with root package name */
        private final Method f41999c;

        public CloseGuard(Method method, Method method2, Method method3) {
            this.f41997a = method;
            this.f41998b = method2;
            this.f41999c = method3;
        }

        public static CloseGuard a() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[0]);
                method2 = cls.getMethod("open", String.class);
                method = cls.getMethod("warnIfOpen", new Class[0]);
                method3 = method4;
            } catch (Exception unused) {
                method = null;
                method2 = null;
            }
            return new CloseGuard(method3, method2, method);
        }

        public Object a(String str) {
            Method method = this.f41997a;
            if (method != null) {
                try {
                    Object invoke = method.invoke(null, new Object[0]);
                    this.f41998b.invoke(invoke, str);
                    return invoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        public boolean a(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                this.f41999c.invoke(obj, new Object[0]);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    public AndroidPlatform(Class<?> cls, OptionalMethod<Socket> optionalMethod, OptionalMethod<Socket> optionalMethod2, OptionalMethod<Socket> optionalMethod3, OptionalMethod<Socket> optionalMethod4) {
        this.f41987a = cls;
        this.f41988b = optionalMethod;
        this.f41989c = optionalMethod2;
        this.f41990d = optionalMethod3;
        this.f41991e = optionalMethod4;
    }

    private static boolean a() {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private boolean a(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return b(str, cls, obj);
        }
    }

    private boolean b(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.isCleartextTrafficPermitted(str);
        }
    }

    public static Platform buildIfSupported() {
        Class<?> cls;
        OptionalMethod optionalMethod;
        OptionalMethod optionalMethod2;
        try {
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            Class<?> cls2 = cls;
            OptionalMethod optionalMethod3 = new OptionalMethod(null, "setUseSessionTickets", Boolean.TYPE);
            OptionalMethod optionalMethod4 = new OptionalMethod(null, "setHostname", String.class);
            if (a()) {
                OptionalMethod optionalMethod5 = new OptionalMethod(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                optionalMethod2 = new OptionalMethod(null, "setAlpnProtocols", byte[].class);
                optionalMethod = optionalMethod5;
            } else {
                optionalMethod = null;
                optionalMethod2 = null;
            }
            return new AndroidPlatform(cls2, optionalMethod3, optionalMethod4, optionalMethod, optionalMethod2);
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform
    public X509TrustManager a(SSLSocketFactory sSLSocketFactory) {
        Object a10 = Platform.a(sSLSocketFactory, this.f41987a, "sslParameters");
        if (a10 == null) {
            try {
                a10 = Platform.a(sSLSocketFactory, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, sSLSocketFactory.getClass().getClassLoader()), "sslParameters");
            } catch (ClassNotFoundException unused) {
                return super.a(sSLSocketFactory);
            }
        }
        X509TrustManager x509TrustManager = (X509TrustManager) Platform.a(a10, X509TrustManager.class, "x509TrustManager");
        return x509TrustManager != null ? x509TrustManager : (X509TrustManager) Platform.a(a10, X509TrustManager.class, "trustManager");
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform
    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new AndroidCertificateChainCleaner(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.buildCertificateChainCleaner(x509TrustManager);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform
    public TrustRootIndex buildTrustRootIndex(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new AndroidTrustRootIndex(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.buildTrustRootIndex(x509TrustManager);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform
    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
        if (str != null) {
            this.f41988b.invokeOptionalWithoutCheckedException(sSLSocket, Boolean.TRUE);
            this.f41989c.invokeOptionalWithoutCheckedException(sSLSocket, str);
        }
        OptionalMethod<Socket> optionalMethod = this.f41991e;
        if (optionalMethod == null || !optionalMethod.isSupported(sSLSocket)) {
            return;
        }
        this.f41991e.invokeWithoutCheckedException(sSLSocket, Platform.a(list));
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform
    public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i10) throws IOException {
        try {
            socket.connect(inetSocketAddress, i10);
        } catch (AssertionError e2) {
            if (!Util.isAndroidGetsocknameError(e2)) {
                throw e2;
            }
            throw new IOException(e2);
        } catch (ClassCastException e10) {
            if (Build.VERSION.SDK_INT != 26) {
                throw e10;
            }
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e10);
            throw iOException;
        } catch (SecurityException e11) {
            IOException iOException2 = new IOException("Exception in connect");
            iOException2.initCause(e11);
            throw iOException2;
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform
    public SSLContext getSSLContext() {
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException("No TLS provider", e2);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        byte[] bArr;
        OptionalMethod<Socket> optionalMethod = this.f41990d;
        if (optionalMethod == null || !optionalMethod.isSupported(sSLSocket) || (bArr = (byte[]) this.f41990d.invokeWithoutCheckedException(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, Util.f41604e);
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform
    public Object getStackTraceForCloseable(String str) {
        return this.f41992f.a(str);
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform
    public boolean isCleartextTrafficPermitted(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return a(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.isCleartextTrafficPermitted(str);
        } catch (IllegalAccessException e2) {
            e = e2;
            throw Util.assertionError("unable to determine cleartext support", e);
        } catch (IllegalArgumentException e10) {
            e = e10;
            throw Util.assertionError("unable to determine cleartext support", e);
        } catch (InvocationTargetException e11) {
            e = e11;
            throw Util.assertionError("unable to determine cleartext support", e);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform
    public void log(int i10, String str, Throwable th) {
        int min;
        int i11 = i10 != 5 ? 3 : 5;
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        int i12 = 0;
        int length = str.length();
        while (i12 < length) {
            int indexOf = str.indexOf(10, i12);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i12 + 4000);
                Log.println(i11, "OkHttp", str.substring(i12, min));
                if (min >= indexOf) {
                    break;
                } else {
                    i12 = min;
                }
            }
            i12 = min + 1;
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform
    public void logCloseableLeak(String str, Object obj) {
        if (this.f41992f.a(obj)) {
            return;
        }
        log(5, str, null);
    }
}
