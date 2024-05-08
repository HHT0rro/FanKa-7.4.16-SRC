package com.tencent.cloud.huiyansdkface.wehttp2;

import com.tencent.cloud.huiyansdkface.okhttp3.Call;
import com.tencent.cloud.huiyansdkface.okhttp3.Connection;
import com.tencent.cloud.huiyansdkface.okhttp3.EventListener;
import com.tencent.cloud.huiyansdkface.okhttp3.Handshake;
import com.tencent.cloud.huiyansdkface.okhttp3.Protocol;
import com.tencent.cloud.huiyansdkface.okhttp3.Request;
import com.tencent.cloud.huiyansdkface.okhttp3.Response;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ReportEventListener extends EventListener {

    /* renamed from: b, reason: collision with root package name */
    private Map<Request, EventReport> f42299b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private EventReportFactory f42300c;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface EventReportFactory {
        EventReport create(Request request);
    }

    public ReportEventListener(EventReportFactory eventReportFactory) {
        this.f42300c = eventReportFactory;
    }

    private EventReport a(Call call) {
        return this.f42299b.get(call.request());
    }

    private void b(Call call) {
        this.f42299b.remove(call);
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void callEnd(Call call) {
        EventReport a10 = a(call);
        if (a10 != null) {
            a10.callEnd();
            b(call);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void callFailed(Call call, IOException iOException) {
        EventReport a10 = a(call);
        if (a10 != null) {
            a10.callFailed(iOException);
            b(call);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void callStart(Call call) {
        if (a(call) == null) {
            EventReport create = this.f42300c.create(call.request());
            create.callStart();
            this.f42299b.put(call.request(), create);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        EventReport a10 = a(call);
        if (a10 != null) {
            a10.connectEnd(protocol == null ? "" : protocol.name());
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        EventReport a10 = a(call);
        if (a10 != null) {
            a10.connectFailed(protocol == null ? "" : protocol.name(), iOException);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        EventReport a10 = a(call);
        if (a10 != null) {
            a10.connectStart(inetSocketAddress, proxy);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void connectionAcquired(Call call, Connection connection) {
        EventReport a10 = a(call);
        if (a10 != null) {
            a10.connectionAcquired();
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void connectionReleased(Call call, Connection connection) {
        EventReport a10 = a(call);
        if (a10 != null) {
            a10.connectionReleased();
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        EventReport a10 = a(call);
        if (a10 != null) {
            a10.dnsEnd(list);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void dnsStart(Call call, String str) {
        EventReport a10 = a(call);
        if (a10 != null) {
            a10.dnsStart(str);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void requestBodyEnd(Call call, long j10) {
        EventReport a10 = a(call);
        if (a10 != null) {
            a10.requestBodyEnd(j10);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void requestBodyStart(Call call) {
        EventReport a10 = a(call);
        if (a10 != null) {
            a10.requestBodyStart();
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void requestHeadersEnd(Call call, Request request) {
        EventReport a10 = a(call);
        if (a10 != null) {
            a10.requestHeadersEnd();
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void requestHeadersStart(Call call) {
        EventReport a10 = a(call);
        if (a10 != null) {
            a10.requestHeadersStart();
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void responseBodyEnd(Call call, long j10) {
        EventReport a10 = a(call);
        if (a10 != null) {
            a10.responseBodyEnd(j10);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void responseBodyStart(Call call) {
        EventReport a10 = a(call);
        if (a10 != null) {
            a10.responseBodyStart();
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void responseHeadersEnd(Call call, Response response) {
        EventReport a10 = a(call);
        if (a10 != null) {
            a10.responseHeadersEnd(response.code(), response.message(), response.receivedResponseAtMillis(), response.sentRequestAtMillis());
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void responseHeadersStart(Call call) {
        EventReport a10 = a(call);
        if (a10 != null) {
            a10.responseHeadersStart();
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void secureConnectEnd(Call call, Handshake handshake) {
        EventReport a10 = a(call);
        if (a10 != null) {
            a10.secureConnectEnd(handshake.tlsVersion().javaName(), handshake.cipherSuite().javaName(), handshake.localPrincipal(), handshake.peerPrincipal(), handshake.localCertificates(), handshake.peerCertificates());
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void secureConnectStart(Call call) {
        EventReport a10 = a(call);
        if (a10 != null) {
            a10.secureConnectStart();
        }
    }
}
