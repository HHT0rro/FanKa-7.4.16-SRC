package com.wangmai.ad.dex.allmodules.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import com.wangmai.ad.dex.allmodules.bean.ApiBean;
import com.wangmai.appsdkdex.TransActivity;
import com.wangmai.common.utils.HandlerUtil;
import com.wangmai.common.utils.MessageEvent;
import com.wangmai.common.utils.ThreadUtils;
import com.wangmai.common.utils.Utils;
import com.wangmai.okhttp.OkHttp;
import com.wangmai.okhttp.callback.StringCallback;
import com.wangmai.okhttp.model.Response;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: DeepLinkHelper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appi {

    /* renamed from: appa, reason: collision with root package name */
    static boolean f46845appa = false;
    static boolean appb = false;
    static int appc = 0;
    static boolean appd = false;
    static boolean appe = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: DeepLinkHelper.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appa implements Runnable {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ Context f46846appa;
        final /* synthetic */ String appb;
        final /* synthetic */ ApiBean appc;
        final /* synthetic */ int appd;
        final /* synthetic */ apph appe;

        appa(Context context, String str, ApiBean apiBean, int i10, apph apphVar) {
            this.f46846appa = context;
            this.appb = str;
            this.appc = apiBean;
            this.appd = i10;
            this.appe = apphVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            appi.appb(this.f46846appa, this.appb, this.appc, this.appd, this.appe);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: DeepLinkHelper.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appb implements Runnable {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ Context f46847appa;
        final /* synthetic */ int appb;
        final /* synthetic */ String appc;
        final /* synthetic */ String appd;
        final /* synthetic */ List appe;
        final /* synthetic */ boolean appf;

        appb(Context context, int i10, String str, String str2, List list, boolean z10) {
            this.f46847appa = context;
            this.appb = i10;
            this.appc = str;
            this.appd = str2;
            this.appe = list;
            this.appf = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Utils.isRunningForeground(this.f46847appa)) {
                appa.appa.appf.appd.appe("DeepLinkHelper", "宿主应用处于前台 " + this.appb);
                appi.appa(this.f46847appa, this.appc, this.appd, (List<String>) this.appe, this.appf);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: DeepLinkHelper.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appc implements HandlerUtil.ITick {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ long f46848appa;
        final /* synthetic */ long appb;
        final /* synthetic */ Context appc;
        final /* synthetic */ String appd;

        appc(long j10, long j11, Context context, String str) {
            this.f46848appa = j10;
            this.appb = j11;
            this.appc = context;
            this.appd = str;
        }

        @Override // com.wangmai.common.utils.HandlerUtil.ITick
        public void onTick() {
            try {
                if (System.currentTimeMillis() > this.f46848appa + this.appb) {
                    HandlerUtil.getInstance().removeMessage();
                    appa.appa.appf.appd.appe("DeepLinkHelper", "cancel monitoring");
                    return;
                }
                boolean appl = appx.appl(this.appc);
                appi.appa(this.appd.replaceAll(Utils.replaceEventType, Utils.TRACK_EVENT_TYPE_APP_STATE).replaceAll(Utils.replaceSubType, String.valueOf(appi.appc * 1000)).replaceAll(Utils.replaceConfig, appl ? "1" : "2"));
                if (appl) {
                    if (appi.f46845appa && !appi.appb) {
                        appi.appb = true;
                        appi.appa(this.appd.replaceAll(Utils.replaceEventType, Utils.TRACK_EVENT_TYPE_DP_CALLBACK).replaceAll(Utils.replaceConfig, String.valueOf(System.currentTimeMillis() - this.f46848appa)));
                    }
                } else {
                    appi.f46845appa = true;
                }
                appi.appc++;
            } catch (Throwable th) {
                HandlerUtil.getInstance().removeMessage();
                appa.appa.appf.appd.appe("DeepLinkHelper", "startAppTrackMonitoring onTick error：" + th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: DeepLinkHelper.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appd extends StringCallback {
        appd() {
        }

        @Override // com.wangmai.okhttp.callback.AbsCallback, com.wangmai.okhttp.callback.Callback
        public void onError(Response<String> response) {
            super.onError(response);
            appa.appa.appf.appd.appe("DeepLinkHelper", "report retry open deepLink error:" + response.getException().toString());
        }

        @Override // com.wangmai.okhttp.callback.Callback
        public void onSuccess(Response<String> response) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: DeepLinkHelper.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appe extends StringCallback {
        appe() {
        }

        @Override // com.wangmai.okhttp.callback.AbsCallback, com.wangmai.okhttp.callback.Callback
        public void onError(Response<String> response) {
            super.onError(response);
            appa.appa.appf.appd.appe("DeepLinkHelper", "track report error :" + response.getException().toString());
        }

        @Override // com.wangmai.okhttp.callback.Callback
        public void onSuccess(Response<String> response) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: DeepLinkHelper.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appf implements MessageEvent.IMessageCallback {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ boolean f46849appa;
        final /* synthetic */ apph appb;
        final /* synthetic */ String appc;
        final /* synthetic */ List appd;

        appf(boolean z10, apph apphVar, String str, List list) {
            this.f46849appa = z10;
            this.appb = apphVar;
            this.appc = str;
            this.appd = list;
        }

        @Override // com.wangmai.common.utils.MessageEvent.IMessageCallback
        public void handleMessage(String str) {
            if (this.f46849appa) {
                if (this.appb != null) {
                    if (MessageEvent.EVENT_SUCCESS.equals(str)) {
                        appa.appa.appf.appd.appc("DeepLinkHelper", "首次静默唤醒成功");
                        this.appb.appb();
                        return;
                    } else {
                        appa.appa.appf.appd.appe("DeepLinkHelper", "首次静默唤醒失败");
                        this.appb.appa();
                        return;
                    }
                }
                return;
            }
            if (MessageEvent.EVENT_SUCCESS.equals(str)) {
                appa.appa.appf.appd.appc("DeepLinkHelper", "二次静默唤醒成功");
                appi.appb(true, this.appc, this.appd);
            } else {
                appa.appa.appf.appd.appc("DeepLinkHelper", "二次静默唤醒失败");
                appi.appb(false, this.appc, this.appd);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: DeepLinkHelper.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appg implements Runnable {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ boolean f46850appa;
        final /* synthetic */ apph appb;
        final /* synthetic */ String appc;
        final /* synthetic */ List appd;

        appg(boolean z10, apph apphVar, String str, List list) {
            this.f46850appa = z10;
            this.appb = apphVar;
            this.appc = str;
            this.appd = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f46850appa) {
                if (this.appb != null) {
                    if (appi.appd) {
                        appa.appa.appf.appd.appc("DeepLinkHelper", "首次普通唤醒，延迟100ms获取唤起结果，唤醒成功");
                        this.appb.appb();
                        return;
                    } else {
                        appa.appa.appf.appd.appe("DeepLinkHelper", "首次普通唤醒，延迟100ms获取唤起结果，唤醒失败");
                        this.appb.appa();
                        return;
                    }
                }
                return;
            }
            if (appi.appd) {
                appa.appa.appf.appd.appc("DeepLinkHelper", "二次普通唤醒，延迟100ms获取唤起结果，唤醒成功");
                appi.appb(true, this.appc, this.appd);
            } else {
                appa.appa.appf.appd.appe("DeepLinkHelper", "二次普通唤醒，延迟100ms获取唤起结果，唤醒失败");
                appi.appb(false, this.appc, this.appd);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: DeepLinkHelper.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public interface apph {
        void appa();

        void appb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void appb(Context context, String str, ApiBean apiBean, int i10, apph apphVar) {
        try {
            appd = false;
            if (appe) {
                appa.appa.appf.appd.appa("DeepLinkHelper", "首次静默唤起");
                Intent appb2 = appb(str);
                Intent intent = new Intent(context, (Class<?>) TransActivity.class);
                intent.putExtra("source_from", 1);
                intent.putExtra("target_intent", appb2);
                context.startActivity(intent);
            } else {
                try {
                    appa.appa.appf.appd.appa("DeepLinkHelper", "首次普通唤起");
                    context.startActivity(appb(str));
                    appd = true;
                } catch (Throwable th) {
                    appa.appa.appf.appd.appe("DeepLinkHelper", "首次普通唤醒失败：" + ((Object) th));
                    com.wangmai.ad.dex.allmodules.utils.appf.appa(context, "", "首次普通唤醒失败：" + th.getMessage());
                    appd = false;
                }
            }
            appa(apphVar, appe, true, (String) null, (List<String>) null);
        } catch (Throwable th2) {
            appa.appa.appf.appd.appa("DeepLinkHelper", "首次唤醒失败(doInvokedDeepLink)：" + ((Object) th2));
            com.wangmai.ad.dex.allmodules.utils.appf.appa(context, "", "首次唤醒失败(doInvokedDeepLink)：" + th2.getMessage());
            if (apphVar != null) {
                apphVar.appa();
            }
        }
        appa(context, str, apiBean, i10, appe);
        appa(context, apiBean);
    }

    public static void appc(Context context, String str, ApiBean apiBean, int i10, apph apphVar) {
        try {
            appa.appa.appf.appd.appa("DeepLinkHelper", "open deepLink", Thread.currentThread().getName(), context);
            appa.appa.appf.appd.appa("DeepLinkHelper", "dp=" + str);
            if (context != null && !TextUtils.isEmpty(str)) {
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    appb(context, str, apiBean, i10, apphVar);
                    return;
                } else {
                    ThreadUtils.runOnUIThread(new appa(context, str, apiBean, i10, apphVar));
                    return;
                }
            }
            appa.appa.appf.appd.appe("DeepLinkHelper", "dp调起失败，context or deepLink is null");
            com.wangmai.ad.dex.allmodules.utils.appf.appa(context, "", "dp调起失败，context or deepLink is null");
            if (apphVar != null) {
                apphVar.appa();
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("DeepLinkHelper", "DP唤醒失败(openDeepLink)：" + ((Object) th));
            com.wangmai.ad.dex.allmodules.utils.appf.appa(context, "", "DP唤醒失败(openDeepLink)：" + th.getMessage());
            if (apphVar != null) {
                apphVar.appa();
            }
        }
    }

    private static void appa(Context context, String str, ApiBean apiBean, int i10, boolean z10) {
        try {
            String sdk_track_url = apiBean.getRespObj().getWxad().getSdk_track_url();
            List<String> sdk_track_event_type = apiBean.getRespObj().getWxad().getSdk_track_event_type();
            if (i10 > 0) {
                ThreadUtils.mMainHandler.postDelayed(new appb(context, i10, str, sdk_track_url, sdk_track_event_type, z10), i10);
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("DeepLinkHelper", "retryOpenByDeepLink error：" + th);
        }
    }

    public static void appa(Context context, String str, String str2, List<String> list, boolean z10) {
        try {
            appd = false;
            if (z10) {
                appa.appa.appf.appd.appe("DeepLinkHelper", "二次静默唤醒");
                Intent appb2 = appb(str);
                Intent intent = new Intent(context, (Class<?>) TransActivity.class);
                intent.putExtra("source_from", 1);
                intent.putExtra("target_intent", appb2);
                context.startActivity(intent);
            } else {
                try {
                    appa.appa.appf.appd.appa("DeepLinkHelper", "二次普通唤醒");
                    context.startActivity(appb(str));
                    appd = true;
                } catch (Throwable th) {
                    appa.appa.appf.appd.appe("DeepLinkHelper", "二次普通唤醒失败：" + th);
                    appd = false;
                }
            }
            appa((apph) null, z10, false, str2, list);
        } catch (Throwable th2) {
            appa.appa.appf.appd.appe("DeepLinkHelper", "二次唤醒失败(doRetryInvokeDeepLink)：" + th2);
            appb(false, str2, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void appb(boolean z10, String str, List<String> list) {
        String replaceAll;
        try {
            if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
                return;
            }
            if (z10 && list.contains(Utils.TRACK_EVENT_TYPE_DP_RETRY_SUCCESS)) {
                replaceAll = str.replaceAll(Utils.replaceEventType, Utils.TRACK_EVENT_TYPE_DP_RETRY_SUCCESS);
            } else if (!list.contains(Utils.TRACK_EVENT_TYPE_DP_RETRY_FAILED)) {
                return;
            } else {
                replaceAll = str.replaceAll(Utils.replaceEventType, Utils.TRACK_EVENT_TYPE_DP_RETRY_FAILED);
            }
            OkHttp.get(replaceAll).execute(new appd());
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("DeepLinkHelper", "reportRetryOpenByDeeplinkResult error:" + th);
        }
    }

    static void appa(Context context, ApiBean apiBean) {
        try {
            String sdk_track_url = apiBean.getRespObj().getWxad().getSdk_track_url();
            List<String> sdk_track_event_type = apiBean.getRespObj().getWxad().getSdk_track_event_type();
            long sdk_dp_app_state_total_time = apiBean.getRespObj().getWxad().getSdk_dp_app_state_total_time();
            if (TextUtils.isEmpty(sdk_track_url) || sdk_track_event_type == null || sdk_track_event_type.isEmpty() || sdk_dp_app_state_total_time < 1000) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            HandlerUtil.getInstance().removeMessage();
            appa();
            HandlerUtil.getInstance().sendMessage(1000L, new appc(currentTimeMillis, sdk_dp_app_state_total_time, context, sdk_track_url));
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("DeepLinkHelper", "startAppTrackMonitoring error：" + th);
        }
    }

    public static Intent appb(String str) {
        Uri parse = Uri.parse(str);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        if (str.startsWith("tbopen://")) {
            appa.appa.appf.appd.appa("DeepLinkHelper", "【淘宝拉活】");
            intent.setFlags(805339136);
        } else {
            intent.setFlags(268468224);
        }
        intent.setData(parse);
        return intent;
    }

    static void appa() {
        f46845appa = false;
        appb = false;
        appc = 0;
    }

    static void appa(String str) {
        try {
            OkHttp.get(str).execute(new appe());
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("DeepLinkHelper", "executeTrackReport error:" + th);
        }
    }

    private static void appa(apph apphVar, boolean z10, boolean z11, String str, List<String> list) {
        if (z10) {
            appa.appa.appf.appd.appa("DeepLinkHelper", "静默唤醒，订阅观察者接收唤起结果通知");
            MessageEvent.attachObserver(new appf(z11, apphVar, str, list));
        } else {
            appa.appa.appf.appd.appa("DeepLinkHelper", "普通唤醒，延迟100ms获取唤起结果");
            ThreadUtils.mMainHandler.postDelayed(new appg(z11, apphVar, str, list), 100L);
        }
    }
}
