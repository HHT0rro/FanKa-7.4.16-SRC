package com.tencent.cloud.huiyansdkface.okhttp3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class EventListener {

    /* renamed from: a, reason: collision with root package name */
    public static final EventListener f41398a = new EventListener() { // from class: com.tencent.cloud.huiyansdkface.okhttp3.EventListener.1
    };

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface Factory {
        EventListener create(Call call);
    }

    public static Factory a(EventListener eventListener) {
        return new Factory() { // from class: com.tencent.cloud.huiyansdkface.okhttp3.EventListener.2
            @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener.Factory
            public EventListener create(Call call) {
                return EventListener.this;
            }
        };
    }

    public void callEnd(Call call) {
    }

    public void callFailed(Call call, IOException iOException) {
    }

    public void callStart(Call call) {
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
    }

    public void connectionAcquired(Call call, Connection connection) {
    }

    public void connectionReleased(Call call, Connection connection) {
    }

    public void dnsEnd(Call call, String str, List<InetAddress> list) {
    }

    public void dnsStart(Call call, String str) {
    }

    public void requestBodyEnd(Call call, long j10) {
    }

    public void requestBodyStart(Call call) {
    }

    public void requestHeadersEnd(Call call, Request request) {
    }

    public void requestHeadersStart(Call call) {
    }

    public void responseBodyEnd(Call call, long j10) {
    }

    public void responseBodyStart(Call call) {
    }

    public void responseHeadersEnd(Call call, Response response) {
    }

    public void responseHeadersStart(Call call) {
    }

    public void secureConnectEnd(Call call, Handshake handshake) {
    }

    public void secureConnectStart(Call call) {
    }
}
