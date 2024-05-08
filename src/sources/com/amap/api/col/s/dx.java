package com.amap.api.col.s;

import android.content.Context;
import android.net.SSLSessionCache;
import android.os.Build;
import com.amap.api.col.s.bx;
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
public final class dx extends SSLSocketFactory {

    /* renamed from: a, reason: collision with root package name */
    private SSLSocketFactory f7822a;

    /* renamed from: b, reason: collision with root package name */
    private Context f7823b;

    /* renamed from: c, reason: collision with root package name */
    private SSLContext f7824c;

    public dx(Context context, SSLContext sSLContext) {
        if (context != null) {
            try {
                this.f7823b = context.getApplicationContext();
            } catch (Throwable th) {
                try {
                    df.c(th, "myssl", "<init>");
                    try {
                        if (this.f7824c == null) {
                            this.f7824c = SSLContext.getDefault();
                        }
                    } catch (Throwable th2) {
                        df.c(th2, "myssl", "<init2>");
                    }
                    try {
                        if (this.f7822a == null) {
                            this.f7822a = (SSLSocketFactory) SSLSocketFactory.getDefault();
                            return;
                        }
                        return;
                    } catch (Throwable th3) {
                        df.c(th3, "myssl", "<init3>");
                        return;
                    }
                } catch (Throwable th4) {
                    try {
                        if (this.f7824c == null) {
                            this.f7824c = SSLContext.getDefault();
                        }
                    } catch (Throwable th5) {
                        df.c(th5, "myssl", "<init2>");
                    }
                    try {
                        if (this.f7822a == null) {
                            this.f7822a = (SSLSocketFactory) SSLSocketFactory.getDefault();
                            throw th4;
                        }
                        throw th4;
                    } catch (Throwable th6) {
                        df.c(th6, "myssl", "<init3>");
                        throw th4;
                    }
                }
            }
        }
        this.f7824c = sSLContext;
        if (sSLContext != null) {
            this.f7822a = sSLContext.getSocketFactory();
        }
        try {
            if (this.f7824c == null) {
                this.f7824c = SSLContext.getDefault();
            }
        } catch (Throwable th7) {
            df.c(th7, "myssl", "<init2>");
        }
        try {
            if (this.f7822a == null) {
                this.f7822a = (SSLSocketFactory) SSLSocketFactory.getDefault();
            }
        } catch (Throwable th8) {
            df.c(th8, "myssl", "<init3>");
        }
    }

    private static Socket a(Socket socket) {
        try {
            if (bx.f.f7377b && (socket instanceof SSLSocket)) {
                ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1.2"});
            }
        } catch (Throwable th) {
            df.c(th, "myssl", "stlv2");
        }
        return socket;
    }

    private static void b(Socket socket) {
        int i10 = Build.VERSION.SDK_INT;
        if (bx.f.f7378c && bx.f.f7380e && (socket instanceof SSLSocket)) {
            int i11 = bx.f.f7381f;
            int i12 = bx.f.f7379d;
            if (i11 <= i12) {
                i12 = bx.f.f7381f;
            }
            if (i12 <= 17 || i10 <= i12) {
                try {
                    socket.getClass().getMethod(ci.c("Cc2V0VXNlU2Vzc2lvblRpY2tldHM"), Boolean.TYPE).invoke(socket, Boolean.TRUE);
                } catch (Throwable th) {
                    df.c(th, "myssl", "sust");
                }
            }
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket() throws IOException {
        boolean z10;
        IOException iOException;
        try {
            SSLSocketFactory sSLSocketFactory = this.f7822a;
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
            SSLSocketFactory sSLSocketFactory = this.f7822a;
            if (sSLSocketFactory != null) {
                return sSLSocketFactory.getDefaultCipherSuites();
            }
        } catch (Throwable th) {
            df.c(th, "myssl", "gdcs");
        }
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        try {
            SSLSocketFactory sSLSocketFactory = this.f7822a;
            if (sSLSocketFactory != null) {
                return sSLSocketFactory.getSupportedCipherSuites();
            }
        } catch (Throwable th) {
            df.c(th, "myssl", "gscs");
        }
        return new String[0];
    }

    public final void a() {
        int i10 = Build.VERSION.SDK_INT;
        if (!bx.f.f7378c || this.f7823b == null || this.f7824c == null) {
            return;
        }
        int i11 = bx.f.f7379d;
        if (i11 <= 17 || i10 <= i11) {
            SSLSessionCache sSLSessionCache = new SSLSessionCache(this.f7823b);
            if (i10 < 28) {
                try {
                    sSLSessionCache.getClass().getMethod(ci.c("MaW5zdGFsbA"), SSLSessionCache.class, SSLContext.class).invoke(sSLSessionCache, sSLSessionCache, this.f7824c);
                    return;
                } catch (Throwable th) {
                    df.c(th, "myssl", "isc1");
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
            SSLSocketFactory sSLSocketFactory = this.f7822a;
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
            SSLSocketFactory sSLSocketFactory = this.f7822a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket a10 = a(sSLSocketFactory.createSocket(str, i10));
            b(a10);
            return a10;
        } catch (Throwable th) {
            df.c(th, "myssl", "cs3");
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
        SSLContext sSLContext = this.f7824c;
        if (sSLContext == null) {
            return;
        }
        try {
            SSLSessionContext clientSessionContext = sSLContext.getClientSessionContext();
            Field declaredField = sSLSessionCache.getClass().getDeclaredField(ci.c("UbVNlc3Npb25DYWNoZQ"));
            declaredField.setAccessible(true);
            Object obj = declaredField.get(sSLSessionCache);
            Method[] methods = clientSessionContext.getClass().getMethods();
            String c4 = ci.c("Yc2V0UGVyc2lzdGVudENhY2hl");
            for (Method method : methods) {
                if (method.getName().equals(c4)) {
                    method.invoke(clientSessionContext, obj);
                    return;
                }
            }
        } catch (Throwable th) {
            df.c(th, "myssl", "isc2");
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i10, InetAddress inetAddress, int i11) throws IOException, UnknownHostException {
        try {
            SSLSocketFactory sSLSocketFactory = this.f7822a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket a10 = a(sSLSocketFactory.createSocket(str, i10, inetAddress, i11));
            b(a10);
            return a10;
        } catch (Throwable th) {
            df.c(th, "myssl", "cs4");
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
            SSLSocketFactory sSLSocketFactory = this.f7822a;
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
            SSLSocketFactory sSLSocketFactory = this.f7822a;
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
