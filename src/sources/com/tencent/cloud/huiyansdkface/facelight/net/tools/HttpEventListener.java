package com.tencent.cloud.huiyansdkface.facelight.net.tools;

import androidx.annotation.Nullable;
import com.cupidapp.live.liveshow.beauty.databeauty.UserData;
import com.huawei.openalliance.ad.constant.u;
import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cloud.huiyansdkface.okhttp3.Call;
import com.tencent.cloud.huiyansdkface.okhttp3.Connection;
import com.tencent.cloud.huiyansdkface.okhttp3.EventListener;
import com.tencent.cloud.huiyansdkface.okhttp3.Handshake;
import com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl;
import com.tencent.cloud.huiyansdkface.okhttp3.Protocol;
import com.tencent.cloud.huiyansdkface.okhttp3.Request;
import com.tencent.cloud.huiyansdkface.okhttp3.Response;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class HttpEventListener extends EventListener {
    public static final EventListener.Factory FACTORY = new EventListener.Factory() { // from class: com.tencent.cloud.huiyansdkface.facelight.net.tools.HttpEventListener.1

        /* renamed from: a, reason: collision with root package name */
        public final AtomicLong f40705a = new AtomicLong(1);

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener.Factory
        public EventListener create(Call call) {
            long andIncrement = this.f40705a.getAndIncrement();
            String encodedPath = call.request().url().encodedPath();
            return (encodedPath.contains("Login") || encodedPath.contains(UserData.RESOURCE_READY) || encodedPath.contains("Resource") || encodedPath.contains("facecompare") || encodedPath.contains("Facecompare") || encodedPath.contains("faceCompare") || encodedPath.contains("appupload") || encodedPath.contains("appUpload") || encodedPath.contains("uploadData") || encodedPath.contains("WbGradeInfo.json")) ? new HttpEventListener(true, andIncrement, call.request().url(), System.nanoTime()) : new HttpEventListener(false, andIncrement, call.request().url(), System.nanoTime());
        }
    };
    private static final String TAG = "HttpEventListener";
    private final long callId;
    private final long callStartNanos;
    private boolean isNeedRecord;
    private StringBuilder sbLog;

    public HttpEventListener(boolean z10, long j10, HttpUrl httpUrl, long j11) {
        this.isNeedRecord = z10;
        this.callId = j10;
        this.callStartNanos = j11;
        StringBuilder sb2 = new StringBuilder(httpUrl.encodedPath());
        sb2.append(" ");
        sb2.append(j10);
        sb2.append(u.bD);
        this.sbLog = sb2;
    }

    private void recordEventLog(String str) {
        if (this.isNeedRecord) {
            long nanoTime = System.nanoTime() - this.callStartNanos;
            StringBuilder sb2 = this.sbLog;
            sb2.append(String.format(Locale.CHINA, "%.3f-%s", Double.valueOf(nanoTime / 1.0E9d), str));
            sb2.append(";");
            if ("callEnd".equalsIgnoreCase(str) || "callFailed".equalsIgnoreCase(str)) {
                WLogger.i(TAG, this.sbLog.toString());
                KycWaSDK.getInstance().trackCustomKVEvent(null, "face_service_http_event", this.sbLog.toString(), null);
            }
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void callEnd(Call call) {
        super.callEnd(call);
        recordEventLog("callEnd");
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void callFailed(Call call, IOException iOException) {
        super.callFailed(call, iOException);
        recordEventLog("callFailed");
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void callStart(Call call) {
        super.callStart(call);
        recordEventLog("callStart");
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable Protocol protocol) {
        super.connectEnd(call, inetSocketAddress, proxy, protocol);
        recordEventLog("connectEnd");
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable Protocol protocol, IOException iOException) {
        super.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
        String str = "";
        String hostAddress = (inetSocketAddress == null || inetSocketAddress.getAddress() == null) ? "" : inetSocketAddress.getAddress().getHostAddress();
        recordEventLog("connectFailed:" + hostAddress);
        if (this.isNeedRecord) {
            if (iOException != null) {
                iOException.printStackTrace();
                str = iOException.toString();
            }
            String encodedPath = call.request().url().encodedPath();
            Properties properties = new Properties();
            properties.setProperty("path", encodedPath);
            properties.setProperty("ipInfo", hostAddress);
            properties.setProperty("errorMsg", str);
            KycWaSDK.getInstance().trackIMSWarnVEvent(null, "faceservice_http_connect_failed", null, properties);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        super.connectStart(call, inetSocketAddress, proxy);
        String hostAddress = (inetSocketAddress == null || inetSocketAddress.getAddress() == null) ? "" : inetSocketAddress.getAddress().getHostAddress();
        recordEventLog("connectStart:" + hostAddress);
        WLogger.d(TAG, "connectStart:" + hostAddress);
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void connectionAcquired(Call call, Connection connection) {
        super.connectionAcquired(call, connection);
        recordEventLog("connectionAcquired");
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void connectionReleased(Call call, Connection connection) {
        super.connectionReleased(call, connection);
        recordEventLog("connectionReleased");
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        super.dnsEnd(call, str, list);
        recordEventLog("dnsEnd");
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void dnsStart(Call call, String str) {
        super.dnsStart(call, str);
        recordEventLog("dnsStart:" + str);
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void requestBodyEnd(Call call, long j10) {
        super.requestBodyEnd(call, j10);
        recordEventLog("requestBodyEnd:" + j10);
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void requestBodyStart(Call call) {
        super.requestBodyStart(call);
        recordEventLog("requestBodyStart");
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void requestHeadersEnd(Call call, Request request) {
        super.requestHeadersEnd(call, request);
        recordEventLog("requestHeadersEnd");
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void requestHeadersStart(Call call) {
        super.requestHeadersStart(call);
        recordEventLog("requestHeadersStart");
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void responseBodyEnd(Call call, long j10) {
        super.responseBodyEnd(call, j10);
        recordEventLog("responseBodyEnd");
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void responseBodyStart(Call call) {
        super.responseBodyStart(call);
        recordEventLog("responseBodyStart");
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void responseHeadersEnd(Call call, Response response) {
        super.responseHeadersEnd(call, response);
        recordEventLog("responseHeadersEnd");
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void responseHeadersStart(Call call) {
        super.responseHeadersStart(call);
        recordEventLog("responseHeadersStart");
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void secureConnectEnd(Call call, @Nullable Handshake handshake) {
        super.secureConnectEnd(call, handshake);
        recordEventLog("secureConnectEnd:" + ((Object) handshake.tlsVersion()));
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void secureConnectStart(Call call) {
        super.secureConnectStart(call);
        recordEventLog("secureConnectStart");
    }
}
