package com.tencent.liteav.base.util;

import android.net.SSLCertificateSocketFactory;
import com.alibaba.security.realidentity.build.cs;
import com.tencent.liteav.base.Log;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private static Pattern f42882a;

    /* renamed from: b, reason: collision with root package name */
    private static final List<String> f42883b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a extends SSLSocketFactory {

        /* renamed from: a, reason: collision with root package name */
        private HttpsURLConnection f42885a;

        public a(HttpsURLConnection httpsURLConnection) {
            this.f42885a = httpsURLConnection;
        }

        @Override // javax.net.SocketFactory
        public final Socket createSocket() throws IOException {
            return null;
        }

        @Override // javax.net.SocketFactory
        public final Socket createSocket(String str, int i10) throws IOException, UnknownHostException {
            return null;
        }

        @Override // javax.net.SocketFactory
        public final Socket createSocket(String str, int i10, InetAddress inetAddress, int i11) throws IOException, UnknownHostException {
            return null;
        }

        @Override // javax.net.SocketFactory
        public final Socket createSocket(InetAddress inetAddress, int i10) throws IOException {
            return null;
        }

        @Override // javax.net.SocketFactory
        public final Socket createSocket(InetAddress inetAddress, int i10, InetAddress inetAddress2, int i11) throws IOException {
            return null;
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public final Socket createSocket(Socket socket, String str, int i10, boolean z10) throws IOException {
            String requestProperty = this.f42885a.getRequestProperty(cs.U);
            if (requestProperty != null) {
                str = requestProperty;
            }
            InetAddress inetAddress = socket.getInetAddress();
            if (z10) {
                socket.close();
            }
            SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0);
            SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(inetAddress, i10);
            sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
            LiteavLog.i("HttpDnsUtil", "Setting SNI hostname");
            sSLCertificateSocketFactory.setHostname(sSLSocket, str);
            SSLSession session = sSLSocket.getSession();
            if (HttpsURLConnection.getDefaultHostnameVerifier().verify(str, session)) {
                LiteavLog.i("HttpDnsUtil", "Established " + session.getProtocol() + " connection with " + session.getPeerHost() + " using " + session.getCipherSuite());
                return sSLSocket;
            }
            throw new SSLPeerUnverifiedException("Cannot verify hostname: ".concat(String.valueOf(str)));
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public final String[] getDefaultCipherSuites() {
            return new String[0];
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public final String[] getSupportedCipherSuites() {
            return new String[0];
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        f42883b = arrayList;
        arrayList.add("intl-sdklog.trtc.tencent-cloud.com");
        arrayList.add("trtc-client-log-overseas-1258344699.cos.ap-singapore.myqcloud.com");
        arrayList.add("inland-sdklog.trtc.tencent-cloud.com");
        arrayList.add("trtc-sdk-log-1258344699.cos.ap-guangzhou.myqcloud.com");
        arrayList.add("trtc-sdk-config-1258344699.file.myqcloud.com");
        arrayList.add("liteav.sdk.qcloud.com");
        arrayList.add("yun.tim.qq.com");
        arrayList.add("videoapi-sgp.im.qcloud.com");
        arrayList.add("sdkdc.live.qcloud.com");
        arrayList.add("mlvbdc.live.qcloud.com");
        arrayList.add("conf.sdk.qcloud.com");
        arrayList.add("speedtestint.trtc.tencent-cloud.com");
        arrayList.add("speedtest.trtc.tencent-cloud.com");
        arrayList.add("webrtc-signal-scheduler.tlivesource.com");
        arrayList.add("cloud.tim.qq.com");
        arrayList.add("livepull.myqcloud.com");
        arrayList.add("livepullipv6.myqcloud.com");
        arrayList.add("tcdns.myqcloud.com");
        arrayList.add("tcdnsipv6.myqcloud.com");
        arrayList.add("liteavapp.qcloud.com");
        arrayList.add("license.vod2.myqcloud.com");
        arrayList.add("license-test.vod2.myqcloud.com");
        arrayList.add("drm.vod2.myqcloud.com");
        arrayList.add("sdkconfig.tlivesource.com");
        arrayList.add("mlvbdc.live.tlivesource.com");
    }

    public static boolean a(String str) {
        return f42883b.contains(str);
    }

    public static boolean b(String str) {
        if (str != null && !"".equals(str)) {
            if (f42882a == null) {
                try {
                    f42882a = Pattern.compile("(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])", 2);
                } catch (Exception e2) {
                    LiteavLog.e("HttpDnsUtil", "Pattern.compile fail " + Log.getStackTraceString(e2));
                    return false;
                }
            }
            if (f42882a.matcher(str).matches() || str.contains(com.huawei.openalliance.ad.constant.u.bD)) {
                return true;
            }
        }
        return false;
    }

    public static void a(HttpURLConnection httpURLConnection, final String str) {
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            httpsURLConnection.setSSLSocketFactory(new a(httpsURLConnection));
            httpsURLConnection.setHostnameVerifier(new HostnameVerifier() { // from class: com.tencent.liteav.base.util.g.1
                @Override // javax.net.ssl.HostnameVerifier
                public final boolean verify(String str2, SSLSession sSLSession) {
                    return HttpsURLConnection.getDefaultHostnameVerifier().verify(String.this, sSLSession);
                }
            });
        }
    }
}
