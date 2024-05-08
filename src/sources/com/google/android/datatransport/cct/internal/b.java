package com.google.android.datatransport.cct.internal;

import com.alibaba.security.realidentity.build.aq;
import com.baidu.mobads.sdk.internal.bk;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.openalliance.ad.constant.bg;
import com.huawei.quickcard.framework.bean.ConfigBean;
import com.inno.innosdk.pb.InnoMain;
import java.io.IOException;

/* compiled from: AutoBatchedLogRequestEncoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b implements b8.a {

    /* renamed from: a, reason: collision with root package name */
    public static final b8.a f19313a = new b();

    /* compiled from: AutoBatchedLogRequestEncoder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements a8.d<com.google.android.datatransport.cct.internal.a> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f19314a = new a();

        @Override // a8.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(com.google.android.datatransport.cct.internal.a aVar, a8.e eVar) throws IOException {
            eVar.c(bg.e.Code, aVar.m());
            eVar.c(bk.f9900i, aVar.j());
            eVar.c("hardware", aVar.f());
            eVar.c(com.alipay.sdk.packet.e.f4642n, aVar.d());
            eVar.c(InnoMain.INNO_KEY_PRODUCT, aVar.l());
            eVar.c("osBuild", aVar.k());
            eVar.c("manufacturer", aVar.h());
            eVar.c(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT, aVar.e());
            eVar.c("locale", aVar.g());
            eVar.c("country", aVar.c());
            eVar.c("mccMnc", aVar.i());
            eVar.c("applicationBuild", aVar.b());
        }
    }

    /* compiled from: AutoBatchedLogRequestEncoder.java */
    /* renamed from: com.google.android.datatransport.cct.internal.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class C0180b implements a8.d<i> {

        /* renamed from: a, reason: collision with root package name */
        public static final C0180b f19315a = new C0180b();

        @Override // a8.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(i iVar, a8.e eVar) throws IOException {
            eVar.c("logRequest", iVar.c());
        }
    }

    /* compiled from: AutoBatchedLogRequestEncoder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements a8.d<ClientInfo> {

        /* renamed from: a, reason: collision with root package name */
        public static final c f19316a = new c();

        @Override // a8.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ClientInfo clientInfo, a8.e eVar) throws IOException {
            eVar.c(aq.D, clientInfo.c());
            eVar.c("androidClientInfo", clientInfo.b());
        }
    }

    /* compiled from: AutoBatchedLogRequestEncoder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d implements a8.d<LogEvent> {

        /* renamed from: a, reason: collision with root package name */
        public static final d f19317a = new d();

        @Override // a8.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(LogEvent logEvent, a8.e eVar) throws IOException {
            eVar.d("eventTimeMs", logEvent.getEventTimeMs());
            eVar.c("eventCode", logEvent.getEventCode());
            eVar.d("eventUptimeMs", logEvent.getEventUptimeMs());
            eVar.c("sourceExtension", logEvent.getSourceExtension());
            eVar.c("sourceExtensionJsonProto3", logEvent.getSourceExtensionJsonProto3());
            eVar.d("timezoneOffsetSeconds", logEvent.getTimezoneOffsetSeconds());
            eVar.c("networkConnectionInfo", logEvent.getNetworkConnectionInfo());
        }
    }

    /* compiled from: AutoBatchedLogRequestEncoder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class e implements a8.d<j> {

        /* renamed from: a, reason: collision with root package name */
        public static final e f19318a = new e();

        @Override // a8.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(j jVar, a8.e eVar) throws IOException {
            eVar.d("requestTimeMs", jVar.g());
            eVar.d("requestUptimeMs", jVar.h());
            eVar.c(aq.f3110f, jVar.b());
            eVar.c("logSource", jVar.d());
            eVar.c("logSourceName", jVar.e());
            eVar.c("logEvent", jVar.c());
            eVar.c("qosTier", jVar.f());
        }
    }

    /* compiled from: AutoBatchedLogRequestEncoder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class f implements a8.d<NetworkConnectionInfo> {

        /* renamed from: a, reason: collision with root package name */
        public static final f f19319a = new f();

        @Override // a8.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(NetworkConnectionInfo networkConnectionInfo, a8.e eVar) throws IOException {
            eVar.c(ConfigBean.Field.NETWORK_TYPE, networkConnectionInfo.c());
            eVar.c("mobileSubtype", networkConnectionInfo.b());
        }
    }

    @Override // b8.a
    public void a(b8.b<?> bVar) {
        C0180b c0180b = C0180b.f19315a;
        bVar.a(i.class, c0180b);
        bVar.a(com.google.android.datatransport.cct.internal.d.class, c0180b);
        e eVar = e.f19318a;
        bVar.a(j.class, eVar);
        bVar.a(com.google.android.datatransport.cct.internal.f.class, eVar);
        c cVar = c.f19316a;
        bVar.a(ClientInfo.class, cVar);
        bVar.a(com.google.android.datatransport.cct.internal.e.class, cVar);
        a aVar = a.f19314a;
        bVar.a(com.google.android.datatransport.cct.internal.a.class, aVar);
        bVar.a(com.google.android.datatransport.cct.internal.c.class, aVar);
        d dVar = d.f19317a;
        bVar.a(LogEvent.class, dVar);
        bVar.a(AutoValue_LogEvent.class, dVar);
        f fVar = f.f19319a;
        bVar.a(NetworkConnectionInfo.class, fVar);
        bVar.a(h.class, fVar);
    }
}
