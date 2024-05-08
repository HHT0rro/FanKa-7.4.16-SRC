package com.huawei.appgallery.agd.base.download;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.huawei.appgallery.agd.base.api.DownloadStatus;
import com.huawei.appgallery.agd.base.api.IAppStatusListener;
import com.huawei.appgallery.agd.common.application.ApplicationWrapper;
import com.huawei.secure.android.common.intent.SafeBroadcastReceiver;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.secure.android.common.util.SafeString;
import j9.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class PackageReceiver extends SafeBroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f27332a = false;

    /* renamed from: b, reason: collision with root package name */
    public IAppStatusListener f27333b;

    public PackageReceiver(IAppStatusListener iAppStatusListener) {
        this.f27333b = iAppStatusListener;
    }

    @Override // com.huawei.secure.android.common.intent.SafeBroadcastReceiver
    public void a(Context context, Intent intent) {
        SafeIntent safeIntent = new SafeIntent(intent);
        String substring = (safeIntent.getDataString() == null || safeIntent.getDataString().length() < 9) ? "" : SafeString.substring(safeIntent.getDataString(), 8);
        String action = safeIntent.getAction();
        a.f50348d.i("PackageReceiver", "onReceive| action " + action + ", packageName " + substring);
        if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
            this.f27333b.onStatusChange(new DownloadStatus(substring));
        }
    }

    public void b() {
        if (this.f27332a) {
            return;
        }
        this.f27332a = true;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addDataScheme("package");
        try {
            ApplicationWrapper.getInstance().getContext().registerReceiver(this, intentFilter);
        } catch (Exception e2) {
            a.f50348d.e("PackageReceiver", "register package receiver fail: " + e2.getMessage());
        }
    }

    public void c() {
        if (this.f27332a) {
            this.f27332a = false;
            try {
                ApplicationWrapper.getInstance().getContext().unregisterReceiver(this);
            } catch (Exception e2) {
                a.f50348d.e("PackageReceiver", "unregister package receiver fail: " + e2.getMessage());
            }
        }
    }
}
