package com.huawei.appgallery.agd.base.download;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.huawei.appgallery.agd.base.api.DownloadStatus;
import com.huawei.appgallery.agd.base.api.IAppStatusListener;
import com.huawei.appgallery.agd.common.application.ApplicationWrapper;
import com.huawei.openalliance.ad.download.app.d;
import com.huawei.secure.android.common.intent.SafeBroadcastReceiver;
import com.huawei.secure.android.common.intent.SafeIntent;
import j9.a;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class AppStatusReceiver extends SafeBroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public IAppStatusListener f27330a;

    /* renamed from: b, reason: collision with root package name */
    public volatile boolean f27331b = false;

    public AppStatusReceiver(IAppStatusListener iAppStatusListener) {
        this.f27330a = iAppStatusListener;
    }

    @Override // com.huawei.secure.android.common.intent.SafeBroadcastReceiver
    public void a(Context context, Intent intent) {
        SafeIntent safeIntent = new SafeIntent(intent);
        if (!"com.huawei.appmarket.broadcast.action.APP_STATUS".equals(safeIntent.getAction())) {
            a.f50348d.e("AppStatusReceiver", "onReceiveMsg: action invalid = [" + safeIntent.getAction() + "]");
            return;
        }
        String stringExtra = safeIntent.getStringExtra(d.f32416f);
        String stringExtra2 = safeIntent.getStringExtra("task.contentId");
        String stringExtra3 = safeIntent.getStringExtra("task.mediaPkg");
        int intExtra = safeIntent.getIntExtra("task.appType", 0);
        int intExtra2 = safeIntent.getIntExtra("task.appStatus", 0);
        int intExtra3 = safeIntent.getIntExtra("task.progress", 0);
        int intExtra4 = safeIntent.getIntExtra("task.status.reason", 0);
        a aVar = a.f50348d;
        aVar.i("AppStatusReceiver", String.format(Locale.ENGLISH, "onReceive| packageName:%s, contentId:%s, media:%s,appType:%d,appStatus:%d,progress:%d,reason:%d", stringExtra, stringExtra2, stringExtra3, Integer.valueOf(intExtra), Integer.valueOf(intExtra2), Integer.valueOf(intExtra3), Integer.valueOf(intExtra4)));
        if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra3)) {
            DownloadStatus downloadStatus = new DownloadStatus(stringExtra, intExtra, intExtra2, intExtra3);
            IAppStatusListener iAppStatusListener = this.f27330a;
            if (iAppStatusListener != null) {
                iAppStatusListener.onStatusChange(downloadStatus);
                return;
            } else {
                aVar.e("AppStatusReceiver", "onReceive| listener null");
                return;
            }
        }
        aVar.e("AppStatusReceiver", "onReceive| wrong broadcast");
    }

    public void b() {
        Context context;
        a.f50348d.i("AppStatusReceiver", "registerReceiver");
        if (ApplicationWrapper.getInstance() == null || (context = ApplicationWrapper.getInstance().getContext()) == null || this.f27331b) {
            return;
        }
        this.f27331b = true;
        try {
            context.registerReceiver(this, new IntentFilter("com.huawei.appmarket.broadcast.action.APP_STATUS"), "com.huawei.appmarket.RECV_THIRD_COMMON_MSG", null);
        } catch (Exception e2) {
            a.f50348d.e("AppStatusReceiver", "registerReceiver:register download receiver fail: " + e2.getMessage());
        }
    }

    public void c() {
        Context context;
        a.f50348d.i("AppStatusReceiver", "unRegisterReceiver");
        if (ApplicationWrapper.getInstance() == null || (context = ApplicationWrapper.getInstance().getContext()) == null || !this.f27331b) {
            return;
        }
        this.f27331b = false;
        try {
            context.unregisterReceiver(this);
        } catch (Exception e2) {
            a.f50348d.e("AppStatusReceiver", "unRegisterReceiver fail: " + e2.getMessage());
        }
    }
}
