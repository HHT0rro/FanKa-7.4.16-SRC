package com.kwad.sdk.commercial;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.model.HybridLoadMsg;
import com.kwad.sdk.commercial.model.WebViewCommercialMsg;
import com.kwad.sdk.commercial.model.WebViewLoadMsg;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bo;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.t;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.c;
import com.wangmai.okhttp.db.DBHelper;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b {
    private static float anQ = -1.0f;
    private static double anR = -1.0d;
    private static final AtomicBoolean anS = new AtomicBoolean();
    private static boolean anT;
    private static volatile boolean anU;
    private static List<c> anV;
    private static a anW;
    private static Map<String, com.kwad.sdk.commercial.c.c> anX;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        @WorkerThread
        void j(String str, String str2, boolean z10);

        @WorkerThread
        boolean zA();

        @WorkerThread
        boolean zB();

        @WorkerThread
        JSONObject zC();

        String zD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void AG() {
        try {
            anX = new HashMap();
            JSONObject zC = anW.zC();
            if (zC == null) {
                return;
            }
            Iterator<String> keys = zC.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject = zC.optJSONObject(next);
                if (optJSONObject != null) {
                    a(next, optJSONObject.optJSONArray("ratio"));
                    b(next, optJSONObject.optJSONArray("ratioApmRL"));
                }
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static synchronized void a(final a aVar, final boolean z10) {
        synchronized (b.class) {
            if (anT) {
                return;
            }
            anT = true;
            anW = aVar;
            g.execute(new ay() { // from class: com.kwad.sdk.commercial.b.1
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    b.b(a.this, z10);
                    b.AG();
                    b.anS.set(true);
                    b.mQ();
                }
            });
        }
    }

    private static void b(String str, JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    Object obj = jSONArray.get(i10);
                    if (obj instanceof String) {
                        com.kwad.sdk.commercial.c.c cVar = new com.kwad.sdk.commercial.c.c();
                        String a10 = a(cVar, (String) obj);
                        com.kwad.sdk.commercial.c.c cVar2 = anX.get(a10);
                        if (cVar2 != null) {
                            cVar2.aov = true;
                            cVar2.aos = Double.parseDouble(str);
                        } else {
                            cVar.aov = true;
                            cVar.aos = Double.parseDouble(str);
                            anX.put(a10, cVar);
                        }
                    }
                }
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    public static synchronized void d(c cVar) {
        synchronized (b.class) {
            if (com.kwad.framework.a.a.f36635md.booleanValue()) {
                if (cVar.category.equals(ILoggerReporter.Category.ERROR_LOG)) {
                    com.kwad.sdk.core.e.c.e("KCLogReporter", "reportItem: " + ((Object) cVar));
                } else {
                    com.kwad.sdk.core.e.c.d("KCLogReporter", "reportItem: " + ((Object) cVar));
                }
            }
            if (!anS.get()) {
                c(cVar);
            } else {
                b(cVar);
            }
        }
    }

    public static void e(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.AJ().cu(ILoggerReporter.Category.APM_LOG).i(0.01d).N("ad_sdk_reward_check_result", "check_type").a(BusinessType.AD_REWARD).u(aVar).a(new com.kwai.adclient.kscommerciallogger.model.b("RESULT_CHECK_REWARD")));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void f(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.AJ().cu(ILoggerReporter.Category.APM_LOG).i(0.5d).N("ad_sdk_webview_track", "scene_id").a(BusinessType.AD_WEBVIEW).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aTL));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void g(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.AJ().cu(ILoggerReporter.Category.ERROR_LOG).i(0.01d).N("ad_sdk_reward_performance", "reward_type").a(BusinessType.AD_REWARD).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.aUn));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void h(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.AJ().cu(ILoggerReporter.Category.APM_LOG).i(0.1d).N("ad_sdk_splash_load", "status").a(BusinessType.AD_SPLASH).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aTL));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void i(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.AJ().cu(ILoggerReporter.Category.APM_LOG).i(0.1d).N("ad_sdk_splash_preload", "status").a(BusinessType.AD_SPLASH).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aTL));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void j(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.AJ().cu(ILoggerReporter.Category.APM_LOG).i(0.01d).N("ad_sdk_splash_cache", DBHelper.TABLE_CACHE).a(BusinessType.AD_SPLASH).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aTK));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void k(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.AJ().cu(ILoggerReporter.Category.APM_LOG).i(0.01d).N("ad_sdk_splash_show", "status").a(BusinessType.AD_SPLASH).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aTL));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void l(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.AJ().cu(ILoggerReporter.Category.ERROR_LOG).i(1.0d).N("ad_sdk_splash_monitor_view_error", "status").a(BusinessType.AD_SPLASH).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aTL));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void m(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.AJ().cu(ILoggerReporter.Category.ERROR_LOG).i(1.0d).N("ad_sdk_splash_monitor_template_data_error", "status").a(BusinessType.AD_SPLASH).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aTL));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void mQ() {
        synchronized (b.class) {
            List<c> list = anV;
            if (list == null) {
                return;
            }
            Iterator<c> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                b(iterator2.next());
            }
            anV.clear();
            anV = null;
        }
    }

    public static void n(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.AJ().cu(ILoggerReporter.Category.ERROR_LOG).i(1.0d).N("ad_sdk_splash_monitor_errorcode_error", "status").a(BusinessType.AD_SPLASH).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aTL));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void o(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.AJ().cu(ILoggerReporter.Category.ERROR_LOG).i(1.0d).N("ad_sdk_dynamic_run", "dynamic").a(com.kwai.adclient.kscommerciallogger.model.a.aTL).u(aVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void p(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.AJ().cu(ILoggerReporter.Category.APM_LOG).i(0.01d).N("ad_sdk_block_info", com.huawei.flexiblelayout.card.a.f27807g).a(com.kwai.adclient.kscommerciallogger.model.b.aUe).u(aVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void q(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.AJ().cu(ILoggerReporter.Category.APM_LOG).i(0.01d).N("ad_image_load_perf", "image_perf").u(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.aUn));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void r(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.AJ().cu(ILoggerReporter.Category.APM_LOG).i(1.0d).N("ad_thread_monitor", "thread_perf").u(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.aUn));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void s(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.AJ().cu(ILoggerReporter.Category.APM_LOG).i(0.001d).N("ad_video_load_perf", "video_load_perf").cv("ad_video_load_perf").u(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.aUn));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void t(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.AJ().cu(ILoggerReporter.Category.APM_LOG).i(0.001d).N("ad_video_load_failed", "video_load_failed").cv("ad_video_load_failed").u(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.aUn));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void c(c cVar) {
        if (anV == null) {
            anV = new CopyOnWriteArrayList();
        }
        anV.add(cVar);
    }

    public static void c(boolean z10, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.AJ().cu(ILoggerReporter.Category.APM_LOG).i(0.01d).N(z10 ? "ad_sdk_reward_page_show" : "ad_sdk_fullscreen_page_show", "page_status").a(z10 ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aTB));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void a(String str, JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    Object obj = jSONArray.get(i10);
                    if (obj instanceof String) {
                        com.kwad.sdk.commercial.c.c cVar = new com.kwad.sdk.commercial.c.c();
                        String a10 = a(cVar, (String) obj);
                        com.kwad.sdk.commercial.c.c cVar2 = anX.get(a10);
                        if (cVar2 != null) {
                            cVar2.aou = true;
                            cVar2.aor = Double.parseDouble(str);
                        } else {
                            cVar.aou = true;
                            cVar.aor = Double.parseDouble(str);
                            anX.put(a10, cVar);
                        }
                    }
                }
            } catch (JSONException e2) {
                ServiceProvider.reportSdkCaughtException(e2);
            }
        }
    }

    public static void d(boolean z10, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.AJ().cu(ILoggerReporter.Category.APM_LOG).i(0.01d).N(z10 ? "ad_sdk_reward_callback_interaction" : "ad_sdk_fullscreen_callback_interaction", "callback_type").a(z10 ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aTL));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void e(boolean z10, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.AJ().cu(ILoggerReporter.Category.APM_LOG).i(0.01d).N(z10 ? "ad_sdk_reward_callback_load" : "ad_sdk_fullscreen_callback_load", "callback_type").a(z10 ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aTL));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void f(boolean z10, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.AJ().cu(ILoggerReporter.Category.ERROR_LOG).i(1.0d).N(z10 ? "ad_sdk_reward_play_error" : "ad_sdk_fullscreen_play_error", "reward_type").a(z10 ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.aUe));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void g(boolean z10, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.AJ().cu(ILoggerReporter.Category.APM_LOG).i(z10 ? 1.0d : 0.01d).N("ad_sdk_splash_single_cache", "status").a(BusinessType.AD_SPLASH).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aTK));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void b(c cVar) {
        c.a Oo;
        if (anU) {
            com.kwad.sdk.commercial.c.b a10 = a(cVar);
            if (anQ == -1.0f) {
                anQ = new Random().nextFloat();
            }
            if (anR == -1.0d) {
                anR = new Random().nextFloat();
            }
            if ((anW.zB() || anQ <= a10.aor) && bo.az(BuildConfig.VERSION_NAME, a10.aot)) {
                try {
                    if (ILoggerReporter.Category.ERROR_LOG.equals(a(cVar.category, cVar))) {
                        Oo = c.a.On();
                    } else {
                        Oo = c.a.Oo();
                    }
                    com.kwai.adclient.kscommerciallogger.a.Oe().a(Oo.b(cVar.aod).b(cVar.aoe).hl(TextUtils.isEmpty(cVar.tag) ? cVar.eventId : cVar.tag).b(cVar.aof).hm(cVar.eventId).A(a(cVar.msg, a10)).Op());
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        }
    }

    public static void g(JSONObject jSONObject) {
        String str;
        try {
            int optInt = jSONObject.optInt("load_status");
            if (optInt != 3 && optInt != 4 && optInt != 7) {
                str = ILoggerReporter.Category.APM_LOG;
                d(c.AJ().cu(str).i(1.0d).j(0.1d).k(0.001d).N("ad_sdk_dynamic_update", "load_status").a(com.kwai.adclient.kscommerciallogger.model.a.aTL).h(jSONObject));
            }
            str = ILoggerReporter.Category.ERROR_LOG;
            d(c.AJ().cu(str).i(1.0d).j(0.1d).k(0.001d).N("ad_sdk_dynamic_update", "load_status").a(com.kwai.adclient.kscommerciallogger.model.a.aTL).h(jSONObject));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static String a(com.kwad.sdk.commercial.c.b bVar, String str) {
        try {
            int lastIndexOf = str.lastIndexOf(95);
            int length = str.length() - 1;
            if (str.charAt(length) >= '0' && str.charAt(length) <= '9' && lastIndexOf != -1) {
                bVar.aot = str.substring(lastIndexOf + 1);
                return str.substring(0, lastIndexOf);
            }
        } catch (Throwable unused) {
        }
        return str;
    }

    @NonNull
    private static com.kwad.sdk.commercial.c.b a(c cVar) {
        double d10;
        double d11;
        String str;
        com.kwad.sdk.commercial.c.c cVar2;
        com.kwad.sdk.commercial.c.c cVar3;
        com.kwad.sdk.commercial.c.b bVar = new com.kwad.sdk.commercial.c.b();
        try {
            Boolean bool = com.kwad.framework.a.a.f36635md;
            if (bool.booleanValue()) {
                bVar.aor = cVar.aob;
            } else {
                bVar.aor = cVar.aoa;
            }
            bVar.aos = cVar.aoc;
            if (!anX.containsKey(cVar.eventId) || (cVar3 = anX.get(cVar.eventId)) == null) {
                d10 = -1.0d;
                d11 = -1.0d;
            } else {
                d10 = cVar3.aou ? cVar3.aor : -1.0d;
                d11 = cVar3.aov ? cVar3.aos : -1.0d;
                if (!TextUtils.isEmpty(cVar3.aot)) {
                    bVar.aot = cVar3.aot;
                }
            }
            if (TextUtils.isEmpty(cVar.primaryKey) && bool.booleanValue()) {
                throw new Exception("primaryKey为空");
            }
            String str2 = cVar.eventId;
            if (!TextUtils.isEmpty(cVar.primaryKey)) {
                if (cVar.msg.has(cVar.primaryKey)) {
                    str = str2 + "_" + cVar.msg.opt(cVar.primaryKey);
                } else {
                    str = str2 + "_" + cVar.primaryKey;
                }
                if (anX.containsKey(str) && (cVar2 = anX.get(str)) != null) {
                    if (cVar2.aou) {
                        d10 = cVar2.aor;
                    }
                    if (cVar2.aov) {
                        d11 = cVar2.aos;
                    }
                    if (!TextUtils.isEmpty(cVar2.aot)) {
                        bVar.aot = cVar2.aot;
                    }
                }
            }
            if (d10 != -1.0d) {
                bVar.aor = d10;
            }
            if (d11 != -1.0d) {
                bVar.aos = d11;
            } else {
                bVar.aos = ((h) ServiceProvider.get(h.class)).yO();
            }
            cVar.aoa = bVar.aor;
            cVar.aoc = bVar.aos;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final a aVar, boolean z10) {
        boolean zA = aVar.zA();
        anU = zA;
        if (zA) {
            JSONObject jSONObject = new JSONObject();
            t.putValue(jSONObject, "publish_type", 0);
            t.putValue(jSONObject, "plug_sdk", z10 ? 1 : 0);
            com.kwai.adclient.kscommerciallogger.a Oe = com.kwai.adclient.kscommerciallogger.a.Oe();
            com.kwad.sdk.commercial.a aVar2 = new com.kwad.sdk.commercial.a();
            com.kwai.adclient.kscommerciallogger.a.b bVar = new com.kwai.adclient.kscommerciallogger.a.b() { // from class: com.kwad.sdk.commercial.b.2
                private void M(String str, String str2) {
                    a.this.j(str, str2, false);
                }

                @Override // com.kwai.adclient.kscommerciallogger.a.b
                public final void L(@NonNull String str, @NonNull String str2) {
                    M(str, str2);
                }
            };
            Boolean bool = com.kwad.framework.a.a.f36635md;
            Oe.a(aVar2, bVar, jSONObject, bool.booleanValue(), bool.booleanValue());
            com.kwad.sdk.commercial.h.a.AR().cH(aVar.zD());
        }
    }

    public static void b(boolean z10, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.AJ().cu(ILoggerReporter.Category.ERROR_LOG).i(1.0d).N(z10 ? "ad_sdk_reward_download_error" : "ad_sdk_fullscreen_download_error", "download_type").a(z10 ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.aTY));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(String str, HybridLoadMsg hybridLoadMsg) {
        try {
            d(c.AJ().cu(str).i(ILoggerReporter.Category.ERROR_LOG.equals(str) ? 1.0d : 0.001d).N("union_web_cache_load_event", "state").a(BusinessType.WEB_CACHE).u(hybridLoadMsg).a(com.kwai.adclient.kscommerciallogger.model.d.aUn));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static String a(String str, c cVar) {
        return (!str.equals(ILoggerReporter.Category.APM_LOG) || anR >= cVar.aoc) ? str : ILoggerReporter.Category.ERROR_LOG;
    }

    public static void a(String str, com.kwai.adclient.kscommerciallogger.model.d dVar, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.AJ().cu(str).i(0.001d).N(ILoggerReporter.Category.ERROR_LOG.equals(str) ? "ad_sdk_init_error_performance" : "ad_sdk_init_performance", "init_status").a(BusinessType.AD_SDK_INIT).u(aVar).a(dVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(j jVar) {
        try {
            d(c.AJ().cu(ILoggerReporter.Category.APM_LOG).i(1.0E-5d).N("ad_perf_monitor_net_success", "network_monitor").u(jVar).a(com.kwai.adclient.kscommerciallogger.model.d.aUn));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(boolean z10, com.kwad.sdk.commercial.c.a aVar, com.kwai.adclient.kscommerciallogger.model.d dVar) {
        try {
            d(c.AJ().cu(ILoggerReporter.Category.APM_LOG).i(0.01d).N(z10 ? "ad_sdk_reward_load" : "ad_sdk_fullscreen_load", "load_status").a(z10 ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).u(aVar).a(dVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(i iVar) {
        try {
            d(c.AJ().cu(ILoggerReporter.Category.APM_LOG).i(0.1d).N("ad_perf_monitor_net_error", "network_monitor").u(iVar).a(com.kwai.adclient.kscommerciallogger.model.d.aUn));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(boolean z10, String str, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.AJ().cu(ILoggerReporter.Category.ERROR_LOG).i(1.0d).N(str, "reward_type").a(z10 ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.aUe));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(@NonNull com.kwad.sdk.utils.b.a aVar) {
        try {
            d(c.AJ().cu(ILoggerReporter.Category.APM_LOG).i(0.01d).N("ad_union_kv_fail_rate", "kv").u(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.aUn));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(String str, HybridLoadMsg hybridLoadMsg) {
        try {
            d(c.AJ().cu(str).i(1.0E-4d).N("union_web_cache_download_event", "state").a(BusinessType.WEB_CACHE).u(hybridLoadMsg).a(com.kwai.adclient.kscommerciallogger.model.d.aUn));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(String str, WebViewLoadMsg webViewLoadMsg) {
        try {
            d(c.AJ().cu(str).i(1.0d).N("union_webview_load_event", "state").u(webViewLoadMsg).a(com.kwai.adclient.kscommerciallogger.model.d.aUn));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(String str, WebViewCommercialMsg webViewCommercialMsg) {
        try {
            double d10 = webViewCommercialMsg.rate;
            if (d10 >= ShadowDrawableWrapper.COS_45) {
                t.putValue(webViewCommercialMsg.msg, "ratio", d10);
            }
            if (TextUtils.isEmpty(webViewCommercialMsg.primaryKey)) {
                webViewCommercialMsg.primaryKey = "web_log";
            }
            d(c.AJ().cu(str).i(webViewCommercialMsg.rate).N(webViewCommercialMsg.eventId, webViewCommercialMsg.primaryKey).a(webViewCommercialMsg.biz).a(webViewCommercialMsg.subBiz).h(webViewCommercialMsg.msg).a(com.kwai.adclient.kscommerciallogger.model.d.aUn));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static JSONObject a(JSONObject jSONObject, com.kwad.sdk.commercial.c.b bVar) {
        try {
            t.putValue(jSONObject, "ratio", bVar.aor);
            double d10 = bVar.aor;
            if (d10 > ShadowDrawableWrapper.COS_45) {
                t.putValue(jSONObject, "ratio_count", a(1.0d, d10, 0));
            }
            t.putValue(jSONObject, "debug_mode", com.kwad.framework.a.a.f36635md.booleanValue() ? 1 : 0);
            t.putValue(jSONObject, "convert_ratio", bVar.aos);
            double d11 = bVar.aos;
            if (d11 > ShadowDrawableWrapper.COS_45) {
                t.putValue(jSONObject, "convert_ratio_count", a(1.0d, d11, 0));
            }
            return jSONObject;
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTrace(e2);
            return jSONObject;
        }
    }

    private static double a(double d10, double d11, int i10) {
        return new BigDecimal(Double.toString(1.0d)).divide(new BigDecimal(Double.toString(d11)), 0, RoundingMode.HALF_UP).doubleValue();
    }
}
