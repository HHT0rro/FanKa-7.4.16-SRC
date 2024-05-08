package com.huawei.appgallery.coreservice.internal.service.installhiapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import androidx.annotation.Nullable;
import com.huawei.appgallery.agd.common.grs.GrsConfigObtainer;
import com.huawei.appgallery.coreservice.R$string;
import com.huawei.appgallery.coreservice.api.ConnectConfig;
import com.huawei.appgallery.marketinstallerservice.api.FailResultParam;
import com.huawei.appgallery.marketinstallerservice.api.InstallCallback;
import com.huawei.appgallery.marketinstallerservice.api.InstallParamSpec;
import com.huawei.appgallery.marketinstallerservice.api.InstallerApi;
import com.huawei.appgallery.marketinstallerservice.api.MarketInfo;
import com.huawei.secure.android.common.intent.SafeIntent;
import w9.e;
import w9.j;
import w9.m;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class GuideInstallAppGallery extends Activity {

    /* renamed from: b, reason: collision with root package name */
    public AlertDialog f27576b = null;

    /* renamed from: c, reason: collision with root package name */
    public boolean f27577c;

    /* renamed from: d, reason: collision with root package name */
    public ConnectConfig f27578d;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements DialogInterface.OnKeyListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
            if (4 != i10 || keyEvent.getAction() != 1) {
                return false;
            }
            m.d("GuideInstallAppGallery", "use cancel download market by KEYCODE_BACK!");
            GuideInstallAppGallery.this.setResult(0);
            GuideInstallAppGallery.this.finish();
            return true;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            m.d("GuideInstallAppGallery", "use cancel download market by NegativeButton!");
            GuideInstallAppGallery.this.setResult(0);
            GuideInstallAppGallery.this.finish();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            String c4 = j.c(GuideInstallAppGallery.this, GrsConfigObtainer.URL_TYPE_STORE);
            InstallParamSpec installParamSpec = new InstallParamSpec();
            installParamSpec.setServerUrl(c4);
            installParamSpec.setSubsystem("agdsdk");
            installParamSpec.setFailResultPromptType(2);
            installParamSpec.setUpdate(GuideInstallAppGallery.this.f27577c);
            if (GuideInstallAppGallery.this.f27578d != null) {
                installParamSpec.setMarketPkg(GuideInstallAppGallery.this.f27578d.getConnectAppPkg());
            }
            GuideInstallAppGallery guideInstallAppGallery = GuideInstallAppGallery.this;
            InstallerApi.installMarket(guideInstallAppGallery, installParamSpec, new d());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class d implements InstallCallback {
        public d() {
        }

        @Override // com.huawei.appgallery.marketinstallerservice.api.InstallCallback
        public void onFailed(FailResultParam failResultParam) {
            if (failResultParam != null) {
                m.d("GuideInstallAppGallery", "can not download market: result:" + failResultParam.getResult() + ", reason:" + failResultParam.getReason() + ", responseCode:" + failResultParam.getResponseCode() + ", rtnCode:" + failResultParam.getRtnCode());
                GuideInstallAppGallery.this.setResult(0);
            }
            GuideInstallAppGallery.this.finish();
        }

        @Override // com.huawei.appgallery.marketinstallerservice.api.InstallCallback
        public void onSuccess(MarketInfo marketInfo) {
            m.d("GuideInstallAppGallery", "download market succeed!");
            GuideInstallAppGallery.this.setResult(-1);
            GuideInstallAppGallery.this.finish();
        }
    }

    public static PendingIntent a(Context context) {
        if (context == null) {
            return null;
        }
        String h10 = e.h(context);
        Intent intent = new Intent(context, (Class<?>) GuideInstallAppGallery.class);
        intent.putExtra("is_app_market_exist", !TextUtils.isEmpty(h10));
        return PendingIntent.getActivity(context, 90001, intent, Build.VERSION.SDK_INT >= 30 ? 1140850688 : 1073741824);
    }

    public static PendingIntent b(Context context, ConnectConfig connectConfig, String str) {
        if (context == null) {
            return null;
        }
        Intent intent = new Intent(context, (Class<?>) GuideInstallAppGallery.class);
        intent.putExtra("is_app_market_exist", !TextUtils.isEmpty(str));
        intent.putExtra("vendor_app_connect_config", connectConfig);
        return PendingIntent.getActivity(context, 90001, intent, Build.VERSION.SDK_INT >= 30 ? 1140850688 : 1073741824);
    }

    @Override // android.app.Activity
    public void finish() {
        try {
            super.finish();
            overridePendingTransition(0, 0);
        } catch (Exception e2) {
            m.c("GuideInstallAppGallery", "activity finish exception:" + e2.getMessage());
        }
    }

    @Override // android.app.Activity
    public Intent getIntent() {
        return new SafeIntent(super.getIntent());
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        m.d("GuideInstallAppGallery", "onCreate");
        SafeIntent safeIntent = new SafeIntent(getIntent());
        this.f27577c = safeIntent.getBooleanExtra("is_app_market_exist", false);
        this.f27578d = (ConnectConfig) safeIntent.getSerializableExtra("vendor_app_connect_config");
        boolean z10 = this.f27577c;
        int i10 = z10 ? R$string.coreservicesdk_guide_update_appmarket : R$string.coreservicesdk_guide_download_appmarket;
        int i11 = z10 ? R$string.agdsdk_update : R$string.agdsdk_download;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle((CharSequence) null);
        String string = getResources().getString(R$string.coreservicesdk_appmarket_name);
        ConnectConfig connectConfig = this.f27578d;
        if (connectConfig != null) {
            string = connectConfig.getInstallAppName();
        }
        builder.setMessage(getResources().getString(i10, string));
        builder.setPositiveButton(getResources().getText(i11), new c());
        builder.setNegativeButton(getResources().getText(R$string.agdsdk_cancel), new b());
        builder.setOnKeyListener(new a());
        AlertDialog create = builder.create();
        this.f27576b = create;
        create.setCanceledOnTouchOutside(false);
        if (isDestroyed() || isFinishing()) {
            return;
        }
        this.f27576b.show();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        AlertDialog alertDialog = this.f27576b;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        this.f27576b.dismiss();
    }
}
