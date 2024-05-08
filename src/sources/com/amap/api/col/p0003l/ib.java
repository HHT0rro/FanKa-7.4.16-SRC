package com.amap.api.col.p0003l;

import android.content.Context;
import android.net.SSLSessionCache;
import android.os.Build;
import com.amap.api.col.p0003l.fk;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: MySSLSocketFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ib extends SSLSocketFactory {

    /* renamed from: a, reason: collision with root package name */
    private SSLSocketFactory f6406a;

    /* renamed from: b, reason: collision with root package name */
    private Context f6407b;

    /* renamed from: c, reason: collision with root package name */
    private SSLContext f6408c;

    public ib(Context context, SSLContext sSLContext) {
        if (context != null) {
            try {
                this.f6407b = context.getApplicationContext();
            } catch (Throwable th) {
                try {
                    gy.b(th, "myssl", "<init>");
                    try {
                        if (this.f6408c == null) {
                            this.f6408c = SSLContext.getDefault();
                        }
                    } catch (Throwable th2) {
                        gy.b(th2, "myssl", "<init2>");
                    }
                    try {
                        if (this.f6406a == null) {
                            this.f6406a = (SSLSocketFactory) SSLSocketFactory.getDefault();
                            return;
                        }
                        return;
                    } catch (Throwable th3) {
                        gy.b(th3, "myssl", "<init3>");
                        return;
                    }
                } catch (Throwable th4) {
                    try {
                        if (this.f6408c == null) {
                            this.f6408c = SSLContext.getDefault();
                        }
                    } catch (Throwable th5) {
                        gy.b(th5, "myssl", "<init2>");
                    }
                    try {
                        if (this.f6406a == null) {
                            this.f6406a = (SSLSocketFactory) SSLSocketFactory.getDefault();
                            throw th4;
                        }
                        throw th4;
                    } catch (Throwable th6) {
                        gy.b(th6, "myssl", "<init3>");
                        throw th4;
                    }
                }
            }
        }
        this.f6408c = sSLContext;
        if (sSLContext != null) {
            this.f6406a = sSLContext.getSocketFactory();
        }
        try {
            if (this.f6408c == null) {
                this.f6408c = SSLContext.getDefault();
            }
        } catch (Throwable th7) {
            gy.b(th7, "myssl", "<init2>");
        }
        try {
            if (this.f6406a == null) {
                this.f6406a = (SSLSocketFactory) SSLSocketFactory.getDefault();
            }
        } catch (Throwable th8) {
            gy.b(th8, "myssl", "<init3>");
        }
    }

    private static Socket a(Socket socket) {
        try {
            if (fk.f.f5826b && (socket instanceof SSLSocket)) {
                ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1.2"});
            }
        } catch (Throwable th) {
            gy.b(th, "myssl", "stlv2");
        }
        return socket;
    }

    private static void b(Socket socket) {
        int i10 = Build.VERSION.SDK_INT;
        if (fk.f.f5827c && fk.f.f5829e && (socket instanceof SSLSocket)) {
            int i11 = fk.f.f5830f;
            int i12 = fk.f.f5828d;
            if (i11 <= i12) {
                i12 = fk.f.f5830f;
            }
            if (i12 <= 17 || i10 <= i12) {
                try {
                    socket.getClass().getMethod(fv.c("Cc2V0VXNlU2Vzc2lvblRpY2tldHM"), Boolean.TYPE).invoke(socket, Boolean.TRUE);
                } catch (Throwable th) {
                    gy.b(th, "myssl", "sust");
                }
            }
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket() throws IOException {
        boolean z10;
        IOException iOException;
        try {
            SSLSocketFactory sSLSocketFactory = this.f6406a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket a10 = a(sSLSocketFactory.createSocket());
            b(a10);
            return a10;
        } finally {
            if (!z10) {
            }
        }
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        try {
            SSLSocketFactory sSLSocketFactory = this.f6406a;
            if (sSLSocketFactory != null) {
                return sSLSocketFactory.getDefaultCipherSuites();
            }
        } catch (Throwable th) {
            gy.b(th, "myssl", "gdcs");
        }
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        try {
            SSLSocketFactory sSLSocketFactory = this.f6406a;
            if (sSLSocketFactory != null) {
                return sSLSocketFactory.getSupportedCipherSuites();
            }
        } catch (Throwable th) {
            gy.b(th, "myssl", "gscs");
        }
        return new String[0];
    }

    public final void a() {
        int i10 = Build.VERSION.SDK_INT;
        if (!fk.f.f5827c || this.f6407b == null || this.f6408c == null) {
            return;
        }
        int i11 = fk.f.f5828d;
        if (i11 <= 17 || i10 <= i11) {
            SSLSessionCache sSLSessionCache = new SSLSessionCache(this.f6407b);
            if (i10 < 28) {
                try {
                    sSLSessionCache.getClass().getMethod(fv.c("MaW5zdGFsbA"), SSLSessionCache.class, SSLContext.class).invoke(sSLSessionCache, sSLSessionCache, this.f6408c);
                    return;
                } catch (Throwable th) {
                    gy.b(th, "myssl", "isc1");
                    a(sSLSessionCache);
                    return;
                }
            }
            a(sSLSessionCache);
        }
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i10, boolean z10) throws IOException {
        boolean z11;
        IOException iOException;
        try {
            SSLSocketFactory sSLSocketFactory = this.f6406a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket a10 = a(sSLSocketFactory.createSocket(socket, str, i10, z10));
            b(a10);
            return a10;
        } finally {
            if (!z11) {
            }
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i10) throws IOException, UnknownHostException {
        try {
            SSLSocketFactory sSLSocketFactory = this.f6406a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket a10 = a(sSLSocketFactory.createSocket(str, i10));
            b(a10);
            return a10;
        } catch (Throwable th) {
            gy.b(th, "myssl", "cs3");
            if (!(th instanceof UnknownHostException)) {
                if (th instanceof IOException) {
                    throw th;
                }
                return null;
            }
            throw th;
        }
    }

    private void a(SSLSessionCache sSLSessionCache) {
        SSLContext sSLContext = this.f6408c;
        if (sSLContext == null) {
            return;
        }
        try {
            SSLSessionContext clientSessionContext = sSLContext.getClientSessionContext();
            Field declaredField = sSLSessionCache.getClass().getDeclaredField(fv.c("UbVNlc3Npb25DYWNoZQ"));
            declaredField.setAccessible(true);
            Object obj = declaredField.get(sSLSessionCache);
            Method[] methods = clientSessionContext.getClass().getMethods();
            String c4 = fv.c("Yc2V0UGVyc2lzdGVudENhY2hl");
            for (Method method : methods) {
                if (method.getName().equals(c4)) {
                    method.invoke(clientSessionContext, obj);
                    return;
                }
            }
        } catch (Throwable th) {
            gy.b(th, "myssl", "isc2");
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i10, InetAddress inetAddress, int i11) throws IOException, UnknownHostException {
        try {
            SSLSocketFactory sSLSocketFactory = this.f6406a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket a10 = a(sSLSocketFactory.createSocket(str, i10, inetAddress, i11));
            b(a10);
            return a10;
        } catch (Throwable th) {
            gy.b(th, "myssl", "cs4");
            if (!(th instanceof UnknownHostException)) {
                if (th instanceof IOException) {
                    throw th;
                }
                return null;
            }
            throw th;
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i10) throws IOException {
        boolean z10;
        IOException iOException;
        try {
            SSLSocketFactory sSLSocketFactory = this.f6406a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket a10 = a(sSLSocketFactory.createSocket(inetAddress, i10));
            b(a10);
            return a10;
        } finally {
            if (!z10) {
            }
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i10, InetAddress inetAddress2, int i11) throws IOException {
        boolean z10;
        IOException iOException;
        try {
            SSLSocketFactory sSLSocketFactory = this.f6406a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket a10 = a(sSLSocketFactory.createSocket(inetAddress, i10, inetAddress2, i11));
            b(a10);
            return a10;
        } finally {
            if (!z10) {
            }
        }
    }
}
