package com.huawei.hms.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.ForegroundBusResponseMgr;
import com.huawei.hms.activity.internal.ForegroundInnerHeader;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.support.api.entity.core.CoreNaming;
import com.huawei.hms.utils.Util;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class ForegroundIntentBuilder {

    /* renamed from: a, reason: collision with root package name */
    private Activity f28937a;

    /* renamed from: b, reason: collision with root package name */
    private RequestHeader f28938b;

    /* renamed from: c, reason: collision with root package name */
    private String f28939c;

    /* renamed from: d, reason: collision with root package name */
    private ForegroundInnerHeader f28940d;

    /* renamed from: e, reason: collision with root package name */
    private String f28941e;

    /* renamed from: f, reason: collision with root package name */
    private Context f28942f;

    public ForegroundIntentBuilder(Activity activity) throws IllegalArgumentException {
        if (activity != null) {
            this.f28937a = activity;
            RequestHeader requestHeader = new RequestHeader();
            this.f28938b = requestHeader;
            requestHeader.setSdkVersion(61100302);
            this.f28939c = "";
            ForegroundInnerHeader foregroundInnerHeader = new ForegroundInnerHeader();
            this.f28940d = foregroundInnerHeader;
            foregroundInnerHeader.setApkVersion(30000000);
            return;
        }
        throw new IllegalArgumentException("listener must not be null.");
    }

    public static void registerResponseCallback(String str, BusResponseCallback busResponseCallback) {
        ForegroundBusResponseMgr.getInstance().registerObserver(str, busResponseCallback);
    }

    public static void unregisterResponseCallback(String str) {
        ForegroundBusResponseMgr.getInstance().unRegisterObserver(str);
    }

    public Intent build() {
        String packageName;
        String appId;
        Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(this.f28937a, ForegroundBusDelegate.class.getName());
        Context context = this.f28942f;
        if (context != null) {
            packageName = context.getPackageName();
            appId = Util.getAppId(this.f28942f);
        } else {
            packageName = this.f28937a.getPackageName();
            appId = Util.getAppId(this.f28937a);
        }
        if (this.f28938b.getAppID() == null) {
            this.f28938b.setAppID(appId + "|");
        } else {
            this.f28938b.setAppID(appId + "|" + this.f28938b.getAppID());
        }
        if (TextUtils.isEmpty(this.f28938b.getTransactionId())) {
            RequestHeader requestHeader = this.f28938b;
            requestHeader.setTransactionId(TransactionIdCreater.getId(requestHeader.getAppID(), CoreNaming.HUBREQUEST));
        }
        this.f28938b.setPkgName(packageName);
        intentStartBridgeActivity.putExtra(ForegroundBusDelegate.HMS_FOREGROUND_REQ_HEADER, this.f28938b.toJson());
        intentStartBridgeActivity.putExtra(ForegroundBusDelegate.HMS_FOREGROUND_REQ_BODY, this.f28939c);
        intentStartBridgeActivity.putExtra(ForegroundBusDelegate.HMS_FOREGROUND_REQ_INNER, this.f28940d.toJson());
        if (!TextUtils.isEmpty(this.f28941e)) {
            intentStartBridgeActivity.putExtra(ForegroundBusDelegate.INNER_PKG_NAME, this.f28941e);
        }
        return intentStartBridgeActivity;
    }

    public ForegroundIntentBuilder setAction(String str) {
        this.f28938b.setApiName(str);
        return this;
    }

    public ForegroundIntentBuilder setApiLevel(int i10) {
        this.f28938b.setApiLevel(i10);
        return this;
    }

    public ForegroundIntentBuilder setApplicationContext(Context context) {
        this.f28942f = context;
        return this;
    }

    public ForegroundIntentBuilder setInnerHms() {
        this.f28941e = this.f28937a.getPackageName();
        return this;
    }

    public ForegroundIntentBuilder setKitSdkVersion(int i10) {
        this.f28938b.setKitSdkVersion(i10);
        return this;
    }

    public ForegroundIntentBuilder setMinApkVersion(int i10) {
        this.f28940d.setApkVersion(i10);
        return this;
    }

    public ForegroundIntentBuilder setRequestBody(String str) {
        this.f28939c = str;
        return this;
    }

    public ForegroundIntentBuilder setResponseCallback(String str, BusResponseCallback busResponseCallback) {
        this.f28940d.setResponseCallbackKey(str);
        ForegroundBusResponseMgr.getInstance().registerObserver(str, busResponseCallback);
        return this;
    }

    public ForegroundIntentBuilder setServiceName(String str) {
        this.f28938b.setSrvName(str);
        return this;
    }

    public ForegroundIntentBuilder setSubAppId(String str) {
        this.f28938b.setAppID(str);
        return this;
    }

    public ForegroundIntentBuilder setTransactionId(String str) {
        this.f28938b.setTransactionId(str);
        return this;
    }

    public ForegroundIntentBuilder setResponseCallback(String str) {
        this.f28940d.setResponseCallbackKey(str);
        return this;
    }
}
