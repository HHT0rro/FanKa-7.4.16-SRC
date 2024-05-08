package com.jd.ad.sdk.jad_xk;

import android.content.Context;
import android.net.SSLSessionCache;
import android.net.ssl.SSLSockets;
import android.os.Build;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class jad_mz extends SSLSocketFactory {
    public String jad_an = "SSLExtensionSocketFactory";
    public SSLSocketFactory jad_bo;

    public jad_mz(Context context) {
        try {
            SSLContext sSLContext = SSLContext.getDefault();
            SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
            this.jad_bo = socketFactory;
            if (socketFactory == null) {
                this.jad_bo = (SSLSocketFactory) SSLSocketFactory.getDefault();
            }
            if (context != null) {
                jad_an(new SSLSessionCache(context), sSLContext);
            }
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i10) {
        return jad_an(this.jad_bo.createSocket(str, i10));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i10, InetAddress inetAddress, int i11) {
        return jad_an(this.jad_bo.createSocket(str, i10, inetAddress, i11));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i10) {
        return jad_an(this.jad_bo.createSocket(inetAddress, i10));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i10, InetAddress inetAddress2, int i11) {
        return jad_an(this.jad_bo.createSocket(inetAddress, i10, inetAddress2, i11));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i10, boolean z10) {
        return jad_an(this.jad_bo.createSocket(socket, str, i10, z10));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.jad_bo.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.jad_bo.getSupportedCipherSuites();
    }

    public final Socket jad_an(Socket socket) {
        if ((socket instanceof SSLSocket) && Build.VERSION.SDK_INT >= 29) {
            SSLSockets.setUseSessionTickets((SSLSocket) socket, true);
        }
        return socket;
    }

    public final void jad_an(SSLSessionCache sSLSessionCache, SSLContext sSLContext) {
        try {
            Field declaredField = sSLSessionCache.getClass().getDeclaredField("mSessionCache");
            declaredField.setAccessible(true);
            sSLContext.getClientSessionContext().getClass().getMethod("setPersistentCache", Class.forName("com.android.org.conscrypt.SSLClientSessionCache")).invoke(sSLContext.getClientSessionContext(), declaredField.get(sSLSessionCache));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
