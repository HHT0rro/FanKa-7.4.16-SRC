package com.kwad.sdk.j;

import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.s;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b {
    public static final /* synthetic */ boolean $assertionsDisabled = false;

    @KsJson
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a extends com.kwad.sdk.commercial.c.a {
        public String aFq;
        public int aJF;
        public String sdkVersion;
    }

    @KsJson
    /* renamed from: com.kwad.sdk.j.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class C0541b extends com.kwad.sdk.commercial.c.a {
        public int aJG;
        public String aJH;
        public String aJI;
        public String aJJ;
        public String aJK;
        public String aJL;
    }

    public static void Jt() {
        g.execute(new ay() { // from class: com.kwad.sdk.j.b.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                b.Ju();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Ju() {
        a a10;
        JSONObject jSONObject = (JSONObject) d.Ca().getAppConfigData(null, new com.kwad.sdk.g.b<JSONObject, JSONObject>() { // from class: com.kwad.sdk.j.b.2
            private static JSONObject o(JSONObject jSONObject2) {
                return jSONObject2.optJSONObject("sdkTTPerfMonitor");
            }

            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ JSONObject apply(JSONObject jSONObject2) {
                return o(jSONObject2);
            }
        });
        if (jSONObject == null) {
            return;
        }
        C0541b c0541b = new C0541b();
        try {
            c0541b.parseJson(jSONObject);
            if (c0541b.aJG == 1 && (a10 = a(ServiceProvider.getContext().getClassLoader(), c0541b)) != null) {
                com.kwad.sdk.commercial.b.d(c.AJ().cu(ILoggerReporter.Category.APM_LOG).i(0.01d).N("ad_sdk_tt_sdk_info", com.alipay.sdk.sys.a.f4667h).u(a10).a(com.kwai.adclient.kscommerciallogger.model.a.aTL));
            }
        } catch (Throwable unused) {
        }
    }

    @Nullable
    private static a a(ClassLoader classLoader, C0541b c0541b) {
        Class<?> a10 = s.a(c0541b.aJH, classLoader);
        if (a10 == null) {
            return null;
        }
        a aVar = new a();
        aVar.aJF = s.classExists(c0541b.aJI) ? 1 : 0;
        Object callStaticMethod = s.callStaticMethod(a10, c0541b.aJJ, new Object[0]);
        aVar.sdkVersion = (String) s.callMethod(callStaticMethod, c0541b.aJK, new Object[0]);
        aVar.aFq = (String) s.callMethod(callStaticMethod, c0541b.aJL, new Object[0]);
        return aVar;
    }
}
