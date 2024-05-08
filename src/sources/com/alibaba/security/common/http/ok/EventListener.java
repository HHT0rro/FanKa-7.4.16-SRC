package com.alibaba.security.common.http.ok;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class EventListener {
    public static final EventListener NONE = new EventListener() { // from class: com.alibaba.security.common.http.ok.EventListener.1
    };

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface Factory {
        EventListener create(RPCall rPCall);
    }

    public static Factory factory(EventListener eventListener) {
        return new Factory() { // from class: com.alibaba.security.common.http.ok.EventListener.2
            @Override // com.alibaba.security.common.http.ok.EventListener.Factory
            public EventListener create(RPCall rPCall) {
                return EventListener.this;
            }
        };
    }

    public void callEnd(RPCall rPCall) {
    }

    public void callFailed(RPCall rPCall, IOException iOException) {
    }

    public void callStart(RPCall rPCall) {
    }

    public void connectEnd(RPCall rPCall, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
    }

    public void connectFailed(RPCall rPCall, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
    }

    public void connectStart(RPCall rPCall, InetSocketAddress inetSocketAddress, Proxy proxy) {
    }

    public void connectionAcquired(RPCall rPCall, Connection connection) {
    }

    public void connectionReleased(RPCall rPCall, Connection connection) {
    }

    public void dnsEnd(RPCall rPCall, String str, List<InetAddress> list) {
    }

    public void dnsStart(RPCall rPCall, String str) {
    }

    public void requestBodyEnd(RPCall rPCall, long j10) {
    }

    public void requestBodyStart(RPCall rPCall) {
    }

    public void requestHeadersEnd(RPCall rPCall, RPRequest rPRequest) {
    }

    public void requestHeadersStart(RPCall rPCall) {
    }

    public void responseBodyEnd(RPCall rPCall, long j10) {
    }

    public void responseBodyStart(RPCall rPCall) {
    }

    public void responseHeadersEnd(RPCall rPCall, Response response) {
    }

    public void responseHeadersStart(RPCall rPCall) {
    }

    public void secureConnectEnd(RPCall rPCall, Handshake handshake) {
    }

    public void secureConnectStart(RPCall rPCall) {
    }
}
