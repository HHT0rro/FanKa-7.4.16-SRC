package com.tencent.cloud.huiyansdkface.wehttp2;

import com.huawei.openalliance.ad.constant.u;
import com.tencent.cloud.huiyansdkface.okhttp3.Request;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.security.Principal;
import java.security.cert.Certificate;
import java.text.SimpleDateFormat;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WeEventReport implements EventReport {

    /* renamed from: a, reason: collision with root package name */
    private final SimpleDateFormat f42363a = new SimpleDateFormat("mm:ss.SSS");

    /* renamed from: b, reason: collision with root package name */
    private final StringBuilder f42364b = new StringBuilder();

    /* renamed from: c, reason: collision with root package name */
    private final TimePointInfo f42365c = new TimePointInfo();

    /* renamed from: d, reason: collision with root package name */
    private final ReportCallback f42366d;

    /* renamed from: e, reason: collision with root package name */
    private Request f42367e;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface ReportCallback {
        void reportFinish(TimePointInfo timePointInfo, StringBuilder sb2);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TimePointInfo {

        /* renamed from: a, reason: collision with root package name */
        private long f42368a;

        /* renamed from: b, reason: collision with root package name */
        private long f42369b;

        /* renamed from: c, reason: collision with root package name */
        private long f42370c;

        /* renamed from: d, reason: collision with root package name */
        private long f42371d;

        /* renamed from: e, reason: collision with root package name */
        private long f42372e;

        /* renamed from: f, reason: collision with root package name */
        private long f42373f;

        /* renamed from: g, reason: collision with root package name */
        private long f42374g;

        /* renamed from: h, reason: collision with root package name */
        private long f42375h;

        /* renamed from: i, reason: collision with root package name */
        private long f42376i;

        /* renamed from: j, reason: collision with root package name */
        private long f42377j;

        /* renamed from: k, reason: collision with root package name */
        private long f42378k;

        /* renamed from: l, reason: collision with root package name */
        private long f42379l;

        /* renamed from: m, reason: collision with root package name */
        private int f42380m;

        /* renamed from: n, reason: collision with root package name */
        private int f42381n;

        public static /* synthetic */ int b(TimePointInfo timePointInfo) {
            int i10 = timePointInfo.f42380m;
            timePointInfo.f42380m = i10 + 1;
            return i10;
        }

        public static /* synthetic */ int e(TimePointInfo timePointInfo) {
            int i10 = timePointInfo.f42381n;
            timePointInfo.f42381n = i10 + 1;
            return i10;
        }

        public long getCallUseTime() {
            return this.f42379l;
        }

        public long getConnectStart() {
            return this.f42370c;
        }

        public int getConnectStartCount() {
            return this.f42381n;
        }

        public long getConnectUseTime() {
            return this.f42375h;
        }

        public long getDnsStart() {
            return this.f42369b;
        }

        public int getDnsStartCount() {
            return this.f42380m;
        }

        public long getDnsUseTime() {
            return this.f42374g;
        }

        public long getReqStart() {
            return this.f42372e;
        }

        public long getReqUseTime() {
            return this.f42377j;
        }

        public long getRespStart() {
            return this.f42373f;
        }

        public long getRespUseTime() {
            return this.f42378k;
        }

        public long getSecureConnectStart() {
            return this.f42371d;
        }

        public long getSecureConnectUseTime() {
            return this.f42376i;
        }

        public long getStartTime() {
            return this.f42368a;
        }
    }

    public WeEventReport(Request request, ReportCallback reportCallback) {
        this.f42367e = request;
        this.f42366d = reportCallback;
    }

    private String a(long j10) {
        return this.f42363a.format(Long.valueOf(j10));
    }

    private void a() {
        this.f42365c.f42379l = System.currentTimeMillis() - this.f42365c.f42368a;
        StringBuilder sb2 = this.f42364b;
        sb2.insert(sb2.indexOf("]]]"), "(" + this.f42365c.f42379l + ")");
    }

    private void a(List<InetAddress> list, StringBuilder sb2) {
        if (list == null || list.size() <= 0) {
            sb2.append("NONE");
            return;
        }
        int size = list.size();
        for (int i10 = 0; i10 < size - 1; i10++) {
            sb2.append(list.get(i10).toString());
            sb2.append(",");
        }
        sb2.append((Object) list.get(list.size() - 1));
    }

    private String b() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(Long.valueOf(System.currentTimeMillis()));
    }

    private String b(long j10) {
        return this.f42363a.format(Long.valueOf(j10));
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.EventReport
    public void callEnd() {
        StringBuilder sb2 = this.f42364b;
        sb2.append(a(System.currentTimeMillis()));
        sb2.append(":callEnd\n");
        a();
        this.f42364b.append("Statistical data：\n");
        StringBuilder sb3 = this.f42364b;
        sb3.append("\tdnsUseTime:");
        sb3.append(this.f42365c.f42374g);
        sb3.append("\n");
        StringBuilder sb4 = this.f42364b;
        sb4.append("\tsecureConnectUseTime:");
        sb4.append(this.f42365c.f42376i);
        sb4.append("\n");
        StringBuilder sb5 = this.f42364b;
        sb5.append("\tconnectUseTime:");
        sb5.append(this.f42365c.f42375h);
        sb5.append("\n");
        StringBuilder sb6 = this.f42364b;
        sb6.append("\treqUseTime:");
        sb6.append(this.f42365c.f42377j);
        sb6.append("\n");
        StringBuilder sb7 = this.f42364b;
        sb7.append("\trespUseTime:");
        sb7.append(this.f42365c.f42378k);
        sb7.append("\n");
        StringBuilder sb8 = this.f42364b;
        sb8.append("\ttotalUseTime:");
        sb8.append(this.f42365c.f42379l);
        sb8.append("\n");
        ReportCallback reportCallback = this.f42366d;
        if (reportCallback != null) {
            reportCallback.reportFinish(this.f42365c, this.f42364b);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.EventReport
    public void callFailed(IOException iOException) {
        StringBuilder sb2 = this.f42364b;
        sb2.append(a(System.currentTimeMillis()));
        sb2.append(":callFailed:");
        sb2.append((Object) iOException);
        sb2.append("\n");
        a();
        ReportCallback reportCallback = this.f42366d;
        if (reportCallback != null) {
            reportCallback.reportFinish(this.f42365c, this.f42364b);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.EventReport
    public void callStart() {
        this.f42365c.f42368a = System.currentTimeMillis();
        StringBuilder sb2 = this.f42364b;
        sb2.append("WeHttp Log: \n[[[");
        sb2.append(b());
        sb2.append("\t");
        sb2.append(this.f42367e.url().toString());
        sb2.append("]]]\n");
        LogTag logTag = (LogTag) this.f42367e.tag(LogTag.class);
        if (logTag != null && logTag.getTag() != null) {
            StringBuilder sb3 = this.f42364b;
            sb3.append(logTag.getTag());
            sb3.append("\n");
        }
        StringBuilder sb4 = this.f42364b;
        sb4.append(a(this.f42365c.f42368a));
        sb4.append(":callStart\n");
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.EventReport
    public void connectEnd(String str) {
        if (!this.f42367e.isHttps()) {
            this.f42365c.f42375h = System.currentTimeMillis() - this.f42365c.f42370c;
        }
        StringBuilder sb2 = this.f42364b;
        sb2.append(a(System.currentTimeMillis()));
        sb2.append(":connectEnd(");
        sb2.append(this.f42365c.f42375h);
        sb2.append("):");
        sb2.append(str);
        sb2.append("\n");
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.EventReport
    public void connectFailed(String str, IOException iOException) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.f42367e.isHttps() || this.f42365c.f42375h <= 0) {
            TimePointInfo timePointInfo = this.f42365c;
            timePointInfo.f42375h = currentTimeMillis - timePointInfo.f42370c;
        }
        if (this.f42367e.isHttps() && this.f42365c.f42371d > 0 && this.f42365c.f42376i <= 0) {
            TimePointInfo timePointInfo2 = this.f42365c;
            timePointInfo2.f42376i = currentTimeMillis - timePointInfo2.f42371d;
        }
        StringBuilder sb2 = this.f42364b;
        sb2.append(a(currentTimeMillis));
        sb2.append(":connectFailed(");
        sb2.append(this.f42365c.f42375h);
        sb2.append("):");
        sb2.append(str);
        sb2.append(u.bD);
        sb2.append((Object) iOException);
        sb2.append("\n");
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.EventReport
    public void connectStart(InetSocketAddress inetSocketAddress, Proxy proxy) {
        TimePointInfo.e(this.f42365c);
        this.f42365c.f42370c = System.currentTimeMillis();
        StringBuilder sb2 = this.f42364b;
        sb2.append(a(this.f42365c.f42370c));
        sb2.append(":connectStart:");
        sb2.append(inetSocketAddress.toString());
        sb2.append(",");
        sb2.append(proxy.toString());
        sb2.append("\n");
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.EventReport
    public void connectionAcquired() {
        StringBuilder sb2 = this.f42364b;
        sb2.append(a(System.currentTimeMillis()));
        sb2.append(":connectionAcquired");
        sb2.append("\n");
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.EventReport
    public void connectionReleased() {
        StringBuilder sb2 = this.f42364b;
        sb2.append(a(System.currentTimeMillis()));
        sb2.append(":connectionReleased\n");
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.EventReport
    public void dnsEnd(List<InetAddress> list) {
        long currentTimeMillis = System.currentTimeMillis();
        TimePointInfo timePointInfo = this.f42365c;
        timePointInfo.f42374g = currentTimeMillis - timePointInfo.f42369b;
        StringBuilder sb2 = this.f42364b;
        sb2.append(a(currentTimeMillis));
        sb2.append(":dnsEnd(");
        sb2.append(this.f42365c.f42374g);
        sb2.append("):");
        a(list, this.f42364b);
        this.f42364b.append("\n");
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.EventReport
    public void dnsStart(String str) {
        TimePointInfo.b(this.f42365c);
        this.f42365c.f42369b = System.currentTimeMillis();
        StringBuilder sb2 = this.f42364b;
        sb2.append(a(this.f42365c.f42369b));
        sb2.append(":dnsStart:" + str);
        sb2.append("\n");
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.EventReport
    public void requestBodyEnd(long j10) {
        long currentTimeMillis = System.currentTimeMillis();
        TimePointInfo timePointInfo = this.f42365c;
        timePointInfo.f42377j = currentTimeMillis - timePointInfo.f42372e;
        StringBuilder sb2 = this.f42364b;
        sb2.append(a(currentTimeMillis));
        sb2.append(":requestBodyEnd(");
        sb2.append(this.f42365c.f42377j);
        sb2.append("):");
        sb2.append(j10);
        sb2.append("\n");
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.EventReport
    public void requestBodyStart() {
        StringBuilder sb2 = this.f42364b;
        sb2.append(a(System.currentTimeMillis()));
        sb2.append(":requestBodyStart\n");
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.EventReport
    public void requestHeadersEnd() {
        StringBuilder sb2 = this.f42364b;
        sb2.append(a(System.currentTimeMillis()));
        sb2.append(":requestHeadersEnd\n");
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.EventReport
    public void requestHeadersStart() {
        this.f42365c.f42372e = System.currentTimeMillis();
        StringBuilder sb2 = this.f42364b;
        sb2.append(a(this.f42365c.f42372e));
        sb2.append(":requestHeadersStart\n");
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.EventReport
    public void responseBodyEnd(long j10) {
        long currentTimeMillis = System.currentTimeMillis();
        TimePointInfo timePointInfo = this.f42365c;
        timePointInfo.f42378k = currentTimeMillis - timePointInfo.f42373f;
        StringBuilder sb2 = this.f42364b;
        sb2.append(a(currentTimeMillis));
        sb2.append(":responseBodyEnd(");
        sb2.append(this.f42365c.f42378k);
        sb2.append("):");
        sb2.append(j10);
        sb2.append("\n");
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.EventReport
    public void responseBodyStart() {
        StringBuilder sb2 = this.f42364b;
        sb2.append(a(System.currentTimeMillis()));
        sb2.append(":responseBodyStart\n");
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.EventReport
    public void responseHeadersEnd(int i10, String str, long j10, long j11) {
        StringBuilder sb2 = this.f42364b;
        sb2.append(a(System.currentTimeMillis()));
        sb2.append(":responseHeadersEnd:");
        sb2.append(i10);
        sb2.append(",");
        sb2.append(str);
        sb2.append(",");
        sb2.append(b(j10));
        sb2.append(",");
        sb2.append(b(j11));
        sb2.append("\n");
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.EventReport
    public void responseHeadersStart() {
        this.f42365c.f42373f = System.currentTimeMillis();
        StringBuilder sb2 = this.f42364b;
        sb2.append(a(this.f42365c.f42373f));
        sb2.append(":responseHeadersStart\n");
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.EventReport
    public void secureConnectEnd(String str, String str2, Principal principal, Principal principal2, List<Certificate> list, List<Certificate> list2) {
        long currentTimeMillis = System.currentTimeMillis();
        TimePointInfo timePointInfo = this.f42365c;
        timePointInfo.f42376i = currentTimeMillis - timePointInfo.f42371d;
        StringBuilder sb2 = this.f42364b;
        sb2.append(a(currentTimeMillis));
        sb2.append(":secureConnectEnd(");
        sb2.append(this.f42365c.f42376i);
        sb2.append("):");
        sb2.append(str);
        sb2.append(",");
        sb2.append(str2);
        sb2.append(",");
        sb2.append(principal != null ? principal.getName() : "none localPrincipal");
        sb2.append(",");
        sb2.append(principal2 != null ? principal2.getName() : "none peerPrincipal");
        sb2.append(",");
        sb2.append(list != null ? list.size() : 0);
        sb2.append(",");
        sb2.append(list2 != null ? list2.size() : 0);
        sb2.append("\n");
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.EventReport
    public void secureConnectStart() {
        this.f42365c.f42371d = System.currentTimeMillis();
        TimePointInfo timePointInfo = this.f42365c;
        timePointInfo.f42375h = timePointInfo.f42371d - this.f42365c.f42370c;
        StringBuilder sb2 = this.f42364b;
        sb2.append(a(System.currentTimeMillis()));
        sb2.append(":secureConnectStart\n");
    }
}
