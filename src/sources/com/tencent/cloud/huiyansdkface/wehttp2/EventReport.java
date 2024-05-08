package com.tencent.cloud.huiyansdkface.wehttp2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface EventReport {
    void callEnd();

    void callFailed(IOException iOException);

    void callStart();

    void connectEnd(String str);

    void connectFailed(String str, IOException iOException);

    void connectStart(InetSocketAddress inetSocketAddress, Proxy proxy);

    void connectionAcquired();

    void connectionReleased();

    void dnsEnd(List<InetAddress> list);

    void dnsStart(String str);

    void requestBodyEnd(long j10);

    void requestBodyStart();

    void requestHeadersEnd();

    void requestHeadersStart();

    void responseBodyEnd(long j10);

    void responseBodyStart();

    void responseHeadersEnd(int i10, String str, long j10, long j11);

    void responseHeadersStart();

    void secureConnectEnd(String str, String str2, Principal principal, Principal principal2, List<Certificate> list, List<Certificate> list2);

    void secureConnectStart();
}
