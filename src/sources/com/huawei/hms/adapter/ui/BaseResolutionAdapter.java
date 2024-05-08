package com.huawei.hms.adapter.ui;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.sysobs.ApkResolutionFailedManager;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.kpms.KpmsConstant;
import com.huawei.hms.utils.IntentUtil;
import com.huawei.hms.utils.RegionUtils;
import com.huawei.hms.utils.ResolutionFlagUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class BaseResolutionAdapter implements IBridgeActivityDelegate {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<Activity> f29002a;

    /* renamed from: b, reason: collision with root package name */
    private String f29003b = "";

    /* renamed from: c, reason: collision with root package name */
    private long f29004c = 0;

    private void a(long j10) {
        if (!RegionUtils.isChinaROM(c())) {
            HMSLog.i("BaseResolutionAdapter", "not ChinaROM");
            return;
        }
        Activity c4 = c();
        if (c4 == null || c4.isFinishing()) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("package", c4.getPackageName());
        hashMap.put(CommonCode.MapKey.RESOLUTION_FLAG, this.f29004c + "-" + j10);
        HiAnalyticsUtils.getInstance().onEvent(c4, HiAnalyticsConstant.HMS_SDK_BASE_START_RESOLUTION, hashMap);
        HMSLog.e("BaseResolutionAdapter", "check resolution flag failed, transactionId: " + this.f29003b + ", carriedTimeStamp: " + this.f29004c + ", savedTimeStamp: " + j10);
    }

    private void b() {
        Activity c4 = c();
        if (c4 == null || c4.isFinishing()) {
            return;
        }
        c4.finish();
    }

    private Activity c() {
        WeakReference<Activity> weakReference = this.f29002a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private void d() {
        SystemManager.getInstance().notifyResolutionResult(null, this.f29003b);
        b();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 1001;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        if (activity == null) {
            HMSLog.e("BaseResolutionAdapter", "activity is null");
            d();
            return;
        }
        if (activity.isFinishing()) {
            HMSLog.e("BaseResolutionAdapter", "activity is finishing");
            return;
        }
        this.f29002a = new WeakReference<>(activity);
        Intent intent = activity.getIntent();
        if (intent == null) {
            d();
            return;
        }
        Bundle bundle = null;
        try {
            bundle = intent.getExtras();
            this.f29003b = intent.getStringExtra(CommonCode.MapKey.TRANSACTION_ID);
            this.f29004c = intent.getLongExtra(CommonCode.MapKey.RESOLUTION_FLAG, 0L);
        } catch (Throwable th) {
            HMSLog.e("BaseResolutionAdapter", "get transaction_id or resolution_flag exception:" + th.getClass().getSimpleName());
        }
        if (!a()) {
            d();
            return;
        }
        if (this.f29003b != null && Build.VERSION.SDK_INT >= 29) {
            HMSLog.i("BaseResolutionAdapter", "remove apk resolution failed task.");
            ApkResolutionFailedManager.getInstance().removeTask(this.f29003b);
        }
        if (bundle == null) {
            d();
            return;
        }
        Parcelable parcelable = bundle.getParcelable("resolution");
        if (parcelable == null) {
            d();
            return;
        }
        if (parcelable instanceof Intent) {
            try {
                activity.startActivityForResult(IntentUtil.modifyIntentBehaviorsSafe((Intent) parcelable), 1001);
                return;
            } catch (Throwable unused) {
                d();
                HMSLog.e("BaseResolutionAdapter", "ActivityNotFoundException:exception");
                return;
            }
        }
        if (parcelable instanceof PendingIntent) {
            try {
                activity.startIntentSenderForResult(((PendingIntent) parcelable).getIntentSender(), 1001, null, 0, 0, 0);
            } catch (IntentSender.SendIntentException unused2) {
                d();
                HMSLog.e("BaseResolutionAdapter", "SendIntentException:exception");
            }
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        HMSLog.i("BaseResolutionAdapter", "onBridgeActivityDestroy");
        this.f29002a = null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i10, int i11, Intent intent) {
        if (i10 != getRequestCode()) {
            return false;
        }
        HMSLog.i("BaseResolutionAdapter", "onBridgeActivityResult, resultCode: " + i11);
        if (i11 == 1001 || i11 == 1002) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.putExtra(CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT, i11);
        }
        if (i11 != -1 && !intent.hasExtra(KpmsConstant.KIT_UPDATE_RESULT) && !intent.hasExtra(CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT)) {
            SystemManager.getInstance().notifyResolutionResult(null, this.f29003b);
        } else {
            SystemManager.getInstance().notifyResolutionResult(intent, this.f29003b);
        }
        b();
        return true;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        HMSLog.i("BaseResolutionAdapter", "onBridgeConfigurationChanged");
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i10, KeyEvent keyEvent) {
        HMSLog.i("BaseResolutionAdapter", "On key up when resolve conn error");
    }

    private boolean a() {
        long resolutionFlag = ResolutionFlagUtil.getInstance().getResolutionFlag(this.f29003b);
        ResolutionFlagUtil.getInstance().removeResolutionFlag(this.f29003b);
        if (resolutionFlag != 0 && resolutionFlag == this.f29004c) {
            return true;
        }
        a(resolutionFlag);
        return false;
    }
}
