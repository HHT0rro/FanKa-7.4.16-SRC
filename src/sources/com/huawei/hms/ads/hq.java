package com.huawei.hms.ads;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.huawei.openalliance.ad.activity.PPSNotificationActivity;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class hq extends hv {
    private static final int C = 1;
    private static final String I = "AppInstalledNotification";
    private AdContentData B;
    private int S;
    private com.huawei.openalliance.ad.inter.data.AppInfo Z;

    public hq(Context context, AdContentData adContentData, String str) {
        super(context);
        com.huawei.openalliance.ad.inter.data.AppInfo appInfo;
        this.B = adContentData;
        this.Z = adContentData.u();
        if (TextUtils.isEmpty(str) || (appInfo = this.Z) == null) {
            return;
        }
        appInfo.V(str);
    }

    private PendingIntent Code(String str) {
        if (!F()) {
            return null;
        }
        Intent intent = new Intent();
        intent.setAction(str);
        intent.setPackage(this.Code.getPackageName());
        intent.putExtra("type", 1);
        intent.putExtra("appInfo", this.Z);
        intent.putExtra(hs.I, this.S);
        intent.putExtra("contentRecord", this.B);
        return PendingIntent.getBroadcast(this.Code, Code(), intent, 201326592);
    }

    private boolean D() {
        com.huawei.openalliance.ad.inter.data.AppInfo appInfo = this.Z;
        return (appInfo == null || appInfo.l() != 1 || TextUtils.isEmpty(this.Z.m())) ? false : true;
    }

    private boolean F() {
        com.huawei.openalliance.ad.inter.data.AppInfo appInfo = this.Z;
        return (appInfo == null || TextUtils.isEmpty(appInfo.Code())) ? false : true;
    }

    private PendingIntent V(String str) {
        if (!F()) {
            return null;
        }
        Intent intent = new Intent(this.Code, (Class<?>) PPSNotificationActivity.class);
        intent.setAction(str);
        intent.putExtra("type", 1);
        intent.putExtra("appInfo", this.Z);
        intent.putExtra(hs.I, this.S);
        intent.putExtra("contentRecord", this.B);
        return PendingIntent.getActivity(this.Code, Code(), intent, 201326592);
    }

    private void V(Notification.Builder builder) {
        Context context;
        ApplicationInfo applicationInfo;
        Drawable loadIcon;
        if (!F() || (context = this.Code) == null || (applicationInfo = com.huawei.openalliance.ad.utils.e.V(context, this.Z.Code()).applicationInfo) == null || (loadIcon = applicationInfo.loadIcon(this.Code.getPackageManager())) == null) {
            return;
        }
        builder.setLargeIcon(com.huawei.openalliance.ad.utils.y.Code(loadIcon));
    }

    @Override // com.huawei.hms.ads.hv
    public String B() {
        return I;
    }

    @Override // com.huawei.hms.ads.hv
    public String C() {
        com.huawei.openalliance.ad.inter.data.AppInfo appInfo = this.Z;
        return appInfo != null ? com.huawei.openalliance.ad.utils.au.V(appInfo.m()) : "";
    }

    @Override // com.huawei.hms.ads.hv
    public int Code() {
        if (F()) {
            return this.Z.Code().hashCode();
        }
        return 1;
    }

    public void Code(int i10) {
        this.S = i10;
    }

    @Override // com.huawei.hms.ads.hv
    public void Code(Notification.Builder builder) {
        if (builder == null || !F()) {
            return;
        }
        V(builder);
        builder.setDeleteIntent(Code(hx.V));
    }

    @Override // com.huawei.hms.ads.hv
    public void I() {
        if (D()) {
            hx.Code(this.Code).Code(this.Z.Code());
            super.I();
            if (this.B == null || !com.huawei.openalliance.ad.utils.ay.d(this.Code)) {
                return;
            }
            hu.I(this.Code, this.B);
        }
    }

    @Override // com.huawei.hms.ads.hv
    public PendingIntent S() {
        return V(hx.Code);
    }

    public int V() {
        return this.S;
    }

    @Override // com.huawei.hms.ads.hv
    public String Z() {
        com.huawei.openalliance.ad.inter.data.AppInfo appInfo = this.Z;
        return appInfo != null ? appInfo.L() : "";
    }
}
