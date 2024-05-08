package io.grpc.okhttp;

import com.google.common.base.o;
import com.tencent.connect.common.Constants;
import io.grpc.internal.GrpcUtil;
import io.grpc.okhttp.internal.OptionalMethod;
import io.grpc.okhttp.internal.Platform;
import io.grpc.okhttp.internal.Protocol;
import io.grpc.okhttp.internal.Util;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class OkHttpProtocolNegotiator {
    public final Platform platform;
    private static final Logger logger = Logger.getLogger(OkHttpProtocolNegotiator.class.getName());
    private static final Platform DEFAULT_PLATFORM = Platform.get();
    private static OkHttpProtocolNegotiator NEGOTIATOR = createNegotiator(OkHttpProtocolNegotiator.class.getClassLoader());

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class AndroidNegotiator extends OkHttpProtocolNegotiator {
        private static final OptionalMethod<Socket> GET_ALPN_SELECTED_PROTOCOL;
        private static final Method GET_APPLICATION_PROTOCOL;
        private static final Method GET_APPLICATION_PROTOCOLS;
        private static final OptionalMethod<Socket> GET_NPN_SELECTED_PROTOCOL;
        private static final OptionalMethod<Socket> SET_ALPN_PROTOCOLS;
        private static final Method SET_APPLICATION_PROTOCOLS;
        private static final OptionalMethod<Socket> SET_HOSTNAME;
        private static final OptionalMethod<Socket> SET_NPN_PROTOCOLS;
        private static final Method SET_SERVER_NAMES;
        private static final OptionalMethod<Socket> SET_USE_SESSION_TICKETS;
        private static final Constructor<?> SNI_HOST_NAME;
        private static final Method SSL_SOCKETS_IS_SUPPORTED_SOCKET;
        private static final Method SSL_SOCKETS_SET_USE_SESSION_TICKET;

        static {
            Method method;
            Method method2;
            Method method3;
            Method method4;
            Method method5;
            Method method6;
            Class<Boolean> cls = Boolean.TYPE;
            Constructor<?> constructor = null;
            SET_USE_SESSION_TICKETS = new OptionalMethod<>(null, "setUseSessionTickets", cls);
            SET_HOSTNAME = new OptionalMethod<>(null, "setHostname", String.class);
            GET_ALPN_SELECTED_PROTOCOL = new OptionalMethod<>(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
            SET_ALPN_PROTOCOLS = new OptionalMethod<>(null, "setAlpnProtocols", byte[].class);
            GET_NPN_SELECTED_PROTOCOL = new OptionalMethod<>(byte[].class, "getNpnSelectedProtocol", new Class[0]);
            SET_NPN_PROTOCOLS = new OptionalMethod<>(null, "setNpnProtocols", byte[].class);
            try {
                method2 = SSLParameters.class.getMethod("setApplicationProtocols", String[].class);
                try {
                    method = SSLParameters.class.getMethod("getApplicationProtocols", new Class[0]);
                } catch (ClassNotFoundException e2) {
                    e = e2;
                    method = null;
                    method3 = null;
                } catch (NoSuchMethodException e10) {
                    e = e10;
                    method = null;
                    method3 = null;
                }
            } catch (ClassNotFoundException e11) {
                e = e11;
                method = null;
                method2 = null;
                method3 = null;
            } catch (NoSuchMethodException e12) {
                e = e12;
                method = null;
                method2 = null;
                method3 = null;
            }
            try {
                method3 = SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]);
                try {
                    Class<?> cls2 = Class.forName("android.net.ssl.SSLSockets");
                    method4 = cls2.getMethod("isSupportedSocket", SSLSocket.class);
                    try {
                        method5 = cls2.getMethod("setUseSessionTickets", SSLSocket.class, cls);
                    } catch (ClassNotFoundException e13) {
                        e = e13;
                        OkHttpProtocolNegotiator.logger.log(Level.FINER, "Failed to find Android 10.0+ APIs", (Throwable) e);
                        method5 = null;
                        SET_APPLICATION_PROTOCOLS = method2;
                        GET_APPLICATION_PROTOCOLS = method;
                        GET_APPLICATION_PROTOCOL = method3;
                        SSL_SOCKETS_IS_SUPPORTED_SOCKET = method4;
                        SSL_SOCKETS_SET_USE_SESSION_TICKET = method5;
                        method6 = SSLParameters.class.getMethod("setServerNames", List.class);
                        try {
                            constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                        } catch (ClassNotFoundException e14) {
                            e = e14;
                            OkHttpProtocolNegotiator.logger.log(Level.FINER, "Failed to find Android 7.0+ APIs", (Throwable) e);
                            SET_SERVER_NAMES = method6;
                            SNI_HOST_NAME = constructor;
                        } catch (NoSuchMethodException e15) {
                            e = e15;
                            OkHttpProtocolNegotiator.logger.log(Level.FINER, "Failed to find Android 7.0+ APIs", (Throwable) e);
                            SET_SERVER_NAMES = method6;
                            SNI_HOST_NAME = constructor;
                        }
                        SET_SERVER_NAMES = method6;
                        SNI_HOST_NAME = constructor;
                    } catch (NoSuchMethodException e16) {
                        e = e16;
                        OkHttpProtocolNegotiator.logger.log(Level.FINER, "Failed to find Android 10.0+ APIs", (Throwable) e);
                        method5 = null;
                        SET_APPLICATION_PROTOCOLS = method2;
                        GET_APPLICATION_PROTOCOLS = method;
                        GET_APPLICATION_PROTOCOL = method3;
                        SSL_SOCKETS_IS_SUPPORTED_SOCKET = method4;
                        SSL_SOCKETS_SET_USE_SESSION_TICKET = method5;
                        method6 = SSLParameters.class.getMethod("setServerNames", List.class);
                        constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                        SET_SERVER_NAMES = method6;
                        SNI_HOST_NAME = constructor;
                    }
                } catch (ClassNotFoundException e17) {
                    e = e17;
                    method4 = null;
                } catch (NoSuchMethodException e18) {
                    e = e18;
                    method4 = null;
                }
            } catch (ClassNotFoundException e19) {
                e = e19;
                method3 = null;
                method4 = method3;
                OkHttpProtocolNegotiator.logger.log(Level.FINER, "Failed to find Android 10.0+ APIs", (Throwable) e);
                method5 = null;
                SET_APPLICATION_PROTOCOLS = method2;
                GET_APPLICATION_PROTOCOLS = method;
                GET_APPLICATION_PROTOCOL = method3;
                SSL_SOCKETS_IS_SUPPORTED_SOCKET = method4;
                SSL_SOCKETS_SET_USE_SESSION_TICKET = method5;
                method6 = SSLParameters.class.getMethod("setServerNames", List.class);
                constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                SET_SERVER_NAMES = method6;
                SNI_HOST_NAME = constructor;
            } catch (NoSuchMethodException e20) {
                e = e20;
                method3 = null;
                method4 = method3;
                OkHttpProtocolNegotiator.logger.log(Level.FINER, "Failed to find Android 10.0+ APIs", (Throwable) e);
                method5 = null;
                SET_APPLICATION_PROTOCOLS = method2;
                GET_APPLICATION_PROTOCOLS = method;
                GET_APPLICATION_PROTOCOL = method3;
                SSL_SOCKETS_IS_SUPPORTED_SOCKET = method4;
                SSL_SOCKETS_SET_USE_SESSION_TICKET = method5;
                method6 = SSLParameters.class.getMethod("setServerNames", List.class);
                constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                SET_SERVER_NAMES = method6;
                SNI_HOST_NAME = constructor;
            }
            SET_APPLICATION_PROTOCOLS = method2;
            GET_APPLICATION_PROTOCOLS = method;
            GET_APPLICATION_PROTOCOL = method3;
            SSL_SOCKETS_IS_SUPPORTED_SOCKET = method4;
            SSL_SOCKETS_SET_USE_SESSION_TICKET = method5;
            try {
                method6 = SSLParameters.class.getMethod("setServerNames", List.class);
                constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
            } catch (ClassNotFoundException e21) {
                e = e21;
                method6 = null;
            } catch (NoSuchMethodException e22) {
                e = e22;
                method6 = null;
            }
            SET_SERVER_NAMES = method6;
            SNI_HOST_NAME = constructor;
        }

        public AndroidNegotiator(Platform platform) {
            super(platform);
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x00bf  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x00ce  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x00d4  */
        @Override // io.grpc.okhttp.OkHttpProtocolNegotiator
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void configureTlsExtensions(javax.net.ssl.SSLSocket r9, java.lang.String r10, java.util.List<io.grpc.okhttp.internal.Protocol> r11) {
            /*
                Method dump skipped, instructions count: 241
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.okhttp.OkHttpProtocolNegotiator.AndroidNegotiator.configureTlsExtensions(javax.net.ssl.SSLSocket, java.lang.String, java.util.List):void");
        }

        @Override // io.grpc.okhttp.OkHttpProtocolNegotiator
        public String getSelectedProtocol(SSLSocket sSLSocket) {
            Method method = GET_APPLICATION_PROTOCOL;
            if (method != null) {
                try {
                    return (String) method.invoke(sSLSocket, new Object[0]);
                } catch (IllegalAccessException e2) {
                    throw new RuntimeException(e2);
                } catch (InvocationTargetException e10) {
                    if (e10.getTargetException() instanceof UnsupportedOperationException) {
                        OkHttpProtocolNegotiator.logger.log(Level.FINER, "Socket unsupported for getApplicationProtocol, will try old methods");
                    } else {
                        throw new RuntimeException(e10);
                    }
                }
            }
            if (this.platform.getTlsExtensionType() == Platform.TlsExtensionType.ALPN_AND_NPN) {
                try {
                    byte[] bArr = (byte[]) GET_ALPN_SELECTED_PROTOCOL.invokeWithoutCheckedException(sSLSocket, new Object[0]);
                    if (bArr != null) {
                        return new String(bArr, Util.UTF_8);
                    }
                } catch (Exception e11) {
                    OkHttpProtocolNegotiator.logger.log(Level.FINE, "Failed calling getAlpnSelectedProtocol()", (Throwable) e11);
                }
            }
            if (this.platform.getTlsExtensionType() == Platform.TlsExtensionType.NONE) {
                return null;
            }
            try {
                byte[] bArr2 = (byte[]) GET_NPN_SELECTED_PROTOCOL.invokeWithoutCheckedException(sSLSocket, new Object[0]);
                if (bArr2 != null) {
                    return new String(bArr2, Util.UTF_8);
                }
                return null;
            } catch (Exception e12) {
                OkHttpProtocolNegotiator.logger.log(Level.FINE, "Failed calling getNpnSelectedProtocol()", (Throwable) e12);
                return null;
            }
        }

        @Override // io.grpc.okhttp.OkHttpProtocolNegotiator
        public String negotiate(SSLSocket sSLSocket, String str, List<Protocol> list) throws IOException {
            String selectedProtocol = getSelectedProtocol(sSLSocket);
            return selectedProtocol == null ? super.negotiate(sSLSocket, str, list) : selectedProtocol;
        }
    }

    public OkHttpProtocolNegotiator(Platform platform) {
        this.platform = (Platform) o.s(platform, Constants.PARAM_PLATFORM);
    }

    public static OkHttpProtocolNegotiator createNegotiator(ClassLoader classLoader) {
        boolean z10;
        try {
            classLoader.loadClass("com.android.org.conscrypt.OpenSSLSocketImpl");
        } catch (ClassNotFoundException e2) {
            logger.log(Level.FINE, "Unable to find Conscrypt. Skipping", (Throwable) e2);
            try {
                classLoader.loadClass("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl");
            } catch (ClassNotFoundException e10) {
                logger.log(Level.FINE, "Unable to find any OpenSSLSocketImpl. Skipping", (Throwable) e10);
                z10 = false;
            }
        }
        z10 = true;
        if (z10) {
            return new AndroidNegotiator(DEFAULT_PLATFORM);
        }
        return new OkHttpProtocolNegotiator(DEFAULT_PLATFORM);
    }

    public static OkHttpProtocolNegotiator get() {
        return NEGOTIATOR;
    }

    public static boolean isValidHostName(String str) {
        if (str.contains("_")) {
            return false;
        }
        try {
            GrpcUtil.checkAuthority(str);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String[] protocolIds(List<Protocol> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<Protocol> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(iterator2.next().toString());
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
        this.platform.configureTlsExtensions(sSLSocket, str, list);
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        return this.platform.getSelectedProtocol(sSLSocket);
    }

    public String negotiate(SSLSocket sSLSocket, String str, List<Protocol> list) throws IOException {
        if (list != null) {
            configureTlsExtensions(sSLSocket, str, list);
        }
        try {
            sSLSocket.startHandshake();
            String selectedProtocol = getSelectedProtocol(sSLSocket);
            if (selectedProtocol != null) {
                return selectedProtocol;
            }
            throw new RuntimeException("TLS ALPN negotiation failed with protocols: " + ((Object) list));
        } finally {
            this.platform.afterHandshake(sSLSocket);
        }
    }
}
