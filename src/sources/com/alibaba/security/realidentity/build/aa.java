package com.alibaba.security.realidentity.build;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.security.biometrics.jni.ALBiometricsJni;
import com.alibaba.security.biometrics.service.common.GetCacheDataManager;
import com.alibaba.security.common.log.RPLogging;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.common.utils.BytesUtils;
import com.alibaba.security.common.utils.CommonUtils;
import com.alibaba.security.common.utils.JsonUtils;
import com.alibaba.security.common.utils.NetWorkUtils;
import com.alibaba.security.realidentity.RPEventListener;
import com.alibaba.security.realidentity.build.j;
import com.alibaba.security.realidentity.build.l;
import com.alibaba.security.realidentity.business.dynamic.DynamicHttpRequest;
import com.alibaba.security.realidentity.business.dynamic.DynamicHttpResponse;
import com.alibaba.security.realidentity.http.base.BusinessHttpWrapper;
import com.alibaba.security.realidentity.http.base.BusinessRequest;
import com.alibaba.security.realidentity.http.base.RetrofitHttpCallback;
import com.alibaba.security.realidentity.http.model.HttpRequest;
import com.alibaba.security.realidentity.http.model.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: DynamicAsyncTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class aa extends z<Map<String, Object>> {

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f3006f;

    /* renamed from: i, reason: collision with root package name */
    private long f3007i;

    /* renamed from: j, reason: collision with root package name */
    private HttpResponse f3008j;

    /* renamed from: h, reason: collision with root package name */
    private static final String f3005h = aa.class.getSimpleName();

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f3004g = {c.f3237y};

    public aa(Context context, String str, RPEventListener rPEventListener, Runnable runnable, gx gxVar) {
        super(context, str, rPEventListener, runnable, gxVar);
        this.f3006f = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x006c, code lost:
    
        if (android.text.TextUtils.isEmpty(r0) != false) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d8  */
    @Override // com.alibaba.security.realidentity.build.z, android.os.AsyncTask
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Map<java.lang.String, java.lang.Object> doInBackground(java.lang.String... r5) {
        /*
            r4 = this;
            long r0 = java.lang.System.currentTimeMillis()
            r4.f3007i = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r1 = "H5_DOMAIN"
            r0.add(r1)
            if (r5 == 0) goto L1c
            int r1 = r5.length
            if (r1 <= 0) goto L1c
            java.util.List r5 = java.util.Arrays.asList(r5)
            r0.addAll(r5)
        L1c:
            com.alibaba.security.realidentity.business.dynamic.DynamicHttpRequest r5 = new com.alibaba.security.realidentity.business.dynamic.DynamicHttpRequest
            java.lang.String r1 = r4.f4021b
            r5.<init>(r1)
            r5.setKeys(r0)
            java.lang.String r0 = com.alibaba.security.common.utils.JsonUtils.toJSON(r5)
            java.lang.String r1 = ""
            com.alibaba.security.common.track.model.TrackLog r0 = com.alibaba.security.common.track.model.TrackLog.createDynamicBegin(r1, r0, r1)
            com.alibaba.security.realidentity.build.j r1 = com.alibaba.security.realidentity.build.j.a.a()
            r1.collectLog(r0)
            com.alibaba.security.realidentity.http.model.HttpResponse r5 = r4.a(r5)
            boolean r0 = r5 instanceof com.alibaba.security.realidentity.business.dynamic.DynamicHttpResponse
            r1 = 0
            if (r0 != 0) goto L44
            r4.a(r5, r1)
            return r1
        L44:
            r0 = r5
            com.alibaba.security.realidentity.business.dynamic.DynamicHttpResponse r0 = (com.alibaba.security.realidentity.business.dynamic.DynamicHttpResponse) r0
            com.alibaba.security.realidentity.business.dynamic.DynamicHttpResponse$Data r0 = r0.getData()
            if (r0 != 0) goto L51
            r4.a(r5, r1)
            return r1
        L51:
            java.lang.String r0 = r0.getData()
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L5d
        L5b:
            r0 = r1
            goto L6f
        L5d:
            byte[] r0 = com.alibaba.security.common.utils.BytesUtils.decodeBase64String(r0)
            if (r0 != 0) goto L64
            goto L5b
        L64:
            java.lang.String r0 = com.alibaba.security.biometrics.jni.ALBiometricsJni.dp(r0)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L6f
            goto L5b
        L6f:
            java.lang.Class<com.alibaba.security.realidentity.business.dynamic.DynamicHttpResponse$DataConfig> r2 = com.alibaba.security.realidentity.business.dynamic.DynamicHttpResponse.DataConfig.class
            r3 = 1
            java.lang.Object r0 = com.alibaba.security.common.utils.JsonUtils.parseObject(r0, r2, r3)
            com.alibaba.security.realidentity.business.dynamic.DynamicHttpResponse$DataConfig r0 = (com.alibaba.security.realidentity.business.dynamic.DynamicHttpResponse.DataConfig) r0
            r4.a(r5, r0)
            if (r0 != 0) goto L7e
            return r1
        L7e:
            java.lang.String r5 = r0.getDomain()
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 != 0) goto L8e
            com.alibaba.security.realidentity.build.j r1 = com.alibaba.security.realidentity.build.j.a.a()
            r1.f3897g = r5
        L8e:
            boolean r1 = com.alibaba.security.common.utils.NetWorkUtils.isLegalUrl(r5)
            if (r1 != 0) goto La3
            java.lang.String r1 = com.alibaba.security.realidentity.build.aa.f3005h
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r2 = "domain is illegal ,url is "
            java.lang.String r5 = r2.concat(r5)
            com.alibaba.security.common.log.RPLogging.e(r1, r5)
        La3:
            java.util.Map r5 = r0.getConfig()
            if (r5 == 0) goto Le7
            boolean r0 = com.alibaba.security.common.utils.CommonUtils.checkWindVaneExist()
            java.lang.String r1 = "1"
            if (r0 != 0) goto Lb6
            com.alibaba.security.realidentity.build.j r0 = com.alibaba.security.realidentity.build.j.a.a()
            goto Lcb
        Lb6:
            java.lang.String r0 = "rpsdkUseSystemWebView"
            java.lang.Object r0 = r5.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            com.alibaba.security.realidentity.build.j r2 = com.alibaba.security.realidentity.build.j.a.a()
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto Lca
            r0 = 1
            goto Lce
        Lca:
            r0 = r2
        Lcb:
            r2 = 0
            r2 = r0
            r0 = 0
        Lce:
            r2.f3907q = r0
            java.lang.String r0 = "rpUseHwMagicWindow"
            java.lang.Object r2 = r5.get(r0)
            if (r2 == 0) goto Le0
            java.lang.Object r0 = r5.get(r0)
            boolean r3 = r0.equals(r1)
        Le0:
            com.alibaba.security.biometrics.service.common.GetCacheDataManager r0 = com.alibaba.security.biometrics.service.common.GetCacheDataManager.getInstance()
            r0.setUseHwMagicWindow(r3)
        Le7:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.realidentity.build.aa.doInBackground(java.lang.String[]):java.util.Map");
    }

    private static void c(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        GetCacheDataManager.getInstance().setUseHwMagicWindow(map.get("rpUseHwMagicWindow") != null ? map.get("rpUseHwMagicWindow").equals("1") : true);
    }

    private static void d(Map<String, Object> map) {
        if (!CommonUtils.checkWindVaneExist()) {
            j.a.f3944a.f3907q = false;
        } else {
            if (map == null) {
                return;
            }
            String str = (String) map.get("rpsdkUseSystemWebView");
            j.a.f3944a.f3907q = !"1".equals(str);
        }
    }

    @Override // com.alibaba.security.realidentity.build.z
    public final /* synthetic */ void a(Map<String, Object> map) {
        Map<String, Object> map2 = map;
        if (this.f3006f) {
            return;
        }
        Context context = this.f4020a.get();
        if (map2 != null && context != null) {
            if ("1".equals(map2.get("rpsdkToNativeSwitch"))) {
                j.a.f3944a.a(context, this.f4021b, this.f4022c);
                return;
            } else {
                this.f4023d.run();
                return;
            }
        }
        this.f4023d.run();
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private void a2(Map<String, Object> map) {
        if (this.f3006f) {
            return;
        }
        Context context = this.f4020a.get();
        if (map != null && context != null) {
            if ("1".equals(map.get("rpsdkToNativeSwitch"))) {
                j.a.f3944a.a(context, this.f4021b, this.f4022c);
                return;
            } else {
                this.f4023d.run();
                return;
            }
        }
        this.f4023d.run();
    }

    private DynamicHttpRequest a(List<String> list) {
        DynamicHttpRequest dynamicHttpRequest = new DynamicHttpRequest(this.f4021b);
        dynamicHttpRequest.setKeys(list);
        return dynamicHttpRequest;
    }

    private HttpResponse a(DynamicHttpRequest dynamicHttpRequest) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            l.a.f3948a.e().dynamic(new BusinessHttpWrapper(DynamicHttpResponse.class, new BusinessRequest(DynamicHttpRequest.class, dynamicHttpRequest)), new RetrofitHttpCallback() { // from class: com.alibaba.security.realidentity.build.aa.1
                @Override // com.alibaba.security.realidentity.http.base.RetrofitHttpCallback
                public final void onFailure(HttpResponse httpResponse) {
                    aa.this.f3008j = httpResponse;
                    countDownLatch.countDown();
                }

                @Override // com.alibaba.security.realidentity.http.base.RetrofitHttpCallback
                public final void onNetError(Exception exc) {
                    j.a.f3944a.collectLog(TrackLog.createSimpleSdk(aa.f3005h, "dynamicRequest", exc.getMessage()));
                    aa.this.f3008j = null;
                    countDownLatch.countDown();
                }

                @Override // com.alibaba.security.realidentity.http.base.RetrofitHttpCallback
                public final void onSuccess(HttpResponse httpResponse) {
                    aa.this.f3008j = httpResponse;
                    countDownLatch.countDown();
                }
            });
            countDownLatch.await(15L, TimeUnit.SECONDS);
        } catch (Throwable th) {
            j jVar = j.a.f3944a;
            String str = f3005h;
            jVar.collectLog(TrackLog.createSimpleSdk(str, "dynamicRequest", th.getMessage()));
            RPLogging.e(str, th);
        }
        return this.f3008j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0031, code lost:
    
        if (android.text.TextUtils.isEmpty(r0) != false) goto L12;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.Map<java.lang.String, java.lang.Object> a(com.alibaba.security.realidentity.http.model.HttpResponse r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.alibaba.security.realidentity.business.dynamic.DynamicHttpResponse
            r1 = 0
            if (r0 != 0) goto L9
            r4.a(r5, r1)
            return r1
        L9:
            r0 = r5
            com.alibaba.security.realidentity.business.dynamic.DynamicHttpResponse r0 = (com.alibaba.security.realidentity.business.dynamic.DynamicHttpResponse) r0
            com.alibaba.security.realidentity.business.dynamic.DynamicHttpResponse$Data r0 = r0.getData()
            if (r0 != 0) goto L16
            r4.a(r5, r1)
            return r1
        L16:
            java.lang.String r0 = r0.getData()
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L22
        L20:
            r0 = r1
            goto L34
        L22:
            byte[] r0 = com.alibaba.security.common.utils.BytesUtils.decodeBase64String(r0)
            if (r0 != 0) goto L29
            goto L20
        L29:
            java.lang.String r0 = com.alibaba.security.biometrics.jni.ALBiometricsJni.dp(r0)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L34
            goto L20
        L34:
            java.lang.Class<com.alibaba.security.realidentity.business.dynamic.DynamicHttpResponse$DataConfig> r2 = com.alibaba.security.realidentity.business.dynamic.DynamicHttpResponse.DataConfig.class
            r3 = 1
            java.lang.Object r0 = com.alibaba.security.common.utils.JsonUtils.parseObject(r0, r2, r3)
            com.alibaba.security.realidentity.business.dynamic.DynamicHttpResponse$DataConfig r0 = (com.alibaba.security.realidentity.business.dynamic.DynamicHttpResponse.DataConfig) r0
            r4.a(r5, r0)
            if (r0 != 0) goto L43
            return r1
        L43:
            java.lang.String r5 = r0.getDomain()
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 != 0) goto L53
            com.alibaba.security.realidentity.build.j r1 = com.alibaba.security.realidentity.build.j.a.a()
            r1.f3897g = r5
        L53:
            boolean r1 = com.alibaba.security.common.utils.NetWorkUtils.isLegalUrl(r5)
            if (r1 != 0) goto L68
            java.lang.String r1 = com.alibaba.security.realidentity.build.aa.f3005h
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r2 = "domain is illegal ,url is "
            java.lang.String r5 = r2.concat(r5)
            com.alibaba.security.common.log.RPLogging.e(r1, r5)
        L68:
            java.util.Map r5 = r0.getConfig()
            if (r5 == 0) goto Lac
            boolean r0 = com.alibaba.security.common.utils.CommonUtils.checkWindVaneExist()
            java.lang.String r1 = "1"
            if (r0 != 0) goto L7b
            com.alibaba.security.realidentity.build.j r0 = com.alibaba.security.realidentity.build.j.a.a()
            goto L90
        L7b:
            java.lang.String r0 = "rpsdkUseSystemWebView"
            java.lang.Object r0 = r5.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            com.alibaba.security.realidentity.build.j r2 = com.alibaba.security.realidentity.build.j.a.a()
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L8f
            r0 = 1
            goto L93
        L8f:
            r0 = r2
        L90:
            r2 = 0
            r2 = r0
            r0 = 0
        L93:
            r2.f3907q = r0
            java.lang.String r0 = "rpUseHwMagicWindow"
            java.lang.Object r2 = r5.get(r0)
            if (r2 == 0) goto La5
            java.lang.Object r0 = r5.get(r0)
            boolean r3 = r0.equals(r1)
        La5:
            com.alibaba.security.biometrics.service.common.GetCacheDataManager r0 = com.alibaba.security.biometrics.service.common.GetCacheDataManager.getInstance()
            r0.setUseHwMagicWindow(r3)
        Lac:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.realidentity.build.aa.a(com.alibaba.security.realidentity.http.model.HttpResponse):java.util.Map");
    }

    private static String b(String str) {
        byte[] decodeBase64String;
        if (TextUtils.isEmpty(str) || (decodeBase64String = BytesUtils.decodeBase64String(str)) == null) {
            return null;
        }
        String dp = ALBiometricsJni.dp(decodeBase64String);
        if (TextUtils.isEmpty(dp)) {
            return null;
        }
        return dp;
    }

    private void b() {
        this.f3006f = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(java.util.Map<java.lang.String, java.lang.Object> r4) {
        /*
            if (r4 == 0) goto L41
            boolean r0 = com.alibaba.security.common.utils.CommonUtils.checkWindVaneExist()
            r1 = 1
            java.lang.String r2 = "1"
            if (r0 != 0) goto L10
            com.alibaba.security.realidentity.build.j r0 = com.alibaba.security.realidentity.build.j.a.a()
            goto L25
        L10:
            java.lang.String r0 = "rpsdkUseSystemWebView"
            java.lang.Object r0 = r4.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            com.alibaba.security.realidentity.build.j r3 = com.alibaba.security.realidentity.build.j.a.a()
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L24
            r0 = 1
            goto L28
        L24:
            r0 = r3
        L25:
            r3 = 0
            r3 = r0
            r0 = 0
        L28:
            r3.f3907q = r0
            java.lang.String r0 = "rpUseHwMagicWindow"
            java.lang.Object r3 = r4.get(r0)
            if (r3 == 0) goto L3a
            java.lang.Object r4 = r4.get(r0)
            boolean r1 = r4.equals(r2)
        L3a:
            com.alibaba.security.biometrics.service.common.GetCacheDataManager r4 = com.alibaba.security.biometrics.service.common.GetCacheDataManager.getInstance()
            r4.setUseHwMagicWindow(r1)
        L41:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.realidentity.build.aa.b(java.util.Map):void");
    }

    private static void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            j.a.f3944a.f3897g = str;
        }
        if (NetWorkUtils.isLegalUrl(str)) {
            return;
        }
        RPLogging.e(f3005h, "domain is illegal ,url is ".concat(String.valueOf(str)));
    }

    private static void a(HttpRequest httpRequest) {
        j.a.f3944a.collectLog(TrackLog.createDynamicBegin("", JsonUtils.toJSON(httpRequest), ""));
    }

    private void a(HttpResponse httpResponse, DynamicHttpResponse.DataConfig dataConfig) {
        TrackLog createDynamicEnd = TrackLog.createDynamicEnd("", JsonUtils.toJSON(httpResponse), JsonUtils.toJSON(dataConfig));
        createDynamicEnd.setRt(System.currentTimeMillis() - this.f3007i);
        j.a.f3944a.collectLog(createDynamicEnd);
    }
}
